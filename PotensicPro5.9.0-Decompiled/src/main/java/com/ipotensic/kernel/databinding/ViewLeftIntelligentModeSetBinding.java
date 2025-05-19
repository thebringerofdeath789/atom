package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewLeftIntelligentModeSetBinding implements ViewBinding {
    public final CheckBox cbDirectional;
    public final CheckBox cbGps;
    public final CheckBox cbLock;
    public final CheckBox cbRemote;
    public final ConstraintLayout llCb;
    public final ConstraintLayout llMode;
    public final LinearLayout llRemote;
    private final ScrollView rootView;
    public final TextView tvFlight;
    public final TextView tvFollowMe;
    public final TextView tvHotCircle;
    public final TextView tvMode;
    public final TextView tvOthers;
    public final TextView tvWaypointFlight;

    private ViewLeftIntelligentModeSetBinding(ScrollView scrollView, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = scrollView;
        this.cbDirectional = checkBox;
        this.cbGps = checkBox2;
        this.cbLock = checkBox3;
        this.cbRemote = checkBox4;
        this.llCb = constraintLayout;
        this.llMode = constraintLayout2;
        this.llRemote = linearLayout;
        this.tvFlight = textView;
        this.tvFollowMe = textView2;
        this.tvHotCircle = textView3;
        this.tvMode = textView4;
        this.tvOthers = textView5;
        this.tvWaypointFlight = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static ViewLeftIntelligentModeSetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLeftIntelligentModeSetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_left_intelligent_mode_set, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLeftIntelligentModeSetBinding bind(View view) {
        int i = R.id.cb_directional;
        CheckBox checkBox = (CheckBox) view.findViewById(i);
        if (checkBox != null) {
            i = R.id.cb_gps;
            CheckBox checkBox2 = (CheckBox) view.findViewById(i);
            if (checkBox2 != null) {
                i = R.id.cb_lock;
                CheckBox checkBox3 = (CheckBox) view.findViewById(i);
                if (checkBox3 != null) {
                    i = R.id.cb_remote;
                    CheckBox checkBox4 = (CheckBox) view.findViewById(i);
                    if (checkBox4 != null) {
                        i = R.id.ll_cb;
                        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(i);
                        if (constraintLayout != null) {
                            i = R.id.ll_mode;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(i);
                            if (constraintLayout2 != null) {
                                i = R.id.ll_remote;
                                LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                                if (linearLayout != null) {
                                    i = R.id.tv_flight;
                                    TextView textView = (TextView) view.findViewById(i);
                                    if (textView != null) {
                                        i = R.id.tv_follow_me;
                                        TextView textView2 = (TextView) view.findViewById(i);
                                        if (textView2 != null) {
                                            i = R.id.tv_hot_circle;
                                            TextView textView3 = (TextView) view.findViewById(i);
                                            if (textView3 != null) {
                                                i = R.id.tv_mode;
                                                TextView textView4 = (TextView) view.findViewById(i);
                                                if (textView4 != null) {
                                                    i = R.id.tv_others;
                                                    TextView textView5 = (TextView) view.findViewById(i);
                                                    if (textView5 != null) {
                                                        i = R.id.tv_waypoint_flight;
                                                        TextView textView6 = (TextView) view.findViewById(i);
                                                        if (textView6 != null) {
                                                            return new ViewLeftIntelligentModeSetBinding((ScrollView) view, checkBox, checkBox2, checkBox3, checkBox4, constraintLayout, constraintLayout2, linearLayout, textView, textView2, textView3, textView4, textView5, textView6);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
