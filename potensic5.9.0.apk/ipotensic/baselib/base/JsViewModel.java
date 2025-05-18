package com.ipotensic.baselib.base;

import android.webkit.JavascriptInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.google.gson.Gson;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.bean.TitleBean;
import com.ipotensic.baselib.utils.SPHelper;
import java.net.URLDecoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: JsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000bH\u0007J\b\u0010\u000f\u001a\u00020\u000bH\u0007R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/ipotensic/baselib/base/JsViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "titleBeanData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/ipotensic/baselib/bean/TitleBean;", "getTitleBeanData", "()Landroidx/lifecycle/MutableLiveData;", "parseData", "", "json", "", "parseTitle", "showTips", "data", "webShowTips", "Companion", "BaseLib_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class JsViewModel extends ViewModel {
    private static final String FUNCTION = "function";
    public static final String GET_TITLE = "getTitle";
    public static final String GO_HOME = "goHome";
    public static final String INIT_TITLE = "initTitle";
    public static final String IS_SHOW = "isshow";
    private static final String PARAMS = "params";
    public static final String SHOW_LANGUAGE = "show_language";
    private static final String TAG = "JsViewModel";
    private final MutableLiveData<TitleBean> titleBeanData = new MutableLiveData<>();

    public final MutableLiveData<TitleBean> getTitleBeanData() {
        return this.titleBeanData;
    }

    public final void parseData(String json) {
        Intrinsics.checkParameterIsNotNull(json, "json");
        try {
            JSONObject jSONObject = new JSONObject(json);
            String optString = jSONObject.optString(FUNCTION);
            String optString2 = jSONObject.optString(PARAMS);
            if (optString != null && optString.hashCode() == -268142808 && optString.equals(INIT_TITLE)) {
                TitleBean titleBean = (TitleBean) new Gson().fromJson(optString2, TitleBean.class);
                titleBean.setTitleName(URLDecoder.decode(titleBean.getTitleName(), "UTF-8"));
                this.titleBeanData.setValue(titleBean);
                DDLog.d(TAG, titleBean.toString());
            }
        } catch (Exception e) {
            DDLog.d(TAG, "parseData error " + e);
        }
    }

    public final void parseTitle(String json) {
        Intrinsics.checkParameterIsNotNull(json, "json");
        try {
            this.titleBeanData.setValue((TitleBean) new Gson().fromJson(json, TitleBean.class));
        } catch (Exception unused) {
            this.titleBeanData.setValue(new TitleBean(null, null, null, null, 15, null));
        }
    }

    @JavascriptInterface
    public final void showTips(String data) {
        Intrinsics.checkParameterIsNotNull(data, "data");
        try {
            SPHelper.getInstance().putInt(SPHelper.KEY_WEB_SHOW_TIPS, new JSONObject(data).optInt(IS_SHOW));
        } catch (Exception e) {
            DDLog.e(TAG, "showTips error " + e);
        }
    }

    @JavascriptInterface
    public final String webShowTips() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(IS_SHOW, SPHelper.getInstance().getInt(SPHelper.KEY_WEB_SHOW_TIPS, 0));
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "jsonObject.toString()");
        return jSONObject2;
    }
}