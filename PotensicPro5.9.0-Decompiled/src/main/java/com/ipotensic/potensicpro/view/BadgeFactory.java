package com.ipotensic.potensicpro.view;

import android.content.Context;

/* loaded from: classes2.dex */
public class BadgeFactory {
    public static BadgeView createDot(Context context) {
        return new BadgeView(context).setWidthAndHeight(10, 10).setTextSize(0).setBadgeGravity(53).setShape(1);
    }

    public static BadgeView createCircle(Context context) {
        return new BadgeView(context).setWidthAndHeight(20, 20).setTextSize(12).setBadgeGravity(53).setShape(1);
    }

    public static BadgeView createRectangle(Context context) {
        return new BadgeView(context).setWidthAndHeight(25, 20).setTextSize(12).setBadgeGravity(53).setShape(2);
    }

    public static BadgeView createOval(Context context) {
        return new BadgeView(context).setWidthAndHeight(25, 20).setTextSize(12).setBadgeGravity(53).setShape(3);
    }

    public static BadgeView createSquare(Context context) {
        return new BadgeView(context).setWidthAndHeight(20, 20).setTextSize(12).setBadgeGravity(53).setShape(5);
    }

    public static BadgeView createRoundRect(Context context) {
        return new BadgeView(context).setWidthAndHeight(25, 20).setTextSize(12).setBadgeGravity(53).setShape(4);
    }

    public static BadgeView create(Context context) {
        return new BadgeView(context);
    }
}
