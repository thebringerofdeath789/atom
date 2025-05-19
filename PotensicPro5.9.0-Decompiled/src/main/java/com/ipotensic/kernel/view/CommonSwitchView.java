package com.ipotensic.kernel.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.ipotensic.baselib.utils.UnitUtil;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.SwitchButton;

/* loaded from: classes2.dex */
public class CommonSwitchView extends RelativeLayout {
    private OnSwitchChangeListener listener;
    private SwitchButton switchButton;
    private TextView tvContent;
    private TextView tvTitle;

    public interface OnSwitchChangeListener {
        void onCheckedChanged(View view, boolean z);

        void onDisableClick(View view);
    }

    public CommonSwitchView(Context context) {
        this(context, null);
    }

    public CommonSwitchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonSwitchView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public CommonSwitchView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CommonSwitchView);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.CommonSwitchView_checked, false);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.CommonSwitchView_switchButtonEnable, true);
        String string = obtainStyledAttributes.getString(R.styleable.CommonSwitchView_tvTitle);
        String string2 = obtainStyledAttributes.getString(R.styleable.CommonSwitchView_tvContent);
        int color = obtainStyledAttributes.getColor(R.styleable.CommonSwitchView_titleColor, -1);
        int color2 = obtainStyledAttributes.getColor(R.styleable.CommonSwitchView_titleColor, -7829368);
        int dimension = (int) obtainStyledAttributes.getDimension(R.styleable.CommonSwitchView_tvTitlePaddingLeft, UnitUtil.dp2px(15));
        int dimension2 = (int) obtainStyledAttributes.getDimension(R.styleable.CommonSwitchView_switchButtonPaddingRight, UnitUtil.dp2px(24));
        this.tvTitle.setTextColor(color);
        this.tvContent.setTextColor(color2);
        this.switchButton.setChecked(z);
        this.switchButton.setViewEnable(z2);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.switchButton.getLayoutParams();
        marginLayoutParams.rightMargin = dimension2;
        this.switchButton.setLayoutParams(marginLayoutParams);
        this.tvTitle.setText(string);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.tvTitle.getLayoutParams();
        marginLayoutParams2.leftMargin = dimension;
        this.tvTitle.setLayoutParams(marginLayoutParams2);
        if (TextUtils.isEmpty(string2)) {
            this.tvContent.setVisibility(8);
        } else {
            this.tvContent.setText(string2);
        }
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        View inflate = View.inflate(context, R.layout.view_common_switch_view, this);
        this.tvContent = (TextView) inflate.findViewById(R.id.tv_content);
        this.tvTitle = (TextView) inflate.findViewById(R.id.tv_title);
        SwitchButton switchButton = (SwitchButton) inflate.findViewById(R.id.switch_btn);
        this.switchButton = switchButton;
        switchButton.switchStateListener(new SwitchButton.SwitchStateListener() { // from class: com.ipotensic.kernel.view.CommonSwitchView.1
            @Override // com.ipotensic.kernel.view.SwitchButton.SwitchStateListener
            public void onStateChanged(View view, boolean z) {
                if (CommonSwitchView.this.listener != null) {
                    CommonSwitchView.this.listener.onCheckedChanged(CommonSwitchView.this, z);
                }
            }

            @Override // com.ipotensic.kernel.view.SwitchButton.SwitchStateListener
            public void onDisableClick() {
                if (CommonSwitchView.this.listener != null) {
                    CommonSwitchView.this.listener.onDisableClick(CommonSwitchView.this);
                }
            }
        });
    }

    public void setListener(OnSwitchChangeListener onSwitchChangeListener) {
        this.listener = onSwitchChangeListener;
    }

    public void setTitle(String str) {
        this.tvTitle.setText(str);
    }

    public void setTitle(int i) {
        this.tvTitle.setText(i);
    }

    public void check(boolean z) {
        this.switchButton.setChecked(z);
    }

    public void setSwitchButtonEnable(boolean z) {
        this.switchButton.setViewEnable(z);
    }

    public void setContent(int i) {
        this.tvContent.setText(i);
        this.tvContent.setVisibility(0);
    }

    public void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.tvContent.setVisibility(8);
        } else {
            this.tvContent.setText(str);
            this.tvContent.setVisibility(0);
        }
    }

    public void setTitleColor(int i) {
        this.tvTitle.setTextColor(ContextCompat.getColor(getContext(), i));
    }

    public void setContentColor(int i) {
        this.tvContent.setTextColor(ContextCompat.getColor(getContext(), i));
    }
}
