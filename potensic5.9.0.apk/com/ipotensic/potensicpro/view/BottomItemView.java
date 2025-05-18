package com.ipotensic.potensicpro.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.AppCompatTextView;
import com.ipotensic.baselib.utils.UnitUtil;
import com.ipotensic.potensicpro.C2640R;

/* loaded from: classes2.dex */
public class BottomItemView extends AppCompatTextView {
    private Drawable normalDrawable;
    private int normalTextColor;
    private Drawable selectedDrawable;
    private int selectedTextColor;

    public BottomItemView(Context context) {
        super(context);
        this.selectedTextColor = context.getResources().getColor(C2640R.color.color_main_tab_blue);
        this.normalTextColor = context.getResources().getColor(C2640R.color.color_full_black);
    }

    public BottomItemView setTitle(String str) {
        setText(str);
        return this;
    }

    public BottomItemView setSelectedDrawableRes(int i) {
        Drawable drawable = getResources().getDrawable(i);
        this.selectedDrawable = drawable;
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), this.selectedDrawable.getMinimumHeight());
        return this;
    }

    public BottomItemView setNormalDrawableRes(int i) {
        Drawable drawable = getResources().getDrawable(i);
        this.normalDrawable = drawable;
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), this.normalDrawable.getMinimumHeight());
        return this;
    }

    private BottomItemView build() {
        setGravity(17);
        setTextSize(10.0f);
        setSingleLine();
        setCompoundDrawablePadding(UnitUtil.dp2px(5));
        setSelected(false);
        return this;
    }

    public static BottomItemView buildWithTitleAndDrawableRes(Context context, String str, int i, int i2) {
        return new BottomItemView(context).setTitle(str).setSelectedDrawableRes(i).setNormalDrawableRes(i2).build();
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        if (z) {
            setCompoundDrawables(null, this.selectedDrawable, null, null);
            setTextColor(this.selectedTextColor);
        } else {
            setCompoundDrawables(null, this.normalDrawable, null, null);
            setTextColor(this.normalTextColor);
        }
    }
}