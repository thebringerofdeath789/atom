package org.apache.xmlbeans.impl.jam.internal;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.impl.jam.JAnnotation;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.JConstructor;
import org.apache.xmlbeans.impl.jam.JElement;
import org.apache.xmlbeans.impl.jam.JMethod;
import org.apache.xmlbeans.impl.jam.JamClassIterator;

/* loaded from: classes5.dex */
public class JamPrinter {
    private static final String INDENT = "  ";

    public static JamPrinter newInstance() {
        return new JamPrinter();
    }

    private JamPrinter() {
    }

    public void print(JElement jElement, PrintWriter printWriter) {
        print(jElement, 0, printWriter);
    }

    public void print(JamClassIterator jamClassIterator, PrintWriter printWriter) {
        while (jamClassIterator.hasNext()) {
            JClass nextClass = jamClassIterator.nextClass();
            printWriter.println("------------------------------");
            printWriter.println(nextClass.getQualifiedName());
            printWriter.println("------------------------------");
            print(nextClass, printWriter);
            printWriter.println();
        }
    }

    private void print(JElement jElement, int i, PrintWriter printWriter) {
        indent(i, printWriter);
        printWriter.print("[");
        printWriter.print(getTypeKey(jElement));
        printWriter.print("] ");
        if (jElement instanceof JMethod) {
            printWriter.print(((JMethod) jElement).getReturnType().getFieldDescriptor());
            printWriter.print(StringUtils.SPACE);
            printWriter.println(jElement.getSimpleName());
            return;
        }
        printWriter.println(jElement.getSimpleName());
    }

    private void print(JAnnotation[] jAnnotationArr, int i, PrintWriter printWriter) {
        for (int i2 = 0; i2 < jAnnotationArr.length; i2++) {
            indent(i, printWriter);
            printWriter.print("<");
            printWriter.print(getTypeKey(jAnnotationArr[i2]));
            printWriter.print("> ");
            printWriter.print(jAnnotationArr[i2].getSimpleName());
        }
    }

    private void indent(int i, PrintWriter printWriter) {
        for (int i2 = 0; i2 < i; i2++) {
            printWriter.print(INDENT);
        }
    }

    private String getTypeKey(Object obj) {
        int i;
        if (obj == null) {
            return "[?UNKNOWN!]";
        }
        String name = obj.getClass().getName();
        int lastIndexOf = name.lastIndexOf(".");
        return (lastIndexOf == -1 || (i = lastIndexOf + 1) >= name.length()) ? name : name.substring(i);
    }

    private static JElement[] getChildrenFor(JElement jElement) {
        ArrayList arrayList = new ArrayList();
        if (jElement instanceof JClass) {
            JClass jClass = (JClass) jElement;
            arrayList.addAll(Arrays.asList(jClass.getDeclaredFields()));
            arrayList.addAll(Arrays.asList(jClass.getDeclaredMethods()));
            arrayList.addAll(Arrays.asList(jClass.getConstructors()));
            arrayList.addAll(Arrays.asList(jClass.getClasses()));
        } else if (jElement instanceof JConstructor) {
            arrayList.addAll(Arrays.asList(((JConstructor) jElement).getParameters()));
        } else if (jElement instanceof JMethod) {
            arrayList.addAll(Arrays.asList(((JMethod) jElement).getParameters()));
        }
        JElement[] jElementArr = new JElement[arrayList.size()];
        arrayList.toArray(jElementArr);
        return jElementArr;
    }
}
