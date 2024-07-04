package umc_haekathon_4.demo.web.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class TreasureBoxRequestDTO {
    @Getter
    @Setter
    public static class CreateTreasureBoxDto {
        private Long userId;
        private LocalDateTime deadline;
        private String status;
        private String title;
        private String location;
    }

    @Getter
    @Setter
    public static class LocationBasedUnlockDto {
        private String location;
    }

}
