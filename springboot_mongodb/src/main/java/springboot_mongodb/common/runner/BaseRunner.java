package springboot_mongodb.common.runner;

import com.jayway.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import springboot_mongodb.common.*;
import springboot_mongodb.common.utils.RetryUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.runner.RunWith;

@RunWith(ListenerRunner.class)
@SpringBootTest
public abstract class BaseRunner {

    protected  final Logger logger = LoggerFactory.getLogger(getClass());
    protected Response response;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("开始测试-----------------");

    }

    @AfterClass
    public static void afterClass() {
        System.out.println("测试结束-----------------");
    }

    // 失败重试
    @Rule
    public RetryUtils retryUtils = new RetryUtils(GlobalVar.RETRY_COUNTS);
}
