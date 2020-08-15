package pit.snow.rest.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pit.snow.domain.service.ShortenerService;
import pit.snow.rest.converter.CreateUrlRequest;
import pit.snow.rest.converter.CreateUrlResponse;
import pit.snow.rest.converter.UpdateUrlConverter;

@RestController
@RequestMapping("/api/v1")
public class ShortenerController {

    @Autowired
    private ShortenerService service;

    @PostMapping("/url")
    ResponseEntity<CreateShortUrlResponse> createShortUrl(@RequestBody CreateShortUrlRequest req) {
        return null;
    }

    @PutMapping("/url")
    ResponseEntity<UpdateUrlResponse> updateShortUrl(@RequestBody UpdateUrlRequest req) {
        return null;
    }
}
