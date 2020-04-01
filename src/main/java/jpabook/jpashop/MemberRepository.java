package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository // Entity를 찾아주는 역할 DAO라고 생각하면된다.
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    // 커맨드와 쿼리를 분리해라!!
    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }
    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}
