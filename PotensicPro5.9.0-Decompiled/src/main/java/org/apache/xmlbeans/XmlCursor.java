package org.apache.xmlbeans;

import aavax.xml.namespace.QName;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes5.dex */
public interface XmlCursor extends XmlTokenSource {

    public interface ChangeStamp {
        boolean hasChanged();
    }

    public interface XmlMark {
        XmlCursor createCursor();
    }

    void addToSelection();

    void beginElement(QName qName);

    void beginElement(String str);

    void beginElement(String str, String str2);

    void clearBookmark(Object obj);

    void clearSelections();

    int comparePosition(XmlCursor xmlCursor);

    int copyChars(int i, XmlCursor xmlCursor);

    boolean copyXml(XmlCursor xmlCursor);

    boolean copyXmlContents(XmlCursor xmlCursor);

    TokenType currentTokenType();

    void dispose();

    XmlCursor execQuery(String str);

    XmlCursor execQuery(String str, XmlOptions xmlOptions);

    void getAllBookmarkRefs(Collection collection);

    void getAllNamespaces(Map map);

    String getAttributeText(QName qName);

    XmlBookmark getBookmark(Object obj);

    int getChars(char[] cArr, int i, int i2);

    String getChars();

    ChangeStamp getDocChangeStamp();

    QName getName();

    XmlObject getObject();

    int getSelectionCount();

    int getTextValue(char[] cArr, int i, int i2);

    String getTextValue();

    boolean hasNextSelection();

    boolean hasNextToken();

    boolean hasPrevToken();

    void insertAttribute(QName qName);

    void insertAttribute(String str);

    void insertAttribute(String str, String str2);

    void insertAttributeWithValue(QName qName, String str);

    void insertAttributeWithValue(String str, String str2);

    void insertAttributeWithValue(String str, String str2, String str3);

    void insertChars(String str);

    void insertComment(String str);

    void insertElement(QName qName);

    void insertElement(String str);

    void insertElement(String str, String str2);

    void insertElementWithText(QName qName, String str);

    void insertElementWithText(String str, String str2);

    void insertElementWithText(String str, String str2, String str3);

    void insertNamespace(String str, String str2);

    void insertProcInst(String str, String str2);

    boolean isAnyAttr();

    boolean isAtSamePositionAs(XmlCursor xmlCursor);

    boolean isAttr();

    boolean isComment();

    boolean isContainer();

    boolean isEnd();

    boolean isEnddoc();

    boolean isFinish();

    boolean isInSameDocument(XmlCursor xmlCursor);

    boolean isLeftOf(XmlCursor xmlCursor);

    boolean isNamespace();

    boolean isProcinst();

    boolean isRightOf(XmlCursor xmlCursor);

    boolean isStart();

    boolean isStartdoc();

    boolean isText();

    int moveChars(int i, XmlCursor xmlCursor);

    boolean moveXml(XmlCursor xmlCursor);

    boolean moveXmlContents(XmlCursor xmlCursor);

    String namespaceForPrefix(String str);

    boolean pop();

    String prefixForNamespace(String str);

    TokenType prevTokenType();

    void push();

    boolean removeAttribute(QName qName);

    int removeChars(int i);

    boolean removeXml();

    boolean removeXmlContents();

    void selectPath(String str);

    void selectPath(String str, XmlOptions xmlOptions);

    boolean setAttributeText(QName qName, String str);

    void setBookmark(XmlBookmark xmlBookmark);

    void setName(QName qName);

    void setTextValue(String str);

    void setTextValue(char[] cArr, int i, int i2);

    boolean toBookmark(XmlBookmark xmlBookmark);

    boolean toChild(int i);

    boolean toChild(QName qName);

    boolean toChild(QName qName, int i);

    boolean toChild(String str);

    boolean toChild(String str, String str2);

    boolean toCursor(XmlCursor xmlCursor);

    void toEndDoc();

    TokenType toEndToken();

    boolean toFirstAttribute();

    boolean toFirstChild();

    TokenType toFirstContentToken();

    boolean toLastAttribute();

    boolean toLastChild();

    boolean toNextAttribute();

    XmlBookmark toNextBookmark(Object obj);

    int toNextChar(int i);

    boolean toNextSelection();

    boolean toNextSibling();

    boolean toNextSibling(QName qName);

    boolean toNextSibling(String str);

    boolean toNextSibling(String str, String str2);

    TokenType toNextToken();

    boolean toParent();

    boolean toPrevAttribute();

    XmlBookmark toPrevBookmark(Object obj);

    int toPrevChar(int i);

    boolean toPrevSibling();

    TokenType toPrevToken();

    boolean toSelection(int i);

    void toStartDoc();

    public static final class TokenType {
        public static final int INT_ATTR = 6;
        public static final int INT_COMMENT = 8;
        public static final int INT_END = 4;
        public static final int INT_ENDDOC = 2;
        public static final int INT_NAMESPACE = 7;
        public static final int INT_NONE = 0;
        public static final int INT_PROCINST = 9;
        public static final int INT_START = 3;
        public static final int INT_STARTDOC = 1;
        public static final int INT_TEXT = 5;
        private String _name;
        private int _value;
        public static final TokenType NONE = new TokenType("NONE", 0);
        public static final TokenType STARTDOC = new TokenType("STARTDOC", 1);
        public static final TokenType ENDDOC = new TokenType("ENDDOC", 2);
        public static final TokenType START = new TokenType("START", 3);
        public static final TokenType END = new TokenType("END", 4);
        public static final TokenType TEXT = new TokenType("TEXT", 5);
        public static final TokenType ATTR = new TokenType("ATTR", 6);
        public static final TokenType NAMESPACE = new TokenType("NAMESPACE", 7);
        public static final TokenType COMMENT = new TokenType("COMMENT", 8);
        public static final TokenType PROCINST = new TokenType("PROCINST", 9);

        public String toString() {
            return this._name;
        }

        public int intValue() {
            return this._value;
        }

        public boolean isNone() {
            return this == NONE;
        }

        public boolean isStartdoc() {
            return this == STARTDOC;
        }

        public boolean isEnddoc() {
            return this == ENDDOC;
        }

        public boolean isStart() {
            return this == START;
        }

        public boolean isEnd() {
            return this == END;
        }

        public boolean isText() {
            return this == TEXT;
        }

        public boolean isAttr() {
            return this == ATTR;
        }

        public boolean isNamespace() {
            return this == NAMESPACE;
        }

        public boolean isComment() {
            return this == COMMENT;
        }

        public boolean isProcinst() {
            return this == PROCINST;
        }

        public boolean isContainer() {
            return this == STARTDOC || this == START;
        }

        public boolean isFinish() {
            return this == ENDDOC || this == END;
        }

        public boolean isAnyAttr() {
            return this == NAMESPACE || this == ATTR;
        }

        private TokenType(String str, int i) {
            this._name = str;
            this._value = i;
        }
    }

    public static abstract class XmlBookmark {
        public XmlMark _currentMark;
        public final Reference _ref;

        public XmlBookmark() {
            this(false);
        }

        public XmlBookmark(boolean z) {
            this._ref = z ? new WeakReference(this) : null;
        }

        public final XmlCursor createCursor() {
            XmlMark xmlMark = this._currentMark;
            if (xmlMark == null) {
                return null;
            }
            return xmlMark.createCursor();
        }

        public final XmlCursor toBookmark(XmlCursor xmlCursor) {
            return (xmlCursor == null || !xmlCursor.toBookmark(this)) ? createCursor() : xmlCursor;
        }

        public Object getKey() {
            return getClass();
        }
    }
}
