package com.wutka.dtd;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* loaded from: classes3.dex */
public class DTD implements DTDOutput {
    public DTDElement rootElement;
    public Hashtable elements = new Hashtable();
    public Hashtable entities = new Hashtable();
    public Hashtable notations = new Hashtable();
    public Hashtable externalDTDs = new Hashtable();
    public Vector items = new Vector();

    @Override // com.wutka.dtd.DTDOutput
    public void write(PrintWriter printWriter) throws IOException {
        Enumeration elements = this.items.elements();
        while (elements.hasMoreElements()) {
            ((DTDOutput) elements.nextElement()).write(printWriter);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DTD) {
            return this.items.equals(((DTD) obj).items);
        }
        return false;
    }

    public void setItems(Object[] objArr) {
        this.items = new Vector(objArr.length);
        for (Object obj : objArr) {
            this.items.addElement(obj);
        }
    }

    public Object[] getItems() {
        return this.items.toArray();
    }

    public void setItem(Object obj, int i) {
        this.items.setElementAt(obj, i);
    }

    public Object getItem(int i) {
        return this.items.elementAt(i);
    }

    public Vector getItemsByType(Class cls) {
        Vector vector = new Vector();
        Enumeration elements = this.items.elements();
        while (elements.hasMoreElements()) {
            Object nextElement = elements.nextElement();
            if (cls.isAssignableFrom(nextElement.getClass())) {
                vector.addElement(nextElement);
            }
        }
        return vector;
    }
}