package jpabook.jpashop.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jpabook.jpashop.domain.Hello;
import jpabook.jpashop.domain.QHello;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class querydslTest {

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    public void contextLoads() {
        Hello hello = new Hello();
        // 에러 : org.hibernate.PersistentObjectException: detached entity passed to persist
        // Hello Entity의 @GeneratedValue의 default값이 auto이기 때문에 pk(@Id)로 지정한 값을 null로 해야한다.
//        hello.setId(1L);
        em.persist(hello);

        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);
        QHello qHello = new QHello("h");
        Hello result = jpaQueryFactory
                .selectFrom(qHello)
                .fetchOne();

        assertThat(result).isEqualTo(hello);
        assertThat(result.getId()).isEqualTo(hello.getId());
    }
}
