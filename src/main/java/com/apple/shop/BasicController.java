package com.apple.shop;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;

@Controller
public class BasicController {
    @GetMapping("/")
    String hello(){
        return "index.html";
    }

    @GetMapping("/about")
    @ResponseBody
    String about(){
        return "소개글입니다";
    }

    @GetMapping("/date")
    @ResponseBody
    String date(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String nowStr = format.format(now);
        //return nowStr;
        return ZonedDateTime.now().toString();
    }
}
