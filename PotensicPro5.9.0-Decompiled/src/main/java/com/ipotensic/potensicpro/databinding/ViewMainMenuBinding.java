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
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ViewMainMenuBinding implements ViewBinding {
    public final ImageButton btnMenuClose;
    public final Group gpAtom;
    public final Group group;
    public final ImageView ivCloseAtom;
    private final ConstraintLayout rootView;
    public final TextView tvAcademy;
    public final TextView tvAircraftLogAtom;
    public final TextView tvFlightLog;
    public final TextView tvFlightRecord;
    public final TextView tvFlightRecordAtom;
    public final TextView tvInstructions;
    public final TextView tvQuickGuide;
    public final TextView tvVideoTeach;

    private ViewMainMenuBinding(ConstraintLayout constraintLayout, ImageButton imageButton, Group group, Group group2, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.rootView = constraintLayout;
        this.btnMenuClose = imageButton;
        this.gpAtom = group;
        this.group = group2;
        this.ivCloseAtom = imageView;
        this.tvAcademy = textView;
        this.tvAircraftLogAtom = textView2;
        this.tvFlightLog = textView3;
        this.tvFlightRecord = textView4;
        this.tvFlightRecordAtom = textView5;
        this.tvInstructions = textView6;
        this.tvQuickGuide = textView7;
        this.tvVideoTeach = textView8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewMainMenuBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewMainMenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_main_menu, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewMainMenuBinding bind(View view) {
        int i = R.id.btn_menu_close;
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.btn_menu_close);
        if (imageButton != null) {
            i = R.id.gp_atom;
            Group group = (Group) view.findViewById(R.id.gp_atom);
            if (group != null) {
                i = R.id.group;
                Group group2 = (Group) view.findViewById(R.id.group);
                if (group2 != null) {
                    i = R.id.iv_close_atom;
                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_close_atom);
                    if (imageView != null) {
                        i = R.id.tv_academy;
                        TextView textView = (TextView) view.findViewById(R.id.tv_academy);
                        if (textView != null) {
                            i = R.id.tv_aircraft_log_atom;
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_aircraft_log_atom);
                            if (textView2 != null) {
                                i = R.id.tv_flight_log;
                                TextView textView3 = (TextView) view.findViewById(R.id.tv_flight_log);
                                if (textView3 != null) {
                                    i = R.id.tv_flight_record;
                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_flight_record);
                                    if (textView4 != null) {
                                        i = R.id.tv_flight_record_atom;
                                        TextView textView5 = (TextView) view.findViewById(R.id.tv_flight_record_atom);
                                        if (textView5 != null) {
                                            i = R.id.tv_instructions;
                                            TextView textView6 = (TextView) view.findViewById(R.id.tv_instructions);
                                            if (textView6 != null) {
                                                i = R.id.tv_quick_guide;
                                                TextView textView7 = (TextView) view.findViewById(R.id.tv_quick_guide);
                                                if (textView7 != null) {
                                                    i = R.id.tv_video_teach;
                                                    TextView textView8 = (TextView) view.findViewById(R.id.tv_video_teach);
                                                    if (textView8 != null) {
                                                        return new ViewMainMenuBinding((ConstraintLayout) view, imageButton, group, group2, imageView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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
