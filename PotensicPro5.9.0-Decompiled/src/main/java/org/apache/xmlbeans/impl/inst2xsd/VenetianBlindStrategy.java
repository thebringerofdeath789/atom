package org.apache.xmlbeans.impl.inst2xsd;

import aavax.xml.namespace.QName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.xmlbeans.impl.inst2xsd.util.Element;
import org.apache.xmlbeans.impl.inst2xsd.util.Type;
import org.apache.xmlbeans.impl.inst2xsd.util.TypeSystemHolder;

/* loaded from: classes5.dex */
public class VenetianBlindStrategy extends RussianDollStrategy implements XsdGenStrategy {
    private boolean compatibleTypes(Type type, Type type2) {
        if (type == type2) {
        }
        return true;
    }

    @Override // org.apache.xmlbeans.impl.inst2xsd.RussianDollStrategy
    protected void checkIfReferenceToGlobalTypeIsNeeded(Element element, TypeSystemHolder typeSystemHolder, Inst2XsdOptions inst2XsdOptions) {
        Type type = element.getType();
        QName name = element.getName();
        if (type.isGlobal() || !type.isComplexType()) {
            return;
        }
        int i = 0;
        while (true) {
            type.setName(new QName(name.getNamespaceURI(), new StringBuffer().append(name.getLocalPart()).append(PackageRelationship.TYPE_ATTRIBUTE_NAME).append(i != 0 ? new StringBuffer().append("").append(i).toString() : "").toString()));
            Type globalType = typeSystemHolder.getGlobalType(type.getName());
            if (globalType == null) {
                type.setGlobal(true);
                typeSystemHolder.addGlobalType(type);
                return;
            } else {
                if (compatibleTypes(globalType, type)) {
                    combineTypes(globalType, type, inst2XsdOptions);
                    element.setType(globalType);
                    return;
                }
                i++;
            }
        }
    }
}
