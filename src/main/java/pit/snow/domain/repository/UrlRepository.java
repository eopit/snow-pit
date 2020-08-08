package pit.snow.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pit.snow.domain.dbentity.DbUrl;

public interface UrlRepository extends MongoRepository<DbUrl, String> {
}
