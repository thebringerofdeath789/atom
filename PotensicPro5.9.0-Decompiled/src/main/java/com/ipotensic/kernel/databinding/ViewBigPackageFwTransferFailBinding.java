package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public abstract class ViewBigPackageFwTransferFailBinding extends ViewDataBinding {
    public final Button btnTransferExit;
    public final Button btnUpgradeExit;
    public final ImageButton btnUpgradeFailClose;
    public final Button btnUpgradeRetry;
    public final LinearLayout layoutFwTransferRetry;
    public final TextView tvErrorCode;
    public final TextView tvUpgradeFailContent;
    public final TextView tvUpgradeFailFaqs;
    public final TextView tvUpgradeFailTitle;

    protected ViewBigPackageFwTransferFailBinding(Object obj, View view, int i, Button button, Button button2, ImageButton imageButton, Button button3, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.btnTransferExit = button;
        this.btnUpgradeExit = button2;
        this.btnUpgradeFailClose = imageButton;
        this.btnUpgradeRetry = button3;
        this.layoutFwTransferRetry = linearLayout;
        this.tvErrorCode = textView;
        this.tvUpgradeFailContent = textView2;
        this.tvUpgradeFailFaqs = textView3;
        this.tvUpgradeFailTitle = textView4;
    }

    public static ViewBigPackageFwTransferFailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewBigPackageFwTransferFailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewBigPackageFwTransferFailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_big_package_fw_transfer_fail, viewGroup, z, obj);
    }

    public static ViewBigPackageFwTransferFailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewBigPackageFwTransferFailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewBigPackageFwTransferFailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_big_package_fw_transfer_fail, null, false, obj);
    }

    public static ViewBigPackageFwTransferFailBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewBigPackageFwTransferFailBinding bind(View view, Object obj) {
        return (ViewBigPackageFwTransferFailBinding) bind(obj, view, R.layout.view_big_package_fw_transfer_fail);
    }
}
