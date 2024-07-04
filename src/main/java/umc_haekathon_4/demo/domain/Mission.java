package umc_haekathon_4.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Mission {
    @Id @GeneratedValue
    @Column(name = "mission_id")
    private Long id;

    private String body;

    @Column(name = "created_at")
    private LocalDateTime createdDate;

    @ManyToOne
    @JoinColumn(name = "treasure_box_id", nullable = false)
    private TreasureBox treasureBox;
}
