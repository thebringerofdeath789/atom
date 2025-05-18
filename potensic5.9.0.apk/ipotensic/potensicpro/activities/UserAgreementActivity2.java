package com.ipotensic.potensicpro.activities;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.okhttp.ClientManager;
import com.ipotensic.baselib.utils.LanguageHelper;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.potensicpro.R;
import com.ipotensic.potensicpro.view.SmartScrollView;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes2.dex */
public class UserAgreementActivity2 extends BaseActivity implements View.OnClickListener {
    private final String URL = "http://app.potensic.com/index.php/useragreement/index/index?brandcode=2&&l=%d";
    private SmartScrollView.onScrollViewScrollChanged listener = new SmartScrollView.onScrollViewScrollChanged() { // from class: com.ipotensic.potensicpro.activities.UserAgreementActivity2.2
        @Override // com.ipotensic.potensicpro.view.SmartScrollView.onScrollViewScrollChanged
        public void onObservableScrollViewScrollChanged(int i, int i2, int i3, int i4) {
            if (UserAgreementActivity2.this.privacyHeight == 0 || i2 <= UserAgreementActivity2.this.privacyHeight) {
                if (UserAgreementActivity2.this.userHeight == 0 || i2 <= UserAgreementActivity2.this.userHeight) {
                    return;
                }
                UserAgreementActivity2.this.tvTitle.setVisibility(0);
                UserAgreementActivity2.this.tvTitle.setText(UserAgreementActivity2.this.getString(R.string.user_agreement));
                return;
            }
            UserAgreementActivity2.this.tvTitle.setVisibility(0);
            UserAgreementActivity2.this.tvTitle.setText(UserAgreementActivity2.this.getString(R.string.privacy_policy));
        }
    };
    private int privacyHeight;
    private SmartScrollView scrollView;
    private TextView tvPrivacy;
    private TextView tvTitle;
    private TextView tvTitle1;
    private TextView tvUser;
    private int userHeight;
    private WebView webView;

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStateBarShow(true);
        setContentView(R.layout.activity_user_agree);
        setToolBar();
        showLoadingDialog();
        initData();
    }

    private void setToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.findViewById(R.id.iv_back).setOnClickListener(this);
        TextView textView = (TextView) toolbar.findViewById(R.id.tv_code_title);
        this.tvTitle1 = textView;
        textView.setText(getResources().getString(R.string.user_agreement));
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayShowTitleEnabled(false);
        supportActionBar.setHomeButtonEnabled(false);
        supportActionBar.setDisplayHomeAsUpEnabled(false);
        this.webView = new WebView(getApplicationContext());
        ((FrameLayout) findViewById(R.id.fl_web_container)).addView(this.webView, new FrameLayout.LayoutParams(-1, -1));
    }

    private void initData() {
        ClientManager.getInstance().getClient().newCall(new Request.Builder().url(String.format("http://app.potensic.com/index.php/useragreement/index/index?brandcode=2&&l=%d", Integer.valueOf(LanguageHelper.getPhoneLanguageType()))).build()).enqueue(new Callback() { // from class: com.ipotensic.potensicpro.activities.UserAgreementActivity2.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                UserAgreementActivity2.this.runOnUiThread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.UserAgreementActivity2.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        UserAgreementActivity2.this.dismissLoadingDialog();
                        ToastUtil.toast(UserAgreementActivity2.this, UserAgreementActivity2.this.getResources().getString(R.string.please_check_the_network));
                    }
                });
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                DDLog.e("\u6253\u5370\u7ed3\u679c\uff1a" + string);
                UserAgreementActivity2.this.runOnUiThread(new Runnable() { // from class: com.ipotensic.potensicpro.activities.UserAgreementActivity2.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!string.contains("<meta charset=\"gb2312\">")) {
                            try {
                                UserAgreementActivity2.this.webView.setWebViewClient(new WebViewClient());
                                WebSettings settings = UserAgreementActivity2.this.webView.getSettings();
                                settings.setJavaScriptEnabled(true);
                                settings.setAllowFileAccess(true);
                                settings.setAllowFileAccessFromFileURLs(true);
                                settings.setAllowContentAccess(true);
                                settings.setDomStorageEnabled(true);
                                UserAgreementActivity2.this.webView.loadDataWithBaseURL(null, string, "text/html", "utf-8", null);
                                UserAgreementActivity2.this.dismissLoadingDialog();
                                return;
                            } catch (Exception unused) {
                                UserAgreementActivity2.this.dismissLoadingDialog();
                                return;
                            }
                        }
                        ToastUtil.toast(UserAgreementActivity2.this, PhoneConfig.applicationContext.getString(R.string.toast_no_network));
                    }
                });
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.iv_back) {
            finish();
        }
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        WebView webView = this.webView;
        if (webView != null) {
            ViewParent parent = webView.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(this.webView);
            }
            this.webView.stopLoading();
            this.webView.getSettings().setJavaScriptEnabled(false);
            this.webView.clearHistory();
            this.webView.clearView();
            this.webView.removeAllViews();
            this.webView.destroy();
        }
        super.onDestroy();
    }
}