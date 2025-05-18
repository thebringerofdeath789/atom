package com.mapbox.android.gestures;

/* loaded from: classes3.dex */
class PermittedActionsGuard {
    private static final int BITS_PER_PERMITTED_ACTION = 8;
    private static final int NO_ACTION_PERMITTED = 255;
    private static final int PERMITTED_ACTION_MASK = 255;

    PermittedActionsGuard() {
    }

    boolean isMissingActions(int i, int i2, int i3) {
        long updatePermittedActions = updatePermittedActions(i2, i3);
        long j = i;
        if (j == updatePermittedActions) {
            return false;
        }
        while (updatePermittedActions != 0) {
            if (j == (255 & updatePermittedActions)) {
                return false;
            }
            updatePermittedActions >>= 8;
        }
        return true;
    }

    private long updatePermittedActions(int i, int i2) {
        if (i2 == 0) {
            return 0L;
        }
        if (Math.abs(i - i2) > 1) {
            return 255L;
        }
        if (i > i2) {
            return 5L;
        }
        if (i < i2) {
            return 255L;
        }
        return ((i == 1 ? 1L : 6L) << 8) + 2;
    }
}