package com.apple.shop;

import jakarta.persistence.*;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Setter
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String title;
    public Integer price;
}
