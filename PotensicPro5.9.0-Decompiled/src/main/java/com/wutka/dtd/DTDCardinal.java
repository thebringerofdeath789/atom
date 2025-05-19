package com.wutka.dtd;

import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import java.io.IOException;
import java.io.PrintWriter;

/* loaded from: classes3.dex */
public class DTDCardinal implements DTDOutput {
    public String name;
    public int type;
    public static final DTDCardinal NONE = new DTDCardinal(0, "NONE");
    public static final DTDCardinal OPTIONAL = new DTDCardinal(1, "OPTIONAL");
    public static final DTDCardinal ZEROMANY = new DTDCardinal(2, "ZEROMANY");
    public static final DTDCardinal ONEMANY = new DTDCardinal(3, "ONEMANY");

    public DTDCardinal(int i, String str) {
        this.type = i;
        this.name = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof DTDCardinal) && ((DTDCardinal) obj).type == this.type;
    }

    @Override // com.wutka.dtd.DTDOutput
    public void write(PrintWriter printWriter) throws IOException {
        if (this == NONE) {
            return;
        }
        if (this == OPTIONAL) {
            printWriter.print("?");
        } else if (this == ZEROMANY) {
            printWriter.print(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD);
        } else if (this == ONEMANY) {
            printWriter.print("+");
        }
    }
}
