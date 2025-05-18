package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.C0858C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
final class RtspSessionTiming {
    private static final long LIVE_START_TIME = 0;
    private static final String START_TIMING_NTP_FORMAT = "npt=%.3f-";
    public final long startTimeMs;
    public final long stopTimeMs;
    public static final RtspSessionTiming DEFAULT = new RtspSessionTiming(0, C0858C.TIME_UNSET);
    private static final Pattern NPT_RANGE_PATTERN = Pattern.compile("npt=([.\\d]+|now)\\s?-\\s?([.\\d]+)?");

    public static RtspSessionTiming parseTiming(String str) throws ParserException {
        long parseFloat;
        Matcher matcher = NPT_RANGE_PATTERN.matcher(str);
        Assertions.checkArgument(matcher.matches());
        String str2 = (String) Assertions.checkNotNull(matcher.group(1));
        long parseFloat2 = str2.equals("now") ? 0L : (long) (Float.parseFloat(str2) * 1000.0f);
        String group = matcher.group(2);
        if (group != null) {
            try {
                parseFloat = (long) (Float.parseFloat(group) * 1000.0f);
                Assertions.checkArgument(parseFloat > parseFloat2);
            } catch (NumberFormatException e) {
                throw new ParserException(e);
            }
        } else {
            parseFloat = C0858C.TIME_UNSET;
        }
        return new RtspSessionTiming(parseFloat2, parseFloat);
    }

    public static String getOffsetStartTimeTiming(long j) {
        return Util.formatInvariant(START_TIMING_NTP_FORMAT, Double.valueOf(j / 1000.0d));
    }

    private RtspSessionTiming(long j, long j2) {
        this.startTimeMs = j;
        this.stopTimeMs = j2;
    }

    public boolean isLive() {
        return this.stopTimeMs == C0858C.TIME_UNSET;
    }

    public long getDurationMs() {
        return this.stopTimeMs - this.startTimeMs;
    }
}