package springboot_mongodb.quakeapi.v3;

import com.jayway.restassured.response.Response;
import springboot_mongodb.common.GlobalVar;
import springboot_mongodb.common.annotation.POST;
import springboot_mongodb.common.annotation.SERVER;

@SERVER(GlobalVar.NOTIFY_SERVER)
public interface FastScan {
    @POST(path = "/api/v3/fast_scan",description = "快速扫描任务")
    Response fast_scan();
}
