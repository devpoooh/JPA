package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    EntityManager em;

    //저장
    public Long save(Member member) {
        em.persist(member);

        return member.getId();
    }

    //id로 멤버찾기
    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}
