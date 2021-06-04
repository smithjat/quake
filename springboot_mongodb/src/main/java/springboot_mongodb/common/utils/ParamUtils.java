package springboot_mongodb.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;

public class ParamUtils {
    public RequestData templateFromYaml(String path){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        RequestData requestData = null;
        try {
            requestData = mapper.readValue(ParamUtils.class.getResourceAsStream(path), RequestData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return requestData;
    }
}
