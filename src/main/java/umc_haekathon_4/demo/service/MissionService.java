package umc_haekathon_4.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc_haekathon_4.demo.domain.Mission;
import umc_haekathon_4.demo.domain.TreasureBox;
import umc_haekathon_4.demo.repository.MissionRepository;

import java.util.Optional;

@Service
public class MissionService {

    private final MissionRepository missionRepository;

    @Autowired
    public MissionService(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }
/*
    @Transactional(readOnly = true)
    public Mission findMissionById(Long missionId) {
        return missionRepository.findById(missionId)
                .orElseThrow(() -> new RuntimeException("Mission not found with id: " + missionId));
    }*/

    @Transactional(readOnly = true)
    public Mission findMissionByIdOrDefault(Long missionId) {
        return missionRepository.findById(missionId)
                .orElse(getDefaultMission());
    }

    private Mission getDefaultMission() {
        Mission defaultMission = new Mission();
        defaultMission.setBody("This is a default mission.");
        return defaultMission;
    }

}
