package com.logan.user.presenter;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.Token;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.okhttp.OnUploadProgressListener;
import com.ipotensic.baselib.utils.SPHelper;
import com.logan.user.model.IUserRequest;
import com.logan.user.model.RequestResponseListener;
import com.logan.user.model.UserRequestClient;
import com.logan.user.model.rev.BaseUserRevData;
import com.logan.user.model.rev.RevShakeTestData;
import com.logan.user.model.rev.RevUserAppDumpLogData;
import com.logan.user.model.rev.RevUserAppVersionData;
import com.logan.user.model.rev.RevUserChangePswData;
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
import com.logan.user.model.rev.RevUserUploadImageData;
import com.logan.user.view.IAppDumpLog;
import com.logan.user.view.IChangePswView;
import com.logan.user.view.IEvaluatingView;
import com.logan.user.view.IFbCommitResultView;
import com.logan.user.view.IFeedbackDeleteView;
import com.logan.user.view.IFeedbackMarkView;
import com.logan.user.view.IFeedbackView;
import com.logan.user.view.IFlightLogView;
import com.logan.user.view.IForgetPwView;
import com.logan.user.view.IGetPdfView;
import com.logan.user.view.IGetTeachVideoView;
import com.logan.user.view.ILoginView;
import com.logan.user.view.ILogoutView;
import com.logan.user.view.IRegisterView;
import com.logan.user.view.ISecurityTipsView;
import com.logan.user.view.IShakeTestView;
import com.logan.user.view.IUnreadMsgView;
import com.logan.user.view.IUploadHeadImgView;
import com.logan.user.view.IVersionView;
import java.io.File;
import java.net.UnknownHostException;
import java.util.List;

/* loaded from: classes3.dex */
public class UserRequestPresenter {
    private static volatile UserRequestPresenter instance;
    private IAppDumpLog appDumpLog;
    private IChangePswView changePswView;
    private IEvaluatingView evaluatingView;
    private IFeedbackDeleteView feedbackDeleteView;
    private IFeedbackMarkView feedbackMarkView;
    private IFeedbackView feedbackView;
    private IFlightLogView flightLogView;
    private IForgetPwView forgetPwView;
    private IFlightLogView fpvFcLogsView;
    private IFbCommitResultView getFeedbackImp;
    private IGetPdfView getPdfView;
    private IGetTeachVideoView getTeachVideoView;
    private ILoginView loginView;
    private ILogoutView logoutView;
    private OnTokenErrorListener onTokenErrorListener;
    private IRegisterView registerView;
    private ISecurityTipsView securityTipsView;
    private IShakeTestView shakeTestView;
    private IUnreadMsgView unreadMsgView;
    private IUploadHeadImgView uploadHeadImgView;
    private IVersionView versionView;
    private RequestResponseListener requestResponseListener = new RequestResponseListener() { // from class: com.logan.user.presenter.UserRequestPresenter.1
        @Override // com.logan.user.model.RequestResponseListener
        public void onRequestSuccess(int i, BaseUserRevData baseUserRevData) {
            switch (i) {
                case 10:
                    RevUserRegisterData revUserRegisterData = (RevUserRegisterData) baseUserRevData;
                    if (UserRequestPresenter.this.registerView != null) {
                        int resultCode = revUserRegisterData.getResultCode();
                        if (resultCode == 0) {
                            UserRequestPresenter.this.registerView.onEmailNotExist();
                            break;
                        } else if (resultCode == 1) {
                            UserRequestPresenter.this.registerView.onRegisterSuccess();
                            break;
                        } else if (resultCode != 2) {
                            UserRequestPresenter.this.registerView.onRegisterError("");
                            break;
                        } else {
                            UserRequestPresenter.this.registerView.onEmailAlreadyUsed();
                            break;
                        }
                    }
                    break;
                case 11:
                    RevUserLoginData revUserLoginData = (RevUserLoginData) baseUserRevData;
                    Token token = revUserLoginData.getToken();
                    if (token != null) {
                        PhoneConfig.usrToken = token;
                        SPHelper.getInstance().setToken(token);
                    }
                    if (UserRequestPresenter.this.loginView != null) {
                        int resultCode2 = revUserLoginData.getResultCode();
                        if (resultCode2 == 0) {
                            UserRequestPresenter.this.loginView.onAccountOrPasswordError();
                            break;
                        } else if (resultCode2 == 1) {
                            UserRequestPresenter.this.loginView.onLoginSuccess();
                            break;
                        } else if (resultCode2 != 3) {
                            UserRequestPresenter.this.loginView.onLoginFailed("");
                            break;
                        } else {
                            UserRequestPresenter.this.loginView.unregistered();
                            break;
                        }
                    }
                    break;
                case 12:
                    RevUserLogoutData revUserLogoutData = (RevUserLogoutData) baseUserRevData;
                    if (UserRequestPresenter.this.logoutView != null) {
                        if (revUserLogoutData.getLogoutResultCode() == 1 || revUserLogoutData.getLogoutResultCode() == 0) {
                            UserRequestPresenter.this.logoutView.onLogoutSuccess();
                            break;
                        } else {
                            UserRequestPresenter.this.logoutView.onLogoutFailed("");
                            break;
                        }
                    }
                    break;
                case 13:
                    RevUserEvaluatingData revUserEvaluatingData = (RevUserEvaluatingData) baseUserRevData;
                    if (UserRequestPresenter.this.evaluatingView != null) {
                        if (revUserEvaluatingData.getEvaluatingResult() == 1) {
                            UserRequestPresenter.this.evaluatingView.onEvaluatingSuccess();
                            break;
                        } else if (revUserEvaluatingData.getEvaluatingResult() == 0) {
                            UserRequestPresenter.this.evaluatingView.onEvaluatingTokenError();
                            UserRequestPresenter.this.onTokenError();
                            break;
                        } else {
                            UserRequestPresenter.this.evaluatingView.onEvaluatingFailed("");
                            break;
                        }
                    }
                    break;
                case 14:
                    RevUserUploadImageData revUserUploadImageData = (RevUserUploadImageData) baseUserRevData;
                    if (UserRequestPresenter.this.uploadHeadImgView != null) {
                        if (revUserUploadImageData.getResultCode() == 1) {
                            UserRequestPresenter.this.uploadHeadImgView.onUploadSuccess();
                            break;
                        } else if (revUserUploadImageData.getResultCode() == 2) {
                            UserRequestPresenter.this.uploadHeadImgView.onTokenError();
                            UserRequestPresenter.this.onTokenError();
                            break;
                        } else {
                            UserRequestPresenter.this.uploadHeadImgView.onUploadFailed("");
                            break;
                        }
                    }
                    break;
                case 15:
                    RevUserForgetData revUserForgetData = (RevUserForgetData) baseUserRevData;
                    if (UserRequestPresenter.this.forgetPwView != null) {
                        if (revUserForgetData.getForgetResultCode() == 1) {
                            UserRequestPresenter.this.forgetPwView.onForgetSuccess();
                            break;
                        } else if (revUserForgetData.getForgetResultCode() == 0) {
                            UserRequestPresenter.this.forgetPwView.onForgetError("");
                            break;
                        } else if (revUserForgetData.getForgetResultCode() == 2) {
                            UserRequestPresenter.this.forgetPwView.onForgetTokenFail("");
                            break;
                        }
                    }
                    break;
                case 16:
                    RevUserChangePswData revUserChangePswData = (RevUserChangePswData) baseUserRevData;
                    if (UserRequestPresenter.this.changePswView != null && revUserChangePswData != null) {
                        int changePswResult = revUserChangePswData.getChangePswResult();
                        if (changePswResult == 0) {
                            UserRequestPresenter.this.changePswView.onTokenError();
                            UserRequestPresenter.this.onTokenError();
                            break;
                        } else if (changePswResult == 1) {
                            UserRequestPresenter.this.changePswView.onChangePswSuccess();
                            break;
                        } else if (changePswResult == 2) {
                            UserRequestPresenter.this.changePswView.onChangePswFailed("Old password error!");
                            break;
                        }
                    }
                    break;
                case 17:
                    RevUserFeedbackData revUserFeedbackData = (RevUserFeedbackData) baseUserRevData;
                    if (UserRequestPresenter.this.feedbackView != null) {
                        if (revUserFeedbackData.getFeedbackResult() == 0) {
                            UserRequestPresenter.this.feedbackView.onFeedbackSuccess();
                            break;
                        } else if (revUserFeedbackData.getFeedbackResult() == 2) {
                            UserRequestPresenter.this.feedbackView.onFeedbackTokenError();
                            UserRequestPresenter.this.onTokenError();
                            break;
                        } else if (revUserFeedbackData.getFeedbackResult() == 5) {
                            UserRequestPresenter.this.feedbackView.onFeedbackBeyondMaximum();
                            break;
                        } else {
                            UserRequestPresenter.this.feedbackView.onFeedbackFailed("");
                            break;
                        }
                    }
                    break;
                case 18:
                    RevUserGetPdfResult revUserGetPdfResult = (RevUserGetPdfResult) baseUserRevData;
                    if (revUserGetPdfResult != null && UserRequestPresenter.this.getPdfView != null) {
                        int code = revUserGetPdfResult.getCode();
                        if (code != 0) {
                            if (code != 1) {
                                if (code == 201 || code == 3) {
                                    UserRequestPresenter.this.getPdfView.onProductNotFind();
                                    break;
                                }
                            } else {
                                UserRequestPresenter.this.getPdfView.onGetPdfSuccess(revUserGetPdfResult.getDocuments());
                                break;
                            }
                        } else {
                            UserRequestPresenter.this.getPdfView.onTokenError();
                            UserRequestPresenter.this.onTokenError();
                            break;
                        }
                    }
                    break;
                case 19:
                    DDLog.w("解析成功 result");
                    RevUserGetTeachVideoResult revUserGetTeachVideoResult = (RevUserGetTeachVideoResult) baseUserRevData;
                    if (UserRequestPresenter.this.getTeachVideoView != null && revUserGetTeachVideoResult != null) {
                        int code2 = revUserGetTeachVideoResult.getCode();
                        if (code2 != 0) {
                            if (code2 != 1) {
                                if (code2 == 201 || code2 == 3) {
                                    UserRequestPresenter.this.getTeachVideoView.onProductNotFind();
                                    break;
                                }
                            } else {
                                UserRequestPresenter.this.getTeachVideoView.onGetTeachVideoSuccess(revUserGetTeachVideoResult.getDocuments());
                                break;
                            }
                        } else {
                            UserRequestPresenter.this.getTeachVideoView.onTokenError();
                            UserRequestPresenter.this.onTokenError();
                            break;
                        }
                    }
                    break;
                case 20:
                    RevUserFlightLogData revUserFlightLogData = (RevUserFlightLogData) baseUserRevData;
                    if (revUserFlightLogData != null && UserRequestPresenter.this.flightLogView != null) {
                        int flightLogResult = revUserFlightLogData.getFlightLogResult();
                        if (flightLogResult == 0) {
                            UserRequestPresenter.this.flightLogView.uploadSuccess();
                            break;
                        } else if (flightLogResult == 1) {
                            UserRequestPresenter.this.flightLogView.tokenError();
                            UserRequestPresenter.this.onTokenError();
                            break;
                        } else if (flightLogResult == 2) {
                            UserRequestPresenter.this.flightLogView.uploadError(new Exception(""));
                            break;
                        } else if (flightLogResult == 3) {
                            UserRequestPresenter.this.flightLogView.fileIsExist();
                            break;
                        } else if (flightLogResult == 4) {
                            UserRequestPresenter.this.flightLogView.notFrequentlyUpload();
                            break;
                        } else if (flightLogResult == 5) {
                            UserRequestPresenter.this.flightLogView.missFiles();
                            break;
                        }
                    }
                    break;
                case 21:
                    RevUserAppVersionData revUserAppVersionData = (RevUserAppVersionData) baseUserRevData;
                    if (UserRequestPresenter.this.versionView != null) {
                        int code3 = revUserAppVersionData.getCode();
                        if (code3 != 5) {
                            if (code3 == 0) {
                                UserRequestPresenter.this.versionView.needToUpdate(revUserAppVersionData.getData());
                                break;
                            }
                        } else {
                            UserRequestPresenter.this.onTokenError();
                            break;
                        }
                    }
                    break;
                case 22:
                    RevUserAppDumpLogData revUserAppDumpLogData = (RevUserAppDumpLogData) baseUserRevData;
                    if (UserRequestPresenter.this.appDumpLog != null) {
                        int uploadedResult = revUserAppDumpLogData.getUploadedResult();
                        if (uploadedResult == 0) {
                            UserRequestPresenter.this.appDumpLog.uploadedSuccess();
                            break;
                        } else if (uploadedResult == 1) {
                            UserRequestPresenter.this.appDumpLog.tokenError();
                            UserRequestPresenter.this.onTokenError();
                            break;
                        } else if (uploadedResult == 2) {
                            UserRequestPresenter.this.appDumpLog.uploadedFail();
                            break;
                        } else if (uploadedResult == 3) {
                            UserRequestPresenter.this.appDumpLog.fileIsExists();
                            break;
                        } else if (uploadedResult == 4) {
                            UserRequestPresenter.this.appDumpLog.uploadedFrequently();
                            break;
                        } else if (uploadedResult == 5) {
                            UserRequestPresenter.this.appDumpLog.missFiles();
                            break;
                        }
                    }
                    break;
                case 23:
                    int commitResult = ((RevUserProductStatisticsData) baseUserRevData).getCommitResult();
                    if (commitResult == 2) {
                        UserRequestPresenter.this.onTokenError();
                    }
                    DDLog.e("product", "提交结果：" + commitResult);
                    break;
                case 24:
                    int feedbackResult = ((RevUserFbDeleteData) baseUserRevData).getFeedbackResult();
                    DDLog.e("feedback", "删除反馈：" + feedbackResult);
                    if (UserRequestPresenter.this.feedbackDeleteView != null) {
                        if (feedbackResult == 0) {
                            UserRequestPresenter.this.feedbackDeleteView.deleteSuccess();
                            break;
                        } else if (feedbackResult == 1) {
                            UserRequestPresenter.this.feedbackDeleteView.deleteFail();
                            break;
                        } else if (feedbackResult == 2) {
                            UserRequestPresenter.this.onTokenError();
                            break;
                        }
                    }
                    break;
                case 25:
                    int feedbackResult2 = ((RevUserFbMarkData) baseUserRevData).getFeedbackResult();
                    if (UserRequestPresenter.this.feedbackMarkView != null) {
                        if (feedbackResult2 == 0) {
                            UserRequestPresenter.this.feedbackMarkView.markSuccess();
                        } else if (feedbackResult2 == 1) {
                            UserRequestPresenter.this.feedbackMarkView.markFail();
                        } else if (feedbackResult2 == 2) {
                            UserRequestPresenter.this.onTokenError();
                        }
                    }
                    DDLog.e("feedback", "标记已读：" + feedbackResult2);
                    break;
                case 26:
                    RevUserGetFeedbackData revUserGetFeedbackData = (RevUserGetFeedbackData) baseUserRevData;
                    int code4 = revUserGetFeedbackData.getCode();
                    List<RevUserGetFeedbackData.FeedbackInfo> list = revUserGetFeedbackData.getList();
                    if (UserRequestPresenter.this.getFeedbackImp != null) {
                        if (code4 == 0) {
                            UserRequestPresenter.this.getFeedbackImp.getFeedbackSuccess(list);
                            break;
                        } else if (code4 == 1) {
                            UserRequestPresenter.this.getFeedbackImp.getFailed();
                            break;
                        } else if (code4 == 2) {
                            UserRequestPresenter.this.onTokenError();
                            break;
                        }
                    }
                    break;
                case 27:
                    RevUserUnreadMessage revUserUnreadMessage = (RevUserUnreadMessage) baseUserRevData;
                    int unreadMsgResult = revUserUnreadMessage.getUnreadMsgResult();
                    if (UserRequestPresenter.this.unreadMsgView != null) {
                        if (unreadMsgResult == 0) {
                            UserRequestPresenter.this.unreadMsgView.getUnreadNum(revUserUnreadMessage.getUnreadNum());
                            break;
                        } else if (unreadMsgResult == 2) {
                            UserRequestPresenter.this.onTokenError();
                            break;
                        }
                    }
                    break;
                case 31:
                    RevUserFlightLogData revUserFlightLogData2 = (RevUserFlightLogData) baseUserRevData;
                    if (revUserFlightLogData2 != null && UserRequestPresenter.this.fpvFcLogsView != null) {
                        switch (revUserFlightLogData2.getFlightLogResult()) {
                            case 0:
                                UserRequestPresenter.this.fpvFcLogsView.uploadSuccess();
                                break;
                            case 1:
                                UserRequestPresenter.this.fpvFcLogsView.tokenError();
                                UserRequestPresenter.this.onTokenError();
                                break;
                            case 2:
                                UserRequestPresenter.this.fpvFcLogsView.uploadError(new Exception(""));
                                break;
                            case 3:
                                UserRequestPresenter.this.fpvFcLogsView.fileIsExist();
                                break;
                            case 4:
                                UserRequestPresenter.this.fpvFcLogsView.notFrequentlyUpload();
                                break;
                            case 5:
                                UserRequestPresenter.this.fpvFcLogsView.missFiles();
                                break;
                            case 6:
                                UserRequestPresenter.this.fpvFcLogsView.someFileMd5Err(revUserFlightLogData2.getMsg());
                                break;
                        }
                    }
                    break;
                case 32:
                    RevShakeTestData revShakeTestData = (RevShakeTestData) baseUserRevData;
                    if (revShakeTestData.getCode() == 0 && UserRequestPresenter.this.shakeTestView != null) {
                        UserRequestPresenter.this.shakeTestView.success(revShakeTestData.getShakeValue());
                        break;
                    }
                    break;
                case 33:
                    RevUserSecurityTipsData revUserSecurityTipsData = (RevUserSecurityTipsData) baseUserRevData;
                    if (revUserSecurityTipsData.getCode() == 0 && UserRequestPresenter.this.securityTipsView != null) {
                        UserRequestPresenter.this.securityTipsView.success(revUserSecurityTipsData.getData());
                        break;
                    }
                    break;
            }
        }

        @Override // com.logan.user.model.RequestResponseListener
        public void onRequestFailed(int i, Exception exc) {
            DDLog.e("请求失败:requestcode :" + i + ", 失败详情：" + exc.getMessage());
            if (exc instanceof UnknownHostException) {
                DDLog.e("网络", "网络不可用 ");
                if (PhoneConfig.runningActivity != null && i != 23 && i != 22 && i != 21 && i != 27 && i != 26 && i != 31 && i != 30 && i != 10 && i != 19 && i != 18 && i != 33 && i != 32) {
                    boolean z = PhoneConfig.isKernelActivityRunning;
                    PhoneConfig.runningActivity.dismissLoadingDialog();
                    return;
                }
            }
            if (i != 26) {
                switch (i) {
                    case 10:
                        if (UserRequestPresenter.this.registerView != null) {
                            UserRequestPresenter.this.registerView.onRegisterError(exc.getMessage());
                            break;
                        }
                        break;
                    case 11:
                        if (UserRequestPresenter.this.loginView != null) {
                            UserRequestPresenter.this.loginView.onLoginFailed(exc.getMessage());
                            break;
                        }
                        break;
                    case 12:
                        if (UserRequestPresenter.this.logoutView != null) {
                            UserRequestPresenter.this.logoutView.onLogoutFailed(exc.getMessage());
                            break;
                        }
                        break;
                    case 13:
                        if (UserRequestPresenter.this.evaluatingView != null) {
                            UserRequestPresenter.this.evaluatingView.onEvaluatingFailed(exc.getMessage());
                            break;
                        }
                        break;
                    case 14:
                        if (UserRequestPresenter.this.uploadHeadImgView != null) {
                            UserRequestPresenter.this.uploadHeadImgView.onUploadFailed(exc.getMessage());
                            break;
                        }
                        break;
                    case 15:
                        if (UserRequestPresenter.this.forgetPwView != null) {
                            UserRequestPresenter.this.forgetPwView.onForgetTokenFail(exc.getMessage());
                            break;
                        }
                        break;
                    case 16:
                        if (UserRequestPresenter.this.changePswView != null) {
                            UserRequestPresenter.this.changePswView.onChangePswFailed(exc.getMessage());
                            break;
                        }
                        break;
                    case 17:
                        if (UserRequestPresenter.this.feedbackView != null) {
                            UserRequestPresenter.this.feedbackView.onFeedbackFailed(exc.getMessage());
                            break;
                        }
                        break;
                    case 18:
                        if (UserRequestPresenter.this.getPdfView != null) {
                            UserRequestPresenter.this.getPdfView.onGetPdfFailed(exc.getMessage());
                            break;
                        }
                        break;
                    case 19:
                        if (UserRequestPresenter.this.getTeachVideoView != null) {
                            UserRequestPresenter.this.getTeachVideoView.onGetTeachVideoFailed(exc.getMessage());
                            break;
                        }
                        break;
                    case 20:
                        if (UserRequestPresenter.this.flightLogView != null) {
                            UserRequestPresenter.this.flightLogView.uploadError(exc);
                            break;
                        }
                        break;
                    case 21:
                        if (UserRequestPresenter.this.versionView != null) {
                            UserRequestPresenter.this.versionView.getInfoError();
                            break;
                        }
                        break;
                    default:
                        switch (i) {
                            case 31:
                                if (UserRequestPresenter.this.fpvFcLogsView != null) {
                                    UserRequestPresenter.this.fpvFcLogsView.uploadError(exc);
                                    break;
                                }
                                break;
                            case 32:
                                if (UserRequestPresenter.this.shakeTestView != null) {
                                    UserRequestPresenter.this.shakeTestView.fail(-1);
                                    break;
                                }
                                break;
                            case 33:
                                if (UserRequestPresenter.this.securityTipsView != null) {
                                    UserRequestPresenter.this.securityTipsView.fail(-1);
                                    break;
                                }
                                break;
                        }
                }
                return;
            }
            if (UserRequestPresenter.this.getFeedbackImp != null) {
                UserRequestPresenter.this.getFeedbackImp.getFailed();
            }
        }
    };
    private IUserRequest userRequest = new UserRequestClient(this.requestResponseListener);

    public interface OnTokenErrorListener {
        void onTokenError();
    }

    private UserRequestPresenter() {
    }

    public static UserRequestPresenter getInstance() {
        if (instance == null) {
            synchronized (UserRequestPresenter.class) {
                if (instance == null) {
                    UserRequestPresenter userRequestPresenter = new UserRequestPresenter();
                    instance = userRequestPresenter;
                    return userRequestPresenter;
                }
            }
        }
        return instance;
    }

    public void register(String str, String str2, String str3, String str4, IRegisterView iRegisterView) {
        this.registerView = iRegisterView;
        this.userRequest.register(str, str2, str3, str4);
    }

    public void login(String str, String str2, ILoginView iLoginView) {
        this.loginView = iLoginView;
        this.userRequest.login(str, str2);
    }

    public void logout(Token token, ILogoutView iLogoutView) {
        this.logoutView = iLogoutView;
        this.userRequest.logout(token);
    }

    public void removeLoginView() {
        this.loginView = null;
    }

    public void removeLogoutView() {
        this.logoutView = null;
    }

    public void forgetPw(String str, IForgetPwView iForgetPwView) {
        this.forgetPwView = iForgetPwView;
        this.userRequest.forgetPassword(str);
    }

    public void uploadHeadImage(Token token, String str, String str2, IUploadHeadImgView iUploadHeadImgView) {
        this.uploadHeadImgView = iUploadHeadImgView;
        this.userRequest.uploadHeadImage(token, str, str2);
    }

    public void evaluating(Token token, String str, IEvaluatingView iEvaluatingView) {
        this.evaluatingView = iEvaluatingView;
        this.userRequest.evaluating(token, str);
    }

    public void getShakeTestValue(Token token, IShakeTestView iShakeTestView) {
        this.shakeTestView = iShakeTestView;
        this.userRequest.getShakeTestValue(token);
    }

    public void getPdfList(Token token, String str, IGetPdfView iGetPdfView) {
        this.getPdfView = iGetPdfView;
        this.userRequest.getPdfList(token, str);
    }

    public void getTeachVideo(Token token, String str, IGetTeachVideoView iGetTeachVideoView) {
        this.getTeachVideoView = iGetTeachVideoView;
        this.userRequest.getTeachVideo(token, str);
    }

    public void changePassword(Token token, String str, String str2, IChangePswView iChangePswView) {
        this.changePswView = iChangePswView;
        this.userRequest.changePassword(token, str, str2);
    }

    public void flightLog(Token token, File file, String str, String str2, IFlightLogView iFlightLogView) {
        this.flightLogView = iFlightLogView;
        this.userRequest.flightLog(token, file, str, str2);
    }

    public void flightLogs(Token token, String[] strArr, String str, String str2, IFlightLogView iFlightLogView, OnUploadProgressListener onUploadProgressListener) {
        this.fpvFcLogsView = iFlightLogView;
        this.userRequest.flightLogs(token, strArr, str, str2, onUploadProgressListener);
    }

    public void checkAppVersionUpdate(Token token, IVersionView iVersionView) {
        this.versionView = iVersionView;
        this.userRequest.versionUpdate(token);
    }

    public void removeVersionView() {
        this.versionView = null;
    }

    public void appDumpLog(Token token, File file, IAppDumpLog iAppDumpLog) {
        this.appDumpLog = iAppDumpLog;
        this.userRequest.appDumpLog(token, file);
    }

    public void productStatistics(Token token, String str, String str2, String str3, String str4, String str5, int i, boolean z) {
        this.userRequest.productStatistics(token, str, str2, str3, str4, str5, i, z);
    }

    public void productInfoStatistics(Token token, String str, String str2, String str3, String str4, String str5, String str6, int i, String str7, String str8) {
        this.userRequest.productInfoStatistics(token, str, str2, str3, str4, str5, str6, i, str7, str8);
    }

    public void feedback(Token token, String str, String[] strArr, IFeedbackView iFeedbackView, int i, String str2, String str3, int i2) {
        this.feedbackView = iFeedbackView;
        this.userRequest.feedback(token, str, strArr, i, str2, str3, i2);
    }

    public void getUserFeedbackInfo(Token token, int i, IFbCommitResultView iFbCommitResultView) {
        this.getFeedbackImp = iFbCommitResultView;
        this.userRequest.getUserFeedbackInfo(token, i);
    }

    public void removeUserFeedbackImp() {
        this.getFeedbackImp = null;
    }

    public void deleteFeedbackInfo(Token token, String str, IFeedbackDeleteView iFeedbackDeleteView) {
        this.feedbackDeleteView = iFeedbackDeleteView;
        this.userRequest.deleteFeedbackInfo(token, str);
    }

    public void markFeedbackInfo(Token token, int i, IFeedbackMarkView iFeedbackMarkView) {
        this.feedbackMarkView = iFeedbackMarkView;
        this.userRequest.markFeedbackInfo(token, i);
    }

    public void getUnreadMessage(Token token, IUnreadMsgView iUnreadMsgView) {
        this.unreadMsgView = iUnreadMsgView;
        this.userRequest.getUnreadMessage(token);
    }

    public void removeUnreadMesView() {
        this.unreadMsgView = null;
    }

    public void getUpdateVersion(Token token, String str, String str2, String str3, String str4, String str5, String str6) {
        this.userRequest.getUpdateVersion(token, str, str2, str3, str4, str5, str6);
    }

    public void getSecurityTips(Token token, String str, ISecurityTipsView iSecurityTipsView) {
        this.securityTipsView = iSecurityTipsView;
        this.userRequest.getSecurityTips(token, str);
    }

    public void removeSecurityTipsView() {
        this.securityTipsView = null;
    }

    public void onTokenError() {
        OnTokenErrorListener onTokenErrorListener = this.onTokenErrorListener;
        if (onTokenErrorListener != null) {
            onTokenErrorListener.onTokenError();
        }
    }

    public void setOnTokenErrorListener(OnTokenErrorListener onTokenErrorListener) {
        this.onTokenErrorListener = onTokenErrorListener;
    }
}
