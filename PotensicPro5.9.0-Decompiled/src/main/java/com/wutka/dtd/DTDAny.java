package com.wutka.dtd;

import java.io.IOException;
import java.io.PrintWriter;

/* loaded from: classes3.dex */
public class DTDAny extends DTDItem {
    @Override // com.wutka.dtd.DTDItem, com.wutka.dtd.DTDOutput
    public void write(PrintWriter printWriter) throws IOException {
        printWriter.print("ANY");
        this.cardinal.write(printWriter);
    }

    @Override // com.wutka.dtd.DTDItem
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof DTDAny) {
            return super.equals(obj);
        }
        return false;
    }
}
