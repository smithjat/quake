package springboot_mongodb.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "quake_task")
public class FastScan {
    private String name;
    private String status;
    private String _id;
}
