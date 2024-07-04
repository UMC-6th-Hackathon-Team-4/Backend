package umc_haekathon_4.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import umc_haekathon_4.demo.domain.common.BaseEntity;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter @Setter
@Builder
@AllArgsConstructor
public class Image extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long id;

    private String imgName;
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memory_id")
    @JsonBackReference
    private Memory memory;

    private String body;

}
