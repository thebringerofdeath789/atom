package com.ipotensic.kernel.manager;

import com.alibaba.fastjson.JSONObject;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.okhttp.CallBackUtil;
import com.ipotensic.baselib.okhttp.OkHttpUtil;
import com.ipotensic.baselib.okhttp.OnResultListener;
import com.ipotensic.baselib.utils.FormatUtil;
import com.logan.flight.data.FlightRevData;
import io.netty.handler.codec.rtsp.RtspHeaders;
import okhttp3.Call;
import okhttp3.Response;

/* loaded from: classes2.dex */
public class TestGpsProductionRequest {
    private static final String URL_GET_NEWEST_MODEL = "https://testshen.depstech.com/index.php/api/gps/dutdrone";
    private static final String URL_UPLOAD_MODEL = "https://testshen.depstech.com/index.php/api/gps/nicedrone";
    private static final String URL_UPLOAD_TEST = "https://testshen.depstech.com/index.php/api/gps/updutdrone";

    public static void uploadModelData(float f, float f2, int i, final OnResultListener<Boolean> onResultListener) {
        if (check()) {
            int id = PhoneConfig.usrToken.getId();
            String flightSN = FlightRevData.get().getFlightRevVersionData().getFlightSN();
            String curTime2 = FormatUtil.getCurTime2();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TtmlNode.ATTR_ID, (Object) Integer.valueOf(id));
            jSONObject.put("sn", (Object) flightSN);
            jSONObject.put("sacc_average", (Object) Float.valueOf(f));
            jSONObject.put("sacc_variance", (Object) Float.valueOf(f2));
            jSONObject.put("gps_num", (Object) Integer.valueOf(i));
            jSONObject.put(RtspHeaders.Values.TIME, (Object) curTime2);
            String jSONString = jSONObject.toJSONString();
            DDLog.m1684e("上传金机数据的json:" + jSONString);
            OkHttpUtil.getInstance().postJson(3000, URL_UPLOAD_MODEL, jSONString, new CallBackUtil<Integer>() { // from class: com.ipotensic.kernel.manager.TestGpsProductionRequest.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.ipotensic.baselib.okhttp.CallBackUtil
                public Integer onParseResponse(int i2, Call call, Response response) {
                    int i3;
                    try {
                        String string = response.body().string();
                        DDLog.m1684e("上传金机数据请求结果:" + string);
                        i3 = JSONObject.parseObject(string).getIntValue("result");
                    } catch (Exception e) {
                        DDLog.m1684e("上传金机数据解析出错:" + e.getMessage());
                        i3 = -1;
                    }
                    return Integer.valueOf(i3);
                }

                @Override // com.ipotensic.baselib.okhttp.CallBackUtil
                public void onResponse(int i2, Integer num) {
                    OnResultListener onResultListener2 = OnResultListener.this;
                    if (onResultListener2 != null) {
                        onResultListener2.onSuccess(Boolean.valueOf(num.intValue() == 0));
                    }
                }

                @Override // com.ipotensic.baselib.okhttp.CallBackUtil
                public void onFailure(int i2, Call call, Exception exc) {
                    DDLog.m1684e("上传金机数据失败:" + exc.getMessage());
                }
            });
        }
    }

    public static void getNewestModelData(final OnResultListener<NewestModelData> onResultListener) {
        if (check()) {
            int id = PhoneConfig.usrToken.getId();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TtmlNode.ATTR_ID, (Object) Integer.valueOf(id));
            String jSONString = jSONObject.toJSONString();
            DDLog.m1684e("获取最新金机数据的json:" + jSONString);
            OkHttpUtil.getInstance().postJson(3001, URL_GET_NEWEST_MODEL, jSONString, new CallBackUtil<NewestModelData>() { // from class: com.ipotensic.kernel.manager.TestGpsProductionRequest.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.ipotensic.baselib.okhttp.CallBackUtil
                public NewestModelData onParseResponse(int i, Call call, Response response) {
                    try {
                        String string = response.body().string();
                        DDLog.m1684e("获取最新金机数据请求结果:" + string);
                        return (NewestModelData) JSONObject.parseObject(string, NewestModelData.class);
                    } catch (Exception e) {
                        DDLog.m1684e("获取最新金机数据解析出错:" + e.getMessage());
                        return null;
                    }
                }

                @Override // com.ipotensic.baselib.okhttp.CallBackUtil
                public void onResponse(int i, NewestModelData newestModelData) {
                    OnResultListener onResultListener2 = OnResultListener.this;
                    if (onResultListener2 != null) {
                        onResultListener2.onSuccess(newestModelData);
                    }
                }

                @Override // com.ipotensic.baselib.okhttp.CallBackUtil
                public void onFailure(int i, Call call, Exception exc) {
                    DDLog.m1684e("获取最新金机数据失败:" + exc.getMessage());
                }
            });
        }
    }

    public static void uploadTestData(float f, float f2, int i, boolean z, final OnResultListener<Boolean> onResultListener) {
        if (check()) {
            int id = PhoneConfig.usrToken.getId();
            String flightSN = FlightRevData.get().getFlightRevVersionData().getFlightSN();
            String curTime2 = FormatUtil.getCurTime2();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TtmlNode.ATTR_ID, (Object) Integer.valueOf(id));
            jSONObject.put("sn", (Object) flightSN);
            jSONObject.put("sacc_average", (Object) Float.valueOf(f));
            jSONObject.put("sacc_variance", (Object) Float.valueOf(f2));
            jSONObject.put("gps_num", (Object) Integer.valueOf(i));
            jSONObject.put(RtspHeaders.Values.TIME, (Object) curTime2);
            if (z) {
                jSONObject.put("test_result", (Object) "pass");
            } else {
                jSONObject.put("test_result", (Object) "fail");
            }
            String jSONString = jSONObject.toJSONString();
            DDLog.m1684e("上传测试机数据的json:" + jSONString);
            OkHttpUtil.getInstance().postJson(3002, URL_UPLOAD_TEST, jSONString, new CallBackUtil<Integer>() { // from class: com.ipotensic.kernel.manager.TestGpsProductionRequest.3
                @Override // com.ipotensic.baselib.okhttp.CallBackUtil
                public void onFailure(int i2, Call call, Exception exc) {
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.ipotensic.baselib.okhttp.CallBackUtil
                public Integer onParseResponse(int i2, Call call, Response response) {
                    int i3;
                    try {
                        String string = response.body().string();
                        DDLog.m1684e("上传测试机数据请求结果:" + string);
                        i3 = JSONObject.parseObject(string).getIntValue("result");
                    } catch (Exception e) {
                        DDLog.m1684e("解析出错:" + e.getMessage());
                        i3 = -1;
                    }
                    return Integer.valueOf(i3);
                }

                @Override // com.ipotensic.baselib.okhttp.CallBackUtil
                public void onResponse(int i2, Integer num) {
                    OnResultListener onResultListener2 = OnResultListener.this;
                    if (onResultListener2 != null) {
                        onResultListener2.onSuccess(Boolean.valueOf(num.intValue() == 0));
                    }
                }
            });
        }
    }

    private static boolean check() {
        boolean z = PhoneConfig.usrToken != null;
        if (!z && FlightRevData.get().getFlightRevVersionData().getFlightSN() != null) {
            DDLog.m1684e("token或sn不完整");
        }
        return z;
    }

    public static class NewestModelData {
        private int gps_num;
        private int result;
        private float sacc_average;
        private float sacc_variance;

        /* renamed from: sn */
        private String f2214sn;
        private float standard_values;
        private String time;

        public int getResult() {
            return this.result;
        }

        public void setResult(int i) {
            this.result = i;
        }

        public String getSn() {
            return this.f2214sn;
        }

        public void setSn(String str) {
            this.f2214sn = str;
        }

        public float getSacc_average() {
            return this.sacc_average;
        }

        public void setSacc_average(float f) {
            this.sacc_average = f;
        }

        public float getSacc_variance() {
            return this.sacc_variance;
        }

        public void setSacc_variance(float f) {
            this.sacc_variance = f;
        }

        public int getGps_num() {
            return this.gps_num;
        }

        public void setGps_num(int i) {
            this.gps_num = i;
        }

        public String getTime() {
            return this.time;
        }

        public void setTime(String str) {
            this.time = str;
        }

        public float getStandard_values() {
            return this.standard_values;
        }

        public void setStandard_values(float f) {
            this.standard_values = f;
        }
    }
}