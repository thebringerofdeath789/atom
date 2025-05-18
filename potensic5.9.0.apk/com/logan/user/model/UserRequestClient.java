package com.logan.user.model;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.Token;
import com.ipotensic.baselib.okhttp.CallBackString;
import com.ipotensic.baselib.okhttp.OkHttpUtil;
import com.ipotensic.baselib.okhttp.OnUploadProgressListener;
import com.ipotensic.baselib.utils.aes.AESUtils;
import com.logan.user.model.rev.BaseUserRevData;
import com.logan.user.model.send.SendFpvFcLogsData;
import com.logan.user.model.send.SendGetPdfData;
import com.logan.user.model.send.SendTeachVideoData;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class UserRequestClient implements IUserRequest {
    private CallBackString<BaseUserRevData> callBackString = new CallBackString<BaseUserRevData>() { // from class: com.logan.user.model.UserRequestClient.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.ipotensic.baselib.okhttp.CallBackString
        public BaseUserRevData onParseResponse(int i, String str) throws Exception {
            switch (i) {
                case 10:
                    return UserJsonParser.parseRegisterResult(str);
                case 11:
                    return UserJsonParser.parseLoginResult(str);
                case 12:
                    return UserJsonParser.parseLogoutResult(str);
                case 13:
                    return UserJsonParser.parseEvaluatingResult(str);
                case 14:
                    return UserJsonParser.parseUploadImageResult(str);
                case 15:
                    return UserJsonParser.parseForgetResult(str);
                case 16:
                    return UserJsonParser.parseChangePswResult(str);
                case 17:
                    DDLog.m1691w("提交反馈结果feedback:" + str);
                    return UserJsonParser.parseFeedbackResult(str);
                case 18:
                    return UserJsonParser.parseGetPdfResult(str);
                case 19:
                    return UserJsonParser.parseTeachVideoResult(str);
                case 20:
                case 31:
                    DDLog.m1691w("response REQUEST_CODE_UPLOAD_FPV_FC_LOGS:" + str);
                    return UserJsonParser.parseFlightLogResult(str);
                case 21:
                    DDLog.m1691w("response REQUEST_CODE_APP_VERSION_UPDATE:" + str);
                    return UserJsonParser.parseVersionResult(str);
                case 22:
                    DDLog.m1691w("dumplog:" + str);
                    return UserJsonParser.parseAppDumpLogResult(str);
                case 23:
                    DDLog.m1684e("统计数据结果:" + str);
                    return UserJsonParser.parseProductStatisticsResult(str);
                case 24:
                    return UserJsonParser.parseFbDeleteResult(str);
                case 25:
                    DDLog.m1691w("feedback:" + str);
                    return UserJsonParser.parseFbMarkResult(str);
                case 26:
                    DDLog.m1691w("反馈feedback:" + str);
                    return UserJsonParser.parseGetFeedbackResult(str);
                case 27:
                    DDLog.m1691w("feedback:" + str);
                    return UserJsonParser.parseUnreadMessageResult(str);
                case 28:
                case 29:
                default:
                    return null;
                case 30:
                    DDLog.m1691w("updateVersion" + str);
                    return UserJsonParser.parseUserUpdateVersionResult(str);
                case 32:
                    DDLog.m1691w("shakeTest:" + str);
                    return UserJsonParser.parseShakeTestValue(str);
                case 33:
                    DDLog.m1691w("securityTips:" + str);
                    return UserJsonParser.parseSecurityTipsResult(str);
            }
        }

        @Override // com.ipotensic.baselib.okhttp.CallBackString
        public void onResponse(int i, BaseUserRevData baseUserRevData) {
            UserRequestClient.this.listener.onRequestSuccess(i, baseUserRevData);
        }

        @Override // com.ipotensic.baselib.okhttp.CallBackString
        public void onFailure(int i, Exception exc) {
            DDLog.m1692w("updateVersion", "请求吗：" + i + ", e: " + exc.getMessage());
            UserRequestClient.this.listener.onRequestFailed(i, exc);
            if (i == 17) {
                DDLog.m1691w("反馈失败 :" + exc.getMessage());
            }
        }
    };
    private RequestResponseListener listener;

    @Override // com.logan.user.model.IUserRequest
    public void sendEmailCode(String str, int i) {
    }

    public UserRequestClient(RequestResponseListener requestResponseListener) {
        this.listener = requestResponseListener;
    }

    @Override // com.logan.user.model.IUserRequest
    public void register(String str, String str2, String str3, String str4) {
        String jsonString = UserData.getInstance().getRegisterData().init(str, str2, str3, str4).getJsonString();
        DDLog.m1691w("json:" + jsonString);
        postJson(10, UserConstants.URL_REGISTER, UserData.getInstance().getAESData().init(AESUtils.encrypt(jsonString)).getJsonString());
    }

    @Override // com.logan.user.model.IUserRequest
    public void login(String str, String str2) {
        String jsonString = UserData.getInstance().getLoginData().init(str, str2).getJsonString();
        DDLog.m1691w("json:" + jsonString);
        String jsonString2 = UserData.getInstance().getAESData().init(AESUtils.encrypt(jsonString)).getJsonString();
        DDLog.m1685e("TAG", "encryptJson = " + jsonString2);
        postJson(11, UserConstants.URL_LOGIN, jsonString2);
    }

    @Override // com.logan.user.model.IUserRequest
    public void logout(Token token) {
        postJson(12, UserConstants.URL_LOGOUT, UserData.getInstance().getLogoutData().init(token).getJsonString());
    }

    @Override // com.logan.user.model.IUserRequest
    public void forgetPassword(String str) {
        postJson(15, UserConstants.URL_FORGET_PASSWORD, UserData.getInstance().getForgetData().init(str).getJsonString());
    }

    @Override // com.logan.user.model.IUserRequest
    public void uploadHeadImage(Token token, String str, String str2) {
        DDLog.m1684e("" + UserData.getInstance().getUploadImgData().init(token, str).toString());
        postJsonAndImage(14, UserConstants.URL_UPLOAD_HEAD_IMG, UserData.getInstance().getUploadImgData().init(token, str).getMapParams(), "img", str2);
    }

    @Override // com.logan.user.model.IUserRequest
    public void evaluating(Token token, String str) {
        postJson(13, UserConstants.URL_EVALUATING, UserData.getInstance().getEvaluatingData().init(token, str).getJsonString());
    }

    @Override // com.logan.user.model.IUserRequest
    public void getPdfList(Token token, String str) {
        SendGetPdfData init = UserData.getInstance().getPdfData().init(token, str);
        DDLog.m1684e("sendData:" + init.getJsonString());
        postJson(18, UserConstants.URL_GET_PDF, init.getJsonString());
    }

    @Override // com.logan.user.model.IUserRequest
    public void getTeachVideo(Token token, String str) {
        SendTeachVideoData init = UserData.getInstance().getTeachVideoData().init(token, str);
        DDLog.m1684e("sendData:" + init.getJsonString());
        postJson(19, UserConstants.URL_GET_TEACH_VIDEO, init.getJsonString());
    }

    @Override // com.logan.user.model.IUserRequest
    public void changePassword(Token token, String str, String str2) {
        postJson(16, UserConstants.URL_CHANGE_PASSWORD, UserData.getInstance().getAESData().init(AESUtils.encrypt(UserData.getInstance().getChangePwData().init(token, str, str2).getJsonString())).getJsonString());
    }

    @Override // com.logan.user.model.IUserRequest
    public void flightLog(Token token, File file, String str, String str2) {
        OkHttpUtil.getInstance().postFile(20, UserConstants.URL_FLIGHT_LOG, UserData.getInstance().getFlightLogData().init(token, file, str, str2).getMapParams(), "log", file.getAbsolutePath(), this.callBackString);
    }

    @Override // com.logan.user.model.IUserRequest
    public void flightLogs(Token token, String[] strArr, String str, String str2, OnUploadProgressListener onUploadProgressListener) {
        SendFpvFcLogsData sendFpvFcLogsData = new SendFpvFcLogsData();
        sendFpvFcLogsData.init(token, strArr, str, str2);
        postJsonAndProgressFiles(31, UserConstants.URL_FPV_FC_LOGS, sendFpvFcLogsData.getMapParams(), "log[]", strArr, onUploadProgressListener);
    }

    @Override // com.logan.user.model.IUserRequest
    public void versionUpdate(Token token) {
        String jsonString = UserData.getInstance().getVersionData().init(token).getJsonString();
        DDLog.m1684e("app升级 json:" + jsonString);
        postJson(21, UserConstants.URL_APP_VERSION_UPDATE, jsonString);
    }

    @Override // com.logan.user.model.IUserRequest
    public void appDumpLog(Token token, File file) {
        OkHttpUtil.getInstance().postFileSync(22, UserConstants.URL_APP_DUMP_LOG, UserData.getInstance().getAppDumpLogData().init(token, file).getMapParams(), "dumplog", file.getAbsolutePath(), this.callBackString);
    }

    @Override // com.logan.user.model.IUserRequest
    public void productStatistics(Token token, String str, String str2, String str3, String str4, String str5, int i, boolean z) {
        String jsonString = UserData.getInstance().getProductStatisticsData().init(token, str, str2, str3, str4, str5, i, z).getJsonString();
        DDLog.m1685e("product", jsonString);
        postJson(23, UserConstants.URL_APP_PRODUCT_STATISTICS, jsonString);
    }

    @Override // com.logan.user.model.IUserRequest
    public void productInfoStatistics(Token token, String str, String str2, String str3, String str4, String str5, String str6, int i, String str7, String str8) {
        String jsonString = UserData.getInstance().getProductInfoStatisticsData().init(token, str, str2, str3, str4, str5, str6, i, str7, str8).getJsonString();
        DDLog.m1685e("productInfoStatistics", jsonString);
        postJson(34, UserConstants.URL_APP_PRODUCTINFO_STATISTICS, jsonString);
    }

    @Override // com.logan.user.model.IUserRequest
    public void feedback(Token token, String str, String[] strArr, int i, String str2, String str3, int i2) {
        DDLog.m1684e("提交反馈");
        postJsonAndImageVideo(17, UserConstants.URL_FEEDBACK, UserData.getInstance().getFeedbackData().init(token, str, i, i2, str2).getMapParams(), "pic[]", str2, str3, strArr);
    }

    @Override // com.logan.user.model.IUserRequest
    public void getUserFeedbackInfo(Token token, int i) {
        String jsonString = UserData.getInstance().getGetFeedbackData().init(token, i).getJsonString();
        DDLog.m1685e("feedback", "获取反馈回复内容：" + jsonString);
        postJson(26, UserConstants.URL_GET_FEEDBACK_INFO, jsonString);
    }

    @Override // com.logan.user.model.IUserRequest
    public void deleteFeedbackInfo(Token token, String str) {
        String jsonString = UserData.getInstance().getDeleteFeedbackData().init(token, str).getJsonString();
        DDLog.m1685e("feedback", "删除消息：" + jsonString);
        postJson(24, UserConstants.URL_DELETE_INFO_FB, jsonString);
    }

    @Override // com.logan.user.model.IUserRequest
    public void markFeedbackInfo(Token token, int i) {
        String jsonString = UserData.getInstance().getMarkFeedbackData().init(token, i).getJsonString();
        DDLog.m1685e("feedback", "已读消息：" + jsonString);
        postJson(25, UserConstants.URL_MARK_INFO_FB, jsonString);
    }

    @Override // com.logan.user.model.IUserRequest
    public void getUnreadMessage(Token token) {
        String jsonString = UserData.getInstance().getUnreadMessageData().init(token).getJsonString();
        DDLog.m1685e("feedback", "未读消息：" + jsonString);
        postJson(27, UserConstants.URL_UNREAD_MESSAGE, jsonString);
    }

    @Override // com.logan.user.model.IUserRequest
    public void getUpdateVersion(Token token, String str, String str2, String str3, String str4, String str5, String str6) {
        String jsonString = UserData.getInstance().getUpdateVersionData().init(token, str, str2, str3, str4, str5, str6).getJsonString();
        DDLog.m1685e("updateVersion", "固件升级信息: " + jsonString);
        postJson(30, UserConstants.URL_SEND_UPDATE_VERSION, jsonString);
    }

    @Override // com.logan.user.model.IUserRequest
    public void getShakeTestValue(Token token) {
        postJson(32, UserConstants.URL_SHAKE_TEST, UserData.getInstance().getShakeTestData().init(token).getJsonString());
    }

    @Override // com.logan.user.model.IUserRequest
    public void getSecurityTips(Token token, String str) {
        String jsonString = UserData.getInstance().getSendSecurityTipsData().init(token, str).getJsonString();
        DDLog.m1685e("securityTips", "获取飞行安全提示信息：" + jsonString);
        postJson(33, UserConstants.URL_SECURITY_TIPS, jsonString);
    }

    private void postJson(int i, String str, String str2) {
        OkHttpUtil.getInstance().postJson(i, str, str2, this.callBackString);
    }

    private void postJsonAndFiles(int i, String str, HashMap<String, String> hashMap, String str2, String[] strArr) {
        OkHttpUtil.getInstance().postJsonAndFiles(i, str, hashMap, str2, strArr, this.callBackString);
    }

    private void postJsonAndProgressFiles(int i, String str, HashMap<String, String> hashMap, String str2, String[] strArr, OnUploadProgressListener onUploadProgressListener) {
        OkHttpUtil.getInstance().postUploadProgressFiles(i, str, hashMap, str2, strArr, this.callBackString, onUploadProgressListener);
    }

    private void postJsonAndImage(int i, String str, HashMap<String, String> hashMap, String str2, String str3) {
        OkHttpUtil.getInstance().postJsonAndFiles(i, str, hashMap, str2, new String[]{str3}, this.callBackString);
    }

    private void postJsonAndImageVideo(int i, String str, HashMap<String, String> hashMap, String str2, String str3, String str4, String... strArr) {
        OkHttpUtil.getInstance().postJsonAndImageVideo(i, str, hashMap, str2, str3, str4, strArr, this.callBackString);
    }
}