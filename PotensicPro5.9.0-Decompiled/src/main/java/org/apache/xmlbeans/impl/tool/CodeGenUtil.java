package org.apache.xmlbeans.impl.tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.lookup.StringLookupFactory;
import org.apache.xmlbeans.SystemProperties;
import org.apache.xmlbeans.XmlOptions;

/* loaded from: classes5.dex */
public class CodeGenUtil {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static String DEFAULT_COMPILER;
    public static String DEFAULT_JAR;
    public static String DEFAULT_MEM_MAX;
    public static String DEFAULT_MEM_START;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$tool$CodeGenUtil;

    static {
        if (class$org$apache$xmlbeans$impl$tool$CodeGenUtil == null) {
            class$org$apache$xmlbeans$impl$tool$CodeGenUtil = class$("org.apache.xmlbeans.impl.tool.CodeGenUtil");
        }
        $assertionsDisabled = true;
        DEFAULT_MEM_START = "8m";
        DEFAULT_MEM_MAX = "256m";
        DEFAULT_COMPILER = "javac";
        DEFAULT_JAR = "jar";
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static URI resolve(URI uri, URI uri2) {
        URI resolve = uri.resolve(uri2);
        if (!StringLookupFactory.KEY_FILE.equals(resolve.getScheme()) || uri2.equals(resolve) || !uri.getPath().startsWith("//") || resolve.getPath().startsWith("//")) {
            return resolve;
        }
        try {
            return new URI(StringLookupFactory.KEY_FILE, null, "///".concat(resolve.getPath()), resolve.getQuery(), resolve.getFragment());
        } catch (URISyntaxException unused) {
            return resolve;
        }
    }

    static void addAllJavaFiles(List list, List list2) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            if (!file.isDirectory()) {
                list2.add(quoteAndEscapeFilename(file.getAbsolutePath()));
            } else {
                addAllJavaFiles(Arrays.asList(file.listFiles(new FileFilter() { // from class: org.apache.xmlbeans.impl.tool.CodeGenUtil.1
                    @Override // java.io.FileFilter
                    public boolean accept(File file2) {
                        return (file2.isFile() && file2.getName().endsWith(".java")) || file2.isDirectory();
                    }
                })), list2);
            }
        }
    }

    private static String quoteAndEscapeFilename(String str) {
        return str.indexOf(StringUtils.SPACE) < 0 ? str : new StringBuffer().append("\"").append(str.replaceAll("\\\\", "\\\\\\\\")).append("\"").toString();
    }

    private static String quoteNoEscapeFilename(String str) {
        return (str.indexOf(StringUtils.SPACE) < 0 || File.separatorChar == '/') ? str : new StringBuffer().append("\"").append(str).append("\"").toString();
    }

    public static boolean externalCompile(List list, File file, File[] fileArr, boolean z) {
        return externalCompile(list, file, fileArr, z, DEFAULT_COMPILER, null, DEFAULT_MEM_START, DEFAULT_MEM_MAX, false, false);
    }

    public static boolean externalCompile(List list, File file, File[] fileArr, boolean z, String str, String str2, String str3, boolean z2, boolean z3) {
        return externalCompile(list, file, fileArr, z, str, null, str2, str3, z2, z3);
    }

    public static boolean externalCompile(List list, File file, File[] fileArr, boolean z, String str, String str2, String str3, String str4, boolean z2, boolean z3) {
        ArrayList arrayList = new ArrayList();
        if (str == null) {
            str = DEFAULT_COMPILER;
        }
        File findJavaTool = findJavaTool(str);
        if (!$assertionsDisabled && !findJavaTool.exists()) {
            throw new AssertionError(new StringBuffer().append("compiler not found ").append(findJavaTool).toString());
        }
        arrayList.add(findJavaTool.getAbsolutePath());
        if (file == null) {
            file = new File(".");
        } else {
            arrayList.add("-d");
            arrayList.add(quoteAndEscapeFilename(file.getAbsolutePath()));
        }
        if (fileArr == null) {
            fileArr = systemClasspath();
        }
        if (fileArr.length > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(file.getAbsolutePath());
            for (File file2 : fileArr) {
                stringBuffer.append(File.pathSeparator);
                stringBuffer.append(file2.getAbsolutePath());
            }
            arrayList.add("-classpath");
            arrayList.add(quoteAndEscapeFilename(stringBuffer.toString()));
        }
        if (str2 == null) {
            str2 = XmlOptions.GENERATE_JAVA_14;
        }
        arrayList.add("-source");
        arrayList.add(str2);
        arrayList.add("-target");
        arrayList.add(str2);
        arrayList.add(z ? "-g" : "-g:none");
        if (z3) {
            arrayList.add("-verbose");
        }
        addAllJavaFiles(list, arrayList);
        File file3 = null;
        try {
            file3 = File.createTempFile("javac", "");
            FileWriter fileWriter = new FileWriter(file3);
            Iterator it = arrayList.iterator();
            it.next();
            while (it.hasNext()) {
                fileWriter.write((String) it.next());
                fileWriter.write(10);
            }
            fileWriter.close();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(arrayList.get(0));
            if (str3 != null && str3.length() != 0) {
                arrayList2.add(new StringBuffer().append("-J-Xms").append(str3).toString());
            }
            if (str4 != null && str4.length() != 0) {
                arrayList2.add(new StringBuffer().append("-J-Xmx").append(str4).toString());
            }
            arrayList2.add(new StringBuffer().append("@").append(file3.getAbsolutePath()).toString());
            arrayList = arrayList2;
        } catch (Exception unused) {
            System.err.println("Could not create command-line file for javac");
        }
        try {
            String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            if (z3) {
                System.out.print("compile command:");
                for (String str5 : strArr) {
                    System.out.print(new StringBuffer().append(StringUtils.SPACE).append(str5).toString());
                }
                System.out.println();
            }
            Process exec = Runtime.getRuntime().exec(strArr);
            StringBuffer stringBuffer2 = new StringBuffer();
            StringBuffer stringBuffer3 = new StringBuffer();
            new ThreadedReader(exec.getInputStream(), stringBuffer3);
            new ThreadedReader(exec.getErrorStream(), stringBuffer2);
            exec.waitFor();
            if (z3 || exec.exitValue() != 0) {
                if (stringBuffer3.length() > 0) {
                    System.out.println(stringBuffer3.toString());
                    System.out.flush();
                }
                if (stringBuffer2.length() > 0) {
                    System.err.println(stringBuffer2.toString());
                    System.err.flush();
                }
                if (exec.exitValue() != 0) {
                    return false;
                }
            }
            if (file3 == null) {
                return true;
            }
            file3.delete();
            return true;
        } catch (Throwable th) {
            System.err.println(th.toString());
            System.err.println(th.getCause());
            th.printStackTrace(System.err);
            return false;
        }
    }

    public static File[] systemClasspath() {
        ArrayList arrayList = new ArrayList();
        for (String str : SystemProperties.getProperty("java.class.path").split(File.pathSeparator)) {
            arrayList.add(new File(str));
        }
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }

    public static boolean externalJar(File file, File file2) {
        return externalJar(file, file2, DEFAULT_JAR, false, false);
    }

    public static boolean externalJar(File file, File file2, String str, boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        if (str == null) {
            str = DEFAULT_JAR;
        }
        File findJavaTool = findJavaTool(str);
        if (!$assertionsDisabled && !findJavaTool.exists()) {
            throw new AssertionError(new StringBuffer().append("jar not found ").append(findJavaTool).toString());
        }
        arrayList.add(findJavaTool.getAbsolutePath());
        arrayList.add("cf");
        arrayList.add(quoteNoEscapeFilename(file2.getAbsolutePath()));
        arrayList.add("-C");
        arrayList.add(quoteNoEscapeFilename(file.getAbsolutePath()));
        arrayList.add(".");
        try {
            String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            if (z2) {
                System.out.print("jar command:");
                for (String str2 : strArr) {
                    System.out.print(new StringBuffer().append(StringUtils.SPACE).append(str2).toString());
                }
                System.out.println();
            }
            Process exec = Runtime.getRuntime().exec(strArr);
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            new ThreadedReader(exec.getInputStream(), stringBuffer2);
            new ThreadedReader(exec.getErrorStream(), stringBuffer);
            exec.waitFor();
            if (!z2 && exec.exitValue() == 0) {
                return true;
            }
            if (stringBuffer2.length() > 0) {
                System.out.println(stringBuffer2.toString());
                System.out.flush();
            }
            if (stringBuffer.length() > 0) {
                System.err.println(stringBuffer.toString());
                System.err.flush();
            }
            return exec.exitValue() == 0;
        } catch (Throwable th) {
            th.printStackTrace(System.err);
            return false;
        }
    }

    private static File findJavaTool(String str) {
        File file = new File(str);
        if (file.isFile()) {
            return file;
        }
        File file2 = new File(new StringBuffer().append(str).append(".exe").toString());
        if (file2.isFile()) {
            return file2;
        }
        String property = SystemProperties.getProperty("java.home");
        String str2 = File.separator;
        File file3 = new File(new StringBuffer().append(property).append(str2).append("..").append(str2).append("bin").toString(), str);
        if (file3.isFile()) {
            return file3;
        }
        File file4 = new File(new StringBuffer().append(file3.getPath()).append(".exe").toString());
        if (file4.isFile()) {
            return file4;
        }
        File file5 = new File(new StringBuffer().append(property).append(str2).append("bin").toString(), str);
        if (file5.isFile()) {
            return file5;
        }
        File file6 = new File(new StringBuffer().append(file5.getPath()).append(".exe").toString());
        return file6.isFile() ? file6 : file;
    }

    private static class ThreadedReader {
        public ThreadedReader(InputStream inputStream, final StringBuffer stringBuffer) {
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            new Thread(new Runnable() { // from class: org.apache.xmlbeans.impl.tool.CodeGenUtil.ThreadedReader.1
                @Override // java.lang.Runnable
                public void run() {
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                return;
                            } else {
                                stringBuffer.append(new StringBuffer().append(readLine).append("\n").toString());
                            }
                        } catch (Exception unused) {
                            return;
                        }
                    }
                }
            }).start();
        }
    }
}
