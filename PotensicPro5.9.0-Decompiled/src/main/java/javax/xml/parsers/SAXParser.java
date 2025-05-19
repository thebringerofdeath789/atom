package javax.xml.parsers;

import com.opencsv.ICSVParser;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.xml.sax.HandlerBase;
import org.xml.sax.InputSource;
import org.xml.sax.Parser;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes4.dex */
public abstract class SAXParser {
    protected SAXParser() {
    }

    public abstract Parser getParser() throws SAXException;

    public abstract Object getProperty(String str) throws SAXNotRecognizedException, SAXNotSupportedException;

    public abstract XMLReader getXMLReader() throws SAXException;

    public abstract boolean isNamespaceAware();

    public abstract boolean isValidating();

    public void parse(File file, HandlerBase handlerBase) throws SAXException, IOException {
        if (file == null) {
            throw new IllegalArgumentException("File cannot be null");
        }
        String stringBuffer = new StringBuffer().append("file:").append(file.getAbsolutePath()).toString();
        if (File.separatorChar == '\\') {
            stringBuffer = stringBuffer.replace(ICSVParser.DEFAULT_ESCAPE_CHARACTER, '/');
        }
        parse(new InputSource(stringBuffer), handlerBase);
    }

    public void parse(File file, DefaultHandler defaultHandler) throws SAXException, IOException {
        if (file == null) {
            throw new IllegalArgumentException("File cannot be null");
        }
        String stringBuffer = new StringBuffer().append("file:").append(file.getAbsolutePath()).toString();
        if (File.separatorChar == '\\') {
            stringBuffer = stringBuffer.replace(ICSVParser.DEFAULT_ESCAPE_CHARACTER, '/');
        }
        parse(new InputSource(stringBuffer), defaultHandler);
    }

    public void parse(InputStream inputStream, HandlerBase handlerBase) throws SAXException, IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("InputStream cannot be null");
        }
        parse(new InputSource(inputStream), handlerBase);
    }

    public void parse(InputStream inputStream, HandlerBase handlerBase, String str) throws SAXException, IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("InputStream cannot be null");
        }
        InputSource inputSource = new InputSource(inputStream);
        inputSource.setSystemId(str);
        parse(inputSource, handlerBase);
    }

    public void parse(InputStream inputStream, DefaultHandler defaultHandler) throws SAXException, IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("InputStream cannot be null");
        }
        parse(new InputSource(inputStream), defaultHandler);
    }

    public void parse(InputStream inputStream, DefaultHandler defaultHandler, String str) throws SAXException, IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("InputStream cannot be null");
        }
        InputSource inputSource = new InputSource(inputStream);
        inputSource.setSystemId(str);
        parse(inputSource, defaultHandler);
    }

    public void parse(String str, HandlerBase handlerBase) throws SAXException, IOException {
        if (str == null) {
            throw new IllegalArgumentException("uri cannot be null");
        }
        parse(new InputSource(str), handlerBase);
    }

    public void parse(String str, DefaultHandler defaultHandler) throws SAXException, IOException {
        if (str == null) {
            throw new IllegalArgumentException("uri cannot be null");
        }
        parse(new InputSource(str), defaultHandler);
    }

    public void parse(InputSource inputSource, HandlerBase handlerBase) throws SAXException, IOException {
        if (inputSource == null) {
            throw new IllegalArgumentException("InputSource cannot be null");
        }
        Parser parser = getParser();
        if (handlerBase != null) {
            parser.setDocumentHandler(handlerBase);
            parser.setEntityResolver(handlerBase);
            parser.setErrorHandler(handlerBase);
            parser.setDTDHandler(handlerBase);
        }
        parser.parse(inputSource);
    }

    public void parse(InputSource inputSource, DefaultHandler defaultHandler) throws SAXException, IOException {
        if (inputSource == null) {
            throw new IllegalArgumentException("InputSource cannot be null");
        }
        XMLReader xMLReader = getXMLReader();
        if (defaultHandler != null) {
            xMLReader.setContentHandler(defaultHandler);
            xMLReader.setEntityResolver(defaultHandler);
            xMLReader.setErrorHandler(defaultHandler);
            xMLReader.setDTDHandler(defaultHandler);
        }
        xMLReader.parse(inputSource);
    }

    public abstract void setProperty(String str, Object obj) throws SAXNotRecognizedException, SAXNotSupportedException;
}
