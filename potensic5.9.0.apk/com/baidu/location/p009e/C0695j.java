package com.baidu.location.p009e;

import android.database.Cursor;
import android.database.MatrixCursor;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Poi;
import com.baidu.location.p010f.C0703a;
import com.baidu.location.p010f.C0704b;
import com.baidu.location.p010f.C0714l;
import com.baidu.location.p012h.C0720b;
import com.baidu.location.p012h.C0733o;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.BooleanUtils;

/* renamed from: com.baidu.location.e.j */
/* loaded from: classes.dex */
final class C0695j {

    /* renamed from: a */
    private static final String[] f966a = {"CoorType", "Time", "LocType", "Longitude", "Latitude", "Radius", "NetworkLocationType", "Country", "CountryCode", "Province", "City", "CityCode", "District", "Street", "StreetNumber", "PoiList", "LocationDescription"};

    /* renamed from: com.baidu.location.e.j$a */
    static final class a {

        /* renamed from: a */
        final String f967a;

        /* renamed from: b */
        final String f968b;

        /* renamed from: c */
        final boolean f969c;

        /* renamed from: d */
        final boolean f970d;

        /* renamed from: e */
        final boolean f971e;

        /* renamed from: f */
        final int f972f;

        /* renamed from: g */
        final BDLocation f973g;

        /* renamed from: h */
        final boolean f974h;

        /* renamed from: i */
        final LinkedHashMap<String, Integer> f975i;

        public a(String[] strArr) {
            boolean z;
            String str;
            String[] strArr2;
            int i = 8;
            if (strArr == null) {
                this.f967a = null;
                this.f968b = null;
                this.f975i = null;
                this.f969c = false;
                this.f970d = false;
                this.f971e = false;
                this.f973g = null;
                this.f974h = false;
                this.f972f = 8;
                return;
            }
            LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
            String str2 = null;
            String str3 = null;
            BDLocation bDLocation = null;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            for (int i2 = 0; i2 < strArr.length; i2 += 2) {
                try {
                    if (strArr[i2].equals("-loc")) {
                        str2 = strArr[i2 + 1];
                        try {
                            String[] split = str2.split("&");
                            int i3 = 0;
                            while (i3 < split.length) {
                                try {
                                    String str4 = str2;
                                    try {
                                        if (split[i3].startsWith("cl=")) {
                                            try {
                                                strArr2 = split;
                                                str3 = split[i3].substring(3);
                                            } catch (Exception unused) {
                                                str2 = str4;
                                                str = str2;
                                                z = false;
                                                this.f967a = str;
                                                this.f968b = str3;
                                                this.f975i = linkedHashMap;
                                                this.f969c = z;
                                                this.f970d = z3;
                                                this.f971e = z4;
                                                this.f972f = i;
                                                this.f973g = bDLocation;
                                                this.f974h = z5;
                                            }
                                        } else {
                                            if (split[i3].startsWith("wf=")) {
                                                String[] split2 = split[i3].substring(3).split("\\|");
                                                strArr2 = split;
                                                int i4 = 0;
                                                while (i4 < split2.length) {
                                                    String[] split3 = split2[i4].split(";");
                                                    String[] strArr3 = split2;
                                                    String str5 = str3;
                                                    if (split3.length >= 2) {
                                                        try {
                                                            linkedHashMap.put(split3[0], Integer.valueOf(split3[1]));
                                                        } catch (Exception unused2) {
                                                            str2 = str4;
                                                            str3 = str5;
                                                            str = str2;
                                                            z = false;
                                                            this.f967a = str;
                                                            this.f968b = str3;
                                                            this.f975i = linkedHashMap;
                                                            this.f969c = z;
                                                            this.f970d = z3;
                                                            this.f971e = z4;
                                                            this.f972f = i;
                                                            this.f973g = bDLocation;
                                                            this.f974h = z5;
                                                        }
                                                    }
                                                    i4++;
                                                    split2 = strArr3;
                                                    str3 = str5;
                                                }
                                            } else {
                                                strArr2 = split;
                                            }
                                            str3 = str3;
                                        }
                                        i3++;
                                        str2 = str4;
                                        split = strArr2;
                                    } catch (Exception unused3) {
                                    }
                                } catch (Exception unused4) {
                                }
                            }
                        } catch (Exception unused5) {
                        }
                    } else {
                        if (strArr[i2].equals("-com")) {
                            String[] split4 = strArr[i2 + 1].split(";");
                            if (split4.length > 0) {
                                BDLocation bDLocation2 = new BDLocation();
                                try {
                                    bDLocation2.setLatitude(Double.valueOf(split4[0]).doubleValue());
                                    bDLocation2.setLongitude(Double.valueOf(split4[1]).doubleValue());
                                    bDLocation2.setLocType(Integer.valueOf(split4[2]).intValue());
                                    bDLocation2.setNetworkLocationType(split4[3]);
                                    bDLocation = bDLocation2;
                                } catch (Exception unused6) {
                                    bDLocation = bDLocation2;
                                    str = str2;
                                    z = false;
                                    this.f967a = str;
                                    this.f968b = str3;
                                    this.f975i = linkedHashMap;
                                    this.f969c = z;
                                    this.f970d = z3;
                                    this.f971e = z4;
                                    this.f972f = i;
                                    this.f973g = bDLocation;
                                    this.f974h = z5;
                                }
                            } else {
                                continue;
                            }
                        } else if (strArr[i2].equals("-log")) {
                            if (strArr[i2 + 1].equals(BooleanUtils.TRUE)) {
                                z2 = true;
                            }
                        } else if (strArr[i2].equals("-rgc")) {
                            if (strArr[i2 + 1].equals(BooleanUtils.TRUE)) {
                                z4 = true;
                            }
                        } else if (strArr[i2].equals("-poi")) {
                            if (strArr[i2 + 1].equals(BooleanUtils.TRUE)) {
                                z3 = true;
                            }
                        } else if (strArr[i2].equals("-minap")) {
                            try {
                                i = Integer.valueOf(strArr[i2 + 1]).intValue();
                            } catch (Exception unused7) {
                            }
                        } else if (strArr[i2].equals("-des") && strArr[i2 + 1].equals(BooleanUtils.TRUE)) {
                            z5 = true;
                        }
                    }
                } catch (Exception unused8) {
                }
            }
            str = !z2 ? null : str2;
            z = true;
            this.f967a = str;
            this.f968b = str3;
            this.f975i = linkedHashMap;
            this.f969c = z;
            this.f970d = z3;
            this.f971e = z4;
            this.f972f = i;
            this.f973g = bDLocation;
            this.f974h = z5;
        }
    }

    /* renamed from: a */
    static Cursor m853a(BDLocation bDLocation) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(System.currentTimeMillis()));
        String[] strArr = f966a;
        MatrixCursor matrixCursor = new MatrixCursor(strArr);
        Object[] objArr = new Object[strArr.length];
        objArr[matrixCursor.getColumnIndex("CoorType")] = "gcj02";
        objArr[matrixCursor.getColumnIndex("Time")] = format;
        objArr[matrixCursor.getColumnIndex("LocType")] = Integer.valueOf(bDLocation.getLocType());
        objArr[matrixCursor.getColumnIndex("Longitude")] = Double.valueOf(bDLocation.getLongitude());
        objArr[matrixCursor.getColumnIndex("Latitude")] = Double.valueOf(bDLocation.getLatitude());
        objArr[matrixCursor.getColumnIndex("Radius")] = Float.valueOf(bDLocation.getRadius());
        objArr[matrixCursor.getColumnIndex("NetworkLocationType")] = bDLocation.getNetworkLocationType();
        Address address = bDLocation.getAddress();
        if (address != null) {
            str2 = address.country;
            str3 = address.countryCode;
            str4 = address.province;
            str5 = address.city;
            str6 = address.cityCode;
            str7 = address.district;
            str8 = address.street;
            str = address.streetNumber;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
        }
        objArr[matrixCursor.getColumnIndex("Country")] = str2;
        objArr[matrixCursor.getColumnIndex("CountryCode")] = str3;
        objArr[matrixCursor.getColumnIndex("Province")] = str4;
        objArr[matrixCursor.getColumnIndex("City")] = str5;
        objArr[matrixCursor.getColumnIndex("CityCode")] = str6;
        objArr[matrixCursor.getColumnIndex("District")] = str7;
        objArr[matrixCursor.getColumnIndex("Street")] = str8;
        objArr[matrixCursor.getColumnIndex("StreetNumber")] = str;
        List<Poi> poiList = bDLocation.getPoiList();
        if (poiList == null) {
            objArr[matrixCursor.getColumnIndex("PoiList")] = null;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < poiList.size(); i++) {
                Poi poi = poiList.get(i);
                stringBuffer.append(poi.getId()).append(";").append(poi.getName()).append(";").append(poi.getRank()).append(";|");
            }
            objArr[matrixCursor.getColumnIndex("PoiList")] = stringBuffer.toString();
        }
        objArr[matrixCursor.getColumnIndex("LocationDescription")] = bDLocation.getLocationDescribe();
        matrixCursor.addRow(objArr);
        return matrixCursor;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x01b4, code lost:
    
        if (r8.size() == 0) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01ad, code lost:
    
        if (r8.size() != 0) goto L88;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static com.baidu.location.BDLocation m854a(android.database.Cursor r28) {
        /*
            Method dump skipped, instructions count: 500
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p009e.C0695j.m854a(android.database.Cursor):com.baidu.location.BDLocation");
    }

    /* renamed from: a */
    static String m855a(BDLocation bDLocation, int i) {
        if (bDLocation == null || bDLocation.getLocType() == 67) {
            return String.format(Locale.CHINA, "&ofl=%s|%d", "1", Integer.valueOf(i));
        }
        String format = String.format(Locale.CHINA, "&ofl=%s|%d|%f|%f|%d", "1", Integer.valueOf(i), Double.valueOf(bDLocation.getLongitude()), Double.valueOf(bDLocation.getLatitude()), Integer.valueOf((int) bDLocation.getRadius()));
        if (bDLocation.getAddress() != null) {
            format = format + "&ofaddr=" + bDLocation.getAddress().address;
        }
        if (bDLocation.getPoiList() != null && bDLocation.getPoiList().size() > 0) {
            Poi poi = bDLocation.getPoiList().get(0);
            format = format + String.format(Locale.US, "&ofpoi=%s|%s", poi.getId(), poi.getName());
        }
        return C0720b.f1244e != null ? format + String.format(Locale.US, "&pack=%s&sdk=%.3f", C0720b.f1244e, Float.valueOf(9.401f)) : format;
    }

    /* renamed from: a */
    static String m856a(BDLocation bDLocation, BDLocation bDLocation2, a aVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(bDLocation2 == null ? "&ofcl=0" : String.format(Locale.US, "&ofcl=1|%f|%f|%d", Double.valueOf(bDLocation2.getLongitude()), Double.valueOf(bDLocation2.getLatitude()), Integer.valueOf((int) bDLocation2.getRadius())));
        stringBuffer.append(bDLocation == null ? "&ofwf=0" : String.format(Locale.US, "&ofwf=1|%f|%f|%d", Double.valueOf(bDLocation.getLongitude()), Double.valueOf(bDLocation.getLatitude()), Integer.valueOf((int) bDLocation.getRadius())));
        stringBuffer.append((aVar == null || !aVar.f971e) ? "&rgcn=0" : "&rgcn=1");
        stringBuffer.append((aVar == null || !aVar.f970d) ? "&poin=0" : "&poin=1");
        stringBuffer.append((aVar == null || !aVar.f974h) ? "&desc=0" : "&desc=1");
        if (aVar != null) {
            stringBuffer.append(String.format(Locale.US, "&aps=%d", Integer.valueOf(aVar.f972f)));
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    static String[] m857a(C0703a c0703a, C0714l c0714l, BDLocation bDLocation, String str, boolean z, int i) {
        ArrayList arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        if (c0703a != null) {
            stringBuffer.append(C0704b.m912a().m936c(c0703a));
        }
        if (c0714l != null) {
            stringBuffer.append(c0714l.m1038a(30));
        }
        if (stringBuffer.length() > 0) {
            if (str != null) {
                stringBuffer.append(str);
            }
            arrayList.add("-loc");
            arrayList.add(stringBuffer.toString());
        }
        if (bDLocation != null) {
            String format = String.format(Locale.US, "%f;%f;%d;%s", Double.valueOf(bDLocation.getLatitude()), Double.valueOf(bDLocation.getLongitude()), Integer.valueOf(bDLocation.getLocType()), bDLocation.getNetworkLocationType());
            arrayList.add("-com");
            arrayList.add(format);
        }
        if (z) {
            arrayList.add("-log");
            arrayList.add(BooleanUtils.TRUE);
        }
        if (C0733o.f1389e.equals(TtmlNode.COMBINE_ALL)) {
            arrayList.add("-rgc");
            arrayList.add(BooleanUtils.TRUE);
        }
        if (C0733o.f1393i) {
            arrayList.add("-poi");
            arrayList.add(BooleanUtils.TRUE);
        }
        if (C0733o.f1391g) {
            arrayList.add("-des");
            arrayList.add(BooleanUtils.TRUE);
        }
        arrayList.add("-minap");
        arrayList.add(Integer.toString(i));
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }
}