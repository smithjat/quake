package springboot_mongodb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import springboot_mongodb.entity.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student,String> {
    Student getStudentByStuName(String name);
}
