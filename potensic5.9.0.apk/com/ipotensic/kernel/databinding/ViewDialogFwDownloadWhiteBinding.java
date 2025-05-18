package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewDialogFwDownloadWhiteBinding implements ViewBinding {
    public final Button btnCancel;
    public final Button btnDownload;
    public final Button btnOk;
    public final LinearLayout layoutTop;
    public final LinearLayout llBtn;
    private final LinearLayout rootView;
    public final TextView tvCodeTitle;
    public final TextView tvContent;

    private ViewDialogFwDownloadWhiteBinding(LinearLayout linearLayout, Button button, Button button2, Button button3, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.btnCancel = button;
        this.btnDownload = button2;
        this.btnOk = button3;
        this.layoutTop = linearLayout2;
        this.llBtn = linearLayout3;
        this.tvCodeTitle = textView;
        this.tvContent = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogFwDownloadWhiteBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogFwDownloadWhiteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_dialog_fw_download_white, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogFwDownloadWhiteBinding bind(View view) {
        int i = C1965R.id.btn_cancel;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = C1965R.id.btn_download;
            Button button2 = (Button) view.findViewById(i);
            if (button2 != null) {
                i = C1965R.id.btn_ok;
                Button button3 = (Button) view.findViewById(i);
                if (button3 != null) {
                    LinearLayout linearLayout = (LinearLayout) view;
                    i = C1965R.id.ll_btn;
                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(i);
                    if (linearLayout2 != null) {
                        i = C1965R.id.tv_code_title;
                        TextView textView = (TextView) view.findViewById(i);
                        if (textView != null) {
                            i = C1965R.id.tv_content;
                            TextView textView2 = (TextView) view.findViewById(i);
                            if (textView2 != null) {
                                return new ViewDialogFwDownloadWhiteBinding(linearLayout, button, button2, button3, linearLayout, linearLayout2, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}