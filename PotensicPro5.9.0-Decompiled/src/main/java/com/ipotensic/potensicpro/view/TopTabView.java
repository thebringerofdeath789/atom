package com.ipotensic.potensicpro.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ipotensic.baselib.utils.UnitUtil;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public class TopTabView extends LinearLayout implements View.OnClickListener {
    private final int NORMAL_TEXT_SIZE;
    private final int PADDING;
    private final int SELECT_TEXT_SIZE;
    private Drawable bottomDrawable;
    private OnTopIndicatorChangeListener changeListener;
    private int curPosition;
    private TextView[] views;

    public interface OnTopIndicatorChangeListener {
        void onIndicatorChanged(int i);
    }

    public TopTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.PADDING = UnitUtil.dp2px(7);
        this.SELECT_TEXT_SIZE = 21;
        this.NORMAL_TEXT_SIZE = 20;
        setOrientation(0);
        Drawable drawable = getContext().getResources().getDrawable(R.mipmap.img_bg_main_media_top_indicator);
        this.bottomDrawable = drawable;
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), this.bottomDrawable.getMinimumHeight());
    }

    public void setTabs(OnTopIndicatorChangeListener onTopIndicatorChangeListener, String... strArr) {
        this.changeListener = onTopIndicatorChangeListener;
        int length = strArr.length;
        this.views = new TextView[length];
        for (int i = 0; i < length; i++) {
            TextView textView = new TextView(getContext());
            textView.setText(strArr[i]);
            textView.setTextSize(20.0f);
            textView.setGravity(49);
            textView.setTextColor(getContext().getResources().getColor(R.color.color_main_media_indicator_gray));
            textView.setSingleLine();
            textView.setTag(Integer.valueOf(i));
            textView.setCompoundDrawablePadding(5);
            int i2 = this.PADDING;
            textView.setPadding(i2, i2, i2, 0);
            textView.setOnClickListener(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.gravity = 49;
            addView(textView, layoutParams);
            this.views[i] = textView;
        }
        setCurIndex(0);
    }

    private void setCurIndex(int i) {
        int i2 = 0;
        while (true) {
            TextView[] textViewArr = this.views;
            if (i2 >= textViewArr.length) {
                break;
            }
            TextView textView = textViewArr[i2];
            boolean z = i2 == i;
            textView.setCompoundDrawables(null, null, null, z ? this.bottomDrawable : null);
            textView.setTextSize(z ? 21.0f : 20.0f);
            textView.setTextColor(getContext().getResources().getColor(z ? R.color.color_connect_selected_text : R.color.color_main_media_indicator_gray));
            i2++;
        }
        OnTopIndicatorChangeListener onTopIndicatorChangeListener = this.changeListener;
        if (onTopIndicatorChangeListener != null) {
            onTopIndicatorChangeListener.onIndicatorChanged(i);
        }
        this.curPosition = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        if (intValue == this.curPosition) {
            return;
        }
        setCurIndex(intValue);
    }
}
