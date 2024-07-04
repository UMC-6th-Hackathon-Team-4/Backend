package umc_haekathon_4.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc_haekathon_4.demo.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
