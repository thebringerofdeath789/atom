package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewMapBinding implements ViewBinding {
    public final ImageButton ivCancelFly;
    public final ImageButton ivGo;
    public final ImageView ivMapCompassBg;
    public final ImageButton ivMapLock;
    public final ImageButton ivMapMark;
    public final ImageButton ivMapPosition;
    public final ImageButton ivMapSetHide;
    public final ImageButton ivMapType;
    public final ImageButton ivNoFlyZoneHelp;
    public final ImageButton ivWaypointCancel;
    public final ImageButton ivWaypointFly;
    public final ImageButton ivWaypointStopFly;
    private final ConstraintLayout rootView;
    public final ViewMapPositionBinding viewMapPosition;
    public final ViewMapSetBinding viewMapSet;
    public final ViewMapTypeBinding viewMapType;

    private ViewMapBinding(ConstraintLayout constraintLayout, ImageButton imageButton, ImageButton imageButton2, ImageView imageView, ImageButton imageButton3, ImageButton imageButton4, ImageButton imageButton5, ImageButton imageButton6, ImageButton imageButton7, ImageButton imageButton8, ImageButton imageButton9, ImageButton imageButton10, ImageButton imageButton11, ViewMapPositionBinding viewMapPositionBinding, ViewMapSetBinding viewMapSetBinding, ViewMapTypeBinding viewMapTypeBinding) {
        this.rootView = constraintLayout;
        this.ivCancelFly = imageButton;
        this.ivGo = imageButton2;
        this.ivMapCompassBg = imageView;
        this.ivMapLock = imageButton3;
        this.ivMapMark = imageButton4;
        this.ivMapPosition = imageButton5;
        this.ivMapSetHide = imageButton6;
        this.ivMapType = imageButton7;
        this.ivNoFlyZoneHelp = imageButton8;
        this.ivWaypointCancel = imageButton9;
        this.ivWaypointFly = imageButton10;
        this.ivWaypointStopFly = imageButton11;
        this.viewMapPosition = viewMapPositionBinding;
        this.viewMapSet = viewMapSetBinding;
        this.viewMapType = viewMapTypeBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewMapBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewMapBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_map, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewMapBinding bind(View view) {
        View findViewById;
        int i = R.id.iv_cancel_fly;
        ImageButton imageButton = (ImageButton) view.findViewById(i);
        if (imageButton != null) {
            i = R.id.iv_go;
            ImageButton imageButton2 = (ImageButton) view.findViewById(i);
            if (imageButton2 != null) {
                i = R.id.iv_map_compass_bg;
                ImageView imageView = (ImageView) view.findViewById(i);
                if (imageView != null) {
                    i = R.id.iv_map_lock;
                    ImageButton imageButton3 = (ImageButton) view.findViewById(i);
                    if (imageButton3 != null) {
                        i = R.id.iv_map_mark;
                        ImageButton imageButton4 = (ImageButton) view.findViewById(i);
                        if (imageButton4 != null) {
                            i = R.id.iv_map_position;
                            ImageButton imageButton5 = (ImageButton) view.findViewById(i);
                            if (imageButton5 != null) {
                                i = R.id.iv_map_set_hide;
                                ImageButton imageButton6 = (ImageButton) view.findViewById(i);
                                if (imageButton6 != null) {
                                    i = R.id.iv_map_type;
                                    ImageButton imageButton7 = (ImageButton) view.findViewById(i);
                                    if (imageButton7 != null) {
                                        i = R.id.iv_no_fly_zone_help;
                                        ImageButton imageButton8 = (ImageButton) view.findViewById(i);
                                        if (imageButton8 != null) {
                                            i = R.id.iv_waypoint_cancel;
                                            ImageButton imageButton9 = (ImageButton) view.findViewById(i);
                                            if (imageButton9 != null) {
                                                i = R.id.iv_waypoint_fly;
                                                ImageButton imageButton10 = (ImageButton) view.findViewById(i);
                                                if (imageButton10 != null) {
                                                    i = R.id.iv_waypoint_stop_fly;
                                                    ImageButton imageButton11 = (ImageButton) view.findViewById(i);
                                                    if (imageButton11 != null && (findViewById = view.findViewById((i = R.id.view_map_position))) != null) {
                                                        ViewMapPositionBinding bind = ViewMapPositionBinding.bind(findViewById);
                                                        i = R.id.view_map_set;
                                                        View findViewById2 = view.findViewById(i);
                                                        if (findViewById2 != null) {
                                                            ViewMapSetBinding bind2 = ViewMapSetBinding.bind(findViewById2);
                                                            i = R.id.view_map_type;
                                                            View findViewById3 = view.findViewById(i);
                                                            if (findViewById3 != null) {
                                                                return new ViewMapBinding((ConstraintLayout) view, imageButton, imageButton2, imageView, imageButton3, imageButton4, imageButton5, imageButton6, imageButton7, imageButton8, imageButton9, imageButton10, imageButton11, bind, bind2, ViewMapTypeBinding.bind(findViewById3));
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}