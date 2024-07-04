package umc_haekathon_4.demo.domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class Image {
    @Id @GeneratedValue
    @Column(name = "image_id")
    private Long id;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdDate;

    private String imgName;
    private String imgpath;

    @ManyToOne
    @JoinColumn(name = "memory_id")
    private Memory memory;

}
