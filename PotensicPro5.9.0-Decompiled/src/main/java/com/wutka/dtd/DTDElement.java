package com.wutka.dtd;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class DTDElement implements DTDOutput {
    public Hashtable attributes = new Hashtable();
    public DTDItem content;
    public String name;

    public DTDElement() {
    }

    public DTDElement(String str) {
        this.name = str;
    }

    @Override // com.wutka.dtd.DTDOutput
    public void write(PrintWriter printWriter) throws IOException {
        printWriter.print("<!ELEMENT ");
        printWriter.print(this.name);
        printWriter.print(StringUtils.SPACE);
        DTDItem dTDItem = this.content;
        if (dTDItem != null) {
            dTDItem.write(printWriter);
        } else {
            printWriter.print("ANY");
        }
        printWriter.println(">");
        printWriter.println();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DTDElement)) {
            return false;
        }
        DTDElement dTDElement = (DTDElement) obj;
        String str = this.name;
        if (str == null) {
            if (dTDElement.name != null) {
                return false;
            }
        } else if (!str.equals(dTDElement.name)) {
            return false;
        }
        Hashtable hashtable = this.attributes;
        if (hashtable == null) {
            if (dTDElement.attributes != null) {
                return false;
            }
        } else if (!hashtable.equals(dTDElement.attributes)) {
            return false;
        }
        DTDItem dTDItem = this.content;
        if (dTDItem == null) {
            if (dTDElement.content != null) {
                return false;
            }
        } else if (!dTDItem.equals(dTDElement.content)) {
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

    public void setAttribute(String str, DTDAttribute dTDAttribute) {
        this.attributes.put(str, dTDAttribute);
    }

    public DTDAttribute getAttribute(String str) {
        return (DTDAttribute) this.attributes.get(str);
    }

    public void setContent(DTDItem dTDItem) {
        this.content = dTDItem;
    }

    public DTDItem getContent() {
        return this.content;
    }
}
