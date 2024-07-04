package umc_haekathon_4.demo.service;

import org.springframework.transaction.annotation.Transactional;
import umc_haekathon_4.demo.domain.Mission;
import umc_haekathon_4.demo.repository.MissionRepository;

public class MissionService {

    private MissionRepository missionRepository;

    @Transactional(readOnly = true)
    public Mission findMissionById(Long missionId) {
        return missionRepository.findById(missionId)
                .orElseThrow(()->new RuntimeException("Mission not found"));
    }
}
