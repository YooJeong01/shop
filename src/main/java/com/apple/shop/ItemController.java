package com.apple.shop;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemRepository itemRepository;

    @GetMapping("/list")
    String list(Model model){
        List<Item> result = itemRepository.findAll();
        model.addAttribute("items",result);
        return "list.html";
    }

    @GetMapping("/write")
    String write(){
        return "write.html";
    }

    @PostMapping("/add")
    String addPost(@RequestParam String title,
                   @RequestParam Integer price){
        Item item = new Item();
        item.title = title;
        item.price = price;
        itemRepository.save(item);
        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    String detail(Model model, @PathVariable Long id){
            Optional<Item> result = itemRepository.findById(id); // id가 1과 일치하는 결과를 찾아서 리턴함
            if (result.isPresent()){
                model.addAttribute("details",result.get());
                System.out.println(result.get());
                return "detail.html";
            } else {
                return "error";
            }
    }
}
