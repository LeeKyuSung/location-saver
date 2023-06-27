package kr.kyusung.locationsaver.dto;

import kr.kyusung.locationsaver.entity.Location;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class LocationReqDto {
    String name;
    String lat;
    String lng;
    String cityName;

    public Location toLocation() {
        return Location.builder()
                .name(name)
                .latitude(lat)
                .longitude(lng)
                .cityName(cityName)
                .build();
    }
}
