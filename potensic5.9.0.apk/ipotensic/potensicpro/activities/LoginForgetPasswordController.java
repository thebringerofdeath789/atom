package com.ipotensic.potensicpro.activities;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.ipotensic.baselib.utils.FormatUtil;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.controllers.BaseController;
import com.ipotensic.potensicpro.R;
import com.logan.user.presenter.UserRequestPresenter;
import com.logan.user.view.IForgetPwView;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public class LoginForgetPasswordController extends BaseController implements View.OnClickListener, IForgetPwView {
    private Button btnNext;
    private EditText edtForgetPassword;
    private String email;
    private OnForgetPasswordListener forgetPasswordListener;

    public interface OnForgetPasswordListener {
        void dismissLoadingDialog();

        void onBackClicked();

        void onForgetSuccess(String str);

        void showLoadingDialog();
    }

    public LoginForgetPasswordController(AppCompatActivity appCompatActivity, ViewStub viewStub) {
        super(appCompatActivity, viewStub);
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        view.findViewById(R.id.btn_return).setOnClickListener(this);
        Button button = (Button) view.findViewById(R.id.btn_next);
        this.btnNext = button;
        button.setOnClickListener(this);
        EditText editText = (EditText) view.findViewById(R.id.edt_forget_password);
        this.edtForgetPassword = editText;
        editText.addTextChangedListener(new MyTextWatcher(this.edtForgetPassword.getId()));
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
            if (FormatUtil.isEmail(editable.toString().trim())) {
                LoginForgetPasswordController.this.btnNext.setBackgroundResource(R.mipmap.img_btn_tell_us_selected);
            } else {
                LoginForgetPasswordController.this.btnNext.setBackgroundResource(R.mipmap.img_btn_tell_us_normal);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        OnForgetPasswordListener onForgetPasswordListener;
        int id = view.getId();
        if (id == R.id.btn_next) {
            forgetPw();
        } else if (id == R.id.btn_return && (onForgetPasswordListener = this.forgetPasswordListener) != null) {
            onForgetPasswordListener.onBackClicked();
        }
    }

    private void forgetPw() {
        String replace = this.edtForgetPassword.getText().toString().trim().replace(StringUtils.SPACE, "");
        if (!FormatUtil.isEmail(replace)) {
            ToastUtil.toast(getContext(), getContext().getString(R.string.toast_correct_email_address));
            return;
        }
        OnForgetPasswordListener onForgetPasswordListener = this.forgetPasswordListener;
        if (onForgetPasswordListener != null) {
            onForgetPasswordListener.showLoadingDialog();
        }
        UserRequestPresenter.getInstance().forgetPw(replace, this);
        this.email = replace;
    }

    public void setOnForgetPasswordListener(OnForgetPasswordListener onForgetPasswordListener) {
        this.forgetPasswordListener = onForgetPasswordListener;
    }

    @Override // com.logan.user.view.IForgetPwView
    public void onForgetSuccess() {
        OnForgetPasswordListener onForgetPasswordListener = this.forgetPasswordListener;
        if (onForgetPasswordListener != null) {
            onForgetPasswordListener.dismissLoadingDialog();
            this.forgetPasswordListener.onForgetSuccess(this.email);
        }
    }

    @Override // com.logan.user.view.IForgetPwView
    public void onForgetTokenFail(String str) {
        ToastUtil.toast(getContext(), getContext().getString(R.string.toast_failed_forget_password));
        OnForgetPasswordListener onForgetPasswordListener = this.forgetPasswordListener;
        if (onForgetPasswordListener != null) {
            onForgetPasswordListener.dismissLoadingDialog();
        }
    }

    @Override // com.logan.user.view.IForgetPwView
    public void onForgetError(String str) {
        ToastUtil.toast(getContext(), getContext().getString(R.string.enter_email_tips));
        OnForgetPasswordListener onForgetPasswordListener = this.forgetPasswordListener;
        if (onForgetPasswordListener != null) {
            onForgetPasswordListener.dismissLoadingDialog();
        }
    }
}