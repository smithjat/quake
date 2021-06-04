package springboot_mongodb.common.enums;

/**
 * @Author: Wang Hualin
 * @Date: 2018/1/20
 */
public enum HttpType {
    POST("post"),
    PUT("put"),
    DELETE("delete"),
    GET("get");

    private String value;

    HttpType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
