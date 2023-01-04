package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) //Order입장에서 Order 와 Member는 다대일 관계이다.
    @JoinColumn(name = "member_id") //fk 설정
    private Member member;

    //* 중요 * 양방향 관계에서는 연관관계에서의 주인을 정해줘야한다. -> fk에 가까운 테이블 : 주인
    @OneToMany(fetch = FetchType.LAZY)
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate; //주문시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status;// 주문상태
}
