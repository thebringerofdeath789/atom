package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewAtomltLeftIntelligentModeBinding implements ViewBinding {
    public final ConstraintLayout atomLTIntelligentMode;
    public final ViewAtomltCircleModeSettingBinding atomLTIntelligentModeRight;
    public final View atomLTIntelligentViewBg;
    public final View atomLTIntelligentViewBlank;
    public final ConstraintLayout atomLTIntelligentViewMode;
    public final TextView atomLTTvFollowMe;
    public final TextView atomLTTvHotCircle;
    public final TextView atomLTTvWaypointFlight;
    private final ConstraintLayout rootView;

    private ViewAtomltLeftIntelligentModeBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ViewAtomltCircleModeSettingBinding viewAtomltCircleModeSettingBinding, View view, View view2, ConstraintLayout constraintLayout3, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.atomLTIntelligentMode = constraintLayout2;
        this.atomLTIntelligentModeRight = viewAtomltCircleModeSettingBinding;
        this.atomLTIntelligentViewBg = view;
        this.atomLTIntelligentViewBlank = view2;
        this.atomLTIntelligentViewMode = constraintLayout3;
        this.atomLTTvFollowMe = textView;
        this.atomLTTvHotCircle = textView2;
        this.atomLTTvWaypointFlight = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewAtomltLeftIntelligentModeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewAtomltLeftIntelligentModeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_atomlt_left_intelligent_mode, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewAtomltLeftIntelligentModeBinding bind(View view) {
        View findViewById;
        View findViewById2;
        int i = R.id.atomLT_intelligent_mode;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(i);
        if (constraintLayout != null && (findViewById = view.findViewById((i = R.id.atomLT_intelligent_mode_right))) != null) {
            ViewAtomltCircleModeSettingBinding bind = ViewAtomltCircleModeSettingBinding.bind(findViewById);
            i = R.id.atomLT_intelligent_view_bg;
            View findViewById3 = view.findViewById(i);
            if (findViewById3 != null && (findViewById2 = view.findViewById((i = R.id.atomLT_intelligent_view_blank))) != null) {
                i = R.id.atomLT_intelligent_view_mode;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(i);
                if (constraintLayout2 != null) {
                    i = R.id.atomLT_tv_follow_me;
                    TextView textView = (TextView) view.findViewById(i);
                    if (textView != null) {
                        i = R.id.atomLT_tv_hot_circle;
                        TextView textView2 = (TextView) view.findViewById(i);
                        if (textView2 != null) {
                            i = R.id.atomLT_tv_waypoint_flight;
                            TextView textView3 = (TextView) view.findViewById(i);
                            if (textView3 != null) {
                                return new ViewAtomltLeftIntelligentModeBinding((ConstraintLayout) view, constraintLayout, bind, findViewById3, findViewById2, constraintLayout2, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
