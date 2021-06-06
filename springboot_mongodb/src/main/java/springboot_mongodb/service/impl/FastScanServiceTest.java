package springboot_mongodb.service.impl;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import springboot_mongodb.common.GlobalVar;
import springboot_mongodb.common.runner.BaseRunner;
import springboot_mongodb.common.utils.ProxyUtils;
import springboot_mongodb.dao.FastScanRepository;
import springboot_mongodb.service.v3.FastScanService;

@Service
public class FastScanServiceTest extends BaseRunner {
    private FastScanService fastScan = ProxyUtils.create(FastScanService.class);

    @Autowired
    private FastScanRepository fastScanRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Transactional
    @Rollback
    @Test
    public void testFastScan() {
        GlobalVar.COOKIES.put("cert_common_dev", GlobalVar.COOKIE);
        response = fastScan.createtask("1.2.3.4","80");
        System.out.println(response.getStatusCode());
        Assert.assertSame(401,response.getStatusCode());
    }
}
