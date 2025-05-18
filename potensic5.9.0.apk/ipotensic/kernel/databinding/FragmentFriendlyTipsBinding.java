package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public abstract class FragmentFriendlyTipsBinding extends ViewDataBinding {
    public final ImageView ivLongTip;
    public final RelativeLayout rlLongTipRoot;
    public final TextView tvLongTipContent;

    protected FragmentFriendlyTipsBinding(Object obj, View view, int i, ImageView imageView, RelativeLayout relativeLayout, TextView textView) {
        super(obj, view, i);
        this.ivLongTip = imageView;
        this.rlLongTipRoot = relativeLayout;
        this.tvLongTipContent = textView;
    }

    public static FragmentFriendlyTipsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFriendlyTipsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentFriendlyTipsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_friendly_tips, viewGroup, z, obj);
    }

    public static FragmentFriendlyTipsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFriendlyTipsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentFriendlyTipsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_friendly_tips, null, false, obj);
    }

    public static FragmentFriendlyTipsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFriendlyTipsBinding bind(View view, Object obj) {
        return (FragmentFriendlyTipsBinding) bind(obj, view, R.layout.fragment_friendly_tips);
    }
}