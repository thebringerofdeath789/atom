package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewDialogUpgradeConditionsBinding implements ViewBinding {
    public final Button btnLater;
    public final Button btnUpgrading;
    public final RelativeLayout layoutCondition;
    private final RelativeLayout rootView;
    public final TextView tvCodeTitle;
    public final TextView tvUpgradeDetail;
    public final ImageView upgradeLogo;

    private ViewDialogUpgradeConditionsBinding(RelativeLayout relativeLayout, Button button, Button button2, RelativeLayout relativeLayout2, TextView textView, TextView textView2, ImageView imageView) {
        this.rootView = relativeLayout;
        this.btnLater = button;
        this.btnUpgrading = button2;
        this.layoutCondition = relativeLayout2;
        this.tvCodeTitle = textView;
        this.tvUpgradeDetail = textView2;
        this.upgradeLogo = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogUpgradeConditionsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogUpgradeConditionsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_dialog_upgrade_conditions, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogUpgradeConditionsBinding bind(View view) {
        int i = R.id.btn_later;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = R.id.btn_upgrading;
            Button button2 = (Button) view.findViewById(i);
            if (button2 != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                i = R.id.tv_code_title;
                TextView textView = (TextView) view.findViewById(i);
                if (textView != null) {
                    i = R.id.tv_upgrade_detail;
                    TextView textView2 = (TextView) view.findViewById(i);
                    if (textView2 != null) {
                        i = R.id.upgrade_logo;
                        ImageView imageView = (ImageView) view.findViewById(i);
                        if (imageView != null) {
                            return new ViewDialogUpgradeConditionsBinding(relativeLayout, button, button2, relativeLayout, textView, textView2, imageView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}