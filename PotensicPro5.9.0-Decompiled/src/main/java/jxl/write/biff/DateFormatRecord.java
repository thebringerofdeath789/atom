package jxl.write.biff;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import jxl.biff.FormatRecord;

/* loaded from: classes4.dex */
public class DateFormatRecord extends FormatRecord {
    protected DateFormatRecord(String str) {
        setFormatString(replace(replace(str, "a", "AM/PM"), "S", SessionDescription.SUPPORTED_SDP_VERSION));
    }
}
