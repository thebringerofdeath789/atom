package com.ipotensic.potensicpro.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.ipotensic.potensicpro.anim.ViewHolderAnimator;
import com.logan.user.model.rev.RevUserGetFeedbackData;
import java.util.List;

/* loaded from: classes2.dex */
public class ExpandableViewHoldersUtil {

    public interface Expandable {
        View getExpandView();

        View getMarkView();

        View getTopView();
    }

    public static void rotateExpandIcon(final ImageView imageView, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 11) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
            ofFloat.setDuration(200L);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.ipotensic.potensicpro.anim.ExpandableViewHoldersUtil.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    imageView.setRotation(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            ofFloat.start();
        }
    }

    public static void openH(final RecyclerView.ViewHolder viewHolder, final View view, boolean z) {
        if (z) {
            Animator ofItemViewHeight = ViewHolderAnimator.ofItemViewHeight(viewHolder);
            ofItemViewHeight.addListener(new AnimatorListenerAdapter() { // from class: com.ipotensic.potensicpro.anim.ExpandableViewHoldersUtil.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    view.setVisibility(0);
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 1.0f);
                    ofFloat.setInterpolator(new LinearInterpolator());
                    ofFloat.addListener(new ViewHolderAnimator.ViewHolderAnimatorListener(viewHolder));
                    ofFloat.start();
                }
            });
            ofItemViewHeight.start();
        } else {
            view.setVisibility(0);
            view.setAlpha(1.0f);
        }
    }

    public static void closeH(RecyclerView.ViewHolder viewHolder, final View view, boolean z) {
        if (z) {
            Animator ofItemViewHeight = ViewHolderAnimator.ofItemViewHeight(viewHolder);
            ofItemViewHeight.addListener(new AnimatorListenerAdapter() { // from class: com.ipotensic.potensicpro.anim.ExpandableViewHoldersUtil.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    view.setVisibility(8);
                    view.setAlpha(0.0f);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    view.setVisibility(8);
                    view.setAlpha(0.0f);
                }
            });
            ofItemViewHeight.start();
        } else {
            view.setVisibility(8);
            view.setAlpha(0.0f);
        }
    }

    public static class KeepOneH<VH extends RecyclerView.ViewHolder & Expandable> {
        private int _opened = -1;

        public void bind(VH vh, int i) {
            if (i == this._opened) {
                VH vh2 = vh;
                ExpandableViewHoldersUtil.openH(vh, vh2.getExpandView(), false);
                ExpandableViewHoldersUtil.closeH(vh, vh2.getTopView(), false);
            } else {
                VH vh3 = vh;
                ExpandableViewHoldersUtil.openH(vh, vh3.getTopView(), false);
                ExpandableViewHoldersUtil.closeH(vh, vh3.getExpandView(), false);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void toggle(VH vh) {
            if (this._opened == vh.getAdapterPosition()) {
                this._opened = -1;
                VH vh2 = vh;
                ExpandableViewHoldersUtil.closeH(vh, vh2.getExpandView(), false);
                ExpandableViewHoldersUtil.openH(vh, vh2.getTopView(), false);
                return;
            }
            int i = this._opened;
            this._opened = vh.getAdapterPosition();
            VH vh3 = vh;
            ExpandableViewHoldersUtil.openH(vh, vh3.getExpandView(), false);
            ExpandableViewHoldersUtil.closeH(vh, vh3.getTopView(), false);
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = ((RecyclerView) vh.itemView.getParent()).findViewHolderForAdapterPosition(i);
            if (findViewHolderForAdapterPosition != 0) {
                Expandable expandable = (Expandable) findViewHolderForAdapterPosition;
                ExpandableViewHoldersUtil.closeH(findViewHolderForAdapterPosition, expandable.getExpandView(), false);
                ExpandableViewHoldersUtil.openH(findViewHolderForAdapterPosition, expandable.getTopView(), false);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void open(VH vh, List<RevUserGetFeedbackData.FeedbackInfo> list) {
            if (this._opened != vh.getAdapterPosition()) {
                int i = this._opened;
                this._opened = vh.getAdapterPosition();
                VH vh2 = vh;
                ExpandableViewHoldersUtil.openH(vh, vh2.getExpandView(), false);
                ExpandableViewHoldersUtil.closeH(vh, vh2.getTopView(), false);
                RecyclerView.ViewHolder findViewHolderForAdapterPosition = ((RecyclerView) vh.itemView.getParent()).findViewHolderForAdapterPosition(i);
                if (findViewHolderForAdapterPosition != 0) {
                    Expandable expandable = (Expandable) findViewHolderForAdapterPosition;
                    ExpandableViewHoldersUtil.openH(findViewHolderForAdapterPosition, expandable.getTopView(), false);
                    ExpandableViewHoldersUtil.closeH(findViewHolderForAdapterPosition, expandable.getExpandView(), false);
                    if (i < 0 || i >= list.size() || list.get(i).getState_user() != 1) {
                        return;
                    }
                    expandable.getMarkView().setVisibility(8);
                }
            }
        }

        public void close(VH vh, List<RevUserGetFeedbackData.FeedbackInfo> list) {
            if (this._opened == vh.getAdapterPosition()) {
                this._opened = -1;
                VH vh2 = vh;
                ExpandableViewHoldersUtil.closeH(vh, vh2.getExpandView(), false);
                ExpandableViewHoldersUtil.openH(vh, vh2.getTopView(), false);
                if (list.get(vh.getAdapterPosition()).getState_user() == 1) {
                    vh2.getMarkView().setVisibility(8);
                }
            }
        }

        public int openPos() {
            return this._opened;
        }
    }
}