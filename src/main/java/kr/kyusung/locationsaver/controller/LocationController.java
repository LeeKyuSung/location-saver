package kr.kyusung.locationsaver.controller;

import kr.kyusung.locationsaver.dto.LocationReqDto;
import kr.kyusung.locationsaver.dto.LocationResDto;
import kr.kyusung.locationsaver.service.LocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @PostMapping
    public ResponseEntity<LocationResDto> location(@RequestBody LocationReqDto locationReqDto) {
        log.info("locationReqDto: {}", locationReqDto);
        return ResponseEntity.ok(locationService.save(locationReqDto));
    }

    @GetMapping
    public ResponseEntity<List<LocationResDto>> location() {
        return ResponseEntity.ok(locationService.findAll());
    }

}
