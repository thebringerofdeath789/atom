package org.apache.poi.hpsf.wellknown;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class PropertyIDMap extends HashMap<Long, String> {
    public static final int PID_APPNAME = 18;
    public static final int PID_AUTHOR = 4;
    public static final int PID_BYTECOUNT = 4;
    public static final int PID_CATEGORY = 2;
    public static final int PID_CHARCOUNT = 16;
    public static final int PID_CODEPAGE = 1;
    public static final int PID_COMMENTS = 6;
    public static final int PID_COMPANY = 15;
    public static final int PID_CREATE_DTM = 12;
    public static final int PID_DICTIONARY = 0;
    public static final int PID_DOCPARTS = 13;
    public static final int PID_EDITTIME = 10;
    public static final int PID_HEADINGPAIR = 12;
    public static final int PID_HIDDENCOUNT = 9;
    public static final int PID_KEYWORDS = 5;
    public static final int PID_LASTAUTHOR = 8;
    public static final int PID_LASTPRINTED = 11;
    public static final int PID_LASTSAVE_DTM = 13;
    public static final int PID_LINECOUNT = 5;
    public static final int PID_LINKSDIRTY = 16;
    public static final int PID_MANAGER = 14;
    public static final int PID_MAX = 16;
    public static final int PID_MMCLIPCOUNT = 10;
    public static final int PID_NOTECOUNT = 8;
    public static final int PID_PAGECOUNT = 14;
    public static final int PID_PARCOUNT = 6;
    public static final int PID_PRESFORMAT = 3;
    public static final int PID_REVNUMBER = 9;
    public static final int PID_SCALE = 11;
    public static final int PID_SECURITY = 19;
    public static final int PID_SLIDECOUNT = 7;
    public static final int PID_SUBJECT = 3;
    public static final int PID_TEMPLATE = 7;
    public static final int PID_THUMBNAIL = 17;
    public static final int PID_TITLE = 2;
    public static final int PID_WORDCOUNT = 15;
    private static PropertyIDMap documentSummaryInformationProperties;
    private static PropertyIDMap summaryInformationProperties;

    public PropertyIDMap(int i, float f) {
        super(i, f);
    }

    public PropertyIDMap(Map<Long, String> map) {
        super(map);
    }

    public Object put(long j, String str) {
        return put((PropertyIDMap) Long.valueOf(j), (Long) str);
    }

    public Object get(long j) {
        return get(Long.valueOf(j));
    }

    public static PropertyIDMap getSummaryInformationProperties() {
        if (summaryInformationProperties == null) {
            PropertyIDMap propertyIDMap = new PropertyIDMap(18, 1.0f);
            propertyIDMap.put(2L, "PID_TITLE");
            propertyIDMap.put(3L, "PID_SUBJECT");
            propertyIDMap.put(4L, "PID_AUTHOR");
            propertyIDMap.put(5L, "PID_KEYWORDS");
            propertyIDMap.put(6L, "PID_COMMENTS");
            propertyIDMap.put(7L, "PID_TEMPLATE");
            propertyIDMap.put(8L, "PID_LASTAUTHOR");
            propertyIDMap.put(9L, "PID_REVNUMBER");
            propertyIDMap.put(10L, "PID_EDITTIME");
            propertyIDMap.put(11L, "PID_LASTPRINTED");
            propertyIDMap.put(12L, "PID_CREATE_DTM");
            propertyIDMap.put(13L, "PID_LASTSAVE_DTM");
            propertyIDMap.put(14L, "PID_PAGECOUNT");
            propertyIDMap.put(15L, "PID_WORDCOUNT");
            propertyIDMap.put(16L, "PID_CHARCOUNT");
            propertyIDMap.put(17L, "PID_THUMBNAIL");
            propertyIDMap.put(18L, "PID_APPNAME");
            propertyIDMap.put(19L, "PID_SECURITY");
            summaryInformationProperties = new PropertyIDMap(Collections.unmodifiableMap(propertyIDMap));
        }
        return summaryInformationProperties;
    }

    public static PropertyIDMap getDocumentSummaryInformationProperties() {
        if (documentSummaryInformationProperties == null) {
            PropertyIDMap propertyIDMap = new PropertyIDMap(17, 1.0f);
            propertyIDMap.put(0L, "PID_DICTIONARY");
            propertyIDMap.put(1L, "PID_CODEPAGE");
            propertyIDMap.put(2L, "PID_CATEGORY");
            propertyIDMap.put(3L, "PID_PRESFORMAT");
            propertyIDMap.put(4L, "PID_BYTECOUNT");
            propertyIDMap.put(5L, "PID_LINECOUNT");
            propertyIDMap.put(6L, "PID_PARCOUNT");
            propertyIDMap.put(7L, "PID_SLIDECOUNT");
            propertyIDMap.put(8L, "PID_NOTECOUNT");
            propertyIDMap.put(9L, "PID_HIDDENCOUNT");
            propertyIDMap.put(10L, "PID_MMCLIPCOUNT");
            propertyIDMap.put(11L, "PID_SCALE");
            propertyIDMap.put(12L, "PID_HEADINGPAIR");
            propertyIDMap.put(13L, "PID_DOCPARTS");
            propertyIDMap.put(14L, "PID_MANAGER");
            propertyIDMap.put(15L, "PID_COMPANY");
            propertyIDMap.put(16L, "PID_LINKSDIRTY");
            documentSummaryInformationProperties = new PropertyIDMap(Collections.unmodifiableMap(propertyIDMap));
        }
        return documentSummaryInformationProperties;
    }

    public static void main(String[] strArr) {
        PropertyIDMap summaryInformationProperties2 = getSummaryInformationProperties();
        PropertyIDMap documentSummaryInformationProperties2 = getDocumentSummaryInformationProperties();
        System.out.println("s1: " + summaryInformationProperties2);
        System.out.println("s2: " + documentSummaryInformationProperties2);
    }
}
