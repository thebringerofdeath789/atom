package com.ipotensic.potensicpro.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.ipotensic.potensicpro.R;
import com.logan.user.presenter.UserRequestPresenter;
import com.logan.user.view.IUploadHeadImgView;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public class UserPersonInfoActivity extends BaseActivity {
    private TextView btnConfirm;
    private EditText etNick;

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStateBarShow(true);
        setContentView(R.layout.activity_user_person_info);
        initView();
        SPHelper.getInstance().clearFlight();
    }

    private void initView() {
        findViewById(R.id.tv_skip).setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.activities.UserPersonInfoActivity.1
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                UserPersonInfoActivity userPersonInfoActivity = UserPersonInfoActivity.this;
                new GeneralDialog(userPersonInfoActivity, userPersonInfoActivity.getString(R.string.dialog_user_person_info_title), UserPersonInfoActivity.this.getString(R.string.dialog_user_person_info_message), 1, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.potensicpro.activities.UserPersonInfoActivity.1.1
                    @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                    public void confirm() {
                        UserPersonInfoActivity.this.startActivity(new Intent(UserPersonInfoActivity.this, (Class<?>) MainActivity.class));
                    }
                }).show();
            }
        });
        TextView textView = (TextView) findViewById(R.id.btn_confirm);
        this.btnConfirm = textView;
        textView.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.activities.UserPersonInfoActivity.2
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                String obj = UserPersonInfoActivity.this.etNick.getText().toString();
                if (TextUtils.isEmpty(obj)) {
                    return;
                }
                UserPersonInfoActivity.this.uploadHeadImg(null, obj);
            }
        });
        EditText editText = (EditText) findViewById(R.id.et_nick);
        this.etNick = editText;
        editText.addTextChangedListener(new MyTextWatcher(this.etNick.getId()));
    }

    public static void setEditTextInhibitInputSpaChat(EditText editText) {
        editText.setFilters(new InputFilter[]{new InputFilter() { // from class: com.ipotensic.potensicpro.activities.UserPersonInfoActivity.3
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                if (charSequence.equals(StringUtils.SPACE)) {
                    return "";
                }
                return null;
            }
        }});
        editText.setFilters(new InputFilter[]{new InputFilter() { // from class: com.ipotensic.potensicpro.activities.UserPersonInfoActivity.4
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                if (Pattern.compile("[`~!@#_$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）— +|{}【】‘；：”“’。，、？]").matcher(charSequence.toString()).find()) {
                    return "";
                }
                return null;
            }
        }});
    }

    class MyTextWatcher implements TextWatcher {
        int mViewId;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        MyTextWatcher(int i) {
            this.mViewId = i;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String trim = editable.toString().trim();
            if (trim.length() > 0) {
                UserPersonInfoActivity.this.etNick.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, UserPersonInfoActivity.this.getResources().getDrawable(R.mipmap.img_icon_nick_name_unlock), (Drawable) null);
                UserPersonInfoActivity.this.btnConfirm.setBackgroundResource(R.mipmap.img_btn_tell_us_selected);
            } else {
                UserPersonInfoActivity.this.etNick.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, UserPersonInfoActivity.this.getResources().getDrawable(R.mipmap.img_icon_nick_name_lock), (Drawable) null);
            }
            if (trim.length() > 22) {
                UserPersonInfoActivity.this.etNick.setText(trim.substring(0, 22));
                UserPersonInfoActivity.this.etNick.requestFocus();
                UserPersonInfoActivity.this.etNick.setSelection(UserPersonInfoActivity.this.etNick.getText().length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadHeadImg(Bitmap bitmap, final String str) {
        showLoadingDialog();
        UserRequestPresenter.getInstance().uploadHeadImage(PhoneConfig.usrToken, str, null, new IUploadHeadImgView() { // from class: com.ipotensic.potensicpro.activities.UserPersonInfoActivity.5
            @Override // com.logan.user.view.IUploadHeadImgView
            public void onUploadSuccess() {
                if (!TextUtils.isEmpty(str)) {
                    SPHelper.getInstance().setNickName(PhoneConfig.usrToken.getToken(), str);
                }
                UserPersonInfoActivity.this.dismissLoadingDialog();
                UserPersonInfoActivity.this.startActivity(new Intent(UserPersonInfoActivity.this, (Class<?>) MainActivity.class));
            }

            @Override // com.logan.user.view.IUploadHeadImgView
            public void onUploadFailed(String str2) {
                UserPersonInfoActivity.this.dismissLoadingDialog();
                UserPersonInfoActivity userPersonInfoActivity = UserPersonInfoActivity.this;
                new GeneralDialog(userPersonInfoActivity, userPersonInfoActivity.getString(R.string.dialog_user_failed_to_submit), UserPersonInfoActivity.this.getString(R.string.dialog_user_failed_to_submit_message), 1, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.potensicpro.activities.UserPersonInfoActivity.5.1
                    @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                    public void confirm() {
                        UserPersonInfoActivity.this.startActivity(new Intent(UserPersonInfoActivity.this, (Class<?>) MainActivity.class));
                    }
                }).show();
            }

            @Override // com.logan.user.view.IUploadHeadImgView
            public void onTokenError() {
                UserPersonInfoActivity.this.dismissLoadingDialog();
            }
        });
    }
}
