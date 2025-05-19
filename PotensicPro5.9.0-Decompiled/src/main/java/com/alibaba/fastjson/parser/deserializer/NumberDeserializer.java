package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.math.BigDecimal;

/* loaded from: classes.dex */
public class NumberDeserializer implements ObjectDeserializer {
    public static final NumberDeserializer instance = new NumberDeserializer();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 2) {
            if (type == Double.TYPE || type == Double.class) {
                String numberString = jSONLexer.numberString();
                jSONLexer.nextToken(16);
                return (T) Double.valueOf(Double.parseDouble(numberString));
            }
            long longValue = jSONLexer.longValue();
            jSONLexer.nextToken(16);
            if (type == Short.TYPE || type == Short.class) {
                if (longValue > 32767 || longValue < -32768) {
                    throw new JSONException("short overflow : " + longValue);
                }
                return (T) Short.valueOf((short) longValue);
            }
            if (type == Byte.TYPE || type == Byte.class) {
                if (longValue > 127 || longValue < -128) {
                    throw new JSONException("short overflow : " + longValue);
                }
                return (T) Byte.valueOf((byte) longValue);
            }
            if (longValue >= -2147483648L && longValue <= 2147483647L) {
                return (T) Integer.valueOf((int) longValue);
            }
            return (T) Long.valueOf(longValue);
        }
        if (jSONLexer.token() == 3) {
            if (type == Double.TYPE || type == Double.class) {
                String numberString2 = jSONLexer.numberString();
                jSONLexer.nextToken(16);
                return (T) Double.valueOf(Double.parseDouble(numberString2));
            }
            if (type == Short.TYPE || type == Short.class) {
                BigDecimal decimalValue = jSONLexer.decimalValue();
                jSONLexer.nextToken(16);
                return (T) Short.valueOf(TypeUtils.shortValue(decimalValue));
            }
            if (type == Byte.TYPE || type == Byte.class) {
                BigDecimal decimalValue2 = jSONLexer.decimalValue();
                jSONLexer.nextToken(16);
                return (T) Byte.valueOf(TypeUtils.byteValue(decimalValue2));
            }
            T t = (T) jSONLexer.decimalValue();
            jSONLexer.nextToken(16);
            return t;
        }
        if (jSONLexer.token() == 18 && "NaN".equals(jSONLexer.stringVal())) {
            jSONLexer.nextToken();
            if (type == Double.class) {
                return (T) Double.valueOf(Double.NaN);
            }
            if (type == Float.class) {
                return (T) Float.valueOf(Float.NaN);
            }
            return null;
        }
        Object parse = defaultJSONParser.parse();
        if (parse == null) {
            return null;
        }
        if (type == Double.TYPE || type == Double.class) {
            try {
                return (T) TypeUtils.castToDouble(parse);
            } catch (Exception e) {
                throw new JSONException("parseDouble error, field : " + obj, e);
            }
        }
        if (type == Short.TYPE || type == Short.class) {
            try {
                return (T) TypeUtils.castToShort(parse);
            } catch (Exception e2) {
                throw new JSONException("parseShort error, field : " + obj, e2);
            }
        }
        if (type == Byte.TYPE || type == Byte.class) {
            try {
                return (T) TypeUtils.castToByte(parse);
            } catch (Exception e3) {
                throw new JSONException("parseByte error, field : " + obj, e3);
            }
        }
        return (T) TypeUtils.castToBigDecimal(parse);
    }
}
