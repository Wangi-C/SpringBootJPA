package jpabook.jpashop.domain.team;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class TeamMember {

    @Id @GeneratedValue
    @Column(name = "teamMember_id")
    private Long id;

    private String name;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;
}
