package springboot_mongodb.common.runner;

import com.jayway.restassured.response.Response;
import springboot_mongodb.common.*;
import springboot_mongodb.common.utils.RetryUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(ListenerRunner.class)
public abstract class BaseRunner {

    protected final Logger logger = LoggerFactory.getLogger(getClass());
    protected Response response;

    @BeforeClass
    public static void beforeClass() {

    }

    @AfterClass
    public static void afterClass() {
    }

    // 失败重试
    @Rule
    public RetryUtils retryUtils = new RetryUtils(GlobalVar.RETRY_COUNTS);
}
