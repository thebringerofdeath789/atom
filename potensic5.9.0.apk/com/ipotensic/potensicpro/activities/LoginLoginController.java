package com.ipotensic.potensicpro.activities;

import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ipotensic.baselib.utils.FormatUtil;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.controllers.BaseController;
import com.ipotensic.potensicpro.C2640R;
import com.ipotensic.potensicpro.utils.KeyboardHelper;
import com.logan.user.presenter.UserRequestPresenter;
import com.logan.user.view.ILoginView;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public class LoginLoginController extends BaseController implements View.OnClickListener, ILoginView {
    private Button btnLogin;
    private ConstraintLayout clBottom;
    private int clBottomY;
    private ConstraintLayout clContent;
    private EditText editEmail;
    private int editEmailY;
    private EditText edtPw;
    private String email;
    private boolean isEmailFocus;
    private boolean isPWFocus;
    private KeyboardHelper keyboardHelper;
    private LoginControllerListener listener;
    private KeyboardHelper.OnKeyboardStatusChangeListener onKeyboardStatusChangeListener;
    private String password;
    private int titleHeight;
    private int titleY;
    private int translationY1;
    private int translationY2;
    private TextView tvEmailErrorTips;
    private TextView tvLogo;
    private TextView tvPasswordErrorTips;
    private TextView tvTitle;
    private int[] viewLocation;

    public interface LoginControllerListener {
        void dismissLoadingDialog();

        void onForgetPasswordClicked();

        void onLoginSuccess();

        void showLoadingDialog();

        void toRegisterPage();
    }

    public LoginLoginController(AppCompatActivity appCompatActivity, View view) {
        super(appCompatActivity, view);
        this.viewLocation = new int[2];
        this.onKeyboardStatusChangeListener = new KeyboardHelper.OnKeyboardStatusChangeListener() { // from class: com.ipotensic.potensicpro.activities.LoginLoginController.5
            @Override // com.ipotensic.potensicpro.utils.KeyboardHelper.OnKeyboardStatusChangeListener
            public void onKeyboardPop(int i) {
                LoginLoginController loginLoginController = LoginLoginController.this;
                loginLoginController.translationY1 = loginLoginController.titleY + LoginLoginController.this.titleHeight;
                LoginLoginController.this.translationY2 = (r9.clBottomY - LoginLoginController.this.editEmailY) - 50;
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(LoginLoginController.this.clContent, "translationY", 0.0f, -LoginLoginController.this.translationY1);
                ofFloat.setDuration(360L);
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                ofFloat.start();
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(LoginLoginController.this.clBottom, "translationY", 0.0f, -LoginLoginController.this.translationY2);
                ofFloat2.setDuration(360L);
                ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
                ofFloat2.start();
                LoginLoginController.this.tvTitle.setVisibility(8);
                LoginLoginController.this.tvLogo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, LoginLoginController.this.getContext().getResources().getDrawable(C2640R.mipmap.img_logo_login_white), (Drawable) null, (Drawable) null);
                LoginLoginController.this.tvLogo.setTextColor(LoginLoginController.this.getContext().getResources().getColor(C2640R.color.white));
            }

            @Override // com.ipotensic.potensicpro.utils.KeyboardHelper.OnKeyboardStatusChangeListener
            public void onKeyboardClose(int i) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(LoginLoginController.this.clContent, "translationY", -LoginLoginController.this.translationY1, 0.0f);
                ofFloat.setDuration(360L);
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                ofFloat.start();
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(LoginLoginController.this.clBottom, "translationY", -LoginLoginController.this.translationY2, 0.0f);
                ofFloat2.setDuration(360L);
                ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
                ofFloat2.start();
                LoginLoginController.this.tvTitle.postDelayed(new Runnable() { // from class: com.ipotensic.potensicpro.activities.LoginLoginController.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LoginLoginController.this.tvTitle.setVisibility(0);
                    }
                }, 500L);
                LoginLoginController.this.tvLogo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, LoginLoginController.this.getContext().getResources().getDrawable(C2640R.mipmap.img_logo_login), (Drawable) null, (Drawable) null);
                LoginLoginController.this.tvLogo.setTextColor(LoginLoginController.this.getContext().getResources().getColor(C2640R.color.color_login_blue));
            }
        };
        initData();
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        view.findViewById(C2640R.id.tv_register).setOnClickListener(this);
        view.findViewById(C2640R.id.tv_forget_password).setOnClickListener(this);
        view.findViewById(C2640R.id.btn_login).setOnClickListener(this);
        this.editEmail = (EditText) view.findViewById(C2640R.id.edit_login_username);
        this.edtPw = (EditText) view.findViewById(C2640R.id.edit_login_password);
        this.btnLogin = (Button) view.findViewById(C2640R.id.btn_login);
        this.clContent = (ConstraintLayout) view.findViewById(C2640R.id.cl_content);
        this.clBottom = (ConstraintLayout) view.findViewById(C2640R.id.cl_bottom);
        this.tvLogo = (TextView) view.findViewById(C2640R.id.tv_logo);
        this.tvTitle = (TextView) view.findViewById(C2640R.id.tv_code_title);
        this.tvEmailErrorTips = (TextView) view.findViewById(C2640R.id.tv_email_error_tips);
        this.tvPasswordErrorTips = (TextView) view.findViewById(C2640R.id.tv_password_error_tips);
        this.editEmail.addTextChangedListener(new MyTextWatcher(this.editEmail.getId()));
        this.edtPw.addTextChangedListener(new MyTextWatcher(this.edtPw.getId()));
    }

    private void initData() {
        this.tvLogo.post(new Runnable() { // from class: com.ipotensic.potensicpro.activities.LoginLoginController.1
            @Override // java.lang.Runnable
            public void run() {
                LoginLoginController.this.tvLogo.getLocationOnScreen(LoginLoginController.this.viewLocation);
            }
        });
        this.tvTitle.post(new Runnable() { // from class: com.ipotensic.potensicpro.activities.LoginLoginController.2
            @Override // java.lang.Runnable
            public void run() {
                LoginLoginController.this.tvTitle.getLocationOnScreen(LoginLoginController.this.viewLocation);
                LoginLoginController loginLoginController = LoginLoginController.this;
                loginLoginController.titleY = loginLoginController.viewLocation[1];
                LoginLoginController loginLoginController2 = LoginLoginController.this;
                loginLoginController2.titleHeight = loginLoginController2.tvTitle.getHeight();
            }
        });
        this.editEmail.post(new Runnable() { // from class: com.ipotensic.potensicpro.activities.LoginLoginController.3
            @Override // java.lang.Runnable
            public void run() {
                LoginLoginController.this.editEmail.getLocationOnScreen(LoginLoginController.this.viewLocation);
                LoginLoginController loginLoginController = LoginLoginController.this;
                loginLoginController.editEmailY = loginLoginController.viewLocation[1];
            }
        });
        this.clBottom.post(new Runnable() { // from class: com.ipotensic.potensicpro.activities.LoginLoginController.4
            @Override // java.lang.Runnable
            public void run() {
                LoginLoginController.this.clBottom.getLocationOnScreen(LoginLoginController.this.viewLocation);
                LoginLoginController loginLoginController = LoginLoginController.this;
                loginLoginController.clBottomY = loginLoginController.viewLocation[1];
            }
        });
        KeyboardHelper keyboardHelper = new KeyboardHelper(getContext());
        this.keyboardHelper = keyboardHelper;
        keyboardHelper.onCreate();
        this.keyboardHelper.setOnKeyboardStatusChangeListener(this.onKeyboardStatusChangeListener);
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
            if (this.mViewId == LoginLoginController.this.editEmail.getId()) {
                LoginLoginController.this.email = editable.toString().trim();
                LoginLoginController.this.tvEmailErrorTips.setVisibility(FormatUtil.isEmail(LoginLoginController.this.editEmail.getText().toString().trim().replace(StringUtils.SPACE, "")) ? 8 : 0);
            } else {
                LoginLoginController.this.password = editable.toString().trim();
                LoginLoginController.this.tvPasswordErrorTips.setVisibility(FormatUtil.passwordLength(LoginLoginController.this.password) ? 8 : 0);
            }
            if (!FormatUtil.isEmail(LoginLoginController.this.email) || !FormatUtil.passwordLength(LoginLoginController.this.password)) {
                LoginLoginController.this.btnLogin.setBackgroundResource(C2640R.mipmap.img_btn_login_commit);
            } else {
                LoginLoginController.this.btnLogin.setBackgroundResource(C2640R.mipmap.img_btn_login_commit_press);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LoginControllerListener loginControllerListener;
        int id = view.getId();
        if (id == C2640R.id.btn_login) {
            login();
            return;
        }
        if (id != C2640R.id.tv_forget_password) {
            if (id == C2640R.id.tv_register && (loginControllerListener = this.listener) != null) {
                loginControllerListener.toRegisterPage();
                return;
            }
            return;
        }
        LoginControllerListener loginControllerListener2 = this.listener;
        if (loginControllerListener2 != null) {
            loginControllerListener2.onForgetPasswordClicked();
        }
    }

    private void login() {
        String replace = this.editEmail.getText().toString().trim().replace(StringUtils.SPACE, "");
        String replace2 = this.edtPw.getText().toString().trim().replace(StringUtils.SPACE, "");
        if (!FormatUtil.passwordLength(replace2) || TextUtils.isEmpty(this.email)) {
            return;
        }
        if (!FormatUtil.isEmail(replace)) {
            ToastUtil.toast(getContext(), getContext().getString(C2640R.string.toast_error_username_or_password));
            return;
        }
        LoginControllerListener loginControllerListener = this.listener;
        if (loginControllerListener != null) {
            loginControllerListener.showLoadingDialog();
        }
        UserRequestPresenter.getInstance().login(replace, replace2, this);
    }

    @Override // com.logan.user.view.ILoginView
    public void onAccountOrPasswordError() {
        ToastUtil.toast(getContext(), getContext().getString(C2640R.string.toast_error_username_or_password));
        LoginControllerListener loginControllerListener = this.listener;
        if (loginControllerListener != null) {
            loginControllerListener.dismissLoadingDialog();
        }
    }

    @Override // com.logan.user.view.ILoginView
    public void onLoginSuccess() {
        LoginControllerListener loginControllerListener = this.listener;
        if (loginControllerListener != null) {
            loginControllerListener.dismissLoadingDialog();
            this.listener.onLoginSuccess();
        }
    }

    @Override // com.logan.user.view.ILoginView
    public void onLoginFailed(String str) {
        ToastUtil.toast(getContext(), getContext().getString(C2640R.string.toast_logon_failure));
        LoginControllerListener loginControllerListener = this.listener;
        if (loginControllerListener != null) {
            loginControllerListener.dismissLoadingDialog();
        }
    }

    @Override // com.logan.user.view.ILoginView
    public void unregistered() {
        ToastUtil.toast(getContext(), getContext().getString(C2640R.string.toast_mailbox_does_not_exist));
        LoginControllerListener loginControllerListener = this.listener;
        if (loginControllerListener != null) {
            loginControllerListener.dismissLoadingDialog();
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.kernel.utils.SimpleLifeCycle
    public void onDestroy() {
        KeyboardHelper keyboardHelper = this.keyboardHelper;
        if (keyboardHelper != null) {
            keyboardHelper.onDestroy();
        }
        UserRequestPresenter.getInstance().removeLoginView();
    }

    public void setLoginControllerListener(LoginControllerListener loginControllerListener) {
        this.listener = loginControllerListener;
    }
}