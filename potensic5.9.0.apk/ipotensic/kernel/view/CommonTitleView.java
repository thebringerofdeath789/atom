package com.ipotensic.kernel.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public class CommonTitleView extends RelativeLayout implements View.OnClickListener {
    private OnClickListener listener;
    private TextView tvLeft;
    private TextView tvRight;
    private TextView tvTitle;

    public interface OnClickListener {
        void onRightClick(View view);
    }

    public CommonTitleView(Context context) {
        this(context, null);
    }

    public CommonTitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonTitleView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public CommonTitleView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CommonTitleView);
        String string = obtainStyledAttributes.getString(R.styleable.CommonTitleView_tvTitle);
        int color = obtainStyledAttributes.getColor(R.styleable.CommonTitleView_titleColor, -1);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.CommonTitleView_right_icon);
        this.tvTitle.setTextColor(color);
        this.tvTitle.setText(string);
        if (drawable != null) {
            setRightIcon(drawable);
        }
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        View inflate = View.inflate(context, R.layout.view_common_title_view, this);
        this.tvTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.tvRight = (TextView) inflate.findViewById(R.id.tv_right);
        this.tvLeft = (TextView) inflate.findViewById(R.id.tv_left);
        this.tvRight.setOnClickListener(this);
    }

    public void setTitle(String str) {
        this.tvTitle.setText(str);
    }

    public void setTitle(int i) {
        this.tvTitle.setText(i);
    }

    public void setTitleColor(int i) {
        this.tvTitle.setTextColor(ContextCompat.getColor(getContext(), i));
    }

    public void setRightIcon(int i) {
        this.tvRight.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, i, 0);
    }

    public void setRightIcon(Drawable drawable) {
        this.tvRight.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
    }

    public void setListener(OnClickListener onClickListener) {
        this.listener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.listener != null && view.getId() == R.id.tv_right) {
            this.listener.onRightClick(view);
        }
    }
}