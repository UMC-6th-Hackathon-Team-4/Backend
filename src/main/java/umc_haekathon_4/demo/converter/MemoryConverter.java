package umc_haekathon_4.demo.converter;

import umc_haekathon_4.demo.domain.Image;
import umc_haekathon_4.demo.domain.Memory;
import umc_haekathon_4.demo.domain.TreasureBox;
import umc_haekathon_4.demo.web.dto.MemoryRequestDTO;
import umc_haekathon_4.demo.web.dto.MemoryResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class MemoryConverter {

    public static Memory convertToEntity(MemoryRequestDTO.CreateMemoryDto request){
        TreasureBox treasureBox=new TreasureBox();
        treasureBox.setId(request.getTreasureBoxId());

        return  Memory.builder()
                .title(request.getTitle())
                .memo(request.getMemo())
                .treasureBox(treasureBox)
                .images(new ArrayList<>()).build();

    }

    public static MemoryResponseDTO convertToDto(Memory memory){
        return MemoryResponseDTO.builder()
                .memoryId(memory.getId())
                .createdDate(memory.getCreatedAt())
                .build();

    }
}
