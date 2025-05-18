package com.mapbox.android.telemetry;

/* loaded from: classes3.dex */
public class AttachmentMetadata {
    private String created = TelemetryUtils.obtainCurrentDate();
    private String endTime;
    private String fileId;
    private String format;
    private String name;
    private String sessionId;
    private Integer size;
    private String startTime;
    private String type;

    public AttachmentMetadata(String str, String str2, String str3, String str4, String str5) {
        this.name = str;
        this.fileId = str2;
        this.format = str3;
        this.type = str4;
        this.sessionId = str5;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setSize(int i) {
        this.size = Integer.valueOf(i);
    }

    public String getName() {
        return this.name;
    }

    public String getCreated() {
        return this.created;
    }

    public String getFileId() {
        return this.fileId;
    }

    public String getFormat() {
        return this.format;
    }

    public String getType() {
        return this.type;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public Integer getSize() {
        return this.size;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public String getEndTime() {
        return this.endTime;
    }
}