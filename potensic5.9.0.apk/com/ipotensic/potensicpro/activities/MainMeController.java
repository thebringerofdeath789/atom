package com.ipotensic.potensicpro.activities;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.alibaba.fastjson.JSONObject;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.listener.SimpleResultListener;
import com.ipotensic.baselib.okhttp.CallBackString;
import com.ipotensic.baselib.okhttp.OkHttpUtil;
import com.ipotensic.baselib.okhttp.PicassoLoader;
import com.ipotensic.baselib.permission.PermissionUtil;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.baselib.utils.UnitUtil;
import com.ipotensic.baselib.utils.aes.Base64Encoder;
import com.ipotensic.baselib.views.badgeview.QBadgeView;
import com.ipotensic.kernel.controllers.BaseController;
import com.ipotensic.kernel.services.LocationService;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.ipotensic.potensicpro.C2640R;
import com.ipotensic.potensicpro.view.CircleImageView;
import com.ipotensic.potensicpro.view.dialog.AppLogDialog;
import com.logan.user.model.UserConstants;
import com.logan.user.presenter.UserRequestPresenter;
import com.logan.user.view.ILogoutView;
import java.io.IOException;
import java.util.Iterator;
import me.yokeyword.indexablerv.countrys.CityEntity;

/* loaded from: classes2.dex */
public class MainMeController extends BaseController implements View.OnClickListener {
    public final int REQUEST_CODE_CANCEL_ACCOUNT;
    public final int REQUEST_CODE_CHANGE_HEAD_IMG;
    private BaseActivity activity;
    private CircleImageView headView;
    private boolean isFinish;
    private ImageView ivBadgeView;
    private QBadgeView qBadgeView;
    private TextView tvBadgeNum;
    private TextView tvDebug;
    private TextView tvNickName;
    private int unReadNum;

    public MainMeController(BaseActivity baseActivity, ViewStub viewStub) {
        super((AppCompatActivity) baseActivity, viewStub);
        this.REQUEST_CODE_CANCEL_ACCOUNT = 110;
        this.REQUEST_CODE_CHANGE_HEAD_IMG = 100;
        this.isFinish = false;
        this.unReadNum = 0;
        this.activity = baseActivity;
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        this.tvBadgeNum = (TextView) view.findViewById(C2640R.id.tv_badge_num);
        this.ivBadgeView = (ImageView) view.findViewById(C2640R.id.iv_badge_view);
        view.findViewById(C2640R.id.btn_logout).setOnClickListener(this);
        view.findViewById(C2640R.id.tv_reset_guidelines).setOnClickListener(this);
        view.findViewById(C2640R.id.btn_cancel_account).setOnClickListener(this);
        this.tvNickName = (TextView) view.findViewById(C2640R.id.tv_nick_name);
        this.tvDebug = (TextView) view.findViewById(C2640R.id.tv_debug);
        CircleImageView circleImageView = (CircleImageView) view.findViewById(C2640R.id.img_head);
        this.headView = circleImageView;
        circleImageView.setBorderColor(getContext().getResources().getColor(C2640R.color.color_full_white));
        this.headView.setBorderWidth(UnitUtil.dp2px(3));
        loadHeadImg(null);
        if (PhoneConfig.usrToken != null && PhoneConfig.usrToken.getLocation() != null) {
            TextView textView = (TextView) view.findViewById(C2640R.id.tv_position);
            String countryName = getCountryName(PhoneConfig.usrToken.getLocation());
            if (countryName == null) {
                countryName = PhoneConfig.usrToken.getCountryname();
            }
            textView.setText(countryName);
        }
        showNickName();
        showFeedbackMsg();
        setOnClickListener(view);
    }

    private void setOnClickListener(View view) {
        int i = 1000;
        this.tvNickName.setOnClickListener(new ScaleClickListener(i) { // from class: com.ipotensic.potensicpro.activities.MainMeController.1
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                MainMeController.this.tvNickName.setBackground(MainMeController.this.getContext().getDrawable(C2640R.drawable.bg_nick_name_selected));
                MainMeController.this.tvNickName.setSelected(true);
                MainMeController mainMeController = MainMeController.this;
                mainMeController.setStringToClip(mainMeController.tvNickName.getText().toString());
                ToastUtil.toast(MainMeController.this.getContext(), MainMeController.this.getContext().getString(C2640R.string.account_copy_successfully));
                new Handler().postDelayed(new Runnable() { // from class: com.ipotensic.potensicpro.activities.MainMeController.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MainMeController.this.tvNickName.setBackground(null);
                    }
                }, 1000L);
            }
        });
        this.headView.setOnClickListener(new ScaleClickListener(i) { // from class: com.ipotensic.potensicpro.activities.MainMeController.2
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                MainMeController.this.getContext().startActivityForResult(new Intent(MainMeController.this.getContext(), (Class<?>) NickNameActivity.class), 100);
            }
        });
        view.findViewById(C2640R.id.img_account_eidt).setOnClickListener(new ScaleClickListener(i) { // from class: com.ipotensic.potensicpro.activities.MainMeController.3
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                MainMeController.this.getContext().startActivityForResult(new Intent(MainMeController.this.getContext(), (Class<?>) NickNameActivity.class), 100);
            }
        });
        view.findViewById(C2640R.id.tv_feedback).setOnClickListener(new ScaleClickListener(i) { // from class: com.ipotensic.potensicpro.activities.MainMeController.4
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                MainMeController.this.getContext().startActivity(new Intent(MainMeController.this.getContext(), (Class<?>) FeedbackActivity.class));
            }
        });
        view.findViewById(C2640R.id.tv_user_agreement).setOnClickListener(new ScaleClickListener(i) { // from class: com.ipotensic.potensicpro.activities.MainMeController.5
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                MainMeController.this.getContext().startActivity(new Intent(MainMeController.this.getContext(), (Class<?>) UserAgreementActivity2.class));
            }
        });
        view.findViewById(C2640R.id.tv_modify_login_pwd).setOnClickListener(new ScaleClickListener(i) { // from class: com.ipotensic.potensicpro.activities.MainMeController.6
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                MainMeController.this.getContext().startActivity(new Intent(MainMeController.this.getContext(), (Class<?>) ModifyLoginPwdActivity.class));
            }
        });
        view.findViewById(C2640R.id.tv_find_my_drone).setOnClickListener(new ScaleClickListener(i) { // from class: com.ipotensic.potensicpro.activities.MainMeController.7
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                PermissionUtil.requestLocationPermissionAndGpsEnable((BaseActivity) MainMeController.this.getContext(), new SimpleResultListener<Boolean>() { // from class: com.ipotensic.potensicpro.activities.MainMeController.7.1
                    @Override // com.ipotensic.baselib.listener.SimpleResultListener
                    public void onResult(Boolean bool) {
                        if (bool.booleanValue()) {
                            LocationService.getInstance().init();
                            MainMeController.this.getContext().startActivity(new Intent(MainMeController.this.getContext(), (Class<?>) FindMyDroneActivity.class));
                        }
                    }
                });
            }
        });
        this.tvDebug.setOnClickListener(new ScaleClickListener(false) { // from class: com.ipotensic.potensicpro.activities.MainMeController.8
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                new AppLogDialog((BaseActivity) MainMeController.this.getContext()).show();
            }
        });
    }

    public void setUnReadNum(int i) {
        this.unReadNum = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStringToClip(String str) {
        ((ClipboardManager) getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Label", str));
    }

    public void showFeedbackMsg() {
        ImageView imageView;
        if (getBaseView() == null || getBaseView().getVisibility() != 0 || (imageView = this.ivBadgeView) == null || this.tvBadgeNum == null) {
            return;
        }
        imageView.setVisibility(this.unReadNum > 0 ? 0 : 8);
        TextView textView = this.tvBadgeNum;
        int i = this.unReadNum;
        textView.setVisibility((i > 99 || i <= 0) ? 8 : 0);
        int i2 = this.unReadNum;
        if (i2 > 99) {
            this.ivBadgeView.setImageResource(C2640R.mipmap.icon_badges_more);
            return;
        }
        if (i2 > 9) {
            this.ivBadgeView.setImageResource(C2640R.mipmap.icon_badges_double);
            this.tvBadgeNum.setText(this.unReadNum + "");
        } else if (i2 > 0) {
            this.ivBadgeView.setImageResource(C2640R.mipmap.icon_badges_single);
            this.tvBadgeNum.setText(this.unReadNum + "");
        }
    }

    private String getCountryName(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Iterator<CityEntity> it = CityEntity.getAll(this.activity).iterator();
            while (it.hasNext()) {
                CityEntity next = it.next();
                if (next.getCode() == Integer.parseInt(str)) {
                    return next.getName();
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private void showNickName() {
        TextView textView;
        if (PhoneConfig.usrToken == null || (textView = this.tvNickName) == null) {
            return;
        }
        textView.setText(PhoneConfig.usrToken.getEmail());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == C2640R.id.btn_cancel_account) {
            if (PhoneConfig.usrToken != null) {
                new GeneralDialog(this.activity, getContext().getString(C2640R.string.main_me_cancel_account_title), getContext().getString(C2640R.string.main_me_cancel_account_content), new GeneralDialog.DialogListener() { // from class: com.ipotensic.potensicpro.activities.MainMeController.11
                    @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.DialogListener
                    public void cancel() {
                    }

                    @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.DialogListener
                    public void confirm() {
                        if (PhoneConfig.usrToken != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(TtmlNode.ATTR_ID, (Object) Integer.valueOf(PhoneConfig.usrToken.getId()));
                            jSONObject.put("token", (Object) Base64Encoder.encode(PhoneConfig.usrToken.getToken()));
                            jSONObject.put("brandcode", (Object) 2);
                            OkHttpUtil.getInstance().postJson(110, UserConstants.URL_APP_CANCEL_ACCOUNT, jSONObject.toString(), new CallBackString<Integer>() { // from class: com.ipotensic.potensicpro.activities.MainMeController.11.1
                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // com.ipotensic.baselib.okhttp.CallBackString
                                public Integer onParseResponse(int i, String str) throws Exception {
                                    return Integer.valueOf(i == 110 ? JSONObject.parseObject(str).getIntValue("code") : -1);
                                }

                                @Override // com.ipotensic.baselib.okhttp.CallBackString
                                public void onResponse(int i, Integer num) {
                                    if (num.intValue() == 0) {
                                        MainMeController.this.activity.dismissLoadingDialog();
                                        PhoneConfig.usrToken = null;
                                        SPHelper.getInstance().clearToken();
                                        MainMeController.this.activity.startActivity(new Intent(MainMeController.this.getContext(), (Class<?>) LoginActivity.class));
                                        MainMeController.this.getContext().finish();
                                        return;
                                    }
                                    ToastUtil.toast(MainMeController.this.activity, MainMeController.this.activity.getString(C2640R.string.toast_no_network));
                                }

                                @Override // com.ipotensic.baselib.okhttp.CallBackString
                                public void onFailure(int i, Exception exc) {
                                    ToastUtil.toast(MainMeController.this.activity, MainMeController.this.activity.getString(C2640R.string.toast_no_network));
                                }
                            });
                        }
                    }
                }).show();
            }
        } else {
            if (id != C2640R.id.btn_logout) {
                if (id == C2640R.id.tv_reset_guidelines) {
                    new GeneralDialog(this.activity, getContext().getString(C2640R.string.dialog_reset_guidelines), getContext().getString(C2640R.string.dialog_reset_guidelines_describe), new GeneralDialog.DialogListener() { // from class: com.ipotensic.potensicpro.activities.MainMeController.10
                        @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.DialogListener
                        public void cancel() {
                        }

                        @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.DialogListener
                        public void confirm() {
                            SPHelper.getInstance().setAppFirstEnterMain(true);
                            SPHelper.getInstance().setTakeOff(true);
                            SPHelper.getInstance().setGoHome(true);
                            SPHelper.getInstance().setIntelligentMode(true);
                            SPHelper.getInstance().setCameraSetting(true);
                            SPHelper.getInstance().setAirborneGallery(true);
                            SPHelper.getInstance().setFirstEnterMap(true);
                            SPHelper.getInstance().setMainSetting(true);
                            SPHelper.getInstance().setGpsMode(true);
                            SPHelper.getInstance().setLockMode(true);
                            SPHelper.getInstance().setHeadMode(true);
                            SPHelper.getInstance().setHotCircleMode(true);
                            SPHelper.getInstance().setWaypointMode(true);
                            SPHelper.getInstance().setFollowMeMode(true);
                            SPHelper.getInstance().setRemoteControlMode(true);
                            SPHelper.getInstance().setEnterMapOfWaypoint(true);
                            SPHelper.getInstance().setSwitchStatus(true);
                            SPHelper.getInstance().setFirstFollowMe(true);
                            SPHelper.getInstance().setFirstPhotoOrVideo(true);
                            SPHelper.getInstance().setFirstHexahedralCalibration(true);
                            SPHelper.getInstance().setFirstEnterMain(true);
                            SPHelper.getInstance().setFirstOpenDownMenu(true);
                            SPHelper.getInstance().setFirstGuideCancelAction(true);
                            SPHelper.getInstance().setRthGuideVideoShown(false);
                            SPHelper.getInstance().putBoolean(SPHelper.KEY_FIRST_ENTER_ATOM_SETTINGS, true);
                            SPHelper.getInstance().putBoolean(SPHelper.KEY_ZOOM_SCALE, true);
                            SPHelper.getInstance().putBoolean(SPHelper.KEY_TIMED_PHOTOGRAPHY, true);
                            SPHelper.getInstance().setCircleTeachVideoPlayed(false);
                            SPHelper.getInstance().setScrewTeachVideoPlayed(false);
                            SPHelper.getInstance().setCometTeachVideoPlayed(false);
                            SPHelper.getInstance().setSkywardTeachVideoPlayed(false);
                            SPHelper.getInstance().setRecessTeachVideoPlayed(false);
                            SPHelper.getInstance().setFollowTeachVideoPlayed(false);
                            SPHelper.getInstance().putInt(SPHelper.KEY_WEB_SHOW_TIPS, 0);
                            SPHelper.getInstance().setSilentReturnGuide(true);
                            SPHelper.getInstance().putBoolean(SPHelper.KEY_ENTER_MAIN_SECOND, true);
                        }
                    }).show();
                    return;
                }
                throw new IllegalStateException("Unexpected value: " + view.getId());
            }
            if (PhoneConfig.usrToken != null) {
                new GeneralDialog(this.activity, getContext().getString(C2640R.string.dialog_confirm_out), getContext().getString(C2640R.string.dialog_confirm_out_describe), new GeneralDialog.DialogListener() { // from class: com.ipotensic.potensicpro.activities.MainMeController.9
                    @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.DialogListener
                    public void cancel() {
                    }

                    @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.DialogListener
                    public void confirm() {
                        MainMeController.this.activity.showLoadingDialog();
                        UserRequestPresenter.getInstance().logout(PhoneConfig.usrToken, new ILogoutView() { // from class: com.ipotensic.potensicpro.activities.MainMeController.9.1
                            @Override // com.logan.user.view.ILogoutView
                            public void onLogoutSuccess() {
                                MainMeController.this.activity.dismissLoadingDialog();
                                PhoneConfig.usrToken = null;
                                SPHelper.getInstance().clearToken();
                                MainMeController.this.activity.startActivity(new Intent(MainMeController.this.getContext(), (Class<?>) LoginActivity.class));
                                MainMeController.this.getContext().finish();
                            }

                            @Override // com.logan.user.view.ILogoutView
                            public void onLogoutFailed(String str) {
                                MainMeController.this.activity.dismissLoadingDialog();
                                ToastUtil.toast(MainMeController.this.activity, MainMeController.this.getContext().getString(C2640R.string.toast_exit_failure));
                            }
                        });
                    }
                }).show();
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 100 && intent != null) {
            loadHeadImg(intent.getStringExtra("img_path"));
        }
        showNickName();
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.kernel.utils.SimpleLifeCycle
    public void onDestroy() {
        this.isFinish = true;
        UserRequestPresenter.getInstance().removeLogoutView();
    }

    private void loadHeadImg(String str) {
        if (this.headView == null) {
            return;
        }
        try {
            if (str != null) {
                this.headView.setImageBitmap(BitmapFactory.decodeFile(LocalFileManager.getInstance().getHeadImageLocalPath()));
                return;
            }
            String headImageDescription = LocalFileManager.getInstance().getHeadImageDescription();
            if (PhoneConfig.usrToken != null && PhoneConfig.usrToken.getToken().equals(headImageDescription)) {
                this.headView.setImageBitmap(BitmapFactory.decodeFile(LocalFileManager.getInstance().getHeadImageLocalPath()));
            } else if (PhoneConfig.usrToken != null) {
                PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.potensicpro.activities.MainMeController.12
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            DDLog.m1687i("download head img:" + PhoneConfig.usrToken.getAvatar());
                            final Bitmap bitmap = PicassoLoader.with(MainMeController.this.getContext()).load(PhoneConfig.usrToken.getAvatar()).resize(250, 250).get();
                            if (bitmap != null) {
                                LocalFileManager.getInstance().saveHeaderBitmap(bitmap, PhoneConfig.usrToken.getToken());
                                if (MainMeController.this.isFinish) {
                                    return;
                                }
                                MainMeController.this.activity.runOnUiThread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.MainMeController.12.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        MainMeController.this.headView.setImageBitmap(bitmap);
                                    }
                                });
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onLoginLoadHeadImg() {
        try {
            String headImageDescription = LocalFileManager.getInstance().getHeadImageDescription();
            if (PhoneConfig.usrToken == null || PhoneConfig.usrToken.getToken().equals(headImageDescription)) {
                return;
            }
            PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.potensicpro.activities.MainMeController.13
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        DDLog.m1692w("LoginSuccess", "download head img:" + PhoneConfig.usrToken.getAvatar());
                        Bitmap bitmap = PicassoLoader.with(MainMeController.this.getContext()).load(PhoneConfig.usrToken.getAvatar()).resize(250, 250).get();
                        if (bitmap != null) {
                            LocalFileManager.getInstance().saveHeaderBitmap(bitmap, PhoneConfig.usrToken.getToken());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}