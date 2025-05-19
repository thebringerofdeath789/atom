package org.apache.xmlbeans.impl.schema;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.QNameSetBuilder;
import org.apache.xmlbeans.QNameSetSpecification;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaLocalAttribute;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.xb.xsdschema.AllNNI;
import org.apache.xmlbeans.impl.xb.xsdschema.ComplexRestrictionType;
import org.apache.xmlbeans.impl.xb.xsdschema.ComplexType;
import org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType;
import org.apache.xmlbeans.impl.xb.xsdschema.Group;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleExtensionType;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleRestrictionType;
import org.apache.xmlbeans.impl.xb.xsdschema.Wildcard;

/* loaded from: classes5.dex */
public class StscComplexTypeResolver {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final int ANY_ATTRIBUTE_CODE = 102;
    private static final int ATTRIBUTE_CODE = 100;
    private static final int ATTRIBUTE_GROUP_CODE = 101;
    private static final int MODEL_GROUP_CODE = 100;
    private static Map attributeCodeMap;
    private static CodeForNameEntry[] attributeCodes;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$schema$StscComplexTypeResolver;
    private static Map particleCodeMap;
    private static CodeForNameEntry[] particleCodes;

    static {
        if (class$org$apache$xmlbeans$impl$schema$StscComplexTypeResolver == null) {
            class$org$apache$xmlbeans$impl$schema$StscComplexTypeResolver = class$("org.apache.xmlbeans.impl.schema.StscComplexTypeResolver");
        }
        $assertionsDisabled = true;
        particleCodes = new CodeForNameEntry[]{new CodeForNameEntry(QNameHelper.forLNS(TtmlNode.COMBINE_ALL, "http://www.w3.org/2001/XMLSchema"), 1), new CodeForNameEntry(QNameHelper.forLNS("sequence", "http://www.w3.org/2001/XMLSchema"), 3), new CodeForNameEntry(QNameHelper.forLNS("choice", "http://www.w3.org/2001/XMLSchema"), 2), new CodeForNameEntry(QNameHelper.forLNS("element", "http://www.w3.org/2001/XMLSchema"), 4), new CodeForNameEntry(QNameHelper.forLNS("any", "http://www.w3.org/2001/XMLSchema"), 5), new CodeForNameEntry(QNameHelper.forLNS("group", "http://www.w3.org/2001/XMLSchema"), 100)};
        particleCodeMap = buildParticleCodeMap();
        attributeCodes = new CodeForNameEntry[]{new CodeForNameEntry(QNameHelper.forLNS("attribute", "http://www.w3.org/2001/XMLSchema"), 100), new CodeForNameEntry(QNameHelper.forLNS("attributeGroup", "http://www.w3.org/2001/XMLSchema"), 101), new CodeForNameEntry(QNameHelper.forLNS("anyAttribute", "http://www.w3.org/2001/XMLSchema"), 102)};
        attributeCodeMap = buildAttributeCodeMap();
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static Group getContentModel(ComplexType complexType) {
        if (complexType.getAll() != null) {
            return complexType.getAll();
        }
        if (complexType.getSequence() != null) {
            return complexType.getSequence();
        }
        if (complexType.getChoice() != null) {
            return complexType.getChoice();
        }
        if (complexType.getGroup() != null) {
            return complexType.getGroup();
        }
        return null;
    }

    public static Group getContentModel(ComplexRestrictionType complexRestrictionType) {
        if (complexRestrictionType.getAll() != null) {
            return complexRestrictionType.getAll();
        }
        if (complexRestrictionType.getSequence() != null) {
            return complexRestrictionType.getSequence();
        }
        if (complexRestrictionType.getChoice() != null) {
            return complexRestrictionType.getChoice();
        }
        if (complexRestrictionType.getGroup() != null) {
            return complexRestrictionType.getGroup();
        }
        return null;
    }

    public static Group getContentModel(ExtensionType extensionType) {
        if (extensionType.getAll() != null) {
            return extensionType.getAll();
        }
        if (extensionType.getSequence() != null) {
            return extensionType.getSequence();
        }
        if (extensionType.getChoice() != null) {
            return extensionType.getChoice();
        }
        if (extensionType.getGroup() != null) {
            return extensionType.getGroup();
        }
        return null;
    }

    static SchemaDocument.Schema getSchema(XmlObject xmlObject) {
        XmlObject object;
        XmlCursor newCursor = xmlObject.newCursor();
        do {
            try {
                if (!newCursor.toParent()) {
                    newCursor.dispose();
                    return null;
                }
                object = newCursor.getObject();
            } finally {
                newCursor.dispose();
            }
        } while (!object.schemaType().equals(SchemaDocument.Schema.type));
        return (SchemaDocument.Schema) object;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d3, code lost:
    
        if (r1 != null) goto L69;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void resolveComplexType(org.apache.xmlbeans.impl.schema.SchemaTypeImpl r16) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.schema.StscComplexTypeResolver.resolveComplexType(org.apache.xmlbeans.impl.schema.SchemaTypeImpl):void");
    }

    static void resolveErrorType(SchemaTypeImpl schemaTypeImpl) {
        throw new RuntimeException("This type of error recovery not yet implemented.");
    }

    private static SchemaType.Ref[] makeRefArray(Collection collection) {
        SchemaType.Ref[] refArr = new SchemaType.Ref[collection.size()];
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            refArr[i] = ((SchemaType) it.next()).getRef();
            i++;
        }
        return refArr;
    }

    static void resolveBasicComplexType(SchemaTypeImpl schemaTypeImpl) {
        ArrayList arrayList = new ArrayList();
        ComplexType complexType = (ComplexType) schemaTypeImpl.getParseObject();
        String targetNamespace = schemaTypeImpl.getTargetNamespace();
        boolean z = schemaTypeImpl.getChameleonNamespace() != null;
        Group contentModel = getContentModel(complexType);
        if (schemaTypeImpl.isRedefinition()) {
            StscState.get().error(XmlErrorCodes.SCHEMA_REDEFINE$EXTEND_OR_RESTRICT, new Object[]{"<complexType>"}, complexType);
        }
        SchemaParticle translateContentModel = translateContentModel(schemaTypeImpl, contentModel, targetNamespace, z, schemaTypeImpl.getElemFormDefault(), schemaTypeImpl.getAttFormDefault(), translateParticleCode(contentModel), arrayList, new LinkedHashMap(), false, null);
        boolean z2 = translateContentModel != null && translateContentModel.getParticleType() == 1;
        SchemaAttributeModelImpl schemaAttributeModelImpl = new SchemaAttributeModelImpl();
        translateAttributeModel(complexType, targetNamespace, z, schemaTypeImpl.getAttFormDefault(), arrayList, schemaTypeImpl, null, schemaAttributeModelImpl, null, true, null);
        WildcardResult summarizeEltWildcards = summarizeEltWildcards(translateContentModel);
        WildcardResult summarizeAttrWildcards = summarizeAttrWildcards(schemaAttributeModelImpl);
        if (translateContentModel != null) {
            buildStateMachine(translateContentModel);
            if (!StscState.get().noUpa() && !((SchemaParticleImpl) translateContentModel).isDeterministic()) {
                StscState.get().error(XmlErrorCodes.UNIQUE_PARTICLE_ATTRIBUTION, (Object[]) null, contentModel);
            }
        }
        Map buildContentPropertyModelByQName = buildContentPropertyModelByQName(translateContentModel, schemaTypeImpl);
        Map buildAttributePropertyModelByQName = buildAttributePropertyModelByQName(schemaAttributeModelImpl, schemaTypeImpl);
        int i = complexType.getMixed() ? 4 : translateContentModel == null ? 1 : 3;
        schemaTypeImpl.setBaseTypeRef(BuiltinSchemaTypeSystem.ST_ANY_TYPE.getRef());
        schemaTypeImpl.setBaseDepth(BuiltinSchemaTypeSystem.ST_ANY_TYPE.getBaseDepth() + 1);
        schemaTypeImpl.setDerivationType(2);
        schemaTypeImpl.setComplexTypeVariety(i);
        schemaTypeImpl.setContentModel(translateContentModel, schemaAttributeModelImpl, buildContentPropertyModelByQName, buildAttributePropertyModelByQName, z2);
        schemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
        schemaTypeImpl.setWildcardSummary(summarizeEltWildcards.typedWildcards, summarizeEltWildcards.hasWildcards, summarizeAttrWildcards.typedWildcards, summarizeAttrWildcards.hasWildcards);
    }

    static void resolveCcRestriction(SchemaTypeImpl schemaTypeImpl, ComplexRestrictionType complexRestrictionType, boolean z) {
        SchemaTypeImpl findGlobalType;
        SchemaAttributeModelImpl schemaAttributeModelImpl;
        StscState stscState = StscState.get();
        String targetNamespace = schemaTypeImpl.getTargetNamespace();
        boolean z2 = schemaTypeImpl.getChameleonNamespace() != null;
        if (complexRestrictionType.getBase() == null) {
            stscState.error("A complexContent must define a base type", 28, complexRestrictionType);
            findGlobalType = null;
        } else {
            if (schemaTypeImpl.isRedefinition()) {
                findGlobalType = stscState.findRedefinedGlobalType(complexRestrictionType.getBase(), schemaTypeImpl.getChameleonNamespace(), schemaTypeImpl);
                if (findGlobalType != null && !findGlobalType.getName().equals(schemaTypeImpl.getName())) {
                    stscState.error(XmlErrorCodes.SCHEMA_REDEFINE$SAME_TYPE, new Object[]{"<complexType>", QNameHelper.pretty(findGlobalType.getName()), QNameHelper.pretty(schemaTypeImpl.getName())}, complexRestrictionType);
                }
            } else {
                findGlobalType = stscState.findGlobalType(complexRestrictionType.getBase(), schemaTypeImpl.getChameleonNamespace(), targetNamespace);
            }
            if (findGlobalType == null) {
                stscState.notFoundError(complexRestrictionType.getBase(), 0, complexRestrictionType.xgetBase(), true);
            }
        }
        if (findGlobalType == null) {
            findGlobalType = BuiltinSchemaTypeSystem.ST_ANY_TYPE;
        }
        if (findGlobalType != null && findGlobalType.finalRestriction()) {
            stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$FINAL, new Object[]{QNameHelper.pretty(findGlobalType.getName()), QNameHelper.pretty(schemaTypeImpl.getName())}, complexRestrictionType.xgetBase());
        }
        SchemaTypeImpl schemaTypeImpl2 = (findGlobalType == null || StscResolver.resolveType(findGlobalType)) ? findGlobalType : null;
        ArrayList arrayList = new ArrayList();
        Group contentModel = getContentModel(complexRestrictionType);
        SchemaParticle translateContentModel = translateContentModel(schemaTypeImpl, contentModel, targetNamespace, z2, schemaTypeImpl.getElemFormDefault(), schemaTypeImpl.getAttFormDefault(), translateParticleCode(contentModel), arrayList, new LinkedHashMap(), false, null);
        boolean z3 = translateContentModel != null && translateContentModel.getParticleType() == 1;
        if (schemaTypeImpl2 == null) {
            schemaAttributeModelImpl = new SchemaAttributeModelImpl();
        } else {
            schemaAttributeModelImpl = new SchemaAttributeModelImpl(schemaTypeImpl2.getAttributeModel());
        }
        SchemaAttributeModelImpl schemaAttributeModelImpl2 = schemaAttributeModelImpl;
        translateAttributeModel(complexRestrictionType, targetNamespace, z2, schemaTypeImpl.getAttFormDefault(), arrayList, schemaTypeImpl, null, schemaAttributeModelImpl2, schemaTypeImpl2, false, null);
        WildcardResult summarizeEltWildcards = summarizeEltWildcards(translateContentModel);
        WildcardResult summarizeAttrWildcards = summarizeAttrWildcards(schemaAttributeModelImpl2);
        if (translateContentModel != null) {
            buildStateMachine(translateContentModel);
            if (!StscState.get().noUpa() && !((SchemaParticleImpl) translateContentModel).isDeterministic()) {
                StscState.get().error(XmlErrorCodes.UNIQUE_PARTICLE_ATTRIBUTION, (Object[]) null, contentModel);
            }
        }
        Map buildContentPropertyModelByQName = buildContentPropertyModelByQName(translateContentModel, schemaTypeImpl);
        Map buildAttributePropertyModelByQName = buildAttributePropertyModelByQName(schemaAttributeModelImpl2, schemaTypeImpl);
        int i = z ? 4 : translateContentModel == null ? 1 : 3;
        schemaTypeImpl.setBaseTypeRef(schemaTypeImpl2.getRef());
        schemaTypeImpl.setBaseDepth(schemaTypeImpl2.getBaseDepth() + 1);
        schemaTypeImpl.setDerivationType(1);
        schemaTypeImpl.setComplexTypeVariety(i);
        schemaTypeImpl.setContentModel(translateContentModel, schemaAttributeModelImpl2, buildContentPropertyModelByQName, buildAttributePropertyModelByQName, z3);
        schemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
        schemaTypeImpl.setWildcardSummary(summarizeEltWildcards.typedWildcards, summarizeEltWildcards.hasWildcards, summarizeAttrWildcards.typedWildcards, summarizeAttrWildcards.hasWildcards);
    }

    static Map extractElementModel(SchemaType schemaType) {
        HashMap hashMap = new HashMap();
        if (schemaType != null) {
            SchemaProperty[] properties = schemaType.getProperties();
            for (int i = 0; i < properties.length; i++) {
                if (!properties[i].isAttribute()) {
                    hashMap.put(properties[i].getName(), properties[i].getType());
                }
            }
        }
        return hashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void resolveCcExtension(org.apache.xmlbeans.impl.schema.SchemaTypeImpl r26, org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType r27, boolean r28) {
        /*
            Method dump skipped, instructions count: 608
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.schema.StscComplexTypeResolver.resolveCcExtension(org.apache.xmlbeans.impl.schema.SchemaTypeImpl, org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType, boolean):void");
    }

    static void resolveScRestriction(SchemaTypeImpl schemaTypeImpl, SimpleRestrictionType simpleRestrictionType) {
        SchemaTypeImpl findGlobalType;
        SchemaTypeImpl schemaTypeImpl2;
        SchemaAttributeModelImpl schemaAttributeModelImpl;
        StscState stscState = StscState.get();
        String targetNamespace = schemaTypeImpl.getTargetNamespace();
        boolean z = schemaTypeImpl.getChameleonNamespace() != null;
        ArrayList arrayList = new ArrayList();
        SchemaTypeImpl translateAnonymousSimpleType = simpleRestrictionType.getSimpleType() != null ? StscTranslator.translateAnonymousSimpleType(simpleRestrictionType.getSimpleType(), targetNamespace, z, schemaTypeImpl.getElemFormDefault(), schemaTypeImpl.getAttFormDefault(), arrayList, schemaTypeImpl) : null;
        if (simpleRestrictionType.getBase() == null) {
            stscState.error("A simpleContent restriction must define a base type", 28, simpleRestrictionType);
            findGlobalType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        } else {
            if (schemaTypeImpl.isRedefinition()) {
                findGlobalType = stscState.findRedefinedGlobalType(simpleRestrictionType.getBase(), schemaTypeImpl.getChameleonNamespace(), schemaTypeImpl);
                if (findGlobalType != null && !findGlobalType.getName().equals(schemaTypeImpl.getName())) {
                    stscState.error(XmlErrorCodes.SCHEMA_REDEFINE$SAME_TYPE, new Object[]{"<simpleType>", QNameHelper.pretty(findGlobalType.getName()), QNameHelper.pretty(schemaTypeImpl.getName())}, simpleRestrictionType);
                }
            } else {
                findGlobalType = stscState.findGlobalType(simpleRestrictionType.getBase(), schemaTypeImpl.getChameleonNamespace(), targetNamespace);
            }
            if (findGlobalType == null) {
                stscState.notFoundError(simpleRestrictionType.getBase(), 0, simpleRestrictionType.xgetBase(), true);
                findGlobalType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
            }
        }
        StscResolver.resolveType(findGlobalType);
        if (translateAnonymousSimpleType != null) {
            StscResolver.resolveType(translateAnonymousSimpleType);
            schemaTypeImpl2 = translateAnonymousSimpleType;
        } else {
            schemaTypeImpl2 = findGlobalType;
        }
        if (findGlobalType.isSimpleType()) {
            stscState.recover(XmlErrorCodes.COMPLEX_TYPE_PROPERTIES$SIMPLE_TYPE_EXTENSION, new Object[]{QNameHelper.pretty(findGlobalType.getName())}, simpleRestrictionType);
            findGlobalType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        } else if (findGlobalType.getContentType() != 2 && schemaTypeImpl2 == null) {
            findGlobalType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        }
        SchemaTypeImpl schemaTypeImpl3 = findGlobalType;
        if (schemaTypeImpl3 != null && schemaTypeImpl3.finalRestriction()) {
            stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$FINAL, new Object[]{QNameHelper.pretty(schemaTypeImpl3.getName()), QNameHelper.pretty(schemaTypeImpl.getName())}, simpleRestrictionType.xgetBase());
        }
        if (schemaTypeImpl3 == null) {
            schemaAttributeModelImpl = new SchemaAttributeModelImpl();
        } else {
            schemaAttributeModelImpl = new SchemaAttributeModelImpl(schemaTypeImpl3.getAttributeModel());
        }
        SchemaAttributeModelImpl schemaAttributeModelImpl2 = schemaAttributeModelImpl;
        translateAttributeModel(simpleRestrictionType, targetNamespace, z, schemaTypeImpl.getAttFormDefault(), arrayList, schemaTypeImpl, null, schemaAttributeModelImpl2, schemaTypeImpl3, false, null);
        WildcardResult summarizeAttrWildcards = summarizeAttrWildcards(schemaAttributeModelImpl2);
        Map buildAttributePropertyModelByQName = buildAttributePropertyModelByQName(schemaAttributeModelImpl2, schemaTypeImpl);
        schemaTypeImpl.setBaseTypeRef(schemaTypeImpl3.getRef());
        schemaTypeImpl.setBaseDepth(schemaTypeImpl3.getBaseDepth() + 1);
        schemaTypeImpl.setContentBasedOnTypeRef(schemaTypeImpl2.getRef());
        schemaTypeImpl.setDerivationType(1);
        schemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
        schemaTypeImpl.setWildcardSummary(QNameSet.EMPTY, false, summarizeAttrWildcards.typedWildcards, summarizeAttrWildcards.hasWildcards);
        schemaTypeImpl.setComplexTypeVariety(2);
        schemaTypeImpl.setContentModel(null, schemaAttributeModelImpl2, null, buildAttributePropertyModelByQName, false);
        schemaTypeImpl.setSimpleTypeVariety(schemaTypeImpl2.getSimpleVariety());
        schemaTypeImpl.setPrimitiveTypeRef(schemaTypeImpl2.getPrimitiveType() != null ? schemaTypeImpl2.getPrimitiveType().getRef() : null);
        int simpleVariety = schemaTypeImpl.getSimpleVariety();
        if (simpleVariety == 2) {
            schemaTypeImpl.setUnionMemberTypeRefs(makeRefArray(Arrays.asList(schemaTypeImpl2.getUnionMemberTypes())));
        } else if (simpleVariety == 3) {
            schemaTypeImpl.setListItemTypeRef(schemaTypeImpl2.getListItemType().getRef());
        }
        StscSimpleTypeResolver.resolveFacets(schemaTypeImpl, simpleRestrictionType, schemaTypeImpl2);
        StscSimpleTypeResolver.resolveFundamentalFacets(schemaTypeImpl);
    }

    static void resolveScExtension(SchemaTypeImpl schemaTypeImpl, SimpleExtensionType simpleExtensionType) {
        SchemaTypeImpl findGlobalType;
        StscState stscState = StscState.get();
        String targetNamespace = schemaTypeImpl.getTargetNamespace();
        boolean z = schemaTypeImpl.getChameleonNamespace() != null;
        if (simpleExtensionType.getBase() == null) {
            stscState.error("A simpleContent extension must define a base type", 28, simpleExtensionType);
            findGlobalType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        } else {
            if (schemaTypeImpl.isRedefinition()) {
                findGlobalType = stscState.findRedefinedGlobalType(simpleExtensionType.getBase(), schemaTypeImpl.getChameleonNamespace(), schemaTypeImpl);
                if (findGlobalType != null && !findGlobalType.getName().equals(schemaTypeImpl.getName())) {
                    stscState.error(XmlErrorCodes.SCHEMA_REDEFINE$SAME_TYPE, new Object[]{"<simpleType>", QNameHelper.pretty(findGlobalType.getName()), QNameHelper.pretty(schemaTypeImpl.getName())}, simpleExtensionType);
                }
            } else {
                findGlobalType = stscState.findGlobalType(simpleExtensionType.getBase(), schemaTypeImpl.getChameleonNamespace(), targetNamespace);
            }
            if (findGlobalType == null) {
                stscState.notFoundError(simpleExtensionType.getBase(), 0, simpleExtensionType.xgetBase(), true);
                findGlobalType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
            }
        }
        StscResolver.resolveType(findGlobalType);
        if (!findGlobalType.isSimpleType() && findGlobalType.getContentType() != 2) {
            stscState.error(XmlErrorCodes.SCHEMA_COMPLEX_TYPE$SIMPLE_CONTENT, new Object[]{QNameHelper.pretty(findGlobalType.getName())}, simpleExtensionType);
            findGlobalType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        }
        if (findGlobalType != null && findGlobalType.finalExtension()) {
            stscState.error(XmlErrorCodes.COMPLEX_TYPE_EXTENSION$FINAL, new Object[]{QNameHelper.pretty(findGlobalType.getName()), QNameHelper.pretty(schemaTypeImpl.getName())}, simpleExtensionType.xgetBase());
        }
        resolveScExtensionPart2(schemaTypeImpl, findGlobalType, simpleExtensionType, targetNamespace, z);
    }

    static void resolveScExtensionPart2(SchemaTypeImpl schemaTypeImpl, SchemaType schemaType, ExtensionType extensionType, String str, boolean z) {
        ArrayList arrayList = new ArrayList();
        SchemaAttributeModelImpl schemaAttributeModelImpl = new SchemaAttributeModelImpl(schemaType.getAttributeModel());
        translateAttributeModel(extensionType, str, z, schemaTypeImpl.getAttFormDefault(), arrayList, schemaTypeImpl, null, schemaAttributeModelImpl, schemaType, true, null);
        WildcardResult summarizeAttrWildcards = summarizeAttrWildcards(schemaAttributeModelImpl);
        Map buildAttributePropertyModelByQName = buildAttributePropertyModelByQName(schemaAttributeModelImpl, schemaTypeImpl);
        schemaTypeImpl.setBaseTypeRef(schemaType.getRef());
        SchemaTypeImpl schemaTypeImpl2 = (SchemaTypeImpl) schemaType;
        schemaTypeImpl.setBaseDepth(schemaTypeImpl2.getBaseDepth() + 1);
        schemaTypeImpl.setContentBasedOnTypeRef(schemaType.getRef());
        schemaTypeImpl.setDerivationType(2);
        schemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
        schemaTypeImpl.setWildcardSummary(QNameSet.EMPTY, false, summarizeAttrWildcards.typedWildcards, summarizeAttrWildcards.hasWildcards);
        schemaTypeImpl.setComplexTypeVariety(2);
        schemaTypeImpl.setContentModel(null, schemaAttributeModelImpl, null, buildAttributePropertyModelByQName, false);
        schemaTypeImpl.setSimpleTypeVariety(schemaType.getSimpleVariety());
        schemaTypeImpl.setPrimitiveTypeRef(schemaType.getPrimitiveType() == null ? null : schemaType.getPrimitiveType().getRef());
        int simpleVariety = schemaTypeImpl.getSimpleVariety();
        if (simpleVariety == 2) {
            schemaTypeImpl.setUnionMemberTypeRefs(makeRefArray(Arrays.asList(schemaType.getUnionMemberTypes())));
        } else if (simpleVariety == 3) {
            schemaTypeImpl.setListItemTypeRef(schemaType.getListItemType().getRef());
        }
        StscSimpleTypeResolver.resolveFacets(schemaTypeImpl, null, schemaTypeImpl2);
        StscSimpleTypeResolver.resolveFundamentalFacets(schemaTypeImpl);
    }

    static class WildcardResult {
        boolean hasWildcards;
        QNameSet typedWildcards;

        WildcardResult(QNameSet qNameSet, boolean z) {
            this.typedWildcards = qNameSet;
            this.hasWildcards = z;
        }
    }

    static WildcardResult summarizeAttrWildcards(SchemaAttributeModel schemaAttributeModel) {
        if (schemaAttributeModel.getWildcardProcess() == 0) {
            return new WildcardResult(QNameSet.EMPTY, false);
        }
        if (schemaAttributeModel.getWildcardProcess() == 3) {
            return new WildcardResult(QNameSet.EMPTY, true);
        }
        return new WildcardResult(schemaAttributeModel.getWildcardSet(), true);
    }

    static WildcardResult summarizeEltWildcards(SchemaParticle schemaParticle) {
        if (schemaParticle == null) {
            return new WildcardResult(QNameSet.EMPTY, false);
        }
        int particleType = schemaParticle.getParticleType();
        if (particleType != 1 && particleType != 2 && particleType != 3) {
            if (particleType == 5) {
                return new WildcardResult(schemaParticle.getWildcardProcess() == 3 ? QNameSet.EMPTY : schemaParticle.getWildcardSet(), true);
            }
            return new WildcardResult(QNameSet.EMPTY, false);
        }
        QNameSetBuilder qNameSetBuilder = new QNameSetBuilder();
        boolean z = false;
        for (int i = 0; i < schemaParticle.countOfParticleChild(); i++) {
            WildcardResult summarizeEltWildcards = summarizeEltWildcards(schemaParticle.getParticleChild(i));
            qNameSetBuilder.addAll(summarizeEltWildcards.typedWildcards);
            z |= summarizeEltWildcards.hasWildcards;
        }
        return new WildcardResult(qNameSetBuilder.toQNameSet(), z);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x011d  */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r4v1, types: [org.apache.xmlbeans.impl.schema.StscState] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v3, types: [org.apache.xmlbeans.impl.schema.StscState] */
    /* JADX WARN: Type inference failed for: r4v4, types: [org.apache.xmlbeans.impl.schema.StscState] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void translateAttributeModel(org.apache.xmlbeans.XmlObject r24, java.lang.String r25, boolean r26, java.lang.String r27, java.util.List r28, org.apache.xmlbeans.SchemaType r29, java.util.Set r30, org.apache.xmlbeans.impl.schema.SchemaAttributeModelImpl r31, org.apache.xmlbeans.SchemaType r32, boolean r33, org.apache.xmlbeans.impl.schema.SchemaAttributeGroupImpl r34) {
        /*
            Method dump skipped, instructions count: 732
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.schema.StscComplexTypeResolver.translateAttributeModel(org.apache.xmlbeans.XmlObject, java.lang.String, boolean, java.lang.String, java.util.List, org.apache.xmlbeans.SchemaType, java.util.Set, org.apache.xmlbeans.impl.schema.SchemaAttributeModelImpl, org.apache.xmlbeans.SchemaType, boolean, org.apache.xmlbeans.impl.schema.SchemaAttributeGroupImpl):void");
    }

    static SchemaParticle extendContentModel(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, XmlObject xmlObject) {
        if (schemaParticle2 == null) {
            return schemaParticle;
        }
        if (schemaParticle == null) {
            return schemaParticle2;
        }
        SchemaParticleImpl schemaParticleImpl = new SchemaParticleImpl();
        schemaParticleImpl.setParticleType(3);
        ArrayList arrayList = new ArrayList();
        addMinusPointlessParticles(arrayList, schemaParticle, 3);
        addMinusPointlessParticles(arrayList, schemaParticle2, 3);
        schemaParticleImpl.setMinOccurs(BigInteger.ONE);
        schemaParticleImpl.setMaxOccurs(BigInteger.ONE);
        schemaParticleImpl.setParticleChildren((SchemaParticle[]) arrayList.toArray(new SchemaParticle[arrayList.size()]));
        return filterPointlessParticlesAndVerifyAllParticles(schemaParticleImpl, xmlObject);
    }

    static BigInteger extractMinOccurs(XmlNonNegativeInteger xmlNonNegativeInteger) {
        if (xmlNonNegativeInteger == null) {
            return BigInteger.ONE;
        }
        BigInteger bigIntegerValue = xmlNonNegativeInteger.getBigIntegerValue();
        return bigIntegerValue == null ? BigInteger.ONE : bigIntegerValue;
    }

    static BigInteger extractMaxOccurs(AllNNI allNNI) {
        if (allNNI == null) {
            return BigInteger.ONE;
        }
        if (allNNI.instanceType().getPrimitiveType().getBuiltinTypeCode() == 11) {
            return ((XmlInteger) allNNI).getBigIntegerValue();
        }
        return null;
    }

    private static class RedefinitionForGroup {
        private SchemaModelGroupImpl group;
        private boolean seenRedefinition = false;

        public RedefinitionForGroup(SchemaModelGroupImpl schemaModelGroupImpl) {
            this.group = schemaModelGroupImpl;
        }

        public SchemaModelGroupImpl getGroup() {
            return this.group;
        }

        public boolean isSeenRedefinition() {
            return this.seenRedefinition;
        }

        public void setSeenRedefinition(boolean z) {
            this.seenRedefinition = z;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02b2  */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.lang.Object[], org.apache.xmlbeans.SchemaParticle] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static org.apache.xmlbeans.SchemaParticle translateContentModel(org.apache.xmlbeans.SchemaType r22, org.apache.xmlbeans.XmlObject r23, java.lang.String r24, boolean r25, java.lang.String r26, java.lang.String r27, int r28, java.util.List r29, java.util.Map r30, boolean r31, org.apache.xmlbeans.impl.schema.StscComplexTypeResolver.RedefinitionForGroup r32) {
        /*
            Method dump skipped, instructions count: 821
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.schema.StscComplexTypeResolver.translateContentModel(org.apache.xmlbeans.SchemaType, org.apache.xmlbeans.XmlObject, java.lang.String, boolean, java.lang.String, java.lang.String, int, java.util.List, java.util.Map, boolean, org.apache.xmlbeans.impl.schema.StscComplexTypeResolver$RedefinitionForGroup):org.apache.xmlbeans.SchemaParticle");
    }

    static int translateWildcardProcess(Wildcard.ProcessContents processContents) {
        if (processContents == null) {
            return 1;
        }
        String stringValue = processContents.getStringValue();
        if ("lax".equals(stringValue)) {
            return 2;
        }
        return "skip".equals(stringValue) ? 3 : 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static org.apache.xmlbeans.SchemaParticle filterPointlessParticlesAndVerifyAllParticles(org.apache.xmlbeans.SchemaParticle r7, org.apache.xmlbeans.XmlObject r8) {
        /*
            java.math.BigInteger r0 = r7.getMaxOccurs()
            r1 = 0
            if (r0 == 0) goto L12
            java.math.BigInteger r0 = r7.getMaxOccurs()
            int r0 = r0.signum()
            if (r0 != 0) goto L12
            return r1
        L12:
            int r0 = r7.getParticleType()
            r2 = 4
            r3 = 0
            r4 = 1
            if (r0 == r4) goto L5c
            r5 = 2
            if (r0 == r5) goto L37
            r5 = 3
            if (r0 == r5) goto L5c
            if (r0 == r2) goto L36
            r8 = 5
            if (r0 == r8) goto L36
            boolean r7 = org.apache.xmlbeans.impl.schema.StscComplexTypeResolver.$assertionsDisabled
            if (r7 != 0) goto L30
            java.lang.AssertionError r7 = new java.lang.AssertionError
            r7.<init>()
            throw r7
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            r7.<init>()
            throw r7
        L36:
            return r7
        L37:
            org.apache.xmlbeans.SchemaParticle[] r0 = r7.getParticleChildren()
            int r0 = r0.length
            if (r0 != 0) goto L4b
            java.math.BigInteger r0 = r7.getMinOccurs()
            java.math.BigInteger r5 = java.math.BigInteger.ZERO
            int r0 = r0.compareTo(r5)
            if (r0 != 0) goto L4b
            return r1
        L4b:
            boolean r0 = r7.isSingleton()
            if (r0 == 0) goto L75
            int r0 = r7.countOfParticleChild()
            if (r0 != r4) goto L75
            org.apache.xmlbeans.SchemaParticle r7 = r7.getParticleChild(r3)
            return r7
        L5c:
            org.apache.xmlbeans.SchemaParticle[] r0 = r7.getParticleChildren()
            int r0 = r0.length
            if (r0 != 0) goto L64
            return r1
        L64:
            boolean r0 = r7.isSingleton()
            if (r0 == 0) goto L75
            int r0 = r7.countOfParticleChild()
            if (r0 != r4) goto L75
            org.apache.xmlbeans.SchemaParticle r7 = r7.getParticleChild(r3)
            return r7
        L75:
            int r0 = r7.getParticleType()
            if (r0 != r4) goto L7d
            r0 = r4
            goto L7e
        L7d:
            r0 = r3
        L7e:
            if (r0 == 0) goto L9b
            java.math.BigInteger r5 = r7.getMaxOccurs()
            if (r5 == 0) goto L92
            java.math.BigInteger r5 = r7.getMaxOccurs()
            java.math.BigInteger r6 = java.math.BigInteger.ONE
            int r5 = r5.compareTo(r6)
            if (r5 <= 0) goto L9b
        L92:
            org.apache.xmlbeans.impl.schema.StscState r5 = org.apache.xmlbeans.impl.schema.StscState.get()
            java.lang.String r6 = "cos-all-limited.1.2a"
            r5.error(r6, r1, r8)
        L9b:
            int r5 = r7.countOfParticleChild()
            if (r3 >= r5) goto Ldb
            org.apache.xmlbeans.SchemaParticle r5 = r7.getParticleChild(r3)
            int r6 = r5.getParticleType()
            if (r6 != r4) goto Lb5
            org.apache.xmlbeans.impl.schema.StscState r5 = org.apache.xmlbeans.impl.schema.StscState.get()
            java.lang.String r6 = "cos-all-limited.1.2b"
            r5.error(r6, r1, r8)
            goto Ld8
        Lb5:
            if (r0 == 0) goto Ld8
            int r6 = r5.getParticleType()
            if (r6 != r2) goto Lcf
            java.math.BigInteger r6 = r5.getMaxOccurs()
            if (r6 == 0) goto Lcf
            java.math.BigInteger r5 = r5.getMaxOccurs()
            java.math.BigInteger r6 = java.math.BigInteger.ONE
            int r5 = r5.compareTo(r6)
            if (r5 <= 0) goto Ld8
        Lcf:
            org.apache.xmlbeans.impl.schema.StscState r5 = org.apache.xmlbeans.impl.schema.StscState.get()
            java.lang.String r6 = "cos-all-limited.2"
            r5.error(r6, r1, r8)
        Ld8:
            int r3 = r3 + 1
            goto L9b
        Ldb:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.schema.StscComplexTypeResolver.filterPointlessParticlesAndVerifyAllParticles(org.apache.xmlbeans.SchemaParticle, org.apache.xmlbeans.XmlObject):org.apache.xmlbeans.SchemaParticle");
    }

    static void addMinusPointlessParticles(List list, SchemaParticle schemaParticle, int i) {
        if (schemaParticle == null) {
            return;
        }
        int particleType = schemaParticle.getParticleType();
        if (particleType != 2) {
            if (particleType == 3 && i == 3 && schemaParticle.isSingleton()) {
                list.addAll(Arrays.asList(schemaParticle.getParticleChildren()));
                return;
            }
        } else if (i == 2 && schemaParticle.isSingleton()) {
            list.addAll(Arrays.asList(schemaParticle.getParticleChildren()));
            return;
        }
        list.add(schemaParticle);
    }

    static Map buildAttributePropertyModelByQName(SchemaAttributeModel schemaAttributeModel, SchemaType schemaType) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        SchemaLocalAttribute[] attributes = schemaAttributeModel.getAttributes();
        for (int i = 0; i < attributes.length; i++) {
            linkedHashMap.put(attributes[i].getName(), buildUseProperty(attributes[i], schemaType));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.util.Map buildContentPropertyModelByQName(org.apache.xmlbeans.SchemaParticle r10, org.apache.xmlbeans.SchemaType r11) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.schema.StscComplexTypeResolver.buildContentPropertyModelByQName(org.apache.xmlbeans.SchemaParticle, org.apache.xmlbeans.SchemaType):java.util.Map");
    }

    static Map buildElementPropertyModel(SchemaLocalElement schemaLocalElement, SchemaType schemaType) {
        HashMap hashMap = new HashMap(1);
        SchemaProperty buildUseProperty = buildUseProperty(schemaLocalElement, schemaType);
        hashMap.put(buildUseProperty.getName(), buildUseProperty);
        return hashMap;
    }

    static SchemaProperty buildUseProperty(SchemaField schemaField, SchemaType schemaType) {
        SchemaPropertyImpl schemaPropertyImpl = new SchemaPropertyImpl();
        schemaPropertyImpl.setName(schemaField.getName());
        schemaPropertyImpl.setContainerTypeRef(schemaType.getRef());
        schemaPropertyImpl.setTypeRef(schemaField.getType().getRef());
        schemaPropertyImpl.setAttribute(schemaField.isAttribute());
        schemaPropertyImpl.setDefault(schemaField.isDefault() ? 2 : 0);
        schemaPropertyImpl.setFixed(schemaField.isFixed() ? 2 : 0);
        schemaPropertyImpl.setNillable(schemaField.isNillable() ? 2 : 0);
        schemaPropertyImpl.setDefaultText(schemaField.getDefaultText());
        schemaPropertyImpl.setMinOccurs(schemaField.getMinOccurs());
        schemaPropertyImpl.setMaxOccurs(schemaField.getMaxOccurs());
        if (schemaField instanceof SchemaLocalElementImpl) {
            schemaPropertyImpl.setAcceptedNames(((SchemaLocalElementImpl) schemaField).acceptedStartNames());
        }
        return schemaPropertyImpl;
    }

    static void mergeProperties(SchemaPropertyImpl schemaPropertyImpl, SchemaProperty schemaProperty, boolean z) {
        BigInteger min;
        BigInteger max;
        BigInteger minOccurs = schemaPropertyImpl.getMinOccurs();
        BigInteger maxOccurs = schemaPropertyImpl.getMaxOccurs();
        if (z) {
            min = minOccurs.add(schemaProperty.getMinOccurs());
            if (maxOccurs != null) {
                if (schemaProperty.getMaxOccurs() != null) {
                    max = maxOccurs.add(schemaProperty.getMaxOccurs());
                    maxOccurs = max;
                }
                maxOccurs = null;
            }
        } else {
            min = minOccurs.min(schemaProperty.getMinOccurs());
            if (maxOccurs != null) {
                if (schemaProperty.getMaxOccurs() != null) {
                    max = maxOccurs.max(schemaProperty.getMaxOccurs());
                    maxOccurs = max;
                }
                maxOccurs = null;
            }
        }
        schemaPropertyImpl.setMinOccurs(min);
        schemaPropertyImpl.setMaxOccurs(maxOccurs);
        if (schemaProperty.hasNillable() != schemaPropertyImpl.hasNillable()) {
            schemaPropertyImpl.setNillable(1);
        }
        if (schemaProperty.hasDefault() != schemaPropertyImpl.hasDefault()) {
            schemaPropertyImpl.setDefault(1);
        }
        if (schemaProperty.hasFixed() != schemaPropertyImpl.hasFixed()) {
            schemaPropertyImpl.setFixed(1);
        }
        if (schemaPropertyImpl.getDefaultText() != null) {
            if (schemaProperty.getDefaultText() == null || !schemaPropertyImpl.getDefaultText().equals(schemaProperty.getDefaultText())) {
                schemaPropertyImpl.setDefaultText(null);
            }
        }
    }

    static SchemaParticle[] ensureStateMachine(SchemaParticle[] schemaParticleArr) {
        for (SchemaParticle schemaParticle : schemaParticleArr) {
            buildStateMachine(schemaParticle);
        }
        return schemaParticleArr;
    }

    static void buildStateMachine(SchemaParticle schemaParticle) {
        boolean z;
        boolean z2;
        if (schemaParticle == null) {
            return;
        }
        SchemaParticleImpl schemaParticleImpl = (SchemaParticleImpl) schemaParticle;
        if (schemaParticleImpl.hasTransitionNotes()) {
            return;
        }
        QNameSetBuilder qNameSetBuilder = new QNameSetBuilder();
        QNameSetBuilder qNameSetBuilder2 = new QNameSetBuilder();
        boolean z3 = schemaParticleImpl.getMinOccurs().signum() == 0;
        int particleType = schemaParticleImpl.getParticleType();
        if (particleType != 1) {
            if (particleType == 2) {
                SchemaParticle[] ensureStateMachine = ensureStateMachine(schemaParticleImpl.getParticleChildren());
                z2 = false;
                for (int i = 0; !z2 && i < ensureStateMachine.length; i++) {
                    if (ensureStateMachine[i].isSkippable()) {
                        z2 = true;
                    }
                }
                z = true;
                for (int i2 = 0; z && i2 < ensureStateMachine.length; i2++) {
                    if (!((SchemaParticleImpl) ensureStateMachine[i2]).isDeterministic()) {
                        z = false;
                    }
                }
                for (int i3 = 0; i3 < ensureStateMachine.length; i3++) {
                    if (z && !qNameSetBuilder.isDisjoint(ensureStateMachine[i3].acceptedStartNames())) {
                        z = false;
                    }
                    qNameSetBuilder.addAll(ensureStateMachine[i3].acceptedStartNames());
                    qNameSetBuilder2.addAll(((SchemaParticleImpl) ensureStateMachine[i3]).getExcludeNextSet());
                }
            } else if (particleType != 3) {
                if (particleType != 4) {
                    if (particleType == 5) {
                        qNameSetBuilder.addAll(schemaParticleImpl.getWildcardSet());
                    } else {
                        throw new IllegalStateException("Unrecognized schema particle");
                    }
                } else if (schemaParticleImpl.hasTransitionRules()) {
                    qNameSetBuilder.addAll(schemaParticleImpl.acceptedStartNames());
                } else {
                    qNameSetBuilder.add(schemaParticleImpl.getName());
                }
                z = true;
            } else {
                SchemaParticle[] ensureStateMachine2 = ensureStateMachine(schemaParticleImpl.getParticleChildren());
                z2 = true;
                for (int i4 = 0; z2 && i4 < ensureStateMachine2.length; i4++) {
                    if (!ensureStateMachine2[i4].isSkippable()) {
                        z2 = false;
                    }
                }
                z = true;
                for (int i5 = 0; z && i5 < ensureStateMachine2.length; i5++) {
                    if (!((SchemaParticleImpl) ensureStateMachine2[i5]).isDeterministic()) {
                        z = false;
                    }
                }
                for (int i6 = 1; i6 < ensureStateMachine2.length; i6++) {
                    qNameSetBuilder2.addAll(((SchemaParticleImpl) ensureStateMachine2[i6 - 1]).getExcludeNextSet());
                    if (z && !qNameSetBuilder2.isDisjoint(ensureStateMachine2[i6].acceptedStartNames())) {
                        z = false;
                    }
                    if (ensureStateMachine2[i6].isSkippable()) {
                        qNameSetBuilder2.addAll(ensureStateMachine2[i6].acceptedStartNames());
                    } else {
                        qNameSetBuilder2.clear();
                    }
                }
                for (int i7 = 0; i7 < ensureStateMachine2.length; i7++) {
                    qNameSetBuilder.addAll(ensureStateMachine2[i7].acceptedStartNames());
                    if (!ensureStateMachine2[i7].isSkippable()) {
                        break;
                    }
                }
            }
            z3 = z2;
        } else {
            SchemaParticle[] ensureStateMachine3 = ensureStateMachine(schemaParticleImpl.getParticleChildren());
            boolean z4 = true;
            for (int i8 = 0; z4 && i8 < ensureStateMachine3.length; i8++) {
                if (!((SchemaParticleImpl) ensureStateMachine3[i8]).isDeterministic()) {
                    z4 = false;
                }
            }
            z = z4;
            for (int i9 = 0; i9 < ensureStateMachine3.length; i9++) {
                if (z && !qNameSetBuilder.isDisjoint(ensureStateMachine3[i9].acceptedStartNames())) {
                    z = false;
                }
                qNameSetBuilder.addAll(ensureStateMachine3[i9].acceptedStartNames());
                qNameSetBuilder2.addAll(((SchemaParticleImpl) ensureStateMachine3[i9]).getExcludeNextSet());
            }
            qNameSetBuilder2.addAll(qNameSetBuilder);
            z3 = true;
        }
        BigInteger minOccurs = schemaParticleImpl.getMinOccurs();
        BigInteger maxOccurs = schemaParticleImpl.getMaxOccurs();
        boolean z5 = maxOccurs == null || maxOccurs.compareTo(BigInteger.ONE) > 0;
        boolean z6 = maxOccurs == null || minOccurs.compareTo(maxOccurs) < 0;
        if (z5 && z && !qNameSetBuilder2.isDisjoint(qNameSetBuilder)) {
            QNameSet intersect = qNameSetBuilder2.intersect(qNameSetBuilder);
            HashMap hashMap = new HashMap();
            particlesMatchingStart(schemaParticleImpl, intersect, hashMap, new QNameSetBuilder());
            HashMap hashMap2 = new HashMap();
            particlesMatchingAfter(schemaParticleImpl, intersect, hashMap2, new QNameSetBuilder(), true);
            z = afterMapSubsumedByStartMap(hashMap, hashMap2);
        }
        if (z6) {
            qNameSetBuilder2.addAll(qNameSetBuilder);
        }
        schemaParticleImpl.setTransitionRules(qNameSetBuilder.toQNameSet(), z3 || minOccurs.signum() == 0);
        schemaParticleImpl.setTransitionNotes(qNameSetBuilder2.toQNameSet(), z);
    }

    private static boolean afterMapSubsumedByStartMap(Map map, Map map2) {
        if (map2.size() > map.size()) {
            return false;
        }
        if (map2.isEmpty()) {
            return true;
        }
        for (SchemaParticle schemaParticle : map.keySet()) {
            if (schemaParticle.getParticleType() == 5 && map2.containsKey(schemaParticle) && !((QNameSet) map.get(schemaParticle)).containsAll((QNameSet) map2.get(schemaParticle))) {
                return false;
            }
            map2.remove(schemaParticle);
            if (map2.isEmpty()) {
                return true;
            }
        }
        return map2.isEmpty();
    }

    private static void particlesMatchingStart(SchemaParticle schemaParticle, QNameSetSpecification qNameSetSpecification, Map map, QNameSetBuilder qNameSetBuilder) {
        int particleType = schemaParticle.getParticleType();
        int i = 0;
        if (particleType == 1 || particleType == 2) {
            SchemaParticle[] particleChildren = schemaParticle.getParticleChildren();
            while (i < particleChildren.length) {
                particlesMatchingStart(particleChildren[i], qNameSetSpecification, map, qNameSetBuilder);
                i++;
            }
            return;
        }
        if (particleType != 3) {
            if (particleType == 4) {
                if (qNameSetSpecification.contains(schemaParticle.getName())) {
                    map.put(schemaParticle, null);
                    qNameSetBuilder.add(schemaParticle.getName());
                    return;
                }
                return;
            }
            if (particleType == 5 && !qNameSetSpecification.isDisjoint(schemaParticle.getWildcardSet())) {
                map.put(schemaParticle, schemaParticle.getWildcardSet().intersect(qNameSetSpecification));
                qNameSetBuilder.addAll(schemaParticle.getWildcardSet());
                return;
            }
            return;
        }
        SchemaParticle[] particleChildren2 = schemaParticle.getParticleChildren();
        if (particleChildren2.length == 0) {
            return;
        }
        if (!particleChildren2[0].isSkippable()) {
            particlesMatchingStart(particleChildren2[0], qNameSetSpecification, map, qNameSetBuilder);
            return;
        }
        QNameSetBuilder qNameSetBuilder2 = new QNameSetBuilder(qNameSetSpecification);
        QNameSetBuilder qNameSetBuilder3 = new QNameSetBuilder();
        while (i < particleChildren2.length) {
            particlesMatchingStart(particleChildren2[i], qNameSetBuilder2, map, qNameSetBuilder3);
            qNameSetBuilder.addAll(qNameSetBuilder3);
            if (!particleChildren2[i].isSkippable()) {
                return;
            }
            qNameSetBuilder2.removeAll(qNameSetBuilder3);
            if (qNameSetBuilder2.isEmpty()) {
                return;
            }
            qNameSetBuilder3.clear();
            i++;
        }
    }

    private static void particlesMatchingAfter(SchemaParticle schemaParticle, QNameSetSpecification qNameSetSpecification, Map map, QNameSetBuilder qNameSetBuilder, boolean z) {
        int particleType = schemaParticle.getParticleType();
        boolean z2 = true;
        if (particleType == 1 || particleType == 2) {
            for (SchemaParticle schemaParticle2 : schemaParticle.getParticleChildren()) {
                particlesMatchingAfter(schemaParticle2, qNameSetSpecification, map, qNameSetBuilder, false);
            }
        } else if (particleType == 3) {
            SchemaParticle[] particleChildren = schemaParticle.getParticleChildren();
            if (particleChildren.length != 0) {
                if (!particleChildren[particleChildren.length - 1].isSkippable()) {
                    particlesMatchingAfter(particleChildren[0], qNameSetSpecification, map, qNameSetBuilder, false);
                } else {
                    QNameSetBuilder qNameSetBuilder2 = new QNameSetBuilder(qNameSetSpecification);
                    QNameSetBuilder qNameSetBuilder3 = new QNameSetBuilder();
                    for (int length = particleChildren.length - 1; length >= 0; length--) {
                        particlesMatchingAfter(particleChildren[length], qNameSetBuilder2, map, qNameSetBuilder3, false);
                        qNameSetBuilder.addAll(qNameSetBuilder3);
                        if (!particleChildren[length].isSkippable()) {
                            break;
                        }
                        qNameSetBuilder2.removeAll(qNameSetBuilder3);
                        if (qNameSetBuilder2.isEmpty()) {
                            break;
                        }
                        qNameSetBuilder3.clear();
                    }
                }
            }
        }
        if (z) {
            return;
        }
        BigInteger minOccurs = schemaParticle.getMinOccurs();
        BigInteger maxOccurs = schemaParticle.getMaxOccurs();
        if (maxOccurs != null && minOccurs.compareTo(maxOccurs) >= 0) {
            z2 = false;
        }
        if (z2) {
            particlesMatchingStart(schemaParticle, qNameSetSpecification, map, qNameSetBuilder);
        }
    }

    private static class CodeForNameEntry {
        public int code;
        public QName name;

        CodeForNameEntry(QName qName, int i) {
            this.name = qName;
            this.code = i;
        }
    }

    private static Map buildParticleCodeMap() {
        HashMap hashMap = new HashMap();
        int i = 0;
        while (true) {
            CodeForNameEntry[] codeForNameEntryArr = particleCodes;
            if (i >= codeForNameEntryArr.length) {
                return hashMap;
            }
            hashMap.put(codeForNameEntryArr[i].name, new Integer(particleCodes[i].code));
            i++;
        }
    }

    private static int translateParticleCode(Group group) {
        if (group == null) {
            return 0;
        }
        return translateParticleCode(group.newCursor().getName());
    }

    private static int translateParticleCode(QName qName) {
        Integer num = (Integer) particleCodeMap.get(qName);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private static Map buildAttributeCodeMap() {
        HashMap hashMap = new HashMap();
        int i = 0;
        while (true) {
            CodeForNameEntry[] codeForNameEntryArr = attributeCodes;
            if (i >= codeForNameEntryArr.length) {
                return hashMap;
            }
            hashMap.put(codeForNameEntryArr[i].name, new Integer(attributeCodes[i].code));
            i++;
        }
    }

    static int translateAttributeCode(QName qName) {
        Integer num = (Integer) attributeCodeMap.get(qName);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }
}
