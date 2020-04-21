package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    //findBy* 에서 * 를 보고 JPQL 이 자동으로 쿼리를 만들어준다.
    //select m from Member m where m.name = ?
    List<Member> findByName(String name);
}
