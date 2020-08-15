package pit.snow.domain.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "url")
public class Url {

    @Id
    private String shortUrl;
    @Indexed
    private String fullUrl;
    private Instant createdAt;
    private Instant updatedAt;

    public Url(String shortUrl, String fullUrl, Instant createdAt, Instant updatedAt) {
        this.shortUrl = shortUrl;
        this.fullUrl = fullUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Url(String shortUrl, String fullUrl) {
        this.shortUrl = shortUrl;
        this.fullUrl = fullUrl;
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
