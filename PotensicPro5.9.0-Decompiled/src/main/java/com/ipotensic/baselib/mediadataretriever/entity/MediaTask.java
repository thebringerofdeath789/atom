package com.ipotensic.baselib.mediadataretriever.entity;

import java.util.Map;

/* loaded from: classes2.dex */
public class MediaTask {
    private String dataSource;
    private Map<String, String> headers;
    private MetadataKey[] keys;
    private boolean loadFrame;
    private int option;
    private int sourceType;
    private long time;

    public MediaTask() {
        this.sourceType = 1;
        this.time = -1L;
        this.option = -1;
        this.loadFrame = true;
    }

    public MediaTask(int i, String str, long j, int i2, MetadataKey[] metadataKeyArr, Map<String, String> map, boolean z) {
        this.sourceType = 1;
        this.time = -1L;
        this.option = -1;
        this.loadFrame = true;
        this.sourceType = i;
        this.dataSource = str;
        this.time = j;
        this.option = i2;
        this.keys = metadataKeyArr;
        this.headers = map;
        this.loadFrame = z;
    }

    public int getSourceType() {
        return this.sourceType;
    }

    public void setSourceType(int i) {
        this.sourceType = i;
    }

    public String getDataSource() {
        return this.dataSource;
    }

    public void setDataSource(String str) {
        this.dataSource = str;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public int getOption() {
        return this.option;
    }

    public void setOption(int i) {
        this.option = i;
    }

    public MetadataKey[] getKeys() {
        return this.keys;
    }

    public void setKeys(MetadataKey[] metadataKeyArr) {
        this.keys = metadataKeyArr;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public void setHeaders(Map<String, String> map) {
        this.headers = map;
    }

    public boolean isLoadFrame() {
        return this.loadFrame;
    }

    public void setLoadFrame(boolean z) {
        this.loadFrame = z;
    }

    public boolean isNeedLoadMetaData() {
        MetadataKey[] metadataKeyArr = this.keys;
        return metadataKeyArr != null && metadataKeyArr.length > 0;
    }
}
