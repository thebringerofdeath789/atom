package com.p019gs.keyboard.databinding;

import android.inputmethodservice.KeyboardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.p019gs.keyboard.C1802R;

/* loaded from: classes2.dex */
public abstract class DialogKeyboardBinding extends ViewDataBinding {
    public final ConstraintLayout keyboardChooser;
    public final KeyboardView keyboardView;
    public final TextView tvLetter;
    public final TextView tvNumber;
    public final TextView tvSymbol;

    protected DialogKeyboardBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, KeyboardView keyboardView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.keyboardChooser = constraintLayout;
        this.keyboardView = keyboardView;
        this.tvLetter = textView;
        this.tvNumber = textView2;
        this.tvSymbol = textView3;
    }

    public static DialogKeyboardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogKeyboardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogKeyboardBinding) ViewDataBinding.inflateInternal(layoutInflater, C1802R.layout.dialog_keyboard, viewGroup, z, obj);
    }

    public static DialogKeyboardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogKeyboardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogKeyboardBinding) ViewDataBinding.inflateInternal(layoutInflater, C1802R.layout.dialog_keyboard, null, false, obj);
    }

    public static DialogKeyboardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogKeyboardBinding bind(View view, Object obj) {
        return (DialogKeyboardBinding) bind(obj, view, C1802R.layout.dialog_keyboard);
    }
}