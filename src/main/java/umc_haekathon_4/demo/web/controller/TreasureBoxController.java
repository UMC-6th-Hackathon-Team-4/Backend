package umc_haekathon_4.demo.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc_haekathon_4.demo.apiPayload.ApiResponse;
import umc_haekathon_4.demo.converter.TreasureBoxConverter;
import umc_haekathon_4.demo.domain.TreasureBox;
import umc_haekathon_4.demo.service.TreasureBoxService;
import umc_haekathon_4.demo.web.dto.TreasureBoxRequestDTO;
import umc_haekathon_4.demo.web.dto.TreasureBoxResponseDTO;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class TreasureBoxController {
    private final TreasureBoxService treasureBoxService;

    //보물상자 생성
    @PostMapping("/treasurebox")
    public ApiResponse<TreasureBoxResponseDTO> create(@RequestBody @Valid TreasureBoxRequestDTO.CreateTreasureBoxDTO request) {
        TreasureBox treasureBox = treasureBoxService.createTreasureBox(request);
        return ApiResponse.onSuccess(TreasureBoxConverter.toDTO(treasureBox));
    }


    //보물상자 조회
    @GetMapping("/treasurebox/list")
    public ApiResponse<TreasureBox> getTreasureBox(Long treasureId) {
        TreasureBox treasureBox = treasureBoxService.getTreasureBox(treasureId);
        return ApiResponse.onSuccess(treasureBox);
    }

    /*
    // 위치 기반 보물상자 열람
    @PostMapping("/treasurebox/{id}/location")

    // 전체 수락 후 보물상자 열람
    @PostMapping("/treasurebox/{id}/all_accept")

    // 보물상자 위치
    @GetMapping("/treasurebox/{id}/location")

    // 보물상자 열람 상태 변경
    @PatchMapping("/treasurebox/{id}/status")

    // 보물 상자 기한 미루기
    @PatchMapping("/treasurebox/{id}/delay")
    */
}
