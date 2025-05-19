package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.DownloadManager;
import java.util.Comparator;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.offline.-$$Lambda$DownloadManager$InternalHandler$OH12G4NteYquO91-EYFUVBFeiK8, reason: invalid class name */
/* loaded from: classes.dex */
public final /* synthetic */ class $$Lambda$DownloadManager$InternalHandler$OH12G4NteYquO91EYFUVBFeiK8 implements Comparator {
    public static final /* synthetic */ $$Lambda$DownloadManager$InternalHandler$OH12G4NteYquO91EYFUVBFeiK8 INSTANCE = new $$Lambda$DownloadManager$InternalHandler$OH12G4NteYquO91EYFUVBFeiK8();

    private /* synthetic */ $$Lambda$DownloadManager$InternalHandler$OH12G4NteYquO91EYFUVBFeiK8() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int compareStartTimes;
        compareStartTimes = DownloadManager.InternalHandler.compareStartTimes((Download) obj, (Download) obj2);
        return compareStartTimes;
    }
}
