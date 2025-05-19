package org.apache.poi.xssf.dev;

import java.util.zip.ZipFile;

/* loaded from: classes5.dex */
public final class XSSFDump {
    public static void main(String[] strArr) throws Exception {
        for (int i = 0; i < strArr.length; i++) {
            System.out.println("Dumping " + strArr[i]);
            ZipFile zipFile = new ZipFile(strArr[i]);
            try {
                dump(zipFile);
                zipFile.close();
            } catch (Throwable th) {
                zipFile.close();
                throw th;
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:8|9|(3:16|17|18)|19|20|22|18) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a7, code lost:
    
        java.lang.System.err.println("Failed to parse " + r1.getName() + ", dumping raw content");
        org.apache.poi.util.IOUtils.copy(r8.getInputStream(r1), r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void dump(java.util.zip.ZipFile r8) throws java.lang.Exception {
        /*
            java.lang.String r0 = r8.getName()
            r1 = 46
            int r1 = r0.lastIndexOf(r1)
            java.io.File r2 = new java.io.File
            r3 = 0
            java.lang.String r0 = r0.substring(r3, r1)
            r2.<init>(r0)
            r2.mkdir()
            java.io.PrintStream r0 = java.lang.System.out
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "Dupming to directory "
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.println(r1)
            java.util.Enumeration r0 = r8.entries()
        L33:
            boolean r1 = r0.hasMoreElements()
            if (r1 == 0) goto Lda
            java.lang.Object r1 = r0.nextElement()
            java.util.zip.ZipEntry r1 = (java.util.zip.ZipEntry) r1
            java.lang.String r4 = r1.getName()
            r5 = 47
            int r5 = r4.lastIndexOf(r5)
            r6 = -1
            if (r5 == r6) goto L58
            java.io.File r6 = new java.io.File
            java.lang.String r4 = r4.substring(r3, r5)
            r6.<init>(r2, r4)
            r6.mkdirs()
        L58:
            java.io.File r4 = new java.io.File
            java.lang.String r5 = r1.getName()
            r4.<init>(r2, r5)
            java.io.FileOutputStream r5 = new java.io.FileOutputStream
            r5.<init>(r4)
            java.lang.String r4 = r1.getName()     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r6 = ".xml"
            boolean r4 = r4.endsWith(r6)     // Catch: java.lang.Throwable -> Ld5
            if (r4 != 0) goto L93
            java.lang.String r4 = r1.getName()     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r6 = ".vml"
            boolean r4 = r4.endsWith(r6)     // Catch: java.lang.Throwable -> Ld5
            if (r4 != 0) goto L93
            java.lang.String r4 = r1.getName()     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r6 = ".rels"
            boolean r4 = r4.endsWith(r6)     // Catch: java.lang.Throwable -> Ld5
            if (r4 == 0) goto L8b
            goto L93
        L8b:
            java.io.InputStream r1 = r8.getInputStream(r1)     // Catch: java.lang.Throwable -> Ld5
            org.apache.poi.util.IOUtils.copy(r1, r5)     // Catch: java.lang.Throwable -> Ld5
            goto Ld0
        L93:
            java.io.InputStream r4 = r8.getInputStream(r1)     // Catch: java.lang.Exception -> La7 java.lang.Throwable -> Ld5
            org.apache.xmlbeans.XmlObject r4 = org.apache.xmlbeans.XmlObject.Factory.parse(r4)     // Catch: java.lang.Exception -> La7 java.lang.Throwable -> Ld5
            org.apache.xmlbeans.XmlOptions r6 = new org.apache.xmlbeans.XmlOptions     // Catch: java.lang.Exception -> La7 java.lang.Throwable -> Ld5
            r6.<init>()     // Catch: java.lang.Exception -> La7 java.lang.Throwable -> Ld5
            r6.setSavePrettyPrint()     // Catch: java.lang.Exception -> La7 java.lang.Throwable -> Ld5
            r4.save(r5, r6)     // Catch: java.lang.Exception -> La7 java.lang.Throwable -> Ld5
            goto Ld0
        La7:
            java.io.PrintStream r4 = java.lang.System.err     // Catch: java.lang.Throwable -> Ld5
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld5
            r6.<init>()     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r7 = "Failed to parse "
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r7 = r1.getName()     // Catch: java.lang.Throwable -> Ld5
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r7 = ", dumping raw content"
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> Ld5
            r4.println(r6)     // Catch: java.lang.Throwable -> Ld5
            java.io.InputStream r1 = r8.getInputStream(r1)     // Catch: java.lang.Throwable -> Ld5
            org.apache.poi.util.IOUtils.copy(r1, r5)     // Catch: java.lang.Throwable -> Ld5
        Ld0:
            r5.close()
            goto L33
        Ld5:
            r8 = move-exception
            r5.close()
            throw r8
        Lda:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.xssf.dev.XSSFDump.dump(java.util.zip.ZipFile):void");
    }
}
