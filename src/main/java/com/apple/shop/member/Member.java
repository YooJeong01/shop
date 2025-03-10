package com.apple.shop.member;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(unique = true) // 제약조건 걸 수있음
    public String username;
    public String password;
    public String displayName;
}
