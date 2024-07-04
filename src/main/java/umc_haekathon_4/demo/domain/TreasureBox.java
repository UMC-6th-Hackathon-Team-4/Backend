package umc_haekathon_4.demo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class TreasureBox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "treasure_box_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "treasure_box", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Memory> memories=new ArrayList<>();

    @OneToMany(mappedBy = "treasure_box", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mission> missions=new ArrayList<>();

    private LocalDateTime createdAt;
    private LocalDateTime deadline;
    private String status;
    private String title;
    private String location;
}
