package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewDialogP1selfTestOpenBinding implements ViewBinding {
    public final Button btnAdd;
    public final Button btnCancel;
    public final Button btnConfirm;
    public final Button btnOk;
    public final Button btnSub;
    public final EditText editTime;
    public final LinearLayout llBg;
    public final LinearLayout llBtn;
    private final LinearLayout rootView;
    public final TextView tvDialogTitle;
    public final View viewLine;

    private ViewDialogP1selfTestOpenBinding(LinearLayout linearLayout, Button button, Button button2, Button button3, Button button4, Button button5, EditText editText, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, View view) {
        this.rootView = linearLayout;
        this.btnAdd = button;
        this.btnCancel = button2;
        this.btnConfirm = button3;
        this.btnOk = button4;
        this.btnSub = button5;
        this.editTime = editText;
        this.llBg = linearLayout2;
        this.llBtn = linearLayout3;
        this.tvDialogTitle = textView;
        this.viewLine = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogP1selfTestOpenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogP1selfTestOpenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_dialog_p1self_test_open, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogP1selfTestOpenBinding bind(View view) {
        View findViewById;
        int i = C1965R.id.btn_add;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = C1965R.id.btn_cancel;
            Button button2 = (Button) view.findViewById(i);
            if (button2 != null) {
                i = C1965R.id.btn_confirm;
                Button button3 = (Button) view.findViewById(i);
                if (button3 != null) {
                    i = C1965R.id.btn_ok;
                    Button button4 = (Button) view.findViewById(i);
                    if (button4 != null) {
                        i = C1965R.id.btn_sub;
                        Button button5 = (Button) view.findViewById(i);
                        if (button5 != null) {
                            i = C1965R.id.edit_time;
                            EditText editText = (EditText) view.findViewById(i);
                            if (editText != null) {
                                LinearLayout linearLayout = (LinearLayout) view;
                                i = C1965R.id.ll_btn;
                                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(i);
                                if (linearLayout2 != null) {
                                    i = C1965R.id.tv_dialog_title;
                                    TextView textView = (TextView) view.findViewById(i);
                                    if (textView != null && (findViewById = view.findViewById((i = C1965R.id.view_line))) != null) {
                                        return new ViewDialogP1selfTestOpenBinding(linearLayout, button, button2, button3, button4, button5, editText, linearLayout, linearLayout2, textView, findViewById);
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