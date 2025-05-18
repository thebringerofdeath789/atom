package com.mapbox.mapboxsdk.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.material.badge.BadgeDrawable;
import com.mapbox.mapboxsdk.C3178R;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.utils.BitmapUtils;
import com.mapbox.mapboxsdk.utils.FontUtils;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class MapboxMapOptions implements Parcelable {
    public static final Parcelable.Creator<MapboxMapOptions> CREATOR = new Parcelable.Creator<MapboxMapOptions>() { // from class: com.mapbox.mapboxsdk.maps.MapboxMapOptions.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MapboxMapOptions createFromParcel(Parcel parcel) {
            return new MapboxMapOptions(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MapboxMapOptions[] newArray(int i) {
            return new MapboxMapOptions[i];
        }
    };
    private static final float FOUR_DP = 4.0f;
    private static final int LIGHT_GRAY = -988703;
    private static final float NINETY_TWO_DP = 92.0f;
    private static final int UNDEFINED_COLOR = -1;
    private String apiBaseUri;
    private boolean attributionEnabled;
    private int attributionGravity;
    private int[] attributionMargins;
    private int attributionTintColor;
    private CameraPosition cameraPosition;
    private boolean compassEnabled;
    private int compassGravity;
    private Drawable compassImage;
    private int compassImageResource;
    private int[] compassMargins;
    private boolean crossSourceCollisions;
    private boolean debugActive;
    private boolean doubleTapGesturesEnabled;
    private boolean fadeCompassFacingNorth;
    private int foregroundLoadColor;
    private GlyphsRasterizationMode glyphsRasterizationMode;
    private boolean horizontalScrollGesturesEnabled;
    private String[] localIdeographFontFamilies;
    private String localIdeographFontFamily;
    private boolean localIdeographFontFamilyEnabled;
    private boolean logoEnabled;
    private int logoGravity;
    private int[] logoMargins;
    private double maxPitch;
    private double maxZoom;
    private double minPitch;
    private double minZoom;
    private float pixelRatio;
    private int prefetchZoomDelta;
    private boolean prefetchesTiles;
    private boolean quickZoomGesturesEnabled;
    private boolean rotateGesturesEnabled;
    private boolean scrollGesturesEnabled;
    private boolean textureMode;
    private boolean tiltGesturesEnabled;
    private boolean translucentTextureSurface;
    private boolean zMediaOverlay;
    private boolean zoomGesturesEnabled;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public MapboxMapOptions() {
        this.compassEnabled = true;
        this.fadeCompassFacingNorth = true;
        this.compassGravity = BadgeDrawable.TOP_END;
        this.logoEnabled = true;
        this.logoGravity = BadgeDrawable.BOTTOM_START;
        this.attributionTintColor = -1;
        this.attributionEnabled = true;
        this.attributionGravity = BadgeDrawable.BOTTOM_START;
        this.minZoom = 0.0d;
        this.maxZoom = 25.5d;
        this.minPitch = 0.0d;
        this.maxPitch = 60.0d;
        this.rotateGesturesEnabled = true;
        this.scrollGesturesEnabled = true;
        this.horizontalScrollGesturesEnabled = true;
        this.tiltGesturesEnabled = true;
        this.zoomGesturesEnabled = true;
        this.doubleTapGesturesEnabled = true;
        this.quickZoomGesturesEnabled = true;
        this.prefetchesTiles = true;
        this.prefetchZoomDelta = 4;
        this.zMediaOverlay = false;
        this.localIdeographFontFamilyEnabled = true;
        this.glyphsRasterizationMode = GlyphsRasterizationMode.IDEOGRAPHS_RASTERIZED_LOCALLY;
        this.crossSourceCollisions = true;
    }

    private MapboxMapOptions(Parcel parcel) {
        this.compassEnabled = true;
        this.fadeCompassFacingNorth = true;
        this.compassGravity = BadgeDrawable.TOP_END;
        this.logoEnabled = true;
        this.logoGravity = BadgeDrawable.BOTTOM_START;
        this.attributionTintColor = -1;
        this.attributionEnabled = true;
        this.attributionGravity = BadgeDrawable.BOTTOM_START;
        this.minZoom = 0.0d;
        this.maxZoom = 25.5d;
        this.minPitch = 0.0d;
        this.maxPitch = 60.0d;
        this.rotateGesturesEnabled = true;
        this.scrollGesturesEnabled = true;
        this.horizontalScrollGesturesEnabled = true;
        this.tiltGesturesEnabled = true;
        this.zoomGesturesEnabled = true;
        this.doubleTapGesturesEnabled = true;
        this.quickZoomGesturesEnabled = true;
        this.prefetchesTiles = true;
        this.prefetchZoomDelta = 4;
        this.zMediaOverlay = false;
        this.localIdeographFontFamilyEnabled = true;
        this.glyphsRasterizationMode = GlyphsRasterizationMode.IDEOGRAPHS_RASTERIZED_LOCALLY;
        this.crossSourceCollisions = true;
        this.cameraPosition = (CameraPosition) parcel.readParcelable(CameraPosition.class.getClassLoader());
        this.debugActive = parcel.readByte() != 0;
        this.compassEnabled = parcel.readByte() != 0;
        this.compassGravity = parcel.readInt();
        this.compassMargins = parcel.createIntArray();
        this.fadeCompassFacingNorth = parcel.readByte() != 0;
        Bitmap bitmap = (Bitmap) parcel.readParcelable(getClass().getClassLoader());
        if (bitmap != null) {
            this.compassImage = new BitmapDrawable(bitmap);
        }
        this.compassImageResource = parcel.readInt();
        this.logoEnabled = parcel.readByte() != 0;
        this.logoGravity = parcel.readInt();
        this.logoMargins = parcel.createIntArray();
        this.attributionEnabled = parcel.readByte() != 0;
        this.attributionGravity = parcel.readInt();
        this.attributionMargins = parcel.createIntArray();
        this.attributionTintColor = parcel.readInt();
        this.minZoom = parcel.readDouble();
        this.maxZoom = parcel.readDouble();
        this.minPitch = parcel.readDouble();
        this.maxPitch = parcel.readDouble();
        this.rotateGesturesEnabled = parcel.readByte() != 0;
        this.scrollGesturesEnabled = parcel.readByte() != 0;
        this.horizontalScrollGesturesEnabled = parcel.readByte() != 0;
        this.tiltGesturesEnabled = parcel.readByte() != 0;
        this.zoomGesturesEnabled = parcel.readByte() != 0;
        this.doubleTapGesturesEnabled = parcel.readByte() != 0;
        this.quickZoomGesturesEnabled = parcel.readByte() != 0;
        this.apiBaseUri = parcel.readString();
        this.textureMode = parcel.readByte() != 0;
        this.translucentTextureSurface = parcel.readByte() != 0;
        this.prefetchesTiles = parcel.readByte() != 0;
        this.prefetchZoomDelta = parcel.readInt();
        this.zMediaOverlay = parcel.readByte() != 0;
        this.localIdeographFontFamilyEnabled = parcel.readByte() != 0;
        this.localIdeographFontFamily = parcel.readString();
        this.glyphsRasterizationMode = GlyphsRasterizationMode.valueOf(parcel.readInt());
        this.localIdeographFontFamilies = parcel.createStringArray();
        this.pixelRatio = parcel.readFloat();
        this.foregroundLoadColor = parcel.readInt();
        this.crossSourceCollisions = parcel.readByte() != 0;
    }

    public static MapboxMapOptions createFromAttributes(Context context) {
        return createFromAttributes(context, null);
    }

    public static MapboxMapOptions createFromAttributes(Context context, AttributeSet attributeSet) {
        return createFromAttributes(new MapboxMapOptions(), context, context.obtainStyledAttributes(attributeSet, C3178R.styleable.mapbox_MapView, 0, 0));
    }

    static MapboxMapOptions createFromAttributes(MapboxMapOptions mapboxMapOptions, Context context, TypedArray typedArray) {
        float f = context.getResources().getDisplayMetrics().density;
        try {
            mapboxMapOptions.camera(new CameraPosition.Builder(typedArray).build());
            mapboxMapOptions.apiBaseUrl(typedArray.getString(C3178R.styleable.mapbox_MapView_mapbox_apiBaseUrl));
            String string = typedArray.getString(C3178R.styleable.mapbox_MapView_mapbox_apiBaseUri);
            if (!TextUtils.isEmpty(string)) {
                mapboxMapOptions.apiBaseUri(string);
            }
            mapboxMapOptions.zoomGesturesEnabled(typedArray.getBoolean(C3178R.styleable.mapbox_MapView_mapbox_uiZoomGestures, true));
            mapboxMapOptions.scrollGesturesEnabled(typedArray.getBoolean(C3178R.styleable.mapbox_MapView_mapbox_uiScrollGestures, true));
            mapboxMapOptions.horizontalScrollGesturesEnabled(typedArray.getBoolean(C3178R.styleable.mapbox_MapView_mapbox_uiHorizontalScrollGestures, true));
            mapboxMapOptions.rotateGesturesEnabled(typedArray.getBoolean(C3178R.styleable.mapbox_MapView_mapbox_uiRotateGestures, true));
            mapboxMapOptions.tiltGesturesEnabled(typedArray.getBoolean(C3178R.styleable.mapbox_MapView_mapbox_uiTiltGestures, true));
            mapboxMapOptions.doubleTapGesturesEnabled(typedArray.getBoolean(C3178R.styleable.mapbox_MapView_mapbox_uiDoubleTapGestures, true));
            mapboxMapOptions.quickZoomGesturesEnabled(typedArray.getBoolean(C3178R.styleable.mapbox_MapView_mapbox_uiQuickZoomGestures, true));
            mapboxMapOptions.maxZoomPreference(typedArray.getFloat(C3178R.styleable.mapbox_MapView_mapbox_cameraZoomMax, 25.5f));
            mapboxMapOptions.minZoomPreference(typedArray.getFloat(C3178R.styleable.mapbox_MapView_mapbox_cameraZoomMin, 0.0f));
            mapboxMapOptions.maxPitchPreference(typedArray.getFloat(C3178R.styleable.mapbox_MapView_mapbox_cameraPitchMax, 60.0f));
            mapboxMapOptions.minPitchPreference(typedArray.getFloat(C3178R.styleable.mapbox_MapView_mapbox_cameraPitchMin, 0.0f));
            mapboxMapOptions.compassEnabled(typedArray.getBoolean(C3178R.styleable.mapbox_MapView_mapbox_uiCompass, true));
            mapboxMapOptions.compassGravity(typedArray.getInt(C3178R.styleable.mapbox_MapView_mapbox_uiCompassGravity, BadgeDrawable.TOP_END));
            int i = C3178R.styleable.mapbox_MapView_mapbox_uiCompassMarginLeft;
            float f2 = FOUR_DP * f;
            mapboxMapOptions.compassMargins(new int[]{(int) typedArray.getDimension(i, f2), (int) typedArray.getDimension(C3178R.styleable.mapbox_MapView_mapbox_uiCompassMarginTop, f2), (int) typedArray.getDimension(C3178R.styleable.mapbox_MapView_mapbox_uiCompassMarginRight, f2), (int) typedArray.getDimension(C3178R.styleable.mapbox_MapView_mapbox_uiCompassMarginBottom, f2)});
            mapboxMapOptions.compassFadesWhenFacingNorth(typedArray.getBoolean(C3178R.styleable.mapbox_MapView_mapbox_uiCompassFadeFacingNorth, true));
            mapboxMapOptions.compassImage(typedArray.getDrawable(C3178R.styleable.mapbox_MapView_mapbox_uiCompassDrawable));
            mapboxMapOptions.compassImageResource(typedArray.getInt(C3178R.styleable.mapbox_MapView_mapbox_uiCompassDrawableRes, C3178R.drawable.mapbox_compass_icon));
            mapboxMapOptions.logoEnabled(typedArray.getBoolean(C3178R.styleable.mapbox_MapView_mapbox_uiLogo, true));
            mapboxMapOptions.logoGravity(typedArray.getInt(C3178R.styleable.mapbox_MapView_mapbox_uiLogoGravity, BadgeDrawable.BOTTOM_START));
            mapboxMapOptions.logoMargins(new int[]{(int) typedArray.getDimension(C3178R.styleable.mapbox_MapView_mapbox_uiLogoMarginLeft, f2), (int) typedArray.getDimension(C3178R.styleable.mapbox_MapView_mapbox_uiLogoMarginTop, f2), (int) typedArray.getDimension(C3178R.styleable.mapbox_MapView_mapbox_uiLogoMarginRight, f2), (int) typedArray.getDimension(C3178R.styleable.mapbox_MapView_mapbox_uiLogoMarginBottom, f2)});
            mapboxMapOptions.attributionTintColor(typedArray.getColor(C3178R.styleable.mapbox_MapView_mapbox_uiAttributionTintColor, -1));
            mapboxMapOptions.attributionEnabled(typedArray.getBoolean(C3178R.styleable.mapbox_MapView_mapbox_uiAttribution, true));
            mapboxMapOptions.attributionGravity(typedArray.getInt(C3178R.styleable.mapbox_MapView_mapbox_uiAttributionGravity, BadgeDrawable.BOTTOM_START));
            mapboxMapOptions.attributionMargins(new int[]{(int) typedArray.getDimension(C3178R.styleable.mapbox_MapView_mapbox_uiAttributionMarginLeft, f * NINETY_TWO_DP), (int) typedArray.getDimension(C3178R.styleable.mapbox_MapView_mapbox_uiAttributionMarginTop, f2), (int) typedArray.getDimension(C3178R.styleable.mapbox_MapView_mapbox_uiAttributionMarginRight, f2), (int) typedArray.getDimension(C3178R.styleable.mapbox_MapView_mapbox_uiAttributionMarginBottom, f2)});
            mapboxMapOptions.textureMode(typedArray.getBoolean(C3178R.styleable.mapbox_MapView_mapbox_renderTextureMode, false));
            mapboxMapOptions.translucentTextureSurface(typedArray.getBoolean(C3178R.styleable.mapbox_MapView_mapbox_renderTextureTranslucentSurface, false));
            mapboxMapOptions.setPrefetchesTiles(typedArray.getBoolean(C3178R.styleable.mapbox_MapView_mapbox_enableTilePrefetch, true));
            mapboxMapOptions.setPrefetchZoomDelta(typedArray.getInt(C3178R.styleable.mapbox_MapView_mapbox_prefetchZoomDelta, 4));
            mapboxMapOptions.renderSurfaceOnTop(typedArray.getBoolean(C3178R.styleable.mapbox_MapView_mapbox_enableZMediaOverlay, false));
            mapboxMapOptions.localIdeographFontFamilyEnabled = typedArray.getBoolean(C3178R.styleable.mapbox_MapView_mapbox_localIdeographEnabled, true);
            int resourceId = typedArray.getResourceId(C3178R.styleable.mapbox_MapView_mapbox_localIdeographFontFamilies, 0);
            if (resourceId != 0) {
                mapboxMapOptions.localIdeographFontFamily(context.getResources().getStringArray(resourceId));
            } else {
                String string2 = typedArray.getString(C3178R.styleable.mapbox_MapView_mapbox_localIdeographFontFamily);
                if (string2 == null) {
                    string2 = "sans-serif";
                }
                mapboxMapOptions.localIdeographFontFamily(string2);
            }
            mapboxMapOptions.setRasterizationMode(GlyphsRasterizationMode.valueOf(typedArray.getInt(C3178R.styleable.mapbox_MapView_mapbox_glyphRasterizationMode, 0)));
            mapboxMapOptions.pixelRatio(typedArray.getFloat(C3178R.styleable.mapbox_MapView_mapbox_pixelRatio, 0.0f));
            mapboxMapOptions.foregroundLoadColor(typedArray.getInt(C3178R.styleable.mapbox_MapView_mapbox_foregroundLoadColor, LIGHT_GRAY));
            mapboxMapOptions.crossSourceCollisions(typedArray.getBoolean(C3178R.styleable.mapbox_MapView_mapbox_cross_source_collisions, true));
            return mapboxMapOptions;
        } finally {
            typedArray.recycle();
        }
    }

    public void setRasterizationMode(GlyphsRasterizationMode glyphsRasterizationMode) {
        this.glyphsRasterizationMode = glyphsRasterizationMode;
    }

    public GlyphsRasterizationMode getGlyphsRasterizationMode() {
        return this.glyphsRasterizationMode;
    }

    @Deprecated
    public MapboxMapOptions apiBaseUrl(String str) {
        this.apiBaseUri = str;
        return this;
    }

    public MapboxMapOptions apiBaseUri(String str) {
        this.apiBaseUri = str;
        return this;
    }

    public MapboxMapOptions camera(CameraPosition cameraPosition) {
        this.cameraPosition = cameraPosition;
        return this;
    }

    public MapboxMapOptions debugActive(boolean z) {
        this.debugActive = z;
        return this;
    }

    public MapboxMapOptions minZoomPreference(double d) {
        this.minZoom = d;
        return this;
    }

    public MapboxMapOptions maxZoomPreference(double d) {
        this.maxZoom = d;
        return this;
    }

    public MapboxMapOptions minPitchPreference(double d) {
        this.minPitch = d;
        return this;
    }

    public MapboxMapOptions maxPitchPreference(double d) {
        this.maxPitch = d;
        return this;
    }

    public MapboxMapOptions compassEnabled(boolean z) {
        this.compassEnabled = z;
        return this;
    }

    public MapboxMapOptions compassGravity(int i) {
        this.compassGravity = i;
        return this;
    }

    public MapboxMapOptions compassMargins(int[] iArr) {
        this.compassMargins = iArr;
        return this;
    }

    public MapboxMapOptions compassFadesWhenFacingNorth(boolean z) {
        this.fadeCompassFacingNorth = z;
        return this;
    }

    public MapboxMapOptions compassImage(Drawable drawable) {
        this.compassImage = drawable;
        return this;
    }

    public MapboxMapOptions compassImageResource(int i) {
        this.compassImageResource = i;
        return this;
    }

    public MapboxMapOptions logoEnabled(boolean z) {
        this.logoEnabled = z;
        return this;
    }

    public MapboxMapOptions logoGravity(int i) {
        this.logoGravity = i;
        return this;
    }

    public MapboxMapOptions logoMargins(int[] iArr) {
        this.logoMargins = iArr;
        return this;
    }

    public MapboxMapOptions attributionEnabled(boolean z) {
        this.attributionEnabled = z;
        return this;
    }

    public MapboxMapOptions attributionGravity(int i) {
        this.attributionGravity = i;
        return this;
    }

    public MapboxMapOptions attributionMargins(int[] iArr) {
        this.attributionMargins = iArr;
        return this;
    }

    public MapboxMapOptions attributionTintColor(int i) {
        this.attributionTintColor = i;
        return this;
    }

    public MapboxMapOptions rotateGesturesEnabled(boolean z) {
        this.rotateGesturesEnabled = z;
        return this;
    }

    public MapboxMapOptions scrollGesturesEnabled(boolean z) {
        this.scrollGesturesEnabled = z;
        return this;
    }

    public MapboxMapOptions horizontalScrollGesturesEnabled(boolean z) {
        this.horizontalScrollGesturesEnabled = z;
        return this;
    }

    public MapboxMapOptions tiltGesturesEnabled(boolean z) {
        this.tiltGesturesEnabled = z;
        return this;
    }

    public MapboxMapOptions zoomGesturesEnabled(boolean z) {
        this.zoomGesturesEnabled = z;
        return this;
    }

    public MapboxMapOptions doubleTapGesturesEnabled(boolean z) {
        this.doubleTapGesturesEnabled = z;
        return this;
    }

    public MapboxMapOptions quickZoomGesturesEnabled(boolean z) {
        this.quickZoomGesturesEnabled = z;
        return this;
    }

    public MapboxMapOptions textureMode(boolean z) {
        this.textureMode = z;
        return this;
    }

    public MapboxMapOptions translucentTextureSurface(boolean z) {
        this.translucentTextureSurface = z;
        return this;
    }

    public MapboxMapOptions foregroundLoadColor(int i) {
        this.foregroundLoadColor = i;
        return this;
    }

    @Deprecated
    public MapboxMapOptions setPrefetchesTiles(boolean z) {
        this.prefetchesTiles = z;
        return this;
    }

    public MapboxMapOptions setPrefetchZoomDelta(int i) {
        this.prefetchZoomDelta = i;
        return this;
    }

    public MapboxMapOptions crossSourceCollisions(boolean z) {
        this.crossSourceCollisions = z;
        return this;
    }

    public MapboxMapOptions localIdeographFontFamilyEnabled(boolean z) {
        this.localIdeographFontFamilyEnabled = z;
        return this;
    }

    public MapboxMapOptions localIdeographFontFamily(String str) {
        this.localIdeographFontFamily = FontUtils.extractValidFont(str);
        return this;
    }

    public MapboxMapOptions localIdeographFontFamily(String... strArr) {
        this.localIdeographFontFamily = FontUtils.extractValidFont(strArr);
        return this;
    }

    public MapboxMapOptions pixelRatio(float f) {
        this.pixelRatio = f;
        return this;
    }

    @Deprecated
    public boolean getPrefetchesTiles() {
        return this.prefetchesTiles;
    }

    public int getPrefetchZoomDelta() {
        return this.prefetchZoomDelta;
    }

    public boolean getCrossSourceCollisions() {
        return this.crossSourceCollisions;
    }

    public void renderSurfaceOnTop(boolean z) {
        this.zMediaOverlay = z;
    }

    public boolean getRenderSurfaceOnTop() {
        return this.zMediaOverlay;
    }

    @Deprecated
    public String getApiBaseUrl() {
        return this.apiBaseUri;
    }

    public String getApiBaseUri() {
        return this.apiBaseUri;
    }

    public CameraPosition getCamera() {
        return this.cameraPosition;
    }

    public double getMinZoomPreference() {
        return this.minZoom;
    }

    public double getMaxZoomPreference() {
        return this.maxZoom;
    }

    public double getMinPitchPreference() {
        return this.minPitch;
    }

    public double getMaxPitchPreference() {
        return this.maxPitch;
    }

    public boolean getCompassEnabled() {
        return this.compassEnabled;
    }

    public int getCompassGravity() {
        return this.compassGravity;
    }

    public int[] getCompassMargins() {
        return this.compassMargins;
    }

    public boolean getCompassFadeFacingNorth() {
        return this.fadeCompassFacingNorth;
    }

    @Deprecated
    public Drawable getCompassImage() {
        return this.compassImage;
    }

    public int getCompassImageResource() {
        return this.compassImageResource;
    }

    public boolean getLogoEnabled() {
        return this.logoEnabled;
    }

    public int getLogoGravity() {
        return this.logoGravity;
    }

    public int[] getLogoMargins() {
        return this.logoMargins;
    }

    public boolean getRotateGesturesEnabled() {
        return this.rotateGesturesEnabled;
    }

    public boolean getScrollGesturesEnabled() {
        return this.scrollGesturesEnabled;
    }

    public boolean getHorizontalScrollGesturesEnabled() {
        return this.horizontalScrollGesturesEnabled;
    }

    public boolean getTiltGesturesEnabled() {
        return this.tiltGesturesEnabled;
    }

    public boolean getZoomGesturesEnabled() {
        return this.zoomGesturesEnabled;
    }

    public boolean getDoubleTapGesturesEnabled() {
        return this.doubleTapGesturesEnabled;
    }

    public boolean getQuickZoomGesturesEnabled() {
        return this.quickZoomGesturesEnabled;
    }

    public boolean getAttributionEnabled() {
        return this.attributionEnabled;
    }

    public int getAttributionGravity() {
        return this.attributionGravity;
    }

    public int[] getAttributionMargins() {
        return this.attributionMargins;
    }

    public int getAttributionTintColor() {
        return this.attributionTintColor;
    }

    public boolean getDebugActive() {
        return this.debugActive;
    }

    public boolean getTextureMode() {
        return this.textureMode;
    }

    public boolean getTranslucentTextureSurface() {
        return this.translucentTextureSurface;
    }

    public int getForegroundLoadColor() {
        return this.foregroundLoadColor;
    }

    public String getLocalIdeographFontFamily() {
        if (this.localIdeographFontFamilyEnabled) {
            return this.localIdeographFontFamily;
        }
        return null;
    }

    public boolean isLocalIdeographFontFamilyEnabled() {
        return this.localIdeographFontFamilyEnabled;
    }

    public float getPixelRatio() {
        return this.pixelRatio;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.cameraPosition, i);
        parcel.writeByte(this.debugActive ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.compassEnabled ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.compassGravity);
        parcel.writeIntArray(this.compassMargins);
        parcel.writeByte(this.fadeCompassFacingNorth ? (byte) 1 : (byte) 0);
        Drawable drawable = this.compassImage;
        parcel.writeParcelable(drawable != null ? BitmapUtils.getBitmapFromDrawable(drawable) : null, i);
        parcel.writeInt(this.compassImageResource);
        parcel.writeByte(this.logoEnabled ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.logoGravity);
        parcel.writeIntArray(this.logoMargins);
        parcel.writeByte(this.attributionEnabled ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.attributionGravity);
        parcel.writeIntArray(this.attributionMargins);
        parcel.writeInt(this.attributionTintColor);
        parcel.writeDouble(this.minZoom);
        parcel.writeDouble(this.maxZoom);
        parcel.writeDouble(this.minPitch);
        parcel.writeDouble(this.maxPitch);
        parcel.writeByte(this.rotateGesturesEnabled ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.scrollGesturesEnabled ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.horizontalScrollGesturesEnabled ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.tiltGesturesEnabled ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.zoomGesturesEnabled ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.doubleTapGesturesEnabled ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.quickZoomGesturesEnabled ? (byte) 1 : (byte) 0);
        parcel.writeString(this.apiBaseUri);
        parcel.writeByte(this.textureMode ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.translucentTextureSurface ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.prefetchesTiles ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.prefetchZoomDelta);
        parcel.writeByte(this.zMediaOverlay ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.localIdeographFontFamilyEnabled ? (byte) 1 : (byte) 0);
        parcel.writeString(this.localIdeographFontFamily);
        parcel.writeInt(this.glyphsRasterizationMode.ordinal());
        parcel.writeStringArray(this.localIdeographFontFamilies);
        parcel.writeFloat(this.pixelRatio);
        parcel.writeInt(this.foregroundLoadColor);
        parcel.writeByte(this.crossSourceCollisions ? (byte) 1 : (byte) 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            MapboxMapOptions mapboxMapOptions = (MapboxMapOptions) obj;
            if (this.debugActive != mapboxMapOptions.debugActive || this.compassEnabled != mapboxMapOptions.compassEnabled || this.fadeCompassFacingNorth != mapboxMapOptions.fadeCompassFacingNorth) {
                return false;
            }
            Drawable drawable = this.compassImage;
            if (drawable == null ? mapboxMapOptions.compassImage != null : !drawable.equals(mapboxMapOptions.compassImage)) {
                return false;
            }
            if (this.compassImageResource != mapboxMapOptions.compassImageResource || this.compassGravity != mapboxMapOptions.compassGravity || this.logoEnabled != mapboxMapOptions.logoEnabled || this.logoGravity != mapboxMapOptions.logoGravity || this.attributionTintColor != mapboxMapOptions.attributionTintColor || this.attributionEnabled != mapboxMapOptions.attributionEnabled || this.attributionGravity != mapboxMapOptions.attributionGravity || Double.compare(mapboxMapOptions.minZoom, this.minZoom) != 0 || Double.compare(mapboxMapOptions.maxZoom, this.maxZoom) != 0 || Double.compare(mapboxMapOptions.minPitch, this.minPitch) != 0 || Double.compare(mapboxMapOptions.maxPitch, this.maxPitch) != 0 || this.rotateGesturesEnabled != mapboxMapOptions.rotateGesturesEnabled || this.scrollGesturesEnabled != mapboxMapOptions.scrollGesturesEnabled || this.horizontalScrollGesturesEnabled != mapboxMapOptions.horizontalScrollGesturesEnabled || this.tiltGesturesEnabled != mapboxMapOptions.tiltGesturesEnabled || this.zoomGesturesEnabled != mapboxMapOptions.zoomGesturesEnabled || this.doubleTapGesturesEnabled != mapboxMapOptions.doubleTapGesturesEnabled || this.quickZoomGesturesEnabled != mapboxMapOptions.quickZoomGesturesEnabled) {
                return false;
            }
            CameraPosition cameraPosition = this.cameraPosition;
            if (cameraPosition == null ? mapboxMapOptions.cameraPosition != null : !cameraPosition.equals(mapboxMapOptions.cameraPosition)) {
                return false;
            }
            if (!Arrays.equals(this.compassMargins, mapboxMapOptions.compassMargins) || !Arrays.equals(this.logoMargins, mapboxMapOptions.logoMargins) || !Arrays.equals(this.attributionMargins, mapboxMapOptions.attributionMargins)) {
                return false;
            }
            String str = this.apiBaseUri;
            if (str == null ? mapboxMapOptions.apiBaseUri != null : !str.equals(mapboxMapOptions.apiBaseUri)) {
                return false;
            }
            if (this.prefetchesTiles == mapboxMapOptions.prefetchesTiles && this.prefetchZoomDelta == mapboxMapOptions.prefetchZoomDelta && this.zMediaOverlay == mapboxMapOptions.zMediaOverlay && this.localIdeographFontFamilyEnabled == mapboxMapOptions.localIdeographFontFamilyEnabled && this.localIdeographFontFamily.equals(mapboxMapOptions.localIdeographFontFamily) && this.glyphsRasterizationMode.equals(mapboxMapOptions.glyphsRasterizationMode) && Arrays.equals(this.localIdeographFontFamilies, mapboxMapOptions.localIdeographFontFamilies) && this.pixelRatio == mapboxMapOptions.pixelRatio && this.crossSourceCollisions != mapboxMapOptions.crossSourceCollisions) {
            }
        }
        return false;
    }

    public int hashCode() {
        CameraPosition cameraPosition = this.cameraPosition;
        int hashCode = (((((((((cameraPosition != null ? cameraPosition.hashCode() : 0) * 31) + (this.debugActive ? 1 : 0)) * 31) + (this.compassEnabled ? 1 : 0)) * 31) + (this.fadeCompassFacingNorth ? 1 : 0)) * 31) + this.compassGravity) * 31;
        Drawable drawable = this.compassImage;
        int hashCode2 = ((((((((((((((((((hashCode + (drawable != null ? drawable.hashCode() : 0)) * 31) + this.compassImageResource) * 31) + Arrays.hashCode(this.compassMargins)) * 31) + (this.logoEnabled ? 1 : 0)) * 31) + this.logoGravity) * 31) + Arrays.hashCode(this.logoMargins)) * 31) + this.attributionTintColor) * 31) + (this.attributionEnabled ? 1 : 0)) * 31) + this.attributionGravity) * 31) + Arrays.hashCode(this.attributionMargins);
        long doubleToLongBits = Double.doubleToLongBits(this.minZoom);
        int i = (hashCode2 * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        long doubleToLongBits2 = Double.doubleToLongBits(this.maxZoom);
        int i2 = (i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(this.minPitch);
        int i3 = (i2 * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        long doubleToLongBits4 = Double.doubleToLongBits(this.maxPitch);
        int i4 = ((((((((((((((((i3 * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)))) * 31) + (this.rotateGesturesEnabled ? 1 : 0)) * 31) + (this.scrollGesturesEnabled ? 1 : 0)) * 31) + (this.horizontalScrollGesturesEnabled ? 1 : 0)) * 31) + (this.tiltGesturesEnabled ? 1 : 0)) * 31) + (this.zoomGesturesEnabled ? 1 : 0)) * 31) + (this.doubleTapGesturesEnabled ? 1 : 0)) * 31) + (this.quickZoomGesturesEnabled ? 1 : 0)) * 31;
        String str = this.apiBaseUri;
        int hashCode3 = (((((((((((((i4 + (str != null ? str.hashCode() : 0)) * 31) + (this.textureMode ? 1 : 0)) * 31) + (this.translucentTextureSurface ? 1 : 0)) * 31) + (this.prefetchesTiles ? 1 : 0)) * 31) + this.prefetchZoomDelta) * 31) + (this.zMediaOverlay ? 1 : 0)) * 31) + (this.localIdeographFontFamilyEnabled ? 1 : 0)) * 31;
        String str2 = this.localIdeographFontFamily;
        return ((((((((hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.glyphsRasterizationMode.ordinal()) * 31) + Arrays.hashCode(this.localIdeographFontFamilies)) * 31) + ((int) this.pixelRatio)) * 31) + (this.crossSourceCollisions ? 1 : 0);
    }
}