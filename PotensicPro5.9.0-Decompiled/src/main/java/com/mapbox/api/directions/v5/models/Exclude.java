package com.mapbox.api.directions.v5.models;

import com.mapbox.api.directions.v5.DirectionsCriteria;
import com.mapbox.api.directions.v5.models.AutoValue_Exclude;
import com.mapbox.api.directions.v5.models.DirectionsJsonObject;
import com.mapbox.api.directions.v5.utils.ParseUtils;
import com.mapbox.geojson.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public abstract class Exclude extends DirectionsJsonObject {
    private static final Set<String> VALID_EXCLUDE_CRITERIA = new HashSet<String>() { // from class: com.mapbox.api.directions.v5.models.Exclude.1
        {
            add(DirectionsCriteria.EXCLUDE_FERRY);
            add(DirectionsCriteria.EXCLUDE_MOTORWAY);
            add(DirectionsCriteria.EXCLUDE_TOLL);
            add(DirectionsCriteria.EXCLUDE_TUNNEL);
            add(DirectionsCriteria.EXCLUDE_RESTRICTED);
            add(DirectionsCriteria.EXCLUDE_CASH_ONLY_TOLLS);
            add(DirectionsCriteria.EXCLUDE_UNPAVED);
        }
    };

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract Exclude build();

        public abstract Builder criteria(List<String> list);

        public abstract Builder points(List<Point> list);
    }

    public abstract List<String> criteria();

    public abstract List<Point> points();

    public static Builder builder() {
        return new AutoValue_Exclude.Builder();
    }

    static Exclude fromUrlQueryParameter(String str) {
        if (str == null || Objects.equals(str, "")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<String> parseToStrings = ParseUtils.parseToStrings(str, ",");
        if (parseToStrings != null) {
            for (String str2 : parseToStrings) {
                if (str2.startsWith("point(") && str2.endsWith(")")) {
                    Point parsePointOrNull = parsePointOrNull(str2);
                    if (parsePointOrNull != null) {
                        arrayList.add(parsePointOrNull);
                    }
                } else if (VALID_EXCLUDE_CRITERIA.contains(str2)) {
                    arrayList2.add(str2);
                }
            }
        }
        if (arrayList2.size() == 0) {
            arrayList2 = null;
        }
        if (arrayList.size() == 0) {
            arrayList = null;
        }
        if (arrayList2 == null && arrayList == null) {
            return null;
        }
        return builder().criteria(arrayList2).points(arrayList).build();
    }

    String toUrlQueryParameter() {
        if (points() == null && criteria() == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        appendPoints(sb);
        appendCriterias(sb);
        return sb.toString();
    }

    private void appendCriterias(StringBuilder sb) {
        if (criteria() != null) {
            for (String str : criteria()) {
                if (sb.length() != 0) {
                    sb.append(',');
                }
                sb.append(str);
            }
        }
    }

    private void appendPoints(StringBuilder sb) {
        if (points() != null) {
            for (Point point : points()) {
                if (sb.length() != 0) {
                    sb.append(",");
                }
                appendPoint(sb, point);
            }
        }
    }

    private static Point parsePointOrNull(String str) {
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            try {
                return Point.fromLngLat(Double.parseDouble(str.substring(6, indexOf)), Double.parseDouble(str.substring(indexOf + 1, str.length() - 1)));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    private void appendPoint(StringBuilder sb, Point point) {
        sb.append("point(").append(point.longitude()).append(' ').append(point.latitude()).append(PropertyUtils.MAPPED_DELIM2);
    }
}
