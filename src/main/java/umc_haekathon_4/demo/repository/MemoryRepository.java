package umc_haekathon_4.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc_haekathon_4.demo.domain.Memory;

public interface MemoryRepository extends JpaRepository<Memory, Long> {
}
