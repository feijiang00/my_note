package myUtils;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: XiaoJiang
 * @Date: 2021/05/06/1:18
 * @QQ群: 807092830
 * @Description:
 */
public class DemoApi {
    public static void main(String[] args) {
        //接口地址
        String URL = "https://tianqiapi.com/free/week";
        String appid = "64483986";
        String appsecret = "5lMkmlom";
        String METH = "GET";

        String str = result(URL,appid,appsecret,METH);
        JSONObject jsonObject = JSONObject.parseObject(str);
        System.out.println(jsonObject);
    }
    public static String result(String URL, String appid, String appsecret,String METH) {

        //params用于存储请求数据的参数
        Map params = new HashMap();
        //showapi_appid的值
        params.put("appid", appid);
        //添加时间
        params.put("appsecret", appsecret);

        //调用httpRequest方法，这个方法主要用于请求地址，并加上请求参数
        String s = httpRequest(URL, params,METH);
        // System.out.println(s);
        return s;
    }


    private static String httpRequest(String requestURL, Map params,String METH) {
        //buffer用于接受返回的json数据
        StringBuffer buffer = new StringBuffer();
        try {
            //建立URL，把请求地址给补全，其中urlencode（）方法用于把params里的参数给取出来
            URL url = new URL(requestURL+"?"+urlencode(params));
            //打开http连接
            HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();//连接
            httpUrlConnection.setDoInput(true);
            httpUrlConnection.setRequestMethod(METH);
            httpUrlConnection.connect();

            //获得输入
            InputStream inputStream = httpUrlConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"utf-8");//编码
            BufferedReader bufferedReader =  new BufferedReader(inputStreamReader);


            //将bufferReader的值给放到str里
            String str = null;
            while((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }


            //关闭bufferReader和输入流
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            // inputStream = null;

            //断开连接
            httpUrlConnection.disconnect();

        } catch(Exception ex) {
            ex.printStackTrace();
        }
        //返回字符串
        return buffer.toString();

    }

    public static String urlencode(Map<String, Object>data) {

        //将map里的参数变成像 showapi_appid=###&showapi_sign=###&的样子
        StringBuilder sb = new StringBuilder();
        for(Map.Entry i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue() + "", "UTF-8")).append("&");
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static String get_time() {//设置时间
        Date d = new Date();//创建日期对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");//创建格式化日期
        String s = sdf.format(d);//创建成字符串
//        System.out.println(s);
        return s;
    }


}
