package org.apache.xmlbeans.impl.inst2xsd;

import org.apache.xmlbeans.impl.inst2xsd.util.Element;
import org.apache.xmlbeans.impl.inst2xsd.util.TypeSystemHolder;

/* loaded from: classes5.dex */
public class SalamiSliceStrategy extends RussianDollStrategy implements XsdGenStrategy {
    @Override // org.apache.xmlbeans.impl.inst2xsd.RussianDollStrategy
    protected void checkIfElementReferenceIsNeeded(Element element, String str, TypeSystemHolder typeSystemHolder, Inst2XsdOptions inst2XsdOptions) {
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
}
