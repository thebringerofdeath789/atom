package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ViewDialogTakePhotoBinding implements ViewBinding {
    public final Button btnCancel;
    public final Button btnTakePhoto;
    public final Button btnUploadPhoto;
    public final LinearLayout layoutMain;
    private final LinearLayout rootView;

    private ViewDialogTakePhotoBinding(LinearLayout linearLayout, Button button, Button button2, Button button3, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.btnCancel = button;
        this.btnTakePhoto = button2;
        this.btnUploadPhoto = button3;
        this.layoutMain = linearLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogTakePhotoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogTakePhotoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_dialog_take_photo, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogTakePhotoBinding bind(View view) {
        int i = R.id.btn_cancel;
        Button button = (Button) view.findViewById(R.id.btn_cancel);
        if (button != null) {
            i = R.id.btn_take_photo;
            Button button2 = (Button) view.findViewById(R.id.btn_take_photo);
            if (button2 != null) {
                i = R.id.btn_upload_photo;
                Button button3 = (Button) view.findViewById(R.id.btn_upload_photo);
                if (button3 != null) {
                    LinearLayout linearLayout = (LinearLayout) view;
                    return new ViewDialogTakePhotoBinding(linearLayout, button, button2, button3, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
