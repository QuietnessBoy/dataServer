package com.services.data.config;

import com.services.data.dto.JsonResult;
import com.services.data.util.JsonResultTool;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @ProjectName Http请求方式封装方法
 * @Package com.services.data.config
 * @ClassName HttpMethod
 * @Description
 * @Company HaoBo
 * @Author wangw
 * @Date 2019/12/18 0018 9:35
 * @UpdateUser
 * @UpdateDate
 * @UpdateRemark
 * @Version 1.0.0
 */
@Slf4j
public class HttpMethod {


    /**
     * @Title Get请求
     * @Description

     * @return
     * @author wangw
     * @date
    */
    public static JsonResult httpGETCase(String methodUrl) {
        JsonResult jsonResult = new JsonResult();
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        String line = null;
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(methodUrl + "");
            connection = (HttpURLConnection) url.openConnection();// 根据URL生成HttpURLConnection
            connection.setRequestMethod("GET");// 默认GET请求
            connection.connect();// 建立TCP连接
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));// 发送http请求
                // 循环读取流
                while ((line = reader.readLine()) != null) {
                    result.append(line).append(System.getProperty("line.separator"));//
                }
                jsonResult = JsonResultTool.JsonResultSet(true,"200","获取到接口数据.",result.toString());
                log.info("获取到接口数据.");
            }else{
                log.error("接口响应失败.");
                jsonResult = JsonResultTool.JsonResultSet(false,"500","接口响应失败.",result.toString());
                return jsonResult;
            }
        } catch (IOException e) {
            e.printStackTrace();
            jsonResult = JsonResultTool.JsonResultSet(false,"404","接口异常.",result.toString());
            log.error("接口异常.");
        }
        return jsonResult;
    }


    /**
     * @Title Post请求
     * @Description

     * @return
     * @author wangw
     * @date
    */
    public static void httpPOSTCase(String methodUrl) {
        HttpURLConnection connection = null;
        OutputStream dataout = null;
        BufferedReader reader = null;
        String line = null;
        try {
            URL url = new URL(methodUrl);
            connection = (HttpURLConnection) url.openConnection();// 根据URL生成HttpURLConnection
            connection.setDoOutput(true);// 设置是否向connection输出，因为这个是post请求，参数要放在http正文内，因此需要设为true,默认情况下是false
            connection.setDoInput(true); // 设置是否从connection读入，默认情况下是true;
            connection.setRequestMethod("GET");// 设置请求方式为post,默认GET请求
            connection.setUseCaches(false);// post请求不能使用缓存设为false
            connection.setConnectTimeout(3000);// 连接主机的超时时间
            connection.setReadTimeout(3000);// 从主机读取数据的超时时间
            connection.setInstanceFollowRedirects(true);// 设置该HttpURLConnection实例是否自动执行重定向
            connection.setRequestProperty("connection", "Keep-Alive");// 连接复用
            connection.setRequestProperty("charset", "utf-8");

            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer 66cb225f1c3ff0ddfdae31rae2b57488aadfb8b5e7");
            connection.connect();// 建立TCP连接,getOutputStream会隐含的进行connect,所以此处可以不要

            dataout = new DataOutputStream(connection.getOutputStream());// 创建输入输出流,用于往连接里面输出携带的参数
            String body = "[{\"orderNo\":\"44921902\",\"adviser\":\"张怡筠\"}]";
            dataout.write(body.getBytes());
            dataout.flush();
            dataout.close();

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));// 发送http请求
                StringBuilder result = new StringBuilder();
                // 循环读取流
                while ((line = reader.readLine()) != null) {
                    result.append(line).append(System.getProperty("line.separator"));//
                }
                System.out.println("########################"+result.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            connection.disconnect();
        }
    }
}
