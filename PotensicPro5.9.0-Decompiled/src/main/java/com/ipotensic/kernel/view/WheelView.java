package com.ipotensic.kernel.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.logan.flight.FlightConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class WheelView extends ScrollView {
    private final String COLOR_SELECT;
    private final String COLOR_UNSELECT;
    public final String TAG;
    private Context context;
    private int displayItemCount;
    private boolean hasUnit;
    private int initialY;
    private int itemHeight;
    private final List<String> items;
    private int lastPosition;
    private final int newCheck;
    private int offset;
    private OnWheelViewListener onWheelViewListener;
    private int selectedIndex;
    private final List<String> tempList;
    private int[] unitArr;
    private LinearLayout views;

    public interface OnWheelViewListener {
        void onSelected(WheelView wheelView, int i, String str);
    }

    public WheelView(Context context) {
        super(context);
        this.TAG = WheelView.class.getSimpleName();
        this.COLOR_SELECT = "#00FF0A";
        this.COLOR_UNSELECT = "#FFFFFF";
        this.newCheck = 1;
        this.items = new ArrayList();
        this.tempList = new ArrayList();
        this.offset = 1;
        this.hasUnit = false;
        this.unitArr = null;
        this.selectedIndex = 1;
        this.itemHeight = 0;
        init(context);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = WheelView.class.getSimpleName();
        this.COLOR_SELECT = "#00FF0A";
        this.COLOR_UNSELECT = "#FFFFFF";
        this.newCheck = 1;
        this.items = new ArrayList();
        this.tempList = new ArrayList();
        this.offset = 1;
        this.hasUnit = false;
        this.unitArr = null;
        this.selectedIndex = 1;
        this.itemHeight = 0;
        init(context);
    }

    public WheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = WheelView.class.getSimpleName();
        this.COLOR_SELECT = "#00FF0A";
        this.COLOR_UNSELECT = "#FFFFFF";
        this.newCheck = 1;
        this.items = new ArrayList();
        this.tempList = new ArrayList();
        this.offset = 1;
        this.hasUnit = false;
        this.unitArr = null;
        this.selectedIndex = 1;
        this.itemHeight = 0;
        init(context);
    }

    private void setItems(List<String> list, boolean z) {
        this.tempList.clear();
        this.tempList.addAll(list);
        for (int i = 0; i < this.offset; i++) {
            this.tempList.add(0, "");
            this.tempList.add("");
        }
        this.items.clear();
        this.items.addAll(this.tempList);
        initData();
    }

    public void setItems(String[] strArr) {
        setItems(Arrays.asList(strArr), false);
    }

    public void setItems(int[] iArr) {
        this.hasUnit = false;
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            arrayList.add("" + i);
        }
        setItems(arrayList, false);
    }

    public void setItemsWithUnit(int[] iArr, boolean z) {
        this.hasUnit = true;
        this.unitArr = iArr;
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            arrayList.add("" + i);
        }
        setItems(arrayList, z);
    }

    public void onUnitChanged() {
        if (this.hasUnit) {
            setItemsWithUnit(this.unitArr, true);
            refreshItemView((this.selectedIndex - this.offset) * this.itemHeight);
        }
    }

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int i) {
        this.offset = i;
    }

    private void init(Context context) {
        this.context = context;
        setVerticalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.views = linearLayout;
        linearLayout.setOrientation(1);
        addView(this.views);
    }

    private class ScrollTask implements Runnable {
        private ScrollTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (WheelView.this.initialY - WheelView.this.getScrollY() == 0) {
                final int i = WheelView.this.initialY % WheelView.this.itemHeight;
                final int i2 = WheelView.this.initialY / WheelView.this.itemHeight;
                if (i != 0) {
                    if (i > WheelView.this.itemHeight / 2) {
                        WheelView.this.post(new Runnable() { // from class: com.ipotensic.kernel.view.WheelView.ScrollTask.1
                            @Override // java.lang.Runnable
                            public void run() {
                                WheelView.this.smoothScrollTo(0, (WheelView.this.initialY - i) + WheelView.this.itemHeight);
                                WheelView.this.selectedIndex = i2 + WheelView.this.offset + 1;
                                WheelView.this.onSelectedCallBack();
                            }
                        });
                        return;
                    } else {
                        WheelView.this.post(new Runnable() { // from class: com.ipotensic.kernel.view.WheelView.ScrollTask.2
                            @Override // java.lang.Runnable
                            public void run() {
                                WheelView.this.smoothScrollTo(0, WheelView.this.initialY - i);
                                WheelView.this.selectedIndex = i2 + WheelView.this.offset;
                                WheelView.this.onSelectedCallBack();
                            }
                        });
                        return;
                    }
                }
                WheelView wheelView = WheelView.this;
                wheelView.selectedIndex = i2 + wheelView.offset;
                WheelView.this.onSelectedCallBack();
                return;
            }
            WheelView wheelView2 = WheelView.this;
            wheelView2.initialY = wheelView2.getScrollY();
            WheelView.this.postDelayed(this, 1L);
        }
    }

    public void startScrollerTask() {
        this.initialY = getScrollY();
        postDelayed(new ScrollTask(), 1L);
    }

    private void initData() {
        this.displayItemCount = (this.offset * 2) + 1;
        this.views.removeAllViews();
        for (int i = 0; i < this.items.size(); i++) {
            String str = this.items.get(i);
            if (this.hasUnit && i != 0 && i != this.items.size() - 1) {
                try {
                    str = FlightConfig.get_value(Integer.parseInt(str)) + (PhoneConfig.isFt ? "ft" : "m");
                } catch (Exception unused) {
                }
            }
            this.views.addView(createView(str));
        }
        refreshItemView(0);
    }

    private TextView createView(String str) {
        TextView textView = new TextView(this.context);
        textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        textView.setSingleLine(true);
        textView.setTextSize(2, 14.0f);
        textView.setText(str);
        textView.setGravity(17);
        textView.setPadding(40, 10, 40, 10);
        if (this.itemHeight == 0) {
            this.itemHeight = getViewMeasuredHeight(textView);
            this.views.setLayoutParams(new FrameLayout.LayoutParams(-1, this.itemHeight * this.displayItemCount));
            setLayoutParams(new LinearLayout.LayoutParams(((LinearLayout.LayoutParams) getLayoutParams()).width, this.itemHeight * this.displayItemCount));
        }
        return textView;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        refreshItemView(i2);
        this.lastPosition = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshItemView(int i) {
        int i2 = this.itemHeight;
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
            textView.getPaint().setFakeBoldText(true);
            if (i4 == i7) {
                textView.setTextColor(Color.parseColor("#00FF0A"));
                textView.setScaleX(1.2f);
                textView.setScaleY(1.2f);
            } else {
                textView.setTextColor(Color.parseColor("#FFFFFF"));
                textView.setScaleX(1.0f);
                textView.setScaleY(1.0f);
            }
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        setBackgroundDrawable(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSelectedCallBack() {
        try {
            OnWheelViewListener onWheelViewListener = this.onWheelViewListener;
            if (onWheelViewListener != null) {
                int i = this.selectedIndex;
                onWheelViewListener.onSelected(this, i, this.items.get(i));
            }
        } catch (Exception unused) {
        }
    }

    public void setSelection(final int i) {
        this.selectedIndex = this.offset + i;
        post(new Runnable() { // from class: com.ipotensic.kernel.view.WheelView.1
            @Override // java.lang.Runnable
            public void run() {
                if (WheelView.this.lastPosition == i * WheelView.this.itemHeight) {
                    WheelView wheelView = WheelView.this;
                    wheelView.refreshItemView(wheelView.lastPosition);
                } else {
                    WheelView wheelView2 = WheelView.this;
                    wheelView2.smoothScrollTo(0, i * wheelView2.itemHeight);
                }
            }
        });
    }

    public String getSelectedItem() {
        return this.items.get(this.selectedIndex);
    }

    public int getSelectedIndex() {
        return this.selectedIndex - this.offset;
    }

    @Override // android.widget.ScrollView
    public void fling(int i) {
        super.fling(i / 3);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            startScrollerTask();
        }
        return super.onTouchEvent(motionEvent);
    }

    public OnWheelViewListener getOnWheelViewListener() {
        return this.onWheelViewListener;
    }

    public void setOnWheelViewListener(OnWheelViewListener onWheelViewListener) {
        this.onWheelViewListener = onWheelViewListener;
    }

    private int getViewMeasuredHeight(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        return view.getMeasuredHeight();
    }
}
