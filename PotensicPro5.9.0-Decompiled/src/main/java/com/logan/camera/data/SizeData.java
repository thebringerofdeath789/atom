package com.logan.camera.data;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class SizeData extends BaseData {
    private List<String> sizes;

    public SizeData(List<String> list) {
        this.sizes = list;
    }

    public List<String> getSizeData() {
        return this.sizes;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = this.sizes.iterator();
        while (it.hasNext()) {
            sb.append("\n size:" + it.next());
        }
        return sb.toString();
    }
}
