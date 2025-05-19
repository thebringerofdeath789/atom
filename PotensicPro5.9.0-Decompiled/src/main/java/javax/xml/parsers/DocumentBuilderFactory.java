package javax.xml.parsers;

import javax.xml.parsers.FactoryFinder;

/* loaded from: classes4.dex */
public abstract class DocumentBuilderFactory {
    private boolean validating = false;
    private boolean namespaceAware = false;
    private boolean whitespace = false;
    private boolean expandEntityRef = true;
    private boolean ignoreComments = false;
    private boolean coalescing = false;

    protected DocumentBuilderFactory() {
    }

    public static DocumentBuilderFactory newInstance() throws FactoryConfigurationError {
        try {
            return (DocumentBuilderFactory) FactoryFinder.find("javax.xml.parsers.DocumentBuilderFactory", null);
        } catch (FactoryFinder.ConfigurationError e) {
            throw new FactoryConfigurationError(e.getException(), e.getMessage());
        }
    }

    public abstract Object getAttribute(String str) throws IllegalArgumentException;

    public boolean isCoalescing() {
        return this.coalescing;
    }

    public boolean isExpandEntityReferences() {
        return this.expandEntityRef;
    }

    public boolean isIgnoringComments() {
        return this.ignoreComments;
    }

    public boolean isIgnoringElementContentWhitespace() {
        return this.whitespace;
    }

    public boolean isNamespaceAware() {
        return this.namespaceAware;
    }

    public boolean isValidating() {
        return this.validating;
    }

    public abstract DocumentBuilder newDocumentBuilder() throws ParserConfigurationException;

    public abstract void setAttribute(String str, Object obj) throws IllegalArgumentException;

    public void setCoalescing(boolean z) {
        this.coalescing = z;
    }

    public void setExpandEntityReferences(boolean z) {
        this.expandEntityRef = z;
    }

    public void setIgnoringComments(boolean z) {
        this.ignoreComments = z;
    }

    public void setIgnoringElementContentWhitespace(boolean z) {
        this.whitespace = z;
    }

    public void setNamespaceAware(boolean z) {
        this.namespaceAware = z;
    }

    public void setValidating(boolean z) {
        this.validating = z;
    }
}
