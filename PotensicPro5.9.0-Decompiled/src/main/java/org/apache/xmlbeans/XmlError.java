package org.apache.xmlbeans;

import aavax.xml.stream.Location;
import java.io.File;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.lookup.StringLookupFactory;
import org.apache.xmlbeans.impl.common.NameUtil;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: classes5.dex */
public class XmlError implements Serializable {
    public static final int SEVERITY_ERROR = 0;
    public static final int SEVERITY_INFO = 2;
    public static final int SEVERITY_WARNING = 1;
    private static final ResourceBundle _bundle = PropertyResourceBundle.getBundle("org.apache.xmlbeans.message");
    static /* synthetic */ Class class$org$apache$xmlbeans$XmlCursor = null;
    static /* synthetic */ Class class$org$apache$xmlbeans$XmlLineNumber = null;
    static /* synthetic */ Class class$org$apache$xmlbeans$XmlObject = null;
    private static final long serialVersionUID = 1;
    private String _code;
    private int _column;
    private transient XmlCursor _cursor;
    private int _line;
    private String _message;
    private int _offset;
    private int _severity;
    private String _source;

    public XmlError(XmlError xmlError) {
        this._severity = 0;
        this._line = -1;
        this._column = -1;
        this._offset = -1;
        this._message = xmlError.getMessage();
        this._code = xmlError.getErrorCode();
        this._severity = xmlError.getSeverity();
        this._source = xmlError.getSourceName();
        this._line = xmlError.getLine();
        this._column = xmlError.getColumn();
        this._offset = xmlError.getOffset();
        this._cursor = xmlError.getCursorLocation();
    }

    private XmlError(String str, String str2, int i, String str3, int i2, int i3, int i4, XmlCursor xmlCursor) {
        this._severity = 0;
        this._line = -1;
        this._column = -1;
        this._offset = -1;
        this._message = str;
        this._code = str2;
        this._severity = i;
        this._source = str3;
        this._line = i2;
        this._column = i3;
        this._offset = i4;
        this._cursor = xmlCursor;
    }

    private XmlError(String str, Object[] objArr, int i, String str2, int i2, int i3, int i4, XmlCursor xmlCursor) {
        this(formattedMessage(str, objArr), str, i, str2, i2, i3, i4, xmlCursor);
    }

    protected XmlError(String str, String str2, int i, XmlCursor xmlCursor) {
        String str3;
        int i2;
        int i3;
        this._severity = 0;
        int i4 = -1;
        this._line = -1;
        this._column = -1;
        this._offset = -1;
        if (xmlCursor != null) {
            str3 = xmlCursor.documentProperties().getSourceName();
            XmlCursor newCursor = xmlCursor.newCursor();
            Class cls = class$org$apache$xmlbeans$XmlLineNumber;
            if (cls == null) {
                cls = class$("org.apache.xmlbeans.XmlLineNumber");
                class$org$apache$xmlbeans$XmlLineNumber = cls;
            }
            XmlLineNumber xmlLineNumber = (XmlLineNumber) newCursor.getBookmark(cls);
            if (xmlLineNumber == null) {
                Class cls2 = class$org$apache$xmlbeans$XmlLineNumber;
                if (cls2 == null) {
                    cls2 = class$("org.apache.xmlbeans.XmlLineNumber");
                    class$org$apache$xmlbeans$XmlLineNumber = cls2;
                }
                xmlLineNumber = (XmlLineNumber) newCursor.toPrevBookmark(cls2);
            }
            if (xmlLineNumber != null) {
                i4 = xmlLineNumber.getLine();
                i3 = xmlLineNumber.getColumn();
                i2 = xmlLineNumber.getOffset();
            } else {
                i2 = -1;
                i3 = -1;
            }
            newCursor.dispose();
        } else {
            str3 = null;
            i2 = -1;
            i3 = -1;
        }
        this._message = str;
        this._code = str2;
        this._severity = i;
        this._source = str3;
        this._line = i4;
        this._column = i3;
        this._offset = i2;
        this._cursor = xmlCursor;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    protected XmlError(String str, Object[] objArr, int i, XmlCursor xmlCursor) {
        this(formattedMessage(str, objArr), str, i, xmlCursor);
    }

    protected XmlError(String str, String str2, int i, Location location) {
        String str3;
        int i2;
        this._severity = 0;
        int i3 = -1;
        this._line = -1;
        this._column = -1;
        this._offset = -1;
        if (location != null) {
            i3 = location.getLineNumber();
            i2 = location.getColumnNumber();
            str3 = location.getPublicId();
            if (str3 == null) {
                str3 = location.getSystemId();
            }
        } else {
            str3 = null;
            i2 = -1;
        }
        this._message = str;
        this._code = str2;
        this._severity = i;
        this._source = str3;
        this._line = i3;
        this._column = i2;
    }

    protected XmlError(String str, Object[] objArr, int i, Location location) {
        this(formattedMessage(str, objArr), str, i, location);
    }

    public static XmlError forMessage(String str) {
        return forMessage(str, 0);
    }

    public static XmlError forMessage(String str, int i) {
        return forSource(str, i, null);
    }

    public static XmlError forMessage(String str, Object[] objArr) {
        return forSource(str, objArr, 0, null);
    }

    public static XmlError forMessage(String str, Object[] objArr, int i) {
        return forSource(str, objArr, i, null);
    }

    public static XmlError forSource(String str, String str2) {
        return forLocation(str, 0, str2, -1, -1, -1);
    }

    public static XmlError forSource(String str, int i, String str2) {
        return forLocation(str, i, str2, -1, -1, -1);
    }

    public static XmlError forSource(String str, Object[] objArr, int i, String str2) {
        return forLocation(str, objArr, i, str2, -1, -1, -1);
    }

    public static XmlError forLocation(String str, String str2, Location location) {
        return new XmlError(str, (String) null, 0, str2, location.getLineNumber(), location.getColumnNumber(), -1, (XmlCursor) null);
    }

    public static XmlError forLocation(String str, String str2, int i, int i2, int i3) {
        return new XmlError(str, (String) null, 0, str2, i, i2, i3, (XmlCursor) null);
    }

    public static XmlError forLocation(String str, Object[] objArr, int i, String str2, int i2, int i3, int i4) {
        return new XmlError(str, objArr, i, str2, i2, i3, i4, (XmlCursor) null);
    }

    public static XmlError forLocation(String str, int i, String str2, int i2, int i3, int i4) {
        return new XmlError(str, (String) null, i, str2, i2, i3, i4, (XmlCursor) null);
    }

    public static XmlError forLocationAndCursor(String str, int i, String str2, int i2, int i3, int i4, XmlCursor xmlCursor) {
        return new XmlError(str, (String) null, i, str2, i2, i3, i4, xmlCursor);
    }

    public static XmlError forObject(String str, XmlObject xmlObject) {
        return forObject(str, 0, xmlObject);
    }

    public static XmlError forObject(String str, Object[] objArr, XmlObject xmlObject) {
        return forObject(str, objArr, 0, xmlObject);
    }

    public static XmlError forObject(String str, int i, XmlObject xmlObject) {
        if (xmlObject == null) {
            return forMessage(str, i);
        }
        return forCursor(str, i, xmlObject.newCursor());
    }

    public static XmlError forObject(String str, Object[] objArr, int i, XmlObject xmlObject) {
        if (xmlObject == null) {
            return forMessage(str, objArr, i);
        }
        return forCursor(str, objArr, i, xmlObject.newCursor());
    }

    public static XmlError forCursor(String str, XmlCursor xmlCursor) {
        return forCursor(str, 0, xmlCursor);
    }

    public static XmlError forCursor(String str, Object[] objArr, XmlCursor xmlCursor) {
        return forCursor(str, objArr, 0, xmlCursor);
    }

    public static XmlError forCursor(String str, int i, XmlCursor xmlCursor) {
        return new XmlError(str, (String) null, i, xmlCursor);
    }

    public static XmlError forCursor(String str, Object[] objArr, int i, XmlCursor xmlCursor) {
        return new XmlError(str, objArr, i, xmlCursor);
    }

    protected static String formattedFileName(String str, URI uri) {
        URI uri2 = null;
        if (str == null) {
            return null;
        }
        try {
            URI uri3 = new URI(str);
            if (uri3.isAbsolute()) {
                uri2 = uri3;
            }
        } catch (URISyntaxException unused) {
        }
        if (uri2 == null) {
            uri2 = new File(str).toURI();
        }
        if (uri != null) {
            uri2 = uri.relativize(uri2);
        }
        if (!uri2.isAbsolute() ? !(uri == null || !uri.isAbsolute() || uri.getScheme().compareToIgnoreCase(StringLookupFactory.KEY_FILE) != 0) : uri2.getScheme().compareToIgnoreCase(StringLookupFactory.KEY_FILE) == 0) {
            try {
                return new File(uri2).toString();
            } catch (Exception unused2) {
            }
        }
        return uri2.toString();
    }

    public static String formattedMessage(String str, Object[] objArr) {
        if (str == null) {
            return null;
        }
        try {
            return MessageFormat.format(_bundle.getString(str), objArr);
        } catch (IllegalArgumentException e) {
            return MessageFormat.format(_bundle.getString("message.pattern.invalid"), e.getMessage());
        } catch (MissingResourceException e2) {
            return MessageFormat.format(_bundle.getString("message.missing.resource"), e2.getMessage());
        }
    }

    public int getSeverity() {
        return this._severity;
    }

    public String getMessage() {
        return this._message;
    }

    public String getErrorCode() {
        return this._code;
    }

    public String getSourceName() {
        return this._source;
    }

    public int getLine() {
        return this._line;
    }

    public int getColumn() {
        return this._column;
    }

    public int getOffset() {
        return this._offset;
    }

    public Object getLocation(Object obj) {
        XmlCursor xmlCursor;
        Class cls = class$org$apache$xmlbeans$XmlCursor;
        if (cls == null) {
            cls = class$("org.apache.xmlbeans.XmlCursor");
            class$org$apache$xmlbeans$XmlCursor = cls;
        }
        if (obj == cls) {
            return this._cursor;
        }
        Class cls2 = class$org$apache$xmlbeans$XmlObject;
        if (cls2 == null) {
            cls2 = class$("org.apache.xmlbeans.XmlObject");
            class$org$apache$xmlbeans$XmlObject = cls2;
        }
        if (obj != cls2 || (xmlCursor = this._cursor) == null) {
            return null;
        }
        return xmlCursor.getObject();
    }

    public XmlCursor getCursorLocation() {
        Class cls = class$org$apache$xmlbeans$XmlCursor;
        if (cls == null) {
            cls = class$("org.apache.xmlbeans.XmlCursor");
            class$org$apache$xmlbeans$XmlCursor = cls;
        }
        return (XmlCursor) getLocation(cls);
    }

    public XmlObject getObjectLocation() {
        Class cls = class$org$apache$xmlbeans$XmlObject;
        if (cls == null) {
            cls = class$("org.apache.xmlbeans.XmlObject");
            class$org$apache$xmlbeans$XmlObject = cls;
        }
        return (XmlObject) getLocation(cls);
    }

    public String toString() {
        return toString(null);
    }

    public String toString(URI uri) {
        StringBuffer stringBuffer = new StringBuffer();
        String formattedFileName = formattedFileName(getSourceName(), uri);
        if (formattedFileName != null) {
            stringBuffer.append(formattedFileName);
            int line = getLine();
            if (line < 0) {
                line = 0;
            }
            stringBuffer.append(NameUtil.COLON);
            stringBuffer.append(line);
            stringBuffer.append(NameUtil.COLON);
            if (getColumn() > 0) {
                stringBuffer.append(getColumn());
                stringBuffer.append(NameUtil.COLON);
            }
            stringBuffer.append(StringUtils.SPACE);
        }
        int severity = getSeverity();
        if (severity == 0) {
            stringBuffer.append("error: ");
        } else if (severity == 1) {
            stringBuffer.append("warning: ");
        }
        if (getErrorCode() != null) {
            stringBuffer.append(getErrorCode()).append(": ");
        }
        String message = getMessage();
        if (message == null) {
            message = "<Unspecified message>";
        }
        stringBuffer.append(message);
        return stringBuffer.toString();
    }

    public static String severityAsString(int i) {
        if (i == 0) {
            return IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR;
        }
        if (i == 1) {
            return "warning";
        }
        if (i == 2) {
            return "info";
        }
        throw new IllegalArgumentException("unknown severity");
    }
}
