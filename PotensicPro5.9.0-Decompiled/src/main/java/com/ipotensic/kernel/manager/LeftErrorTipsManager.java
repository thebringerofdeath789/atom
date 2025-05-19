package com.ipotensic.kernel.manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.utils.AnimationUtil;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class LeftErrorTipsManager {
    private static volatile LeftErrorTipsManager instance;
    private LinearLayout leftErrorTipView;
    private Thread showItemThread;
    private List<View> items = new LinkedList();
    private final byte[] lock = new byte[1];
    private boolean isStart = false;
    private final long DISMISS_TIME = 5000;
    private final List<ViewTimeoutRunnable> timeoutRunnable = new ArrayList();

    private LeftErrorTipsManager() {
    }

    public static LeftErrorTipsManager get() {
        if (instance == null) {
            synchronized (LeftErrorTipsManager.class) {
                if (instance == null) {
                    LeftErrorTipsManager leftErrorTipsManager = new LeftErrorTipsManager();
                    instance = leftErrorTipsManager;
                    return leftErrorTipsManager;
                }
            }
        }
        return instance;
    }

    public void init(Context context, int i) {
        if (i == -1 || this.leftErrorTipView == null) {
            return;
        }
        DDLog.e("开始显示");
        View inflate = LayoutInflater.from(context).inflate(R.layout.view_layout_left_error_tip_item, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_tip_msg);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_tip_title);
        textView.setTypeface(PhoneConfig.typeface);
        textView2.setTypeface(PhoneConfig.typeface);
        textView.setText(context.getString(i));
        inflate.setTag(Integer.valueOf(i));
        addView(inflate);
    }

    public void stop() {
        synchronized (this.lock) {
            this.items.clear();
            this.isStart = false;
            this.lock.notify();
            this.leftErrorTipView.removeAllViews();
        }
    }

    public boolean isStart() {
        return this.isStart;
    }

    public void setView(LinearLayout linearLayout) {
        this.leftErrorTipView = linearLayout;
    }

    private void addView(View view) {
        List<View> list = this.items;
        if (list == null || list.contains(view)) {
            return;
        }
        this.items.add(view);
    }

    public void start() {
        if (this.isStart) {
            return;
        }
        this.isStart = true;
        if (this.showItemThread == null) {
            Thread thread = new Thread(new Runnable() { // from class: com.ipotensic.kernel.manager.LeftErrorTipsManager.1
                @Override // java.lang.Runnable
                public void run() {
                    LeftErrorTipsManager leftErrorTipsManager;
                    while (LeftErrorTipsManager.this.isStart) {
                        synchronized (LeftErrorTipsManager.this.lock) {
                            try {
                                try {
                                    if (LeftErrorTipsManager.this.items != null && LeftErrorTipsManager.this.items.size() > 0) {
                                        if (LeftErrorTipsManager.this.leftErrorTipView.getChildCount() == 3) {
                                            LeftErrorTipsManager.this.lock.wait();
                                        }
                                        PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.kernel.manager.LeftErrorTipsManager.1.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                LeftErrorTipsManager.this.showInfo();
                                            }
                                        });
                                        LeftErrorTipsManager.this.lock.wait();
                                    }
                                    Thread.sleep(100L);
                                    LeftErrorTipsManager.this.isStart = false;
                                    leftErrorTipsManager = LeftErrorTipsManager.this;
                                } finally {
                                }
                            } catch (Exception e) {
                                DDLog.e(e.getMessage());
                                LeftErrorTipsManager.this.isStart = false;
                                leftErrorTipsManager = LeftErrorTipsManager.this;
                            }
                            leftErrorTipsManager.showItemThread = null;
                        }
                    }
                }
            });
            this.showItemThread = thread;
            thread.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showInfo() {
        synchronized (this.lock) {
            if (this.items.size() > 0) {
                View remove = this.items.remove(0);
                if (getSameShowingView(remove) == null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.bottomMargin = 10;
                    this.leftErrorTipView.addView(remove, 0, layoutParams);
                    AnimationUtil.transInLeft(remove);
                    ViewTimeoutRunnable viewTimeoutRunnable = new ViewTimeoutRunnable(remove);
                    PhoneConfig.mainHandler.postDelayed(viewTimeoutRunnable, 5000L);
                    this.timeoutRunnable.add(viewTimeoutRunnable);
                } else {
                    DDLog.e("正在显示");
                    ViewTimeoutRunnable timeoutRunnable = getTimeoutRunnable(remove);
                    if (timeoutRunnable != null) {
                        PhoneConfig.mainHandler.removeCallbacks(timeoutRunnable);
                        PhoneConfig.mainHandler.postDelayed(timeoutRunnable, 5000L);
                    }
                }
            }
            this.lock.notify();
        }
    }

    private ViewTimeoutRunnable getTimeoutRunnable(View view) {
        ViewTimeoutRunnable viewTimeoutRunnable;
        if (this.timeoutRunnable.size() == 0) {
            return null;
        }
        for (int i = 0; i < this.timeoutRunnable.size(); i++) {
            try {
                viewTimeoutRunnable = this.timeoutRunnable.get(i);
            } catch (Exception unused) {
            }
            if (viewTimeoutRunnable.view.getId() == view.getId()) {
                return viewTimeoutRunnable;
            }
        }
        return null;
    }

    private View getSameShowingView(View view) {
        LinearLayout linearLayout;
        int childCount;
        if (view.getTag() == null || (linearLayout = this.leftErrorTipView) == null || (childCount = linearLayout.getChildCount()) == 0) {
            return null;
        }
        int intValue = ((Integer) view.getTag()).intValue();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.leftErrorTipView.getChildAt(i);
            if (childAt.getTag() != null) {
                try {
                    if (((Integer) childAt.getTag()).intValue() == intValue) {
                        return childAt;
                    }
                } catch (Exception unused) {
                    continue;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideInfo(View view) {
        view.setVisibility(8);
        this.leftErrorTipView.removeView(view);
        synchronized (this.lock) {
            this.lock.notify();
        }
    }

    private class ViewTimeoutRunnable implements Runnable {
        public View view;

        public ViewTimeoutRunnable(View view) {
            this.view = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            LeftErrorTipsManager.this.hideInfo(this.view);
            LeftErrorTipsManager.this.timeoutRunnable.remove(this);
        }
    }
}
