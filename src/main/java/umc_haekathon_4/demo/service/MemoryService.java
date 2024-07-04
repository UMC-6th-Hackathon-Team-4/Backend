package umc_haekathon_4.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import umc_haekathon_4.demo.converter.MemoryConverter;
import umc_haekathon_4.demo.domain.Image;
import umc_haekathon_4.demo.domain.Memory;
import umc_haekathon_4.demo.domain.TreasureBox;
import umc_haekathon_4.demo.repository.ImageRepository;
import umc_haekathon_4.demo.repository.MemoryRepository;
import umc_haekathon_4.demo.repository.TreasureBoxRepository;
import umc_haekathon_4.demo.web.dto.MemoryRequestDTO;
import umc_haekathon_4.demo.web.dto.MemoryResponseDTO;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoryService {

    private final MemoryRepository memoryRepository;
    private final TreasureBoxRepository treasureBoxRepository;
    private final ImageRepository imageRepository;


    public Memory createMemory(MemoryRequestDTO.CreateMemoryDto request) {
        Memory memory = new Memory();
        memory.setTitle(request.getTitle());
        memory.setMemo(request.getMemo());

        // Handle TreasureBox
        TreasureBox treasureBox = treasureBoxRepository.findById(request.getTreasureBoxId())
                .orElseThrow(() -> new RuntimeException("TreasureBox not found"));
        memory.setTreasureBox(treasureBox);

        // Handle Images
        List<Image> images = imageRepository.findAllById(request.getImageIds());
        memory.setImages(images);

        return memoryRepository.save(memory);
    }

/*    public Memory setTitle(Long memoryId, String title){
        Memory memory = memoryRepository.findById(memoryId)
                .orElseThrow(() -> new RuntimeException("Memory not found"));
        memory.setTitle(title);
        return memoryRepository.save(memory);
    }*/

    public Memory getMemory(Long memoryId) {
        return memoryRepository.findById(memoryId)
                .orElseThrow(()->new RuntimeException("memory not found"));

    }

    public List<Memory> getAllMemories() {
        return memoryRepository.findAll();
    }

/*    public MemoryResponseDTO addImgToMem(Long memoryId, MultipartFile file) {
        Memory memory = memoryRepository.findById(memoryId)
                .orElseThrow(() -> new RuntimeException("memory not found"));
        try {
            if (file.isEmpty()) {
                throw new RuntimeException("Failed to store empty file.");
            }
            Path targetLocation = Paths.get("src/main/resources/uploads/" + file.getOriginalFilename());
            Files.copy(file.getInputStream(), targetLocation);
    }*/
}
