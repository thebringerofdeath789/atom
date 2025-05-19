package org.apache.xmlbeans.impl.tool;

import aavax.xml.namespace.QName;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;

/* loaded from: classes5.dex */
public class FactorImports {
    public static void printUsage() {
        System.out.println("Refactors a directory of XSD files to remove name conflicts.");
        System.out.println("Usage: sfactor [-import common.xsd] [-out outputdir] inputdir");
        System.out.println("    -import common.xsd - The XSD file to contain redundant ");
        System.out.println("                         definitions for importing.");
        System.out.println("    -out outputdir - The directory into which to place XSD ");
        System.out.println("                     files resulting from refactoring, ");
        System.out.println("                     plus a commonly imported common.xsd.");
        System.out.println("    inputdir - The directory containing the XSD files with");
        System.out.println("               redundant definitions.");
        System.out.println("    -license - Print license information.");
        System.out.println();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(38:40|41|42|43|44|(26:49|50|(1:52)|53|54|55|(3:59|56|57)|60|61|(2:64|62)|65|66|(2:69|67)|70|71|(2:74|72)|75|76|(2:79|77)|80|81|(6:84|85|86|87|88|82)|94|95|96|93)|106|107|108|109|110|111|50|(0)|53|54|55|(2:56|57)|60|61|(1:62)|65|66|(1:67)|70|71|(1:72)|75|76|(1:77)|80|81|(1:82)|94|95|96|93|38) */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0204, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0209, code lost:
    
        r23 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0206, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0207, code lost:
    
        r22 = r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0172 A[Catch: IOException -> 0x0200, XmlException -> 0x0202, LOOP:2: B:56:0x016f->B:59:0x0172, LOOP_END, TryCatch #0 {XmlException -> 0x0202, blocks: (B:57:0x016f, B:59:0x0172, B:61:0x017e, B:62:0x0187, B:64:0x018a, B:66:0x0196, B:67:0x019f, B:69:0x01a2, B:71:0x01ae, B:72:0x01b7, B:74:0x01ba, B:76:0x01c6, B:77:0x01cf, B:79:0x01d2, B:81:0x01de, B:82:0x01e7, B:84:0x01ea), top: B:56:0x016f }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x018a A[Catch: IOException -> 0x0200, XmlException -> 0x0202, LOOP:3: B:62:0x0187->B:64:0x018a, LOOP_END, TryCatch #0 {XmlException -> 0x0202, blocks: (B:57:0x016f, B:59:0x0172, B:61:0x017e, B:62:0x0187, B:64:0x018a, B:66:0x0196, B:67:0x019f, B:69:0x01a2, B:71:0x01ae, B:72:0x01b7, B:74:0x01ba, B:76:0x01c6, B:77:0x01cf, B:79:0x01d2, B:81:0x01de, B:82:0x01e7, B:84:0x01ea), top: B:56:0x016f }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01a2 A[Catch: IOException -> 0x0200, XmlException -> 0x0202, LOOP:4: B:67:0x019f->B:69:0x01a2, LOOP_END, TryCatch #0 {XmlException -> 0x0202, blocks: (B:57:0x016f, B:59:0x0172, B:61:0x017e, B:62:0x0187, B:64:0x018a, B:66:0x0196, B:67:0x019f, B:69:0x01a2, B:71:0x01ae, B:72:0x01b7, B:74:0x01ba, B:76:0x01c6, B:77:0x01cf, B:79:0x01d2, B:81:0x01de, B:82:0x01e7, B:84:0x01ea), top: B:56:0x016f }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01ba A[Catch: IOException -> 0x0200, XmlException -> 0x0202, LOOP:5: B:72:0x01b7->B:74:0x01ba, LOOP_END, TryCatch #0 {XmlException -> 0x0202, blocks: (B:57:0x016f, B:59:0x0172, B:61:0x017e, B:62:0x0187, B:64:0x018a, B:66:0x0196, B:67:0x019f, B:69:0x01a2, B:71:0x01ae, B:72:0x01b7, B:74:0x01ba, B:76:0x01c6, B:77:0x01cf, B:79:0x01d2, B:81:0x01de, B:82:0x01e7, B:84:0x01ea), top: B:56:0x016f }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01d2 A[Catch: IOException -> 0x0200, XmlException -> 0x0202, LOOP:6: B:77:0x01cf->B:79:0x01d2, LOOP_END, TryCatch #0 {XmlException -> 0x0202, blocks: (B:57:0x016f, B:59:0x0172, B:61:0x017e, B:62:0x0187, B:64:0x018a, B:66:0x0196, B:67:0x019f, B:69:0x01a2, B:71:0x01ae, B:72:0x01b7, B:74:0x01ba, B:76:0x01c6, B:77:0x01cf, B:79:0x01d2, B:81:0x01de, B:82:0x01e7, B:84:0x01ea), top: B:56:0x016f }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01ea A[Catch: IOException -> 0x0200, XmlException -> 0x0202, TRY_LEAVE, TryCatch #0 {XmlException -> 0x0202, blocks: (B:57:0x016f, B:59:0x0172, B:61:0x017e, B:62:0x0187, B:64:0x018a, B:66:0x0196, B:67:0x019f, B:69:0x01a2, B:71:0x01ae, B:72:0x01b7, B:74:0x01ba, B:76:0x01c6, B:77:0x01cf, B:79:0x01d2, B:81:0x01de, B:82:0x01e7, B:84:0x01ea), top: B:56:0x016f }] */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v32, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.util.Map] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void main(java.lang.String[] r26) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 1508
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.tool.FactorImports.main(java.lang.String[]):void");
    }

    private static File outputFileFor(File file, File file2, File file3) {
        URI relativize = file2.getAbsoluteFile().toURI().relativize(file.getAbsoluteFile().toURI());
        if (relativize.isAbsolute()) {
            System.out.println(new StringBuffer().append("Cannot relativize ").append(file).toString());
            return null;
        }
        return new File(CodeGenUtil.resolve(file3.toURI(), relativize));
    }

    private static URI commonAncestor(URI uri, URI uri2) {
        String uri3 = uri.toString();
        String uri4 = uri2.toString();
        int length = uri3.length();
        if (uri4.length() < length) {
            length = uri4.length();
        }
        int i = 0;
        while (i < length && uri3.charAt(i) == uri4.charAt(i)) {
            i++;
        }
        int i2 = i - 1;
        if (i2 >= 0) {
            i2 = uri3.lastIndexOf(47, i2);
        }
        if (i2 < 0) {
            return null;
        }
        try {
            return new URI(uri3.substring(0, i2));
        } catch (URISyntaxException unused) {
            return null;
        }
    }

    private static String relativeURIFor(File file, File file2) {
        int indexOf;
        URI uri = file.getAbsoluteFile().toURI();
        URI uri2 = file2.getAbsoluteFile().toURI();
        URI commonAncestor = commonAncestor(uri, uri2);
        if (commonAncestor == null) {
            return uri2.toString();
        }
        URI relativize = commonAncestor.relativize(uri);
        URI relativize2 = commonAncestor.relativize(uri2);
        if (relativize.isAbsolute() || relativize2.isAbsolute()) {
            return uri2.toString();
        }
        String uri3 = relativize.toString();
        int i = 0;
        String str = "";
        while (i < uri3.length() && (indexOf = uri3.indexOf(47, i)) >= 0) {
            str = new StringBuffer().append(str).append("../").toString();
            i = indexOf + 1;
        }
        return new StringBuffer().append(str).append(relativize2.toString()).toString();
    }

    private static File commonFileFor(String str, String str2, int i, File file) {
        if (i > 0) {
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf < 0) {
                lastIndexOf = str.length();
            }
            str = new StringBuffer().append(str.substring(0, lastIndexOf)).append(i).append(str.substring(lastIndexOf)).toString();
        }
        return new File(file, str);
    }

    private static void noteName(String str, String str2, Set set, Set set2, Set set3) {
        if (str == null) {
            return;
        }
        QName qName = new QName(str2, str);
        if (set.contains(qName)) {
            set2.add(qName);
            set3.add(str2);
        } else {
            set.add(qName);
        }
    }

    private static boolean isFirstDuplicate(String str, String str2, Set set, Set set2) {
        if (str == null) {
            return false;
        }
        QName qName = new QName(str2, str);
        if (!set2.contains(qName) || !set.contains(qName)) {
            return false;
        }
        set.remove(qName);
        return true;
    }

    private static boolean isDuplicate(String str, String str2, Set set) {
        if (str == null) {
            return false;
        }
        return set.contains(new QName(str2, str));
    }
}
