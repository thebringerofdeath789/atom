package com.mapbox.api.directions.p022v5.utils;

import com.mapbox.api.directions.p022v5.models.Bearing;
import com.mapbox.geojson.Point;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ParseUtils {
    private static final String COMMA = ",";
    private static final String FALSE = "false";
    private static final String SEMICOLON = ";";
    private static final String TRUE = "true";
    private static final String UNLIMITED = "unlimited";
    private static final ValueParser<Integer> INTEGER_PARSER = new ValueParser<Integer>() { // from class: com.mapbox.api.directions.v5.utils.ParseUtils.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.mapbox.api.directions.v5.utils.ParseUtils.ValueParser
        public Integer parse(String str) {
            return Integer.valueOf(str);
        }
    };
    private static final ValueParser<String> STRING_PARSER = new ValueParser<String>() { // from class: com.mapbox.api.directions.v5.utils.ParseUtils.2
        @Override // com.mapbox.api.directions.v5.utils.ParseUtils.ValueParser
        public String parse(String str) {
            return str;
        }
    };
    private static final ValueParser<Point> POINT_PARSER = new ValueParser<Point>() { // from class: com.mapbox.api.directions.v5.utils.ParseUtils.3
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.mapbox.api.directions.v5.utils.ParseUtils.ValueParser
        public Point parse(String str) {
            String[] split = str.split(ParseUtils.COMMA);
            if (split.length != 2) {
                throw new RuntimeException("Point list should have exactly 2 values, longitude and latitude.");
            }
            return Point.fromLngLat(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
        }
    };
    private static final ValueParser<Double> DOUBLE_PARSER = new ValueParser<Double>() { // from class: com.mapbox.api.directions.v5.utils.ParseUtils.4
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.mapbox.api.directions.v5.utils.ParseUtils.ValueParser
        public Double parse(String str) {
            if (str.equals(ParseUtils.UNLIMITED)) {
                return Double.valueOf(Double.POSITIVE_INFINITY);
            }
            return Double.valueOf(str);
        }
    };
    private static final ValueParser<Boolean> BOOLEAN_PARSER = new ValueParser<Boolean>() { // from class: com.mapbox.api.directions.v5.utils.ParseUtils.5
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.mapbox.api.directions.v5.utils.ParseUtils.ValueParser
        public Boolean parse(String str) {
            if (str.equalsIgnoreCase("true")) {
                return true;
            }
            if (str.equalsIgnoreCase("false")) {
                return false;
            }
            throw new RuntimeException("Boolean value should be either true or false string but is " + str);
        }
    };
    private static final ValueParser<Bearing> BEARING_PARSER = new ValueParser<Bearing>() { // from class: com.mapbox.api.directions.v5.utils.ParseUtils.6
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.mapbox.api.directions.v5.utils.ParseUtils.ValueParser
        public Bearing parse(String str) {
            String[] split = str.split(ParseUtils.COMMA);
            return Bearing.builder().angle(Double.parseDouble(split[0])).degrees(Double.parseDouble(split[1])).build();
        }
    };

    private interface ValueParser<T> {
        T parse(String str);
    }

    private static <T> List<T> parseToList(String str, String str2, ValueParser<T> valueParser) {
        if (str2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str3 : str2.split(str, -1)) {
            if (str3.isEmpty()) {
                arrayList.add(null);
            } else {
                arrayList.add(valueParser.parse(str3));
            }
        }
        return arrayList;
    }

    public static List<Integer> parseToIntegers(String str) {
        return parseToList(SEMICOLON, str, INTEGER_PARSER);
    }

    public static List<String> parseToStrings(String str) {
        return parseToList(SEMICOLON, str, STRING_PARSER);
    }

    public static List<String> parseToStrings(String str, String str2) {
        return parseToList(str2, str, STRING_PARSER);
    }

    public static List<Point> parseToPoints(String str) {
        return parseToList(SEMICOLON, str, POINT_PARSER);
    }

    public static List<Double> parseToDoubles(String str) {
        return parseToList(SEMICOLON, str, DOUBLE_PARSER);
    }

    public static List<Bearing> parseBearings(String str) {
        return parseToList(SEMICOLON, str, BEARING_PARSER);
    }

    public static List<Boolean> parseToBooleans(String str) {
        return parseToList(SEMICOLON, str, BOOLEAN_PARSER);
    }
}