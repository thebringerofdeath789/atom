package org.apache.xmlbeans.impl.inst2xsd;

import aavax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlByte;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlDate;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlDuration;
import org.apache.xmlbeans.XmlFloat;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlLong;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.XmlShort;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlTime;
import org.apache.xmlbeans.impl.common.PrefixResolver;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.common.XmlWhitespace;
import org.apache.xmlbeans.impl.inst2xsd.util.Attribute;
import org.apache.xmlbeans.impl.inst2xsd.util.Element;
import org.apache.xmlbeans.impl.inst2xsd.util.Type;
import org.apache.xmlbeans.impl.inst2xsd.util.TypeSystemHolder;
import org.apache.xmlbeans.impl.util.XsTypeConverter;
import org.apache.xmlbeans.impl.values.XmlAnyUriImpl;
import org.apache.xmlbeans.impl.values.XmlDateImpl;
import org.apache.xmlbeans.impl.values.XmlDateTimeImpl;
import org.apache.xmlbeans.impl.values.XmlDurationImpl;
import org.apache.xmlbeans.impl.values.XmlQNameImpl;
import org.apache.xmlbeans.impl.values.XmlTimeImpl;

/* loaded from: classes5.dex */
public class RussianDollStrategy implements XsdGenStrategy {
    static final /* synthetic */ boolean $assertionsDisabled;
    static final String _xsi = "http://www.w3.org/2001/XMLSchema-instance";
    static final QName _xsiNil;
    static final QName _xsiType;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$inst2xsd$RussianDollStrategy;
    private SCTValidationContext _validationContext = new SCTValidationContext();

    protected void checkIfReferenceToGlobalTypeIsNeeded(Element element, TypeSystemHolder typeSystemHolder, Inst2XsdOptions inst2XsdOptions) {
    }

    static {
        if (class$org$apache$xmlbeans$impl$inst2xsd$RussianDollStrategy == null) {
            class$org$apache$xmlbeans$impl$inst2xsd$RussianDollStrategy = class$("org.apache.xmlbeans.impl.inst2xsd.RussianDollStrategy");
        }
        $assertionsDisabled = true;
        _xsiNil = new QName(_xsi, "nil", "xsi");
        _xsiType = new QName(_xsi, "type", "xsi");
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    @Override // org.apache.xmlbeans.impl.inst2xsd.XsdGenStrategy
    public void processDoc(XmlObject[] xmlObjectArr, Inst2XsdOptions inst2XsdOptions, TypeSystemHolder typeSystemHolder) {
        for (XmlObject xmlObject : xmlObjectArr) {
            XmlCursor newCursor = xmlObject.newCursor();
            StringBuffer stringBuffer = new StringBuffer();
            while (!newCursor.isStart()) {
                newCursor.toNextToken();
                if (newCursor.isComment()) {
                    stringBuffer.append(newCursor.getTextValue());
                } else if (newCursor.isEnddoc()) {
                    return;
                }
            }
            Element processElement = processElement(newCursor, stringBuffer.toString(), inst2XsdOptions, typeSystemHolder);
            processElement.setGlobal(true);
            addGlobalElement(processElement, typeSystemHolder, inst2XsdOptions);
        }
    }

    protected Element addGlobalElement(Element element, TypeSystemHolder typeSystemHolder, Inst2XsdOptions inst2XsdOptions) {
        if (!$assertionsDisabled && !element.isGlobal()) {
            throw new AssertionError();
        }
        Element globalElement = typeSystemHolder.getGlobalElement(element.getName());
        if (globalElement == null) {
            typeSystemHolder.addGlobalElement(element);
            return element;
        }
        combineTypes(globalElement.getType(), element.getType(), inst2XsdOptions);
        combineElementComments(globalElement, element);
        return globalElement;
    }

    protected Element processElement(XmlCursor xmlCursor, String str, Inst2XsdOptions inst2XsdOptions, TypeSystemHolder typeSystemHolder) {
        String str2 = str;
        if (!$assertionsDisabled && !xmlCursor.isStart()) {
            throw new AssertionError();
        }
        Element element = new Element();
        element.setName(xmlCursor.getName());
        element.setGlobal(false);
        Type createUnnamedType = Type.createUnnamedType(1);
        element.setType(createUnnamedType);
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        while (true) {
            switch (xmlCursor.toNextToken().intValue()) {
                case 0:
                case 2:
                case 4:
                    String collapse = XmlWhitespace.collapse(stringBuffer.toString(), 3);
                    if (str2 == null) {
                        str2 = stringBuffer2.length() == 0 ? null : stringBuffer2.toString();
                    } else if (stringBuffer2.length() != 0) {
                        str2 = stringBuffer2.insert(0, str2).toString();
                    }
                    element.setComment(str2);
                    if (arrayList.size() > 0) {
                        if (collapse.length() > 0) {
                            createUnnamedType.setContentType(4);
                        } else {
                            createUnnamedType.setContentType(3);
                        }
                        processElementsInComplexType(createUnnamedType, arrayList, element.getName().getNamespaceURI(), typeSystemHolder, inst2XsdOptions);
                        processAttributesInComplexType(createUnnamedType, arrayList2);
                    } else {
                        XmlCursor newCursor = xmlCursor.newCursor();
                        newCursor.toParent();
                        if (arrayList2.size() > 0) {
                            createUnnamedType.setContentType(2);
                            createUnnamedType.setExtensionType(Type.createNamedType(processSimpleContentType(stringBuffer.toString(), inst2XsdOptions, newCursor), 1));
                            processAttributesInComplexType(createUnnamedType, arrayList2);
                        } else {
                            createUnnamedType.setContentType(1);
                            createUnnamedType.setName(processSimpleContentType(stringBuffer.toString(), inst2XsdOptions, newCursor));
                            if (XmlString.type.getName().equals(createUnnamedType.getName())) {
                                collapse = stringBuffer.toString();
                            }
                            createUnnamedType.addEnumerationValue(collapse, newCursor);
                        }
                        newCursor.dispose();
                    }
                    checkIfReferenceToGlobalTypeIsNeeded(element, typeSystemHolder, inst2XsdOptions);
                    return element;
                case 1:
                    throw new IllegalStateException();
                case 3:
                    arrayList.add(processElement(xmlCursor, stringBuffer2.toString(), inst2XsdOptions, typeSystemHolder));
                    stringBuffer2.delete(0, stringBuffer2.length());
                    break;
                case 5:
                    stringBuffer.append(xmlCursor.getChars());
                    break;
                case 6:
                    QName name = xmlCursor.getName();
                    QName qName = _xsiNil;
                    if (!qName.getNamespaceURI().equals(name.getNamespaceURI())) {
                        arrayList2.add(processAttribute(xmlCursor, inst2XsdOptions, element.getName().getNamespaceURI(), typeSystemHolder));
                        break;
                    } else if (!qName.equals(name)) {
                        break;
                    } else {
                        element.setNillable(true);
                        break;
                    }
                case 7:
                case 9:
                    break;
                case 8:
                    stringBuffer2.append(xmlCursor.getTextValue());
                    break;
                default:
                    throw new IllegalStateException("Unknown TokenType.");
            }
        }
    }

    protected void processElementsInComplexType(Type type, List list, String str, TypeSystemHolder typeSystemHolder, Inst2XsdOptions inst2XsdOptions) {
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        Element element = null;
        while (it.hasNext()) {
            Element element2 = (Element) it.next();
            if (element == null) {
                checkIfElementReferenceIsNeeded(element2, str, typeSystemHolder, inst2XsdOptions);
                type.addElement(element2);
                hashMap.put(element2.getName(), element2);
            } else if (element.getName() == element2.getName()) {
                combineTypes(element.getType(), element2.getType(), inst2XsdOptions);
                combineElementComments(element, element2);
                element.setMinOccurs(0);
                element.setMaxOccurs(-1);
            } else if (((Element) hashMap.get(element2.getName())) == null) {
                checkIfElementReferenceIsNeeded(element2, str, typeSystemHolder, inst2XsdOptions);
                type.addElement(element2);
                hashMap.put(element2.getName(), element2);
            } else {
                combineTypes(element.getType(), element2.getType(), inst2XsdOptions);
                combineElementComments(element, element2);
                type.setTopParticleForComplexOrMixedContent(2);
            }
            element = element2;
        }
    }

    protected void checkIfElementReferenceIsNeeded(Element element, String str, TypeSystemHolder typeSystemHolder, Inst2XsdOptions inst2XsdOptions) {
        if (element.getName().getNamespaceURI().equals(str)) {
            return;
        }
        Element element2 = new Element();
        element2.setGlobal(true);
        element2.setName(element.getName());
        element2.setType(element.getType());
        if (element.isNillable()) {
            element2.setNillable(true);
            element.setNillable(false);
        }
        element.setRef(addGlobalElement(element2, typeSystemHolder, inst2XsdOptions));
    }

    protected void processAttributesInComplexType(Type type, List list) {
        if (!$assertionsDisabled && !type.isComplexType()) {
            throw new AssertionError();
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            type.addAttribute((Attribute) it.next());
        }
    }

    protected Attribute processAttribute(XmlCursor xmlCursor, Inst2XsdOptions inst2XsdOptions, String str, TypeSystemHolder typeSystemHolder) {
        if (!$assertionsDisabled && !xmlCursor.isAttr()) {
            throw new AssertionError("xc not on attribute");
        }
        Attribute attribute = new Attribute();
        attribute.setName(xmlCursor.getName());
        XmlCursor newCursor = xmlCursor.newCursor();
        newCursor.toParent();
        Type createNamedType = Type.createNamedType(processSimpleContentType(xmlCursor.getTextValue(), inst2XsdOptions, newCursor), 1);
        newCursor.dispose();
        attribute.setType(createNamedType);
        checkIfAttributeReferenceIsNeeded(attribute, str, typeSystemHolder);
        return attribute;
    }

    protected void checkIfAttributeReferenceIsNeeded(Attribute attribute, String str, TypeSystemHolder typeSystemHolder) {
        if (attribute.getName().getNamespaceURI().equals("") || attribute.getName().getNamespaceURI().equals(str)) {
            return;
        }
        Attribute attribute2 = new Attribute();
        attribute2.setGlobal(true);
        attribute2.setName(attribute.getName());
        attribute2.setType(attribute.getType());
        typeSystemHolder.addGlobalAttribute(attribute2);
        attribute.setRef(attribute2);
    }

    protected class SCTValidationContext implements ValidationContext {
        protected boolean valid = true;

        protected SCTValidationContext() {
        }

        public boolean isValid() {
            return this.valid;
        }

        public void resetToValid() {
            this.valid = true;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidationContext
        public void invalid(String str) {
            this.valid = false;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidationContext
        public void invalid(String str, Object[] objArr) {
            this.valid = false;
        }
    }

    protected QName processSimpleContentType(String str, Inst2XsdOptions inst2XsdOptions, final XmlCursor xmlCursor) {
        if (inst2XsdOptions.getSimpleContentTypes() == 2) {
            return XmlString.type.getName();
        }
        if (inst2XsdOptions.getSimpleContentTypes() != 1) {
            throw new IllegalArgumentException(new StringBuffer().append("Unknown value for Inst2XsdOptions.getSimpleContentTypes() :").append(inst2XsdOptions.getSimpleContentTypes()).toString());
        }
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                XsTypeConverter.lexByte(str);
                                return XmlByte.type.getName();
                            } catch (Exception unused) {
                                XmlDateImpl.validateLexical(str, XmlDate.type, this._validationContext);
                                if (this._validationContext.isValid()) {
                                    return XmlDate.type.getName();
                                }
                                this._validationContext.resetToValid();
                                XmlDateTimeImpl.validateLexical(str, XmlDateTime.type, this._validationContext);
                                if (this._validationContext.isValid()) {
                                    return XmlDateTime.type.getName();
                                }
                                this._validationContext.resetToValid();
                                XmlTimeImpl.validateLexical(str, XmlTime.type, this._validationContext);
                                if (this._validationContext.isValid()) {
                                    return XmlTime.type.getName();
                                }
                                this._validationContext.resetToValid();
                                XmlDurationImpl.validateLexical(str, XmlDuration.type, this._validationContext);
                                if (this._validationContext.isValid()) {
                                    return XmlDuration.type.getName();
                                }
                                this._validationContext.resetToValid();
                                if (str.startsWith("http://") || str.startsWith("www.")) {
                                    XmlAnyUriImpl.validateLexical(str, this._validationContext);
                                    if (this._validationContext.isValid()) {
                                        return XmlAnyURI.type.getName();
                                    }
                                    this._validationContext.resetToValid();
                                }
                                int indexOf = str.indexOf(58);
                                if (indexOf >= 0 && indexOf == str.lastIndexOf(58) && indexOf + 1 < str.length()) {
                                    XmlQNameImpl.validateLexical(str, this._validationContext, new PrefixResolver() { // from class: org.apache.xmlbeans.impl.inst2xsd.RussianDollStrategy.1
                                        @Override // org.apache.xmlbeans.impl.common.PrefixResolver
                                        public String getNamespaceForPrefix(String str2) {
                                            return xmlCursor.namespaceForPrefix(str2);
                                        }
                                    });
                                    if (this._validationContext.isValid()) {
                                        return XmlQName.type.getName();
                                    }
                                    this._validationContext.resetToValid();
                                }
                                return XmlString.type.getName();
                            }
                        } catch (Exception unused2) {
                            XsTypeConverter.lexLong(str);
                            return XmlLong.type.getName();
                        }
                    } catch (Exception unused3) {
                        XsTypeConverter.lexFloat(str);
                        return XmlFloat.type.getName();
                    }
                } catch (Exception unused4) {
                    XsTypeConverter.lexInt(str);
                    return XmlInt.type.getName();
                }
            } catch (Exception unused5) {
                XsTypeConverter.lexInteger(str);
                return XmlInteger.type.getName();
            }
        } catch (Exception unused6) {
            XsTypeConverter.lexShort(str);
            return XmlShort.type.getName();
        }
    }

    protected void combineTypes(Type type, Type type2, Inst2XsdOptions inst2XsdOptions) {
        if (type == type2) {
            return;
        }
        if (type.isGlobal() && type2.isGlobal() && type.getName().equals(type2.getName())) {
            return;
        }
        if (type.getContentType() == 1 && type2.getContentType() == 1) {
            combineSimpleTypes(type, type2, inst2XsdOptions);
            return;
        }
        if ((type.getContentType() == 1 || type.getContentType() == 2) && (type2.getContentType() == 1 || type2.getContentType() == 2)) {
            QName name = type.isComplexType() ? type.getExtensionType().getName() : type.getName();
            QName name2 = type2.isComplexType() ? type2.getExtensionType().getName() : type2.getName();
            type.setContentType(2);
            QName combineToMoreGeneralSimpleType = combineToMoreGeneralSimpleType(name, name2);
            if (type.isComplexType()) {
                type.setExtensionType(Type.createNamedType(combineToMoreGeneralSimpleType, 1));
            } else {
                type.setName(combineToMoreGeneralSimpleType);
            }
            combineAttributesOfTypes(type, type2);
            return;
        }
        if (type.getContentType() == 3 && type2.getContentType() == 3) {
            combineAttributesOfTypes(type, type2);
            combineElementsOfTypes(type, type2, false, inst2XsdOptions);
            return;
        }
        if (type.getContentType() == 1 || type.getContentType() == 2 || type2.getContentType() == 1 || type2.getContentType() == 2) {
            type.setContentType(4);
            combineAttributesOfTypes(type, type2);
            combineElementsOfTypes(type, type2, true, inst2XsdOptions);
        } else {
            if ((type.getContentType() == 1 || type.getContentType() == 2 || type.getContentType() == 3 || type.getContentType() == 4) && (type2.getContentType() == 1 || type2.getContentType() == 2 || type2.getContentType() == 3 || type2.getContentType() == 4)) {
                type.setContentType(4);
                combineAttributesOfTypes(type, type2);
                combineElementsOfTypes(type, type2, false, inst2XsdOptions);
                return;
            }
            throw new IllegalArgumentException("Unknown content type.");
        }
    }

    protected void combineSimpleTypes(Type type, Type type2, Inst2XsdOptions inst2XsdOptions) {
        if (!$assertionsDisabled && (type.getContentType() != 1 || type2.getContentType() != 1)) {
            throw new AssertionError("Invalid arguments");
        }
        type.setName(combineToMoreGeneralSimpleType(type.getName(), type2.getName()));
        if (inst2XsdOptions.isUseEnumerations()) {
            type.addAllEnumerationsFrom(type2);
            if (type.getEnumerationValues().size() > inst2XsdOptions.getUseEnumerations()) {
                type.closeEnumeration();
            }
        }
    }

    protected QName combineToMoreGeneralSimpleType(QName qName, QName qName2) {
        return qName.equals(qName2) ? qName : (qName2.equals(XmlShort.type.getName()) && qName.equals(XmlByte.type.getName())) ? qName2 : (qName.equals(XmlShort.type.getName()) && qName2.equals(XmlByte.type.getName())) ? qName : (qName2.equals(XmlInt.type.getName()) && (qName.equals(XmlShort.type.getName()) || qName.equals(XmlByte.type.getName()))) ? qName2 : (qName.equals(XmlInt.type.getName()) && (qName2.equals(XmlShort.type.getName()) || qName2.equals(XmlByte.type.getName()))) ? qName : (qName2.equals(XmlLong.type.getName()) && (qName.equals(XmlInt.type.getName()) || qName.equals(XmlShort.type.getName()) || qName.equals(XmlByte.type.getName()))) ? qName2 : (qName.equals(XmlLong.type.getName()) && (qName2.equals(XmlInt.type.getName()) || qName2.equals(XmlShort.type.getName()) || qName2.equals(XmlByte.type.getName()))) ? qName : (qName2.equals(XmlInteger.type.getName()) && (qName.equals(XmlLong.type.getName()) || qName.equals(XmlInt.type.getName()) || qName.equals(XmlShort.type.getName()) || qName.equals(XmlByte.type.getName()))) ? qName2 : (qName.equals(XmlInteger.type.getName()) && (qName2.equals(XmlLong.type.getName()) || qName2.equals(XmlInt.type.getName()) || qName2.equals(XmlShort.type.getName()) || qName2.equals(XmlByte.type.getName()))) ? qName : (qName2.equals(XmlFloat.type.getName()) && (qName.equals(XmlInteger.type.getName()) || qName.equals(XmlLong.type.getName()) || qName.equals(XmlInt.type.getName()) || qName.equals(XmlShort.type.getName()) || qName.equals(XmlByte.type.getName()))) ? qName2 : (qName.equals(XmlFloat.type.getName()) && (qName2.equals(XmlInteger.type.getName()) || qName2.equals(XmlLong.type.getName()) || qName2.equals(XmlInt.type.getName()) || qName2.equals(XmlShort.type.getName()) || qName2.equals(XmlByte.type.getName()))) ? qName : XmlString.type.getName();
    }

    protected void combineAttributesOfTypes(Type type, Type type2) {
        for (int i = 0; i < type2.getAttributes().size(); i++) {
            Attribute attribute = (Attribute) type2.getAttributes().get(i);
            int i2 = 0;
            while (true) {
                if (i2 < type.getAttributes().size()) {
                    Attribute attribute2 = (Attribute) type.getAttributes().get(i2);
                    if (attribute2.getName().equals(attribute.getName())) {
                        attribute2.getType().setName(combineToMoreGeneralSimpleType(attribute2.getType().getName(), attribute.getType().getName()));
                        break;
                    }
                    i2++;
                } else {
                    type.addAttribute(attribute);
                    break;
                }
            }
        }
        for (int i3 = 0; i3 < type.getAttributes().size(); i3++) {
            Attribute attribute3 = (Attribute) type.getAttributes().get(i3);
            for (int i4 = 0; i4 < type2.getAttributes().size(); i4++) {
                ((Attribute) type2.getAttributes().get(i4)).getName().equals(attribute3.getName());
            }
            attribute3.setOptional(true);
        }
    }

    protected void combineElementsOfTypes(Type type, Type type2, boolean z, Inst2XsdOptions inst2XsdOptions) {
        boolean z2 = (type.getTopParticleForComplexOrMixedContent() == 1 && type2.getTopParticleForComplexOrMixedContent() == 1) ? false : true;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; !z2 && i4 < type.getElements().size(); i4++) {
            Element element = (Element) type.getElements().get(i4);
            int i5 = i;
            while (true) {
                if (i5 >= type2.getElements().size()) {
                    break;
                }
                if (element.getName().equals(((Element) type2.getElements().get(i5)).getName())) {
                    i2 = i5;
                    break;
                }
                i5++;
            }
            if (i2 < i) {
                arrayList.add(element);
                element.setMinOccurs(0);
            } else {
                int i6 = i;
                while (true) {
                    if (i6 >= i2) {
                        break;
                    }
                    Element element2 = (Element) type2.getElements().get(i6);
                    for (int i7 = i4 + 1; i7 < type.getElements().size(); i7++) {
                        if (element2.getName().equals(((Element) type.getElements().get(i7)).getName())) {
                            i3 = i7;
                            break;
                        }
                    }
                    i6++;
                }
                if (i3 < i4) {
                    while (i < i2) {
                        Element element3 = (Element) type2.getElements().get(i);
                        arrayList.add(element3);
                        element3.setMinOccurs(0);
                        i++;
                    }
                    arrayList.add(element);
                    Element element4 = (Element) type2.getElements().get(i2);
                    if (element4.getMinOccurs() <= 0) {
                        element.setMinOccurs(0);
                    }
                    if (element4.getMaxOccurs() == -1) {
                        element.setMaxOccurs(-1);
                    }
                    combineTypes(element.getType(), element4.getType(), inst2XsdOptions);
                    combineElementComments(element, element4);
                    i = i2 + 1;
                } else {
                    z2 = true;
                }
            }
        }
        while (i < type2.getElements().size()) {
            Element element5 = (Element) type2.getElements().get(i);
            arrayList.add(element5);
            element5.setMinOccurs(0);
            i++;
        }
        if (z2) {
            type.setTopParticleForComplexOrMixedContent(2);
            for (int i8 = 0; i8 < type2.getElements().size(); i8++) {
                Element element6 = (Element) type2.getElements().get(i8);
                for (int i9 = 0; i9 < type.getElements().size(); i9++) {
                    Element element7 = (Element) type.getElements().get(i9);
                    element7.setMinOccurs(1);
                    element7.setMaxOccurs(1);
                    if (element7 != element6) {
                        if (element7.getName().equals(element6.getName())) {
                            combineTypes(element7.getType(), element6.getType(), inst2XsdOptions);
                            combineElementComments(element7, element6);
                        }
                    }
                }
                type.addElement(element6);
                element6.setMinOccurs(1);
                element6.setMaxOccurs(1);
            }
            return;
        }
        type.setElements(arrayList);
    }

    protected void combineElementComments(Element element, Element element2) {
        if (element2.getComment() == null || element2.getComment().length() <= 0) {
            return;
        }
        if (element.getComment() == null) {
            element.setComment(element2.getComment());
        } else {
            element.setComment(new StringBuffer().append(element.getComment()).append(element2.getComment()).toString());
        }
    }
}
