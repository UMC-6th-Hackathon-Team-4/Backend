package umc_haekathon_4.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class Mission {
    @Id @GeneratedValue
    @Column(name = "mission_id")
    private Long id;

    private String body;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdDate;
}
