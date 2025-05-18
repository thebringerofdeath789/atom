package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewLayoutTestCameraBinding implements ViewBinding {
    public final TextView btnClear1;
    public final TextView btnClear2;
    public final TextView btnSend1;
    public final TextView btnSend2;
    public final EditText etFun1;
    public final EditText etFun2;
    public final EditText etParams1;
    public final EditText etParams2;
    public final ConstraintLayout layoutCameraTest;
    public final LinearLayout layoutDown;
    private final ConstraintLayout rootView;
    public final ScrollView scrollView;
    public final TextView tvMsg;
    public final TextView tvPreviewSize;

    private ViewLayoutTestCameraBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, EditText editText, EditText editText2, EditText editText3, EditText editText4, ConstraintLayout constraintLayout2, LinearLayout linearLayout, ScrollView scrollView, TextView textView5, TextView textView6) {
        this.rootView = constraintLayout;
        this.btnClear1 = textView;
        this.btnClear2 = textView2;
        this.btnSend1 = textView3;
        this.btnSend2 = textView4;
        this.etFun1 = editText;
        this.etFun2 = editText2;
        this.etParams1 = editText3;
        this.etParams2 = editText4;
        this.layoutCameraTest = constraintLayout2;
        this.layoutDown = linearLayout;
        this.scrollView = scrollView;
        this.tvMsg = textView5;
        this.tvPreviewSize = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutTestCameraBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutTestCameraBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_layout_test_camera, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutTestCameraBinding bind(View view) {
        int i = R.id.btn_clear1;
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null) {
            i = R.id.btn_clear2;
            TextView textView2 = (TextView) view.findViewById(i);
            if (textView2 != null) {
                i = R.id.btn_send1;
                TextView textView3 = (TextView) view.findViewById(i);
                if (textView3 != null) {
                    i = R.id.btn_send2;
                    TextView textView4 = (TextView) view.findViewById(i);
                    if (textView4 != null) {
                        i = R.id.et_fun1;
                        EditText editText = (EditText) view.findViewById(i);
                        if (editText != null) {
                            i = R.id.et_fun2;
                            EditText editText2 = (EditText) view.findViewById(i);
                            if (editText2 != null) {
                                i = R.id.et_params1;
                                EditText editText3 = (EditText) view.findViewById(i);
                                if (editText3 != null) {
                                    i = R.id.et_params2;
                                    EditText editText4 = (EditText) view.findViewById(i);
                                    if (editText4 != null) {
                                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                        i = R.id.layout_down;
                                        LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                                        if (linearLayout != null) {
                                            i = R.id.scroll_view;
                                            ScrollView scrollView = (ScrollView) view.findViewById(i);
                                            if (scrollView != null) {
                                                i = R.id.tv_msg;
                                                TextView textView5 = (TextView) view.findViewById(i);
                                                if (textView5 != null) {
                                                    i = R.id.tv_preview_size;
                                                    TextView textView6 = (TextView) view.findViewById(i);
                                                    if (textView6 != null) {
                                                        return new ViewLayoutTestCameraBinding(constraintLayout, textView, textView2, textView3, textView4, editText, editText2, editText3, editText4, constraintLayout, linearLayout, scrollView, textView5, textView6);
                                                    }
                                                }
                                            }
                                        }
                                    }
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