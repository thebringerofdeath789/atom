package org.apache.commons.text.lookup;

import io.netty.handler.codec.http.HttpHeaders;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/* loaded from: classes4.dex */
public final class StringLookupFactory {
    public static final StringLookupFactory INSTANCE = new StringLookupFactory();
    static final FunctionStringLookup<String> INSTANCE_BASE64_DECODER = FunctionStringLookup.on(new Function() { // from class: org.apache.commons.text.lookup.-$$Lambda$StringLookupFactory$jMYn8JXelZWaB5EFfJt2pGas6X4
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return StringLookupFactory.lambda$static$0((String) obj);
        }
    });
    static final FunctionStringLookup<String> INSTANCE_BASE64_ENCODER = FunctionStringLookup.on(new Function() { // from class: org.apache.commons.text.lookup.-$$Lambda$StringLookupFactory$yJrcs9TeYNzP27ZT7ThTmc53KJU
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            String encodeToString;
            encodeToString = Base64.getEncoder().encodeToString(((String) obj).getBytes(StandardCharsets.ISO_8859_1));
            return encodeToString;
        }
    });
    static final FunctionStringLookup<String> INSTANCE_ENVIRONMENT_VARIABLES = FunctionStringLookup.on(new Function() { // from class: org.apache.commons.text.lookup.-$$Lambda$StringLookupFactory$qEfM5BkBiyKLhxh3FFETOUT1Oj0
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            String str;
            str = System.getenv((String) obj);
            return str;
        }
    });
    static final FunctionStringLookup<String> INSTANCE_NULL = FunctionStringLookup.on(new Function() { // from class: org.apache.commons.text.lookup.-$$Lambda$StringLookupFactory$4kva25maYANN2bsC5pD_QRL4A08
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return StringLookupFactory.lambda$static$2((String) obj);
        }
    });
    static final FunctionStringLookup<String> INSTANCE_SYSTEM_PROPERTIES = FunctionStringLookup.on(new Function() { // from class: org.apache.commons.text.lookup.-$$Lambda$StringLookupFactory$sKRTJ6Nnjl0HUfAmjreOQTU8IQQ
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            String property;
            property = System.getProperty((String) obj);
            return property;
        }
    });
    public static final String KEY_BASE64_DECODER = "base64Decoder";
    public static final String KEY_BASE64_ENCODER = "base64Encoder";
    public static final String KEY_CONST = "const";
    public static final String KEY_DATE = "date";
    public static final String KEY_DNS = "dns";
    public static final String KEY_ENV = "env";
    public static final String KEY_FILE = "file";
    public static final String KEY_JAVA = "java";
    public static final String KEY_LOCALHOST = "localhost";
    public static final String KEY_PROPERTIES = "properties";
    public static final String KEY_RESOURCE_BUNDLE = "resourceBundle";
    public static final String KEY_SCRIPT = "script";
    public static final String KEY_SYS = "sys";
    public static final String KEY_URL = "url";
    public static final String KEY_URL_DECODER = "urlDecoder";
    public static final String KEY_URL_ENCODER = "urlEncoder";
    public static final String KEY_XML = "xml";

    static /* synthetic */ String lambda$static$2(String str) {
        return null;
    }

    static /* synthetic */ String lambda$static$0(String str) {
        return new String(Base64.getDecoder().decode(str), StandardCharsets.ISO_8859_1);
    }

    public static void clear() {
        ConstantStringLookup.clear();
    }

    private StringLookupFactory() {
    }

    public void addDefaultStringLookups(Map<String, StringLookup> map) {
        if (map != null) {
            map.put(HttpHeaders.Values.BASE64, INSTANCE_BASE64_DECODER);
            for (DefaultStringLookup defaultStringLookup : DefaultStringLookup.values()) {
                map.put(InterpolatorStringLookup.toKey(defaultStringLookup.getKey()), defaultStringLookup.getStringLookup());
            }
        }
    }

    public StringLookup base64DecoderStringLookup() {
        return INSTANCE_BASE64_DECODER;
    }

    public StringLookup base64EncoderStringLookup() {
        return INSTANCE_BASE64_ENCODER;
    }

    @Deprecated
    public StringLookup base64StringLookup() {
        return INSTANCE_BASE64_DECODER;
    }

    public <R, U> BiStringLookup<U> biFunctionStringLookup(BiFunction<String, U, R> biFunction) {
        return BiFunctionStringLookup.on(biFunction);
    }

    public StringLookup constantStringLookup() {
        return ConstantStringLookup.INSTANCE;
    }

    public StringLookup dateStringLookup() {
        return DateStringLookup.INSTANCE;
    }

    public StringLookup dnsStringLookup() {
        return DnsStringLookup.INSTANCE;
    }

    public StringLookup environmentVariableStringLookup() {
        return INSTANCE_ENVIRONMENT_VARIABLES;
    }

    public StringLookup fileStringLookup() {
        return FileStringLookup.INSTANCE;
    }

    public <R> StringLookup functionStringLookup(Function<String, R> function) {
        return FunctionStringLookup.on(function);
    }

    public StringLookup interpolatorStringLookup() {
        return InterpolatorStringLookup.INSTANCE;
    }

    public StringLookup interpolatorStringLookup(Map<String, StringLookup> map, StringLookup stringLookup, boolean z) {
        return new InterpolatorStringLookup(map, stringLookup, z);
    }

    public <V> StringLookup interpolatorStringLookup(Map<String, V> map) {
        return new InterpolatorStringLookup(map);
    }

    public StringLookup interpolatorStringLookup(StringLookup stringLookup) {
        return new InterpolatorStringLookup(stringLookup);
    }

    public StringLookup javaPlatformStringLookup() {
        return JavaPlatformStringLookup.INSTANCE;
    }

    public StringLookup localHostStringLookup() {
        return LocalHostStringLookup.INSTANCE;
    }

    public <V> StringLookup mapStringLookup(Map<String, V> map) {
        return FunctionStringLookup.on(map);
    }

    public StringLookup nullStringLookup() {
        return INSTANCE_NULL;
    }

    public StringLookup propertiesStringLookup() {
        return PropertiesStringLookup.INSTANCE;
    }

    public StringLookup resourceBundleStringLookup() {
        return ResourceBundleStringLookup.INSTANCE;
    }

    public StringLookup resourceBundleStringLookup(String str) {
        return new ResourceBundleStringLookup(str);
    }

    public StringLookup scriptStringLookup() {
        return ScriptStringLookup.INSTANCE;
    }

    public StringLookup systemPropertyStringLookup() {
        return INSTANCE_SYSTEM_PROPERTIES;
    }

    public StringLookup urlDecoderStringLookup() {
        return UrlDecoderStringLookup.INSTANCE;
    }

    public StringLookup urlEncoderStringLookup() {
        return UrlEncoderStringLookup.INSTANCE;
    }

    public StringLookup urlStringLookup() {
        return UrlStringLookup.INSTANCE;
    }

    public StringLookup xmlStringLookup() {
        return XmlStringLookup.INSTANCE;
    }
}
