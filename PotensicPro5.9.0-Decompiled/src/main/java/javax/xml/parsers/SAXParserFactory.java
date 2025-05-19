package javax.xml.parsers;

import javax.xml.parsers.FactoryFinder;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

/* loaded from: classes4.dex */
public abstract class SAXParserFactory {
    private boolean validating = false;
    private boolean namespaceAware = false;

    protected SAXParserFactory() {
    }

    public static SAXParserFactory newInstance() throws FactoryConfigurationError {
        try {
            return (SAXParserFactory) FactoryFinder.find("javax.xml.parsers.SAXParserFactory", null);
        } catch (FactoryFinder.ConfigurationError e) {
            throw new FactoryConfigurationError(e.getException(), e.getMessage());
        }
    }

    public abstract boolean getFeature(String str) throws ParserConfigurationException, SAXNotRecognizedException, SAXNotSupportedException;

    public boolean isNamespaceAware() {
        return this.namespaceAware;
    }

    public boolean isValidating() {
        return this.validating;
    }

    public abstract SAXParser newSAXParser() throws ParserConfigurationException, SAXException;

    public abstract void setFeature(String str, boolean z) throws ParserConfigurationException, SAXNotRecognizedException, SAXNotSupportedException;

    public void setNamespaceAware(boolean z) {
        this.namespaceAware = z;
    }

    public void setValidating(boolean z) {
        this.validating = z;
    }
}
