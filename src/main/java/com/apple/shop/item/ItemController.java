package com.apple.shop.item;
import com.apple.shop.member.Member;
import com.apple.shop.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemRepository itemRepository;
    private final ItemService itemService;
    private final MemberRepository memberRepository;

    @GetMapping("/list")
    String list(Model model){
        // DB조작이라 service로 기능 이동함
        //List<Item> result = itemRepository.findAll();
        model.addAttribute("items",itemService.findItem());
        return "list.html";
    }



    @GetMapping("/write")
    String write(){
        return "write.html";
    }




    @PostMapping("/add")
    String addPost(String title, Integer price){
        itemService.saveItem(title, price);
        return "redirect:/list";
    }




    @GetMapping("/detail/{id}")
    String detail(Model model, @PathVariable Long id){
            // DB조작이라 service로 기능 이동함
            // Optional<Item> result = itemRepository.findById(id); // id가 1과 일치하는 결과를 찾아서 리턴함
            Optional<Item> result = itemService.getDetail(id);
            if (result.isPresent()){
                model.addAttribute("details",result.get());
                System.out.println(result.get());
                return "detail.html";
            } else {
                return "error";
            }
    }

    @GetMapping("/modify/{id}")
    String modify(Model model, @PathVariable Long id){
        Optional<Item> result = itemService.getDetail(id);
        if (result.isPresent()){
            model.addAttribute("items",result.get());
            System.out.println(result.get());
            return "modify.html";
        } else {
            return "error";
        }
    }

    @PostMapping("/modify")
    String editItem(String title, Integer price, Long id){
        itemService.editItem(title, price, id);
        return "redirect:/list";
    }

//    @PostMapping("/test1")
//    String test1(@RequestBody Map<String, Object> body){
//        System.out.println(body.get("name"));
//        return "redirect:/list";
//    }
//
//    @GetMapping("/test2")
//    String test2(@RequestParam String name) {
//        System.out.println(name);
//        return "redirect:/list";
//    }

    @DeleteMapping("/delete")
    ResponseEntity<String> delete(@RequestParam Long id) {
        itemRepository.deleteById(id);
        return ResponseEntity.status(200).body("삭제완료");
    }



}
