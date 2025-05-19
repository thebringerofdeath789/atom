package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewDialogGimbalModelGuideVideoBinding implements ViewBinding {
    public final ImageButton btnExit;
    public final ImageButton btnPlay;
    public final RelativeLayout layoutTop;
    private final ConstraintLayout rootView;
    public final TextView tvFpv;
    public final TextView tvStable;
    public final VideoView videoView;

    private ViewDialogGimbalModelGuideVideoBinding(ConstraintLayout constraintLayout, ImageButton imageButton, ImageButton imageButton2, RelativeLayout relativeLayout, TextView textView, TextView textView2, VideoView videoView) {
        this.rootView = constraintLayout;
        this.btnExit = imageButton;
        this.btnPlay = imageButton2;
        this.layoutTop = relativeLayout;
        this.tvFpv = textView;
        this.tvStable = textView2;
        this.videoView = videoView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogGimbalModelGuideVideoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogGimbalModelGuideVideoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_dialog_gimbal_model_guide_video, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogGimbalModelGuideVideoBinding bind(View view) {
        int i = R.id.btn_exit;
        ImageButton imageButton = (ImageButton) view.findViewById(i);
        if (imageButton != null) {
            i = R.id.btn_play;
            ImageButton imageButton2 = (ImageButton) view.findViewById(i);
            if (imageButton2 != null) {
                i = R.id.layout_top;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(i);
                if (relativeLayout != null) {
                    i = R.id.tv_fpv;
                    TextView textView = (TextView) view.findViewById(i);
                    if (textView != null) {
                        i = R.id.tv_stable;
                        TextView textView2 = (TextView) view.findViewById(i);
                        if (textView2 != null) {
                            i = R.id.video_view;
                            VideoView videoView = (VideoView) view.findViewById(i);
                            if (videoView != null) {
                                return new ViewDialogGimbalModelGuideVideoBinding((ConstraintLayout) view, imageButton, imageButton2, relativeLayout, textView, textView2, videoView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
