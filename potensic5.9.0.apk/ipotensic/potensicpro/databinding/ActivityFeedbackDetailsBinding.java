package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.baselib.views.LooperViewPager;
import com.ipotensic.potensicpro.R;
import xyz.doikki.videoplayer.player.VideoView;

/* loaded from: classes2.dex */
public final class ActivityFeedbackDetailsBinding implements ViewBinding {
    public final ImageView ivBack;
    public final ImageView ivDelete;
    public final RelativeLayout layoutPreview;
    public final LinearLayout layoutViewDefault;
    public final View line;
    public final LooperViewPager loopViewpager;
    public final VideoView player;
    public final RecyclerView recyclerView;
    private final RelativeLayout rootView;
    public final Toolbar toolbar;
    public final TextView tvCodeTitle;

    private ActivityFeedbackDetailsBinding(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout2, LinearLayout linearLayout, View view, LooperViewPager looperViewPager, VideoView videoView, RecyclerView recyclerView, Toolbar toolbar, TextView textView) {
        this.rootView = relativeLayout;
        this.ivBack = imageView;
        this.ivDelete = imageView2;
        this.layoutPreview = relativeLayout2;
        this.layoutViewDefault = linearLayout;
        this.line = view;
        this.loopViewpager = looperViewPager;
        this.player = videoView;
        this.recyclerView = recyclerView;
        this.toolbar = toolbar;
        this.tvCodeTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityFeedbackDetailsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityFeedbackDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_feedback_details, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityFeedbackDetailsBinding bind(View view) {
        int i = R.id.iv_back;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
        if (imageView != null) {
            i = R.id.iv_delete;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_delete);
            if (imageView2 != null) {
                i = R.id.layout_preview;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.layout_preview);
                if (relativeLayout != null) {
                    i = R.id.layout_view_default;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout_view_default);
                    if (linearLayout != null) {
                        i = R.id.line;
                        View findViewById = view.findViewById(R.id.line);
                        if (findViewById != null) {
                            i = R.id.loop_viewpager;
                            LooperViewPager looperViewPager = (LooperViewPager) view.findViewById(R.id.loop_viewpager);
                            if (looperViewPager != null) {
                                i = R.id.player;
                                VideoView videoView = (VideoView) view.findViewById(R.id.player);
                                if (videoView != null) {
                                    i = R.id.recycler_view;
                                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
                                    if (recyclerView != null) {
                                        i = R.id.toolbar;
                                        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
                                        if (toolbar != null) {
                                            i = R.id.tv_code_title;
                                            TextView textView = (TextView) view.findViewById(R.id.tv_code_title);
                                            if (textView != null) {
                                                return new ActivityFeedbackDetailsBinding((RelativeLayout) view, imageView, imageView2, relativeLayout, linearLayout, findViewById, looperViewPager, videoView, recyclerView, toolbar, textView);
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