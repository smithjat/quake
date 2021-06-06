package springboot_mongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Document(collection = "test_task_fastscan")
public class FastScan {
    @Id
    private String name;
    private String status;
    private Long time;
}
