package jpabook.jpashop.domain.team;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Team {

    @Id @GeneratedValue
    @Column(name = "team_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team")
    private List<TeamMember> memberList = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }
}
