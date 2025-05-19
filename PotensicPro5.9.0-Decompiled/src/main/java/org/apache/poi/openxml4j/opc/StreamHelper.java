package org.apache.poi.openxml4j.opc;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.commons.lang3.BooleanUtils;
import org.w3c.dom.Document;

/* loaded from: classes5.dex */
public final class StreamHelper {
    private static final TransformerFactory transformerFactory = TransformerFactory.newInstance();

    private StreamHelper() {
    }

    private static synchronized Transformer getIdentityTransformer() throws TransformerException {
        Transformer newTransformer;
        synchronized (StreamHelper.class) {
            newTransformer = transformerFactory.newTransformer();
        }
        return newTransformer;
    }

    public static boolean saveXmlInStream(Document document, OutputStream outputStream) {
        try {
            Transformer identityTransformer = getIdentityTransformer();
            DOMSource dOMSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new FilterOutputStream(outputStream) { // from class: org.apache.poi.openxml4j.opc.StreamHelper.1
                @Override // java.io.FilterOutputStream, java.io.OutputStream
                public void write(byte[] bArr, int i, int i2) throws IOException {
                    this.out.write(bArr, i, i2);
                }

                @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    this.out.flush();
                }
            });
            identityTransformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            identityTransformer.setOutputProperty(OutputKeys.INDENT, BooleanUtils.YES);
            identityTransformer.setOutputProperty(OutputKeys.STANDALONE, BooleanUtils.YES);
            identityTransformer.transform(dOMSource, streamResult);
            return true;
        } catch (TransformerException unused) {
            return false;
        }
    }

    public static boolean copyStream(InputStream inputStream, OutputStream outputStream) {
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read < 0) {
                    return true;
                }
                outputStream.write(bArr, 0, read);
            }
        } catch (Exception unused) {
            return false;
        }
    }
}
