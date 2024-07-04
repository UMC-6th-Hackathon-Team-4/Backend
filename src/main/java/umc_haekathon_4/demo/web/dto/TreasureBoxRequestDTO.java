package umc_haekathon_4.demo.web.dto;

import lombok.*;

import java.time.LocalDateTime;

public class TreasureBoxRequestDTO {
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateTreasureBoxDTO {
        private Long userId;
        private LocalDateTime deadline;
        private String status;
        private String title;
        private String body;
        private String location;
    }

}
