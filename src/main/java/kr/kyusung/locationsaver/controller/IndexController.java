package kr.kyusung.locationsaver.controller;

import kr.kyusung.locationsaver.service.LocationService;
import kr.kyusung.locationsaver.service.WeatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequiredArgsConstructor
public class IndexController {
    private final WeatherService weatherService;
    private final LocationService locationService;

    @GetMapping("/")
    public String index(@RequestParam(required = false) String name, Model model) {
        if (name == null) {
            name = "이름 없음";
        }
        model.addAttribute("name", name);
        return "index";
    }
}
