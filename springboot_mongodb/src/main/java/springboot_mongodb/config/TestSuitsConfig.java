package springboot_mongodb.config;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import springboot_mongodb.service.impl.FastScanServiceTest;

//@Ignore("not ready yet")
@RunWith(Suite.class)
@Suite.SuiteClasses({FastScanServiceTest.class})
public class TestSuitsConfig {
}
