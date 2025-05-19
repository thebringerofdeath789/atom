package org.apache.xmlbeans.impl.schema;

import aavax.xml.namespace.QName;
import com.opencsv.ICSVParser;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.text.lookup.StringLookupFactory;
import org.apache.xmlbeans.BindingConfig;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SystemProperties;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ResolverUtil;
import org.apache.xmlbeans.impl.util.HexBin;
import org.apache.xmlbeans.impl.values.XmlStringImpl;
import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;
import org.xml.sax.EntityResolver;

/* loaded from: classes5.dex */
public class StscState {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static final Object CHAMELEON_INCLUDE_URI;
    static final SchemaType.Ref[] EMPTY_STREF_ARRAY;
    static final SchemaType[] EMPTY_ST_ARRAY;
    static final XmlValueRef[] FACETS_LIST;
    private static final XmlValueRef[] FACETS_NONE;
    static final XmlValueRef[] FACETS_UNION;
    private static final XmlValueRef[] FACETS_WS_COLLAPSE;
    static final boolean[] FIXED_FACETS_LIST;
    private static final boolean[] FIXED_FACETS_NONE;
    static final boolean[] FIXED_FACETS_UNION;
    private static final boolean[] FIXED_FACETS_WS;
    private static final String PROJECT_URL_PREFIX = "project://local";
    private static final XmlValueRef XMLSTR_COLLAPSE;
    private static final XmlValueRef XMLSTR_PRESERVE;
    private static final XmlValueRef XMLSTR_REPLACE;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$schema$StscState;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$SchemaDocument;
    private static ThreadLocal tl_stscStack;
    private boolean _allowPartial;
    private List _annotations;
    private Map _attributeGroups;
    private Map _attributeTypes;
    URI _baseURI;
    private Map _compatMap;
    private BindingConfig _config;
    private Map _containers;
    private SchemaDependencies _dependencies;
    private byte[] _digest;
    private Map _documentTypes;
    private boolean _doingDownloads;
    private EntityResolver _entityResolver;
    private Collection _errorListener;
    private String _givenStsName;
    private Map _globalAttributes;
    private Map _globalElements;
    private Map _globalTypes;
    private Map _idConstraints;
    private SchemaTypeLoader _importingLoader;
    private boolean _mdefAll;
    private Set _mdefNamespaces;
    private Map _misspelledNames;
    private Map _modelGroups;
    private Set _namespaces;
    private boolean _noAnn;
    private boolean _noDigest;
    private boolean _noPvr;
    private boolean _noUpa;
    private Set _processingGroups;
    private int _recoveredErrors;
    private Map _redefinedAttributeGroups;
    private Map _redefinedGlobalTypes;
    private Map _redefinedModelGroups;
    SchemaTypeLoader _s4sloader;
    private File _schemasDir;
    Map _sourceForUri;
    private SchemaTypeSystemImpl _target;
    private Map _typesByClassname;

    static {
        if (class$org$apache$xmlbeans$impl$schema$StscState == null) {
            class$org$apache$xmlbeans$impl$schema$StscState = class$("org.apache.xmlbeans.impl.schema.StscState");
        }
        $assertionsDisabled = true;
        CHAMELEON_INCLUDE_URI = new Object();
        tl_stscStack = new ThreadLocal();
        XMLSTR_PRESERVE = buildString("preserve");
        XMLSTR_REPLACE = buildString("preserve");
        XMLSTR_COLLAPSE = buildString("preserve");
        EMPTY_ST_ARRAY = new SchemaType[0];
        EMPTY_STREF_ARRAY = new SchemaType.Ref[0];
        XmlValueRef[] xmlValueRefArr = {null, null, null, null, null, null, null, null, null, null, null, null};
        FACETS_NONE = xmlValueRefArr;
        boolean[] zArr = {false, false, false, false, false, false, false, false, false, false, false, false};
        FIXED_FACETS_NONE = zArr;
        XmlValueRef[] xmlValueRefArr2 = {null, null, null, null, null, null, null, null, null, build_wsstring(3), null, null};
        FACETS_WS_COLLAPSE = xmlValueRefArr2;
        boolean[] zArr2 = {false, false, false, false, false, false, false, false, false, true, false, false};
        FIXED_FACETS_WS = zArr2;
        FACETS_UNION = xmlValueRefArr;
        FIXED_FACETS_UNION = zArr;
        FACETS_LIST = xmlValueRefArr2;
        FIXED_FACETS_LIST = zArr2;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private static Set buildDefaultMdefNamespaces() {
        return new HashSet(Arrays.asList("http://www.openuri.org/2002/04/soap/conversation/"));
    }

    private StscState() {
        this._digest = null;
        this._noDigest = false;
        this._allowPartial = false;
        this._recoveredErrors = 0;
        this._containers = new LinkedHashMap();
        this._redefinedGlobalTypes = new LinkedHashMap();
        this._redefinedModelGroups = new LinkedHashMap();
        this._redefinedAttributeGroups = new LinkedHashMap();
        this._globalTypes = new LinkedHashMap();
        this._globalElements = new LinkedHashMap();
        this._globalAttributes = new LinkedHashMap();
        this._modelGroups = new LinkedHashMap();
        this._attributeGroups = new LinkedHashMap();
        this._documentTypes = new LinkedHashMap();
        this._attributeTypes = new LinkedHashMap();
        this._typesByClassname = new LinkedHashMap();
        this._misspelledNames = new HashMap();
        this._processingGroups = new LinkedHashSet();
        this._idConstraints = new LinkedHashMap();
        this._namespaces = new HashSet();
        this._annotations = new ArrayList();
        this._mdefNamespaces = buildDefaultMdefNamespaces();
        this._sourceForUri = new HashMap();
        this._baseURI = URI.create("project://local/");
        Class cls = class$org$apache$xmlbeans$impl$xb$xsdschema$SchemaDocument;
        if (cls == null) {
            cls = class$("org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument");
            class$org$apache$xmlbeans$impl$xb$xsdschema$SchemaDocument = cls;
        }
        this._s4sloader = XmlBeans.typeLoaderForClassLoader(cls.getClassLoader());
    }

    public void initFromTypeSystem(SchemaTypeSystemImpl schemaTypeSystemImpl, Set set) {
        SchemaContainer[] containers = schemaTypeSystemImpl.containers();
        for (int i = 0; i < containers.length; i++) {
            if (!set.contains(containers[i].getNamespace())) {
                addContainer(containers[i]);
            }
        }
    }

    void addNewContainer(String str) {
        if (this._containers.containsKey(str)) {
            return;
        }
        SchemaContainer schemaContainer = new SchemaContainer(str);
        schemaContainer.setTypeSystem(sts());
        addNamespace(str);
        this._containers.put(str, schemaContainer);
    }

    private void addContainer(SchemaContainer schemaContainer) {
        this._containers.put(schemaContainer.getNamespace(), schemaContainer);
        List redefinedModelGroups = schemaContainer.redefinedModelGroups();
        for (int i = 0; i < redefinedModelGroups.size(); i++) {
            this._redefinedModelGroups.put(((SchemaModelGroup) redefinedModelGroups.get(i)).getName(), redefinedModelGroups.get(i));
        }
        List redefinedAttributeGroups = schemaContainer.redefinedAttributeGroups();
        for (int i2 = 0; i2 < redefinedAttributeGroups.size(); i2++) {
            this._redefinedAttributeGroups.put(((SchemaAttributeGroup) redefinedAttributeGroups.get(i2)).getName(), redefinedAttributeGroups.get(i2));
        }
        List redefinedGlobalTypes = schemaContainer.redefinedGlobalTypes();
        for (int i3 = 0; i3 < redefinedGlobalTypes.size(); i3++) {
            this._redefinedGlobalTypes.put(((SchemaType) redefinedGlobalTypes.get(i3)).getName(), redefinedGlobalTypes.get(i3));
        }
        List globalElements = schemaContainer.globalElements();
        for (int i4 = 0; i4 < globalElements.size(); i4++) {
            this._globalElements.put(((SchemaGlobalElement) globalElements.get(i4)).getName(), globalElements.get(i4));
        }
        List globalAttributes = schemaContainer.globalAttributes();
        for (int i5 = 0; i5 < globalAttributes.size(); i5++) {
            this._globalAttributes.put(((SchemaGlobalAttribute) globalAttributes.get(i5)).getName(), globalAttributes.get(i5));
        }
        List modelGroups = schemaContainer.modelGroups();
        for (int i6 = 0; i6 < modelGroups.size(); i6++) {
            this._modelGroups.put(((SchemaModelGroup) modelGroups.get(i6)).getName(), modelGroups.get(i6));
        }
        List attributeGroups = schemaContainer.attributeGroups();
        for (int i7 = 0; i7 < attributeGroups.size(); i7++) {
            this._attributeGroups.put(((SchemaAttributeGroup) attributeGroups.get(i7)).getName(), attributeGroups.get(i7));
        }
        List globalTypes = schemaContainer.globalTypes();
        for (int i8 = 0; i8 < globalTypes.size(); i8++) {
            SchemaType schemaType = (SchemaType) globalTypes.get(i8);
            this._globalTypes.put(schemaType.getName(), schemaType);
            if (schemaType.getFullJavaName() != null) {
                addClassname(schemaType.getFullJavaName(), schemaType);
            }
        }
        List documentTypes = schemaContainer.documentTypes();
        for (int i9 = 0; i9 < documentTypes.size(); i9++) {
            SchemaType schemaType2 = (SchemaType) documentTypes.get(i9);
            this._documentTypes.put(schemaType2.getProperties()[0].getName(), schemaType2);
            if (schemaType2.getFullJavaName() != null) {
                addClassname(schemaType2.getFullJavaName(), schemaType2);
            }
        }
        List attributeTypes = schemaContainer.attributeTypes();
        for (int i10 = 0; i10 < attributeTypes.size(); i10++) {
            SchemaType schemaType3 = (SchemaType) attributeTypes.get(i10);
            this._attributeTypes.put(schemaType3.getProperties()[0].getName(), schemaType3);
            if (schemaType3.getFullJavaName() != null) {
                addClassname(schemaType3.getFullJavaName(), schemaType3);
            }
        }
        List identityConstraints = schemaContainer.identityConstraints();
        for (int i11 = 0; i11 < identityConstraints.size(); i11++) {
            this._idConstraints.put(((SchemaIdentityConstraint) identityConstraints.get(i11)).getName(), identityConstraints.get(i11));
        }
        this._annotations.addAll(schemaContainer.annotations());
        this._namespaces.add(schemaContainer.getNamespace());
        schemaContainer.unsetImmutable();
    }

    SchemaContainer getContainer(String str) {
        return (SchemaContainer) this._containers.get(str);
    }

    Map getContainerMap() {
        return Collections.unmodifiableMap(this._containers);
    }

    void registerDependency(String str, String str2) {
        this._dependencies.registerDependency(str, str2);
    }

    void registerContribution(String str, String str2) {
        this._dependencies.registerContribution(str, str2);
    }

    SchemaDependencies getDependencies() {
        return this._dependencies;
    }

    void setDependencies(SchemaDependencies schemaDependencies) {
        this._dependencies = schemaDependencies;
    }

    boolean isFileProcessed(String str) {
        return this._dependencies.isFileRepresented(str);
    }

    public void setImportingTypeLoader(SchemaTypeLoader schemaTypeLoader) {
        this._importingLoader = schemaTypeLoader;
    }

    public void setErrorListener(Collection collection) {
        this._errorListener = collection;
    }

    public void error(String str, int i, XmlObject xmlObject) {
        addError(this._errorListener, str, i, xmlObject);
    }

    public void error(String str, Object[] objArr, XmlObject xmlObject) {
        addError(this._errorListener, str, objArr, xmlObject);
    }

    public void recover(String str, Object[] objArr, XmlObject xmlObject) {
        addError(this._errorListener, str, objArr, xmlObject);
        this._recoveredErrors++;
    }

    public void warning(String str, int i, XmlObject xmlObject) {
        addWarning(this._errorListener, str, i, xmlObject);
    }

    public void warning(String str, Object[] objArr, XmlObject xmlObject) {
        if (str != XmlErrorCodes.RESERVED_TYPE_NAME || xmlObject.documentProperties().getSourceName() == null || xmlObject.documentProperties().getSourceName().indexOf("XMLSchema.xsd") <= 0) {
            addWarning(this._errorListener, str, objArr, xmlObject);
        }
    }

    public void info(String str) {
        addInfo(this._errorListener, str);
    }

    public void info(String str, Object[] objArr) {
        addInfo(this._errorListener, str, objArr);
    }

    public static void addError(Collection collection, String str, int i, XmlObject xmlObject) {
        collection.add(XmlError.forObject(str, 0, xmlObject));
    }

    public static void addError(Collection collection, String str, Object[] objArr, XmlObject xmlObject) {
        collection.add(XmlError.forObject(str, objArr, 0, xmlObject));
    }

    public static void addError(Collection collection, String str, Object[] objArr, File file) {
        collection.add(XmlError.forLocation(str, objArr, 0, file.toURI().toString(), 0, 0, 0));
    }

    public static void addError(Collection collection, String str, Object[] objArr, URL url) {
        collection.add(XmlError.forLocation(str, objArr, 0, url.toString(), 0, 0, 0));
    }

    public static void addWarning(Collection collection, String str, int i, XmlObject xmlObject) {
        collection.add(XmlError.forObject(str, 1, xmlObject));
    }

    public static void addWarning(Collection collection, String str, Object[] objArr, XmlObject xmlObject) {
        collection.add(XmlError.forObject(str, objArr, 1, xmlObject));
    }

    public static void addInfo(Collection collection, String str) {
        collection.add(XmlError.forMessage(str, 2));
    }

    public static void addInfo(Collection collection, String str, Object[] objArr) {
        collection.add(XmlError.forMessage(str, objArr, 2));
    }

    public void setGivenTypeSystemName(String str) {
        this._givenStsName = str;
    }

    public void setTargetSchemaTypeSystem(SchemaTypeSystemImpl schemaTypeSystemImpl) {
        this._target = schemaTypeSystemImpl;
    }

    public void addSchemaDigest(byte[] bArr) {
        if (this._noDigest) {
            return;
        }
        if (bArr == null) {
            this._noDigest = true;
            this._digest = null;
            return;
        }
        if (this._digest == null) {
            this._digest = new byte[16];
        }
        int length = this._digest.length;
        if (bArr.length < length) {
            length = bArr.length;
        }
        for (int i = 0; i < length; i++) {
            byte[] bArr2 = this._digest;
            bArr2[i] = (byte) (bArr2[i] ^ bArr[i]);
        }
    }

    public SchemaTypeSystemImpl sts() {
        SchemaTypeSystemImpl schemaTypeSystemImpl = this._target;
        if (schemaTypeSystemImpl != null) {
            return schemaTypeSystemImpl;
        }
        String str = this._givenStsName;
        if (str == null && this._digest != null) {
            str = new StringBuffer().append("s").append(new String(HexBin.encode(this._digest))).toString();
        }
        SchemaTypeSystemImpl schemaTypeSystemImpl2 = new SchemaTypeSystemImpl(str);
        this._target = schemaTypeSystemImpl2;
        return schemaTypeSystemImpl2;
    }

    public boolean shouldDownloadURI(String str) {
        if (this._doingDownloads) {
            return true;
        }
        if (str == null) {
            return false;
        }
        try {
            URI uri = new URI(str);
            if (!uri.getScheme().equalsIgnoreCase("jar") && !uri.getScheme().equalsIgnoreCase("zip")) {
                return uri.getScheme().equalsIgnoreCase(StringLookupFactory.KEY_FILE);
            }
            String schemeSpecificPart = uri.getSchemeSpecificPart();
            int lastIndexOf = schemeSpecificPart.lastIndexOf(33);
            if (lastIndexOf > 0) {
                schemeSpecificPart = schemeSpecificPart.substring(0, lastIndexOf);
            }
            return shouldDownloadURI(schemeSpecificPart);
        } catch (Exception unused) {
            return false;
        }
    }

    public void setOptions(XmlOptions xmlOptions) {
        if (xmlOptions == null) {
            return;
        }
        this._allowPartial = xmlOptions.hasOption("COMPILE_PARTIAL_TYPESYSTEM");
        this._compatMap = (Map) xmlOptions.get(XmlOptions.COMPILE_SUBSTITUTE_NAMES);
        this._noUpa = xmlOptions.hasOption(XmlOptions.COMPILE_NO_UPA_RULE) || !BooleanUtils.TRUE.equals(SystemProperties.getProperty("xmlbean.uniqueparticleattribution", BooleanUtils.TRUE));
        this._noPvr = xmlOptions.hasOption(XmlOptions.COMPILE_NO_PVR_RULE) || !BooleanUtils.TRUE.equals(SystemProperties.getProperty("xmlbean.particlerestriction", BooleanUtils.TRUE));
        this._noAnn = xmlOptions.hasOption(XmlOptions.COMPILE_NO_ANNOTATIONS) || !BooleanUtils.TRUE.equals(SystemProperties.getProperty("xmlbean.schemaannotations", BooleanUtils.TRUE));
        this._doingDownloads = xmlOptions.hasOption(XmlOptions.COMPILE_DOWNLOAD_URLS) ? true : BooleanUtils.TRUE.equals(SystemProperties.getProperty("xmlbean.downloadurls", "false"));
        EntityResolver entityResolver = (EntityResolver) xmlOptions.get(XmlOptions.ENTITY_RESOLVER);
        this._entityResolver = entityResolver;
        if (entityResolver == null) {
            this._entityResolver = ResolverUtil.getGlobalEntityResolver();
        }
        if (this._entityResolver != null) {
            this._doingDownloads = true;
        }
        if (xmlOptions.hasOption(XmlOptions.COMPILE_MDEF_NAMESPACES)) {
            this._mdefNamespaces.addAll((Collection) xmlOptions.get(XmlOptions.COMPILE_MDEF_NAMESPACES));
            if (this._mdefNamespaces.contains("##local")) {
                this._mdefNamespaces.remove("##local");
                this._mdefNamespaces.add("");
            }
            if (this._mdefNamespaces.contains("##any")) {
                this._mdefNamespaces.remove("##any");
                this._mdefAll = true;
            }
        }
    }

    public EntityResolver getEntityResolver() {
        return this._entityResolver;
    }

    public boolean noUpa() {
        return this._noUpa;
    }

    public boolean noPvr() {
        return this._noPvr;
    }

    public boolean noAnn() {
        return this._noAnn;
    }

    public boolean allowPartial() {
        return this._allowPartial;
    }

    public int getRecovered() {
        return this._recoveredErrors;
    }

    private QName compatName(QName qName, String str) {
        QName qName2;
        if (qName.getNamespaceURI().length() == 0 && str != null && str.length() > 0) {
            qName = new QName(str, qName.getLocalPart());
        }
        Map map = this._compatMap;
        return (map == null || (qName2 = (QName) map.get(qName)) == null) ? qName : qName2;
    }

    public void setBindingConfig(BindingConfig bindingConfig) throws IllegalArgumentException {
        this._config = bindingConfig;
    }

    public BindingConfig getBindingConfig() throws IllegalArgumentException {
        return this._config;
    }

    public String getPackageOverride(String str) {
        BindingConfig bindingConfig = this._config;
        if (bindingConfig == null) {
            return null;
        }
        return bindingConfig.lookupPackageForNamespace(str);
    }

    public String getJavaPrefix(String str) {
        BindingConfig bindingConfig = this._config;
        if (bindingConfig == null) {
            return null;
        }
        return bindingConfig.lookupPrefixForNamespace(str);
    }

    public String getJavaSuffix(String str) {
        BindingConfig bindingConfig = this._config;
        if (bindingConfig == null) {
            return null;
        }
        return bindingConfig.lookupSuffixForNamespace(str);
    }

    public String getJavaname(QName qName, int i) {
        BindingConfig bindingConfig = this._config;
        if (bindingConfig == null) {
            return null;
        }
        return bindingConfig.lookupJavanameForQName(qName, i);
    }

    private static String crunchName(QName qName) {
        return qName.getLocalPart().toLowerCase();
    }

    void addSpelling(QName qName, SchemaComponent schemaComponent) {
        this._misspelledNames.put(crunchName(qName), schemaComponent);
    }

    SchemaComponent findSpelling(QName qName) {
        return (SchemaComponent) this._misspelledNames.get(crunchName(qName));
    }

    void addNamespace(String str) {
        this._namespaces.add(str);
    }

    String[] getNamespaces() {
        Set set = this._namespaces;
        return (String[]) set.toArray(new String[set.size()]);
    }

    boolean linkerDefinesNamespace(String str) {
        return this._importingLoader.isNamespaceDefined(str);
    }

    SchemaTypeImpl findGlobalType(QName qName, String str, String str2) {
        QName compatName = compatName(qName, str);
        SchemaTypeImpl schemaTypeImpl = (SchemaTypeImpl) this._globalTypes.get(compatName);
        boolean z = false;
        if (schemaTypeImpl == null && (schemaTypeImpl = (SchemaTypeImpl) this._importingLoader.findType(compatName)) != null) {
            z = true;
        }
        if (!z && str2 != null) {
            registerDependency(str2, compatName.getNamespaceURI());
        }
        return schemaTypeImpl;
    }

    SchemaTypeImpl findRedefinedGlobalType(QName qName, String str, SchemaTypeImpl schemaTypeImpl) {
        QName name = schemaTypeImpl.getName();
        QName compatName = compatName(qName, str);
        if (compatName.equals(name)) {
            return (SchemaTypeImpl) this._redefinedGlobalTypes.get(schemaTypeImpl);
        }
        SchemaTypeImpl schemaTypeImpl2 = (SchemaTypeImpl) this._globalTypes.get(compatName);
        return schemaTypeImpl2 == null ? (SchemaTypeImpl) this._importingLoader.findType(compatName) : schemaTypeImpl2;
    }

    void addGlobalType(SchemaTypeImpl schemaTypeImpl, SchemaTypeImpl schemaTypeImpl2) {
        if (schemaTypeImpl != null) {
            QName name = schemaTypeImpl.getName();
            SchemaContainer container = getContainer(name.getNamespaceURI());
            if (!$assertionsDisabled && (container == null || container != schemaTypeImpl.getContainer())) {
                throw new AssertionError();
            }
            if (schemaTypeImpl2 != null) {
                if (this._redefinedGlobalTypes.containsKey(schemaTypeImpl2)) {
                    if (ignoreMdef(name)) {
                        return;
                    }
                    if (this._mdefAll) {
                        warning(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"global type", QNameHelper.pretty(name), ((SchemaType) this._redefinedGlobalTypes.get(schemaTypeImpl2)).getSourceName()}, schemaTypeImpl.getParseObject());
                        return;
                    } else {
                        error(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"global type", QNameHelper.pretty(name), ((SchemaType) this._redefinedGlobalTypes.get(schemaTypeImpl2)).getSourceName()}, schemaTypeImpl.getParseObject());
                        return;
                    }
                }
                this._redefinedGlobalTypes.put(schemaTypeImpl2, schemaTypeImpl);
                container.addRedefinedType(schemaTypeImpl.getRef());
                return;
            }
            if (this._globalTypes.containsKey(name)) {
                if (ignoreMdef(name)) {
                    return;
                }
                if (this._mdefAll) {
                    warning(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"global type", QNameHelper.pretty(name), ((SchemaType) this._globalTypes.get(name)).getSourceName()}, schemaTypeImpl.getParseObject());
                    return;
                } else {
                    error(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"global type", QNameHelper.pretty(name), ((SchemaType) this._globalTypes.get(name)).getSourceName()}, schemaTypeImpl.getParseObject());
                    return;
                }
            }
            this._globalTypes.put(name, schemaTypeImpl);
            container.addGlobalType(schemaTypeImpl.getRef());
            addSpelling(name, schemaTypeImpl);
        }
    }

    private boolean ignoreMdef(QName qName) {
        return this._mdefNamespaces.contains(qName.getNamespaceURI());
    }

    SchemaType[] globalTypes() {
        return (SchemaType[]) this._globalTypes.values().toArray(new SchemaType[this._globalTypes.size()]);
    }

    SchemaType[] redefinedGlobalTypes() {
        return (SchemaType[]) this._redefinedGlobalTypes.values().toArray(new SchemaType[this._redefinedGlobalTypes.size()]);
    }

    SchemaTypeImpl findDocumentType(QName qName, String str, String str2) {
        QName compatName = compatName(qName, str);
        SchemaTypeImpl schemaTypeImpl = (SchemaTypeImpl) this._documentTypes.get(compatName);
        boolean z = false;
        if (schemaTypeImpl == null && (schemaTypeImpl = (SchemaTypeImpl) this._importingLoader.findDocumentType(compatName)) != null) {
            z = true;
        }
        if (!z && str2 != null) {
            registerDependency(str2, compatName.getNamespaceURI());
        }
        return schemaTypeImpl;
    }

    void addDocumentType(SchemaTypeImpl schemaTypeImpl, QName qName) {
        if (this._documentTypes.containsKey(qName)) {
            if (ignoreMdef(qName)) {
                return;
            }
            if (this._mdefAll) {
                warning(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"global element", QNameHelper.pretty(qName), ((SchemaComponent) this._documentTypes.get(qName)).getSourceName()}, schemaTypeImpl.getParseObject());
                return;
            } else {
                error(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"global element", QNameHelper.pretty(qName), ((SchemaComponent) this._documentTypes.get(qName)).getSourceName()}, schemaTypeImpl.getParseObject());
                return;
            }
        }
        this._documentTypes.put(qName, schemaTypeImpl);
        SchemaContainer container = getContainer(qName.getNamespaceURI());
        if (!$assertionsDisabled && (container == null || container != schemaTypeImpl.getContainer())) {
            throw new AssertionError();
        }
        container.addDocumentType(schemaTypeImpl.getRef());
    }

    SchemaType[] documentTypes() {
        return (SchemaType[]) this._documentTypes.values().toArray(new SchemaType[this._documentTypes.size()]);
    }

    SchemaTypeImpl findAttributeType(QName qName, String str, String str2) {
        QName compatName = compatName(qName, str);
        SchemaTypeImpl schemaTypeImpl = (SchemaTypeImpl) this._attributeTypes.get(compatName);
        boolean z = false;
        if (schemaTypeImpl == null && (schemaTypeImpl = (SchemaTypeImpl) this._importingLoader.findAttributeType(compatName)) != null) {
            z = true;
        }
        if (!z && str2 != null) {
            registerDependency(str2, compatName.getNamespaceURI());
        }
        return schemaTypeImpl;
    }

    void addAttributeType(SchemaTypeImpl schemaTypeImpl, QName qName) {
        if (this._attributeTypes.containsKey(qName)) {
            if (ignoreMdef(qName)) {
                return;
            }
            if (this._mdefAll) {
                warning(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"global attribute", QNameHelper.pretty(qName), ((SchemaComponent) this._attributeTypes.get(qName)).getSourceName()}, schemaTypeImpl.getParseObject());
                return;
            } else {
                error(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"global attribute", QNameHelper.pretty(qName), ((SchemaComponent) this._attributeTypes.get(qName)).getSourceName()}, schemaTypeImpl.getParseObject());
                return;
            }
        }
        this._attributeTypes.put(qName, schemaTypeImpl);
        SchemaContainer container = getContainer(qName.getNamespaceURI());
        if (!$assertionsDisabled && (container == null || container != schemaTypeImpl.getContainer())) {
            throw new AssertionError();
        }
        container.addAttributeType(schemaTypeImpl.getRef());
    }

    SchemaType[] attributeTypes() {
        return (SchemaType[]) this._attributeTypes.values().toArray(new SchemaType[this._attributeTypes.size()]);
    }

    SchemaGlobalAttributeImpl findGlobalAttribute(QName qName, String str, String str2) {
        QName compatName = compatName(qName, str);
        SchemaGlobalAttributeImpl schemaGlobalAttributeImpl = (SchemaGlobalAttributeImpl) this._globalAttributes.get(compatName);
        boolean z = false;
        if (schemaGlobalAttributeImpl == null && (schemaGlobalAttributeImpl = (SchemaGlobalAttributeImpl) this._importingLoader.findAttribute(compatName)) != null) {
            z = true;
        }
        if (!z && str2 != null) {
            registerDependency(str2, compatName.getNamespaceURI());
        }
        return schemaGlobalAttributeImpl;
    }

    void addGlobalAttribute(SchemaGlobalAttributeImpl schemaGlobalAttributeImpl) {
        if (schemaGlobalAttributeImpl != null) {
            QName name = schemaGlobalAttributeImpl.getName();
            this._globalAttributes.put(name, schemaGlobalAttributeImpl);
            addSpelling(name, schemaGlobalAttributeImpl);
            SchemaContainer container = getContainer(name.getNamespaceURI());
            if (!$assertionsDisabled && (container == null || container != schemaGlobalAttributeImpl.getContainer())) {
                throw new AssertionError();
            }
            container.addGlobalAttribute(schemaGlobalAttributeImpl.getRef());
        }
    }

    SchemaGlobalAttribute[] globalAttributes() {
        return (SchemaGlobalAttribute[]) this._globalAttributes.values().toArray(new SchemaGlobalAttribute[this._globalAttributes.size()]);
    }

    SchemaGlobalElementImpl findGlobalElement(QName qName, String str, String str2) {
        QName compatName = compatName(qName, str);
        SchemaGlobalElementImpl schemaGlobalElementImpl = (SchemaGlobalElementImpl) this._globalElements.get(compatName);
        boolean z = false;
        if (schemaGlobalElementImpl == null && (schemaGlobalElementImpl = (SchemaGlobalElementImpl) this._importingLoader.findElement(compatName)) != null) {
            z = true;
        }
        if (!z && str2 != null) {
            registerDependency(str2, compatName.getNamespaceURI());
        }
        return schemaGlobalElementImpl;
    }

    void addGlobalElement(SchemaGlobalElementImpl schemaGlobalElementImpl) {
        if (schemaGlobalElementImpl != null) {
            QName name = schemaGlobalElementImpl.getName();
            this._globalElements.put(name, schemaGlobalElementImpl);
            SchemaContainer container = getContainer(name.getNamespaceURI());
            if (!$assertionsDisabled && (container == null || container != schemaGlobalElementImpl.getContainer())) {
                throw new AssertionError();
            }
            container.addGlobalElement(schemaGlobalElementImpl.getRef());
            addSpelling(name, schemaGlobalElementImpl);
        }
    }

    SchemaGlobalElement[] globalElements() {
        return (SchemaGlobalElement[]) this._globalElements.values().toArray(new SchemaGlobalElement[this._globalElements.size()]);
    }

    SchemaAttributeGroupImpl findAttributeGroup(QName qName, String str, String str2) {
        QName compatName = compatName(qName, str);
        SchemaAttributeGroupImpl schemaAttributeGroupImpl = (SchemaAttributeGroupImpl) this._attributeGroups.get(compatName);
        boolean z = false;
        if (schemaAttributeGroupImpl == null && (schemaAttributeGroupImpl = (SchemaAttributeGroupImpl) this._importingLoader.findAttributeGroup(compatName)) != null) {
            z = true;
        }
        if (!z && str2 != null) {
            registerDependency(str2, compatName.getNamespaceURI());
        }
        return schemaAttributeGroupImpl;
    }

    SchemaAttributeGroupImpl findRedefinedAttributeGroup(QName qName, String str, SchemaAttributeGroupImpl schemaAttributeGroupImpl) {
        QName name = schemaAttributeGroupImpl.getName();
        QName compatName = compatName(qName, str);
        if (compatName.equals(name)) {
            return (SchemaAttributeGroupImpl) this._redefinedAttributeGroups.get(schemaAttributeGroupImpl);
        }
        SchemaAttributeGroupImpl schemaAttributeGroupImpl2 = (SchemaAttributeGroupImpl) this._attributeGroups.get(compatName);
        return schemaAttributeGroupImpl2 == null ? (SchemaAttributeGroupImpl) this._importingLoader.findAttributeGroup(compatName) : schemaAttributeGroupImpl2;
    }

    void addAttributeGroup(SchemaAttributeGroupImpl schemaAttributeGroupImpl, SchemaAttributeGroupImpl schemaAttributeGroupImpl2) {
        if (schemaAttributeGroupImpl != null) {
            QName name = schemaAttributeGroupImpl.getName();
            SchemaContainer container = getContainer(name.getNamespaceURI());
            if (!$assertionsDisabled && (container == null || container != schemaAttributeGroupImpl.getContainer())) {
                throw new AssertionError();
            }
            if (schemaAttributeGroupImpl2 != null) {
                if (this._redefinedAttributeGroups.containsKey(schemaAttributeGroupImpl2)) {
                    if (ignoreMdef(name)) {
                        return;
                    }
                    if (this._mdefAll) {
                        warning(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"attribute group", QNameHelper.pretty(name), ((SchemaComponent) this._redefinedAttributeGroups.get(schemaAttributeGroupImpl2)).getSourceName()}, schemaAttributeGroupImpl.getParseObject());
                        return;
                    } else {
                        error(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"attribute group", QNameHelper.pretty(name), ((SchemaComponent) this._redefinedAttributeGroups.get(schemaAttributeGroupImpl2)).getSourceName()}, schemaAttributeGroupImpl.getParseObject());
                        return;
                    }
                }
                this._redefinedAttributeGroups.put(schemaAttributeGroupImpl2, schemaAttributeGroupImpl);
                container.addRedefinedAttributeGroup(schemaAttributeGroupImpl.getRef());
                return;
            }
            if (this._attributeGroups.containsKey(name)) {
                if (ignoreMdef(name)) {
                    return;
                }
                if (this._mdefAll) {
                    warning(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"attribute group", QNameHelper.pretty(name), ((SchemaComponent) this._attributeGroups.get(name)).getSourceName()}, schemaAttributeGroupImpl.getParseObject());
                    return;
                } else {
                    error(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"attribute group", QNameHelper.pretty(name), ((SchemaComponent) this._attributeGroups.get(name)).getSourceName()}, schemaAttributeGroupImpl.getParseObject());
                    return;
                }
            }
            this._attributeGroups.put(schemaAttributeGroupImpl.getName(), schemaAttributeGroupImpl);
            addSpelling(schemaAttributeGroupImpl.getName(), schemaAttributeGroupImpl);
            container.addAttributeGroup(schemaAttributeGroupImpl.getRef());
        }
    }

    SchemaAttributeGroup[] attributeGroups() {
        return (SchemaAttributeGroup[]) this._attributeGroups.values().toArray(new SchemaAttributeGroup[this._attributeGroups.size()]);
    }

    SchemaAttributeGroup[] redefinedAttributeGroups() {
        return (SchemaAttributeGroup[]) this._redefinedAttributeGroups.values().toArray(new SchemaAttributeGroup[this._redefinedAttributeGroups.size()]);
    }

    SchemaModelGroupImpl findModelGroup(QName qName, String str, String str2) {
        QName compatName = compatName(qName, str);
        SchemaModelGroupImpl schemaModelGroupImpl = (SchemaModelGroupImpl) this._modelGroups.get(compatName);
        boolean z = false;
        if (schemaModelGroupImpl == null && (schemaModelGroupImpl = (SchemaModelGroupImpl) this._importingLoader.findModelGroup(compatName)) != null) {
            z = true;
        }
        if (!z && str2 != null) {
            registerDependency(str2, compatName.getNamespaceURI());
        }
        return schemaModelGroupImpl;
    }

    SchemaModelGroupImpl findRedefinedModelGroup(QName qName, String str, SchemaModelGroupImpl schemaModelGroupImpl) {
        QName name = schemaModelGroupImpl.getName();
        QName compatName = compatName(qName, str);
        if (compatName.equals(name)) {
            return (SchemaModelGroupImpl) this._redefinedModelGroups.get(schemaModelGroupImpl);
        }
        SchemaModelGroupImpl schemaModelGroupImpl2 = (SchemaModelGroupImpl) this._modelGroups.get(compatName);
        return schemaModelGroupImpl2 == null ? (SchemaModelGroupImpl) this._importingLoader.findModelGroup(compatName) : schemaModelGroupImpl2;
    }

    void addModelGroup(SchemaModelGroupImpl schemaModelGroupImpl, SchemaModelGroupImpl schemaModelGroupImpl2) {
        if (schemaModelGroupImpl != null) {
            QName name = schemaModelGroupImpl.getName();
            SchemaContainer container = getContainer(name.getNamespaceURI());
            if (!$assertionsDisabled && (container == null || container != schemaModelGroupImpl.getContainer())) {
                throw new AssertionError();
            }
            if (schemaModelGroupImpl2 != null) {
                if (this._redefinedModelGroups.containsKey(schemaModelGroupImpl2)) {
                    if (ignoreMdef(name)) {
                        return;
                    }
                    if (this._mdefAll) {
                        warning(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"model group", QNameHelper.pretty(name), ((SchemaComponent) this._redefinedModelGroups.get(schemaModelGroupImpl2)).getSourceName()}, schemaModelGroupImpl.getParseObject());
                        return;
                    } else {
                        error(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"model group", QNameHelper.pretty(name), ((SchemaComponent) this._redefinedModelGroups.get(schemaModelGroupImpl2)).getSourceName()}, schemaModelGroupImpl.getParseObject());
                        return;
                    }
                }
                this._redefinedModelGroups.put(schemaModelGroupImpl2, schemaModelGroupImpl);
                container.addRedefinedModelGroup(schemaModelGroupImpl.getRef());
                return;
            }
            if (this._modelGroups.containsKey(name)) {
                if (ignoreMdef(name)) {
                    return;
                }
                if (this._mdefAll) {
                    warning(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"model group", QNameHelper.pretty(name), ((SchemaComponent) this._modelGroups.get(name)).getSourceName()}, schemaModelGroupImpl.getParseObject());
                    return;
                } else {
                    error(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"model group", QNameHelper.pretty(name), ((SchemaComponent) this._modelGroups.get(name)).getSourceName()}, schemaModelGroupImpl.getParseObject());
                    return;
                }
            }
            this._modelGroups.put(schemaModelGroupImpl.getName(), schemaModelGroupImpl);
            addSpelling(schemaModelGroupImpl.getName(), schemaModelGroupImpl);
            container.addModelGroup(schemaModelGroupImpl.getRef());
        }
    }

    SchemaModelGroup[] modelGroups() {
        return (SchemaModelGroup[]) this._modelGroups.values().toArray(new SchemaModelGroup[this._modelGroups.size()]);
    }

    SchemaModelGroup[] redefinedModelGroups() {
        return (SchemaModelGroup[]) this._redefinedModelGroups.values().toArray(new SchemaModelGroup[this._redefinedModelGroups.size()]);
    }

    SchemaIdentityConstraintImpl findIdConstraint(QName qName, String str, String str2) {
        QName compatName = compatName(qName, str);
        if (str2 != null) {
            registerDependency(str2, compatName.getNamespaceURI());
        }
        return (SchemaIdentityConstraintImpl) this._idConstraints.get(compatName);
    }

    void addIdConstraint(SchemaIdentityConstraintImpl schemaIdentityConstraintImpl) {
        if (schemaIdentityConstraintImpl != null) {
            QName name = schemaIdentityConstraintImpl.getName();
            SchemaContainer container = getContainer(name.getNamespaceURI());
            if (!$assertionsDisabled && (container == null || container != schemaIdentityConstraintImpl.getContainer())) {
                throw new AssertionError();
            }
            if (this._idConstraints.containsKey(name)) {
                if (ignoreMdef(name)) {
                    return;
                }
                warning(XmlErrorCodes.SCHEMA_PROPERTIES$DUPLICATE, new Object[]{"identity constraint", QNameHelper.pretty(name), ((SchemaComponent) this._idConstraints.get(name)).getSourceName()}, schemaIdentityConstraintImpl.getParseObject());
            } else {
                this._idConstraints.put(name, schemaIdentityConstraintImpl);
                addSpelling(schemaIdentityConstraintImpl.getName(), schemaIdentityConstraintImpl);
                container.addIdentityConstraint(schemaIdentityConstraintImpl.getRef());
            }
        }
    }

    SchemaIdentityConstraintImpl[] idConstraints() {
        return (SchemaIdentityConstraintImpl[]) this._idConstraints.values().toArray(new SchemaIdentityConstraintImpl[this._idConstraints.size()]);
    }

    void addAnnotation(SchemaAnnotationImpl schemaAnnotationImpl, String str) {
        if (schemaAnnotationImpl != null) {
            SchemaContainer container = getContainer(str);
            if (!$assertionsDisabled && (container == null || container != schemaAnnotationImpl.getContainer())) {
                throw new AssertionError();
            }
            this._annotations.add(schemaAnnotationImpl);
            container.addAnnotation(schemaAnnotationImpl);
        }
    }

    List annotations() {
        return this._annotations;
    }

    boolean isProcessing(Object obj) {
        return this._processingGroups.contains(obj);
    }

    void startProcessing(Object obj) {
        if (!$assertionsDisabled && this._processingGroups.contains(obj)) {
            throw new AssertionError();
        }
        this._processingGroups.add(obj);
    }

    void finishProcessing(Object obj) {
        if (!$assertionsDisabled && !this._processingGroups.contains(obj)) {
            throw new AssertionError();
        }
        this._processingGroups.remove(obj);
    }

    Object[] getCurrentProcessing() {
        return this._processingGroups.toArray();
    }

    Map typesByClassname() {
        return Collections.unmodifiableMap(this._typesByClassname);
    }

    void addClassname(String str, SchemaType schemaType) {
        this._typesByClassname.put(str, schemaType);
    }

    private static final class StscStack {
        StscState current;
        ArrayList stack;

        private StscStack() {
            this.stack = new ArrayList();
        }

        final StscState push() {
            this.stack.add(this.current);
            StscState stscState = new StscState();
            this.current = stscState;
            return stscState;
        }

        final void pop() {
            this.current = (StscState) this.stack.get(r0.size() - 1);
            this.stack.remove(r0.size() - 1);
        }
    }

    public static StscState start() {
        StscStack stscStack = (StscStack) tl_stscStack.get();
        if (stscStack == null) {
            stscStack = new StscStack();
            tl_stscStack.set(stscStack);
        }
        return stscStack.push();
    }

    public static StscState get() {
        return ((StscStack) tl_stscStack.get()).current;
    }

    public static void end() {
        StscStack stscStack = (StscStack) tl_stscStack.get();
        stscStack.pop();
        if (stscStack.stack.size() == 0) {
            tl_stscStack.set(null);
        }
    }

    static XmlValueRef build_wsstring(int i) {
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

    static XmlValueRef buildString(String str) {
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

    public void notFoundError(QName qName, int i, XmlObject xmlObject, boolean z) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        QName name;
        String sourceName;
        Object pretty = QNameHelper.pretty(qName);
        if (z) {
            this._recoveredErrors++;
        }
        Object obj5 = "attribute group";
        if (i == 0) {
            obj = "type";
        } else if (i == 1) {
            obj = "element";
        } else if (i == 3) {
            obj = "attribute";
        } else if (i == 4) {
            obj = "attribute group";
        } else if (i == 5) {
            obj = "identity constraint";
        } else if (i == 6) {
            obj = "model group";
        } else {
            if (!$assertionsDisabled) {
                throw new AssertionError();
            }
            obj = "definition";
        }
        SchemaComponent findSpelling = findSpelling(qName);
        if (findSpelling == null || (name = findSpelling.getName()) == null) {
            obj2 = null;
            obj3 = null;
            obj4 = null;
        } else {
            int componentType = findSpelling.getComponentType();
            if (componentType == 0) {
                sourceName = ((SchemaType) findSpelling).getSourceName();
                obj5 = "type";
            } else if (componentType == 1) {
                sourceName = ((SchemaGlobalElement) findSpelling).getSourceName();
                obj5 = "element";
            } else if (componentType != 3) {
                if (componentType != 4) {
                    if (componentType != 6) {
                        sourceName = null;
                        obj5 = null;
                    } else {
                        obj5 = "model group";
                    }
                }
                sourceName = null;
            } else {
                sourceName = ((SchemaGlobalAttribute) findSpelling).getSourceName();
                obj5 = "attribute";
            }
            if (sourceName != null) {
                sourceName = sourceName.substring(sourceName.lastIndexOf(47) + 1);
            }
            if (name.equals(qName)) {
                obj4 = obj5;
                obj3 = sourceName;
                obj2 = null;
            } else {
                Object obj6 = obj5;
                obj3 = sourceName;
                obj2 = QNameHelper.pretty(name);
                obj4 = obj6;
            }
        }
        if (obj4 == null) {
            error(XmlErrorCodes.SCHEMA_QNAME_RESOLVE, new Object[]{obj, pretty}, xmlObject);
            return;
        }
        Object[] objArr = new Object[7];
        objArr[0] = obj;
        objArr[1] = pretty;
        objArr[2] = obj4;
        objArr[3] = obj2 == null ? new Integer(0) : new Integer(1);
        objArr[4] = obj2;
        objArr[5] = obj3 == null ? new Integer(0) : new Integer(1);
        objArr[6] = obj3;
        error(XmlErrorCodes.SCHEMA_QNAME_RESOLVE$HELP, objArr, xmlObject);
    }

    public String sourceNameForUri(String str) {
        return (String) this._sourceForUri.get(str);
    }

    public Map sourceCopyMap() {
        return Collections.unmodifiableMap(this._sourceForUri);
    }

    public void setBaseUri(URI uri) {
        this._baseURI = uri;
    }

    public String relativize(String str) {
        return relativize(str, false);
    }

    public String computeSavedFilename(String str) {
        return relativize(str, true);
    }

    private String relativize(String str, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.startsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            str = new StringBuffer().append(PROJECT_URL_PREFIX).append(str.replace(ICSVParser.DEFAULT_ESCAPE_CHARACTER, '/')).toString();
        } else {
            int indexOf = str.indexOf(58);
            if (indexOf <= 1 || !str.substring(0, indexOf).matches("^\\w+$")) {
                str = new StringBuffer().append("project://local/").append(str.replace(ICSVParser.DEFAULT_ESCAPE_CHARACTER, '/')).toString();
            }
        }
        URI uri = this._baseURI;
        if (uri != null) {
            try {
                URI relativize = uri.relativize(new URI(str));
                if (!relativize.isAbsolute()) {
                    return relativize.toString();
                }
                str = relativize.toString();
            } catch (URISyntaxException unused) {
            }
        }
        if (!z) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(47);
        String hexsafe = QNameHelper.hexsafe(lastIndexOf == -1 ? "" : str.substring(0, lastIndexOf));
        int i = lastIndexOf + 1;
        int indexOf2 = str.indexOf(63, i);
        if (indexOf2 == -1) {
            return new StringBuffer().append(hexsafe).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(str.substring(i)).toString();
        }
        String hexsafe2 = QNameHelper.hexsafe(indexOf2 != -1 ? str.substring(indexOf2) : "");
        if (hexsafe2.startsWith(QNameHelper.URI_SHA1_PREFIX)) {
            return new StringBuffer().append(hexsafe).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(str.substring(i, indexOf2)).toString();
        }
        return new StringBuffer().append(hexsafe).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(str.substring(i, indexOf2)).append(hexsafe2).toString();
    }

    public void addSourceUri(String str, String str2) {
        if (str == null) {
            return;
        }
        if (str2 == null) {
            str2 = computeSavedFilename(str);
        }
        this._sourceForUri.put(str, str2);
    }

    public Collection getErrorListener() {
        return this._errorListener;
    }

    public SchemaTypeLoader getS4SLoader() {
        return this._s4sloader;
    }

    public File getSchemasDir() {
        return this._schemasDir;
    }

    public void setSchemasDir(File file) {
        this._schemasDir = file;
    }
}
