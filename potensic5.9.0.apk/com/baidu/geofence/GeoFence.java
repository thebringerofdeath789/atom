package com.baidu.geofence;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.geofence.model.DPoint;
import com.baidu.geofence.model.DistrictItem;
import com.baidu.location.BDLocation;
import java.util.ArrayList;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* loaded from: classes.dex */
public class GeoFence implements Parcelable {
    public static final int ADDGEOFENCE_SUCCESS = 7;
    public static final String BUNDLE_KEY_CUSTOMID = "2";
    public static final String BUNDLE_KEY_FENCE = "5";
    public static final String BUNDLE_KEY_FENCEID = "1";
    public static final String BUNDLE_KEY_FENCESTATUS = "3";
    public static final String BUNDLE_KEY_LOCERRORCODE = "4";
    public static final Parcelable.Creator<GeoFence> CREATOR = new C0602a();
    public static final int ERROR_CODE_EXISTS = 14;
    public static final int ERROR_CODE_FAILURE_AUTH = 11;
    public static final int ERROR_CODE_FAILURE_CONNECTION = 9;
    public static final int ERROR_CODE_FAILURE_PARSER = 10;
    public static final int ERROR_CODE_INVALID_PARAMETER = 8;
    public static final int ERROR_CODE_UNKNOWN = 12;
    public static final int ERROR_NO_VALIDFENCE = 13;
    public static final int INIT_STATUS_IN = 24;
    public static final int INIT_STATUS_OUT = 25;
    public static final int STATUS_IN = 15;
    public static final int STATUS_LOCFAIL = 18;
    public static final int STATUS_OUT = 16;
    public static final int STATUS_STAYED = 17;
    public static final int STATUS_UNKNOWN = 19;
    public static final int TYPE_BDMAPPOI = 22;
    public static final int TYPE_DISTRICT = 23;
    public static final int TYPE_POLYGON = 21;
    public static final int TYPE_ROUND = 20;

    /* renamed from: a */
    private String f102a;

    /* renamed from: b */
    private String f103b;

    /* renamed from: c */
    private int f104c;

    /* renamed from: d */
    private DistrictItem f105d;

    /* renamed from: e */
    private PoiItem f106e;

    /* renamed from: f */
    private int f107f;

    /* renamed from: g */
    private boolean f108g;

    /* renamed from: h */
    private DPoint f109h;

    /* renamed from: i */
    private boolean f110i;

    /* renamed from: j */
    private BDLocation f111j;

    /* renamed from: k */
    private String f112k;

    /* renamed from: l */
    private float f113l;

    /* renamed from: m */
    private String f114m;

    /* renamed from: n */
    private String f115n;

    /* renamed from: o */
    private long f116o;

    /* renamed from: p */
    private long f117p;

    /* renamed from: q */
    private boolean f118q;

    /* renamed from: r */
    private boolean f119r;

    /* renamed from: s */
    private boolean f120s;

    /* renamed from: t */
    private ArrayList<DPoint> f121t;

    /* renamed from: u */
    private int f122u;

    /* renamed from: v */
    private int f123v;

    /* renamed from: w */
    private int f124w;

    /* renamed from: x */
    private int f125x;

    public GeoFence() {
        this.f107f = 19;
        this.f108g = false;
        this.f110i = true;
        this.f118q = false;
        this.f119r = false;
        this.f120s = false;
        this.f121t = null;
        this.f122u = 1;
        this.f123v = 1;
        this.f124w = 1;
        this.f125x = IjkMediaCodecInfo.RANK_LAST_CHANCE;
    }

    private GeoFence(Parcel parcel) {
        this.f107f = 19;
        this.f108g = false;
        this.f110i = true;
        this.f118q = false;
        this.f119r = false;
        this.f120s = false;
        this.f121t = null;
        this.f122u = 1;
        this.f123v = 1;
        this.f124w = 1;
        this.f125x = IjkMediaCodecInfo.RANK_LAST_CHANCE;
        this.f102a = parcel.readString();
        this.f103b = parcel.readString();
        this.f114m = parcel.readString();
        this.f104c = parcel.readInt();
        this.f107f = parcel.readInt();
        this.f112k = parcel.readString();
        this.f113l = parcel.readFloat();
        this.f115n = parcel.readString();
        this.f116o = parcel.readLong();
        this.f117p = parcel.readLong();
        ArrayList<DPoint> arrayList = new ArrayList<>();
        try {
            parcel.readList(arrayList, DPoint.class.getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (arrayList.size() == 0) {
            this.f121t = null;
        } else {
            this.f121t = arrayList;
        }
        try {
            this.f111j = (BDLocation) parcel.readParcelable(BDLocation.class.getClassLoader());
        } catch (Exception e2) {
            this.f111j = null;
            e2.printStackTrace();
        }
        try {
            this.f109h = (DPoint) parcel.readParcelable(DPoint.class.getClassLoader());
        } catch (Exception e3) {
            this.f109h = null;
            e3.printStackTrace();
        }
        try {
            this.f106e = (PoiItem) parcel.readParcelable(PoiItem.class.getClassLoader());
        } catch (Exception e4) {
            this.f106e = null;
            e4.printStackTrace();
        }
        try {
            this.f105d = (DistrictItem) parcel.readParcelable(DistrictItem.class.getClassLoader());
        } catch (Exception e5) {
            this.f105d = null;
            e5.printStackTrace();
        }
        this.f122u = parcel.readInt();
        this.f123v = parcel.readInt();
        this.f124w = parcel.readInt();
        boolean[] zArr = new boolean[5];
        try {
            parcel.readBooleanArray(zArr);
            this.f110i = zArr[0];
            this.f108g = zArr[1];
            this.f118q = zArr[2];
            this.f119r = zArr[3];
            this.f120s = zArr[4];
        } catch (Exception unused) {
        }
    }

    /* synthetic */ GeoFence(Parcel parcel, C0602a c0602a) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getActivatesAction() {
        return this.f112k;
    }

    public DPoint getCenter() {
        return this.f109h;
    }

    public BDLocation getCurrentLocation() {
        return this.f111j;
    }

    public String getCustomId() {
        return this.f103b;
    }

    public long getEndTimeMillis() {
        return this.f117p;
    }

    public String getFenceId() {
        return this.f102a;
    }

    public int getInTriggerCount() {
        return this.f122u;
    }

    public String getKeyWord() {
        return this.f114m;
    }

    public int getOutTriggerCount() {
        return this.f123v;
    }

    public PoiItem getPoiItem() {
        if (this.f104c == 22) {
            return this.f106e;
        }
        return null;
    }

    public ArrayList<DPoint> getPoints() {
        return this.f121t;
    }

    public float getRadius() {
        return this.f113l;
    }

    public String getRegion() {
        return this.f115n;
    }

    public long getStartTimeMillis() {
        return this.f116o;
    }

    public int getStatus() {
        return this.f107f;
    }

    public int getStayTime() {
        return this.f125x;
    }

    public int getStayTriggerCount() {
        return this.f124w;
    }

    public int getType() {
        return this.f104c;
    }

    public boolean isAble() {
        return this.f110i;
    }

    public boolean isIn() {
        return this.f118q;
    }

    public boolean isOneSecond() {
        return this.f120s;
    }

    public boolean isOut() {
        return this.f119r;
    }

    public boolean isSend() {
        return this.f108g;
    }

    public void setAble(boolean z) {
        this.f110i = z;
    }

    public void setActivatesAction(String str) {
        this.f112k = str;
    }

    public void setCenter(DPoint dPoint) {
        this.f109h = dPoint;
    }

    public void setCurrentLoc(BDLocation bDLocation) {
        this.f111j = bDLocation;
    }

    public void setCustomId(String str) {
        this.f103b = str;
    }

    public void setEndTimeMillis(long j) {
        this.f117p = j;
    }

    public void setFenceId(String str) {
        this.f102a = str;
    }

    public void setFenceType(int i) {
        this.f104c = i;
    }

    public void setIn(boolean z) {
        this.f118q = z;
    }

    public void setInTriggerCount(int i) {
        this.f122u = i;
    }

    public void setKeyWord(String str) {
        this.f114m = str;
    }

    public void setOneSecond(boolean z) {
        this.f120s = z;
    }

    public void setOut(boolean z) {
        this.f119r = z;
    }

    public void setOutTriggerCount(int i) {
        this.f123v = i;
    }

    public void setPoiItem(PoiItem poiItem) {
        this.f106e = poiItem;
    }

    public void setPoints(ArrayList<DPoint> arrayList) {
        this.f121t = arrayList;
    }

    public void setRadius(float f) {
        this.f113l = f;
    }

    public void setRegion(String str) {
        this.f115n = str;
    }

    public void setSend(boolean z) {
        this.f108g = z;
    }

    public void setStartTimeMillis(long j) {
        this.f116o = j;
    }

    public void setStatus(int i) {
        this.f107f = i;
    }

    public void setStayTime(int i) {
        this.f125x = i;
    }

    public void setStayTriggerCount(int i) {
        this.f124w = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f102a);
        parcel.writeString(this.f103b);
        parcel.writeString(this.f114m);
        parcel.writeInt(this.f104c);
        parcel.writeInt(this.f107f);
        parcel.writeString(this.f112k);
        parcel.writeFloat(this.f113l);
        parcel.writeString(this.f115n);
        parcel.writeLong(this.f116o);
        parcel.writeLong(this.f117p);
        parcel.writeList(this.f121t);
        parcel.writeParcelable(this.f111j, i);
        parcel.writeParcelable(this.f109h, i);
        parcel.writeParcelable(this.f106e, i);
        parcel.writeParcelable(this.f105d, i);
        parcel.writeInt(this.f122u);
        parcel.writeInt(this.f123v);
        parcel.writeInt(this.f124w);
        parcel.writeBooleanArray(new boolean[]{this.f110i, this.f108g, this.f118q, this.f119r, this.f120s});
    }
}