package org.apache.xmlbeans.impl.validator;

import aavax.xml.namespace.QName;
import aavax.xml.stream.Location;
import aavax.xml.stream.XMLStreamException;
import aavax.xml.stream.XMLStreamReader;
import aavax.xml.stream.util.StreamReaderDelegate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidatorListener;
import org.apache.xmlbeans.impl.common.XmlWhitespace;

/* loaded from: classes5.dex */
public class ValidatingXMLStreamReader extends StreamReaderDelegate implements XMLStreamReader {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static final String OPTION_ATTTRIBUTE_VALIDATION_COMPAT_MODE = "OPTION_ATTTRIBUTE_VALIDATION_COMPAT_MODE";
    private static final String URI_XSI = "http://www.w3.org/2001/XMLSchema-instance";
    private static final QName XSI_NIL;
    private static final QName XSI_NSL;
    private static final QName XSI_SL;
    private static final QName XSI_TYPE;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$validator$ValidatingXMLStreamReader;
    private final AttributeEventImpl _attEvent;
    private List _attNamesList;
    private List _attValuesList;
    private SchemaType _contentType;
    private int _depth;
    private final ElementEventImpl _elemEvent;
    private Collection _errorListener;
    private XmlOptions _options;
    private PackTextXmlStreamReader _packTextXmlStreamReader;
    private final SimpleEventImpl _simpleEvent;
    private int _state;
    private SchemaTypeLoader _stl;
    protected Validator _validator;
    private SchemaType _xsiType;
    private final int STATE_FIRSTEVENT = 0;
    private final int STATE_VALIDATING = 1;
    private final int STATE_ATTBUFFERING = 2;
    private final int STATE_ERROR = 3;

    static {
        if (class$org$apache$xmlbeans$impl$validator$ValidatingXMLStreamReader == null) {
            class$org$apache$xmlbeans$impl$validator$ValidatingXMLStreamReader = class$("org.apache.xmlbeans.impl.validator.ValidatingXMLStreamReader");
        }
        $assertionsDisabled = true;
        XSI_TYPE = new QName(URI_XSI, "type");
        XSI_NIL = new QName(URI_XSI, "nil");
        XSI_SL = new QName(URI_XSI, "schemaLocation");
        XSI_NSL = new QName(URI_XSI, "noNamespaceSchemaLocation");
    }

    public ValidatingXMLStreamReader() {
        this._elemEvent = new ElementEventImpl();
        this._attEvent = new AttributeEventImpl();
        this._simpleEvent = new SimpleEventImpl();
        this._packTextXmlStreamReader = new PackTextXmlStreamReader();
    }

    public void init(XMLStreamReader xMLStreamReader, boolean z, SchemaType schemaType, SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions, Collection collection) {
        this._packTextXmlStreamReader.init(xMLStreamReader);
        setParent(this._packTextXmlStreamReader);
        this._contentType = schemaType;
        this._stl = schemaTypeLoader;
        this._options = xmlOptions;
        this._errorListener = collection;
        this._elemEvent.setXMLStreamReader(this._packTextXmlStreamReader);
        this._attEvent.setXMLStreamReader(this._packTextXmlStreamReader);
        this._simpleEvent.setXMLStreamReader(this._packTextXmlStreamReader);
        this._validator = null;
        this._state = 0;
        List list = this._attNamesList;
        if (list != null) {
            list.clear();
            this._attValuesList.clear();
        }
        this._xsiType = null;
        this._depth = 0;
        if (z) {
            validate_event(getEventType());
        }
    }

    private static class PackTextXmlStreamReader extends StreamReaderDelegate implements XMLStreamReader {
        static final /* synthetic */ boolean $assertionsDisabled;
        private StringBuffer _buffer;
        private boolean _hasBufferedText;
        private int _textEventType;

        static {
            if (ValidatingXMLStreamReader.class$org$apache$xmlbeans$impl$validator$ValidatingXMLStreamReader == null) {
                ValidatingXMLStreamReader.class$org$apache$xmlbeans$impl$validator$ValidatingXMLStreamReader = ValidatingXMLStreamReader.class$("org.apache.xmlbeans.impl.validator.ValidatingXMLStreamReader");
            } else {
                Class cls = ValidatingXMLStreamReader.class$org$apache$xmlbeans$impl$validator$ValidatingXMLStreamReader;
            }
            $assertionsDisabled = true;
        }

        private PackTextXmlStreamReader() {
            this._buffer = new StringBuffer();
        }

        void init(XMLStreamReader xMLStreamReader) {
            setParent(xMLStreamReader);
            this._hasBufferedText = false;
            StringBuffer stringBuffer = this._buffer;
            stringBuffer.delete(0, stringBuffer.length());
        }

        @Override // aavax.xml.stream.util.StreamReaderDelegate, aavax.xml.stream.XMLStreamReader
        public int next() throws XMLStreamException {
            if (this._hasBufferedText) {
                clearBuffer();
                return super.getEventType();
            }
            int next = super.next();
            if (next == 4 || next == 12 || next == 6) {
                this._textEventType = next;
                bufferText();
            }
            return next;
        }

        private void clearBuffer() {
            StringBuffer stringBuffer = this._buffer;
            stringBuffer.delete(0, stringBuffer.length());
            this._hasBufferedText = false;
        }

        private void bufferText() throws XMLStreamException {
            if (super.hasText()) {
                this._buffer.append(super.getText());
            }
            this._hasBufferedText = true;
            while (hasNext()) {
                int next = super.next();
                if (next != 4) {
                    if (next == 5) {
                        continue;
                    } else if (next != 6 && next != 12) {
                        return;
                    }
                }
                if (super.hasText()) {
                    this._buffer.append(super.getText());
                }
            }
        }

        @Override // aavax.xml.stream.util.StreamReaderDelegate, aavax.xml.stream.XMLStreamReader
        public String getText() {
            if ($assertionsDisabled || this._hasBufferedText) {
                return this._buffer.toString();
            }
            throw new AssertionError();
        }

        @Override // aavax.xml.stream.util.StreamReaderDelegate, aavax.xml.stream.XMLStreamReader
        public int getTextLength() {
            if ($assertionsDisabled || this._hasBufferedText) {
                return this._buffer.length();
            }
            throw new AssertionError();
        }

        @Override // aavax.xml.stream.util.StreamReaderDelegate, aavax.xml.stream.XMLStreamReader
        public int getTextStart() {
            if ($assertionsDisabled || this._hasBufferedText) {
                return 0;
            }
            throw new AssertionError();
        }

        @Override // aavax.xml.stream.util.StreamReaderDelegate, aavax.xml.stream.XMLStreamReader
        public char[] getTextCharacters() {
            if ($assertionsDisabled || this._hasBufferedText) {
                return this._buffer.toString().toCharArray();
            }
            throw new AssertionError();
        }

        @Override // aavax.xml.stream.util.StreamReaderDelegate, aavax.xml.stream.XMLStreamReader
        public int getTextCharacters(int i, char[] cArr, int i2, int i3) {
            if (!$assertionsDisabled && !this._hasBufferedText) {
                throw new AssertionError();
            }
            this._buffer.getChars(i, i + i3, cArr, i2);
            return i3;
        }

        @Override // aavax.xml.stream.util.StreamReaderDelegate, aavax.xml.stream.XMLStreamReader
        public boolean isWhiteSpace() {
            if ($assertionsDisabled || this._hasBufferedText) {
                return XmlWhitespace.isAllSpace(this._buffer);
            }
            throw new AssertionError();
        }

        @Override // aavax.xml.stream.util.StreamReaderDelegate, aavax.xml.stream.XMLStreamReader
        public boolean hasText() {
            if (this._hasBufferedText) {
                return true;
            }
            return super.hasText();
        }

        @Override // aavax.xml.stream.util.StreamReaderDelegate, aavax.xml.stream.XMLStreamReader
        public int getEventType() {
            if (this._hasBufferedText) {
                return this._textEventType;
            }
            return super.getEventType();
        }
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private static class ElementEventImpl implements ValidatorListener.Event {
        private static final int BUF_LENGTH = 1024;
        private char[] _buf;
        private int _length;
        private boolean _supportForGetTextCharacters;
        private XMLStreamReader _xmlStream;

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public XmlCursor getLocationAsCursor() {
            return null;
        }

        private ElementEventImpl() {
            this._buf = new char[1024];
            this._supportForGetTextCharacters = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setXMLStreamReader(XMLStreamReader xMLStreamReader) {
            this._xmlStream = xMLStreamReader;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public Location getLocation() {
            return this._xmlStream.getLocation();
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getXsiType() {
            return this._xmlStream.getAttributeValue(ValidatingXMLStreamReader.URI_XSI, "type");
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getXsiNil() {
            return this._xmlStream.getAttributeValue(ValidatingXMLStreamReader.URI_XSI, "nil");
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getXsiLoc() {
            return this._xmlStream.getAttributeValue(ValidatingXMLStreamReader.URI_XSI, "schemaLocation");
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getXsiNoLoc() {
            return this._xmlStream.getAttributeValue(ValidatingXMLStreamReader.URI_XSI, "noNamespaceSchemaLocation");
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public QName getName() {
            if (this._xmlStream.hasName()) {
                return new QName(this._xmlStream.getNamespaceURI(), this._xmlStream.getLocalName());
            }
            return null;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getText() {
            this._length = 0;
            addTextToBuffer();
            return new String(this._buf, 0, this._length);
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getText(int i) {
            return XmlWhitespace.collapse(this._xmlStream.getText(), i);
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public boolean textIsWhitespace() {
            return this._xmlStream.isWhiteSpace();
        }

        @Override // org.apache.xmlbeans.impl.common.PrefixResolver
        public String getNamespaceForPrefix(String str) {
            return this._xmlStream.getNamespaceURI(str);
        }

        private void addTextToBuffer() {
            int textLength = this._xmlStream.getTextLength();
            ensureBufferLength(textLength);
            if (this._supportForGetTextCharacters) {
                try {
                    this._length = this._xmlStream.getTextCharacters(0, this._buf, this._length, textLength);
                } catch (Exception unused) {
                    this._supportForGetTextCharacters = false;
                }
            }
            if (this._supportForGetTextCharacters) {
                return;
            }
            System.arraycopy(this._xmlStream.getTextCharacters(), this._xmlStream.getTextStart(), this._buf, this._length, textLength);
            this._length += textLength;
        }

        private void ensureBufferLength(int i) {
            int i2 = this._length;
            int i3 = i2 + i;
            char[] cArr = this._buf;
            if (i3 > cArr.length) {
                char[] cArr2 = new char[i + i2];
                if (i2 > 0) {
                    System.arraycopy(cArr, 0, cArr2, 0, i2);
                }
                this._buf = cArr2;
            }
        }
    }

    private static final class AttributeEventImpl implements ValidatorListener.Event {
        static final /* synthetic */ boolean $assertionsDisabled;
        private int _attIndex;
        private XMLStreamReader _xmlStream;

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public XmlCursor getLocationAsCursor() {
            return null;
        }

        static {
            if (ValidatingXMLStreamReader.class$org$apache$xmlbeans$impl$validator$ValidatingXMLStreamReader == null) {
                ValidatingXMLStreamReader.class$org$apache$xmlbeans$impl$validator$ValidatingXMLStreamReader = ValidatingXMLStreamReader.class$("org.apache.xmlbeans.impl.validator.ValidatingXMLStreamReader");
            } else {
                Class cls = ValidatingXMLStreamReader.class$org$apache$xmlbeans$impl$validator$ValidatingXMLStreamReader;
            }
            $assertionsDisabled = true;
        }

        private AttributeEventImpl() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setXMLStreamReader(XMLStreamReader xMLStreamReader) {
            this._xmlStream = xMLStreamReader;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public Location getLocation() {
            return this._xmlStream.getLocation();
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getXsiType() {
            throw new IllegalStateException();
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getXsiNil() {
            throw new IllegalStateException();
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getXsiLoc() {
            throw new IllegalStateException();
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getXsiNoLoc() {
            throw new IllegalStateException();
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public QName getName() {
            if (!$assertionsDisabled && !this._xmlStream.isStartElement()) {
                throw new AssertionError("Not on Start Element.");
            }
            String attributeNamespace = this._xmlStream.getAttributeNamespace(this._attIndex);
            if (attributeNamespace == null) {
                attributeNamespace = "";
            }
            return new QName(attributeNamespace, this._xmlStream.getAttributeLocalName(this._attIndex));
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getText() {
            if ($assertionsDisabled || this._xmlStream.isStartElement()) {
                return this._xmlStream.getAttributeValue(this._attIndex);
            }
            throw new AssertionError("Not on Start Element.");
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getText(int i) {
            if ($assertionsDisabled || this._xmlStream.isStartElement()) {
                return XmlWhitespace.collapse(this._xmlStream.getAttributeValue(this._attIndex), i);
            }
            throw new AssertionError("Not on Start Element.");
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public boolean textIsWhitespace() {
            throw new IllegalStateException();
        }

        @Override // org.apache.xmlbeans.impl.common.PrefixResolver
        public String getNamespaceForPrefix(String str) {
            if ($assertionsDisabled || this._xmlStream.isStartElement()) {
                return this._xmlStream.getNamespaceURI(str);
            }
            throw new AssertionError("Not on Start Element.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAttributeIndex(int i) {
            this._attIndex = i;
        }
    }

    private static final class SimpleEventImpl implements ValidatorListener.Event {
        private QName _qname;
        private String _text;
        private XMLStreamReader _xmlStream;

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public XmlCursor getLocationAsCursor() {
            return null;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getXsiLoc() {
            return null;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getXsiNil() {
            return null;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getXsiNoLoc() {
            return null;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getXsiType() {
            return null;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public boolean textIsWhitespace() {
            return false;
        }

        private SimpleEventImpl() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setXMLStreamReader(XMLStreamReader xMLStreamReader) {
            this._xmlStream = xMLStreamReader;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public Location getLocation() {
            return this._xmlStream.getLocation();
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public QName getName() {
            return this._qname;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getText() {
            return this._text;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getText(int i) {
            return XmlWhitespace.collapse(this._text, i);
        }

        @Override // org.apache.xmlbeans.impl.common.PrefixResolver
        public String getNamespaceForPrefix(String str) {
            return this._xmlStream.getNamespaceURI(str);
        }
    }

    @Override // aavax.xml.stream.util.StreamReaderDelegate, aavax.xml.stream.XMLStreamReader
    public Object getProperty(String str) throws IllegalArgumentException {
        return super.getProperty(str);
    }

    @Override // aavax.xml.stream.util.StreamReaderDelegate, aavax.xml.stream.XMLStreamReader
    public int next() throws XMLStreamException {
        int next = super.next();
        validate_event(next);
        return next;
    }

    private void validate_event(int i) {
        int i2 = this._state;
        if (i2 == 3) {
            return;
        }
        int i3 = this._depth;
        if (i3 < 0) {
            throw new IllegalArgumentException("ValidatingXMLStreamReader cannot go further than the subtree is was initialized on.");
        }
        switch (i) {
            case 1:
                this._depth = i3 + 1;
                if (i2 == 2) {
                    pushBufferedAttributes();
                }
                if (this._validator == null) {
                    QName qName = new QName(getNamespaceURI(), getLocalName());
                    if (this._contentType == null) {
                        this._contentType = typeForGlobalElement(qName);
                    }
                    if (this._state == 3) {
                        return;
                    }
                    initValidator(this._contentType);
                    this._validator.nextEvent(1, this._elemEvent);
                }
                this._validator.nextEvent(1, this._elemEvent);
                validate_attributes(getAttributeCount());
                return;
            case 2:
            case 8:
                this._depth = i3 - 1;
                if (i2 == 2) {
                    pushBufferedAttributes();
                }
                this._validator.nextEvent(2, this._elemEvent);
                return;
            case 3:
            case 5:
            case 6:
            case 9:
            case 11:
            case 13:
            case 14:
            case 15:
                return;
            case 4:
            case 12:
                if (i2 == 2) {
                    pushBufferedAttributes();
                }
                if (this._validator == null) {
                    SchemaType schemaType = this._contentType;
                    if (schemaType == null) {
                        if (isWhiteSpace()) {
                            return;
                        }
                        addError("No content type provided for validation of a content model.");
                        this._state = 3;
                        return;
                    }
                    initValidator(schemaType);
                    this._validator.nextEvent(1, this._simpleEvent);
                }
                this._validator.nextEvent(3, this._elemEvent);
                return;
            case 7:
                this._depth = i3 + 1;
                return;
            case 10:
                if (getAttributeCount() == 0) {
                    return;
                }
                int i4 = this._state;
                if (i4 == 0 || i4 == 2) {
                    for (int i5 = 0; i5 < getAttributeCount(); i5++) {
                        QName qName2 = new QName(getAttributeNamespace(i5), getAttributeLocalName(i5));
                        if (qName2.equals(XSI_TYPE)) {
                            String attributeValue = getAttributeValue(i5);
                            this._xsiType = this._stl.findType(new QName(super.getNamespaceURI(QNameHelper.getPrefixPart(attributeValue)), QNameHelper.getLocalPart(attributeValue)));
                        }
                        if (this._attNamesList == null) {
                            this._attNamesList = new ArrayList();
                            this._attValuesList = new ArrayList();
                        }
                        if (!isSpecialAttribute(qName2)) {
                            this._attNamesList.add(qName2);
                            this._attValuesList.add(getAttributeValue(i5));
                        }
                    }
                    this._state = 2;
                    return;
                }
                throw new IllegalStateException("ATT event must be only at the beggining of the stream.");
            default:
                throw new IllegalStateException("Unknown event type.");
        }
    }

    private void pushBufferedAttributes() {
        SchemaType schemaType = this._xsiType;
        if (schemaType != null) {
            SchemaType schemaType2 = this._contentType;
            if (schemaType2 != null) {
                if (schemaType2.isAssignableFrom(schemaType)) {
                    schemaType = this._xsiType;
                } else {
                    addError(new StringBuffer().append("Specified type '").append(this._contentType).append("' not compatible with found xsi:type '").append(this._xsiType).append("'.").toString());
                    this._state = 3;
                    return;
                }
            }
        } else {
            schemaType = this._contentType;
            if (schemaType == null) {
                List list = this._attNamesList;
                if (list != null) {
                    schemaType = this._stl.findAttributeType((QName) list.get(0));
                    if (schemaType == null) {
                        addError(new StringBuffer().append("A schema global attribute with name '").append(this._attNamesList.get(0)).append("' could not be found in the current schema type loader.").toString());
                        this._state = 3;
                        return;
                    }
                } else {
                    addError("No content type provided for validation of a content model.");
                    this._state = 3;
                    return;
                }
            }
        }
        initValidator(schemaType);
        this._validator.nextEvent(1, this._simpleEvent);
        validate_attributes(this._attNamesList.size());
        this._attNamesList = null;
        this._attValuesList = null;
        this._state = 1;
    }

    private boolean isSpecialAttribute(QName qName) {
        if (qName.getNamespaceURI().equals(URI_XSI)) {
            return qName.getLocalPart().equals(XSI_TYPE.getLocalPart()) || qName.getLocalPart().equals(XSI_NIL.getLocalPart()) || qName.getLocalPart().equals(XSI_SL.getLocalPart()) || qName.getLocalPart().equals(XSI_NSL.getLocalPart());
        }
        return false;
    }

    private void initValidator(SchemaType schemaType) {
        if (!$assertionsDisabled && schemaType == null) {
            throw new AssertionError();
        }
        this._validator = new Validator(schemaType, null, this._stl, this._options, this._errorListener);
    }

    private SchemaType typeForGlobalElement(QName qName) {
        if (!$assertionsDisabled && qName == null) {
            throw new AssertionError();
        }
        SchemaType findDocumentType = this._stl.findDocumentType(qName);
        if (findDocumentType == null) {
            addError(new StringBuffer().append("Schema document type not found for element '").append(qName).append("'.").toString());
            this._state = 3;
        }
        return findDocumentType;
    }

    private void addError(String str) {
        Location location = getLocation();
        if (location != null) {
            String publicId = location.getPublicId();
            if (publicId == null) {
                publicId = location.getSystemId();
            }
            this._errorListener.add(XmlError.forLocation(str, publicId, location));
            return;
        }
        this._errorListener.add(XmlError.forMessage(str));
    }

    protected void validate_attributes(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            validate_attribute(i2);
        }
        XmlOptions xmlOptions = this._options;
        if (xmlOptions == null || !xmlOptions.hasOption(OPTION_ATTTRIBUTE_VALIDATION_COMPAT_MODE)) {
            this._validator.nextEvent(5, this._simpleEvent);
        }
    }

    protected void validate_attribute(int i) {
        ValidatorListener.Event event;
        List list = this._attNamesList;
        if (list == null) {
            this._attEvent.setAttributeIndex(i);
            if (isSpecialAttribute(this._attEvent.getName())) {
                return;
            } else {
                event = this._attEvent;
            }
        } else {
            this._simpleEvent._qname = (QName) list.get(i);
            this._simpleEvent._text = (String) this._attValuesList.get(i);
            event = this._simpleEvent;
        }
        this._validator.nextEvent(4, event);
    }

    public boolean isValid() {
        Validator validator;
        if (this._state == 3 || (validator = this._validator) == null) {
            return false;
        }
        return validator.isValid();
    }
}
