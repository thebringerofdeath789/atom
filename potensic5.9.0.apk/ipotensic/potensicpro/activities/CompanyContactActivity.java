package com.ipotensic.potensicpro.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.utils.NetworkUtils;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public class CompanyContactActivity extends BaseActivity {
    private Toolbar toolbar;

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStateBarShow(true);
        setContentView(R.layout.activity_company_contact);
        setToolBar();
        ((TextView) findViewById(R.id.tv_email_content)).setText(getString(R.string.me_our_email));
        TextView textView = (TextView) findViewById(R.id.tv_website_link);
        textView.setText(Html.fromHtml(getString(R.string.me_www)));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.potensicpro.activities.CompanyContactActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PhoneConfig.isConnectFlightWifi() && NetworkUtils.getNetworkState(CompanyContactActivity.this) >= 0) {
                    CompanyContactActivity.this.toBrowser();
                } else {
                    CompanyContactActivity companyContactActivity = CompanyContactActivity.this;
                    new GeneralDialog(companyContactActivity, companyContactActivity.getResources().getString(R.string.txt_dialog_make_sure_internet_title), CompanyContactActivity.this.getResources().getString(R.string.txt_dialog_make_sure_internet_detail), 0, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.potensicpro.activities.CompanyContactActivity.1.1
                        @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                        public void confirm() {
                        }
                    }).show();
                }
            }
        });
    }

    private void setToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.toolbar = toolbar;
        toolbar.findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.potensicpro.activities.CompanyContactActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CompanyContactActivity.this.finish();
            }
        });
        ((TextView) this.toolbar.findViewById(R.id.tv_code_title)).setText(R.string.me_contact_us);
        setSupportActionBar(this.toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayShowTitleEnabled(false);
        supportActionBar.setHomeButtonEnabled(false);
        supportActionBar.setDisplayHomeAsUpEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toBrowser() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://www.potensic.com"));
        startActivity(intent);
    }
}