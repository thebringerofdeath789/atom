package org.apache.xmlbeans.impl.schema;

import aavax.xml.namespace.QName;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.apache.xmlbeans.BindingConfig;
import org.apache.xmlbeans.InterfaceExtension;
import org.apache.xmlbeans.PrePostExtension;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaStringEnumEntry;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.UserType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes5.dex */
public class StscJavaizer {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final int MAX_ENUM_COUNT = 3668;
    private static final String[] PREFIXES;
    static String[] PROTECTED_PROPERTIES;
    static Set PROTECTED_PROPERTIES_SET;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$schema$StscJavaizer;

    static {
        if (class$org$apache$xmlbeans$impl$schema$StscJavaizer == null) {
            class$org$apache$xmlbeans$impl$schema$StscJavaizer = class$("org.apache.xmlbeans.impl.schema.StscJavaizer");
        }
        $assertionsDisabled = true;
        PREFIXES = new String[]{"get", "xget", "isNil", "isSet", "sizeOf", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "xset", "addNew", "setNil", "unset", "insert", "add", "insertNew", "addNew", "remove"};
        PROTECTED_PROPERTIES = new String[]{"StringValue", "BooleanValue", "ByteValue", "ShortValue", "IntValue", "LongValue", "BigIntegerValue", "BigDecimalValue", "FloatValue", "DoubleValue", "ByteArrayValue", "EnumValue", "CalendarValue", "DateValue", "GDateValue", "GDurationValue", "QNameValue", "ListValue", "ObjectValue", "Class"};
        PROTECTED_PROPERTIES_SET = new HashSet(Arrays.asList(PROTECTED_PROPERTIES));
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static void javaizeAllTypes(boolean z) {
        StscState stscState = StscState.get();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(stscState.documentTypes()));
        arrayList.addAll(Arrays.asList(stscState.attributeTypes()));
        arrayList.addAll(Arrays.asList(stscState.globalTypes()));
        if (z) {
            assignGlobalJavaNames(arrayList);
        }
        for (int i = 0; i < arrayList.size(); i++) {
            SchemaType schemaType = (SchemaType) arrayList.get(i);
            if (z) {
                javaizeType((SchemaTypeImpl) schemaType);
                String fullJavaName = schemaType.getFullJavaName();
                if (fullJavaName != null) {
                    stscState.addClassname(fullJavaName.replace('$', '.'), schemaType);
                }
            } else {
                skipJavaizingType((SchemaTypeImpl) schemaType);
            }
            arrayList.addAll(Arrays.asList(schemaType.getAnonymousTypes()));
            addAnonymousTypesFromRedefinition(schemaType, arrayList);
        }
    }

    static void assignGlobalJavaNames(Collection collection) {
        HashSet hashSet = new HashSet();
        StscState stscState = StscState.get();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            SchemaTypeImpl schemaTypeImpl = (SchemaTypeImpl) it.next();
            String javaname = stscState.getJavaname(findTopName(schemaTypeImpl), schemaTypeImpl.isDocumentType() ? 2 : 1);
            if (schemaTypeImpl.isUnjavaized()) {
                schemaTypeImpl.setFullJavaName(pickFullJavaClassName(hashSet, findTopName(schemaTypeImpl), javaname, schemaTypeImpl.isDocumentType(), schemaTypeImpl.isAttributeType()));
                schemaTypeImpl.setFullJavaImplName(pickFullJavaImplName(hashSet, schemaTypeImpl.getFullJavaName()));
                setUserTypes(schemaTypeImpl, stscState);
                setExtensions(schemaTypeImpl, stscState);
            }
        }
        verifyInterfaceNameCollisions(hashSet, stscState);
    }

    private static void verifyInterfaceNameCollisions(Set set, StscState stscState) {
        BindingConfig bindingConfig = stscState.getBindingConfig();
        if (bindingConfig == null) {
            return;
        }
        InterfaceExtension[] interfaceExtensions = bindingConfig.getInterfaceExtensions();
        for (int i = 0; i < interfaceExtensions.length; i++) {
            if (set.contains(interfaceExtensions[i].getInterface().toLowerCase())) {
                stscState.error(new StringBuffer().append("InterfaceExtension interface '").append(interfaceExtensions[i].getInterface()).append("' creates a name collision with one of the generated interfaces or classes.").toString(), 0, (XmlObject) null);
            }
            String staticHandler = interfaceExtensions[i].getStaticHandler();
            if (staticHandler != null && set.contains(staticHandler.toLowerCase())) {
                stscState.error(new StringBuffer().append("InterfaceExtension handler class '").append(staticHandler).append("' creates a name collision with one of the generated interfaces or classes.").toString(), 0, (XmlObject) null);
            }
        }
        for (PrePostExtension prePostExtension : bindingConfig.getPrePostExtensions()) {
            String staticHandler2 = prePostExtension.getStaticHandler();
            if (staticHandler2 != null && set.contains(staticHandler2.toLowerCase())) {
                stscState.error(new StringBuffer().append("PrePostExtension handler class '").append(staticHandler2).append("' creates a name collision with one of the generated interfaces or classes.").toString(), 0, (XmlObject) null);
            }
        }
    }

    private static void setUserTypes(SchemaTypeImpl schemaTypeImpl, StscState stscState) {
        UserType lookupUserTypeForQName;
        BindingConfig bindingConfig = stscState.getBindingConfig();
        if (bindingConfig == null || (lookupUserTypeForQName = bindingConfig.lookupUserTypeForQName(schemaTypeImpl.getName())) == null) {
            return;
        }
        schemaTypeImpl.setUserTypeName(lookupUserTypeForQName.getJavaName());
        schemaTypeImpl.setUserTypeHandlerName(lookupUserTypeForQName.getStaticHandler());
    }

    private static void setExtensions(SchemaTypeImpl schemaTypeImpl, StscState stscState) {
        String fullJavaName = schemaTypeImpl.getFullJavaName();
        BindingConfig bindingConfig = stscState.getBindingConfig();
        if (fullJavaName == null || bindingConfig == null) {
            return;
        }
        schemaTypeImpl.setInterfaceExtensions(bindingConfig.getInterfaceExtensions(fullJavaName));
        schemaTypeImpl.setPrePostExtension(bindingConfig.getPrePostExtension(fullJavaName));
    }

    private static boolean isStringType(SchemaType schemaType) {
        return schemaType != null && schemaType.getSimpleVariety() == 1 && schemaType.getPrimitiveType().getBuiltinTypeCode() == 12;
    }

    static String pickConstantName(Set set, String str) {
        String upperCaseUnderbar = NameUtil.upperCaseUnderbar(str);
        if (upperCaseUnderbar.length() == 0) {
            upperCaseUnderbar = "X";
        }
        if (upperCaseUnderbar.startsWith("INT_")) {
            upperCaseUnderbar = new StringBuffer().append("X_").append(upperCaseUnderbar).toString();
        }
        String str2 = upperCaseUnderbar;
        int i = 1;
        while (set.contains(str2)) {
            i++;
            str2 = new StringBuffer().append(upperCaseUnderbar).append("_").append(i).toString();
        }
        set.add(str2);
        return str2;
    }

    static void skipJavaizingType(SchemaTypeImpl schemaTypeImpl) {
        if (schemaTypeImpl.isJavaized()) {
            return;
        }
        SchemaTypeImpl schemaTypeImpl2 = (SchemaTypeImpl) schemaTypeImpl.getBaseType();
        if (schemaTypeImpl2 != null) {
            skipJavaizingType(schemaTypeImpl2);
        }
        schemaTypeImpl.startJavaizing();
        secondPassProcessType(schemaTypeImpl);
        schemaTypeImpl.finishJavaizing();
    }

    static void secondPassProcessType(SchemaTypeImpl schemaTypeImpl) {
        XmlAnySimpleType[] enumerationValues;
        if (!isStringType(schemaTypeImpl) || (enumerationValues = schemaTypeImpl.getEnumerationValues()) == null) {
            return;
        }
        if (enumerationValues.length > MAX_ENUM_COUNT) {
            StscState.get().warning(new StringBuffer().append("SchemaType Enumeration found with too many enumeration values to create a Java enumeration. The base SchemaType \"").append(schemaTypeImpl.getBaseEnumType()).append("\" will be used instead").toString(), 1, (XmlObject) null);
            return;
        }
        SchemaStringEnumEntry[] schemaStringEnumEntryArr = new SchemaStringEnumEntry[enumerationValues.length];
        SchemaType baseEnumType = schemaTypeImpl.getBaseEnumType();
        int i = 0;
        if (baseEnumType == schemaTypeImpl) {
            HashSet hashSet = new HashSet();
            while (i < enumerationValues.length) {
                String stringValue = enumerationValues[i].getStringValue();
                int i2 = i + 1;
                schemaStringEnumEntryArr[i] = new SchemaStringEnumEntryImpl(stringValue, i2, pickConstantName(hashSet, stringValue));
                i = i2;
            }
        } else {
            while (i < enumerationValues.length) {
                schemaStringEnumEntryArr[i] = baseEnumType.enumEntryForString(enumerationValues[i].getStringValue());
                i++;
            }
        }
        schemaTypeImpl.setStringEnumEntries(schemaStringEnumEntryArr);
    }

    static void javaizeType(SchemaTypeImpl schemaTypeImpl) {
        if (schemaTypeImpl.isJavaized()) {
            return;
        }
        SchemaTypeImpl schemaTypeImpl2 = (SchemaTypeImpl) schemaTypeImpl.getBaseType();
        if (schemaTypeImpl2 != null) {
            javaizeType(schemaTypeImpl2);
        }
        if (schemaTypeImpl.getContentBasedOnType() != null && schemaTypeImpl.getContentBasedOnType() != schemaTypeImpl2) {
            javaizeType((SchemaTypeImpl) schemaTypeImpl.getContentBasedOnType());
        }
        schemaTypeImpl.startJavaizing();
        schemaTypeImpl.setCompiled(true);
        secondPassProcessType(schemaTypeImpl);
        if (!schemaTypeImpl.isSimpleType()) {
            SchemaProperty[] elementProperties = schemaTypeImpl.getElementProperties();
            SchemaProperty[] attributeProperties = schemaTypeImpl.getAttributeProperties();
            HashSet hashSet = new HashSet();
            for (SchemaProperty schemaProperty : schemaTypeImpl2.getProperties()) {
                String javaPropertyName = schemaProperty.getJavaPropertyName();
                if (!$assertionsDisabled && hashSet.contains(javaPropertyName)) {
                    throw new AssertionError();
                }
                hashSet.add(javaPropertyName);
            }
            avoidExtensionMethods(hashSet, schemaTypeImpl);
            boolean z = true;
            while (true) {
                if (elementProperties.length > 0) {
                    assignJavaPropertyNames(hashSet, elementProperties, schemaTypeImpl2, z);
                }
                assignJavaPropertyNames(hashSet, attributeProperties, schemaTypeImpl2, z);
                if (!z) {
                    break;
                } else {
                    z = false;
                }
            }
            SchemaProperty[] properties = schemaTypeImpl.getProperties();
            boolean isPropertyModelOrderInsensitive = isPropertyModelOrderInsensitive(properties);
            assignJavaTypeCodes(properties);
            schemaTypeImpl.setOrderSensitive(!isPropertyModelOrderInsensitive);
        }
        if (schemaTypeImpl.getFullJavaName() != null || schemaTypeImpl.getOuterType() != null) {
            assignJavaAnonymousTypeNames(schemaTypeImpl);
        }
        schemaTypeImpl.finishJavaizing();
    }

    private static void avoidExtensionMethods(Set set, SchemaTypeImpl schemaTypeImpl) {
        InterfaceExtension[] interfaceExtensions = schemaTypeImpl.getInterfaceExtensions();
        if (interfaceExtensions != null) {
            for (InterfaceExtension interfaceExtension : interfaceExtensions) {
                for (InterfaceExtension.MethodSignature methodSignature : interfaceExtension.getMethods()) {
                    String name = methodSignature.getName();
                    int i = 0;
                    while (true) {
                        String[] strArr = PREFIXES;
                        if (i < strArr.length) {
                            String str = strArr[i];
                            if (name.startsWith(str)) {
                                set.add(name.substring(str.length()));
                            }
                            i++;
                        }
                    }
                }
            }
        }
    }

    static void assignJavaAnonymousTypeNames(SchemaTypeImpl schemaTypeImpl) {
        String str;
        String str2;
        HashSet hashSet = new HashSet();
        SchemaType[] anonymousTypes = schemaTypeImpl.getAnonymousTypes();
        StscState stscState = StscState.get();
        int length = anonymousTypes.length;
        if (schemaTypeImpl.isRedefinition()) {
            ArrayList arrayList = new ArrayList();
            addAnonymousTypesFromRedefinition(schemaTypeImpl, arrayList);
            if (arrayList.size() > 0) {
                SchemaType[] schemaTypeArr = new SchemaType[arrayList.size() + length];
                arrayList.toArray(schemaTypeArr);
                System.arraycopy(anonymousTypes, 0, schemaTypeArr, arrayList.size(), length);
                anonymousTypes = schemaTypeArr;
            }
        }
        for (SchemaType schemaType = schemaTypeImpl; schemaType != null; schemaType = schemaType.getOuterType()) {
            hashSet.add(schemaType.getShortJavaName());
        }
        for (SchemaType schemaType2 = schemaTypeImpl; schemaType2 != null; schemaType2 = schemaType2.getOuterType()) {
            hashSet.add(schemaType2.getShortJavaImplName());
        }
        hashSet.add(getOutermostPackage(schemaTypeImpl.getFullJavaName()));
        for (int i = 0; i < anonymousTypes.length; i++) {
            SchemaTypeImpl schemaTypeImpl2 = (SchemaTypeImpl) anonymousTypes[i];
            if (schemaTypeImpl2 != null && !schemaTypeImpl2.isSkippedAnonymousType()) {
                if (schemaTypeImpl2.getContainerField() != null) {
                    str2 = schemaTypeImpl2.getContainerField().getName().getLocalPart();
                    str = stscState.getJavaname(schemaTypeImpl2.getContainerField().getName(), 1);
                } else {
                    int simpleVariety = schemaTypeImpl2.getOuterType().getSimpleVariety();
                    if (simpleVariety == 2) {
                        str = "Member";
                    } else if (simpleVariety == 3) {
                        str = "Item";
                    } else {
                        if (!$assertionsDisabled) {
                            throw new AssertionError(new StringBuffer().append("Weird type ").append(schemaTypeImpl2.toString()).toString());
                        }
                        str = "Base";
                    }
                    str2 = null;
                }
                if (i < length) {
                    schemaTypeImpl2.setShortJavaName(pickInnerJavaClassName(hashSet, str2, str));
                    schemaTypeImpl2.setShortJavaImplName(pickInnerJavaImplName(hashSet, str2, str != null ? new StringBuffer().append(str).append("Impl").toString() : null));
                } else {
                    schemaTypeImpl2.setFullJavaName(new StringBuffer().append(schemaTypeImpl.getFullJavaName()).append("$").append(pickInnerJavaClassName(hashSet, str2, str)).toString());
                    schemaTypeImpl2.setFullJavaImplName(new StringBuffer().append(schemaTypeImpl.getFullJavaImplName()).append("$").append(pickInnerJavaImplName(hashSet, str2, str != null ? new StringBuffer().append(str).append("Impl").toString() : null)).toString());
                }
                setExtensions(schemaTypeImpl2, stscState);
            }
        }
    }

    static void assignJavaPropertyNames(Set set, SchemaProperty[] schemaPropertyArr, SchemaType schemaType, boolean z) {
        String javaPropertyName;
        StscState stscState = StscState.get();
        for (SchemaProperty schemaProperty : schemaPropertyArr) {
            SchemaPropertyImpl schemaPropertyImpl = (SchemaPropertyImpl) schemaProperty;
            SchemaProperty attributeProperty = schemaPropertyImpl.isAttribute() ? schemaType.getAttributeProperty(schemaPropertyImpl.getName()) : schemaType.getElementProperty(schemaPropertyImpl.getName());
            if ((attributeProperty != null) == z) {
                QName name = schemaPropertyImpl.getName();
                if (attributeProperty == null) {
                    javaPropertyName = pickJavaPropertyName(set, name.getLocalPart(), stscState.getJavaname(name, schemaPropertyImpl.isAttribute() ? 4 : 3));
                } else {
                    javaPropertyName = attributeProperty.getJavaPropertyName();
                }
                schemaPropertyImpl.setJavaPropertyName(javaPropertyName);
                boolean z2 = schemaPropertyImpl.getMaxOccurs() == null || schemaPropertyImpl.getMaxOccurs().compareTo(BigInteger.ONE) > 0;
                boolean z3 = !z2 && schemaPropertyImpl.getMaxOccurs().signum() > 0;
                boolean z4 = z3 && schemaPropertyImpl.getMinOccurs().signum() == 0;
                SchemaType type = schemaPropertyImpl.getType();
                if (attributeProperty != null) {
                    if (attributeProperty.extendsJavaArray()) {
                        z3 = false;
                        z4 = false;
                        z2 = true;
                    }
                    if (attributeProperty.extendsJavaSingleton()) {
                        z3 = true;
                    }
                    boolean z5 = attributeProperty.extendsJavaOption() ? true : z4;
                    type = attributeProperty.javaBasedOnType();
                    z4 = z5;
                }
                schemaPropertyImpl.setExtendsJava(type.getRef(), z3, z4, z2);
            }
        }
    }

    static void assignJavaTypeCodes(SchemaProperty[] schemaPropertyArr) {
        for (SchemaProperty schemaProperty : schemaPropertyArr) {
            SchemaPropertyImpl schemaPropertyImpl = (SchemaPropertyImpl) schemaProperty;
            schemaPropertyImpl.setJavaTypeCode(javaTypeCodeForType(schemaPropertyImpl.javaBasedOnType()));
        }
    }

    static int javaTypeCodeInCommon(SchemaType[] schemaTypeArr) {
        int i = 0;
        if (schemaTypeArr != null && schemaTypeArr.length != 0) {
            i = javaTypeCodeForType(schemaTypeArr[0]);
            if (i == 19) {
                return i;
            }
            for (int i2 = 1; i2 < schemaTypeArr.length; i2++) {
                if (i != javaTypeCodeForType(schemaTypeArr[i2])) {
                    return 19;
                }
            }
        }
        return i;
    }

    static int javaTypeCodeForType(SchemaType schemaType) {
        if (!schemaType.isSimpleType()) {
            return 0;
        }
        if (((SchemaTypeImpl) schemaType).getUserTypeHandlerName() != null) {
            return 20;
        }
        if (schemaType.getSimpleVariety() == 2) {
            SchemaType unionCommonBaseType = schemaType.getUnionCommonBaseType();
            if (unionCommonBaseType == null || unionCommonBaseType.isURType()) {
                return javaTypeCodeInCommon(schemaType.getUnionConstituentTypes());
            }
            schemaType = unionCommonBaseType;
        }
        if (schemaType.getSimpleVariety() == 3) {
            return 16;
        }
        if (schemaType.isURType()) {
            return 0;
        }
        switch (schemaType.getPrimitiveType().getBuiltinTypeCode()) {
            case 2:
                return 10;
            case 3:
                return 1;
            case 4:
            case 5:
                return 11;
            case 6:
                return 10;
            case 7:
                return 15;
            case 8:
                return 0;
            case 9:
                return 2;
            case 10:
                return 3;
            case 11:
                int decimalSize = schemaType.getDecimalSize();
                if (decimalSize == 8) {
                    return 4;
                }
                if (decimalSize == 16) {
                    return 5;
                }
                if (decimalSize == 32) {
                    return 6;
                }
                if (decimalSize != 64) {
                    return decimalSize != 1000000 ? 8 : 9;
                }
                return 7;
            case 12:
                if (isStringType(schemaType.getBaseEnumType())) {
                    return (schemaType.getEnumerationValues() == null || schemaType.getEnumerationValues().length <= MAX_ENUM_COUNT) ? 18 : 10;
                }
                return 10;
            case 13:
                return 13;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                return 17;
            default:
                if ($assertionsDisabled) {
                    throw new IllegalStateException(new StringBuffer().append("unrecognized code ").append(schemaType.getPrimitiveType().getBuiltinTypeCode()).append(" of ").append(schemaType.getPrimitiveType().getName()).toString());
                }
                throw new AssertionError(new StringBuffer().append("unrecognized code ").append(schemaType.getPrimitiveType().getBuiltinTypeCode()).toString());
        }
    }

    static boolean isPropertyModelOrderInsensitive(SchemaProperty[] schemaPropertyArr) {
        for (SchemaProperty schemaProperty : schemaPropertyArr) {
            if (schemaProperty.hasNillable() == 1 || schemaProperty.hasDefault() == 1 || schemaProperty.hasFixed() == 1) {
                return false;
            }
            if (schemaProperty.hasDefault() != 0 && schemaProperty.getDefaultText() == null) {
                return false;
            }
        }
        return true;
    }

    static boolean protectReservedGlobalClassNames(String str) {
        String substring = str.substring(str.lastIndexOf(46) + 1);
        return substring.endsWith("Document") && !substring.equals("Document");
    }

    static boolean protectReservedInnerClassNames(String str) {
        return str.equals("Enum") || str.equals("Factory");
    }

    static boolean protectReservedPropertyNames(String str) {
        return PROTECTED_PROPERTIES_SET.contains(str) || (str.endsWith(SoapEncSchemaTypeSystem.SOAP_ARRAY) && !str.equals(SoapEncSchemaTypeSystem.SOAP_ARRAY));
    }

    static String pickFullJavaClassName(Set set, QName qName, String str, boolean z, boolean z2) {
        boolean z3;
        if (str != null && str.indexOf(46) >= 0) {
            z3 = protectReservedGlobalClassNames(str);
        } else {
            StscState stscState = StscState.get();
            String namespaceURI = qName.getNamespaceURI();
            String classNameFromQName = NameUtil.getClassNameFromQName(qName);
            String packageOverride = stscState.getPackageOverride(namespaceURI);
            if (packageOverride != null) {
                classNameFromQName = new StringBuffer().append(packageOverride).append(".").append(classNameFromQName.substring(classNameFromQName.lastIndexOf(46) + 1)).toString();
            }
            String javaPrefix = stscState.getJavaPrefix(namespaceURI);
            if (javaPrefix != null) {
                classNameFromQName = new StringBuffer().append(classNameFromQName.substring(0, classNameFromQName.lastIndexOf(46) + 1)).append(javaPrefix).append(classNameFromQName.substring(classNameFromQName.lastIndexOf(46) + 1)).toString();
            }
            if (str != null) {
                classNameFromQName = new StringBuffer().append(classNameFromQName.substring(0, classNameFromQName.lastIndexOf(46) + 1)).append(str).toString();
            }
            boolean protectReservedGlobalClassNames = protectReservedGlobalClassNames(classNameFromQName);
            if (str == null) {
                if (z) {
                    classNameFromQName = new StringBuffer().append(classNameFromQName).append("Document").toString();
                } else if (z2) {
                    classNameFromQName = new StringBuffer().append(classNameFromQName).append("Attribute").toString();
                }
                str = classNameFromQName;
                String javaSuffix = stscState.getJavaSuffix(namespaceURI);
                if (javaSuffix != null) {
                    str = new StringBuffer().append(str).append(javaSuffix).toString();
                }
            } else {
                str = classNameFromQName;
            }
            z3 = protectReservedGlobalClassNames;
        }
        String outermostPackage = getOutermostPackage(str);
        String stringBuffer = z3 ? new StringBuffer().append(str).append(1).toString() : str;
        int i = 1;
        while (true) {
            if (set.contains(stringBuffer.toLowerCase()) || stringBuffer.equals(outermostPackage)) {
                i++;
                stringBuffer = new StringBuffer().append(str).append(i).toString();
            } else {
                set.add(stringBuffer.toLowerCase());
                return stringBuffer;
            }
        }
    }

    static String getOutermostPackage(String str) {
        int indexOf;
        return (str != null && (indexOf = str.indexOf(46)) >= 0) ? str.substring(0, indexOf) : "";
    }

    static String pickFullJavaImplName(Set set, String str) {
        String str2;
        String str3;
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            str2 = str.substring(lastIndexOf + 1);
            str3 = str.substring(0, lastIndexOf);
        } else {
            str2 = str;
            str3 = null;
        }
        String stringBuffer = new StringBuffer().append(str3).append(".impl.").append(str2).append("Impl").toString();
        String str4 = stringBuffer;
        int i = 1;
        while (set.contains(str4.toLowerCase())) {
            i++;
            str4 = new StringBuffer().append(stringBuffer).append(i).toString();
        }
        set.add(str4.toLowerCase());
        return str4;
    }

    static String pickJavaPropertyName(Set set, String str, String str2) {
        if (str2 == null) {
            str2 = NameUtil.upperCamelCase(str);
        }
        String stringBuffer = protectReservedPropertyNames(str2) ? new StringBuffer().append(str2).append(1).toString() : str2;
        int i = 1;
        while (set.contains(stringBuffer)) {
            i++;
            stringBuffer = new StringBuffer().append(str2).append(i).toString();
        }
        set.add(stringBuffer);
        return stringBuffer;
    }

    static String pickInnerJavaClassName(Set set, String str, String str2) {
        if (str2 == null) {
            str2 = NameUtil.upperCamelCase(str);
        }
        String stringBuffer = protectReservedInnerClassNames(str2) ? new StringBuffer().append(str2).append(1).toString() : str2;
        int i = 1;
        while (set.contains(stringBuffer)) {
            i++;
            stringBuffer = new StringBuffer().append(str2).append(i).toString();
        }
        set.add(stringBuffer);
        return stringBuffer;
    }

    static String pickInnerJavaImplName(Set set, String str, String str2) {
        if (str2 == null) {
            str2 = new StringBuffer().append(NameUtil.upperCamelCase(str)).append("Impl").toString();
        }
        int i = 1;
        String str3 = str2;
        while (set.contains(str3)) {
            i++;
            str3 = new StringBuffer().append(str2).append(i).toString();
        }
        set.add(str3);
        return str3;
    }

    static QName findTopName(SchemaType schemaType) {
        if (schemaType.getName() != null) {
            return schemaType.getName();
        }
        if (schemaType.isDocumentType()) {
            if (schemaType.getContentModel() == null || schemaType.getContentModel().getParticleType() != 4) {
                throw new IllegalStateException();
            }
            return schemaType.getDocumentElementName();
        }
        if (schemaType.isAttributeType()) {
            if (schemaType.getAttributeModel() == null || schemaType.getAttributeModel().getAttributes().length != 1) {
                throw new IllegalStateException();
            }
            return schemaType.getAttributeTypeAttributeName();
        }
        SchemaField containerField = schemaType.getContainerField();
        boolean z = $assertionsDisabled;
        if (!z && containerField == null) {
            throw new AssertionError();
        }
        if (z || schemaType.getOuterType() == null) {
            return containerField.getName();
        }
        throw new AssertionError();
    }

    static void addAnonymousTypesFromRedefinition(SchemaType schemaType, List list) {
        while (((SchemaTypeImpl) schemaType).isRedefinition()) {
            if (schemaType.getDerivationType() != 2 && !schemaType.isSimpleType()) {
                return;
            }
            schemaType = schemaType.getBaseType();
            SchemaType[] anonymousTypes = schemaType.getAnonymousTypes();
            if (anonymousTypes.length > 0) {
                list.addAll(Arrays.asList(anonymousTypes));
            }
        }
    }
}
