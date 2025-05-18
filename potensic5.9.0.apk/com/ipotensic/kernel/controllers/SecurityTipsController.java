package com.ipotensic.kernel.controllers;

import android.animation.Animator;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pools;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.utils.LanguageHelper;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.utils.Conditions;
import com.logan.flight.FlightConfig;
import com.logan.user.model.rev.RevUserSecurityTipsData;
import com.logan.user.presenter.UserRequestPresenter;
import com.logan.user.view.ISecurityTipsView;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes2.dex */
public class SecurityTipsController extends BaseController {
    private static final String TAG = "SecurityTipsController";
    private final int MSG_TIP_ADD;
    private final int MSG_TIP_ANIMATE;
    private final int MSG_TIP_DELETE;
    private final Handler handler;
    private int index;
    private LinearLayout securityTips;
    private int showDuration;
    private int showInterval;
    private TextView textView;
    private Pools.SimplePool<TextView> textViewPool;
    private String[] texts;
    private int time;
    private Timer timer;
    private LayoutTransition transition;

    static /* synthetic */ int access$1110(SecurityTipsController securityTipsController) {
        int i = securityTipsController.time;
        securityTipsController.time = i - 1;
        return i;
    }

    static /* synthetic */ int access$408(SecurityTipsController securityTipsController) {
        int i = securityTipsController.index;
        securityTipsController.index = i + 1;
        return i;
    }

    public SecurityTipsController(AppCompatActivity appCompatActivity, View view) {
        super(appCompatActivity, view);
        this.texts = new String[0];
        this.index = 0;
        this.MSG_TIP_ADD = 0;
        this.MSG_TIP_ANIMATE = 1;
        this.MSG_TIP_DELETE = 2;
        this.handler = new Handler(Looper.getMainLooper()) { // from class: com.ipotensic.kernel.controllers.SecurityTipsController.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                int i = message.what;
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            return;
                        }
                        SecurityTipsController.this.securityTips.removeAllViews();
                        return;
                    } else {
                        try {
                            if (SecurityTipsController.this.securityTips.getChildCount() > 0) {
                                SecurityTipsController.this.securityTips.getChildAt(0).animate().alpha(0.0f).setDuration(SecurityTipsController.this.transition.getDuration(2)).start();
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            DDLog.m1685e(SecurityTipsController.TAG, "MSG_TIP_ANIMATE exception is " + e.getMessage());
                            return;
                        }
                    }
                }
                try {
                    if ((FlightConfig.isConnectFlight() || Conditions.isFlying()) && SPHelper.getInstance().isShowFlightTips() && !PhoneConfig.isKernelActivityPause) {
                        TextView securityTipsTextView = SecurityTipsController.this.securityTipsTextView();
                        if (securityTipsTextView != null) {
                            if (SecurityTipsController.this.securityTips.getChildCount() > 0) {
                                SecurityTipsController.this.securityTips.removeAllViews();
                            }
                            SecurityTipsController.this.securityTips.addView(securityTipsTextView);
                        }
                        sendEmptyMessageDelayed(0, (SecurityTipsController.this.showDuration + SecurityTipsController.this.showInterval) * 1000);
                        SecurityTipsController.access$408(SecurityTipsController.this);
                        if (SecurityTipsController.this.index >= SecurityTipsController.this.texts.length) {
                            SecurityTipsController.this.index = 0;
                            SecurityTipsController.this.randomSort();
                        }
                    }
                } catch (Exception e2) {
                    DDLog.m1685e(SecurityTipsController.TAG, "MSG_TIP_ADD exception is " + e2.getMessage());
                }
            }
        };
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        this.securityTips = (LinearLayout) view.findViewById(C1965R.id.security_tips_container);
        if (isSupportedModels() && SPHelper.getInstance().isShowFlightTips()) {
            requestSecurityTips();
            this.transition = new LayoutTransition();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat((Object) null, "alpha", 0.0f, 1.0f);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.ipotensic.kernel.controllers.SecurityTipsController.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (SecurityTipsController.this.securityTips.getChildCount() >= 1) {
                        SecurityTipsController.this.handler.sendEmptyMessageDelayed(1, SecurityTipsController.this.showDuration * 1000);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (SecurityTipsController.this.securityTips.getChildCount() >= 1) {
                        SecurityTipsController.this.handler.sendEmptyMessageDelayed(2, SecurityTipsController.this.showDuration * 1000);
                    }
                }
            });
            this.transition.setAnimator(2, ofFloat);
            this.transition.setAnimator(3, ObjectAnimator.ofPropertyValuesHolder(null, PropertyValuesHolder.ofFloat("alpha", 0.0f, 0.0f)).setDuration(this.transition.getDuration(3)));
            this.securityTips.setLayoutTransition(this.transition);
        }
    }

    private void requestSecurityTips() {
        UserRequestPresenter.getInstance().getSecurityTips(PhoneConfig.usrToken, LanguageHelper.getLanguageType(getContext()), new ISecurityTipsView() { // from class: com.ipotensic.kernel.controllers.SecurityTipsController.3
            @Override // com.logan.user.view.ISecurityTipsView
            public void success(RevUserSecurityTipsData.SecurityTip securityTip) {
                DDLog.m1685e(SecurityTipsController.TAG, "getSecurityTips success");
                SecurityTipsController.this.parseSecurityTip(securityTip);
                SPHelper.getInstance().setSecurityTips(JSON.toJSONString(securityTip));
            }

            @Override // com.logan.user.view.ISecurityTipsView
            public void fail(int i) {
                DDLog.m1685e(SecurityTipsController.TAG, "getSecurityTips fail");
                if (SecurityTipsController.this.texts.length != 0 || SPHelper.getInstance().getSecurityTips() == null) {
                    return;
                }
                SecurityTipsController.this.parseSecurityTip((RevUserSecurityTipsData.SecurityTip) JSONObject.parseObject(SPHelper.getInstance().getSecurityTips(), RevUserSecurityTipsData.SecurityTip.class));
            }
        });
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.kernel.utils.SimpleLifeCycle
    public void onResume() {
        if (FlightConfig.isConnectFlight()) {
            startCountDown(60);
        }
    }

    private boolean isSupportedModels() {
        return FlightConfig.isAtomPanTilt() || FlightConfig.is_Atom_SE_Series() || FlightConfig.isAtomLT();
    }

    public void isMapMode(boolean z) {
        LinearLayout linearLayout = this.securityTips;
        if (linearLayout != null) {
            linearLayout.setVisibility(z ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseSecurityTip(RevUserSecurityTipsData.SecurityTip securityTip) {
        if (securityTip == null) {
            return;
        }
        this.texts = securityTip.getContent();
        this.textViewPool = new Pools.SimplePool<>(this.texts.length);
        this.showDuration = securityTip.getShow_duration();
        this.showInterval = securityTip.getShow_interval();
        DDLog.m1685e(TAG, "getSecurityTips showDuration=" + this.showDuration + ",showInterval=" + this.showInterval);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TextView securityTipsTextView() {
        Pools.SimplePool<TextView> simplePool = this.textViewPool;
        if (simplePool == null) {
            return null;
        }
        TextView acquire = simplePool.acquire();
        this.textView = acquire;
        if (acquire == null) {
            TextView textView = new TextView(getContext());
            this.textView = textView;
            textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.textView.setMaxLines(3);
            this.textView.setEllipsize(TextUtils.TruncateAt.END);
            this.textView.setGravity(3);
            this.textView.setTextSize(14.0f);
            this.textView.setTextColor(getContext().getResources().getColor(C1965R.color.white));
            this.textView.setText(this.texts[this.index]);
            return this.textView;
        }
        acquire.setText(this.texts[this.index]);
        return this.textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void randomSort() {
        for (int i = 0; i < this.texts.length; i++) {
            int nextInt = new Random().nextInt(this.texts.length);
            String[] strArr = this.texts;
            String str = strArr[nextInt];
            strArr[nextInt] = strArr[i];
            strArr[i] = str;
        }
    }

    private void startCountDown(int i) {
        if (isSupportedModels() && SPHelper.getInstance().isShowFlightTips() && this.timer == null) {
            this.time = i;
            this.timer = new Timer();
            DDLog.m1685e(TAG, "startCountDown time =" + this.time);
            this.timer.schedule(new TimerTask() { // from class: com.ipotensic.kernel.controllers.SecurityTipsController.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (SecurityTipsController.this.time < 0) {
                        DDLog.m1685e(SecurityTipsController.TAG, "stopCountDown time =" + SecurityTipsController.this.time);
                        SecurityTipsController.this.stopCountDown();
                        SecurityTipsController.this.handler.sendEmptyMessage(0);
                        return;
                    }
                    SecurityTipsController.access$1110(SecurityTipsController.this);
                }
            }, 0L, 1000L);
        }
    }

    public void stopCountDown() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
    }

    /* renamed from: com.ipotensic.kernel.controllers.SecurityTipsController$5 */
    static /* synthetic */ class C21815 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.FLIGHT_CONNECT_STATE_CHANGED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_SHOW_FLIGHT_TIPS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        TextView textView;
        super.onEvent(eventID, event);
        int i = C21815.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return;
            }
            boolean booleanValue = ((Boolean) event.obj).booleanValue();
            if (FlightConfig.isConnectFlight() && booleanValue && this.timer == null) {
                requestSecurityTips();
                startCountDown(60);
                return;
            } else {
                if (booleanValue || this.timer == null) {
                    return;
                }
                stopCountDown();
                return;
            }
        }
        boolean booleanValue2 = ((Boolean) event.obj).booleanValue();
        DDLog.m1685e(TAG, "连接状态：" + booleanValue2);
        if (SPHelper.getInstance().isShowFlightTips()) {
            if (booleanValue2 && this.timer == null) {
                startCountDown(60);
            } else if (!booleanValue2 && this.timer != null) {
                stopCountDown();
            }
            if (!booleanValue2 && Conditions.isFlying() && (textView = this.textView) != null) {
                textView.setTextColor(getContext().getResources().getColor(C1965R.color.color_white_fifty_percent));
            }
            if (booleanValue2 || this.securityTips.getChildCount() <= 0) {
                return;
            }
            this.securityTips.removeAllViews();
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.kernel.utils.SimpleLifeCycle
    public void onPause() {
        super.onPause();
        stopCountDown();
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.kernel.utils.SimpleLifeCycle
    public void onDestroy() {
        super.onDestroy();
        this.handler.removeCallbacksAndMessages(null);
        UserRequestPresenter.getInstance().removeSecurityTipsView();
    }
}