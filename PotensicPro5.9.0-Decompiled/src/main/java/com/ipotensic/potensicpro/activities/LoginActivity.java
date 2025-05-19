package com.ipotensic.potensicpro.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewStub;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.kernel.controllers.BaseController;
import com.ipotensic.potensicpro.R;
import com.ipotensic.potensicpro.activities.LoginForgetPasswordController;
import com.ipotensic.potensicpro.activities.LoginLoginController;
import com.ipotensic.potensicpro.activities.LoginRegisterController;
import com.ipotensic.potensicpro.activities.LoginSendSuccessController;

/* loaded from: classes2.dex */
public class LoginActivity extends BaseActivity {
    private static final String LOGIN_SUCCESS = "login_success";
    private BaseController curController;
    private LoginForgetPasswordController forgetPasswordController;
    private LoginLoginController loginController;
    private LoginRegisterController registerController;
    private LoginSendSuccessController sendSuccessController;
    private LoginSendSuccessController.OnSendSuccessListener sendSuccessListener = new LoginSendSuccessController.OnSendSuccessListener() { // from class: com.ipotensic.potensicpro.activities.LoginActivity.1
        @Override // com.ipotensic.potensicpro.activities.LoginSendSuccessController.OnSendSuccessListener
        public void onBackClicked() {
            LoginActivity loginActivity = LoginActivity.this;
            loginActivity.setCurPage(loginActivity.loginController);
        }
    };
    private LoginLoginController.LoginControllerListener loginControllerListener = new LoginLoginController.LoginControllerListener() { // from class: com.ipotensic.potensicpro.activities.LoginActivity.2
        @Override // com.ipotensic.potensicpro.activities.LoginLoginController.LoginControllerListener
        public void toRegisterPage() {
            LoginActivity loginActivity = LoginActivity.this;
            loginActivity.setCurPage(loginActivity.registerController);
        }

        @Override // com.ipotensic.potensicpro.activities.LoginLoginController.LoginControllerListener
        public void onForgetPasswordClicked() {
            LoginActivity loginActivity = LoginActivity.this;
            loginActivity.setCurPage(loginActivity.forgetPasswordController);
        }

        @Override // com.ipotensic.potensicpro.activities.LoginLoginController.LoginControllerListener
        public void showLoadingDialog() {
            LoginActivity.this.showLoadingDialog();
        }

        @Override // com.ipotensic.potensicpro.activities.LoginLoginController.LoginControllerListener
        public void dismissLoadingDialog() {
            LoginActivity.this.dismissLoadingDialog();
        }

        @Override // com.ipotensic.potensicpro.activities.LoginLoginController.LoginControllerListener
        public void onLoginSuccess() {
            Intent intent = new Intent(LoginActivity.this, (Class<?>) MainActivity.class);
            intent.putExtra(LoginActivity.LOGIN_SUCCESS, true);
            LoginActivity.this.startActivity(intent);
            LoginActivity.this.finish();
        }
    };
    private LoginRegisterController.RegisterControllerListener registerControllerListener = new LoginRegisterController.RegisterControllerListener() { // from class: com.ipotensic.potensicpro.activities.LoginActivity.3
        @Override // com.ipotensic.potensicpro.activities.LoginRegisterController.RegisterControllerListener
        public void toLoginPage() {
            LoginActivity loginActivity = LoginActivity.this;
            loginActivity.setCurPage(loginActivity.loginController);
        }

        @Override // com.ipotensic.potensicpro.activities.LoginRegisterController.RegisterControllerListener
        public void showLoadingDialog() {
            LoginActivity.this.showLoadingDialog();
        }

        @Override // com.ipotensic.potensicpro.activities.LoginRegisterController.RegisterControllerListener
        public void dismissLoadingDialog() {
            LoginActivity.this.dismissLoadingDialog();
        }
    };
    private LoginForgetPasswordController.OnForgetPasswordListener forgetPasswordListener = new LoginForgetPasswordController.OnForgetPasswordListener() { // from class: com.ipotensic.potensicpro.activities.LoginActivity.4
        @Override // com.ipotensic.potensicpro.activities.LoginForgetPasswordController.OnForgetPasswordListener
        public void showLoadingDialog() {
            LoginActivity.this.showLoadingDialog();
        }

        @Override // com.ipotensic.potensicpro.activities.LoginForgetPasswordController.OnForgetPasswordListener
        public void dismissLoadingDialog() {
            LoginActivity.this.dismissLoadingDialog();
        }

        @Override // com.ipotensic.potensicpro.activities.LoginForgetPasswordController.OnForgetPasswordListener
        public void onBackClicked() {
            LoginActivity loginActivity = LoginActivity.this;
            loginActivity.setCurPage(loginActivity.loginController);
        }

        @Override // com.ipotensic.potensicpro.activities.LoginForgetPasswordController.OnForgetPasswordListener
        public void onForgetSuccess(String str) {
            LoginActivity loginActivity = LoginActivity.this;
            loginActivity.setCurPage(loginActivity.sendSuccessController);
            LoginActivity.this.sendSuccessController.setSuccessEmail(str);
        }
    };

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStateBarShow(true);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        LoginLoginController loginLoginController = new LoginLoginController(this, (ConstraintLayout) findViewById(R.id.layout_login));
        this.loginController = loginLoginController;
        loginLoginController.setLoginControllerListener(this.loginControllerListener);
        LoginRegisterController loginRegisterController = new LoginRegisterController(this, (ViewStub) findViewById(R.id.stub_register));
        this.registerController = loginRegisterController;
        loginRegisterController.setRegisterControllerListener(this.registerControllerListener);
        LoginForgetPasswordController loginForgetPasswordController = new LoginForgetPasswordController(this, (ViewStub) findViewById(R.id.stub_forget_password));
        this.forgetPasswordController = loginForgetPasswordController;
        loginForgetPasswordController.setOnForgetPasswordListener(this.forgetPasswordListener);
        LoginSendSuccessController loginSendSuccessController = new LoginSendSuccessController(this, (ViewStub) findViewById(R.id.stub_send_success));
        this.sendSuccessController = loginSendSuccessController;
        loginSendSuccessController.setOnSendSuccessListener(this.sendSuccessListener);
        this.curController = this.loginController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurPage(BaseController baseController) {
        this.curController = baseController;
        this.loginController.setVisibility(baseController instanceof LoginLoginController ? 0 : 8);
        this.registerController.setVisibility(baseController instanceof LoginRegisterController ? 0 : 8);
        this.forgetPasswordController.setVisibility(baseController instanceof LoginForgetPasswordController ? 0 : 8);
        this.sendSuccessController.setVisibility(baseController instanceof LoginSendSuccessController ? 0 : 8);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        BaseController baseController = this.curController;
        if ((baseController instanceof LoginSendSuccessController) || (baseController instanceof LoginForgetPasswordController) || (baseController instanceof LoginRegisterController)) {
            setCurPage(this.loginController);
        }
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        LoginLoginController loginLoginController = this.loginController;
        if (loginLoginController != null) {
            loginLoginController.onDestroy();
        }
        LoginRegisterController loginRegisterController = this.registerController;
        if (loginRegisterController != null) {
            loginRegisterController.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.registerController.getClass();
        if (i == 111 && i2 == -1) {
            this.registerController.onActivityResult(i, i2, intent);
        }
    }
}
