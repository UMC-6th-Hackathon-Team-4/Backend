package umc_haekathon_4.demo.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc_haekathon_4.demo.apiPayload.ApiResponse;
import umc_haekathon_4.demo.apiPayload.code.ErrorReasonDTO;
import umc_haekathon_4.demo.domain.Mission;
import umc_haekathon_4.demo.service.MissionService;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class MissionController {

    private final MissionService missionService;


    //미션 주기
    @GetMapping("/mission")
    public ApiResponse<Mission> getMission(Long missionId){
        Mission mission = missionService.findMissionByIdOrDefault(missionId);
        return ApiResponse.onSuccess(mission);
    }


}
