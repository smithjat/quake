package springboot_mongodb.service.v3;

import org.junit.Test;
import springboot_mongodb.common.runner.BaseRunner;
import org.springframework.boot.test.context.SpringBootTest;
import springboot_mongodb.common.utils.ProxyUtils;

@SpringBootTest
public class TestFastScanService extends BaseRunner {
    private FastScanService fastScan = ProxyUtils.create(FastScanService.class);
    @Test
    public void testIndex() throws InterruptedException {
//        COOKIES.put("cert_common_dev", GlobalVar.COOKIE);
//        response = schedule.index();
//        response.then().body("message", equalTo("Successful."));

        Thread.sleep(10000);
//        System.out.println(RegexUtils.getDoc(doc));
    }

}
