package kr.kyusung.locationsaver.dto;

import kr.kyusung.locationsaver.entity.Location;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class LocationResDto {
    Long seqNo;
    String name;
    String lat;
    String lng;
    String cityName;

    public LocationResDto(Location location) {
        this.seqNo = location.getSeqNo();
        this.name = location.getName();
        this.lat = location.getLatitude();
        this.lng = location.getLongitude();
        this.cityName = location.getCityName();
    }
}
