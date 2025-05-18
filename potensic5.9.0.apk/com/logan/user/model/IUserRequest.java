package com.logan.user.model;

import com.ipotensic.baselib.Token;
import com.ipotensic.baselib.okhttp.OnUploadProgressListener;
import java.io.File;

/* loaded from: classes3.dex */
public interface IUserRequest {
    void appDumpLog(Token token, File file);

    void changePassword(Token token, String str, String str2);

    void deleteFeedbackInfo(Token token, String str);

    void evaluating(Token token, String str);

    void feedback(Token token, String str, String[] strArr, int i, String str2, String str3, int i2);

    void flightLog(Token token, File file, String str, String str2);

    void flightLogs(Token token, String[] strArr, String str, String str2, OnUploadProgressListener onUploadProgressListener);

    void forgetPassword(String str);

    void getPdfList(Token token, String str);

    void getSecurityTips(Token token, String str);

    void getShakeTestValue(Token token);

    void getTeachVideo(Token token, String str);

    void getUnreadMessage(Token token);

    void getUpdateVersion(Token token, String str, String str2, String str3, String str4, String str5, String str6);

    void getUserFeedbackInfo(Token token, int i);

    void login(String str, String str2);

    void logout(Token token);

    void markFeedbackInfo(Token token, int i);

    void productInfoStatistics(Token token, String str, String str2, String str3, String str4, String str5, String str6, int i, String str7, String str8);

    void productStatistics(Token token, String str, String str2, String str3, String str4, String str5, int i, boolean z);

    void register(String str, String str2, String str3, String str4);

    void sendEmailCode(String str, int i);

    void uploadHeadImage(Token token, String str, String str2);

    void versionUpdate(Token token);
}