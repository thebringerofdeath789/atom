package org.apache.xmlbeans.impl.inst2xsd;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import javax.xml.transform.OutputKeys;
import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.inst2xsd.util.TypeSystemHolder;
import org.apache.xmlbeans.impl.tool.CommandLine;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;

/* loaded from: classes5.dex */
public class Inst2Xsd {
    public static void main(String[] strArr) {
        String str;
        if (strArr == null || strArr.length == 0) {
            printHelp();
            System.exit(0);
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.add("h");
        hashSet.add("help");
        hashSet.add("usage");
        hashSet.add("license");
        hashSet.add(OutputKeys.VERSION);
        hashSet.add("verbose");
        hashSet.add("validate");
        HashSet hashSet2 = new HashSet();
        hashSet2.add("design");
        hashSet2.add("simple-content-types");
        hashSet2.add("enumerations");
        hashSet2.add("outDir");
        hashSet2.add("outPrefix");
        String str2 = ".xsd";
        CommandLine commandLine = new CommandLine(strArr, hashSet, hashSet2);
        Inst2XsdOptions inst2XsdOptions = new Inst2XsdOptions();
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
        if (commandLine.getOpt("h") != null || commandLine.getOpt("help") != null || commandLine.getOpt("usage") != null) {
            printHelp();
            System.exit(0);
            return;
        }
        String[] badOpts = commandLine.getBadOpts();
        if (badOpts.length > 0) {
            for (String str3 : badOpts) {
                System.out.println(new StringBuffer().append("Unrecognized option: ").append(str3).toString());
            }
            printHelp();
            System.exit(0);
            return;
        }
        String opt = commandLine.getOpt("design");
        if (opt != null) {
            if (opt.equals("vb")) {
                inst2XsdOptions.setDesign(3);
            } else if (opt.equals("rd")) {
                inst2XsdOptions.setDesign(1);
            } else if (opt.equals("ss")) {
                inst2XsdOptions.setDesign(2);
            } else {
                printHelp();
                System.exit(0);
                return;
            }
        }
        String opt2 = commandLine.getOpt("simple-content-types");
        if (opt2 != null) {
            if (opt2.equals("smart")) {
                inst2XsdOptions.setSimpleContentTypes(1);
            } else if (opt2.equals("string")) {
                inst2XsdOptions.setSimpleContentTypes(2);
            } else {
                printHelp();
                System.exit(0);
                return;
            }
        }
        String opt3 = commandLine.getOpt("enumerations");
        if (opt3 != null) {
            if (opt3.equals("never")) {
                inst2XsdOptions.setUseEnumerations(1);
            } else {
                try {
                    inst2XsdOptions.setUseEnumerations(Integer.parseInt(opt3));
                } catch (NumberFormatException unused) {
                    printHelp();
                    System.exit(0);
                    return;
                }
            }
        }
        File file = new File(commandLine.getOpt("outDir") == null ? "." : commandLine.getOpt("outDir"));
        String opt4 = commandLine.getOpt("outPrefix");
        if (opt4 == null) {
            opt4 = "schema";
        }
        inst2XsdOptions.setVerbose(commandLine.getOpt("verbose") != null);
        boolean z = commandLine.getOpt("validate") != null;
        File[] filesEndingWith = commandLine.filesEndingWith(".xml");
        int length = filesEndingWith.length;
        XmlObject[] xmlObjectArr = new XmlObject[length];
        if (length == 0) {
            printHelp();
            System.exit(0);
            return;
        }
        for (int i = 0; i < filesEndingWith.length; i++) {
            try {
                xmlObjectArr[i] = XmlObject.Factory.parse(filesEndingWith[i]);
            } catch (IOException e) {
                System.err.println(new StringBuffer().append("Could not read file: '").append(filesEndingWith[i].getName()).append("'. ").append(e.getMessage()).toString());
                return;
            } catch (XmlException e2) {
                System.err.println(new StringBuffer().append("Invalid xml file: '").append(filesEndingWith[i].getName()).append("'. ").append(e2.getMessage()).toString());
                return;
            }
        }
        SchemaDocument[] inst2xsd = inst2xsd(xmlObjectArr, inst2XsdOptions);
        int i2 = 0;
        while (i2 < inst2xsd.length) {
            try {
                SchemaDocument schemaDocument = inst2xsd[i2];
                if (inst2XsdOptions.isVerbose()) {
                    System.out.println(new StringBuffer().append("----------------------\n\n").append(schemaDocument).toString());
                }
                str = str2;
                try {
                    schemaDocument.save(new File(file, new StringBuffer().append(opt4).append(i2).append(str).toString()), new XmlOptions().setSavePrettyPrint());
                    i2++;
                    str2 = str;
                } catch (IOException e3) {
                    e = e3;
                    System.err.println(new StringBuffer().append("Could not write file: '").append(file).append(File.pathSeparator).append(opt4).append(i2).append(str).append("'. ").append(e.getMessage()).toString());
                    return;
                }
            } catch (IOException e4) {
                e = e4;
                str = str2;
            }
        }
        if (z) {
            validateInstances(inst2xsd, xmlObjectArr);
        }
    }

    private static void printHelp() {
        System.out.println("Generates XMLSchema from instance xml documents.");
        System.out.println("Usage: inst2xsd [opts] [instance.xml]*");
        System.out.println("Options include:");
        System.out.println("    -design [rd|ss|vb] - XMLSchema design type");
        System.out.println("             rd  - Russian Doll Design - local elements and local types");
        System.out.println("             ss  - Salami Slice Design - global elements and local types");
        System.out.println("             vb  - Venetian Blind Design (default) - local elements and global complex types");
        System.out.println("    -simple-content-types [smart|string] - Simple content types detection (leaf text). Smart is the default");
        System.out.println("    -enumerations [never|NUMBER] - Use enumerations. Default value is 10.");
        System.out.println("    -outDir [dir] - Directory for output files. Default is '.'");
        System.out.println("    -outPrefix [file_name_prefix] - Prefix for output file names. Default is 'schema'");
        System.out.println("    -validate - Validates input instances agaist generated schemas.");
        System.out.println("    -verbose - print more informational messages");
        System.out.println("    -license - print license information");
        System.out.println("    -help - help imformation");
    }

    private Inst2Xsd() {
    }

    public static SchemaDocument[] inst2xsd(Reader[] readerArr, Inst2XsdOptions inst2XsdOptions) throws IOException, XmlException {
        XmlObject[] xmlObjectArr = new XmlObject[readerArr.length];
        for (int i = 0; i < readerArr.length; i++) {
            xmlObjectArr[i] = XmlObject.Factory.parse(readerArr[i]);
        }
        return inst2xsd(xmlObjectArr, inst2XsdOptions);
    }

    public static SchemaDocument[] inst2xsd(XmlObject[] xmlObjectArr, Inst2XsdOptions inst2XsdOptions) {
        XsdGenStrategy russianDollStrategy;
        if (inst2XsdOptions == null) {
            inst2XsdOptions = new Inst2XsdOptions();
        }
        TypeSystemHolder typeSystemHolder = new TypeSystemHolder();
        int design = inst2XsdOptions.getDesign();
        if (design == 1) {
            russianDollStrategy = new RussianDollStrategy();
        } else if (design == 2) {
            russianDollStrategy = new SalamiSliceStrategy();
        } else if (design == 3) {
            russianDollStrategy = new VenetianBlindStrategy();
        } else {
            throw new IllegalArgumentException("Unknown design.");
        }
        russianDollStrategy.processDoc(xmlObjectArr, inst2XsdOptions, typeSystemHolder);
        if (inst2XsdOptions.isVerbose()) {
            System.out.println(new StringBuffer().append("typeSystemHolder.toString(): ").append(typeSystemHolder).toString());
        }
        return typeSystemHolder.getSchemaDocuments();
    }

    private static boolean validateInstances(SchemaDocument[] schemaDocumentArr, XmlObject[] xmlObjectArr) {
        XmlObject parse;
        ArrayList<XmlError> arrayList;
        ArrayList<XmlError> arrayList2 = new ArrayList();
        XmlOptions xmlOptions = new XmlOptions();
        xmlOptions.setErrorListener(arrayList2);
        try {
            SchemaTypeLoader loadXsd = XmlBeans.loadXsd(schemaDocumentArr, xmlOptions);
            System.out.println("\n-------------------");
            boolean z = true;
            for (int i = 0; i < xmlObjectArr.length; i++) {
                try {
                    parse = loadXsd.parse(xmlObjectArr[i].newXMLStreamReader(), (SchemaType) null, new XmlOptions().setLoadLineNumbers());
                    arrayList = new ArrayList();
                } catch (XmlException e) {
                    System.out.println(new StringBuffer().append("Error:\n").append(xmlObjectArr[i].documentProperties().getSourceName()).append(" not loadable: ").append(e).toString());
                    e.printStackTrace(System.out);
                }
                if (parse.schemaType() == XmlObject.type) {
                    System.out.println(new StringBuffer().append(xmlObjectArr[i].documentProperties().getSourceName()).append(" NOT valid.  ").toString());
                    System.out.println("  Document type not found.");
                } else if (parse.validate(new XmlOptions().setErrorListener(arrayList))) {
                    System.out.println(new StringBuffer().append("Instance[").append(i).append("] valid - ").append(xmlObjectArr[i].documentProperties().getSourceName()).toString());
                } else {
                    System.out.println(new StringBuffer().append("Instance[").append(i).append("] NOT valid - ").append(xmlObjectArr[i].documentProperties().getSourceName()).toString());
                    for (XmlError xmlError : arrayList) {
                        System.out.println(new StringBuffer().append(xmlError.getLine()).append(":").append(xmlError.getColumn()).append(StringUtils.SPACE).append(xmlError.getMessage()).toString());
                    }
                }
                z = false;
            }
            return z;
        } catch (Exception e2) {
            if (arrayList2.isEmpty() || !(e2 instanceof XmlException)) {
                e2.printStackTrace(System.out);
            }
            System.out.println("\n-------------------\n\nInvalid schemas.");
            for (XmlError xmlError2 : arrayList2) {
                System.out.println(new StringBuffer().append(xmlError2.getLine()).append(":").append(xmlError2.getColumn()).append(StringUtils.SPACE).append(xmlError2.getMessage()).toString());
            }
            return false;
        }
    }
}
