package com.mapbox.mapboxsdk.maps;

import android.graphics.Bitmap;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Icon;
import com.mapbox.mapboxsdk.annotations.IconFactory;
import com.mapbox.mapboxsdk.annotations.Marker;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
class IconManager {
    private int highestIconHeight;
    private int highestIconWidth;
    private final Map<Icon, Integer> iconMap = new HashMap();
    private NativeMap nativeMap;

    IconManager(NativeMap nativeMap) {
        this.nativeMap = nativeMap;
    }

    Icon loadIconForMarker(Marker marker) {
        Icon icon = marker.getIcon();
        if (icon == null) {
            icon = loadDefaultIconForMarker(marker);
        } else {
            updateHighestIconSize(icon);
        }
        addIcon(icon);
        return icon;
    }

    int getTopOffsetPixelsForIcon(Icon icon) {
        return (int) (this.nativeMap.getTopOffsetPixelsForAnnotationSymbol(icon.getId()) * this.nativeMap.getPixelRatio());
    }

    int getHighestIconWidth() {
        return this.highestIconWidth;
    }

    int getHighestIconHeight() {
        return this.highestIconHeight;
    }

    private Icon loadDefaultIconForMarker(Marker marker) {
        Icon defaultMarker = IconFactory.getInstance(Mapbox.getApplicationContext()).defaultMarker();
        Bitmap bitmap = defaultMarker.getBitmap();
        updateHighestIconSize(bitmap.getWidth(), bitmap.getHeight() / 2);
        marker.setIcon(defaultMarker);
        return defaultMarker;
    }

    private void addIcon(Icon icon) {
        addIcon(icon, true);
    }

    private void addIcon(Icon icon, boolean z) {
        if (!this.iconMap.keySet().contains(icon)) {
            this.iconMap.put(icon, 1);
            if (z) {
                loadIcon(icon);
                return;
            }
            return;
        }
        Map<Icon, Integer> map = this.iconMap;
        map.put(icon, Integer.valueOf(map.get(icon).intValue() + 1));
    }

    private void updateHighestIconSize(Icon icon) {
        updateHighestIconSize(icon.getBitmap());
    }

    private void updateHighestIconSize(Bitmap bitmap) {
        updateHighestIconSize(bitmap.getWidth(), bitmap.getHeight());
    }

    private void updateHighestIconSize(int i, int i2) {
        if (i > this.highestIconWidth) {
            this.highestIconWidth = i;
        }
        if (i2 > this.highestIconHeight) {
            this.highestIconHeight = i2;
        }
    }

    private void loadIcon(Icon icon) {
        Bitmap bitmap = icon.getBitmap();
        this.nativeMap.addAnnotationIcon(icon.getId(), bitmap.getWidth(), bitmap.getHeight(), icon.getScale(), icon.toBytes());
    }

    void reloadIcons() {
        Iterator<Icon> it = this.iconMap.keySet().iterator();
        while (it.hasNext()) {
            loadIcon(it.next());
        }
    }

    void ensureIconLoaded(Marker marker, MapboxMap mapboxMap) {
        Icon icon = marker.getIcon();
        if (icon == null) {
            icon = loadDefaultIconForMarker(marker);
        }
        addIcon(icon);
        setTopOffsetPixels(marker, mapboxMap, icon);
    }

    private void setTopOffsetPixels(Marker marker, MapboxMap mapboxMap, Icon icon) {
        Marker marker2 = marker.getId() != -1 ? (Marker) mapboxMap.getAnnotation(marker.getId()) : null;
        if (marker2 == null || marker2.getIcon() == null || marker2.getIcon() != marker.getIcon()) {
            marker.setTopOffsetPixels(getTopOffsetPixelsForIcon(icon));
        }
    }

    void iconCleanup(Icon icon) {
        if (this.iconMap.get(icon) != null) {
            Integer valueOf = Integer.valueOf(r0.intValue() - 1);
            if (valueOf.intValue() == 0) {
                remove(icon);
            } else {
                updateIconRefCounter(icon, valueOf.intValue());
            }
        }
    }

    private void remove(Icon icon) {
        this.nativeMap.removeAnnotationIcon(icon.getId());
        this.iconMap.remove(icon);
    }

    private void updateIconRefCounter(Icon icon, int i) {
        this.iconMap.put(icon, Integer.valueOf(i));
    }
}