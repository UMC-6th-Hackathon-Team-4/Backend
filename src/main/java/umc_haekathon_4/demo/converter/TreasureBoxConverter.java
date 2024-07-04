package umc_haekathon_4.demo.converter;

import umc_haekathon_4.demo.domain.TreasureBox;
import umc_haekathon_4.demo.domain.User;
import umc_haekathon_4.demo.web.dto.TreasureBoxRequestDTO;
import umc_haekathon_4.demo.web.dto.TreasureBoxResponseDTO;

import java.time.LocalDateTime;

public class TreasureBoxConverter {
    public static TreasureBox toEntity(TreasureBoxRequestDTO.CreateTreasureBoxDTO dto, User user) {
        return TreasureBox.builder()
                .user(user)
                .createdAt(LocalDateTime.now())
                .deadline(dto.getDeadline())
                .status(dto.getStatus())
                .title(dto.getTitle())
                .location(dto.getLocation())
                .build();
    }

    public static TreasureBoxResponseDTO.TreasureBoxDTO toDTO(TreasureBox treasureBox) {
        return TreasureBoxResponseDTO.TreasureBoxDTO.builder()
                .id(treasureBox.getId())
                .userId(treasureBox.getUser().getId())
                .createdAt(treasureBox.getCreatedAt())
                .deadline(treasureBox.getDeadline())
                .status(treasureBox.getStatus())
                .title(treasureBox.getTitle())
                .location(treasureBox.getLocation())
                .build();
    }
}
