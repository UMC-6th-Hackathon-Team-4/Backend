package umc_haekathon_4.demo.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


public class ImageRequestDTO {

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class createImageDTO{
        private String imgName;
        private String imgpath;
        private Long memoryId;
    }

}