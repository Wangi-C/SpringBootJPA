package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    // implementation 'org.springframework.boot:spring-boot-starter-data-jpa' -> EntityManager 자동 주입.
    @PersistenceContext
    private EntityManager em;

    public Long save(Member member) {
         em.persist(member);
         return member.getId();
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}
