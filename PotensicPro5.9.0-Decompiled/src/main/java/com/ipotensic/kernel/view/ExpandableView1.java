package com.ipotensic.kernel.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public class ExpandableView1 extends LinearLayout {
    private final int PADDING;
    private View bottomView;
    private Drawable drawableLeft;
    private Drawable drawableRight;
    private boolean isChildShow;
    private String rightTxt;
    private final int textSize;
    private String title;
    private final int titleColor;

    public ExpandableView1(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.PADDING = 10;
        this.isChildShow = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandableView);
        this.drawableLeft = obtainStyledAttributes.getDrawable(R.styleable.ExpandableView_left_icon);
        this.drawableRight = obtainStyledAttributes.getDrawable(R.styleable.ExpandableView_right_icon);
        this.title = obtainStyledAttributes.getString(R.styleable.ExpandableView_title);
        this.rightTxt = obtainStyledAttributes.getString(R.styleable.ExpandableView_right_text);
        this.titleColor = obtainStyledAttributes.getColor(R.styleable.ExpandableView_titleColor, Color.parseColor("#ffffff"));
        this.textSize = obtainStyledAttributes.getInteger(R.styleable.ExpandableView_titleSizeSp, 0);
        obtainStyledAttributes.recycle();
        setOrientation(1);
        initView();
    }

    private void initView() {
        TextView textView = new TextView(getContext());
        textView.setText(this.title);
        textView.setTextColor(this.titleColor);
        textView.setTextSize(this.textSize);
        textView.setCompoundDrawablePadding(10);
        textView.setId(View.generateViewId());
        textView.setGravity(19);
        textView.setPadding(10, 0, 10, 0);
        setDrawableLeft(textView);
        addView(textView, new RelativeLayout.LayoutParams(-1, -2));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.ExpandableView1.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ExpandableView1.this.bottomView != null) {
                    ExpandableView1.this.isChildShow = !r2.isChildShow;
                    ExpandableView1.this.setState(false);
                }
            }
        });
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        View childAt = getChildAt(1);
        this.bottomView = childAt;
        this.isChildShow = childAt.getVisibility() == 0;
        setState(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setState(boolean z) {
        this.bottomView.setVisibility(this.isChildShow ? 0 : 8);
        if (z) {
            return;
        }
        int[] iArr = new int[2];
        boolean z2 = this.isChildShow;
        iArr[0] = z2 ? 0 : 10000;
        iArr[1] = z2 ? 10000 : 0;
        ValueAnimator ofInt = ValueAnimator.ofInt(iArr);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.ipotensic.kernel.view.ExpandableView1.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ExpandableView1.this.drawableRight.setLevel(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.setDuration(200L);
        ofInt.start();
    }

    private void setDrawableLeft(TextView textView) {
        Drawable drawable = this.drawableLeft;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), this.drawableLeft.getMinimumHeight());
        }
        Drawable drawable2 = getContext().getResources().getDrawable(R.drawable.bg_expandable_anim);
        this.drawableRight = drawable2;
        drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), this.drawableRight.getMinimumHeight());
        textView.setCompoundDrawables(this.drawableLeft, null, this.drawableRight, null);
    }
}
