package org.apache.xmlbeans.impl.schema;

import aavax.xml.namespace.QName;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.File;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.xmlbeans.Filer;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.values.XmlIntegerImpl;
import org.apache.xmlbeans.impl.values.XmlStringImpl;
import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes5.dex */
public class BuiltinSchemaTypeSystem extends SchemaTypeLoaderBase implements SchemaTypeSystem {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final SchemaAnnotation[] EMPTY_SCHEMAANNOTATION_ARRAY;
    private static final SchemaAttributeGroup[] EMPTY_SCHEMAATTRIBUTEGROUP_ARRAY;
    private static final SchemaGlobalAttribute[] EMPTY_SCHEMAATTRIBUTE_ARRAY;
    private static final SchemaGlobalElement[] EMPTY_SCHEMAELEMENT_ARRAY;
    private static final SchemaModelGroup[] EMPTY_SCHEMAMODELGROUP_ARRAY;
    private static final SchemaType.Ref[] EMPTY_SCHEMATYPEREF_ARRAY;
    private static final SchemaType[] EMPTY_SCHEMATYPE_ARRAY;
    private static final XmlValueRef[] FACETS_BUILTIN_LIST;
    private static final XmlValueRef[] FACETS_BYTE;
    private static final XmlValueRef[] FACETS_INT;
    private static final XmlValueRef[] FACETS_INTEGER;
    static final XmlValueRef[] FACETS_LIST;
    private static final XmlValueRef[] FACETS_LONG;
    private static final XmlValueRef[] FACETS_NEGATIVE;
    private static final XmlValueRef[] FACETS_NONE;
    private static final XmlValueRef[] FACETS_NONNEGATIVE;
    private static final XmlValueRef[] FACETS_NONPOSITIVE;
    private static final XmlValueRef[] FACETS_POSITIVE;
    private static final XmlValueRef[] FACETS_SHORT;
    static final XmlValueRef[] FACETS_UNION;
    private static final XmlValueRef[] FACETS_UNSIGNED_BYTE;
    private static final XmlValueRef[] FACETS_UNSIGNED_INT;
    private static final XmlValueRef[] FACETS_UNSIGNED_LONG;
    private static final XmlValueRef[] FACETS_UNSIGNED_SHORT;
    private static final XmlValueRef[] FACETS_WS_COLLAPSE;
    private static final XmlValueRef[] FACETS_WS_PRESERVE;
    private static final XmlValueRef[] FACETS_WS_REPLACE;
    private static final boolean[] FIXED_FACETS_INTEGER;
    static final boolean[] FIXED_FACETS_LIST;
    private static final boolean[] FIXED_FACETS_NONE;
    static final boolean[] FIXED_FACETS_UNION;
    private static final boolean[] FIXED_FACETS_WS;
    public static final SchemaTypeImpl ST_ANY_SIMPLE;
    public static final SchemaTypeImpl ST_ANY_TYPE;
    public static final SchemaTypeImpl ST_ANY_URI;
    public static final SchemaTypeImpl ST_BASE_64_BINARY;
    public static final SchemaTypeImpl ST_BOOLEAN;
    public static final SchemaTypeImpl ST_BYTE;
    public static final SchemaTypeImpl ST_DATE;
    public static final SchemaTypeImpl ST_DATE_TIME;
    public static final SchemaTypeImpl ST_DECIMAL;
    public static final SchemaTypeImpl ST_DOUBLE;
    public static final SchemaTypeImpl ST_DURATION;
    public static final SchemaTypeImpl ST_ENTITIES;
    public static final SchemaTypeImpl ST_ENTITY;
    public static final SchemaTypeImpl ST_FLOAT;
    public static final SchemaTypeImpl ST_G_DAY;
    public static final SchemaTypeImpl ST_G_MONTH;
    public static final SchemaTypeImpl ST_G_MONTH_DAY;
    public static final SchemaTypeImpl ST_G_YEAR;
    public static final SchemaTypeImpl ST_G_YEAR_MONTH;
    public static final SchemaTypeImpl ST_HEX_BINARY;
    public static final SchemaTypeImpl ST_ID;
    public static final SchemaTypeImpl ST_IDREF;
    public static final SchemaTypeImpl ST_IDREFS;
    public static final SchemaTypeImpl ST_INT;
    public static final SchemaTypeImpl ST_INTEGER;
    public static final SchemaTypeImpl ST_LANGUAGE;
    public static final SchemaTypeImpl ST_LONG;
    public static final SchemaTypeImpl ST_NAME;
    public static final SchemaTypeImpl ST_NCNAME;
    public static final SchemaTypeImpl ST_NEGATIVE_INTEGER;
    public static final SchemaTypeImpl ST_NMTOKEN;
    public static final SchemaTypeImpl ST_NMTOKENS;
    public static final SchemaTypeImpl ST_NON_NEGATIVE_INTEGER;
    public static final SchemaTypeImpl ST_NON_POSITIVE_INTEGER;
    public static final SchemaTypeImpl ST_NORMALIZED_STRING;
    public static final SchemaTypeImpl ST_NOTATION;
    public static final SchemaTypeImpl ST_NO_TYPE;
    public static final SchemaTypeImpl ST_POSITIVE_INTEGER;
    public static final SchemaTypeImpl ST_QNAME;
    public static final SchemaTypeImpl ST_SHORT;
    public static final SchemaTypeImpl ST_STRING;
    public static final SchemaTypeImpl ST_TIME;
    public static final SchemaTypeImpl ST_TOKEN;
    public static final SchemaTypeImpl ST_UNSIGNED_BYTE;
    public static final SchemaTypeImpl ST_UNSIGNED_INT;
    public static final SchemaTypeImpl ST_UNSIGNED_LONG;
    public static final SchemaTypeImpl ST_UNSIGNED_SHORT;
    private static final XmlValueRef XMLSTR_COLLAPSE;
    private static final XmlValueRef XMLSTR_PRESERVE;
    private static final XmlValueRef XMLSTR_REPLACE;
    private static BuiltinSchemaTypeSystem _global;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$schema$BuiltinSchemaTypeSystem;
    private SchemaContainer _container;
    private Map _typeMap = new HashMap();
    private SchemaTypeImpl[] _typeArray = new SchemaTypeImpl[47];
    private Map _handlesToObjects = new HashMap();
    private Map _objectsToHandles = new HashMap();
    private Map _typesByClassname = new HashMap();

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase, org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalAttribute findAttribute(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaAttributeGroup.Ref findAttributeGroupRef(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalAttribute.Ref findAttributeRef(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase, org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType findAttributeType(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findAttributeTypeRef(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase, org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType findDocumentType(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findDocumentTypeRef(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase, org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalElement findElement(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalElement.Ref findElementRef(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaIdentityConstraint.Ref findIdentityConstraintRef(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaModelGroup.Ref findModelGroupRef(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public String getName() {
        return "schema.typesystem.builtin";
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public InputStream getSourceAsStream(String str) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public void resolve() {
    }

    static {
        if (class$org$apache$xmlbeans$impl$schema$BuiltinSchemaTypeSystem == null) {
            class$org$apache$xmlbeans$impl$schema$BuiltinSchemaTypeSystem = class$("org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem");
        }
        $assertionsDisabled = true;
        EMPTY_SCHEMATYPE_ARRAY = new SchemaType[0];
        EMPTY_SCHEMATYPEREF_ARRAY = new SchemaType.Ref[0];
        EMPTY_SCHEMAELEMENT_ARRAY = new SchemaGlobalElement[0];
        EMPTY_SCHEMAATTRIBUTE_ARRAY = new SchemaGlobalAttribute[0];
        EMPTY_SCHEMAMODELGROUP_ARRAY = new SchemaModelGroup[0];
        EMPTY_SCHEMAATTRIBUTEGROUP_ARRAY = new SchemaAttributeGroup[0];
        EMPTY_SCHEMAANNOTATION_ARRAY = new SchemaAnnotation[0];
        BuiltinSchemaTypeSystem builtinSchemaTypeSystem = new BuiltinSchemaTypeSystem();
        _global = builtinSchemaTypeSystem;
        ST_ANY_TYPE = builtinSchemaTypeSystem.getBuiltinType(1);
        ST_ANY_SIMPLE = _global.getBuiltinType(2);
        ST_BOOLEAN = _global.getBuiltinType(3);
        ST_BASE_64_BINARY = _global.getBuiltinType(4);
        ST_HEX_BINARY = _global.getBuiltinType(5);
        ST_ANY_URI = _global.getBuiltinType(6);
        ST_QNAME = _global.getBuiltinType(7);
        ST_NOTATION = _global.getBuiltinType(8);
        ST_FLOAT = _global.getBuiltinType(9);
        ST_DOUBLE = _global.getBuiltinType(10);
        ST_DECIMAL = _global.getBuiltinType(11);
        ST_STRING = _global.getBuiltinType(12);
        ST_DURATION = _global.getBuiltinType(13);
        ST_DATE_TIME = _global.getBuiltinType(14);
        ST_TIME = _global.getBuiltinType(15);
        ST_DATE = _global.getBuiltinType(16);
        ST_G_YEAR_MONTH = _global.getBuiltinType(17);
        ST_G_YEAR = _global.getBuiltinType(18);
        ST_G_MONTH_DAY = _global.getBuiltinType(19);
        ST_G_DAY = _global.getBuiltinType(20);
        ST_G_MONTH = _global.getBuiltinType(21);
        ST_INTEGER = _global.getBuiltinType(22);
        ST_LONG = _global.getBuiltinType(23);
        ST_INT = _global.getBuiltinType(24);
        ST_SHORT = _global.getBuiltinType(25);
        ST_BYTE = _global.getBuiltinType(26);
        ST_NON_POSITIVE_INTEGER = _global.getBuiltinType(27);
        ST_NEGATIVE_INTEGER = _global.getBuiltinType(28);
        ST_NON_NEGATIVE_INTEGER = _global.getBuiltinType(29);
        ST_POSITIVE_INTEGER = _global.getBuiltinType(30);
        ST_UNSIGNED_LONG = _global.getBuiltinType(31);
        ST_UNSIGNED_INT = _global.getBuiltinType(32);
        ST_UNSIGNED_SHORT = _global.getBuiltinType(33);
        ST_UNSIGNED_BYTE = _global.getBuiltinType(34);
        ST_NORMALIZED_STRING = _global.getBuiltinType(35);
        ST_TOKEN = _global.getBuiltinType(36);
        ST_NAME = _global.getBuiltinType(37);
        ST_NCNAME = _global.getBuiltinType(38);
        ST_LANGUAGE = _global.getBuiltinType(39);
        ST_ID = _global.getBuiltinType(40);
        ST_IDREF = _global.getBuiltinType(41);
        ST_IDREFS = _global.getBuiltinType(42);
        ST_ENTITY = _global.getBuiltinType(43);
        ST_ENTITIES = _global.getBuiltinType(44);
        ST_NMTOKEN = _global.getBuiltinType(45);
        ST_NMTOKENS = _global.getBuiltinType(46);
        ST_NO_TYPE = _global.getBuiltinType(0);
        XMLSTR_PRESERVE = buildString("preserve");
        XMLSTR_REPLACE = buildString("preserve");
        XMLSTR_COLLAPSE = buildString("preserve");
        XmlValueRef[] xmlValueRefArr = {null, null, null, null, null, null, null, null, null, null, null, null};
        FACETS_NONE = xmlValueRefArr;
        boolean[] zArr = {false, false, false, false, false, false, false, false, false, false, false, false};
        FIXED_FACETS_NONE = zArr;
        XmlValueRef[] xmlValueRefArr2 = {null, null, null, null, null, null, null, null, null, build_wsstring(3), null, null};
        FACETS_WS_COLLAPSE = xmlValueRefArr2;
        FACETS_WS_REPLACE = new XmlValueRef[]{null, null, null, null, null, null, null, null, null, build_wsstring(2), null, null};
        FACETS_WS_PRESERVE = new XmlValueRef[]{null, null, null, null, null, null, null, null, null, build_wsstring(1), null, null};
        FACETS_INTEGER = new XmlValueRef[]{null, null, null, null, null, null, null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_LONG = new XmlValueRef[]{null, null, null, null, buildInteger(BigInteger.valueOf(Long.MIN_VALUE)), buildInteger(BigInteger.valueOf(Long.MAX_VALUE)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_INT = new XmlValueRef[]{null, null, null, null, buildInteger(BigInteger.valueOf(-2147483648L)), buildInteger(BigInteger.valueOf(2147483647L)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_SHORT = new XmlValueRef[]{null, null, null, null, buildInteger(BigInteger.valueOf(-32768L)), buildInteger(BigInteger.valueOf(32767L)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_BYTE = new XmlValueRef[]{null, null, null, null, buildInteger(BigInteger.valueOf(-128L)), buildInteger(BigInteger.valueOf(127L)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_NONNEGATIVE = new XmlValueRef[]{null, null, null, null, buildInteger(BigInteger.ZERO), null, null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_POSITIVE = new XmlValueRef[]{null, null, null, null, buildInteger(BigInteger.ONE), null, null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_NONPOSITIVE = new XmlValueRef[]{null, null, null, null, null, buildInteger(BigInteger.ZERO), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_NEGATIVE = new XmlValueRef[]{null, null, null, null, null, buildInteger(BigInteger.ONE.negate()), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_UNSIGNED_LONG = new XmlValueRef[]{null, null, null, null, buildInteger(BigInteger.ZERO), buildInteger(new BigInteger("18446744073709551615")), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_UNSIGNED_INT = new XmlValueRef[]{null, null, null, null, buildInteger(BigInteger.ZERO), buildInteger(BigInteger.valueOf(4294967295L)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_UNSIGNED_SHORT = new XmlValueRef[]{null, null, null, null, buildInteger(BigInteger.ZERO), buildInteger(BigInteger.valueOf(WebSocketProtocol.PAYLOAD_SHORT_MAX)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_UNSIGNED_BYTE = new XmlValueRef[]{null, null, null, null, buildInteger(BigInteger.ZERO), buildInteger(BigInteger.valueOf(255L)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_BUILTIN_LIST = new XmlValueRef[]{null, buildNnInteger(BigInteger.ONE), null, null, null, null, null, null, null, build_wsstring(3), null, null};
        boolean[] zArr2 = {false, false, false, false, false, false, false, false, false, true, false, false};
        FIXED_FACETS_WS = zArr2;
        FIXED_FACETS_INTEGER = new boolean[]{false, false, false, false, false, false, false, false, true, true, false, false};
        FACETS_UNION = xmlValueRefArr;
        FIXED_FACETS_UNION = zArr;
        FACETS_LIST = xmlValueRefArr2;
        FIXED_FACETS_LIST = zArr2;
        for (int i = 0; i <= 46; i++) {
            _global.fillInType(i);
        }
    }

    public static SchemaTypeSystem get() {
        return _global;
    }

    private SchemaTypeImpl getBuiltinType(int i) {
        return this._typeArray[i];
    }

    private BuiltinSchemaTypeSystem() {
        SchemaContainer schemaContainer = new SchemaContainer("http://www.w3.org/2001/XMLSchema");
        this._container = schemaContainer;
        schemaContainer.setTypeSystem(this);
        setupBuiltin(1, "anyType", "org.apache.xmlbeans.XmlObject");
        setupBuiltin(2, "anySimpleType", "org.apache.xmlbeans.XmlAnySimpleType");
        setupBuiltin(3, XmlErrorCodes.BOOLEAN, "org.apache.xmlbeans.XmlBoolean");
        setupBuiltin(4, XmlErrorCodes.BASE64BINARY, "org.apache.xmlbeans.XmlBase64Binary");
        setupBuiltin(5, XmlErrorCodes.HEXBINARY, "org.apache.xmlbeans.XmlHexBinary");
        setupBuiltin(6, XmlErrorCodes.ANYURI, "org.apache.xmlbeans.XmlAnyURI");
        setupBuiltin(7, XmlErrorCodes.QNAME, "org.apache.xmlbeans.XmlQName");
        setupBuiltin(8, "NOTATION", "org.apache.xmlbeans.XmlNOTATION");
        setupBuiltin(9, XmlErrorCodes.FLOAT, "org.apache.xmlbeans.XmlFloat");
        setupBuiltin(10, XmlErrorCodes.DOUBLE, "org.apache.xmlbeans.XmlDouble");
        setupBuiltin(11, XmlErrorCodes.DECIMAL, "org.apache.xmlbeans.XmlDecimal");
        setupBuiltin(12, "string", "org.apache.xmlbeans.XmlString");
        setupBuiltin(13, "duration", "org.apache.xmlbeans.XmlDuration");
        setupBuiltin(14, "dateTime", "org.apache.xmlbeans.XmlDateTime");
        setupBuiltin(15, RtspHeaders.Values.TIME, "org.apache.xmlbeans.XmlTime");
        setupBuiltin(16, "date", "org.apache.xmlbeans.XmlDate");
        setupBuiltin(17, "gYearMonth", "org.apache.xmlbeans.XmlGYearMonth");
        setupBuiltin(18, "gYear", "org.apache.xmlbeans.XmlGYear");
        setupBuiltin(19, "gMonthDay", "org.apache.xmlbeans.XmlGMonthDay");
        setupBuiltin(20, "gDay", "org.apache.xmlbeans.XmlGDay");
        setupBuiltin(21, "gMonth", "org.apache.xmlbeans.XmlGMonth");
        setupBuiltin(22, XmlErrorCodes.INTEGER, "org.apache.xmlbeans.XmlInteger");
        setupBuiltin(23, XmlErrorCodes.LONG, "org.apache.xmlbeans.XmlLong");
        setupBuiltin(24, XmlErrorCodes.INT, "org.apache.xmlbeans.XmlInt");
        setupBuiltin(25, "short", "org.apache.xmlbeans.XmlShort");
        setupBuiltin(26, "byte", "org.apache.xmlbeans.XmlByte");
        setupBuiltin(27, "nonPositiveInteger", "org.apache.xmlbeans.XmlNonPositiveInteger");
        setupBuiltin(28, "negativeInteger", "org.apache.xmlbeans.XmlNegativeInteger");
        setupBuiltin(29, "nonNegativeInteger", "org.apache.xmlbeans.XmlNonNegativeInteger");
        setupBuiltin(30, "positiveInteger", "org.apache.xmlbeans.XmlPositiveInteger");
        setupBuiltin(31, "unsignedLong", "org.apache.xmlbeans.XmlUnsignedLong");
        setupBuiltin(32, "unsignedInt", "org.apache.xmlbeans.XmlUnsignedInt");
        setupBuiltin(33, "unsignedShort", "org.apache.xmlbeans.XmlUnsignedShort");
        setupBuiltin(34, "unsignedByte", "org.apache.xmlbeans.XmlUnsignedByte");
        setupBuiltin(35, "normalizedString", "org.apache.xmlbeans.XmlNormalizedString");
        setupBuiltin(36, "token", "org.apache.xmlbeans.XmlToken");
        setupBuiltin(37, "Name", "org.apache.xmlbeans.XmlName");
        setupBuiltin(38, XmlErrorCodes.NCNAME, "org.apache.xmlbeans.XmlNCName");
        setupBuiltin(39, IjkMediaMeta.IJKM_KEY_LANGUAGE, "org.apache.xmlbeans.XmlLanguage");
        setupBuiltin(40, "ID", "org.apache.xmlbeans.XmlID");
        setupBuiltin(41, "IDREF", "org.apache.xmlbeans.XmlIDREF");
        setupBuiltin(42, "IDREFS", "org.apache.xmlbeans.XmlIDREFS");
        setupBuiltin(43, "ENTITY", "org.apache.xmlbeans.XmlENTITY");
        setupBuiltin(44, "ENTITIES", "org.apache.xmlbeans.XmlENTITIES");
        setupBuiltin(45, XmlErrorCodes.NMTOKEN, "org.apache.xmlbeans.XmlNMTOKEN");
        setupBuiltin(46, "NMTOKENS", "org.apache.xmlbeans.XmlNMTOKENS");
        setupBuiltin(0, null, null);
        this._container.setImmutable();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public boolean isNamespaceDefined(String str) {
        return str.equals("http://www.w3.org/2001/XMLSchema");
    }

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase, org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType findType(QName qName) {
        return (SchemaType) this._typeMap.get(qName);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findTypeRef(QName qName) {
        SchemaType findType = findType(qName);
        if (findType == null) {
            return null;
        }
        return findType.getRef();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType typeForClassname(String str) {
        return (SchemaType) this._typesByClassname.get(str);
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaType[] globalTypes() {
        SchemaTypeImpl[] schemaTypeImplArr = this._typeArray;
        int length = schemaTypeImplArr.length - 1;
        SchemaType[] schemaTypeArr = new SchemaType[length];
        System.arraycopy(schemaTypeImplArr, 1, schemaTypeArr, 0, length);
        return schemaTypeArr;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaType[] documentTypes() {
        return EMPTY_SCHEMATYPE_ARRAY;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaType[] attributeTypes() {
        return EMPTY_SCHEMATYPE_ARRAY;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaGlobalElement[] globalElements() {
        return EMPTY_SCHEMAELEMENT_ARRAY;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaGlobalAttribute[] globalAttributes() {
        return EMPTY_SCHEMAATTRIBUTE_ARRAY;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaModelGroup[] modelGroups() {
        return EMPTY_SCHEMAMODELGROUP_ARRAY;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaAttributeGroup[] attributeGroups() {
        return EMPTY_SCHEMAATTRIBUTEGROUP_ARRAY;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaAnnotation[] annotations() {
        return EMPTY_SCHEMAANNOTATION_ARRAY;
    }

    public String handleForType(SchemaType schemaType) {
        return (String) this._objectsToHandles.get(schemaType);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public ClassLoader getClassLoader() {
        Class cls = class$org$apache$xmlbeans$impl$schema$BuiltinSchemaTypeSystem;
        if (cls == null) {
            cls = class$("org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem");
            class$org$apache$xmlbeans$impl$schema$BuiltinSchemaTypeSystem = cls;
        }
        return cls.getClassLoader();
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public void saveToDirectory(File file) {
        throw new UnsupportedOperationException("The builtin schema type system cannot be saved.");
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public void save(Filer filer) {
        throw new UnsupportedOperationException("The builtin schema type system cannot be saved.");
    }

    private static XmlValueRef build_wsstring(int i) {
        if (i == 1) {
            return XMLSTR_PRESERVE;
        }
        if (i == 2) {
            return XMLSTR_REPLACE;
        }
        if (i != 3) {
            return null;
        }
        return XMLSTR_COLLAPSE;
    }

    private static XmlValueRef buildNnInteger(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0) {
            return null;
        }
        try {
            XmlIntegerImpl xmlIntegerImpl = new XmlIntegerImpl();
            xmlIntegerImpl.set(bigInteger);
            xmlIntegerImpl.setImmutable();
            return new XmlValueRef(xmlIntegerImpl);
        } catch (XmlValueOutOfRangeException unused) {
            return null;
        }
    }

    private static XmlValueRef buildInteger(BigInteger bigInteger) {
        if (bigInteger == null) {
            return null;
        }
        try {
            XmlIntegerImpl xmlIntegerImpl = new XmlIntegerImpl();
            xmlIntegerImpl.set(bigInteger);
            xmlIntegerImpl.setImmutable();
            return new XmlValueRef(xmlIntegerImpl);
        } catch (XmlValueOutOfRangeException unused) {
            return null;
        }
    }

    private static XmlValueRef buildString(String str) {
        if (str == null) {
            return null;
        }
        try {
            XmlStringImpl xmlStringImpl = new XmlStringImpl();
            xmlStringImpl.set(str);
            xmlStringImpl.setImmutable();
            return new XmlValueRef(xmlStringImpl);
        } catch (XmlValueOutOfRangeException unused) {
            return null;
        }
    }

    private void setupBuiltin(int i, String str, String str2) {
        SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(this._container, true);
        this._container.addGlobalType(schemaTypeImpl.getRef());
        QName forLNS = str == null ? null : QNameHelper.forLNS(str, "http://www.w3.org/2001/XMLSchema");
        StringBuffer append = new StringBuffer().append("_BI_");
        if (str == null) {
            str = "NO_TYPE";
        }
        String stringBuffer = append.append(str).toString();
        schemaTypeImpl.setName(forLNS);
        schemaTypeImpl.setBuiltinTypeCode(i);
        if (str2 != null) {
            schemaTypeImpl.setFullJavaName(str2);
        }
        this._typeArray[i] = schemaTypeImpl;
        this._typeMap.put(forLNS, schemaTypeImpl);
        this._handlesToObjects.put(stringBuffer, schemaTypeImpl);
        this._objectsToHandles.put(schemaTypeImpl, stringBuffer);
        if (str2 != null) {
            this._typesByClassname.put(str2, schemaTypeImpl);
        }
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaType typeForHandle(String str) {
        return (SchemaType) this._handlesToObjects.get(str);
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaComponent resolveHandle(String str) {
        return (SchemaComponent) this._handlesToObjects.get(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:106:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void fillInType(int r15) {
        /*
            Method dump skipped, instructions count: 958
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem.fillInType(int):void");
    }

    public static SchemaType getNoType() {
        return ST_NO_TYPE;
    }
}
