package org.jdom.transform;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.transform.sax.SAXResult;
import org.jdom.DefaultJDOMFactory;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMFactory;
import org.jdom.input.SAXHandler;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.XMLFilterImpl;

/* loaded from: classes5.dex */
public class JDOMResult extends SAXResult {
    private static final String CVS_ID = "@(#) $RCSfile: JDOMResult.java,v $ $Revision: 1.23 $ $Date: 2004/08/31 06:10:38 $ $Name: jdom_1_0 $";
    public static final String JDOM_FEATURE = "http://org.jdom.transform.JDOMResult/feature";
    private Object result = null;
    private boolean queried = false;
    private JDOMFactory factory = null;

    @Override // javax.xml.transform.sax.SAXResult
    public void setHandler(ContentHandler contentHandler) {
    }

    @Override // javax.xml.transform.sax.SAXResult
    public void setLexicalHandler(LexicalHandler lexicalHandler) {
    }

    public JDOMResult() {
        DocumentBuilder documentBuilder = new DocumentBuilder();
        super.setHandler(documentBuilder);
        super.setLexicalHandler(documentBuilder);
    }

    public void setResult(List list) {
        this.result = list;
        this.queried = false;
    }

    public List getResult() {
        List list = Collections.EMPTY_LIST;
        retrieveResult();
        Object obj = this.result;
        if (obj instanceof List) {
            list = (List) obj;
        } else if ((obj instanceof Document) && !this.queried) {
            List content = ((Document) obj).getContent();
            ArrayList arrayList = new ArrayList(content.size());
            while (content.size() != 0) {
                arrayList.add(content.remove(0));
            }
            this.result = arrayList;
            list = arrayList;
        }
        this.queried = true;
        return list;
    }

    public void setDocument(Document document) {
        this.result = document;
        this.queried = false;
    }

    public Document getDocument() {
        retrieveResult();
        Object obj = this.result;
        Document document = null;
        if (obj instanceof Document) {
            document = (Document) obj;
        } else if ((obj instanceof List) && !this.queried) {
            try {
                JDOMFactory factory = getFactory();
                if (factory == null) {
                    factory = new DefaultJDOMFactory();
                }
                document = factory.document(null);
                document.setContent((List) this.result);
                this.result = document;
            } catch (RuntimeException unused) {
            }
        }
        this.queried = true;
        return document;
    }

    public void setFactory(JDOMFactory jDOMFactory) {
        this.factory = jDOMFactory;
    }

    public JDOMFactory getFactory() {
        return this.factory;
    }

    private void retrieveResult() {
        if (this.result == null) {
            setResult(((DocumentBuilder) getHandler()).getResult());
        }
    }

    private static class FragmentHandler extends SAXHandler {
        private Element dummyRoot;

        public FragmentHandler(JDOMFactory jDOMFactory) {
            super(jDOMFactory);
            Element element = new Element("root", null, null);
            this.dummyRoot = element;
            pushElement(element);
        }

        public List getResult() {
            try {
                flushCharacters();
            } catch (SAXException unused) {
            }
            return getDetachedContent(this.dummyRoot);
        }

        private List getDetachedContent(Element element) {
            List content = element.getContent();
            ArrayList arrayList = new ArrayList(content.size());
            while (content.size() != 0) {
                arrayList.add(content.remove(0));
            }
            return arrayList;
        }
    }

    private class DocumentBuilder extends XMLFilterImpl implements LexicalHandler {
        private FragmentHandler saxHandler = null;
        private boolean startDocumentReceived = false;

        public DocumentBuilder() {
        }

        public List getResult() {
            FragmentHandler fragmentHandler = this.saxHandler;
            if (fragmentHandler == null) {
                return null;
            }
            List result = fragmentHandler.getResult();
            this.saxHandler = null;
            this.startDocumentReceived = false;
            return result;
        }

        private void ensureInitialization() throws SAXException {
            if (this.startDocumentReceived) {
                return;
            }
            startDocument();
        }

        @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
        public void startDocument() throws SAXException {
            this.startDocumentReceived = true;
            JDOMResult.this.setResult(null);
            FragmentHandler fragmentHandler = new FragmentHandler(JDOMResult.this.getFactory());
            this.saxHandler = fragmentHandler;
            super.setContentHandler(fragmentHandler);
            super.startDocument();
        }

        @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            ensureInitialization();
            super.startElement(str, str2, str3, attributes);
        }

        @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
        public void startPrefixMapping(String str, String str2) throws SAXException {
            ensureInitialization();
            super.startPrefixMapping(str, str2);
        }

        @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) throws SAXException {
            ensureInitialization();
            super.characters(cArr, i, i2);
        }

        @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
        public void ignorableWhitespace(char[] cArr, int i, int i2) throws SAXException {
            ensureInitialization();
            super.ignorableWhitespace(cArr, i, i2);
        }

        @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
        public void processingInstruction(String str, String str2) throws SAXException {
            ensureInitialization();
            super.processingInstruction(str, str2);
        }

        @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
        public void skippedEntity(String str) throws SAXException {
            ensureInitialization();
            super.skippedEntity(str);
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void startDTD(String str, String str2, String str3) throws SAXException {
            ensureInitialization();
            this.saxHandler.startDTD(str, str2, str3);
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void endDTD() throws SAXException {
            this.saxHandler.endDTD();
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void startEntity(String str) throws SAXException {
            ensureInitialization();
            this.saxHandler.startEntity(str);
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void endEntity(String str) throws SAXException {
            this.saxHandler.endEntity(str);
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void startCDATA() throws SAXException {
            ensureInitialization();
            this.saxHandler.startCDATA();
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void endCDATA() throws SAXException {
            this.saxHandler.endCDATA();
        }

        @Override // org.xml.sax.ext.LexicalHandler
        public void comment(char[] cArr, int i, int i2) throws SAXException {
            ensureInitialization();
            this.saxHandler.comment(cArr, i, i2);
        }
    }
}
