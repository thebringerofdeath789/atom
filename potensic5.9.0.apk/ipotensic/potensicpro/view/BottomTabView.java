package com.ipotensic.potensicpro.view;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.ipotensic.baselib.utils.UnitUtil;
import com.ipotensic.potensicpro.R;
import com.ipotensic.potensicpro.activities.MainMediaController;
import com.ipotensic.potensicpro.adapter.MainPagerAdapter;

/* loaded from: classes2.dex */
public class BottomTabView extends LinearLayout implements View.OnClickListener {
    private final float ELEVATION;
    private final int PADDING;
    private AppCompatActivity activity;
    private MainPagerAdapter adapter;
    private Context context;
    private int curIndex;
    private BottomItemView[] itemViews;
    private MainMediaController mainMediaController;
    private onTabChangeListener onTabChangeListener;
    private int tabNum;

    public interface onTabChangeListener {
        boolean isAllowChange(int i);

        void onTabChanged(int i);
    }

    public BottomTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.PADDING = UnitUtil.dp2px(15);
        float dp2px = UnitUtil.dp2px(5);
        this.ELEVATION = dp2px;
        this.context = context;
        setGravity(48);
        setGravity(17);
        setOrientation(0);
        setBackgroundResource(R.drawable.shadow_main_bottom_tab);
        if (Build.VERSION.SDK_INT >= 21) {
            setElevation(dp2px);
        }
    }

    public void setTabChangedListener(onTabChangeListener ontabchangelistener) {
        this.onTabChangeListener = ontabchangelistener;
    }

    public void setAttachedActivity(AppCompatActivity appCompatActivity) {
        this.activity = appCompatActivity;
    }

    public void init(BottomItemView... bottomItemViewArr) {
        this.tabNum = bottomItemViewArr.length;
        this.itemViews = bottomItemViewArr;
        for (int i = 0; i < this.tabNum; i++) {
            BottomItemView bottomItemView = bottomItemViewArr[i];
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
            layoutParams.gravity = 16;
            if (i == 0) {
                bottomItemView.setPadding((this.PADDING * 5) / 2, 0, 0, 0);
            } else if (i == this.tabNum - 1) {
                bottomItemView.setPadding(0, 0, (this.PADDING * 5) / 2, 0);
            } else {
                int i2 = this.PADDING;
                bottomItemView.setPadding(i2, 0, i2, 0);
            }
            bottomItemView.setTag(Integer.valueOf(i));
            bottomItemView.setOnClickListener(this);
            addView(bottomItemView, layoutParams);
        }
        setCurTab(0);
    }

    public void setAdapter(MainPagerAdapter mainPagerAdapter) {
        this.adapter = mainPagerAdapter;
    }

    public void showRedPoint(int i) {
        BottomItemView bottomItemView = this.itemViews[2];
        bottomItemView.setSelectedDrawableRes(i > 0 ? R.drawable.bg_tab_me_unread_selected : R.mipmap.img_btn_main_tab_me_selected);
        bottomItemView.setNormalDrawableRes(i > 0 ? R.drawable.bg_tab_me_unread_normal : R.mipmap.img_btn_main_tab_me_normal);
        bottomItemView.setSelected(this.curIndex == 2);
    }

    public void setMainMediaController(MainMediaController mainMediaController) {
        this.mainMediaController = mainMediaController;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        if (this.curIndex != intValue && this.onTabChangeListener.isAllowChange(intValue)) {
            setCurTab(intValue);
        }
    }

    public void setCurTab(int i) {
        int i2 = 0;
        while (i2 < this.tabNum) {
            BottomItemView bottomItemView = this.itemViews[i2];
            bottomItemView.setSelected(i == i2);
            if (i == i2) {
                bottomItemView.setScaleX(1.04f);
                bottomItemView.setScaleY(1.04f);
            } else {
                bottomItemView.setScaleX(1.0f);
                bottomItemView.setScaleY(1.0f);
            }
            i2++;
        }
        MainPagerAdapter mainPagerAdapter = this.adapter;
        if (mainPagerAdapter != null) {
            mainPagerAdapter.onTabChanged(i);
        }
        this.curIndex = i;
        this.onTabChangeListener.onTabChanged(i);
    }
}