package javax.xml.transform.sax;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

/* loaded from: classes4.dex */
public class SAXSource implements Source {
    public static final String FEATURE = "http://javax.xml.transform.sax.SAXSource/feature";
    private InputSource inputSource;
    private XMLReader reader;

    public SAXSource() {
    }

    public SAXSource(InputSource inputSource) {
        this.inputSource = inputSource;
    }

    public SAXSource(XMLReader xMLReader, InputSource inputSource) {
        this.reader = xMLReader;
        this.inputSource = inputSource;
    }

    public static InputSource sourceToInputSource(Source source) {
        if (source instanceof SAXSource) {
            return ((SAXSource) source).getInputSource();
        }
        if (!(source instanceof StreamSource)) {
            return null;
        }
        StreamSource streamSource = (StreamSource) source;
        InputSource inputSource = new InputSource(streamSource.getSystemId());
        inputSource.setByteStream(streamSource.getInputStream());
        inputSource.setCharacterStream(streamSource.getReader());
        inputSource.setPublicId(streamSource.getPublicId());
        return inputSource;
    }

    public InputSource getInputSource() {
        return this.inputSource;
    }

    @Override // javax.xml.transform.Source
    public String getSystemId() {
        InputSource inputSource = this.inputSource;
        if (inputSource != null) {
            return inputSource.getSystemId();
        }
        return null;
    }

    public XMLReader getXMLReader() {
        return this.reader;
    }

    public void setInputSource(InputSource inputSource) {
        this.inputSource = inputSource;
    }

    @Override // javax.xml.transform.Source
    public void setSystemId(String str) {
        InputSource inputSource = this.inputSource;
        if (inputSource == null) {
            this.inputSource = new InputSource(str);
        } else {
            inputSource.setSystemId(str);
        }
    }

    public void setXMLReader(XMLReader xMLReader) {
        this.reader = xMLReader;
    }
}
