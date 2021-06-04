package springboot_mongodb.service.v3;

import com.jayway.restassured.response.Response;
import springboot_mongodb.common.GlobalVar;
import springboot_mongodb.common.annotation.POST;
import springboot_mongodb.common.annotation.SERVER;

@SERVER(GlobalVar.NOTIFY_SERVER)
public interface FastScanService {
    @POST(path = "/api/v3/fast_scan",description = "快速扫描任务")
    Response fast_scan();
}
