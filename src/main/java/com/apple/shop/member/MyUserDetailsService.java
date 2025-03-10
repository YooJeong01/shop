//package com.apple.shop.member;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class MyUserDetailsService implements UserDetailsService {
//    private final MemberRepository memberRepository; //Dependency Injection 패턴 사용
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        //DB에서 username을 가진 유저를 찾아서
//        //return new User(유저아이디, 비번, 권한)해주세요
//        return memberRepository.findByUsername(username);
//    }
//}
