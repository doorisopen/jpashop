package jpabook.jpashop.repository;


import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
            // Entity를 찾아주는 역할 DAO라고 생각하면된다.
@Repository // component scan의 대상으로 스프링 빈으로 등록 된다.
@RequiredArgsConstructor
public class MemberRepositoryOld {

    //@PersistenceContext
    private final EntityManager em;

    // 커맨드와 쿼리를 분리해라!!
    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
