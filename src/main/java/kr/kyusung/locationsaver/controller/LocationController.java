package kr.kyusung.locationsaver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class LocationController {
    @GetMapping("/")
    public String index(@RequestParam(required = false) String name, Model model) {
        if (name == null) {
            name = "이름 없음";
        }
        model.addAttribute("name", name);
        return "index";
    }
}
