package umc_haekathon_4.demo.domain;

import jakarta.persistence.*;
import lombok.*;
import umc_haekathon_4.demo.domain.common.BaseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TreasureBox extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "treasure_box_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "treasureBox", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Memory> memories=new ArrayList<>();

    @OneToMany(mappedBy = "treasureBox", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Mission> missions=new ArrayList<>();

    private LocalDateTime deadline;
    private String status;
    private String title;
    private String location;
    private  String body;
}
