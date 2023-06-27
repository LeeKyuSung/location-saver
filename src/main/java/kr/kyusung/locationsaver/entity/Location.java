package kr.kyusung.locationsaver.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long seqNo;

    String name;
    String latitude;
    String longitude;
    String cityName;

    @CreatedDate
    LocalDateTime createdDate;
}
