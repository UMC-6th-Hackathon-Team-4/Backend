package umc_haekathon_4.demo.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Image {
    @Id @GeneratedValue
    @Column(name = "image_id")
    private Long id;


    @Column(name = "created_at")
    private LocalDateTime createdDate;

    private String imgName;
    private String url;

    @ManyToOne
    @JoinColumn(name = "memory_id")
    private Memory memory;

}
