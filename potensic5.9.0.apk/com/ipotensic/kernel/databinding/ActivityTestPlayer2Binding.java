package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;
import xyz.doikki.videoplayer.player.VideoView;

/* loaded from: classes2.dex */
public final class ActivityTestPlayer2Binding implements ViewBinding {
    public final RelativeLayout layoutMain;
    public final VideoView player;
    private final RelativeLayout rootView;

    private ActivityTestPlayer2Binding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, VideoView videoView) {
        this.rootView = relativeLayout;
        this.layoutMain = relativeLayout2;
        this.player = videoView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityTestPlayer2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityTestPlayer2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.activity_test_player2, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityTestPlayer2Binding bind(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i = C1965R.id.player;
        VideoView videoView = (VideoView) view.findViewById(i);
        if (videoView != null) {
            return new ActivityTestPlayer2Binding(relativeLayout, relativeLayout, videoView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}