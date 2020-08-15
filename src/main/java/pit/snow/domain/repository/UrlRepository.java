package pit.snow.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pit.snow.domain.entity.Url;

@Repository
public interface UrlRepository extends MongoRepository<Url, String> {
}
