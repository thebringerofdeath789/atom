package io.netty.handler.codec.http2;

import com.google.android.exoplayer2.source.rtsp.RtspHeaders;
import io.netty.handler.codec.UnsupportedValueConverter;
import io.netty.util.AsciiString;
import java.util.Arrays;
import java.util.List;
import net.lingala.zip4j.util.InternalZipConstants;
import okhttp3.internal.http2.Header;

/* loaded from: classes3.dex */
final class HpackStaticTable {
    private static final CharSequenceMap<Integer> STATIC_INDEX_BY_NAME;
    private static final List<HpackHeaderField> STATIC_TABLE;
    static final int length;

    static {
        List<HpackHeaderField> asList = Arrays.asList(newEmptyHeaderField(Header.TARGET_AUTHORITY_UTF8), newHeaderField(Header.TARGET_METHOD_UTF8, "GET"), newHeaderField(Header.TARGET_METHOD_UTF8, "POST"), newHeaderField(Header.TARGET_PATH_UTF8, InternalZipConstants.ZIP_FILE_SEPARATOR), newHeaderField(Header.TARGET_PATH_UTF8, "/index.html"), newHeaderField(Header.TARGET_SCHEME_UTF8, "http"), newHeaderField(Header.TARGET_SCHEME_UTF8, "https"), newHeaderField(Header.RESPONSE_STATUS_UTF8, "200"), newHeaderField(Header.RESPONSE_STATUS_UTF8, "204"), newHeaderField(Header.RESPONSE_STATUS_UTF8, "206"), newHeaderField(Header.RESPONSE_STATUS_UTF8, "304"), newHeaderField(Header.RESPONSE_STATUS_UTF8, "400"), newHeaderField(Header.RESPONSE_STATUS_UTF8, "404"), newHeaderField(Header.RESPONSE_STATUS_UTF8, "500"), newEmptyHeaderField("accept-charset"), newHeaderField("accept-encoding", "gzip, deflate"), newEmptyHeaderField("accept-language"), newEmptyHeaderField("accept-ranges"), newEmptyHeaderField(RtspHeaders.ACCEPT), newEmptyHeaderField("access-control-allow-origin"), newEmptyHeaderField("age"), newEmptyHeaderField(RtspHeaders.ALLOW), newEmptyHeaderField(RtspHeaders.AUTHORIZATION), newEmptyHeaderField(RtspHeaders.CACHE_CONTROL), newEmptyHeaderField("content-disposition"), newEmptyHeaderField(RtspHeaders.CONTENT_ENCODING), newEmptyHeaderField(RtspHeaders.CONTENT_LANGUAGE), newEmptyHeaderField(RtspHeaders.CONTENT_LENGTH), newEmptyHeaderField(RtspHeaders.CONTENT_LOCATION), newEmptyHeaderField("content-range"), newEmptyHeaderField(RtspHeaders.CONTENT_TYPE), newEmptyHeaderField("cookie"), newEmptyHeaderField("date"), newEmptyHeaderField("etag"), newEmptyHeaderField("expect"), newEmptyHeaderField(RtspHeaders.EXPIRES), newEmptyHeaderField("from"), newEmptyHeaderField("host"), newEmptyHeaderField("if-match"), newEmptyHeaderField("if-modified-since"), newEmptyHeaderField("if-none-match"), newEmptyHeaderField("if-range"), newEmptyHeaderField("if-unmodified-since"), newEmptyHeaderField("last-modified"), newEmptyHeaderField("link"), newEmptyHeaderField("location"), newEmptyHeaderField("max-forwards"), newEmptyHeaderField(RtspHeaders.PROXY_AUTHENTICATE), newEmptyHeaderField("proxy-authorization"), newEmptyHeaderField("range"), newEmptyHeaderField("referer"), newEmptyHeaderField("refresh"), newEmptyHeaderField("retry-after"), newEmptyHeaderField("server"), newEmptyHeaderField("set-cookie"), newEmptyHeaderField("strict-transport-security"), newEmptyHeaderField("transfer-encoding"), newEmptyHeaderField(RtspHeaders.USER_AGENT), newEmptyHeaderField("vary"), newEmptyHeaderField(RtspHeaders.VIA), newEmptyHeaderField(RtspHeaders.WWW_AUTHENTICATE));
        STATIC_TABLE = asList;
        STATIC_INDEX_BY_NAME = createMap();
        length = asList.size();
    }

    private static HpackHeaderField newEmptyHeaderField(String str) {
        return new HpackHeaderField(AsciiString.cached(str), AsciiString.EMPTY_STRING);
    }

    private static HpackHeaderField newHeaderField(String str, String str2) {
        return new HpackHeaderField(AsciiString.cached(str), AsciiString.cached(str2));
    }

    static HpackHeaderField getEntry(int i) {
        return STATIC_TABLE.get(i - 1);
    }

    static int getIndex(CharSequence charSequence) {
        Integer num = STATIC_INDEX_BY_NAME.get(charSequence);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    static int getIndex(CharSequence charSequence, CharSequence charSequence2) {
        int index = getIndex(charSequence);
        if (index == -1) {
            return -1;
        }
        while (index <= length) {
            HpackHeaderField entry = getEntry(index);
            if (HpackUtil.equalsConstantTime(charSequence, entry.name) == 0) {
                break;
            }
            if (HpackUtil.equalsConstantTime(charSequence2, entry.value) != 0) {
                return index;
            }
            index++;
        }
        return -1;
    }

    private static CharSequenceMap<Integer> createMap() {
        int size = STATIC_TABLE.size();
        CharSequenceMap<Integer> charSequenceMap = new CharSequenceMap<>(true, UnsupportedValueConverter.instance(), size);
        while (size > 0) {
            charSequenceMap.set((CharSequenceMap<Integer>) getEntry(size).name, (CharSequence) Integer.valueOf(size));
            size--;
        }
        return charSequenceMap;
    }

    private HpackStaticTable() {
    }
}
