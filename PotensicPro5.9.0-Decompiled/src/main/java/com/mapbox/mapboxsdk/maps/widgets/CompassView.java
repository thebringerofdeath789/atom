package com.mapbox.mapboxsdk.maps.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import com.mapbox.mapboxsdk.maps.MapboxMap;

/* loaded from: classes3.dex */
public final class CompassView extends ImageView implements Runnable {
    private static final long TIME_FADE_ANIMATION = 500;
    public static final long TIME_MAP_NORTH_ANIMATION = 150;
    public static final long TIME_WAIT_IDLE = 500;
    private MapboxMap.OnCompassAnimationListener compassAnimationListener;
    private int compassImageResource;
    private ViewPropertyAnimatorCompat fadeAnimator;
    private boolean fadeCompassViewFacingNorth;
    private boolean isAnimating;
    private boolean legacyImageDrawableSetter;
    private float rotation;

    public CompassView(Context context) {
        super(context);
        this.rotation = 0.0f;
        this.fadeCompassViewFacingNorth = true;
        this.isAnimating = false;
        this.legacyImageDrawableSetter = false;
        initialize(context);
    }

    public CompassView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rotation = 0.0f;
        this.fadeCompassViewFacingNorth = true;
        this.isAnimating = false;
        this.legacyImageDrawableSetter = false;
        initialize(context);
    }

    public CompassView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.rotation = 0.0f;
        this.fadeCompassViewFacingNorth = true;
        this.isAnimating = false;
        this.legacyImageDrawableSetter = false;
        initialize(context);
    }

    private void initialize(Context context) {
        setEnabled(false);
        int i = (int) (context.getResources().getDisplayMetrics().density * 48.0f);
        setLayoutParams(new ViewGroup.LayoutParams(i, i));
    }

    public void injectCompassAnimationListener(MapboxMap.OnCompassAnimationListener onCompassAnimationListener) {
        this.compassAnimationListener = onCompassAnimationListener;
    }

    public void isAnimating(boolean z) {
        this.isAnimating = z;
    }

    public void resetAnimation() {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.fadeAnimator;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
        }
        this.fadeAnimator = null;
    }

    public boolean isHidden() {
        return this.fadeCompassViewFacingNorth && isFacingNorth();
    }

    public boolean isFacingNorth() {
        return ((double) Math.abs(this.rotation)) >= 359.0d || ((double) Math.abs(this.rotation)) <= 1.0d;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z && !isHidden()) {
            resetAnimation();
            setAlpha(1.0f);
            setVisibility(0);
            update(this.rotation);
            return;
        }
        resetAnimation();
        setAlpha(0.0f);
        setVisibility(4);
    }

    public void update(double d) {
        this.rotation = (float) d;
        if (isEnabled()) {
            if (isHidden()) {
                if (getVisibility() == 4 || this.fadeAnimator != null) {
                    return;
                }
                postDelayed(this, 500L);
                return;
            }
            resetAnimation();
            setAlpha(1.0f);
            setVisibility(0);
            notifyCompassAnimationListenerWhenAnimating();
            setRotation(this.rotation);
        }
    }

    public void fadeCompassViewFacingNorth(boolean z) {
        this.fadeCompassViewFacingNorth = z;
    }

    public boolean isFadeCompassViewFacingNorth() {
        return this.fadeCompassViewFacingNorth;
    }

    public void setCompassImage(Drawable drawable) {
        this.legacyImageDrawableSetter = true;
        setImageDrawable(drawable);
    }

    public Drawable getCompassImage() {
        return getDrawable();
    }

    @Override // java.lang.Runnable
    public void run() {
        if (isHidden()) {
            this.compassAnimationListener.onCompassAnimationFinished();
            resetAnimation();
            setLayerType(2, null);
            ViewPropertyAnimatorCompat duration = ViewCompat.animate(this).alpha(0.0f).setDuration(500L);
            this.fadeAnimator = duration;
            duration.setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: com.mapbox.mapboxsdk.maps.widgets.CompassView.1
                @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                public void onAnimationEnd(View view) {
                    CompassView.this.setLayerType(0, null);
                    CompassView.this.setVisibility(4);
                    CompassView.this.resetAnimation();
                }
            });
        }
    }

    private void notifyCompassAnimationListenerWhenAnimating() {
        if (this.isAnimating) {
            this.compassAnimationListener.onCompassAnimation();
        }
    }

    public int getCompassImageResource() {
        return this.compassImageResource;
    }

    public void setCompassImageResource(int i) {
        this.compassImageResource = i;
        setImageResource(i);
    }

    public boolean isLegacyImageDrawableSetter() {
        return this.legacyImageDrawableSetter;
    }
}
