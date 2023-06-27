package kr.kyusung.locationsaver.controller;

import kr.kyusung.locationsaver.service.WeatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityController {
    private final WeatherService weatherService;

    @GetMapping
    public ResponseEntity<String> city(String lat, String lng) {
        log.info("lat: {}, lng: {}", lat, lng);
        return ResponseEntity.ok(weatherService.getCityName(lat, lng));
    }
}
