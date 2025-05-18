package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.C2640R;

/* loaded from: classes2.dex */
public final class ViewMainMenuBinding implements ViewBinding {
    public final ImageButton btnMenuClose;
    public final Group gpAtom;
    public final Group group;
    public final ImageView ivCloseAtom;
    private final ConstraintLayout rootView;
    public final TextView tvAircraftLogAtom;
    public final TextView tvFlightLog;
    public final TextView tvFlightRecord;
    public final TextView tvFlightRecordAtom;
    public final TextView tvInstructions;
    public final TextView tvQuickGuide;
    public final TextView tvVideoTeach;

    private ViewMainMenuBinding(ConstraintLayout constraintLayout, ImageButton imageButton, Group group, Group group2, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = constraintLayout;
        this.btnMenuClose = imageButton;
        this.gpAtom = group;
        this.group = group2;
        this.ivCloseAtom = imageView;
        this.tvAircraftLogAtom = textView;
        this.tvFlightLog = textView2;
        this.tvFlightRecord = textView3;
        this.tvFlightRecordAtom = textView4;
        this.tvInstructions = textView5;
        this.tvQuickGuide = textView6;
        this.tvVideoTeach = textView7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewMainMenuBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewMainMenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2640R.layout.view_main_menu, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewMainMenuBinding bind(View view) {
        int i = C2640R.id.btn_menu_close;
        ImageButton imageButton = (ImageButton) view.findViewById(C2640R.id.btn_menu_close);
        if (imageButton != null) {
            i = C2640R.id.gp_atom;
            Group group = (Group) view.findViewById(C2640R.id.gp_atom);
            if (group != null) {
                i = C2640R.id.group;
                Group group2 = (Group) view.findViewById(C2640R.id.group);
                if (group2 != null) {
                    i = C2640R.id.iv_close_atom;
                    ImageView imageView = (ImageView) view.findViewById(C2640R.id.iv_close_atom);
                    if (imageView != null) {
                        i = C2640R.id.tv_aircraft_log_atom;
                        TextView textView = (TextView) view.findViewById(C2640R.id.tv_aircraft_log_atom);
                        if (textView != null) {
                            i = C2640R.id.tv_flight_log;
                            TextView textView2 = (TextView) view.findViewById(C2640R.id.tv_flight_log);
                            if (textView2 != null) {
                                i = C2640R.id.tv_flight_record;
                                TextView textView3 = (TextView) view.findViewById(C2640R.id.tv_flight_record);
                                if (textView3 != null) {
                                    i = C2640R.id.tv_flight_record_atom;
                                    TextView textView4 = (TextView) view.findViewById(C2640R.id.tv_flight_record_atom);
                                    if (textView4 != null) {
                                        i = C2640R.id.tv_instructions;
                                        TextView textView5 = (TextView) view.findViewById(C2640R.id.tv_instructions);
                                        if (textView5 != null) {
                                            i = C2640R.id.tv_quick_guide;
                                            TextView textView6 = (TextView) view.findViewById(C2640R.id.tv_quick_guide);
                                            if (textView6 != null) {
                                                i = C2640R.id.tv_video_teach;
                                                TextView textView7 = (TextView) view.findViewById(C2640R.id.tv_video_teach);
                                                if (textView7 != null) {
                                                    return new ViewMainMenuBinding((ConstraintLayout) view, imageButton, group, group2, imageView, textView, textView2, textView3, textView4, textView5, textView6, textView7);
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