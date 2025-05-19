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
    public static final Parcelable.Creator<GeoFence> CREATOR = new a();
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
    private String a;
    private String b;
    private int c;
    private DistrictItem d;
    private PoiItem e;
    private int f;
    private boolean g;
    private DPoint h;
    private boolean i;
    private BDLocation j;
    private String k;
    private float l;
    private String m;
    private String n;
    private long o;
    private long p;
    private boolean q;
    private boolean r;
    private boolean s;
    private ArrayList<DPoint> t;
    private int u;
    private int v;
    private int w;
    private int x;

    public GeoFence() {
        this.f = 19;
        this.g = false;
        this.i = true;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = null;
        this.u = 1;
        this.v = 1;
        this.w = 1;
        this.x = IjkMediaCodecInfo.RANK_LAST_CHANCE;
    }

    private GeoFence(Parcel parcel) {
        this.f = 19;
        this.g = false;
        this.i = true;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = null;
        this.u = 1;
        this.v = 1;
        this.w = 1;
        this.x = IjkMediaCodecInfo.RANK_LAST_CHANCE;
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.m = parcel.readString();
        this.c = parcel.readInt();
        this.f = parcel.readInt();
        this.k = parcel.readString();
        this.l = parcel.readFloat();
        this.n = parcel.readString();
        this.o = parcel.readLong();
        this.p = parcel.readLong();
        ArrayList<DPoint> arrayList = new ArrayList<>();
        try {
            parcel.readList(arrayList, DPoint.class.getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (arrayList.size() == 0) {
            this.t = null;
        } else {
            this.t = arrayList;
        }
        try {
            this.j = (BDLocation) parcel.readParcelable(BDLocation.class.getClassLoader());
        } catch (Exception e2) {
            this.j = null;
            e2.printStackTrace();
        }
        try {
            this.h = (DPoint) parcel.readParcelable(DPoint.class.getClassLoader());
        } catch (Exception e3) {
            this.h = null;
            e3.printStackTrace();
        }
        try {
            this.e = (PoiItem) parcel.readParcelable(PoiItem.class.getClassLoader());
        } catch (Exception e4) {
            this.e = null;
            e4.printStackTrace();
        }
        try {
            this.d = (DistrictItem) parcel.readParcelable(DistrictItem.class.getClassLoader());
        } catch (Exception e5) {
            this.d = null;
            e5.printStackTrace();
        }
        this.u = parcel.readInt();
        this.v = parcel.readInt();
        this.w = parcel.readInt();
        boolean[] zArr = new boolean[5];
        try {
            parcel.readBooleanArray(zArr);
            this.i = zArr[0];
            this.g = zArr[1];
            this.q = zArr[2];
            this.r = zArr[3];
            this.s = zArr[4];
        } catch (Exception unused) {
        }
    }

    /* synthetic */ GeoFence(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getActivatesAction() {
        return this.k;
    }

    public DPoint getCenter() {
        return this.h;
    }

    public BDLocation getCurrentLocation() {
        return this.j;
    }

    public String getCustomId() {
        return this.b;
    }

    public long getEndTimeMillis() {
        return this.p;
    }

    public String getFenceId() {
        return this.a;
    }

    public int getInTriggerCount() {
        return this.u;
    }

    public String getKeyWord() {
        return this.m;
    }

    public int getOutTriggerCount() {
        return this.v;
    }

    public PoiItem getPoiItem() {
        if (this.c == 22) {
            return this.e;
        }
        return null;
    }

    public ArrayList<DPoint> getPoints() {
        return this.t;
    }

    public float getRadius() {
        return this.l;
    }

    public String getRegion() {
        return this.n;
    }

    public long getStartTimeMillis() {
        return this.o;
    }

    public int getStatus() {
        return this.f;
    }

    public int getStayTime() {
        return this.x;
    }

    public int getStayTriggerCount() {
        return this.w;
    }

    public int getType() {
        return this.c;
    }

    public boolean isAble() {
        return this.i;
    }

    public boolean isIn() {
        return this.q;
    }

    public boolean isOneSecond() {
        return this.s;
    }

    public boolean isOut() {
        return this.r;
    }

    public boolean isSend() {
        return this.g;
    }

    public void setAble(boolean z) {
        this.i = z;
    }

    public void setActivatesAction(String str) {
        this.k = str;
    }

    public void setCenter(DPoint dPoint) {
        this.h = dPoint;
    }

    public void setCurrentLoc(BDLocation bDLocation) {
        this.j = bDLocation;
    }

    public void setCustomId(String str) {
        this.b = str;
    }

    public void setEndTimeMillis(long j) {
        this.p = j;
    }

    public void setFenceId(String str) {
        this.a = str;
    }

    public void setFenceType(int i) {
        this.c = i;
    }

    public void setIn(boolean z) {
        this.q = z;
    }

    public void setInTriggerCount(int i) {
        this.u = i;
    }

    public void setKeyWord(String str) {
        this.m = str;
    }

    public void setOneSecond(boolean z) {
        this.s = z;
    }

    public void setOut(boolean z) {
        this.r = z;
    }

    public void setOutTriggerCount(int i) {
        this.v = i;
    }

    public void setPoiItem(PoiItem poiItem) {
        this.e = poiItem;
    }

    public void setPoints(ArrayList<DPoint> arrayList) {
        this.t = arrayList;
    }

    public void setRadius(float f) {
        this.l = f;
    }

    public void setRegion(String str) {
        this.n = str;
    }

    public void setSend(boolean z) {
        this.g = z;
    }

    public void setStartTimeMillis(long j) {
        this.o = j;
    }

    public void setStatus(int i) {
        this.f = i;
    }

    public void setStayTime(int i) {
        this.x = i;
    }

    public void setStayTriggerCount(int i) {
        this.w = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.m);
        parcel.writeInt(this.c);
        parcel.writeInt(this.f);
        parcel.writeString(this.k);
        parcel.writeFloat(this.l);
        parcel.writeString(this.n);
        parcel.writeLong(this.o);
        parcel.writeLong(this.p);
        parcel.writeList(this.t);
        parcel.writeParcelable(this.j, i);
        parcel.writeParcelable(this.h, i);
        parcel.writeParcelable(this.e, i);
        parcel.writeParcelable(this.d, i);
        parcel.writeInt(this.u);
        parcel.writeInt(this.v);
        parcel.writeInt(this.w);
        parcel.writeBooleanArray(new boolean[]{this.i, this.g, this.q, this.r, this.s});
    }
}
