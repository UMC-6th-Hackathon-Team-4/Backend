package umc_haekathon_4.demo.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class MemoryRequestDTO {

    @NoArgsConstructor
    @Builder
    @Getter
    @AllArgsConstructor
    public static class CreateMemoryDto{
        private String title;
        private String memo;
        private List<Long> imageIds;
        private Long treasureBoxId;
    }
}
