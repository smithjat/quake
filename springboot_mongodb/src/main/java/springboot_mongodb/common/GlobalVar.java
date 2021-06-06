package springboot_mongodb.common;

import springboot_mongodb.common.utils.ListenerUtils;

import java.util.HashMap;
import java.util.Map;

public class GlobalVar {

    public static final String NOTIFY_SERVER ="NOTIFY_SERVER";
    public static final String COOKIE="b80a5c4a-b8f4-4b60-9ca5-291f4dcc513c";
    public static String SERVER_URL = "https://quake-3-dev.cert.qihoo.net";

    public static Map<String, String> COOKIES = new HashMap<>();
    public static Map<String, Object> HEADERS = new HashMap<>();

    // 失败重试，等于2，则失败重试1次，共执行2次
    public final static Integer RETRY_COUNTS = 2;

    public static String REPORT_PATH = "target/reports/";

    public final static ListenerUtils listenerUtils = new ListenerUtils();
}
