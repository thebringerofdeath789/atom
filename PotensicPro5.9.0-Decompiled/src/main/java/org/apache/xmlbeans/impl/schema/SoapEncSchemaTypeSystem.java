package org.apache.xmlbeans.impl.schema;

import aavax.xml.namespace.QName;
import java.io.File;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.apache.xmlbeans.Filer;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeSystem;

/* loaded from: classes5.dex */
public class SoapEncSchemaTypeSystem extends SchemaTypeLoaderBase implements SchemaTypeSystem {
    public static final String ARRAY_TYPE = "arrayType";
    private static final String ATTR_HREF = "href";
    private static final String ATTR_ID = "id";
    private static final String ATTR_OFFSET = "offset";
    public static final String SOAPENC = "http://schemas.xmlsoap.org/soap/encoding/";
    public static final String SOAP_ARRAY = "Array";
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$schema$SoapEncSchemaTypeSystem;
    private SchemaContainer _container;
    private Map _handlesToObjects = new HashMap();
    private SchemaGlobalAttributeImpl arrayType;
    private SchemaTypeImpl soapArray;
    private String soapArrayHandle;
    private static final SchemaType[] EMPTY_SCHEMATYPE_ARRAY = new SchemaType[0];
    private static final SchemaGlobalElement[] EMPTY_SCHEMAELEMENT_ARRAY = new SchemaGlobalElement[0];
    private static final SchemaModelGroup[] EMPTY_SCHEMAMODELGROUP_ARRAY = new SchemaModelGroup[0];
    private static final SchemaAttributeGroup[] EMPTY_SCHEMAATTRIBUTEGROUP_ARRAY = new SchemaAttributeGroup[0];
    private static final SchemaAnnotation[] EMPTY_SCHEMAANNOTATION_ARRAY = new SchemaAnnotation[0];
    private static SoapEncSchemaTypeSystem _global = new SoapEncSchemaTypeSystem();

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase, org.apache.xmlbeans.SchemaTypeLoader
    public SchemaAttributeGroup findAttributeGroup(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaAttributeGroup.Ref findAttributeGroupRef(QName qName) {
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

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase, org.apache.xmlbeans.SchemaTypeLoader
    public SchemaModelGroup findModelGroup(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaModelGroup.Ref findModelGroupRef(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public String getName() {
        return "schema.typesystem.soapenc.builtin";
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public InputStream getSourceAsStream(String str) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public void resolve() {
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType typeForClassname(String str) {
        return null;
    }

    public static SchemaTypeSystem get() {
        return _global;
    }

    private SoapEncSchemaTypeSystem() {
        SchemaContainer schemaContainer = new SchemaContainer("http://schemas.xmlsoap.org/soap/encoding/");
        this._container = schemaContainer;
        schemaContainer.setTypeSystem(this);
        SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(this._container, true);
        this.soapArray = schemaTypeImpl;
        this._container.addGlobalType(schemaTypeImpl.getRef());
        this.soapArray.setName(new QName("http://schemas.xmlsoap.org/soap/encoding/", SOAP_ARRAY));
        this.soapArrayHandle = new StringBuffer().append(SOAP_ARRAY.toLowerCase()).append("type").toString();
        this.soapArray.setComplexTypeVariety(3);
        this.soapArray.setBaseTypeRef(BuiltinSchemaTypeSystem.ST_ANY_TYPE.getRef());
        this.soapArray.setBaseDepth(1);
        this.soapArray.setDerivationType(2);
        this.soapArray.setSimpleTypeVariety(0);
        SchemaParticleImpl schemaParticleImpl = new SchemaParticleImpl();
        schemaParticleImpl.setParticleType(3);
        schemaParticleImpl.setMinOccurs(BigInteger.ZERO);
        schemaParticleImpl.setMaxOccurs(BigInteger.ONE);
        schemaParticleImpl.setTransitionRules(QNameSet.ALL, true);
        schemaParticleImpl.setParticleChildren(new SchemaParticleImpl[]{r3});
        SchemaParticleImpl schemaParticleImpl2 = new SchemaParticleImpl();
        schemaParticleImpl2.setParticleType(5);
        schemaParticleImpl2.setWildcardSet(QNameSet.ALL);
        schemaParticleImpl2.setWildcardProcess(2);
        schemaParticleImpl2.setMinOccurs(BigInteger.ZERO);
        schemaParticleImpl2.setMaxOccurs(null);
        schemaParticleImpl2.setTransitionRules(QNameSet.ALL, true);
        SchemaAttributeModelImpl schemaAttributeModelImpl = new SchemaAttributeModelImpl();
        schemaAttributeModelImpl.setWildcardProcess(2);
        HashSet hashSet = new HashSet();
        hashSet.add("http://schemas.xmlsoap.org/soap/encoding/");
        schemaAttributeModelImpl.setWildcardSet(QNameSet.forSets(hashSet, null, Collections.EMPTY_SET, Collections.EMPTY_SET));
        SchemaLocalAttributeImpl schemaLocalAttributeImpl = new SchemaLocalAttributeImpl();
        schemaLocalAttributeImpl.init(new QName("", "id"), BuiltinSchemaTypeSystem.ST_ID.getRef(), 2, null, null, null, false, null, null, null);
        schemaAttributeModelImpl.addAttribute(schemaLocalAttributeImpl);
        SchemaLocalAttributeImpl schemaLocalAttributeImpl2 = new SchemaLocalAttributeImpl();
        schemaLocalAttributeImpl2.init(new QName("", ATTR_HREF), BuiltinSchemaTypeSystem.ST_ANY_URI.getRef(), 2, null, null, null, false, null, null, null);
        schemaAttributeModelImpl.addAttribute(schemaLocalAttributeImpl2);
        SchemaLocalAttributeImpl schemaLocalAttributeImpl3 = new SchemaLocalAttributeImpl();
        schemaLocalAttributeImpl3.init(new QName("http://schemas.xmlsoap.org/soap/encoding/", ARRAY_TYPE), BuiltinSchemaTypeSystem.ST_STRING.getRef(), 2, null, null, null, false, null, null, null);
        schemaAttributeModelImpl.addAttribute(schemaLocalAttributeImpl3);
        SchemaLocalAttributeImpl schemaLocalAttributeImpl4 = new SchemaLocalAttributeImpl();
        schemaLocalAttributeImpl4.init(new QName("http://schemas.xmlsoap.org/soap/encoding/", "offset"), BuiltinSchemaTypeSystem.ST_STRING.getRef(), 2, null, null, null, false, null, null, null);
        schemaAttributeModelImpl.addAttribute(schemaLocalAttributeImpl4);
        this.soapArray.setContentModel(schemaParticleImpl, schemaAttributeModelImpl, Collections.EMPTY_MAP, Collections.EMPTY_MAP, false);
        SchemaGlobalAttributeImpl schemaGlobalAttributeImpl = new SchemaGlobalAttributeImpl(this._container);
        this.arrayType = schemaGlobalAttributeImpl;
        this._container.addGlobalAttribute(schemaGlobalAttributeImpl.getRef());
        this.arrayType.init(new QName("http://schemas.xmlsoap.org/soap/encoding/", ARRAY_TYPE), BuiltinSchemaTypeSystem.ST_STRING.getRef(), 2, null, null, null, false, null, null, null);
        this._handlesToObjects.put(this.soapArrayHandle, this.soapArray);
        this._handlesToObjects.put(new StringBuffer().append(ARRAY_TYPE.toLowerCase()).append("attribute").toString(), this.arrayType);
        this._container.setImmutable();
    }

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase, org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType findType(QName qName) {
        if ("http://schemas.xmlsoap.org/soap/encoding/".equals(qName.getNamespaceURI()) && SOAP_ARRAY.equals(qName.getLocalPart())) {
            return this.soapArray;
        }
        return null;
    }

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase, org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalAttribute findAttribute(QName qName) {
        if ("http://schemas.xmlsoap.org/soap/encoding/".equals(qName.getNamespaceURI()) && ARRAY_TYPE.equals(qName.getLocalPart())) {
            return this.arrayType;
        }
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public boolean isNamespaceDefined(String str) {
        return "http://schemas.xmlsoap.org/soap/encoding/".equals(str);
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
    public SchemaGlobalAttribute.Ref findAttributeRef(QName qName) {
        SchemaGlobalAttribute findAttribute = findAttribute(qName);
        if (findAttribute == null) {
            return null;
        }
        return findAttribute.getRef();
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
        Class cls = class$org$apache$xmlbeans$impl$schema$SoapEncSchemaTypeSystem;
        if (cls == null) {
            cls = class$("org.apache.xmlbeans.impl.schema.SoapEncSchemaTypeSystem");
            class$org$apache$xmlbeans$impl$schema$SoapEncSchemaTypeSystem = cls;
        }
        return cls.getClassLoader();
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaType[] globalTypes() {
        return new SchemaType[]{this.soapArray};
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
        return new SchemaGlobalAttribute[]{this.arrayType};
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
        if (this.soapArray.equals(schemaType)) {
            return this.soapArrayHandle;
        }
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaComponent resolveHandle(String str) {
        return (SchemaComponent) this._handlesToObjects.get(str);
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaType typeForHandle(String str) {
        return (SchemaType) this._handlesToObjects.get(str);
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public void saveToDirectory(File file) {
        throw new UnsupportedOperationException("The builtin soap encoding schema type system cannot be saved.");
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public void save(Filer filer) {
        throw new UnsupportedOperationException("The builtin soap encoding schema type system cannot be saved.");
    }
}
