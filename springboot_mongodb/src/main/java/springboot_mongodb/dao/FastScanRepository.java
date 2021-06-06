package springboot_mongodb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import springboot_mongodb.entity.FastScan;
@Repository
public interface FastScanRepository extends MongoRepository<FastScan,String> {
    FastScan getByName(String name);
}
