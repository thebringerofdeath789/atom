package com.logan.server.jhttp;

import com.baidu.location.BDLocation;
import com.logan.user.model.UserConstants;
import java.util.HashMap;
import java.util.Map;
import okhttp3.internal.http.StatusLine;
import org.apache.commons.net.nntp.NNTPReply;

/* loaded from: classes3.dex */
public class HttpStatus {
    public static Map<Integer, String> status;

    static {
        HashMap hashMap = new HashMap();
        status = hashMap;
        hashMap.put(100, "Continue");
        status.put(101, "Switching Protocols");
        status.put(200, "OK");
        status.put(201, "Created");
        status.put(202, "Accepted");
        status.put(203, "Non");
        status.put(204, "No Content");
        status.put(Integer.valueOf(NNTPReply.CLOSING_CONNECTION), "Reset Content");
        status.put(206, "Partial Content");
        status.put(300, "Multiple Choices");
        status.put(Integer.valueOf(UserConstants.REQUEST_CODE_DOWNLOAD_FW_FROM_SERVER), "Moved Permanently");
        status.put(Integer.valueOf(UserConstants.REQUEST_CODE_DOWNLOAD_PDF_FILE), "Found");
        status.put(Integer.valueOf(UserConstants.REQUEST_CODE_DOWNLOAD_FEEDBACK_VIDEO_FILE), "See Other");
        status.put(304, "Not Modified");
        status.put(305, "Use Proxy");
        status.put(306, "Unused");
        status.put(Integer.valueOf(StatusLine.HTTP_TEMP_REDIRECT), "Temporary Redirect");
        status.put(Integer.valueOf(NNTPReply.SERVICE_DISCONTINUED), "Bad Request");
        status.put(401, "Unauthorized");
        status.put(402, "Payment Required");
        status.put(403, "Forbidden");
        status.put(404, "Not Found");
        status.put(405, "Method Not Allowed");
        status.put(406, "Not Acceptable");
        status.put(407, "Proxy Authentication Required");
        status.put(408, "Request Time");
        status.put(409, "Conflict");
        status.put(410, "Gone");
        status.put(Integer.valueOf(NNTPReply.NO_SUCH_NEWSGROUP), "Length Required");
        status.put(Integer.valueOf(NNTPReply.NO_NEWSGROUP_SELECTED), "Precondition Failed");
        status.put(413, "Request Entity Too Large");
        status.put(414, "Request");
        status.put(415, "Unsupported Media Type");
        status.put(416, "Requested range not satisfiable");
        status.put(417, "Expectation Failed");
        status.put(500, "Internal Server Error");
        status.put(501, "Not Implemented");
        status.put(502, "Bad Gateway");
        status.put(503, "Service Unavailable");
        status.put(504, "Gateway Time");
        status.put(Integer.valueOf(BDLocation.TypeServerCheckKeyError), "HTTP Version not supported");
    }

    public static String getStatusMsg(int i) {
        if (status.containsKey(Integer.valueOf(i))) {
            return status.get(Integer.valueOf(i));
        }
        return status.get(500);
    }

    public static boolean statusSupported(int i) {
        return status.containsKey(Integer.valueOf(i));
    }
}
