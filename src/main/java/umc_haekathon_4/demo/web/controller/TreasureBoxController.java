package umc_haekathon_4.demo.web.controller;

import io.swagger.v3.oas.annotations.Operation;
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

import java.util.List;

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


    //보물상자 리스트
    @GetMapping("/treasurebox/list")
    public ApiResponse<List<TreasureBox>> getTreasureBoxes() {
        List<TreasureBox> treasureBoxes = treasureBoxService.getTreasureBoxes();
        return ApiResponse.onSuccess(treasureBoxes);
    }

    //보물상자 조회
    @GetMapping("/treasurebox/list/choose")
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
    @Operation(summary = "보물 상자 위치", description = "보물 상자 위치")
    public ApiResponse<String> getLocation(@PathVariable Long id) {
        String location = treasureBoxService.getLocation(id);
        return ApiResponse.onSuccess(location);
    }

    // 전체 수락 후 보물상자 열람
    @PostMapping("/treasurebox/{id}/all_accept")
    @Operation(summary = "보물 상자 열람", description = "전체가 수락하고나면 보물 상자 열람")
    public ApiResponse<TreasureBoxResponseDTO> acceptAll(@PathVariable Long id) {
        TreasureBoxResponseDTO treasureBox = treasureBoxService.acceptAll(id);
        return ApiResponse.onSuccess(treasureBox);
    }

    // 보물상자 열람 상태 변경
    @PatchMapping("/treasurebox/{id}/status")
    @Operation(summary = "보물상자 열람 상태 변경")
    public ApiResponse<TreasureBoxResponseDTO> updateStatus(@PathVariable Long id, @RequestBody @Valid TreasureBoxRequestDTO.UpdateStatusDTO request) {
        TreasureBoxResponseDTO treasureBox = treasureBoxService.updateStatus(id, request);
        return ApiResponse.onSuccess(treasureBox);
    }

    // 보물 상자 기한 미루기
    @PatchMapping("/treasurebox/{id}/delay")
    @Operation(summary = "보물 상자 기한 미루기")
    public ApiResponse<TreasureBoxResponseDTO> delayDeadline(@PathVariable Long id, @RequestBody @Valid TreasureBoxRequestDTO.UpdateDeadlineDTO request) {
        TreasureBoxResponseDTO treasureBox = treasureBoxService.delayDeadline(id, request);
        return ApiResponse.onSuccess(treasureBox);
    }
}
