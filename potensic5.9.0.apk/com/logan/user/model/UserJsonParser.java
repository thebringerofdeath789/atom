package com.logan.user.model;

import androidx.core.app.NotificationCompat;
import com.alibaba.fastjson.JSONObject;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.Token;
import com.logan.user.model.rev.RevShakeTestData;
import com.logan.user.model.rev.RevUserAppDumpLogData;
import com.logan.user.model.rev.RevUserAppVersionData;
import com.logan.user.model.rev.RevUserChangePswData;
import com.logan.user.model.rev.RevUserEmailCodeData;
import com.logan.user.model.rev.RevUserEvaluatingData;
import com.logan.user.model.rev.RevUserFbDeleteData;
import com.logan.user.model.rev.RevUserFbMarkData;
import com.logan.user.model.rev.RevUserFeedbackData;
import com.logan.user.model.rev.RevUserFlightLogData;
import com.logan.user.model.rev.RevUserForgetData;
import com.logan.user.model.rev.RevUserGetFeedbackData;
import com.logan.user.model.rev.RevUserGetPdfResult;
import com.logan.user.model.rev.RevUserGetTeachVideoResult;
import com.logan.user.model.rev.RevUserLoginData;
import com.logan.user.model.rev.RevUserLogoutData;
import com.logan.user.model.rev.RevUserProductStatisticsData;
import com.logan.user.model.rev.RevUserRegisterData;
import com.logan.user.model.rev.RevUserSecurityTipsData;
import com.logan.user.model.rev.RevUserUnreadMessage;
import com.logan.user.model.rev.RevUserUpdateVersionData;
import com.logan.user.model.rev.RevUserUploadImageData;

/* loaded from: classes3.dex */
public class UserJsonParser {
    public static RevUserRegisterData parseRegisterResult(String str) throws Exception {
        return UserData.getInstance().getRevUserRegisterData().init(JSONObject.parseObject(str).getIntValue("code"));
    }

    public static RevUserLoginData parseLoginResult(String str) throws Exception {
        String string;
        JSONObject parseObject = JSONObject.parseObject(str);
        int intValue = parseObject.getIntValue("code");
        return UserData.getInstance().getRevUserLoginData().init(intValue, (intValue != 1 || (string = parseObject.getString("data")) == null) ? null : (Token) JSONObject.parseObject(string, Token.class));
    }

    public static RevUserLogoutData parseLogoutResult(String str) throws Exception {
        return UserData.getInstance().getRevUserLogoutData().init(JSONObject.parseObject(str).getIntValue("code"));
    }

    public static RevUserForgetData parseForgetResult(String str) throws Exception {
        return UserData.getInstance().getRevUserForgetData().init(JSONObject.parseObject(str).getIntValue("code"));
    }

    public static RevUserUploadImageData parseUploadImageResult(String str) throws Exception {
        return UserData.getInstance().getRevUserUploadImageData().init(JSONObject.parseObject(str).getIntValue("code"));
    }

    public static RevUserEvaluatingData parseEvaluatingResult(String str) throws Exception {
        return UserData.getInstance().getRevUserEvaluatingData().init(JSONObject.parseObject(str).getIntValue("code"));
    }

    public static RevUserFeedbackData parseFeedbackResult(String str) throws Exception {
        return UserData.getInstance().getRevUserFeedbackData().init(JSONObject.parseObject(str).getIntValue("code"));
    }

    public static RevUserChangePswData parseChangePswResult(String str) throws Exception {
        return UserData.getInstance().getRevUserChangePswData().init(JSONObject.parseObject(str).getIntValue("code"));
    }

    public static RevUserGetPdfResult parseGetPdfResult(String str) throws Exception {
        return (RevUserGetPdfResult) JSONObject.parseObject(str, RevUserGetPdfResult.class);
    }

    public static RevUserGetTeachVideoResult parseTeachVideoResult(String str) throws Exception {
        DDLog.m1684e("parseTeachVideoResult");
        return (RevUserGetTeachVideoResult) JSONObject.parseObject(str, RevUserGetTeachVideoResult.class);
    }

    public static RevUserFlightLogData parseFlightLogResult(String str) {
        JSONObject parseObject = JSONObject.parseObject(str);
        int intValue = parseObject.getIntValue("code");
        String string = parseObject.getString(NotificationCompat.CATEGORY_MESSAGE);
        RevUserFlightLogData init = UserData.getInstance().getRevUserFlightLogData().init(intValue);
        init.setMsg(string);
        return init;
    }

    public static RevUserAppVersionData parseVersionResult(String str) {
        return (RevUserAppVersionData) JSONObject.parseObject(str, RevUserAppVersionData.class);
    }

    public static RevUserAppDumpLogData parseAppDumpLogResult(String str) {
        return UserData.getInstance().getRevAppDumpLogData().init(JSONObject.parseObject(str).getIntValue("code"));
    }

    public static RevUserProductStatisticsData parseProductStatisticsResult(String str) {
        return UserData.getInstance().getRevProductStatisticsData().init(JSONObject.parseObject(str).getIntValue("code"));
    }

    public static RevUserFbDeleteData parseFbDeleteResult(String str) {
        return UserData.getInstance().getRevUserFbDeleteData().init(JSONObject.parseObject(str).getIntValue("code"));
    }

    public static RevUserFbMarkData parseFbMarkResult(String str) {
        return UserData.getInstance().getRevUserFbMarkData().init(JSONObject.parseObject(str).getIntValue("code"));
    }

    public static RevUserGetFeedbackData parseGetFeedbackResult(String str) {
        return UserData.getInstance().getRevUserGetFeedbackData().parse(str);
    }

    public static RevUserUnreadMessage parseUnreadMessageResult(String str) {
        JSONObject parseObject = JSONObject.parseObject(str);
        int intValue = parseObject.getIntValue("code");
        return UserData.getInstance().getRevUserUnreadMessage().parse(intValue, intValue == 0 ? parseObject.getIntValue("num") : 0);
    }

    public static RevUserEmailCodeData parseUserEmailResult(String str) {
        return UserData.getInstance().getRevUserEmailCodeData().parse(JSONObject.parseObject(str).getIntValue("code"));
    }

    public static RevUserUpdateVersionData parseUserUpdateVersionResult(String str) {
        return UserData.getInstance().getRevUserUpdateVersionData().parse(JSONObject.parseObject(str).getIntValue("code"));
    }

    public static RevShakeTestData parseShakeTestValue(String str) {
        JSONObject parseObject = JSONObject.parseObject(str);
        int intValue = parseObject.getIntValue("code");
        float floatValue = parseObject.getJSONObject("data").getFloatValue("shake_id");
        RevShakeTestData revShakeTestData = new RevShakeTestData();
        revShakeTestData.parse(intValue, floatValue);
        return revShakeTestData;
    }

    public static RevUserSecurityTipsData parseSecurityTipsResult(String str) {
        return (RevUserSecurityTipsData) JSONObject.parseObject(str, RevUserSecurityTipsData.class);
    }
}