package javax.xml.transform.stream;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import javax.xml.transform.Source;
import net.lingala.zip4j.util.InternalZipConstants;

/* loaded from: classes4.dex */
public class StreamSource implements Source {
    public static final String FEATURE = "http://javax.xml.transform.stream.StreamSource/feature";
    private InputStream inputStream;
    private String publicId;
    private Reader reader;
    private String systemId;

    public StreamSource() {
    }

    public StreamSource(File file) {
        setSystemId(file);
    }

    public StreamSource(InputStream inputStream) {
        setInputStream(inputStream);
    }

    public StreamSource(InputStream inputStream, String str) {
        setInputStream(inputStream);
        setSystemId(str);
    }

    public StreamSource(Reader reader) {
        setReader(reader);
    }

    public StreamSource(Reader reader, String str) {
        setReader(reader);
        setSystemId(str);
    }

    public StreamSource(String str) {
        this.systemId = str;
    }

    public InputStream getInputStream() {
        return this.inputStream;
    }

    public String getPublicId() {
        return this.publicId;
    }

    public Reader getReader() {
        return this.reader;
    }

    @Override // javax.xml.transform.Source
    public String getSystemId() {
        return this.systemId;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void setPublicId(String str) {
        this.publicId = str;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
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

    @Override // javax.xml.transform.Source
    public void setSystemId(String str) {
        this.systemId = str;
    }
}
