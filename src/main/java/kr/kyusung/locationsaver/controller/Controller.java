package kr.kyusung.locationsaver.controller;

import kr.kyusung.locationsaver.service.WeatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class Controller {
    private final WeatherService weatherService;

    @GetMapping("/")
    public String index(@RequestParam(required = false) String name, Model model) {
        if (name == null) {
            name = "이름 없음";
        }
        model.addAttribute("name", name);
        return "index";
    }

    @GetMapping("/city")
    @ResponseBody
    public ResponseEntity<String> city(String lat, String lng) {
        log.info("lat: {}, lng: {}", lat, lng);
        return ResponseEntity.ok(weatherService.getCityName(lat, lng));
    }
}
