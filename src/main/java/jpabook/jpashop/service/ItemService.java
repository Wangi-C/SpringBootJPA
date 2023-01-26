package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Transactional
    public void updateItem(Long itemId, UpdateItemDto dto) {
        //transaction이 있는 서비스 계층에서 영속 상태의 엔티티를 조회하고 에닡티의 데이터를 직접 변경. -> dirty checking
        Item findItem = itemRepository.findOne(itemId);
        // findItem => 영속성 엔티티
        findItem.setPrice(dto.getPrice());
        findItem.setName(dto.getName());
        findItem.setStockQuantity(dto.getStockQuantity());
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
