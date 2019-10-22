//package com.yangy.manage.common.utils;
//
//import org.apache.http.Consts;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.util.EntityUtils;
//
//import java.io.InputStream;
//
///**
// * url 长链接转短
// *
// * @author yang yang
// * @email m17610912950@163.com
// * @time 2019年08月28日 10:12
// **/
//public class ShortUrlUtils {
//
//    public static void main(String[] args) throws Exception{
//        HttpClient httpClient = HttpUtil.getHttpClient();
//
//
//
//        String url = domain + urlSuffix + data;
//        HttpGet httpGet = new HttpGet(url);
//        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(0).setConnectTimeout(0).build();
//        httpGet.setConfig(requestConfig);
//        HttpResponse httpResponse = httpClient.execute(httpGet);
//        HttpEntity httpEntity = httpResponse.getEntity();
//        System.out.println(EntityUtils.toString(httpEntity, Consts.UTF_8.name()));
//    }
//
//
//}
