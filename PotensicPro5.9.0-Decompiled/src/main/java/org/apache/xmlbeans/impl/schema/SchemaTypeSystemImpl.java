package org.apache.xmlbeans.impl.schema;

import aavax.xml.namespace.QName;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.xmlbeans.Filer;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.ResourceLoader;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaLocalAttribute;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaStringEnumEntry;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SchemaTypeLoaderException;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.SystemProperties;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.XBeanDebug;
import org.apache.xmlbeans.impl.regex.RegularExpression;
import org.apache.xmlbeans.impl.schema.SchemaAnnotationImpl;
import org.apache.xmlbeans.impl.util.FilerImpl;
import org.apache.xmlbeans.impl.util.HexBin;
import org.apache.xmlbeans.impl.values.XmlObjectBase;
import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.GroupDocument;
import org.apache.xmlbeans.soap.SOAPArrayType;
import org.apache.xmlbeans.soap.SchemaWSDLArrayType;
import repackage.Repackager;

/* loaded from: classes5.dex */
public class SchemaTypeSystemImpl extends SchemaTypeLoaderBase implements SchemaTypeSystem {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final int CONSTANT_CLASS = 7;
    private static final int CONSTANT_DOUBLE = 6;
    private static final int CONSTANT_FIELD = 9;
    private static final int CONSTANT_FLOAT = 4;
    private static final int CONSTANT_INTEGER = 3;
    private static final int CONSTANT_INTERFACEMETHOD = 11;
    private static final int CONSTANT_LONG = 5;
    private static final int CONSTANT_METHOD = 10;
    private static final int CONSTANT_NAMEANDTYPE = 12;
    private static final int CONSTANT_STRING = 8;
    private static final int CONSTANT_UNICODE = 2;
    private static final int CONSTANT_UTF8 = 1;
    public static final int DATA_BABE = -629491010;
    private static final SchemaAttributeGroup[] EMPTY_AG_ARRAY;
    private static final SchemaAnnotation[] EMPTY_ANN_ARRAY;
    private static final SchemaGlobalAttribute[] EMPTY_GA_ARRAY;
    private static final SchemaGlobalElement[] EMPTY_GE_ARRAY;
    private static final SchemaIdentityConstraint[] EMPTY_IC_ARRAY;
    private static final SchemaModelGroup[] EMPTY_MG_ARRAY;
    private static final SchemaType[] EMPTY_ST_ARRAY;
    public static final int FIELD_GLOBAL = 1;
    public static final int FIELD_LOCALATTR = 2;
    public static final int FIELD_LOCALELT = 3;
    public static final int FIELD_NONE = 0;
    public static final int FILETYPE_SCHEMAATTRIBUTE = 4;
    public static final int FILETYPE_SCHEMAATTRIBUTEGROUP = 7;
    public static final int FILETYPE_SCHEMAELEMENT = 3;
    public static final int FILETYPE_SCHEMAIDENTITYCONSTRAINT = 8;
    public static final int FILETYPE_SCHEMAINDEX = 1;
    public static final int FILETYPE_SCHEMAMODELGROUP = 6;
    public static final int FILETYPE_SCHEMAPOINTER = 5;
    public static final int FILETYPE_SCHEMATYPE = 2;
    static final int FLAG_ABSTRACT = 262144;
    static final int FLAG_ATTRIBUTE_TYPE = 524288;
    static final int FLAG_BLOCK_EXT = 4096;
    static final int FLAG_BLOCK_REST = 8192;
    static final int FLAG_BOUNDED = 8;
    static final int FLAG_COMPILED = 2048;
    static final int FLAG_DOCUMENT_TYPE = 2;
    static final int FLAG_FINAL_EXT = 16384;
    static final int FLAG_FINAL_LIST = 131072;
    static final int FLAG_FINAL_REST = 32768;
    static final int FLAG_FINAL_UNION = 65536;
    static final int FLAG_FINITE = 16;
    static final int FLAG_HAS_PATTERN = 256;
    static final int FLAG_NUMERIC = 32;
    static final int FLAG_ORDERED = 4;
    static final int FLAG_ORDER_SENSITIVE = 512;
    public static final int FLAG_PART_ABSTRACT = 128;
    public static final int FLAG_PART_BLOCKEXT = 16;
    public static final int FLAG_PART_BLOCKREST = 32;
    public static final int FLAG_PART_BLOCKSUBST = 64;
    public static final int FLAG_PART_FINALEXT = 256;
    public static final int FLAG_PART_FINALREST = 512;
    public static final int FLAG_PART_FIXED = 4;
    public static final int FLAG_PART_NILLABLE = 8;
    public static final int FLAG_PART_SKIPPABLE = 1;
    public static final int FLAG_PROP_ISATTR = 1;
    public static final int FLAG_PROP_JAVAARRAY = 8;
    public static final int FLAG_PROP_JAVAOPTIONAL = 4;
    public static final int FLAG_PROP_JAVASINGLETON = 2;
    static final int FLAG_SIMPLE_TYPE = 1;
    static final int FLAG_STRINGENUM = 64;
    static final int FLAG_TOTAL_ORDER = 1024;
    static final int FLAG_UNION_OF_LISTS = 128;
    private static final String HOLDER_TEMPLATE_CLASS = "org.apache.xmlbeans.impl.schema.TypeSystemHolder";
    private static final String HOLDER_TEMPLATE_CLASSFILE = "TypeSystemHolder.template";
    private static final String[] HOLDER_TEMPLATE_NAMES;
    public static final int MAJOR_VERSION = 2;
    private static final int MAX_UNSIGNED_SHORT = 65535;
    public static String METADATA_PACKAGE_GEN = null;
    public static final int MINOR_VERSION = 24;
    public static final int RELEASE_NUMBER = 0;
    static final byte[] SINGLE_ZERO_BYTE;
    private static byte[] _mask;
    private static Random _random;
    static /* synthetic */ Class class$org$apache$xmlbeans$SchemaTypeSystem;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$schema$SchemaTypeSystemImpl;
    private List _annotations;
    private Map _attributeGroups;
    private Map _attributeTypes;
    private String _basePackage;
    private ClassLoader _classloader;
    private SchemaDependencies _deps;
    private Map _documentTypes;
    private Filer _filer;
    private Map _globalAttributes;
    private Map _globalElements;
    private Map _globalTypes;
    SchemaTypeLoader _linker;
    private HandlePool _localHandles;
    private Map _modelGroups;
    private String _name;
    private Set _namespaces;
    private List _redefinedAttributeGroups;
    private List _redefinedGlobalTypes;
    private List _redefinedModelGroups;
    private ResourceLoader _resourceLoader;
    private boolean _incomplete = false;
    private Map _containers = new HashMap();
    private Map _identityConstraints = Collections.EMPTY_MAP;
    private Map _typeRefsByClassname = new HashMap();
    private final Map _resolvedHandles = new HashMap();
    private boolean _allNonGroupHandlesResolved = false;

    final SchemaTypeSystemImpl getTypeSystem() {
        return this;
    }

    static {
        String name;
        if (class$org$apache$xmlbeans$impl$schema$SchemaTypeSystemImpl == null) {
            class$org$apache$xmlbeans$impl$schema$SchemaTypeSystemImpl = class$("org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl");
        }
        $assertionsDisabled = true;
        Class cls = class$org$apache$xmlbeans$SchemaTypeSystem;
        if (cls == null) {
            cls = class$("org.apache.xmlbeans.SchemaTypeSystem");
            class$org$apache$xmlbeans$SchemaTypeSystem = cls;
        }
        Package r1 = cls.getPackage();
        if (r1 == null) {
            Class cls2 = class$org$apache$xmlbeans$SchemaTypeSystem;
            if (cls2 == null) {
                cls2 = class$("org.apache.xmlbeans.SchemaTypeSystem");
                class$org$apache$xmlbeans$SchemaTypeSystem = cls2;
            }
            String name2 = cls2.getName();
            Class cls3 = class$org$apache$xmlbeans$SchemaTypeSystem;
            if (cls3 == null) {
                cls3 = class$("org.apache.xmlbeans.SchemaTypeSystem");
                class$org$apache$xmlbeans$SchemaTypeSystem = cls3;
            }
            name = name2.substring(0, cls3.getName().lastIndexOf("."));
        } else {
            name = r1.getName();
        }
        METADATA_PACKAGE_GEN = name.replaceAll("\\.", "_");
        HOLDER_TEMPLATE_NAMES = makeClassStrings(HOLDER_TEMPLATE_CLASS);
        _mask = new byte[16];
        EMPTY_ST_ARRAY = new SchemaType[0];
        EMPTY_GE_ARRAY = new SchemaGlobalElement[0];
        EMPTY_GA_ARRAY = new SchemaGlobalAttribute[0];
        EMPTY_MG_ARRAY = new SchemaModelGroup[0];
        EMPTY_AG_ARRAY = new SchemaAttributeGroup[0];
        EMPTY_IC_ARRAY = new SchemaIdentityConstraint[0];
        EMPTY_ANN_ARRAY = new SchemaAnnotation[0];
        SINGLE_ZERO_BYTE = new byte[]{0};
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private static String nameToPathString(String str) {
        String replace = str.replace('.', '/');
        return (replace.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR) || replace.length() <= 0) ? replace : new StringBuffer().append(replace).append(InternalZipConstants.ZIP_FILE_SEPARATOR).toString();
    }

    public SchemaTypeSystemImpl(Class cls) {
        String name = cls.getName();
        this._name = name.substring(0, name.lastIndexOf(46));
        XBeanDebug.trace(1, new StringBuffer().append("Loading type system ").append(this._name).toString(), 1);
        this._basePackage = nameToPathString(this._name);
        ClassLoader classLoader = cls.getClassLoader();
        this._classloader = classLoader;
        this._linker = SchemaTypeLoaderImpl.build(null, null, classLoader);
        this._resourceLoader = new ClassLoaderResourceLoader(this._classloader);
        try {
            initFromHeader();
            XBeanDebug.trace(1, new StringBuffer().append("Finished loading type system ").append(this._name).toString(), -1);
        } catch (Error e) {
            XBeanDebug.logException(e);
            throw e;
        } catch (RuntimeException e2) {
            XBeanDebug.logException(e2);
            throw e2;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:7|8|10|11|(2:13|(4:15|16|17|18))|22|16|17|18) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean fileContainsTypeSystem(java.io.File r4, java.lang.String r5) {
        /*
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r1 = nameToPathString(r5)
            java.lang.StringBuffer r0 = r0.append(r1)
            java.lang.String r1 = "index.xsb"
            java.lang.StringBuffer r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            boolean r1 = r4.isDirectory()
            if (r1 == 0) goto L27
            java.io.File r5 = new java.io.File
            r5.<init>(r4, r0)
            boolean r4 = r5.isFile()
            return r4
        L27:
            r1 = 0
            java.util.zip.ZipFile r2 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L48
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L48
            java.util.zip.ZipEntry r0 = r2.getEntry(r0)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43
            if (r0 == 0) goto L3b
            boolean r4 = r0.isDirectory()     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43
            if (r4 != 0) goto L3b
            r4 = 1
            goto L3c
        L3b:
            r4 = 0
        L3c:
            r2.close()     // Catch: java.io.IOException -> L3f
        L3f:
            return r4
        L40:
            r4 = move-exception
            r1 = r2
            goto L70
        L43:
            r0 = move-exception
            r1 = r2
            goto L49
        L46:
            r4 = move-exception
            goto L70
        L48:
            r0 = move-exception
        L49:
            java.lang.StringBuffer r2 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> L46
            r2.<init>()     // Catch: java.lang.Throwable -> L46
            java.lang.String r3 = "Problem loading SchemaTypeSystem, zipfilename "
            java.lang.StringBuffer r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L46
            java.lang.StringBuffer r4 = r2.append(r4)     // Catch: java.lang.Throwable -> L46
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L46
            org.apache.xmlbeans.impl.common.XBeanDebug.log(r4)     // Catch: java.lang.Throwable -> L46
            org.apache.xmlbeans.impl.common.XBeanDebug.logException(r0)     // Catch: java.lang.Throwable -> L46
            org.apache.xmlbeans.SchemaTypeLoaderException r4 = new org.apache.xmlbeans.SchemaTypeLoaderException     // Catch: java.lang.Throwable -> L46
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L46
            java.lang.String r2 = "index"
            r3 = 9
            r4.<init>(r0, r5, r2, r3)     // Catch: java.lang.Throwable -> L46
            throw r4     // Catch: java.lang.Throwable -> L46
        L70:
            if (r1 == 0) goto L75
            r1.close()     // Catch: java.io.IOException -> L75
        L75:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl.fileContainsTypeSystem(java.io.File, java.lang.String):boolean");
    }

    public static SchemaTypeSystemImpl forName(String str, ClassLoader classLoader) {
        try {
            return (SchemaTypeSystemImpl) Class.forName(new StringBuffer().append(str).append(".").append(SchemaTypeCodePrinter.INDEX_CLASSNAME).toString(), true, classLoader).getField("typeSystem").get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    public SchemaTypeSystemImpl(ResourceLoader resourceLoader, String str, SchemaTypeLoader schemaTypeLoader) {
        this._name = str;
        this._basePackage = nameToPathString(str);
        this._linker = schemaTypeLoader;
        this._resourceLoader = resourceLoader;
        try {
            initFromHeader();
        } catch (Error e) {
            XBeanDebug.logException(e);
            throw e;
        } catch (RuntimeException e2) {
            XBeanDebug.logException(e2);
            throw e2;
        }
    }

    private void initFromHeader() {
        XsbReader xsbReader;
        Throwable th;
        XBeanDebug.trace(1, new StringBuffer().append("Reading unresolved handles for type system ").append(this._name).toString(), 0);
        try {
            xsbReader = new XsbReader("index", 1);
        } catch (Throwable th2) {
            xsbReader = null;
            th = th2;
        }
        try {
            HandlePool handlePool = new HandlePool();
            this._localHandles = handlePool;
            xsbReader.readHandlePool(handlePool);
            this._globalElements = xsbReader.readQNameRefMap();
            this._globalAttributes = xsbReader.readQNameRefMap();
            this._modelGroups = xsbReader.readQNameRefMap();
            this._attributeGroups = xsbReader.readQNameRefMap();
            this._identityConstraints = xsbReader.readQNameRefMap();
            this._globalTypes = xsbReader.readQNameRefMap();
            this._documentTypes = xsbReader.readQNameRefMap();
            this._attributeTypes = xsbReader.readQNameRefMap();
            this._typeRefsByClassname = xsbReader.readClassnameRefMap();
            this._namespaces = xsbReader.readNamespaces();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (xsbReader.atLeast(2, 15, 0)) {
                this._redefinedGlobalTypes = xsbReader.readQNameRefMapAsList(arrayList);
                this._redefinedModelGroups = xsbReader.readQNameRefMapAsList(arrayList2);
                this._redefinedAttributeGroups = xsbReader.readQNameRefMapAsList(arrayList3);
            }
            if (xsbReader.atLeast(2, 19, 0)) {
                this._annotations = xsbReader.readAnnotations();
            }
            buildContainers(arrayList, arrayList2, arrayList3);
            xsbReader.readEnd();
        } catch (Throwable th3) {
            th = th3;
            if (xsbReader != null) {
                xsbReader.readEnd();
            }
            throw th;
        }
    }

    void saveIndex() {
        XsbReader xsbReader = new XsbReader("index");
        xsbReader.writeIndexData();
        xsbReader.writeRealHeader("index", 1);
        xsbReader.writeIndexData();
        xsbReader.writeEnd();
    }

    void savePointers() {
        savePointersForComponents(globalElements(), new StringBuffer().append("schema").append(METADATA_PACKAGE_GEN).append("/element/").toString());
        savePointersForComponents(globalAttributes(), new StringBuffer().append("schema").append(METADATA_PACKAGE_GEN).append("/attribute/").toString());
        savePointersForComponents(modelGroups(), new StringBuffer().append("schema").append(METADATA_PACKAGE_GEN).append("/modelgroup/").toString());
        savePointersForComponents(attributeGroups(), new StringBuffer().append("schema").append(METADATA_PACKAGE_GEN).append("/attributegroup/").toString());
        savePointersForComponents(globalTypes(), new StringBuffer().append("schema").append(METADATA_PACKAGE_GEN).append("/type/").toString());
        savePointersForComponents(identityConstraints(), new StringBuffer().append("schema").append(METADATA_PACKAGE_GEN).append("/identityconstraint/").toString());
        savePointersForNamespaces(this._namespaces, new StringBuffer().append("schema").append(METADATA_PACKAGE_GEN).append("/namespace/").toString());
        savePointersForClassnames(this._typeRefsByClassname.keySet(), new StringBuffer().append("schema").append(METADATA_PACKAGE_GEN).append("/javaname/").toString());
        savePointersForComponents(redefinedModelGroups(), new StringBuffer().append("schema").append(METADATA_PACKAGE_GEN).append("/redefinedmodelgroup/").toString());
        savePointersForComponents(redefinedAttributeGroups(), new StringBuffer().append("schema").append(METADATA_PACKAGE_GEN).append("/redefinedattributegroup/").toString());
        savePointersForComponents(redefinedGlobalTypes(), new StringBuffer().append("schema").append(METADATA_PACKAGE_GEN).append("/redefinedtype/").toString());
    }

    void savePointersForComponents(SchemaComponent[] schemaComponentArr, String str) {
        for (SchemaComponent schemaComponent : schemaComponentArr) {
            savePointerFile(new StringBuffer().append(str).append(QNameHelper.hexsafedir(schemaComponent.getName())).toString(), this._name);
        }
    }

    void savePointersForClassnames(Set set, String str) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            savePointerFile(new StringBuffer().append(str).append(((String) it.next()).replace('.', '/')).toString(), this._name);
        }
    }

    void savePointersForNamespaces(Set set, String str) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            savePointerFile(new StringBuffer().append(str).append(QNameHelper.hexsafedir(new QName((String) it.next(), "xmlns"))).toString(), this._name);
        }
    }

    void savePointerFile(String str, String str2) {
        XsbReader xsbReader = new XsbReader(str);
        xsbReader.writeString(str2);
        xsbReader.writeRealHeader(str, 5);
        xsbReader.writeString(str2);
        xsbReader.writeEnd();
    }

    void saveLoader() {
        OutputStream outputStream;
        OutputStream outputStream2;
        String indexClassForSystem = SchemaTypeCodePrinter.indexClassForSystem(this);
        String[] makeClassStrings = makeClassStrings(indexClassForSystem);
        if (!$assertionsDisabled && makeClassStrings.length != HOLDER_TEMPLATE_NAMES.length) {
            throw new AssertionError();
        }
        Filer filer = this._filer;
        InputStream inputStream = null;
        Repackager repackager = filer instanceof FilerImpl ? ((FilerImpl) filer).getRepackager() : null;
        try {
            try {
                Class cls = class$org$apache$xmlbeans$impl$schema$SchemaTypeSystemImpl;
                if (cls == null) {
                    cls = class$("org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl");
                    class$org$apache$xmlbeans$impl$schema$SchemaTypeSystemImpl = cls;
                }
                InputStream resourceAsStream = cls.getResourceAsStream(HOLDER_TEMPLATE_CLASSFILE);
                try {
                    if (resourceAsStream == null) {
                        throw new SchemaTypeLoaderException("couldn't find resource: TypeSystemHolder.template", this._name, null, 9);
                    }
                    DataInputStream dataInputStream = new DataInputStream(resourceAsStream);
                    OutputStream createBinaryFile = this._filer.createBinaryFile(new StringBuffer().append(indexClassForSystem.replace('.', '/')).append(".class").toString());
                    DataOutputStream dataOutputStream = new DataOutputStream(createBinaryFile);
                    dataOutputStream.writeInt(dataInputStream.readInt());
                    dataOutputStream.writeShort(dataInputStream.readUnsignedShort());
                    dataOutputStream.writeShort(dataInputStream.readUnsignedShort());
                    int readUnsignedShort = dataInputStream.readUnsignedShort();
                    dataOutputStream.writeShort(readUnsignedShort);
                    for (int i = 1; i < readUnsignedShort; i++) {
                        int readUnsignedByte = dataInputStream.readUnsignedByte();
                        dataOutputStream.writeByte(readUnsignedByte);
                        switch (readUnsignedByte) {
                            case 1:
                                dataOutputStream.writeUTF(repackageConstant(dataInputStream.readUTF(), makeClassStrings, repackager));
                                break;
                            case 2:
                            default:
                                throw new RuntimeException(new StringBuffer().append("Unexpected constant type: ").append(readUnsignedByte).toString());
                            case 3:
                            case 4:
                                dataOutputStream.writeInt(dataInputStream.readInt());
                                break;
                            case 5:
                            case 6:
                                dataOutputStream.writeInt(dataInputStream.readInt());
                                dataOutputStream.writeInt(dataInputStream.readInt());
                                break;
                            case 7:
                            case 8:
                                dataOutputStream.writeShort(dataInputStream.readUnsignedShort());
                                break;
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                                dataOutputStream.writeShort(dataInputStream.readUnsignedShort());
                                dataOutputStream.writeShort(dataInputStream.readUnsignedShort());
                                break;
                        }
                    }
                    while (true) {
                        try {
                            dataOutputStream.writeByte(dataInputStream.readByte());
                        } catch (EOFException unused) {
                            if (resourceAsStream != null) {
                                try {
                                    resourceAsStream.close();
                                } catch (Exception unused2) {
                                }
                            }
                            if (createBinaryFile != null) {
                                createBinaryFile.close();
                            }
                        }
                    }
                } catch (IOException unused3) {
                    outputStream2 = null;
                    inputStream = resourceAsStream;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused4) {
                        }
                    }
                    if (outputStream2 != null) {
                        outputStream2.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    outputStream = null;
                    inputStream = resourceAsStream;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused5) {
                        }
                    }
                    if (outputStream == null) {
                        throw th;
                    }
                    try {
                        outputStream.close();
                        throw th;
                    } catch (Exception unused6) {
                        throw th;
                    }
                }
            } catch (IOException unused7) {
                outputStream2 = null;
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
            }
        } catch (Exception unused8) {
        }
    }

    private static String repackageConstant(String str, String[] strArr, Repackager repackager) {
        int i = 0;
        while (true) {
            String[] strArr2 = HOLDER_TEMPLATE_NAMES;
            if (i >= strArr2.length) {
                return repackager != null ? repackager.repackage(new StringBuffer(str)).toString() : str;
            }
            if (strArr2[i].equals(str)) {
                return strArr[i];
            }
            i++;
        }
    }

    private static String[] makeClassStrings(String str) {
        String[] strArr = new String[4];
        strArr[0] = str;
        strArr[1] = str.replace('.', '/');
        strArr[2] = new StringBuffer().append("L").append(strArr[1]).append(";").toString();
        strArr[3] = new StringBuffer().append("class$").append(str.replace('.', '$')).toString();
        return strArr;
    }

    private Map buildTypeRefsByClassname() {
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        arrayList.addAll(Arrays.asList(documentTypes()));
        arrayList.addAll(Arrays.asList(attributeTypes()));
        arrayList.addAll(Arrays.asList(globalTypes()));
        for (int i = 0; i < arrayList.size(); i++) {
            SchemaType schemaType = (SchemaType) arrayList.get(i);
            String fullJavaName = schemaType.getFullJavaName();
            if (fullJavaName != null) {
                linkedHashMap.put(fullJavaName.replace('$', '.'), schemaType.getRef());
            }
            arrayList.addAll(Arrays.asList(schemaType.getAnonymousTypes()));
        }
        return linkedHashMap;
    }

    private Map buildTypeRefsByClassname(Map map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : map.keySet()) {
            linkedHashMap.put(str, ((SchemaType) map.get(str)).getRef());
        }
        return linkedHashMap;
    }

    private static Map buildComponentRefMap(SchemaComponent[] schemaComponentArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < schemaComponentArr.length; i++) {
            linkedHashMap.put(schemaComponentArr[i].getName(), schemaComponentArr[i].getComponentRef());
        }
        return linkedHashMap;
    }

    private static List buildComponentRefList(SchemaComponent[] schemaComponentArr) {
        ArrayList arrayList = new ArrayList();
        for (SchemaComponent schemaComponent : schemaComponentArr) {
            arrayList.add(schemaComponent.getComponentRef());
        }
        return arrayList;
    }

    private static Map buildDocumentMap(SchemaType[] schemaTypeArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < schemaTypeArr.length; i++) {
            linkedHashMap.put(schemaTypeArr[i].getDocumentElementName(), schemaTypeArr[i].getRef());
        }
        return linkedHashMap;
    }

    private static Map buildAttributeTypeMap(SchemaType[] schemaTypeArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < schemaTypeArr.length; i++) {
            linkedHashMap.put(schemaTypeArr[i].getAttributeTypeAttributeName(), schemaTypeArr[i].getRef());
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SchemaContainer getContainer(String str) {
        return (SchemaContainer) this._containers.get(str);
    }

    private void addContainer(String str) {
        SchemaContainer schemaContainer = new SchemaContainer(str);
        schemaContainer.setTypeSystem(this);
        this._containers.put(str, schemaContainer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SchemaContainer getContainerNonNull(String str) {
        SchemaContainer container = getContainer(str);
        if (container != null) {
            return container;
        }
        addContainer(str);
        return getContainer(str);
    }

    private void buildContainers(List list, List list2, List list3) {
        for (Map.Entry entry : this._globalElements.entrySet()) {
            getContainerNonNull(((QName) entry.getKey()).getNamespaceURI()).addGlobalElement((SchemaGlobalElement.Ref) entry.getValue());
        }
        for (Map.Entry entry2 : this._globalAttributes.entrySet()) {
            getContainerNonNull(((QName) entry2.getKey()).getNamespaceURI()).addGlobalAttribute((SchemaGlobalAttribute.Ref) entry2.getValue());
        }
        for (Map.Entry entry3 : this._modelGroups.entrySet()) {
            getContainerNonNull(((QName) entry3.getKey()).getNamespaceURI()).addModelGroup((SchemaModelGroup.Ref) entry3.getValue());
        }
        for (Map.Entry entry4 : this._attributeGroups.entrySet()) {
            getContainerNonNull(((QName) entry4.getKey()).getNamespaceURI()).addAttributeGroup((SchemaAttributeGroup.Ref) entry4.getValue());
        }
        for (Map.Entry entry5 : this._identityConstraints.entrySet()) {
            getContainerNonNull(((QName) entry5.getKey()).getNamespaceURI()).addIdentityConstraint((SchemaIdentityConstraint.Ref) entry5.getValue());
        }
        for (Map.Entry entry6 : this._globalTypes.entrySet()) {
            getContainerNonNull(((QName) entry6.getKey()).getNamespaceURI()).addGlobalType((SchemaType.Ref) entry6.getValue());
        }
        for (Map.Entry entry7 : this._documentTypes.entrySet()) {
            getContainerNonNull(((QName) entry7.getKey()).getNamespaceURI()).addDocumentType((SchemaType.Ref) entry7.getValue());
        }
        for (Map.Entry entry8 : this._attributeTypes.entrySet()) {
            getContainerNonNull(((QName) entry8.getKey()).getNamespaceURI()).addAttributeType((SchemaType.Ref) entry8.getValue());
        }
        List list4 = this._redefinedGlobalTypes;
        if (list4 != null && this._redefinedModelGroups != null && this._redefinedAttributeGroups != null) {
            if (!$assertionsDisabled && list4.size() != list.size()) {
                throw new AssertionError();
            }
            Iterator it = this._redefinedGlobalTypes.iterator();
            Iterator it2 = list.iterator();
            while (it.hasNext()) {
                getContainerNonNull(((QName) it2.next()).getNamespaceURI()).addRedefinedType((SchemaType.Ref) it.next());
            }
            Iterator it3 = this._redefinedModelGroups.iterator();
            Iterator it4 = list2.iterator();
            while (it3.hasNext()) {
                getContainerNonNull(((QName) it4.next()).getNamespaceURI()).addRedefinedModelGroup((SchemaModelGroup.Ref) it3.next());
            }
            Iterator it5 = this._redefinedAttributeGroups.iterator();
            Iterator it6 = list3.iterator();
            while (it5.hasNext()) {
                getContainerNonNull(((QName) it6.next()).getNamespaceURI()).addRedefinedAttributeGroup((SchemaAttributeGroup.Ref) it5.next());
            }
        }
        List list5 = this._annotations;
        if (list5 != null) {
            Iterator it7 = list5.iterator();
            while (it7.hasNext()) {
                getContainerNonNull("").addAnnotation((SchemaAnnotation) it7.next());
            }
        }
        Iterator it8 = this._containers.values().iterator();
        while (it8.hasNext()) {
            ((SchemaContainer) it8.next()).setImmutable();
        }
    }

    private void fixupContainers() {
        for (SchemaContainer schemaContainer : this._containers.values()) {
            schemaContainer.setTypeSystem(this);
            schemaContainer.setImmutable();
        }
    }

    private void assertContainersSynchronized() {
        if (!$assertionsDisabled) {
            HashMap hashMap = new HashMap();
            Iterator it = this._containers.values().iterator();
            while (it.hasNext()) {
                hashMap.putAll(buildComponentRefMap((SchemaComponent[]) ((SchemaContainer) it.next()).globalElements().toArray(new SchemaComponent[0])));
            }
            if (!$assertionsDisabled && !this._globalElements.equals(hashMap)) {
                throw new AssertionError();
            }
            HashMap hashMap2 = new HashMap();
            Iterator it2 = this._containers.values().iterator();
            while (it2.hasNext()) {
                hashMap2.putAll(buildComponentRefMap((SchemaComponent[]) ((SchemaContainer) it2.next()).globalAttributes().toArray(new SchemaComponent[0])));
            }
            if (!$assertionsDisabled && !this._globalAttributes.equals(hashMap2)) {
                throw new AssertionError();
            }
            HashMap hashMap3 = new HashMap();
            Iterator it3 = this._containers.values().iterator();
            while (it3.hasNext()) {
                hashMap3.putAll(buildComponentRefMap((SchemaComponent[]) ((SchemaContainer) it3.next()).modelGroups().toArray(new SchemaComponent[0])));
            }
            if (!$assertionsDisabled && !this._modelGroups.equals(hashMap3)) {
                throw new AssertionError();
            }
            HashSet hashSet = new HashSet();
            Iterator it4 = this._containers.values().iterator();
            while (it4.hasNext()) {
                hashSet.addAll(buildComponentRefList((SchemaComponent[]) ((SchemaContainer) it4.next()).redefinedModelGroups().toArray(new SchemaComponent[0])));
            }
            if (!$assertionsDisabled && !new HashSet(this._redefinedModelGroups).equals(hashSet)) {
                throw new AssertionError();
            }
            HashMap hashMap4 = new HashMap();
            Iterator it5 = this._containers.values().iterator();
            while (it5.hasNext()) {
                hashMap4.putAll(buildComponentRefMap((SchemaComponent[]) ((SchemaContainer) it5.next()).attributeGroups().toArray(new SchemaComponent[0])));
            }
            if (!$assertionsDisabled && !this._attributeGroups.equals(hashMap4)) {
                throw new AssertionError();
            }
            HashSet hashSet2 = new HashSet();
            Iterator it6 = this._containers.values().iterator();
            while (it6.hasNext()) {
                hashSet2.addAll(buildComponentRefList((SchemaComponent[]) ((SchemaContainer) it6.next()).redefinedAttributeGroups().toArray(new SchemaComponent[0])));
            }
            if (!$assertionsDisabled && !new HashSet(this._redefinedAttributeGroups).equals(hashSet2)) {
                throw new AssertionError();
            }
            HashMap hashMap5 = new HashMap();
            Iterator it7 = this._containers.values().iterator();
            while (it7.hasNext()) {
                hashMap5.putAll(buildComponentRefMap((SchemaComponent[]) ((SchemaContainer) it7.next()).globalTypes().toArray(new SchemaComponent[0])));
            }
            if (!$assertionsDisabled && !this._globalTypes.equals(hashMap5)) {
                throw new AssertionError();
            }
            HashSet hashSet3 = new HashSet();
            Iterator it8 = this._containers.values().iterator();
            while (it8.hasNext()) {
                hashSet3.addAll(buildComponentRefList((SchemaComponent[]) ((SchemaContainer) it8.next()).redefinedGlobalTypes().toArray(new SchemaComponent[0])));
            }
            if (!$assertionsDisabled && !new HashSet(this._redefinedGlobalTypes).equals(hashSet3)) {
                throw new AssertionError();
            }
            HashMap hashMap6 = new HashMap();
            Iterator it9 = this._containers.values().iterator();
            while (it9.hasNext()) {
                hashMap6.putAll(buildDocumentMap((SchemaType[]) ((SchemaContainer) it9.next()).documentTypes().toArray(new SchemaType[0])));
            }
            if (!$assertionsDisabled && !this._documentTypes.equals(hashMap6)) {
                throw new AssertionError();
            }
            HashMap hashMap7 = new HashMap();
            Iterator it10 = this._containers.values().iterator();
            while (it10.hasNext()) {
                hashMap7.putAll(buildAttributeTypeMap((SchemaType[]) ((SchemaContainer) it10.next()).attributeTypes().toArray(new SchemaType[0])));
            }
            if (!$assertionsDisabled && !this._attributeTypes.equals(hashMap7)) {
                throw new AssertionError();
            }
            HashMap hashMap8 = new HashMap();
            Iterator it11 = this._containers.values().iterator();
            while (it11.hasNext()) {
                hashMap8.putAll(buildComponentRefMap((SchemaComponent[]) ((SchemaContainer) it11.next()).identityConstraints().toArray(new SchemaComponent[0])));
            }
            if (!$assertionsDisabled && !this._identityConstraints.equals(hashMap8)) {
                throw new AssertionError();
            }
            HashSet hashSet4 = new HashSet();
            Iterator it12 = this._containers.values().iterator();
            while (it12.hasNext()) {
                hashSet4.addAll(((SchemaContainer) it12.next()).annotations());
            }
            if (!$assertionsDisabled && !new HashSet(this._annotations).equals(hashSet4)) {
                throw new AssertionError();
            }
            HashSet hashSet5 = new HashSet();
            Iterator it13 = this._containers.values().iterator();
            while (it13.hasNext()) {
                hashSet5.add(((SchemaContainer) it13.next()).getNamespace());
            }
            if (!$assertionsDisabled && !this._namespaces.equals(hashSet5)) {
                throw new AssertionError();
            }
        }
    }

    private static synchronized void nextBytes(byte[] bArr) {
        synchronized (SchemaTypeSystemImpl.class) {
            if (_random == null) {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    Class cls = class$org$apache$xmlbeans$impl$schema$SchemaTypeSystemImpl;
                    if (cls == null) {
                        cls = class$("org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl");
                        class$org$apache$xmlbeans$impl$schema$SchemaTypeSystemImpl = cls;
                    }
                    dataOutputStream.writeInt(System.identityHashCode(cls));
                    String[] strArr = {"user.name", "user.dir", "user.timezone", "user.country", "java.class.path", "java.home", "java.vendor", "java.version", "os.version"};
                    for (int i = 0; i < 9; i++) {
                        String property = SystemProperties.getProperty(strArr[i]);
                        if (property != null) {
                            dataOutputStream.writeUTF(property);
                            dataOutputStream.writeInt(System.identityHashCode(property));
                        }
                    }
                    dataOutputStream.writeLong(Runtime.getRuntime().freeMemory());
                    dataOutputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    for (int i2 = 0; i2 < byteArray.length; i2++) {
                        byte[] bArr2 = _mask;
                        int length = i2 % bArr2.length;
                        bArr2[length] = (byte) (bArr2[length] * 21);
                        bArr2[length] = (byte) (bArr2[length] + i2);
                    }
                } catch (IOException e) {
                    XBeanDebug.logException(e);
                }
                _random = new Random(System.currentTimeMillis());
            }
            _random.nextBytes(bArr);
            for (int i3 = 0; i3 < bArr.length; i3++) {
                byte[] bArr3 = _mask;
                bArr[i3] = (byte) (bArr3[bArr3.length & i3] ^ bArr[i3]);
            }
        }
    }

    public SchemaTypeSystemImpl(String str) {
        if (str == null) {
            byte[] bArr = new byte[16];
            nextBytes(bArr);
            str = new StringBuffer().append("s").append(new String(HexBin.encode(bArr))).toString();
        }
        String stringBuffer = new StringBuffer().append("schema").append(METADATA_PACKAGE_GEN).append(".system.").append(str).toString();
        this._name = stringBuffer;
        this._basePackage = nameToPathString(stringBuffer);
        this._classloader = null;
    }

    public void loadFromBuilder(SchemaGlobalElement[] schemaGlobalElementArr, SchemaGlobalAttribute[] schemaGlobalAttributeArr, SchemaType[] schemaTypeArr, SchemaType[] schemaTypeArr2, SchemaType[] schemaTypeArr3) {
        if (!$assertionsDisabled && this._classloader != null) {
            throw new AssertionError();
        }
        this._localHandles = new HandlePool();
        this._globalElements = buildComponentRefMap(schemaGlobalElementArr);
        this._globalAttributes = buildComponentRefMap(schemaGlobalAttributeArr);
        this._globalTypes = buildComponentRefMap(schemaTypeArr);
        this._documentTypes = buildDocumentMap(schemaTypeArr2);
        this._attributeTypes = buildAttributeTypeMap(schemaTypeArr3);
        this._typeRefsByClassname = buildTypeRefsByClassname();
        buildContainers(Collections.EMPTY_LIST, Collections.EMPTY_LIST, Collections.EMPTY_LIST);
        this._namespaces = new HashSet();
    }

    public void loadFromStscState(StscState stscState) {
        if (!$assertionsDisabled && this._classloader != null) {
            throw new AssertionError();
        }
        this._localHandles = new HandlePool();
        this._globalElements = buildComponentRefMap(stscState.globalElements());
        this._globalAttributes = buildComponentRefMap(stscState.globalAttributes());
        this._modelGroups = buildComponentRefMap(stscState.modelGroups());
        this._redefinedModelGroups = buildComponentRefList(stscState.redefinedModelGroups());
        this._attributeGroups = buildComponentRefMap(stscState.attributeGroups());
        this._redefinedAttributeGroups = buildComponentRefList(stscState.redefinedAttributeGroups());
        this._globalTypes = buildComponentRefMap(stscState.globalTypes());
        this._redefinedGlobalTypes = buildComponentRefList(stscState.redefinedGlobalTypes());
        this._documentTypes = buildDocumentMap(stscState.documentTypes());
        this._attributeTypes = buildAttributeTypeMap(stscState.attributeTypes());
        this._typeRefsByClassname = buildTypeRefsByClassname(stscState.typesByClassname());
        this._identityConstraints = buildComponentRefMap(stscState.idConstraints());
        this._annotations = stscState.annotations();
        this._namespaces = new HashSet(Arrays.asList(stscState.getNamespaces()));
        this._containers = stscState.getContainerMap();
        fixupContainers();
        assertContainersSynchronized();
        setDependencies(stscState.getDependencies());
    }

    void setDependencies(SchemaDependencies schemaDependencies) {
        this._deps = schemaDependencies;
    }

    SchemaDependencies getDependencies() {
        return this._deps;
    }

    public boolean isIncomplete() {
        return this._incomplete;
    }

    void setIncomplete(boolean z) {
        this._incomplete = z;
    }

    static class StringPool {
        private String _handle;
        private String _name;
        private List intsToStrings = new ArrayList();
        private Map stringsToInts = new HashMap();

        StringPool(String str, String str2) {
            this._handle = str;
            this._name = str2;
            this.intsToStrings.add(null);
        }

        int codeForString(String str) {
            if (str == null) {
                return 0;
            }
            Integer num = (Integer) this.stringsToInts.get(str);
            if (num == null) {
                num = new Integer(this.intsToStrings.size());
                this.intsToStrings.add(str);
                this.stringsToInts.put(str, num);
            }
            return num.intValue();
        }

        String stringForCode(int i) {
            if (i == 0) {
                return null;
            }
            return (String) this.intsToStrings.get(i);
        }

        void writeTo(DataOutputStream dataOutputStream) {
            if (this.intsToStrings.size() >= 65535) {
                throw new SchemaTypeLoaderException(new StringBuffer().append("Too many strings (").append(this.intsToStrings.size()).append(")").toString(), this._name, this._handle, 10);
            }
            try {
                dataOutputStream.writeShort(this.intsToStrings.size());
                Iterator it = this.intsToStrings.iterator();
                it.next();
                while (it.hasNext()) {
                    dataOutputStream.writeUTF((String) it.next());
                }
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage(), this._name, this._handle, 9);
            }
        }

        void readFrom(DataInputStream dataInputStream) {
            if (this.intsToStrings.size() != 1 || this.stringsToInts.size() != 0) {
                throw new IllegalStateException();
            }
            try {
                int readUnsignedShort = dataInputStream.readUnsignedShort();
                for (int i = 1; i < readUnsignedShort; i++) {
                    if (codeForString(dataInputStream.readUTF().intern()) != i) {
                        throw new IllegalStateException();
                    }
                }
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage() == null ? e.getMessage() : "IO Exception", this._name, this._handle, 9, e);
            }
        }
    }

    class HandlePool {
        private boolean _started;
        private Map _handlesToRefs = new LinkedHashMap();
        private Map _componentsToHandles = new LinkedHashMap();

        HandlePool() {
        }

        private String addUniqueHandle(SchemaComponent schemaComponent, String str) {
            String lowerCase = str.toLowerCase();
            int i = 2;
            String str2 = lowerCase;
            while (this._handlesToRefs.containsKey(str2)) {
                str2 = new StringBuffer().append(lowerCase).append(i).toString();
                i++;
            }
            this._handlesToRefs.put(str2, schemaComponent.getComponentRef());
            this._componentsToHandles.put(schemaComponent, str2);
            return str2;
        }

        String handleForComponent(SchemaComponent schemaComponent) {
            if (schemaComponent == null) {
                return null;
            }
            if (schemaComponent.getTypeSystem() != SchemaTypeSystemImpl.this.getTypeSystem()) {
                throw new IllegalArgumentException("Cannot supply handles for types from another type system");
            }
            if (schemaComponent instanceof SchemaType) {
                return handleForType((SchemaType) schemaComponent);
            }
            if (schemaComponent instanceof SchemaGlobalElement) {
                return handleForElement((SchemaGlobalElement) schemaComponent);
            }
            if (schemaComponent instanceof SchemaGlobalAttribute) {
                return handleForAttribute((SchemaGlobalAttribute) schemaComponent);
            }
            if (schemaComponent instanceof SchemaModelGroup) {
                return handleForModelGroup((SchemaModelGroup) schemaComponent);
            }
            if (schemaComponent instanceof SchemaAttributeGroup) {
                return handleForAttributeGroup((SchemaAttributeGroup) schemaComponent);
            }
            if (schemaComponent instanceof SchemaIdentityConstraint) {
                return handleForIdentityConstraint((SchemaIdentityConstraint) schemaComponent);
            }
            throw new IllegalStateException("Component type cannot have a handle");
        }

        String handleForElement(SchemaGlobalElement schemaGlobalElement) {
            if (schemaGlobalElement == null) {
                return null;
            }
            if (schemaGlobalElement.getTypeSystem() != SchemaTypeSystemImpl.this.getTypeSystem()) {
                throw new IllegalArgumentException("Cannot supply handles for types from another type system");
            }
            String str = (String) this._componentsToHandles.get(schemaGlobalElement);
            return str == null ? addUniqueHandle(schemaGlobalElement, new StringBuffer().append(NameUtil.upperCamelCase(schemaGlobalElement.getName().getLocalPart())).append("Element").toString()) : str;
        }

        String handleForAttribute(SchemaGlobalAttribute schemaGlobalAttribute) {
            if (schemaGlobalAttribute == null) {
                return null;
            }
            if (schemaGlobalAttribute.getTypeSystem() != SchemaTypeSystemImpl.this.getTypeSystem()) {
                throw new IllegalArgumentException("Cannot supply handles for types from another type system");
            }
            String str = (String) this._componentsToHandles.get(schemaGlobalAttribute);
            return str == null ? addUniqueHandle(schemaGlobalAttribute, new StringBuffer().append(NameUtil.upperCamelCase(schemaGlobalAttribute.getName().getLocalPart())).append("Attribute").toString()) : str;
        }

        String handleForModelGroup(SchemaModelGroup schemaModelGroup) {
            if (schemaModelGroup == null) {
                return null;
            }
            if (schemaModelGroup.getTypeSystem() != SchemaTypeSystemImpl.this.getTypeSystem()) {
                throw new IllegalArgumentException("Cannot supply handles for types from another type system");
            }
            String str = (String) this._componentsToHandles.get(schemaModelGroup);
            return str == null ? addUniqueHandle(schemaModelGroup, new StringBuffer().append(NameUtil.upperCamelCase(schemaModelGroup.getName().getLocalPart())).append("ModelGroup").toString()) : str;
        }

        String handleForAttributeGroup(SchemaAttributeGroup schemaAttributeGroup) {
            if (schemaAttributeGroup == null) {
                return null;
            }
            if (schemaAttributeGroup.getTypeSystem() != SchemaTypeSystemImpl.this.getTypeSystem()) {
                throw new IllegalArgumentException("Cannot supply handles for types from another type system");
            }
            String str = (String) this._componentsToHandles.get(schemaAttributeGroup);
            return str == null ? addUniqueHandle(schemaAttributeGroup, new StringBuffer().append(NameUtil.upperCamelCase(schemaAttributeGroup.getName().getLocalPart())).append("AttributeGroup").toString()) : str;
        }

        String handleForIdentityConstraint(SchemaIdentityConstraint schemaIdentityConstraint) {
            if (schemaIdentityConstraint == null) {
                return null;
            }
            if (schemaIdentityConstraint.getTypeSystem() != SchemaTypeSystemImpl.this.getTypeSystem()) {
                throw new IllegalArgumentException("Cannot supply handles for types from another type system");
            }
            String str = (String) this._componentsToHandles.get(schemaIdentityConstraint);
            return str == null ? addUniqueHandle(schemaIdentityConstraint, new StringBuffer().append(NameUtil.upperCamelCase(schemaIdentityConstraint.getName().getLocalPart())).append("IdentityConstraint").toString()) : str;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0076  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x008e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        java.lang.String handleForType(org.apache.xmlbeans.SchemaType r6) {
            /*
                r5 = this;
                if (r6 != 0) goto L4
                r6 = 0
                return r6
            L4:
                org.apache.xmlbeans.SchemaTypeSystem r0 = r6.getTypeSystem()
                org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl r1 = org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl.this
                org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl r1 = r1.getTypeSystem()
                if (r0 != r1) goto Lb4
                java.util.Map r0 = r5._componentsToHandles
                java.lang.Object r0 = r0.get(r6)
                java.lang.String r0 = (java.lang.String) r0
                if (r0 != 0) goto Lb3
                aavax.xml.namespace.QName r0 = r6.getName()
                if (r0 != 0) goto L58
                boolean r1 = r6.isDocumentType()
                if (r1 == 0) goto L2d
                aavax.xml.namespace.QName r0 = r6.getDocumentElementName()
                java.lang.String r1 = "Doc"
                goto L5a
            L2d:
                boolean r1 = r6.isAttributeType()
                if (r1 == 0) goto L3a
                aavax.xml.namespace.QName r0 = r6.getAttributeTypeAttributeName()
                java.lang.String r1 = "AttrType"
                goto L5a
            L3a:
                org.apache.xmlbeans.SchemaField r1 = r6.getContainerField()
                if (r1 == 0) goto L58
                org.apache.xmlbeans.SchemaField r0 = r6.getContainerField()
                aavax.xml.namespace.QName r0 = r0.getName()
                org.apache.xmlbeans.SchemaField r1 = r6.getContainerField()
                boolean r1 = r1.isAttribute()
                if (r1 == 0) goto L55
                java.lang.String r1 = "Attr"
                goto L5a
            L55:
                java.lang.String r1 = "Elem"
                goto L5a
            L58:
                java.lang.String r1 = ""
            L5a:
                java.lang.String r2 = r6.toString()
                int r2 = r2.hashCode()
                r3 = -2147483648(0xffffffff80000000, float:-0.0)
                r2 = r2 | r3
                java.lang.String r2 = java.lang.Integer.toHexString(r2)
                r3 = 4
                java.lang.String r2 = r2.substring(r3)
                java.lang.String r2 = r2.toUpperCase()
                java.lang.String r3 = "Type"
                if (r0 != 0) goto L8e
                java.lang.StringBuffer r0 = new java.lang.StringBuffer
                r0.<init>()
                java.lang.String r1 = "Anon"
                java.lang.StringBuffer r0 = r0.append(r1)
                java.lang.StringBuffer r0 = r0.append(r2)
                java.lang.StringBuffer r0 = r0.append(r3)
                java.lang.String r0 = r0.toString()
                goto Laf
            L8e:
                java.lang.StringBuffer r4 = new java.lang.StringBuffer
                r4.<init>()
                java.lang.String r0 = r0.getLocalPart()
                java.lang.String r0 = org.apache.xmlbeans.impl.common.NameUtil.upperCamelCase(r0)
                java.lang.StringBuffer r0 = r4.append(r0)
                java.lang.StringBuffer r0 = r0.append(r2)
                java.lang.StringBuffer r0 = r0.append(r1)
                java.lang.StringBuffer r0 = r0.append(r3)
                java.lang.String r0 = r0.toString()
            Laf:
                java.lang.String r0 = r5.addUniqueHandle(r6, r0)
            Lb3:
                return r0
            Lb4:
                java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
                java.lang.String r0 = "Cannot supply handles for types from another type system"
                r6.<init>(r0)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl.HandlePool.handleForType(org.apache.xmlbeans.SchemaType):java.lang.String");
        }

        SchemaComponent.Ref refForHandle(String str) {
            if (str == null) {
                return null;
            }
            return (SchemaComponent.Ref) this._handlesToRefs.get(str);
        }

        Set getAllHandles() {
            return this._handlesToRefs.keySet();
        }

        void startWriteMode() {
            this._started = true;
            this._componentsToHandles = new LinkedHashMap();
            for (String str : this._handlesToRefs.keySet()) {
                this._componentsToHandles.put(((SchemaComponent.Ref) this._handlesToRefs.get(str)).getComponent(), str);
            }
        }
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public void saveToDirectory(File file) {
        save(new FilerImpl(file, null, null, false, false));
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public void save(Filer filer) {
        if (this._incomplete) {
            throw new IllegalStateException("Incomplete SchemaTypeSystems cannot be saved.");
        }
        if (filer == null) {
            throw new IllegalArgumentException("filer must not be null");
        }
        this._filer = filer;
        this._localHandles.startWriteMode();
        saveTypesRecursively(globalTypes());
        saveTypesRecursively(documentTypes());
        saveTypesRecursively(attributeTypes());
        saveGlobalElements(globalElements());
        saveGlobalAttributes(globalAttributes());
        saveModelGroups(modelGroups());
        saveAttributeGroups(attributeGroups());
        saveIdentityConstraints(identityConstraints());
        saveTypesRecursively(redefinedGlobalTypes());
        saveModelGroups(redefinedModelGroups());
        saveAttributeGroups(redefinedAttributeGroups());
        saveIndex();
        savePointers();
        saveLoader();
    }

    void saveTypesRecursively(SchemaType[] schemaTypeArr) {
        for (int i = 0; i < schemaTypeArr.length; i++) {
            if (schemaTypeArr[i].getTypeSystem() == getTypeSystem()) {
                saveType(schemaTypeArr[i]);
                saveTypesRecursively(schemaTypeArr[i].getAnonymousTypes());
            }
        }
    }

    public void saveGlobalElements(SchemaGlobalElement[] schemaGlobalElementArr) {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        for (SchemaGlobalElement schemaGlobalElement : schemaGlobalElementArr) {
            saveGlobalElement(schemaGlobalElement);
        }
    }

    public void saveGlobalAttributes(SchemaGlobalAttribute[] schemaGlobalAttributeArr) {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        for (SchemaGlobalAttribute schemaGlobalAttribute : schemaGlobalAttributeArr) {
            saveGlobalAttribute(schemaGlobalAttribute);
        }
    }

    public void saveModelGroups(SchemaModelGroup[] schemaModelGroupArr) {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        for (SchemaModelGroup schemaModelGroup : schemaModelGroupArr) {
            saveModelGroup(schemaModelGroup);
        }
    }

    public void saveAttributeGroups(SchemaAttributeGroup[] schemaAttributeGroupArr) {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        for (SchemaAttributeGroup schemaAttributeGroup : schemaAttributeGroupArr) {
            saveAttributeGroup(schemaAttributeGroup);
        }
    }

    public void saveIdentityConstraints(SchemaIdentityConstraint[] schemaIdentityConstraintArr) {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        for (SchemaIdentityConstraint schemaIdentityConstraint : schemaIdentityConstraintArr) {
            saveIdentityConstraint(schemaIdentityConstraint);
        }
    }

    public void saveGlobalElement(SchemaGlobalElement schemaGlobalElement) {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        String handleForElement = this._localHandles.handleForElement(schemaGlobalElement);
        XsbReader xsbReader = new XsbReader(handleForElement);
        SchemaParticle schemaParticle = (SchemaParticle) schemaGlobalElement;
        xsbReader.writeParticleData(schemaParticle);
        xsbReader.writeString(schemaGlobalElement.getSourceName());
        xsbReader.writeRealHeader(handleForElement, 3);
        xsbReader.writeParticleData(schemaParticle);
        xsbReader.writeString(schemaGlobalElement.getSourceName());
        xsbReader.writeEnd();
    }

    public void saveGlobalAttribute(SchemaGlobalAttribute schemaGlobalAttribute) {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        String handleForAttribute = this._localHandles.handleForAttribute(schemaGlobalAttribute);
        XsbReader xsbReader = new XsbReader(handleForAttribute);
        xsbReader.writeAttributeData(schemaGlobalAttribute);
        xsbReader.writeString(schemaGlobalAttribute.getSourceName());
        xsbReader.writeRealHeader(handleForAttribute, 4);
        xsbReader.writeAttributeData(schemaGlobalAttribute);
        xsbReader.writeString(schemaGlobalAttribute.getSourceName());
        xsbReader.writeEnd();
    }

    public void saveModelGroup(SchemaModelGroup schemaModelGroup) {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        String handleForModelGroup = this._localHandles.handleForModelGroup(schemaModelGroup);
        XsbReader xsbReader = new XsbReader(handleForModelGroup);
        xsbReader.writeModelGroupData(schemaModelGroup);
        xsbReader.writeRealHeader(handleForModelGroup, 6);
        xsbReader.writeModelGroupData(schemaModelGroup);
        xsbReader.writeEnd();
    }

    public void saveAttributeGroup(SchemaAttributeGroup schemaAttributeGroup) {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        String handleForAttributeGroup = this._localHandles.handleForAttributeGroup(schemaAttributeGroup);
        XsbReader xsbReader = new XsbReader(handleForAttributeGroup);
        xsbReader.writeAttributeGroupData(schemaAttributeGroup);
        xsbReader.writeRealHeader(handleForAttributeGroup, 7);
        xsbReader.writeAttributeGroupData(schemaAttributeGroup);
        xsbReader.writeEnd();
    }

    public void saveIdentityConstraint(SchemaIdentityConstraint schemaIdentityConstraint) {
        if (this._incomplete) {
            throw new IllegalStateException("This SchemaTypeSystem cannot be saved.");
        }
        String handleForIdentityConstraint = this._localHandles.handleForIdentityConstraint(schemaIdentityConstraint);
        XsbReader xsbReader = new XsbReader(handleForIdentityConstraint);
        xsbReader.writeIdConstraintData(schemaIdentityConstraint);
        xsbReader.writeRealHeader(handleForIdentityConstraint, 8);
        xsbReader.writeIdConstraintData(schemaIdentityConstraint);
        xsbReader.writeEnd();
    }

    void saveType(SchemaType schemaType) {
        String handleForType = this._localHandles.handleForType(schemaType);
        XsbReader xsbReader = new XsbReader(handleForType);
        xsbReader.writeTypeData(schemaType);
        xsbReader.writeRealHeader(handleForType, 2);
        xsbReader.writeTypeData(schemaType);
        xsbReader.writeEnd();
    }

    public static String crackPointer(InputStream inputStream) {
        DataInputStream dataInputStream;
        DataInputStream dataInputStream2 = null;
        try {
            dataInputStream = new DataInputStream(inputStream);
        } catch (IOException unused) {
            dataInputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (dataInputStream.readInt() != -629491010) {
                try {
                    dataInputStream.close();
                } catch (IOException unused2) {
                }
                return null;
            }
            short readShort = dataInputStream.readShort();
            short readShort2 = dataInputStream.readShort();
            if (readShort != 2) {
                try {
                    dataInputStream.close();
                } catch (IOException unused3) {
                }
                return null;
            }
            if (readShort2 > 24) {
                try {
                    dataInputStream.close();
                } catch (IOException unused4) {
                }
                return null;
            }
            if (readShort > 2 || (readShort == 2 && readShort2 >= 18)) {
                dataInputStream.readShort();
            }
            if (dataInputStream.readShort() != 5) {
                try {
                    dataInputStream.close();
                } catch (IOException unused5) {
                }
                return null;
            }
            StringPool stringPool = new StringPool("pointer", "unk");
            stringPool.readFrom(dataInputStream);
            String stringForCode = stringPool.stringForCode(dataInputStream.readShort());
            try {
                dataInputStream.close();
            } catch (IOException unused6) {
            }
            return stringForCode;
        } catch (IOException unused7) {
            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (IOException unused8) {
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            dataInputStream2 = dataInputStream;
            if (dataInputStream2 != null) {
                try {
                    dataInputStream2.close();
                } catch (IOException unused9) {
                }
            }
            throw th;
        }
    }

    private class XsbReader {
        static final /* synthetic */ boolean $assertionsDisabled;
        int _actualfiletype;
        String _handle;
        DataInputStream _input;
        private int _majorver;
        private int _minorver;
        DataOutputStream _output;
        private int _releaseno;
        StringPool _stringPool;

        static {
            if (SchemaTypeSystemImpl.class$org$apache$xmlbeans$impl$schema$SchemaTypeSystemImpl == null) {
                SchemaTypeSystemImpl.class$org$apache$xmlbeans$impl$schema$SchemaTypeSystemImpl = SchemaTypeSystemImpl.class$("org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl");
            } else {
                Class cls = SchemaTypeSystemImpl.class$org$apache$xmlbeans$impl$schema$SchemaTypeSystemImpl;
            }
            $assertionsDisabled = true;
        }

        public XsbReader(String str, int i) {
            String stringBuffer = new StringBuffer().append(SchemaTypeSystemImpl.this._basePackage).append(str).append(".xsb").toString();
            InputStream loaderStream = getLoaderStream(stringBuffer);
            if (loaderStream == null) {
                throw new SchemaTypeLoaderException(new StringBuffer().append("XML-BEANS compiled schema: Could not locate compiled schema resource ").append(stringBuffer).toString(), SchemaTypeSystemImpl.this._name, str, 0);
            }
            this._input = new DataInputStream(loaderStream);
            this._handle = str;
            if (readInt() != -629491010) {
                throw new SchemaTypeLoaderException("XML-BEANS compiled schema: Wrong magic cookie", SchemaTypeSystemImpl.this._name, str, 1);
            }
            this._majorver = readShort();
            int readShort = readShort();
            this._minorver = readShort;
            if (this._majorver != 2) {
                throw new SchemaTypeLoaderException(new StringBuffer().append("XML-BEANS compiled schema: Wrong major version - expecting 2, got ").append(this._majorver).toString(), SchemaTypeSystemImpl.this._name, str, 2);
            }
            if (readShort > 24) {
                throw new SchemaTypeLoaderException(new StringBuffer().append("XML-BEANS compiled schema: Incompatible minor version - expecting up to 24, got ").append(this._minorver).toString(), SchemaTypeSystemImpl.this._name, str, 3);
            }
            if (readShort < 14) {
                throw new SchemaTypeLoaderException(new StringBuffer().append("XML-BEANS compiled schema: Incompatible minor version - expecting at least 14, got ").append(this._minorver).toString(), SchemaTypeSystemImpl.this._name, str, 3);
            }
            if (atLeast(2, 18, 0)) {
                this._releaseno = readShort();
            }
            int readShort2 = readShort();
            if (readShort2 != i && i != 65535) {
                throw new SchemaTypeLoaderException(new StringBuffer().append("XML-BEANS compiled schema: File has the wrong type - expecting type ").append(i).append(", got type ").append(readShort2).toString(), SchemaTypeSystemImpl.this._name, str, 4);
            }
            StringPool stringPool = new StringPool(this._handle, SchemaTypeSystemImpl.this._name);
            this._stringPool = stringPool;
            stringPool.readFrom(this._input);
            this._actualfiletype = readShort2;
        }

        protected boolean atLeast(int i, int i2, int i3) {
            int i4 = this._majorver;
            if (i4 > i) {
                return true;
            }
            if (i4 < i) {
                return false;
            }
            int i5 = this._minorver;
            if (i5 > i2) {
                return true;
            }
            return i5 >= i2 && this._releaseno >= i3;
        }

        protected boolean atMost(int i, int i2, int i3) {
            int i4 = this._majorver;
            if (i4 > i) {
                return false;
            }
            if (i4 < i) {
                return true;
            }
            int i5 = this._minorver;
            if (i5 > i2) {
                return false;
            }
            return i5 < i2 || this._releaseno <= i3;
        }

        int getActualFiletype() {
            return this._actualfiletype;
        }

        XsbReader(String str) {
            this._handle = str;
            this._stringPool = new StringPool(this._handle, SchemaTypeSystemImpl.this._name);
        }

        void writeRealHeader(String str, int i) {
            String stringBuffer;
            if (str.indexOf(47) < 0) {
                stringBuffer = new StringBuffer().append(SchemaTypeSystemImpl.this._basePackage).append(str).append(".xsb").toString();
            } else {
                stringBuffer = new StringBuffer().append(str).append(".xsb").toString();
            }
            OutputStream saverStream = getSaverStream(stringBuffer);
            if (saverStream == null) {
                throw new SchemaTypeLoaderException(new StringBuffer().append("Could not write compiled schema resource ").append(stringBuffer).toString(), SchemaTypeSystemImpl.this._name, str, 12);
            }
            this._output = new DataOutputStream(saverStream);
            this._handle = str;
            writeInt(-629491010);
            writeShort(2);
            writeShort(24);
            writeShort(0);
            writeShort(i);
            this._stringPool.writeTo(this._output);
        }

        void readEnd() {
            try {
                DataInputStream dataInputStream = this._input;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
            } catch (IOException unused) {
            }
            this._input = null;
            this._stringPool = null;
            this._handle = null;
        }

        void writeEnd() {
            try {
                DataOutputStream dataOutputStream = this._output;
                if (dataOutputStream != null) {
                    dataOutputStream.flush();
                    this._output.close();
                }
                this._output = null;
                this._stringPool = null;
                this._handle = null;
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage(), SchemaTypeSystemImpl.this._name, this._handle, 9);
            }
        }

        int fileTypeFromComponentType(int i) {
            if (i == 0) {
                return 2;
            }
            if (i == 1) {
                return 3;
            }
            if (i == 3) {
                return 4;
            }
            if (i == 4) {
                return 7;
            }
            if (i == 5) {
                return 8;
            }
            if (i == 6) {
                return 6;
            }
            throw new IllegalStateException("Unexpected component type");
        }

        void writeIndexData() {
            writeHandlePool(SchemaTypeSystemImpl.this._localHandles);
            writeQNameMap(SchemaTypeSystemImpl.this.globalElements());
            writeQNameMap(SchemaTypeSystemImpl.this.globalAttributes());
            writeQNameMap(SchemaTypeSystemImpl.this.modelGroups());
            writeQNameMap(SchemaTypeSystemImpl.this.attributeGroups());
            writeQNameMap(SchemaTypeSystemImpl.this.identityConstraints());
            writeQNameMap(SchemaTypeSystemImpl.this.globalTypes());
            writeDocumentTypeMap(SchemaTypeSystemImpl.this.documentTypes());
            writeAttributeTypeMap(SchemaTypeSystemImpl.this.attributeTypes());
            writeClassnameMap(SchemaTypeSystemImpl.this._typeRefsByClassname);
            writeNamespaces(SchemaTypeSystemImpl.this._namespaces);
            writeQNameMap(SchemaTypeSystemImpl.this.redefinedGlobalTypes());
            writeQNameMap(SchemaTypeSystemImpl.this.redefinedModelGroups());
            writeQNameMap(SchemaTypeSystemImpl.this.redefinedAttributeGroups());
            writeAnnotations(SchemaTypeSystemImpl.this.annotations());
        }

        void writeHandlePool(HandlePool handlePool) {
            writeShort(handlePool._componentsToHandles.size());
            for (SchemaComponent schemaComponent : handlePool._componentsToHandles.keySet()) {
                String str = (String) handlePool._componentsToHandles.get(schemaComponent);
                int fileTypeFromComponentType = fileTypeFromComponentType(schemaComponent.getComponentType());
                writeString(str);
                writeShort(fileTypeFromComponentType);
            }
        }

        void readHandlePool(HandlePool handlePool) {
            Object ref;
            if (handlePool._handlesToRefs.size() != 0 || handlePool._started) {
                throw new IllegalStateException("Nonempty handle set before read");
            }
            int readShort = readShort();
            for (int i = 0; i < readShort; i++) {
                String readString = readString();
                int readShort2 = readShort();
                if (readShort2 == 2) {
                    ref = new SchemaType.Ref(SchemaTypeSystemImpl.this.getTypeSystem(), readString);
                } else if (readShort2 == 3) {
                    ref = new SchemaGlobalElement.Ref(SchemaTypeSystemImpl.this.getTypeSystem(), readString);
                } else if (readShort2 == 4) {
                    ref = new SchemaGlobalAttribute.Ref(SchemaTypeSystemImpl.this.getTypeSystem(), readString);
                } else if (readShort2 == 6) {
                    ref = new SchemaModelGroup.Ref(SchemaTypeSystemImpl.this.getTypeSystem(), readString);
                } else if (readShort2 == 7) {
                    ref = new SchemaAttributeGroup.Ref(SchemaTypeSystemImpl.this.getTypeSystem(), readString);
                } else if (readShort2 == 8) {
                    ref = new SchemaIdentityConstraint.Ref(SchemaTypeSystemImpl.this.getTypeSystem(), readString);
                } else {
                    throw new SchemaTypeLoaderException(new StringBuffer().append("Schema index has an unrecognized entry of type ").append(readShort2).toString(), SchemaTypeSystemImpl.this._name, readString, 5);
                }
                handlePool._handlesToRefs.put(readString, ref);
            }
        }

        int readShort() {
            try {
                return this._input.readUnsignedShort();
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage(), SchemaTypeSystemImpl.this._name, this._handle, 9);
            }
        }

        void writeShort(int i) {
            if (i >= 65535 || i < -1) {
                throw new SchemaTypeLoaderException(new StringBuffer().append("Value ").append(i).append(" out of range: must fit in a 16-bit unsigned short.").toString(), SchemaTypeSystemImpl.this._name, this._handle, 10);
            }
            DataOutputStream dataOutputStream = this._output;
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.writeShort(i);
                } catch (IOException e) {
                    throw new SchemaTypeLoaderException(e.getMessage(), SchemaTypeSystemImpl.this._name, this._handle, 9);
                }
            }
        }

        int readInt() {
            try {
                return this._input.readInt();
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage(), SchemaTypeSystemImpl.this._name, this._handle, 9);
            }
        }

        void writeInt(int i) {
            DataOutputStream dataOutputStream = this._output;
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.writeInt(i);
                } catch (IOException e) {
                    throw new SchemaTypeLoaderException(e.getMessage(), SchemaTypeSystemImpl.this._name, this._handle, 9);
                }
            }
        }

        String readString() {
            return this._stringPool.stringForCode(readShort());
        }

        void writeString(String str) {
            writeShort(this._stringPool.codeForString(str));
        }

        QName readQName() {
            String readString = readString();
            String readString2 = readString();
            if (readString2 == null) {
                return null;
            }
            return new QName(readString, readString2);
        }

        void writeQName(QName qName) {
            if (qName == null) {
                writeString(null);
                writeString(null);
            } else {
                writeString(qName.getNamespaceURI());
                writeString(qName.getLocalPart());
            }
        }

        SOAPArrayType readSOAPArrayType() {
            QName readQName = readQName();
            String readString = readString();
            if (readQName == null) {
                return null;
            }
            return new SOAPArrayType(readQName, readString);
        }

        void writeSOAPArrayType(SOAPArrayType sOAPArrayType) {
            if (sOAPArrayType == null) {
                writeQName(null);
                writeString(null);
            } else {
                writeQName(sOAPArrayType.getQName());
                writeString(sOAPArrayType.soap11DimensionString());
            }
        }

        void writeAnnotation(SchemaAnnotation schemaAnnotation) {
            if (schemaAnnotation == null) {
                writeInt(-1);
                return;
            }
            SchemaAnnotation.Attribute[] attributes = schemaAnnotation.getAttributes();
            writeInt(attributes.length);
            for (int i = 0; i < attributes.length; i++) {
                QName name = attributes[i].getName();
                String value = attributes[i].getValue();
                String valueUri = attributes[i].getValueUri();
                writeQName(name);
                writeString(value);
                writeString(valueUri);
            }
            XmlObject[] userInformation = schemaAnnotation.getUserInformation();
            writeInt(userInformation.length);
            XmlOptions saveAggressiveNamespaces = new XmlOptions().setSaveOuter().setSaveAggressiveNamespaces();
            for (XmlObject xmlObject : userInformation) {
                writeString(xmlObject.xmlText(saveAggressiveNamespaces));
            }
            XmlObject[] applicationInformation = schemaAnnotation.getApplicationInformation();
            writeInt(applicationInformation.length);
            for (XmlObject xmlObject2 : applicationInformation) {
                writeString(xmlObject2.xmlText(saveAggressiveNamespaces));
            }
        }

        SchemaAnnotation readAnnotation(SchemaContainer schemaContainer) {
            int readInt;
            if (!atLeast(2, 19, 0) || (readInt = readInt()) == -1) {
                return null;
            }
            SchemaAnnotation.Attribute[] attributeArr = new SchemaAnnotation.Attribute[readInt];
            for (int i = 0; i < readInt; i++) {
                attributeArr[i] = new SchemaAnnotationImpl.AttributeImpl(readQName(), readString(), atLeast(2, 24, 0) ? readString() : null);
            }
            int readInt2 = readInt();
            String[] strArr = new String[readInt2];
            for (int i2 = 0; i2 < readInt2; i2++) {
                strArr[i2] = readString();
            }
            int readInt3 = readInt();
            String[] strArr2 = new String[readInt3];
            for (int i3 = 0; i3 < readInt3; i3++) {
                strArr2[i3] = readString();
            }
            return new SchemaAnnotationImpl(schemaContainer, strArr2, strArr, attributeArr);
        }

        void writeAnnotations(SchemaAnnotation[] schemaAnnotationArr) {
            writeInt(schemaAnnotationArr.length);
            for (SchemaAnnotation schemaAnnotation : schemaAnnotationArr) {
                writeAnnotation(schemaAnnotation);
            }
        }

        List readAnnotations() {
            int readInt = readInt();
            ArrayList arrayList = new ArrayList(readInt);
            SchemaContainer containerNonNull = SchemaTypeSystemImpl.this.getContainerNonNull("");
            for (int i = 0; i < readInt; i++) {
                arrayList.add(readAnnotation(containerNonNull));
            }
            return arrayList;
        }

        SchemaComponent.Ref readHandle() {
            String readString = readString();
            if (readString == null) {
                return null;
            }
            if (readString.charAt(0) != '_') {
                return SchemaTypeSystemImpl.this._localHandles.refForHandle(readString);
            }
            char charAt = readString.charAt(2);
            if (charAt == 'A') {
                return SchemaTypeSystemImpl.this._linker.findAttributeRef(QNameHelper.forPretty(readString, 4));
            }
            if (charAt == 'I') {
                SchemaType schemaType = (SchemaType) BuiltinSchemaTypeSystem.get().resolveHandle(readString);
                if (schemaType != null) {
                    return schemaType.getRef();
                }
                return ((SchemaType) XQuerySchemaTypeSystem.get().resolveHandle(readString)).getRef();
            }
            if (charAt == 'Y') {
                SchemaType typeForSignature = SchemaTypeSystemImpl.this._linker.typeForSignature(readString.substring(4));
                if (typeForSignature == null) {
                    throw new SchemaTypeLoaderException(new StringBuffer().append("Cannot resolve type for handle ").append(readString).toString(), SchemaTypeSystemImpl.this._name, this._handle, 13);
                }
                return typeForSignature.getRef();
            }
            if (charAt == 'D') {
                return SchemaTypeSystemImpl.this._linker.findIdentityConstraintRef(QNameHelper.forPretty(readString, 4));
            }
            if (charAt == 'E') {
                return SchemaTypeSystemImpl.this._linker.findElementRef(QNameHelper.forPretty(readString, 4));
            }
            switch (charAt) {
                case 'M':
                    return SchemaTypeSystemImpl.this._linker.findModelGroupRef(QNameHelper.forPretty(readString, 4));
                case 'N':
                    return SchemaTypeSystemImpl.this._linker.findAttributeGroupRef(QNameHelper.forPretty(readString, 4));
                case 'O':
                    return SchemaTypeSystemImpl.this._linker.findDocumentTypeRef(QNameHelper.forPretty(readString, 4));
                default:
                    switch (charAt) {
                        case 'R':
                            SchemaGlobalAttribute findAttribute = SchemaTypeSystemImpl.this._linker.findAttribute(QNameHelper.forPretty(readString, 4));
                            if (findAttribute == null) {
                                throw new SchemaTypeLoaderException(new StringBuffer().append("Cannot resolve attribute for handle ").append(readString).toString(), SchemaTypeSystemImpl.this._name, this._handle, 13);
                            }
                            return findAttribute.getType().getRef();
                        case 'S':
                            SchemaGlobalElement findElement = SchemaTypeSystemImpl.this._linker.findElement(QNameHelper.forPretty(readString, 4));
                            if (findElement == null) {
                                throw new SchemaTypeLoaderException(new StringBuffer().append("Cannot resolve element for handle ").append(readString).toString(), SchemaTypeSystemImpl.this._name, this._handle, 13);
                            }
                            return findElement.getType().getRef();
                        case 'T':
                            return SchemaTypeSystemImpl.this._linker.findTypeRef(QNameHelper.forPretty(readString, 4));
                        default:
                            throw new SchemaTypeLoaderException(new StringBuffer().append("Cannot resolve handle ").append(readString).toString(), SchemaTypeSystemImpl.this._name, this._handle, 13);
                    }
            }
        }

        void writeHandle(SchemaComponent schemaComponent) {
            if (schemaComponent == null || schemaComponent.getTypeSystem() == SchemaTypeSystemImpl.this.getTypeSystem()) {
                writeString(SchemaTypeSystemImpl.this._localHandles.handleForComponent(schemaComponent));
                return;
            }
            int componentType = schemaComponent.getComponentType();
            if (componentType == 0) {
                SchemaType schemaType = (SchemaType) schemaComponent;
                if (schemaType.isBuiltinType()) {
                    writeString(new StringBuffer().append("_BI_").append(schemaType.getName().getLocalPart()).toString());
                    return;
                }
                if (schemaType.getName() != null) {
                    writeString(new StringBuffer().append("_XT_").append(QNameHelper.pretty(schemaType.getName())).toString());
                    return;
                } else if (schemaType.isDocumentType()) {
                    writeString(new StringBuffer().append("_XO_").append(QNameHelper.pretty(schemaType.getDocumentElementName())).toString());
                    return;
                } else {
                    writeString(new StringBuffer().append("_XY_").append(schemaType.toString()).toString());
                    return;
                }
            }
            if (componentType == 1) {
                writeString(new StringBuffer().append("_XE_").append(QNameHelper.pretty(schemaComponent.getName())).toString());
                return;
            }
            if (componentType == 3) {
                writeString(new StringBuffer().append("_XA_").append(QNameHelper.pretty(schemaComponent.getName())).toString());
                return;
            }
            if (componentType == 4) {
                writeString(new StringBuffer().append("_XN_").append(QNameHelper.pretty(schemaComponent.getName())).toString());
                return;
            }
            if (componentType == 5) {
                writeString(new StringBuffer().append("_XD_").append(QNameHelper.pretty(schemaComponent.getName())).toString());
            } else if (componentType == 6) {
                writeString(new StringBuffer().append("_XM_").append(QNameHelper.pretty(schemaComponent.getName())).toString());
            } else {
                if (!$assertionsDisabled) {
                    throw new AssertionError();
                }
                throw new SchemaTypeLoaderException(new StringBuffer().append("Cannot write handle for component ").append(schemaComponent).toString(), SchemaTypeSystemImpl.this._name, this._handle, 13);
            }
        }

        SchemaType.Ref readTypeRef() {
            return (SchemaType.Ref) readHandle();
        }

        void writeType(SchemaType schemaType) {
            writeHandle(schemaType);
        }

        Map readQNameRefMap() {
            HashMap hashMap = new HashMap();
            int readShort = readShort();
            for (int i = 0; i < readShort; i++) {
                hashMap.put(readQName(), readHandle());
            }
            return hashMap;
        }

        List readQNameRefMapAsList(List list) {
            int readShort = readShort();
            ArrayList arrayList = new ArrayList(readShort);
            for (int i = 0; i < readShort; i++) {
                QName readQName = readQName();
                arrayList.add(readHandle());
                list.add(readQName);
            }
            return arrayList;
        }

        void writeQNameMap(SchemaComponent[] schemaComponentArr) {
            writeShort(schemaComponentArr.length);
            for (int i = 0; i < schemaComponentArr.length; i++) {
                writeQName(schemaComponentArr[i].getName());
                writeHandle(schemaComponentArr[i]);
            }
        }

        void writeDocumentTypeMap(SchemaType[] schemaTypeArr) {
            writeShort(schemaTypeArr.length);
            for (int i = 0; i < schemaTypeArr.length; i++) {
                writeQName(schemaTypeArr[i].getDocumentElementName());
                writeHandle(schemaTypeArr[i]);
            }
        }

        void writeAttributeTypeMap(SchemaType[] schemaTypeArr) {
            writeShort(schemaTypeArr.length);
            for (int i = 0; i < schemaTypeArr.length; i++) {
                writeQName(schemaTypeArr[i].getAttributeTypeAttributeName());
                writeHandle(schemaTypeArr[i]);
            }
        }

        SchemaType.Ref[] readTypeRefArray() {
            int readShort = readShort();
            SchemaType.Ref[] refArr = new SchemaType.Ref[readShort];
            for (int i = 0; i < readShort; i++) {
                refArr[i] = readTypeRef();
            }
            return refArr;
        }

        void writeTypeArray(SchemaType[] schemaTypeArr) {
            writeShort(schemaTypeArr.length);
            for (SchemaType schemaType : schemaTypeArr) {
                writeHandle(schemaType);
            }
        }

        Map readClassnameRefMap() {
            HashMap hashMap = new HashMap();
            int readShort = readShort();
            for (int i = 0; i < readShort; i++) {
                hashMap.put(readString(), readHandle());
            }
            return hashMap;
        }

        void writeClassnameMap(Map map) {
            writeShort(map.size());
            for (String str : map.keySet()) {
                writeString(str);
                writeHandle(((SchemaType.Ref) map.get(str)).get());
            }
        }

        Set readNamespaces() {
            HashSet hashSet = new HashSet();
            int readShort = readShort();
            for (int i = 0; i < readShort; i++) {
                hashSet.add(readString());
            }
            return hashSet;
        }

        void writeNamespaces(Set set) {
            writeShort(set.size());
            Iterator it = set.iterator();
            while (it.hasNext()) {
                writeString((String) it.next());
            }
        }

        OutputStream getSaverStream(String str) {
            try {
                return SchemaTypeSystemImpl.this._filer.createBinaryFile(str);
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage(), SchemaTypeSystemImpl.this._name, this._handle, 9);
            }
        }

        InputStream getLoaderStream(String str) {
            return SchemaTypeSystemImpl.this._resourceLoader.getResourceAsStream(str);
        }

        void checkContainerNotNull(SchemaContainer schemaContainer, QName qName) {
            if (schemaContainer == null) {
                throw new LinkageError(new StringBuffer().append("Loading of resource ").append(SchemaTypeSystemImpl.this._name).append('.').append(this._handle).append("failed, information from ").append(SchemaTypeSystemImpl.this._name).append(".index.xsb is ").append(" out of sync (or conflicting index files found)").toString());
            }
        }

        public SchemaGlobalElement finishLoadingElement() {
            try {
                try {
                    int readShort = readShort();
                    if (readShort != 4) {
                        throw new SchemaTypeLoaderException("Wrong particle type ", SchemaTypeSystemImpl.this._name, this._handle, 11);
                    }
                    int readShort2 = readShort();
                    BigInteger readBigInteger = readBigInteger();
                    BigInteger readBigInteger2 = readBigInteger();
                    QNameSet readQNameSet = readQNameSet();
                    QName readQName = readQName();
                    SchemaContainer container = SchemaTypeSystemImpl.this.getContainer(readQName.getNamespaceURI());
                    checkContainerNotNull(container, readQName);
                    SchemaGlobalElementImpl schemaGlobalElementImpl = new SchemaGlobalElementImpl(container);
                    schemaGlobalElementImpl.setParticleType(readShort);
                    schemaGlobalElementImpl.setMinOccurs(readBigInteger);
                    schemaGlobalElementImpl.setMaxOccurs(readBigInteger2);
                    boolean z = true;
                    schemaGlobalElementImpl.setTransitionRules(readQNameSet, (readShort2 & 1) != 0);
                    schemaGlobalElementImpl.setNameAndTypeRef(readQName, readTypeRef());
                    schemaGlobalElementImpl.setDefault(readString(), (readShort2 & 4) != 0, null);
                    if (atLeast(2, 16, 0)) {
                        schemaGlobalElementImpl.setDefaultValue(readXmlValueObject());
                    }
                    schemaGlobalElementImpl.setNillable((readShort2 & 8) != 0);
                    schemaGlobalElementImpl.setBlock((readShort2 & 16) != 0, (readShort2 & 32) != 0, (readShort2 & 64) != 0);
                    schemaGlobalElementImpl.setWsdlArrayType(readSOAPArrayType());
                    schemaGlobalElementImpl.setAbstract((readShort2 & 128) != 0);
                    schemaGlobalElementImpl.setAnnotation(readAnnotation(container));
                    boolean z2 = (readShort2 & 256) != 0;
                    if ((readShort2 & 512) == 0) {
                        z = false;
                    }
                    schemaGlobalElementImpl.setFinal(z2, z);
                    if (atLeast(2, 17, 0)) {
                        schemaGlobalElementImpl.setSubstitutionGroup((SchemaGlobalElement.Ref) readHandle());
                    }
                    int readShort3 = readShort();
                    for (int i = 0; i < readShort3; i++) {
                        schemaGlobalElementImpl.addSubstitutionGroupMember(readQName());
                    }
                    int readShort4 = readShort();
                    SchemaIdentityConstraint.Ref[] refArr = new SchemaIdentityConstraint.Ref[readShort4];
                    for (int i2 = 0; i2 < readShort4; i2++) {
                        refArr[i2] = (SchemaIdentityConstraint.Ref) readHandle();
                    }
                    schemaGlobalElementImpl.setIdentityConstraints(refArr);
                    schemaGlobalElementImpl.setFilename(readString());
                    return schemaGlobalElementImpl;
                } catch (SchemaTypeLoaderException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new SchemaTypeLoaderException("Cannot load type from typesystem", SchemaTypeSystemImpl.this._name, null, 14, e2);
                }
            } finally {
                readEnd();
            }
        }

        public SchemaGlobalAttribute finishLoadingAttribute() {
            try {
                try {
                    QName readQName = readQName();
                    SchemaContainer container = SchemaTypeSystemImpl.this.getContainer(readQName.getNamespaceURI());
                    checkContainerNotNull(container, readQName);
                    SchemaGlobalAttributeImpl schemaGlobalAttributeImpl = new SchemaGlobalAttributeImpl(container);
                    loadAttribute(schemaGlobalAttributeImpl, readQName, container);
                    schemaGlobalAttributeImpl.setFilename(readString());
                    return schemaGlobalAttributeImpl;
                } catch (SchemaTypeLoaderException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new SchemaTypeLoaderException("Cannot load type from typesystem", SchemaTypeSystemImpl.this._name, this._handle, 14, e2);
                }
            } finally {
                readEnd();
            }
        }

        SchemaModelGroup finishLoadingModelGroup() {
            QName readQName = readQName();
            SchemaContainer container = SchemaTypeSystemImpl.this.getContainer(readQName.getNamespaceURI());
            checkContainerNotNull(container, readQName);
            SchemaModelGroupImpl schemaModelGroupImpl = new SchemaModelGroupImpl(container);
            try {
                try {
                    schemaModelGroupImpl.init(readQName, readString(), readShort() == 1, atLeast(2, 22, 0) ? readString() : null, atLeast(2, 22, 0) ? readString() : null, atLeast(2, 15, 0) && readShort() == 1, GroupDocument.Factory.parse(readString()).getGroup(), readAnnotation(container), null);
                    if (atLeast(2, 21, 0)) {
                        schemaModelGroupImpl.setFilename(readString());
                    }
                    return schemaModelGroupImpl;
                } catch (SchemaTypeLoaderException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new SchemaTypeLoaderException("Cannot load type from typesystem", SchemaTypeSystemImpl.this._name, this._handle, 14, e2);
                }
            } finally {
                readEnd();
            }
        }

        SchemaIdentityConstraint finishLoadingIdentityConstraint() {
            try {
                try {
                    QName readQName = readQName();
                    SchemaContainer container = SchemaTypeSystemImpl.this.getContainer(readQName.getNamespaceURI());
                    checkContainerNotNull(container, readQName);
                    SchemaIdentityConstraintImpl schemaIdentityConstraintImpl = new SchemaIdentityConstraintImpl(container);
                    schemaIdentityConstraintImpl.setName(readQName);
                    schemaIdentityConstraintImpl.setConstraintCategory(readShort());
                    schemaIdentityConstraintImpl.setSelector(readString());
                    schemaIdentityConstraintImpl.setAnnotation(readAnnotation(container));
                    int readShort = readShort();
                    String[] strArr = new String[readShort];
                    for (int i = 0; i < readShort; i++) {
                        strArr[i] = readString();
                    }
                    schemaIdentityConstraintImpl.setFields(strArr);
                    if (schemaIdentityConstraintImpl.getConstraintCategory() == 2) {
                        schemaIdentityConstraintImpl.setReferencedKey((SchemaIdentityConstraint.Ref) readHandle());
                    }
                    int readShort2 = readShort();
                    HashMap hashMap = new HashMap();
                    for (int i2 = 0; i2 < readShort2; i2++) {
                        hashMap.put(readString(), readString());
                    }
                    schemaIdentityConstraintImpl.setNSMap(hashMap);
                    if (atLeast(2, 21, 0)) {
                        schemaIdentityConstraintImpl.setFilename(readString());
                    }
                    return schemaIdentityConstraintImpl;
                } catch (SchemaTypeLoaderException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new SchemaTypeLoaderException("Cannot load type from typesystem", SchemaTypeSystemImpl.this._name, this._handle, 14, e2);
                }
            } finally {
                readEnd();
            }
        }

        SchemaAttributeGroup finishLoadingAttributeGroup() {
            QName readQName = readQName();
            SchemaContainer container = SchemaTypeSystemImpl.this.getContainer(readQName.getNamespaceURI());
            checkContainerNotNull(container, readQName);
            SchemaAttributeGroupImpl schemaAttributeGroupImpl = new SchemaAttributeGroupImpl(container);
            try {
                try {
                    try {
                        schemaAttributeGroupImpl.init(readQName, readString(), readShort() == 1, atLeast(2, 22, 0) ? readString() : null, atLeast(2, 15, 0) && readShort() == 1, AttributeGroupDocument.Factory.parse(readString()).getAttributeGroup(), readAnnotation(container), null);
                        if (atLeast(2, 21, 0)) {
                            schemaAttributeGroupImpl.setFilename(readString());
                        }
                        return schemaAttributeGroupImpl;
                    } catch (SchemaTypeLoaderException e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw new SchemaTypeLoaderException("Cannot load type from typesystem", SchemaTypeSystemImpl.this._name, this._handle, 14, e2);
                }
            } finally {
                readEnd();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:180:0x01f4  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x01f2  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public org.apache.xmlbeans.SchemaType finishLoadingType() {
            /*
                Method dump skipped, instructions count: 1009
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl.XsbReader.finishLoadingType():org.apache.xmlbeans.SchemaType");
        }

        /* JADX WARN: Multi-variable type inference failed */
        void writeTypeData(SchemaType schemaType) {
            writeQName(schemaType.getName());
            writeType(schemaType.getOuterType());
            SchemaTypeImpl schemaTypeImpl = (SchemaTypeImpl) schemaType;
            writeShort(schemaTypeImpl.getBaseDepth());
            writeType(schemaType.getBaseType());
            writeShort(schemaType.getDerivationType());
            writeAnnotation(schemaType.getAnnotation());
            if (schemaType.getContainerField() == null) {
                writeShort(0);
            } else if (schemaType.getOuterType().isAttributeType() || schemaType.getOuterType().isDocumentType()) {
                writeShort(1);
                writeHandle((SchemaComponent) schemaType.getContainerField());
            } else if (schemaType.getContainerField().isAttribute()) {
                writeShort(2);
                writeShort(((SchemaTypeImpl) schemaType.getOuterType()).getIndexForLocalAttribute((SchemaLocalAttribute) schemaType.getContainerField()));
            } else {
                writeShort(3);
                writeShort(((SchemaTypeImpl) schemaType.getOuterType()).getIndexForLocalElement((SchemaLocalElement) schemaType.getContainerField()));
            }
            writeString(schemaType.getFullJavaName());
            writeString(schemaType.getFullJavaImplName());
            writeTypeArray(schemaType.getAnonymousTypes());
            writeShort(schemaType.getAnonymousUnionMemberOrdinal());
            boolean isSimpleType = schemaType.isSimpleType();
            int i = isSimpleType;
            if (schemaType.isDocumentType()) {
                i = (isSimpleType ? 1 : 0) | 2;
            }
            int i2 = i;
            if (schemaType.isAttributeType()) {
                i2 = (i == true ? 1 : 0) | 524288;
            }
            int i3 = i2;
            if (schemaType.ordered() != 0) {
                i3 = (i2 == true ? 1 : 0) | 4;
            }
            int i4 = i3;
            if (schemaType.ordered() == 2) {
                i4 = (i3 == true ? 1 : 0) | 1024;
            }
            int i5 = i4;
            if (schemaType.isBounded()) {
                i5 = (i4 == true ? 1 : 0) | 8;
            }
            int i6 = i5;
            if (schemaType.isFinite()) {
                i6 = (i5 == true ? 1 : 0) | 16;
            }
            int i7 = i6;
            if (schemaType.isNumeric()) {
                i7 = (i6 == true ? 1 : 0) | 32;
            }
            int i8 = i7;
            if (schemaType.hasStringEnumValues()) {
                i8 = (i7 == true ? 1 : 0) | 64;
            }
            int i9 = i8;
            if (schemaTypeImpl.isUnionOfLists()) {
                i9 = (i8 == true ? 1 : 0) | 128;
            }
            int i10 = i9;
            if (schemaType.hasPatternFacet()) {
                i10 = (i9 == true ? 1 : 0) | 256;
            }
            int i11 = i10;
            if (schemaType.isOrderSensitive()) {
                i11 = (i10 == true ? 1 : 0) | 512;
            }
            int i12 = i11;
            if (schemaType.blockExtension()) {
                i12 = (i11 == true ? 1 : 0) | 4096;
            }
            int i13 = i12;
            if (schemaType.blockRestriction()) {
                i13 = (i12 == true ? 1 : 0) | 8192;
            }
            int i14 = i13;
            if (schemaType.finalExtension()) {
                i14 = (i13 == true ? 1 : 0) | 16384;
            }
            int i15 = i14;
            if (schemaType.finalRestriction()) {
                i15 = (i14 == true ? 1 : 0) | 16384;
            }
            int i16 = i15;
            if (schemaType.finalList()) {
                i16 = (i15 == true ? 1 : 0) | 131072;
            }
            int i17 = i16;
            if (schemaType.finalUnion()) {
                i17 = (i16 == true ? 1 : 0) | 65536;
            }
            int i18 = i17;
            if (schemaType.isAbstract()) {
                i18 = (i17 == true ? 1 : 0) | 262144;
            }
            writeInt(i18);
            if (!schemaType.isSimpleType()) {
                writeShort(schemaType.getContentType());
                writeType(schemaType.getContentBasedOnType());
                SchemaAttributeModel attributeModel = schemaType.getAttributeModel();
                SchemaLocalAttribute[] attributes = attributeModel.getAttributes();
                writeShort(attributes.length);
                for (SchemaLocalAttribute schemaLocalAttribute : attributes) {
                    writeAttributeData(schemaLocalAttribute);
                }
                writeQNameSet(attributeModel.getWildcardSet());
                writeShort(attributeModel.getWildcardProcess());
                SchemaProperty[] attributeProperties = schemaType.getAttributeProperties();
                writeShort(attributeProperties.length);
                for (SchemaProperty schemaProperty : attributeProperties) {
                    writePropertyData(schemaProperty);
                }
                if (schemaType.getContentType() == 3 || schemaType.getContentType() == 4) {
                    writeShort(schemaType.hasAllContent() ? 1 : 0);
                    writeParticleArray(schemaType.getContentModel() != null ? new SchemaParticle[]{schemaType.getContentModel()} : new SchemaParticle[0]);
                    SchemaProperty[] elementProperties = schemaType.getElementProperties();
                    writeShort(elementProperties.length);
                    for (SchemaProperty schemaProperty2 : elementProperties) {
                        writePropertyData(schemaProperty2);
                    }
                }
            }
            if (schemaType.isSimpleType() || schemaType.getContentType() == 2) {
                writeShort(schemaType.getSimpleVariety());
                int i19 = 0;
                for (int i20 = 0; i20 <= 11; i20++) {
                    if (schemaType.getFacet(i20) != null) {
                        i19++;
                    }
                }
                writeShort(i19);
                for (int i21 = 0; i21 <= 11; i21++) {
                    XmlAnySimpleType facet = schemaType.getFacet(i21);
                    if (facet != null) {
                        writeShort(i21);
                        writeXmlValueObject(facet);
                        writeShort(schemaType.isFacetFixed(i21) ? 1 : 0);
                    }
                }
                writeShort(schemaType.getWhiteSpaceRule());
                RegularExpression[] patternExpressions = schemaTypeImpl.getPatternExpressions();
                writeShort(patternExpressions.length);
                for (RegularExpression regularExpression : patternExpressions) {
                    writeString(regularExpression.getPattern());
                }
                XmlAnySimpleType[] enumerationValues = schemaType.getEnumerationValues();
                if (enumerationValues == null) {
                    writeShort(0);
                } else {
                    writeShort(enumerationValues.length);
                    for (XmlAnySimpleType xmlAnySimpleType : enumerationValues) {
                        writeXmlValueObject(xmlAnySimpleType);
                    }
                }
                writeType(schemaType.getBaseEnumType());
                if (schemaType.hasStringEnumValues()) {
                    SchemaStringEnumEntry[] stringEnumEntries = schemaType.getStringEnumEntries();
                    writeShort(stringEnumEntries.length);
                    for (int i22 = 0; i22 < stringEnumEntries.length; i22++) {
                        writeString(stringEnumEntries[i22].getString());
                        writeShort(stringEnumEntries[i22].getIntValue());
                        writeString(stringEnumEntries[i22].getEnumName());
                    }
                }
                int simpleVariety = schemaType.getSimpleVariety();
                if (simpleVariety == 1) {
                    writeType(schemaType.getPrimitiveType());
                    writeInt(schemaType.getDecimalSize());
                } else if (simpleVariety == 2) {
                    writeTypeArray(schemaType.getUnionMemberTypes());
                } else if (simpleVariety == 3) {
                    writeType(schemaType.getListItemType());
                }
            }
            writeString(schemaType.getSourceName());
        }

        void readExtensionsList() {
            int readShort = readShort();
            if (!$assertionsDisabled && readShort != 0) {
                throw new AssertionError();
            }
            for (int i = 0; i < readShort; i++) {
                readString();
                readString();
                readString();
            }
        }

        SchemaLocalAttribute readAttributeData() {
            SchemaLocalAttributeImpl schemaLocalAttributeImpl = new SchemaLocalAttributeImpl();
            loadAttribute(schemaLocalAttributeImpl, readQName(), null);
            return schemaLocalAttributeImpl;
        }

        void loadAttribute(SchemaLocalAttributeImpl schemaLocalAttributeImpl, QName qName, SchemaContainer schemaContainer) {
            schemaLocalAttributeImpl.init(qName, readTypeRef(), readShort(), readString(), null, atLeast(2, 16, 0) ? readXmlValueObject() : null, readShort() == 1, readSOAPArrayType(), readAnnotation(schemaContainer), null);
        }

        void writeAttributeData(SchemaLocalAttribute schemaLocalAttribute) {
            writeQName(schemaLocalAttribute.getName());
            writeType(schemaLocalAttribute.getType());
            writeShort(schemaLocalAttribute.getUse());
            writeString(schemaLocalAttribute.getDefaultText());
            writeXmlValueObject(schemaLocalAttribute.getDefaultValue());
            writeShort(schemaLocalAttribute.isFixed() ? 1 : 0);
            writeSOAPArrayType(((SchemaWSDLArrayType) schemaLocalAttribute).getWSDLArrayType());
            writeAnnotation(schemaLocalAttribute.getAnnotation());
        }

        void writeIdConstraintData(SchemaIdentityConstraint schemaIdentityConstraint) {
            writeQName(schemaIdentityConstraint.getName());
            writeShort(schemaIdentityConstraint.getConstraintCategory());
            writeString(schemaIdentityConstraint.getSelector());
            writeAnnotation(schemaIdentityConstraint.getAnnotation());
            String[] fields = schemaIdentityConstraint.getFields();
            writeShort(fields.length);
            for (String str : fields) {
                writeString(str);
            }
            if (schemaIdentityConstraint.getConstraintCategory() == 2) {
                writeHandle(schemaIdentityConstraint.getReferencedKey());
            }
            Set<Map.Entry> entrySet = schemaIdentityConstraint.getNSMap().entrySet();
            writeShort(entrySet.size());
            for (Map.Entry entry : entrySet) {
                String str2 = (String) entry.getKey();
                String str3 = (String) entry.getValue();
                writeString(str2);
                writeString(str3);
            }
            writeString(schemaIdentityConstraint.getSourceName());
        }

        SchemaParticle[] readParticleArray() {
            int readShort = readShort();
            SchemaParticle[] schemaParticleArr = new SchemaParticle[readShort];
            for (int i = 0; i < readShort; i++) {
                schemaParticleArr[i] = readParticleData();
            }
            return schemaParticleArr;
        }

        void writeParticleArray(SchemaParticle[] schemaParticleArr) {
            writeShort(schemaParticleArr.length);
            for (SchemaParticle schemaParticle : schemaParticleArr) {
                writeParticleData(schemaParticle);
            }
        }

        SchemaParticle readParticleData() {
            SchemaParticleImpl schemaLocalElementImpl;
            int readShort = readShort();
            if (readShort != 4) {
                schemaLocalElementImpl = new SchemaParticleImpl();
            } else {
                schemaLocalElementImpl = new SchemaLocalElementImpl();
            }
            loadParticle(schemaLocalElementImpl, readShort);
            return schemaLocalElementImpl;
        }

        void loadParticle(SchemaParticleImpl schemaParticleImpl, int i) {
            int readShort = readShort();
            schemaParticleImpl.setParticleType(i);
            schemaParticleImpl.setMinOccurs(readBigInteger());
            schemaParticleImpl.setMaxOccurs(readBigInteger());
            schemaParticleImpl.setTransitionRules(readQNameSet(), (readShort & 1) != 0);
            if (i == 1 || i == 2 || i == 3) {
                schemaParticleImpl.setParticleChildren(readParticleArray());
                return;
            }
            if (i != 4) {
                if (i == 5) {
                    schemaParticleImpl.setWildcardSet(readQNameSet());
                    schemaParticleImpl.setWildcardProcess(readShort());
                    return;
                }
                throw new SchemaTypeLoaderException("Unrecognized particle type ", SchemaTypeSystemImpl.this._name, this._handle, 11);
            }
            SchemaLocalElementImpl schemaLocalElementImpl = (SchemaLocalElementImpl) schemaParticleImpl;
            schemaLocalElementImpl.setNameAndTypeRef(readQName(), readTypeRef());
            schemaLocalElementImpl.setDefault(readString(), (readShort & 4) != 0, null);
            if (atLeast(2, 16, 0)) {
                schemaLocalElementImpl.setDefaultValue(readXmlValueObject());
            }
            schemaLocalElementImpl.setNillable((readShort & 8) != 0);
            schemaLocalElementImpl.setBlock((readShort & 16) != 0, (readShort & 32) != 0, (readShort & 64) != 0);
            schemaLocalElementImpl.setWsdlArrayType(readSOAPArrayType());
            schemaLocalElementImpl.setAbstract((readShort & 128) != 0);
            schemaLocalElementImpl.setAnnotation(readAnnotation(null));
            int readShort2 = readShort();
            SchemaIdentityConstraint.Ref[] refArr = new SchemaIdentityConstraint.Ref[readShort2];
            for (int i2 = 0; i2 < readShort2; i2++) {
                refArr[i2] = (SchemaIdentityConstraint.Ref) readHandle();
            }
            schemaLocalElementImpl.setIdentityConstraints(refArr);
        }

        void writeParticleData(SchemaParticle schemaParticle) {
            writeShort(schemaParticle.getParticleType());
            short s = schemaParticle.isSkippable() ? (short) 1 : (short) 0;
            if (schemaParticle.getParticleType() == 4) {
                SchemaLocalElement schemaLocalElement = (SchemaLocalElement) schemaParticle;
                if (schemaLocalElement.isFixed()) {
                    s = (short) (s | 4);
                }
                if (schemaLocalElement.isNillable()) {
                    s = (short) (s | 8);
                }
                if (schemaLocalElement.blockExtension()) {
                    s = (short) (s | 16);
                }
                if (schemaLocalElement.blockRestriction()) {
                    s = (short) (s | 32);
                }
                if (schemaLocalElement.blockSubstitution()) {
                    s = (short) (s | 64);
                }
                if (schemaLocalElement.isAbstract()) {
                    s = (short) (s | 128);
                }
                if (schemaLocalElement instanceof SchemaGlobalElement) {
                    SchemaGlobalElement schemaGlobalElement = (SchemaGlobalElement) schemaLocalElement;
                    if (schemaGlobalElement.finalExtension()) {
                        s = (short) (s | 256);
                    }
                    if (schemaGlobalElement.finalRestriction()) {
                        s = (short) (s | 512);
                    }
                }
            }
            writeShort(s);
            writeBigInteger(schemaParticle.getMinOccurs());
            writeBigInteger(schemaParticle.getMaxOccurs());
            writeQNameSet(schemaParticle.acceptedStartNames());
            int particleType = schemaParticle.getParticleType();
            if (particleType == 1 || particleType == 2 || particleType == 3) {
                writeParticleArray(schemaParticle.getParticleChildren());
                return;
            }
            if (particleType != 4) {
                if (particleType == 5) {
                    writeQNameSet(schemaParticle.getWildcardSet());
                    writeShort(schemaParticle.getWildcardProcess());
                    return;
                }
                throw new SchemaTypeLoaderException("Unrecognized particle type ", SchemaTypeSystemImpl.this._name, this._handle, 11);
            }
            SchemaLocalElement schemaLocalElement2 = (SchemaLocalElement) schemaParticle;
            writeQName(schemaLocalElement2.getName());
            writeType(schemaLocalElement2.getType());
            writeString(schemaLocalElement2.getDefaultText());
            writeXmlValueObject(schemaLocalElement2.getDefaultValue());
            writeSOAPArrayType(((SchemaWSDLArrayType) schemaLocalElement2).getWSDLArrayType());
            writeAnnotation(schemaLocalElement2.getAnnotation());
            if (schemaLocalElement2 instanceof SchemaGlobalElement) {
                SchemaGlobalElement schemaGlobalElement2 = (SchemaGlobalElement) schemaLocalElement2;
                writeHandle(schemaGlobalElement2.substitutionGroup());
                QName[] substitutionGroupMembers = schemaGlobalElement2.substitutionGroupMembers();
                writeShort(substitutionGroupMembers.length);
                for (QName qName : substitutionGroupMembers) {
                    writeQName(qName);
                }
            }
            SchemaIdentityConstraint[] identityConstraints = schemaLocalElement2.getIdentityConstraints();
            writeShort(identityConstraints.length);
            for (SchemaIdentityConstraint schemaIdentityConstraint : identityConstraints) {
                writeHandle(schemaIdentityConstraint);
            }
        }

        SchemaProperty readPropertyData() {
            SchemaPropertyImpl schemaPropertyImpl = new SchemaPropertyImpl();
            schemaPropertyImpl.setName(readQName());
            schemaPropertyImpl.setTypeRef(readTypeRef());
            int readShort = readShort();
            schemaPropertyImpl.setAttribute((readShort & 1) != 0);
            schemaPropertyImpl.setContainerTypeRef(readTypeRef());
            schemaPropertyImpl.setMinOccurs(readBigInteger());
            schemaPropertyImpl.setMaxOccurs(readBigInteger());
            schemaPropertyImpl.setNillable(readShort());
            schemaPropertyImpl.setDefault(readShort());
            schemaPropertyImpl.setFixed(readShort());
            schemaPropertyImpl.setDefaultText(readString());
            schemaPropertyImpl.setJavaPropertyName(readString());
            schemaPropertyImpl.setJavaTypeCode(readShort());
            schemaPropertyImpl.setExtendsJava(readTypeRef(), (readShort & 2) != 0, (readShort & 4) != 0, (readShort & 8) != 0);
            if (atMost(2, 19, 0)) {
                schemaPropertyImpl.setJavaSetterDelimiter(readQNameSet());
            }
            if (atLeast(2, 16, 0)) {
                schemaPropertyImpl.setDefaultValue(readXmlValueObject());
            }
            if (!schemaPropertyImpl.isAttribute() && atLeast(2, 17, 0)) {
                int readShort2 = readShort();
                LinkedHashSet linkedHashSet = new LinkedHashSet(readShort2);
                for (int i = 0; i < readShort2; i++) {
                    linkedHashSet.add(readQName());
                }
                schemaPropertyImpl.setAcceptedNames(linkedHashSet);
            }
            schemaPropertyImpl.setImmutable();
            return schemaPropertyImpl;
        }

        void writePropertyData(SchemaProperty schemaProperty) {
            writeQName(schemaProperty.getName());
            writeType(schemaProperty.getType());
            writeShort((schemaProperty.isAttribute() ? 1 : 0) | (schemaProperty.extendsJavaSingleton() ? 2 : 0) | (schemaProperty.extendsJavaOption() ? 4 : 0) | (schemaProperty.extendsJavaArray() ? 8 : 0));
            writeType(schemaProperty.getContainerType());
            writeBigInteger(schemaProperty.getMinOccurs());
            writeBigInteger(schemaProperty.getMaxOccurs());
            writeShort(schemaProperty.hasNillable());
            writeShort(schemaProperty.hasDefault());
            writeShort(schemaProperty.hasFixed());
            writeString(schemaProperty.getDefaultText());
            writeString(schemaProperty.getJavaPropertyName());
            writeShort(schemaProperty.getJavaTypeCode());
            writeType(schemaProperty.javaBasedOnType());
            writeXmlValueObject(schemaProperty.getDefaultValue());
            if (schemaProperty.isAttribute()) {
                return;
            }
            QName[] acceptedNames = schemaProperty.acceptedNames();
            writeShort(acceptedNames.length);
            for (QName qName : acceptedNames) {
                writeQName(qName);
            }
        }

        void writeModelGroupData(SchemaModelGroup schemaModelGroup) {
            SchemaModelGroupImpl schemaModelGroupImpl = (SchemaModelGroupImpl) schemaModelGroup;
            writeQName(schemaModelGroupImpl.getName());
            writeString(schemaModelGroupImpl.getTargetNamespace());
            writeShort(schemaModelGroupImpl.getChameleonNamespace() != null ? 1 : 0);
            writeString(schemaModelGroupImpl.getElemFormDefault());
            writeString(schemaModelGroupImpl.getAttFormDefault());
            writeShort(schemaModelGroupImpl.isRedefinition() ? 1 : 0);
            writeString(schemaModelGroupImpl.getParseObject().xmlText(new XmlOptions().setSaveOuter()));
            writeAnnotation(schemaModelGroupImpl.getAnnotation());
            writeString(schemaModelGroupImpl.getSourceName());
        }

        void writeAttributeGroupData(SchemaAttributeGroup schemaAttributeGroup) {
            SchemaAttributeGroupImpl schemaAttributeGroupImpl = (SchemaAttributeGroupImpl) schemaAttributeGroup;
            writeQName(schemaAttributeGroupImpl.getName());
            writeString(schemaAttributeGroupImpl.getTargetNamespace());
            writeShort(schemaAttributeGroupImpl.getChameleonNamespace() != null ? 1 : 0);
            writeString(schemaAttributeGroupImpl.getFormDefault());
            writeShort(schemaAttributeGroupImpl.isRedefinition() ? 1 : 0);
            writeString(schemaAttributeGroupImpl.getParseObject().xmlText(new XmlOptions().setSaveOuter()));
            writeAnnotation(schemaAttributeGroupImpl.getAnnotation());
            writeString(schemaAttributeGroupImpl.getSourceName());
        }

        XmlValueRef readXmlValueObject() {
            SchemaType.Ref readTypeRef = readTypeRef();
            if (readTypeRef == null) {
                return null;
            }
            int readShort = readShort();
            if (readShort != 0) {
                if (readShort == 65535) {
                    int readShort2 = readShort();
                    ArrayList arrayList = new ArrayList();
                    writeShort(arrayList.size());
                    for (int i = 0; i < readShort2; i++) {
                        arrayList.add(readXmlValueObject());
                    }
                    return new XmlValueRef(readTypeRef, arrayList);
                }
                switch (readShort) {
                    case 2:
                    case 3:
                    case 6:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                        return new XmlValueRef(readTypeRef, readString());
                    case 4:
                    case 5:
                        return new XmlValueRef(readTypeRef, readByteArray());
                    case 7:
                    case 8:
                        return new XmlValueRef(readTypeRef, readQName());
                    case 9:
                    case 10:
                        return new XmlValueRef(readTypeRef, new Double(readDouble()));
                    default:
                        if (!$assertionsDisabled) {
                            throw new AssertionError();
                        }
                        break;
                }
            }
            return new XmlValueRef(readTypeRef, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        void writeXmlValueObject(XmlAnySimpleType xmlAnySimpleType) {
            SchemaType schemaType = xmlAnySimpleType == 0 ? null : xmlAnySimpleType.schemaType();
            writeType(schemaType);
            if (schemaType == null) {
            }
            SimpleValue simpleValue = (SimpleValue) xmlAnySimpleType;
            SchemaType instanceType = simpleValue.instanceType();
            if (instanceType == null) {
                writeShort(0);
                return;
            }
            if (instanceType.getSimpleVariety() == 3) {
                writeShort(-1);
                List xgetListValue = ((XmlObjectBase) xmlAnySimpleType).xgetListValue();
                writeShort(xgetListValue.size());
                Iterator it = xgetListValue.iterator();
                while (it.hasNext()) {
                    writeXmlValueObject((XmlAnySimpleType) it.next());
                }
                return;
            }
            int builtinTypeCode = instanceType.getPrimitiveType().getBuiltinTypeCode();
            writeShort(builtinTypeCode);
            switch (builtinTypeCode) {
                case 2:
                case 3:
                case 6:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                    writeString(xmlAnySimpleType.getStringValue());
                    break;
                case 4:
                case 5:
                    writeByteArray(simpleValue.getByteArrayValue());
                    break;
                case 7:
                case 8:
                    writeQName(simpleValue.getQNameValue());
                    break;
                case 9:
                    writeDouble(simpleValue.getFloatValue());
                    break;
                case 10:
                    writeDouble(simpleValue.getDoubleValue());
                    break;
            }
        }

        double readDouble() {
            try {
                return this._input.readDouble();
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage(), SchemaTypeSystemImpl.this._name, this._handle, 9);
            }
        }

        void writeDouble(double d) {
            DataOutputStream dataOutputStream = this._output;
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.writeDouble(d);
                } catch (IOException e) {
                    throw new SchemaTypeLoaderException(e.getMessage(), SchemaTypeSystemImpl.this._name, this._handle, 9);
                }
            }
        }

        QNameSet readQNameSet() {
            int readShort = readShort();
            HashSet hashSet = new HashSet();
            int readShort2 = readShort();
            for (int i = 0; i < readShort2; i++) {
                hashSet.add(readString());
            }
            HashSet hashSet2 = new HashSet();
            int readShort3 = readShort();
            for (int i2 = 0; i2 < readShort3; i2++) {
                hashSet2.add(readQName());
            }
            HashSet hashSet3 = new HashSet();
            int readShort4 = readShort();
            for (int i3 = 0; i3 < readShort4; i3++) {
                hashSet3.add(readQName());
            }
            if (readShort == 1) {
                return QNameSet.forSets(hashSet, null, hashSet2, hashSet3);
            }
            return QNameSet.forSets(null, hashSet, hashSet3, hashSet2);
        }

        void writeQNameSet(QNameSet qNameSet) {
            int i = qNameSet.excludedURIs() != null ? 1 : 0;
            writeShort(i);
            Set excludedURIs = i != 0 ? qNameSet.excludedURIs() : qNameSet.includedURIs();
            writeShort(excludedURIs.size());
            Iterator it = excludedURIs.iterator();
            while (it.hasNext()) {
                writeString((String) it.next());
            }
            Set excludedQNamesInIncludedURIs = i != 0 ? qNameSet.excludedQNamesInIncludedURIs() : qNameSet.includedQNamesInExcludedURIs();
            writeShort(excludedQNamesInIncludedURIs.size());
            Iterator it2 = excludedQNamesInIncludedURIs.iterator();
            while (it2.hasNext()) {
                writeQName((QName) it2.next());
            }
            Set includedQNamesInExcludedURIs = i != 0 ? qNameSet.includedQNamesInExcludedURIs() : qNameSet.excludedQNamesInIncludedURIs();
            writeShort(includedQNamesInExcludedURIs.size());
            Iterator it3 = includedQNamesInExcludedURIs.iterator();
            while (it3.hasNext()) {
                writeQName((QName) it3.next());
            }
        }

        byte[] readByteArray() {
            try {
                byte[] bArr = new byte[this._input.readShort()];
                this._input.readFully(bArr);
                return bArr;
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage(), SchemaTypeSystemImpl.this._name, this._handle, 9);
            }
        }

        void writeByteArray(byte[] bArr) {
            try {
                writeShort(bArr.length);
                DataOutputStream dataOutputStream = this._output;
                if (dataOutputStream != null) {
                    dataOutputStream.write(bArr);
                }
            } catch (IOException e) {
                throw new SchemaTypeLoaderException(e.getMessage(), SchemaTypeSystemImpl.this._name, this._handle, 9);
            }
        }

        BigInteger readBigInteger() {
            byte[] readByteArray = readByteArray();
            if (readByteArray.length == 0) {
                return null;
            }
            if (readByteArray.length == 1 && readByteArray[0] == 0) {
                return BigInteger.ZERO;
            }
            if (readByteArray.length == 1 && readByteArray[0] == 1) {
                return BigInteger.ONE;
            }
            return new BigInteger(readByteArray);
        }

        void writeBigInteger(BigInteger bigInteger) {
            if (bigInteger == null) {
                writeShort(0);
            } else if (bigInteger.signum() == 0) {
                writeByteArray(SchemaTypeSystemImpl.SINGLE_ZERO_BYTE);
            } else {
                writeByteArray(bigInteger.toByteArray());
            }
        }
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaType typeForHandle(String str) {
        SchemaType schemaType;
        synchronized (this._resolvedHandles) {
            schemaType = (SchemaType) this._resolvedHandles.get(str);
        }
        return schemaType;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType typeForClassname(String str) {
        SchemaType.Ref ref = (SchemaType.Ref) this._typeRefsByClassname.get(str);
        if (ref != null) {
            return ref.get();
        }
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaComponent resolveHandle(String str) {
        SchemaComponent schemaComponent;
        SchemaComponent finishLoadingType;
        synchronized (this._resolvedHandles) {
            schemaComponent = (SchemaComponent) this._resolvedHandles.get(str);
        }
        if (schemaComponent == null) {
            XsbReader xsbReader = new XsbReader(str, 65535);
            int actualFiletype = xsbReader.getActualFiletype();
            if (actualFiletype == 2) {
                XBeanDebug.trace(1, new StringBuffer().append("Resolving type for handle ").append(str).toString(), 0);
                finishLoadingType = xsbReader.finishLoadingType();
            } else if (actualFiletype == 3) {
                XBeanDebug.trace(1, new StringBuffer().append("Resolving element for handle ").append(str).toString(), 0);
                finishLoadingType = xsbReader.finishLoadingElement();
            } else if (actualFiletype == 4) {
                XBeanDebug.trace(1, new StringBuffer().append("Resolving attribute for handle ").append(str).toString(), 0);
                finishLoadingType = xsbReader.finishLoadingAttribute();
            } else if (actualFiletype == 6) {
                XBeanDebug.trace(1, new StringBuffer().append("Resolving model group for handle ").append(str).toString(), 0);
                finishLoadingType = xsbReader.finishLoadingModelGroup();
            } else if (actualFiletype == 7) {
                XBeanDebug.trace(1, new StringBuffer().append("Resolving attribute group for handle ").append(str).toString(), 0);
                finishLoadingType = xsbReader.finishLoadingAttributeGroup();
            } else if (actualFiletype == 8) {
                XBeanDebug.trace(1, new StringBuffer().append("Resolving id constraint for handle ").append(str).toString(), 0);
                finishLoadingType = xsbReader.finishLoadingIdentityConstraint();
            } else {
                throw new IllegalStateException("Illegal handle type");
            }
            synchronized (this._resolvedHandles) {
                if (!this._resolvedHandles.containsKey(str)) {
                    this._resolvedHandles.put(str, finishLoadingType);
                    schemaComponent = finishLoadingType;
                } else {
                    schemaComponent = (SchemaComponent) this._resolvedHandles.get(str);
                }
            }
        }
        return schemaComponent;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public void resolve() {
        XBeanDebug.trace(1, new StringBuffer().append("Resolve called type system ").append(this._name).toString(), 0);
        if (this._allNonGroupHandlesResolved) {
            return;
        }
        XBeanDebug.trace(1, new StringBuffer().append("Resolving all handles for type system ").append(this._name).toString(), 1);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this._globalElements.values());
        arrayList.addAll(this._globalAttributes.values());
        arrayList.addAll(this._globalTypes.values());
        arrayList.addAll(this._documentTypes.values());
        arrayList.addAll(this._attributeTypes.values());
        arrayList.addAll(this._identityConstraints.values());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((SchemaComponent.Ref) it.next()).getComponent();
        }
        XBeanDebug.trace(1, new StringBuffer().append("Finished resolving type system ").append(this._name).toString(), -1);
        this._allNonGroupHandlesResolved = true;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public boolean isNamespaceDefined(String str) {
        return this._namespaces.contains(str);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findTypeRef(QName qName) {
        return (SchemaType.Ref) this._globalTypes.get(qName);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findDocumentTypeRef(QName qName) {
        return (SchemaType.Ref) this._documentTypes.get(qName);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findAttributeTypeRef(QName qName) {
        return (SchemaType.Ref) this._attributeTypes.get(qName);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalElement.Ref findElementRef(QName qName) {
        return (SchemaGlobalElement.Ref) this._globalElements.get(qName);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalAttribute.Ref findAttributeRef(QName qName) {
        return (SchemaGlobalAttribute.Ref) this._globalAttributes.get(qName);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaModelGroup.Ref findModelGroupRef(QName qName) {
        return (SchemaModelGroup.Ref) this._modelGroups.get(qName);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaAttributeGroup.Ref findAttributeGroupRef(QName qName) {
        return (SchemaAttributeGroup.Ref) this._attributeGroups.get(qName);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaIdentityConstraint.Ref findIdentityConstraintRef(QName qName) {
        return (SchemaIdentityConstraint.Ref) this._identityConstraints.get(qName);
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaType[] globalTypes() {
        if (this._globalTypes.isEmpty()) {
            return EMPTY_ST_ARRAY;
        }
        SchemaType[] schemaTypeArr = new SchemaType[this._globalTypes.size()];
        int i = 0;
        Iterator it = this._globalTypes.values().iterator();
        while (it.hasNext()) {
            schemaTypeArr[i] = ((SchemaType.Ref) it.next()).get();
            i++;
        }
        return schemaTypeArr;
    }

    public SchemaType[] redefinedGlobalTypes() {
        List list = this._redefinedGlobalTypes;
        if (list == null || list.isEmpty()) {
            return EMPTY_ST_ARRAY;
        }
        SchemaType[] schemaTypeArr = new SchemaType[this._redefinedGlobalTypes.size()];
        int i = 0;
        Iterator it = this._redefinedGlobalTypes.iterator();
        while (it.hasNext()) {
            schemaTypeArr[i] = ((SchemaType.Ref) it.next()).get();
            i++;
        }
        return schemaTypeArr;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public InputStream getSourceAsStream(String str) {
        if (!str.startsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            str = new StringBuffer().append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(str).toString();
        }
        return this._resourceLoader.getResourceAsStream(new StringBuffer().append("schema").append(METADATA_PACKAGE_GEN).append("/src").append(str).toString());
    }

    SchemaContainer[] containers() {
        SchemaContainer[] schemaContainerArr = new SchemaContainer[this._containers.size()];
        Iterator it = this._containers.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            schemaContainerArr[i] = (SchemaContainer) it.next();
            i++;
        }
        return schemaContainerArr;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaType[] documentTypes() {
        if (this._documentTypes.isEmpty()) {
            return EMPTY_ST_ARRAY;
        }
        SchemaType[] schemaTypeArr = new SchemaType[this._documentTypes.size()];
        int i = 0;
        Iterator it = this._documentTypes.values().iterator();
        while (it.hasNext()) {
            schemaTypeArr[i] = ((SchemaType.Ref) it.next()).get();
            i++;
        }
        return schemaTypeArr;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaType[] attributeTypes() {
        if (this._attributeTypes.isEmpty()) {
            return EMPTY_ST_ARRAY;
        }
        SchemaType[] schemaTypeArr = new SchemaType[this._attributeTypes.size()];
        int i = 0;
        Iterator it = this._attributeTypes.values().iterator();
        while (it.hasNext()) {
            schemaTypeArr[i] = ((SchemaType.Ref) it.next()).get();
            i++;
        }
        return schemaTypeArr;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaGlobalElement[] globalElements() {
        if (this._globalElements.isEmpty()) {
            return EMPTY_GE_ARRAY;
        }
        SchemaGlobalElement[] schemaGlobalElementArr = new SchemaGlobalElement[this._globalElements.size()];
        int i = 0;
        Iterator it = this._globalElements.values().iterator();
        while (it.hasNext()) {
            schemaGlobalElementArr[i] = ((SchemaGlobalElement.Ref) it.next()).get();
            i++;
        }
        return schemaGlobalElementArr;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaGlobalAttribute[] globalAttributes() {
        if (this._globalAttributes.isEmpty()) {
            return EMPTY_GA_ARRAY;
        }
        SchemaGlobalAttribute[] schemaGlobalAttributeArr = new SchemaGlobalAttribute[this._globalAttributes.size()];
        int i = 0;
        Iterator it = this._globalAttributes.values().iterator();
        while (it.hasNext()) {
            schemaGlobalAttributeArr[i] = ((SchemaGlobalAttribute.Ref) it.next()).get();
            i++;
        }
        return schemaGlobalAttributeArr;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaModelGroup[] modelGroups() {
        if (this._modelGroups.isEmpty()) {
            return EMPTY_MG_ARRAY;
        }
        SchemaModelGroup[] schemaModelGroupArr = new SchemaModelGroup[this._modelGroups.size()];
        int i = 0;
        Iterator it = this._modelGroups.values().iterator();
        while (it.hasNext()) {
            schemaModelGroupArr[i] = ((SchemaModelGroup.Ref) it.next()).get();
            i++;
        }
        return schemaModelGroupArr;
    }

    public SchemaModelGroup[] redefinedModelGroups() {
        List list = this._redefinedModelGroups;
        if (list == null || list.isEmpty()) {
            return EMPTY_MG_ARRAY;
        }
        SchemaModelGroup[] schemaModelGroupArr = new SchemaModelGroup[this._redefinedModelGroups.size()];
        int i = 0;
        Iterator it = this._redefinedModelGroups.iterator();
        while (it.hasNext()) {
            schemaModelGroupArr[i] = ((SchemaModelGroup.Ref) it.next()).get();
            i++;
        }
        return schemaModelGroupArr;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaAttributeGroup[] attributeGroups() {
        if (this._attributeGroups.isEmpty()) {
            return EMPTY_AG_ARRAY;
        }
        SchemaAttributeGroup[] schemaAttributeGroupArr = new SchemaAttributeGroup[this._attributeGroups.size()];
        int i = 0;
        Iterator it = this._attributeGroups.values().iterator();
        while (it.hasNext()) {
            schemaAttributeGroupArr[i] = ((SchemaAttributeGroup.Ref) it.next()).get();
            i++;
        }
        return schemaAttributeGroupArr;
    }

    public SchemaAttributeGroup[] redefinedAttributeGroups() {
        List list = this._redefinedAttributeGroups;
        if (list == null || list.isEmpty()) {
            return EMPTY_AG_ARRAY;
        }
        SchemaAttributeGroup[] schemaAttributeGroupArr = new SchemaAttributeGroup[this._redefinedAttributeGroups.size()];
        int i = 0;
        Iterator it = this._redefinedAttributeGroups.iterator();
        while (it.hasNext()) {
            schemaAttributeGroupArr[i] = ((SchemaAttributeGroup.Ref) it.next()).get();
            i++;
        }
        return schemaAttributeGroupArr;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaAnnotation[] annotations() {
        List list = this._annotations;
        if (list == null || list.isEmpty()) {
            return EMPTY_ANN_ARRAY;
        }
        return (SchemaAnnotation[]) this._annotations.toArray(new SchemaAnnotation[this._annotations.size()]);
    }

    public SchemaIdentityConstraint[] identityConstraints() {
        if (this._identityConstraints.isEmpty()) {
            return EMPTY_IC_ARRAY;
        }
        SchemaIdentityConstraint[] schemaIdentityConstraintArr = new SchemaIdentityConstraint[this._identityConstraints.size()];
        int i = 0;
        Iterator it = this._identityConstraints.values().iterator();
        while (it.hasNext()) {
            schemaIdentityConstraintArr[i] = ((SchemaIdentityConstraint.Ref) it.next()).get();
            i++;
        }
        return schemaIdentityConstraintArr;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public ClassLoader getClassLoader() {
        return this._classloader;
    }

    public String handleForType(SchemaType schemaType) {
        return this._localHandles.handleForType(schemaType);
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public String getName() {
        return this._name;
    }

    public SchemaTypeSystem typeSystemForName(String str) {
        String str2 = this._name;
        if (str2 == null || !str.equals(str2)) {
            return null;
        }
        return this;
    }
}
