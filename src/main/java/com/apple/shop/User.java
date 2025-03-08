package com.apple.shop;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class User {
    private Integer age;
    private String name;

    public void setAge(Integer a) {
        if (-1 < a && a < 101) {
            this.age = a;
        }
    }

    public void setAgeAdd() {
        this.age = this.age + 1;
    }

    public Integer getAge() {
        return age;
    }
}
