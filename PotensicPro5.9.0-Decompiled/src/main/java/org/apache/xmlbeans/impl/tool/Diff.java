package org.apache.xmlbeans.impl.tool;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import org.apache.xmlbeans.SystemProperties;
import org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl;

/* loaded from: classes5.dex */
public class Diff {
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$tool$Diff;

    static {
        if (class$org$apache$xmlbeans$impl$tool$Diff == null) {
            class$org$apache$xmlbeans$impl$tool$Diff = class$("org.apache.xmlbeans.impl.tool.Diff");
        }
        $assertionsDisabled = true;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static void main(String[] strArr) {
        if (strArr.length != 2) {
            System.out.println("Usage: diff <jarname1> <jarname2> to compare two jars");
            System.out.println("  or   diff <dirname1> <dirname2> to compare two dirs");
            return;
        }
        File file = new File(strArr[0]);
        if (!file.exists()) {
            System.out.println(new StringBuffer().append("File \"").append(strArr[0]).append("\" not found.").toString());
            return;
        }
        File file2 = new File(strArr[1]);
        if (!file2.exists()) {
            System.out.println(new StringBuffer().append("File \"").append(strArr[1]).append("\" not found.").toString());
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (file.isDirectory()) {
            if (!file2.isDirectory()) {
                System.out.println("Both parameters have to be directories if the first parameter is a directory.");
                return;
            }
            dirsAsTypeSystems(file, file2, arrayList);
        } else if (file2.isDirectory()) {
            System.out.println("Both parameters have to be jar files if the first parameter is a jar file.");
            return;
        } else {
            try {
                jarsAsTypeSystems(new JarFile(file), new JarFile(file2), arrayList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (arrayList.size() < 1) {
            System.out.println("No differences encountered.");
            return;
        }
        System.out.println("Differences:");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i).toString());
        }
    }

    public static void jarsAsTypeSystems(JarFile jarFile, JarFile jarFile2, List list) {
        Enumeration<JarEntry> entries = jarFile.entries();
        Enumeration<JarEntry> entries2 = jarFile2.entries();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        while (entries.hasMoreElements()) {
            JarEntry nextElement = entries.nextElement();
            String name = nextElement.getName();
            if (name.startsWith(new StringBuffer().append("schema").append(SchemaTypeSystemImpl.METADATA_PACKAGE_GEN).append("/system/s").toString()) && name.endsWith(".xsb")) {
                arrayList.add(nextElement);
            }
        }
        while (entries2.hasMoreElements()) {
            JarEntry nextElement2 = entries2.nextElement();
            String name2 = nextElement2.getName();
            if (name2.startsWith(new StringBuffer().append("schema").append(SchemaTypeSystemImpl.METADATA_PACKAGE_GEN).append("/system/s").toString()) && name2.endsWith(".xsb")) {
                arrayList2.add(nextElement2);
            }
        }
        ZipEntry[] zipEntryArr = (ZipEntry[]) arrayList.toArray(new ZipEntry[arrayList.size()]);
        ZipEntry[] zipEntryArr2 = (ZipEntry[]) arrayList2.toArray(new ZipEntry[arrayList2.size()]);
        ZipEntryNameComparator zipEntryNameComparator = new ZipEntryNameComparator();
        Arrays.sort(zipEntryArr, zipEntryNameComparator);
        Arrays.sort(zipEntryArr2, zipEntryNameComparator);
        int i = 0;
        int i2 = 0;
        while (i < zipEntryArr.length && i2 < zipEntryArr2.length) {
            String name3 = zipEntryArr[i].getName();
            String name4 = zipEntryArr2[i2].getName();
            int compareTo = name3.compareTo(name4);
            if (compareTo == 0) {
                zipEntriesAsXsb(zipEntryArr[i], jarFile, zipEntryArr2[i2], jarFile2, list);
                i++;
            } else if (compareTo < 0) {
                list.add(new StringBuffer().append("Jar \"").append(jarFile.getName()).append("\" contains an extra file: \"").append(name3).append("\"").toString());
                i++;
            } else if (compareTo > 0) {
                list.add(new StringBuffer().append("Jar \"").append(jarFile2.getName()).append("\" contains an extra file: \"").append(name4).append("\"").toString());
            }
            i2++;
        }
        while (i < zipEntryArr.length) {
            list.add(new StringBuffer().append("Jar \"").append(jarFile.getName()).append("\" contains an extra file: \"").append(zipEntryArr[i].getName()).append("\"").toString());
            i++;
        }
        while (i2 < zipEntryArr2.length) {
            list.add(new StringBuffer().append("Jar \"").append(jarFile2.getName()).append("\" contains an extra file: \"").append(zipEntryArr2[i2].getName()).append("\"").toString());
            i2++;
        }
    }

    public static void dirsAsTypeSystems(File file, File file2, List list) {
        boolean z = $assertionsDisabled;
        if (!z && !file.isDirectory()) {
            throw new AssertionError("Parameters must be directories");
        }
        if (!z && !file2.isDirectory()) {
            throw new AssertionError("Parameters must be directories");
        }
        File file3 = new File(file, new StringBuffer().append("schema").append(SchemaTypeSystemImpl.METADATA_PACKAGE_GEN).append("/system").toString());
        File file4 = new File(file2, new StringBuffer().append("schema").append(SchemaTypeSystemImpl.METADATA_PACKAGE_GEN).append("/system").toString());
        int i = 0;
        if (file3.exists() && file4.exists()) {
            File[] listFiles = file3.listFiles();
            File[] listFiles2 = file4.listFiles();
            if (listFiles.length == 1 && listFiles2.length == 1) {
                file3 = listFiles[0];
                file4 = listFiles2[0];
            } else {
                if (listFiles.length == 0) {
                    file3 = null;
                }
                if (listFiles2.length == 0) {
                    file4 = null;
                }
                if (listFiles.length > 1) {
                    list.add(new StringBuffer().append("More than one typesystem found in dir \"").append(file.getName()).append("\"").toString());
                    return;
                } else if (listFiles2.length > 1) {
                    list.add(new StringBuffer().append("More than one typesystem found in dir \"").append(file2.getName()).append("\"").toString());
                    return;
                }
            }
        } else {
            if (!file3.exists()) {
                file3 = null;
            }
            if (!file4.exists()) {
                file4 = null;
            }
        }
        if (file3 == null && file4 == null) {
            return;
        }
        if (file3 == null || file4 == null) {
            if (file3 == null) {
                list.add(new StringBuffer().append("No typesystems found in dir \"").append(file).append("\"").toString());
            }
            if (file4 == null) {
                list.add(new StringBuffer().append("No typesystems found in dir \"").append(file2).append("\"").toString());
                return;
            }
            return;
        }
        boolean isDiffIndex = isDiffIndex();
        XsbFilenameFilter xsbFilenameFilter = new XsbFilenameFilter();
        File[] listFiles3 = file3.listFiles(xsbFilenameFilter);
        File[] listFiles4 = file4.listFiles(xsbFilenameFilter);
        FileNameComparator fileNameComparator = new FileNameComparator();
        Arrays.sort(listFiles3, fileNameComparator);
        Arrays.sort(listFiles4, fileNameComparator);
        int i2 = 0;
        while (i < listFiles3.length && i2 < listFiles4.length) {
            String name = listFiles3[i].getName();
            String name2 = listFiles4[i2].getName();
            int compareTo = name.compareTo(name2);
            if (compareTo == 0) {
                if (isDiffIndex || !listFiles3[i].getName().equals("index.xsb")) {
                    filesAsXsb(listFiles3[i], listFiles4[i2], list);
                }
                i++;
            } else if (compareTo < 0) {
                list.add(new StringBuffer().append("Dir \"").append(file3.getName()).append("\" contains an extra file: \"").append(name).append("\"").toString());
                i++;
            } else if (compareTo > 0) {
                list.add(new StringBuffer().append("Dir \"").append(file4.getName()).append("\" contains an extra file: \"").append(name2).append("\"").toString());
            }
            i2++;
        }
        while (i < listFiles3.length) {
            list.add(new StringBuffer().append("Dir \"").append(file3.getName()).append("\" contains an extra file: \"").append(listFiles3[i].getName()).append("\"").toString());
            i++;
        }
        while (i2 < listFiles4.length) {
            list.add(new StringBuffer().append("Dir \"").append(file4.getName()).append("\" contains an extra file: \"").append(listFiles4[i2].getName()).append("\"").toString());
            i2++;
        }
    }

    private static boolean isDiffIndex() {
        String property = SystemProperties.getProperty("xmlbeans.diff.diffIndex");
        if (property == null) {
            return true;
        }
        return (SessionDescription.SUPPORTED_SDP_VERSION.equals(property) || "false".equalsIgnoreCase(property)) ? false : true;
    }

    public static void filesAsXsb(File file, File file2, List list) {
        boolean z = $assertionsDisabled;
        if (!z && !file.exists()) {
            throw new AssertionError(new StringBuffer().append("File \"").append(file.getAbsolutePath()).append("\" does not exist.").toString());
        }
        if (!z && !file2.exists()) {
            throw new AssertionError(new StringBuffer().append("File \"").append(file2.getAbsolutePath()).append("\" does not exist.").toString());
        }
        try {
            streamsAsXsb(new FileInputStream(file), file.getName(), new FileInputStream(file2), file2.getName(), list);
        } catch (FileNotFoundException | IOException unused) {
        }
    }

    public static void zipEntriesAsXsb(ZipEntry zipEntry, JarFile jarFile, ZipEntry zipEntry2, JarFile jarFile2, List list) {
        try {
            streamsAsXsb(jarFile.getInputStream(zipEntry), zipEntry.getName(), jarFile2.getInputStream(zipEntry2), zipEntry2.getName(), list);
        } catch (IOException unused) {
        }
    }

    public static void streamsAsXsb(InputStream inputStream, String str, InputStream inputStream2, String str2, List list) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        XsbDumper.dump(inputStream, "", new PrintStream(byteArrayOutputStream));
        XsbDumper.dump(inputStream2, "", new PrintStream(byteArrayOutputStream2));
        inputStream.close();
        inputStream2.close();
        readersAsText(new StringReader(byteArrayOutputStream.toString()), str, new StringReader(byteArrayOutputStream2.toString()), str2, list);
    }

    public static void readersAsText(Reader reader, String str, Reader reader2, String str2, List list) throws IOException {
        org.apache.xmlbeans.impl.util.Diff.readersAsText(reader, str, reader2, str2, list);
    }

    private static class XsbFilenameFilter implements FilenameFilter {
        private XsbFilenameFilter() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(".xsb");
        }
    }

    private static class ZipEntryNameComparator implements Comparator {
        static final /* synthetic */ boolean $assertionsDisabled;

        @Override // java.util.Comparator
        public boolean equals(Object obj) {
            return this == obj;
        }

        static {
            if (Diff.class$org$apache$xmlbeans$impl$tool$Diff == null) {
                Diff.class$org$apache$xmlbeans$impl$tool$Diff = Diff.class$("org.apache.xmlbeans.impl.tool.Diff");
            } else {
                Class cls = Diff.class$org$apache$xmlbeans$impl$tool$Diff;
            }
            $assertionsDisabled = true;
        }

        private ZipEntryNameComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            boolean z = $assertionsDisabled;
            if (!z && !(obj instanceof ZipEntry)) {
                throw new AssertionError("Must pass in a java.util.zip.ZipEntry as argument");
            }
            if (z || (obj2 instanceof ZipEntry)) {
                return ((ZipEntry) obj).getName().compareTo(((ZipEntry) obj2).getName());
            }
            throw new AssertionError("Must pass in a java.util.zip.ZipEntry as argument");
        }
    }

    private static class FileNameComparator implements Comparator {
        static final /* synthetic */ boolean $assertionsDisabled;

        @Override // java.util.Comparator
        public boolean equals(Object obj) {
            return this == obj;
        }

        static {
            if (Diff.class$org$apache$xmlbeans$impl$tool$Diff == null) {
                Diff.class$org$apache$xmlbeans$impl$tool$Diff = Diff.class$("org.apache.xmlbeans.impl.tool.Diff");
            } else {
                Class cls = Diff.class$org$apache$xmlbeans$impl$tool$Diff;
            }
            $assertionsDisabled = true;
        }

        private FileNameComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            boolean z = $assertionsDisabled;
            if (!z && !(obj instanceof File)) {
                throw new AssertionError("Must pass in a java.io.File as argument");
            }
            if (z || (obj2 instanceof File)) {
                return ((File) obj).getName().compareTo(((File) obj2).getName());
            }
            throw new AssertionError("Must pass in a java.io.File as argument");
        }
    }
}
