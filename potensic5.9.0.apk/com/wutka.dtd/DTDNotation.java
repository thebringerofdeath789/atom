package com.wutka.dtd;

import java.io.IOException;
import java.io.PrintWriter;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class DTDNotation implements DTDOutput {
    public DTDExternalID externalID;
    public String name;

    public DTDNotation() {
    }

    public DTDNotation(String str) {
        this.name = str;
    }

    @Override // com.wutka.dtd.DTDOutput
    public void write(PrintWriter printWriter) throws IOException {
        printWriter.print("<!NOTATION ");
        printWriter.print(this.name);
        printWriter.print(StringUtils.SPACE);
        this.externalID.write(printWriter);
        printWriter.println(">");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DTDNotation)) {
            return false;
        }
        DTDNotation dTDNotation = (DTDNotation) obj;
        String str = this.name;
        if (str == null) {
            if (dTDNotation.name != null) {
                return false;
            }
        } else if (!str.equals(dTDNotation.name)) {
            return false;
        }
        DTDExternalID dTDExternalID = this.externalID;
        if (dTDExternalID == null) {
            if (dTDNotation.externalID != null) {
                return false;
            }
        } else if (!dTDExternalID.equals(dTDNotation.externalID)) {
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

    public void setExternalID(DTDExternalID dTDExternalID) {
        this.externalID = dTDExternalID;
    }

    public DTDExternalID getExternalID() {
        return this.externalID;
    }
}