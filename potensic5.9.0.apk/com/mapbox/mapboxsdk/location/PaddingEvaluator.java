package com.mapbox.mapboxsdk.location;

import android.animation.TypeEvaluator;

/* loaded from: classes3.dex */
class PaddingEvaluator implements TypeEvaluator<double[]> {
    private final double[] padding = new double[4];

    PaddingEvaluator() {
    }

    @Override // android.animation.TypeEvaluator
    public double[] evaluate(float f, double[] dArr, double[] dArr2) {
        double[] dArr3 = this.padding;
        double d = f;
        dArr3[0] = dArr[0] + ((dArr2[0] - dArr[0]) * d);
        dArr3[1] = dArr[1] + ((dArr2[1] - dArr[1]) * d);
        dArr3[2] = dArr[2] + ((dArr2[2] - dArr[2]) * d);
        dArr3[3] = dArr[3] + ((dArr2[3] - dArr[3]) * d);
        return dArr3;
    }
}