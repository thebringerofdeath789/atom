package com.mapbox.mapboxsdk.plugins.annotation;

import com.alibaba.fastjson.parser.JSONLexer;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.style.expressions.Expression;
import com.mapbox.mapboxsdk.style.layers.PropertyFactory;
import com.mapbox.mapboxsdk.style.layers.PropertyValue;
import com.mapbox.mapboxsdk.style.layers.SymbolLayer;
import com.mapbox.mapboxsdk.style.sources.GeoJsonOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class SymbolManager extends AnnotationManager<SymbolLayer, Symbol, SymbolOptions, OnSymbolDragListener, OnSymbolClickListener, OnSymbolLongClickListener> {
    private static final String PROPERTY_ICON_ALLOW_OVERLAP = "icon-allow-overlap";
    private static final String PROPERTY_ICON_IGNORE_PLACEMENT = "icon-ignore-placement";
    private static final String PROPERTY_ICON_KEEP_UPRIGHT = "icon-keep-upright";
    private static final String PROPERTY_ICON_OPTIONAL = "icon-optional";
    private static final String PROPERTY_ICON_PADDING = "icon-padding";
    private static final String PROPERTY_ICON_PITCH_ALIGNMENT = "icon-pitch-alignment";
    private static final String PROPERTY_ICON_ROTATION_ALIGNMENT = "icon-rotation-alignment";
    private static final String PROPERTY_ICON_TEXT_FIT = "icon-text-fit";
    private static final String PROPERTY_ICON_TEXT_FIT_PADDING = "icon-text-fit-padding";
    private static final String PROPERTY_ICON_TRANSLATE = "icon-translate";
    private static final String PROPERTY_ICON_TRANSLATE_ANCHOR = "icon-translate-anchor";
    private static final String PROPERTY_SYMBOL_AVOID_EDGES = "symbol-avoid-edges";
    private static final String PROPERTY_SYMBOL_PLACEMENT = "symbol-placement";
    private static final String PROPERTY_SYMBOL_SPACING = "symbol-spacing";
    private static final String PROPERTY_TEXT_ALLOW_OVERLAP = "text-allow-overlap";
    private static final String PROPERTY_TEXT_IGNORE_PLACEMENT = "text-ignore-placement";
    private static final String PROPERTY_TEXT_KEEP_UPRIGHT = "text-keep-upright";
    private static final String PROPERTY_TEXT_LINE_HEIGHT = "text-line-height";
    private static final String PROPERTY_TEXT_MAX_ANGLE = "text-max-angle";
    private static final String PROPERTY_TEXT_OPTIONAL = "text-optional";
    private static final String PROPERTY_TEXT_PADDING = "text-padding";
    private static final String PROPERTY_TEXT_PITCH_ALIGNMENT = "text-pitch-alignment";
    private static final String PROPERTY_TEXT_ROTATION_ALIGNMENT = "text-rotation-alignment";
    private static final String PROPERTY_TEXT_TRANSLATE = "text-translate";
    private static final String PROPERTY_TEXT_TRANSLATE_ANCHOR = "text-translate-anchor";
    private static final String PROPERTY_TEXT_VARIABLE_ANCHOR = "text-variable-anchor";

    @Override // com.mapbox.mapboxsdk.plugins.annotation.AnnotationManager
    String getAnnotationIdKey() {
        return TtmlNode.ATTR_ID;
    }

    public SymbolManager(MapView mapView, MapboxMap mapboxMap, Style style) {
        this(mapView, mapboxMap, style, null, null);
    }

    public SymbolManager(MapView mapView, MapboxMap mapboxMap, Style style, String str) {
        this(mapView, mapboxMap, style, str, null);
    }

    public SymbolManager(MapView mapView, MapboxMap mapboxMap, Style style, String str, GeoJsonOptions geoJsonOptions) {
        this(mapView, mapboxMap, style, new SymbolElementProvider(), str, geoJsonOptions, DraggableAnnotationController.getInstance(mapView, mapboxMap));
    }

    SymbolManager(MapView mapView, MapboxMap mapboxMap, Style style, CoreElementProvider<SymbolLayer> coreElementProvider, String str, GeoJsonOptions geoJsonOptions, DraggableAnnotationController draggableAnnotationController) {
        super(mapView, mapboxMap, style, coreElementProvider, draggableAnnotationController, str, geoJsonOptions);
    }

    @Override // com.mapbox.mapboxsdk.plugins.annotation.AnnotationManager
    void initializeDataDrivenPropertyMap() {
        this.dataDrivenPropertyUsageMap.put("symbol-sort-key", false);
        this.dataDrivenPropertyUsageMap.put("icon-size", false);
        this.dataDrivenPropertyUsageMap.put("icon-image", false);
        this.dataDrivenPropertyUsageMap.put("icon-rotate", false);
        this.dataDrivenPropertyUsageMap.put("icon-offset", false);
        this.dataDrivenPropertyUsageMap.put("icon-anchor", false);
        this.dataDrivenPropertyUsageMap.put("text-field", false);
        this.dataDrivenPropertyUsageMap.put("text-font", false);
        this.dataDrivenPropertyUsageMap.put("text-size", false);
        this.dataDrivenPropertyUsageMap.put("text-max-width", false);
        this.dataDrivenPropertyUsageMap.put("text-letter-spacing", false);
        this.dataDrivenPropertyUsageMap.put("text-justify", false);
        this.dataDrivenPropertyUsageMap.put("text-radial-offset", false);
        this.dataDrivenPropertyUsageMap.put("text-anchor", false);
        this.dataDrivenPropertyUsageMap.put("text-rotate", false);
        this.dataDrivenPropertyUsageMap.put("text-transform", false);
        this.dataDrivenPropertyUsageMap.put("text-offset", false);
        this.dataDrivenPropertyUsageMap.put("icon-opacity", false);
        this.dataDrivenPropertyUsageMap.put("icon-color", false);
        this.dataDrivenPropertyUsageMap.put("icon-halo-color", false);
        this.dataDrivenPropertyUsageMap.put("icon-halo-width", false);
        this.dataDrivenPropertyUsageMap.put("icon-halo-blur", false);
        this.dataDrivenPropertyUsageMap.put("text-opacity", false);
        this.dataDrivenPropertyUsageMap.put("text-color", false);
        this.dataDrivenPropertyUsageMap.put("text-halo-color", false);
        this.dataDrivenPropertyUsageMap.put("text-halo-width", false);
        this.dataDrivenPropertyUsageMap.put("text-halo-blur", false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.mapbox.mapboxsdk.plugins.annotation.AnnotationManager
    protected void setDataDrivenPropertyIsUsed(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        str.hashCode();
        String str6 = "icon-halo-color";
        String str7 = "text-radial-offset";
        String str8 = "icon-rotate";
        switch (str.hashCode()) {
            case -2146810373:
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                if (str.equals(str3)) {
                    r24 = 0;
                    break;
                }
                break;
            case -2041493401:
                str2 = "icon-halo-width";
                str4 = "icon-color";
                str3 = "text-rotate";
                if (str.equals("icon-offset")) {
                    r24 = 1;
                    break;
                }
                break;
            case -1946894033:
                str2 = "icon-halo-width";
                str4 = "icon-color";
                r24 = str.equals(str8) ? (char) 2 : (char) 65535;
                str8 = str8;
                str3 = "text-rotate";
                break;
            case -1717422239:
                str2 = "icon-halo-width";
                str4 = "icon-color";
                r24 = str.equals(str7) ? (char) 3 : (char) 65535;
                str7 = str7;
                str3 = "text-rotate";
                break;
            case -1708933018:
                str2 = "icon-halo-width";
                str4 = "icon-color";
                r24 = str.equals(str6) ? (char) 4 : (char) 65535;
                str6 = str6;
                str3 = "text-rotate";
                break;
            case -1690648887:
                str5 = "icon-color";
                str2 = "icon-halo-width";
                if (str.equals(str2)) {
                    r24 = 5;
                }
                str4 = str5;
                str3 = "text-rotate";
                break;
            case -1600683761:
                str5 = "icon-color";
                r24 = str.equals(str5) ? (char) 6 : (char) 65535;
                str2 = "icon-halo-width";
                str4 = str5;
                str3 = "text-rotate";
                break;
            case -1595213049:
                if (str.equals("icon-image")) {
                    r24 = 7;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case -1436636971:
                if (str.equals("icon-size")) {
                    r24 = '\b';
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case -1336352187:
                if (str.equals("symbol-sort-key")) {
                    r24 = '\t';
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case -1262567732:
                if (str.equals("text-transform")) {
                    r24 = '\n';
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case -1084154641:
                if (str.equals("text-font")) {
                    r24 = 11;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case -1083772767:
                if (str.equals("text-size")) {
                    r24 = '\f';
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case -888013006:
                if (str.equals("text-halo-color")) {
                    r24 = '\r';
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case -886443260:
                if (str.equals("icon-halo-blur")) {
                    r24 = 14;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case -869728875:
                if (str.equals("text-halo-width")) {
                    r24 = 15;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case -483024021:
                if (str.equals("text-opacity")) {
                    r24 = 16;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case -465299984:
                if (str.equals("text-justify")) {
                    r24 = 17;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case 317300605:
                if (str.equals("text-max-width")) {
                    r24 = 18;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case 428355132:
                if (str.equals("text-letter-spacing")) {
                    r24 = 19;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case 525511352:
                if (str.equals("text-halo-blur")) {
                    r24 = 20;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case 748171971:
                if (str.equals("text-color")) {
                    r24 = 21;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case 750756954:
                if (str.equals("text-field")) {
                    r24 = 22;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case 1419415223:
                if (str.equals("icon-opacity")) {
                    r24 = 23;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case 1660037973:
                if (str.equals("text-anchor")) {
                    r24 = 24;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case 1859954313:
                if (str.equals("icon-anchor")) {
                    r24 = 25;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            case 2053557555:
                if (str.equals("text-offset")) {
                    r24 = JSONLexer.EOI;
                }
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
            default:
                str2 = "icon-halo-width";
                str3 = "text-rotate";
                str4 = "icon-color";
                break;
        }
        switch (r24) {
            case 0:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.textRotate(Expression.get(str3)));
                break;
            case 1:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.iconOffset(Expression.get("icon-offset")));
                break;
            case 2:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.iconRotate(Expression.get(str8)));
                break;
            case 3:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.textRadialOffset(Expression.get(str7)));
                break;
            case 4:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.iconHaloColor(Expression.get(str6)));
                break;
            case 5:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.iconHaloWidth(Expression.get(str2)));
                break;
            case 6:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.iconColor(Expression.get(str4)));
                break;
            case 7:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.iconImage(Expression.get("icon-image")));
                break;
            case '\b':
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.iconSize(Expression.get("icon-size")));
                break;
            case '\t':
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.symbolSortKey(Expression.get("symbol-sort-key")));
                break;
            case '\n':
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.textTransform(Expression.get("text-transform")));
                break;
            case 11:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.textFont(Expression.get("text-font")));
                break;
            case '\f':
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.textSize(Expression.get("text-size")));
                break;
            case '\r':
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.textHaloColor(Expression.get("text-halo-color")));
                break;
            case 14:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.iconHaloBlur(Expression.get("icon-halo-blur")));
                break;
            case 15:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.textHaloWidth(Expression.get("text-halo-width")));
                break;
            case 16:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.textOpacity(Expression.get("text-opacity")));
                break;
            case 17:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.textJustify(Expression.get("text-justify")));
                break;
            case 18:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.textMaxWidth(Expression.get("text-max-width")));
                break;
            case 19:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.textLetterSpacing(Expression.get("text-letter-spacing")));
                break;
            case 20:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.textHaloBlur(Expression.get("text-halo-blur")));
                break;
            case 21:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.textColor(Expression.get("text-color")));
                break;
            case 22:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.textField(Expression.get("text-field")));
                break;
            case 23:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.iconOpacity(Expression.get("icon-opacity")));
                break;
            case 24:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.textAnchor(Expression.get("text-anchor")));
                break;
            case 25:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.iconAnchor(Expression.get("icon-anchor")));
                break;
            case 26:
                ((SymbolLayer) this.layer).setProperties(PropertyFactory.textOffset(Expression.get("text-offset")));
                break;
        }
    }

    public List<Symbol> create(String str) {
        return create(FeatureCollection.fromJson(str));
    }

    public List<Symbol> create(FeatureCollection featureCollection) {
        List<Feature> features = featureCollection.features();
        ArrayList arrayList = new ArrayList();
        if (features != null) {
            Iterator<Feature> it = features.iterator();
            while (it.hasNext()) {
                SymbolOptions fromFeature = SymbolOptions.fromFeature(it.next());
                if (fromFeature != null) {
                    arrayList.add(fromFeature);
                }
            }
        }
        return create(arrayList);
    }

    public String getSymbolPlacement() {
        return ((SymbolLayer) this.layer).getSymbolPlacement().value;
    }

    public void setSymbolPlacement(String str) {
        PropertyValue<String> symbolPlacement = PropertyFactory.symbolPlacement(str);
        this.constantPropertyUsageMap.put(PROPERTY_SYMBOL_PLACEMENT, symbolPlacement);
        ((SymbolLayer) this.layer).setProperties(symbolPlacement);
    }

    public Float getSymbolSpacing() {
        return ((SymbolLayer) this.layer).getSymbolSpacing().value;
    }

    public void setSymbolSpacing(Float f) {
        PropertyValue<Float> symbolSpacing = PropertyFactory.symbolSpacing(f);
        this.constantPropertyUsageMap.put(PROPERTY_SYMBOL_SPACING, symbolSpacing);
        ((SymbolLayer) this.layer).setProperties(symbolSpacing);
    }

    public Boolean getSymbolAvoidEdges() {
        return ((SymbolLayer) this.layer).getSymbolAvoidEdges().value;
    }

    public void setSymbolAvoidEdges(Boolean bool) {
        PropertyValue<Boolean> symbolAvoidEdges = PropertyFactory.symbolAvoidEdges(bool);
        this.constantPropertyUsageMap.put(PROPERTY_SYMBOL_AVOID_EDGES, symbolAvoidEdges);
        ((SymbolLayer) this.layer).setProperties(symbolAvoidEdges);
    }

    public Boolean getIconAllowOverlap() {
        return ((SymbolLayer) this.layer).getIconAllowOverlap().value;
    }

    public void setIconAllowOverlap(Boolean bool) {
        PropertyValue<Boolean> iconAllowOverlap = PropertyFactory.iconAllowOverlap(bool);
        this.constantPropertyUsageMap.put(PROPERTY_ICON_ALLOW_OVERLAP, iconAllowOverlap);
        ((SymbolLayer) this.layer).setProperties(iconAllowOverlap);
    }

    public Boolean getIconIgnorePlacement() {
        return ((SymbolLayer) this.layer).getIconIgnorePlacement().value;
    }

    public void setIconIgnorePlacement(Boolean bool) {
        PropertyValue<Boolean> iconIgnorePlacement = PropertyFactory.iconIgnorePlacement(bool);
        this.constantPropertyUsageMap.put(PROPERTY_ICON_IGNORE_PLACEMENT, iconIgnorePlacement);
        ((SymbolLayer) this.layer).setProperties(iconIgnorePlacement);
    }

    public Boolean getIconOptional() {
        return ((SymbolLayer) this.layer).getIconOptional().value;
    }

    public void setIconOptional(Boolean bool) {
        PropertyValue<Boolean> iconOptional = PropertyFactory.iconOptional(bool);
        this.constantPropertyUsageMap.put(PROPERTY_ICON_OPTIONAL, iconOptional);
        ((SymbolLayer) this.layer).setProperties(iconOptional);
    }

    public String getIconRotationAlignment() {
        return ((SymbolLayer) this.layer).getIconRotationAlignment().value;
    }

    public void setIconRotationAlignment(String str) {
        PropertyValue<String> iconRotationAlignment = PropertyFactory.iconRotationAlignment(str);
        this.constantPropertyUsageMap.put(PROPERTY_ICON_ROTATION_ALIGNMENT, iconRotationAlignment);
        ((SymbolLayer) this.layer).setProperties(iconRotationAlignment);
    }

    public String getIconTextFit() {
        return ((SymbolLayer) this.layer).getIconTextFit().value;
    }

    public void setIconTextFit(String str) {
        PropertyValue<String> iconTextFit = PropertyFactory.iconTextFit(str);
        this.constantPropertyUsageMap.put(PROPERTY_ICON_TEXT_FIT, iconTextFit);
        ((SymbolLayer) this.layer).setProperties(iconTextFit);
    }

    public Float[] getIconTextFitPadding() {
        return ((SymbolLayer) this.layer).getIconTextFitPadding().value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setIconTextFitPadding(Float[] fArr) {
        PropertyValue<Float[]> iconTextFitPadding = PropertyFactory.iconTextFitPadding(fArr);
        this.constantPropertyUsageMap.put(PROPERTY_ICON_TEXT_FIT_PADDING, iconTextFitPadding);
        ((SymbolLayer) this.layer).setProperties(iconTextFitPadding);
    }

    public Float getIconPadding() {
        return ((SymbolLayer) this.layer).getIconPadding().value;
    }

    public void setIconPadding(Float f) {
        PropertyValue<Float> iconPadding = PropertyFactory.iconPadding(f);
        this.constantPropertyUsageMap.put(PROPERTY_ICON_PADDING, iconPadding);
        ((SymbolLayer) this.layer).setProperties(iconPadding);
    }

    public Boolean getIconKeepUpright() {
        return ((SymbolLayer) this.layer).getIconKeepUpright().value;
    }

    public void setIconKeepUpright(Boolean bool) {
        PropertyValue<Boolean> iconKeepUpright = PropertyFactory.iconKeepUpright(bool);
        this.constantPropertyUsageMap.put(PROPERTY_ICON_KEEP_UPRIGHT, iconKeepUpright);
        ((SymbolLayer) this.layer).setProperties(iconKeepUpright);
    }

    public String getIconPitchAlignment() {
        return ((SymbolLayer) this.layer).getIconPitchAlignment().value;
    }

    public void setIconPitchAlignment(String str) {
        PropertyValue<String> iconPitchAlignment = PropertyFactory.iconPitchAlignment(str);
        this.constantPropertyUsageMap.put(PROPERTY_ICON_PITCH_ALIGNMENT, iconPitchAlignment);
        ((SymbolLayer) this.layer).setProperties(iconPitchAlignment);
    }

    public String getTextPitchAlignment() {
        return ((SymbolLayer) this.layer).getTextPitchAlignment().value;
    }

    public void setTextPitchAlignment(String str) {
        PropertyValue<String> textPitchAlignment = PropertyFactory.textPitchAlignment(str);
        this.constantPropertyUsageMap.put(PROPERTY_TEXT_PITCH_ALIGNMENT, textPitchAlignment);
        ((SymbolLayer) this.layer).setProperties(textPitchAlignment);
    }

    public String getTextRotationAlignment() {
        return ((SymbolLayer) this.layer).getTextRotationAlignment().value;
    }

    public void setTextRotationAlignment(String str) {
        PropertyValue<String> textRotationAlignment = PropertyFactory.textRotationAlignment(str);
        this.constantPropertyUsageMap.put(PROPERTY_TEXT_ROTATION_ALIGNMENT, textRotationAlignment);
        ((SymbolLayer) this.layer).setProperties(textRotationAlignment);
    }

    public Float getTextLineHeight() {
        return ((SymbolLayer) this.layer).getTextLineHeight().value;
    }

    public void setTextLineHeight(Float f) {
        PropertyValue<Float> textLineHeight = PropertyFactory.textLineHeight(f);
        this.constantPropertyUsageMap.put(PROPERTY_TEXT_LINE_HEIGHT, textLineHeight);
        ((SymbolLayer) this.layer).setProperties(textLineHeight);
    }

    public String[] getTextVariableAnchor() {
        return ((SymbolLayer) this.layer).getTextVariableAnchor().value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTextVariableAnchor(String[] strArr) {
        PropertyValue<String[]> textVariableAnchor = PropertyFactory.textVariableAnchor(strArr);
        this.constantPropertyUsageMap.put(PROPERTY_TEXT_VARIABLE_ANCHOR, textVariableAnchor);
        ((SymbolLayer) this.layer).setProperties(textVariableAnchor);
    }

    public Float getTextMaxAngle() {
        return ((SymbolLayer) this.layer).getTextMaxAngle().value;
    }

    public void setTextMaxAngle(Float f) {
        PropertyValue<Float> textMaxAngle = PropertyFactory.textMaxAngle(f);
        this.constantPropertyUsageMap.put(PROPERTY_TEXT_MAX_ANGLE, textMaxAngle);
        ((SymbolLayer) this.layer).setProperties(textMaxAngle);
    }

    public Float getTextPadding() {
        return ((SymbolLayer) this.layer).getTextPadding().value;
    }

    public void setTextPadding(Float f) {
        PropertyValue<Float> textPadding = PropertyFactory.textPadding(f);
        this.constantPropertyUsageMap.put(PROPERTY_TEXT_PADDING, textPadding);
        ((SymbolLayer) this.layer).setProperties(textPadding);
    }

    public Boolean getTextKeepUpright() {
        return ((SymbolLayer) this.layer).getTextKeepUpright().value;
    }

    public void setTextKeepUpright(Boolean bool) {
        PropertyValue<Boolean> textKeepUpright = PropertyFactory.textKeepUpright(bool);
        this.constantPropertyUsageMap.put(PROPERTY_TEXT_KEEP_UPRIGHT, textKeepUpright);
        ((SymbolLayer) this.layer).setProperties(textKeepUpright);
    }

    public Boolean getTextAllowOverlap() {
        return ((SymbolLayer) this.layer).getTextAllowOverlap().value;
    }

    public void setTextAllowOverlap(Boolean bool) {
        PropertyValue<Boolean> textAllowOverlap = PropertyFactory.textAllowOverlap(bool);
        this.constantPropertyUsageMap.put(PROPERTY_TEXT_ALLOW_OVERLAP, textAllowOverlap);
        ((SymbolLayer) this.layer).setProperties(textAllowOverlap);
    }

    public Boolean getTextIgnorePlacement() {
        return ((SymbolLayer) this.layer).getTextIgnorePlacement().value;
    }

    public void setTextIgnorePlacement(Boolean bool) {
        PropertyValue<Boolean> textIgnorePlacement = PropertyFactory.textIgnorePlacement(bool);
        this.constantPropertyUsageMap.put(PROPERTY_TEXT_IGNORE_PLACEMENT, textIgnorePlacement);
        ((SymbolLayer) this.layer).setProperties(textIgnorePlacement);
    }

    public Boolean getTextOptional() {
        return ((SymbolLayer) this.layer).getTextOptional().value;
    }

    public void setTextOptional(Boolean bool) {
        PropertyValue<Boolean> textOptional = PropertyFactory.textOptional(bool);
        this.constantPropertyUsageMap.put(PROPERTY_TEXT_OPTIONAL, textOptional);
        ((SymbolLayer) this.layer).setProperties(textOptional);
    }

    public Float[] getIconTranslate() {
        return ((SymbolLayer) this.layer).getIconTranslate().value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setIconTranslate(Float[] fArr) {
        PropertyValue<Float[]> iconTranslate = PropertyFactory.iconTranslate(fArr);
        this.constantPropertyUsageMap.put(PROPERTY_ICON_TRANSLATE, iconTranslate);
        ((SymbolLayer) this.layer).setProperties(iconTranslate);
    }

    public String getIconTranslateAnchor() {
        return ((SymbolLayer) this.layer).getIconTranslateAnchor().value;
    }

    public void setIconTranslateAnchor(String str) {
        PropertyValue<String> iconTranslateAnchor = PropertyFactory.iconTranslateAnchor(str);
        this.constantPropertyUsageMap.put(PROPERTY_ICON_TRANSLATE_ANCHOR, iconTranslateAnchor);
        ((SymbolLayer) this.layer).setProperties(iconTranslateAnchor);
    }

    public Float[] getTextTranslate() {
        return ((SymbolLayer) this.layer).getTextTranslate().value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTextTranslate(Float[] fArr) {
        PropertyValue<Float[]> textTranslate = PropertyFactory.textTranslate(fArr);
        this.constantPropertyUsageMap.put(PROPERTY_TEXT_TRANSLATE, textTranslate);
        ((SymbolLayer) this.layer).setProperties(textTranslate);
    }

    public String getTextTranslateAnchor() {
        return ((SymbolLayer) this.layer).getTextTranslateAnchor().value;
    }

    public void setTextTranslateAnchor(String str) {
        PropertyValue<String> textTranslateAnchor = PropertyFactory.textTranslateAnchor(str);
        this.constantPropertyUsageMap.put(PROPERTY_TEXT_TRANSLATE_ANCHOR, textTranslateAnchor);
        ((SymbolLayer) this.layer).setProperties(textTranslateAnchor);
    }

    @Override // com.mapbox.mapboxsdk.plugins.annotation.AnnotationManager
    public void setFilter(Expression expression) {
        this.layerFilter = expression;
        ((SymbolLayer) this.layer).setFilter(this.layerFilter);
    }

    public Expression getFilter() {
        return ((SymbolLayer) this.layer).getFilter();
    }
}