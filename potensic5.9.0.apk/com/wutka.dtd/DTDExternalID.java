package com.wutka.dtd;

import java.io.IOException;
import java.io.PrintWriter;

/* loaded from: classes3.dex */
public abstract class DTDExternalID implements DTDOutput {
    public String system;

    @Override // com.wutka.dtd.DTDOutput
    public abstract void write(PrintWriter printWriter) throws IOException;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DTDExternalID)) {
            return false;
        }
        DTDExternalID dTDExternalID = (DTDExternalID) obj;
        String str = this.system;
        if (str == null) {
            if (dTDExternalID.system != null) {
                return false;
            }
        } else if (!str.equals(dTDExternalID.system)) {
            return false;
        }
        return true;
    }

    public void setSystem(String str) {
        this.system = str;
    }

    public String getSystem() {
        return this.system;
    }
}