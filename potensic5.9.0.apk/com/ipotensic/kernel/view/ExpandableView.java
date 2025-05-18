package com.ipotensic.kernel.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public class ExpandableView extends LinearLayout {
    private final int PADDING;
    private View bottomView;
    private Context context;
    private Drawable drawableLeft;
    private Drawable drawableRight;
    private ImageView expandImage;
    private boolean isBold;
    private boolean isChildShow;
    private float leftDrawablePadding;
    private OnExpandListener listener;
    private final int rightTextColor;
    private final int rightTextSize;
    private String rightTxt;
    private final int textSize;
    private String title;
    private final int titleColor;
    private TextView titleView;
    private RelativeLayout topView;
    private float topViewPaddingBottom;
    private float topViewPaddingLeft;
    private float topViewPaddingRight;
    private float topViewPaddingTop;

    public interface OnExpandListener {
        void onExpand(boolean z);
    }

    public ExpandableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.PADDING = 10;
        this.isChildShow = false;
        this.context = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1965R.styleable.ExpandableView);
        this.drawableLeft = obtainStyledAttributes.getDrawable(C1965R.styleable.ExpandableView_left_icon);
        this.drawableRight = obtainStyledAttributes.getDrawable(C1965R.styleable.ExpandableView_right_icon);
        this.title = obtainStyledAttributes.getString(C1965R.styleable.ExpandableView_title);
        this.rightTxt = obtainStyledAttributes.getString(C1965R.styleable.ExpandableView_right_text);
        this.titleColor = obtainStyledAttributes.getColor(C1965R.styleable.ExpandableView_titleColor, getResources().getColor(C1965R.color.colorWhite));
        this.textSize = obtainStyledAttributes.getInteger(C1965R.styleable.ExpandableView_titleSizeSp, 0);
        this.isBold = obtainStyledAttributes.getBoolean(C1965R.styleable.ExpandableView_isBold, false);
        this.leftDrawablePadding = obtainStyledAttributes.getDimension(C1965R.styleable.ExpandableView_leftDrawablePadding, 10.0f);
        this.topViewPaddingTop = obtainStyledAttributes.getDimension(C1965R.styleable.ExpandableView_topViewPaddingTop, 0.0f);
        this.topViewPaddingBottom = obtainStyledAttributes.getDimension(C1965R.styleable.ExpandableView_topViewPaddingBottom, 0.0f);
        this.topViewPaddingRight = obtainStyledAttributes.getDimension(C1965R.styleable.ExpandableView_topViewPaddingRight, 0.0f);
        this.topViewPaddingLeft = obtainStyledAttributes.getDimension(C1965R.styleable.ExpandableView_topViewPaddingLeft, 0.0f);
        this.rightTextColor = obtainStyledAttributes.getColor(C1965R.styleable.ExpandableView_rightTextcolor, getResources().getColor(C1965R.color.colorGray));
        this.rightTextSize = obtainStyledAttributes.getInteger(C1965R.styleable.ExpandableView_rightTextSize, 0);
        obtainStyledAttributes.recycle();
        setOrientation(1);
        initView();
    }

    private void initView() {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.topView = relativeLayout;
        relativeLayout.setPadding((int) this.topViewPaddingLeft, (int) this.topViewPaddingTop, (int) this.topViewPaddingRight, (int) this.topViewPaddingBottom);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        TextView textView = new TextView(getContext());
        this.titleView = textView;
        textView.setText(this.title);
        this.titleView.setTextColor(this.titleColor);
        this.titleView.setTextSize(this.textSize);
        this.titleView.setCompoundDrawablePadding((int) this.leftDrawablePadding);
        this.titleView.setId(View.generateViewId());
        this.titleView.setGravity(19);
        this.titleView.setPadding(0, 0, 30, 0);
        if (this.isBold) {
            this.titleView.getPaint().setFakeBoldText(true);
        }
        setDrawableLeft(this.titleView);
        this.topView.addView(this.titleView, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(11);
        layoutParams2.addRule(15);
        ImageView imageView = new ImageView(getContext());
        this.expandImage = imageView;
        imageView.setPadding(10, 10, 10, 10);
        this.expandImage.setImageDrawable(this.drawableRight);
        this.expandImage.setId(View.generateViewId());
        this.topView.addView(this.expandImage, layoutParams2);
        if (this.rightTxt != null) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(15);
            layoutParams3.addRule(0, this.expandImage.getId());
            layoutParams3.rightMargin = 10;
            TextView textView2 = new TextView(getContext());
            textView2.setText(this.context.getString(C1965R.string.sys_general_about));
            textView2.setTextColor(this.rightTextColor);
            textView2.setTextSize(this.rightTextSize);
            this.topView.addView(textView2, layoutParams3);
            this.topView.setTag(textView2);
        }
        addView(this.topView, new RelativeLayout.LayoutParams(-1, -2));
        this.topView.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.view.ExpandableView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ExpandableView.this.bottomView != null) {
                    ExpandableView.this.isChildShow = !r2.isChildShow;
                    ExpandableView.this.setState();
                    if (ExpandableView.this.listener != null) {
                        ExpandableView.this.listener.onExpand(ExpandableView.this.isChildShow);
                    }
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
        setState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setState() {
        this.bottomView.setVisibility(this.isChildShow ? 0 : 8);
        this.expandImage.setRotation(this.isChildShow ? 90.0f : 0.0f);
    }

    private void setDrawableLeft(TextView textView) {
        Drawable drawable = this.drawableLeft;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), this.drawableLeft.getMinimumHeight());
            textView.setCompoundDrawables(this.drawableLeft, null, null, null);
        }
    }

    public void setOnExpandListener(OnExpandListener onExpandListener) {
        this.listener = onExpandListener;
    }

    public void setTitleText(String str) {
        TextView textView = this.titleView;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void removeListener() {
        this.listener = null;
    }
}