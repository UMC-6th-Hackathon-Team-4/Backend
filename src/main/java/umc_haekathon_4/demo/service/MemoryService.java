package umc_haekathon_4.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import umc_haekathon_4.demo.aws.s3.AmazonS3Manager;
import umc_haekathon_4.demo.converter.ImageConverter;
import umc_haekathon_4.demo.converter.MemoryConverter;
import umc_haekathon_4.demo.domain.Image;
import umc_haekathon_4.demo.domain.Memory;
import umc_haekathon_4.demo.domain.TreasureBox;
import umc_haekathon_4.demo.domain.Uuid;
import umc_haekathon_4.demo.repository.ImageRepository;
import umc_haekathon_4.demo.repository.MemoryRepository;
import umc_haekathon_4.demo.repository.TreasureBoxRepository;
import umc_haekathon_4.demo.repository.UuidRepository;
import umc_haekathon_4.demo.web.dto.MemoryRequestDTO;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemoryService {

    private final MemoryRepository memoryRepository;
    private final TreasureBoxRepository treasureBoxRepository;
    private final ImageRepository imageRepository;
    private final AmazonS3Manager s3Manager;
    private final UuidRepository uuidRepository;


    public Memory createMemory(MemoryRequestDTO.CreateMemoryDto request, MultipartFile file) {
        Memory memory = MemoryConverter.convertToEntity(request);

        // S3
        String uuid = UUID.randomUUID().toString();
        Uuid savedUuid = uuidRepository.save(Uuid.builder()
                .uuid(uuid).build());

        String imageUrl = s3Manager.uploadFile(s3Manager.generateReviewKeyName(savedUuid), file);

        // Handle TreasureBox
        TreasureBox treasureBox = treasureBoxRepository.findById(request.getTreasureBoxId())
                .orElseThrow(() -> new RuntimeException("TreasureBox not found"));
        memory.setTreasureBox(treasureBox);

        // Handle Images
//        List<Image> images = imageRepository.findAllById(request.getImageIds());
//        memory.setImages(images);

        // S3
        imageRepository.save(ImageConverter.toImage(imageUrl, memory));

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
}
