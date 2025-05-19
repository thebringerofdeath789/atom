package org.jdom.transform;

import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.transform.sax.SAXSource;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.output.SAXOutputter;
import org.jdom.output.XMLOutputter;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLFilter;
import org.xml.sax.XMLReader;

/* loaded from: classes5.dex */
public class JDOMSource extends SAXSource {
    private static final String CVS_ID = "@(#) $RCSfile: JDOMSource.java,v $ $Revision: 1.18 $ $Date: 2004/08/31 04:43:48 $ $Name: jdom_1_0 $";
    public static final String JDOM_FEATURE = "http://org.jdom.transform.JDOMSource/feature";
    private XMLReader xmlReader = null;

    public JDOMSource(Document document) {
        setDocument(document);
    }

    public JDOMSource(List list) {
        setNodes(list);
    }

    public JDOMSource(Element element) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(element);
        setNodes(arrayList);
    }

    public void setDocument(Document document) {
        super.setInputSource(new JDOMInputSource(document));
    }

    public Document getDocument() {
        Object source = ((JDOMInputSource) getInputSource()).getSource();
        if (source instanceof Document) {
            return (Document) source;
        }
        return null;
    }

    public void setNodes(List list) {
        super.setInputSource(new JDOMInputSource(list));
    }

    public List getNodes() {
        Object source = ((JDOMInputSource) getInputSource()).getSource();
        if (source instanceof List) {
            return (List) source;
        }
        return null;
    }

    @Override // javax.xml.transform.sax.SAXSource
    public void setInputSource(InputSource inputSource) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override // javax.xml.transform.sax.SAXSource
    public void setXMLReader(XMLReader xMLReader) throws UnsupportedOperationException {
        if (xMLReader instanceof XMLFilter) {
            XMLReader xMLReader2 = xMLReader;
            while (true) {
                XMLFilter xMLFilter = (XMLFilter) xMLReader2;
                if (xMLFilter.getParent() instanceof XMLFilter) {
                    xMLReader2 = xMLFilter.getParent();
                } else {
                    xMLFilter.setParent(new DocumentReader());
                    this.xmlReader = xMLReader;
                    return;
                }
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override // javax.xml.transform.sax.SAXSource
    public XMLReader getXMLReader() {
        if (this.xmlReader == null) {
            this.xmlReader = new DocumentReader();
        }
        return this.xmlReader;
    }

    private static class JDOMInputSource extends InputSource {
        private Object source;

        public JDOMInputSource(Document document) {
            this.source = null;
            this.source = document;
        }

        public JDOMInputSource(List list) {
            this.source = null;
            this.source = list;
        }

        public Object getSource() {
            return this.source;
        }

        @Override // org.xml.sax.InputSource
        public void setCharacterStream(Reader reader) throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        @Override // org.xml.sax.InputSource
        public Reader getCharacterStream() {
            Object source = getSource();
            if (source instanceof Document) {
                return new StringReader(new XMLOutputter().outputString((Document) source));
            }
            if (source instanceof List) {
                return new StringReader(new XMLOutputter().outputString((List) source));
            }
            return null;
        }
    }

    private static class DocumentReader extends SAXOutputter implements XMLReader {
        @Override // org.xml.sax.XMLReader
        public void parse(String str) throws SAXNotSupportedException {
            throw new SAXNotSupportedException("Only JDOM Documents are supported as input");
        }

        @Override // org.xml.sax.XMLReader
        public void parse(InputSource inputSource) throws SAXException {
            if (inputSource instanceof JDOMInputSource) {
                try {
                    Object source = ((JDOMInputSource) inputSource).getSource();
                    if (source instanceof Document) {
                        output((Document) source);
                        return;
                    } else {
                        output((List) source);
                        return;
                    }
                } catch (JDOMException e) {
                    throw new SAXException(e.getMessage(), e);
                }
            }
            throw new SAXNotSupportedException("Only JDOM Documents are supported as input");
        }
    }
}
