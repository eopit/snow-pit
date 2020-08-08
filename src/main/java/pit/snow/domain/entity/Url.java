package pit.snow.domain.entity;

import java.time.Instant;

public class Url {

    private String shortUrl;
    private String fullUrl;
    private Instant createdAt;
    private Instant updatedAt;

    public Url(String shortUrl, String fullUrl, Instant createdAt, Instant updatedAt) {
        this.shortUrl = shortUrl;
        this.fullUrl = fullUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
