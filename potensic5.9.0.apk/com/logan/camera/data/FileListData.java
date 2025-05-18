package com.logan.camera.data;

import java.util.List;

/* loaded from: classes2.dex */
public class FileListData extends BaseData {
    private List<String> file;

    public FileListData(List<String> list) {
        this.file = list;
    }

    public List<String> getFile() {
        return this.file;
    }
}