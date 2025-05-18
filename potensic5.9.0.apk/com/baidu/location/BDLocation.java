package com.baidu.location;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.location.Address;
import com.baidu.location.p012h.C0733o;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class BDLocation implements Parcelable {
    public static final String BDLOCATION_BD09LL_TO_GCJ02 = "bd09ll2gcj";
    public static final String BDLOCATION_BD09_TO_GCJ02 = "bd092gcj";
    public static final String BDLOCATION_COOR_TYPE_BD09LL = "bd09";
    public static final String BDLOCATION_COOR_TYPE_BD09MC = "bd09mc";
    public static final String BDLOCATION_COOR_TYPE_GCJ02 = "gcj02";
    public static final String BDLOCATION_COOR_TYPE_GCJ03 = "gcj03";
    public static final String BDLOCATION_COOR_TYPE_WGS84 = "wgs84";
    public static final String BDLOCATION_GCJ02_TO_BD09 = "bd09";
    public static final String BDLOCATION_GCJ02_TO_BD09LL = "bd09ll";
    public static final String BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU = "bd_beidou";
    public static final String BDLOCATION_GNSS_PROVIDER_FROM_SYSTEM = "system";
    public static final String BDLOCATION_WGS84_TO_GCJ02 = "gps2gcj";
    public static final Parcelable.Creator<BDLocation> CREATOR = new C0642a();
    public static final int GNSS_ACCURACY_BAD = 3;
    public static final int GNSS_ACCURACY_GOOD = 1;
    public static final int GNSS_ACCURACY_MID = 2;
    public static final int GNSS_ACCURACY_UNKNOWN = 0;
    public static final int GPS_ACCURACY_BAD = 3;
    public static final int GPS_ACCURACY_GOOD = 1;
    public static final int GPS_ACCURACY_MID = 2;
    public static final int GPS_ACCURACY_UNKNOWN = 0;
    public static final int GPS_RECTIFY_INDOOR = 1;
    public static final int GPS_RECTIFY_NONE = 0;
    public static final int GPS_RECTIFY_OUTDOOR = 2;
    public static final int INDOOR_LOCATION_NEARBY_SURPPORT_TRUE = 2;
    public static final int INDOOR_LOCATION_SOURCE_BLUETOOTH = 4;
    public static final int INDOOR_LOCATION_SOURCE_MAGNETIC = 2;
    public static final int INDOOR_LOCATION_SOURCE_SMALLCELLSTATION = 8;
    public static final int INDOOR_LOCATION_SOURCE_UNKNOWN = 0;
    public static final int INDOOR_LOCATION_SOURCE_WIFI = 1;
    public static final int INDOOR_LOCATION_SURPPORT_FALSE = 0;
    public static final int INDOOR_LOCATION_SURPPORT_TRUE = 1;
    public static final int INDOOR_NETWORK_STATE_HIGH = 2;
    public static final int INDOOR_NETWORK_STATE_LOW = 0;
    public static final int INDOOR_NETWORK_STATE_MIDDLE = 1;
    public static final int LOCATION_WHERE_IN_CN = 1;
    public static final int LOCATION_WHERE_OUT_CN = 0;
    public static final int LOCATION_WHERE_UNKNOW = 2;
    public static final int MOCK_GNSS_PROBABILITY_HIGH = 3;
    public static final int MOCK_GNSS_PROBABILITY_LOW = 1;
    public static final int MOCK_GNSS_PROBABILITY_MIDDLE = 2;
    public static final int MOCK_GNSS_PROBABILITY_UNKNOW = -1;
    public static final int MOCK_GNSS_PROBABILITY_ZERO = 0;
    public static final int MOCK_GPS_PROBABILITY_HIGH = 3;
    public static final int MOCK_GPS_PROBABILITY_LOW = 1;
    public static final int MOCK_GPS_PROBABILITY_MIDDLE = 2;
    public static final int MOCK_GPS_PROBABILITY_UNKNOW = -1;
    public static final int MOCK_GPS_PROBABILITY_ZERO = 0;
    public static final int OPERATORS_TYPE_MOBILE = 1;
    public static final int OPERATORS_TYPE_TELECOMU = 3;
    public static final int OPERATORS_TYPE_UNICOM = 2;
    public static final int OPERATORS_TYPE_UNKONW = 0;
    public static final int TYPE_BMS_HD_LOCATION = 602;
    public static final int TYPE_CLOSE_LOCATION_SERVICE_SWITCH_FAIL = 69;
    public static final int TYPE_HD_LOCATION = 601;
    public static final int TYPE_NO_PERMISSION_AND_CLOSE_SWITCH_FAIL = 71;
    public static final int TYPE_NO_PERMISSION_LOCATION_FAIL = 70;
    public static final int TypeCacheLocation = 65;
    public static final int TypeCoarseLocation = 160;
    public static final int TypeCriteriaException = 62;
    public static final int TypeGnssLocation = 61;
    public static final int TypeGpsLocation = 61;
    public static final int TypeNetWorkException = 63;
    public static final int TypeNetWorkLocation = 161;
    public static final int TypeNone = 0;
    public static final int TypeOffLineLocation = 66;
    public static final int TypeOffLineLocationFail = 67;
    public static final int TypeOffLineLocationNetworkFail = 68;
    public static final int TypeServerCheckKeyError = 505;
    public static final int TypeServerDecryptError = 162;
    public static final int TypeServerError = 167;
    public static final int USER_INDDOR_TRUE = 1;
    public static final int USER_INDOOR_FALSE = 0;
    public static final int USER_INDOOR_UNKNOW = -1;

    /* renamed from: A */
    private String f257A;

    /* renamed from: B */
    private String f258B;

    /* renamed from: C */
    private double f259C;

    /* renamed from: D */
    private boolean f260D;

    /* renamed from: E */
    private int f261E;

    /* renamed from: F */
    private int f262F;

    /* renamed from: G */
    private String f263G;

    /* renamed from: H */
    private int f264H;

    /* renamed from: I */
    private String f265I;

    /* renamed from: J */
    private int f266J;

    /* renamed from: K */
    private int f267K;

    /* renamed from: L */
    private int f268L;

    /* renamed from: M */
    private int f269M;

    /* renamed from: N */
    private String f270N;

    /* renamed from: O */
    private String f271O;

    /* renamed from: P */
    private String f272P;

    /* renamed from: Q */
    private int f273Q;

    /* renamed from: R */
    private List<Poi> f274R;

    /* renamed from: S */
    private String f275S;

    /* renamed from: T */
    private String f276T;

    /* renamed from: U */
    private String f277U;

    /* renamed from: V */
    private Bundle f278V;

    /* renamed from: W */
    private int f279W;

    /* renamed from: X */
    private int f280X;

    /* renamed from: Y */
    private long f281Y;

    /* renamed from: Z */
    private String f282Z;

    /* renamed from: a */
    private int f283a;

    /* renamed from: aa */
    private String f284aa;

    /* renamed from: ab */
    private double f285ab;

    /* renamed from: ac */
    private double f286ac;

    /* renamed from: ad */
    private boolean f287ad;

    /* renamed from: ae */
    private PoiRegion f288ae;

    /* renamed from: af */
    private float f289af;

    /* renamed from: ag */
    private double f290ag;

    /* renamed from: ah */
    private int f291ah;

    /* renamed from: ai */
    private int f292ai;

    /* renamed from: aj */
    private BDLocation f293aj;

    /* renamed from: ak */
    private Bundle f294ak;

    /* renamed from: al */
    private String f295al;

    /* renamed from: am */
    private long f296am;

    /* renamed from: b */
    private String f297b;

    /* renamed from: c */
    private double f298c;

    /* renamed from: d */
    private double f299d;

    /* renamed from: e */
    private boolean f300e;

    /* renamed from: f */
    private double f301f;

    /* renamed from: g */
    private boolean f302g;

    /* renamed from: h */
    private float f303h;

    /* renamed from: i */
    private boolean f304i;

    /* renamed from: j */
    private float f305j;

    /* renamed from: k */
    private String f306k;

    /* renamed from: l */
    private float f307l;

    /* renamed from: m */
    private int f308m;

    /* renamed from: n */
    private float f309n;

    /* renamed from: o */
    private boolean f310o;

    /* renamed from: p */
    private int f311p;

    /* renamed from: q */
    private float f312q;

    /* renamed from: r */
    private String f313r;

    /* renamed from: s */
    private boolean f314s;

    /* renamed from: t */
    private String f315t;

    /* renamed from: u */
    private String f316u;

    /* renamed from: v */
    private String f317v;

    /* renamed from: w */
    private String f318w;

    /* renamed from: x */
    private boolean f319x;

    /* renamed from: y */
    private Address f320y;

    /* renamed from: z */
    private String f321z;

    public BDLocation() {
        this.f283a = 0;
        this.f297b = null;
        this.f298c = Double.MIN_VALUE;
        this.f299d = Double.MIN_VALUE;
        this.f300e = false;
        this.f301f = Double.MIN_VALUE;
        this.f302g = false;
        this.f303h = 0.0f;
        this.f304i = false;
        this.f305j = 0.0f;
        this.f307l = 0.0f;
        this.f308m = -1;
        this.f309n = 0.0f;
        this.f310o = false;
        this.f311p = -1;
        this.f312q = -1.0f;
        this.f313r = null;
        this.f314s = false;
        this.f315t = null;
        this.f316u = null;
        this.f317v = null;
        this.f318w = null;
        this.f319x = false;
        this.f320y = new Address.Builder().build();
        this.f321z = null;
        this.f257A = null;
        this.f258B = null;
        this.f260D = false;
        this.f261E = 0;
        this.f262F = 1;
        this.f263G = null;
        this.f265I = "";
        this.f266J = -1;
        this.f267K = 0;
        this.f268L = 2;
        this.f269M = 0;
        this.f270N = null;
        this.f271O = null;
        this.f272P = null;
        this.f273Q = -1;
        this.f274R = null;
        this.f275S = null;
        this.f276T = null;
        this.f277U = null;
        this.f278V = new Bundle();
        this.f279W = 0;
        this.f280X = 0;
        this.f281Y = 0L;
        this.f282Z = null;
        this.f284aa = null;
        this.f285ab = Double.MIN_VALUE;
        this.f286ac = Double.MIN_VALUE;
        this.f287ad = false;
        this.f288ae = null;
        this.f289af = -1.0f;
        this.f290ag = -1.0d;
        this.f291ah = 0;
        this.f292ai = -1;
        this.f294ak = null;
        this.f295al = null;
        this.f296am = -1L;
    }

    private BDLocation(Parcel parcel) {
        this.f283a = 0;
        this.f297b = null;
        this.f298c = Double.MIN_VALUE;
        this.f299d = Double.MIN_VALUE;
        this.f300e = false;
        this.f301f = Double.MIN_VALUE;
        this.f302g = false;
        this.f303h = 0.0f;
        this.f304i = false;
        this.f305j = 0.0f;
        this.f307l = 0.0f;
        this.f308m = -1;
        this.f309n = 0.0f;
        this.f310o = false;
        this.f311p = -1;
        this.f312q = -1.0f;
        this.f313r = null;
        this.f314s = false;
        this.f315t = null;
        this.f316u = null;
        this.f317v = null;
        this.f318w = null;
        this.f319x = false;
        this.f320y = new Address.Builder().build();
        this.f321z = null;
        this.f257A = null;
        this.f258B = null;
        this.f260D = false;
        this.f261E = 0;
        this.f262F = 1;
        this.f263G = null;
        this.f265I = "";
        this.f266J = -1;
        this.f267K = 0;
        this.f268L = 2;
        this.f269M = 0;
        this.f270N = null;
        this.f271O = null;
        this.f272P = null;
        this.f273Q = -1;
        this.f274R = null;
        this.f275S = null;
        this.f276T = null;
        this.f277U = null;
        this.f278V = new Bundle();
        this.f279W = 0;
        this.f280X = 0;
        this.f281Y = 0L;
        this.f282Z = null;
        this.f284aa = null;
        this.f285ab = Double.MIN_VALUE;
        this.f286ac = Double.MIN_VALUE;
        this.f287ad = false;
        this.f288ae = null;
        this.f289af = -1.0f;
        this.f290ag = -1.0d;
        this.f291ah = 0;
        this.f292ai = -1;
        this.f294ak = null;
        this.f295al = null;
        this.f296am = -1L;
        this.f283a = parcel.readInt();
        this.f297b = parcel.readString();
        this.f296am = parcel.readLong();
        this.f298c = parcel.readDouble();
        this.f299d = parcel.readDouble();
        this.f301f = parcel.readDouble();
        this.f303h = parcel.readFloat();
        this.f305j = parcel.readFloat();
        this.f306k = parcel.readString();
        this.f307l = parcel.readFloat();
        this.f308m = parcel.readInt();
        this.f309n = parcel.readFloat();
        this.f311p = parcel.readInt();
        this.f312q = parcel.readFloat();
        this.f321z = parcel.readString();
        this.f261E = parcel.readInt();
        this.f257A = parcel.readString();
        this.f258B = parcel.readString();
        this.f259C = parcel.readDouble();
        this.f263G = parcel.readString();
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        String readString3 = parcel.readString();
        String readString4 = parcel.readString();
        String readString5 = parcel.readString();
        String readString6 = parcel.readString();
        parcel.readString();
        String readString7 = parcel.readString();
        String readString8 = parcel.readString();
        String readString9 = parcel.readString();
        this.f320y = new Address.Builder().country(readString7).countryCode(readString8).province(readString).city(readString2).cityCode(readString6).district(readString3).street(readString4).streetNumber(readString5).adcode(readString9).town(parcel.readString()).build();
        boolean[] zArr = new boolean[8];
        this.f264H = parcel.readInt();
        this.f265I = parcel.readString();
        this.f316u = parcel.readString();
        this.f317v = parcel.readString();
        this.f318w = parcel.readString();
        this.f262F = parcel.readInt();
        this.f275S = parcel.readString();
        this.f266J = parcel.readInt();
        this.f267K = parcel.readInt();
        this.f268L = parcel.readInt();
        this.f269M = parcel.readInt();
        this.f270N = parcel.readString();
        this.f271O = parcel.readString();
        this.f272P = parcel.readString();
        this.f273Q = parcel.readInt();
        this.f279W = parcel.readInt();
        this.f276T = parcel.readString();
        this.f280X = parcel.readInt();
        this.f277U = parcel.readString();
        this.f282Z = parcel.readString();
        this.f284aa = parcel.readString();
        this.f281Y = parcel.readLong();
        this.f285ab = parcel.readDouble();
        this.f286ac = parcel.readDouble();
        this.f289af = parcel.readFloat();
        this.f290ag = parcel.readDouble();
        this.f291ah = parcel.readInt();
        this.f292ai = parcel.readInt();
        this.f313r = parcel.readString();
        this.f295al = parcel.readString();
        try {
            this.f293aj = (BDLocation) parcel.readParcelable(BDLocation.class.getClassLoader());
        } catch (Exception e) {
            this.f293aj = null;
            e.printStackTrace();
        }
        try {
            parcel.readBooleanArray(zArr);
            this.f300e = zArr[0];
            this.f302g = zArr[1];
            this.f304i = zArr[2];
            this.f310o = zArr[3];
            this.f314s = zArr[4];
            this.f319x = zArr[5];
            this.f260D = zArr[6];
            this.f287ad = zArr[7];
        } catch (Exception unused) {
        }
        ArrayList arrayList = new ArrayList();
        try {
            parcel.readList(arrayList, Poi.class.getClassLoader());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (arrayList.size() == 0) {
            this.f274R = null;
        } else {
            this.f274R = arrayList;
        }
        try {
            this.f278V = parcel.readBundle();
        } catch (Exception e3) {
            e3.printStackTrace();
            this.f278V = new Bundle();
        }
        try {
            this.f294ak = parcel.readBundle();
        } catch (Exception e4) {
            e4.printStackTrace();
            this.f294ak = new Bundle();
        }
        try {
            this.f288ae = (PoiRegion) parcel.readParcelable(PoiRegion.class.getClassLoader());
        } catch (Exception e5) {
            this.f288ae = null;
            e5.printStackTrace();
        }
    }

    /* synthetic */ BDLocation(Parcel parcel, C0642a c0642a) {
        this(parcel);
    }

    public BDLocation(BDLocation bDLocation) {
        this.f283a = 0;
        ArrayList arrayList = null;
        this.f297b = null;
        this.f298c = Double.MIN_VALUE;
        this.f299d = Double.MIN_VALUE;
        this.f300e = false;
        this.f301f = Double.MIN_VALUE;
        this.f302g = false;
        this.f303h = 0.0f;
        this.f304i = false;
        this.f305j = 0.0f;
        this.f307l = 0.0f;
        this.f308m = -1;
        this.f309n = 0.0f;
        this.f310o = false;
        this.f311p = -1;
        this.f312q = -1.0f;
        this.f313r = null;
        this.f314s = false;
        this.f315t = null;
        this.f316u = null;
        this.f317v = null;
        this.f318w = null;
        this.f319x = false;
        this.f320y = new Address.Builder().build();
        this.f321z = null;
        this.f257A = null;
        this.f258B = null;
        this.f260D = false;
        this.f261E = 0;
        this.f262F = 1;
        this.f263G = null;
        this.f265I = "";
        this.f266J = -1;
        this.f267K = 0;
        this.f268L = 2;
        this.f269M = 0;
        this.f270N = null;
        this.f271O = null;
        this.f272P = null;
        this.f273Q = -1;
        this.f274R = null;
        this.f275S = null;
        this.f276T = null;
        this.f277U = null;
        this.f278V = new Bundle();
        this.f279W = 0;
        this.f280X = 0;
        this.f281Y = 0L;
        this.f282Z = null;
        this.f284aa = null;
        this.f285ab = Double.MIN_VALUE;
        this.f286ac = Double.MIN_VALUE;
        this.f287ad = false;
        this.f288ae = null;
        this.f289af = -1.0f;
        this.f290ag = -1.0d;
        this.f291ah = 0;
        this.f292ai = -1;
        this.f294ak = null;
        this.f295al = null;
        this.f296am = -1L;
        this.f283a = bDLocation.f283a;
        this.f297b = bDLocation.f297b;
        this.f296am = bDLocation.f296am;
        this.f298c = bDLocation.f298c;
        this.f299d = bDLocation.f299d;
        this.f300e = bDLocation.f300e;
        this.f301f = bDLocation.f301f;
        this.f302g = bDLocation.f302g;
        this.f303h = bDLocation.f303h;
        this.f304i = bDLocation.f304i;
        this.f305j = bDLocation.f305j;
        this.f306k = bDLocation.f306k;
        this.f307l = bDLocation.f307l;
        this.f308m = bDLocation.f308m;
        this.f309n = bDLocation.f309n;
        this.f310o = bDLocation.f310o;
        this.f311p = bDLocation.f311p;
        this.f312q = bDLocation.f312q;
        this.f313r = bDLocation.f313r;
        this.f314s = bDLocation.f314s;
        this.f315t = bDLocation.f315t;
        this.f319x = bDLocation.f319x;
        this.f320y = new Address.Builder().country(bDLocation.f320y.country).countryCode(bDLocation.f320y.countryCode).province(bDLocation.f320y.province).city(bDLocation.f320y.city).cityCode(bDLocation.f320y.cityCode).district(bDLocation.f320y.district).street(bDLocation.f320y.street).streetNumber(bDLocation.f320y.streetNumber).adcode(bDLocation.f320y.adcode).town(bDLocation.f320y.town).build();
        this.f321z = bDLocation.f321z;
        this.f257A = bDLocation.f257A;
        this.f258B = bDLocation.f258B;
        this.f259C = bDLocation.f259C;
        this.f262F = bDLocation.f262F;
        this.f261E = bDLocation.f261E;
        this.f260D = bDLocation.f260D;
        this.f263G = bDLocation.f263G;
        this.f264H = bDLocation.f264H;
        this.f265I = bDLocation.f265I;
        this.f316u = bDLocation.f316u;
        this.f317v = bDLocation.f317v;
        this.f318w = bDLocation.f318w;
        this.f266J = bDLocation.f266J;
        this.f267K = bDLocation.f267K;
        this.f268L = bDLocation.f267K;
        this.f269M = bDLocation.f269M;
        this.f270N = bDLocation.f270N;
        this.f271O = bDLocation.f271O;
        this.f272P = bDLocation.f272P;
        this.f273Q = bDLocation.f273Q;
        this.f279W = bDLocation.f279W;
        this.f277U = bDLocation.f277U;
        this.f282Z = bDLocation.f282Z;
        this.f284aa = bDLocation.f284aa;
        this.f285ab = bDLocation.f285ab;
        this.f286ac = bDLocation.f286ac;
        this.f281Y = bDLocation.f281Y;
        this.f290ag = bDLocation.f290ag;
        this.f291ah = bDLocation.f291ah;
        this.f292ai = bDLocation.f292ai;
        this.f293aj = bDLocation.f293aj;
        this.f276T = bDLocation.f276T;
        if (bDLocation.f274R != null) {
            arrayList = new ArrayList();
            for (int i = 0; i < bDLocation.f274R.size(); i++) {
                Poi poi = bDLocation.f274R.get(i);
                arrayList.add(new Poi(poi.getId(), poi.getName(), poi.getRank(), poi.getTags(), poi.getAddr()));
            }
        }
        this.f274R = arrayList;
        this.f275S = bDLocation.f275S;
        this.f278V = bDLocation.f278V;
        this.f280X = bDLocation.f280X;
        this.f287ad = bDLocation.f287ad;
        this.f288ae = bDLocation.f288ae;
        this.f289af = bDLocation.f289af;
        this.f294ak = bDLocation.f294ak;
        this.f295al = bDLocation.f295al;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x04ee A[Catch: Exception -> 0x018b, Error -> 0x079b, TryCatch #3 {Exception -> 0x018b, blocks: (B:12:0x00f2, B:14:0x014a, B:15:0x0153, B:21:0x017a, B:24:0x0181, B:27:0x0186, B:37:0x0195, B:39:0x01c4, B:40:0x01cb, B:42:0x01d1, B:43:0x01dc, B:45:0x01e2, B:46:0x01e9, B:48:0x01ef, B:49:0x01fa, B:52:0x0204, B:54:0x0212, B:56:0x021e, B:57:0x0221, B:58:0x0228, B:60:0x0230, B:61:0x0242, B:63:0x0248, B:65:0x0267, B:66:0x0273, B:68:0x0279, B:70:0x0282, B:75:0x028f, B:76:0x0291, B:78:0x0299, B:80:0x02a5, B:81:0x02a7, B:83:0x02af, B:85:0x02bd, B:86:0x02c5, B:88:0x02cd, B:89:0x02d5, B:91:0x02de, B:92:0x02e7, B:96:0x02ee, B:98:0x02f6, B:100:0x0302, B:101:0x0307, B:264:0x0319, B:266:0x0321, B:267:0x0329, B:269:0x0331, B:270:0x0339, B:272:0x0341, B:273:0x0349, B:275:0x0351, B:276:0x0359, B:278:0x0361, B:279:0x036d, B:281:0x0375, B:282:0x0380, B:284:0x0389, B:285:0x0395, B:287:0x039e, B:288:0x03aa, B:290:0x03b2, B:291:0x03ba, B:293:0x03c3, B:297:0x049d, B:109:0x04e6, B:111:0x04ee, B:113:0x04fc, B:114:0x04ff, B:116:0x0507, B:118:0x0513, B:119:0x051e, B:121:0x0526, B:123:0x0534, B:124:0x0537, B:126:0x053f, B:128:0x054d, B:129:0x0550, B:131:0x0558, B:133:0x0566, B:134:0x0569, B:136:0x0571, B:137:0x0579, B:139:0x0581, B:150:0x0596, B:153:0x059f, B:154:0x05a9, B:156:0x0681, B:158:0x0689, B:163:0x06ad, B:166:0x06b4, B:168:0x06bf, B:169:0x06c7, B:171:0x06cf, B:187:0x0705, B:188:0x0708, B:201:0x073e, B:256:0x067e, B:356:0x0486, B:108:0x04e3, B:410:0x0756, B:413:0x075b), top: B:10:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0507 A[Catch: Exception -> 0x018b, Error -> 0x079b, TryCatch #3 {Exception -> 0x018b, blocks: (B:12:0x00f2, B:14:0x014a, B:15:0x0153, B:21:0x017a, B:24:0x0181, B:27:0x0186, B:37:0x0195, B:39:0x01c4, B:40:0x01cb, B:42:0x01d1, B:43:0x01dc, B:45:0x01e2, B:46:0x01e9, B:48:0x01ef, B:49:0x01fa, B:52:0x0204, B:54:0x0212, B:56:0x021e, B:57:0x0221, B:58:0x0228, B:60:0x0230, B:61:0x0242, B:63:0x0248, B:65:0x0267, B:66:0x0273, B:68:0x0279, B:70:0x0282, B:75:0x028f, B:76:0x0291, B:78:0x0299, B:80:0x02a5, B:81:0x02a7, B:83:0x02af, B:85:0x02bd, B:86:0x02c5, B:88:0x02cd, B:89:0x02d5, B:91:0x02de, B:92:0x02e7, B:96:0x02ee, B:98:0x02f6, B:100:0x0302, B:101:0x0307, B:264:0x0319, B:266:0x0321, B:267:0x0329, B:269:0x0331, B:270:0x0339, B:272:0x0341, B:273:0x0349, B:275:0x0351, B:276:0x0359, B:278:0x0361, B:279:0x036d, B:281:0x0375, B:282:0x0380, B:284:0x0389, B:285:0x0395, B:287:0x039e, B:288:0x03aa, B:290:0x03b2, B:291:0x03ba, B:293:0x03c3, B:297:0x049d, B:109:0x04e6, B:111:0x04ee, B:113:0x04fc, B:114:0x04ff, B:116:0x0507, B:118:0x0513, B:119:0x051e, B:121:0x0526, B:123:0x0534, B:124:0x0537, B:126:0x053f, B:128:0x054d, B:129:0x0550, B:131:0x0558, B:133:0x0566, B:134:0x0569, B:136:0x0571, B:137:0x0579, B:139:0x0581, B:150:0x0596, B:153:0x059f, B:154:0x05a9, B:156:0x0681, B:158:0x0689, B:163:0x06ad, B:166:0x06b4, B:168:0x06bf, B:169:0x06c7, B:171:0x06cf, B:187:0x0705, B:188:0x0708, B:201:0x073e, B:256:0x067e, B:356:0x0486, B:108:0x04e3, B:410:0x0756, B:413:0x075b), top: B:10:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0526 A[Catch: Exception -> 0x018b, Error -> 0x079b, TryCatch #3 {Exception -> 0x018b, blocks: (B:12:0x00f2, B:14:0x014a, B:15:0x0153, B:21:0x017a, B:24:0x0181, B:27:0x0186, B:37:0x0195, B:39:0x01c4, B:40:0x01cb, B:42:0x01d1, B:43:0x01dc, B:45:0x01e2, B:46:0x01e9, B:48:0x01ef, B:49:0x01fa, B:52:0x0204, B:54:0x0212, B:56:0x021e, B:57:0x0221, B:58:0x0228, B:60:0x0230, B:61:0x0242, B:63:0x0248, B:65:0x0267, B:66:0x0273, B:68:0x0279, B:70:0x0282, B:75:0x028f, B:76:0x0291, B:78:0x0299, B:80:0x02a5, B:81:0x02a7, B:83:0x02af, B:85:0x02bd, B:86:0x02c5, B:88:0x02cd, B:89:0x02d5, B:91:0x02de, B:92:0x02e7, B:96:0x02ee, B:98:0x02f6, B:100:0x0302, B:101:0x0307, B:264:0x0319, B:266:0x0321, B:267:0x0329, B:269:0x0331, B:270:0x0339, B:272:0x0341, B:273:0x0349, B:275:0x0351, B:276:0x0359, B:278:0x0361, B:279:0x036d, B:281:0x0375, B:282:0x0380, B:284:0x0389, B:285:0x0395, B:287:0x039e, B:288:0x03aa, B:290:0x03b2, B:291:0x03ba, B:293:0x03c3, B:297:0x049d, B:109:0x04e6, B:111:0x04ee, B:113:0x04fc, B:114:0x04ff, B:116:0x0507, B:118:0x0513, B:119:0x051e, B:121:0x0526, B:123:0x0534, B:124:0x0537, B:126:0x053f, B:128:0x054d, B:129:0x0550, B:131:0x0558, B:133:0x0566, B:134:0x0569, B:136:0x0571, B:137:0x0579, B:139:0x0581, B:150:0x0596, B:153:0x059f, B:154:0x05a9, B:156:0x0681, B:158:0x0689, B:163:0x06ad, B:166:0x06b4, B:168:0x06bf, B:169:0x06c7, B:171:0x06cf, B:187:0x0705, B:188:0x0708, B:201:0x073e, B:256:0x067e, B:356:0x0486, B:108:0x04e3, B:410:0x0756, B:413:0x075b), top: B:10:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x053f A[Catch: Exception -> 0x018b, Error -> 0x079b, TryCatch #3 {Exception -> 0x018b, blocks: (B:12:0x00f2, B:14:0x014a, B:15:0x0153, B:21:0x017a, B:24:0x0181, B:27:0x0186, B:37:0x0195, B:39:0x01c4, B:40:0x01cb, B:42:0x01d1, B:43:0x01dc, B:45:0x01e2, B:46:0x01e9, B:48:0x01ef, B:49:0x01fa, B:52:0x0204, B:54:0x0212, B:56:0x021e, B:57:0x0221, B:58:0x0228, B:60:0x0230, B:61:0x0242, B:63:0x0248, B:65:0x0267, B:66:0x0273, B:68:0x0279, B:70:0x0282, B:75:0x028f, B:76:0x0291, B:78:0x0299, B:80:0x02a5, B:81:0x02a7, B:83:0x02af, B:85:0x02bd, B:86:0x02c5, B:88:0x02cd, B:89:0x02d5, B:91:0x02de, B:92:0x02e7, B:96:0x02ee, B:98:0x02f6, B:100:0x0302, B:101:0x0307, B:264:0x0319, B:266:0x0321, B:267:0x0329, B:269:0x0331, B:270:0x0339, B:272:0x0341, B:273:0x0349, B:275:0x0351, B:276:0x0359, B:278:0x0361, B:279:0x036d, B:281:0x0375, B:282:0x0380, B:284:0x0389, B:285:0x0395, B:287:0x039e, B:288:0x03aa, B:290:0x03b2, B:291:0x03ba, B:293:0x03c3, B:297:0x049d, B:109:0x04e6, B:111:0x04ee, B:113:0x04fc, B:114:0x04ff, B:116:0x0507, B:118:0x0513, B:119:0x051e, B:121:0x0526, B:123:0x0534, B:124:0x0537, B:126:0x053f, B:128:0x054d, B:129:0x0550, B:131:0x0558, B:133:0x0566, B:134:0x0569, B:136:0x0571, B:137:0x0579, B:139:0x0581, B:150:0x0596, B:153:0x059f, B:154:0x05a9, B:156:0x0681, B:158:0x0689, B:163:0x06ad, B:166:0x06b4, B:168:0x06bf, B:169:0x06c7, B:171:0x06cf, B:187:0x0705, B:188:0x0708, B:201:0x073e, B:256:0x067e, B:356:0x0486, B:108:0x04e3, B:410:0x0756, B:413:0x075b), top: B:10:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0558 A[Catch: Exception -> 0x018b, Error -> 0x079b, TryCatch #3 {Exception -> 0x018b, blocks: (B:12:0x00f2, B:14:0x014a, B:15:0x0153, B:21:0x017a, B:24:0x0181, B:27:0x0186, B:37:0x0195, B:39:0x01c4, B:40:0x01cb, B:42:0x01d1, B:43:0x01dc, B:45:0x01e2, B:46:0x01e9, B:48:0x01ef, B:49:0x01fa, B:52:0x0204, B:54:0x0212, B:56:0x021e, B:57:0x0221, B:58:0x0228, B:60:0x0230, B:61:0x0242, B:63:0x0248, B:65:0x0267, B:66:0x0273, B:68:0x0279, B:70:0x0282, B:75:0x028f, B:76:0x0291, B:78:0x0299, B:80:0x02a5, B:81:0x02a7, B:83:0x02af, B:85:0x02bd, B:86:0x02c5, B:88:0x02cd, B:89:0x02d5, B:91:0x02de, B:92:0x02e7, B:96:0x02ee, B:98:0x02f6, B:100:0x0302, B:101:0x0307, B:264:0x0319, B:266:0x0321, B:267:0x0329, B:269:0x0331, B:270:0x0339, B:272:0x0341, B:273:0x0349, B:275:0x0351, B:276:0x0359, B:278:0x0361, B:279:0x036d, B:281:0x0375, B:282:0x0380, B:284:0x0389, B:285:0x0395, B:287:0x039e, B:288:0x03aa, B:290:0x03b2, B:291:0x03ba, B:293:0x03c3, B:297:0x049d, B:109:0x04e6, B:111:0x04ee, B:113:0x04fc, B:114:0x04ff, B:116:0x0507, B:118:0x0513, B:119:0x051e, B:121:0x0526, B:123:0x0534, B:124:0x0537, B:126:0x053f, B:128:0x054d, B:129:0x0550, B:131:0x0558, B:133:0x0566, B:134:0x0569, B:136:0x0571, B:137:0x0579, B:139:0x0581, B:150:0x0596, B:153:0x059f, B:154:0x05a9, B:156:0x0681, B:158:0x0689, B:163:0x06ad, B:166:0x06b4, B:168:0x06bf, B:169:0x06c7, B:171:0x06cf, B:187:0x0705, B:188:0x0708, B:201:0x073e, B:256:0x067e, B:356:0x0486, B:108:0x04e3, B:410:0x0756, B:413:0x075b), top: B:10:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0571 A[Catch: Exception -> 0x018b, Error -> 0x079b, TryCatch #3 {Exception -> 0x018b, blocks: (B:12:0x00f2, B:14:0x014a, B:15:0x0153, B:21:0x017a, B:24:0x0181, B:27:0x0186, B:37:0x0195, B:39:0x01c4, B:40:0x01cb, B:42:0x01d1, B:43:0x01dc, B:45:0x01e2, B:46:0x01e9, B:48:0x01ef, B:49:0x01fa, B:52:0x0204, B:54:0x0212, B:56:0x021e, B:57:0x0221, B:58:0x0228, B:60:0x0230, B:61:0x0242, B:63:0x0248, B:65:0x0267, B:66:0x0273, B:68:0x0279, B:70:0x0282, B:75:0x028f, B:76:0x0291, B:78:0x0299, B:80:0x02a5, B:81:0x02a7, B:83:0x02af, B:85:0x02bd, B:86:0x02c5, B:88:0x02cd, B:89:0x02d5, B:91:0x02de, B:92:0x02e7, B:96:0x02ee, B:98:0x02f6, B:100:0x0302, B:101:0x0307, B:264:0x0319, B:266:0x0321, B:267:0x0329, B:269:0x0331, B:270:0x0339, B:272:0x0341, B:273:0x0349, B:275:0x0351, B:276:0x0359, B:278:0x0361, B:279:0x036d, B:281:0x0375, B:282:0x0380, B:284:0x0389, B:285:0x0395, B:287:0x039e, B:288:0x03aa, B:290:0x03b2, B:291:0x03ba, B:293:0x03c3, B:297:0x049d, B:109:0x04e6, B:111:0x04ee, B:113:0x04fc, B:114:0x04ff, B:116:0x0507, B:118:0x0513, B:119:0x051e, B:121:0x0526, B:123:0x0534, B:124:0x0537, B:126:0x053f, B:128:0x054d, B:129:0x0550, B:131:0x0558, B:133:0x0566, B:134:0x0569, B:136:0x0571, B:137:0x0579, B:139:0x0581, B:150:0x0596, B:153:0x059f, B:154:0x05a9, B:156:0x0681, B:158:0x0689, B:163:0x06ad, B:166:0x06b4, B:168:0x06bf, B:169:0x06c7, B:171:0x06cf, B:187:0x0705, B:188:0x0708, B:201:0x073e, B:256:0x067e, B:356:0x0486, B:108:0x04e3, B:410:0x0756, B:413:0x075b), top: B:10:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0581 A[Catch: Exception -> 0x018b, Error -> 0x079b, TRY_LEAVE, TryCatch #3 {Exception -> 0x018b, blocks: (B:12:0x00f2, B:14:0x014a, B:15:0x0153, B:21:0x017a, B:24:0x0181, B:27:0x0186, B:37:0x0195, B:39:0x01c4, B:40:0x01cb, B:42:0x01d1, B:43:0x01dc, B:45:0x01e2, B:46:0x01e9, B:48:0x01ef, B:49:0x01fa, B:52:0x0204, B:54:0x0212, B:56:0x021e, B:57:0x0221, B:58:0x0228, B:60:0x0230, B:61:0x0242, B:63:0x0248, B:65:0x0267, B:66:0x0273, B:68:0x0279, B:70:0x0282, B:75:0x028f, B:76:0x0291, B:78:0x0299, B:80:0x02a5, B:81:0x02a7, B:83:0x02af, B:85:0x02bd, B:86:0x02c5, B:88:0x02cd, B:89:0x02d5, B:91:0x02de, B:92:0x02e7, B:96:0x02ee, B:98:0x02f6, B:100:0x0302, B:101:0x0307, B:264:0x0319, B:266:0x0321, B:267:0x0329, B:269:0x0331, B:270:0x0339, B:272:0x0341, B:273:0x0349, B:275:0x0351, B:276:0x0359, B:278:0x0361, B:279:0x036d, B:281:0x0375, B:282:0x0380, B:284:0x0389, B:285:0x0395, B:287:0x039e, B:288:0x03aa, B:290:0x03b2, B:291:0x03ba, B:293:0x03c3, B:297:0x049d, B:109:0x04e6, B:111:0x04ee, B:113:0x04fc, B:114:0x04ff, B:116:0x0507, B:118:0x0513, B:119:0x051e, B:121:0x0526, B:123:0x0534, B:124:0x0537, B:126:0x053f, B:128:0x054d, B:129:0x0550, B:131:0x0558, B:133:0x0566, B:134:0x0569, B:136:0x0571, B:137:0x0579, B:139:0x0581, B:150:0x0596, B:153:0x059f, B:154:0x05a9, B:156:0x0681, B:158:0x0689, B:163:0x06ad, B:166:0x06b4, B:168:0x06bf, B:169:0x06c7, B:171:0x06cf, B:187:0x0705, B:188:0x0708, B:201:0x073e, B:256:0x067e, B:356:0x0486, B:108:0x04e3, B:410:0x0756, B:413:0x075b), top: B:10:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0689 A[Catch: Exception -> 0x018b, Error -> 0x079b, TRY_LEAVE, TryCatch #3 {Exception -> 0x018b, blocks: (B:12:0x00f2, B:14:0x014a, B:15:0x0153, B:21:0x017a, B:24:0x0181, B:27:0x0186, B:37:0x0195, B:39:0x01c4, B:40:0x01cb, B:42:0x01d1, B:43:0x01dc, B:45:0x01e2, B:46:0x01e9, B:48:0x01ef, B:49:0x01fa, B:52:0x0204, B:54:0x0212, B:56:0x021e, B:57:0x0221, B:58:0x0228, B:60:0x0230, B:61:0x0242, B:63:0x0248, B:65:0x0267, B:66:0x0273, B:68:0x0279, B:70:0x0282, B:75:0x028f, B:76:0x0291, B:78:0x0299, B:80:0x02a5, B:81:0x02a7, B:83:0x02af, B:85:0x02bd, B:86:0x02c5, B:88:0x02cd, B:89:0x02d5, B:91:0x02de, B:92:0x02e7, B:96:0x02ee, B:98:0x02f6, B:100:0x0302, B:101:0x0307, B:264:0x0319, B:266:0x0321, B:267:0x0329, B:269:0x0331, B:270:0x0339, B:272:0x0341, B:273:0x0349, B:275:0x0351, B:276:0x0359, B:278:0x0361, B:279:0x036d, B:281:0x0375, B:282:0x0380, B:284:0x0389, B:285:0x0395, B:287:0x039e, B:288:0x03aa, B:290:0x03b2, B:291:0x03ba, B:293:0x03c3, B:297:0x049d, B:109:0x04e6, B:111:0x04ee, B:113:0x04fc, B:114:0x04ff, B:116:0x0507, B:118:0x0513, B:119:0x051e, B:121:0x0526, B:123:0x0534, B:124:0x0537, B:126:0x053f, B:128:0x054d, B:129:0x0550, B:131:0x0558, B:133:0x0566, B:134:0x0569, B:136:0x0571, B:137:0x0579, B:139:0x0581, B:150:0x0596, B:153:0x059f, B:154:0x05a9, B:156:0x0681, B:158:0x0689, B:163:0x06ad, B:166:0x06b4, B:168:0x06bf, B:169:0x06c7, B:171:0x06cf, B:187:0x0705, B:188:0x0708, B:201:0x073e, B:256:0x067e, B:356:0x0486, B:108:0x04e3, B:410:0x0756, B:413:0x075b), top: B:10:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x069d A[Catch: Exception -> 0x06ad, Error -> 0x079b, TryCatch #2 {Exception -> 0x06ad, blocks: (B:160:0x0697, B:162:0x069d, B:204:0x06a9), top: B:159:0x0697 }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x06b1  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x06bf A[Catch: Exception -> 0x018b, Error -> 0x079b, TryCatch #3 {Exception -> 0x018b, blocks: (B:12:0x00f2, B:14:0x014a, B:15:0x0153, B:21:0x017a, B:24:0x0181, B:27:0x0186, B:37:0x0195, B:39:0x01c4, B:40:0x01cb, B:42:0x01d1, B:43:0x01dc, B:45:0x01e2, B:46:0x01e9, B:48:0x01ef, B:49:0x01fa, B:52:0x0204, B:54:0x0212, B:56:0x021e, B:57:0x0221, B:58:0x0228, B:60:0x0230, B:61:0x0242, B:63:0x0248, B:65:0x0267, B:66:0x0273, B:68:0x0279, B:70:0x0282, B:75:0x028f, B:76:0x0291, B:78:0x0299, B:80:0x02a5, B:81:0x02a7, B:83:0x02af, B:85:0x02bd, B:86:0x02c5, B:88:0x02cd, B:89:0x02d5, B:91:0x02de, B:92:0x02e7, B:96:0x02ee, B:98:0x02f6, B:100:0x0302, B:101:0x0307, B:264:0x0319, B:266:0x0321, B:267:0x0329, B:269:0x0331, B:270:0x0339, B:272:0x0341, B:273:0x0349, B:275:0x0351, B:276:0x0359, B:278:0x0361, B:279:0x036d, B:281:0x0375, B:282:0x0380, B:284:0x0389, B:285:0x0395, B:287:0x039e, B:288:0x03aa, B:290:0x03b2, B:291:0x03ba, B:293:0x03c3, B:297:0x049d, B:109:0x04e6, B:111:0x04ee, B:113:0x04fc, B:114:0x04ff, B:116:0x0507, B:118:0x0513, B:119:0x051e, B:121:0x0526, B:123:0x0534, B:124:0x0537, B:126:0x053f, B:128:0x054d, B:129:0x0550, B:131:0x0558, B:133:0x0566, B:134:0x0569, B:136:0x0571, B:137:0x0579, B:139:0x0581, B:150:0x0596, B:153:0x059f, B:154:0x05a9, B:156:0x0681, B:158:0x0689, B:163:0x06ad, B:166:0x06b4, B:168:0x06bf, B:169:0x06c7, B:171:0x06cf, B:187:0x0705, B:188:0x0708, B:201:0x073e, B:256:0x067e, B:356:0x0486, B:108:0x04e3, B:410:0x0756, B:413:0x075b), top: B:10:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x06cf A[Catch: Exception -> 0x018b, Error -> 0x079b, TRY_LEAVE, TryCatch #3 {Exception -> 0x018b, blocks: (B:12:0x00f2, B:14:0x014a, B:15:0x0153, B:21:0x017a, B:24:0x0181, B:27:0x0186, B:37:0x0195, B:39:0x01c4, B:40:0x01cb, B:42:0x01d1, B:43:0x01dc, B:45:0x01e2, B:46:0x01e9, B:48:0x01ef, B:49:0x01fa, B:52:0x0204, B:54:0x0212, B:56:0x021e, B:57:0x0221, B:58:0x0228, B:60:0x0230, B:61:0x0242, B:63:0x0248, B:65:0x0267, B:66:0x0273, B:68:0x0279, B:70:0x0282, B:75:0x028f, B:76:0x0291, B:78:0x0299, B:80:0x02a5, B:81:0x02a7, B:83:0x02af, B:85:0x02bd, B:86:0x02c5, B:88:0x02cd, B:89:0x02d5, B:91:0x02de, B:92:0x02e7, B:96:0x02ee, B:98:0x02f6, B:100:0x0302, B:101:0x0307, B:264:0x0319, B:266:0x0321, B:267:0x0329, B:269:0x0331, B:270:0x0339, B:272:0x0341, B:273:0x0349, B:275:0x0351, B:276:0x0359, B:278:0x0361, B:279:0x036d, B:281:0x0375, B:282:0x0380, B:284:0x0389, B:285:0x0395, B:287:0x039e, B:288:0x03aa, B:290:0x03b2, B:291:0x03ba, B:293:0x03c3, B:297:0x049d, B:109:0x04e6, B:111:0x04ee, B:113:0x04fc, B:114:0x04ff, B:116:0x0507, B:118:0x0513, B:119:0x051e, B:121:0x0526, B:123:0x0534, B:124:0x0537, B:126:0x053f, B:128:0x054d, B:129:0x0550, B:131:0x0558, B:133:0x0566, B:134:0x0569, B:136:0x0571, B:137:0x0579, B:139:0x0581, B:150:0x0596, B:153:0x059f, B:154:0x05a9, B:156:0x0681, B:158:0x0689, B:163:0x06ad, B:166:0x06b4, B:168:0x06bf, B:169:0x06c7, B:171:0x06cf, B:187:0x0705, B:188:0x0708, B:201:0x073e, B:256:0x067e, B:356:0x0486, B:108:0x04e3, B:410:0x0756, B:413:0x075b), top: B:10:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0700 A[Catch: all -> 0x0703, TRY_LEAVE, TryCatch #1 {all -> 0x0703, blocks: (B:175:0x06d9, B:177:0x06df, B:179:0x06e5, B:181:0x06e9, B:183:0x0700), top: B:174:0x06d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0710 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:203:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x06a9 A[Catch: Exception -> 0x06ad, Error -> 0x079b, TRY_LEAVE, TryCatch #2 {Exception -> 0x06ad, blocks: (B:160:0x0697, B:162:0x069d, B:204:0x06a9), top: B:159:0x0697 }] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0693  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x05b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:297:0x049d A[Catch: Exception -> 0x018b, Error -> 0x079b, TRY_LEAVE, TryCatch #3 {Exception -> 0x018b, blocks: (B:12:0x00f2, B:14:0x014a, B:15:0x0153, B:21:0x017a, B:24:0x0181, B:27:0x0186, B:37:0x0195, B:39:0x01c4, B:40:0x01cb, B:42:0x01d1, B:43:0x01dc, B:45:0x01e2, B:46:0x01e9, B:48:0x01ef, B:49:0x01fa, B:52:0x0204, B:54:0x0212, B:56:0x021e, B:57:0x0221, B:58:0x0228, B:60:0x0230, B:61:0x0242, B:63:0x0248, B:65:0x0267, B:66:0x0273, B:68:0x0279, B:70:0x0282, B:75:0x028f, B:76:0x0291, B:78:0x0299, B:80:0x02a5, B:81:0x02a7, B:83:0x02af, B:85:0x02bd, B:86:0x02c5, B:88:0x02cd, B:89:0x02d5, B:91:0x02de, B:92:0x02e7, B:96:0x02ee, B:98:0x02f6, B:100:0x0302, B:101:0x0307, B:264:0x0319, B:266:0x0321, B:267:0x0329, B:269:0x0331, B:270:0x0339, B:272:0x0341, B:273:0x0349, B:275:0x0351, B:276:0x0359, B:278:0x0361, B:279:0x036d, B:281:0x0375, B:282:0x0380, B:284:0x0389, B:285:0x0395, B:287:0x039e, B:288:0x03aa, B:290:0x03b2, B:291:0x03ba, B:293:0x03c3, B:297:0x049d, B:109:0x04e6, B:111:0x04ee, B:113:0x04fc, B:114:0x04ff, B:116:0x0507, B:118:0x0513, B:119:0x051e, B:121:0x0526, B:123:0x0534, B:124:0x0537, B:126:0x053f, B:128:0x054d, B:129:0x0550, B:131:0x0558, B:133:0x0566, B:134:0x0569, B:136:0x0571, B:137:0x0579, B:139:0x0581, B:150:0x0596, B:153:0x059f, B:154:0x05a9, B:156:0x0681, B:158:0x0689, B:163:0x06ad, B:166:0x06b4, B:168:0x06bf, B:169:0x06c7, B:171:0x06cf, B:187:0x0705, B:188:0x0708, B:201:0x073e, B:256:0x067e, B:356:0x0486, B:108:0x04e3, B:410:0x0756, B:413:0x075b), top: B:10:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:298:0x04d6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0230 A[Catch: Exception -> 0x018b, Error -> 0x079b, TryCatch #3 {Exception -> 0x018b, blocks: (B:12:0x00f2, B:14:0x014a, B:15:0x0153, B:21:0x017a, B:24:0x0181, B:27:0x0186, B:37:0x0195, B:39:0x01c4, B:40:0x01cb, B:42:0x01d1, B:43:0x01dc, B:45:0x01e2, B:46:0x01e9, B:48:0x01ef, B:49:0x01fa, B:52:0x0204, B:54:0x0212, B:56:0x021e, B:57:0x0221, B:58:0x0228, B:60:0x0230, B:61:0x0242, B:63:0x0248, B:65:0x0267, B:66:0x0273, B:68:0x0279, B:70:0x0282, B:75:0x028f, B:76:0x0291, B:78:0x0299, B:80:0x02a5, B:81:0x02a7, B:83:0x02af, B:85:0x02bd, B:86:0x02c5, B:88:0x02cd, B:89:0x02d5, B:91:0x02de, B:92:0x02e7, B:96:0x02ee, B:98:0x02f6, B:100:0x0302, B:101:0x0307, B:264:0x0319, B:266:0x0321, B:267:0x0329, B:269:0x0331, B:270:0x0339, B:272:0x0341, B:273:0x0349, B:275:0x0351, B:276:0x0359, B:278:0x0361, B:279:0x036d, B:281:0x0375, B:282:0x0380, B:284:0x0389, B:285:0x0395, B:287:0x039e, B:288:0x03aa, B:290:0x03b2, B:291:0x03ba, B:293:0x03c3, B:297:0x049d, B:109:0x04e6, B:111:0x04ee, B:113:0x04fc, B:114:0x04ff, B:116:0x0507, B:118:0x0513, B:119:0x051e, B:121:0x0526, B:123:0x0534, B:124:0x0537, B:126:0x053f, B:128:0x054d, B:129:0x0550, B:131:0x0558, B:133:0x0566, B:134:0x0569, B:136:0x0571, B:137:0x0579, B:139:0x0581, B:150:0x0596, B:153:0x059f, B:154:0x05a9, B:156:0x0681, B:158:0x0689, B:163:0x06ad, B:166:0x06b4, B:168:0x06bf, B:169:0x06c7, B:171:0x06cf, B:187:0x0705, B:188:0x0708, B:201:0x073e, B:256:0x067e, B:356:0x0486, B:108:0x04e3, B:410:0x0756, B:413:0x075b), top: B:10:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0299 A[Catch: Exception -> 0x018b, Error -> 0x079b, TryCatch #3 {Exception -> 0x018b, blocks: (B:12:0x00f2, B:14:0x014a, B:15:0x0153, B:21:0x017a, B:24:0x0181, B:27:0x0186, B:37:0x0195, B:39:0x01c4, B:40:0x01cb, B:42:0x01d1, B:43:0x01dc, B:45:0x01e2, B:46:0x01e9, B:48:0x01ef, B:49:0x01fa, B:52:0x0204, B:54:0x0212, B:56:0x021e, B:57:0x0221, B:58:0x0228, B:60:0x0230, B:61:0x0242, B:63:0x0248, B:65:0x0267, B:66:0x0273, B:68:0x0279, B:70:0x0282, B:75:0x028f, B:76:0x0291, B:78:0x0299, B:80:0x02a5, B:81:0x02a7, B:83:0x02af, B:85:0x02bd, B:86:0x02c5, B:88:0x02cd, B:89:0x02d5, B:91:0x02de, B:92:0x02e7, B:96:0x02ee, B:98:0x02f6, B:100:0x0302, B:101:0x0307, B:264:0x0319, B:266:0x0321, B:267:0x0329, B:269:0x0331, B:270:0x0339, B:272:0x0341, B:273:0x0349, B:275:0x0351, B:276:0x0359, B:278:0x0361, B:279:0x036d, B:281:0x0375, B:282:0x0380, B:284:0x0389, B:285:0x0395, B:287:0x039e, B:288:0x03aa, B:290:0x03b2, B:291:0x03ba, B:293:0x03c3, B:297:0x049d, B:109:0x04e6, B:111:0x04ee, B:113:0x04fc, B:114:0x04ff, B:116:0x0507, B:118:0x0513, B:119:0x051e, B:121:0x0526, B:123:0x0534, B:124:0x0537, B:126:0x053f, B:128:0x054d, B:129:0x0550, B:131:0x0558, B:133:0x0566, B:134:0x0569, B:136:0x0571, B:137:0x0579, B:139:0x0581, B:150:0x0596, B:153:0x059f, B:154:0x05a9, B:156:0x0681, B:158:0x0689, B:163:0x06ad, B:166:0x06b4, B:168:0x06bf, B:169:0x06c7, B:171:0x06cf, B:187:0x0705, B:188:0x0708, B:201:0x073e, B:256:0x067e, B:356:0x0486, B:108:0x04e3, B:410:0x0756, B:413:0x075b), top: B:10:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02af A[Catch: Exception -> 0x018b, Error -> 0x079b, TryCatch #3 {Exception -> 0x018b, blocks: (B:12:0x00f2, B:14:0x014a, B:15:0x0153, B:21:0x017a, B:24:0x0181, B:27:0x0186, B:37:0x0195, B:39:0x01c4, B:40:0x01cb, B:42:0x01d1, B:43:0x01dc, B:45:0x01e2, B:46:0x01e9, B:48:0x01ef, B:49:0x01fa, B:52:0x0204, B:54:0x0212, B:56:0x021e, B:57:0x0221, B:58:0x0228, B:60:0x0230, B:61:0x0242, B:63:0x0248, B:65:0x0267, B:66:0x0273, B:68:0x0279, B:70:0x0282, B:75:0x028f, B:76:0x0291, B:78:0x0299, B:80:0x02a5, B:81:0x02a7, B:83:0x02af, B:85:0x02bd, B:86:0x02c5, B:88:0x02cd, B:89:0x02d5, B:91:0x02de, B:92:0x02e7, B:96:0x02ee, B:98:0x02f6, B:100:0x0302, B:101:0x0307, B:264:0x0319, B:266:0x0321, B:267:0x0329, B:269:0x0331, B:270:0x0339, B:272:0x0341, B:273:0x0349, B:275:0x0351, B:276:0x0359, B:278:0x0361, B:279:0x036d, B:281:0x0375, B:282:0x0380, B:284:0x0389, B:285:0x0395, B:287:0x039e, B:288:0x03aa, B:290:0x03b2, B:291:0x03ba, B:293:0x03c3, B:297:0x049d, B:109:0x04e6, B:111:0x04ee, B:113:0x04fc, B:114:0x04ff, B:116:0x0507, B:118:0x0513, B:119:0x051e, B:121:0x0526, B:123:0x0534, B:124:0x0537, B:126:0x053f, B:128:0x054d, B:129:0x0550, B:131:0x0558, B:133:0x0566, B:134:0x0569, B:136:0x0571, B:137:0x0579, B:139:0x0581, B:150:0x0596, B:153:0x059f, B:154:0x05a9, B:156:0x0681, B:158:0x0689, B:163:0x06ad, B:166:0x06b4, B:168:0x06bf, B:169:0x06c7, B:171:0x06cf, B:187:0x0705, B:188:0x0708, B:201:0x073e, B:256:0x067e, B:356:0x0486, B:108:0x04e3, B:410:0x0756, B:413:0x075b), top: B:10:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02f6 A[Catch: Exception -> 0x018b, Error -> 0x079b, TryCatch #3 {Exception -> 0x018b, blocks: (B:12:0x00f2, B:14:0x014a, B:15:0x0153, B:21:0x017a, B:24:0x0181, B:27:0x0186, B:37:0x0195, B:39:0x01c4, B:40:0x01cb, B:42:0x01d1, B:43:0x01dc, B:45:0x01e2, B:46:0x01e9, B:48:0x01ef, B:49:0x01fa, B:52:0x0204, B:54:0x0212, B:56:0x021e, B:57:0x0221, B:58:0x0228, B:60:0x0230, B:61:0x0242, B:63:0x0248, B:65:0x0267, B:66:0x0273, B:68:0x0279, B:70:0x0282, B:75:0x028f, B:76:0x0291, B:78:0x0299, B:80:0x02a5, B:81:0x02a7, B:83:0x02af, B:85:0x02bd, B:86:0x02c5, B:88:0x02cd, B:89:0x02d5, B:91:0x02de, B:92:0x02e7, B:96:0x02ee, B:98:0x02f6, B:100:0x0302, B:101:0x0307, B:264:0x0319, B:266:0x0321, B:267:0x0329, B:269:0x0331, B:270:0x0339, B:272:0x0341, B:273:0x0349, B:275:0x0351, B:276:0x0359, B:278:0x0361, B:279:0x036d, B:281:0x0375, B:282:0x0380, B:284:0x0389, B:285:0x0395, B:287:0x039e, B:288:0x03aa, B:290:0x03b2, B:291:0x03ba, B:293:0x03c3, B:297:0x049d, B:109:0x04e6, B:111:0x04ee, B:113:0x04fc, B:114:0x04ff, B:116:0x0507, B:118:0x0513, B:119:0x051e, B:121:0x0526, B:123:0x0534, B:124:0x0537, B:126:0x053f, B:128:0x054d, B:129:0x0550, B:131:0x0558, B:133:0x0566, B:134:0x0569, B:136:0x0571, B:137:0x0579, B:139:0x0581, B:150:0x0596, B:153:0x059f, B:154:0x05a9, B:156:0x0681, B:158:0x0689, B:163:0x06ad, B:166:0x06b4, B:168:0x06bf, B:169:0x06c7, B:171:0x06cf, B:187:0x0705, B:188:0x0708, B:201:0x073e, B:256:0x067e, B:356:0x0486, B:108:0x04e3, B:410:0x0756, B:413:0x075b), top: B:10:0x00f0 }] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v5, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BDLocation(java.lang.String r26) {
        /*
            Method dump skipped, instructions count: 1965
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.BDLocation.<init>(java.lang.String):void");
    }

    /* renamed from: a */
    private void m221a(Boolean bool) {
        this.f319x = bool.booleanValue();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getAcc() {
        return this.f259C;
    }

    public String getAdCode() {
        return this.f320y.adcode;
    }

    public String getAddrStr() {
        return this.f320y.address;
    }

    public Address getAddress() {
        return this.f320y;
    }

    public double getAltitude() {
        return this.f301f;
    }

    public String getBuildingID() {
        return this.f257A;
    }

    public String getBuildingName() {
        return this.f258B;
    }

    public String getCity() {
        return this.f320y.city;
    }

    public String getCityCode() {
        return this.f320y.cityCode;
    }

    public String getCoorType() {
        return this.f313r;
    }

    public String getCountry() {
        return this.f320y.country;
    }

    public String getCountryCode() {
        return this.f320y.countryCode;
    }

    public long getDelayTime() {
        return this.f281Y;
    }

    @Deprecated
    public float getDerect() {
        return this.f312q;
    }

    public float getDirection() {
        return this.f312q;
    }

    public double getDisToRealLocation() {
        return this.f290ag;
    }

    public String getDistrict() {
        return this.f320y.district;
    }

    public Bundle getExtraInfo() {
        return this.f294ak;
    }

    public Location getExtraLocation(String str) {
        Bundle bundle = this.f278V;
        if (bundle == null) {
            return null;
        }
        Parcelable parcelable = bundle.getParcelable(str);
        if (parcelable instanceof Location) {
            return (Location) parcelable;
        }
        return null;
    }

    public String getFloor() {
        return this.f321z;
    }

    public double[] getFusionLocInfo(String str) {
        return this.f278V.getDoubleArray(str);
    }

    public int getGnssAccuracyStatus() {
        return this.f279W;
    }

    public float getGnssBiasProb() {
        return this.f289af;
    }

    public int getGnssCheckStatus() {
        return this.f280X;
    }

    public String getGnssProvider() {
        return this.f295al;
    }

    @Deprecated
    public int getGpsAccuracyStatus() {
        return this.f279W;
    }

    @Deprecated
    public float getGpsBiasProb() {
        return this.f289af;
    }

    @Deprecated
    public int getGpsCheckStatus() {
        return this.f280X;
    }

    public int getInOutStatus() {
        return this.f273Q;
    }

    public int getIndoorLocationSource() {
        return this.f269M;
    }

    public int getIndoorLocationSurpport() {
        return this.f267K;
    }

    public String getIndoorLocationSurpportBuidlingID() {
        return this.f271O;
    }

    public String getIndoorLocationSurpportBuidlingName() {
        return this.f270N;
    }

    public int getIndoorNetworkState() {
        return this.f268L;
    }

    public String getIndoorSurpportPolygon() {
        return this.f272P;
    }

    public double getLatitude() {
        return this.f298c;
    }

    public int getLocType() {
        return this.f283a;
    }

    public String getLocTypeDescription() {
        return this.f275S;
    }

    public String getLocationDescribe() {
        return this.f316u;
    }

    public String getLocationID() {
        return this.f276T;
    }

    public int getLocationWhere() {
        return this.f262F;
    }

    public double getLongitude() {
        return this.f299d;
    }

    public int getMockGnssProbability() {
        return this.f292ai;
    }

    public int getMockGnssStrategy() {
        return this.f291ah;
    }

    @Deprecated
    public int getMockGpsProbability() {
        return this.f292ai;
    }

    @Deprecated
    public int getMockGpsStrategy() {
        return this.f291ah;
    }

    public String getNetworkLocationType() {
        return this.f263G;
    }

    public double getNrlLat() {
        return this.f285ab;
    }

    public double getNrlLon() {
        return this.f286ac;
    }

    public String getNrlResult() {
        return this.f282Z;
    }

    public int getOperators() {
        return this.f264H;
    }

    public List<Poi> getPoiList() {
        return this.f274R;
    }

    public PoiRegion getPoiRegion() {
        return this.f288ae;
    }

    public String getProvince() {
        return this.f320y.province;
    }

    public float getRadius() {
        return this.f305j;
    }

    public BDLocation getReallLocation() {
        if (getMockGpsStrategy() > 0) {
            return this.f293aj;
        }
        return null;
    }

    public String getRetFields(String str) {
        return this.f278V.getString(str);
    }

    public String getRoadLocString() {
        return this.f277U;
    }

    public int getSatelliteNumber() {
        this.f310o = true;
        return this.f311p;
    }

    @Deprecated
    public String getSemaAptag() {
        return this.f316u;
    }

    public float getSpeed() {
        return this.f303h;
    }

    public String getStreet() {
        return this.f320y.street;
    }

    public String getStreetNumber() {
        return this.f320y.streetNumber;
    }

    public String getTime() {
        return this.f297b;
    }

    public long getTimeStamp() {
        return this.f296am;
    }

    public String getTown() {
        return this.f320y.town;
    }

    public String getTraffic() {
        return this.f306k;
    }

    public float getTrafficConfidence() {
        return this.f307l;
    }

    public float getTrafficSkipProb() {
        return this.f309n;
    }

    public int getUserIndoorState() {
        return this.f266J;
    }

    public String getVdrJsonString() {
        Bundle bundle = this.f278V;
        if (bundle == null || !bundle.containsKey("vdr")) {
            return null;
        }
        return this.f278V.getString("vdr");
    }

    public String getViaductResult() {
        return this.f284aa;
    }

    public boolean hasAddr() {
        return this.f314s;
    }

    public boolean hasAltitude() {
        return this.f300e;
    }

    public boolean hasRadius() {
        return this.f304i;
    }

    public boolean hasSateNumber() {
        return this.f310o;
    }

    public boolean hasSpeed() {
        return this.f302g;
    }

    public boolean isCellChangeFlag() {
        return this.f319x;
    }

    public boolean isInIndoorPark() {
        return this.f287ad;
    }

    public boolean isIndoorLocMode() {
        return this.f260D;
    }

    public boolean isNrlAvailable() {
        return (this.f286ac == Double.MIN_VALUE || this.f285ab == Double.MIN_VALUE) ? false : true;
    }

    public int isParkAvailable() {
        return this.f261E;
    }

    public int isTrafficStation() {
        return this.f308m;
    }

    public void setAcc(double d) {
        this.f259C = d;
    }

    public void setAddr(Address address) {
        if (address != null) {
            this.f320y = address;
            this.f314s = true;
        }
    }

    public void setAddrStr(String str) {
        this.f315t = str;
        this.f314s = str != null;
    }

    public void setAltitude(double d) {
        if (d < 9999.0d) {
            this.f301f = d;
            this.f300e = true;
        }
    }

    public void setBuildingID(String str) {
        this.f257A = str;
    }

    public void setBuildingName(String str) {
        this.f258B = str;
    }

    public void setCoorType(String str) {
        this.f313r = str;
    }

    public void setDelayTime(long j) {
        this.f281Y = j;
    }

    public void setDirection(float f) {
        this.f312q = f;
    }

    public void setDisToRealLocation(double d) {
        this.f290ag = d;
    }

    public void setExtraLocation(String str, Location location) {
        if (this.f278V == null) {
            this.f278V = new Bundle();
        }
        this.f278V.putParcelable(str, location);
    }

    public void setExtrainfo(Bundle bundle) {
        this.f294ak = bundle == null ? null : new Bundle(bundle);
    }

    public void setFloor(String str) {
        this.f321z = str;
    }

    public void setFusionLocInfo(String str, double[] dArr) {
        if (this.f278V == null) {
            this.f278V = new Bundle();
        }
        this.f278V.putDoubleArray(str, dArr);
    }

    public void setGnssAccuracyStatus(int i) {
        this.f279W = i;
    }

    public void setGnssBiasProb(float f) {
        this.f289af = f;
    }

    public void setGnssCheckStatus(int i) {
        this.f280X = i;
    }

    public void setGnssProvider(String str) {
        this.f295al = str;
    }

    @Deprecated
    public void setGpsAccuracyStatus(int i) {
        this.f279W = i;
    }

    @Deprecated
    public void setGpsBiasProb(float f) {
        this.f289af = f;
    }

    @Deprecated
    public void setGpsCheckStatus(int i) {
        this.f280X = i;
    }

    public void setInOutStatus(int i) {
        this.f273Q = i;
    }

    public void setIndoorLocMode(boolean z) {
        this.f260D = z;
    }

    public void setIndoorLocationSource(int i) {
        this.f269M = i;
    }

    public void setIndoorLocationSurpport(int i) {
        this.f267K = i;
    }

    public void setIndoorNetworkState(int i) {
        this.f268L = i;
    }

    public void setIndoorSurpportPolygon(String str) {
        this.f272P = str;
    }

    public void setIsInIndoorPark(boolean z) {
        this.f287ad = z;
    }

    public void setIsTrafficStation(int i) {
        this.f308m = i;
    }

    public void setLatitude(double d) {
        this.f298c = d;
    }

    public void setLocType(int i) {
        String str;
        this.f283a = i;
        if (i != 66) {
            if (i != 67) {
                if (i == 167) {
                    str = "NetWork location failed because baidu location service can not caculate the location!";
                } else if (i != 505) {
                    switch (i) {
                        case 61:
                            setLocTypeDescription("GPS location successful!");
                            setUserIndoorState(0);
                            setGnssProvider(BDLOCATION_GNSS_PROVIDER_FROM_SYSTEM);
                            return;
                        case 62:
                            str = "Location failed beacuse we can not get any loc information!";
                            break;
                        case 63:
                            break;
                        default:
                            switch (i) {
                                case 69:
                                    str = "Location failed because the location service switch is not on";
                                    break;
                                case 70:
                                    str = "Location failed because the location permission is not enabled";
                                    break;
                                case 71:
                                    str = "Location failed because the location service switch is not on and the location permission is not enabled";
                                    break;
                                default:
                                    switch (i) {
                                        case 160:
                                            str = "Coarse location successful";
                                            break;
                                        case 161:
                                            str = "NetWork location successful!";
                                            break;
                                        case 162:
                                            str = "NetWork location failed because baidu location service can not decrypt the request query, please check the so file !";
                                            break;
                                        default:
                                            str = "UnKnown!";
                                            break;
                                    }
                            }
                    }
                } else {
                    str = "NetWork location failed because baidu location service check the key is unlegal, please check the key in AndroidManifest.xml !";
                }
            }
            str = "Offline location failed, please check the net (wifi/cell)!";
        } else {
            str = "Offline location successful!";
        }
        setLocTypeDescription(str);
    }

    public void setLocTypeDescription(String str) {
        this.f275S = str;
    }

    public void setLocationDescribe(String str) {
        this.f316u = str;
    }

    public void setLocationID(String str) {
        this.f276T = str;
    }

    public void setLocationWhere(int i) {
        this.f262F = i;
    }

    public void setLongitude(double d) {
        this.f299d = d;
    }

    public void setMockGnssProbability(int i) {
        this.f292ai = i;
    }

    public void setMockGnssStrategy(int i) {
        this.f291ah = i;
    }

    @Deprecated
    public void setMockGpsProbability(int i) {
        this.f292ai = i;
    }

    @Deprecated
    public void setMockGpsStrategy(int i) {
        this.f291ah = i;
    }

    public void setNetworkLocationType(String str) {
        this.f263G = str;
    }

    public void setNrlData(String str) {
        this.f282Z = str;
    }

    public void setOperators(int i) {
        this.f264H = i;
    }

    public void setParkAvailable(int i) {
        this.f261E = i;
    }

    public void setPoiList(List<Poi> list) {
        this.f274R = list;
    }

    public void setPoiRegion(PoiRegion poiRegion) {
        this.f288ae = poiRegion;
    }

    public void setRadius(float f) {
        this.f305j = f;
        this.f304i = true;
    }

    public void setReallLocation(BDLocation bDLocation) {
        if (getMockGpsStrategy() > 0) {
            this.f293aj = bDLocation;
        }
    }

    public void setRetFields(String str, String str2) {
        if (this.f278V == null) {
            this.f278V = new Bundle();
        }
        this.f278V.putString(str, str2);
    }

    public void setRoadLocString(float f, float f2, String str, String str2) {
        String format = ((double) f) > 0.001d ? String.format("%.2f", Float.valueOf(f)) : "";
        String format2 = ((double) f2) > 0.001d ? String.format("%.2f", Float.valueOf(f2)) : "";
        if (this.f282Z != null) {
            this.f277U = String.format(Locale.US, "%s|%s,%s", this.f282Z, format, format2);
            if (this.f284aa != null) {
                this.f277U = String.format(Locale.US, "%s|%s", this.f277U, this.f284aa);
            }
        }
        if (str != null) {
            this.f277U = String.format(Locale.US, "%s|%s", this.f277U, str);
        }
        if (str2 != null) {
            this.f277U = String.format(Locale.US, "%s|%s", this.f277U, str2);
        }
    }

    public void setSatelliteNumber(int i) {
        this.f311p = i;
    }

    public void setSpeed(float f) {
        this.f303h = f;
        this.f302g = true;
    }

    public void setTime(String str) {
        this.f297b = str;
        setLocationID(C0733o.m1141a(str));
    }

    public void setTimeStamp(long j) {
        this.f296am = j;
    }

    public void setTraffic(String str) {
        this.f306k = str;
    }

    public void setTrafficConfidence(float f) {
        this.f307l = f;
    }

    public void setTrafficSkipProb(float f) {
        this.f309n = f;
    }

    public void setUserIndoorState(int i) {
        this.f266J = i;
    }

    public void setVdrJsonValue(String str) {
        if (this.f278V == null) {
            this.f278V = new Bundle();
        }
        this.f278V.putString("vdr", str);
    }

    public void setViaductData(String str) {
        this.f284aa = str;
    }

    public String toString() {
        return "&loctype=" + getLocType() + "&lat=" + getLatitude() + "&lon=" + getLongitude() + "&radius=" + getRadius() + "&biasprob=" + getGpsBiasProb() + "&extrainfo=" + getExtraInfo();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f283a);
        parcel.writeString(this.f297b);
        parcel.writeLong(this.f296am);
        parcel.writeDouble(this.f298c);
        parcel.writeDouble(this.f299d);
        parcel.writeDouble(this.f301f);
        parcel.writeFloat(this.f303h);
        parcel.writeFloat(this.f305j);
        parcel.writeString(this.f306k);
        parcel.writeFloat(this.f307l);
        parcel.writeInt(this.f308m);
        parcel.writeFloat(this.f309n);
        parcel.writeInt(this.f311p);
        parcel.writeFloat(this.f312q);
        parcel.writeString(this.f321z);
        parcel.writeInt(this.f261E);
        parcel.writeString(this.f257A);
        parcel.writeString(this.f258B);
        parcel.writeDouble(this.f259C);
        parcel.writeString(this.f263G);
        parcel.writeString(this.f320y.province);
        parcel.writeString(this.f320y.city);
        parcel.writeString(this.f320y.district);
        parcel.writeString(this.f320y.street);
        parcel.writeString(this.f320y.streetNumber);
        parcel.writeString(this.f320y.cityCode);
        parcel.writeString(this.f320y.address);
        parcel.writeString(this.f320y.country);
        parcel.writeString(this.f320y.countryCode);
        parcel.writeString(this.f320y.adcode);
        parcel.writeString(this.f320y.town);
        parcel.writeInt(this.f264H);
        parcel.writeString(this.f265I);
        parcel.writeString(this.f316u);
        parcel.writeString(this.f317v);
        parcel.writeString(this.f318w);
        parcel.writeInt(this.f262F);
        parcel.writeString(this.f275S);
        parcel.writeInt(this.f266J);
        parcel.writeInt(this.f267K);
        parcel.writeInt(this.f268L);
        parcel.writeInt(this.f269M);
        parcel.writeString(this.f270N);
        parcel.writeString(this.f271O);
        parcel.writeString(this.f272P);
        parcel.writeInt(this.f273Q);
        parcel.writeInt(this.f279W);
        parcel.writeString(this.f276T);
        parcel.writeInt(this.f280X);
        parcel.writeString(this.f277U);
        parcel.writeString(this.f282Z);
        parcel.writeString(this.f284aa);
        parcel.writeLong(this.f281Y);
        parcel.writeDouble(this.f285ab);
        parcel.writeDouble(this.f286ac);
        parcel.writeFloat(this.f289af);
        parcel.writeDouble(this.f290ag);
        parcel.writeInt(this.f291ah);
        parcel.writeInt(this.f292ai);
        parcel.writeString(this.f313r);
        parcel.writeString(this.f295al);
        parcel.writeParcelable(this.f293aj, i);
        parcel.writeBooleanArray(new boolean[]{this.f300e, this.f302g, this.f304i, this.f310o, this.f314s, this.f319x, this.f260D, this.f287ad});
        parcel.writeList(this.f274R);
        parcel.writeBundle(this.f278V);
        parcel.writeBundle(this.f294ak);
        parcel.writeParcelable(this.f288ae, i);
    }
}