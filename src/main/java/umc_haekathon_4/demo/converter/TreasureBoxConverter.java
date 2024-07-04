package umc_haekathon_4.demo.converter;

import umc_haekathon_4.demo.domain.TreasureBox;
import umc_haekathon_4.demo.domain.User;
import umc_haekathon_4.demo.web.dto.TreasureBoxRequestDTO;
import umc_haekathon_4.demo.web.dto.TreasureBoxResponseDTO;

import java.time.LocalDateTime;

public class TreasureBoxConverter {
    public static TreasureBox toEntity(TreasureBoxRequestDTO.CreateTreasureBoxDTO createTreasureboxDTO, User user) {
        TreasureBox treasureBox = new TreasureBox();
        treasureBox.setTitle(createTreasureboxDTO.getTitle());
        treasureBox.setBody(createTreasureboxDTO.getBody());
        treasureBox.setLatitude(createTreasureboxDTO.getLatitude());
        treasureBox.setLongitude(createTreasureboxDTO.getLongitude());
        treasureBox.setDeadline(createTreasureboxDTO.getDeadline());
        treasureBox.setUser(user);
        return treasureBox;
    }

    public static TreasureBoxResponseDTO toDTO(TreasureBox treasureBox) {
        return TreasureBoxResponseDTO.builder()
                .id(treasureBox.getId())
                .userId(treasureBox.getUser().getId())
                .createdAt(treasureBox.getCreatedAt())
                .deadline(treasureBox.getDeadline())
                .status(treasureBox.getStatus())
                .title(treasureBox.getTitle())
                .latitude(treasureBox.getLatitude())
                .longitude(treasureBox.getLongitude())
                .build();
    }
}
