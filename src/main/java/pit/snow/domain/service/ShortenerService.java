package pit.snow.domain.service;

import org.springframework.stereotype.Service;
import pit.snow.exception.NotFoundException;
import pit.snow.domain.entity.Url;
import pit.snow.domain.repository.UrlRepository;

import java.time.Instant;

@Service
public class ShortenerService {

    private final String DOMAIN = "localhost:8080/";

    private UrlRepository repo;

    private EncodeService encoderService;

    public ShortenerService(UrlRepository repo, EncodeService encoderService) {
        this.repo = repo;
        this.encoderService = encoderService;
    }

    public String createShortUrl(String entireUrl) {
        boolean alreadyOnDatabase = true;
        String generatedUrl;

        do {
            generatedUrl = encoderService.generateShortUrl();
            alreadyOnDatabase = isOnDatabase(encoderService.generateShortUrl());
        } while (alreadyOnDatabase);

        Url url = saveUrl(buildNewUrl(entireUrl, generatedUrl));
        return DOMAIN + url.getShortUrl();
    }

    public String updateUrl(Url sentUrl) {
        Url foundUrl = getFromDatabase(sentUrl.getShortUrl());

        if (foundUrl == null) {
            throw new NotFoundException();
        }

        repo.save(sentUrl);
        return sentUrl.getFullUrl();
    }

    private Url buildNewUrl(String entireUrl, String shortUrl) {
        return new Url(shortUrl, entireUrl, Instant.now(), Instant.now());
    }

    private Url saveUrl(Url newUrl) {
        return repo.insert(newUrl);
    }

    private boolean isOnDatabase(String shorturl) {
        return repo.findById(shorturl).isPresent();
    }

    private Url getFromDatabase(String shortUrl) {
        return repo.findById(shortUrl).orElse(null);
    }
}
