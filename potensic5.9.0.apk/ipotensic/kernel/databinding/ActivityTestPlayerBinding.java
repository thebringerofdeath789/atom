package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;
import xyz.doikki.videoplayer.player.VideoView;

/* loaded from: classes2.dex */
public final class ActivityTestPlayerBinding implements ViewBinding {
    public final LinearLayout layoutMain;
    public final VideoView player;
    private final LinearLayout rootView;

    private ActivityTestPlayerBinding(LinearLayout linearLayout, LinearLayout linearLayout2, VideoView videoView) {
        this.rootView = linearLayout;
        this.layoutMain = linearLayout2;
        this.player = videoView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityTestPlayerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityTestPlayerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_test_player, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityTestPlayerBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.player;
        VideoView videoView = (VideoView) view.findViewById(i);
        if (videoView != null) {
            return new ActivityTestPlayerBinding(linearLayout, linearLayout, videoView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}