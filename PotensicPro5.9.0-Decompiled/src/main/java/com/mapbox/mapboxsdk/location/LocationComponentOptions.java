package com.mapbox.mapboxsdk.location;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.animation.Interpolator;
import com.mapbox.mapboxsdk.R;
import com.tencent.bugly.BuglyStrategy;
import java.util.Arrays;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
public class LocationComponentOptions implements Parcelable {
    private static final float ACCURACY_ALPHA_DEFAULT = 0.15f;
    private static final float CIRCLE_PULSING_ALPHA_DEFAULT = 1.0f;
    private static final long CIRCLE_PULSING_DURATION_DEFAULT_MS = 2300;
    public static final float CIRCLE_PULSING_MAX_RADIUS_DEFAULT = 35.0f;
    private static final float MAX_ZOOM_ICON_SCALE_DEFAULT = 1.0f;
    private static final float MIN_ZOOM_ICON_SCALE_DEFAULT = 0.6f;
    private static final long STALE_STATE_DELAY_MS = 30000;
    private static final float TRACKING_ANIMATION_DURATION_MULTIPLIER_DEFAULT = 1.1f;
    private float accuracyAlpha;
    private boolean accuracyAnimationEnabled;
    private int accuracyColor;
    private int backgroundDrawable;
    private int backgroundDrawableStale;
    private String backgroundName;
    private String backgroundStaleName;
    private Integer backgroundStaleTintColor;
    private Integer backgroundTintColor;
    private int bearingDrawable;
    private String bearingName;
    private Integer bearingTintColor;
    private boolean compassAnimationEnabled;
    private float elevation;
    private boolean enableStaleState;
    private int foregroundDrawable;
    private int foregroundDrawableStale;
    private String foregroundName;
    private String foregroundStaleName;
    private Integer foregroundStaleTintColor;
    private Integer foregroundTintColor;
    private int gpsDrawable;
    private String gpsName;
    private String layerAbove;
    private String layerBelow;
    private float maxZoomIconScale;
    private float minZoomIconScale;
    private int[] padding;
    private float pulseAlpha;
    private Integer pulseColor;
    private Boolean pulseEnabled;
    private Boolean pulseFadeEnabled;
    private Interpolator pulseInterpolator;
    private float pulseMaxRadius;
    private float pulseSingleDuration;
    private long staleStateTimeout;
    private float trackingAnimationDurationMultiplier;
    private boolean trackingGesturesManagement;
    private float trackingInitialMoveThreshold;
    private float trackingMultiFingerMoveThreshold;
    private RectF trackingMultiFingerProtectedMoveArea;
    private static final int[] PADDING_DEFAULT = {0, 0, 0, 0};
    public static final Parcelable.Creator<LocationComponentOptions> CREATOR = new Parcelable.Creator<LocationComponentOptions>() { // from class: com.mapbox.mapboxsdk.location.LocationComponentOptions.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocationComponentOptions createFromParcel(Parcel parcel) {
            return new LocationComponentOptions(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocationComponentOptions[] newArray(int i) {
            return new LocationComponentOptions[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LocationComponentOptions(float f, int i, int i2, String str, int i3, String str2, int i4, String str3, int i5, String str4, int i6, String str5, int i7, String str6, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, float f2, boolean z, long j, int[] iArr, float f3, float f4, boolean z2, float f5, float f6, RectF rectF, String str7, String str8, float f7, boolean z3, boolean z4, Boolean bool, Boolean bool2, Integer num6, float f8, float f9, float f10, Interpolator interpolator) {
        this.accuracyAlpha = f;
        this.accuracyColor = i;
        this.backgroundDrawableStale = i2;
        this.backgroundStaleName = str;
        this.foregroundDrawableStale = i3;
        this.foregroundStaleName = str2;
        this.gpsDrawable = i4;
        this.gpsName = str3;
        this.foregroundDrawable = i5;
        this.foregroundName = str4;
        this.backgroundDrawable = i6;
        this.backgroundName = str5;
        this.bearingDrawable = i7;
        this.bearingName = str6;
        this.bearingTintColor = num;
        this.foregroundTintColor = num2;
        this.backgroundTintColor = num3;
        this.foregroundStaleTintColor = num4;
        this.backgroundStaleTintColor = num5;
        this.elevation = f2;
        this.enableStaleState = z;
        this.staleStateTimeout = j;
        Objects.requireNonNull(iArr, "Null padding");
        this.padding = iArr;
        this.maxZoomIconScale = f3;
        this.minZoomIconScale = f4;
        this.trackingGesturesManagement = z2;
        this.trackingInitialMoveThreshold = f5;
        this.trackingMultiFingerMoveThreshold = f6;
        this.trackingMultiFingerProtectedMoveArea = rectF;
        this.layerAbove = str7;
        this.layerBelow = str8;
        this.trackingAnimationDurationMultiplier = f7;
        this.compassAnimationEnabled = z3;
        this.accuracyAnimationEnabled = z4;
        this.pulseEnabled = bool;
        this.pulseFadeEnabled = bool2;
        this.pulseColor = num6;
        this.pulseSingleDuration = f8;
        this.pulseMaxRadius = f9;
        this.pulseAlpha = f10;
        this.pulseInterpolator = interpolator;
    }

    public static LocationComponentOptions createFromAttributes(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.mapbox_LocationComponent);
        Builder padding = new Builder().enableStaleState(true).staleStateTimeout(30000L).maxZoomIconScale(1.0f).minZoomIconScale(MIN_ZOOM_ICON_SCALE_DEFAULT).padding(PADDING_DEFAULT);
        padding.foregroundDrawable(obtainStyledAttributes.getResourceId(R.styleable.mapbox_LocationComponent_mapbox_foregroundDrawable, -1));
        if (obtainStyledAttributes.hasValue(R.styleable.mapbox_LocationComponent_mapbox_foregroundTintColor)) {
            padding.foregroundTintColor(Integer.valueOf(obtainStyledAttributes.getColor(R.styleable.mapbox_LocationComponent_mapbox_foregroundTintColor, -1)));
        }
        padding.backgroundDrawable(obtainStyledAttributes.getResourceId(R.styleable.mapbox_LocationComponent_mapbox_backgroundDrawable, -1));
        if (obtainStyledAttributes.hasValue(R.styleable.mapbox_LocationComponent_mapbox_backgroundTintColor)) {
            padding.backgroundTintColor(Integer.valueOf(obtainStyledAttributes.getColor(R.styleable.mapbox_LocationComponent_mapbox_backgroundTintColor, -1)));
        }
        padding.foregroundDrawableStale(obtainStyledAttributes.getResourceId(R.styleable.mapbox_LocationComponent_mapbox_foregroundDrawableStale, -1));
        if (obtainStyledAttributes.hasValue(R.styleable.mapbox_LocationComponent_mapbox_foregroundStaleTintColor)) {
            padding.foregroundStaleTintColor(Integer.valueOf(obtainStyledAttributes.getColor(R.styleable.mapbox_LocationComponent_mapbox_foregroundStaleTintColor, -1)));
        }
        padding.backgroundDrawableStale(obtainStyledAttributes.getResourceId(R.styleable.mapbox_LocationComponent_mapbox_backgroundDrawableStale, -1));
        if (obtainStyledAttributes.hasValue(R.styleable.mapbox_LocationComponent_mapbox_backgroundStaleTintColor)) {
            padding.backgroundStaleTintColor(Integer.valueOf(obtainStyledAttributes.getColor(R.styleable.mapbox_LocationComponent_mapbox_backgroundStaleTintColor, -1)));
        }
        padding.bearingDrawable(obtainStyledAttributes.getResourceId(R.styleable.mapbox_LocationComponent_mapbox_bearingDrawable, -1));
        if (obtainStyledAttributes.hasValue(R.styleable.mapbox_LocationComponent_mapbox_bearingTintColor)) {
            padding.bearingTintColor(Integer.valueOf(obtainStyledAttributes.getColor(R.styleable.mapbox_LocationComponent_mapbox_bearingTintColor, -1)));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.mapbox_LocationComponent_mapbox_enableStaleState)) {
            padding.enableStaleState(obtainStyledAttributes.getBoolean(R.styleable.mapbox_LocationComponent_mapbox_enableStaleState, true));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.mapbox_LocationComponent_mapbox_staleStateTimeout)) {
            padding.staleStateTimeout(obtainStyledAttributes.getInteger(R.styleable.mapbox_LocationComponent_mapbox_staleStateTimeout, BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH));
        }
        padding.gpsDrawable(obtainStyledAttributes.getResourceId(R.styleable.mapbox_LocationComponent_mapbox_gpsDrawable, -1));
        float dimension = obtainStyledAttributes.getDimension(R.styleable.mapbox_LocationComponent_mapbox_elevation, 0.0f);
        padding.accuracyColor(obtainStyledAttributes.getColor(R.styleable.mapbox_LocationComponent_mapbox_accuracyColor, -1));
        padding.accuracyAlpha(obtainStyledAttributes.getFloat(R.styleable.mapbox_LocationComponent_mapbox_accuracyAlpha, 0.15f));
        padding.elevation(dimension);
        padding.trackingGesturesManagement(obtainStyledAttributes.getBoolean(R.styleable.mapbox_LocationComponent_mapbox_trackingGesturesManagement, false));
        padding.trackingInitialMoveThreshold(obtainStyledAttributes.getDimension(R.styleable.mapbox_LocationComponent_mapbox_trackingInitialMoveThreshold, context.getResources().getDimension(R.dimen.mapbox_locationComponentTrackingInitialMoveThreshold)));
        padding.trackingMultiFingerMoveThreshold(obtainStyledAttributes.getDimension(R.styleable.mapbox_LocationComponent_mapbox_trackingMultiFingerMoveThreshold, context.getResources().getDimension(R.dimen.mapbox_locationComponentTrackingMultiFingerMoveThreshold)));
        padding.padding(new int[]{obtainStyledAttributes.getInt(R.styleable.mapbox_LocationComponent_mapbox_iconPaddingLeft, 0), obtainStyledAttributes.getInt(R.styleable.mapbox_LocationComponent_mapbox_iconPaddingTop, 0), obtainStyledAttributes.getInt(R.styleable.mapbox_LocationComponent_mapbox_iconPaddingRight, 0), obtainStyledAttributes.getInt(R.styleable.mapbox_LocationComponent_mapbox_iconPaddingBottom, 0)});
        padding.layerAbove(obtainStyledAttributes.getString(R.styleable.mapbox_LocationComponent_mapbox_layer_above));
        padding.layerBelow(obtainStyledAttributes.getString(R.styleable.mapbox_LocationComponent_mapbox_layer_below));
        float f = obtainStyledAttributes.getFloat(R.styleable.mapbox_LocationComponent_mapbox_minZoomIconScale, MIN_ZOOM_ICON_SCALE_DEFAULT);
        float f2 = obtainStyledAttributes.getFloat(R.styleable.mapbox_LocationComponent_mapbox_maxZoomIconScale, 1.0f);
        padding.minZoomIconScale(f);
        padding.maxZoomIconScale(f2);
        padding.trackingAnimationDurationMultiplier(obtainStyledAttributes.getFloat(R.styleable.mapbox_LocationComponent_mapbox_trackingAnimationDurationMultiplier, TRACKING_ANIMATION_DURATION_MULTIPLIER_DEFAULT));
        padding.compassAnimationEnabled = Boolean.valueOf(obtainStyledAttributes.getBoolean(R.styleable.mapbox_LocationComponent_mapbox_compassAnimationEnabled, true));
        padding.accuracyAnimationEnabled = Boolean.valueOf(obtainStyledAttributes.getBoolean(R.styleable.mapbox_LocationComponent_mapbox_accuracyAnimationEnabled, true));
        padding.pulseEnabled = Boolean.valueOf(obtainStyledAttributes.getBoolean(R.styleable.mapbox_LocationComponent_mapbox_pulsingLocationCircleEnabled, false));
        padding.pulseFadeEnabled = Boolean.valueOf(obtainStyledAttributes.getBoolean(R.styleable.mapbox_LocationComponent_mapbox_pulsingLocationCircleFadeEnabled, true));
        if (obtainStyledAttributes.hasValue(R.styleable.mapbox_LocationComponent_mapbox_pulsingLocationCircleColor)) {
            padding.pulseColor(obtainStyledAttributes.getColor(R.styleable.mapbox_LocationComponent_mapbox_pulsingLocationCircleColor, -1));
        }
        padding.pulseSingleDuration = obtainStyledAttributes.getFloat(R.styleable.mapbox_LocationComponent_mapbox_pulsingLocationCircleDuration, 2300.0f);
        padding.pulseMaxRadius = obtainStyledAttributes.getFloat(R.styleable.mapbox_LocationComponent_mapbox_pulsingLocationCircleRadius, 35.0f);
        padding.pulseAlpha = obtainStyledAttributes.getFloat(R.styleable.mapbox_LocationComponent_mapbox_pulsingLocationCircleAlpha, 1.0f);
        obtainStyledAttributes.recycle();
        return padding.build();
    }

    public Builder toBuilder() {
        return new Builder();
    }

    public static Builder builder(Context context) {
        return createFromAttributes(context, R.style.mapbox_LocationComponent).toBuilder();
    }

    public float accuracyAlpha() {
        return this.accuracyAlpha;
    }

    public int accuracyColor() {
        return this.accuracyColor;
    }

    public int backgroundDrawableStale() {
        return this.backgroundDrawableStale;
    }

    public String backgroundStaleName() {
        return this.backgroundStaleName;
    }

    public int foregroundDrawableStale() {
        return this.foregroundDrawableStale;
    }

    public String foregroundStaleName() {
        return this.foregroundStaleName;
    }

    public int gpsDrawable() {
        return this.gpsDrawable;
    }

    public String gpsName() {
        return this.gpsName;
    }

    public int foregroundDrawable() {
        return this.foregroundDrawable;
    }

    public String foregroundName() {
        return this.foregroundName;
    }

    public int backgroundDrawable() {
        return this.backgroundDrawable;
    }

    public String backgroundName() {
        return this.backgroundName;
    }

    public int bearingDrawable() {
        return this.bearingDrawable;
    }

    public String bearingName() {
        return this.bearingName;
    }

    public Integer bearingTintColor() {
        return this.bearingTintColor;
    }

    public Integer foregroundTintColor() {
        return this.foregroundTintColor;
    }

    public Integer backgroundTintColor() {
        return this.backgroundTintColor;
    }

    public Integer foregroundStaleTintColor() {
        return this.foregroundStaleTintColor;
    }

    public Integer backgroundStaleTintColor() {
        return this.backgroundStaleTintColor;
    }

    public float elevation() {
        return this.elevation;
    }

    public boolean enableStaleState() {
        return this.enableStaleState;
    }

    public long staleStateTimeout() {
        return this.staleStateTimeout;
    }

    public int[] padding() {
        return this.padding;
    }

    public float maxZoomIconScale() {
        return this.maxZoomIconScale;
    }

    public float minZoomIconScale() {
        return this.minZoomIconScale;
    }

    public boolean trackingGesturesManagement() {
        return this.trackingGesturesManagement;
    }

    public float trackingInitialMoveThreshold() {
        return this.trackingInitialMoveThreshold;
    }

    public float trackingMultiFingerMoveThreshold() {
        return this.trackingMultiFingerMoveThreshold;
    }

    public RectF trackingMultiFingerProtectedMoveArea() {
        return this.trackingMultiFingerProtectedMoveArea;
    }

    public String layerAbove() {
        return this.layerAbove;
    }

    public String layerBelow() {
        return this.layerBelow;
    }

    public float trackingAnimationDurationMultiplier() {
        return this.trackingAnimationDurationMultiplier;
    }

    public boolean compassAnimationEnabled() {
        return this.compassAnimationEnabled;
    }

    public boolean accuracyAnimationEnabled() {
        return this.accuracyAnimationEnabled;
    }

    public Boolean pulseEnabled() {
        return this.pulseEnabled;
    }

    public Boolean pulseFadeEnabled() {
        return this.pulseFadeEnabled;
    }

    public Integer pulseColor() {
        return this.pulseColor;
    }

    public float pulseSingleDuration() {
        return this.pulseSingleDuration;
    }

    public float pulseMaxRadius() {
        return this.pulseMaxRadius;
    }

    public float pulseAlpha() {
        return this.pulseAlpha;
    }

    public Interpolator pulseInterpolator() {
        return this.pulseInterpolator;
    }

    public String toString() {
        return "LocationComponentOptions{accuracyAlpha=" + this.accuracyAlpha + ", accuracyColor=" + this.accuracyColor + ", backgroundDrawableStale=" + this.backgroundDrawableStale + ", backgroundStaleName=" + this.backgroundStaleName + ", foregroundDrawableStale=" + this.foregroundDrawableStale + ", foregroundStaleName=" + this.foregroundStaleName + ", gpsDrawable=" + this.gpsDrawable + ", gpsName=" + this.gpsName + ", foregroundDrawable=" + this.foregroundDrawable + ", foregroundName=" + this.foregroundName + ", backgroundDrawable=" + this.backgroundDrawable + ", backgroundName=" + this.backgroundName + ", bearingDrawable=" + this.bearingDrawable + ", bearingName=" + this.bearingName + ", bearingTintColor=" + this.bearingTintColor + ", foregroundTintColor=" + this.foregroundTintColor + ", backgroundTintColor=" + this.backgroundTintColor + ", foregroundStaleTintColor=" + this.foregroundStaleTintColor + ", backgroundStaleTintColor=" + this.backgroundStaleTintColor + ", elevation=" + this.elevation + ", enableStaleState=" + this.enableStaleState + ", staleStateTimeout=" + this.staleStateTimeout + ", padding=" + Arrays.toString(this.padding) + ", maxZoomIconScale=" + this.maxZoomIconScale + ", minZoomIconScale=" + this.minZoomIconScale + ", trackingGesturesManagement=" + this.trackingGesturesManagement + ", trackingInitialMoveThreshold=" + this.trackingInitialMoveThreshold + ", trackingMultiFingerMoveThreshold=" + this.trackingMultiFingerMoveThreshold + ", trackingMultiFingerProtectedMoveArea=" + this.trackingMultiFingerProtectedMoveArea + ", layerAbove=" + this.layerAbove + "layerBelow=" + this.layerBelow + "trackingAnimationDurationMultiplier=" + this.trackingAnimationDurationMultiplier + "pulseEnabled=" + this.pulseEnabled + "pulseFadeEnabled=" + this.pulseFadeEnabled + "pulseColor=" + this.pulseColor + "pulseSingleDuration=" + this.pulseSingleDuration + "pulseMaxRadius=" + this.pulseMaxRadius + "pulseAlpha=" + this.pulseAlpha + StringSubstitutor.DEFAULT_VAR_END;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LocationComponentOptions locationComponentOptions = (LocationComponentOptions) obj;
        if (Float.compare(locationComponentOptions.accuracyAlpha, this.accuracyAlpha) != 0 || this.accuracyColor != locationComponentOptions.accuracyColor || this.backgroundDrawableStale != locationComponentOptions.backgroundDrawableStale || this.foregroundDrawableStale != locationComponentOptions.foregroundDrawableStale || this.gpsDrawable != locationComponentOptions.gpsDrawable || this.foregroundDrawable != locationComponentOptions.foregroundDrawable || this.backgroundDrawable != locationComponentOptions.backgroundDrawable || this.bearingDrawable != locationComponentOptions.bearingDrawable || Float.compare(locationComponentOptions.elevation, this.elevation) != 0 || this.enableStaleState != locationComponentOptions.enableStaleState || this.staleStateTimeout != locationComponentOptions.staleStateTimeout || Float.compare(locationComponentOptions.maxZoomIconScale, this.maxZoomIconScale) != 0 || Float.compare(locationComponentOptions.minZoomIconScale, this.minZoomIconScale) != 0 || this.trackingGesturesManagement != locationComponentOptions.trackingGesturesManagement || Float.compare(locationComponentOptions.trackingInitialMoveThreshold, this.trackingInitialMoveThreshold) != 0 || Float.compare(locationComponentOptions.trackingMultiFingerMoveThreshold, this.trackingMultiFingerMoveThreshold) != 0 || Float.compare(locationComponentOptions.trackingAnimationDurationMultiplier, this.trackingAnimationDurationMultiplier) != 0) {
            return false;
        }
        RectF rectF = this.trackingMultiFingerProtectedMoveArea;
        if (rectF == null ? locationComponentOptions.trackingMultiFingerProtectedMoveArea != null : !rectF.equals(locationComponentOptions.trackingMultiFingerProtectedMoveArea)) {
            return false;
        }
        if (this.compassAnimationEnabled != locationComponentOptions.compassAnimationEnabled || this.accuracyAnimationEnabled != locationComponentOptions.accuracyAnimationEnabled) {
            return false;
        }
        String str = this.backgroundStaleName;
        if (str == null ? locationComponentOptions.backgroundStaleName != null : !str.equals(locationComponentOptions.backgroundStaleName)) {
            return false;
        }
        String str2 = this.foregroundStaleName;
        if (str2 == null ? locationComponentOptions.foregroundStaleName != null : !str2.equals(locationComponentOptions.foregroundStaleName)) {
            return false;
        }
        String str3 = this.gpsName;
        if (str3 == null ? locationComponentOptions.gpsName != null : !str3.equals(locationComponentOptions.gpsName)) {
            return false;
        }
        String str4 = this.foregroundName;
        if (str4 == null ? locationComponentOptions.foregroundName != null : !str4.equals(locationComponentOptions.foregroundName)) {
            return false;
        }
        String str5 = this.backgroundName;
        if (str5 == null ? locationComponentOptions.backgroundName != null : !str5.equals(locationComponentOptions.backgroundName)) {
            return false;
        }
        String str6 = this.bearingName;
        if (str6 == null ? locationComponentOptions.bearingName != null : !str6.equals(locationComponentOptions.bearingName)) {
            return false;
        }
        Integer num = this.bearingTintColor;
        if (num == null ? locationComponentOptions.bearingTintColor != null : !num.equals(locationComponentOptions.bearingTintColor)) {
            return false;
        }
        Integer num2 = this.foregroundTintColor;
        if (num2 == null ? locationComponentOptions.foregroundTintColor != null : !num2.equals(locationComponentOptions.foregroundTintColor)) {
            return false;
        }
        Integer num3 = this.backgroundTintColor;
        if (num3 == null ? locationComponentOptions.backgroundTintColor != null : !num3.equals(locationComponentOptions.backgroundTintColor)) {
            return false;
        }
        Integer num4 = this.foregroundStaleTintColor;
        if (num4 == null ? locationComponentOptions.foregroundStaleTintColor != null : !num4.equals(locationComponentOptions.foregroundStaleTintColor)) {
            return false;
        }
        Integer num5 = this.backgroundStaleTintColor;
        if (num5 == null ? locationComponentOptions.backgroundStaleTintColor != null : !num5.equals(locationComponentOptions.backgroundStaleTintColor)) {
            return false;
        }
        if (!Arrays.equals(this.padding, locationComponentOptions.padding)) {
            return false;
        }
        String str7 = this.layerAbove;
        if (str7 == null ? locationComponentOptions.layerAbove != null : !str7.equals(locationComponentOptions.layerAbove)) {
            return false;
        }
        if (this.pulseEnabled != locationComponentOptions.pulseEnabled || this.pulseFadeEnabled != locationComponentOptions.pulseFadeEnabled) {
            return false;
        }
        Integer num6 = this.pulseColor;
        if (num6 == null ? locationComponentOptions.pulseColor() != null : !num6.equals(locationComponentOptions.pulseColor)) {
            return false;
        }
        if (Float.compare(locationComponentOptions.pulseSingleDuration, this.pulseSingleDuration) != 0 || Float.compare(locationComponentOptions.pulseMaxRadius, this.pulseMaxRadius) != 0 || Float.compare(locationComponentOptions.pulseAlpha, this.pulseAlpha) != 0) {
            return false;
        }
        String str8 = this.layerBelow;
        String str9 = locationComponentOptions.layerBelow;
        return str8 != null ? str8.equals(str9) : str9 == null;
    }

    public int hashCode() {
        float f = this.accuracyAlpha;
        int floatToIntBits = (((((f != 0.0f ? Float.floatToIntBits(f) : 0) * 31) + this.accuracyColor) * 31) + this.backgroundDrawableStale) * 31;
        String str = this.backgroundStaleName;
        int hashCode = (((floatToIntBits + (str != null ? str.hashCode() : 0)) * 31) + this.foregroundDrawableStale) * 31;
        String str2 = this.foregroundStaleName;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.gpsDrawable) * 31;
        String str3 = this.gpsName;
        int hashCode3 = (((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.foregroundDrawable) * 31;
        String str4 = this.foregroundName;
        int hashCode4 = (((hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.backgroundDrawable) * 31;
        String str5 = this.backgroundName;
        int hashCode5 = (((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.bearingDrawable) * 31;
        String str6 = this.bearingName;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Integer num = this.bearingTintColor;
        int hashCode7 = (hashCode6 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.foregroundTintColor;
        int hashCode8 = (hashCode7 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.backgroundTintColor;
        int hashCode9 = (hashCode8 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.foregroundStaleTintColor;
        int hashCode10 = (hashCode9 + (num4 != null ? num4.hashCode() : 0)) * 31;
        Integer num5 = this.backgroundStaleTintColor;
        int hashCode11 = (hashCode10 + (num5 != null ? num5.hashCode() : 0)) * 31;
        float f2 = this.elevation;
        int floatToIntBits2 = (((hashCode11 + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31) + (this.enableStaleState ? 1 : 0)) * 31;
        long j = this.staleStateTimeout;
        int hashCode12 = (((floatToIntBits2 + ((int) (j ^ (j >>> 32)))) * 31) + Arrays.hashCode(this.padding)) * 31;
        float f3 = this.maxZoomIconScale;
        int floatToIntBits3 = (hashCode12 + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 31;
        float f4 = this.minZoomIconScale;
        int floatToIntBits4 = (((floatToIntBits3 + (f4 != 0.0f ? Float.floatToIntBits(f4) : 0)) * 31) + (this.trackingGesturesManagement ? 1 : 0)) * 31;
        float f5 = this.trackingInitialMoveThreshold;
        int floatToIntBits5 = (floatToIntBits4 + (f5 != 0.0f ? Float.floatToIntBits(f5) : 0)) * 31;
        float f6 = this.trackingMultiFingerMoveThreshold;
        int floatToIntBits6 = (floatToIntBits5 + (f6 != 0.0f ? Float.floatToIntBits(f6) : 0)) * 31;
        RectF rectF = this.trackingMultiFingerProtectedMoveArea;
        int hashCode13 = (floatToIntBits6 + (rectF != null ? rectF.hashCode() : 0)) * 31;
        String str7 = this.layerAbove;
        int hashCode14 = (hashCode13 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.layerBelow;
        int hashCode15 = (hashCode14 + (str8 != null ? str8.hashCode() : 0)) * 31;
        float f7 = this.trackingAnimationDurationMultiplier;
        int floatToIntBits7 = (((((((((hashCode15 + (f7 != 0.0f ? Float.floatToIntBits(f7) : 0)) * 31) + (this.compassAnimationEnabled ? 1 : 0)) * 31) + (this.accuracyAnimationEnabled ? 1 : 0)) * 31) + (this.pulseEnabled.booleanValue() ? 1 : 0)) * 31) + (this.pulseFadeEnabled.booleanValue() ? 1 : 0)) * 31;
        Integer num6 = this.pulseColor;
        int hashCode16 = (floatToIntBits7 + (num6 != null ? num6.hashCode() : 0)) * 31;
        float f8 = this.pulseSingleDuration;
        int floatToIntBits8 = (hashCode16 + (f8 != 0.0f ? Float.floatToIntBits(f8) : 0)) * 31;
        float f9 = this.pulseMaxRadius;
        int floatToIntBits9 = (floatToIntBits8 + (f9 != 0.0f ? Float.floatToIntBits(f9) : 0)) * 31;
        float f10 = this.pulseAlpha;
        return floatToIntBits9 + (f10 != 0.0f ? Float.floatToIntBits(f10) : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.accuracyAlpha);
        parcel.writeInt(this.accuracyColor);
        parcel.writeInt(this.backgroundDrawableStale);
        parcel.writeString(this.backgroundStaleName);
        parcel.writeInt(this.foregroundDrawableStale);
        parcel.writeString(this.foregroundStaleName);
        parcel.writeInt(this.gpsDrawable);
        parcel.writeString(this.gpsName);
        parcel.writeInt(this.foregroundDrawable);
        parcel.writeString(this.foregroundName);
        parcel.writeInt(this.backgroundDrawable);
        parcel.writeString(this.backgroundName);
        parcel.writeInt(this.bearingDrawable);
        parcel.writeString(this.bearingName);
        parcel.writeValue(this.bearingTintColor);
        parcel.writeValue(this.foregroundTintColor);
        parcel.writeValue(this.backgroundTintColor);
        parcel.writeValue(this.foregroundStaleTintColor);
        parcel.writeValue(this.backgroundStaleTintColor);
        parcel.writeFloat(this.elevation);
        parcel.writeByte(this.enableStaleState ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.staleStateTimeout);
        parcel.writeIntArray(this.padding);
        parcel.writeFloat(this.maxZoomIconScale);
        parcel.writeFloat(this.minZoomIconScale);
        parcel.writeByte(this.trackingGesturesManagement ? (byte) 1 : (byte) 0);
        parcel.writeFloat(this.trackingInitialMoveThreshold);
        parcel.writeFloat(this.trackingMultiFingerMoveThreshold);
        parcel.writeParcelable(this.trackingMultiFingerProtectedMoveArea, i);
        parcel.writeString(this.layerAbove);
        parcel.writeString(this.layerBelow);
        parcel.writeFloat(this.trackingAnimationDurationMultiplier);
        parcel.writeByte(this.compassAnimationEnabled ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.accuracyAnimationEnabled ? (byte) 1 : (byte) 0);
        parcel.writeValue(this.pulseEnabled);
        parcel.writeValue(this.pulseFadeEnabled);
        parcel.writeValue(this.pulseColor);
        parcel.writeFloat(this.pulseSingleDuration);
        parcel.writeFloat(this.pulseMaxRadius);
        parcel.writeFloat(this.pulseAlpha);
    }

    protected LocationComponentOptions(Parcel parcel) {
        this.accuracyAlpha = parcel.readFloat();
        this.accuracyColor = parcel.readInt();
        this.backgroundDrawableStale = parcel.readInt();
        this.backgroundStaleName = parcel.readString();
        this.foregroundDrawableStale = parcel.readInt();
        this.foregroundStaleName = parcel.readString();
        this.gpsDrawable = parcel.readInt();
        this.gpsName = parcel.readString();
        this.foregroundDrawable = parcel.readInt();
        this.foregroundName = parcel.readString();
        this.backgroundDrawable = parcel.readInt();
        this.backgroundName = parcel.readString();
        this.bearingDrawable = parcel.readInt();
        this.bearingName = parcel.readString();
        this.bearingTintColor = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.foregroundTintColor = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.backgroundTintColor = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.foregroundStaleTintColor = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.backgroundStaleTintColor = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.elevation = parcel.readFloat();
        this.enableStaleState = parcel.readByte() != 0;
        this.staleStateTimeout = parcel.readLong();
        this.padding = parcel.createIntArray();
        this.maxZoomIconScale = parcel.readFloat();
        this.minZoomIconScale = parcel.readFloat();
        this.trackingGesturesManagement = parcel.readByte() != 0;
        this.trackingInitialMoveThreshold = parcel.readFloat();
        this.trackingMultiFingerMoveThreshold = parcel.readFloat();
        this.trackingMultiFingerProtectedMoveArea = (RectF) parcel.readParcelable(RectF.class.getClassLoader());
        this.layerAbove = parcel.readString();
        this.layerBelow = parcel.readString();
        this.trackingAnimationDurationMultiplier = parcel.readFloat();
        this.compassAnimationEnabled = parcel.readByte() != 0;
        this.accuracyAnimationEnabled = parcel.readByte() != 0;
        this.pulseEnabled = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.pulseFadeEnabled = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.pulseColor = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.pulseSingleDuration = parcel.readFloat();
        this.pulseMaxRadius = parcel.readFloat();
        this.pulseAlpha = parcel.readFloat();
    }

    public static class Builder {
        private Float accuracyAlpha;
        private Boolean accuracyAnimationEnabled;
        private Integer accuracyColor;
        private Integer backgroundDrawable;
        private Integer backgroundDrawableStale;
        private String backgroundName;
        private String backgroundStaleName;
        private Integer backgroundStaleTintColor;
        private Integer backgroundTintColor;
        private Integer bearingDrawable;
        private String bearingName;
        private Integer bearingTintColor;
        private Boolean compassAnimationEnabled;
        private Float elevation;
        private Boolean enableStaleState;
        private Integer foregroundDrawable;
        private Integer foregroundDrawableStale;
        private String foregroundName;
        private String foregroundStaleName;
        private Integer foregroundStaleTintColor;
        private Integer foregroundTintColor;
        private Integer gpsDrawable;
        private String gpsName;
        private String layerAbove;
        private String layerBelow;
        private Float maxZoomIconScale;
        private Float minZoomIconScale;
        private int[] padding;
        private float pulseAlpha;
        private int pulseColor;
        private Boolean pulseEnabled;
        private Boolean pulseFadeEnabled;
        private Interpolator pulseInterpolator;
        private float pulseMaxRadius;
        private float pulseSingleDuration;
        private Long staleStateTimeout;
        private Float trackingAnimationDurationMultiplier;
        private Boolean trackingGesturesManagement;
        private Float trackingInitialMoveThreshold;
        private Float trackingMultiFingerMoveThreshold;
        private RectF trackingMultiFingerProtectedMoveArea;

        public LocationComponentOptions build() {
            LocationComponentOptions autoBuild = autoBuild();
            if (autoBuild.accuracyAlpha() < 0.0f || autoBuild.accuracyAlpha() > 1.0f) {
                throw new IllegalArgumentException("Accuracy alpha value must be between 0.0 and 1.0.");
            }
            if (autoBuild.elevation() < 0.0f) {
                throw new IllegalArgumentException("Invalid shadow size " + autoBuild.elevation() + ". Must be >= 0");
            }
            if (autoBuild.layerAbove() != null && autoBuild.layerBelow() != null) {
                throw new IllegalArgumentException("You cannot set both layerAbove and layerBelow options. Choose one or the other.");
            }
            if (autoBuild.pulseEnabled() == null) {
                String str = autoBuild.pulseFadeEnabled() != null ? " pulseFadeEnabled" : "";
                if (autoBuild.pulseColor() != null) {
                    str = str + " pulseColor";
                }
                if (autoBuild.pulseSingleDuration() > 0.0f) {
                    str = str + " pulseSingleDuration";
                }
                if (autoBuild.pulseMaxRadius() > 0.0f) {
                    str = str + " pulseMaxRadius";
                }
                if (autoBuild.pulseAlpha() >= 0.0f && autoBuild.pulseAlpha() <= 1.0f) {
                    str = str + " pulseAlpha";
                }
                if (autoBuild.pulseInterpolator() != null) {
                    str = str + " pulseInterpolator";
                }
                if (!str.isEmpty()) {
                    throw new IllegalStateException("You've set up the following pulsing circle options but have not enabled the pulsing circle via the LocationComponentOptions builder:" + str + ". Enable the pulsing circle if you're going to set pulsing options.");
                }
            }
            return autoBuild;
        }

        Builder() {
        }

        private Builder(LocationComponentOptions locationComponentOptions) {
            this.accuracyAlpha = Float.valueOf(locationComponentOptions.accuracyAlpha());
            this.accuracyColor = Integer.valueOf(locationComponentOptions.accuracyColor());
            this.backgroundDrawableStale = Integer.valueOf(locationComponentOptions.backgroundDrawableStale());
            this.backgroundStaleName = locationComponentOptions.backgroundStaleName();
            this.foregroundDrawableStale = Integer.valueOf(locationComponentOptions.foregroundDrawableStale());
            this.foregroundStaleName = locationComponentOptions.foregroundStaleName();
            this.gpsDrawable = Integer.valueOf(locationComponentOptions.gpsDrawable());
            this.gpsName = locationComponentOptions.gpsName();
            this.foregroundDrawable = Integer.valueOf(locationComponentOptions.foregroundDrawable());
            this.foregroundName = locationComponentOptions.foregroundName();
            this.backgroundDrawable = Integer.valueOf(locationComponentOptions.backgroundDrawable());
            this.backgroundName = locationComponentOptions.backgroundName();
            this.bearingDrawable = Integer.valueOf(locationComponentOptions.bearingDrawable());
            this.bearingName = locationComponentOptions.bearingName();
            this.bearingTintColor = locationComponentOptions.bearingTintColor();
            this.foregroundTintColor = locationComponentOptions.foregroundTintColor();
            this.backgroundTintColor = locationComponentOptions.backgroundTintColor();
            this.foregroundStaleTintColor = locationComponentOptions.foregroundStaleTintColor();
            this.backgroundStaleTintColor = locationComponentOptions.backgroundStaleTintColor();
            this.elevation = Float.valueOf(locationComponentOptions.elevation());
            this.enableStaleState = Boolean.valueOf(locationComponentOptions.enableStaleState());
            this.staleStateTimeout = Long.valueOf(locationComponentOptions.staleStateTimeout());
            this.padding = locationComponentOptions.padding();
            this.maxZoomIconScale = Float.valueOf(locationComponentOptions.maxZoomIconScale());
            this.minZoomIconScale = Float.valueOf(locationComponentOptions.minZoomIconScale());
            this.trackingGesturesManagement = Boolean.valueOf(locationComponentOptions.trackingGesturesManagement());
            this.trackingInitialMoveThreshold = Float.valueOf(locationComponentOptions.trackingInitialMoveThreshold());
            this.trackingMultiFingerMoveThreshold = Float.valueOf(locationComponentOptions.trackingMultiFingerMoveThreshold());
            this.trackingMultiFingerProtectedMoveArea = locationComponentOptions.trackingMultiFingerProtectedMoveArea();
            this.layerAbove = locationComponentOptions.layerAbove();
            this.layerBelow = locationComponentOptions.layerBelow();
            this.trackingAnimationDurationMultiplier = Float.valueOf(locationComponentOptions.trackingAnimationDurationMultiplier());
            this.compassAnimationEnabled = Boolean.valueOf(locationComponentOptions.compassAnimationEnabled());
            this.accuracyAnimationEnabled = Boolean.valueOf(locationComponentOptions.accuracyAnimationEnabled());
            this.pulseEnabled = locationComponentOptions.pulseEnabled;
            this.pulseFadeEnabled = locationComponentOptions.pulseFadeEnabled;
            this.pulseColor = locationComponentOptions.pulseColor.intValue();
            this.pulseSingleDuration = locationComponentOptions.pulseSingleDuration;
            this.pulseMaxRadius = locationComponentOptions.pulseMaxRadius;
            this.pulseAlpha = locationComponentOptions.pulseAlpha;
            this.pulseInterpolator = locationComponentOptions.pulseInterpolator;
        }

        public Builder accuracyAlpha(float f) {
            this.accuracyAlpha = Float.valueOf(f);
            return this;
        }

        public Builder accuracyColor(int i) {
            this.accuracyColor = Integer.valueOf(i);
            return this;
        }

        public Builder backgroundDrawableStale(int i) {
            this.backgroundDrawableStale = Integer.valueOf(i);
            return this;
        }

        public Builder backgroundStaleName(String str) {
            this.backgroundStaleName = str;
            return this;
        }

        public Builder foregroundDrawableStale(int i) {
            this.foregroundDrawableStale = Integer.valueOf(i);
            return this;
        }

        public Builder foregroundStaleName(String str) {
            this.foregroundStaleName = str;
            return this;
        }

        public Builder gpsDrawable(int i) {
            this.gpsDrawable = Integer.valueOf(i);
            return this;
        }

        public Builder gpsName(String str) {
            this.gpsName = str;
            return this;
        }

        public Builder foregroundDrawable(int i) {
            this.foregroundDrawable = Integer.valueOf(i);
            return this;
        }

        public Builder foregroundName(String str) {
            this.foregroundName = str;
            return this;
        }

        public Builder backgroundDrawable(int i) {
            this.backgroundDrawable = Integer.valueOf(i);
            return this;
        }

        public Builder backgroundName(String str) {
            this.backgroundName = str;
            return this;
        }

        public Builder bearingDrawable(int i) {
            this.bearingDrawable = Integer.valueOf(i);
            return this;
        }

        public Builder bearingName(String str) {
            this.bearingName = str;
            return this;
        }

        public Builder bearingTintColor(Integer num) {
            this.bearingTintColor = num;
            return this;
        }

        public Builder foregroundTintColor(Integer num) {
            this.foregroundTintColor = num;
            return this;
        }

        public Builder backgroundTintColor(Integer num) {
            this.backgroundTintColor = num;
            return this;
        }

        public Builder foregroundStaleTintColor(Integer num) {
            this.foregroundStaleTintColor = num;
            return this;
        }

        public Builder backgroundStaleTintColor(Integer num) {
            this.backgroundStaleTintColor = num;
            return this;
        }

        public Builder elevation(float f) {
            this.elevation = Float.valueOf(f);
            return this;
        }

        public Builder enableStaleState(boolean z) {
            this.enableStaleState = Boolean.valueOf(z);
            return this;
        }

        public Builder staleStateTimeout(long j) {
            this.staleStateTimeout = Long.valueOf(j);
            return this;
        }

        @Deprecated
        public Builder padding(int[] iArr) {
            Objects.requireNonNull(iArr, "Null padding");
            this.padding = iArr;
            return this;
        }

        public Builder maxZoomIconScale(float f) {
            this.maxZoomIconScale = Float.valueOf(f);
            return this;
        }

        public Builder minZoomIconScale(float f) {
            this.minZoomIconScale = Float.valueOf(f);
            return this;
        }

        public Builder trackingGesturesManagement(boolean z) {
            this.trackingGesturesManagement = Boolean.valueOf(z);
            return this;
        }

        public Builder trackingInitialMoveThreshold(float f) {
            this.trackingInitialMoveThreshold = Float.valueOf(f);
            return this;
        }

        public Builder trackingMultiFingerMoveThreshold(float f) {
            this.trackingMultiFingerMoveThreshold = Float.valueOf(f);
            return this;
        }

        public Builder trackingMultiFingerProtectedMoveArea(RectF rectF) {
            this.trackingMultiFingerProtectedMoveArea = rectF;
            return this;
        }

        public Builder layerAbove(String str) {
            this.layerAbove = str;
            return this;
        }

        public Builder layerBelow(String str) {
            this.layerBelow = str;
            return this;
        }

        public Builder trackingAnimationDurationMultiplier(float f) {
            this.trackingAnimationDurationMultiplier = Float.valueOf(f);
            return this;
        }

        public Builder compassAnimationEnabled(Boolean bool) {
            this.compassAnimationEnabled = bool;
            return this;
        }

        public Builder accuracyAnimationEnabled(boolean z) {
            this.accuracyAnimationEnabled = Boolean.valueOf(z);
            return this;
        }

        public Builder pulseEnabled(boolean z) {
            this.pulseEnabled = Boolean.valueOf(z);
            return this;
        }

        public Builder pulseFadeEnabled(boolean z) {
            this.pulseFadeEnabled = Boolean.valueOf(z);
            return this;
        }

        public Builder pulseColor(int i) {
            this.pulseColor = i;
            return this;
        }

        public Builder pulseSingleDuration(float f) {
            this.pulseSingleDuration = f;
            return this;
        }

        public Builder pulseMaxRadius(float f) {
            this.pulseMaxRadius = f;
            return this;
        }

        public Builder pulseAlpha(float f) {
            this.pulseAlpha = f;
            return this;
        }

        public Builder pulseInterpolator(Interpolator interpolator) {
            this.pulseInterpolator = interpolator;
            return this;
        }

        LocationComponentOptions autoBuild() {
            String str = this.accuracyAlpha == null ? " accuracyAlpha" : "";
            if (this.accuracyColor == null) {
                str = str + " accuracyColor";
            }
            if (this.backgroundDrawableStale == null) {
                str = str + " backgroundDrawableStale";
            }
            if (this.foregroundDrawableStale == null) {
                str = str + " foregroundDrawableStale";
            }
            if (this.gpsDrawable == null) {
                str = str + " gpsDrawable";
            }
            if (this.foregroundDrawable == null) {
                str = str + " foregroundDrawable";
            }
            if (this.backgroundDrawable == null) {
                str = str + " backgroundDrawable";
            }
            if (this.bearingDrawable == null) {
                str = str + " bearingDrawable";
            }
            if (this.elevation == null) {
                str = str + " elevation";
            }
            if (this.enableStaleState == null) {
                str = str + " enableStaleState";
            }
            if (this.staleStateTimeout == null) {
                str = str + " staleStateTimeout";
            }
            if (this.padding == null) {
                str = str + " padding";
            }
            if (this.maxZoomIconScale == null) {
                str = str + " maxZoomIconScale";
            }
            if (this.minZoomIconScale == null) {
                str = str + " minZoomIconScale";
            }
            if (this.trackingGesturesManagement == null) {
                str = str + " trackingGesturesManagement";
            }
            if (this.trackingInitialMoveThreshold == null) {
                str = str + " trackingInitialMoveThreshold";
            }
            if (this.trackingMultiFingerMoveThreshold == null) {
                str = str + " trackingMultiFingerMoveThreshold";
            }
            if (this.trackingAnimationDurationMultiplier == null) {
                str = str + " trackingAnimationDurationMultiplier";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new LocationComponentOptions(this.accuracyAlpha.floatValue(), this.accuracyColor.intValue(), this.backgroundDrawableStale.intValue(), this.backgroundStaleName, this.foregroundDrawableStale.intValue(), this.foregroundStaleName, this.gpsDrawable.intValue(), this.gpsName, this.foregroundDrawable.intValue(), this.foregroundName, this.backgroundDrawable.intValue(), this.backgroundName, this.bearingDrawable.intValue(), this.bearingName, this.bearingTintColor, this.foregroundTintColor, this.backgroundTintColor, this.foregroundStaleTintColor, this.backgroundStaleTintColor, this.elevation.floatValue(), this.enableStaleState.booleanValue(), this.staleStateTimeout.longValue(), this.padding, this.maxZoomIconScale.floatValue(), this.minZoomIconScale.floatValue(), this.trackingGesturesManagement.booleanValue(), this.trackingInitialMoveThreshold.floatValue(), this.trackingMultiFingerMoveThreshold.floatValue(), this.trackingMultiFingerProtectedMoveArea, this.layerAbove, this.layerBelow, this.trackingAnimationDurationMultiplier.floatValue(), this.compassAnimationEnabled.booleanValue(), this.accuracyAnimationEnabled.booleanValue(), this.pulseEnabled, this.pulseFadeEnabled, Integer.valueOf(this.pulseColor), this.pulseSingleDuration, this.pulseMaxRadius, this.pulseAlpha, this.pulseInterpolator);
        }
    }
}
