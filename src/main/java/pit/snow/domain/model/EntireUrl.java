package pit.snow.domain.model;

import java.time.Instant;

public class EntireUrl {

    private String fullUrl;
    private String shortUrl;
    private Instant createdAt;
    private Instant updatedAt;

    public EntireUrl(String fullUrl, String shortUrl) {
        this.fullUrl = fullUrl;
        this.shortUrl = shortUrl;
    }

    public EntireUrl(String fullUrl, String shortUrl, Instant createdAt, Instant updatedAt) {
        this.fullUrl = fullUrl;
        this.shortUrl = shortUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
