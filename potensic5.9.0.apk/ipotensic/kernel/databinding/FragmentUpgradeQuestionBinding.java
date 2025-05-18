package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public abstract class FragmentUpgradeQuestionBinding extends ViewDataBinding {
    public final ImageButton btnBack;
    public final TextView tvUpgradeQuestionTitle;

    protected FragmentUpgradeQuestionBinding(Object obj, View view, int i, ImageButton imageButton, TextView textView) {
        super(obj, view, i);
        this.btnBack = imageButton;
        this.tvUpgradeQuestionTitle = textView;
    }

    public static FragmentUpgradeQuestionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentUpgradeQuestionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentUpgradeQuestionBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_upgrade_question, viewGroup, z, obj);
    }

    public static FragmentUpgradeQuestionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentUpgradeQuestionBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentUpgradeQuestionBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_upgrade_question, null, false, obj);
    }

    public static FragmentUpgradeQuestionBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentUpgradeQuestionBinding bind(View view, Object obj) {
        return (FragmentUpgradeQuestionBinding) bind(obj, view, R.layout.fragment_upgrade_question);
    }
}