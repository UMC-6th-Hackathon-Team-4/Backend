package umc_haekathon_4.demo.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ImageResponseDTO {
    private Long id;
    private LocalDateTime createdDate;
    private String imgName;
    private String imgpath;
    private Long memoryId;
}
