package springboot_mongodb.common.utils;


import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: yiqin
 * @Date: 2019/04/12 10:37
 * @Description: 发送异常至钉钉
 */

public class QuakeUtils {


    private static String URL_SENG_DINGDING_MSG = "/send_dingding_msg";

    //应用程序的名称
    private static String applicationName;
    private static String level;
    private static String dd_msgtype;
    private static String atall;

    static {
        applicationName = "接口监控";
        level = "提示";
        dd_msgtype = "msg";
        atall = "false";

    }

    /**
     * 发送钉钉消息
     * @param content   通知消息的内容
     */
    public static String sendMsg(String dd_server_url, String dd_access_token, String content) {
        HashMap<String, String> map = new HashMap<>();
        map.put("keyval", "接口返回结果异常");
        map.put("msgtype", applicationName);
        map.put("level", level);
        map.put("content", content);
        map.put("dd_msgtype", dd_msgtype);
        map.put("atall", atall);

        //若没有指定at的手机号，则默认"开发人员手机号"
//        map.put("atlist", StringUtils.isNotBlank(atlist)? atlist: "17611111111");
//        map.put("dd_msg_url", dd_msg_url);
        map.put("dd_access_token", dd_access_token);
        try {
            return sendPostJson(dd_server_url, map);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "失败";
    }

    /**
     * 发送post请求
     * @param url 地址
     * @param parameters map参数
     * @return 返回数据
     */
    private static String sendPostJson(String url, Map<String, String> parameters) {
        String result = "";// 返回的结果
        BufferedReader in = null;// 读取响应输入流
        PrintWriter out = null;
        String params = "";// 编码之后的参数
        try {
            if (parameters != null && parameters.size() > 0) {
                params = JSON.toJSONString(parameters);
            }
            // 创建URL对象
            java.net.URL connURL = new java.net.URL(url + URL_SENG_DINGDING_MSG);
            // 打开URL连接
            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) connURL
                    .openConnection();
            httpConn.setConnectTimeout(2000);
            httpConn.setReadTimeout(4000);

            // 设置通用属性
            httpConn.setRequestProperty("Accept", "*/*");
            httpConn.setRequestProperty("Connection", "Keep-Alive");
            httpConn.setRequestProperty("Content-Type", "application/json");
            httpConn.setRequestProperty("User-Agent",
                    "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");
            // 设置POST方式
            httpConn.setDoInput(true);
            httpConn.setDoOutput(true);
            // 获取HttpURLConnection对象对应的输出流
            out = new PrintWriter(httpConn.getOutputStream());
            // 发送请求参数
            out.write(params);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应，设置编码方式
            in = new BufferedReader(new InputStreamReader(httpConn
                    .getInputStream(), "UTF-8"));
            String line;
            // 读取返回的内容
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
}