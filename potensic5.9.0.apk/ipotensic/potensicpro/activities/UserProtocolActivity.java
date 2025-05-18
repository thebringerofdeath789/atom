package com.ipotensic.potensicpro.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.potensicpro.R;
import com.ipotensic.potensicpro.view.SmartScrollView;

/* loaded from: classes2.dex */
public class UserProtocolActivity extends BaseActivity implements View.OnClickListener {
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
        setContentView(R.layout.activity_user);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn_return).setOnClickListener(this);
        this.tvTitle = (TextView) findViewById(R.id.tv_code_title);
        this.tvUser = (TextView) findViewById(R.id.tv_user);
        this.tvPrivacy = (TextView) findViewById(R.id.tv_privacy_policy);
        this.scrollView = (SmartScrollView) findViewById(R.id.scroll_view);
        this.tvTitle.setVisibility(0);
        this.tvTitle.setText(getString(R.string.user_agreement));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.btn_return) {
            finish();
        }
    }
}