package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;
import com.ipotensic.potensicpro.view.PDFDownloadProgressView;

/* loaded from: classes2.dex */
public final class ViewAdapterInstructionBinding implements ViewBinding {
    public final ConstraintLayout container;
    public final ImageView ivImg;
    public final PDFDownloadProgressView progressView;
    private final ConstraintLayout rootView;
    public final TextView tvCodeTitle;
    public final TextView tvMessage;

    private ViewAdapterInstructionBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, PDFDownloadProgressView pDFDownloadProgressView, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.container = constraintLayout2;
        this.ivImg = imageView;
        this.progressView = pDFDownloadProgressView;
        this.tvCodeTitle = textView;
        this.tvMessage = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewAdapterInstructionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewAdapterInstructionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_adapter_instruction, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewAdapterInstructionBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.iv_img;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_img);
        if (imageView != null) {
            i = R.id.progressView;
            PDFDownloadProgressView pDFDownloadProgressView = (PDFDownloadProgressView) view.findViewById(R.id.progressView);
            if (pDFDownloadProgressView != null) {
                i = R.id.tv_code_title;
                TextView textView = (TextView) view.findViewById(R.id.tv_code_title);
                if (textView != null) {
                    i = R.id.tv_message;
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_message);
                    if (textView2 != null) {
                        return new ViewAdapterInstructionBinding(constraintLayout, constraintLayout, imageView, pDFDownloadProgressView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
