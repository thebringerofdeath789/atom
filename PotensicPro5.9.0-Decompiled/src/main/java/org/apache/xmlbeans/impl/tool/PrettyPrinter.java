package org.apache.xmlbeans.impl.tool;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashSet;
import javax.xml.transform.OutputKeys;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;

/* loaded from: classes5.dex */
public class PrettyPrinter {
    private static final int DEFAULT_INDENT = 2;

    public static void printUsage() {
        System.out.println("Pretty prints XML files.");
        System.out.println("Usage: xpretty [switches] file.xml");
        System.out.println("Switches:");
        System.out.println("    -indent #   use the given indent");
        System.out.println("    -license prints license information");
    }

    public static void main(String[] strArr) {
        HashSet hashSet = new HashSet();
        hashSet.add("h");
        hashSet.add("help");
        hashSet.add("usage");
        hashSet.add("license");
        hashSet.add(OutputKeys.VERSION);
        CommandLine commandLine = new CommandLine(strArr, hashSet, Collections.singleton(OutputKeys.INDENT));
        if (commandLine.getOpt("h") != null || commandLine.getOpt("help") != null || commandLine.getOpt("usage") != null) {
            printUsage();
            System.exit(0);
            return;
        }
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
        String opt = commandLine.getOpt(OutputKeys.INDENT);
        int parseInt = opt == null ? 2 : Integer.parseInt(opt);
        File[] files = commandLine.getFiles();
        for (int i = 0; i < files.length; i++) {
            try {
                try {
                    XmlObject.Factory.parse(files[i], new XmlOptions().setLoadLineNumbers()).save(System.out, new XmlOptions().setSavePrettyPrint().setSavePrettyPrintIndent(parseInt));
                } catch (IOException e) {
                    System.err.println(new StringBuffer().append("Unable to pretty print ").append(files[i]).append(": ").append(e.getMessage()).toString());
                }
            } catch (Exception e2) {
                System.err.println(new StringBuffer().append(files[i]).append(" not loadable: ").append(e2.getMessage()).toString());
            }
        }
    }

    public static String indent(String str) throws IOException, XmlException {
        StringWriter stringWriter = new StringWriter();
        XmlObject.Factory.parse(str, new XmlOptions().setLoadLineNumbers()).save(stringWriter, new XmlOptions().setSavePrettyPrint().setSavePrettyPrintIndent(2));
        stringWriter.close();
        return stringWriter.getBuffer().toString();
    }
}
