package com.mapbox.mapboxsdk.plugins.localization;

import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLngBounds;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.style.expressions.Expression;
import com.mapbox.mapboxsdk.style.layers.Layer;
import com.mapbox.mapboxsdk.style.layers.PropertyFactory;
import com.mapbox.mapboxsdk.style.layers.PropertyValue;
import com.mapbox.mapboxsdk.style.layers.SymbolLayer;
import com.mapbox.mapboxsdk.style.sources.Source;
import com.mapbox.mapboxsdk.style.sources.VectorSource;
import com.mapbox.mapboxsdk.style.types.Formatted;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import timber.log.Timber;

/* loaded from: classes3.dex */
public final class LocalizationPlugin {
    private static final String EXPRESSION_REGEX = "\\b(name|name_.{2,7})\\b";
    private static final String EXPRESSION_V8_REGEX_BASE = "\\[\"get\", \"name_en\"], \\[\"get\", \"name\"]";
    private static final String EXPRESSION_V8_REGEX_LOCALIZED = "\\[\"match\", \"(name|name_.{2,7})\", \"name_zh-Hant\", \\[\"coalesce\", \\[\"get\", \"name_zh-Hant\"], \\[\"get\", \"name_zh-Hans\"], \\[\"match\", \\[\"get\", \"name_script\"], \"Latin\", \\[\"get\", \"name\"], \\[\"get\", \"name_en\"]], \\[\"get\", \"name\"]], \\[\"coalesce\", \\[\"get\", \"(name|name_.{2,7})\"], \\[\"match\", \\[\"get\", \"name_script\"], \"Latin\", \\[\"get\", \"name\"], \\[\"get\", \"name_en\"]], \\[\"get\", \"name\"]]]";
    private static final String EXPRESSION_V8_TEMPLATE_BASE = "[\"get\", \"name_en\"], [\"get\", \"name\"]";
    private static final String EXPRESSION_V8_TEMPLATE_LOCALIZED = "[\"match\", \"%s\", \"name_zh-Hant\", [\"coalesce\", [\"get\", \"name_zh-Hant\"], [\"get\", \"name_zh-Hans\"], [\"match\", [\"get\", \"name_script\"], \"Latin\", [\"get\", \"name\"], [\"get\", \"name_en\"]], [\"get\", \"name\"]], [\"coalesce\", [\"get\", \"%s\"], [\"match\", [\"get\", \"name_script\"], \"Latin\", [\"get\", \"name\"], [\"get\", \"name_en\"]], [\"get\", \"name\"]]]";
    private static final String STEP_REGEX = "\\[\"zoom\"], ";
    private static final String STEP_TEMPLATE = "[\"zoom\"], \"\", ";
    private static final List<String> SUPPORTED_SOURCES;
    private MapLocale mapLocale;
    private final MapboxMap mapboxMap;
    private Style style;

    static {
        ArrayList arrayList = new ArrayList();
        SUPPORTED_SOURCES = arrayList;
        arrayList.add("mapbox.mapbox-streets-v6");
        arrayList.add("mapbox.mapbox-streets-v7");
        arrayList.add("mapbox.mapbox-streets-v8");
    }

    public LocalizationPlugin(MapView mapView, final MapboxMap mapboxMap, Style style) {
        this.mapboxMap = mapboxMap;
        this.style = style;
        if (!style.isFullyLoaded()) {
            throw new RuntimeException("The style has to be non-null and fully loaded.");
        }
        mapView.addOnDidFinishLoadingStyleListener(new MapView.OnDidFinishLoadingStyleListener() { // from class: com.mapbox.mapboxsdk.plugins.localization.LocalizationPlugin.1
            @Override // com.mapbox.mapboxsdk.maps.MapView.OnDidFinishLoadingStyleListener
            public void onDidFinishLoadingStyle() {
                mapboxMap.getStyle(new Style.OnStyleLoaded() { // from class: com.mapbox.mapboxsdk.plugins.localization.LocalizationPlugin.1.1
                    @Override // com.mapbox.mapboxsdk.maps.Style.OnStyleLoaded
                    public void onStyleLoaded(Style style2) {
                        LocalizationPlugin.this.style = style2;
                        if (LocalizationPlugin.this.mapLocale != null) {
                            LocalizationPlugin.this.setMapLanguage(LocalizationPlugin.this.mapLocale);
                        }
                    }
                });
            }
        });
    }

    private MapLocale getChineseMapLocale(MapLocale mapLocale, boolean z) {
        if (z) {
            return mapLocale.equals(MapLocale.CHINESE_HANS) ? mapLocale : MapLocale.CHINA;
        }
        return MapLocale.CHINA;
    }

    public void matchMapLanguageWithDeviceDefault() {
        setMapLanguage(Locale.getDefault(), false);
    }

    public void matchMapLanguageWithDeviceDefault(boolean z) {
        setMapLanguage(Locale.getDefault(), z);
    }

    public void setMapLanguage(String str) {
        setMapLanguage(new MapLocale(str));
    }

    public void setMapLanguage(Locale locale) {
        setMapLanguage(locale, false);
    }

    public void setMapLanguage(Locale locale, boolean z) {
        MapLocale mapLocale = MapLocale.getMapLocale(locale, z);
        if (mapLocale == null) {
            Timber.m2548d("Couldn't match Locale %s %s to a MapLocale", locale.toString(), locale.getDisplayName());
        } else {
            Timber.m2548d("Locale: %s, set MapLocale: %s", locale.toString(), mapLocale.getMapLanguage());
            setMapLanguage(mapLocale);
        }
    }

    public void setMapLanguage(MapLocale mapLocale) {
        this.mapLocale = mapLocale;
        if (this.style.isFullyLoaded()) {
            List<Layer> layers = this.style.getLayers();
            for (Source source : this.style.getSources()) {
                if (sourceIsFromMapbox(source)) {
                    boolean sourceIsStreetsV8 = sourceIsStreetsV8(source);
                    for (Layer layer : layers) {
                        if (layer instanceof SymbolLayer) {
                            PropertyValue<Formatted> textField = ((SymbolLayer) layer).getTextField();
                            if (textField.isExpression()) {
                                if (sourceIsStreetsV8) {
                                    convertExpressionV8(mapLocale, layer, textField);
                                } else {
                                    convertExpression(mapLocale, layer, textField, sourceIsStreetsV7(source));
                                }
                            }
                        }
                    }
                } else {
                    String url = source instanceof VectorSource ? ((VectorSource) source).getUrl() : null;
                    if (url == null) {
                        url = "not found";
                    }
                    Timber.m2548d("The %s (%s) source is not based on Mapbox Vector Tiles. Supported sources:\n %s", source.getId(), url, SUPPORTED_SOURCES);
                }
            }
        }
    }

    private void convertExpression(MapLocale mapLocale, Layer layer, PropertyValue<?> propertyValue, boolean z) {
        Expression expression = propertyValue.getExpression();
        if (expression != null) {
            if (mapLocale.getMapLanguage().startsWith(MapLocale.CHINESE)) {
                mapLocale = getChineseMapLocale(mapLocale, z);
                Timber.m2548d("reset mapLocale to: %s", mapLocale.getMapLanguage());
            }
            String replaceAll = expression.toString().replaceAll(EXPRESSION_REGEX, mapLocale.getMapLanguage());
            if (replaceAll.startsWith("[\"step") && expression.toArray().length % 2 == 0) {
                replaceAll = replaceAll.replaceAll(STEP_REGEX, STEP_TEMPLATE);
            }
            layer.setProperties(PropertyFactory.textField(Expression.raw(replaceAll)));
        }
    }

    private void convertExpressionV8(MapLocale mapLocale, Layer layer, PropertyValue<?> propertyValue) {
        Expression expression = propertyValue.getExpression();
        if (expression != null) {
            String replaceAll = expression.toString().replaceAll(EXPRESSION_V8_REGEX_LOCALIZED, EXPRESSION_V8_TEMPLATE_BASE);
            String mapLanguage = mapLocale.getMapLanguage();
            if (!mapLanguage.equals(MapLocale.ENGLISH)) {
                if (mapLanguage.equals(MapLocale.CHINESE)) {
                    mapLanguage = MapLocale.SIMPLIFIED_CHINESE;
                }
                replaceAll = replaceAll.replaceAll(EXPRESSION_V8_REGEX_BASE, String.format(Locale.US, EXPRESSION_V8_TEMPLATE_LOCALIZED, mapLanguage, mapLanguage));
            }
            layer.setProperties(PropertyFactory.textField(Expression.raw(replaceAll)));
        }
    }

    public void setCameraToLocaleCountry(int i) {
        setCameraToLocaleCountry(Locale.getDefault(), i);
    }

    public void setCameraToLocaleCountry(Locale locale, int i) {
        MapLocale mapLocale = MapLocale.getMapLocale(locale, false);
        if (mapLocale != null) {
            setCameraToLocaleCountry(mapLocale, i);
        } else {
            Timber.m2548d("Couldn't match Locale %s to a MapLocale", locale.getDisplayName());
        }
    }

    public void setCameraToLocaleCountry(MapLocale mapLocale, int i) {
        LatLngBounds countryBounds = mapLocale.getCountryBounds();
        Objects.requireNonNull(countryBounds, "Expected a LatLngBounds object but received null instead. Make sure your MapLocale instance also has a country bounding box defined.");
        this.mapboxMap.moveCamera(CameraUpdateFactory.newLatLngBounds(countryBounds, i));
    }

    private boolean sourceIsFromMapbox(Source source) {
        String url;
        if (!(source instanceof VectorSource) || (url = ((VectorSource) source).getUrl()) == null) {
            return false;
        }
        Iterator<String> it = SUPPORTED_SOURCES.iterator();
        while (it.hasNext()) {
            if (url.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean sourceIsStreetsV7(Source source) {
        String url;
        return (source instanceof VectorSource) && (url = ((VectorSource) source).getUrl()) != null && url.contains("mapbox.mapbox-streets-v7");
    }

    private boolean sourceIsStreetsV8(Source source) {
        String url;
        return (source instanceof VectorSource) && (url = ((VectorSource) source).getUrl()) != null && url.contains("mapbox.mapbox-streets-v8");
    }
}