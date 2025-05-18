package com.mapbox.mapboxsdk.style.layers;

import com.google.gson.JsonArray;
import com.mapbox.mapboxsdk.MapStrictMode;
import com.mapbox.mapboxsdk.exceptions.ConversionException;
import com.mapbox.mapboxsdk.log.Logger;
import com.mapbox.mapboxsdk.style.expressions.Expression;
import com.mapbox.mapboxsdk.utils.ColorUtils;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class PropertyValue<T> {
    private static final String TAG = "Mbgl-PropertyValue";
    public final String name;
    public final T value;

    public PropertyValue(String str, T t) {
        this.name = str;
        this.value = t;
    }

    public boolean isNull() {
        return this.value == null;
    }

    public boolean isExpression() {
        if (!isNull()) {
            T t = this.value;
            if ((t instanceof JsonArray) || (t instanceof Expression)) {
                return true;
            }
        }
        return false;
    }

    public Expression getExpression() {
        if (isExpression()) {
            T t = this.value;
            return t instanceof JsonArray ? Expression.Converter.convert((JsonArray) t) : (Expression) t;
        }
        Logger.m1762w(TAG, String.format("%s not an expression, try PropertyValue#getValue()", this.name));
        return null;
    }

    public boolean isValue() {
        return (isNull() || isExpression()) ? false : true;
    }

    public T getValue() {
        if (isValue()) {
            return this.value;
        }
        Logger.m1762w(TAG, String.format("%s not a value, try PropertyValue#getExpression()", this.name));
        return null;
    }

    public Integer getColorInt() {
        if (isValue()) {
            T t = this.value;
            if (t instanceof String) {
                try {
                    return Integer.valueOf(ColorUtils.rgbaToColor((String) t));
                } catch (ConversionException e) {
                    Logger.m1756e(TAG, String.format("%s could not be converted to a Color int: %s", this.name, e.getMessage()));
                    MapStrictMode.strictModeViolation(e);
                    return null;
                }
            }
        }
        Logger.m1756e(TAG, String.format("%s is not a String value and can not be converted to a color it", this.name));
        return null;
    }

    public String toString() {
        return String.format("%s: %s", this.name, this.value);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PropertyValue propertyValue = (PropertyValue) obj;
        if (!this.name.equals(propertyValue.name)) {
            return false;
        }
        T t = this.value;
        if (t == null) {
            return propertyValue.value == null;
        }
        if (t instanceof Object[]) {
            return Arrays.deepEquals((Object[]) t, (Object[]) propertyValue.value);
        }
        return t.equals(propertyValue.value);
    }

    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        T t = this.value;
        return hashCode + (t != null ? t.hashCode() : 0);
    }
}