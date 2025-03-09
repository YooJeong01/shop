package com.apple.shop.assignment;
import jakarta.persistence.*;
import lombok.ToString;
@Entity
@ToString
public class Content {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String content;
    public String date;
}
