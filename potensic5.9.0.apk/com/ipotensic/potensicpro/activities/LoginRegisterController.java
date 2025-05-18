package com.ipotensic.potensicpro.activities;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.utils.FormatUtil;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.controllers.BaseController;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.ipotensic.potensicpro.C2640R;
import com.ipotensic.potensicpro.utils.KeyboardHelper;
import com.logan.user.presenter.UserRequestPresenter;
import com.logan.user.view.ILoginView;
import com.logan.user.view.IRegisterView;
import me.yokeyword.indexablerv.countrys.PickCountryActivity;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public class LoginRegisterController extends BaseController implements IRegisterView, ILoginView {
    public final int AREA_SELECT;
    private Button btnRegister;
    private CheckBox checkBox;
    private ConstraintLayout clBottom;
    private int clBottomY;
    private ConstraintLayout clContent;
    private int countryCode;
    private String countryName;
    private EditText edtEmail;
    private int edtEmailY;
    private EditText edtPw;
    private String email;
    private boolean isEmailFocus;
    private boolean isPWFocus;
    private KeyboardHelper keyboardHelper;
    private RegisterControllerListener listener;
    private int logoY;
    private KeyboardHelper.OnKeyboardStatusChangeListener onKeyboardStatusChangeListener;
    private String password;
    private int titleHeight;
    private int titleY;
    private int translationY1;
    private int translationY2;
    private TextView tvChooseCountry;
    private TextView tvEmailErrorTips;
    private TextView tvLogo;
    private TextView tvPasswordErrorTips;
    private TextView tvTitle;
    private int[] viewLocation;

    public interface RegisterControllerListener {
        void dismissLoadingDialog();

        void showLoadingDialog();

        void toLoginPage();
    }

    @Override // com.logan.user.view.IRegisterView
    public void onEmailCodeError() {
    }

    @Override // com.logan.user.view.IRegisterView
    public void onEmailCodeInvalid() {
    }

    public LoginRegisterController(AppCompatActivity appCompatActivity, ViewStub viewStub) {
        super(appCompatActivity, viewStub);
        this.AREA_SELECT = 111;
        this.viewLocation = new int[2];
        this.onKeyboardStatusChangeListener = new KeyboardHelper.OnKeyboardStatusChangeListener() { // from class: com.ipotensic.potensicpro.activities.LoginRegisterController.6
            @Override // com.ipotensic.potensicpro.utils.KeyboardHelper.OnKeyboardStatusChangeListener
            public void onKeyboardPop(int i) {
                LoginRegisterController loginRegisterController = LoginRegisterController.this;
                loginRegisterController.translationY1 = loginRegisterController.titleHeight + LoginRegisterController.this.titleY;
                LoginRegisterController.this.translationY2 = (r9.clBottomY - LoginRegisterController.this.edtEmailY) - 25;
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(LoginRegisterController.this.clContent, "translationY", 0.0f, -LoginRegisterController.this.translationY1);
                ofFloat.setDuration(360L);
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                ofFloat.start();
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(LoginRegisterController.this.clBottom, "translationY", 0.0f, -LoginRegisterController.this.translationY2);
                ofFloat2.setDuration(360L);
                ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
                ofFloat2.start();
                LoginRegisterController.this.tvTitle.setVisibility(8);
                LoginRegisterController.this.tvLogo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, LoginRegisterController.this.getContext().getResources().getDrawable(C2640R.mipmap.img_logo_login_white), (Drawable) null, (Drawable) null);
                LoginRegisterController.this.tvLogo.setTextColor(LoginRegisterController.this.getContext().getResources().getColor(C2640R.color.white));
            }

            @Override // com.ipotensic.potensicpro.utils.KeyboardHelper.OnKeyboardStatusChangeListener
            public void onKeyboardClose(int i) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(LoginRegisterController.this.clContent, "translationY", -LoginRegisterController.this.translationY1, 0.0f);
                ofFloat.setDuration(360L);
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                ofFloat.start();
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(LoginRegisterController.this.clBottom, "translationY", -LoginRegisterController.this.translationY2, 0.0f);
                ofFloat2.setDuration(360L);
                ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
                ofFloat2.start();
                LoginRegisterController.this.tvTitle.postDelayed(new Runnable() { // from class: com.ipotensic.potensicpro.activities.LoginRegisterController.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LoginRegisterController.this.tvTitle.setVisibility(0);
                    }
                }, 500L);
                LoginRegisterController.this.tvLogo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, LoginRegisterController.this.getContext().getResources().getDrawable(C2640R.mipmap.img_logo_login), (Drawable) null, (Drawable) null);
                LoginRegisterController.this.tvLogo.setTextColor(LoginRegisterController.this.getContext().getResources().getColor(C2640R.color.color_login_blue));
            }
        };
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        this.tvChooseCountry = (TextView) view.findViewById(C2640R.id.tv_choose_country);
        this.btnRegister = (Button) view.findViewById(C2640R.id.btn_register);
        this.edtEmail = (EditText) view.findViewById(C2640R.id.edit_register_username);
        this.edtPw = (EditText) view.findViewById(C2640R.id.edit_register_password);
        this.tvEmailErrorTips = (TextView) view.findViewById(C2640R.id.tv_email_error_tips);
        this.tvPasswordErrorTips = (TextView) view.findViewById(C2640R.id.tv_password_error_tips);
        this.clContent = (ConstraintLayout) view.findViewById(C2640R.id.cl_content);
        this.clBottom = (ConstraintLayout) view.findViewById(C2640R.id.cl_bottom);
        this.tvLogo = (TextView) view.findViewById(C2640R.id.tv_logo);
        this.tvTitle = (TextView) view.findViewById(C2640R.id.tv_code_title);
        this.checkBox = (CheckBox) view.findViewById(C2640R.id.checkbox);
        this.edtEmail.addTextChangedListener(new MyTextWatcher(this.edtEmail.getId()));
        this.edtPw.addTextChangedListener(new MyTextWatcher(this.edtPw.getId()));
        initData();
        setOnFocusListener();
        setOnClickListener(view);
    }

    private void setOnFocusListener() {
        this.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.ipotensic.potensicpro.activities.LoginRegisterController.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                LoginRegisterController.this.edtPw.setTransformationMethod(z ? HideReturnsTransformationMethod.getInstance() : PasswordTransformationMethod.getInstance());
                LoginRegisterController.this.edtPw.setSelection(LoginRegisterController.this.edtPw.length());
            }
        });
    }

    private void initData() {
        this.tvLogo.post(new Runnable() { // from class: com.ipotensic.potensicpro.activities.LoginRegisterController.2
            @Override // java.lang.Runnable
            public void run() {
                LoginRegisterController.this.tvLogo.getLocationOnScreen(LoginRegisterController.this.viewLocation);
                LoginRegisterController loginRegisterController = LoginRegisterController.this;
                loginRegisterController.logoY = loginRegisterController.viewLocation[1];
            }
        });
        this.tvTitle.post(new Runnable() { // from class: com.ipotensic.potensicpro.activities.LoginRegisterController.3
            @Override // java.lang.Runnable
            public void run() {
                LoginRegisterController.this.tvTitle.getLocationOnScreen(LoginRegisterController.this.viewLocation);
                LoginRegisterController loginRegisterController = LoginRegisterController.this;
                loginRegisterController.titleY = loginRegisterController.viewLocation[1];
                LoginRegisterController loginRegisterController2 = LoginRegisterController.this;
                loginRegisterController2.titleHeight = loginRegisterController2.tvTitle.getHeight();
            }
        });
        this.edtEmail.post(new Runnable() { // from class: com.ipotensic.potensicpro.activities.LoginRegisterController.4
            @Override // java.lang.Runnable
            public void run() {
                LoginRegisterController.this.edtEmail.getLocationOnScreen(LoginRegisterController.this.viewLocation);
                LoginRegisterController loginRegisterController = LoginRegisterController.this;
                loginRegisterController.edtEmailY = loginRegisterController.viewLocation[1];
            }
        });
        this.clBottom.post(new Runnable() { // from class: com.ipotensic.potensicpro.activities.LoginRegisterController.5
            @Override // java.lang.Runnable
            public void run() {
                LoginRegisterController.this.clBottom.getLocationOnScreen(LoginRegisterController.this.viewLocation);
                LoginRegisterController loginRegisterController = LoginRegisterController.this;
                loginRegisterController.clBottomY = loginRegisterController.viewLocation[1];
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
            if (this.mViewId == LoginRegisterController.this.edtEmail.getId()) {
                LoginRegisterController.this.email = editable.toString().trim();
                LoginRegisterController.this.tvEmailErrorTips.setVisibility(FormatUtil.isEmail(LoginRegisterController.this.edtEmail.getText().toString().trim().replace(StringUtils.SPACE, "")) ? 8 : 0);
            } else {
                LoginRegisterController.this.password = editable.toString().trim();
                LoginRegisterController.this.tvPasswordErrorTips.setVisibility(FormatUtil.passwordLength(LoginRegisterController.this.password) ? 8 : 0);
            }
            if (!FormatUtil.isEmail(LoginRegisterController.this.email) || !FormatUtil.passwordLength(LoginRegisterController.this.password)) {
                LoginRegisterController.this.btnRegister.setBackgroundResource(C2640R.mipmap.img_btn_login_commit);
            } else {
                LoginRegisterController.this.btnRegister.setBackgroundResource(C2640R.mipmap.img_btn_login_commit_press);
            }
        }
    }

    private void setOnClickListener(View view) {
        view.findViewById(C2640R.id.tv_login).setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.activities.LoginRegisterController.7
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                if (LoginRegisterController.this.listener != null) {
                    LoginRegisterController.this.listener.toLoginPage();
                }
            }
        });
        TextView textView = (TextView) view.findViewById(C2640R.id.tv_user_agreement_content);
        textView.setText(Html.fromHtml(getContext().getString(C2640R.string.terms_and_agreements)));
        textView.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.activities.LoginRegisterController.8
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                LoginRegisterController.this.getContext().startActivity(new Intent(LoginRegisterController.this.getContext(), (Class<?>) UserAgreementActivity2.class));
            }
        });
        this.btnRegister.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.activities.LoginRegisterController.9
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                LoginRegisterController.this.register();
            }
        });
        this.tvChooseCountry.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.activities.LoginRegisterController.10
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                LoginRegisterController.this.getContext().startActivityForResult(new Intent(LoginRegisterController.this.getContext(), (Class<?>) PickCountryActivity.class), 111);
            }
        });
    }

    public void setRegisterControllerListener(RegisterControllerListener registerControllerListener) {
        this.listener = registerControllerListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void register() {
        if (this.countryName == null) {
            ToastUtil.toast(getContext(), getContext().getString(C2640R.string.toast_choose_the_country));
            return;
        }
        String replace = this.edtEmail.getText().toString().trim().replace(StringUtils.SPACE, "");
        String replace2 = this.edtPw.getText().toString().trim().replace(StringUtils.SPACE, "");
        String replace3 = this.tvChooseCountry.getText().toString().trim().replace("", "");
        if (FormatUtil.passwordLength(replace2) && !TextUtils.isEmpty(replace) && FormatUtil.isEmail(replace)) {
            RegisterControllerListener registerControllerListener = this.listener;
            if (registerControllerListener != null) {
                registerControllerListener.showLoadingDialog();
            }
            UserRequestPresenter.getInstance().register(replace, replace2, "" + this.countryCode, replace3, this);
        }
    }

    @Override // com.logan.user.view.ILoginView
    public void onAccountOrPasswordError() {
        RegisterControllerListener registerControllerListener = this.listener;
        if (registerControllerListener != null) {
            registerControllerListener.dismissLoadingDialog();
            this.listener.toLoginPage();
        }
    }

    @Override // com.logan.user.view.ILoginView
    public void onLoginSuccess() {
        RegisterControllerListener registerControllerListener = this.listener;
        if (registerControllerListener != null) {
            registerControllerListener.dismissLoadingDialog();
        }
        getContext().startActivity(new Intent(getContext(), (Class<?>) UserPersonInfoActivity.class));
    }

    @Override // com.logan.user.view.ILoginView
    public void onLoginFailed(String str) {
        RegisterControllerListener registerControllerListener = this.listener;
        if (registerControllerListener != null) {
            registerControllerListener.dismissLoadingDialog();
            this.listener.toLoginPage();
        }
    }

    @Override // com.logan.user.view.ILoginView
    public void unregistered() {
        RegisterControllerListener registerControllerListener = this.listener;
        if (registerControllerListener != null) {
            registerControllerListener.dismissLoadingDialog();
            this.listener.toLoginPage();
        }
    }

    @Override // com.logan.user.view.IRegisterView
    public void onRegisterSuccess() {
        registerSuccess(getContext().getString(C2640R.string.toast_register_successfully));
    }

    @Override // com.logan.user.view.IRegisterView
    public void onEmailAlreadyUsed() {
        RegisterControllerListener registerControllerListener = this.listener;
        if (registerControllerListener != null) {
            registerControllerListener.dismissLoadingDialog();
        }
        ToastUtil.toast(getContext(), getContext().getString(C2640R.string.toast_mailbox_has_been_used));
        this.listener.toLoginPage();
    }

    @Override // com.logan.user.view.IRegisterView
    public void onEmailNotExist() {
        RegisterControllerListener registerControllerListener = this.listener;
        if (registerControllerListener != null) {
            registerControllerListener.dismissLoadingDialog();
        }
        ToastUtil.toast(getContext(), getContext().getString(C2640R.string.toast_mailbox_does_not_exist));
    }

    @Override // com.logan.user.view.IRegisterView
    public void onRegisterError(String str) {
        registerFailed(getContext().getString(C2640R.string.toast_registration_error));
    }

    private void registerSuccess(String str) {
        UserRequestPresenter.getInstance().login(this.edtEmail.getText().toString().trim().replace(StringUtils.SPACE, ""), this.edtPw.getText().toString().trim().replace(StringUtils.SPACE, ""), this);
    }

    private void registerFailed(String str) {
        RegisterControllerListener registerControllerListener = this.listener;
        if (registerControllerListener != null) {
            registerControllerListener.dismissLoadingDialog();
        }
        new GeneralDialog((Context) getContext(), getContext().getResources().getString(C2640R.string.dialog_failure), str, C2640R.mipmap.img_dialog_failure, false, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.potensicpro.activities.LoginRegisterController.11
            @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
            public void confirm() {
            }
        }).show();
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.kernel.utils.SimpleLifeCycle
    public void onDestroy() {
        KeyboardHelper keyboardHelper = this.keyboardHelper;
        if (keyboardHelper != null) {
            keyboardHelper.onDestroy();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null) {
            this.countryName = intent.getStringExtra("country_name");
            this.countryCode = intent.getIntExtra("country_code", 0);
            TextView textView = this.tvChooseCountry;
            if (textView != null) {
                textView.setText(this.countryName);
            }
        }
    }
}