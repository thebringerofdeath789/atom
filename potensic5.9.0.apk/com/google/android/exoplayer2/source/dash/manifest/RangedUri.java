package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.util.UriUtil;

/* loaded from: classes.dex */
public final class RangedUri {
    private int hashCode;
    public final long length;
    private final String referenceUri;
    public final long start;

    public RangedUri(String str, long j, long j2) {
        this.referenceUri = str == null ? "" : str;
        this.start = j;
        this.length = j2;
    }

    public Uri resolveUri(String str) {
        return UriUtil.resolveToUri(str, this.referenceUri);
    }

    public String resolveUriString(String str) {
        return UriUtil.resolve(str, this.referenceUri);
    }

    public RangedUri attemptMerge(RangedUri rangedUri, String str) {
        String resolveUriString = resolveUriString(str);
        if (rangedUri != null && resolveUriString.equals(rangedUri.resolveUriString(str))) {
            long j = this.length;
            if (j != -1 && this.start + j == rangedUri.start) {
                long j2 = this.start;
                long j3 = rangedUri.length;
                return new RangedUri(resolveUriString, j2, j3 != -1 ? this.length + j3 : -1L);
            }
            long j4 = rangedUri.length;
            if (j4 != -1 && rangedUri.start + j4 == this.start) {
                long j5 = rangedUri.start;
                long j6 = this.length;
                return new RangedUri(resolveUriString, j5, j6 != -1 ? rangedUri.length + j6 : -1L);
            }
        }
        return null;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = ((((527 + ((int) this.start)) * 31) + ((int) this.length)) * 31) + this.referenceUri.hashCode();
        }
        return this.hashCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RangedUri rangedUri = (RangedUri) obj;
        return this.start == rangedUri.start && this.length == rangedUri.length && this.referenceUri.equals(rangedUri.referenceUri);
    }

    public String toString() {
        String str = this.referenceUri;
        long j = this.start;
        return new StringBuilder(String.valueOf(str).length() + 81).append("RangedUri(referenceUri=").append(str).append(", start=").append(j).append(", length=").append(this.length).append(")").toString();
    }
}