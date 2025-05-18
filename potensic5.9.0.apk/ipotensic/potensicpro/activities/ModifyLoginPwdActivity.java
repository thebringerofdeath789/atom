package com.ipotensic.potensicpro.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.utils.FormatUtil;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.ipotensic.potensicpro.R;
import com.logan.user.presenter.UserRequestPresenter;
import com.logan.user.view.IChangePswView;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public class ModifyLoginPwdActivity extends BaseActivity implements View.OnClickListener, IChangePswView {
    private Button btnConfirm;
    private String confirmPwd;
    private EditText etConfirmPwd;
    private EditText etNewPwd;
    private EditText etOldPwd;
    private String newPwd;
    private String oldPwd;
    private TextView tvPwdErrorTips1;
    private TextView tvPwdErrorTips2;
    private TextView tvPwdErrorTips3;

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStateBarShow(true);
        setContentView(R.layout.activity_modify_login_pwd);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn_return).setOnClickListener(this);
        Button button = (Button) findViewById(R.id.btn_confirm);
        this.btnConfirm = button;
        button.setOnClickListener(this);
        this.etOldPwd = (EditText) findViewById(R.id.et_old_pwd);
        this.etNewPwd = (EditText) findViewById(R.id.et_new_pwd);
        this.etConfirmPwd = (EditText) findViewById(R.id.et_confirm_new_pwd);
        this.tvPwdErrorTips1 = (TextView) findViewById(R.id.tv_pwd_error_tips_1);
        this.tvPwdErrorTips2 = (TextView) findViewById(R.id.tv_pwd_error_tips_2);
        this.tvPwdErrorTips3 = (TextView) findViewById(R.id.tv_pwd_error_tips_3);
        this.etOldPwd.addTextChangedListener(new MyTextWatcher(this.etOldPwd.getId()));
        this.etNewPwd.addTextChangedListener(new MyTextWatcher(this.etNewPwd.getId()));
        this.etConfirmPwd.addTextChangedListener(new MyTextWatcher(this.etConfirmPwd.getId()));
    }

    public static void setEditTextInhibitInputSpaChat(EditText editText) {
        editText.setFilters(new InputFilter[]{new InputFilter() { // from class: com.ipotensic.potensicpro.activities.ModifyLoginPwdActivity.1
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                if (charSequence.equals(StringUtils.SPACE)) {
                    return "";
                }
                return null;
            }
        }});
        editText.setFilters(new InputFilter[]{new InputFilter() { // from class: com.ipotensic.potensicpro.activities.ModifyLoginPwdActivity.2
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                if (Pattern.compile("[`~!@#_$%^&*()+=|{}':;',\\[\\].<>/?~\uff01@#\uffe5%\u2026\u2026&*\uff08\uff09\u2014 +|{}\u3010\u3011\u2018\uff1b\uff1a\u201d\u201c\u2019\u3002\uff0c\u3001\uff1f]").matcher(charSequence.toString()).find()) {
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
            if (this.mViewId != ModifyLoginPwdActivity.this.etOldPwd.getId()) {
                if (this.mViewId != ModifyLoginPwdActivity.this.etNewPwd.getId()) {
                    if (this.mViewId == ModifyLoginPwdActivity.this.etConfirmPwd.getId()) {
                        ModifyLoginPwdActivity.this.confirmPwd = editable.toString().trim();
                        if (ModifyLoginPwdActivity.this.confirmPwd.length() > 0) {
                            ModifyLoginPwdActivity.this.etConfirmPwd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ModifyLoginPwdActivity.this.getResources().getDrawable(R.mipmap.img_icon_pwd_unlock), (Drawable) null);
                        } else {
                            ModifyLoginPwdActivity.this.etConfirmPwd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ModifyLoginPwdActivity.this.getResources().getDrawable(R.mipmap.img_icon_pwd_lock), (Drawable) null);
                        }
                        ModifyLoginPwdActivity.this.etConfirmPwd.post(new Runnable() { // from class: com.ipotensic.potensicpro.activities.ModifyLoginPwdActivity.MyTextWatcher.3
                            @Override // java.lang.Runnable
                            public void run() {
                                ModifyLoginPwdActivity.this.tvPwdErrorTips3.setVisibility(ModifyLoginPwdActivity.this.confirmPwd.length() >= 6 ? 8 : 0);
                            }
                        });
                    }
                } else {
                    ModifyLoginPwdActivity.this.newPwd = editable.toString().trim();
                    if (ModifyLoginPwdActivity.this.newPwd.length() > 0) {
                        ModifyLoginPwdActivity.this.etNewPwd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ModifyLoginPwdActivity.this.getResources().getDrawable(R.mipmap.img_icon_pwd_unlock), (Drawable) null);
                    } else {
                        ModifyLoginPwdActivity.this.etNewPwd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ModifyLoginPwdActivity.this.getResources().getDrawable(R.mipmap.img_icon_pwd_lock), (Drawable) null);
                    }
                    ModifyLoginPwdActivity.this.etNewPwd.post(new Runnable() { // from class: com.ipotensic.potensicpro.activities.ModifyLoginPwdActivity.MyTextWatcher.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ModifyLoginPwdActivity.this.tvPwdErrorTips2.setVisibility(ModifyLoginPwdActivity.this.newPwd.length() >= 6 ? 8 : 0);
                        }
                    });
                }
            } else {
                ModifyLoginPwdActivity.this.oldPwd = editable.toString().trim();
                if (ModifyLoginPwdActivity.this.oldPwd.length() > 0) {
                    ModifyLoginPwdActivity.this.etOldPwd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ModifyLoginPwdActivity.this.getResources().getDrawable(R.mipmap.img_icon_pwd_unlock), (Drawable) null);
                } else {
                    ModifyLoginPwdActivity.this.etOldPwd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ModifyLoginPwdActivity.this.getResources().getDrawable(R.mipmap.img_icon_pwd_lock), (Drawable) null);
                }
                ModifyLoginPwdActivity.this.etOldPwd.post(new Runnable() { // from class: com.ipotensic.potensicpro.activities.ModifyLoginPwdActivity.MyTextWatcher.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ModifyLoginPwdActivity.this.tvPwdErrorTips1.setVisibility(ModifyLoginPwdActivity.this.oldPwd.length() >= 6 ? 8 : 0);
                    }
                });
            }
            if (!FormatUtil.isTruePassword(ModifyLoginPwdActivity.this.oldPwd) || !FormatUtil.passwordLength(ModifyLoginPwdActivity.this.newPwd) || !FormatUtil.passwordLength(ModifyLoginPwdActivity.this.confirmPwd)) {
                ModifyLoginPwdActivity.this.btnConfirm.setEnabled(false);
                ModifyLoginPwdActivity.this.btnConfirm.setBackgroundResource(R.mipmap.img_btn_tell_us_normal);
            } else {
                ModifyLoginPwdActivity.this.btnConfirm.setBackgroundResource(R.mipmap.img_btn_tell_us_selected);
                ModifyLoginPwdActivity.this.btnConfirm.setEnabled(true);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_return) {
            finish();
            return;
        }
        if (id != R.id.btn_confirm || TextUtils.isEmpty(this.newPwd) || TextUtils.isEmpty(this.confirmPwd) || TextUtils.isEmpty(this.oldPwd)) {
            return;
        }
        if (this.newPwd.equals(this.oldPwd)) {
            ToastUtil.toast(this, getString(R.string.toast_not_same_new_psw));
            return;
        }
        if (!this.newPwd.equals(this.confirmPwd)) {
            ToastUtil.toast(this, getString(R.string.toast_not_same_psw));
            return;
        }
        if (!FormatUtil.passwordLength(this.oldPwd) || !FormatUtil.passwordLength(this.newPwd)) {
            ToastUtil.toast(this, getString(R.string.password_error_tips));
        } else if (PhoneConfig.usrToken != null) {
            showLoadingDialog();
            UserRequestPresenter.getInstance().changePassword(PhoneConfig.usrToken, this.oldPwd, this.newPwd, this);
        }
    }

    @Override // com.logan.user.view.IChangePswView
    public void onTokenError() {
        dismissLoadingDialog();
    }

    @Override // com.logan.user.view.IChangePswView
    public void onChangePswSuccess() {
        dismissLoadingDialog();
        PhoneConfig.usrToken = null;
        SPHelper.getInstance().clearToken();
        new GeneralDialog((Context) this, getString(R.string.dialog_success), getString(R.string.dialog_password_modify_success), R.mipmap.img_dialog_upgrade_success, true, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.potensicpro.activities.ModifyLoginPwdActivity.3
            @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
            public void confirm() {
                ModifyLoginPwdActivity.this.startActivity(new Intent(ModifyLoginPwdActivity.this, (Class<?>) LoginActivity.class));
            }
        }).show();
    }

    @Override // com.logan.user.view.IChangePswView
    public void onChangePswFailed(String str) {
        dismissLoadingDialog();
        new GeneralDialog((Context) this, getString(R.string.dialog_failure), getString(R.string.dialog_password_modify_failure), R.mipmap.img_dialog_failure, true, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.potensicpro.activities.ModifyLoginPwdActivity.4
            @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
            public void confirm() {
            }
        }).show();
    }
}