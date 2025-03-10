package com.apple.shop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    // 페이지가 보이려면 항상 GetMapping 해줘야한다.. 잊지않기
    @GetMapping("/register")
    String register(){
        return "register.html";
    }

    @PostMapping("/member")
    ResponseEntity<String> registerUser(String username, String password, String displayName){
        memberService.registerUser(username, password, displayName);
        return ResponseEntity.status(200).body("가입완료");
    }

    @GetMapping("/login")
    public String login(){
        return "login.html";
    }
}
