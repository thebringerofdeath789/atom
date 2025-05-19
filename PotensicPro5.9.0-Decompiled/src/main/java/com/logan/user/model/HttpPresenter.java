package com.logan.user.model;

import android.content.Context;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.okhttp.CallBackUtil;
import com.ipotensic.baselib.okhttp.OkHttpUtil;
import com.ipotensic.baselib.okhttp.OnResultListener;
import com.logan.user.model.send.SendDumpLogBean;
import java.io.File;
import okhttp3.Call;
import okhttp3.Response;

/* loaded from: classes3.dex */
public class HttpPresenter {
    private static final String BASE_URL = "http://appserver.depstech.com";
    private static final int REQUEST_CODE_GET_UID = 100;
    private static final int REQUEST_CODE_POST_BAD_STATE = 102;
    private static final int REQUEST_CODE_POST_DUMP = 101;
    private static final String URL_GET_UID = "http://appserver.depstech.com/index.php/api/phone/getuid";
    private static final String URL_POST_BAD_STATE = "http://appserver.depstech.com/index.php/api/phone/statistics";
    private static final String URL_POST_DUMP = "https://testshen.depstech.com/index.php/api/app/uploadappdumplog";
    private static HttpPresenter instance;

    private HttpPresenter() {
    }

    public static HttpPresenter getInstance() {
        if (instance == null) {
            synchronized (HttpPresenter.class) {
                if (instance == null) {
                    HttpPresenter httpPresenter = new HttpPresenter();
                    instance = httpPresenter;
                    return httpPresenter;
                }
            }
        }
        return instance;
    }

    public void postDumpFile(Context context, String str, final OnResultListener<String> onResultListener) {
        OkHttpUtil.getInstance().postJsonAndFile(101, URL_POST_DUMP, new SendDumpLogBean(str).getMap(), "dumplog", new File(str), new CallBackUtil<String>() { // from class: com.logan.user.model.HttpPresenter.1
            @Override // com.ipotensic.baselib.okhttp.CallBackUtil
            public void onResponse(int i, String str2) {
            }

            @Override // com.ipotensic.baselib.okhttp.CallBackUtil
            public String onParseResponse(int i, Call call, Response response) {
                try {
                    String string = response.body().string();
                    DDLog.e("上传日志文件：" + string);
                    if (string.contains("\"code\":\"0\"")) {
                        onResultListener.onSuccess(null);
                    }
                    return string;
                } catch (Exception e) {
                    onResultListener.onFailed(e);
                    return null;
                }
            }

            @Override // com.ipotensic.baselib.okhttp.CallBackUtil
            public void onFailure(int i, Call call, Exception exc) {
                DDLog.e("上传日志文件失败：" + exc.getMessage());
                onResultListener.onFailed(exc);
            }
        });
    }
}
