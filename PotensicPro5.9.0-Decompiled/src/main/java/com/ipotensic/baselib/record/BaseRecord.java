package com.ipotensic.baselib.record;

import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.utils.FormatUtil;
import java.io.File;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.litepal.crud.LitePalSupport;

/* compiled from: BaseRecord.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0010J\u000e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0010J\u000e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0013R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/ipotensic/baselib/record/BaseRecord;", "Lorg/litepal/crud/LitePalSupport;", "Ljava/io/Serializable;", "()V", "captureShotPath", "", "getCaptureShotPath", "()Ljava/lang/String;", "setCaptureShotPath", "(Ljava/lang/String;)V", "createTime", "", "Ljava/lang/Long;", "dataPath", "duration", "maxDistance", "", "maxHeight", "maxWindSpeed", "", "totalDistance", "save", "", "setDistance", "", "distance", "setHeight", "height", "setWindSpeed", "windSpeed", "BaseLib_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public abstract class BaseRecord extends LitePalSupport implements Serializable {
    private String captureShotPath;
    private Long createTime = Long.valueOf(System.currentTimeMillis());
    private String dataPath;
    private Long duration;
    private float maxDistance;
    private float maxHeight;
    private int maxWindSpeed;
    private float totalDistance;

    public BaseRecord() {
        LocalFileManager localFileManager = LocalFileManager.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(localFileManager, "LocalFileManager.getInstance()");
        this.dataPath = new File(localFileManager.getFlightRecordDir(), getClass().getSimpleName() + "_" + FormatUtil.formatCurTime() + ".record").getAbsolutePath();
    }

    public final String getCaptureShotPath() {
        return this.captureShotPath;
    }

    public final void setCaptureShotPath(String str) {
        this.captureShotPath = str;
    }

    public final void setDistance(float distance) {
        if (this.maxDistance < distance) {
            this.maxDistance = distance;
        }
        this.totalDistance += distance;
    }

    public final void setHeight(float height) {
        if (this.maxHeight < height) {
            this.maxHeight = height;
        }
    }

    public final void setWindSpeed(int windSpeed) {
        if (this.maxWindSpeed < windSpeed) {
            this.maxWindSpeed = windSpeed;
        }
    }

    @Override // org.litepal.crud.LitePalSupport
    public boolean save() {
        long currentTimeMillis = System.currentTimeMillis();
        Long l = this.createTime;
        if (l == null) {
            Intrinsics.throwNpe();
        }
        this.duration = Long.valueOf(currentTimeMillis - l.longValue());
        return super.save();
    }
}
