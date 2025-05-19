package org.apache.xmlbeans.impl.tool;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import javax.xml.transform.OutputKeys;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;

/* loaded from: classes5.dex */
public class InstanceValidator {
    public static void printUsage() {
        System.out.println("Validates the specified instance against the specified schema.");
        System.out.println("Contrast with the svalidate tool, which validates using a stream.");
        System.out.println("Usage: validate [-dl] [-nopvr] [-noupa] [-license] schema.xsd instance.xml");
        System.out.println("Options:");
        System.out.println("    -dl - permit network downloads for imports and includes (default is off)");
        System.out.println("    -noupa - do not enforce the unique particle attribution rule");
        System.out.println("    -nopvr - do not enforce the particle valid (restriction) rule");
        System.out.println("    -strict - performs strict(er) validation");
        System.out.println("    -partial - allow partial schema type system");
        System.out.println("    -license - prints license information");
    }

    public static void main(String[] strArr) {
        System.exit(extraMain(strArr));
    }

    public static int extraMain(String[] strArr) {
        int i;
        XmlOptions xmlOptions;
        XmlOptions errorListener;
        HashSet hashSet = new HashSet();
        hashSet.add("h");
        hashSet.add("help");
        hashSet.add("usage");
        hashSet.add("license");
        hashSet.add(OutputKeys.VERSION);
        hashSet.add("dl");
        hashSet.add("noupa");
        hashSet.add("nopvr");
        hashSet.add("strict");
        hashSet.add("partial");
        CommandLine commandLine = new CommandLine(strArr, hashSet, Collections.EMPTY_SET);
        if (commandLine.getOpt("h") != null || commandLine.getOpt("help") != null || commandLine.getOpt("usage") != null || strArr.length < 1) {
            printUsage();
            return 0;
        }
        String[] badOpts = commandLine.getBadOpts();
        if (badOpts.length > 0) {
            for (String str : badOpts) {
                System.out.println(new StringBuffer().append("Unrecognized option: ").append(str).toString());
            }
            printUsage();
            return 0;
        }
        if (commandLine.getOpt("license") != null) {
            CommandLine.printLicense();
            return 0;
        }
        if (commandLine.getOpt(OutputKeys.VERSION) != null) {
            CommandLine.printVersion();
            return 0;
        }
        if (commandLine.args().length == 0) {
            return 0;
        }
        boolean z = commandLine.getOpt("dl") != null;
        boolean z2 = commandLine.getOpt("nopvr") != null;
        boolean z3 = commandLine.getOpt("noupa") != null;
        boolean z4 = commandLine.getOpt("strict") != null;
        boolean z5 = commandLine.getOpt("partial") != null;
        File[] filesEndingWith = commandLine.filesEndingWith(".xsd");
        File[] filesEndingWith2 = commandLine.filesEndingWith(".xml");
        File[] filesEndingWith3 = commandLine.filesEndingWith(".jar");
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < filesEndingWith.length; i2++) {
            try {
                arrayList.add(XmlObject.Factory.parse(filesEndingWith[i2], new XmlOptions().setLoadLineNumbers().setLoadMessageDigest()));
            } catch (Exception e) {
                System.err.println(new StringBuffer().append(filesEndingWith[i2]).append(" not loadable: ").append(e).toString());
            }
        }
        XmlObject[] xmlObjectArr = (XmlObject[]) arrayList.toArray(new XmlObject[0]);
        ArrayList arrayList2 = new ArrayList();
        XmlOptions xmlOptions2 = new XmlOptions();
        xmlOptions2.setErrorListener(arrayList2);
        if (z) {
            xmlOptions2.setCompileDownloadUrls();
        }
        if (z2) {
            xmlOptions2.setCompileNoPvrRule();
        }
        if (z3) {
            xmlOptions2.setCompileNoUpaRule();
        }
        if (z5) {
            xmlOptions2.put("COMPILE_PARTIAL_TYPESYSTEM");
        }
        SchemaTypeLoader typeLoaderForResource = (filesEndingWith3 == null || filesEndingWith3.length <= 0) ? null : XmlBeans.typeLoaderForResource(XmlBeans.resourceLoaderForPath(filesEndingWith3));
        if (xmlObjectArr != null) {
            try {
                if (xmlObjectArr.length > 0) {
                    typeLoaderForResource = XmlBeans.compileXsd(xmlObjectArr, typeLoaderForResource, xmlOptions2);
                }
            } catch (Exception e2) {
                if (arrayList2.isEmpty() || !(e2 instanceof XmlException)) {
                    e2.printStackTrace(System.err);
                }
                System.out.println(new StringBuffer().append("Schema invalid:").append(z5 ? " couldn't recover from errors" : "").toString());
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    System.out.println(it.next());
                }
                return 10;
            }
        }
        if (!z5 || arrayList2.isEmpty()) {
            i = 0;
        } else {
            i = 11;
            System.out.println("Schema invalid: partial schema type system recovered");
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                System.out.println(it2.next());
            }
        }
        if (typeLoaderForResource == null) {
            typeLoaderForResource = XmlBeans.getContextTypeLoader();
        }
        int i3 = i;
        for (int i4 = 0; i4 < filesEndingWith2.length; i4++) {
            try {
                XmlObject parse = typeLoaderForResource.parse(filesEndingWith2[i4], (SchemaType) null, new XmlOptions().setLoadLineNumbers(XmlOptions.LOAD_LINE_NUMBERS_END_ELEMENT));
                ArrayList arrayList3 = new ArrayList();
                if (parse.schemaType() == XmlObject.type) {
                    System.out.println(new StringBuffer().append(filesEndingWith2[i4]).append(" NOT valid.  ").toString());
                    System.out.println("  Document type not found.");
                } else {
                    if (z4) {
                        xmlOptions = new XmlOptions();
                        errorListener = xmlOptions.setErrorListener(arrayList3).setValidateStrict();
                    } else {
                        xmlOptions = new XmlOptions();
                        errorListener = xmlOptions.setErrorListener(arrayList3);
                    }
                    if (parse.validate(errorListener)) {
                        System.out.println(new StringBuffer().append(filesEndingWith2[i4]).append(" valid.").toString());
                    } else {
                        System.out.println(new StringBuffer().append(filesEndingWith2[i4]).append(" NOT valid.").toString());
                        Iterator it3 = arrayList3.iterator();
                        while (it3.hasNext()) {
                            System.out.println(it3.next());
                        }
                        i3 = 1;
                    }
                }
            } catch (Exception e3) {
                System.err.println(new StringBuffer().append(filesEndingWith2[i4]).append(" not loadable: ").append(e3).toString());
                e3.printStackTrace(System.err);
            }
        }
        return i3;
    }
}
