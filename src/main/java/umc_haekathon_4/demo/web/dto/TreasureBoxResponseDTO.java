package umc_haekathon_4.demo.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TreasureBoxResponseDTO {
    private Long id;
    private Long userId;
    private LocalDateTime createdAt;
    private LocalDateTime deadline;
    private String status;
    private String title;
    private String body;
    private String location;
}
