package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.view.ExpandableView;
import com.ipotensic.potensicpro.R;
import com.ipotensic.potensicpro.view.CircleImageView;

/* loaded from: classes2.dex */
public final class ViewMainPageMeBinding implements ViewBinding {
    public final ExpandableView cancelAccount;
    public final ConstraintLayout clTopLayout;
    public final ImageView imgAccountEidt;
    public final CircleImageView imgHead;
    public final ImageView ivBadgeView;
    public final ImageView ivFeedback;
    public final LinearLayout layoutHead;
    public final ConstraintLayout layoutTop;
    public final View lineDebug;
    public final ExpandableView logout;
    public final View meBottomView;
    private final ConstraintLayout rootView;
    public final ScrollView scroll;
    public final TextView tvBadgeNum;
    public final TextView tvDebug;
    public final TextView tvFeedback;
    public final TextView tvFindMyDrone;
    public final TextView tvModifyLoginPwd;
    public final TextView tvNickName;
    public final TextView tvPosition;
    public final TextView tvResetGuidelines;
    public final TextView tvUserAgreement;

    private ViewMainPageMeBinding(ConstraintLayout constraintLayout, ExpandableView expandableView, ConstraintLayout constraintLayout2, ImageView imageView, CircleImageView circleImageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, ConstraintLayout constraintLayout3, View view, ExpandableView expandableView2, View view2, ScrollView scrollView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        this.rootView = constraintLayout;
        this.cancelAccount = expandableView;
        this.clTopLayout = constraintLayout2;
        this.imgAccountEidt = imageView;
        this.imgHead = circleImageView;
        this.ivBadgeView = imageView2;
        this.ivFeedback = imageView3;
        this.layoutHead = linearLayout;
        this.layoutTop = constraintLayout3;
        this.lineDebug = view;
        this.logout = expandableView2;
        this.meBottomView = view2;
        this.scroll = scrollView;
        this.tvBadgeNum = textView;
        this.tvDebug = textView2;
        this.tvFeedback = textView3;
        this.tvFindMyDrone = textView4;
        this.tvModifyLoginPwd = textView5;
        this.tvNickName = textView6;
        this.tvPosition = textView7;
        this.tvResetGuidelines = textView8;
        this.tvUserAgreement = textView9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewMainPageMeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewMainPageMeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_main_page_me, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewMainPageMeBinding bind(View view) {
        int i = R.id.cancel_account;
        ExpandableView expandableView = (ExpandableView) view.findViewById(R.id.cancel_account);
        if (expandableView != null) {
            i = R.id.cl_top_layout;
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_top_layout);
            if (constraintLayout != null) {
                i = R.id.img_account_eidt;
                ImageView imageView = (ImageView) view.findViewById(R.id.img_account_eidt);
                if (imageView != null) {
                    i = R.id.img_head;
                    CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.img_head);
                    if (circleImageView != null) {
                        i = R.id.iv_badge_view;
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_badge_view);
                        if (imageView2 != null) {
                            i = R.id.iv_feedback;
                            ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_feedback);
                            if (imageView3 != null) {
                                i = R.id.layout_head;
                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout_head);
                                if (linearLayout != null) {
                                    i = R.id.layout_top;
                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.layout_top);
                                    if (constraintLayout2 != null) {
                                        i = R.id.line_debug;
                                        View findViewById = view.findViewById(R.id.line_debug);
                                        if (findViewById != null) {
                                            i = R.id.logout;
                                            ExpandableView expandableView2 = (ExpandableView) view.findViewById(R.id.logout);
                                            if (expandableView2 != null) {
                                                i = R.id.me_bottom_view;
                                                View findViewById2 = view.findViewById(R.id.me_bottom_view);
                                                if (findViewById2 != null) {
                                                    i = R.id.scroll;
                                                    ScrollView scrollView = (ScrollView) view.findViewById(R.id.scroll);
                                                    if (scrollView != null) {
                                                        i = R.id.tv_badge_num;
                                                        TextView textView = (TextView) view.findViewById(R.id.tv_badge_num);
                                                        if (textView != null) {
                                                            i = R.id.tv_debug;
                                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_debug);
                                                            if (textView2 != null) {
                                                                i = R.id.tv_feedback;
                                                                TextView textView3 = (TextView) view.findViewById(R.id.tv_feedback);
                                                                if (textView3 != null) {
                                                                    i = R.id.tv_find_my_drone;
                                                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_find_my_drone);
                                                                    if (textView4 != null) {
                                                                        i = R.id.tv_modify_login_pwd;
                                                                        TextView textView5 = (TextView) view.findViewById(R.id.tv_modify_login_pwd);
                                                                        if (textView5 != null) {
                                                                            i = R.id.tv_nick_name;
                                                                            TextView textView6 = (TextView) view.findViewById(R.id.tv_nick_name);
                                                                            if (textView6 != null) {
                                                                                i = R.id.tv_position;
                                                                                TextView textView7 = (TextView) view.findViewById(R.id.tv_position);
                                                                                if (textView7 != null) {
                                                                                    i = R.id.tv_reset_guidelines;
                                                                                    TextView textView8 = (TextView) view.findViewById(R.id.tv_reset_guidelines);
                                                                                    if (textView8 != null) {
                                                                                        i = R.id.tv_user_agreement;
                                                                                        TextView textView9 = (TextView) view.findViewById(R.id.tv_user_agreement);
                                                                                        if (textView9 != null) {
                                                                                            return new ViewMainPageMeBinding((ConstraintLayout) view, expandableView, constraintLayout, imageView, circleImageView, imageView2, imageView3, linearLayout, constraintLayout2, findViewById, expandableView2, findViewById2, scrollView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9);
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