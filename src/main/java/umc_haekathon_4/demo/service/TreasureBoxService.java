package umc_haekathon_4.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc_haekathon_4.demo.converter.TreasureBoxConverter;
import umc_haekathon_4.demo.domain.TreasureBox;
import umc_haekathon_4.demo.domain.User;
import umc_haekathon_4.demo.repository.MissionRepository;
import umc_haekathon_4.demo.repository.TreasureBoxRepository;
import umc_haekathon_4.demo.repository.UserRepository;
import umc_haekathon_4.demo.web.dto.TreasureBoxRequestDTO;
import umc_haekathon_4.demo.web.dto.TreasureBoxResponseDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TreasureBoxService {
    private final TreasureBoxRepository treasureBoxRepository;
    private final UserRepository UserRepository;
    private final MissionRepository MissionRepository;

    private static final double DISTANCE_THRESHOLD = 100; // 위치 임계값

    public TreasureBox createTreasureBox(TreasureBoxRequestDTO.CreateTreasureBoxDTO request) {
        User user = UserRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        TreasureBox treasureBox = TreasureBoxConverter.toEntity(request,user);
        return treasureBoxRepository.save(treasureBox);
    }

    public TreasureBox getTreasureBox(Long TreasureBoxId) {
        return treasureBoxRepository.findById(TreasureBoxId)
                .orElseThrow(() -> new RuntimeException("TreasureBox not found"));
    }


    public TreasureBoxResponseDTO setLocation(Long id, TreasureBoxRequestDTO.UpdateLocationDTO request) {
        TreasureBox treasureBox = treasureBoxRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TreasureBox not found"));

        treasureBox.setLatitude(request.getLatitude());
        treasureBox.setLongitude(request.getLongitude());
        treasureBox = treasureBoxRepository.save(treasureBox);
        return TreasureBoxConverter.toDTO(treasureBox);
    }

    public double[] getLocation(Long id) {
        TreasureBox treasureBox = treasureBoxRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TreasureBox not found"));

        return new double[]{treasureBox.getLatitude(), treasureBox.getLongitude()};
    }


    public TreasureBoxResponseDTO acceptAll(Long id) {
        TreasureBox treasureBox = treasureBoxRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TreasureBox not found"));

        treasureBox.setStatus("UNLOCK");

        treasureBox = treasureBoxRepository.save(treasureBox);
        return TreasureBoxConverter.toDTO(treasureBox);
    }

    public TreasureBoxResponseDTO updateStatus(Long id, TreasureBoxRequestDTO.UpdateStatusDTO request) {
        TreasureBox treasureBox = treasureBoxRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TreasureBox not found"));

        treasureBox.setStatus(request.getStatus());
        treasureBox = treasureBoxRepository.save(treasureBox);
        return TreasureBoxConverter.toDTO(treasureBox);
    }

    public TreasureBoxResponseDTO delayDeadline(Long id, TreasureBoxRequestDTO.UpdateDeadlineDTO request) {
        TreasureBox treasureBox = treasureBoxRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TreasureBox not found"));

        treasureBox.setDeadline(request.getNewDeadline());
        treasureBox = treasureBoxRepository.save(treasureBox);
        return TreasureBoxConverter.toDTO(treasureBox);
    }

    public List<TreasureBox> getTreasureBoxes() {
        return treasureBoxRepository.findAll();
    }

    public boolean canOpenTreasureBox(Long id, TreasureBoxRequestDTO.initialLocationDTO userLocation) {
        TreasureBox treasureBox = treasureBoxRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TreasureBox not found"));

        double distance = calculateDistance(
                treasureBox.getLatitude(), treasureBox.getLongitude(),
                userLocation.getLatitude(), userLocation.getLongitude()
        );

        if (distance < DISTANCE_THRESHOLD) {
            treasureBox.setStatus("opened");
            treasureBoxRepository.save(treasureBox);
            return true;
        }

        return false;
    }

    public TreasureBoxResponseDTO openTreasureBox(Long id) {
        TreasureBox treasureBox = treasureBoxRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TreasureBox not found"));
        return TreasureBoxConverter.toDTO(treasureBox);
    }

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371;
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters
        return distance;
    }
}
