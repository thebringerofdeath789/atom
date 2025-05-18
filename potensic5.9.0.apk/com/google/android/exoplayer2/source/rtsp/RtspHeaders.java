package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.Iterables;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class RtspHeaders {
    public static final String ACCEPT = "accept";
    public static final String ALLOW = "allow";
    public static final String AUTHORIZATION = "authorization";
    public static final String BANDWIDTH = "bandwidth";
    public static final String BLOCKSIZE = "blocksize";
    public static final String CACHE_CONTROL = "cache-control";
    public static final String CONNECTION = "connection";
    public static final String CONTENT_BASE = "content-base";
    public static final String CONTENT_ENCODING = "content-encoding";
    public static final String CONTENT_LANGUAGE = "content-language";
    public static final String CONTENT_LENGTH = "content-length";
    public static final String CONTENT_LOCATION = "content-location";
    public static final String CONTENT_TYPE = "content-type";
    public static final String CSEQ = "cseq";
    public static final String DATE = "date";
    public static final String EXPIRES = "expires";
    public static final String PROXY_AUTHENTICATE = "proxy-authenticate";
    public static final String PROXY_REQUIRE = "proxy-require";
    public static final String PUBLIC = "public";
    public static final String RANGE = "range";
    public static final String RTCP_INTERVAL = "rtcp-interval";
    public static final String RTP_INFO = "rtp-info";
    public static final String SCALE = "scale";
    public static final String SESSION = "session";
    public static final String SPEED = "speed";
    public static final String SUPPORTED = "supported";
    public static final String TIMESTAMP = "timestamp";
    public static final String TRANSPORT = "transport";
    public static final String USER_AGENT = "user-agent";
    public static final String VIA = "via";
    public static final String WWW_AUTHENTICATE = "www-authenticate";
    private final ImmutableListMultimap<String, String> namesAndValues;

    public static final class Builder {
        private final ImmutableListMultimap.Builder<String, String> namesAndValuesBuilder = new ImmutableListMultimap.Builder<>();

        public Builder add(String str, String str2) {
            this.namesAndValuesBuilder.put((ImmutableListMultimap.Builder<String, String>) Ascii.toLowerCase(str.trim()), str2.trim());
            return this;
        }

        public Builder addAll(List<String> list) {
            for (int i = 0; i < list.size(); i++) {
                String[] splitAtFirst = Util.splitAtFirst(list.get(i), ":\\s?");
                if (splitAtFirst.length == 2) {
                    add(splitAtFirst[0], splitAtFirst[1]);
                }
            }
            return this;
        }

        public Builder addAll(Map<String, String> map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                add(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public RtspHeaders build() {
            return new RtspHeaders(this);
        }
    }

    public ImmutableListMultimap<String, String> asMultiMap() {
        return this.namesAndValues;
    }

    public String get(String str) {
        ImmutableList<String> values = values(str);
        if (values.isEmpty()) {
            return null;
        }
        return (String) Iterables.getLast(values);
    }

    public ImmutableList<String> values(String str) {
        return this.namesAndValues.get((ImmutableListMultimap<String, String>) Ascii.toLowerCase(str));
    }

    private RtspHeaders(Builder builder) {
        this.namesAndValues = builder.namesAndValuesBuilder.build();
    }
}