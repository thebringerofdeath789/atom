package com.mapbox.mapboxsdk.style.layers;

/* loaded from: classes3.dex */
public class TransitionOptions {
    private long delay;
    private long duration;
    private boolean enablePlacementTransitions;

    public TransitionOptions(long j, long j2) {
        this(j, j2, true);
    }

    public TransitionOptions(long j, long j2, boolean z) {
        this.duration = j;
        this.delay = j2;
        this.enablePlacementTransitions = z;
    }

    @Deprecated
    public static TransitionOptions fromTransitionOptions(long j, long j2) {
        return new TransitionOptions(j, j2);
    }

    static TransitionOptions fromTransitionOptions(long j, long j2, boolean z) {
        return new TransitionOptions(j, j2, z);
    }

    public long getDuration() {
        return this.duration;
    }

    public long getDelay() {
        return this.delay;
    }

    public boolean isEnablePlacementTransitions() {
        return this.enablePlacementTransitions;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TransitionOptions transitionOptions = (TransitionOptions) obj;
        return this.duration == transitionOptions.duration && this.delay == transitionOptions.delay && this.enablePlacementTransitions == transitionOptions.enablePlacementTransitions;
    }

    public int hashCode() {
        long j = this.duration;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        long j2 = this.delay;
        return ((i + ((int) ((j2 >>> 32) ^ j2))) * 31) + (this.enablePlacementTransitions ? 1 : 0);
    }

    public String toString() {
        return "TransitionOptions{duration=" + this.duration + ", delay=" + this.delay + ", enablePlacementTransitions=" + this.enablePlacementTransitions + '}';
    }
}