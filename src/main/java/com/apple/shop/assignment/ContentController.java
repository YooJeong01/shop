package com.apple.shop.assignment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ContentController {
    private final ContentRepository contentRepository;

    @GetMapping("/content")
    String list(Model model){
        List<Content> result = contentRepository.findAll();
        model.addAttribute("contents",result);
        return "content.html";
    }
}
