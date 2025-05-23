package com.wutka.dtd;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Vector;

/* loaded from: classes3.dex */
public class DTDEnumeration implements DTDOutput {
    protected Vector items = new Vector();

    public void add(String str) {
        this.items.addElement(str);
    }

    public void remove(String str) {
        this.items.removeElement(str);
    }

    public String[] getItems() {
        String[] strArr = new String[this.items.size()];
        this.items.copyInto(strArr);
        return strArr;
    }

    public Vector getItemsVec() {
        return this.items;
    }

    @Override // com.wutka.dtd.DTDOutput
    public void write(PrintWriter printWriter) throws IOException {
        printWriter.print("( ");
        Enumeration elements = getItemsVec().elements();
        boolean z = true;
        while (elements.hasMoreElements()) {
            if (!z) {
                printWriter.print(" | ");
            }
            z = false;
            printWriter.print(elements.nextElement());
        }
        printWriter.print(")");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof DTDEnumeration) {
            return this.items.equals(((DTDEnumeration) obj).items);
        }
        return false;
    }

    public String[] getItem() {
        return getItems();
    }

    public void setItem(String[] strArr) {
        this.items = new Vector(strArr.length);
        for (String str : strArr) {
            this.items.addElement(str);
        }
    }

    public void setItem(String str, int i) {
        this.items.setElementAt(str, i);
    }

    public String getItem(int i) {
        return (String) this.items.elementAt(i);
    }
}