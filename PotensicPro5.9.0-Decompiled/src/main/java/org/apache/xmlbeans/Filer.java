package org.apache.xmlbeans;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/* loaded from: classes5.dex */
public interface Filer {
    OutputStream createBinaryFile(String str) throws IOException;

    Writer createSourceFile(String str) throws IOException;
}
