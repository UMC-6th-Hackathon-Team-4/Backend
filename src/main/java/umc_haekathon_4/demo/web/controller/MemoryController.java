package umc_haekathon_4.demo.web.controller;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import umc_haekathon_4.demo.apiPayload.ApiResponse;
import umc_haekathon_4.demo.domain.Memory;
import umc_haekathon_4.demo.service.MemoryService;
import umc_haekathon_4.demo.web.dto.MemoryRequestDTO;
import umc_haekathon_4.demo.web.dto.MemoryResponseDTO;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MemoryController {

    private final MemoryService memoryService;

    //추억 등록
    @PostMapping("/memory/upload")
    public ApiResponse<MemoryResponseDTO.MemoryResponseDTOBuilder> create(@RequestBody @Valid MemoryRequestDTO.CreateMemoryDto request) {
        Memory memory = memoryService.createMemory(title, memo, treasureBoxId, imageIds);
        return null;
    }

    //추억 제목
    @PostMapping("/memory/upload/title")

    //추억 내용 작성
    @PostMapping("/memory/upload/write")

    //추억 사진 올리기
    @PostMapping("/memory/upload/{image_id}")

    //추억 조회
    @GetMapping("/memory")

    //추억 미리보기
    @GetMapping("/memory-preview")


}
