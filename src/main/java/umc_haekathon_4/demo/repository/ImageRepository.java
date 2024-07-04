package umc_haekathon_4.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc_haekathon_4.demo.domain.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
