package umc_haekathon_4.demo.converter;

import umc_haekathon_4.demo.domain.Image;
import umc_haekathon_4.demo.domain.Memory;

public class ImageConverter {

    public static Image toImage(String imageUrl, Memory request) {
        return Image.builder()
                .url(imageUrl)
                .memory(request)
                .build();
    }
}
