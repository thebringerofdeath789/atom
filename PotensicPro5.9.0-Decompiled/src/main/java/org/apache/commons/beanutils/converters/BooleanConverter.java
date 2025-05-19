package org.apache.commons.beanutils.converters;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import org.apache.commons.lang3.BooleanUtils;

/* loaded from: classes4.dex */
public final class BooleanConverter extends AbstractConverter {

    @Deprecated
    public static final Object NO_DEFAULT = new Object();
    private String[] falseStrings;
    private String[] trueStrings;

    public BooleanConverter() {
        this.trueStrings = new String[]{BooleanUtils.TRUE, BooleanUtils.YES, "y", "on", "1"};
        this.falseStrings = new String[]{"false", BooleanUtils.NO, "n", "off", SessionDescription.SUPPORTED_SDP_VERSION};
    }

    public BooleanConverter(Object obj) {
        this.trueStrings = new String[]{BooleanUtils.TRUE, BooleanUtils.YES, "y", "on", "1"};
        this.falseStrings = new String[]{"false", BooleanUtils.NO, "n", "off", SessionDescription.SUPPORTED_SDP_VERSION};
        if (obj != NO_DEFAULT) {
            setDefaultValue(obj);
        }
    }

    public BooleanConverter(String[] strArr, String[] strArr2) {
        this.trueStrings = new String[]{BooleanUtils.TRUE, BooleanUtils.YES, "y", "on", "1"};
        this.falseStrings = new String[]{"false", BooleanUtils.NO, "n", "off", SessionDescription.SUPPORTED_SDP_VERSION};
        this.trueStrings = copyStrings(strArr);
        this.falseStrings = copyStrings(strArr2);
    }

    public BooleanConverter(String[] strArr, String[] strArr2, Object obj) {
        this.trueStrings = new String[]{BooleanUtils.TRUE, BooleanUtils.YES, "y", "on", "1"};
        this.falseStrings = new String[]{"false", BooleanUtils.NO, "n", "off", SessionDescription.SUPPORTED_SDP_VERSION};
        this.trueStrings = copyStrings(strArr);
        this.falseStrings = copyStrings(strArr2);
        if (obj != NO_DEFAULT) {
            setDefaultValue(obj);
        }
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    protected Class<Boolean> getDefaultType() {
        return Boolean.class;
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    protected <T> T convertToType(Class<T> cls, Object obj) throws Throwable {
        if (Boolean.class.equals(cls) || Boolean.TYPE.equals(cls)) {
            String lowerCase = obj.toString().toLowerCase();
            for (String str : this.trueStrings) {
                if (str.equals(lowerCase)) {
                    return cls.cast(Boolean.TRUE);
                }
            }
            for (String str2 : this.falseStrings) {
                if (str2.equals(lowerCase)) {
                    return cls.cast(Boolean.FALSE);
                }
            }
        }
        throw conversionException(cls, obj);
    }

    private static String[] copyStrings(String[] strArr) {
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr2[i] = strArr[i].toLowerCase();
        }
        return strArr2;
    }
}
