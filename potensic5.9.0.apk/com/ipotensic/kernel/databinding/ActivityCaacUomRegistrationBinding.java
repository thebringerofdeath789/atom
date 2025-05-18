package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.view.blur.BlurView;

/* loaded from: classes2.dex */
public final class ActivityCaacUomRegistrationBinding implements ViewBinding {
    public final ImageButton btnBack;
    public final TextView btnCopy;
    public final TextView btnUomRegisterTips;
    public final BlurView downloadBlurView;
    public final BlurView infoBlurView;
    public final ImageView ivDownloadQRCodeDetail;
    public final ImageView ivInfoQRCode;
    public final ImageView ivInfoQRCodeDetail;
    public final ImageView ivOrder1;
    public final ImageView ivOrder2;
    public final ImageView ivOrder3;
    public final RelativeLayout layoutDownloadQRCodeDetail;
    public final LinearLayout layoutDownloadQRCodeEnlarge;
    public final ConstraintLayout layoutInfoQRCodeDetail;
    public final LinearLayout layoutInfoQRCodeEnlarge;
    public final LinearLayout layoutRegister;
    public final RelativeLayout layoutTop;
    public final View line1;
    public final View line2;
    private final RelativeLayout rootView;
    public final TextView tvDownloadQRCodeEnlarge;
    public final TextView tvFlightSN;
    public final TextView tvInfoDetail;
    public final TextView tvInfoQRCodeEnlarge;
    public final TextView tvOrder1Tips;
    public final TextView tvOrder1Title;
    public final TextView tvOrder1Url;
    public final TextView tvOrder2Title;
    public final TextView tvOrder3Title;
    public final TextView tvProductName;

    private ActivityCaacUomRegistrationBinding(RelativeLayout relativeLayout, ImageButton imageButton, TextView textView, TextView textView2, BlurView blurView, BlurView blurView2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, RelativeLayout relativeLayout2, LinearLayout linearLayout, ConstraintLayout constraintLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, RelativeLayout relativeLayout3, View view, View view2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12) {
        this.rootView = relativeLayout;
        this.btnBack = imageButton;
        this.btnCopy = textView;
        this.btnUomRegisterTips = textView2;
        this.downloadBlurView = blurView;
        this.infoBlurView = blurView2;
        this.ivDownloadQRCodeDetail = imageView;
        this.ivInfoQRCode = imageView2;
        this.ivInfoQRCodeDetail = imageView3;
        this.ivOrder1 = imageView4;
        this.ivOrder2 = imageView5;
        this.ivOrder3 = imageView6;
        this.layoutDownloadQRCodeDetail = relativeLayout2;
        this.layoutDownloadQRCodeEnlarge = linearLayout;
        this.layoutInfoQRCodeDetail = constraintLayout;
        this.layoutInfoQRCodeEnlarge = linearLayout2;
        this.layoutRegister = linearLayout3;
        this.layoutTop = relativeLayout3;
        this.line1 = view;
        this.line2 = view2;
        this.tvDownloadQRCodeEnlarge = textView3;
        this.tvFlightSN = textView4;
        this.tvInfoDetail = textView5;
        this.tvInfoQRCodeEnlarge = textView6;
        this.tvOrder1Tips = textView7;
        this.tvOrder1Title = textView8;
        this.tvOrder1Url = textView9;
        this.tvOrder2Title = textView10;
        this.tvOrder3Title = textView11;
        this.tvProductName = textView12;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityCaacUomRegistrationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityCaacUomRegistrationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.activity_caac_uom_registration, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityCaacUomRegistrationBinding bind(View view) {
        View findViewById;
        View findViewById2;
        int i = C1965R.id.btnBack;
        ImageButton imageButton = (ImageButton) view.findViewById(i);
        if (imageButton != null) {
            i = C1965R.id.btnCopy;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                i = C1965R.id.btnUomRegisterTips;
                TextView textView2 = (TextView) view.findViewById(i);
                if (textView2 != null) {
                    i = C1965R.id.downloadBlurView;
                    BlurView blurView = (BlurView) view.findViewById(i);
                    if (blurView != null) {
                        i = C1965R.id.infoBlurView;
                        BlurView blurView2 = (BlurView) view.findViewById(i);
                        if (blurView2 != null) {
                            i = C1965R.id.ivDownloadQRCodeDetail;
                            ImageView imageView = (ImageView) view.findViewById(i);
                            if (imageView != null) {
                                i = C1965R.id.ivInfoQRCode;
                                ImageView imageView2 = (ImageView) view.findViewById(i);
                                if (imageView2 != null) {
                                    i = C1965R.id.ivInfoQRCodeDetail;
                                    ImageView imageView3 = (ImageView) view.findViewById(i);
                                    if (imageView3 != null) {
                                        i = C1965R.id.ivOrder1;
                                        ImageView imageView4 = (ImageView) view.findViewById(i);
                                        if (imageView4 != null) {
                                            i = C1965R.id.ivOrder2;
                                            ImageView imageView5 = (ImageView) view.findViewById(i);
                                            if (imageView5 != null) {
                                                i = C1965R.id.ivOrder3;
                                                ImageView imageView6 = (ImageView) view.findViewById(i);
                                                if (imageView6 != null) {
                                                    i = C1965R.id.layoutDownloadQRCodeDetail;
                                                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(i);
                                                    if (relativeLayout != null) {
                                                        i = C1965R.id.layoutDownloadQRCodeEnlarge;
                                                        LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                                                        if (linearLayout != null) {
                                                            i = C1965R.id.layoutInfoQRCodeDetail;
                                                            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(i);
                                                            if (constraintLayout != null) {
                                                                i = C1965R.id.layoutInfoQRCodeEnlarge;
                                                                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(i);
                                                                if (linearLayout2 != null) {
                                                                    i = C1965R.id.layoutRegister;
                                                                    LinearLayout linearLayout3 = (LinearLayout) view.findViewById(i);
                                                                    if (linearLayout3 != null) {
                                                                        i = C1965R.id.layoutTop;
                                                                        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(i);
                                                                        if (relativeLayout2 != null && (findViewById = view.findViewById((i = C1965R.id.line1))) != null && (findViewById2 = view.findViewById((i = C1965R.id.line2))) != null) {
                                                                            i = C1965R.id.tvDownloadQRCodeEnlarge;
                                                                            TextView textView3 = (TextView) view.findViewById(i);
                                                                            if (textView3 != null) {
                                                                                i = C1965R.id.tvFlightSN;
                                                                                TextView textView4 = (TextView) view.findViewById(i);
                                                                                if (textView4 != null) {
                                                                                    i = C1965R.id.tvInfoDetail;
                                                                                    TextView textView5 = (TextView) view.findViewById(i);
                                                                                    if (textView5 != null) {
                                                                                        i = C1965R.id.tvInfoQRCodeEnlarge;
                                                                                        TextView textView6 = (TextView) view.findViewById(i);
                                                                                        if (textView6 != null) {
                                                                                            i = C1965R.id.tvOrder1Tips;
                                                                                            TextView textView7 = (TextView) view.findViewById(i);
                                                                                            if (textView7 != null) {
                                                                                                i = C1965R.id.tvOrder1Title;
                                                                                                TextView textView8 = (TextView) view.findViewById(i);
                                                                                                if (textView8 != null) {
                                                                                                    i = C1965R.id.tvOrder1Url;
                                                                                                    TextView textView9 = (TextView) view.findViewById(i);
                                                                                                    if (textView9 != null) {
                                                                                                        i = C1965R.id.tvOrder2Title;
                                                                                                        TextView textView10 = (TextView) view.findViewById(i);
                                                                                                        if (textView10 != null) {
                                                                                                            i = C1965R.id.tvOrder3Title;
                                                                                                            TextView textView11 = (TextView) view.findViewById(i);
                                                                                                            if (textView11 != null) {
                                                                                                                i = C1965R.id.tvProductName;
                                                                                                                TextView textView12 = (TextView) view.findViewById(i);
                                                                                                                if (textView12 != null) {
                                                                                                                    return new ActivityCaacUomRegistrationBinding((RelativeLayout) view, imageButton, textView, textView2, blurView, blurView2, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, relativeLayout, linearLayout, constraintLayout, linearLayout2, linearLayout3, relativeLayout2, findViewById, findViewById2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}