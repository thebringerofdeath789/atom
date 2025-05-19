package org.apache.xmlbeans.impl.jam.xml;

import aavax.xml.stream.XMLInputFactory;
import aavax.xml.stream.XMLStreamException;
import aavax.xml.stream.XMLStreamReader;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.internal.CachedClassBuilder;
import org.apache.xmlbeans.impl.jam.internal.elements.ClassImpl;
import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;
import org.apache.xmlbeans.impl.jam.mutable.MAnnotatedElement;
import org.apache.xmlbeans.impl.jam.mutable.MAnnotation;
import org.apache.xmlbeans.impl.jam.mutable.MClass;
import org.apache.xmlbeans.impl.jam.mutable.MConstructor;
import org.apache.xmlbeans.impl.jam.mutable.MField;
import org.apache.xmlbeans.impl.jam.mutable.MInvokable;
import org.apache.xmlbeans.impl.jam.mutable.MMethod;
import org.apache.xmlbeans.impl.jam.mutable.MParameter;
import org.apache.xmlbeans.impl.jam.mutable.MSourcePosition;

/* loaded from: classes5.dex */
class JamXmlReader implements JamXmlElements {
    private CachedClassBuilder mCache;
    private ElementContext mContext;
    private XMLStreamReader mIn;

    public JamXmlReader(CachedClassBuilder cachedClassBuilder, InputStream inputStream, ElementContext elementContext) throws XMLStreamException {
        this(cachedClassBuilder, XMLInputFactory.newInstance().createXMLStreamReader(inputStream), elementContext);
    }

    public JamXmlReader(CachedClassBuilder cachedClassBuilder, Reader reader, ElementContext elementContext) throws XMLStreamException {
        this(cachedClassBuilder, XMLInputFactory.newInstance().createXMLStreamReader(reader), elementContext);
    }

    public JamXmlReader(CachedClassBuilder cachedClassBuilder, XMLStreamReader xMLStreamReader, ElementContext elementContext) {
        if (cachedClassBuilder == null) {
            throw new IllegalArgumentException("null cache");
        }
        if (xMLStreamReader == null) {
            throw new IllegalArgumentException("null cache");
        }
        if (elementContext == null) {
            throw new IllegalArgumentException("null ctx");
        }
        this.mIn = xMLStreamReader;
        this.mCache = cachedClassBuilder;
        this.mContext = elementContext;
    }

    public void read() throws XMLStreamException {
        nextElement();
        assertStart(JamXmlElements.JAMSERVICE);
        nextElement();
        while (JamXmlElements.CLASS.equals(getElementName())) {
            readClass();
        }
        assertEnd(JamXmlElements.JAMSERVICE);
    }

    private void readClass() throws XMLStreamException {
        String str;
        assertStart(JamXmlElements.CLASS);
        nextElement();
        String assertCurrentString = assertCurrentString("name");
        int lastIndexOf = assertCurrentString.lastIndexOf(46);
        if (lastIndexOf != -1) {
            str = assertCurrentString.substring(0, lastIndexOf);
            assertCurrentString = assertCurrentString.substring(lastIndexOf + 1);
        } else {
            str = "";
        }
        MClass createClassToBuild = this.mCache.createClassToBuild(str, assertCurrentString, null);
        createClassToBuild.setIsInterface(assertCurrentBoolean(JamXmlElements.ISINTERFACE));
        createClassToBuild.setModifiers(assertCurrentInt(JamXmlElements.MODIFIERS));
        String checkCurrentString = checkCurrentString(JamXmlElements.SUPERCLASS);
        if (checkCurrentString != null) {
            createClassToBuild.setSuperclass(checkCurrentString);
        }
        while (true) {
            String checkCurrentString2 = checkCurrentString(JamXmlElements.INTERFACE);
            if (checkCurrentString2 == null) {
                break;
            } else {
                createClassToBuild.addInterface(checkCurrentString2);
            }
        }
        while (JamXmlElements.FIELD.equals(getElementName())) {
            readField(createClassToBuild);
        }
        while (JamXmlElements.CONSTRUCTOR.equals(getElementName())) {
            readConstructor(createClassToBuild);
        }
        while ("method".equals(getElementName())) {
            readMethod(createClassToBuild);
        }
        readAnnotatedElement(createClassToBuild);
        assertEnd(JamXmlElements.CLASS);
        ((ClassImpl) createClassToBuild).setState(6);
        nextElement();
    }

    private void readField(MClass mClass) throws XMLStreamException {
        assertStart(JamXmlElements.FIELD);
        MField addNewField = mClass.addNewField();
        nextElement();
        addNewField.setSimpleName(assertCurrentString("name"));
        addNewField.setModifiers(assertCurrentInt(JamXmlElements.MODIFIERS));
        addNewField.setType(assertCurrentString("type"));
        readAnnotatedElement(addNewField);
        assertEnd(JamXmlElements.FIELD);
        nextElement();
    }

    private void readConstructor(MClass mClass) throws XMLStreamException {
        assertStart(JamXmlElements.CONSTRUCTOR);
        MConstructor addNewConstructor = mClass.addNewConstructor();
        nextElement();
        readInvokableContents(addNewConstructor);
        assertEnd(JamXmlElements.CONSTRUCTOR);
        nextElement();
    }

    private void readMethod(MClass mClass) throws XMLStreamException {
        assertStart("method");
        MMethod addNewMethod = mClass.addNewMethod();
        nextElement();
        addNewMethod.setSimpleName(assertCurrentString("name"));
        addNewMethod.setReturnType(assertCurrentString(JamXmlElements.RETURNTYPE));
        readInvokableContents(addNewMethod);
        assertEnd("method");
        nextElement();
    }

    private void readSourcePosition(MAnnotatedElement mAnnotatedElement) throws XMLStreamException {
        assertStart(JamXmlElements.SOURCEPOSITION);
        MSourcePosition createSourcePosition = mAnnotatedElement.createSourcePosition();
        nextElement();
        if ("line".equals(getElementName())) {
            createSourcePosition.setLine(assertCurrentInt("line"));
        }
        if (JamXmlElements.COLUMN.equals(getElementName())) {
            createSourcePosition.setColumn(assertCurrentInt(JamXmlElements.COLUMN));
        }
        if (JamXmlElements.SOURCEURI.equals(getElementName())) {
            try {
                createSourcePosition.setSourceURI(new URI(assertCurrentString(JamXmlElements.SOURCEURI)));
            } catch (URISyntaxException e) {
                throw new XMLStreamException(e);
            }
        }
        assertEnd(JamXmlElements.SOURCEPOSITION);
        nextElement();
    }

    private void readInvokableContents(MInvokable mInvokable) throws XMLStreamException {
        mInvokable.setModifiers(assertCurrentInt(JamXmlElements.MODIFIERS));
        while (JamXmlElements.PARAMETER.equals(getElementName())) {
            nextElement();
            MParameter addNewParameter = mInvokable.addNewParameter();
            addNewParameter.setSimpleName(assertCurrentString("name"));
            addNewParameter.setType(assertCurrentString("type"));
            readAnnotatedElement(addNewParameter);
            assertEnd(JamXmlElements.PARAMETER);
            nextElement();
        }
        readAnnotatedElement(mInvokable);
    }

    private void readAnnotatedElement(MAnnotatedElement mAnnotatedElement) throws XMLStreamException {
        while (JamXmlElements.ANNOTATION.equals(getElementName())) {
            nextElement();
            MAnnotation addLiteralAnnotation = mAnnotatedElement.addLiteralAnnotation(assertCurrentString("name"));
            while (JamXmlElements.ANNOTATIONVALUE.equals(getElementName())) {
                nextElement();
                String assertCurrentString = assertCurrentString("name");
                JClass loadClass = this.mContext.getClassLoader().loadClass(assertCurrentString("type"));
                if (loadClass.isArrayType()) {
                    ArrayList arrayList = new ArrayList();
                    while ("value".equals(getElementName())) {
                        arrayList.add(assertCurrentString("value"));
                    }
                    String[] strArr = new String[arrayList.size()];
                    arrayList.toArray(strArr);
                    addLiteralAnnotation.setSimpleValue(assertCurrentString, strArr, loadClass);
                } else {
                    addLiteralAnnotation.setSimpleValue(assertCurrentString, assertCurrentString("value"), loadClass);
                }
                assertEnd(JamXmlElements.ANNOTATIONVALUE);
                nextElement();
            }
            assertEnd(JamXmlElements.ANNOTATION);
            nextElement();
        }
        if (JamXmlElements.COMMENT.equals(getElementName())) {
            mAnnotatedElement.createComment().setText(this.mIn.getElementText());
            assertEnd(JamXmlElements.COMMENT);
            nextElement();
        }
        if (JamXmlElements.SOURCEPOSITION.equals(getElementName())) {
            readSourcePosition(mAnnotatedElement);
        }
    }

    private void assertStart(String str) throws XMLStreamException {
        if (this.mIn.isStartElement() && str.equals(getElementName())) {
            return;
        }
        error(new StringBuffer().append("expected to get a <").append(str).append(">, ").toString());
    }

    private void assertEnd(String str) throws XMLStreamException {
        if (this.mIn.isEndElement() && str.equals(getElementName())) {
            return;
        }
        error(new StringBuffer().append("expected to get a </").append(str).append(">, ").toString());
    }

    private String checkCurrentString(String str) throws XMLStreamException {
        if (!str.equals(getElementName())) {
            return null;
        }
        String elementText = this.mIn.getElementText();
        assertEnd(str);
        nextElement();
        return elementText;
    }

    private String assertCurrentString(String str) throws XMLStreamException {
        assertStart(str);
        String elementText = this.mIn.getElementText();
        assertEnd(str);
        nextElement();
        return elementText;
    }

    private int assertCurrentInt(String str) throws XMLStreamException {
        assertStart(str);
        String elementText = this.mIn.getElementText();
        assertEnd(str);
        nextElement();
        return Integer.valueOf(elementText).intValue();
    }

    private boolean assertCurrentBoolean(String str) throws XMLStreamException {
        assertStart(str);
        String elementText = this.mIn.getElementText();
        assertEnd(str);
        nextElement();
        return Boolean.valueOf(elementText).booleanValue();
    }

    private void error(String str) throws XMLStreamException {
        StringWriter stringWriter = new StringWriter();
        stringWriter.write("<");
        stringWriter.write(this.mIn.getLocalName());
        stringWriter.write("> line:");
        stringWriter.write(new StringBuffer().append("").append(this.mIn.getLocation().getLineNumber()).toString());
        stringWriter.write(" col:");
        stringWriter.write(new StringBuffer().append("").append(this.mIn.getLocation().getColumnNumber()).toString());
        stringWriter.write("]");
        throw new XMLStreamException(new StringBuffer().append(str).append(":\n ").append(stringWriter.toString()).toString());
    }

    private void nextElement() throws XMLStreamException {
        while (this.mIn.next() != -1) {
            if (this.mIn.isEndElement() || this.mIn.isStartElement()) {
                return;
            }
        }
        throw new XMLStreamException("Unexpected end of file");
    }

    private String getElementName() {
        return this.mIn.getLocalName();
    }
}
