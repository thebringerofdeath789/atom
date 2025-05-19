package com.mapbox.android.gestures;

import android.util.Pair;

/* loaded from: classes3.dex */
public class PointerDistancePair extends Pair<Integer, Integer> {
    public PointerDistancePair(Integer num, Integer num2) {
        super(num, num2);
    }

    @Override // android.util.Pair
    public boolean equals(Object obj) {
        if (!(obj instanceof PointerDistancePair)) {
            return false;
        }
        PointerDistancePair pointerDistancePair = (PointerDistancePair) obj;
        if (((Integer) this.first).equals(pointerDistancePair.first) && ((Integer) this.second).equals(pointerDistancePair.second)) {
            return true;
        }
        return ((Integer) this.first).equals(pointerDistancePair.second) && ((Integer) this.second).equals(pointerDistancePair.first);
    }
}
