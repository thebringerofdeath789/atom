package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;

/* loaded from: classes2.dex */
public final class AlignmentPattern extends ResultPoint {
    private final float estimatedModuleSize;

    AlignmentPattern(float f, float f2, float f3) {
        super(f, f2);
        this.estimatedModuleSize = f3;
    }

    boolean aboutEquals(float f, float f2, float f3) {
        if (Math.abs(f2 - getY()) > f || Math.abs(f3 - getX()) > f) {
            return false;
        }
        float abs = Math.abs(f - this.estimatedModuleSize);
        return abs <= 1.0f || abs <= this.estimatedModuleSize;
    }

    AlignmentPattern combineEstimate(float f, float f2, float f3) {
        return new AlignmentPattern((getX() + f2) / 2.0f, (getY() + f) / 2.0f, (this.estimatedModuleSize + f3) / 2.0f);
    }
}