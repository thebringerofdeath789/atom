package com.baidu.location.indoor.mapversion.p014b;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.baidu.location.indoor.mapversion.b.b */
/* loaded from: classes.dex */
class C0752b implements FilenameFilter {

    /* renamed from: a */
    final /* synthetic */ String f1583a;

    /* renamed from: b */
    final /* synthetic */ C0751a f1584b;

    C0752b(C0751a c0751a, String str) {
        this.f1584b = c0751a;
        this.f1583a = str;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        String m1288d;
        StringBuilder sb = new StringBuilder();
        m1288d = this.f1584b.m1288d(this.f1583a);
        return str.startsWith(sb.append(m1288d).append("_").toString());
    }
}