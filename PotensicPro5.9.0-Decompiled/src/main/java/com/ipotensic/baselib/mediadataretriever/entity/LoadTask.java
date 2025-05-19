package com.ipotensic.baselib.mediadataretriever.entity;

import android.view.View;
import com.ipotensic.baselib.mediadataretriever.inter.OnMediaRetrieverLoadListener;
import java.util.Map;

/* loaded from: classes2.dex */
public class LoadTask {
    private String dataSource;
    private int errorHolder;
    private Map<String, String> headers;
    private MetadataKey[] keys;
    private OnMediaRetrieverLoadListener onMediaRetrieverLoadListener;
    private int option;
    private int placeHolder;
    private int sourceType;
    private View targetView;
    private int thumbnailType;
    private long time;
    private boolean needLoadFrame = true;
    private long createTime = System.currentTimeMillis();

    public LoadTask(int i, String str, View view, int i2, int i3, long j, int i4, int i5, MetadataKey[] metadataKeyArr, Map<String, String> map, OnMediaRetrieverLoadListener onMediaRetrieverLoadListener) {
        this.sourceType = 1;
        this.time = -1L;
        this.option = -1;
        this.sourceType = i;
        this.dataSource = str;
        this.targetView = view;
        this.placeHolder = i2;
        this.errorHolder = i3;
        this.time = j;
        this.option = i4;
        this.thumbnailType = i5;
        this.keys = metadataKeyArr;
        this.headers = map;
        this.onMediaRetrieverLoadListener = onMediaRetrieverLoadListener;
        View view2 = this.targetView;
        if (view2 != null) {
            view2.setTag(str);
        }
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

    public View getTargetView() {
        return this.targetView;
    }

    public void setTargetView(View view) {
        this.targetView = view;
    }

    public int getPlaceHolder() {
        return this.placeHolder;
    }

    public void setPlaceHolder(int i) {
        this.placeHolder = i;
    }

    public int getErrorHolder() {
        return this.errorHolder;
    }

    public void setErrorHolder(int i) {
        this.errorHolder = i;
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

    public int getThumbnailType() {
        return this.thumbnailType;
    }

    public void setThumbnailType(int i) {
        this.thumbnailType = i;
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

    public OnMediaRetrieverLoadListener getOnMediaRetrieverLoadListener() {
        return this.onMediaRetrieverLoadListener;
    }

    public void setOnMediaRetrieverLoadListener(OnMediaRetrieverLoadListener onMediaRetrieverLoadListener) {
        this.onMediaRetrieverLoadListener = onMediaRetrieverLoadListener;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public boolean isNeedLoadFrame() {
        return this.needLoadFrame;
    }

    public void setNeedLoadFrame(boolean z) {
        this.needLoadFrame = z;
    }

    public Object getTag() {
        return this.dataSource;
    }

    public boolean isLegalTag() {
        Object tag = this.targetView.getTag();
        if (getTag() == null || tag == null) {
            return false;
        }
        return getTag().equals(tag);
    }

    public boolean isNeedLoadMetaData() {
        MetadataKey[] metadataKeyArr = this.keys;
        return metadataKeyArr != null && metadataKeyArr.length > 0;
    }

    public MediaTask generatorMediaTask(boolean z) {
        return new MediaTask(this.sourceType, this.dataSource, this.time, this.option, this.keys, this.headers, z);
    }
}
