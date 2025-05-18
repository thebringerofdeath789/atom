package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ActivityMainBinding implements ViewBinding {
    public final TextView btnTabAcademy;
    public final TextView btnTabDevice;
    public final TextView btnTabGallery;
    public final TextView btnTabMe;
    public final LinearLayout layoutBottomTab;
    private final ConstraintLayout rootView;
    public final ViewStub stubAcademy;
    public final ViewStub stubMe;
    public final ViewStub stubMedia;

    private ActivityMainBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, LinearLayout linearLayout, ViewStub viewStub, ViewStub viewStub2, ViewStub viewStub3) {
        this.rootView = constraintLayout;
        this.btnTabAcademy = textView;
        this.btnTabDevice = textView2;
        this.btnTabGallery = textView3;
        this.btnTabMe = textView4;
        this.layoutBottomTab = linearLayout;
        this.stubAcademy = viewStub;
        this.stubMe = viewStub2;
        this.stubMedia = viewStub3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityMainBinding bind(View view) {
        int i = R.id.btnTabAcademy;
        TextView textView = (TextView) view.findViewById(R.id.btnTabAcademy);
        if (textView != null) {
            i = R.id.btnTabDevice;
            TextView textView2 = (TextView) view.findViewById(R.id.btnTabDevice);
            if (textView2 != null) {
                i = R.id.btnTabGallery;
                TextView textView3 = (TextView) view.findViewById(R.id.btnTabGallery);
                if (textView3 != null) {
                    i = R.id.btnTabMe;
                    TextView textView4 = (TextView) view.findViewById(R.id.btnTabMe);
                    if (textView4 != null) {
                        i = R.id.layoutBottomTab;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layoutBottomTab);
                        if (linearLayout != null) {
                            i = R.id.stub_academy;
                            ViewStub viewStub = (ViewStub) view.findViewById(R.id.stub_academy);
                            if (viewStub != null) {
                                i = R.id.stub_me;
                                ViewStub viewStub2 = (ViewStub) view.findViewById(R.id.stub_me);
                                if (viewStub2 != null) {
                                    i = R.id.stub_media;
                                    ViewStub viewStub3 = (ViewStub) view.findViewById(R.id.stub_media);
                                    if (viewStub3 != null) {
                                        return new ActivityMainBinding((ConstraintLayout) view, textView, textView2, textView3, textView4, linearLayout, viewStub, viewStub2, viewStub3);
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