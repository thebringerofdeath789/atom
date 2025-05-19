package org.apache.xmlbeans.impl.jam.internal.javadoc;

import com.sun.javadoc.Doclet;
import com.sun.javadoc.RootDoc;
import com.sun.tools.javadoc.Main;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.xmlbeans.impl.jam.provider.JamLogger;

/* loaded from: classes5.dex */
public class JavadocRunner extends Doclet {
    private static final String JAVADOC_RUNNER_150 = "org.apache.xmlbeans.impl.jam.internal.javadoc.JavadocRunner_150";

    public static JavadocRunner newInstance() {
        try {
            Class.forName("com.sun.javadoc.AnnotationDesc");
            try {
                return (JavadocRunner) Class.forName(JAVADOC_RUNNER_150).newInstance();
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
                return new JavadocRunner();
            }
        } catch (ClassNotFoundException unused2) {
            return new JavadocRunner();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v2, types: [int] */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.lang.ClassLoader] */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.lang.ClassLoader] */
    /* JADX WARN: Type inference failed for: r8v14, types: [java.lang.Thread] */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.lang.Thread] */
    synchronized RootDoc run(File[] fileArr, PrintWriter printWriter, String str, String str2, String[] strArr, JamLogger jamLogger) throws IOException, FileNotFoundException {
        ?? length;
        RootDoc root;
        if (fileArr != null) {
            if (fileArr.length != 0) {
                ArrayList arrayList = new ArrayList();
                if (strArr != null) {
                    arrayList.addAll(Arrays.asList(strArr));
                }
                arrayList.add("-private");
                if (str != null) {
                    arrayList.add("-sourcepath");
                    arrayList.add(str);
                }
                if (str2 != null) {
                    arrayList.add("-classpath");
                    arrayList.add(str2);
                    arrayList.add("-docletpath");
                    arrayList.add(str2);
                }
                int i = 0;
                while (true) {
                    length = fileArr.length;
                    if (i >= length) {
                        break;
                    }
                    arrayList.add(fileArr[i].toString());
                    if (printWriter != null) {
                        printWriter.println(fileArr[i].toString());
                    }
                    i++;
                }
                int size = arrayList.size();
                String[] strArr2 = new String[size];
                arrayList.toArray(strArr2);
                StringWriter stringWriter = null;
                if (printWriter == null) {
                    stringWriter = new StringWriter();
                    printWriter = new PrintWriter(stringWriter);
                }
                try {
                    length = Thread.currentThread().getContextClassLoader();
                    try {
                        JavadocResults.prepare();
                        if (jamLogger.isVerbose(this)) {
                            jamLogger.verbose("Invoking javadoc.  Command line equivalent is: ");
                            StringWriter stringWriter2 = new StringWriter();
                            stringWriter2.write("javadoc ");
                            for (int i2 = 0; i2 < size; i2++) {
                                stringWriter2.write("'");
                                stringWriter2.write(strArr2[i2]);
                                stringWriter2.write("' ");
                            }
                            jamLogger.verbose(new StringBuffer().append("  ").append(stringWriter2.toString()).toString());
                        }
                        int execute = Main.execute("JAM", printWriter, printWriter, printWriter, getClass().getName(), strArr2);
                        root = JavadocResults.getRoot();
                        if (execute != 0 || root == null) {
                            printWriter.flush();
                            if (JavadocClassloadingException.isClassloadingProblemPresent()) {
                                throw new JavadocClassloadingException();
                            }
                            throw new RuntimeException(new StringBuffer().append("Unknown javadoc problem: result=").append(execute).append(", root=").append(root).append(":\n").append(stringWriter == null ? "" : stringWriter.toString()).toString());
                        }
                    } catch (RuntimeException e) {
                        throw e;
                    }
                } finally {
                    Thread.currentThread().setContextClassLoader(length);
                }
            }
        }
        throw new FileNotFoundException("No input files found.");
        return root;
    }

    public static boolean start(RootDoc rootDoc) {
        JavadocResults.setRoot(rootDoc);
        return true;
    }
}
