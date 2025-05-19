package org.apache.commons.collections;

import com.opencsv.ICSVParser;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;
import org.apache.commons.lang3.BooleanUtils;

/* loaded from: classes4.dex */
public class ExtendedProperties extends Hashtable {
    protected static final String END_TOKEN = "}";
    protected static final String START_TOKEN = "${";
    protected static String include = "include";
    protected String basePath;
    private ExtendedProperties defaults;
    protected String file;
    protected String fileSeparator;
    protected boolean isInitialized;
    protected ArrayList keysAsListed;

    protected String interpolate(String str) {
        return interpolateHelper(str, null);
    }

    protected String interpolateHelper(String str, List list) {
        int i;
        int indexOf;
        if (str == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList();
            list.add(str);
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = -1;
        while (true) {
            i = i2 + 1;
            int indexOf2 = str.indexOf("${", i);
            if (indexOf2 <= -1 || (indexOf = str.indexOf("}", indexOf2)) <= -1) {
                break;
            }
            stringBuffer.append(str.substring(i, indexOf2));
            String substring = str.substring(indexOf2 + 2, indexOf);
            if (list.contains(substring)) {
                String obj = list.remove(0).toString();
                list.add(substring);
                StringBuffer stringBuffer2 = new StringBuffer();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    stringBuffer2.append(it.next());
                    if (it.hasNext()) {
                        stringBuffer2.append("->");
                    }
                }
                throw new IllegalStateException(new StringBuffer().append("infinite loop in property interpolation of ").append(obj).append(": ").append(stringBuffer2.toString()).toString());
            }
            list.add(substring);
            Object property = getProperty(substring);
            if (property != null) {
                stringBuffer.append(interpolateHelper(property.toString(), list));
                list.remove(list.size() - 1);
            } else {
                ExtendedProperties extendedProperties = this.defaults;
                if (extendedProperties != null && extendedProperties.getString(substring, null) != null) {
                    stringBuffer.append(this.defaults.getString(substring));
                } else {
                    stringBuffer.append("${").append(substring).append("}");
                }
            }
            i2 = indexOf;
        }
        stringBuffer.append(str.substring(i, str.length()));
        return stringBuffer.toString();
    }

    private static String escape(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        int i = 0;
        while (i < stringBuffer.length()) {
            char charAt = stringBuffer.charAt(i);
            if (charAt == ',' || charAt == '\\') {
                stringBuffer.insert(i, ICSVParser.DEFAULT_ESCAPE_CHARACTER);
                i++;
            }
            i++;
        }
        return stringBuffer.toString();
    }

    private static String unescape(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        int i = 0;
        while (i < stringBuffer.length() - 1) {
            char charAt = stringBuffer.charAt(i);
            int i2 = i + 1;
            char charAt2 = stringBuffer.charAt(i2);
            if (charAt == '\\' && charAt2 == '\\') {
                stringBuffer.deleteCharAt(i);
            }
            i = i2;
        }
        return stringBuffer.toString();
    }

    private static int countPreceding(String str, int i, char c) {
        int i2 = i - 1;
        int i3 = i2;
        while (i3 >= 0 && str.charAt(i3) == c) {
            i3--;
        }
        return i2 - i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean endsWithSlash(String str) {
        return str.endsWith("\\") && countPreceding(str, str.length() - 1, ICSVParser.DEFAULT_ESCAPE_CHARACTER) % 2 == 0;
    }

    static class PropertiesReader extends LineNumberReader {
        public PropertiesReader(Reader reader) {
            super(reader);
        }

        public String readProperty() throws IOException {
            StringBuffer stringBuffer = new StringBuffer();
            String readLine = readLine();
            while (readLine != null) {
                String trim = readLine.trim();
                if (trim.length() != 0 && trim.charAt(0) != '#') {
                    if (ExtendedProperties.endsWithSlash(trim)) {
                        stringBuffer.append(trim.substring(0, trim.length() - 1));
                    } else {
                        stringBuffer.append(trim);
                        return stringBuffer.toString();
                    }
                }
                readLine = readLine();
            }
            return null;
        }
    }

    static class PropertiesTokenizer extends StringTokenizer {
        static final String DELIMITER = ",";

        public PropertiesTokenizer(String str) {
            super(str, DELIMITER);
        }

        @Override // java.util.StringTokenizer
        public boolean hasMoreTokens() {
            return super.hasMoreTokens();
        }

        @Override // java.util.StringTokenizer
        public String nextToken() {
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                if (!hasMoreTokens()) {
                    break;
                }
                String nextToken = super.nextToken();
                if (ExtendedProperties.endsWithSlash(nextToken)) {
                    stringBuffer.append(nextToken.substring(0, nextToken.length() - 1));
                    stringBuffer.append(DELIMITER);
                } else {
                    stringBuffer.append(nextToken);
                    break;
                }
            }
            return stringBuffer.toString().trim();
        }
    }

    public ExtendedProperties() {
        try {
            this.fileSeparator = (String) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.commons.collections.ExtendedProperties.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    return System.getProperty("file.separator");
                }
            });
        } catch (SecurityException unused) {
            this.fileSeparator = File.separator;
        }
        this.isInitialized = false;
        this.keysAsListed = new ArrayList();
    }

    public ExtendedProperties(String str) throws IOException {
        this(str, null);
    }

    public ExtendedProperties(String str, String str2) throws IOException {
        FileInputStream fileInputStream;
        try {
            this.fileSeparator = (String) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.commons.collections.ExtendedProperties.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    return System.getProperty("file.separator");
                }
            });
        } catch (SecurityException unused) {
            this.fileSeparator = File.separator;
        }
        this.isInitialized = false;
        this.keysAsListed = new ArrayList();
        this.file = str;
        String absolutePath = new File(str).getAbsolutePath();
        this.basePath = absolutePath;
        this.basePath = absolutePath.substring(0, absolutePath.lastIndexOf(this.fileSeparator) + 1);
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Throwable th) {
            th = th;
        }
        try {
            load(fileInputStream);
            try {
                fileInputStream.close();
            } catch (IOException unused2) {
            }
            if (str2 != null) {
                this.defaults = new ExtendedProperties(str2);
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    public boolean isInitialized() {
        return this.isInitialized;
    }

    public String getInclude() {
        return include;
    }

    public void setInclude(String str) {
        include = str;
    }

    public void load(InputStream inputStream) throws IOException {
        load(inputStream, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0032 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0014 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void load(java.io.InputStream r5, java.lang.String r6) throws java.io.IOException {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r6 == 0) goto L11
            org.apache.commons.collections.ExtendedProperties$PropertiesReader r0 = new org.apache.commons.collections.ExtendedProperties$PropertiesReader     // Catch: java.lang.Throwable -> Le java.io.UnsupportedEncodingException -> L11
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> Le java.io.UnsupportedEncodingException -> L11
            r1.<init>(r5, r6)     // Catch: java.lang.Throwable -> Le java.io.UnsupportedEncodingException -> L11
            r0.<init>(r1)     // Catch: java.lang.Throwable -> Le java.io.UnsupportedEncodingException -> L11
            goto L12
        Le:
            r5 = move-exception
            goto Lcf
        L11:
            r0 = 0
        L12:
            if (r0 != 0) goto L2b
            org.apache.commons.collections.ExtendedProperties$PropertiesReader r0 = new org.apache.commons.collections.ExtendedProperties$PropertiesReader     // Catch: java.lang.Throwable -> Le java.io.UnsupportedEncodingException -> L21
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> Le java.io.UnsupportedEncodingException -> L21
            java.lang.String r1 = "8859_1"
            r6.<init>(r5, r1)     // Catch: java.lang.Throwable -> Le java.io.UnsupportedEncodingException -> L21
            r0.<init>(r6)     // Catch: java.lang.Throwable -> Le java.io.UnsupportedEncodingException -> L21
            goto L2b
        L21:
            org.apache.commons.collections.ExtendedProperties$PropertiesReader r0 = new org.apache.commons.collections.ExtendedProperties$PropertiesReader     // Catch: java.lang.Throwable -> Le
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> Le
            r6.<init>(r5)     // Catch: java.lang.Throwable -> Le
            r0.<init>(r6)     // Catch: java.lang.Throwable -> Le
        L2b:
            r5 = 1
            java.lang.String r6 = r0.readProperty()     // Catch: java.lang.Throwable -> Lcb
            if (r6 != 0) goto L36
            r4.isInitialized = r5     // Catch: java.lang.Throwable -> Le
            monitor-exit(r4)
            return
        L36:
            r1 = 61
            int r1 = r6.indexOf(r1)     // Catch: java.lang.Throwable -> Lcb
            if (r1 <= 0) goto L2b
            r2 = 0
            java.lang.String r2 = r6.substring(r2, r1)     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r2 = r2.trim()     // Catch: java.lang.Throwable -> Lcb
            int r1 = r1 + 1
            java.lang.String r6 = r6.substring(r1)     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r6 = r6.trim()     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r1 = ""
            boolean r1 = r1.equals(r6)     // Catch: java.lang.Throwable -> Lcb
            if (r1 == 0) goto L5a
            goto L2b
        L5a:
            java.lang.String r1 = r4.getInclude()     // Catch: java.lang.Throwable -> Lcb
            if (r1 == 0) goto Lc6
            java.lang.String r1 = r4.getInclude()     // Catch: java.lang.Throwable -> Lcb
            boolean r1 = r2.equalsIgnoreCase(r1)     // Catch: java.lang.Throwable -> Lcb
            if (r1 == 0) goto Lc6
            java.lang.String r1 = r4.fileSeparator     // Catch: java.lang.Throwable -> Lcb
            boolean r1 = r6.startsWith(r1)     // Catch: java.lang.Throwable -> Lcb
            if (r1 == 0) goto L78
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> Lcb
            r1.<init>(r6)     // Catch: java.lang.Throwable -> Lcb
            goto Lb0
        L78:
            java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> Lcb
            r1.<init>()     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r2 = "."
            java.lang.StringBuffer r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r2 = r4.fileSeparator     // Catch: java.lang.Throwable -> Lcb
            java.lang.StringBuffer r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lcb
            boolean r1 = r6.startsWith(r1)     // Catch: java.lang.Throwable -> Lcb
            if (r1 == 0) goto L98
            r1 = 2
            java.lang.String r6 = r6.substring(r1)     // Catch: java.lang.Throwable -> Lcb
        L98:
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> Lcb
            java.lang.StringBuffer r2 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> Lcb
            r2.<init>()     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r3 = r4.basePath     // Catch: java.lang.Throwable -> Lcb
            java.lang.StringBuffer r2 = r2.append(r3)     // Catch: java.lang.Throwable -> Lcb
            java.lang.StringBuffer r6 = r2.append(r6)     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> Lcb
            r1.<init>(r6)     // Catch: java.lang.Throwable -> Lcb
        Lb0:
            boolean r6 = r1.exists()     // Catch: java.lang.Throwable -> Lcb
            if (r6 == 0) goto L2b
            boolean r6 = r1.canRead()     // Catch: java.lang.Throwable -> Lcb
            if (r6 == 0) goto L2b
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> Lcb
            r6.<init>(r1)     // Catch: java.lang.Throwable -> Lcb
            r4.load(r6)     // Catch: java.lang.Throwable -> Lcb
            goto L2b
        Lc6:
            r4.addProperty(r2, r6)     // Catch: java.lang.Throwable -> Lcb
            goto L2b
        Lcb:
            r6 = move-exception
            r4.isInitialized = r5     // Catch: java.lang.Throwable -> Le
            throw r6     // Catch: java.lang.Throwable -> Le
        Lcf:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.collections.ExtendedProperties.load(java.io.InputStream, java.lang.String):void");
    }

    public Object getProperty(String str) {
        ExtendedProperties extendedProperties;
        Object obj = get(str);
        return (obj != null || (extendedProperties = this.defaults) == null) ? obj : extendedProperties.get(str);
    }

    public void addProperty(String str, Object obj) {
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (str2.indexOf(",") > 0) {
                PropertiesTokenizer propertiesTokenizer = new PropertiesTokenizer(str2);
                while (propertiesTokenizer.hasMoreTokens()) {
                    addPropertyInternal(str, unescape(propertiesTokenizer.nextToken()));
                }
            } else {
                addPropertyInternal(str, unescape(str2));
            }
        } else {
            addPropertyInternal(str, obj);
        }
        this.isInitialized = true;
    }

    private void addPropertyDirect(String str, Object obj) {
        if (!containsKey(str)) {
            this.keysAsListed.add(str);
        }
        put(str, obj);
    }

    private void addPropertyInternal(String str, Object obj) {
        Object obj2 = get(str);
        if (obj2 instanceof String) {
            Vector vector = new Vector(2);
            vector.add(obj2);
            vector.add(obj);
            put(str, vector);
            return;
        }
        if (obj2 instanceof List) {
            ((List) obj2).add(obj);
            return;
        }
        if (!containsKey(str)) {
            this.keysAsListed.add(str);
        }
        put(str, obj);
    }

    public void setProperty(String str, Object obj) {
        clearProperty(str);
        addProperty(str, obj);
    }

    public synchronized void save(OutputStream outputStream, String str) throws IOException {
        if (outputStream == null) {
            return;
        }
        PrintWriter printWriter = new PrintWriter(outputStream);
        if (str != null) {
            printWriter.println(str);
        }
        Enumeration keys = keys();
        while (keys.hasMoreElements()) {
            String str2 = (String) keys.nextElement();
            Object obj = get(str2);
            if (obj != null) {
                if (obj instanceof String) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(str2);
                    stringBuffer.append("=");
                    stringBuffer.append(escape((String) obj));
                    printWriter.println(stringBuffer.toString());
                } else if (obj instanceof List) {
                    for (String str3 : (List) obj) {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append(str2);
                        stringBuffer2.append("=");
                        stringBuffer2.append(escape(str3));
                        printWriter.println(stringBuffer2.toString());
                    }
                }
            }
            printWriter.println();
            printWriter.flush();
        }
    }

    public void combine(ExtendedProperties extendedProperties) {
        Iterator keys = extendedProperties.getKeys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            setProperty(str, extendedProperties.get(str));
        }
    }

    public void clearProperty(String str) {
        if (containsKey(str)) {
            int i = 0;
            while (true) {
                if (i >= this.keysAsListed.size()) {
                    break;
                }
                if (this.keysAsListed.get(i).equals(str)) {
                    this.keysAsListed.remove(i);
                    break;
                }
                i++;
            }
            remove(str);
        }
    }

    public Iterator getKeys() {
        return this.keysAsListed.iterator();
    }

    public Iterator getKeys(String str) {
        Iterator keys = getKeys();
        ArrayList arrayList = new ArrayList();
        while (keys.hasNext()) {
            Object next = keys.next();
            if ((next instanceof String) && ((String) next).startsWith(str)) {
                arrayList.add(next);
            }
        }
        return arrayList.iterator();
    }

    public ExtendedProperties subset(String str) {
        ExtendedProperties extendedProperties = new ExtendedProperties();
        Iterator keys = getKeys();
        boolean z = false;
        while (keys.hasNext()) {
            Object next = keys.next();
            if (next instanceof String) {
                String str2 = (String) next;
                if (str2.startsWith(str)) {
                    if (!z) {
                        z = true;
                    }
                    extendedProperties.addPropertyDirect(str2.length() == str.length() ? str : str2.substring(str.length() + 1), get(next));
                }
            }
        }
        if (z) {
            return extendedProperties;
        }
        return null;
    }

    public void display() {
        Iterator keys = getKeys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            System.out.println(new StringBuffer().append(str).append(" => ").append(get(str)).toString());
        }
    }

    public String getString(String str) {
        return getString(str, null);
    }

    public String getString(String str, String str2) {
        Object obj = get(str);
        if (obj instanceof String) {
            return interpolate((String) obj);
        }
        if (obj == null) {
            ExtendedProperties extendedProperties = this.defaults;
            if (extendedProperties != null) {
                return interpolate(extendedProperties.getString(str, str2));
            }
            return interpolate(str2);
        }
        if (obj instanceof List) {
            return interpolate((String) ((List) obj).get(0));
        }
        throw new ClassCastException(new StringBuffer().append('\'').append(str).append("' doesn't map to a String object").toString());
    }

    public Properties getProperties(String str) {
        return getProperties(str, new Properties());
    }

    public Properties getProperties(String str, Properties properties) {
        String[] stringArray = getStringArray(str);
        Properties properties2 = new Properties(properties);
        for (String str2 : stringArray) {
            int indexOf = str2.indexOf(61);
            if (indexOf > 0) {
                properties2.put(str2.substring(0, indexOf).trim(), str2.substring(indexOf + 1).trim());
            } else {
                throw new IllegalArgumentException(new StringBuffer().append('\'').append(str2).append("' does not contain ").append("an equals sign").toString());
            }
        }
        return properties2;
    }

    public String[] getStringArray(String str) {
        List list;
        Object obj = get(str);
        if (obj instanceof String) {
            list = new Vector(1);
            list.add(obj);
        } else {
            if (!(obj instanceof List)) {
                if (obj == null) {
                    ExtendedProperties extendedProperties = this.defaults;
                    return extendedProperties != null ? extendedProperties.getStringArray(str) : new String[0];
                }
                throw new ClassCastException(new StringBuffer().append('\'').append(str).append("' doesn't map to a String/List object").toString());
            }
            list = (List) obj;
        }
        int size = list.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = (String) list.get(i);
        }
        return strArr;
    }

    public Vector getVector(String str) {
        return getVector(str, null);
    }

    public Vector getVector(String str, Vector vector) {
        Object obj = get(str);
        if (obj instanceof List) {
            return new Vector((List) obj);
        }
        if (obj instanceof String) {
            Vector vector2 = new Vector(1);
            vector2.add(obj);
            put(str, vector2);
            return vector2;
        }
        if (obj == null) {
            ExtendedProperties extendedProperties = this.defaults;
            if (extendedProperties != null) {
                return extendedProperties.getVector(str, vector);
            }
            return vector == null ? new Vector() : vector;
        }
        throw new ClassCastException(new StringBuffer().append('\'').append(str).append("' doesn't map to a Vector object").toString());
    }

    public List getList(String str) {
        return getList(str, null);
    }

    public List getList(String str, List list) {
        Object obj = get(str);
        if (obj instanceof List) {
            return new ArrayList((List) obj);
        }
        if (obj instanceof String) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(obj);
            put(str, arrayList);
            return arrayList;
        }
        if (obj == null) {
            ExtendedProperties extendedProperties = this.defaults;
            if (extendedProperties != null) {
                return extendedProperties.getList(str, list);
            }
            return list == null ? new ArrayList() : list;
        }
        throw new ClassCastException(new StringBuffer().append('\'').append(str).append("' doesn't map to a List object").toString());
    }

    public boolean getBoolean(String str) {
        Boolean bool = getBoolean(str, (Boolean) null);
        if (bool != null) {
            return bool.booleanValue();
        }
        throw new NoSuchElementException(new StringBuffer().append('\'').append(str).append("' doesn't map to an existing object").toString());
    }

    public boolean getBoolean(String str, boolean z) {
        return getBoolean(str, new Boolean(z)).booleanValue();
    }

    public Boolean getBoolean(String str, Boolean bool) {
        Object obj = get(str);
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            Boolean bool2 = new Boolean(testBoolean((String) obj));
            put(str, bool2);
            return bool2;
        }
        if (obj == null) {
            ExtendedProperties extendedProperties = this.defaults;
            return extendedProperties != null ? extendedProperties.getBoolean(str, bool) : bool;
        }
        throw new ClassCastException(new StringBuffer().append('\'').append(str).append("' doesn't map to a Boolean object").toString());
    }

    public String testBoolean(String str) {
        String lowerCase = str.toLowerCase();
        String str2 = BooleanUtils.TRUE;
        if (!lowerCase.equals(BooleanUtils.TRUE) && !lowerCase.equals("on") && !lowerCase.equals(BooleanUtils.YES)) {
            str2 = "false";
            if (!lowerCase.equals("false") && !lowerCase.equals("off") && !lowerCase.equals(BooleanUtils.NO)) {
                return null;
            }
        }
        return str2;
    }

    public byte getByte(String str) {
        Byte b = getByte(str, (Byte) null);
        if (b != null) {
            return b.byteValue();
        }
        throw new NoSuchElementException(new StringBuffer().append('\'').append(str).append(" doesn't map to an existing object").toString());
    }

    public byte getByte(String str, byte b) {
        return getByte(str, new Byte(b)).byteValue();
    }

    public Byte getByte(String str, Byte b) {
        Object obj = get(str);
        if (obj instanceof Byte) {
            return (Byte) obj;
        }
        if (obj instanceof String) {
            Byte b2 = new Byte((String) obj);
            put(str, b2);
            return b2;
        }
        if (obj == null) {
            ExtendedProperties extendedProperties = this.defaults;
            return extendedProperties != null ? extendedProperties.getByte(str, b) : b;
        }
        throw new ClassCastException(new StringBuffer().append('\'').append(str).append("' doesn't map to a Byte object").toString());
    }

    public short getShort(String str) {
        Short sh = getShort(str, (Short) null);
        if (sh != null) {
            return sh.shortValue();
        }
        throw new NoSuchElementException(new StringBuffer().append('\'').append(str).append("' doesn't map to an existing object").toString());
    }

    public short getShort(String str, short s) {
        return getShort(str, new Short(s)).shortValue();
    }

    public Short getShort(String str, Short sh) {
        Object obj = get(str);
        if (obj instanceof Short) {
            return (Short) obj;
        }
        if (obj instanceof String) {
            Short sh2 = new Short((String) obj);
            put(str, sh2);
            return sh2;
        }
        if (obj == null) {
            ExtendedProperties extendedProperties = this.defaults;
            return extendedProperties != null ? extendedProperties.getShort(str, sh) : sh;
        }
        throw new ClassCastException(new StringBuffer().append('\'').append(str).append("' doesn't map to a Short object").toString());
    }

    public int getInt(String str) {
        return getInteger(str);
    }

    public int getInt(String str, int i) {
        return getInteger(str, i);
    }

    public int getInteger(String str) {
        Integer integer = getInteger(str, (Integer) null);
        if (integer != null) {
            return integer.intValue();
        }
        throw new NoSuchElementException(new StringBuffer().append('\'').append(str).append("' doesn't map to an existing object").toString());
    }

    public int getInteger(String str, int i) {
        Integer integer = getInteger(str, (Integer) null);
        return integer == null ? i : integer.intValue();
    }

    public Integer getInteger(String str, Integer num) {
        Object obj = get(str);
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof String) {
            Integer num2 = new Integer((String) obj);
            put(str, num2);
            return num2;
        }
        if (obj == null) {
            ExtendedProperties extendedProperties = this.defaults;
            return extendedProperties != null ? extendedProperties.getInteger(str, num) : num;
        }
        throw new ClassCastException(new StringBuffer().append('\'').append(str).append("' doesn't map to a Integer object").toString());
    }

    public long getLong(String str) {
        Long l = getLong(str, (Long) null);
        if (l != null) {
            return l.longValue();
        }
        throw new NoSuchElementException(new StringBuffer().append('\'').append(str).append("' doesn't map to an existing object").toString());
    }

    public long getLong(String str, long j) {
        return getLong(str, new Long(j)).longValue();
    }

    public Long getLong(String str, Long l) {
        Object obj = get(str);
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            Long l2 = new Long((String) obj);
            put(str, l2);
            return l2;
        }
        if (obj == null) {
            ExtendedProperties extendedProperties = this.defaults;
            return extendedProperties != null ? extendedProperties.getLong(str, l) : l;
        }
        throw new ClassCastException(new StringBuffer().append('\'').append(str).append("' doesn't map to a Long object").toString());
    }

    public float getFloat(String str) {
        Float f = getFloat(str, (Float) null);
        if (f != null) {
            return f.floatValue();
        }
        throw new NoSuchElementException(new StringBuffer().append('\'').append(str).append("' doesn't map to an existing object").toString());
    }

    public float getFloat(String str, float f) {
        return getFloat(str, new Float(f)).floatValue();
    }

    public Float getFloat(String str, Float f) {
        Object obj = get(str);
        if (obj instanceof Float) {
            return (Float) obj;
        }
        if (obj instanceof String) {
            Float f2 = new Float((String) obj);
            put(str, f2);
            return f2;
        }
        if (obj == null) {
            ExtendedProperties extendedProperties = this.defaults;
            return extendedProperties != null ? extendedProperties.getFloat(str, f) : f;
        }
        throw new ClassCastException(new StringBuffer().append('\'').append(str).append("' doesn't map to a Float object").toString());
    }

    public double getDouble(String str) {
        Double d = getDouble(str, (Double) null);
        if (d != null) {
            return d.doubleValue();
        }
        throw new NoSuchElementException(new StringBuffer().append('\'').append(str).append("' doesn't map to an existing object").toString());
    }

    public double getDouble(String str, double d) {
        return getDouble(str, new Double(d)).doubleValue();
    }

    public Double getDouble(String str, Double d) {
        Object obj = get(str);
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof String) {
            Double d2 = new Double((String) obj);
            put(str, d2);
            return d2;
        }
        if (obj == null) {
            ExtendedProperties extendedProperties = this.defaults;
            return extendedProperties != null ? extendedProperties.getDouble(str, d) : d;
        }
        throw new ClassCastException(new StringBuffer().append('\'').append(str).append("' doesn't map to a Double object").toString());
    }

    public static ExtendedProperties convertProperties(Properties properties) {
        ExtendedProperties extendedProperties = new ExtendedProperties();
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str = (String) propertyNames.nextElement();
            extendedProperties.setProperty(str, properties.getProperty(str));
        }
        return extendedProperties;
    }
}
