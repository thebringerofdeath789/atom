package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.baselib.cropbitmap.LikeQQCropView;
import com.ipotensic.potensicpro.R;
import com.ipotensic.potensicpro.view.CircleImageView;

/* loaded from: classes2.dex */
public final class ActivityNickNameBinding implements ViewBinding {
    public final TextView btnCancel;
    public final TextView btnConfirm;
    public final ImageButton btnReturn;
    public final TextView btnSure;
    public final EditText etNick;
    public final CircleImageView imgHead;
    public final ConstraintLayout layoutCrop;
    private final ConstraintLayout rootView;
    public final View viewBlank;
    public final LikeQQCropView viewCropBitmap;

    private ActivityNickNameBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, ImageButton imageButton, TextView textView3, EditText editText, CircleImageView circleImageView, ConstraintLayout constraintLayout2, View view, LikeQQCropView likeQQCropView) {
        this.rootView = constraintLayout;
        this.btnCancel = textView;
        this.btnConfirm = textView2;
        this.btnReturn = imageButton;
        this.btnSure = textView3;
        this.etNick = editText;
        this.imgHead = circleImageView;
        this.layoutCrop = constraintLayout2;
        this.viewBlank = view;
        this.viewCropBitmap = likeQQCropView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityNickNameBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityNickNameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_nick_name, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityNickNameBinding bind(View view) {
        int i = R.id.btn_cancel;
        TextView textView = (TextView) view.findViewById(R.id.btn_cancel);
        if (textView != null) {
            i = R.id.btn_confirm;
            TextView textView2 = (TextView) view.findViewById(R.id.btn_confirm);
            if (textView2 != null) {
                i = R.id.btn_return;
                ImageButton imageButton = (ImageButton) view.findViewById(R.id.btn_return);
                if (imageButton != null) {
                    i = R.id.btn_sure;
                    TextView textView3 = (TextView) view.findViewById(R.id.btn_sure);
                    if (textView3 != null) {
                        i = R.id.et_nick;
                        EditText editText = (EditText) view.findViewById(R.id.et_nick);
                        if (editText != null) {
                            i = R.id.img_head;
                            CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.img_head);
                            if (circleImageView != null) {
                                i = R.id.layout_crop;
                                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.layout_crop);
                                if (constraintLayout != null) {
                                    i = R.id.view_blank;
                                    View findViewById = view.findViewById(R.id.view_blank);
                                    if (findViewById != null) {
                                        i = R.id.view_crop_bitmap;
                                        LikeQQCropView likeQQCropView = (LikeQQCropView) view.findViewById(R.id.view_crop_bitmap);
                                        if (likeQQCropView != null) {
                                            return new ActivityNickNameBinding((ConstraintLayout) view, textView, textView2, imageButton, textView3, editText, circleImageView, constraintLayout, findViewById, likeQQCropView);
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
