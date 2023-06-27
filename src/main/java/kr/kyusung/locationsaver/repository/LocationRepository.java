package kr.kyusung.locationsaver.repository;

import kr.kyusung.locationsaver.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {

}
