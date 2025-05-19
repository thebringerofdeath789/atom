package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.github.barteksc.pdfviewer.PDFView;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ActivityPdfBinding implements ViewBinding {
    public final ImageButton btnBack;
    public final ImageView ivShare;
    public final LinearLayout llBottom;
    public final PDFView pdfView;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final Toolbar toolbar;
    public final TextView tvCodeTitle;
    public final TextView tvPageNum;
    public final View viewTop;

    private ActivityPdfBinding(ConstraintLayout constraintLayout, ImageButton imageButton, ImageView imageView, LinearLayout linearLayout, PDFView pDFView, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2, View view) {
        this.rootView = constraintLayout;
        this.btnBack = imageButton;
        this.ivShare = imageView;
        this.llBottom = linearLayout;
        this.pdfView = pDFView;
        this.recyclerView = recyclerView;
        this.toolbar = toolbar;
        this.tvCodeTitle = textView;
        this.tvPageNum = textView2;
        this.viewTop = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityPdfBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityPdfBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_pdf, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityPdfBinding bind(View view) {
        int i = R.id.btn_back;
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.btn_back);
        if (imageButton != null) {
            i = R.id.iv_share;
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_share);
            if (imageView != null) {
                i = R.id.ll_bottom;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_bottom);
                if (linearLayout != null) {
                    i = R.id.pdfView;
                    PDFView pDFView = (PDFView) view.findViewById(R.id.pdfView);
                    if (pDFView != null) {
                        i = R.id.recycler_view;
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
                        if (recyclerView != null) {
                            i = R.id.toolbar;
                            Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
                            if (toolbar != null) {
                                i = R.id.tv_code_title;
                                TextView textView = (TextView) view.findViewById(R.id.tv_code_title);
                                if (textView != null) {
                                    i = R.id.tv_page_num;
                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_page_num);
                                    if (textView2 != null) {
                                        i = R.id.view_top;
                                        View findViewById = view.findViewById(R.id.view_top);
                                        if (findViewById != null) {
                                            return new ActivityPdfBinding((ConstraintLayout) view, imageButton, imageView, linearLayout, pDFView, recyclerView, toolbar, textView, textView2, findViewById);
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
