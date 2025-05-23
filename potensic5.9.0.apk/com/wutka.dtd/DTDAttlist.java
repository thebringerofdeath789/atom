package com.wutka.dtd;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Vector;

/* loaded from: classes3.dex */
public class DTDAttlist implements DTDOutput {
    public Vector attributes = new Vector();
    public String name;

    public DTDAttlist() {
    }

    public DTDAttlist(String str) {
        this.name = str;
    }

    @Override // com.wutka.dtd.DTDOutput
    public void write(PrintWriter printWriter) throws IOException {
        printWriter.print("<!ATTLIST ");
        printWriter.println(this.name);
        Iterator it = this.attributes.iterator();
        while (it.hasNext()) {
            printWriter.print("           ");
            ((DTDAttribute) it.next()).write(printWriter);
            if (it.hasNext()) {
                printWriter.println();
            } else {
                printWriter.println(">");
            }
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DTDAttlist)) {
            return false;
        }
        DTDAttlist dTDAttlist = (DTDAttlist) obj;
        String str = this.name;
        if (str == null && dTDAttlist.name != null) {
            return false;
        }
        if (str == null || str.equals(dTDAttlist.name)) {
            return this.attributes.equals(dTDAttlist.attributes);
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public DTDAttribute[] getAttribute() {
        DTDAttribute[] dTDAttributeArr = new DTDAttribute[this.attributes.size()];
        this.attributes.copyInto(dTDAttributeArr);
        return dTDAttributeArr;
    }

    public void setAttribute(DTDAttribute[] dTDAttributeArr) {
        this.attributes = new Vector(dTDAttributeArr.length);
        for (DTDAttribute dTDAttribute : dTDAttributeArr) {
            this.attributes.addElement(dTDAttribute);
        }
    }

    public DTDAttribute getAttribute(int i) {
        return (DTDAttribute) this.attributes.elementAt(i);
    }

    public void setAttribute(DTDAttribute dTDAttribute, int i) {
        this.attributes.setElementAt(dTDAttribute, i);
    }
}