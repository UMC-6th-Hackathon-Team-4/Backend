package umc_haekathon_4.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc_haekathon_4.demo.converter.MemoryConverter;
import umc_haekathon_4.demo.domain.Image;
import umc_haekathon_4.demo.domain.Memory;
import umc_haekathon_4.demo.domain.TreasureBox;
import umc_haekathon_4.demo.repository.ImageRepository;
import umc_haekathon_4.demo.repository.MemoryRepository;
import umc_haekathon_4.demo.repository.TreasureBoxRepository;
import umc_haekathon_4.demo.web.dto.MemoryRequestDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoryService {

    private final MemoryRepository memoryRepository;
    private final TreasureBoxRepository treasureBoxRepository;
    private final ImageRepository imageRepository;


    public Memory createMemory(MemoryRequestDTO.CreateMemoryDto request) {

        TreasureBox treasureBox=treasureBoxRepository.findById(request.getTreasureBoxId())
                .orElseThrow(() -> new RuntimeException("TreasureBox not found"));

        List<Image> images=imageRepository.findAllById(request.getImageIds());

        Memory memory = MemoryConverter.convertToEntity(request,images,treasureBox);
        return memoryRepository.save(memory);
    }
}
