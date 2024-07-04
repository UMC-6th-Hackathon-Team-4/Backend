package umc_haekathon_4.demo.domain;

import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "treasure_box_id", nullable = false)
    private TeasureBox teasureBox;
}
