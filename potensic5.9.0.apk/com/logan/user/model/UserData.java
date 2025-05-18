package com.logan.user.model;

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
import com.logan.user.model.rev.RevUserLoginData;
import com.logan.user.model.rev.RevUserLogoutData;
import com.logan.user.model.rev.RevUserProductStatisticsData;
import com.logan.user.model.rev.RevUserRegisterData;
import com.logan.user.model.rev.RevUserSecurityTipsData;
import com.logan.user.model.rev.RevUserUnreadMessage;
import com.logan.user.model.rev.RevUserUpdateVersionData;
import com.logan.user.model.rev.RevUserUploadImageData;
import com.logan.user.model.send.SendAESData;
import com.logan.user.model.send.SendAppDumpLogData;
import com.logan.user.model.send.SendChangePwData;
import com.logan.user.model.send.SendEmailCodeData;
import com.logan.user.model.send.SendEvaluatingData;
import com.logan.user.model.send.SendFeedbackData;
import com.logan.user.model.send.SendFeedbackDeleteData;
import com.logan.user.model.send.SendFeedbackMarkData;
import com.logan.user.model.send.SendFlightLogData;
import com.logan.user.model.send.SendForgetData;
import com.logan.user.model.send.SendGetFeedbackData;
import com.logan.user.model.send.SendGetPdfData;
import com.logan.user.model.send.SendLoginData;
import com.logan.user.model.send.SendLogoutData;
import com.logan.user.model.send.SendProductInfoStatisticsData;
import com.logan.user.model.send.SendProductStatisticsData;
import com.logan.user.model.send.SendRegisterData;
import com.logan.user.model.send.SendSecurityTipsData;
import com.logan.user.model.send.SendShakeTestData;
import com.logan.user.model.send.SendTeachVideoData;
import com.logan.user.model.send.SendUnreadMessageData;
import com.logan.user.model.send.SendUpdateVersionData;
import com.logan.user.model.send.SendUploadImgData;
import com.logan.user.model.send.SendVersionData;

/* loaded from: classes3.dex */
public class UserData {
    private static volatile UserData instance;
    private SendAESData aESData;
    private SendAppDumpLogData appDumpLogData;
    private SendChangePwData changePwData;
    private SendFeedbackDeleteData deleteFbData;
    private SendEmailCodeData emailCodeData;
    private SendEvaluatingData evaluatingData;
    private SendFeedbackData feedbackData;
    private SendFlightLogData flightLogData;
    private SendForgetData forgetData;
    private SendGetFeedbackData getFeedbackData;
    private SendGetPdfData getPdfData;
    private SendLoginData loginData;
    private SendLogoutData logoutData;
    private SendFeedbackMarkData markFbData;
    private SendProductInfoStatisticsData productInfoStatisticsData;
    private SendProductStatisticsData productStatisticsData;
    private SendRegisterData registerData;
    private RevUserAppDumpLogData revAppDumpLogData;
    private RevUserAppVersionData revAppVersionData;
    private RevUserProductStatisticsData revProductStatisticsData;
    private RevUserChangePswData revUserChangePswData;
    private RevUserEmailCodeData revUserEmailCodeData;
    private RevUserEvaluatingData revUserEvaluatingData;
    private RevUserFbDeleteData revUserFbDeleteData;
    private RevUserFbMarkData revUserFbMarkData;
    private RevUserFeedbackData revUserFeedbackData;
    private RevUserFlightLogData revUserFlightLogData;
    private RevUserForgetData revUserForgetData;
    private RevUserGetFeedbackData revUserGetFeedbackData;
    private RevUserLoginData revUserLoginData;
    private RevUserLogoutData revUserLogoutData;
    private RevUserRegisterData revUserRegisterData;
    private RevUserSecurityTipsData revUserSecurityTipsData;
    private RevUserUnreadMessage revUserUnreadMessage;
    private RevUserUpdateVersionData revUserUpdateVersionData;
    private RevUserUploadImageData revUserUploadImageData;
    private SendSecurityTipsData sendSecurityTipsData;
    private SendShakeTestData shakeTestData;
    private SendTeachVideoData teachVideoData;
    private SendUnreadMessageData unreadMessageData;
    private SendUpdateVersionData updateVersionData;
    private SendUploadImgData uploadImgData;
    private SendVersionData versionData;

    private UserData() {
    }

    public static UserData getInstance() {
        if (instance == null) {
            synchronized (UserData.class) {
                if (instance == null) {
                    UserData userData = new UserData();
                    instance = userData;
                    return userData;
                }
            }
        }
        return instance;
    }

    public SendShakeTestData getShakeTestData() {
        if (this.shakeTestData == null) {
            this.shakeTestData = new SendShakeTestData();
        }
        return this.shakeTestData;
    }

    public SendUpdateVersionData getUpdateVersionData() {
        if (this.updateVersionData == null) {
            this.updateVersionData = new SendUpdateVersionData();
        }
        return this.updateVersionData;
    }

    public RevUserUpdateVersionData getRevUserUpdateVersionData() {
        if (this.revUserUpdateVersionData == null) {
            this.revUserUpdateVersionData = new RevUserUpdateVersionData();
        }
        return this.revUserUpdateVersionData;
    }

    public SendEmailCodeData getEmailCodeData() {
        if (this.emailCodeData == null) {
            this.emailCodeData = new SendEmailCodeData();
        }
        return this.emailCodeData;
    }

    public RevUserEmailCodeData getRevUserEmailCodeData() {
        if (this.revUserEmailCodeData == null) {
            this.revUserEmailCodeData = new RevUserEmailCodeData();
        }
        return this.revUserEmailCodeData;
    }

    public SendUnreadMessageData getUnreadMessageData() {
        if (this.unreadMessageData == null) {
            this.unreadMessageData = new SendUnreadMessageData();
        }
        return this.unreadMessageData;
    }

    public SendGetFeedbackData getGetFeedbackData() {
        if (this.getFeedbackData == null) {
            this.getFeedbackData = new SendGetFeedbackData();
        }
        return this.getFeedbackData;
    }

    public SendFeedbackDeleteData getDeleteFeedbackData() {
        if (this.deleteFbData == null) {
            this.deleteFbData = new SendFeedbackDeleteData();
        }
        return this.deleteFbData;
    }

    public SendFeedbackMarkData getMarkFeedbackData() {
        if (this.markFbData == null) {
            this.markFbData = new SendFeedbackMarkData();
        }
        return this.markFbData;
    }

    public SendProductStatisticsData getProductStatisticsData() {
        if (this.productStatisticsData == null) {
            this.productStatisticsData = new SendProductStatisticsData();
        }
        return this.productStatisticsData;
    }

    public SendProductInfoStatisticsData getProductInfoStatisticsData() {
        if (this.productInfoStatisticsData == null) {
            this.productInfoStatisticsData = new SendProductInfoStatisticsData();
        }
        return this.productInfoStatisticsData;
    }

    public RevUserProductStatisticsData getRevProductStatisticsData() {
        if (this.revProductStatisticsData == null) {
            this.revProductStatisticsData = new RevUserProductStatisticsData();
        }
        return this.revProductStatisticsData;
    }

    public SendAppDumpLogData getAppDumpLogData() {
        if (this.appDumpLogData == null) {
            this.appDumpLogData = new SendAppDumpLogData();
        }
        return this.appDumpLogData;
    }

    public RevUserAppDumpLogData getRevAppDumpLogData() {
        if (this.revAppDumpLogData == null) {
            this.revAppDumpLogData = new RevUserAppDumpLogData();
        }
        return this.revAppDumpLogData;
    }

    public SendFlightLogData getFlightLogData() {
        if (this.flightLogData == null) {
            this.flightLogData = new SendFlightLogData();
        }
        return this.flightLogData;
    }

    public SendRegisterData getRegisterData() {
        if (this.registerData == null) {
            this.registerData = new SendRegisterData();
        }
        return this.registerData;
    }

    public SendLoginData getLoginData() {
        if (this.loginData == null) {
            this.loginData = new SendLoginData();
        }
        return this.loginData;
    }

    public SendLogoutData getLogoutData() {
        if (this.logoutData == null) {
            this.logoutData = new SendLogoutData();
        }
        return this.logoutData;
    }

    public SendForgetData getForgetData() {
        if (this.forgetData == null) {
            this.forgetData = new SendForgetData();
        }
        return this.forgetData;
    }

    public SendUploadImgData getUploadImgData() {
        if (this.uploadImgData == null) {
            this.uploadImgData = new SendUploadImgData();
        }
        return this.uploadImgData;
    }

    public SendEvaluatingData getEvaluatingData() {
        if (this.evaluatingData == null) {
            this.evaluatingData = new SendEvaluatingData();
        }
        return this.evaluatingData;
    }

    public SendFeedbackData getFeedbackData() {
        if (this.feedbackData == null) {
            this.feedbackData = new SendFeedbackData();
        }
        return this.feedbackData;
    }

    public SendGetPdfData getPdfData() {
        if (this.getPdfData == null) {
            this.getPdfData = new SendGetPdfData();
        }
        return this.getPdfData;
    }

    public SendTeachVideoData getTeachVideoData() {
        if (this.teachVideoData == null) {
            this.teachVideoData = new SendTeachVideoData();
        }
        return this.teachVideoData;
    }

    public SendChangePwData getChangePwData() {
        if (this.changePwData == null) {
            this.changePwData = new SendChangePwData();
        }
        return this.changePwData;
    }

    public SendAESData getAESData() {
        if (this.aESData == null) {
            this.aESData = new SendAESData();
        }
        return this.aESData;
    }

    public SendVersionData getVersionData() {
        if (this.versionData == null) {
            this.versionData = new SendVersionData();
        }
        return this.versionData;
    }

    public RevUserEvaluatingData getRevUserEvaluatingData() {
        if (this.revUserEvaluatingData == null) {
            this.revUserEvaluatingData = new RevUserEvaluatingData();
        }
        return this.revUserEvaluatingData;
    }

    public RevUserFeedbackData getRevUserFeedbackData() {
        if (this.revUserFeedbackData == null) {
            this.revUserFeedbackData = new RevUserFeedbackData();
        }
        return this.revUserFeedbackData;
    }

    public RevUserRegisterData getRevUserRegisterData() {
        if (this.revUserRegisterData == null) {
            this.revUserRegisterData = new RevUserRegisterData();
        }
        return this.revUserRegisterData;
    }

    public RevUserLoginData getRevUserLoginData() {
        if (this.revUserLoginData == null) {
            this.revUserLoginData = new RevUserLoginData();
        }
        return this.revUserLoginData;
    }

    public RevUserLogoutData getRevUserLogoutData() {
        if (this.revUserLogoutData == null) {
            this.revUserLogoutData = new RevUserLogoutData();
        }
        return this.revUserLogoutData;
    }

    public RevUserForgetData getRevUserForgetData() {
        if (this.revUserForgetData == null) {
            this.revUserForgetData = new RevUserForgetData();
        }
        return this.revUserForgetData;
    }

    public RevUserUploadImageData getRevUserUploadImageData() {
        if (this.revUserUploadImageData == null) {
            this.revUserUploadImageData = new RevUserUploadImageData();
        }
        return this.revUserUploadImageData;
    }

    public RevUserChangePswData getRevUserChangePswData() {
        if (this.revUserChangePswData == null) {
            this.revUserChangePswData = new RevUserChangePswData();
        }
        return this.revUserChangePswData;
    }

    public RevUserFlightLogData getRevUserFlightLogData() {
        if (this.revUserFlightLogData == null) {
            this.revUserFlightLogData = new RevUserFlightLogData();
        }
        return this.revUserFlightLogData;
    }

    public RevUserAppVersionData getRevAppVersionData() {
        if (this.revAppVersionData == null) {
            this.revAppVersionData = new RevUserAppVersionData();
        }
        return this.revAppVersionData;
    }

    public RevUserFbDeleteData getRevUserFbDeleteData() {
        if (this.revUserFbDeleteData == null) {
            this.revUserFbDeleteData = new RevUserFbDeleteData();
        }
        return this.revUserFbDeleteData;
    }

    public RevUserFbMarkData getRevUserFbMarkData() {
        if (this.revUserFbMarkData == null) {
            this.revUserFbMarkData = new RevUserFbMarkData();
        }
        return this.revUserFbMarkData;
    }

    public RevUserGetFeedbackData getRevUserGetFeedbackData() {
        if (this.revUserGetFeedbackData == null) {
            this.revUserGetFeedbackData = new RevUserGetFeedbackData();
        }
        return this.revUserGetFeedbackData;
    }

    public RevUserUnreadMessage getRevUserUnreadMessage() {
        if (this.revUserUnreadMessage == null) {
            this.revUserUnreadMessage = new RevUserUnreadMessage();
        }
        return this.revUserUnreadMessage;
    }

    public SendSecurityTipsData getSendSecurityTipsData() {
        if (this.sendSecurityTipsData == null) {
            this.sendSecurityTipsData = new SendSecurityTipsData();
        }
        return this.sendSecurityTipsData;
    }

    public RevUserSecurityTipsData getRevUserSecurityTipsData() {
        if (this.revUserSecurityTipsData == null) {
            this.revUserSecurityTipsData = new RevUserSecurityTipsData();
        }
        return this.revUserSecurityTipsData;
    }
}