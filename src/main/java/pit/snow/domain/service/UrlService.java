package pit.snow.domain.service;

import org.springframework.stereotype.Service;
import pit.snow.domain.dbentity.DbUrl;
import pit.snow.domain.entity.Url;
import pit.snow.domain.exception.NotFoundException;
import pit.snow.domain.exception.UrlInvalidException;
import pit.snow.domain.repository.UrlRepository;
import pit.snow.rest.request.RequestUrl;

import java.time.Instant;
import java.util.Optional;
import java.util.Random;

@Service
public class UrlService {

    private UrlRepository repo;

    public UrlService(UrlRepository repo) {
        this.repo = repo;
    }

    public Url shortenUrl(RequestUrl req) {
        if (!isUrlValid(req.getFullUrl())) {
            throw new UrlInvalidException();
        }

        boolean isOnDatabase = false;
        DbUrl dbUrl;
        String shortUrl;

        do {
            shortUrl = generateShortUrl();
            isOnDatabase = alreadyExist(shortUrl);
        } while (isOnDatabase);

        dbUrl = new DbUrl(shortUrl, req.getFullUrl(), Instant.now(), Instant.now());
        repo.insert(dbUrl);

        return new Url(dbUrl.getShortUrl(), dbUrl.getFullUrl(), dbUrl.getCreatedAt(), dbUrl.getUpdatedAt());
    }

    public Url updateUrl(RequestUrl req) {
        if (!isUrlValid(req.getFullUrl())) {
            throw new UrlInvalidException();
        }

        Optional<DbUrl> dbUrl = repo.findById(req.getShortUrl());

        if (!dbUrl.isPresent()) {
            throw new NotFoundException();
        }

        DbUrl url = dbUrl.get();
        url.setFullUrl(url.getFullUrl());
        url.setUpdatedAt(Instant.now());

        repo.save(url);

        return new Url(url.getShortUrl(), url.getFullUrl(), url.getCreatedAt(), url.getUpdatedAt());
    }

    public Url deleteUrl(RequestUrl req) {
        Optional<DbUrl> dbUrl = repo.findById(req.getShortUrl());

        if (!dbUrl.isPresent()) {
            throw new NotFoundException();
        }

        DbUrl url = dbUrl.get();
        repo.delete(url);

        return new Url(url.getShortUrl(), url.getFullUrl(), url.getCreatedAt(), url.getUpdatedAt());
    }

    public Url getUrl(RequestUrl req) {
        Optional<DbUrl> dbUrl = repo.findById(req.getShortUrl());

        if (!dbUrl.isPresent()) {
            throw new NotFoundException();
        }

        DbUrl url = dbUrl.get();

        return new Url(url.getShortUrl(), url.getFullUrl(), url.getCreatedAt(), url.getUpdatedAt());
    }

    private String generateShortUrl() {
        String base62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int linkLength = 6;
        StringBuilder generatedUrl = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < linkLength; i++) {
            int index = rand.nextInt(62);

            generatedUrl.append(base62.charAt(index));
        }
        return generatedUrl.toString();
    }

    private boolean alreadyExist(String shortUrl) {
        return repo.findById(shortUrl).isPresent();
    }

    private boolean isUrlValid(String url) {
        String regex = "https?://(www\\.)?[-a-zA-Z0-9@:%.+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%+.~#?&=]*)";
        return url.matches(regex);
    }
}
