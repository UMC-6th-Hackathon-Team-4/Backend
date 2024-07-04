package umc_haekathon_4.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umc_haekathon_4.demo.converter.TreasureBoxConverter;
import umc_haekathon_4.demo.domain.TreasureBox;
import umc_haekathon_4.demo.domain.User;
import umc_haekathon_4.demo.repository.MissionRepository;
import umc_haekathon_4.demo.repository.TreasureBoxRepository;
import umc_haekathon_4.demo.repository.UserRepository;
import umc_haekathon_4.demo.web.dto.TreasureBoxRequestDTO;
import umc_haekathon_4.demo.web.dto.TreasureBoxResponseDTO;

@Service
@RequiredArgsConstructor
public class TreasureBoxService {
    private final TreasureBoxRepository treasureBoxRepository;
    private final UserRepository UserRepository;
    private final MissionRepository MissionRepository;

    public TreasureBox createTreasureBox(TreasureBoxRequestDTO.CreateTreasureBoxDTO request) {
        User user = UserRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        TreasureBox treasureBox = TreasureBoxConverter.toEntity(request,user);
        return treasureBoxRepository.save(treasureBox);
    }

    public TreasureBox getTreasureBox(Long TreasureBoxId) {
        return treasureBoxRepository.findById(TreasureBoxId)
                .orElseThrow(() -> new RuntimeException("TreasureBox not found"));
    }
}
