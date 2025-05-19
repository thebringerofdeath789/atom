package javax.xml.parsers;

import com.opencsv.ICSVParser;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* loaded from: classes4.dex */
public abstract class DocumentBuilder {
    protected DocumentBuilder() {
    }

    public abstract DOMImplementation getDOMImplementation();

    public abstract boolean isNamespaceAware();

    public abstract boolean isValidating();

    public abstract Document newDocument();

    public Document parse(File file) throws SAXException, IOException {
        if (file == null) {
            throw new IllegalArgumentException("File cannot be null");
        }
        String stringBuffer = new StringBuffer().append("file:").append(file.getAbsolutePath()).toString();
        if (File.separatorChar == '\\') {
            stringBuffer = stringBuffer.replace(ICSVParser.DEFAULT_ESCAPE_CHARACTER, '/');
        }
        return parse(new InputSource(stringBuffer));
    }

    public Document parse(InputStream inputStream) throws SAXException, IOException {
        if (inputStream != null) {
            return parse(new InputSource(inputStream));
        }
        throw new IllegalArgumentException("InputStream cannot be null");
    }

    public Document parse(InputStream inputStream, String str) throws SAXException, IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("InputStream cannot be null");
        }
        InputSource inputSource = new InputSource(inputStream);
        inputSource.setSystemId(str);
        return parse(inputSource);
    }

    public Document parse(String str) throws SAXException, IOException {
        if (str != null) {
            return parse(new InputSource(str));
        }
        throw new IllegalArgumentException("URI cannot be null");
    }

    public abstract Document parse(InputSource inputSource) throws SAXException, IOException;

    public abstract void setEntityResolver(EntityResolver entityResolver);

    public abstract void setErrorHandler(ErrorHandler errorHandler);
}
