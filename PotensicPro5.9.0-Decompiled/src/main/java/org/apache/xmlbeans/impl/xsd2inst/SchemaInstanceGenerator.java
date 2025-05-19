package org.apache.xmlbeans.impl.xsd2inst;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashSet;
import javax.xml.transform.OutputKeys;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.tool.CommandLine;

/* loaded from: classes5.dex */
public class SchemaInstanceGenerator {

    public static class Xsd2InstOptions {
        private boolean _downloads = false;
        private boolean _nopvr = false;
        private boolean _noupa = false;

        public boolean isNetworkDownloads() {
            return this._downloads;
        }

        public void setNetworkDownloads(boolean z) {
            this._downloads = z;
        }

        public boolean isNopvr() {
            return this._nopvr;
        }

        public void setNopvr(boolean z) {
            this._nopvr = z;
        }

        public boolean isNoupa() {
            return this._noupa;
        }

        public void setNoupa(boolean z) {
            this._noupa = z;
        }
    }

    public static void printUsage() {
        System.out.println("Generates a document based on the given Schema file");
        System.out.println("having the given element as root.");
        System.out.println("The tool makes reasonable attempts to create a valid document,");
        System.out.println("but this is not always possible since, for example, ");
        System.out.println("there are schemas for which no valid instance document ");
        System.out.println("can be produced.");
        System.out.println("Usage: xsd2inst [flags] schema.xsd -name element_name");
        System.out.println("Flags:");
        System.out.println("    -name    the name of the root element");
        System.out.println("    -dl      enable network downloads for imports and includes");
        System.out.println("    -nopvr   disable particle valid (restriction) rule");
        System.out.println("    -noupa   disable unique particle attribution rule");
        System.out.println("    -license prints license information");
        System.out.println("    -version prints version information");
    }

    public static void main(String[] strArr) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        hashSet.add("h");
        hashSet.add("help");
        hashSet.add("usage");
        hashSet.add("license");
        hashSet.add(OutputKeys.VERSION);
        hashSet.add("dl");
        hashSet.add("noupa");
        hashSet.add("nopvr");
        hashSet.add("partial");
        hashSet2.add("name");
        CommandLine commandLine = new CommandLine(strArr, hashSet, hashSet2);
        if (commandLine.getOpt("h") != null || commandLine.getOpt("help") != null || commandLine.getOpt("usage") != null) {
            printUsage();
            return;
        }
        String[] badOpts = commandLine.getBadOpts();
        int i = 0;
        if (badOpts.length > 0) {
            while (i < badOpts.length) {
                System.out.println(new StringBuffer().append("Unrecognized option: ").append(badOpts[i]).toString());
                i++;
            }
            printUsage();
            return;
        }
        if (commandLine.getOpt("license") != null) {
            CommandLine.printLicense();
            System.exit(0);
            return;
        }
        if (commandLine.getOpt(OutputKeys.VERSION) != null) {
            CommandLine.printVersion();
            System.exit(0);
            return;
        }
        boolean z = commandLine.getOpt("dl") != null;
        boolean z2 = commandLine.getOpt("nopvr") != null;
        boolean z3 = commandLine.getOpt("noupa") != null;
        File[] filesEndingWith = commandLine.filesEndingWith(".xsd");
        String opt = commandLine.getOpt("name");
        if (opt == null) {
            System.out.println("Required option \"-name\" must be present");
            return;
        }
        ArrayList arrayList = new ArrayList();
        while (i < filesEndingWith.length) {
            try {
                arrayList.add(XmlObject.Factory.parse(filesEndingWith[i], new XmlOptions().setLoadLineNumbers().setLoadMessageDigest()));
            } catch (Exception e) {
                System.err.println(new StringBuffer().append("Can not load schema file: ").append(filesEndingWith[i]).append(": ").toString());
                e.printStackTrace();
            }
            i++;
        }
        XmlObject[] xmlObjectArr = (XmlObject[]) arrayList.toArray(new XmlObject[arrayList.size()]);
        Xsd2InstOptions xsd2InstOptions = new Xsd2InstOptions();
        xsd2InstOptions.setNetworkDownloads(z);
        xsd2InstOptions.setNopvr(z2);
        xsd2InstOptions.setNoupa(z3);
        System.out.println(xsd2inst(xmlObjectArr, opt, xsd2InstOptions));
    }

    public static String xsd2inst(String[] strArr, String str, Xsd2InstOptions xsd2InstOptions) throws XmlException, IOException {
        Reader[] readerArr = new Reader[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            readerArr[i] = new StringReader(strArr[i]);
        }
        return xsd2inst(readerArr, str, xsd2InstOptions);
    }

    public static String xsd2inst(Reader[] readerArr, String str, Xsd2InstOptions xsd2InstOptions) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readerArr.length; i++) {
            try {
                arrayList.add(XmlObject.Factory.parse(readerArr[i], new XmlOptions().setLoadLineNumbers().setLoadMessageDigest()));
            } catch (Exception e) {
                System.err.println(new StringBuffer().append("Can not load schema reader: ").append(i).append("  ").append(readerArr[i]).append(": ").toString());
                e.printStackTrace();
            }
        }
        return xsd2inst((XmlObject[]) arrayList.toArray(new XmlObject[arrayList.size()]), str, xsd2InstOptions);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String xsd2inst(org.apache.xmlbeans.XmlObject[] r4, java.lang.String r5, org.apache.xmlbeans.impl.xsd2inst.SchemaInstanceGenerator.Xsd2InstOptions r6) {
        /*
            int r0 = r4.length
            r1 = 0
            if (r0 <= 0) goto L5b
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            org.apache.xmlbeans.XmlOptions r2 = new org.apache.xmlbeans.XmlOptions
            r2.<init>()
            boolean r3 = r6.isNetworkDownloads()
            if (r3 == 0) goto L17
            r2.setCompileDownloadUrls()
        L17:
            boolean r3 = r6.isNopvr()
            if (r3 == 0) goto L20
            r2.setCompileNoPvrRule()
        L20:
            boolean r6 = r6.isNoupa()
            if (r6 == 0) goto L29
            r2.setCompileNoUpaRule()
        L29:
            org.apache.xmlbeans.SchemaTypeSystem r6 = org.apache.xmlbeans.XmlBeans.getBuiltinTypeSystem()     // Catch: java.lang.Exception -> L32
            org.apache.xmlbeans.SchemaTypeSystem r4 = org.apache.xmlbeans.XmlBeans.compileXsd(r4, r6, r2)     // Catch: java.lang.Exception -> L32
            goto L5c
        L32:
            r4 = move-exception
            boolean r6 = r0.isEmpty()
            if (r6 != 0) goto L3d
            boolean r6 = r4 instanceof org.apache.xmlbeans.XmlException
            if (r6 != 0) goto L40
        L3d:
            r4.printStackTrace()
        L40:
            java.io.PrintStream r4 = java.lang.System.out
            java.lang.String r6 = "Schema compilation errors: "
            r4.println(r6)
            java.util.Iterator r4 = r0.iterator()
        L4b:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L5b
            java.io.PrintStream r6 = java.lang.System.out
            java.lang.Object r0 = r4.next()
            r6.println(r0)
            goto L4b
        L5b:
            r4 = r1
        L5c:
            if (r4 == 0) goto La2
            org.apache.xmlbeans.SchemaType[] r4 = r4.documentTypes()
            r6 = 0
        L63:
            int r0 = r4.length
            if (r6 >= r0) goto L7c
            r0 = r4[r6]
            aavax.xml.namespace.QName r0 = r0.getDocumentElementName()
            java.lang.String r0 = r0.getLocalPart()
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L79
            r1 = r4[r6]
            goto L7c
        L79:
            int r6 = r6 + 1
            goto L63
        L7c:
            if (r1 == 0) goto L83
            java.lang.String r4 = org.apache.xmlbeans.impl.xsd2inst.SampleXmlUtil.createSampleForType(r1)
            return r4
        L83:
            java.lang.RuntimeException r4 = new java.lang.RuntimeException
            java.lang.StringBuffer r6 = new java.lang.StringBuffer
            r6.<init>()
            java.lang.String r0 = "Could not find a global element with name \""
            java.lang.StringBuffer r6 = r6.append(r0)
            java.lang.StringBuffer r5 = r6.append(r5)
            java.lang.String r6 = "\""
            java.lang.StringBuffer r5 = r5.append(r6)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        La2:
            java.lang.RuntimeException r4 = new java.lang.RuntimeException
            java.lang.String r5 = "No Schemas to process."
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.xsd2inst.SchemaInstanceGenerator.xsd2inst(org.apache.xmlbeans.XmlObject[], java.lang.String, org.apache.xmlbeans.impl.xsd2inst.SchemaInstanceGenerator$Xsd2InstOptions):java.lang.String");
    }
}
