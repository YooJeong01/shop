package com.apple.shop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(String username, String password, String displayName){
        var duplicateUsername = memberRepository.findByUsername(username);
        if (duplicateUsername.isPresent()){
            throw new RuntimeException("중복된 아이디입니다");
        }
        if (username.length() < 4 || password.length() < 4){
            throw new RuntimeException("길이를 4자 이상으로 작성해주세요");
        }

        Member member = new Member();
        member.setUsername(username);
        member.setPassword(passwordEncoder.encode(password));
        member.setDisplayName(displayName);
        memberRepository.save(member);
    }
}
