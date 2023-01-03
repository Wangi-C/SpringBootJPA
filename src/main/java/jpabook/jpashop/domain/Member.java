package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded //Address가 내장타입이다 라는 것을 알려준다.
    private Address address;

    @OneToMany(mappedBy = "member") //Member입장에서는 Order와 일대다 관계
    private List<Order> orders = new ArrayList<>();
}
