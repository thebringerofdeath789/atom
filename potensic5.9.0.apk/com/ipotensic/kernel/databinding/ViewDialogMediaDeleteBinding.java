package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewDialogMediaDeleteBinding implements ViewBinding {
    public final Button btnCancel;
    public final Button btnDelete;
    private final LinearLayout rootView;

    private ViewDialogMediaDeleteBinding(LinearLayout linearLayout, Button button, Button button2) {
        this.rootView = linearLayout;
        this.btnCancel = button;
        this.btnDelete = button2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogMediaDeleteBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogMediaDeleteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_dialog_media_delete, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogMediaDeleteBinding bind(View view) {
        int i = C1965R.id.btn_cancel;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = C1965R.id.btn_delete;
            Button button2 = (Button) view.findViewById(i);
            if (button2 != null) {
                return new ViewDialogMediaDeleteBinding((LinearLayout) view, button, button2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}