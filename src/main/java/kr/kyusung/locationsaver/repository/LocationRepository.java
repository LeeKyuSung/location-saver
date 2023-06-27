package kr.kyusung.locationsaver.repository;

import kr.kyusung.locationsaver.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

    List<Location> findByOrderBySeqNoDesc();
}
