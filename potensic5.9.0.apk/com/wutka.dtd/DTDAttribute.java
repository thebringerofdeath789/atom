package com.wutka.dtd;

import java.io.IOException;
import java.io.PrintWriter;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class DTDAttribute implements DTDOutput {
    public DTDDecl decl;
    public String defaultValue;
    public String name;
    public Object type;

    public DTDAttribute() {
    }

    public DTDAttribute(String str) {
        this.name = str;
    }

    @Override // com.wutka.dtd.DTDOutput
    public void write(PrintWriter printWriter) throws IOException {
        printWriter.print(new StringBuffer().append(this.name).append(StringUtils.SPACE).toString());
        Object obj = this.type;
        if (obj instanceof String) {
            printWriter.print(obj);
        } else if (obj instanceof DTDEnumeration) {
            ((DTDEnumeration) obj).write(printWriter);
        } else if (obj instanceof DTDNotationList) {
            ((DTDNotationList) obj).write(printWriter);
        }
        DTDDecl dTDDecl = this.decl;
        if (dTDDecl != null) {
            dTDDecl.write(printWriter);
        }
        if (this.defaultValue != null) {
            printWriter.print(" \"");
            printWriter.print(this.defaultValue);
            printWriter.print("\"");
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DTDAttribute)) {
            return false;
        }
        DTDAttribute dTDAttribute = (DTDAttribute) obj;
        String str = this.name;
        if (str == null) {
            if (dTDAttribute.name != null) {
                return false;
            }
        } else if (!str.equals(dTDAttribute.name)) {
            return false;
        }
        Object obj2 = this.type;
        if (obj2 == null) {
            if (dTDAttribute.type != null) {
                return false;
            }
        } else if (!obj2.equals(dTDAttribute.type)) {
            return false;
        }
        DTDDecl dTDDecl = this.decl;
        if (dTDDecl == null) {
            if (dTDAttribute.decl != null) {
                return false;
            }
        } else if (!dTDDecl.equals(dTDAttribute.decl)) {
            return false;
        }
        String str2 = this.defaultValue;
        if (str2 == null) {
            if (dTDAttribute.defaultValue != null) {
                return false;
            }
        } else if (!str2.equals(dTDAttribute.defaultValue)) {
            return false;
        }
        return true;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public void setType(Object obj) {
        if (!(obj instanceof String) && !(obj instanceof DTDEnumeration) && !(obj instanceof DTDNotationList)) {
            throw new IllegalArgumentException("Must be String, DTDEnumeration or DTDNotationList");
        }
        this.type = obj;
    }

    public Object getType() {
        return this.type;
    }

    public void setDecl(DTDDecl dTDDecl) {
        this.decl = dTDDecl;
    }

    public DTDDecl getDecl() {
        return this.decl;
    }

    public void setDefaultValue(String str) {
        this.defaultValue = str;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }
}