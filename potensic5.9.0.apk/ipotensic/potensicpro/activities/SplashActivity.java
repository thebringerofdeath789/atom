package com.ipotensic.potensicpro.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.ipotensic.baselib.ActivityHelper;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.permission.PermissionUtil;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.baselib.utils.UnitUtil;
import com.ipotensic.potensicpro.R;
import com.ipotensic.potensicpro.view.dialog.PrivacyDialog;
import com.ipotensic.potensicpro.view.dialog.ProtocolNotAgreeDialog;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class SplashActivity extends BaseActivity {
    private static final String TAG = "SplashActivity";
    private PagerAdapter adapter;
    private TextView btnSkip;
    private Button btnStart;
    private ImageView ivBg;
    private LinearLayout layoutIndicator;
    private TextView tvExplain;
    private ViewPager viewPager;
    private ArrayList<View> pages = new ArrayList<>();
    private ArrayList<ImageView> indicators = new ArrayList<>();
    private String[] explains = new String[0];
    private boolean isResume = false;

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (SPHelper.getInstance().getFirstEnterMain()) {
            SPHelper.getInstance().putBoolean(SPHelper.KEY_ENTER_MAIN_SECOND, true);
        }
        setStateBarShow(false);
        setContentView(R.layout.activity_splash);
        this.ivBg = (ImageView) findViewById(R.id.iv_background);
        initView();
        initData();
        if (!SPHelper.getInstance().isProtocolAgree()) {
            new PrivacyDialog(this, new PrivacyDialog.OnAgreeListener() { // from class: com.ipotensic.potensicpro.activities.SplashActivity.1
                @Override // com.ipotensic.potensicpro.view.dialog.PrivacyDialog.OnAgreeListener
                public void onAgree() {
                    SPHelper.getInstance().setProtocolAgree(true);
                    SplashActivity.this.onAgreeProtocol(100L);
                }

                @Override // com.ipotensic.potensicpro.view.dialog.PrivacyDialog.OnAgreeListener
                public void onDisagree() {
                    new ProtocolNotAgreeDialog(SplashActivity.this).show();
                }
            }).show();
        } else {
            onAgreeProtocol(SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
        PermissionUtil.hasStoragePermission(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAgreeProtocol(long j) {
        PhoneConfig.mainHandler.postDelayed(new Runnable() { // from class: com.ipotensic.potensicpro.activities.SplashActivity.2
            @Override // java.lang.Runnable
            public void run() {
                DDLog.e("splash \u5f00\u59cb\u542f\u52a8... : " + ActivityHelper.getInstance().isActivityRunning(PhoneConfig.usrToken == null ? LoginActivity.class : MainActivity.class));
                if (!ActivityHelper.getInstance().isActivityRunning(PhoneConfig.usrToken == null ? LoginActivity.class : MainActivity.class)) {
                    if (SplashActivity.this.isResume) {
                        DDLog.e("splash \u8fdb\u5165\u4e0b\u4e00\u4e2a\u9875\u9762");
                        SplashActivity.this.startActivity(new Intent(SplashActivity.this, (Class<?>) (PhoneConfig.usrToken == null ? LoginActivity.class : MainActivity.class)));
                    }
                    DDLog.e("splash \u5faa\u73af");
                    PhoneConfig.mainHandler.postDelayed(this, 1000L);
                    return;
                }
                SplashActivity.this.finish();
            }
        }, j);
    }

    private void initView() {
        this.tvExplain = (TextView) findViewById(R.id.tv_explain);
        this.layoutIndicator = (LinearLayout) findViewById(R.id.layout_indicator);
        this.btnStart = (Button) findViewById(R.id.btn_start);
        this.viewPager = (ViewPager) findViewById(R.id.view_pager);
        this.btnSkip = (TextView) findViewById(R.id.btn_skip);
        setOnClickListener();
    }

    private void setOnClickListener() {
        this.btnSkip.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.activities.SplashActivity.3
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                Intent intent;
                if (PhoneConfig.usrToken != null) {
                    intent = new Intent(SplashActivity.this, (Class<?>) MainActivity.class);
                } else {
                    intent = new Intent(SplashActivity.this, (Class<?>) LoginActivity.class);
                }
                SplashActivity.this.startActivity(intent);
            }
        });
        this.btnStart.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.activities.SplashActivity.4
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                Intent intent;
                if (PhoneConfig.usrToken != null) {
                    intent = new Intent(SplashActivity.this, (Class<?>) MainActivity.class);
                } else {
                    intent = new Intent(SplashActivity.this, (Class<?>) LoginActivity.class);
                }
                SplashActivity.this.startActivity(intent);
            }
        });
    }

    private void initData() {
        this.explains = getResources().getStringArray(R.array.welcome_speech);
        View inflate = LayoutInflater.from(this).inflate(R.layout.view_splash_l, (ViewGroup) null);
        View inflate2 = LayoutInflater.from(this).inflate(R.layout.view_splash_ll, (ViewGroup) null);
        View inflate3 = LayoutInflater.from(this).inflate(R.layout.view_splash_lll, (ViewGroup) null);
        addPage(inflate);
        addPage(inflate2);
        addPage(inflate3);
        ViewAdapter viewAdapter = new ViewAdapter();
        this.adapter = viewAdapter;
        this.viewPager.setAdapter(viewAdapter);
        setIndicator(0);
        this.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.ipotensic.potensicpro.activities.SplashActivity.5
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                SplashActivity.this.setIndicator(i);
            }
        });
    }

    private void addPage(View view) {
        this.pages.add(view);
        ImageView imageView = new ImageView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i = 4;
        try {
            i = UnitUtil.dp2px(4);
        } catch (Exception e) {
            DDLog.e(TAG, "dp2px\u8f6c\u6362\u51fa\u9519", e);
        }
        layoutParams.setMargins(i, i, i, i);
        imageView.setImageResource(R.drawable.level_splash_indicator);
        LinearLayout linearLayout = this.layoutIndicator;
        if (linearLayout != null) {
            linearLayout.addView(imageView, layoutParams);
        }
        ArrayList<ImageView> arrayList = this.indicators;
        if (arrayList != null) {
            arrayList.add(imageView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIndicator(int i) {
        int size = this.pages.size() - 1;
        if (i > size) {
            return;
        }
        this.tvExplain.setText(this.explains[i]);
        for (int i2 = 0; i2 < this.pages.size(); i2++) {
            if (i2 == i) {
                this.indicators.get(i2).setImageLevel(1);
            } else {
                this.indicators.get(i2).setImageLevel(0);
            }
        }
        if (i == size) {
            this.btnSkip.setVisibility(8);
            this.btnStart.setVisibility(0);
        } else {
            this.btnSkip.setVisibility(0);
            this.btnStart.setVisibility(4);
        }
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private class ViewAdapter extends PagerAdapter {
        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        private ViewAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return SplashActivity.this.pages.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = (View) SplashActivity.this.pages.get(i);
            if (viewGroup != null) {
                viewGroup.addView(view);
            }
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) SplashActivity.this.pages.get(i));
        }
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.isResume = false;
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.isResume = true;
    }
}