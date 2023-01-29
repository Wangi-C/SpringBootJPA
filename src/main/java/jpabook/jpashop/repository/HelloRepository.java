package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Hello;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class HelloRepository {
    private final EntityManager em;

    public void save(Hello hello) {
        em.persist(hello);
    }
}
