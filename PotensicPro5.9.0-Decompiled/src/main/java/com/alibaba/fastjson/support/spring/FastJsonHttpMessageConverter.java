package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.nio.charset.Charset;
import org.springframework.core.ResolvableType;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.GenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

/* loaded from: classes.dex */
public class FastJsonHttpMessageConverter extends AbstractHttpMessageConverter<Object> implements GenericHttpMessageConverter<Object> {
    public static final MediaType APPLICATION_JAVASCRIPT = new MediaType(MimeTypes.BASE_TYPE_APPLICATION, "javascript");

    @Deprecated
    protected String dateFormat;
    private FastJsonConfig fastJsonConfig;

    @Deprecated
    protected SerializerFeature[] features;

    @Deprecated
    protected SerializeFilter[] filters;

    protected boolean supports(Class<?> cls) {
        return true;
    }

    public FastJsonConfig getFastJsonConfig() {
        return this.fastJsonConfig;
    }

    public void setFastJsonConfig(FastJsonConfig fastJsonConfig) {
        this.fastJsonConfig = fastJsonConfig;
    }

    public FastJsonHttpMessageConverter() {
        super(MediaType.ALL);
        this.features = new SerializerFeature[0];
        this.filters = new SerializeFilter[0];
        this.fastJsonConfig = new FastJsonConfig();
    }

    @Deprecated
    public Charset getCharset() {
        return this.fastJsonConfig.getCharset();
    }

    @Deprecated
    public void setCharset(Charset charset) {
        this.fastJsonConfig.setCharset(charset);
    }

    @Deprecated
    public String getDateFormat() {
        return this.fastJsonConfig.getDateFormat();
    }

    @Deprecated
    public void setDateFormat(String str) {
        this.fastJsonConfig.setDateFormat(str);
    }

    @Deprecated
    public SerializerFeature[] getFeatures() {
        return this.fastJsonConfig.getSerializerFeatures();
    }

    @Deprecated
    public void setFeatures(SerializerFeature... serializerFeatureArr) {
        this.fastJsonConfig.setSerializerFeatures(serializerFeatureArr);
    }

    @Deprecated
    public SerializeFilter[] getFilters() {
        return this.fastJsonConfig.getSerializeFilters();
    }

    @Deprecated
    public void setFilters(SerializeFilter... serializeFilterArr) {
        this.fastJsonConfig.setSerializeFilters(serializeFilterArr);
    }

    @Deprecated
    public void addSerializeFilter(SerializeFilter serializeFilter) {
        if (serializeFilter == null) {
            return;
        }
        int length = this.fastJsonConfig.getSerializeFilters().length;
        int i = length + 1;
        SerializeFilter[] serializeFilterArr = new SerializeFilter[i];
        System.arraycopy(this.fastJsonConfig.getSerializeFilters(), 0, serializeFilterArr, 0, length);
        serializeFilterArr[i - 1] = serializeFilter;
        this.fastJsonConfig.setSerializeFilters(serializeFilterArr);
    }

    public boolean canRead(Type type, Class<?> cls, MediaType mediaType) {
        return super.canRead(cls, mediaType);
    }

    public boolean canWrite(Type type, Class<?> cls, MediaType mediaType) {
        return super.canWrite(cls, mediaType);
    }

    public Object read(Type type, Class<?> cls, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return readType(getType(type, cls), httpInputMessage);
    }

    public void write(Object obj, Type type, MediaType mediaType, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        super.write(obj, mediaType, httpOutputMessage);
    }

    protected Object readInternal(Class<? extends Object> cls, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return readType(getType(cls, null), httpInputMessage);
    }

    private Object readType(Type type, HttpInputMessage httpInputMessage) {
        try {
            return JSON.parseObject(httpInputMessage.getBody(), this.fastJsonConfig.getCharset(), type, this.fastJsonConfig.getParserConfig(), this.fastJsonConfig.getParseProcess(), JSON.DEFAULT_PARSER_FEATURE, this.fastJsonConfig.getFeatures());
        } catch (JSONException e) {
            throw new HttpMessageNotReadableException("JSON parse error: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new HttpMessageNotReadableException("I/O error while reading input message", e2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0049, code lost:
    
        if ((r2 instanceof com.alibaba.fastjson.JSONPObject) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void writeInternal(java.lang.Object r12, org.springframework.http.HttpOutputMessage r13) throws java.io.IOException, org.springframework.http.converter.HttpMessageNotWritableException {
        /*
            r11 = this;
            java.io.ByteArrayOutputStream r8 = new java.io.ByteArrayOutputStream
            r8.<init>()
            org.springframework.http.HttpHeaders r9 = r13.getHeaders()     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            com.alibaba.fastjson.support.config.FastJsonConfig r0 = r11.fastJsonConfig     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            com.alibaba.fastjson.serializer.SerializeFilter[] r0 = r0.getSerializeFilters()     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            java.util.List r0 = java.util.Arrays.asList(r0)     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            r0 = 0
            java.lang.Object r12 = r11.strangeCodeForJackson(r12)     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            boolean r2 = r12 instanceof com.alibaba.fastjson.support.spring.FastJsonContainer     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            if (r2 == 0) goto L32
            com.alibaba.fastjson.support.spring.FastJsonContainer r12 = (com.alibaba.fastjson.support.spring.FastJsonContainer) r12     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            com.alibaba.fastjson.support.spring.PropertyPreFilters r2 = r12.getFilters()     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            java.util.List r2 = r2.getFilters()     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            r1.addAll(r2)     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            java.lang.Object r12 = r12.getValue()     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
        L32:
            r2 = r12
            boolean r12 = r2 instanceof com.alibaba.fastjson.support.spring.MappingFastJsonValue     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            r3 = 1
            if (r12 == 0) goto L47
            r12 = r2
            com.alibaba.fastjson.support.spring.MappingFastJsonValue r12 = (com.alibaba.fastjson.support.spring.MappingFastJsonValue) r12     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            java.lang.String r12 = r12.getJsonpFunction()     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            boolean r12 = org.springframework.util.StringUtils.isEmpty(r12)     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            if (r12 != 0) goto L4d
            goto L4b
        L47:
            boolean r12 = r2 instanceof com.alibaba.fastjson.JSONPObject     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            if (r12 == 0) goto L4d
        L4b:
            r12 = r3
            goto L4e
        L4d:
            r12 = r0
        L4e:
            com.alibaba.fastjson.support.config.FastJsonConfig r0 = r11.fastJsonConfig     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            java.nio.charset.Charset r3 = r0.getCharset()     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            com.alibaba.fastjson.support.config.FastJsonConfig r0 = r11.fastJsonConfig     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            com.alibaba.fastjson.serializer.SerializeConfig r4 = r0.getSerializeConfig()     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            int r0 = r1.size()     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            com.alibaba.fastjson.serializer.SerializeFilter[] r0 = new com.alibaba.fastjson.serializer.SerializeFilter[r0]     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            java.lang.Object[] r0 = r1.toArray(r0)     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            r5 = r0
            com.alibaba.fastjson.serializer.SerializeFilter[] r5 = (com.alibaba.fastjson.serializer.SerializeFilter[]) r5     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            com.alibaba.fastjson.support.config.FastJsonConfig r0 = r11.fastJsonConfig     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            java.lang.String r6 = r0.getDateFormat()     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            int r7 = com.alibaba.fastjson.JSON.DEFAULT_GENERATE_FEATURE     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            com.alibaba.fastjson.support.config.FastJsonConfig r0 = r11.fastJsonConfig     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            com.alibaba.fastjson.serializer.SerializerFeature[] r10 = r0.getSerializerFeatures()     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            r0 = r8
            r1 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r10
            int r0 = com.alibaba.fastjson.JSON.writeJSONString(r0, r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            if (r12 == 0) goto L87
            org.springframework.http.MediaType r12 = com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter.APPLICATION_JAVASCRIPT     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            r9.setContentType(r12)     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
        L87:
            com.alibaba.fastjson.support.config.FastJsonConfig r12 = r11.fastJsonConfig     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            boolean r12 = r12.isWriteContentLength()     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            if (r12 == 0) goto L93
            long r0 = (long) r0     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            r9.setContentLength(r0)     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
        L93:
            java.io.OutputStream r12 = r13.getBody()     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            r8.writeTo(r12)     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            r8.close()
            return
        L9e:
            r12 = move-exception
            goto Lbe
        La0:
            r12 = move-exception
            org.springframework.http.converter.HttpMessageNotWritableException r13 = new org.springframework.http.converter.HttpMessageNotWritableException     // Catch: java.lang.Throwable -> L9e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9e
            r0.<init>()     // Catch: java.lang.Throwable -> L9e
            java.lang.String r1 = "Could not write JSON: "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L9e
            java.lang.String r1 = r12.getMessage()     // Catch: java.lang.Throwable -> L9e
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L9e
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L9e
            r13.<init>(r0, r12)     // Catch: java.lang.Throwable -> L9e
            throw r13     // Catch: java.lang.Throwable -> L9e
        Lbe:
            r8.close()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter.writeInternal(java.lang.Object, org.springframework.http.HttpOutputMessage):void");
    }

    private Object strangeCodeForJackson(Object obj) {
        return (obj == null || !"com.fasterxml.jackson.databind.node.ObjectNode".equals(obj.getClass().getName())) ? obj : obj.toString();
    }

    protected Type getType(Type type, Class<?> cls) {
        return Spring4TypeResolvableHelper.isSupport() ? Spring4TypeResolvableHelper.getType(type, cls) : type;
    }

    private static class Spring4TypeResolvableHelper {
        private static boolean hasClazzResolvableType;

        private Spring4TypeResolvableHelper() {
        }

        static {
            try {
                Class.forName("org.springframework.core.ResolvableType");
                hasClazzResolvableType = true;
            } catch (ClassNotFoundException unused) {
                hasClazzResolvableType = false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isSupport() {
            return hasClazzResolvableType;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Type getType(Type type, Class<?> cls) {
            if (cls == null) {
                return type;
            }
            ResolvableType forType = ResolvableType.forType(type);
            if (type instanceof TypeVariable) {
                ResolvableType resolveVariable = resolveVariable((TypeVariable) type, ResolvableType.forClass(cls));
                return resolveVariable != ResolvableType.NONE ? resolveVariable.resolve() : type;
            }
            if (!(type instanceof ParameterizedType) || !forType.hasUnresolvableGenerics()) {
                return type;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Class[] clsArr = new Class[parameterizedType.getActualTypeArguments().length];
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (int i = 0; i < actualTypeArguments.length; i++) {
                Type type2 = actualTypeArguments[i];
                if (type2 instanceof TypeVariable) {
                    ResolvableType resolveVariable2 = resolveVariable((TypeVariable) type2, ResolvableType.forClass(cls));
                    if (resolveVariable2 != ResolvableType.NONE) {
                        clsArr[i] = resolveVariable2.resolve();
                    } else {
                        clsArr[i] = ResolvableType.forType(type2).resolve();
                    }
                } else {
                    clsArr[i] = ResolvableType.forType(type2).resolve();
                }
            }
            return ResolvableType.forClassWithGenerics(forType.getRawClass(), clsArr).getType();
        }

        private static ResolvableType resolveVariable(TypeVariable<?> typeVariable, ResolvableType resolvableType) {
            if (resolvableType.hasGenerics()) {
                ResolvableType forType = ResolvableType.forType(typeVariable, resolvableType);
                if (forType.resolve() != null) {
                    return forType;
                }
            }
            ResolvableType superType = resolvableType.getSuperType();
            if (superType != ResolvableType.NONE) {
                ResolvableType resolveVariable = resolveVariable(typeVariable, superType);
                if (resolveVariable.resolve() != null) {
                    return resolveVariable;
                }
            }
            for (ResolvableType resolvableType2 : resolvableType.getInterfaces()) {
                ResolvableType resolveVariable2 = resolveVariable(typeVariable, resolvableType2);
                if (resolveVariable2.resolve() != null) {
                    return resolveVariable2;
                }
            }
            return ResolvableType.NONE;
        }
    }
}
