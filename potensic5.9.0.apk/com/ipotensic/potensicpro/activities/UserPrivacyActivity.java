package com.ipotensic.potensicpro.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.potensicpro.C2640R;
import com.ipotensic.potensicpro.view.SmartScrollView;

/* loaded from: classes2.dex */
public class UserPrivacyActivity extends BaseActivity implements View.OnClickListener {
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
        setContentView(C2640R.layout.activity_user_privacy);
        initView();
    }

    private void initView() {
        findViewById(C2640R.id.btn_return).setOnClickListener(this);
        this.tvTitle = (TextView) findViewById(C2640R.id.tv_code_title);
        this.tvUser = (TextView) findViewById(C2640R.id.tv_user);
        this.tvPrivacy = (TextView) findViewById(C2640R.id.tv_privacy_policy);
        this.scrollView = (SmartScrollView) findViewById(C2640R.id.scroll_view);
        this.tvTitle.setVisibility(0);
        this.tvTitle.setText(getString(C2640R.string.privacy_policy));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == C2640R.id.btn_return) {
            finish();
        }
    }
}