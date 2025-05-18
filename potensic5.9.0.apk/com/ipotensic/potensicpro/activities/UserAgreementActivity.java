package com.ipotensic.potensicpro.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.potensicpro.C2640R;
import com.ipotensic.potensicpro.view.SmartScrollView;

/* loaded from: classes2.dex */
public class UserAgreementActivity extends BaseActivity implements View.OnClickListener {
    private SmartScrollView.onScrollViewScrollChanged listener = new SmartScrollView.onScrollViewScrollChanged() { // from class: com.ipotensic.potensicpro.activities.UserAgreementActivity.3
        @Override // com.ipotensic.potensicpro.view.SmartScrollView.onScrollViewScrollChanged
        public void onObservableScrollViewScrollChanged(int i, int i2, int i3, int i4) {
            if (UserAgreementActivity.this.privacyHeight == 0 || i2 <= UserAgreementActivity.this.privacyHeight) {
                if (UserAgreementActivity.this.userHeight == 0 || i2 <= UserAgreementActivity.this.userHeight) {
                    return;
                }
                UserAgreementActivity.this.tvTitle.setVisibility(0);
                UserAgreementActivity.this.tvTitle.setText(UserAgreementActivity.this.getString(C2640R.string.user_agreement));
                return;
            }
            UserAgreementActivity.this.tvTitle.setVisibility(0);
            UserAgreementActivity.this.tvTitle.setText(UserAgreementActivity.this.getString(C2640R.string.privacy_policy));
        }
    };
    private int privacyHeight;
    private SmartScrollView scrollView;
    private TextView tvPrivacy;
    private TextView tvTitle;
    private TextView tvUser;
    private int userHeight;

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStateBarShow(true);
        setContentView(C2640R.layout.activity_user);
        initView();
    }

    private void initView() {
        findViewById(C2640R.id.btn_return).setOnClickListener(this);
        this.tvTitle = (TextView) findViewById(C2640R.id.tv_code_title);
        this.tvUser = (TextView) findViewById(C2640R.id.tv_user);
        this.tvPrivacy = (TextView) findViewById(C2640R.id.tv_privacy_policy);
        SmartScrollView smartScrollView = (SmartScrollView) findViewById(C2640R.id.scroll_view);
        this.scrollView = smartScrollView;
        smartScrollView.setOnScrollViewScrollChanged(this.listener);
        this.tvUser.post(new Runnable() { // from class: com.ipotensic.potensicpro.activities.UserAgreementActivity.1
            @Override // java.lang.Runnable
            public void run() {
                UserAgreementActivity userAgreementActivity = UserAgreementActivity.this;
                userAgreementActivity.userHeight = userAgreementActivity.tvUser.getBottom();
            }
        });
        this.tvPrivacy.post(new Runnable() { // from class: com.ipotensic.potensicpro.activities.UserAgreementActivity.2
            @Override // java.lang.Runnable
            public void run() {
                UserAgreementActivity userAgreementActivity = UserAgreementActivity.this;
                userAgreementActivity.privacyHeight = userAgreementActivity.tvPrivacy.getBottom();
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == C2640R.id.btn_return) {
            finish();
        }
    }
}