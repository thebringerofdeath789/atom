package org.apache.xmlbeans.impl.tool;

import aavax.xml.stream.XMLInputFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import javax.xml.transform.OutputKeys;
import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;

/* loaded from: classes5.dex */
public class StreamInstanceValidator {
    private static final XMLInputFactory XML_INPUT_FACTORY = XMLInputFactory.newInstance();

    public static void printUsage() {
        System.out.println("Validates the specified instance against the specified schema.");
        System.out.println("A streaming validation useful for validating very large instance ");
        System.out.println("documents with less memory. Contrast with the validate tool.");
        System.out.println("Usage: svalidate [-dl] [-nopvr] [-noupa] [-license] schema.xsd instance.xml");
        System.out.println("Options:");
        System.out.println("    -dl - permit network downloads for imports and includes (default is off)");
        System.out.println("    -noupa - do not enforce the unique particle attribution rule");
        System.out.println("    -nopvr - do not enforce the particle valid (restriction) rule");
        System.out.println("    -license - prints license information");
    }

    public static void main(String[] strArr) {
        HashSet hashSet = new HashSet();
        hashSet.add("h");
        hashSet.add("help");
        hashSet.add("usage");
        hashSet.add("license");
        hashSet.add(OutputKeys.VERSION);
        hashSet.add("dl");
        hashSet.add("noupr");
        hashSet.add("noupa");
        CommandLine commandLine = new CommandLine(strArr, hashSet, Collections.EMPTY_SET);
        if (commandLine.getOpt("h") == null && commandLine.getOpt("help") == null && commandLine.getOpt("usage") == null) {
            if (strArr.length >= 1) {
                String[] badOpts = commandLine.getBadOpts();
                if (badOpts.length > 0) {
                    for (String str : badOpts) {
                        System.out.println(new StringBuffer().append("Unrecognized option: ").append(str).toString());
                    }
                    printUsage();
                    System.exit(0);
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
                if (commandLine.args().length == 0) {
                    printUsage();
                    return;
                }
                boolean z = commandLine.getOpt("dl") != null;
                boolean z2 = commandLine.getOpt("nopvr") != null;
                boolean z3 = commandLine.getOpt("noupa") != null;
                File[] filesEndingWith = commandLine.filesEndingWith(".xsd");
                File[] filesEndingWith2 = commandLine.filesEndingWith(".xml");
                File[] filesEndingWith3 = commandLine.filesEndingWith(".jar");
                ArrayList arrayList = new ArrayList();
                XmlOptions loadLineNumbers = new XmlOptions().setLoadLineNumbers();
                for (int i = 0; i < filesEndingWith.length; i++) {
                    try {
                        arrayList.add(XmlObject.Factory.parse(filesEndingWith[i], loadLineNumbers.setLoadMessageDigest()));
                    } catch (Exception e) {
                        System.err.println(new StringBuffer().append(filesEndingWith[i]).append(" not loadable: ").append(e).toString());
                    }
                }
                XmlObject[] xmlObjectArr = (XmlObject[]) arrayList.toArray(new XmlObject[0]);
                SchemaTypeLoader schemaTypeLoader = null;
                ArrayList arrayList2 = new ArrayList();
                XmlOptions xmlOptions = new XmlOptions();
                xmlOptions.setErrorListener(arrayList2);
                if (z) {
                    xmlOptions.setCompileDownloadUrls();
                }
                if (z2) {
                    xmlOptions.setCompileNoPvrRule();
                }
                if (z3) {
                    xmlOptions.setCompileNoUpaRule();
                }
                if (filesEndingWith3 != null && filesEndingWith3.length > 0) {
                    schemaTypeLoader = XmlBeans.typeLoaderForResource(XmlBeans.resourceLoaderForPath(filesEndingWith3));
                }
                if (xmlObjectArr != null) {
                    try {
                        if (xmlObjectArr.length > 0) {
                            schemaTypeLoader = XmlBeans.compileXsd(xmlObjectArr, schemaTypeLoader, xmlOptions);
                        }
                    } catch (Exception e2) {
                        if (arrayList2.isEmpty() || !(e2 instanceof XmlException)) {
                            e2.printStackTrace(System.err);
                        }
                        System.out.println("Schema invalid");
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            System.out.println(it.next());
                        }
                        return;
                    }
                }
                validateFiles(filesEndingWith2, schemaTypeLoader, loadLineNumbers);
                return;
            }
        }
        printUsage();
        System.exit(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void validateFiles(java.io.File[] r16, org.apache.xmlbeans.SchemaTypeLoader r17, org.apache.xmlbeans.XmlOptions r18) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.tool.StreamInstanceValidator.validateFiles(java.io.File[], org.apache.xmlbeans.SchemaTypeLoader, org.apache.xmlbeans.XmlOptions):void");
    }

    private static String stringFromError(XmlError xmlError, String str) {
        return new StringBuffer().append(XmlError.severityAsString(xmlError.getSeverity())).append(": ").append(str).append(":").append(xmlError.getLine()).append(":").append(xmlError.getColumn()).append(StringUtils.SPACE).append(xmlError.getMessage()).append(StringUtils.SPACE).toString();
    }
}
