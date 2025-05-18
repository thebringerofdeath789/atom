package com.wutka.dtd;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/* loaded from: classes3.dex */
public class DTDChoice extends DTDContainer {
    @Override // com.wutka.dtd.DTDContainer, com.wutka.dtd.DTDItem, com.wutka.dtd.DTDOutput
    public void write(PrintWriter printWriter) throws IOException {
        printWriter.print("(");
        Enumeration elements = getItemsVec().elements();
        boolean z = true;
        while (elements.hasMoreElements()) {
            if (!z) {
                printWriter.print(" | ");
            }
            z = false;
            ((DTDItem) elements.nextElement()).write(printWriter);
        }
        printWriter.print(")");
        this.cardinal.write(printWriter);
    }

    @Override // com.wutka.dtd.DTDContainer, com.wutka.dtd.DTDItem
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof DTDChoice) {
            return super.equals(obj);
        }
        return false;
    }
}