package org.apache.xmlbeans.xml.stream.utils;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes5.dex */
public interface NestedThrowable {
    Throwable getNested();

    void superPrintStackTrace(PrintStream printStream);

    void superPrintStackTrace(PrintWriter printWriter);

    String superToString();

    public static class Util {
        private static String EOL = System.getProperty("line.separator");

        public static String toString(NestedThrowable nestedThrowable) {
            Throwable nested = nestedThrowable.getNested();
            if (nested == null) {
                return nestedThrowable.superToString();
            }
            return new StringBuffer().append(nestedThrowable.superToString()).append(" - with nested exception:").append(EOL).append("[").append(nestedToString(nested)).append("]").toString();
        }

        private static String nestedToString(Throwable th) {
            if (th instanceof InvocationTargetException) {
                return new StringBuffer().append(th.toString()).append(" - with target exception:").append(EOL).append("[").append(((InvocationTargetException) th).getTargetException().toString()).append("]").toString();
            }
            return th.toString();
        }

        public static void printStackTrace(NestedThrowable nestedThrowable, PrintStream printStream) {
            Throwable nested = nestedThrowable.getNested();
            if (nested != null) {
                nested.printStackTrace(printStream);
                printStream.println("--------------- nested within: ------------------");
            }
            nestedThrowable.superPrintStackTrace(printStream);
        }

        public static void printStackTrace(NestedThrowable nestedThrowable, PrintWriter printWriter) {
            Throwable nested = nestedThrowable.getNested();
            if (nested != null) {
                nested.printStackTrace(printWriter);
                printWriter.println("--------------- nested within: ------------------");
            }
            nestedThrowable.superPrintStackTrace(printWriter);
        }
    }
}
