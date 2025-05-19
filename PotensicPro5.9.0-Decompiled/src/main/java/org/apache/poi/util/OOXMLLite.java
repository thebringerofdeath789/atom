package org.apache.poi.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Pattern;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

/* loaded from: classes5.dex */
public final class OOXMLLite {
    private static Field _classes;
    private File _destDest;
    private File _ooxmlJar;
    private File _testDir;

    OOXMLLite(String str, String str2, String str3) {
        this._destDest = new File(str);
        this._testDir = new File(str2);
        this._ooxmlJar = new File(str3);
    }

    public static void main(String[] strArr) throws IOException, ClassNotFoundException {
        String str = null;
        String str2 = null;
        int i = 0;
        String str3 = null;
        while (i < strArr.length) {
            if (strArr[i].equals("-dest")) {
                i++;
                str = strArr[i];
            } else if (strArr[i].equals("-test")) {
                i++;
                str3 = strArr[i];
            } else if (strArr[i].equals("-ooxml")) {
                i++;
                str2 = strArr[i];
            }
            i++;
        }
        new OOXMLLite(str, str3, str2).build();
    }

    void build() throws IOException, ClassNotFoundException {
        ArrayList arrayList = new ArrayList();
        System.out.println("Collecting unit tests from " + this._testDir);
        File file = this._testDir;
        collectTests(file, file, arrayList, ".+.class$", ".+(BaseTestXCell|TestUnfixedBugs|MemoryUsage|TestDataProvider|TestDataSamples|All.+Tests|ZipFileAssert|PkiTestUtils|TestCellFormatPart\\$\\d|TestSignatureInfo\\$\\d).class");
        System.out.println("Found " + arrayList.size() + " classes");
        JUnitCore jUnitCore = new JUnitCore();
        jUnitCore.addListener(new TextListener(System.out));
        if (!jUnitCore.run((Class[]) arrayList.toArray(new Class[arrayList.size()])).wasSuccessful()) {
            throw new RuntimeException("Tests did not succeed, cannot build ooxml-lite jar");
        }
        System.out.println("Copying classes to " + this._destDest);
        for (Class<?> cls : getLoadedClasses(this._ooxmlJar.getName()).values()) {
            String str = cls.getName().replace('.', '/') + ".class";
            copyFile(cls.getResourceAsStream('/' + str), new File(this._destDest, str));
            if (cls.isInterface()) {
                for (Class<?> cls2 : cls.getDeclaredClasses()) {
                    String str2 = cls2.getName().replace('.', '/') + ".class";
                    copyFile(cls2.getResourceAsStream('/' + str2), new File(this._destDest, str2));
                }
            }
        }
        System.out.println("Copying .xsb resources");
        JarFile jarFile = new JarFile(this._ooxmlJar);
        Pattern compile = Pattern.compile("schemaorg_apache_xmlbeans/(system|element)/.*\\.xsb");
        try {
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry nextElement = entries.nextElement();
                if (compile.matcher(nextElement.getName()).matches()) {
                    copyFile(jarFile.getInputStream(nextElement), new File(this._destDest, nextElement.getName()));
                }
            }
        } finally {
            jarFile.close();
        }
    }

    private static boolean checkForTestAnnotation(Class<?> cls) {
        for (Method method : cls.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                return true;
            }
        }
        System.out.println("Class " + cls.getName() + " does not derive from TestCase and does not have a @Test annotation");
        return false;
    }

    private static void collectTests(File file, File file2, List<Class<?>> list, String str, String str2) throws ClassNotFoundException {
        if (file2.isDirectory()) {
            for (File file3 : file2.listFiles()) {
                collectTests(file, file3, list, str, str2);
            }
            return;
        }
        String replace = file2.getAbsolutePath().substring(file.getAbsolutePath().length() + 1).replace(File.separator, ".");
        if (replace.matches(str) && !replace.matches(str2)) {
            if (replace.indexOf(36) != -1) {
                System.out.println("Inner class " + replace + " not included");
                return;
            }
            Class<?> cls = Class.forName(replace.replace(".class", ""));
            if (TestCase.class.isAssignableFrom(cls) || checkForTestAnnotation(cls)) {
                list.add(cls);
            }
        }
    }

    private static Map<String, Class<?>> getLoadedClasses(String str) {
        try {
            Field declaredField = ClassLoader.class.getDeclaredField("classes");
            _classes = declaredField;
            declaredField.setAccessible(true);
            try {
                Vector vector = (Vector) _classes.get(ClassLoader.getSystemClassLoader());
                HashMap hashMap = new HashMap();
                Iterator it = vector.iterator();
                while (it.hasNext()) {
                    Class cls = (Class) it.next();
                    if (cls.getProtectionDomain() != null && cls.getProtectionDomain().getCodeSource() != null && cls.getProtectionDomain().getCodeSource().getLocation().toString().indexOf(str) != -1) {
                        hashMap.put(cls.getName(), cls);
                    }
                }
                return hashMap;
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    private static void copyFile(InputStream inputStream, File file) throws IOException {
        file.getParentFile().mkdirs();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            IOUtils.copy(inputStream, fileOutputStream);
        } finally {
            fileOutputStream.close();
        }
    }
}
