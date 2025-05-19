package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;

/* loaded from: classes.dex */
public abstract class Rating implements Bundleable {
    public static final Bundleable.Creator<Rating> CREATOR = new Bundleable.Creator() { // from class: com.google.android.exoplayer2.-$$Lambda$Rating$S87uZHR0r4DpwOSwqteylD8fJ5w
        @Override // com.google.android.exoplayer2.Bundleable.Creator
        public final Bundleable fromBundle(Bundle bundle) {
            Rating fromBundle;
            fromBundle = Rating.fromBundle(bundle);
            return fromBundle;
        }
    };
    static final int FIELD_RATING_TYPE = 0;
    static final int RATING_TYPE_DEFAULT = -1;
    static final int RATING_TYPE_HEART = 0;
    static final int RATING_TYPE_PERCENTAGE = 1;
    static final int RATING_TYPE_STAR = 2;
    static final int RATING_TYPE_THUMB = 3;
    public static final float RATING_UNSET = -1.0f;

    public abstract boolean isRated();

    Rating() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Rating fromBundle(Bundle bundle) {
        int i = bundle.getInt(keyForField(0), -1);
        if (i == 0) {
            return HeartRating.CREATOR.fromBundle(bundle);
        }
        if (i == 1) {
            return PercentageRating.CREATOR.fromBundle(bundle);
        }
        if (i == 2) {
            return StarRating.CREATOR.fromBundle(bundle);
        }
        if (i == 3) {
            return ThumbRating.CREATOR.fromBundle(bundle);
        }
        throw new IllegalArgumentException(new StringBuilder(44).append("Encountered unknown rating type: ").append(i).toString());
    }

    private static String keyForField(int i) {
        return Integer.toString(i, 36);
    }
}
