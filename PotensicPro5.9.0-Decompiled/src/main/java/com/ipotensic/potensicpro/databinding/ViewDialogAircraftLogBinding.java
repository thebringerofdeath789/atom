package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ViewDialogAircraftLogBinding implements ViewBinding {
    public final ImageButton btnClose;
    public final Button btnFinish;
    public final EditText etFeedback;
    public final EditText etModel;
    public final View line;
    private final ConstraintLayout rootView;
    public final TextView tvCodeTitle;
    public final TextView tvFeedback;
    public final TextView tvModel;

    private ViewDialogAircraftLogBinding(ConstraintLayout constraintLayout, ImageButton imageButton, Button button, EditText editText, EditText editText2, View view, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.btnClose = imageButton;
        this.btnFinish = button;
        this.etFeedback = editText;
        this.etModel = editText2;
        this.line = view;
        this.tvCodeTitle = textView;
        this.tvFeedback = textView2;
        this.tvModel = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogAircraftLogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogAircraftLogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_dialog_aircraft_log, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogAircraftLogBinding bind(View view) {
        int i = R.id.btn_close;
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.btn_close);
        if (imageButton != null) {
            i = R.id.btn_finish;
            Button button = (Button) view.findViewById(R.id.btn_finish);
            if (button != null) {
                i = R.id.et_feedback;
                EditText editText = (EditText) view.findViewById(R.id.et_feedback);
                if (editText != null) {
                    i = R.id.et_model;
                    EditText editText2 = (EditText) view.findViewById(R.id.et_model);
                    if (editText2 != null) {
                        i = R.id.line;
                        View findViewById = view.findViewById(R.id.line);
                        if (findViewById != null) {
                            i = R.id.tv_code_title;
                            TextView textView = (TextView) view.findViewById(R.id.tv_code_title);
                            if (textView != null) {
                                i = R.id.tv_feedback;
                                TextView textView2 = (TextView) view.findViewById(R.id.tv_feedback);
                                if (textView2 != null) {
                                    i = R.id.tv_model;
                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_model);
                                    if (textView3 != null) {
                                        return new ViewDialogAircraftLogBinding((ConstraintLayout) view, imageButton, button, editText, editText2, findViewById, textView, textView2, textView3);
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
