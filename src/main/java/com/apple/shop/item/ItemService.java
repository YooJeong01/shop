package com.apple.shop.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public void saveItem(String title,Integer price){
        Item item = new Item();
        if (title.length()>100){
            throw new RuntimeException("100자 이하의 상품명을 입력해주세요");
        } else {
            item.title = title;
        }
        if (price < 0) {
            throw new RuntimeException("음수가 아닌 가격을 입력해주세요");
        } else {
            item.price = price;
        }

        itemRepository.save(item);
    }

    public void editItem(String title, Integer price, Long id){
        Item item = new Item();
        item.setId(id);
        if (title.length()>100){
            throw new RuntimeException("100자 이하의 상품명을 입력해주세요");
        } else {
            item.setTitle(title);
        }
        if (price < 0) {
            throw new RuntimeException("음수가 아닌 가격을 입력해주세요");
        } else {
            item.setPrice(price);
        }
        itemRepository.save(item);
    }

    public List<Item> findItem(){
        List<Item> result = itemRepository.findAll();
        return result;
    }

    public Optional<Item> getDetail(@PathVariable Long id){
        Optional<Item> result = itemRepository.findById(id); // id가 1과 일치하는 결과를 찾아서 리턴함
        return result;
    }
}
