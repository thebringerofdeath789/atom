package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.VideoView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class GuideVideoViewBinding implements ViewBinding {
    public final Button btnCancel;
    public final ImageButton btnClose;
    public final Button btnConfirm;
    private final ConstraintLayout rootView;
    public final VideoView videoView;

    private GuideVideoViewBinding(ConstraintLayout constraintLayout, Button button, ImageButton imageButton, Button button2, VideoView videoView) {
        this.rootView = constraintLayout;
        this.btnCancel = button;
        this.btnClose = imageButton;
        this.btnConfirm = button2;
        this.videoView = videoView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static GuideVideoViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static GuideVideoViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.guide_video_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static GuideVideoViewBinding bind(View view) {
        int i = R.id.btn_cancel;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = R.id.btn_close;
            ImageButton imageButton = (ImageButton) view.findViewById(i);
            if (imageButton != null) {
                i = R.id.btn_confirm;
                Button button2 = (Button) view.findViewById(i);
                if (button2 != null) {
                    i = R.id.video_view;
                    VideoView videoView = (VideoView) view.findViewById(i);
                    if (videoView != null) {
                        return new GuideVideoViewBinding((ConstraintLayout) view, button, imageButton, button2, videoView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
