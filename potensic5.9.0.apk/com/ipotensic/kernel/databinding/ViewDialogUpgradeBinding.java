package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewDialogUpgradeBinding implements ViewBinding {
    public final ImageButton btnCancel;
    public final Button btnUpgrade;
    public final RelativeLayout layoutUpgrade;
    private final RelativeLayout rootView;
    public final TextView tvCodeTitle;
    public final TextView tvUpgradeDetail;
    public final TextView tvUpgradeInfo;
    public final ImageView upgradeLogo;

    private ViewDialogUpgradeBinding(RelativeLayout relativeLayout, ImageButton imageButton, Button button, RelativeLayout relativeLayout2, TextView textView, TextView textView2, TextView textView3, ImageView imageView) {
        this.rootView = relativeLayout;
        this.btnCancel = imageButton;
        this.btnUpgrade = button;
        this.layoutUpgrade = relativeLayout2;
        this.tvCodeTitle = textView;
        this.tvUpgradeDetail = textView2;
        this.tvUpgradeInfo = textView3;
        this.upgradeLogo = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogUpgradeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogUpgradeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_dialog_upgrade, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogUpgradeBinding bind(View view) {
        int i = C1965R.id.btn_cancel;
        ImageButton imageButton = (ImageButton) view.findViewById(i);
        if (imageButton != null) {
            i = C1965R.id.btn_upgrade;
            Button button = (Button) view.findViewById(i);
            if (button != null) {
                i = C1965R.id.layout_upgrade;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(i);
                if (relativeLayout != null) {
                    i = C1965R.id.tv_code_title;
                    TextView textView = (TextView) view.findViewById(i);
                    if (textView != null) {
                        i = C1965R.id.tv_upgrade_detail;
                        TextView textView2 = (TextView) view.findViewById(i);
                        if (textView2 != null) {
                            i = C1965R.id.tv_upgrade_info;
                            TextView textView3 = (TextView) view.findViewById(i);
                            if (textView3 != null) {
                                i = C1965R.id.upgrade_logo;
                                ImageView imageView = (ImageView) view.findViewById(i);
                                if (imageView != null) {
                                    return new ViewDialogUpgradeBinding((RelativeLayout) view, imageButton, button, relativeLayout, textView, textView2, textView3, imageView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}