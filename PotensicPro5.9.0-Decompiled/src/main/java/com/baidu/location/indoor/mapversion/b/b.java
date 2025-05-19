package com.baidu.location.indoor.mapversion.b;

import java.io.File;
import java.io.FilenameFilter;

/* loaded from: classes.dex */
class b implements FilenameFilter {
    final /* synthetic */ String a;
    final /* synthetic */ a b;

    b(a aVar, String str) {
        this.b = aVar;
        this.a = str;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        String d;
        StringBuilder sb = new StringBuilder();
        d = this.b.d(this.a);
        return str.startsWith(sb.append(d).append("_").toString());
    }
}
