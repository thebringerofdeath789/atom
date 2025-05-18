package com.ipotensic.kernel.controllers;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public class TestLocationController extends BaseController {
    private final String OFFLINE;
    private final long TIMEOUT;
    private int bdCount;
    private String bdLocationStr;
    private final Runnable bdLocationTimeoutRunnable;
    private ConstraintLayout layoutTest;
    private int systemCount;
    private String systemLocationStr;
    private final Runnable systemLocationTimeoutRunnable;
    private TextView tvBdAcc;
    private TextView tvSatelliteCount;
    private TextView tvSystemAcc;

    public TestLocationController(AppCompatActivity appCompatActivity, View view) {
        super(appCompatActivity, view);
        this.TIMEOUT = 5000L;
        this.OFFLINE = "离线";
        this.bdCount = 0;
        this.systemCount = 0;
        this.bdLocationStr = "";
        this.systemLocationStr = "";
        this.bdLocationTimeoutRunnable = new Runnable() { // from class: com.ipotensic.kernel.controllers.TestLocationController.1
            @Override // java.lang.Runnable
            public void run() {
                if (TestLocationController.this.tvBdAcc != null) {
                    TestLocationController.this.tvBdAcc.setText(TestLocationController.this.bdLocationStr + "  离线");
                }
            }
        };
        this.systemLocationTimeoutRunnable = new Runnable() { // from class: com.ipotensic.kernel.controllers.TestLocationController.2
            @Override // java.lang.Runnable
            public void run() {
                if (TestLocationController.this.tvSystemAcc != null) {
                    TestLocationController.this.tvSystemAcc.setText(TestLocationController.this.systemLocationStr + "  离线");
                }
            }
        };
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        this.tvSystemAcc = (TextView) view.findViewById(C1965R.id.tv_system_acc);
        this.tvBdAcc = (TextView) view.findViewById(C1965R.id.tv_bd_acc);
        this.layoutTest = (ConstraintLayout) view.findViewById(C1965R.id.layout_test);
        this.tvSatelliteCount = (TextView) view.findViewById(C1965R.id.tv_count);
        this.tvBdAcc.setText("离线");
        this.tvSystemAcc.setText("离线");
    }

    public void bringToFront() {
        ConstraintLayout constraintLayout = this.layoutTest;
        if (constraintLayout != null) {
            constraintLayout.bringToFront();
        }
    }

    public void onBDLocationChanged(double d, double d2, float f) {
        this.bdCount++;
        if (this.tvBdAcc != null) {
            String str = ((int) f) + "     " + this.bdCount;
            this.bdLocationStr = str;
            this.tvBdAcc.setText(str);
        }
        PhoneConfig.mainHandler.removeCallbacks(this.bdLocationTimeoutRunnable);
        PhoneConfig.mainHandler.postDelayed(this.bdLocationTimeoutRunnable, 5000L);
    }

    public void onSystemLocationChanged(double d, double d2, float f) {
        this.systemCount++;
        if (this.tvSystemAcc != null) {
            String str = ((int) f) + "     " + this.systemCount;
            this.systemLocationStr = str;
            this.tvSystemAcc.setText(str);
        }
        PhoneConfig.mainHandler.removeCallbacks(this.systemLocationTimeoutRunnable);
        PhoneConfig.mainHandler.postDelayed(this.systemLocationTimeoutRunnable, 5000L);
    }

    public void onSatelliteCount(int i) {
        TextView textView = this.tvSatelliteCount;
        if (textView != null) {
            textView.setText("  卫星数量 :      " + i);
        }
    }

    public void show(boolean z) {
        if (z) {
            this.layoutTest.setVisibility(0);
        } else {
            this.layoutTest.setVisibility(8);
        }
    }
}