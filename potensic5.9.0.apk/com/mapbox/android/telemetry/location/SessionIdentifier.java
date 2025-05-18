package com.mapbox.android.telemetry.location;

import com.mapbox.android.telemetry.TelemetryUtils;

/* loaded from: classes3.dex */
public class SessionIdentifier {
    private static final int DEFAULT_ROTATION_HOURS = 24;
    private static final long HOURS_TO_MILLISECONDS = 3600000;
    private long lastSessionIdUpdate;
    private final long rotationInterval;
    private String sessionId;

    public SessionIdentifier() {
        this(86400000L);
    }

    public SessionIdentifier(long j) {
        this.sessionId = null;
        this.rotationInterval = j;
    }

    @Deprecated
    public SessionIdentifier(int i) {
        this.sessionId = null;
        this.rotationInterval = i * 3600000;
    }

    public long getInterval() {
        return this.rotationInterval;
    }

    String getSessionId() {
        if (System.currentTimeMillis() - this.lastSessionIdUpdate >= this.rotationInterval || this.sessionId == null) {
            this.sessionId = TelemetryUtils.obtainUniversalUniqueIdentifier();
            this.lastSessionIdUpdate = System.currentTimeMillis();
        }
        return this.sessionId;
    }
}