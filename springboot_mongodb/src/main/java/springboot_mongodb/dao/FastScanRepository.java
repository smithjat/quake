package springboot_mongodb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import springboot_mongodb.entity.FastScan;

public interface FastScanRepository extends MongoRepository<FastScan,String> {

}
