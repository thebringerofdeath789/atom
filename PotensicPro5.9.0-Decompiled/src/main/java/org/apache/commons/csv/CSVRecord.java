package org.apache.commons.csv;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;

/* loaded from: classes4.dex */
public final class CSVRecord implements Serializable, Iterable<String> {
    private static final long serialVersionUID = 1;
    private final long characterPosition;
    private final String comment;
    private final transient CSVParser parser;
    private final long recordNumber;
    private final String[] values;

    CSVRecord(CSVParser cSVParser, String[] strArr, String str, long j, long j2) {
        this.recordNumber = j;
        this.values = strArr == null ? Constants.EMPTY_STRING_ARRAY : strArr;
        this.parser = cSVParser;
        this.comment = str;
        this.characterPosition = j2;
    }

    public String get(Enum<?> r2) {
        return get(Objects.toString(r2, null));
    }

    public String get(int i) {
        return this.values[i];
    }

    public String get(String str) {
        Map<String, Integer> headerMapRaw = getHeaderMapRaw();
        if (headerMapRaw == null) {
            throw new IllegalStateException("No header mapping was specified, the record values can't be accessed by name");
        }
        Integer num = headerMapRaw.get(str);
        if (num == null) {
            throw new IllegalArgumentException(String.format("Mapping for %s not found, expected one of %s", str, headerMapRaw.keySet()));
        }
        try {
            return this.values[num.intValue()];
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new IllegalArgumentException(String.format("Index for header '%s' is %d but CSVRecord only has %d values!", str, num, Integer.valueOf(this.values.length)));
        }
    }

    public long getCharacterPosition() {
        return this.characterPosition;
    }

    public String getComment() {
        return this.comment;
    }

    private Map<String, Integer> getHeaderMapRaw() {
        CSVParser cSVParser = this.parser;
        if (cSVParser == null) {
            return null;
        }
        return cSVParser.getHeaderMapRaw();
    }

    public CSVParser getParser() {
        return this.parser;
    }

    public long getRecordNumber() {
        return this.recordNumber;
    }

    public boolean hasComment() {
        return this.comment != null;
    }

    public boolean isConsistent() {
        Map<String, Integer> headerMapRaw = getHeaderMapRaw();
        return headerMapRaw == null || headerMapRaw.size() == this.values.length;
    }

    public boolean isMapped(String str) {
        Map<String, Integer> headerMapRaw = getHeaderMapRaw();
        return headerMapRaw != null && headerMapRaw.containsKey(str);
    }

    public boolean isSet(int i) {
        return i >= 0 && i < this.values.length;
    }

    public boolean isSet(String str) {
        return isMapped(str) && getHeaderMapRaw().get(str).intValue() < this.values.length;
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return toList().iterator();
    }

    public <M extends Map<String, String>> M putIn(final M m) {
        if (getHeaderMapRaw() == null) {
            return m;
        }
        getHeaderMapRaw().entrySet().forEach(new Consumer() { // from class: org.apache.commons.csv.-$$Lambda$CSVRecord$9brPWoOrwiA9Xr8RstiTZXMdeEA
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                CSVRecord.this.lambda$putIn$0$CSVRecord(m, (Map.Entry) obj);
            }
        });
        return m;
    }

    public /* synthetic */ void lambda$putIn$0$CSVRecord(Map map, Map.Entry entry) {
        int intValue = ((Integer) entry.getValue()).intValue();
        if (intValue < this.values.length) {
            map.put(entry.getKey(), this.values[intValue]);
        }
    }

    public int size() {
        return this.values.length;
    }

    public Stream<String> stream() {
        return Stream.of((Object[]) this.values);
    }

    public List<String> toList() {
        return Arrays.asList(this.values);
    }

    public Map<String, String> toMap() {
        return putIn(new LinkedHashMap(this.values.length));
    }

    public String toString() {
        return "CSVRecord [comment='" + this.comment + "', recordNumber=" + this.recordNumber + ", values=" + Arrays.toString(this.values) + "]";
    }

    String[] values() {
        return this.values;
    }
}
