package com.ipotensic.potensicpro.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.potensicpro.C2640R;
import com.logan.flight.FlightConfig;

/* loaded from: classes2.dex */
public class DroneGuideActivity extends BaseActivity {
    private String btnStr;
    private TextView tvContent;

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStateBarShow(true);
        setContentView(C2640R.layout.activity_drone_guide);
        setToolBar();
    }

    private void setToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(C2640R.id.toolbar);
        toolbar.findViewById(C2640R.id.iv_back).setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.potensicpro.activities.DroneGuideActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DroneGuideActivity.this.finish();
            }
        });
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayShowTitleEnabled(false);
        supportActionBar.setHomeButtonEnabled(false);
        supportActionBar.setDisplayHomeAsUpEnabled(false);
        this.tvContent = (TextView) findViewById(C2640R.id.tv_content);
        setText();
    }

    private void setText() {
        String string;
        try {
            String string2 = getString(C2640R.string.me_find_my_drone_title);
            if (FlightConfig.is_Atom_SE_Series()) {
                string = getString(C2640R.string.me_find_my_drone_atom_se_tips);
            } else if (FlightConfig.isAtomLT()) {
                string = getString(C2640R.string.me_find_my_drone_atom_lt_tips);
            } else {
                string = getString(C2640R.string.me_find_my_drone_atom_tips);
            }
            this.tvContent.setText(string.substring(string2.length() + 1, string.length()));
        } catch (Exception e) {
            DDLog.m1684e("droneGuideSetText报错:" + e.getMessage());
        }
    }
}