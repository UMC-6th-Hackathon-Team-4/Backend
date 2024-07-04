package umc_haekathon_4.demo.web.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc_haekathon_4.demo.domain.Image;
import umc_haekathon_4.demo.domain.TreasureBox;


import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class MemoryResponseDTO {

        private Long id;
        private String title;
        private String memo;
        private LocalDateTime createdDate;
        private List<Image> images;
        private TreasureBox treasureBox;
}
