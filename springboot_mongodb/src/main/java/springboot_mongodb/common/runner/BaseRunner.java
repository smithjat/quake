package springboot_mongodb.common.runner;

import com.jayway.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import springboot_mongodb.common.*;
import springboot_mongodb.common.utils.RetryUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@RunWith(ListenerRunner.class)
public abstract class BaseRunner {

//    protected  final Logger logger = LoggerFactory.getLogger(getClass());
    private  static Logger logger = LogManager.getLogger(BaseRunner.class.getClass());;
    protected Response response;

    @BeforeClass
    public static void beforeClass() {
//        logger.info("abc--BeforeClass");
    }

    @AfterClass
    public static void afterClass() {
//        logger.info("abc--AfterClass");
    }

    // 失败重试
    @Rule
    public RetryUtils retryUtils = new RetryUtils(GlobalVar.RETRY_COUNTS);
}
