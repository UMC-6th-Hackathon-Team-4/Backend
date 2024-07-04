package umc_haekathon_4.demo.web.dto;

import lombok.Getter;
import lombok.Setter;

import umc_haekathon_4.demo.domain.TreasureBox;
import umc_haekathon_4.demo.domain.User;


import java.time.LocalDateTime;

public class TreasureBoxRequestDTO {
    @Getter
    @Setter
    public static class CreateTreasureBoxDTO {
        private Long userId;
        private LocalDateTime deadline;
        private String status;
        private String title;
        private String location;
    }

    @Getter
    @Setter
    public static class LocationBasedUnlockDTO {
        private String location;
    }
}
