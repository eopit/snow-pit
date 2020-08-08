package pit.snow.rest.request;

public class RequestUrl {

    private String shortUrl;
    private String fullUrl;

    public RequestUrl() {
    }

    public RequestUrl(String shortUrl, String fullUrl) {
        this.shortUrl = shortUrl;
        this.fullUrl = fullUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public String getFullUrl() {
        return fullUrl;
    }
}
