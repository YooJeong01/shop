package com.apple.shop.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // 못찾을수도 있기때문에 Optional을 사용함
    public Optional<Member> findByUsername(String username);
}
