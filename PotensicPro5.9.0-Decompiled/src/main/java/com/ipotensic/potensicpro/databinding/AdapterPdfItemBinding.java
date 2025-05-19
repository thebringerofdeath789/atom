package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class AdapterPdfItemBinding implements ViewBinding {
    public final ImageView imgPdf;
    private final ConstraintLayout rootView;
    public final View viewLine;

    private AdapterPdfItemBinding(ConstraintLayout constraintLayout, ImageView imageView, View view) {
        this.rootView = constraintLayout;
        this.imgPdf = imageView;
        this.viewLine = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AdapterPdfItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AdapterPdfItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.adapter_pdf_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AdapterPdfItemBinding bind(View view) {
        int i = R.id.img_pdf;
        ImageView imageView = (ImageView) view.findViewById(R.id.img_pdf);
        if (imageView != null) {
            i = R.id.view_line;
            View findViewById = view.findViewById(R.id.view_line);
            if (findViewById != null) {
                return new AdapterPdfItemBinding((ConstraintLayout) view, imageView, findViewById);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
