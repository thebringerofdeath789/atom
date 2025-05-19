package org.apache.xmlbeans.impl.tool;

import aavax.xml.namespace.QName;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.util.HexBin;
import org.apache.xmlbeans.soap.SOAPArrayType;

/* loaded from: classes5.dex */
public class XsbDumper {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static final int DATA_BABE = -629491010;
    public static final int FIELD_GLOBAL = 1;
    public static final int FIELD_LOCALATTR = 2;
    public static final int FIELD_LOCALELT = 3;
    public static final int FIELD_NONE = 0;
    public static final int FILETYPE_SCHEMAATTRIBUTE = 4;
    public static final int FILETYPE_SCHEMAATTRIBUTEGROUP = 7;
    public static final int FILETYPE_SCHEMAELEMENT = 3;
    public static final int FILETYPE_SCHEMAINDEX = 1;
    public static final int FILETYPE_SCHEMAMODELGROUP = 6;
    public static final int FILETYPE_SCHEMAPOINTER = 5;
    public static final int FILETYPE_SCHEMATYPE = 2;
    static final int FLAG_ABSTRACT = 262144;
    static final int FLAG_ATTRIBUTE_TYPE = 524288;
    static final int FLAG_BLOCK_EXT = 4096;
    static final int FLAG_BLOCK_REST = 8192;
    static final int FLAG_BOUNDED = 8;
    static final int FLAG_COMPILED = 2048;
    static final int FLAG_DOCUMENT_TYPE = 2;
    static final int FLAG_FINAL_EXT = 16384;
    static final int FLAG_FINAL_LIST = 131072;
    static final int FLAG_FINAL_REST = 32768;
    static final int FLAG_FINAL_UNION = 65536;
    static final int FLAG_FINITE = 16;
    static final int FLAG_HAS_PATTERN = 256;
    static final int FLAG_NUMERIC = 32;
    static final int FLAG_ORDERED = 4;
    static final int FLAG_ORDER_SENSITIVE = 512;
    public static final int FLAG_PART_ABSTRACT = 128;
    public static final int FLAG_PART_BLOCKEXT = 16;
    public static final int FLAG_PART_BLOCKREST = 32;
    public static final int FLAG_PART_BLOCKSUBST = 64;
    public static final int FLAG_PART_FINALEXT = 256;
    public static final int FLAG_PART_FINALREST = 512;
    public static final int FLAG_PART_FIXED = 4;
    public static final int FLAG_PART_NILLABLE = 8;
    public static final int FLAG_PART_SKIPPABLE = 1;
    public static final int FLAG_PROP_ISATTR = 1;
    public static final int FLAG_PROP_JAVAARRAY = 8;
    public static final int FLAG_PROP_JAVAOPTIONAL = 4;
    public static final int FLAG_PROP_JAVASINGLETON = 2;
    static final int FLAG_SIMPLE_TYPE = 1;
    static final int FLAG_STRINGENUM = 64;
    static final int FLAG_TOTAL_ORDER = 1024;
    static final int FLAG_UNION_OF_LISTS = 128;
    public static final int MAJOR_VERSION = 2;
    public static final int MINOR_VERSION = 24;
    static final byte[] SINGLE_ZERO_BYTE;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$tool$XsbDumper;
    private static final XmlOptions prettyOptions;
    private String _indent;
    DataInputStream _input;
    private int _majorver;
    private int _minorver;
    private PrintStream _out;
    private int _releaseno;
    StringPool _stringPool;

    static {
        if (class$org$apache$xmlbeans$impl$tool$XsbDumper == null) {
            class$org$apache$xmlbeans$impl$tool$XsbDumper = class$("org.apache.xmlbeans.impl.tool.XsbDumper");
        }
        $assertionsDisabled = true;
        prettyOptions = new XmlOptions().setSavePrettyPrint();
        SINGLE_ZERO_BYTE = new byte[]{0};
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static void printUsage() {
        System.out.println("Prints the contents of an XSB file in human-readable form.");
        System.out.println("An XSB file contains schema meta information needed to ");
        System.out.println("perform tasks such as binding and validation.");
        System.out.println("Usage: dumpxsb myfile.xsb");
        System.out.println("    myfile.xsb - Path to an XSB file.");
        System.out.println();
    }

    public static void main(String[] strArr) {
        if (strArr.length == 0) {
            printUsage();
            System.exit(0);
        } else {
            for (String str : strArr) {
                dump(new File(str), true);
            }
        }
    }

    private static void dump(File file, boolean z) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles(new FileFilter() { // from class: org.apache.xmlbeans.impl.tool.XsbDumper.1
                @Override // java.io.FileFilter
                public boolean accept(File file3) {
                    return file3.isDirectory() || (file3.isFile() && file3.getName().endsWith(".xsb"));
                }
            })) {
                dump(file2, false);
            }
            return;
        }
        if (file.getName().endsWith(".jar") || file.getName().endsWith(".zip")) {
            dumpZip(file);
            return;
        }
        if (z || file.getName().endsWith(".xsb")) {
            try {
                System.out.println(file.toString());
                dump(new FileInputStream(file), "  ");
                System.out.println();
            } catch (FileNotFoundException e) {
                System.out.println(e.toString());
            }
        }
    }

    public static void dumpZip(File file) {
        try {
            ZipFile zipFile = new ZipFile(file);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                if (nextElement.getName().endsWith(".xsb")) {
                    System.out.println(nextElement.getName());
                    dump(zipFile.getInputStream(nextElement), "  ");
                    System.out.println();
                }
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public static void dump(InputStream inputStream) {
        dump(inputStream, "", System.out);
    }

    public static void dump(InputStream inputStream, String str) {
        dump(inputStream, str, System.out);
    }

    public static void dump(InputStream inputStream, String str, PrintStream printStream) {
        new XsbDumper(inputStream, str, printStream).dumpAll();
    }

    private XsbDumper(InputStream inputStream, String str, PrintStream printStream) {
        this._input = new DataInputStream(inputStream);
        this._indent = str;
        this._out = printStream;
    }

    void flush() {
        this._out.flush();
    }

    void emit(String str) {
        this._out.println(new StringBuffer().append(this._indent).append(str).toString());
        flush();
    }

    void emit() {
        this._out.println();
        flush();
    }

    void error(Exception exc) {
        this._out.println(exc.toString());
        flush();
        IllegalStateException illegalStateException = new IllegalStateException(exc.getMessage());
        illegalStateException.initCause(exc);
        throw illegalStateException;
    }

    void error(String str) {
        this._out.println(str);
        flush();
        throw new IllegalStateException(str);
    }

    void indent() {
        this._indent = new StringBuffer().append(this._indent).append("  ").toString();
    }

    void outdent() {
        this._indent = this._indent.substring(0, r0.length() - 2);
    }

    static String filetypeString(int i) {
        switch (i) {
            case 1:
                return "FILETYPE_SCHEMAINDEX";
            case 2:
                return "FILETYPE_SCHEMATYPE";
            case 3:
                return "FILETYPE_SCHEMAELEMENT";
            case 4:
                return "FILETYPE_SCHEMAATTRIBUTE";
            case 5:
                return "FILETYPE_SCHEMAPOINTER";
            case 6:
                return "FILETYPE_SCHEMAMODELGROUP";
            case 7:
                return "FILETYPE_SCHEMAATTRIBUTEGROUP";
            default:
                return new StringBuffer().append("Unknown FILETYPE (").append(i).append(")").toString();
        }
    }

    static String particleflagsString(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        if ((i & 1) != 0) {
            stringBuffer.append("FLAG_PART_SKIPPABLE | ");
        }
        if ((i & 4) != 0) {
            stringBuffer.append("FLAG_PART_FIXED | ");
        }
        if ((i & 8) != 0) {
            stringBuffer.append("FLAG_PART_NILLABLE | ");
        }
        if ((i & 16) != 0) {
            stringBuffer.append("FLAG_PART_BLOCKEXT | ");
        }
        if ((i & 32) != 0) {
            stringBuffer.append("FLAG_PART_BLOCKREST | ");
        }
        if ((i & 64) != 0) {
            stringBuffer.append("FLAG_PART_BLOCKSUBST | ");
        }
        if ((i & 128) != 0) {
            stringBuffer.append("FLAG_PART_ABSTRACT | ");
        }
        if ((i & 256) != 0) {
            stringBuffer.append("FLAG_PART_FINALEXT | ");
        }
        if ((i & 512) != 0) {
            stringBuffer.append("FLAG_PART_FINALREST | ");
        }
        if (stringBuffer.length() == 0) {
            stringBuffer.append("0 | ");
        }
        return stringBuffer.substring(0, stringBuffer.length() - 3);
    }

    static String propertyflagsString(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        if ((i & 1) != 0) {
            stringBuffer.append("FLAG_PROP_ISATTR | ");
        }
        if ((i & 2) != 0) {
            stringBuffer.append("FLAG_PROP_JAVASINGLETON | ");
        }
        if ((i & 4) != 0) {
            stringBuffer.append("FLAG_PROP_JAVAOPTIONAL | ");
        }
        if ((i & 8) != 0) {
            stringBuffer.append("FLAG_PROP_JAVAARRAY | ");
        }
        if (stringBuffer.length() == 0) {
            stringBuffer.append("0 | ");
        }
        return stringBuffer.substring(0, stringBuffer.length() - 3);
    }

    static String containerfieldTypeString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? new StringBuffer().append("Unknown container field type (").append(i).append(")").toString() : "FIELD_LOCALELT" : "FIELD_LOCALATTR" : "FIELD_GLOBAL" : "FIELD_NONE";
    }

    static String typeflagsString(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        if ((i & 1) != 0) {
            stringBuffer.append("FLAG_SIMPLE_TYPE | ");
        }
        if ((i & 2) != 0) {
            stringBuffer.append("FLAG_DOCUMENT_TYPE | ");
        }
        if ((524288 & i) != 0) {
            stringBuffer.append("FLAG_ATTRIBUTE_TYPE | ");
        }
        if ((i & 4) != 0) {
            stringBuffer.append("FLAG_ORDERED | ");
        }
        if ((i & 8) != 0) {
            stringBuffer.append("FLAG_BOUNDED | ");
        }
        if ((i & 16) != 0) {
            stringBuffer.append("FLAG_FINITE | ");
        }
        if ((i & 32) != 0) {
            stringBuffer.append("FLAG_NUMERIC | ");
        }
        if ((i & 64) != 0) {
            stringBuffer.append("FLAG_STRINGENUM | ");
        }
        if ((i & 128) != 0) {
            stringBuffer.append("FLAG_UNION_OF_LISTS | ");
        }
        if ((i & 256) != 0) {
            stringBuffer.append("FLAG_HAS_PATTERN | ");
        }
        if ((i & 1024) != 0) {
            stringBuffer.append("FLAG_TOTAL_ORDER | ");
        }
        if ((i & 2048) != 0) {
            stringBuffer.append("FLAG_COMPILED | ");
        }
        if ((i & 4096) != 0) {
            stringBuffer.append("FLAG_BLOCK_EXT | ");
        }
        if ((i & 8192) != 0) {
            stringBuffer.append("FLAG_BLOCK_REST | ");
        }
        if ((i & 16384) != 0) {
            stringBuffer.append("FLAG_FINAL_EXT | ");
        }
        if ((32768 & i) != 0) {
            stringBuffer.append("FLAG_FINAL_REST | ");
        }
        if ((65536 & i) != 0) {
            stringBuffer.append("FLAG_FINAL_UNION | ");
        }
        if ((131072 & i) != 0) {
            stringBuffer.append("FLAG_FINAL_LIST | ");
        }
        if ((i & 262144) != 0) {
            stringBuffer.append("FLAG_ABSTRACT | ");
        }
        if (stringBuffer.length() == 0) {
            stringBuffer.append("0 | ");
        }
        return stringBuffer.substring(0, stringBuffer.length() - 3);
    }

    void dumpAll() {
        switch (dumpHeader()) {
            case 1:
                dumpIndexData();
                return;
            case 2:
                dumpTypeFileData();
                break;
            case 3:
                dumpParticleData(true);
                break;
            case 4:
                dumpAttributeData(true);
                break;
            case 5:
                dumpPointerData();
                break;
            case 6:
                dumpModelGroupData();
                break;
            case 7:
                dumpAttributeGroupData();
                break;
        }
        readEnd();
    }

    static String hex32String(int i) {
        return Integer.toHexString(i);
    }

    protected int dumpHeader() {
        int readInt = readInt();
        emit(new StringBuffer().append("Magic cookie: ").append(hex32String(readInt)).toString());
        if (readInt != -629491010) {
            emit("Wrong magic cookie.");
            return 0;
        }
        this._majorver = readShort();
        this._minorver = readShort();
        if (atLeast(2, 18, 0)) {
            this._releaseno = readShort();
        }
        emit(new StringBuffer().append("Major version: ").append(this._majorver).toString());
        emit(new StringBuffer().append("Minor version: ").append(this._minorver).toString());
        emit(new StringBuffer().append("Release number: ").append(this._releaseno).toString());
        if (this._majorver != 2 || this._minorver > 24) {
            emit("Incompatible version.");
            return 0;
        }
        int readShort = readShort();
        emit(new StringBuffer().append("Filetype: ").append(filetypeString(readShort)).toString());
        StringPool stringPool = new StringPool();
        this._stringPool = stringPool;
        stringPool.readFrom(this._input);
        return readShort;
    }

    void dumpPointerData() {
        emit(new StringBuffer().append("Type system: ").append(readString()).toString());
    }

    protected void dumpIndexData() {
        int readShort = readShort();
        emit(new StringBuffer().append("Handle pool (").append(readShort).append("):").toString());
        indent();
        for (int i = 0; i < readShort; i++) {
            emit(new StringBuffer().append(readString()).append(" (").append(filetypeString(readShort())).append(")").toString());
        }
        outdent();
        dumpQNameMap("Global elements");
        dumpQNameMap("Global attributes");
        dumpQNameMap("Model groups");
        dumpQNameMap("Attribute groups");
        dumpQNameMap("Identity constraints");
        dumpQNameMap("Global types");
        dumpQNameMap("Document types");
        dumpQNameMap("Attribute types");
        dumpClassnameIndex("All types by classname");
        dumpStringArray("Defined namespaces");
        if (atLeast(2, 15, 0)) {
            dumpQNameMap("Redefined global types");
            dumpQNameMap("Redfined model groups");
            dumpQNameMap("Redfined attribute groups");
        }
        if (atLeast(2, 19, 0)) {
            dumpAnnotations();
        }
        readEnd();
    }

    class StringPool {
        private List intsToStrings = new ArrayList();
        private Map stringsToInts = new HashMap();

        StringPool() {
            this.intsToStrings.add(null);
        }

        String stringForCode(int i) {
            if (i == 0) {
                return null;
            }
            return (String) this.intsToStrings.get(i);
        }

        int codeForString(String str) {
            if (str == null) {
                return 0;
            }
            Integer num = (Integer) this.stringsToInts.get(str);
            if (num == null) {
                num = new Integer(this.intsToStrings.size());
                this.intsToStrings.add(str);
                this.stringsToInts.put(str, num);
            }
            return num.intValue();
        }

        void readFrom(DataInputStream dataInputStream) {
            if (this.intsToStrings.size() != 1 || this.stringsToInts.size() != 0) {
                throw new IllegalStateException();
            }
            try {
                short readShort = dataInputStream.readShort();
                XsbDumper.this.emit(new StringBuffer().append("String pool (").append((int) readShort).append("):").toString());
                XsbDumper.this.indent();
                for (int i = 1; i < readShort; i++) {
                    String readUTF = dataInputStream.readUTF();
                    int codeForString = codeForString(readUTF);
                    if (codeForString != i) {
                        throw new IllegalStateException();
                    }
                    XsbDumper.this.emit(new StringBuffer().append(codeForString).append(" = \"").append(readUTF).append("\"").toString());
                }
                XsbDumper.this.outdent();
            } catch (IOException e) {
                XsbDumper.this.emit(e.toString());
            }
        }
    }

    int readShort() {
        try {
            return this._input.readUnsignedShort();
        } catch (IOException e) {
            error(e);
            return 0;
        }
    }

    int readInt() {
        try {
            return this._input.readInt();
        } catch (IOException e) {
            error(e);
            return 0;
        }
    }

    String readString() {
        return this._stringPool.stringForCode(readShort());
    }

    QName readQName() {
        String readString = readString();
        String readString2 = readString();
        if (readString2 == null) {
            return null;
        }
        return new QName(readString, readString2);
    }

    String readHandle() {
        return readString();
    }

    String readType() {
        return readHandle();
    }

    static String qnameString(QName qName) {
        if (qName == null) {
            return "(null)";
        }
        if (qName.getNamespaceURI() != null) {
            return new StringBuffer().append(qName.getLocalPart()).append("@").append(qName.getNamespaceURI()).toString();
        }
        return qName.getLocalPart();
    }

    static String qnameSetString(QNameSet qNameSet) {
        return qNameSet.toString();
    }

    void dumpQNameMap(String str) {
        int readShort = readShort();
        emit(new StringBuffer().append(str).append(" (").append(readShort).append("):").toString());
        indent();
        for (int i = 0; i < readShort; i++) {
            emit(new StringBuffer().append(qnameString(readQName())).append(" = ").append(readHandle()).toString());
        }
        outdent();
    }

    void dumpTypeArray(String str) {
        int readShort = readShort();
        emit(new StringBuffer().append(str).append(" (").append(readShort).append("):").toString());
        indent();
        for (int i = 0; i < readShort; i++) {
            emit(new StringBuffer().append(i).append(" = ").append(readType()).toString());
        }
        outdent();
    }

    void dumpClassnameIndex(String str) {
        int readShort = readShort();
        emit(new StringBuffer().append(str).append(" (").append(readShort).append("):").toString());
        indent();
        for (int i = 0; i < readShort; i++) {
            emit(new StringBuffer().append(readString()).append(" = ").append(readType()).toString());
        }
        outdent();
    }

    void dumpStringArray(String str) {
        int readShort = readShort();
        emit(new StringBuffer().append(str).append(" (").append(readShort).append("):").toString());
        indent();
        for (int i = 0; i < readShort; i++) {
            emit(readString());
        }
        outdent();
    }

    void readEnd() {
        try {
            this._input.close();
        } catch (IOException unused) {
        }
        this._input = null;
        this._stringPool = null;
    }

    static String particleTypeString(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? new StringBuffer().append("Unknown particle type (").append(i).append(")").toString() : "WILDCARD" : "ELEMENT" : "SEQUENCE" : "CHOICE" : "ALL";
    }

    static String bigIntegerString(BigInteger bigInteger) {
        return bigInteger == null ? "(null)" : bigInteger.toString();
    }

    static String wcprocessString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? new StringBuffer().append("Unknown process type (").append(i).append(")").toString() : "SKIP" : "LAX" : "STRICT" : "NOT_WILDCARD";
    }

    void dumpAnnotation() {
        int readInt;
        boolean z;
        boolean z2 = false;
        if (atLeast(2, 19, 0) && (readInt = readInt()) != -1) {
            emit("Annotation");
            indent();
            if (readInt > 0) {
                emit(new StringBuffer().append("Attributes (").append(readInt).append("):").toString());
                indent();
                for (int i = 0; i < readInt; i++) {
                    if (atLeast(2, 24, 0)) {
                        emit(new StringBuffer().append("Name: ").append(qnameString(readQName())).append(", Value: ").append(readString()).append(", ValueURI: ").append(readString()).toString());
                    } else {
                        emit(new StringBuffer().append("Name: ").append(qnameString(readQName())).append(", Value: ").append(readString()).toString());
                    }
                }
                outdent();
                z = false;
            } else {
                z = true;
            }
            int readInt2 = readInt();
            if (readInt2 > 0) {
                emit(new StringBuffer().append("Documentation elements (").append(readInt2).append("):").toString());
                indent();
                for (int i2 = 0; i2 < readInt2; i2++) {
                    emit(readString());
                }
                outdent();
                z = false;
            }
            int readInt3 = readInt();
            if (readInt3 > 0) {
                emit(new StringBuffer().append("Appinfo elements (").append(readInt3).append("):").toString());
                indent();
                for (int i3 = 0; i3 < readInt3; i3++) {
                    emit(readString());
                }
                outdent();
            } else {
                z2 = z;
            }
            if (z2) {
                emit("<empty>");
            }
            outdent();
        }
    }

    void dumpAnnotations() {
        int readInt = readInt();
        if (readInt > 0) {
            emit(new StringBuffer().append("Top-level annotations (").append(readInt).append("):").toString());
            indent();
            for (int i = 0; i < readInt; i++) {
                dumpAnnotation();
            }
            outdent();
        }
    }

    void dumpParticleData(boolean z) {
        int readShort = readShort();
        emit(new StringBuffer().append(particleTypeString(readShort)).append(":").toString());
        indent();
        emit(new StringBuffer().append("Flags: ").append(particleflagsString(readShort())).toString());
        emit(new StringBuffer().append("MinOccurs: ").append(bigIntegerString(readBigInteger())).toString());
        emit(new StringBuffer().append("MaxOccurs: ").append(bigIntegerString(readBigInteger())).toString());
        emit(new StringBuffer().append("Transition: ").append(qnameSetString(readQNameSet())).toString());
        if (readShort == 1 || readShort == 2 || readShort == 3) {
            dumpParticleArray("Particle children");
        } else if (readShort == 4) {
            emit(new StringBuffer().append("Name: ").append(qnameString(readQName())).toString());
            emit(new StringBuffer().append("Type: ").append(readType()).toString());
            emit(new StringBuffer().append("Default: ").append(readString()).toString());
            if (atLeast(2, 16, 0)) {
                emit(new StringBuffer().append("Default value: ").append(readXmlValueObject()).toString());
            }
            emit(new StringBuffer().append("WsdlArrayType: ").append(SOAPArrayTypeString(readSOAPArrayType())).toString());
            dumpAnnotation();
            if (z) {
                if (atLeast(2, 17, 0)) {
                    emit(new StringBuffer().append("Substitution group ref: ").append(readHandle()).toString());
                }
                int readShort2 = readShort();
                emit(new StringBuffer().append("Substitution group members (").append(readShort2).append(")").toString());
                indent();
                for (int i = 0; i < readShort2; i++) {
                    emit(qnameString(readQName()));
                }
                outdent();
            }
            int readShort3 = readShort();
            emit(new StringBuffer().append("Identity constraints (").append(readShort3).append("):").toString());
            indent();
            for (int i2 = 0; i2 < readShort3; i2++) {
                emit(readHandle());
            }
            outdent();
            if (z) {
                emit(new StringBuffer().append("Filename: ").append(readString()).toString());
            }
        } else if (readShort == 5) {
            emit(new StringBuffer().append("Wildcard set: ").append(qnameSetString(readQNameSet())).toString());
            emit(new StringBuffer().append("Wildcard process: ").append(wcprocessString(readShort())).toString());
        } else {
            error("Unrecognized schema particle type");
        }
        outdent();
    }

    void dumpParticleArray(String str) {
        int readShort = readShort();
        emit(new StringBuffer().append(str).append("(").append(readShort).append("):").toString());
        indent();
        for (int i = 0; i < readShort; i++) {
            dumpParticleData(false);
        }
        outdent();
    }

    static String complexVarietyString(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? new StringBuffer().append("Unknown complex variety (").append(i).append(")").toString() : "MIXED_CONTENT" : "ELEMENT_CONTENT" : "SIMPLE_CONTENT" : "EMPTY_CONTENT";
    }

    static String simpleVarietyString(int i) {
        return i != 1 ? i != 2 ? i != 3 ? new StringBuffer().append("Unknown simple variety (").append(i).append(")").toString() : "LIST" : "UNION" : "ATOMIC";
    }

    String facetCodeString(int i) {
        switch (i) {
            case 0:
                return "FACET_LENGTH";
            case 1:
                return "FACET_MIN_LENGTH";
            case 2:
                return "FACET_MAX_LENGTH";
            case 3:
                return "FACET_MIN_EXCLUSIVE";
            case 4:
                return "FACET_MIN_INCLUSIVE";
            case 5:
                return "FACET_MAX_INCLUSIVE";
            case 6:
                return "FACET_MAX_EXCLUSIVE";
            case 7:
                return "FACET_TOTAL_DIGITS";
            case 8:
                return "FACET_FRACTION_DIGITS";
            default:
                return new StringBuffer().append("Unknown facet code (").append(i).append(")").toString();
        }
    }

    String whitespaceCodeString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? new StringBuffer().append("Unknown whitespace code (").append(i).append(")").toString() : "WS_COLLAPSE" : "WS_REPLACE" : "WS_PRESERVE" : "WS_UNSPECIFIED";
    }

    String derivationTypeString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? new StringBuffer().append("Unknown derivation code (").append(i).append(")").toString() : "DT_EXTENSION" : "DT_RESTRICTION" : "DT_NOT_DERIVED";
    }

    void dumpTypeFileData() {
        int i;
        emit(new StringBuffer().append("Name: ").append(qnameString(readQName())).toString());
        emit(new StringBuffer().append("Outer type: ").append(readType()).toString());
        emit(new StringBuffer().append("Depth: ").append(readShort()).toString());
        emit(new StringBuffer().append("Base type: ").append(readType()).toString());
        emit(new StringBuffer().append("Derivation type: ").append(derivationTypeString(readShort())).toString());
        dumpAnnotation();
        emit("Container field:");
        indent();
        int readShort = readShort();
        emit(new StringBuffer().append("Reftype: ").append(containerfieldTypeString(readShort)).toString());
        if (readShort == 1) {
            emit(new StringBuffer().append("Handle: ").append(readHandle()).toString());
        } else if (readShort == 2) {
            emit(new StringBuffer().append("Index: ").append(readShort()).toString());
        } else if (readShort == 3) {
            emit(new StringBuffer().append("Index: ").append(readShort()).toString());
        }
        outdent();
        emit(new StringBuffer().append("Java class name: ").append(readString()).toString());
        emit(new StringBuffer().append("Java impl class name: ").append(readString()).toString());
        dumpTypeArray("Anonymous types");
        emit(new StringBuffer().append("Anonymous union member ordinal: ").append(readShort()).toString());
        int readInt = readInt();
        emit(new StringBuffer().append("Flags: ").append(typeflagsString(readInt)).toString());
        boolean z = (readInt & 1) == 0;
        if (z) {
            i = readShort();
            emit(new StringBuffer().append("Complex variety: ").append(complexVarietyString(i)).toString());
            if (atLeast(2, 23, 0)) {
                emit(new StringBuffer().append("Content based on type: ").append(readType()).toString());
            }
            int readShort2 = readShort();
            emit(new StringBuffer().append("Attribute model (").append(readShort2).append("):").toString());
            indent();
            for (int i2 = 0; i2 < readShort2; i2++) {
                dumpAttributeData(false);
            }
            emit(new StringBuffer().append("Wildcard set: ").append(qnameSetString(readQNameSet())).toString());
            emit(new StringBuffer().append("Wildcard process: ").append(wcprocessString(readShort())).toString());
            outdent();
            int readShort3 = readShort();
            emit(new StringBuffer().append("Attribute properties (").append(readShort3).append("):").toString());
            indent();
            for (int i3 = 0; i3 < readShort3; i3++) {
                dumpPropertyData();
            }
            outdent();
            if (i == 3 || i == 4) {
                emit(new StringBuffer().append("IsAll: ").append(readShort()).toString());
                dumpParticleArray("Content model");
                int readShort4 = readShort();
                emit(new StringBuffer().append("Element properties (").append(readShort4).append("):").toString());
                indent();
                for (int i4 = 0; i4 < readShort4; i4++) {
                    dumpPropertyData();
                }
                outdent();
            }
        } else {
            i = 0;
        }
        if (!z || i == 2) {
            int readShort5 = readShort();
            emit(new StringBuffer().append("Simple type variety: ").append(simpleVarietyString(readShort5)).toString());
            boolean z2 = (readInt & 64) != 0;
            int readShort6 = readShort();
            emit(new StringBuffer().append("Facets (").append(readShort6).append("):").toString());
            indent();
            for (int i5 = 0; i5 < readShort6; i5++) {
                emit(facetCodeString(readShort()));
                emit(new StringBuffer().append("Value: ").append(readXmlValueObject()).toString());
                emit(new StringBuffer().append("Fixed: ").append(readShort()).toString());
            }
            outdent();
            emit(new StringBuffer().append("Whitespace rule: ").append(whitespaceCodeString(readShort())).toString());
            int readShort7 = readShort();
            emit(new StringBuffer().append("Patterns (").append(readShort7).append("):").toString());
            indent();
            for (int i6 = 0; i6 < readShort7; i6++) {
                emit(readString());
            }
            outdent();
            int readShort8 = readShort();
            emit(new StringBuffer().append("Enumeration values (").append(readShort8).append("):").toString());
            indent();
            for (int i7 = 0; i7 < readShort8; i7++) {
                emit(readXmlValueObject());
            }
            outdent();
            emit(new StringBuffer().append("Base enum type: ").append(readType()).toString());
            if (z2) {
                int readShort9 = readShort();
                emit(new StringBuffer().append("String enum entries (").append(readShort9).append("):").toString());
                indent();
                for (int i8 = 0; i8 < readShort9; i8++) {
                    emit(new StringBuffer().append("\"").append(readString()).append("\" -> ").append(readShort()).append(" = ").append(readString()).toString());
                }
                outdent();
            }
            if (readShort5 == 1) {
                emit(new StringBuffer().append("Primitive type: ").append(readType()).toString());
                emit(new StringBuffer().append("Decimal size: ").append(readInt()).toString());
            } else if (readShort5 == 2) {
                dumpTypeArray("Union members");
            } else if (readShort5 == 3) {
                emit(new StringBuffer().append("List item type: ").append(readType()).toString());
            } else {
                error("Unknown simple type variety");
            }
        }
        emit(new StringBuffer().append("Filename: ").append(readString()).toString());
    }

    static String attruseCodeString(int i) {
        return i != 1 ? i != 2 ? i != 3 ? new StringBuffer().append("Unknown use code (").append(i).append(")").toString() : "REQUIRED" : "OPTIONAL" : "PROHIBITED";
    }

    void dumpAttributeData(boolean z) {
        emit(new StringBuffer().append("Name: ").append(qnameString(readQName())).toString());
        emit(new StringBuffer().append("Type: ").append(readType()).toString());
        emit(new StringBuffer().append("Use: ").append(attruseCodeString(readShort())).toString());
        emit(new StringBuffer().append("Default: ").append(readString()).toString());
        if (atLeast(2, 16, 0)) {
            emit(new StringBuffer().append("Default value: ").append(readXmlValueObject()).toString());
        }
        emit(new StringBuffer().append("Fixed: ").append(readShort()).toString());
        emit(new StringBuffer().append("WsdlArrayType: ").append(SOAPArrayTypeString(readSOAPArrayType())).toString());
        dumpAnnotation();
        if (z) {
            emit(new StringBuffer().append("Filename: ").append(readString()).toString());
        }
    }

    void dumpXml() {
        String readString = readString();
        try {
            emit(XmlObject.Factory.parse(readString).xmlText(prettyOptions));
        } catch (XmlException unused) {
            emit("!!!!!! BAD XML !!!!!");
            emit(readString);
        }
    }

    void dumpModelGroupData() {
        emit(new StringBuffer().append("Name: ").append(qnameString(readQName())).toString());
        emit(new StringBuffer().append("Target namespace: ").append(readString()).toString());
        emit(new StringBuffer().append("Chameleon: ").append(readShort()).toString());
        if (atLeast(2, 22, 0)) {
            emit(new StringBuffer().append("Element form default: ").append(readString()).toString());
        }
        if (atLeast(2, 22, 0)) {
            emit(new StringBuffer().append("Attribute form default: ").append(readString()).toString());
        }
        if (atLeast(2, 15, 0)) {
            emit(new StringBuffer().append("Redefine: ").append(readShort()).toString());
        }
        emit("Model Group Xml: ");
        dumpXml();
        dumpAnnotation();
        if (atLeast(2, 21, 0)) {
            emit(new StringBuffer().append("Filename: ").append(readString()).toString());
        }
    }

    void dumpAttributeGroupData() {
        emit(new StringBuffer().append("Name: ").append(qnameString(readQName())).toString());
        emit(new StringBuffer().append("Target namespace: ").append(readString()).toString());
        emit(new StringBuffer().append("Chameleon: ").append(readShort()).toString());
        if (atLeast(2, 22, 0)) {
            emit(new StringBuffer().append("Form default: ").append(readString()).toString());
        }
        if (atLeast(2, 15, 0)) {
            emit(new StringBuffer().append("Redefine: ").append(readShort()).toString());
        }
        emit("Attribute Group Xml: ");
        dumpXml();
        dumpAnnotation();
        if (atLeast(2, 21, 0)) {
            emit(new StringBuffer().append("Filename: ").append(readString()).toString());
        }
    }

    static String alwaysString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? new StringBuffer().append("Unknown frequency code (").append(i).append(")").toString() : "CONSISTENTLY" : "VARIABLE" : "NEVER";
    }

    static String jtcString(int i) {
        switch (i) {
            case 0:
                return "XML_OBJECT";
            case 1:
                return "JAVA_BOOLEAN";
            case 2:
                return "JAVA_FLOAT";
            case 3:
                return "JAVA_DOUBLE";
            case 4:
                return "JAVA_BYTE";
            case 5:
                return "JAVA_SHORT";
            case 6:
                return "JAVA_INT";
            case 7:
                return "JAVA_LONG";
            case 8:
                return "JAVA_BIG_DECIMAL";
            case 9:
                return "JAVA_BIG_INTEGER";
            case 10:
                return "JAVA_STRING";
            case 11:
                return "JAVA_BYTE_ARRAY";
            case 12:
                return "JAVA_GDATE";
            case 13:
                return "JAVA_GDURATION";
            case 14:
                return "JAVA_DATE";
            case 15:
                return "JAVA_QNAME";
            case 16:
                return "JAVA_LIST";
            case 17:
                return "JAVA_CALENDAR";
            case 18:
                return "JAVA_ENUM";
            case 19:
                return "JAVA_OBJECT";
            default:
                return new StringBuffer().append("Unknown java type code (").append(i).append(")").toString();
        }
    }

    void dumpPropertyData() {
        emit("Property");
        indent();
        emit(new StringBuffer().append("Name: ").append(qnameString(readQName())).toString());
        emit(new StringBuffer().append("Type: ").append(readType()).toString());
        int readShort = readShort();
        emit(new StringBuffer().append("Flags: ").append(propertyflagsString(readShort)).toString());
        emit(new StringBuffer().append("Container type: ").append(readType()).toString());
        emit(new StringBuffer().append("Min occurances: ").append(bigIntegerString(readBigInteger())).toString());
        emit(new StringBuffer().append("Max occurances: ").append(bigIntegerString(readBigInteger())).toString());
        emit(new StringBuffer().append("Nillable: ").append(alwaysString(readShort())).toString());
        emit(new StringBuffer().append("Default: ").append(alwaysString(readShort())).toString());
        emit(new StringBuffer().append("Fixed: ").append(alwaysString(readShort())).toString());
        emit(new StringBuffer().append("Default text: ").append(readString()).toString());
        emit(new StringBuffer().append("Java prop name: ").append(readString()).toString());
        emit(new StringBuffer().append("Java type code: ").append(jtcString(readShort())).toString());
        emit(new StringBuffer().append("Type for java signature: ").append(readType()).toString());
        if (atMost(2, 19, 0)) {
            emit(new StringBuffer().append("Java setter delimiter: ").append(qnameSetString(readQNameSet())).toString());
        }
        if (atLeast(2, 16, 0)) {
            emit(new StringBuffer().append("Default value: ").append(readXmlValueObject()).toString());
        }
        if ((readShort & 1) == 0 && atLeast(2, 17, 0)) {
            int readShort2 = readShort();
            emit(new StringBuffer().append("Accepted substitutions (").append(readShort2).append("):").toString());
            for (int i = 0; i < readShort2; i++) {
                emit(new StringBuffer().append("  Accepted name ").append(readQName()).toString());
            }
        }
        outdent();
    }

    String readXmlValueObject() {
        String str;
        String readType = readType();
        if (readType == null) {
            return "null";
        }
        int readShort = readShort();
        if (readShort != 0) {
            switch (readShort) {
                case 2:
                case 3:
                case 6:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                    str = readString();
                    return new StringBuffer().append(str).append(" (").append(readType).append(": ").append(readShort).append(")").toString();
                case 4:
                case 5:
                    str = new String(HexBin.encode(readByteArray()));
                    if (str.length() > 19) {
                        str = new StringBuffer().append((Object) str.subSequence(0, 16)).append("...").toString();
                    }
                    return new StringBuffer().append(str).append(" (").append(readType).append(": ").append(readShort).append(")").toString();
                case 7:
                case 8:
                    str = QNameHelper.pretty(readQName());
                    return new StringBuffer().append(str).append(" (").append(readType).append(": ").append(readShort).append(")").toString();
                case 9:
                case 10:
                    str = Double.toString(readDouble());
                    return new StringBuffer().append(str).append(" (").append(readType).append(": ").append(readShort).append(")").toString();
                default:
                    if (!$assertionsDisabled) {
                        throw new AssertionError();
                    }
                    break;
            }
        }
        str = "nil";
        return new StringBuffer().append(str).append(" (").append(readType).append(": ").append(readShort).append(")").toString();
    }

    double readDouble() {
        try {
            return this._input.readDouble();
        } catch (IOException e) {
            error(e);
            return 0.0d;
        }
    }

    String SOAPArrayTypeString(SOAPArrayType sOAPArrayType) {
        return sOAPArrayType == null ? "null" : new StringBuffer().append(QNameHelper.pretty(sOAPArrayType.getQName())).append(sOAPArrayType.soap11DimensionString()).toString();
    }

    SOAPArrayType readSOAPArrayType() {
        QName readQName = readQName();
        String readString = readString();
        if (readQName == null) {
            return null;
        }
        return new SOAPArrayType(readQName, readString);
    }

    QNameSet readQNameSet() {
        int readShort = readShort();
        HashSet hashSet = new HashSet();
        int readShort2 = readShort();
        for (int i = 0; i < readShort2; i++) {
            hashSet.add(readString());
        }
        HashSet hashSet2 = new HashSet();
        int readShort3 = readShort();
        for (int i2 = 0; i2 < readShort3; i2++) {
            hashSet2.add(readQName());
        }
        HashSet hashSet3 = new HashSet();
        int readShort4 = readShort();
        for (int i3 = 0; i3 < readShort4; i3++) {
            hashSet3.add(readQName());
        }
        if (readShort == 1) {
            return QNameSet.forSets(hashSet, null, hashSet2, hashSet3);
        }
        return QNameSet.forSets(null, hashSet, hashSet3, hashSet2);
    }

    byte[] readByteArray() {
        try {
            byte[] bArr = new byte[this._input.readShort()];
            this._input.readFully(bArr);
            return bArr;
        } catch (IOException e) {
            error(e);
            return null;
        }
    }

    BigInteger readBigInteger() {
        byte[] readByteArray = readByteArray();
        if (readByteArray.length == 0) {
            return null;
        }
        if (readByteArray.length == 1 && readByteArray[0] == 0) {
            return BigInteger.ZERO;
        }
        if (readByteArray.length == 1 && readByteArray[0] == 1) {
            return BigInteger.ONE;
        }
        return new BigInteger(readByteArray);
    }

    protected boolean atLeast(int i, int i2, int i3) {
        int i4 = this._majorver;
        if (i4 > i) {
            return true;
        }
        if (i4 < i) {
            return false;
        }
        int i5 = this._minorver;
        if (i5 > i2) {
            return true;
        }
        return i5 >= i2 && this._releaseno >= i3;
    }

    protected boolean atMost(int i, int i2, int i3) {
        int i4 = this._majorver;
        if (i4 > i) {
            return false;
        }
        if (i4 < i) {
            return true;
        }
        int i5 = this._minorver;
        if (i5 > i2) {
            return false;
        }
        return i5 < i2 || this._releaseno <= i3;
    }
}
