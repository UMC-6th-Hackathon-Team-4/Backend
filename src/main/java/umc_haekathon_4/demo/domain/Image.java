package umc_haekathon_4.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import umc_haekathon_4.demo.domain.common.BaseEntity;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Image extends BaseEntity {
    @Id @GeneratedValue
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
