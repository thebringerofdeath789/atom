package io.netty.handler.codec.http.websocketx.extensions;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class WebSocketExtensionData {
    private final String name;
    private final Map<String, String> parameters;

    public WebSocketExtensionData(String str, Map<String, String> map) {
        Objects.requireNonNull(str, "name");
        Objects.requireNonNull(map, "parameters");
        this.name = str;
        this.parameters = Collections.unmodifiableMap(map);
    }

    public String name() {
        return this.name;
    }

    public Map<String, String> parameters() {
        return this.parameters;
    }
}
