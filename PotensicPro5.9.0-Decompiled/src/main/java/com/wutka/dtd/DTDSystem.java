package com.wutka.dtd;

import java.io.PrintWriter;

/* loaded from: classes3.dex */
public class DTDSystem extends DTDExternalID {
    @Override // com.wutka.dtd.DTDExternalID, com.wutka.dtd.DTDOutput
    public void write(PrintWriter printWriter) {
        if (this.system != null) {
            printWriter.print("SYSTEM \"");
            printWriter.print(this.system);
            printWriter.print("\"");
        }
    }

    @Override // com.wutka.dtd.DTDExternalID
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof DTDSystem) {
            return super.equals(obj);
        }
        return false;
    }
}
