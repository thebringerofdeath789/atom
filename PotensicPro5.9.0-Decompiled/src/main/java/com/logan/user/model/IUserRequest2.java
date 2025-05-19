package com.logan.user.model;

import com.ipotensic.baselib.Token;
import java.io.File;

/* loaded from: classes3.dex */
public interface IUserRequest2 {
    void appDumpLog(Token token, File file);

    void changePassword(Token token, String str, String str2);

    void deleteFeedbackInfo(Token token, String str);

    void evaluating(Token token, String str);

    void feedback(Token token, String str, String[] strArr, int i, String str2, String str3, int i2);

    void flightLog(Token token, File file, String str, String str2);

    void forgetPassword(String str);

    void getPdfList(Token token, String str);

    void getTeachVideo(Token token, String str);

    void getUnreadMessage(Token token);

    void getUserFeedbackInfo(Token token, int i);

    void login(String str, String str2);

    void logout(Token token);

    void markFeedbackInfo(Token token, int i);

    void productStatistics(Token token, String str, String str2, String str3, String str4, String str5, int i);

    void register(String str, String str2, String str3, String str4, String str5);

    void sendEmailCode(String str, int i);

    void uploadHeadImage(Token token, String str, String str2);

    void versionUpdate(Token token);
}
