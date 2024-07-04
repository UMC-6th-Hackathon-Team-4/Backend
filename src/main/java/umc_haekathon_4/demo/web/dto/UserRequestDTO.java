package umc_haekathon_4.demo.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserRequestDTO {
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class UserDTO{
        private String userId;
        private Long treasureId;
    }
}
