package umc_haekathon_4.demo.domain;

import jakarta.persistence.*;
import lombok.*;
import umc_haekathon_4.demo.domain.common.BaseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Memory extends BaseEntity {
    @Id @GeneratedValue
    @Column(name="memory_id")
    private Long id;

    private String title;

    private String memo;

    @Column(name = "created_at")
    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "memory", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Image> images=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "treasure_box_id", nullable = false)
    private TreasureBox treasureBox;
}
