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


    // 위치 기반 보물상자 열람
    @PostMapping("/treasurebox/{id}/location")
    public ApiResponse<TreasureBoxResponseDTO> setLocation(@PathVariable Long id, @RequestBody @Valid TreasureBoxRequestDTO.UpdateLocationDTO request) {
        TreasureBoxResponseDTO treasureBox = treasureBoxService.setLocation(id, request);
        return ApiResponse.onSuccess(treasureBox);
    }

    // 보물상자 위치
    @GetMapping("/treasurebox/{id}/location")
    public ApiResponse<String> getLocation(@PathVariable Long id) {
        String location = treasureBoxService.getLocation(id);
        return ApiResponse.onSuccess(location);
    }

    // 전체 수락 후 보물상자 열람
    @PostMapping("/treasurebox/{id}/all_accept")
    public ApiResponse<TreasureBoxResponseDTO> acceptAll(@PathVariable Long id) {
        TreasureBoxResponseDTO treasureBox = treasureBoxService.acceptAll(id);
        return ApiResponse.onSuccess(treasureBox);
    }

    // 보물상자 열람 상태 변경
    @PatchMapping("/treasurebox/{id}/status")
    public ApiResponse<TreasureBoxResponseDTO> updateStatus(@PathVariable Long id, @RequestBody @Valid TreasureBoxRequestDTO.UpdateStatusDTO request) {
        TreasureBoxResponseDTO treasureBox = treasureBoxService.updateStatus(id, request);
        return ApiResponse.onSuccess(treasureBox);
    }

    // 보물 상자 기한 미루기
    @PatchMapping("/treasurebox/{id}/delay")
    public ApiResponse<TreasureBoxResponseDTO> delayDeadline(@PathVariable Long id, @RequestBody @Valid TreasureBoxRequestDTO.UpdateDeadlineDTO request) {
        TreasureBoxResponseDTO treasureBox = treasureBoxService.delayDeadline(id, request);
        return ApiResponse.onSuccess(treasureBox);
    }
}
