package org.apache.xmlbeans.impl.inst2xsd.util;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.math.BigInteger;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.apache.xmlbeans.impl.xb.xsdschema.ComplexType;
import org.apache.xmlbeans.impl.xb.xsdschema.ExplicitGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.FormChoice;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalElement;
import org.apache.xmlbeans.impl.xb.xsdschema.NoFixedFacet;
import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleExtensionType;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelAttribute;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelComplexType;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelElement;

/* loaded from: classes5.dex */
public class TypeSystemHolder {
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$inst2xsd$util$TypeSystemHolder;
    Map _globalElements = new LinkedHashMap();
    Map _globalAttributes = new LinkedHashMap();
    Map _globalTypes = new LinkedHashMap();

    static {
        if (class$org$apache$xmlbeans$impl$inst2xsd$util$TypeSystemHolder == null) {
            class$org$apache$xmlbeans$impl$inst2xsd$util$TypeSystemHolder = class$("org.apache.xmlbeans.impl.inst2xsd.util.TypeSystemHolder");
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

    public void addGlobalElement(Element element) {
        if (!$assertionsDisabled && (!element.isGlobal() || element.isRef())) {
            throw new AssertionError();
        }
        this._globalElements.put(element.getName(), element);
    }

    public Element getGlobalElement(QName qName) {
        return (Element) this._globalElements.get(qName);
    }

    public Element[] getGlobalElements() {
        Collection values = this._globalElements.values();
        return (Element[]) values.toArray(new Element[values.size()]);
    }

    public void addGlobalAttribute(Attribute attribute) {
        if (!$assertionsDisabled && (!attribute.isGlobal() || attribute.isRef())) {
            throw new AssertionError();
        }
        this._globalAttributes.put(attribute.getName(), attribute);
    }

    public Attribute getGlobalAttribute(QName qName) {
        return (Attribute) this._globalAttributes.get(qName);
    }

    public Attribute[] getGlobalAttributes() {
        Collection values = this._globalAttributes.values();
        return (Attribute[]) values.toArray(new Attribute[values.size()]);
    }

    public void addGlobalType(Type type) {
        if (!$assertionsDisabled && (!type.isGlobal() || type.getName() == null)) {
            throw new AssertionError("type must be a global type before being added.");
        }
        this._globalTypes.put(type.getName(), type);
    }

    public Type getGlobalType(QName qName) {
        return (Type) this._globalTypes.get(qName);
    }

    public Type[] getGlobalTypes() {
        Collection values = this._globalTypes.values();
        return (Type[]) values.toArray(new Type[values.size()]);
    }

    public SchemaDocument[] getSchemaDocuments() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (QName qName : this._globalElements.keySet()) {
            String namespaceURI = qName.getNamespaceURI();
            fillUpGlobalElement((Element) this._globalElements.get(qName), getSchemaDocumentForTNS(linkedHashMap, namespaceURI), namespaceURI);
        }
        for (QName qName2 : this._globalAttributes.keySet()) {
            String namespaceURI2 = qName2.getNamespaceURI();
            fillUpGlobalAttribute((Attribute) this._globalAttributes.get(qName2), getSchemaDocumentForTNS(linkedHashMap, namespaceURI2), namespaceURI2);
        }
        for (QName qName3 : this._globalTypes.keySet()) {
            String namespaceURI3 = qName3.getNamespaceURI();
            fillUpGlobalType((Type) this._globalTypes.get(qName3), getSchemaDocumentForTNS(linkedHashMap, namespaceURI3), namespaceURI3);
        }
        Collection values = linkedHashMap.values();
        return (SchemaDocument[]) values.toArray(new SchemaDocument[values.size()]);
    }

    private static SchemaDocument getSchemaDocumentForTNS(Map map, String str) {
        SchemaDocument schemaDocument = (SchemaDocument) map.get(str);
        if (schemaDocument != null) {
            return schemaDocument;
        }
        SchemaDocument newInstance = SchemaDocument.Factory.newInstance();
        map.put(str, newInstance);
        return newInstance;
    }

    private static SchemaDocument.Schema getTopLevelSchemaElement(SchemaDocument schemaDocument, String str) {
        SchemaDocument.Schema schema = schemaDocument.getSchema();
        if (schema == null) {
            schema = schemaDocument.addNewSchema();
            schema.setAttributeFormDefault(FormChoice.Enum.forString("unqualified"));
            schema.setElementFormDefault(FormChoice.Enum.forString("qualified"));
            if (!str.equals("")) {
                schema.setTargetNamespace(str);
            }
        }
        return schema;
    }

    private void fillUpGlobalElement(Element element, SchemaDocument schemaDocument, String str) {
        if (!$assertionsDisabled && !str.equals(element.getName().getNamespaceURI())) {
            throw new AssertionError();
        }
        TopLevelElement addNewElement = getTopLevelSchemaElement(schemaDocument, str).addNewElement();
        addNewElement.setName(element.getName().getLocalPart());
        if (element.isNillable()) {
            addNewElement.setNillable(element.isNillable());
        }
        fillUpElementDocumentation(addNewElement, element.getComment());
        fillUpTypeOnElement(element.getType(), addNewElement, str);
    }

    protected void fillUpLocalElement(Element element, LocalElement localElement, String str) {
        fillUpElementDocumentation(localElement, element.getComment());
        if (!element.isRef()) {
            if (!$assertionsDisabled && !element.getName().getNamespaceURI().equals(str) && element.getName().getNamespaceURI().length() != 0) {
                throw new AssertionError();
            }
            fillUpTypeOnElement(element.getType(), localElement, str);
            localElement.setName(element.getName().getLocalPart());
        } else {
            localElement.setRef(element.getName());
            if (!$assertionsDisabled && element.isNillable()) {
                throw new AssertionError();
            }
        }
        if (element.getMaxOccurs() == -1) {
            localElement.setMaxOccurs("unbounded");
        }
        if (element.getMinOccurs() != 1) {
            localElement.setMinOccurs(new BigInteger(new StringBuffer().append("").append(element.getMinOccurs()).toString()));
        }
        if (element.isNillable()) {
            localElement.setNillable(element.isNillable());
        }
    }

    private void fillUpTypeOnElement(Type type, org.apache.xmlbeans.impl.xb.xsdschema.Element element, String str) {
        if (type.isGlobal()) {
            if (!$assertionsDisabled && type.getName() == null) {
                throw new AssertionError("Global type must have a name.");
            }
            element.setType(type.getName());
            return;
        }
        if (type.getContentType() == 1) {
            if (type.isEnumeration()) {
                fillUpEnumeration(type, element);
                return;
            } else {
                element.setType(type.getName());
                return;
            }
        }
        fillUpContentForComplexType(type, element.addNewComplexType(), str);
    }

    private void fillUpEnumeration(Type type, org.apache.xmlbeans.impl.xb.xsdschema.Element element) {
        if (!$assertionsDisabled && (!type.isEnumeration() || type.isComplexType())) {
            throw new AssertionError("Enumerations must be on simple types only.");
        }
        RestrictionDocument.Restriction addNewRestriction = element.addNewSimpleType().addNewRestriction();
        addNewRestriction.setBase(type.getName());
        int i = 0;
        if (type.isQNameEnumeration()) {
            while (i < type.getEnumerationQNames().size()) {
                QName qName = (QName) type.getEnumerationQNames().get(i);
                XmlQName.Factory.newValue(qName);
                NoFixedFacet addNewEnumeration = addNewRestriction.addNewEnumeration();
                XmlCursor newCursor = addNewEnumeration.newCursor();
                String prefixForNamespace = newCursor.prefixForNamespace(qName.getNamespaceURI());
                newCursor.dispose();
                addNewEnumeration.setValue(XmlQName.Factory.newValue(new QName(qName.getNamespaceURI(), qName.getLocalPart(), prefixForNamespace)));
                i++;
            }
            return;
        }
        while (i < type.getEnumerationValues().size()) {
            addNewRestriction.addNewEnumeration().setValue(XmlString.Factory.newValue((String) type.getEnumerationValues().get(i)));
            i++;
        }
    }

    private void fillUpAttributesInComplexTypesSimpleContent(Type type, SimpleExtensionType simpleExtensionType, String str) {
        for (int i = 0; i < type.getAttributes().size(); i++) {
            fillUpLocalAttribute((Attribute) type.getAttributes().get(i), simpleExtensionType.addNewAttribute(), str);
        }
    }

    private void fillUpAttributesInComplexTypesComplexContent(Type type, ComplexType complexType, String str) {
        for (int i = 0; i < type.getAttributes().size(); i++) {
            fillUpLocalAttribute((Attribute) type.getAttributes().get(i), complexType.addNewAttribute(), str);
        }
    }

    protected void fillUpLocalAttribute(Attribute attribute, org.apache.xmlbeans.impl.xb.xsdschema.Attribute attribute2, String str) {
        if (attribute.isRef()) {
            attribute2.setRef(attribute.getRef().getName());
            return;
        }
        if (!$assertionsDisabled && attribute.getName().getNamespaceURI() != str && !attribute.getName().getNamespaceURI().equals("")) {
            throw new AssertionError();
        }
        attribute2.setType(attribute.getType().getName());
        attribute2.setName(attribute.getName().getLocalPart());
        if (attribute.isOptional()) {
            attribute2.setUse(Attribute.Use.OPTIONAL);
        }
    }

    protected void fillUpContentForComplexType(Type type, ComplexType complexType, String str) {
        ExplicitGroup addNewChoice;
        if (type.getContentType() == 2) {
            SimpleContentDocument.SimpleContent addNewSimpleContent = complexType.addNewSimpleContent();
            if (!$assertionsDisabled && (type.getExtensionType() == null || type.getExtensionType().getName() == null)) {
                throw new AssertionError("Extension type must exist and be named for a COMPLEX_TYPE_SIMPLE_CONTENT");
            }
            SimpleExtensionType addNewExtension = addNewSimpleContent.addNewExtension();
            addNewExtension.setBase(type.getExtensionType().getName());
            fillUpAttributesInComplexTypesSimpleContent(type, addNewExtension, str);
            return;
        }
        if (type.getContentType() == 4) {
            complexType.setMixed(true);
        }
        if (type.getContentType() == 5) {
            addNewChoice = null;
        } else if (type.getTopParticleForComplexOrMixedContent() == 1) {
            addNewChoice = complexType.addNewSequence();
        } else if (type.getTopParticleForComplexOrMixedContent() == 2) {
            addNewChoice = complexType.addNewChoice();
            addNewChoice.setMaxOccurs("unbounded");
            addNewChoice.setMinOccurs(new BigInteger(SessionDescription.SUPPORTED_SDP_VERSION));
        } else {
            throw new IllegalStateException("Unknown particle type in complex and mixed content");
        }
        for (int i = 0; i < type.getElements().size(); i++) {
            Element element = (Element) type.getElements().get(i);
            if (!$assertionsDisabled && element.isGlobal()) {
                throw new AssertionError();
            }
            fillUpLocalElement(element, addNewChoice.addNewElement(), str);
        }
        fillUpAttributesInComplexTypesComplexContent(type, complexType, str);
    }

    private void fillUpGlobalAttribute(Attribute attribute, SchemaDocument schemaDocument, String str) {
        if (!$assertionsDisabled && !str.equals(attribute.getName().getNamespaceURI())) {
            throw new AssertionError();
        }
        TopLevelAttribute addNewAttribute = getTopLevelSchemaElement(schemaDocument, str).addNewAttribute();
        addNewAttribute.setName(attribute.getName().getLocalPart());
        Type type = attribute.getType();
        if (type.getContentType() == 1) {
            addNewAttribute.setType(type.getName());
            return;
        }
        throw new IllegalStateException();
    }

    private static void fillUpElementDocumentation(org.apache.xmlbeans.impl.xb.xsdschema.Element element, String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        element.addNewAnnotation().addNewDocumentation().set(XmlString.Factory.newValue(str));
    }

    private void fillUpGlobalType(Type type, SchemaDocument schemaDocument, String str) {
        if (!$assertionsDisabled && !str.equals(type.getName().getNamespaceURI())) {
            throw new AssertionError();
        }
        TopLevelComplexType addNewComplexType = getTopLevelSchemaElement(schemaDocument, str).addNewComplexType();
        addNewComplexType.setName(type.getName().getLocalPart());
        fillUpContentForComplexType(type, addNewComplexType, str);
    }

    public String toString() {
        return new StringBuffer().append("TypeSystemHolder{\n\n_globalElements=").append(this._globalElements).append("\n\n_globalAttributes=").append(this._globalAttributes).append("\n\n_globalTypes=").append(this._globalTypes).append("\n}").toString();
    }
}
