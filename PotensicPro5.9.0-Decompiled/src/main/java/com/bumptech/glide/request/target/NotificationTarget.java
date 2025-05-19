package com.bumptech.glide.request.target;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.mapbox.api.directions.v5.models.StepManeuver;
import java.util.Objects;

/* loaded from: classes.dex */
public class NotificationTarget extends SimpleTarget<Bitmap> {
    private final Context context;
    private final Notification notification;
    private final int notificationId;
    private final RemoteViews remoteViews;
    private final int viewId;

    @Override // com.bumptech.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(Object obj, GlideAnimation glideAnimation) {
        onResourceReady((Bitmap) obj, (GlideAnimation<? super Bitmap>) glideAnimation);
    }

    public NotificationTarget(Context context, RemoteViews remoteViews, int i, Notification notification, int i2) {
        this(context, remoteViews, i, Integer.MIN_VALUE, Integer.MIN_VALUE, notification, i2);
    }

    public NotificationTarget(Context context, RemoteViews remoteViews, int i, int i2, int i3, Notification notification, int i4) {
        super(i2, i3);
        Objects.requireNonNull(context, "Context must not be null!");
        Objects.requireNonNull(notification, "Notification object can not be null!");
        Objects.requireNonNull(remoteViews, "RemoteViews object can not be null!");
        this.context = context;
        this.viewId = i;
        this.notification = notification;
        this.notificationId = i4;
        this.remoteViews = remoteViews;
    }

    private void update() {
        ((NotificationManager) this.context.getSystemService(StepManeuver.NOTIFICATION)).notify(this.notificationId, this.notification);
    }

    public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
        this.remoteViews.setImageViewBitmap(this.viewId, bitmap);
        update();
    }
}
