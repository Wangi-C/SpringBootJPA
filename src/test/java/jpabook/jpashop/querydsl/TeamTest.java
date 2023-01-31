package jpabook.jpashop.querydsl;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jpabook.jpashop.domain.team.QTeamMember;
import jpabook.jpashop.domain.team.TeamMember;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeamTest {

    @Autowired
    EntityManager em;

    @Test
    public void startJPQL() {
        TeamMember findByJPQL = em.createQuery(
                        "select tm from TeamMember tm " +
                                "where tm.name = :name", TeamMember.class)
                .setParameter("name", "wangi")
                .getSingleResult();

        assertThat(findByJPQL.getName()).isEqualTo("wangi");
    }

    @Test
    public void startQuerydsl() {
        JPAQuery<TeamMember> query = new JPAQuery<>(em);
        QTeamMember qTeamMember = new QTeamMember("wangi");

        List<TeamMember> memberList
                = query.from(qTeamMember)
                        .fetch();

        assertThat(memberList.size()).isEqualTo(1);
    }
}
