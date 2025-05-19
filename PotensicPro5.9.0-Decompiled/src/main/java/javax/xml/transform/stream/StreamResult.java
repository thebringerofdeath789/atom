package javax.xml.transform.stream;

import java.io.File;
import java.io.OutputStream;
import java.io.Writer;
import javax.xml.transform.Result;
import net.lingala.zip4j.util.InternalZipConstants;

/* loaded from: classes4.dex */
public class StreamResult implements Result {
    public static final String FEATURE = "http://javax.xml.transform.stream.StreamResult/feature";
    private OutputStream outputStream;
    private String systemId;
    private Writer writer;

    public StreamResult() {
    }

    public StreamResult(File file) {
        setSystemId(file);
    }

    public StreamResult(OutputStream outputStream) {
        setOutputStream(outputStream);
    }

    public StreamResult(Writer writer) {
        setWriter(writer);
    }

    public StreamResult(String str) {
        this.systemId = str;
    }

    public OutputStream getOutputStream() {
        return this.outputStream;
    }

    @Override // javax.xml.transform.Result
    public String getSystemId() {
        return this.systemId;
    }

    public Writer getWriter() {
        return this.writer;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void setSystemId(File file) {
        StringBuffer stringBuffer;
        String str;
        String absolutePath = file.getAbsolutePath();
        if (File.separatorChar != '/') {
            absolutePath = absolutePath.replace(File.separatorChar, '/');
        }
        if (absolutePath.startsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            stringBuffer = new StringBuffer();
            str = "file://";
        } else {
            stringBuffer = new StringBuffer();
            str = "file:///";
        }
        this.systemId = stringBuffer.append(str).append(absolutePath).toString();
    }

    @Override // javax.xml.transform.Result
    public void setSystemId(String str) {
        this.systemId = str;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }
}
