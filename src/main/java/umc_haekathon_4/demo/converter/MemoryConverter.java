package umc_haekathon_4.demo.converter;

import umc_haekathon_4.demo.domain.Image;
import umc_haekathon_4.demo.domain.Memory;
import umc_haekathon_4.demo.domain.TreasureBox;
import umc_haekathon_4.demo.web.dto.MemoryRequestDTO;
import umc_haekathon_4.demo.web.dto.MemoryResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MemoryConverter {

    public static Memory convertToEntity(MemoryRequestDTO.CreateMemoryDto createMemoryDto, List<Image> images,TreasureBox treasureBox){
        Memory memory=new Memory();
        memory.setTitle(createMemoryDto.getTitle());
        memory.setMemo(createMemoryDto.getMemo());
        memory.setTreasureBox(treasureBox);
        memory.setImages(images);

        return memory;
    }

    public static MemoryResponseDTO convertToDto(Memory memory){
        return MemoryResponseDTO.builder()
                .id(memory.getId())
                .title(memory.getTitle())
                .memo(memory.getMemo())
                .createdDate(memory.getCreatedDate())
                .images(memory.getImages())
                .treasureBox(memory.getTreasureBox())
                .build();

    }
}
