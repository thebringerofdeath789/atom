package org.apache.xmlbeans.impl.schema;

import aavax.xml.namespace.QName;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.XBeanDebug;

/* loaded from: classes5.dex */
public class StscChecker {
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$schema$StscChecker;

    static {
        if (class$org$apache$xmlbeans$impl$schema$StscChecker == null) {
            class$org$apache$xmlbeans$impl$schema$StscChecker = class$("org.apache.xmlbeans.impl.schema.StscChecker");
        }
        $assertionsDisabled = true;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static void checkAll() {
        StscState stscState = StscState.get();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(stscState.documentTypes()));
        arrayList.addAll(Arrays.asList(stscState.attributeTypes()));
        arrayList.addAll(Arrays.asList(stscState.redefinedGlobalTypes()));
        arrayList.addAll(Arrays.asList(stscState.globalTypes()));
        for (int i = 0; i < arrayList.size(); i++) {
            SchemaType schemaType = (SchemaType) arrayList.get(i);
            if (!stscState.noPvr() && !schemaType.isDocumentType()) {
                checkRestriction((SchemaTypeImpl) schemaType);
            }
            checkFields((SchemaTypeImpl) schemaType);
            arrayList.addAll(Arrays.asList(schemaType.getAnonymousTypes()));
        }
        checkSubstitutionGroups(stscState.globalElements());
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00fc, code lost:
    
        if (r1[r4].getName().getNamespaceURI().length() > 0) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00fe, code lost:
    
        r7 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void checkFields(org.apache.xmlbeans.impl.schema.SchemaTypeImpl r15) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.schema.StscChecker.checkFields(org.apache.xmlbeans.impl.schema.SchemaTypeImpl):void");
    }

    private static void checkElementDefaults(SchemaParticle schemaParticle, XmlObject xmlObject, SchemaType schemaType) {
        String str;
        if (schemaParticle == null) {
            return;
        }
        int particleType = schemaParticle.getParticleType();
        if (particleType == 1 || particleType == 2 || particleType == 3) {
            for (SchemaParticle schemaParticle2 : schemaParticle.getParticleChildren()) {
                checkElementDefaults(schemaParticle2, xmlObject, schemaType);
            }
            return;
        }
        if (particleType != 4) {
            return;
        }
        String defaultText = schemaParticle.getDefaultText();
        if (defaultText != null) {
            if (schemaParticle.getType().isSimpleType() || schemaParticle.getType().getContentType() == 2) {
                try {
                    XmlAnySimpleType defaultValue = schemaParticle.getDefaultValue();
                    XmlOptions xmlOptions = new XmlOptions();
                    xmlOptions.put(XmlOptions.VALIDATE_TEXT_ONLY);
                    if (!defaultValue.validate(xmlOptions)) {
                        throw new Exception();
                    }
                    SchemaPropertyImpl schemaPropertyImpl = (SchemaPropertyImpl) schemaType.getElementProperty(schemaParticle.getName());
                    if (schemaPropertyImpl != null && schemaPropertyImpl.getDefaultText() != null) {
                        schemaPropertyImpl.setDefaultValue(new XmlValueRef(defaultValue));
                    }
                } catch (Exception unused) {
                    str = schemaParticle.isFixed() ? "fixed" : "default";
                    XmlObject selectAttribute = xmlObject.selectAttribute("", str);
                    StscState stscState = StscState.get();
                    Object[] objArr = {QNameHelper.pretty(schemaParticle.getName()), str, defaultText, QNameHelper.pretty(schemaParticle.getType().getName())};
                    if (selectAttribute == null) {
                        selectAttribute = xmlObject;
                    }
                    stscState.error(XmlErrorCodes.ELEM_PROPERTIES$CONSTRAINT_VALID, objArr, selectAttribute);
                }
            } else if (schemaParticle.getType().getContentType() == 4) {
                if (!schemaParticle.getType().getContentModel().isSkippable()) {
                    str = schemaParticle.isFixed() ? "fixed" : "default";
                    XmlObject selectAttribute2 = xmlObject.selectAttribute("", str);
                    StscState stscState2 = StscState.get();
                    Object[] objArr2 = {QNameHelper.pretty(schemaParticle.getName()), str, defaultText};
                    if (selectAttribute2 == null) {
                        selectAttribute2 = xmlObject;
                    }
                    stscState2.error(XmlErrorCodes.ELEM_DEFAULT_VALID$MIXED_AND_EMPTIABLE, objArr2, selectAttribute2);
                } else {
                    SchemaPropertyImpl schemaPropertyImpl2 = (SchemaPropertyImpl) schemaType.getElementProperty(schemaParticle.getName());
                    if (schemaPropertyImpl2 != null && schemaPropertyImpl2.getDefaultText() != null) {
                        schemaPropertyImpl2.setDefaultValue(new XmlValueRef(XmlString.type.newValue(defaultText)));
                    }
                }
            } else if (schemaParticle.getType().getContentType() == 3) {
                XmlObject selectAttribute3 = xmlObject.selectAttribute("", "default");
                StscState stscState3 = StscState.get();
                Object[] objArr3 = {QNameHelper.pretty(schemaParticle.getName()), defaultText, "element"};
                if (selectAttribute3 == null) {
                    selectAttribute3 = xmlObject;
                }
                stscState3.error(XmlErrorCodes.ELEM_DEFAULT_VALID$SIMPLE_TYPE_OR_MIXED, objArr3, selectAttribute3);
            } else if (schemaParticle.getType().getContentType() == 1) {
                XmlObject selectAttribute4 = xmlObject.selectAttribute("", "default");
                StscState stscState4 = StscState.get();
                Object[] objArr4 = {QNameHelper.pretty(schemaParticle.getName()), defaultText, "empty"};
                if (selectAttribute4 == null) {
                    selectAttribute4 = xmlObject;
                }
                stscState4.error(XmlErrorCodes.ELEM_DEFAULT_VALID$SIMPLE_TYPE_OR_MIXED, objArr4, selectAttribute4);
            }
        }
        String str2 = null;
        if (BuiltinSchemaTypeSystem.ST_ID.isAssignableFrom(schemaParticle.getType())) {
            str2 = BuiltinSchemaTypeSystem.ST_ID.getName().getLocalPart();
        } else if (BuiltinSchemaTypeSystem.ST_IDREF.isAssignableFrom(schemaParticle.getType())) {
            str2 = BuiltinSchemaTypeSystem.ST_IDREF.getName().getLocalPart();
        } else if (BuiltinSchemaTypeSystem.ST_IDREFS.isAssignableFrom(schemaParticle.getType())) {
            str2 = BuiltinSchemaTypeSystem.ST_IDREFS.getName().getLocalPart();
        } else if (BuiltinSchemaTypeSystem.ST_ENTITY.isAssignableFrom(schemaParticle.getType())) {
            str2 = BuiltinSchemaTypeSystem.ST_ENTITY.getName().getLocalPart();
        } else if (BuiltinSchemaTypeSystem.ST_ENTITIES.isAssignableFrom(schemaParticle.getType())) {
            str2 = BuiltinSchemaTypeSystem.ST_ENTITIES.getName().getLocalPart();
        } else if (BuiltinSchemaTypeSystem.ST_NOTATION.isAssignableFrom(schemaParticle.getType())) {
            if (schemaParticle.getType().getBuiltinTypeCode() == 8) {
                SchemaLocalElementImpl schemaLocalElementImpl = (SchemaLocalElementImpl) schemaParticle;
                StscState.get().recover(XmlErrorCodes.ELEM_NOTATION_TYPE_FORBIDDEN, new Object[]{QNameHelper.pretty(schemaParticle.getName())}, schemaLocalElementImpl._parseObject == null ? xmlObject : schemaLocalElementImpl._parseObject.selectAttribute("", "type"));
            } else {
                if (schemaParticle.getType().getSimpleVariety() == 2) {
                    for (SchemaType schemaType2 : schemaParticle.getType().getUnionConstituentTypes()) {
                        if (schemaType2.getBuiltinTypeCode() == 8) {
                            SchemaLocalElementImpl schemaLocalElementImpl2 = (SchemaLocalElementImpl) schemaParticle;
                            StscState.get().recover(XmlErrorCodes.ELEM_NOTATION_TYPE_FORBIDDEN, new Object[]{QNameHelper.pretty(schemaParticle.getName())}, schemaLocalElementImpl2._parseObject == null ? xmlObject : schemaLocalElementImpl2._parseObject.selectAttribute("", "type"));
                        }
                    }
                }
                str2 = BuiltinSchemaTypeSystem.ST_NOTATION.getName().getLocalPart();
            }
            while (schemaType.getOuterType() != null) {
                schemaType = schemaType.getOuterType();
            }
            if (!schemaType.isDocumentType() ? schemaType.getName().getNamespaceURI().length() <= 0 : schemaType.getDocumentElementName().getNamespaceURI().length() <= 0) {
                SchemaLocalElementImpl schemaLocalElementImpl3 = (SchemaLocalElementImpl) schemaParticle;
                StscState.get().warning(XmlErrorCodes.ELEM_COMPATIBILITY_TARGETNS, new Object[]{QNameHelper.pretty(schemaParticle.getName())}, schemaLocalElementImpl3._parseObject == null ? xmlObject : schemaLocalElementImpl3._parseObject);
            }
        }
        if (str2 != null) {
            StscState stscState5 = StscState.get();
            Object[] objArr5 = {QNameHelper.pretty(schemaParticle.getName()), str2};
            SchemaLocalElementImpl schemaLocalElementImpl4 = (SchemaLocalElementImpl) schemaParticle;
            if (schemaLocalElementImpl4._parseObject != null) {
                xmlObject = schemaLocalElementImpl4._parseObject.selectAttribute("", "type");
            }
            stscState5.warning(XmlErrorCodes.ELEM_COMPATIBILITY_TYPE, objArr5, xmlObject);
        }
    }

    public static boolean checkRestriction(SchemaTypeImpl schemaTypeImpl) {
        if (schemaTypeImpl.getDerivationType() == 1 && !schemaTypeImpl.isSimpleType()) {
            StscState stscState = StscState.get();
            XmlObject parseObject = schemaTypeImpl.getParseObject();
            SchemaType baseType = schemaTypeImpl.getBaseType();
            if (baseType.isSimpleType()) {
                stscState.error(XmlErrorCodes.SCHEMA_COMPLEX_TYPE$COMPLEX_CONTENT, new Object[]{QNameHelper.pretty(baseType.getName())}, parseObject);
                return false;
            }
            int contentType = schemaTypeImpl.getContentType();
            if (contentType == 1) {
                int contentType2 = baseType.getContentType();
                if (contentType2 != 1) {
                    if (contentType2 == 3 || contentType2 == 4) {
                        if (baseType.getContentModel() != null && !baseType.getContentModel().isSkippable()) {
                            stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$EMPTY_AND_ELEMENT_OR_MIXED_EMPTIABLE, (Object[]) null, parseObject);
                            return false;
                        }
                    } else {
                        stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$EMPTY_AND_NOT_SIMPLE, (Object[]) null, parseObject);
                        return false;
                    }
                }
            } else if (contentType == 2) {
                int contentType3 = baseType.getContentType();
                if (contentType3 == 2) {
                    SchemaType contentBasedOnType = schemaTypeImpl.getContentBasedOnType();
                    if (contentBasedOnType != baseType) {
                        while (baseType != null && !baseType.isSimpleType()) {
                            baseType = baseType.getContentBasedOnType();
                        }
                        if (baseType != null && !baseType.isAssignableFrom(contentBasedOnType)) {
                            stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$SC_NOT_DERIVED, (Object[]) null, parseObject);
                            return false;
                        }
                    }
                } else if (contentType3 == 4) {
                    if (baseType.getContentModel() != null && !baseType.getContentModel().isSkippable()) {
                        stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$SC_AND_MIXED_EMPTIABLE, (Object[]) null, parseObject);
                        return false;
                    }
                } else {
                    stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$SC_AND_SIMPLE_TYPE_OR_MIXED, (Object[]) null, parseObject);
                    return false;
                }
            } else {
                if (contentType != 3) {
                    if (contentType == 4) {
                        if (baseType.getContentType() != 4) {
                            stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$ELEMENT_OR_MIXED_AND_MIXED, (Object[]) null, parseObject);
                            return false;
                        }
                    }
                }
                if (baseType.getContentType() == 1) {
                    stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$ELEMENT_OR_MIXED_AND_EMPTY, (Object[]) null, parseObject);
                    return false;
                }
                if (baseType.getContentType() == 2) {
                    stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$ELEMENT_OR_MIXED_AND_SIMPLE, (Object[]) null, parseObject);
                    return false;
                }
                SchemaParticle contentModel = baseType.getContentModel();
                SchemaParticle contentModel2 = schemaTypeImpl.getContentModel();
                if (contentModel2 == null && schemaTypeImpl.getDerivationType() == 1) {
                    return true;
                }
                if (contentModel == null || contentModel2 == null) {
                    XBeanDebug.logStackTrace(new StringBuffer().append("Null models that weren't caught by EMPTY_CONTENT: ").append(baseType).append(" (").append(contentModel).append("), ").append(schemaTypeImpl).append(" (").append(contentModel2).append(")").toString());
                    stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$ELEMENT_OR_MIXED_AND_VALID, (Object[]) null, parseObject);
                    return false;
                }
                ArrayList arrayList = new ArrayList();
                if (!isParticleValidRestriction(contentModel, contentModel2, arrayList, parseObject)) {
                    if (arrayList.size() == 0) {
                        stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$ELEMENT_OR_MIXED_AND_VALID, (Object[]) null, parseObject);
                    } else {
                        stscState.getErrorListener().add(arrayList.get(arrayList.size() - 1));
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isParticleValidRestriction(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection collection, XmlObject xmlObject) {
        if (schemaParticle.equals(schemaParticle2)) {
            return true;
        }
        int particleType = schemaParticle.getParticleType();
        if (particleType == 1) {
            int particleType2 = schemaParticle2.getParticleType();
            if (particleType2 == 1) {
                return recurse(schemaParticle, schemaParticle2, collection, xmlObject);
            }
            if (particleType2 != 2) {
                if (particleType2 == 3) {
                    return recurseUnordered(schemaParticle, schemaParticle2, collection, xmlObject);
                }
                if (particleType2 == 4) {
                    return recurseAsIfGroup(schemaParticle, schemaParticle2, collection, xmlObject);
                }
                if (particleType2 != 5) {
                    if ($assertionsDisabled) {
                        return false;
                    }
                    throw new AssertionError(XBeanDebug.logStackTrace("Unknown schema type for Derived Type"));
                }
            }
            collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION$INVALID_RESTRICTION, new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle)}, xmlObject));
            return false;
        }
        if (particleType == 2) {
            int particleType3 = schemaParticle2.getParticleType();
            if (particleType3 != 1) {
                if (particleType3 == 2) {
                    return recurseLax(schemaParticle, schemaParticle2, collection, xmlObject);
                }
                if (particleType3 == 3) {
                    return mapAndSum(schemaParticle, schemaParticle2, collection, xmlObject);
                }
                if (particleType3 == 4) {
                    return recurseAsIfGroup(schemaParticle, schemaParticle2, collection, xmlObject);
                }
                if (particleType3 != 5) {
                    if ($assertionsDisabled) {
                        return false;
                    }
                    throw new AssertionError(XBeanDebug.logStackTrace("Unknown schema type for Derived Type"));
                }
            }
            collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION$INVALID_RESTRICTION, new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle)}, xmlObject));
            return false;
        }
        if (particleType == 3) {
            int particleType4 = schemaParticle2.getParticleType();
            if (particleType4 != 1 && particleType4 != 2) {
                if (particleType4 == 3) {
                    return recurse(schemaParticle, schemaParticle2, collection, xmlObject);
                }
                if (particleType4 == 4) {
                    return recurseAsIfGroup(schemaParticle, schemaParticle2, collection, xmlObject);
                }
                if (particleType4 != 5) {
                    if ($assertionsDisabled) {
                        return false;
                    }
                    throw new AssertionError(XBeanDebug.logStackTrace("Unknown schema type for Derived Type"));
                }
            }
            collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION$INVALID_RESTRICTION, new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle)}, xmlObject));
            return false;
        }
        if (particleType == 4) {
            int particleType5 = schemaParticle2.getParticleType();
            if (particleType5 != 1 && particleType5 != 2 && particleType5 != 3) {
                if (particleType5 == 4) {
                    return nameAndTypeOK((SchemaLocalElement) schemaParticle, (SchemaLocalElement) schemaParticle2, collection, xmlObject);
                }
                if (particleType5 != 5) {
                    if ($assertionsDisabled) {
                        return false;
                    }
                    throw new AssertionError(XBeanDebug.logStackTrace("Unknown schema type for Derived Type"));
                }
            }
            collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION$INVALID_RESTRICTION, new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle)}, xmlObject));
            return false;
        }
        if (particleType == 5) {
            int particleType6 = schemaParticle2.getParticleType();
            if (particleType6 == 1) {
                return nsRecurseCheckCardinality(schemaParticle, schemaParticle2, collection, xmlObject);
            }
            if (particleType6 == 2) {
                return nsRecurseCheckCardinality(schemaParticle, schemaParticle2, collection, xmlObject);
            }
            if (particleType6 == 3) {
                return nsRecurseCheckCardinality(schemaParticle, schemaParticle2, collection, xmlObject);
            }
            if (particleType6 == 4) {
                return nsCompat(schemaParticle, (SchemaLocalElement) schemaParticle2, collection, xmlObject);
            }
            if (particleType6 == 5) {
                return nsSubset(schemaParticle, schemaParticle2, collection, xmlObject);
            }
            if ($assertionsDisabled) {
                return false;
            }
            throw new AssertionError(XBeanDebug.logStackTrace("Unknown schema type for Derived Type"));
        }
        if ($assertionsDisabled) {
            return false;
        }
        throw new AssertionError(XBeanDebug.logStackTrace("Unknown schema type for Base Type"));
    }

    private static boolean mapAndSum(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection collection, XmlObject xmlObject) {
        boolean z;
        boolean z2 = $assertionsDisabled;
        if (!z2 && schemaParticle.getParticleType() != 2) {
            throw new AssertionError();
        }
        if (!z2 && schemaParticle2.getParticleType() != 3) {
            throw new AssertionError();
        }
        SchemaParticle[] particleChildren = schemaParticle2.getParticleChildren();
        SchemaParticle[] particleChildren2 = schemaParticle.getParticleChildren();
        for (SchemaParticle schemaParticle3 : particleChildren) {
            int i = 0;
            while (true) {
                if (i >= particleChildren2.length) {
                    z = false;
                    break;
                }
                if (isParticleValidRestriction(particleChildren2[i], schemaParticle3, collection, xmlObject)) {
                    z = true;
                    break;
                }
                i++;
            }
            if (!z) {
                collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_MAP_AND_SUM$MAP, new Object[]{printParticle(schemaParticle3)}, xmlObject));
                return false;
            }
        }
        BigInteger multiply = schemaParticle2.getMinOccurs().multiply(BigInteger.valueOf(schemaParticle2.getParticleChildren().length));
        BigInteger multiply2 = schemaParticle2.getMaxOccurs() == null ? null : schemaParticle2.getMaxOccurs().multiply(BigInteger.valueOf(schemaParticle2.getParticleChildren().length));
        if (multiply.compareTo(schemaParticle.getMinOccurs()) < 0) {
            collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_MAP_AND_SUM$SUM_MIN_OCCURS_GTE_MIN_OCCURS, new Object[]{multiply.toString(), schemaParticle.getMinOccurs().toString()}, xmlObject));
            return false;
        }
        if (schemaParticle.getMaxOccurs() == null || (multiply2 != null && multiply2.compareTo(schemaParticle.getMaxOccurs()) <= 0)) {
            return true;
        }
        Object[] objArr = new Object[2];
        objArr[0] = multiply2 == null ? "unbounded" : multiply2.toString();
        objArr[1] = schemaParticle.getMaxOccurs().toString();
        collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_MAP_AND_SUM$SUM_MAX_OCCURS_LTE_MAX_OCCURS, objArr, xmlObject));
        return false;
    }

    private static boolean recurseAsIfGroup(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection collection, XmlObject xmlObject) {
        if (!$assertionsDisabled && ((schemaParticle.getParticleType() != 1 || schemaParticle2.getParticleType() != 4) && ((schemaParticle.getParticleType() != 2 || schemaParticle2.getParticleType() != 4) && (schemaParticle.getParticleType() != 3 || schemaParticle2.getParticleType() != 4)))) {
            throw new AssertionError();
        }
        SchemaParticleImpl schemaParticleImpl = new SchemaParticleImpl();
        schemaParticleImpl.setParticleType(schemaParticle.getParticleType());
        schemaParticleImpl.setMinOccurs(BigInteger.ONE);
        schemaParticleImpl.setMaxOccurs(BigInteger.ONE);
        schemaParticleImpl.setParticleChildren(new SchemaParticle[]{schemaParticle2});
        return isParticleValidRestriction(schemaParticle, schemaParticleImpl, collection, xmlObject);
    }

    private static boolean recurseLax(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection collection, XmlObject xmlObject) {
        if (!$assertionsDisabled && (schemaParticle.getParticleType() != 2 || schemaParticle2.getParticleType() != 2)) {
            throw new AssertionError();
        }
        if (!occurrenceRangeOK(schemaParticle, schemaParticle2, collection, xmlObject)) {
            return false;
        }
        SchemaParticle[] particleChildren = schemaParticle2.getParticleChildren();
        SchemaParticle[] particleChildren2 = schemaParticle.getParticleChildren();
        int i = 0;
        for (int i2 = 0; i < particleChildren.length && i2 < particleChildren2.length; i2++) {
            if (isParticleValidRestriction(particleChildren2[i2], particleChildren[i], collection, xmlObject)) {
                i++;
            }
        }
        if (i >= particleChildren.length) {
            return true;
        }
        collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_RECURSE_LAX$MAP, new Object[]{printParticles(particleChildren2, i)}, xmlObject));
        return false;
    }

    private static boolean recurseUnordered(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection collection, XmlObject xmlObject) {
        boolean z;
        if (!$assertionsDisabled && (schemaParticle.getParticleType() != 1 || schemaParticle2.getParticleType() != 3)) {
            throw new AssertionError();
        }
        if (!occurrenceRangeOK(schemaParticle, schemaParticle2, collection, xmlObject)) {
            return false;
        }
        SchemaParticle[] particleChildren = schemaParticle.getParticleChildren();
        HashMap hashMap = new HashMap(10);
        Object obj = new Object();
        for (int i = 0; i < particleChildren.length; i++) {
            hashMap.put(particleChildren[i].getName(), particleChildren[i]);
        }
        SchemaParticle[] particleChildren2 = schemaParticle2.getParticleChildren();
        for (int i2 = 0; i2 < particleChildren2.length; i2++) {
            Object obj2 = hashMap.get(particleChildren2[i2].getName());
            if (obj2 == null) {
                collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_RECURSE_UNORDERED$MAP, new Object[]{printParticle(particleChildren2[i2])}, xmlObject));
            } else if (obj2 == obj) {
                collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_RECURSE_UNORDERED$MAP_UNIQUE, new Object[]{printParticle(particleChildren2[i2])}, xmlObject));
            } else {
                SchemaParticle schemaParticle3 = (SchemaParticle) obj2;
                if (particleChildren2[i2].getMaxOccurs() == null || particleChildren2[i2].getMaxOccurs().compareTo(BigInteger.ONE) > 0) {
                    collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_RECURSE_UNORDERED$MAP_MAX_OCCURS_1, new Object[]{printParticle(particleChildren2[i2]), printMaxOccurs(particleChildren2[i2].getMinOccurs())}, xmlObject));
                } else if (isParticleValidRestriction(schemaParticle3, particleChildren2[i2], collection, xmlObject)) {
                    hashMap.put(particleChildren2[i2].getName(), obj);
                }
            }
            z = false;
        }
        z = true;
        if (z) {
            for (QName qName : hashMap.keySet()) {
                if (hashMap.get(qName) != obj && !((SchemaParticle) hashMap.get(qName)).isSkippable()) {
                    collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_RECURSE_UNORDERED$UNMAPPED_ARE_EMPTIABLE, new Object[]{printParticle((SchemaParticle) hashMap.get(qName))}, xmlObject));
                    z = false;
                }
            }
        }
        return z;
    }

    private static boolean recurse(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection collection, XmlObject xmlObject) {
        boolean z;
        if (!occurrenceRangeOK(schemaParticle, schemaParticle2, collection, xmlObject)) {
            return false;
        }
        SchemaParticle[] particleChildren = schemaParticle2.getParticleChildren();
        SchemaParticle[] particleChildren2 = schemaParticle.getParticleChildren();
        int i = 0;
        int i2 = 0;
        while (i < particleChildren.length && i2 < particleChildren2.length) {
            SchemaParticle schemaParticle3 = particleChildren[i];
            SchemaParticle schemaParticle4 = particleChildren2[i2];
            if (!isParticleValidRestriction(schemaParticle4, schemaParticle3, collection, xmlObject)) {
                if (!schemaParticle4.isSkippable()) {
                    collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_RECURSE$MAP_VALID, new Object[]{printParticle(schemaParticle3), printParticle(schemaParticle2), printParticle(schemaParticle4), printParticle(schemaParticle)}, xmlObject));
                    z = false;
                    break;
                }
            } else {
                i++;
            }
            i2++;
        }
        z = true;
        if (i < particleChildren.length) {
            collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_RECURSE$MAP, new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle), printParticles(particleChildren, i)}, xmlObject));
            return false;
        }
        if (i2 < particleChildren2.length) {
            ArrayList arrayList = new ArrayList(particleChildren2.length);
            while (i2 < particleChildren2.length) {
                if (!particleChildren2[i2].isSkippable()) {
                    arrayList.add(particleChildren2[i2]);
                }
                i2++;
            }
            if (arrayList.size() > 0) {
                collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_RECURSE$UNMAPPED_ARE_EMPTIABLE, new Object[]{printParticle(schemaParticle), printParticle(schemaParticle2), printParticles(arrayList)}, xmlObject));
                return false;
            }
        }
        return z;
    }

    private static boolean nsRecurseCheckCardinality(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection collection, XmlObject xmlObject) {
        boolean z = $assertionsDisabled;
        if (!z && schemaParticle.getParticleType() != 5) {
            throw new AssertionError();
        }
        if (!z && schemaParticle2.getParticleType() != 1 && schemaParticle2.getParticleType() != 2 && schemaParticle2.getParticleType() != 3) {
            throw new AssertionError();
        }
        SchemaParticleImpl schemaParticleImpl = new SchemaParticleImpl();
        schemaParticleImpl.setParticleType(schemaParticle.getParticleType());
        schemaParticleImpl.setWildcardProcess(schemaParticle.getWildcardProcess());
        schemaParticleImpl.setWildcardSet(schemaParticle.getWildcardSet());
        schemaParticleImpl.setMinOccurs(BigInteger.ZERO);
        schemaParticleImpl.setMaxOccurs(null);
        schemaParticleImpl.setTransitionRules(schemaParticle.getWildcardSet(), true);
        schemaParticleImpl.setTransitionNotes(schemaParticle.getWildcardSet(), true);
        boolean z2 = true;
        for (SchemaParticle schemaParticle3 : schemaParticle2.getParticleChildren()) {
            int particleType = schemaParticle3.getParticleType();
            if (particleType == 1 || particleType == 2 || particleType == 3) {
                z2 = nsRecurseCheckCardinality(schemaParticleImpl, schemaParticle3, collection, xmlObject);
            } else if (particleType == 4) {
                z2 = nsCompat(schemaParticleImpl, (SchemaLocalElement) schemaParticle3, collection, xmlObject);
            } else if (particleType == 5) {
                z2 = nsSubset(schemaParticleImpl, schemaParticle3, collection, xmlObject);
            }
            if (!z2) {
                break;
            }
        }
        return z2 ? checkGroupOccurrenceOK(schemaParticle, schemaParticle2, collection, xmlObject) : z2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000f, code lost:
    
        if (r2 != 3) goto L10;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean checkGroupOccurrenceOK(org.apache.xmlbeans.SchemaParticle r7, org.apache.xmlbeans.SchemaParticle r8, java.util.Collection r9, org.apache.xmlbeans.XmlObject r10) {
        /*
            java.math.BigInteger r0 = java.math.BigInteger.ZERO
            java.math.BigInteger r1 = java.math.BigInteger.ZERO
            int r2 = r8.getParticleType()
            r3 = 2
            r4 = 1
            if (r2 == r4) goto L1b
            if (r2 == r3) goto L12
            r5 = 3
            if (r2 == r5) goto L1b
            goto L23
        L12:
            java.math.BigInteger r0 = getEffectiveMinRangeChoice(r8)
            java.math.BigInteger r1 = getEffectiveMaxRangeChoice(r8)
            goto L23
        L1b:
            java.math.BigInteger r0 = getEffectiveMinRangeAllSeq(r8)
            java.math.BigInteger r1 = getEffectiveMaxRangeAllSeq(r8)
        L23:
            java.math.BigInteger r2 = r7.getMinOccurs()
            int r0 = r0.compareTo(r2)
            r2 = 0
            if (r0 >= 0) goto L47
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.String r5 = printParticle(r8)
            r0[r2] = r5
            java.lang.String r5 = printParticle(r7)
            r0[r4] = r5
            java.lang.String r5 = "range-ok.1"
            org.apache.xmlbeans.XmlError r0 = org.apache.xmlbeans.XmlError.forObject(r5, r0, r10)
            r9.add(r0)
            r0 = r2
            goto L48
        L47:
            r0 = r4
        L48:
            java.math.BigInteger r5 = r7.getMaxOccurs()
            if (r5 == 0) goto L88
            java.lang.String r5 = "range-ok.2"
            if (r1 != 0) goto L68
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.String r8 = printParticle(r8)
            r0[r2] = r8
            java.lang.String r7 = printParticle(r7)
            r0[r4] = r7
            org.apache.xmlbeans.XmlError r7 = org.apache.xmlbeans.XmlError.forObject(r5, r0, r10)
            r9.add(r7)
            goto L89
        L68:
            java.math.BigInteger r6 = r7.getMaxOccurs()
            int r1 = r1.compareTo(r6)
            if (r1 <= 0) goto L88
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.String r8 = printParticle(r8)
            r0[r2] = r8
            java.lang.String r7 = printParticle(r7)
            r0[r4] = r7
            org.apache.xmlbeans.XmlError r7 = org.apache.xmlbeans.XmlError.forObject(r5, r0, r10)
            r9.add(r7)
            goto L89
        L88:
            r2 = r0
        L89:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.schema.StscChecker.checkGroupOccurrenceOK(org.apache.xmlbeans.SchemaParticle, org.apache.xmlbeans.SchemaParticle, java.util.Collection, org.apache.xmlbeans.XmlObject):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x004e, code lost:
    
        if (r0.compareTo(r2) > 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x005d, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x005b, code lost:
    
        if (r0.compareTo(r2) > 0) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0061 A[LOOP:0: B:2:0x000c->B:15:0x0061, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0064 A[EDGE_INSN: B:16:0x0064->B:17:0x0064 BREAK  A[LOOP:0: B:2:0x000c->B:15:0x0061], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.math.BigInteger getEffectiveMaxRangeChoice(org.apache.xmlbeans.SchemaParticle r11) {
        /*
            java.math.BigInteger r0 = java.math.BigInteger.ZERO
            java.math.BigInteger r1 = java.math.BigInteger.ZERO
            java.math.BigInteger r2 = java.math.BigInteger.ZERO
            org.apache.xmlbeans.SchemaParticle[] r3 = r11.getParticleChildren()
            r4 = 0
            r5 = r4
        Lc:
            int r6 = r3.length
            r7 = 0
            if (r4 >= r6) goto L64
            r6 = r3[r4]
            int r8 = r6.getParticleType()
            r9 = 1
            if (r8 == r9) goto L51
            r10 = 2
            if (r8 == r10) goto L44
            r10 = 3
            if (r8 == r10) goto L51
            r10 = 4
            if (r8 == r10) goto L26
            r10 = 5
            if (r8 == r10) goto L26
            goto L5e
        L26:
            java.math.BigInteger r8 = r6.getMaxOccurs()
            if (r8 != 0) goto L2e
            r0 = r7
            goto L5e
        L2e:
            int r8 = r6.getIntMaxOccurs()
            if (r8 <= 0) goto L5e
            java.math.BigInteger r5 = r6.getMaxOccurs()
            int r5 = r5.compareTo(r1)
            if (r5 <= 0) goto L42
            java.math.BigInteger r1 = r6.getMaxOccurs()
        L42:
            r5 = r9
            goto L5e
        L44:
            java.math.BigInteger r0 = getEffectiveMaxRangeChoice(r6)
            if (r0 == 0) goto L5e
            int r6 = r0.compareTo(r2)
            if (r6 <= 0) goto L5e
            goto L5d
        L51:
            java.math.BigInteger r0 = getEffectiveMaxRangeAllSeq(r6)
            if (r0 == 0) goto L5e
            int r6 = r0.compareTo(r2)
            if (r6 <= 0) goto L5e
        L5d:
            r2 = r0
        L5e:
            if (r0 != 0) goto L61
            goto L64
        L61:
            int r4 = r4 + 1
            goto Lc
        L64:
            if (r0 == 0) goto L7c
            if (r5 == 0) goto L6f
            java.math.BigInteger r0 = r11.getMaxOccurs()
            if (r0 != 0) goto L6f
            goto L7d
        L6f:
            java.math.BigInteger r11 = r11.getMaxOccurs()
            java.math.BigInteger r0 = r1.add(r2)
            java.math.BigInteger r7 = r11.multiply(r0)
            goto L7d
        L7c:
            r7 = r0
        L7d:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.schema.StscChecker.getEffectiveMaxRangeChoice(org.apache.xmlbeans.SchemaParticle):java.math.BigInteger");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0048, code lost:
    
        if (r0.compareTo(r2) > 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0057, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0055, code lost:
    
        if (r0.compareTo(r2) > 0) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005b A[LOOP:0: B:2:0x000c->B:15:0x005b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005e A[EDGE_INSN: B:16:0x005e->B:17:0x005e BREAK  A[LOOP:0: B:2:0x000c->B:15:0x005b], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.math.BigInteger getEffectiveMaxRangeAllSeq(org.apache.xmlbeans.SchemaParticle r11) {
        /*
            java.math.BigInteger r0 = java.math.BigInteger.ZERO
            java.math.BigInteger r1 = java.math.BigInteger.ZERO
            java.math.BigInteger r2 = java.math.BigInteger.ZERO
            org.apache.xmlbeans.SchemaParticle[] r3 = r11.getParticleChildren()
            r4 = 0
            r5 = r4
        Lc:
            int r6 = r3.length
            r7 = 0
            if (r4 >= r6) goto L5e
            r6 = r3[r4]
            int r8 = r6.getParticleType()
            r9 = 1
            if (r8 == r9) goto L4b
            r10 = 2
            if (r8 == r10) goto L3e
            r10 = 3
            if (r8 == r10) goto L4b
            r10 = 4
            if (r8 == r10) goto L26
            r10 = 5
            if (r8 == r10) goto L26
            goto L58
        L26:
            java.math.BigInteger r8 = r6.getMaxOccurs()
            if (r8 != 0) goto L2e
            r0 = r7
            goto L58
        L2e:
            int r8 = r6.getIntMaxOccurs()
            if (r8 <= 0) goto L58
            java.math.BigInteger r5 = r6.getMaxOccurs()
            java.math.BigInteger r1 = r1.add(r5)
            r5 = r9
            goto L58
        L3e:
            java.math.BigInteger r0 = getEffectiveMaxRangeChoice(r6)
            if (r0 == 0) goto L58
            int r6 = r0.compareTo(r2)
            if (r6 <= 0) goto L58
            goto L57
        L4b:
            java.math.BigInteger r0 = getEffectiveMaxRangeAllSeq(r6)
            if (r0 == 0) goto L58
            int r6 = r0.compareTo(r2)
            if (r6 <= 0) goto L58
        L57:
            r2 = r0
        L58:
            if (r0 != 0) goto L5b
            goto L5e
        L5b:
            int r4 = r4 + 1
            goto Lc
        L5e:
            if (r0 == 0) goto L76
            if (r5 == 0) goto L69
            java.math.BigInteger r0 = r11.getMaxOccurs()
            if (r0 != 0) goto L69
            goto L77
        L69:
            java.math.BigInteger r11 = r11.getMaxOccurs()
            java.math.BigInteger r0 = r1.add(r2)
            java.math.BigInteger r7 = r11.multiply(r0)
            goto L77
        L76:
            r7 = r0
        L77:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.schema.StscChecker.getEffectiveMaxRangeAllSeq(org.apache.xmlbeans.SchemaParticle):java.math.BigInteger");
    }

    private static BigInteger getEffectiveMinRangeChoice(SchemaParticle schemaParticle) {
        int i;
        BigInteger effectiveMinRangeAllSeq;
        SchemaParticle[] particleChildren = schemaParticle.getParticleChildren();
        if (particleChildren.length == 0) {
            return BigInteger.ZERO;
        }
        BigInteger bigInteger = null;
        while (i < particleChildren.length) {
            SchemaParticle schemaParticle2 = particleChildren[i];
            int particleType = schemaParticle2.getParticleType();
            if (particleType != 1) {
                if (particleType == 2) {
                    effectiveMinRangeAllSeq = getEffectiveMinRangeChoice(schemaParticle2);
                    if (bigInteger != null && bigInteger.compareTo(effectiveMinRangeAllSeq) <= 0) {
                    }
                    bigInteger = effectiveMinRangeAllSeq;
                } else if (particleType != 3) {
                    if ((particleType == 4 || particleType == 5) && (bigInteger == null || bigInteger.compareTo(schemaParticle2.getMinOccurs()) > 0)) {
                        bigInteger = schemaParticle2.getMinOccurs();
                    }
                }
            }
            effectiveMinRangeAllSeq = getEffectiveMinRangeAllSeq(schemaParticle2);
            i = (bigInteger != null && bigInteger.compareTo(effectiveMinRangeAllSeq) <= 0) ? i + 1 : 0;
            bigInteger = effectiveMinRangeAllSeq;
        }
        if (bigInteger == null) {
            bigInteger = BigInteger.ZERO;
        }
        return schemaParticle.getMinOccurs().multiply(bigInteger);
    }

    private static BigInteger getEffectiveMinRangeAllSeq(SchemaParticle schemaParticle) {
        BigInteger bigInteger = BigInteger.ZERO;
        SchemaParticle[] particleChildren = schemaParticle.getParticleChildren();
        BigInteger bigInteger2 = BigInteger.ZERO;
        for (SchemaParticle schemaParticle2 : particleChildren) {
            int particleType = schemaParticle2.getParticleType();
            if (particleType != 1) {
                if (particleType == 2) {
                    bigInteger2 = bigInteger2.add(getEffectiveMinRangeChoice(schemaParticle2));
                } else if (particleType != 3) {
                    if (particleType == 4 || particleType == 5) {
                        bigInteger2 = bigInteger2.add(schemaParticle2.getMinOccurs());
                    }
                }
            }
            bigInteger2 = bigInteger2.add(getEffectiveMinRangeAllSeq(schemaParticle2));
        }
        return schemaParticle.getMinOccurs().multiply(bigInteger2);
    }

    private static boolean nsSubset(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection collection, XmlObject xmlObject) {
        boolean z = $assertionsDisabled;
        if (!z && schemaParticle.getParticleType() != 5) {
            throw new AssertionError();
        }
        if (!z && schemaParticle2.getParticleType() != 5) {
            throw new AssertionError();
        }
        if (occurrenceRangeOK(schemaParticle, schemaParticle2, collection, xmlObject)) {
            if (schemaParticle.getWildcardSet().inverse().isDisjoint(schemaParticle2.getWildcardSet())) {
                return true;
            }
            collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_NS_SUBST$WILDCARD_SUBSET, new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle)}, xmlObject));
        }
        return false;
    }

    private static boolean nsCompat(SchemaParticle schemaParticle, SchemaLocalElement schemaLocalElement, Collection collection, XmlObject xmlObject) {
        if (!$assertionsDisabled && schemaParticle.getParticleType() != 5) {
            throw new AssertionError();
        }
        if (!schemaParticle.getWildcardSet().contains(schemaLocalElement.getName())) {
            collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_NS_COMPAT$WILDCARD_VALID, new Object[]{printParticle((SchemaParticle) schemaLocalElement), printParticle(schemaParticle)}, xmlObject));
        } else if (occurrenceRangeOK(schemaParticle, (SchemaParticle) schemaLocalElement, collection, xmlObject)) {
            return true;
        }
        return false;
    }

    private static boolean nameAndTypeOK(SchemaLocalElement schemaLocalElement, SchemaLocalElement schemaLocalElement2, Collection collection, XmlObject xmlObject) {
        SchemaParticle schemaParticle = (SchemaParticle) schemaLocalElement;
        if (!schemaParticle.canStartWithElement(schemaLocalElement2.getName())) {
            collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION_NAME_AND_TYPE$NAME, new Object[]{printParticle((SchemaParticle) schemaLocalElement2), printParticle(schemaParticle)}, xmlObject));
            return false;
        }
        if (schemaLocalElement.isNillable() || !schemaLocalElement2.isNillable()) {
            return occurrenceRangeOK(schemaParticle, (SchemaParticle) schemaLocalElement2, collection, xmlObject) && checkFixed(schemaLocalElement, schemaLocalElement2, collection, xmlObject) && checkIdentityConstraints(schemaLocalElement, schemaLocalElement2, collection, xmlObject) && typeDerivationOK(schemaLocalElement.getType(), schemaLocalElement2.getType(), collection, xmlObject) && blockSetOK(schemaLocalElement, schemaLocalElement2, collection, xmlObject);
        }
        collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION_NAME_AND_TYPE$NILLABLE, new Object[]{printParticle((SchemaParticle) schemaLocalElement2), printParticle(schemaParticle)}, xmlObject));
        return false;
    }

    private static boolean blockSetOK(SchemaLocalElement schemaLocalElement, SchemaLocalElement schemaLocalElement2, Collection collection, XmlObject xmlObject) {
        if (schemaLocalElement.blockRestriction() && !schemaLocalElement2.blockRestriction()) {
            collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION_NAME_AND_TYPE$DISALLOWED_SUBSTITUTIONS, new Object[]{printParticle((SchemaParticle) schemaLocalElement2), "restriction", printParticle((SchemaParticle) schemaLocalElement)}, xmlObject));
            return false;
        }
        if (schemaLocalElement.blockExtension() && !schemaLocalElement2.blockExtension()) {
            collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION_NAME_AND_TYPE$DISALLOWED_SUBSTITUTIONS, new Object[]{printParticle((SchemaParticle) schemaLocalElement2), "extension", printParticle((SchemaParticle) schemaLocalElement)}, xmlObject));
            return false;
        }
        if (!schemaLocalElement.blockSubstitution() || schemaLocalElement2.blockSubstitution()) {
            return true;
        }
        collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION_NAME_AND_TYPE$DISALLOWED_SUBSTITUTIONS, new Object[]{printParticle((SchemaParticle) schemaLocalElement2), "substitution", printParticle((SchemaParticle) schemaLocalElement)}, xmlObject));
        return false;
    }

    private static boolean typeDerivationOK(SchemaType schemaType, SchemaType schemaType2, Collection collection, XmlObject xmlObject) {
        if (schemaType.isAssignableFrom(schemaType2)) {
            return checkAllDerivationsForRestriction(schemaType, schemaType2, collection, xmlObject);
        }
        collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION_NAME_AND_TYPE$TYPE_VALID, new Object[]{printType(schemaType2), printType(schemaType)}, xmlObject));
        return false;
    }

    private static boolean checkAllDerivationsForRestriction(SchemaType schemaType, SchemaType schemaType2, Collection collection, XmlObject xmlObject) {
        HashSet hashSet = schemaType.getSimpleVariety() == 2 ? new HashSet(Arrays.asList(schemaType.getUnionConstituentTypes())) : null;
        for (SchemaType schemaType3 = schemaType2; !schemaType.equals(schemaType3) && hashSet != null && !hashSet.contains(schemaType3); schemaType3 = schemaType3.getBaseType()) {
            if (schemaType3.getDerivationType() != 1) {
                collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION_NAME_AND_TYPE$TYPE_RESTRICTED, new Object[]{printType(schemaType2), printType(schemaType), printType(schemaType3)}, xmlObject));
                return false;
            }
        }
        return true;
    }

    private static boolean checkIdentityConstraints(SchemaLocalElement schemaLocalElement, SchemaLocalElement schemaLocalElement2, Collection collection, XmlObject xmlObject) {
        SchemaIdentityConstraint[] identityConstraints = schemaLocalElement.getIdentityConstraints();
        for (SchemaIdentityConstraint schemaIdentityConstraint : schemaLocalElement2.getIdentityConstraints()) {
            if (checkForIdentityConstraintExistence(identityConstraints, schemaIdentityConstraint)) {
                collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION_NAME_AND_TYPE$IDENTITY_CONSTRAINTS, new Object[]{printParticle((SchemaParticle) schemaLocalElement2), printParticle((SchemaParticle) schemaLocalElement)}, xmlObject));
                return false;
            }
        }
        return true;
    }

    private static boolean checkForIdentityConstraintExistence(SchemaIdentityConstraint[] schemaIdentityConstraintArr, SchemaIdentityConstraint schemaIdentityConstraint) {
        for (SchemaIdentityConstraint schemaIdentityConstraint2 : schemaIdentityConstraintArr) {
            if (schemaIdentityConstraint2.getName().equals(schemaIdentityConstraint.getName())) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkFixed(SchemaLocalElement schemaLocalElement, SchemaLocalElement schemaLocalElement2, Collection collection, XmlObject xmlObject) {
        if (!schemaLocalElement.isFixed() || schemaLocalElement.getDefaultText().equals(schemaLocalElement2.getDefaultText())) {
            return true;
        }
        collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION_NAME_AND_TYPE$FIXED, new Object[]{printParticle((SchemaParticle) schemaLocalElement2), schemaLocalElement2.getDefaultText(), printParticle((SchemaParticle) schemaLocalElement), schemaLocalElement.getDefaultText()}, xmlObject));
        return false;
    }

    private static boolean occurrenceRangeOK(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection collection, XmlObject xmlObject) {
        if (schemaParticle2.getMinOccurs().compareTo(schemaParticle.getMinOccurs()) < 0) {
            collection.add(XmlError.forObject(XmlErrorCodes.OCCURRENCE_RANGE$MIN_GTE_MIN, new Object[]{printParticle(schemaParticle2), schemaParticle2.getMinOccurs().toString(), printParticle(schemaParticle), schemaParticle.getMinOccurs().toString()}, xmlObject));
        } else {
            if (schemaParticle.getMaxOccurs() == null) {
                return true;
            }
            if (schemaParticle2.getMaxOccurs() != null && schemaParticle.getMaxOccurs() != null && schemaParticle2.getMaxOccurs().compareTo(schemaParticle.getMaxOccurs()) <= 0) {
                return true;
            }
            collection.add(XmlError.forObject(XmlErrorCodes.OCCURRENCE_RANGE$MAX_LTE_MAX, new Object[]{printParticle(schemaParticle2), printMaxOccurs(schemaParticle2.getMaxOccurs()), printParticle(schemaParticle), printMaxOccurs(schemaParticle.getMaxOccurs())}, xmlObject));
        }
        return false;
    }

    private static String printParticles(List list) {
        return printParticles((SchemaParticle[]) list.toArray(new SchemaParticle[list.size()]));
    }

    private static String printParticles(SchemaParticle[] schemaParticleArr) {
        return printParticles(schemaParticleArr, 0, schemaParticleArr.length);
    }

    private static String printParticles(SchemaParticle[] schemaParticleArr, int i) {
        return printParticles(schemaParticleArr, i, schemaParticleArr.length);
    }

    private static String printParticles(SchemaParticle[] schemaParticleArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer(schemaParticleArr.length * 30);
        while (i < i2) {
            stringBuffer.append(printParticle(schemaParticleArr[i]));
            i++;
            if (i != i2) {
                stringBuffer.append(", ");
            }
        }
        return stringBuffer.toString();
    }

    private static String printParticle(SchemaParticle schemaParticle) {
        int particleType = schemaParticle.getParticleType();
        if (particleType == 1) {
            return "<all>";
        }
        if (particleType == 2) {
            return "<choice>";
        }
        if (particleType == 3) {
            return "<sequence>";
        }
        if (particleType != 4) {
            return particleType != 5 ? "??" : "<any>";
        }
        return new StringBuffer().append("<element name=\"").append(QNameHelper.pretty(schemaParticle.getName())).append("\">").toString();
    }

    private static String printMaxOccurs(BigInteger bigInteger) {
        return bigInteger == null ? "unbounded" : bigInteger.toString();
    }

    private static String printType(SchemaType schemaType) {
        if (schemaType.getName() != null) {
            return QNameHelper.pretty(schemaType.getName());
        }
        return schemaType.toString();
    }

    private static void checkSubstitutionGroups(SchemaGlobalElement[] schemaGlobalElementArr) {
        StscState stscState = StscState.get();
        for (SchemaGlobalElement schemaGlobalElement : schemaGlobalElementArr) {
            SchemaGlobalElement substitutionGroup = schemaGlobalElement.substitutionGroup();
            if (substitutionGroup != null) {
                SchemaType type = substitutionGroup.getType();
                SchemaType type2 = schemaGlobalElement.getType();
                XmlObject xmlObject = ((SchemaGlobalElementImpl) schemaGlobalElement)._parseObject;
                if (!type.isAssignableFrom(type2)) {
                    stscState.error(XmlErrorCodes.ELEM_PROPERTIES$SUBSTITUTION_VALID, new Object[]{QNameHelper.pretty(schemaGlobalElement.getName()), QNameHelper.pretty(substitutionGroup.getName())}, xmlObject);
                } else if (substitutionGroup.finalExtension() && substitutionGroup.finalRestriction()) {
                    stscState.error(XmlErrorCodes.ELEM_PROPERTIES$SUBSTITUTION_FINAL, new Object[]{QNameHelper.pretty(schemaGlobalElement.getName()), QNameHelper.pretty(substitutionGroup.getName()), "#all"}, xmlObject);
                } else if (!type.equals(type2)) {
                    if (substitutionGroup.finalExtension() && type2.getDerivationType() == 2) {
                        stscState.error(XmlErrorCodes.ELEM_PROPERTIES$SUBSTITUTION_FINAL, new Object[]{QNameHelper.pretty(schemaGlobalElement.getName()), QNameHelper.pretty(substitutionGroup.getName()), "extension"}, xmlObject);
                    } else if (substitutionGroup.finalRestriction() && type2.getDerivationType() == 1) {
                        stscState.error(XmlErrorCodes.ELEM_PROPERTIES$SUBSTITUTION_FINAL, new Object[]{QNameHelper.pretty(schemaGlobalElement.getName()), QNameHelper.pretty(substitutionGroup.getName()), "restriction"}, xmlObject);
                    }
                }
            }
        }
    }
}
