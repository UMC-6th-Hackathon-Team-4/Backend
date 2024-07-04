package umc_haekathon_4.demo.domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Memory {
    @Id @GeneratedValue
    @Column(name="memory_id")
    private Long id;

    private String title;

    private String memo;

    @Column(name = "created_at")
    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "memory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "treasure_box_id", nullable = false)
    private TreasureBox treasureBox;
}
