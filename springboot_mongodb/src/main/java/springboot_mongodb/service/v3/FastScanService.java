package springboot_mongodb.service.v3;

import com.jayway.restassured.response.Response;
import springboot_mongodb.common.GlobalVar;
import springboot_mongodb.common.annotation.*;

@SERVER(GlobalVar.NOTIFY_SERVER)
public interface FastScanService {
    @POST(path = "/api/v3/fast_scan",description = "快速扫描任务")
    Response createtask(@Param("ip") String ip,
                        @Param("port") String port);
}
