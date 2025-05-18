package com.ipotensic.kernel.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.utils.UnitUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class HorizontalWheelView extends HorizontalScrollView {
    private static final String COLOR_SELECT = "#00FF0A";
    private static final String COLOR_UNSELECT = "#B3FFFFFF";
    private static final String COLOR_UNSELECT_MARGIN = "#33FFFFFF";
    public static final String TAG = "HorizontalWheelView";
    public final int OFF_SET_DEFAULT;
    private Context context;
    private long currentMS;
    int displayItemCount;
    private float downX;
    private float downY;
    int initialX;
    private boolean isControlFrequency;
    private boolean isInterrupt;
    private int itemWidth;
    List<String> items;
    private long lastClickTime;
    private long moveTime;
    private float moveX;
    private float moveY;
    private boolean needAppendFps;
    int newCheck;
    int offset;
    private int offsetX;
    private OnWheelViewListener onWheelViewListener;
    private int parentWidth;
    Runnable scrollerTask;
    int[] selectedAreaBorder;
    int selectedIndex;
    private LinearLayout views;

    public interface OnWheelViewListener {
        void onSelected(int i, String str);

        void onTouch();
    }

    public HorizontalWheelView(Context context) {
        super(context);
        this.OFF_SET_DEFAULT = 2;
        this.offset = 2;
        this.selectedIndex = 1;
        this.newCheck = 50;
        this.offsetX = 0;
        this.downY = 0.0f;
        this.moveY = 0.0f;
        this.moveTime = 0L;
        init(context);
    }

    public HorizontalWheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.OFF_SET_DEFAULT = 2;
        this.offset = 2;
        this.selectedIndex = 1;
        this.newCheck = 50;
        this.offsetX = 0;
        this.downY = 0.0f;
        this.moveY = 0.0f;
        this.moveTime = 0L;
        init(context);
    }

    public HorizontalWheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.OFF_SET_DEFAULT = 2;
        this.offset = 2;
        this.selectedIndex = 1;
        this.newCheck = 50;
        this.offsetX = 0;
        this.downY = 0.0f;
        this.moveY = 0.0f;
        this.moveTime = 0L;
        init(context);
    }

    public void setItems(int i, List<String> list, int i2) {
        if (this.items == null) {
            this.items = new ArrayList();
        }
        this.itemWidth = 0;
        this.items.clear();
        this.items.addAll(list);
        this.parentWidth = i;
        for (int i3 = 0; i3 < this.offset; i3++) {
            this.items.add(0, "");
            this.items.add("");
        }
        initData(i2);
        String str = TAG;
        DDLog.m1685e(str, "parent width = " + i);
        DDLog.m1685e(str, "item width = " + this.itemWidth);
    }

    private void init(Context context) {
        this.context = context;
        setHorizontalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.views = linearLayout;
        linearLayout.setOrientation(0);
        addView(this.views);
        this.scrollerTask = new Runnable() { // from class: com.ipotensic.kernel.view.-$$Lambda$HorizontalWheelView$HakKY0RQIvt1Gyur4yaPd3jEjks
            @Override // java.lang.Runnable
            public final void run() {
                HorizontalWheelView.this.lambda$init$2$HorizontalWheelView();
            }
        };
    }

    public /* synthetic */ void lambda$init$2$HorizontalWheelView() {
        int scrollX = getScrollX() - this.offsetX;
        int i = this.initialX;
        if (i - scrollX == 0) {
            int i2 = this.itemWidth;
            final int i3 = i % i2;
            final int i4 = i / i2;
            if (i3 == 0) {
                int i5 = this.offset;
                if (i4 + i5 == this.selectedIndex) {
                    return;
                }
                this.selectedIndex = i4 + i5;
                onSelectedCallBack();
                return;
            }
            if (i3 > i2 / 2) {
                post(new Runnable() { // from class: com.ipotensic.kernel.view.-$$Lambda$HorizontalWheelView$P0y1bXB7yhLF604wfeUjVx0Ff28
                    @Override // java.lang.Runnable
                    public final void run() {
                        HorizontalWheelView.this.lambda$init$0$HorizontalWheelView(i3, i4);
                    }
                });
                return;
            } else {
                post(new Runnable() { // from class: com.ipotensic.kernel.view.-$$Lambda$HorizontalWheelView$4IIM_z1PGH9BuPhT-LIEt6koxNA
                    @Override // java.lang.Runnable
                    public final void run() {
                        HorizontalWheelView.this.lambda$init$1$HorizontalWheelView(i3, i4);
                    }
                });
                return;
            }
        }
        this.initialX = getScrollX() - this.offsetX;
        postDelayed(this.scrollerTask, this.newCheck);
    }

    public /* synthetic */ void lambda$init$0$HorizontalWheelView(int i, int i2) {
        smoothScrollTo((this.initialX - i) + this.itemWidth + this.offsetX, 0);
        int i3 = this.offset;
        if (i2 + i3 + 1 == this.selectedIndex) {
            return;
        }
        this.selectedIndex = i2 + i3 + 1;
        onSelectedCallBack();
    }

    public /* synthetic */ void lambda$init$1$HorizontalWheelView(int i, int i2) {
        smoothScrollTo((this.initialX - i) + this.offsetX, 0);
        int i3 = this.offset;
        if (i2 + i3 == this.selectedIndex) {
            return;
        }
        this.selectedIndex = i2 + i3;
        onSelectedCallBack();
    }

    public void startScrollerTask() {
        this.initialX = getScrollX() - this.offsetX;
        postDelayed(this.scrollerTask, this.newCheck);
    }

    public void updateViews(final int i, final int i2) {
        if (this.parentWidth == i) {
            return;
        }
        this.parentWidth = i;
        this.displayItemCount = (this.offset * 2) + 1;
        int dip2px = UnitUtil.dip2px(50.0f);
        this.itemWidth = dip2px;
        int i3 = this.displayItemCount;
        if (i / i3 > dip2px) {
            this.itemWidth = i / i3;
            this.offsetX = 0;
        } else {
            this.offsetX = ((i3 * dip2px) - i) / 2;
        }
        post(new Runnable() { // from class: com.ipotensic.kernel.view.-$$Lambda$HorizontalWheelView$taLdFU2gmhTac-7DZvILsMQ7JXc
            @Override // java.lang.Runnable
            public final void run() {
                HorizontalWheelView.this.lambda$updateViews$3$HorizontalWheelView(i, i2);
            }
        });
    }

    public /* synthetic */ void lambda$updateViews$3$HorizontalWheelView(int i, int i2) {
        this.views.setLayoutParams(new FrameLayout.LayoutParams(this.offsetX + i, -2));
        setLayoutParams(new LinearLayout.LayoutParams(i + this.offsetX, ((LinearLayout.LayoutParams) getLayoutParams()).height));
        refreshItemView(this.itemWidth * i2);
        setSelection(i2);
    }

    private void initData(final int i) {
        this.displayItemCount = (this.offset * 2) + 1;
        int dip2px = UnitUtil.dip2px(50.0f);
        this.itemWidth = dip2px;
        int i2 = this.parentWidth;
        int i3 = this.displayItemCount;
        if (i2 / i3 > dip2px) {
            this.itemWidth = i2 / i3;
            this.offsetX = 0;
        } else {
            this.offsetX = ((i3 * dip2px) - i2) / 2;
        }
        this.views.removeAllViews();
        for (int i4 = 0; i4 < this.items.size(); i4++) {
            this.views.addView(createView(this.items.get(i4)));
        }
        post(new Runnable() { // from class: com.ipotensic.kernel.view.-$$Lambda$HorizontalWheelView$mRQt9Hgv4lu_UDrfO_DMQKgWsGg
            @Override // java.lang.Runnable
            public final void run() {
                HorizontalWheelView.this.lambda$initData$4$HorizontalWheelView(i);
            }
        });
    }

    public /* synthetic */ void lambda$initData$4$HorizontalWheelView(int i) {
        this.views.setLayoutParams(new FrameLayout.LayoutParams(this.parentWidth + this.offsetX, -2));
        setLayoutParams(new LinearLayout.LayoutParams(this.parentWidth + this.offsetX, ((LinearLayout.LayoutParams) getLayoutParams()).height));
        refreshItemView(this.itemWidth * i);
        setSelection(i);
    }

    private TextView createView(String str) {
        TextView textView = new TextView(this.context);
        textView.setLayoutParams(new FrameLayout.LayoutParams(this.itemWidth, -2));
        textView.setSingleLine(true);
        textView.setTextSize(2, 14.0f);
        if (str.startsWith("1080")) {
            textView.setTextSize(2, 13.0f);
        }
        textView.setText(str);
        if (this.needAppendFps && !TextUtils.isEmpty(str)) {
            textView.setText(str + "fps");
        }
        if (str.endsWith("P") || str.endsWith("K")) {
            textView.setText(str.substring(0, str.length() - 1) + str.substring(str.length() - 1));
        }
        textView.setGravity(17);
        textView.setPadding(0, UnitUtil.dp2px(8), 0, 0);
        return textView;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        refreshItemView(i - this.offsetX);
    }

    public void refreshItemView(int i) {
        int i2 = this.itemWidth;
        int i3 = this.offset;
        int i4 = (i / i2) + i3;
        int i5 = i % i2;
        int i6 = i / i2;
        if (i5 == 0) {
            i4 = i6 + i3;
        } else if (i5 > i2 / 2) {
            i4 = i6 + i3 + 1;
        }
        int childCount = this.views.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            TextView textView = (TextView) this.views.getChildAt(i7);
            if (textView == null) {
                return;
            }
            if (i4 == i7) {
                textView.setTextColor(Color.parseColor(COLOR_SELECT));
            } else if (i4 == i7 - 1 || i4 == i7 + 1) {
                textView.setTextColor(Color.parseColor(COLOR_UNSELECT));
            } else {
                textView.setTextColor(Color.parseColor(COLOR_UNSELECT_MARGIN));
            }
        }
    }

    private int[] obtainSelectedAreaBorder() {
        if (this.selectedAreaBorder == null) {
            this.selectedAreaBorder = new int[]{r2 * r3, r2 * (r3 + 1)};
            int i = this.itemWidth;
            int i2 = this.offset;
        }
        return this.selectedAreaBorder;
    }

    private void onSelectedCallBack() {
        if (this.onWheelViewListener == null || TextUtils.isEmpty(this.items.get(this.selectedIndex))) {
            return;
        }
        OnWheelViewListener onWheelViewListener = this.onWheelViewListener;
        int i = this.selectedIndex;
        onWheelViewListener.onSelected(i - this.offset, this.items.get(i));
    }

    public void setSelection(final int i) {
        this.selectedIndex = this.offset + i;
        post(new Runnable() { // from class: com.ipotensic.kernel.view.-$$Lambda$HorizontalWheelView$M1FKI4-MAR1_6iRtboXyzEctD-I
            @Override // java.lang.Runnable
            public final void run() {
                HorizontalWheelView.this.lambda$setSelection$5$HorizontalWheelView(i);
            }
        });
    }

    public /* synthetic */ void lambda$setSelection$5$HorizontalWheelView(int i) {
        smoothScrollTo((i * this.itemWidth) + this.offsetX, 0);
    }

    @Override // android.widget.HorizontalScrollView
    public void fling(int i) {
        super.fling(i / 3);
    }

    public void setControlFrequency(boolean z) {
        this.isControlFrequency = z;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((this.isControlFrequency && System.currentTimeMillis() < this.lastClickTime + 1200) || this.isInterrupt) {
            if (motionEvent.getAction() == 0) {
                this.isInterrupt = true;
            } else if (motionEvent.getAction() == 1) {
                this.isInterrupt = false;
            }
            return true;
        }
        OnWheelViewListener onWheelViewListener = this.onWheelViewListener;
        if (onWheelViewListener != null) {
            onWheelViewListener.onTouch();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.downX = motionEvent.getX();
            this.downY = motionEvent.getY();
            this.currentMS = System.currentTimeMillis();
        } else if (action == 1) {
            this.lastClickTime = System.currentTimeMillis();
            this.moveTime = System.currentTimeMillis() - this.currentMS;
            this.moveX = motionEvent.getX() - this.downX;
            this.moveY = motionEvent.getY() - this.downY;
            if (this.moveTime < 300 && Math.abs(this.moveX) < 20.0f && Math.abs(this.moveY) < 20.0f) {
                int x = (int) ((motionEvent.getX() + this.offsetX) / this.itemWidth);
                int i = this.selectedIndex;
                int i2 = (x + i) - 2;
                if (i2 != i && i2 >= 2 && i2 < this.items.size() - 2) {
                    setSelection(i2 - 2);
                    onSelectedCallBack();
                }
            } else {
                startScrollerTask();
            }
            this.moveY = 0.0f;
            this.moveX = 0.0f;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnWheelViewListener(OnWheelViewListener onWheelViewListener) {
        this.onWheelViewListener = onWheelViewListener;
    }

    public void setNeedAppendFps(boolean z) {
        this.needAppendFps = z;
    }
}