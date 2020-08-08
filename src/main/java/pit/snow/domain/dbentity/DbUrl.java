package pit.snow.domain.dbentity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.redis.core.index.Indexed;

import java.time.Instant;

@Document(collection = "url")
public class DbUrl {

    @Id
    private String shortUrl;
    @Indexed
    private String fullUrl;
    private Instant createdAt;
    private Instant updatedAt;

    public DbUrl(String shortUrl, String fullUrl, Instant createdAt, Instant updatedAt) {
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

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
