package com.yangy.manage.common.utils;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedHashMap;

public class BaiduDwz {
    final static String CREATE_API = "https://dwz.cn/admin/v2/create";
    final static String TOKEN = "fd98ac2430d5639b0fae596ff39a96e5"; // TODO:设置Token

    class UrlResponse {
        @SerializedName("Code")
        private int code;

        @SerializedName("ErrMsg")
        private String errMsg;

        @SerializedName("LongUrl")
        private String longUrl;

        @SerializedName("ShortUrl")
        private String shortUrl;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getErrMsg() {
            return errMsg;
        }

        public void setErrMsg(String errMsg) {
            this.errMsg = errMsg;
        }

        public String getLongUrl() {
            return longUrl;
        }

        public void setLongUrl(String longUrl) {
            this.longUrl = longUrl;
        }

        public String getShortUrl() {
            return shortUrl;
        }

        public void setShortUrl(String shortUrl) {
            this.shortUrl = shortUrl;
        }
    }

    /**
     * 创建短网址
     *
     * @param longUrl 长网址：即原网址
     *                termOfValidity
     *                有效期：默认值为long-term
     * @return 成功：短网址
     * 失败：返回空字符串
     */
    public static String createShortUrl(String longUrl, String termOfValidity) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("Url",longUrl);
        map.put("TermOfValidity",termOfValidity);

        try {
            String post = HttpUtil.post("application/json", "https://dwz.cn", "/admin/v2/create", HttpUtil.getMapToString(map, true), 0, 0);
            System.out.println(post);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String res = createShortUrl("http://47.99.58.100:9231/web/toLogin", "1-year");
        System.out.println(res);
    }

}
