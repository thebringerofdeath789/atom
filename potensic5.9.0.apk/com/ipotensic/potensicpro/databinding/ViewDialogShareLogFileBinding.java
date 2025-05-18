package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.C2640R;

/* loaded from: classes2.dex */
public final class ViewDialogShareLogFileBinding implements ViewBinding {
    public final Button btnClose;
    public final RecyclerView listLogFile;
    private final LinearLayout rootView;

    private ViewDialogShareLogFileBinding(LinearLayout linearLayout, Button button, RecyclerView recyclerView) {
        this.rootView = linearLayout;
        this.btnClose = button;
        this.listLogFile = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogShareLogFileBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogShareLogFileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2640R.layout.view_dialog_share_log_file, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogShareLogFileBinding bind(View view) {
        int i = C2640R.id.btn_close;
        Button button = (Button) view.findViewById(C2640R.id.btn_close);
        if (button != null) {
            i = C2640R.id.list_log_file;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(C2640R.id.list_log_file);
            if (recyclerView != null) {
                return new ViewDialogShareLogFileBinding((LinearLayout) view, button, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}