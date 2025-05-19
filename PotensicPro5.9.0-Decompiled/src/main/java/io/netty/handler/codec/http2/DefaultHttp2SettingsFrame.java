package io.netty.handler.codec.http2;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public class DefaultHttp2SettingsFrame implements Http2SettingsFrame {
    private final Http2Settings settings;

    @Override // io.netty.handler.codec.http2.Http2SettingsFrame, io.netty.handler.codec.http2.Http2Frame
    public String name() {
        return "SETTINGS";
    }

    public DefaultHttp2SettingsFrame(Http2Settings http2Settings) {
        this.settings = (Http2Settings) ObjectUtil.checkNotNull(http2Settings, "settings");
    }

    @Override // io.netty.handler.codec.http2.Http2SettingsFrame
    public Http2Settings settings() {
        return this.settings;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "(settings=" + this.settings + PropertyUtils.MAPPED_DELIM2;
    }
}
