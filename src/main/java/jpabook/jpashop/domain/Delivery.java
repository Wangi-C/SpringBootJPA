package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery") // 연관과계에서의 거울.
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) //EnumType.ORDINAL -> default값 : status가 하나 추가되면 기존 2 위치에 있던 status가 3으로 밀리면서 2로 조회했을때 다른 데이터가 조회될 수 있다.
    private DeliveryStatus status; // Ready, xxx, comp
}
