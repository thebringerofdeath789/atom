package com.squareup.picasso;

import android.app.Notification;
import android.app.NotificationManager;
import android.appwidget.AppWidgetManager;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.mapbox.api.directions.v5.models.StepManeuver;
import com.squareup.picasso.Picasso;

/* loaded from: classes3.dex */
abstract class RemoteViewsAction extends Action<RemoteViewsTarget> {
    final RemoteViews remoteViews;
    private RemoteViewsTarget target;
    final int viewId;

    abstract void update();

    RemoteViewsAction(Picasso picasso, Request request, RemoteViews remoteViews, int i, int i2, int i3, int i4, Object obj, String str) {
        super(picasso, null, request, i3, i4, i2, null, str, obj, false);
        this.remoteViews = remoteViews;
        this.viewId = i;
    }

    @Override // com.squareup.picasso.Action
    void complete(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
        this.remoteViews.setImageViewBitmap(this.viewId, bitmap);
        update();
    }

    @Override // com.squareup.picasso.Action
    public void error() {
        if (this.errorResId != 0) {
            setImageResource(this.errorResId);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.picasso.Action
    public RemoteViewsTarget getTarget() {
        if (this.target == null) {
            this.target = new RemoteViewsTarget(this.remoteViews, this.viewId);
        }
        return this.target;
    }

    void setImageResource(int i) {
        this.remoteViews.setImageViewResource(this.viewId, i);
        update();
    }

    static class RemoteViewsTarget {
        final RemoteViews remoteViews;
        final int viewId;

        RemoteViewsTarget(RemoteViews remoteViews, int i) {
            this.remoteViews = remoteViews;
            this.viewId = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            RemoteViewsTarget remoteViewsTarget = (RemoteViewsTarget) obj;
            return this.viewId == remoteViewsTarget.viewId && this.remoteViews.equals(remoteViewsTarget.remoteViews);
        }

        public int hashCode() {
            return (this.remoteViews.hashCode() * 31) + this.viewId;
        }
    }

    static class AppWidgetAction extends RemoteViewsAction {
        private final int[] appWidgetIds;

        @Override // com.squareup.picasso.RemoteViewsAction, com.squareup.picasso.Action
        /* bridge */ /* synthetic */ RemoteViewsTarget getTarget() {
            return super.getTarget();
        }

        AppWidgetAction(Picasso picasso, Request request, RemoteViews remoteViews, int i, int[] iArr, int i2, int i3, String str, Object obj, int i4) {
            super(picasso, request, remoteViews, i, i4, i2, i3, obj, str);
            this.appWidgetIds = iArr;
        }

        @Override // com.squareup.picasso.RemoteViewsAction
        void update() {
            AppWidgetManager.getInstance(this.picasso.context).updateAppWidget(this.appWidgetIds, this.remoteViews);
        }
    }

    static class NotificationAction extends RemoteViewsAction {
        private final Notification notification;
        private final int notificationId;

        @Override // com.squareup.picasso.RemoteViewsAction, com.squareup.picasso.Action
        /* bridge */ /* synthetic */ RemoteViewsTarget getTarget() {
            return super.getTarget();
        }

        NotificationAction(Picasso picasso, Request request, RemoteViews remoteViews, int i, int i2, Notification notification, int i3, int i4, String str, Object obj, int i5) {
            super(picasso, request, remoteViews, i, i5, i3, i4, obj, str);
            this.notificationId = i2;
            this.notification = notification;
        }

        @Override // com.squareup.picasso.RemoteViewsAction
        void update() {
            ((NotificationManager) Utils.getService(this.picasso.context, StepManeuver.NOTIFICATION)).notify(this.notificationId, this.notification);
        }
    }
}
