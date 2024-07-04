package umc_haekathon_4.demo.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc_haekathon_4.demo.service.TreasureBoxService;
import umc_haekathon_4.demo.web.dto.TreasureBoxRequestDTO;
import umc_haekathon_4.demo.web.dto.TreasureBoxResponseDTO;

@RestController
@RequestMapping("/treasure")
@RequiredArgsConstructor
public class TreasureBoxController {
    private TreasureBoxService treasureBoxService;


}
