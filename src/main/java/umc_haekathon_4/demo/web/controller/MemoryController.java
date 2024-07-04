package umc_haekathon_4.demo.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import umc_haekathon_4.demo.apiPayload.ApiResponse;
import umc_haekathon_4.demo.converter.MemoryConverter;
import umc_haekathon_4.demo.domain.Memory;
import umc_haekathon_4.demo.service.MemoryService;
import umc_haekathon_4.demo.web.dto.MemoryRequestDTO;
import umc_haekathon_4.demo.web.dto.MemoryResponseDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class MemoryController {

    private final MemoryService memoryService;

    //추억 등록
    @PostMapping("/memory/upload")
    @Operation(summary = "추억 등록", description = "새로운 추억을 등록합니다.")
    public ApiResponse<MemoryResponseDTO> create(@RequestBody @Valid MemoryRequestDTO.CreateMemoryDto request) {
        Memory memory = memoryService.createMemory(request);
        return ApiResponse.onSuccess(MemoryConverter.convertToDto(memory));
    }

/*    @PostMapping("/memory/upload-image")
    private ApiResponse<MemoryResponseDTO> addImgToMem(Long memoryId, MultipartFile file){
        MemoryResponseDTO updatedMemory = memoryService.addImgToMem(memoryId, file);
        return ApiResponse.onSuccess(updatedMemory);
    }*/

    //추억 조회
    @GetMapping("/memory")
    @Operation(summary = "추억 조회", description = "주어진 ID의 추억을 조회합니다.")
    public ApiResponse<Memory> getMemory(Long memoryId) {
        Memory memory = memoryService.getMemory(memoryId);
        return ApiResponse.onSuccess(memory);
    }


    //모든 추억 미리보기
    @GetMapping("/memory-preview")
    @Operation(summary = "모든 추억 미리보기", description = "등록된 모든 추억을 미리 봅니다.")
    public ApiResponse<List<Memory>> getAllMemories(){
        List<Memory> memories = memoryService.getAllMemories();
        return ApiResponse.onSuccess(memories);
    }


}
