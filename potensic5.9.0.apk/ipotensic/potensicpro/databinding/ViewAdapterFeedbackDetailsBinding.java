package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;
import com.ipotensic.potensicpro.view.RoundImageView;

/* loaded from: classes2.dex */
public final class ViewAdapterFeedbackDetailsBinding implements ViewBinding {
    public final ConstraintLayout clBottomLayout;
    public final ConstraintLayout clCustomerLayout;
    public final ConstraintLayout clTopLayout;
    public final RoundImageView imageView;
    public final ImageView ivDown;
    public final ImageView ivRedPoint;
    public final ImageView ivRight;
    public final View line1;
    private final CardView rootView;
    public final RecyclerView rvCustomerFeedback;
    public final RecyclerView rvUserFeedback;
    public final TextView tvCustomerReply;
    public final TextView tvCustomerReplyTime;
    public final TextView tvMe;
    public final TextView tvTitle1;
    public final TextView tvTitle2;
    public final TextView tvUserReply1;
    public final TextView tvUserReply2;
    public final TextView tvUserTime1;
    public final TextView tvUserTime2;
    public final ImageView videoView;

    private ViewAdapterFeedbackDetailsBinding(CardView cardView, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, RoundImageView roundImageView, ImageView imageView, ImageView imageView2, ImageView imageView3, View view, RecyclerView recyclerView, RecyclerView recyclerView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, ImageView imageView4) {
        this.rootView = cardView;
        this.clBottomLayout = constraintLayout;
        this.clCustomerLayout = constraintLayout2;
        this.clTopLayout = constraintLayout3;
        this.imageView = roundImageView;
        this.ivDown = imageView;
        this.ivRedPoint = imageView2;
        this.ivRight = imageView3;
        this.line1 = view;
        this.rvCustomerFeedback = recyclerView;
        this.rvUserFeedback = recyclerView2;
        this.tvCustomerReply = textView;
        this.tvCustomerReplyTime = textView2;
        this.tvMe = textView3;
        this.tvTitle1 = textView4;
        this.tvTitle2 = textView5;
        this.tvUserReply1 = textView6;
        this.tvUserReply2 = textView7;
        this.tvUserTime1 = textView8;
        this.tvUserTime2 = textView9;
        this.videoView = imageView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static ViewAdapterFeedbackDetailsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewAdapterFeedbackDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_adapter_feedback_details, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewAdapterFeedbackDetailsBinding bind(View view) {
        int i = R.id.cl_bottom_layout;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_bottom_layout);
        if (constraintLayout != null) {
            i = R.id.cl_customer_layout;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_customer_layout);
            if (constraintLayout2 != null) {
                i = R.id.cl_top_layout;
                ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.cl_top_layout);
                if (constraintLayout3 != null) {
                    i = R.id.image_view;
                    RoundImageView roundImageView = (RoundImageView) view.findViewById(R.id.image_view);
                    if (roundImageView != null) {
                        i = R.id.iv_down;
                        ImageView imageView = (ImageView) view.findViewById(R.id.iv_down);
                        if (imageView != null) {
                            i = R.id.iv_red_point;
                            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_red_point);
                            if (imageView2 != null) {
                                i = R.id.iv_right;
                                ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_right);
                                if (imageView3 != null) {
                                    i = R.id.line1;
                                    View findViewById = view.findViewById(R.id.line1);
                                    if (findViewById != null) {
                                        i = R.id.rv_customer_feedback;
                                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_customer_feedback);
                                        if (recyclerView != null) {
                                            i = R.id.rv_user_feedback;
                                            RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.rv_user_feedback);
                                            if (recyclerView2 != null) {
                                                i = R.id.tv_customer_reply;
                                                TextView textView = (TextView) view.findViewById(R.id.tv_customer_reply);
                                                if (textView != null) {
                                                    i = R.id.tv_customer_reply_time;
                                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_customer_reply_time);
                                                    if (textView2 != null) {
                                                        i = R.id.tv_me;
                                                        TextView textView3 = (TextView) view.findViewById(R.id.tv_me);
                                                        if (textView3 != null) {
                                                            i = R.id.tv_title_1;
                                                            TextView textView4 = (TextView) view.findViewById(R.id.tv_title_1);
                                                            if (textView4 != null) {
                                                                i = R.id.tv_title_2;
                                                                TextView textView5 = (TextView) view.findViewById(R.id.tv_title_2);
                                                                if (textView5 != null) {
                                                                    i = R.id.tv_user_reply_1;
                                                                    TextView textView6 = (TextView) view.findViewById(R.id.tv_user_reply_1);
                                                                    if (textView6 != null) {
                                                                        i = R.id.tv_user_reply_2;
                                                                        TextView textView7 = (TextView) view.findViewById(R.id.tv_user_reply_2);
                                                                        if (textView7 != null) {
                                                                            i = R.id.tv_user_time_1;
                                                                            TextView textView8 = (TextView) view.findViewById(R.id.tv_user_time_1);
                                                                            if (textView8 != null) {
                                                                                i = R.id.tv_user_time_2;
                                                                                TextView textView9 = (TextView) view.findViewById(R.id.tv_user_time_2);
                                                                                if (textView9 != null) {
                                                                                    i = R.id.video_view;
                                                                                    ImageView imageView4 = (ImageView) view.findViewById(R.id.video_view);
                                                                                    if (imageView4 != null) {
                                                                                        return new ViewAdapterFeedbackDetailsBinding((CardView) view, constraintLayout, constraintLayout2, constraintLayout3, roundImageView, imageView, imageView2, imageView3, findViewById, recyclerView, recyclerView2, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, imageView4);
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