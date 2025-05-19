package org.apache.xmlbeans.impl.validator;

import aavax.xml.namespace.QName;
import aavax.xml.stream.Location;
import java.util.AbstractCollection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XMLStreamValidationException;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.GenericXmlInputStream;
import org.apache.xmlbeans.impl.common.ValidatorListener;
import org.apache.xmlbeans.impl.common.XMLNameHelper;
import org.apache.xmlbeans.impl.common.XmlWhitespace;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;
import org.apache.xmlbeans.xml.stream.Attribute;
import org.apache.xmlbeans.xml.stream.AttributeIterator;
import org.apache.xmlbeans.xml.stream.CharacterData;
import org.apache.xmlbeans.xml.stream.StartElement;
import org.apache.xmlbeans.xml.stream.XMLEvent;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLName;
import org.apache.xmlbeans.xml.stream.XMLStreamException;

/* loaded from: classes5.dex */
public final class ValidatingXMLInputStream extends GenericXmlInputStream implements ValidatorListener.Event {
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$validator$ValidatingXMLInputStream;
    private XMLStreamValidationException _exception;
    private boolean _finished;
    private XMLName _name;
    private XMLInputStream _source;
    private StartElement _startElement;
    private StringBuffer _text = new StringBuffer();
    private Validator _validator;
    private String _xsiLoc;
    private String _xsiNil;
    private String _xsiNoLoc;
    private String _xsiType;

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public XmlCursor getLocationAsCursor() {
        return null;
    }

    static {
        if (class$org$apache$xmlbeans$impl$validator$ValidatingXMLInputStream == null) {
            class$org$apache$xmlbeans$impl$validator$ValidatingXMLInputStream = class$("org.apache.xmlbeans.impl.validator.ValidatingXMLInputStream");
        }
        $assertionsDisabled = true;
    }

    public ValidatingXMLInputStream(XMLInputStream xMLInputStream, SchemaTypeLoader schemaTypeLoader, SchemaType schemaType, XmlOptions xmlOptions) throws XMLStreamException {
        SchemaType findDocumentType;
        this._source = xMLInputStream;
        XmlOptions maskNull = XmlOptions.maskNull(xmlOptions);
        SchemaType schemaType2 = (SchemaType) maskNull.get(XmlOptions.DOCUMENT_TYPE);
        schemaType = schemaType2 != null ? schemaType2 : schemaType;
        if (schemaType == null) {
            schemaType = BuiltinSchemaTypeSystem.ST_ANY_TYPE;
            XMLInputStream subStream = xMLInputStream.getSubStream();
            if (subStream.skip(2) && (findDocumentType = schemaTypeLoader.findDocumentType(XMLNameHelper.getQName(subStream.next().getName()))) != null) {
                schemaType = findDocumentType;
            }
            subStream.close();
        }
        this._validator = new Validator(schemaType, null, schemaTypeLoader, maskNull, new ExceptionXmlErrorListener());
        nextEvent(1);
    }

    @Override // org.apache.xmlbeans.impl.common.GenericXmlInputStream
    protected XMLEvent nextEvent() throws XMLStreamException {
        XMLEvent next = this._source.next();
        if (next == null) {
            if (!this._finished) {
                flushText();
                nextEvent(2);
                this._finished = true;
            }
        } else {
            int type = next.getType();
            if (type == 2) {
                StartElement startElement = (StartElement) next;
                flushText();
                this._startElement = startElement;
                AttributeIterator attributes = startElement.getAttributes();
                while (attributes.hasNext()) {
                    Attribute next2 = attributes.next();
                    XMLName name = next2.getName();
                    if ("http://www.w3.org/2001/XMLSchema-instance".equals(name.getNamespaceUri())) {
                        String localName = name.getLocalName();
                        if (localName.equals("type")) {
                            this._xsiType = next2.getValue();
                        } else if (localName.equals("nil")) {
                            this._xsiNil = next2.getValue();
                        } else if (localName.equals("schemaLocation")) {
                            this._xsiLoc = next2.getValue();
                        } else if (localName.equals("noNamespaceSchemaLocation")) {
                            this._xsiNoLoc = next2.getValue();
                        }
                    }
                }
                this._name = next.getName();
                nextEvent(1);
                AttributeIterator attributes2 = startElement.getAttributes();
                while (attributes2.hasNext()) {
                    Attribute next3 = attributes2.next();
                    XMLName name2 = next3.getName();
                    if ("http://www.w3.org/2001/XMLSchema-instance".equals(name2.getNamespaceUri())) {
                        String localName2 = name2.getLocalName();
                        if (!localName2.equals("type") && !localName2.equals("nil") && !localName2.equals("schemaLocation") && !localName2.equals("noNamespaceSchemaLocation")) {
                        }
                    }
                    this._text.append(next3.getValue());
                    this._name = next3.getName();
                    nextEvent(4);
                }
                clearText();
                this._startElement = null;
            } else if (type == 4) {
                flushText();
                nextEvent(2);
            } else if (type == 16 || type == 64) {
                CharacterData characterData = (CharacterData) next;
                if (characterData.hasContent()) {
                    this._text.append(characterData.getContent());
                }
            }
        }
        return next;
    }

    private void clearText() {
        StringBuffer stringBuffer = this._text;
        stringBuffer.delete(0, stringBuffer.length());
    }

    private void flushText() throws XMLStreamException {
        if (this._text.length() > 0) {
            nextEvent(3);
            clearText();
        }
    }

    @Override // org.apache.xmlbeans.impl.common.PrefixResolver
    public String getNamespaceForPrefix(String str) {
        Map namespaceMap;
        StartElement startElement = this._startElement;
        if (startElement == null || (namespaceMap = startElement.getNamespaceMap()) == null) {
            return null;
        }
        return (String) namespaceMap.get(str);
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public Location getLocation() {
        try {
            final org.apache.xmlbeans.xml.stream.Location location = this._source.peek().getLocation();
            if (location == null) {
                return null;
            }
            return new Location() { // from class: org.apache.xmlbeans.impl.validator.ValidatingXMLInputStream.1
                @Override // aavax.xml.stream.Location
                public int getCharacterOffset() {
                    return -1;
                }

                @Override // aavax.xml.stream.Location
                public int getLineNumber() {
                    return location.getLineNumber();
                }

                @Override // aavax.xml.stream.Location
                public int getColumnNumber() {
                    return location.getColumnNumber();
                }

                @Override // aavax.xml.stream.Location
                public String getPublicId() {
                    return location.getPublicId();
                }

                @Override // aavax.xml.stream.Location
                public String getSystemId() {
                    return location.getSystemId();
                }
            };
        } catch (XMLStreamException unused) {
            return null;
        }
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public String getXsiType() {
        return this._xsiType;
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public String getXsiNil() {
        return this._xsiNil;
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public String getXsiLoc() {
        return this._xsiLoc;
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public String getXsiNoLoc() {
        return this._xsiNoLoc;
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public QName getName() {
        return XMLNameHelper.getQName(this._name);
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public String getText() {
        return this._text.toString();
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public String getText(int i) {
        return XmlWhitespace.collapse(this._text.toString(), i);
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public boolean textIsWhitespace() {
        for (int i = 0; i < this._text.length(); i++) {
            char charAt = this._text.charAt(i);
            if (charAt != '\t' && charAt != '\n' && charAt != '\r' && charAt != ' ') {
                return false;
            }
        }
        return true;
    }

    private final class ExceptionXmlErrorListener extends AbstractCollection {
        static final /* synthetic */ boolean $assertionsDisabled;

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return 0;
        }

        static {
            if (ValidatingXMLInputStream.class$org$apache$xmlbeans$impl$validator$ValidatingXMLInputStream == null) {
                ValidatingXMLInputStream.class$org$apache$xmlbeans$impl$validator$ValidatingXMLInputStream = ValidatingXMLInputStream.class$("org.apache.xmlbeans.impl.validator.ValidatingXMLInputStream");
            } else {
                Class cls = ValidatingXMLInputStream.class$org$apache$xmlbeans$impl$validator$ValidatingXMLInputStream;
            }
            $assertionsDisabled = true;
        }

        private ExceptionXmlErrorListener() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(Object obj) {
            if (!$assertionsDisabled && ValidatingXMLInputStream.this._exception != null) {
                throw new AssertionError();
            }
            ValidatingXMLInputStream.this._exception = new XMLStreamValidationException((XmlError) obj);
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return Collections.EMPTY_LIST.iterator();
        }
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private void nextEvent(int i) throws XMLStreamException {
        if (!$assertionsDisabled && this._exception != null) {
            throw new AssertionError();
        }
        this._validator.nextEvent(i, this);
        XMLStreamValidationException xMLStreamValidationException = this._exception;
        if (xMLStreamValidationException != null) {
            throw xMLStreamValidationException;
        }
    }
}
