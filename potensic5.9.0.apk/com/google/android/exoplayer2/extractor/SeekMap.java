package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes.dex */
public interface SeekMap {
    long getDurationUs();

    SeekPoints getSeekPoints(long j);

    boolean isSeekable();

    public static class Unseekable implements SeekMap {
        private final long durationUs;
        private final SeekPoints startSeekPoints;

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return false;
        }

        public Unseekable(long j) {
            this(j, 0L);
        }

        public Unseekable(long j, long j2) {
            this.durationUs = j;
            this.startSeekPoints = new SeekPoints(j2 == 0 ? SeekPoint.START : new SeekPoint(0L, j2));
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            return this.durationUs;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public SeekPoints getSeekPoints(long j) {
            return this.startSeekPoints;
        }
    }

    public static final class SeekPoints {
        public final SeekPoint first;
        public final SeekPoint second;

        public SeekPoints(SeekPoint seekPoint) {
            this(seekPoint, seekPoint);
        }

        public SeekPoints(SeekPoint seekPoint, SeekPoint seekPoint2) {
            this.first = (SeekPoint) Assertions.checkNotNull(seekPoint);
            this.second = (SeekPoint) Assertions.checkNotNull(seekPoint2);
        }

        public String toString() {
            String sb;
            String valueOf = String.valueOf(this.first);
            if (this.first.equals(this.second)) {
                sb = "";
            } else {
                String valueOf2 = String.valueOf(this.second);
                sb = new StringBuilder(String.valueOf(valueOf2).length() + 2).append(", ").append(valueOf2).toString();
            }
            return new StringBuilder(String.valueOf(valueOf).length() + 2 + String.valueOf(sb).length()).append("[").append(valueOf).append(sb).append("]").toString();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            SeekPoints seekPoints = (SeekPoints) obj;
            return this.first.equals(seekPoints.first) && this.second.equals(seekPoints.second);
        }

        public int hashCode() {
            return (this.first.hashCode() * 31) + this.second.hashCode();
        }
    }
}