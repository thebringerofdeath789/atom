package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: classes.dex */
public class JavaBeanDeserializer implements ObjectDeserializer {
    private final Map<String, FieldDeserializer> alterNameFieldDeserializers;
    public final JavaBeanInfo beanInfo;
    protected final Class<?> clazz;
    private ConcurrentMap<String, Object> extraFieldDeserializers;
    private Map<String, FieldDeserializer> fieldDeserializerMap;
    private final FieldDeserializer[] fieldDeserializers;
    private transient long[] hashArray;
    private transient short[] hashArrayMapping;
    private transient long[] smartMatchHashArray;
    private transient short[] smartMatchHashArrayMapping;
    protected final FieldDeserializer[] sortedFieldDeserializers;

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls) {
        this(parserConfig, cls, cls);
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type) {
        this(parserConfig, JavaBeanInfo.build(cls, type, parserConfig.propertyNamingStrategy, parserConfig.fieldBased, parserConfig.compatibleWithJavaBean, parserConfig.isJacksonCompatible()));
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo) {
        this.clazz = javaBeanInfo.clazz;
        this.beanInfo = javaBeanInfo;
        this.sortedFieldDeserializers = new FieldDeserializer[javaBeanInfo.sortedFields.length];
        int length = javaBeanInfo.sortedFields.length;
        HashMap hashMap = null;
        for (int i = 0; i < length; i++) {
            FieldInfo fieldInfo = javaBeanInfo.sortedFields[i];
            FieldDeserializer createFieldDeserializer = parserConfig.createFieldDeserializer(parserConfig, javaBeanInfo, fieldInfo);
            this.sortedFieldDeserializers[i] = createFieldDeserializer;
            if (length > 128) {
                if (this.fieldDeserializerMap == null) {
                    this.fieldDeserializerMap = new HashMap();
                }
                this.fieldDeserializerMap.put(fieldInfo.name, createFieldDeserializer);
            }
            for (String str : fieldInfo.alternateNames) {
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                hashMap.put(str, createFieldDeserializer);
            }
        }
        this.alterNameFieldDeserializers = hashMap;
        this.fieldDeserializers = new FieldDeserializer[javaBeanInfo.fields.length];
        int length2 = javaBeanInfo.fields.length;
        for (int i2 = 0; i2 < length2; i2++) {
            this.fieldDeserializers[i2] = getFieldDeserializer(javaBeanInfo.fields[i2].name);
        }
    }

    public FieldDeserializer getFieldDeserializer(String str) {
        return getFieldDeserializer(str, null);
    }

    public FieldDeserializer getFieldDeserializer(String str, int[] iArr) {
        FieldDeserializer fieldDeserializer;
        if (str == null) {
            return null;
        }
        Map<String, FieldDeserializer> map = this.fieldDeserializerMap;
        if (map != null && (fieldDeserializer = map.get(str)) != null) {
            return fieldDeserializer;
        }
        int i = 0;
        int length = this.sortedFieldDeserializers.length - 1;
        while (i <= length) {
            int i2 = (i + length) >>> 1;
            int compareTo = this.sortedFieldDeserializers[i2].fieldInfo.name.compareTo(str);
            if (compareTo < 0) {
                i = i2 + 1;
            } else {
                if (compareTo <= 0) {
                    if (isSetFlag(i2, iArr)) {
                        return null;
                    }
                    return this.sortedFieldDeserializers[i2];
                }
                length = i2 - 1;
            }
        }
        Map<String, FieldDeserializer> map2 = this.alterNameFieldDeserializers;
        if (map2 != null) {
            return map2.get(str);
        }
        return null;
    }

    public FieldDeserializer getFieldDeserializer(long j) {
        int i = 0;
        if (this.hashArray == null) {
            long[] jArr = new long[this.sortedFieldDeserializers.length];
            int i2 = 0;
            while (true) {
                FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                if (i2 >= fieldDeserializerArr.length) {
                    break;
                }
                jArr[i2] = TypeUtils.fnv1a_64(fieldDeserializerArr[i2].fieldInfo.name);
                i2++;
            }
            Arrays.sort(jArr);
            this.hashArray = jArr;
        }
        int binarySearch = Arrays.binarySearch(this.hashArray, j);
        if (binarySearch < 0) {
            return null;
        }
        if (this.hashArrayMapping == null) {
            short[] sArr = new short[this.hashArray.length];
            Arrays.fill(sArr, (short) -1);
            while (true) {
                FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                if (i >= fieldDeserializerArr2.length) {
                    break;
                }
                int binarySearch2 = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(fieldDeserializerArr2[i].fieldInfo.name));
                if (binarySearch2 >= 0) {
                    sArr[binarySearch2] = (short) i;
                }
                i++;
            }
            this.hashArrayMapping = sArr;
        }
        short s = this.hashArrayMapping[binarySearch];
        if (s != -1) {
            return this.sortedFieldDeserializers[s];
        }
        return null;
    }

    static boolean isSetFlag(int i, int[] iArr) {
        if (iArr == null) {
            return false;
        }
        int i2 = i / 32;
        int i3 = i % 32;
        if (i2 < iArr.length) {
            if (((1 << i3) & iArr[i2]) != 0) {
                return true;
            }
        }
        return false;
    }

    public Object createInstance(DefaultJSONParser defaultJSONParser, Type type) {
        Object newInstance;
        if ((type instanceof Class) && this.clazz.isInterface()) {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new JSONObject());
        }
        Object obj = null;
        if (this.beanInfo.defaultConstructor == null && this.beanInfo.factoryMethod == null) {
            return null;
        }
        if (this.beanInfo.factoryMethod != null && this.beanInfo.defaultConstructorParameterSize > 0) {
            return null;
        }
        try {
            Constructor<?> constructor = this.beanInfo.defaultConstructor;
            if (this.beanInfo.defaultConstructorParameterSize != 0) {
                ParseContext context = defaultJSONParser.getContext();
                if (context == null || context.object == null) {
                    throw new JSONException("can't create non-static inner class instance.");
                }
                if (type instanceof Class) {
                    String name = ((Class) type).getName();
                    String substring = name.substring(0, name.lastIndexOf(36));
                    Object obj2 = context.object;
                    String name2 = obj2.getClass().getName();
                    if (!name2.equals(substring)) {
                        ParseContext parseContext = context.parent;
                        if (parseContext == null || parseContext.object == null || !("java.util.ArrayList".equals(name2) || "java.util.List".equals(name2) || "java.util.Collection".equals(name2) || "java.util.Map".equals(name2) || "java.util.HashMap".equals(name2))) {
                            obj = obj2;
                        } else if (parseContext.object.getClass().getName().equals(substring)) {
                            obj = parseContext.object;
                        }
                        obj2 = obj;
                    }
                    if (obj2 == null || ((obj2 instanceof Collection) && ((Collection) obj2).isEmpty())) {
                        throw new JSONException("can't create non-static inner class instance.");
                    }
                    newInstance = constructor.newInstance(obj2);
                } else {
                    throw new JSONException("can't create non-static inner class instance.");
                }
            } else if (constructor != null) {
                newInstance = constructor.newInstance(new Object[0]);
            } else {
                newInstance = this.beanInfo.factoryMethod.invoke(null, new Object[0]);
            }
            if (defaultJSONParser != null && defaultJSONParser.lexer.isEnabled(Feature.InitStringFieldAsEmpty)) {
                for (FieldInfo fieldInfo : this.beanInfo.fields) {
                    if (fieldInfo.fieldClass == String.class) {
                        try {
                            fieldInfo.set(newInstance, "");
                        } catch (Exception e) {
                            throw new JSONException("create instance error, class " + this.clazz.getName(), e);
                        }
                    }
                }
            }
            return newInstance;
        } catch (JSONException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new JSONException("create instance error, class " + this.clazz.getName(), e3);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, 0);
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, int i) {
        return (T) deserialze(defaultJSONParser, type, obj, null, i, null);
    }

    public <T> T deserialzeArrayMapping(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        Enum<?> scanEnum;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() != 14) {
            throw new JSONException(IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR);
        }
        T t = (T) createInstance(defaultJSONParser, type);
        int i = 0;
        int length = this.sortedFieldDeserializers.length;
        while (true) {
            if (i >= length) {
                break;
            }
            char c = i == length + (-1) ? ']' : ',';
            FieldDeserializer fieldDeserializer = this.sortedFieldDeserializers[i];
            Class<?> cls = fieldDeserializer.fieldInfo.fieldClass;
            if (cls == Integer.TYPE) {
                fieldDeserializer.setValue((Object) t, jSONLexer.scanInt(c));
            } else if (cls == String.class) {
                fieldDeserializer.setValue((Object) t, jSONLexer.scanString(c));
            } else if (cls == Long.TYPE) {
                fieldDeserializer.setValue(t, jSONLexer.scanLong(c));
            } else if (cls.isEnum()) {
                char current = jSONLexer.getCurrent();
                if (current == '\"' || current == 'n') {
                    scanEnum = jSONLexer.scanEnum(cls, defaultJSONParser.getSymbolTable(), c);
                } else if (current >= '0' && current <= '9') {
                    scanEnum = ((EnumDeserializer) ((DefaultFieldDeserializer) fieldDeserializer).getFieldValueDeserilizer(defaultJSONParser.getConfig())).valueOf(jSONLexer.scanInt(c));
                } else {
                    scanEnum = scanEnum(jSONLexer, c);
                }
                fieldDeserializer.setValue(t, scanEnum);
            } else if (cls == Boolean.TYPE) {
                fieldDeserializer.setValue(t, jSONLexer.scanBoolean(c));
            } else if (cls == Float.TYPE) {
                fieldDeserializer.setValue(t, Float.valueOf(jSONLexer.scanFloat(c)));
            } else if (cls == Double.TYPE) {
                fieldDeserializer.setValue(t, Double.valueOf(jSONLexer.scanDouble(c)));
            } else if (cls == Date.class && jSONLexer.getCurrent() == '1') {
                fieldDeserializer.setValue(t, new Date(jSONLexer.scanLong(c)));
            } else if (cls == BigDecimal.class) {
                fieldDeserializer.setValue(t, jSONLexer.scanDecimal(c));
            } else {
                jSONLexer.nextToken(14);
                fieldDeserializer.setValue(t, defaultJSONParser.parseObject(fieldDeserializer.fieldInfo.fieldType, fieldDeserializer.fieldInfo.name));
                if (jSONLexer.token() == 15) {
                    break;
                }
                check(jSONLexer, c == ']' ? 15 : 16);
            }
            i++;
        }
        jSONLexer.nextToken(16);
        return t;
    }

    protected void check(JSONLexer jSONLexer, int i) {
        if (jSONLexer.token() != i) {
            throw new JSONException("syntax error");
        }
    }

    protected Enum<?> scanEnum(JSONLexer jSONLexer, char c) {
        throw new JSONException("illegal enum. " + jSONLexer.info());
    }

    /* JADX WARN: Code restructure failed: missing block: B:178:0x09ab, code lost:
    
        throw new com.alibaba.fastjson.JSONException("syntax error, unexpect token " + com.alibaba.fastjson.parser.JSONToken.name(r12.token()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x06cc, code lost:
    
        r12.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x06cf, code lost:
    
        r1 = r16;
        r5 = r30;
        r15 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:450:0x069b, code lost:
    
        r12.nextToken();
     */
    /* JADX WARN: Code restructure failed: missing block: B:467:0x0416, code lost:
    
        if (r12.isEnabled(com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas) != false) goto L324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:539:0x0536, code lost:
    
        r2 = getSeeAlso(r13, r33.beanInfo, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:540:0x053c, code lost:
    
        if (r2 != null) goto L396;
     */
    /* JADX WARN: Code restructure failed: missing block: B:541:0x053e, code lost:
    
        r15 = r13.checkAutoType(r1, com.alibaba.fastjson.util.TypeUtils.getClass(r35), r12.getFeatures());
        r2 = r34.getConfig().getDeserializer(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:542:0x0554, code lost:
    
        r3 = (T) r2.deserialze(r34, r15, r36);
     */
    /* JADX WARN: Code restructure failed: missing block: B:543:0x055a, code lost:
    
        if ((r2 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) == false) goto L402;
     */
    /* JADX WARN: Code restructure failed: missing block: B:544:0x055c, code lost:
    
        r2 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:545:0x055e, code lost:
    
        if (r4 == null) goto L402;
     */
    /* JADX WARN: Code restructure failed: missing block: B:546:0x0560, code lost:
    
        r2.getFieldDeserializer(r4).setValue((java.lang.Object) r3, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:547:0x0567, code lost:
    
        if (r5 == null) goto L404;
     */
    /* JADX WARN: Code restructure failed: missing block: B:548:0x0569, code lost:
    
        r5.object = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:549:0x056d, code lost:
    
        r34.setContext(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:550:0x0570, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:552:0x0553, code lost:
    
        r15 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:730:0x0385, code lost:
    
        if (r12.matchStat == (-2)) goto L290;
     */
    /* JADX WARN: Removed duplicated region for block: B:138:0x05b7  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x05c2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x05fd  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x06c1  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x09cf  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x06c6 A[Catch: all -> 0x09b9, TryCatch #16 {all -> 0x09b9, blocks: (B:155:0x06b9, B:169:0x06c6, B:181:0x06cc, B:438:0x068f, B:440:0x06b1), top: B:154:0x06b9 }] */
    /* JADX WARN: Removed duplicated region for block: B:262:0x089b A[Catch: all -> 0x08f3, TRY_ENTER, TryCatch #13 {all -> 0x08f3, blocks: (B:305:0x086e, B:307:0x0871, B:309:0x0875, B:311:0x087b, B:313:0x0882, B:262:0x089b, B:263:0x08a3, B:265:0x08a9, B:268:0x08bb, B:297:0x08c8, B:298:0x08f2), top: B:304:0x086e }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0072 A[Catch: all -> 0x0049, TRY_LEAVE, TryCatch #8 {all -> 0x0049, blocks: (B:17:0x0039, B:19:0x003e, B:25:0x0055, B:27:0x0060, B:29:0x0068, B:34:0x0072, B:41:0x0082, B:46:0x008e, B:48:0x0098, B:51:0x009f, B:53:0x00a5, B:55:0x00b1, B:58:0x00bb, B:68:0x00ce, B:70:0x00d6, B:73:0x00e0, B:75:0x00e6, B:79:0x00ee, B:83:0x00fe, B:86:0x0111, B:90:0x011a, B:95:0x012b, B:96:0x0134, B:97:0x0135, B:99:0x015b, B:100:0x0164, B:101:0x0178, B:103:0x00c9, B:109:0x017f), top: B:15:0x0037, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:437:0x0672  */
    /* JADX WARN: Removed duplicated region for block: B:457:0x03ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:693:0x031e A[Catch: all -> 0x041e, TryCatch #21 {all -> 0x041e, blocks: (B:462:0x03f9, B:569:0x0403, B:466:0x0410, B:476:0x042b, B:478:0x0434, B:480:0x0440, B:491:0x0444, B:493:0x044c, B:495:0x0452, B:496:0x0456, B:498:0x0462, B:501:0x046b, B:503:0x046f, B:505:0x0472, B:507:0x0476, B:508:0x0479, B:509:0x0485, B:511:0x048d, B:512:0x0493, B:514:0x0499, B:516:0x049f, B:518:0x04a5, B:521:0x04ab, B:522:0x04af, B:525:0x04b7, B:526:0x04e7, B:527:0x0503, B:529:0x0506, B:541:0x053e, B:544:0x055c, B:546:0x0560, B:581:0x01f6, B:588:0x0204, B:591:0x0210, B:594:0x0387, B:598:0x021f, B:600:0x0223, B:603:0x022c, B:608:0x0236, B:611:0x023f, B:616:0x0249, B:619:0x0252, B:622:0x0258, B:627:0x0262, B:632:0x026c, B:637:0x0276, B:639:0x027c, B:642:0x028a, B:644:0x0292, B:646:0x0296, B:652:0x02a6, B:659:0x02b7, B:662:0x02c1, B:667:0x02cc, B:670:0x02d6, B:675:0x02e1, B:678:0x02eb, B:681:0x02f2, B:685:0x02fe, B:687:0x0306, B:690:0x0316, B:693:0x031e, B:697:0x0311, B:699:0x0329, B:701:0x0333, B:704:0x033f, B:707:0x0344, B:710:0x033a, B:711:0x034a, B:714:0x035c, B:717:0x0361, B:720:0x0357, B:721:0x0367, B:723:0x0371, B:726:0x037d, B:729:0x0382, B:731:0x0378, B:732:0x039a, B:734:0x03a2, B:737:0x03af, B:740:0x03b6, B:745:0x03aa), top: B:461:0x03f9 }] */
    /* JADX WARN: Removed duplicated region for block: B:739:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:740:0x03b6 A[Catch: all -> 0x041e, TRY_LEAVE, TryCatch #21 {all -> 0x041e, blocks: (B:462:0x03f9, B:569:0x0403, B:466:0x0410, B:476:0x042b, B:478:0x0434, B:480:0x0440, B:491:0x0444, B:493:0x044c, B:495:0x0452, B:496:0x0456, B:498:0x0462, B:501:0x046b, B:503:0x046f, B:505:0x0472, B:507:0x0476, B:508:0x0479, B:509:0x0485, B:511:0x048d, B:512:0x0493, B:514:0x0499, B:516:0x049f, B:518:0x04a5, B:521:0x04ab, B:522:0x04af, B:525:0x04b7, B:526:0x04e7, B:527:0x0503, B:529:0x0506, B:541:0x053e, B:544:0x055c, B:546:0x0560, B:581:0x01f6, B:588:0x0204, B:591:0x0210, B:594:0x0387, B:598:0x021f, B:600:0x0223, B:603:0x022c, B:608:0x0236, B:611:0x023f, B:616:0x0249, B:619:0x0252, B:622:0x0258, B:627:0x0262, B:632:0x026c, B:637:0x0276, B:639:0x027c, B:642:0x028a, B:644:0x0292, B:646:0x0296, B:652:0x02a6, B:659:0x02b7, B:662:0x02c1, B:667:0x02cc, B:670:0x02d6, B:675:0x02e1, B:678:0x02eb, B:681:0x02f2, B:685:0x02fe, B:687:0x0306, B:690:0x0316, B:693:0x031e, B:697:0x0311, B:699:0x0329, B:701:0x0333, B:704:0x033f, B:707:0x0344, B:710:0x033a, B:711:0x034a, B:714:0x035c, B:717:0x0361, B:720:0x0357, B:721:0x0367, B:723:0x0371, B:726:0x037d, B:729:0x0382, B:731:0x0378, B:732:0x039a, B:734:0x03a2, B:737:0x03af, B:740:0x03b6, B:745:0x03aa), top: B:461:0x03f9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r34, java.lang.reflect.Type r35, java.lang.Object r36, java.lang.Object r37, int r38, int[] r39) {
        /*
            Method dump skipped, instructions count: 2522
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object, java.lang.Object, int, int[]):java.lang.Object");
    }

    protected Enum scanEnum(JSONLexerBase jSONLexerBase, char[] cArr, ObjectDeserializer objectDeserializer) {
        EnumDeserializer enumDeserializer = objectDeserializer instanceof EnumDeserializer ? (EnumDeserializer) objectDeserializer : null;
        if (enumDeserializer == null) {
            jSONLexerBase.matchStat = -1;
            return null;
        }
        long scanEnumSymbol = jSONLexerBase.scanEnumSymbol(cArr);
        if (jSONLexerBase.matchStat <= 0) {
            return null;
        }
        Enum enumByHashCode = enumDeserializer.getEnumByHashCode(scanEnumSymbol);
        if (enumByHashCode == null) {
            if (scanEnumSymbol == -3750763034362895579L) {
                return null;
            }
            if (jSONLexerBase.isEnabled(Feature.ErrorOnEnumNotMatch)) {
                throw new JSONException("not match enum value, " + enumDeserializer.enumClass);
            }
        }
        return enumByHashCode;
    }

    public boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map) {
        return parseField(defaultJSONParser, str, obj, type, map, null);
    }

    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v4 */
    public boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map, int[] iArr) {
        FieldDeserializer fieldDeserializer;
        ?? r17;
        JSONLexer jSONLexer;
        JSONLexer jSONLexer2 = defaultJSONParser.lexer;
        int i = Feature.DisableFieldSmartMatch.mask;
        if (jSONLexer2.isEnabled(i) || (i & this.beanInfo.parserFeatures) != 0) {
            fieldDeserializer = getFieldDeserializer(str);
        } else {
            fieldDeserializer = smartMatch(str, iArr);
        }
        int i2 = Feature.SupportNonPublicField.mask;
        if (fieldDeserializer != null || (!jSONLexer2.isEnabled(i2) && (i2 & this.beanInfo.parserFeatures) == 0)) {
            r17 = 1;
            jSONLexer = jSONLexer2;
        } else {
            if (this.extraFieldDeserializers == null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(1, 0.75f, 1);
                for (Class<?> cls = this.clazz; cls != null && cls != Object.class; cls = cls.getSuperclass()) {
                    for (Field field : cls.getDeclaredFields()) {
                        String name = field.getName();
                        if (getFieldDeserializer(name) == null) {
                            int modifiers = field.getModifiers();
                            if ((modifiers & 16) == 0 && (modifiers & 8) == 0) {
                                concurrentHashMap.put(name, field);
                            }
                        }
                    }
                }
                this.extraFieldDeserializers = concurrentHashMap;
            }
            Object obj2 = this.extraFieldDeserializers.get(str);
            if (obj2 != null) {
                if (obj2 instanceof FieldDeserializer) {
                    fieldDeserializer = (FieldDeserializer) obj2;
                } else {
                    Field field2 = (Field) obj2;
                    field2.setAccessible(true);
                    r17 = 1;
                    jSONLexer = jSONLexer2;
                    fieldDeserializer = new DefaultFieldDeserializer(defaultJSONParser.getConfig(), this.clazz, new FieldInfo(str, field2.getDeclaringClass(), field2.getType(), field2.getGenericType(), field2, 0, 0, 0));
                    this.extraFieldDeserializers.put(str, fieldDeserializer);
                }
            }
            jSONLexer = jSONLexer2;
            r17 = 1;
        }
        if (fieldDeserializer == null) {
            if (!jSONLexer.isEnabled(Feature.IgnoreNotMatch)) {
                throw new JSONException("setter not found, class " + this.clazz.getName() + ", property " + str);
            }
            int i3 = -1;
            int i4 = 0;
            while (true) {
                FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                if (i4 >= fieldDeserializerArr.length) {
                    break;
                }
                FieldDeserializer fieldDeserializer2 = fieldDeserializerArr[i4];
                FieldInfo fieldInfo = fieldDeserializer2.fieldInfo;
                if (fieldInfo.unwrapped && (fieldDeserializer2 instanceof DefaultFieldDeserializer)) {
                    if (fieldInfo.field != null) {
                        DefaultFieldDeserializer defaultFieldDeserializer = (DefaultFieldDeserializer) fieldDeserializer2;
                        ObjectDeserializer fieldValueDeserilizer = defaultFieldDeserializer.getFieldValueDeserilizer(defaultJSONParser.getConfig());
                        if (fieldValueDeserilizer instanceof JavaBeanDeserializer) {
                            FieldDeserializer fieldDeserializer3 = ((JavaBeanDeserializer) fieldValueDeserilizer).getFieldDeserializer(str);
                            if (fieldDeserializer3 != null) {
                                try {
                                    Object obj3 = fieldInfo.field.get(obj);
                                    if (obj3 == null) {
                                        obj3 = ((JavaBeanDeserializer) fieldValueDeserilizer).createInstance(defaultJSONParser, fieldInfo.fieldType);
                                        fieldDeserializer2.setValue(obj, obj3);
                                    }
                                    jSONLexer.nextTokenWithColon(defaultFieldDeserializer.getFastMatchToken());
                                    fieldDeserializer3.parseField(defaultJSONParser, obj3, type, map);
                                    i3 = i4;
                                } catch (Exception e) {
                                    throw new JSONException("parse unwrapped field error.", e);
                                }
                            } else {
                                continue;
                            }
                        } else if (fieldValueDeserilizer instanceof MapDeserializer) {
                            MapDeserializer mapDeserializer = (MapDeserializer) fieldValueDeserilizer;
                            try {
                                Map<Object, Object> map2 = (Map) fieldInfo.field.get(obj);
                                if (map2 == null) {
                                    map2 = mapDeserializer.createMap(fieldInfo.fieldType);
                                    fieldDeserializer2.setValue(obj, map2);
                                }
                                jSONLexer.nextTokenWithColon();
                                map2.put(str, defaultJSONParser.parse(str));
                                i3 = i4;
                            } catch (Exception e2) {
                                throw new JSONException("parse unwrapped field error.", e2);
                            }
                        } else {
                            continue;
                        }
                    } else if (fieldInfo.method.getParameterTypes().length == 2) {
                        jSONLexer.nextTokenWithColon();
                        Object parse = defaultJSONParser.parse(str);
                        try {
                            Method method = fieldInfo.method;
                            Object[] objArr = new Object[2];
                            objArr[0] = str;
                            objArr[r17] = parse;
                            method.invoke(obj, objArr);
                            i3 = i4;
                        } catch (Exception e3) {
                            throw new JSONException("parse unwrapped field error.", e3);
                        }
                    } else {
                        continue;
                    }
                }
                i4++;
            }
            if (i3 == -1) {
                defaultJSONParser.parseExtra(obj, str);
                return false;
            }
            if (iArr != null) {
                int i5 = i3 / 32;
                iArr[i5] = iArr[i5] | (r17 << (i3 % 32));
            }
            return r17;
        }
        JSONLexer jSONLexer3 = jSONLexer;
        int i6 = 0;
        while (true) {
            FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
            if (i6 >= fieldDeserializerArr2.length) {
                i6 = -1;
                break;
            }
            if (fieldDeserializerArr2[i6] == fieldDeserializer) {
                break;
            }
            i6++;
        }
        if (i6 != -1 && iArr != null && str.startsWith("_") && isSetFlag(i6, iArr)) {
            defaultJSONParser.parseExtra(obj, str);
            return false;
        }
        jSONLexer3.nextTokenWithColon(fieldDeserializer.getFastMatchToken());
        fieldDeserializer.parseField(defaultJSONParser, obj, type, map);
        if (iArr != null) {
            int i7 = i6 / 32;
            iArr[i7] = iArr[i7] | (r17 << (i6 % 32));
        }
        return r17;
    }

    public FieldDeserializer smartMatch(String str) {
        return smartMatch(str, null);
    }

    public FieldDeserializer smartMatch(String str, int[] iArr) {
        boolean z;
        if (str == null) {
            return null;
        }
        FieldDeserializer fieldDeserializer = getFieldDeserializer(str, iArr);
        if (fieldDeserializer == null) {
            long fnv1a_64_lower = TypeUtils.fnv1a_64_lower(str);
            int i = 0;
            if (this.smartMatchHashArray == null) {
                long[] jArr = new long[this.sortedFieldDeserializers.length];
                int i2 = 0;
                while (true) {
                    FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                    if (i2 >= fieldDeserializerArr.length) {
                        break;
                    }
                    jArr[i2] = TypeUtils.fnv1a_64_lower(fieldDeserializerArr[i2].fieldInfo.name);
                    i2++;
                }
                Arrays.sort(jArr);
                this.smartMatchHashArray = jArr;
            }
            int binarySearch = Arrays.binarySearch(this.smartMatchHashArray, fnv1a_64_lower);
            if (binarySearch < 0) {
                z = str.startsWith("is");
                if (z) {
                    binarySearch = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv1a_64_lower(str.substring(2)));
                }
            } else {
                z = false;
            }
            if (binarySearch >= 0) {
                if (this.smartMatchHashArrayMapping == null) {
                    short[] sArr = new short[this.smartMatchHashArray.length];
                    Arrays.fill(sArr, (short) -1);
                    while (true) {
                        FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                        if (i >= fieldDeserializerArr2.length) {
                            break;
                        }
                        int binarySearch2 = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv1a_64_lower(fieldDeserializerArr2[i].fieldInfo.name));
                        if (binarySearch2 >= 0) {
                            sArr[binarySearch2] = (short) i;
                        }
                        i++;
                    }
                    this.smartMatchHashArrayMapping = sArr;
                }
                short s = this.smartMatchHashArrayMapping[binarySearch];
                if (s != -1 && !isSetFlag(s, iArr)) {
                    fieldDeserializer = this.sortedFieldDeserializers[s];
                }
            }
            if (fieldDeserializer != null) {
                FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                if ((fieldInfo.parserFeatures & Feature.DisableFieldSmartMatch.mask) != 0) {
                    return null;
                }
                Class<?> cls = fieldInfo.fieldClass;
                if (z && cls != Boolean.TYPE && cls != Boolean.class) {
                    return null;
                }
            }
        }
        return fieldDeserializer;
    }

    private Object createFactoryInstance(ParserConfig parserConfig, Object obj) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        return this.beanInfo.factoryMethod.invoke(null, obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:174:0x01d6, code lost:
    
        if (r11.beanInfo.fields[r12].fieldClass == java.lang.String.class) goto L125;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object createInstance(java.util.Map<java.lang.String, java.lang.Object> r12, com.alibaba.fastjson.parser.ParserConfig r13) throws java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 655
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.createInstance(java.util.Map, com.alibaba.fastjson.parser.ParserConfig):java.lang.Object");
    }

    public Type getFieldType(int i) {
        return this.sortedFieldDeserializers[i].fieldInfo.fieldType;
    }

    protected Object parseRest(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i) {
        return parseRest(defaultJSONParser, type, obj, obj2, i, new int[0]);
    }

    protected Object parseRest(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i, int[] iArr) {
        return deserialze(defaultJSONParser, type, obj, obj2, i, iArr);
    }

    protected JavaBeanDeserializer getSeeAlso(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, String str) {
        if (javaBeanInfo.jsonType == null) {
            return null;
        }
        for (Class<?> cls : javaBeanInfo.jsonType.seeAlso()) {
            ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
            if (deserializer instanceof JavaBeanDeserializer) {
                JavaBeanDeserializer javaBeanDeserializer = (JavaBeanDeserializer) deserializer;
                JavaBeanInfo javaBeanInfo2 = javaBeanDeserializer.beanInfo;
                if (javaBeanInfo2.typeName.equals(str)) {
                    return javaBeanDeserializer;
                }
                JavaBeanDeserializer seeAlso = getSeeAlso(parserConfig, javaBeanInfo2, str);
                if (seeAlso != null) {
                    return seeAlso;
                }
            }
        }
        return null;
    }

    protected static void parseArray(Collection collection, ObjectDeserializer objectDeserializer, DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.lexer;
        int i = jSONLexerBase.token();
        if (i == 8) {
            jSONLexerBase.nextToken(16);
            jSONLexerBase.token();
            return;
        }
        if (i != 14) {
            defaultJSONParser.throwException(i);
        }
        if (jSONLexerBase.getCurrent() == '[') {
            jSONLexerBase.next();
            jSONLexerBase.setToken(14);
        } else {
            jSONLexerBase.nextToken(14);
        }
        if (jSONLexerBase.token() == 15) {
            jSONLexerBase.nextToken();
            return;
        }
        int i2 = 0;
        while (true) {
            collection.add(objectDeserializer.deserialze(defaultJSONParser, type, Integer.valueOf(i2)));
            i2++;
            if (jSONLexerBase.token() != 16) {
                break;
            }
            if (jSONLexerBase.getCurrent() == '[') {
                jSONLexerBase.next();
                jSONLexerBase.setToken(14);
            } else {
                jSONLexerBase.nextToken(14);
            }
        }
        int i3 = jSONLexerBase.token();
        if (i3 != 15) {
            defaultJSONParser.throwException(i3);
        }
        if (jSONLexerBase.getCurrent() == ',') {
            jSONLexerBase.next();
            jSONLexerBase.setToken(16);
        } else {
            jSONLexerBase.nextToken(16);
        }
    }
}
