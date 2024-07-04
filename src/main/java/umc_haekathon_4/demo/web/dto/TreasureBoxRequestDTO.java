package umc_haekathon_4.demo.web.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TreasureBoxRequestDTO {
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateTreasureBoxDTO {
        private Long userId;
        private LocalDate deadline;
        private String status;
        private String title;
        private String body;
        private double latitude;
        private double longitude;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UpdateLocationDTO {
        private double latitude;
        private double longitude;
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
        private LocalDate newDeadline;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class initialLocationDTO {
        private double latitude;
        private double longitude;
    }
}
