package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ViewDialogHeaderChooseBinding implements ViewBinding {
    public final Button btnCancel;
    public final Button btnTakePhoto;
    public final Button btnUploadPhoto;
    private final LinearLayout rootView;

    private ViewDialogHeaderChooseBinding(LinearLayout linearLayout, Button button, Button button2, Button button3) {
        this.rootView = linearLayout;
        this.btnCancel = button;
        this.btnTakePhoto = button2;
        this.btnUploadPhoto = button3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogHeaderChooseBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogHeaderChooseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_dialog_header_choose, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogHeaderChooseBinding bind(View view) {
        int i = R.id.btn_cancel;
        Button button = (Button) view.findViewById(R.id.btn_cancel);
        if (button != null) {
            i = R.id.btn_take_photo;
            Button button2 = (Button) view.findViewById(R.id.btn_take_photo);
            if (button2 != null) {
                i = R.id.btn_upload_photo;
                Button button3 = (Button) view.findViewById(R.id.btn_upload_photo);
                if (button3 != null) {
                    return new ViewDialogHeaderChooseBinding((LinearLayout) view, button, button2, button3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
