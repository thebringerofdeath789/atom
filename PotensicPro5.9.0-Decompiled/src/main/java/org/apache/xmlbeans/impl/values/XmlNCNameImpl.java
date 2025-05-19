package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.common.XMLChar;

/* loaded from: classes5.dex */
public class XmlNCNameImpl extends JavaStringHolderEx implements XmlNCName {
    public XmlNCNameImpl() {
        super(XmlNCName.type, false);
    }

    public XmlNCNameImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }

    public static void validateLexical(String str, ValidationContext validationContext) {
        if (XMLChar.isValidNCName(str)) {
            return;
        }
        validationContext.invalid(XmlErrorCodes.NCNAME, new Object[]{str});
    }
}
