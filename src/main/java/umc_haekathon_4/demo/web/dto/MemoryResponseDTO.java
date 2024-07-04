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
@Getter
@Builder
public class MemoryResponseDTO {

        private Long memoryId;
        private LocalDateTime createdDate;
}
