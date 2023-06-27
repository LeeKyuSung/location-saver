package kr.kyusung.locationsaver.service;

import kr.kyusung.locationsaver.dto.LocationReqDto;
import kr.kyusung.locationsaver.dto.LocationResDto;
import kr.kyusung.locationsaver.entity.Location;
import kr.kyusung.locationsaver.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationResDto save(LocationReqDto locationReqDto) {
        return new LocationResDto(
                locationRepository.save(
                        locationReqDto.toLocation()
                )
        );
    }

    public List<LocationResDto> findAll() {
        return locationRepository.findAll().stream()
                .map(LocationResDto::new)
                .toList();
    }
}
