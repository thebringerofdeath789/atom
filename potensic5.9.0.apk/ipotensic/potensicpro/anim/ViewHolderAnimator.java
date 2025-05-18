package com.ipotensic.potensicpro.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public class ViewHolderAnimator {

    public static class ViewHolderAnimatorListener extends AnimatorListenerAdapter {
        private final RecyclerView.ViewHolder _holder;

        public ViewHolderAnimatorListener(RecyclerView.ViewHolder viewHolder) {
            this._holder = viewHolder;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this._holder.setIsRecyclable(false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this._holder.setIsRecyclable(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this._holder.setIsRecyclable(true);
        }
    }

    public static class LayoutParamsAnimatorListener extends AnimatorListenerAdapter {
        private final int _paramsHeight;
        private final int _paramsWidth;
        private final View _view;

        public LayoutParamsAnimatorListener(View view, int i, int i2) {
            this._view = view;
            this._paramsWidth = i;
            this._paramsHeight = i2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ViewGroup.LayoutParams layoutParams = this._view.getLayoutParams();
            layoutParams.width = this._paramsWidth;
            layoutParams.height = this._paramsHeight;
            this._view.setLayoutParams(layoutParams);
        }
    }

    public static Animator ofItemViewHeight(RecyclerView.ViewHolder viewHolder) {
        View view = (View) viewHolder.itemView.getParent();
        if (view == null) {
            throw new IllegalStateException("Cannot animate the layout of a view that has no parent");
        }
        int measuredHeight = viewHolder.itemView.getMeasuredHeight();
        viewHolder.itemView.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        Animator ofHeight = LayoutAnimator.ofHeight(viewHolder.itemView, measuredHeight, viewHolder.itemView.getMeasuredHeight());
        ofHeight.addListener(new ViewHolderAnimatorListener(viewHolder));
        ofHeight.addListener(new LayoutParamsAnimatorListener(viewHolder.itemView, -1, -2));
        return ofHeight;
    }
}