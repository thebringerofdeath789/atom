package org.apache.xmlbeans.impl.xb.ltgfmt;

import aavax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface FileDesc extends XmlObject {
    public static final SchemaType type;

    Code addNewCode();

    Code getCode();

    String getFileName();

    String getFolder();

    Role.Enum getRole();

    String getTsDir();

    boolean getValidity();

    boolean isSetCode();

    boolean isSetFileName();

    boolean isSetFolder();

    boolean isSetRole();

    boolean isSetTsDir();

    boolean isSetValidity();

    void setCode(Code code);

    void setFileName(String str);

    void setFolder(String str);

    void setRole(Role.Enum r1);

    void setTsDir(String str);

    void setValidity(boolean z);

    void unsetCode();

    void unsetFileName();

    void unsetFolder();

    void unsetRole();

    void unsetTsDir();

    void unsetValidity();

    XmlToken xgetFileName();

    XmlToken xgetFolder();

    Role xgetRole();

    XmlToken xgetTsDir();

    XmlBoolean xgetValidity();

    void xsetFileName(XmlToken xmlToken);

    void xsetFolder(XmlToken xmlToken);

    void xsetRole(Role role);

    void xsetTsDir(XmlToken xmlToken);

    void xsetValidity(XmlBoolean xmlBoolean);

    /* renamed from: org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$ltgfmt$FileDesc;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$ltgfmt$FileDesc$Role;

        static /* synthetic */ Class class$(String str) {
            try {
                return Class.forName(str);
            } catch (ClassNotFoundException e) {
                throw new NoClassDefFoundError().initCause(e);
            }
        }
    }

    static {
        Class cls;
        if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$ltgfmt$FileDesc == null) {
            cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc");
            AnonymousClass1.class$org$apache$xmlbeans$impl$xb$ltgfmt$FileDesc = cls;
        } else {
            cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$ltgfmt$FileDesc;
        }
        type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLTOOLS").resolveHandle("filedesc9392type");
    }

    public interface Role extends XmlToken {
        public static final Enum INSTANCE;
        public static final int INT_INSTANCE = 2;
        public static final int INT_RESOURCE = 3;
        public static final int INT_SCHEMA = 1;
        public static final Enum RESOURCE;
        public static final Enum SCHEMA;
        public static final SchemaType type;

        StringEnumAbstractBase enumValue();

        void set(StringEnumAbstractBase stringEnumAbstractBase);

        static {
            Class cls;
            if (AnonymousClass1.class$org$apache$xmlbeans$impl$xb$ltgfmt$FileDesc$Role == null) {
                cls = AnonymousClass1.class$("org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc$Role");
                AnonymousClass1.class$org$apache$xmlbeans$impl$xb$ltgfmt$FileDesc$Role = cls;
            } else {
                cls = AnonymousClass1.class$org$apache$xmlbeans$impl$xb$ltgfmt$FileDesc$Role;
            }
            type = (SchemaType) XmlBeans.typeSystemForClassLoader(cls.getClassLoader(), "schemaorg_apache_xmlbeans.system.sXMLTOOLS").resolveHandle("role21a8attrtype");
            SCHEMA = Enum.forString("schema");
            INSTANCE = Enum.forString("instance");
            RESOURCE = Enum.forString("resource");
        }

        public static final class Enum extends StringEnumAbstractBase {
            static final int INT_INSTANCE = 2;
            static final int INT_RESOURCE = 3;
            static final int INT_SCHEMA = 1;
            private static final long serialVersionUID = 1;
            public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("schema", 1), new Enum("instance", 2), new Enum("resource", 3)});

            public static Enum forString(String str) {
                return (Enum) table.forString(str);
            }

            public static Enum forInt(int i) {
                return (Enum) table.forInt(i);
            }

            private Enum(String str, int i) {
                super(str, i);
            }

            private Object readResolve() {
                return forInt(intValue());
            }
        }

        public static final class Factory {
            public static Role newValue(Object obj) {
                return (Role) Role.type.newValue(obj);
            }

            public static Role newInstance() {
                return (Role) XmlBeans.getContextTypeLoader().newInstance(Role.type, null);
            }

            public static Role newInstance(XmlOptions xmlOptions) {
                return (Role) XmlBeans.getContextTypeLoader().newInstance(Role.type, xmlOptions);
            }

            private Factory() {
            }
        }
    }

    public static final class Factory {
        public static FileDesc newInstance() {
            return (FileDesc) XmlBeans.getContextTypeLoader().newInstance(FileDesc.type, null);
        }

        public static FileDesc newInstance(XmlOptions xmlOptions) {
            return (FileDesc) XmlBeans.getContextTypeLoader().newInstance(FileDesc.type, xmlOptions);
        }

        public static FileDesc parse(String str) throws XmlException {
            return (FileDesc) XmlBeans.getContextTypeLoader().parse(str, FileDesc.type, (XmlOptions) null);
        }

        public static FileDesc parse(String str, XmlOptions xmlOptions) throws XmlException {
            return (FileDesc) XmlBeans.getContextTypeLoader().parse(str, FileDesc.type, xmlOptions);
        }

        public static FileDesc parse(File file) throws XmlException, IOException {
            return (FileDesc) XmlBeans.getContextTypeLoader().parse(file, FileDesc.type, (XmlOptions) null);
        }

        public static FileDesc parse(File file, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FileDesc) XmlBeans.getContextTypeLoader().parse(file, FileDesc.type, xmlOptions);
        }

        public static FileDesc parse(URL url) throws XmlException, IOException {
            return (FileDesc) XmlBeans.getContextTypeLoader().parse(url, FileDesc.type, (XmlOptions) null);
        }

        public static FileDesc parse(URL url, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FileDesc) XmlBeans.getContextTypeLoader().parse(url, FileDesc.type, xmlOptions);
        }

        public static FileDesc parse(InputStream inputStream) throws XmlException, IOException {
            return (FileDesc) XmlBeans.getContextTypeLoader().parse(inputStream, FileDesc.type, (XmlOptions) null);
        }

        public static FileDesc parse(InputStream inputStream, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FileDesc) XmlBeans.getContextTypeLoader().parse(inputStream, FileDesc.type, xmlOptions);
        }

        public static FileDesc parse(Reader reader) throws XmlException, IOException {
            return (FileDesc) XmlBeans.getContextTypeLoader().parse(reader, FileDesc.type, (XmlOptions) null);
        }

        public static FileDesc parse(Reader reader, XmlOptions xmlOptions) throws XmlException, IOException {
            return (FileDesc) XmlBeans.getContextTypeLoader().parse(reader, FileDesc.type, xmlOptions);
        }

        public static FileDesc parse(XMLStreamReader xMLStreamReader) throws XmlException {
            return (FileDesc) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, FileDesc.type, (XmlOptions) null);
        }

        public static FileDesc parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) throws XmlException {
            return (FileDesc) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, FileDesc.type, xmlOptions);
        }

        public static FileDesc parse(Node node) throws XmlException {
            return (FileDesc) XmlBeans.getContextTypeLoader().parse(node, FileDesc.type, (XmlOptions) null);
        }

        public static FileDesc parse(Node node, XmlOptions xmlOptions) throws XmlException {
            return (FileDesc) XmlBeans.getContextTypeLoader().parse(node, FileDesc.type, xmlOptions);
        }

        public static FileDesc parse(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return (FileDesc) XmlBeans.getContextTypeLoader().parse(xMLInputStream, FileDesc.type, (XmlOptions) null);
        }

        public static FileDesc parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return (FileDesc) XmlBeans.getContextTypeLoader().parse(xMLInputStream, FileDesc.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, FileDesc.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) throws XmlException, XMLStreamException {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, FileDesc.type, xmlOptions);
        }

        private Factory() {
        }
    }
}
