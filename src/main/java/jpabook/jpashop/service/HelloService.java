package jpabook.jpashop.service;

import jpabook.jpashop.domain.Hello;
import jpabook.jpashop.repository.HelloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HelloService {
    private final HelloRepository helloRepository;

    @Transactional
    public void joinHello(Hello hello) {
        helloRepository.save(hello);
    }
}
