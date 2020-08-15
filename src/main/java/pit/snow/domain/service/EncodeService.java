package pit.snow.domain.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class EncodeService {

    public String generateShortUrl() {
        final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final int SHORT_URL_LENGTH = 6;

        StringBuilder generatedUrl = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < SHORT_URL_LENGTH; i++) {
            int index = rand.nextInt(62);
            generatedUrl.append(BASE62.charAt(index));
        }
        return generatedUrl.toString();
    }
}
