package kr.kyusung.locationsaver.service;

import kr.kyusung.locationsaver.dto.WeatherResDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Service
@RequiredArgsConstructor
public class WeatherService {
    private static final String WEATHER_BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
    @Value("${openweathermap.api.key}")
    private String weatherApiKey;

    private final RestTemplate restTemplate;

    public String getCityName(String lat, String lng) {
        UriComponents urlBuilder = UriComponentsBuilder.fromHttpUrl(WEATHER_BASE_URL)
                .queryParam("lat", lat)
                .queryParam("lon", lng)
                .queryParam("appid", weatherApiKey)
                .queryParam("units", "metric")
                .build(false);
        try {
            ResponseEntity<WeatherResDto> response = restTemplate.getForEntity(urlBuilder.toUriString(), WeatherResDto.class);
            log.info("response: {}", response);
            return response.getBody().getName();
        } catch (Exception e) {
            log.error("Error while getting weather data", e);
            return null;
        }
    }
}
