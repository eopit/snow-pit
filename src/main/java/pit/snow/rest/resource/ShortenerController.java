package pit.snow.rest.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pit.snow.domain.entity.Url;
import pit.snow.domain.service.UrlService;
import pit.snow.rest.request.RequestUrl;

@RestController
@RequestMapping("/api/v1")
public class ShortenerController {

    @Autowired
    private UrlService urlService;

    @PostMapping("/url")
    ResponseEntity<Url> createShortUrl(@RequestBody RequestUrl req) {
        Url generatedUrl = urlService.shortenUrl(req);
        return new ResponseEntity<>(generatedUrl, HttpStatus.CREATED);
    }
}
