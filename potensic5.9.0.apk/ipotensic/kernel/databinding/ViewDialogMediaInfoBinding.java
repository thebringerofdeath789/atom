package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewDialogMediaInfoBinding implements ViewBinding {
    public final LinearLayout layoutDuration;
    public final LinearLayout layoutFrameRate;
    public final LinearLayout layoutResolution;
    public final LinearLayout layoutSize;
    private final LinearLayout rootView;
    public final TextView tvCancel;
    public final TextView tvDate;
    public final TextView tvDuration;
    public final TextView tvFormat;
    public final TextView tvFrameRate;
    public final TextView tvResolution;
    public final TextView tvSize;

    private ViewDialogMediaInfoBinding(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = linearLayout;
        this.layoutDuration = linearLayout2;
        this.layoutFrameRate = linearLayout3;
        this.layoutResolution = linearLayout4;
        this.layoutSize = linearLayout5;
        this.tvCancel = textView;
        this.tvDate = textView2;
        this.tvDuration = textView3;
        this.tvFormat = textView4;
        this.tvFrameRate = textView5;
        this.tvResolution = textView6;
        this.tvSize = textView7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogMediaInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogMediaInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_dialog_media_info, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogMediaInfoBinding bind(View view) {
        int i = R.id.layout_duration;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
        if (linearLayout != null) {
            i = R.id.layout_frame_rate;
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(i);
            if (linearLayout2 != null) {
                i = R.id.layout_resolution;
                LinearLayout linearLayout3 = (LinearLayout) view.findViewById(i);
                if (linearLayout3 != null) {
                    i = R.id.layout_size;
                    LinearLayout linearLayout4 = (LinearLayout) view.findViewById(i);
                    if (linearLayout4 != null) {
                        i = R.id.tv_cancel;
                        TextView textView = (TextView) view.findViewById(i);
                        if (textView != null) {
                            i = R.id.tv_date;
                            TextView textView2 = (TextView) view.findViewById(i);
                            if (textView2 != null) {
                                i = R.id.tv_duration;
                                TextView textView3 = (TextView) view.findViewById(i);
                                if (textView3 != null) {
                                    i = R.id.tv_format;
                                    TextView textView4 = (TextView) view.findViewById(i);
                                    if (textView4 != null) {
                                        i = R.id.tv_frame_rate;
                                        TextView textView5 = (TextView) view.findViewById(i);
                                        if (textView5 != null) {
                                            i = R.id.tv_resolution;
                                            TextView textView6 = (TextView) view.findViewById(i);
                                            if (textView6 != null) {
                                                i = R.id.tv_size;
                                                TextView textView7 = (TextView) view.findViewById(i);
                                                if (textView7 != null) {
                                                    return new ViewDialogMediaInfoBinding((LinearLayout) view, linearLayout, linearLayout2, linearLayout3, linearLayout4, textView, textView2, textView3, textView4, textView5, textView6, textView7);
                                                }
                                            }
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