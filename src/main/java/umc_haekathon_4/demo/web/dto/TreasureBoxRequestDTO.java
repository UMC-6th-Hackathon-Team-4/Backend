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

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UpdateLocationDTO {
        private String location;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UpdateStatusDTO {
        private String status;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UpdateDeadlineDTO {
        private LocalDateTime newDeadline;
    }
}
