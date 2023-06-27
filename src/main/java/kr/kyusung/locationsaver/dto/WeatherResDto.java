package kr.kyusung.locationsaver.dto;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@ToString
public class WeatherResDto {

    public int cod;
    public String name;
    public int id;
    public int timezone;
    public Sys sys;
    public int dt;
    public Clouds clouds;
    public Wind wind;
    public int visibility;
    public Main main;
    public String base;
    public List<Weather> weather;
    public Coord coord;

    @Getter
    @NoArgsConstructor
    @ToString
    public static class Sys {
        public int sunset;
        public int sunrise;
        public String country;
    }

    @Getter
    @NoArgsConstructor
    @ToString
    public static class Clouds {
        public int all;
    }

    @Getter
    @NoArgsConstructor
    @ToString
    public static class Wind {
        public double gust;
        public int deg;
        public double speed;
    }

    @Getter
    @NoArgsConstructor
    @ToString
    public static class Main {
        public int grnd_level;
        public int sea_level;
        public int humidity;
        public int pressure;
        public double temp_max;
        public double temp_min;
        public double feels_like;
        public double temp;
    }

    @Getter
    @NoArgsConstructor
    @ToString
    public static class Weather {
        public String icon;
        public String description;
        public String main;
        public int id;
    }

    @Getter
    @NoArgsConstructor
    @ToString
    public static class Coord {
        public int lat;
        public int lon;
    }
}

