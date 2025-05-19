package com.ipotensic.potensicpro.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.baselib.utils.compress.CompressHelper;
import com.ipotensic.baselib.utils.compress.FileUtil;
import com.ipotensic.baselib.views.badgeview.QBadgeView;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.ipotensic.potensicpro.R;
import com.ipotensic.potensicpro.view.HorizontalPhotosView;
import com.logan.user.presenter.UserRequestPresenter;
import com.logan.user.view.IFeedbackView;
import com.logan.user.view.IUnreadMsgView;
import java.io.File;
import java.util.Map;

/* loaded from: classes2.dex */
public class FeedbackActivity extends BaseActivity implements View.OnClickListener, IFeedbackView, HorizontalPhotosView.OnPhotoSelectedListener, IUnreadMsgView {
    private Button btnTellUs;
    private String content;
    private EditText editContent;
    private ImageView ivBadgeView;
    private ImageView ivRecord;
    private HorizontalPhotosView photosView;
    private QBadgeView qBadgeView;
    private Toolbar toolbar;
    private TextView tvBadgeNum;
    private TextView tvNumTips;
    private TextView tvUploadNum;
    private int uploadPicNum;
    private final int MODE_ABNORMAL_FEEDBACK = 10;
    private int curMode = 10;
    private final int FID = -1;

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStateBarShow(true);
        setContentView(R.layout.activity_feedback);
        this.tvNumTips = (TextView) findViewById(R.id.tv_num_tip);
        this.editContent = (EditText) findViewById(R.id.et_content);
        HorizontalPhotosView horizontalPhotosView = (HorizontalPhotosView) findViewById(R.id.recycler_view);
        this.photosView = horizontalPhotosView;
        horizontalPhotosView.bindActivity(this);
        this.photosView.setOnPhotoSelectedListener(this);
        Button button = (Button) findViewById(R.id.btn_tell_us);
        this.btnTellUs = button;
        button.setOnClickListener(this);
        this.tvUploadNum = (TextView) findViewById(R.id.tv_upload_num);
        this.editContent.addTextChangedListener(new MyTextWatcher());
        this.tvNumTips.setText(String.format("%d%s", 0, getResources().getString(R.string.fb_input_num_tip)));
        setToolBar();
        setOnClickListener();
    }

    private void setToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.toolbar = toolbar;
        toolbar.findViewById(R.id.iv_back).setOnClickListener(this);
        this.ivRecord = (ImageView) findViewById(R.id.iv_record);
        this.tvBadgeNum = (TextView) findViewById(R.id.tv_badge_num);
        this.ivBadgeView = (ImageView) findViewById(R.id.iv_badge_view);
        setSupportActionBar(this.toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayShowTitleEnabled(false);
        supportActionBar.setHomeButtonEnabled(false);
        supportActionBar.setDisplayHomeAsUpEnabled(false);
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        requestUnreadMessage();
    }

    public void requestUnreadMessage() {
        if (PhoneConfig.usrToken != null) {
            UserRequestPresenter.getInstance().getUnreadMessage(PhoneConfig.usrToken, this);
        }
    }

    private void setOnClickListener() {
        findViewById(R.id.tv_contact_us).setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.activities.FeedbackActivity.1
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                FeedbackActivity.this.startActivity(new Intent(FeedbackActivity.this, (Class<?>) CompanyContactActivity.class));
            }
        });
        this.ivBadgeView.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.activities.FeedbackActivity.2
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                FeedbackActivity.this.startActivity(new Intent(FeedbackActivity.this, (Class<?>) FeedbackDetailsActivity.class));
            }
        });
        this.ivRecord.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.activities.FeedbackActivity.3
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                FeedbackActivity.this.startActivity(new Intent(FeedbackActivity.this, (Class<?>) FeedbackDetailsActivity.class));
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_tell_us) {
            String str = this.content;
            if (str == null || TextUtils.isEmpty(str.trim()) || this.content.length() < 10) {
                return;
            }
            feedback(this.content);
            return;
        }
        if (id != R.id.iv_back) {
            return;
        }
        String obj = this.editContent.getText().toString();
        if (this.uploadPicNum > 0 || !TextUtils.isEmpty(obj)) {
            new GeneralDialog((Context) this, getString(R.string.exit_feedback), getString(R.string.exit_feedback_content), getString(R.string.dialog_cancel), getString(R.string.dialog_define), true, false, new GeneralDialog.DialogListener() { // from class: com.ipotensic.potensicpro.activities.FeedbackActivity.4
                @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.DialogListener
                public void cancel() {
                }

                @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.DialogListener
                public void confirm() {
                    FeedbackActivity.this.finish();
                }
            }).show();
        } else {
            finish();
        }
    }

    private void feedback(final String str) {
        if (PhoneConfig.usrToken != null) {
            showLoadingDialog();
            PhoneConfig.threadPool.execute(new Runnable() { // from class: com.ipotensic.potensicpro.activities.FeedbackActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    Map<Integer, HorizontalPhotosView.PicAndVideoBean> picAndVideoMap = FeedbackActivity.this.photosView.getPicAndVideoMap();
                    String[] strArr = new String[6];
                    String videoPath = FeedbackActivity.this.photosView.getVideoPath();
                    String str2 = null;
                    int i = -1;
                    for (int i2 = 0; i2 < picAndVideoMap.size(); i2++) {
                        HorizontalPhotosView.PicAndVideoBean picAndVideoBean = picAndVideoMap.get(Integer.valueOf(i2));
                        if (picAndVideoBean != null) {
                            if (picAndVideoBean.isVideo()) {
                                str2 = picAndVideoBean.getPath();
                                i = i2 + 1;
                            } else {
                                strArr[i2] = picAndVideoBean.getPath();
                            }
                        }
                    }
                    String[] strArr2 = new String[6];
                    for (int i3 = 0; i3 < 6; i3++) {
                        String str3 = strArr[i3];
                        if (str3 != null) {
                            File file = new File(str3);
                            if (file.exists()) {
                                File compressToFile = CompressHelper.getDefault(FeedbackActivity.this).compressToFile(file);
                                strArr2[i3] = compressToFile.getAbsolutePath();
                                DDLog.e(compressToFile.getAbsolutePath() + "（压缩前:" + FileUtil.getReadableFileSize(file.length()) + ",压缩后:" + FileUtil.getReadableFileSize(compressToFile.length()) + ")");
                            } else {
                                strArr2[i3] = null;
                            }
                        }
                    }
                    UserRequestPresenter.getInstance().feedback(PhoneConfig.usrToken, str, strArr2, FeedbackActivity.this, -1, videoPath, str2, i);
                }
            });
        }
    }

    @Override // com.ipotensic.potensicpro.view.HorizontalPhotosView.OnPhotoSelectedListener
    public void onSelectedPicNum(int i) {
        this.uploadPicNum = i;
        this.tvUploadNum.setText(String.format("%s%d%s", "(", Integer.valueOf(i), "/6)"));
    }

    @Override // com.logan.user.view.IUnreadMsgView
    public void getUnreadNum(int i) {
        this.ivBadgeView.setVisibility(i > 0 ? 0 : 8);
        this.tvBadgeNum.setVisibility((i > 99 || i <= 0) ? 8 : 0);
        if (i > 99) {
            this.ivBadgeView.setImageResource(R.mipmap.icon_badges_more);
            return;
        }
        if (i > 9) {
            this.ivBadgeView.setImageResource(R.mipmap.icon_badges_double);
            this.tvBadgeNum.setText(i + "");
        } else if (i > 0) {
            this.ivBadgeView.setImageResource(R.mipmap.icon_badges_single);
            this.tvBadgeNum.setText(i + "");
        }
    }

    class MyTextWatcher implements TextWatcher {
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        MyTextWatcher() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            FeedbackActivity.this.content = editable.toString();
            if (TextUtils.isEmpty(FeedbackActivity.this.content.trim())) {
                if (FeedbackActivity.this.content.length() >= 10) {
                    FeedbackActivity.this.btnTellUs.setBackgroundResource(R.mipmap.img_btn_tell_us_normal);
                }
                FeedbackActivity.this.runOnUiThread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.FeedbackActivity.MyTextWatcher.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FeedbackActivity.this.tvNumTips.setText(String.format("%d%s", 0, FeedbackActivity.this.getResources().getString(R.string.fb_input_num_tip)));
                    }
                });
            } else {
                if (FeedbackActivity.this.content.length() >= 10) {
                    FeedbackActivity.this.btnTellUs.setBackgroundResource(R.mipmap.img_btn_tell_us_selected);
                } else {
                    FeedbackActivity.this.btnTellUs.setBackgroundResource(R.mipmap.img_btn_tell_us_normal);
                }
                FeedbackActivity.this.runOnUiThread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.FeedbackActivity.MyTextWatcher.2
                    @Override // java.lang.Runnable
                    public void run() {
                        FeedbackActivity.this.tvNumTips.setText(String.format("%d%s", Integer.valueOf(FeedbackActivity.this.content.length()), FeedbackActivity.this.getResources().getString(R.string.fb_input_num_tip)));
                    }
                });
            }
        }
    }

    private void setDrawableLeft(TextView textView, Drawable drawable) {
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView.setCompoundDrawables(drawable, null, null, null);
        }
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        HorizontalPhotosView horizontalPhotosView = this.photosView;
        if (horizontalPhotosView != null) {
            horizontalPhotosView.onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        HorizontalPhotosView horizontalPhotosView = this.photosView;
        if (horizontalPhotosView != null) {
            horizontalPhotosView.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // com.logan.user.view.IFeedbackView
    public void onFeedbackSuccess() {
        dismissLoadingDialog();
        new GeneralDialog((Context) this, getString(R.string.dialog_success), getString(R.string.fb_commit_success), R.mipmap.img_dialog_upgrade_success, true, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.potensicpro.activities.FeedbackActivity.6
            @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
            public void confirm() {
                FeedbackActivity.this.finish();
            }
        }).show();
    }

    @Override // com.logan.user.view.IFeedbackView
    public void onFeedbackTokenError() {
        if (isFinishing()) {
            return;
        }
        dismissLoadingDialog();
    }

    @Override // com.logan.user.view.IFeedbackView
    public void onFeedbackFailed(String str) {
        if (isFinishing()) {
            return;
        }
        dismissLoadingDialog();
        new GeneralDialog((Context) this, getString(R.string.dialog_failure), getString(R.string.dialog_feedback_failure_describe), R.mipmap.img_dialog_failure, true, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.potensicpro.activities.FeedbackActivity.7
            @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
            public void confirm() {
            }
        }).show();
    }

    @Override // com.logan.user.view.IFeedbackView
    public void onFeedbackBeyondMaximum() {
        dismissLoadingDialog();
        ToastUtil.toast(this, getString(R.string.feedback_over_limit));
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        UserRequestPresenter.getInstance().removeUnreadMesView();
    }
}
