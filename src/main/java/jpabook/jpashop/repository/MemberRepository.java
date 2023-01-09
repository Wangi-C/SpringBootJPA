package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    //@PersistenceContext //jpa EntityManager를 만들어서 Entity를 넣어줌.
    //@Autowired 는 안됌. @PersistenceContext or @RequiredArgsConstructor사용.
    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        //createQuery(jpql, .class)
        List<Member> result = em.createQuery("select m from Member m", Member.class)
                .getResultList();

        return result;
    }

    public List<Member> findByName(String name) {

        // 이름으로 회원을 조회.
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
