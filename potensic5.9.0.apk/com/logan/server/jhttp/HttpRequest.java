package com.logan.server.jhttp;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class HttpRequest {
    private String body;
    private String header;
    private String method;
    private Matcher pathinfo;
    private String protocolVersion;
    private Map<String, List<String>> headerList = new HashMap();
    private Map<String, String> getQuery = new HashMap();
    private Map<String, String> postQuery = new HashMap();
    private String host = "127.0.0.1";
    private String path = InternalZipConstants.ZIP_FILE_SEPARATOR;
    private String url = InternalZipConstants.ZIP_FILE_SEPARATOR;
    private String getQueryText = "";

    public void setHeader(String str) {
        this.header = str;
        parseHeader();
    }

    public void setBody(String str) {
        this.body = str;
        if (this.method.equals("POST")) {
            parsePostQuery();
        }
    }

    private void parseHeader() {
        String[] split = this.header.split("\r\n");
        String[] split2 = split[0].split(StringUtils.SPACE);
        this.method = split2[0];
        this.url = split2[1];
        parseUrl();
        this.protocolVersion = split2[2];
        for (int i = 1; i < split.length; i++) {
            if (!split[i].equals("")) {
                String[] split3 = split[i].split(": ", 2);
                if (split3.length == 2) {
                    String str = split3[0];
                    String str2 = split3[1];
                    if (this.headerList.containsKey(str)) {
                        this.headerList.get(str).add(str2);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(str2);
                        this.headerList.put(str, arrayList);
                    }
                }
            }
        }
        if (this.headerList.containsKey("Host")) {
            this.host = this.headerList.get("Host").get(0);
        }
    }

    private void parseUrl() {
        int indexOf = this.url.indexOf("?");
        if (indexOf >= 0) {
            this.path = this.url.substring(0, indexOf);
            this.getQueryText = this.url.substring(indexOf + 1);
            parseGetQuery();
            return;
        }
        this.path = this.url;
    }

    private void parsePostQuery() {
        parseQuery(this.postQuery, this.body);
    }

    private void parseGetQuery() {
        parseQuery(this.getQuery, this.getQueryText);
    }

    private void parseQuery(Map<String, String> map, String str) {
        for (String str2 : str.split("&")) {
            String[] split = str2.split("=", 2);
            if (split.length == 2) {
                try {
                    split[0] = URLDecoder.decode(split[0], "UTF-8");
                    split[1] = URLDecoder.decode(split[1], "UTF-8");
                    map.put(split[0], split[1]);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getMethod() {
        return this.method;
    }

    public String getPath() {
        return this.path;
    }

    public String getUrl() {
        return this.url;
    }

    public String getHost() {
        return this.host;
    }

    public String getProtocolVersion() {
        return this.protocolVersion;
    }

    public Map<String, List<String>> headers() {
        return this.headerList;
    }

    public Map<String, String> gets() {
        return this.getQuery;
    }

    public Map<String, String> posts() {
        return this.postQuery;
    }

    public List<String> header(String str) {
        if (this.headerList.containsKey(str)) {
            return this.headerList.get(str);
        }
        return null;
    }

    public String get(String str, String str2) {
        return this.getQuery.containsKey(str) ? this.getQuery.get(str) : str2;
    }

    public String post(String str, String str2) {
        return this.postQuery.containsKey(str) ? this.postQuery.get(str) : str2;
    }

    public void setPathinfo(Matcher matcher) {
        this.pathinfo = matcher;
    }

    public Matcher getPathinfo() {
        return this.pathinfo;
    }
}