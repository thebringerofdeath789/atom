package org.apache.xmlbeans.impl.schema;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlByte;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.XmlShort;
import org.apache.xmlbeans.XmlUnsignedByte;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.regex.RegularExpression;
import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType;
import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument;

/* loaded from: classes5.dex */
public class StscSimpleTypeResolver {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final RegularExpression[] EMPTY_REGEX_ARRAY;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$schema$StscSimpleTypeResolver;
    private static final Map facetCodeMap;
    private static CodeForNameEntry[] facetCodes;

    static boolean isMultipleFacet(int i) {
        return i == 11 || i == 10;
    }

    static {
        if (class$org$apache$xmlbeans$impl$schema$StscSimpleTypeResolver == null) {
            class$org$apache$xmlbeans$impl$schema$StscSimpleTypeResolver = class$("org.apache.xmlbeans.impl.schema.StscSimpleTypeResolver");
        }
        $assertionsDisabled = true;
        EMPTY_REGEX_ARRAY = new RegularExpression[0];
        facetCodes = new CodeForNameEntry[]{new CodeForNameEntry(QNameHelper.forLNS(SessionDescription.ATTR_LENGTH, "http://www.w3.org/2001/XMLSchema"), 0), new CodeForNameEntry(QNameHelper.forLNS("minLength", "http://www.w3.org/2001/XMLSchema"), 1), new CodeForNameEntry(QNameHelper.forLNS("maxLength", "http://www.w3.org/2001/XMLSchema"), 2), new CodeForNameEntry(QNameHelper.forLNS("pattern", "http://www.w3.org/2001/XMLSchema"), 10), new CodeForNameEntry(QNameHelper.forLNS("enumeration", "http://www.w3.org/2001/XMLSchema"), 11), new CodeForNameEntry(QNameHelper.forLNS("whiteSpace", "http://www.w3.org/2001/XMLSchema"), 9), new CodeForNameEntry(QNameHelper.forLNS("maxInclusive", "http://www.w3.org/2001/XMLSchema"), 5), new CodeForNameEntry(QNameHelper.forLNS("maxExclusive", "http://www.w3.org/2001/XMLSchema"), 6), new CodeForNameEntry(QNameHelper.forLNS("minInclusive", "http://www.w3.org/2001/XMLSchema"), 4), new CodeForNameEntry(QNameHelper.forLNS("minExclusive", "http://www.w3.org/2001/XMLSchema"), 3), new CodeForNameEntry(QNameHelper.forLNS("totalDigits", "http://www.w3.org/2001/XMLSchema"), 7), new CodeForNameEntry(QNameHelper.forLNS("fractionDigits", "http://www.w3.org/2001/XMLSchema"), 8)};
        facetCodeMap = buildFacetCodeMap();
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void resolveSimpleType(org.apache.xmlbeans.impl.schema.SchemaTypeImpl r7) {
        /*
            org.apache.xmlbeans.XmlObject r0 = r7.getParseObject()
            org.apache.xmlbeans.impl.xb.xsdschema.SimpleType r0 = (org.apache.xmlbeans.impl.xb.xsdschema.SimpleType) r0
            boolean r1 = org.apache.xmlbeans.impl.schema.StscSimpleTypeResolver.$assertionsDisabled
            if (r1 != 0) goto L17
            boolean r1 = r7.isSimpleType()
            if (r1 == 0) goto L11
            goto L17
        L11:
            java.lang.AssertionError r7 = new java.lang.AssertionError
            r7.<init>()
            throw r7
        L17:
            org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument$Schema r1 = org.apache.xmlbeans.impl.schema.StscComplexTypeResolver.getSchema(r0)
            boolean r2 = r0.isSetList()
            boolean r3 = r0.isSetUnion()
            int r2 = r2 + r3
            boolean r3 = r0.isSetRestriction()
            int r2 = r2 + r3
            r3 = 52
            r4 = 1
            if (r2 <= r4) goto L38
            org.apache.xmlbeans.impl.schema.StscState r2 = org.apache.xmlbeans.impl.schema.StscState.get()
            java.lang.String r5 = "A simple type must define either a list, a union, or a restriction: more than one found."
            r2.error(r5, r3, r0)
            goto L47
        L38:
            if (r2 >= r4) goto L47
            org.apache.xmlbeans.impl.schema.StscState r1 = org.apache.xmlbeans.impl.schema.StscState.get()
            java.lang.String r2 = "A simple type must define either a list, a union, or a restriction: none was found."
            r1.error(r2, r3, r0)
            resolveErrorSimpleType(r7)
            return
        L47:
            r2 = 0
            boolean r3 = r0.isSetFinal()
            if (r3 == 0) goto L53
            java.lang.Object r2 = r0.getFinal()
            goto L5f
        L53:
            if (r1 == 0) goto L5f
            boolean r3 = r1.isSetFinalDefault()
            if (r3 == 0) goto L5f
            java.lang.Object r2 = r1.getFinalDefault()
        L5f:
            r1 = 0
            if (r2 == 0) goto L90
            boolean r3 = r2 instanceof java.lang.String
            if (r3 == 0) goto L73
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = "#all"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L90
            r1 = r4
            r5 = r1
            goto L92
        L73:
            boolean r3 = r2 instanceof java.util.List
            if (r3 == 0) goto L90
            java.util.List r2 = (java.util.List) r2
            java.lang.String r3 = "restriction"
            boolean r3 = r2.contains(r3)
            java.lang.String r5 = "list"
            boolean r5 = r2.contains(r5)
            java.lang.String r6 = "union"
            boolean r2 = r2.contains(r6)
            if (r2 == 0) goto L8e
            r1 = r4
        L8e:
            r4 = r3
            goto L92
        L90:
            r4 = r1
            r5 = r4
        L92:
            r7.setSimpleFinal(r4, r5, r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            org.apache.xmlbeans.impl.xb.xsdschema.ListDocument$List r2 = r0.getList()
            if (r2 == 0) goto La8
            org.apache.xmlbeans.impl.xb.xsdschema.ListDocument$List r0 = r0.getList()
            resolveListType(r7, r0, r1)
            goto Lc3
        La8:
            org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument$Union r2 = r0.getUnion()
            if (r2 == 0) goto Lb6
            org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument$Union r0 = r0.getUnion()
            resolveUnionType(r7, r0, r1)
            goto Lc3
        Lb6:
            org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument$Restriction r2 = r0.getRestriction()
            if (r2 == 0) goto Lc3
            org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument$Restriction r0 = r0.getRestriction()
            resolveSimpleRestrictionType(r7, r0, r1)
        Lc3:
            org.apache.xmlbeans.SchemaType$Ref[] r0 = makeRefArray(r1)
            r7.setAnonymousTypeRefs(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.schema.StscSimpleTypeResolver.resolveSimpleType(org.apache.xmlbeans.impl.schema.SchemaTypeImpl):void");
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

    static void resolveErrorSimpleType(SchemaTypeImpl schemaTypeImpl) {
        schemaTypeImpl.setSimpleTypeVariety(1);
        schemaTypeImpl.setBaseTypeRef(BuiltinSchemaTypeSystem.ST_ANY_SIMPLE.getRef());
        schemaTypeImpl.setBaseDepth(BuiltinSchemaTypeSystem.ST_ANY_SIMPLE.getBaseDepth() + 1);
        schemaTypeImpl.setPrimitiveTypeRef(BuiltinSchemaTypeSystem.ST_ANY_SIMPLE.getRef());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [org.apache.xmlbeans.impl.xb.xsdschema.SimpleType] */
    static void resolveListType(SchemaTypeImpl schemaTypeImpl, ListDocument.List list, List list2) {
        XmlQName xmlQName;
        SchemaTypeImpl translateAnonymousSimpleType;
        SchemaTypeImpl schemaTypeImpl2;
        StscState stscState = StscState.get();
        schemaTypeImpl.setSimpleTypeVariety(3);
        schemaTypeImpl.setBaseTypeRef(BuiltinSchemaTypeSystem.ST_ANY_SIMPLE.getRef());
        schemaTypeImpl.setBaseDepth(BuiltinSchemaTypeSystem.ST_ANY_SIMPLE.getBaseDepth() + 1);
        schemaTypeImpl.setDerivationType(1);
        if (schemaTypeImpl.isRedefinition()) {
            stscState.error(XmlErrorCodes.SCHEMA_REDEFINE$EXTEND_OR_RESTRICT, new Object[]{XmlErrorCodes.LIST}, list);
        }
        QName itemType = list.getItemType();
        LocalSimpleType simpleType = list.getSimpleType();
        if (itemType == null || simpleType == null) {
            xmlQName = simpleType;
        } else {
            stscState.error(XmlErrorCodes.SCHEMA_SIMPLE_TYPE$LIST_HAS_BOTH_ITEM_OR_SIMPLE_TYPE, (Object[]) null, list);
            xmlQName = null;
        }
        if (itemType != null) {
            translateAnonymousSimpleType = stscState.findGlobalType(itemType, schemaTypeImpl.getChameleonNamespace(), schemaTypeImpl.getTargetNamespace());
            xmlQName = list.xgetItemType();
            if (translateAnonymousSimpleType == null) {
                stscState.notFoundError(itemType, 0, list.xgetItemType(), true);
                translateAnonymousSimpleType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
            }
        } else if (xmlQName != null) {
            translateAnonymousSimpleType = StscTranslator.translateAnonymousSimpleType(xmlQName, schemaTypeImpl.getTargetNamespace(), schemaTypeImpl.getChameleonNamespace() != null, schemaTypeImpl.getElemFormDefault(), schemaTypeImpl.getAttFormDefault(), list2, schemaTypeImpl);
        } else {
            stscState.error(XmlErrorCodes.SCHEMA_SIMPLE_TYPE$LIST_HAS_NEITHER_ITEM_OR_SIMPLE_TYPE, (Object[]) null, list);
            resolveErrorSimpleType(schemaTypeImpl);
            return;
        }
        if (translateAnonymousSimpleType.finalList()) {
            stscState.error(XmlErrorCodes.SIMPLE_TYPE_PROPERTIES$LIST_FINAL, (Object[]) null, list);
        }
        StscResolver.resolveType(translateAnonymousSimpleType);
        if (translateAnonymousSimpleType.isSimpleType()) {
            schemaTypeImpl2 = schemaTypeImpl;
        } else {
            stscState.error(XmlErrorCodes.SIMPLE_TYPE_RESTRICTION$LIST_ITEM_NOT_SIMPLE, (Object[]) null, xmlQName);
            schemaTypeImpl2 = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        }
        int simpleVariety = translateAnonymousSimpleType.getSimpleVariety();
        if (simpleVariety != 1) {
            if (simpleVariety != 2) {
                if (simpleVariety == 3) {
                    stscState.error(XmlErrorCodes.SIMPLE_TYPE_RESTRICTION$LIST_ITEM_IS_LIST, (Object[]) null, xmlQName);
                    resolveErrorSimpleType(schemaTypeImpl2);
                    return;
                } else {
                    if (!$assertionsDisabled) {
                        throw new AssertionError();
                    }
                    schemaTypeImpl2.setListItemTypeRef(BuiltinSchemaTypeSystem.ST_ANY_SIMPLE.getRef());
                    schemaTypeImpl2.setBasicFacets(StscState.FACETS_LIST, StscState.FIXED_FACETS_LIST);
                    schemaTypeImpl2.setWhiteSpaceRule(3);
                    resolveFundamentalFacets(schemaTypeImpl2);
                }
            }
            if (translateAnonymousSimpleType.isUnionOfLists()) {
                stscState.error(XmlErrorCodes.SIMPLE_TYPE_RESTRICTION$LIST_ITEM_IS_UNION_OF_LIST, (Object[]) null, xmlQName);
                resolveErrorSimpleType(schemaTypeImpl2);
                return;
            }
        }
        schemaTypeImpl2.setListItemTypeRef(translateAnonymousSimpleType.getRef());
        if (schemaTypeImpl2.getBuiltinTypeCode() == 8) {
            stscState.recover(XmlErrorCodes.DATATYPE_ENUM_NOTATION, null, xmlQName);
        }
        schemaTypeImpl2.setBasicFacets(StscState.FACETS_LIST, StscState.FIXED_FACETS_LIST);
        schemaTypeImpl2.setWhiteSpaceRule(3);
        resolveFundamentalFacets(schemaTypeImpl2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [org.apache.xmlbeans.XmlObject] */
    static void resolveUnionType(SchemaTypeImpl schemaTypeImpl, UnionDocument.Union union, List list) {
        String stringBuffer;
        UnionDocument.Union.MemberTypes xgetMemberTypes;
        XmlObject xgetMemberTypes2;
        schemaTypeImpl.setSimpleTypeVariety(2);
        schemaTypeImpl.setBaseTypeRef(BuiltinSchemaTypeSystem.ST_ANY_SIMPLE.getRef());
        schemaTypeImpl.setBaseDepth(BuiltinSchemaTypeSystem.ST_ANY_SIMPLE.getBaseDepth() + 1);
        schemaTypeImpl.setDerivationType(1);
        StscState stscState = StscState.get();
        if (schemaTypeImpl.isRedefinition()) {
            stscState.error(XmlErrorCodes.SCHEMA_REDEFINE$EXTEND_OR_RESTRICT, new Object[]{XmlErrorCodes.UNION}, union);
        }
        List<QName> memberTypes = union.getMemberTypes();
        LocalSimpleType[] simpleTypeArray = union.getSimpleTypeArray();
        ArrayList arrayList = new ArrayList();
        if (simpleTypeArray.length == 0 && (memberTypes == null || memberTypes.size() == 0)) {
            stscState.error(XmlErrorCodes.SCHEMA_SIMPLE_TYPE$UNION_HAS_MEMBER_TYPES_OR_SIMPLE_TYPES, (Object[]) null, union);
        }
        if (memberTypes != null) {
            for (QName qName : memberTypes) {
                SchemaTypeImpl findGlobalType = stscState.findGlobalType(qName, schemaTypeImpl.getChameleonNamespace(), schemaTypeImpl.getTargetNamespace());
                if (findGlobalType == null) {
                    stscState.notFoundError(qName, 0, union.xgetMemberTypes(), true);
                } else {
                    arrayList.add(findGlobalType);
                }
            }
        }
        int i = 0;
        while (i < simpleTypeArray.length) {
            SchemaTypeImpl translateAnonymousSimpleType = StscTranslator.translateAnonymousSimpleType(simpleTypeArray[i], schemaTypeImpl.getTargetNamespace(), schemaTypeImpl.getChameleonNamespace() != null, schemaTypeImpl.getElemFormDefault(), schemaTypeImpl.getAttFormDefault(), list, schemaTypeImpl);
            arrayList.add(translateAnonymousSimpleType);
            i++;
            translateAnonymousSimpleType.setAnonymousUnionMemberOrdinal(i);
        }
        Iterator it = arrayList.iterator();
        while (true) {
            String str = "";
            if (!it.hasNext()) {
                break;
            }
            SchemaTypeImpl schemaTypeImpl2 = (SchemaTypeImpl) it.next();
            if (!StscResolver.resolveType(schemaTypeImpl2)) {
                if (schemaTypeImpl2.getOuterType().equals(schemaTypeImpl)) {
                    xgetMemberTypes2 = schemaTypeImpl2.getParseObject();
                } else {
                    str = new StringBuffer().append(QNameHelper.pretty(schemaTypeImpl2.getName())).append(StringUtils.SPACE).toString();
                    xgetMemberTypes2 = union.xgetMemberTypes();
                }
                stscState.error(XmlErrorCodes.SCHEMA_SIMPLE_TYPE$CYCLIC_UNION, new Object[]{str}, xgetMemberTypes2);
                it.remove();
            }
        }
        Iterator it2 = arrayList.iterator();
        boolean z = false;
        while (it2.hasNext()) {
            SchemaTypeImpl schemaTypeImpl3 = (SchemaTypeImpl) it2.next();
            if (!schemaTypeImpl3.isSimpleType()) {
                if (schemaTypeImpl3.getOuterType() != null && schemaTypeImpl3.getOuterType().equals(schemaTypeImpl)) {
                    xgetMemberTypes = schemaTypeImpl3.getParseObject();
                    stringBuffer = "";
                } else {
                    stringBuffer = new StringBuffer().append(QNameHelper.pretty(schemaTypeImpl3.getName())).append(StringUtils.SPACE).toString();
                    xgetMemberTypes = union.xgetMemberTypes();
                }
                stscState.error(XmlErrorCodes.SIMPLE_TYPE_RESTRICTION$UNION_MEMBER_NOT_SIMPLE, new Object[]{stringBuffer}, xgetMemberTypes);
                it2.remove();
            } else if (schemaTypeImpl3.getSimpleVariety() == 3 || (schemaTypeImpl3.getSimpleVariety() == 2 && schemaTypeImpl3.isUnionOfLists())) {
                z = true;
            }
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (((SchemaTypeImpl) arrayList.get(i2)).finalUnion()) {
                stscState.error(XmlErrorCodes.SIMPLE_TYPE_PROPERTIES$UNION_FINAL, (Object[]) null, union);
            }
        }
        schemaTypeImpl.setUnionOfLists(z);
        schemaTypeImpl.setUnionMemberTypeRefs(makeRefArray(arrayList));
        schemaTypeImpl.setBasicFacets(StscState.FACETS_UNION, StscState.FIXED_FACETS_UNION);
        resolveFundamentalFacets(schemaTypeImpl);
    }

    static void resolveSimpleRestrictionType(SchemaTypeImpl schemaTypeImpl, RestrictionDocument.Restriction restriction, List list) {
        LocalSimpleType localSimpleType;
        SchemaTypeImpl schemaTypeImpl2;
        QName base = restriction.getBase();
        LocalSimpleType simpleType = restriction.getSimpleType();
        StscState stscState = StscState.get();
        if (base == null || simpleType == null) {
            localSimpleType = simpleType;
        } else {
            stscState.error(XmlErrorCodes.SCHEMA_SIMPLE_TYPE$RESTRICTION_HAS_BOTH_BASE_OR_SIMPLE_TYPE, (Object[]) null, restriction);
            localSimpleType = null;
        }
        if (base != null) {
            if (schemaTypeImpl.isRedefinition()) {
                schemaTypeImpl2 = stscState.findRedefinedGlobalType(restriction.getBase(), schemaTypeImpl.getChameleonNamespace(), schemaTypeImpl);
                if (schemaTypeImpl2 != null && !schemaTypeImpl2.getName().equals(schemaTypeImpl.getName())) {
                    stscState.error(XmlErrorCodes.SCHEMA_REDEFINE$SAME_TYPE, new Object[]{"<simpleType>", QNameHelper.pretty(base), QNameHelper.pretty(schemaTypeImpl.getName())}, restriction);
                }
            } else {
                schemaTypeImpl2 = stscState.findGlobalType(base, schemaTypeImpl.getChameleonNamespace(), schemaTypeImpl.getTargetNamespace());
            }
            if (schemaTypeImpl2 == null) {
                stscState.notFoundError(base, 0, restriction.xgetBase(), true);
                schemaTypeImpl2 = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
            }
        } else if (localSimpleType != null) {
            if (schemaTypeImpl.isRedefinition()) {
                StscState.get().error(XmlErrorCodes.SCHEMA_REDEFINE$EXTEND_OR_RESTRICT, new Object[]{"<simpleType>"}, localSimpleType);
            }
            schemaTypeImpl2 = StscTranslator.translateAnonymousSimpleType(localSimpleType, schemaTypeImpl.getTargetNamespace(), schemaTypeImpl.getChameleonNamespace() != null, schemaTypeImpl.getElemFormDefault(), schemaTypeImpl.getAttFormDefault(), list, schemaTypeImpl);
        } else {
            stscState.error(XmlErrorCodes.SCHEMA_SIMPLE_TYPE$RESTRICTION_HAS_NEITHER_BASE_OR_SIMPLE_TYPE, (Object[]) null, restriction);
            schemaTypeImpl2 = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        }
        if (!StscResolver.resolveType(schemaTypeImpl2)) {
            schemaTypeImpl2 = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        }
        if (schemaTypeImpl2.finalRestriction()) {
            stscState.error(XmlErrorCodes.SIMPLE_TYPE_PROPERTIES$RESTRICTION_FINAL, (Object[]) null, restriction);
        }
        schemaTypeImpl.setBaseTypeRef(schemaTypeImpl2.getRef());
        schemaTypeImpl.setBaseDepth(schemaTypeImpl2.getBaseDepth() + 1);
        schemaTypeImpl.setDerivationType(1);
        if (!schemaTypeImpl2.isSimpleType()) {
            stscState.error(XmlErrorCodes.SIMPLE_TYPE_RESTRICTION$ATOMIC_NOT_SIMPLE, (Object[]) null, restriction.xgetBase());
            resolveErrorSimpleType(schemaTypeImpl);
            return;
        }
        schemaTypeImpl.setSimpleTypeVariety(schemaTypeImpl2.getSimpleVariety());
        int simpleVariety = schemaTypeImpl2.getSimpleVariety();
        if (simpleVariety == 1) {
            schemaTypeImpl.setPrimitiveTypeRef(schemaTypeImpl2.getPrimitiveType().getRef());
        } else if (simpleVariety == 2) {
            schemaTypeImpl.setUnionOfLists(schemaTypeImpl2.isUnionOfLists());
            schemaTypeImpl.setUnionMemberTypeRefs(makeRefArray(Arrays.asList(schemaTypeImpl2.getUnionMemberTypes())));
        } else if (simpleVariety == 3) {
            schemaTypeImpl.setListItemTypeRef(schemaTypeImpl2.getListItemType().getRef());
        }
        resolveFacets(schemaTypeImpl, restriction, schemaTypeImpl2);
        resolveFundamentalFacets(schemaTypeImpl);
    }

    static int translateWhitespaceCode(XmlAnySimpleType xmlAnySimpleType) {
        String stringValue = xmlAnySimpleType.getStringValue();
        if (stringValue.equals("collapse")) {
            return 3;
        }
        if (stringValue.equals("preserve")) {
            return 1;
        }
        if (stringValue.equals("replace")) {
            return 2;
        }
        StscState.get().error(new StringBuffer().append("Unrecognized whitespace value \"").append(stringValue).append("\"").toString(), 20, xmlAnySimpleType);
        return 0;
    }

    static boolean facetAppliesToType(int i, SchemaTypeImpl schemaTypeImpl) {
        int simpleVariety = schemaTypeImpl.getSimpleVariety();
        if (simpleVariety == 2) {
            return i == 10 || i == 11;
        }
        if (simpleVariety == 3) {
            if (i != 0 && i != 1 && i != 2) {
                switch (i) {
                    case 9:
                    case 10:
                    case 11:
                        break;
                    default:
                        return false;
                }
            }
            return true;
        }
        switch (schemaTypeImpl.getPrimitiveType().getBuiltinTypeCode()) {
            case 2:
                return false;
            case 3:
                return i == 9 || i == 10;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 12:
                if (i != 0 && i != 1 && i != 2) {
                    switch (i) {
                        case 9:
                        case 10:
                        case 11:
                            break;
                        default:
                            return false;
                    }
                }
                return true;
            case 9:
            case 10:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                switch (i) {
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 9:
                    case 10:
                    case 11:
                        return true;
                    case 7:
                    case 8:
                    default:
                        return false;
                }
            case 11:
                switch (i) {
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                        return true;
                    default:
                        return false;
                }
            default:
                if ($assertionsDisabled) {
                    return false;
                }
                throw new AssertionError();
        }
    }

    private static int other_similar_limit(int i) {
        if (i == 3) {
            return 4;
        }
        if (i == 4) {
            return 3;
        }
        if (i == 5) {
            return 6;
        }
        if (i == 6) {
            return 5;
        }
        if ($assertionsDisabled) {
            throw new IllegalStateException();
        }
        throw new AssertionError();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x024d, code lost:
    
        if (r10 == r13) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0077, code lost:
    
        if (r9 == 2) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x0409, code lost:
    
        if (r23.getBaseType() != r0) goto L227;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x03bd A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r0v46, types: [org.apache.xmlbeans.XmlObject] */
    /* JADX WARN: Type inference failed for: r0v49, types: [org.apache.xmlbeans.XmlObject] */
    /* JADX WARN: Type inference failed for: r0v76, types: [org.apache.xmlbeans.XmlObject, org.apache.xmlbeans.XmlPositiveInteger] */
    /* JADX WARN: Type inference failed for: r0v80, types: [org.apache.xmlbeans.XmlNonNegativeInteger, org.apache.xmlbeans.XmlObject] */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v19, types: [org.apache.xmlbeans.XmlObject] */
    /* JADX WARN: Type inference failed for: r10v22, types: [org.apache.xmlbeans.XmlAnySimpleType] */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v27, types: [org.apache.xmlbeans.XmlAnySimpleType] */
    /* JADX WARN: Type inference failed for: r10v37 */
    /* JADX WARN: Type inference failed for: r10v40, types: [org.apache.xmlbeans.XmlObject] */
    /* JADX WARN: Type inference failed for: r10v44 */
    /* JADX WARN: Type inference failed for: r10v45, types: [org.apache.xmlbeans.XmlObject] */
    /* JADX WARN: Type inference failed for: r10v49 */
    /* JADX WARN: Type inference failed for: r10v50, types: [org.apache.xmlbeans.XmlObject] */
    /* JADX WARN: Type inference failed for: r11v10, types: [org.apache.xmlbeans.XmlAnySimpleType] */
    /* JADX WARN: Type inference failed for: r11v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v24, types: [org.apache.xmlbeans.XmlAnySimpleType, org.apache.xmlbeans.XmlObject] */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v26, types: [org.apache.xmlbeans.XmlAnySimpleType] */
    /* JADX WARN: Type inference failed for: r11v31, types: [org.apache.xmlbeans.XmlAnySimpleType] */
    /* JADX WARN: Type inference failed for: r11v35 */
    /* JADX WARN: Type inference failed for: r11v38, types: [org.apache.xmlbeans.XmlObject] */
    /* JADX WARN: Type inference failed for: r11v40, types: [org.apache.xmlbeans.XmlAnySimpleType] */
    /* JADX WARN: Type inference failed for: r11v50 */
    /* JADX WARN: Type inference failed for: r11v51 */
    /* JADX WARN: Type inference failed for: r11v52 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8, types: [org.apache.xmlbeans.XmlAnySimpleType] */
    /* JADX WARN: Type inference failed for: r13v13, types: [org.apache.xmlbeans.XmlInteger, org.apache.xmlbeans.XmlNonNegativeInteger, org.apache.xmlbeans.XmlObject] */
    /* JADX WARN: Type inference failed for: r13v23, types: [org.apache.xmlbeans.XmlAnySimpleType] */
    /* JADX WARN: Type inference failed for: r13v8, types: [org.apache.xmlbeans.XmlObject] */
    /* JADX WARN: Type inference failed for: r5v14, types: [org.apache.xmlbeans.XmlAnySimpleType] */
    /* JADX WARN: Type inference failed for: r6v0, types: [org.apache.xmlbeans.XmlAnySimpleType[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void resolveFacets(org.apache.xmlbeans.impl.schema.SchemaTypeImpl r23, org.apache.xmlbeans.XmlObject r24, org.apache.xmlbeans.impl.schema.SchemaTypeImpl r25) {
        /*
            Method dump skipped, instructions count: 1150
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.schema.StscSimpleTypeResolver.resolveFacets(org.apache.xmlbeans.impl.schema.SchemaTypeImpl, org.apache.xmlbeans.XmlObject, org.apache.xmlbeans.impl.schema.SchemaTypeImpl):void");
    }

    private static XmlValueRef[] makeValueRefArray(XmlAnySimpleType[] xmlAnySimpleTypeArr) {
        int length = xmlAnySimpleTypeArr.length;
        XmlValueRef[] xmlValueRefArr = new XmlValueRef[length];
        for (int i = 0; i < length; i++) {
            xmlValueRefArr[i] = xmlAnySimpleTypeArr[i] == null ? null : new XmlValueRef(xmlAnySimpleTypeArr[i]);
        }
        return xmlValueRefArr;
    }

    private static boolean isDiscreteType(SchemaTypeImpl schemaTypeImpl) {
        int builtinTypeCode;
        if (schemaTypeImpl.getFacet(8) == null && (builtinTypeCode = schemaTypeImpl.getPrimitiveType().getBuiltinTypeCode()) != 3) {
            switch (builtinTypeCode) {
            }
            return true;
        }
        return true;
    }

    private static boolean isNumericPrimitive(SchemaType schemaType) {
        switch (schemaType.getBuiltinTypeCode()) {
            case 9:
            case 10:
            case 11:
                return true;
            default:
                return false;
        }
    }

    private static int decimalSizeOfType(SchemaTypeImpl schemaTypeImpl) {
        int mathematicalSizeOfType = mathematicalSizeOfType(schemaTypeImpl);
        if (mathematicalSizeOfType == 8 && !XmlByte.type.isAssignableFrom(schemaTypeImpl)) {
            mathematicalSizeOfType = 16;
        }
        if (mathematicalSizeOfType != 16 || XmlShort.type.isAssignableFrom(schemaTypeImpl) || XmlUnsignedByte.type.isAssignableFrom(schemaTypeImpl)) {
            return mathematicalSizeOfType;
        }
        return 32;
    }

    private static int mathematicalSizeOfType(SchemaTypeImpl schemaTypeImpl) {
        BigInteger valueOf;
        if (schemaTypeImpl.getPrimitiveType().getBuiltinTypeCode() != 11) {
            return 0;
        }
        if (schemaTypeImpl.getFacet(8) == null || ((SimpleValue) schemaTypeImpl.getFacet(8)).getBigIntegerValue().signum() != 0) {
            return SchemaType.SIZE_BIG_DECIMAL;
        }
        BigInteger bigInteger = null;
        BigInteger bigIntegerValue = schemaTypeImpl.getFacet(3) != null ? ((SimpleValue) schemaTypeImpl.getFacet(3)).getBigIntegerValue() : null;
        if (schemaTypeImpl.getFacet(4) != null) {
            bigIntegerValue = ((SimpleValue) schemaTypeImpl.getFacet(4)).getBigIntegerValue();
        }
        BigInteger bigIntegerValue2 = schemaTypeImpl.getFacet(5) != null ? ((SimpleValue) schemaTypeImpl.getFacet(5)).getBigIntegerValue() : null;
        if (schemaTypeImpl.getFacet(6) != null) {
            bigIntegerValue2 = ((SimpleValue) schemaTypeImpl.getFacet(6)).getBigIntegerValue();
        }
        if (schemaTypeImpl.getFacet(7) != null) {
            try {
                switch (((SimpleValue) schemaTypeImpl.getFacet(7)).getBigIntegerValue().intValue()) {
                    case 0:
                    case 1:
                    case 2:
                        valueOf = BigInteger.valueOf(99L);
                        bigInteger = valueOf;
                        break;
                    case 3:
                    case 4:
                        valueOf = BigInteger.valueOf(9999L);
                        bigInteger = valueOf;
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        valueOf = BigInteger.valueOf(999999999L);
                        bigInteger = valueOf;
                        break;
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                        valueOf = BigInteger.valueOf(999999999999999999L);
                        bigInteger = valueOf;
                        break;
                }
            } catch (XmlValueOutOfRangeException unused) {
            }
            if (bigInteger != null) {
                BigInteger negate = bigInteger.negate();
                if (bigIntegerValue != null) {
                    negate = bigIntegerValue.max(negate);
                }
                bigIntegerValue = negate;
                bigIntegerValue2 = bigIntegerValue2 == null ? bigInteger : bigIntegerValue2.min(bigInteger);
            }
        }
        if (bigIntegerValue == null || bigIntegerValue2 == null) {
            return SchemaType.SIZE_BIG_INTEGER;
        }
        if (bigIntegerValue.signum() < 0) {
            bigIntegerValue = bigIntegerValue.negate().subtract(BigInteger.ONE);
        }
        if (bigIntegerValue2.signum() < 0) {
            bigIntegerValue2 = bigIntegerValue2.negate().subtract(BigInteger.ONE);
        }
        BigInteger max = bigIntegerValue2.max(bigIntegerValue);
        if (max.compareTo(BigInteger.valueOf(127L)) <= 0) {
            return 8;
        }
        if (max.compareTo(BigInteger.valueOf(32767L)) <= 0) {
            return 16;
        }
        if (max.compareTo(BigInteger.valueOf(2147483647L)) <= 0) {
            return 32;
        }
        if (max.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) <= 0) {
            return 64;
        }
        return SchemaType.SIZE_BIG_INTEGER;
    }

    static void resolveFundamentalFacets(SchemaTypeImpl schemaTypeImpl) {
        int simpleVariety = schemaTypeImpl.getSimpleVariety();
        if (simpleVariety == 1) {
            SchemaTypeImpl schemaTypeImpl2 = (SchemaTypeImpl) schemaTypeImpl.getBaseType();
            schemaTypeImpl.setOrdered(schemaTypeImpl2.ordered());
            schemaTypeImpl.setBounded(((schemaTypeImpl.getFacet(3) == null && schemaTypeImpl.getFacet(4) == null) || (schemaTypeImpl.getFacet(5) == null && schemaTypeImpl.getFacet(6) == null)) ? false : true);
            schemaTypeImpl.setFinite(schemaTypeImpl2.isFinite() || (schemaTypeImpl.isBounded() && isDiscreteType(schemaTypeImpl)));
            if (!schemaTypeImpl2.isNumeric() && !isNumericPrimitive(schemaTypeImpl.getPrimitiveType())) {
                r2 = false;
            }
            schemaTypeImpl.setNumeric(r2);
            schemaTypeImpl.setDecimalSize(decimalSizeOfType(schemaTypeImpl));
            return;
        }
        if (simpleVariety != 2) {
            if (simpleVariety != 3) {
                return;
            }
            schemaTypeImpl.setOrdered(0);
            schemaTypeImpl.setBounded((schemaTypeImpl.getFacet(0) == null && schemaTypeImpl.getFacet(2) == null) ? false : true);
            schemaTypeImpl.setFinite(schemaTypeImpl.getListItemType().isFinite() && schemaTypeImpl.isBounded());
            schemaTypeImpl.setNumeric(false);
            schemaTypeImpl.setDecimalSize(0);
            return;
        }
        SchemaType[] unionMemberTypes = schemaTypeImpl.getUnionMemberTypes();
        boolean z = true;
        boolean z2 = true;
        boolean z3 = true;
        int i = 0;
        for (int i2 = 0; i2 < unionMemberTypes.length; i2++) {
            if (unionMemberTypes[i2].ordered() != 0) {
                i = 1;
            }
            if (!unionMemberTypes[i2].isBounded()) {
                z = false;
            }
            if (!unionMemberTypes[i2].isFinite()) {
                z2 = false;
            }
            if (!unionMemberTypes[i2].isNumeric()) {
                z3 = false;
            }
        }
        schemaTypeImpl.setOrdered(i);
        schemaTypeImpl.setBounded(z);
        schemaTypeImpl.setFinite(z2);
        schemaTypeImpl.setNumeric(z3);
        schemaTypeImpl.setDecimalSize(0);
    }

    private static class CodeForNameEntry {
        public int code;
        public QName name;

        CodeForNameEntry(QName qName, int i) {
            this.name = qName;
            this.code = i;
        }
    }

    private static Map buildFacetCodeMap() {
        HashMap hashMap = new HashMap();
        int i = 0;
        while (true) {
            CodeForNameEntry[] codeForNameEntryArr = facetCodes;
            if (i >= codeForNameEntryArr.length) {
                return hashMap;
            }
            hashMap.put(codeForNameEntryArr[i].name, new Integer(facetCodes[i].code));
            i++;
        }
    }

    private static int translateFacetCode(QName qName) {
        Integer num = (Integer) facetCodeMap.get(qName);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }
}
