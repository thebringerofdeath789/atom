package org.apache.xmlbeans.impl.tool;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Pattern;
import javax.xml.transform.OutputKeys;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.text.StringSubstitutor;
import org.apache.xmlbeans.SystemProperties;
import org.apache.xmlbeans.XmlCalendar;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc;
import org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument;

/* loaded from: classes5.dex */
public class XSTCTester {
    private static final Pattern leadingSpace = Pattern.compile("^\\s+", 8);

    public interface Harness {
        void runTestCase(TestCaseResult testCaseResult);
    }

    public static void printUsage() {
        System.out.println("Usage: xstc [-showpass] [-errcode] foo_LTGfmt.xml ...");
    }

    public static void main(String[] strArr) throws IOException {
        HashSet hashSet = new HashSet();
        hashSet.add("h");
        hashSet.add("help");
        hashSet.add("usage");
        hashSet.add(OutputKeys.VERSION);
        hashSet.add("showpass");
        hashSet.add("errcode");
        long currentTimeMillis = System.currentTimeMillis();
        CommandLine commandLine = new CommandLine(strArr, hashSet, Collections.EMPTY_SET);
        int i = 0;
        if (commandLine.getOpt("h") != null || commandLine.getOpt("help") != null || commandLine.getOpt("usage") != null) {
            printUsage();
            System.exit(0);
            return;
        }
        if (commandLine.getOpt(OutputKeys.VERSION) != null) {
            CommandLine.printVersion();
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
        if (commandLine.args().length == 0) {
            printUsage();
            return;
        }
        boolean z = commandLine.getOpt("showpass") != null;
        boolean z2 = commandLine.getOpt("errcode") != null;
        File[] files = commandLine.getFiles();
        ArrayList arrayList = new ArrayList();
        XMLBeanXSTCHarness xMLBeanXSTCHarness = new XMLBeanXSTCHarness();
        for (int i2 = 0; i2 < files.length; i2++) {
            if (files[i2].getName().indexOf("LTG") >= 0) {
                arrayList.add(files[i2]);
            }
        }
        File file = new File("out.html");
        PrintWriter printWriter = new PrintWriter(new FileWriter(file));
        printWriter.println("<html>");
        printWriter.println("<style>td {border-bottom: 1px solid black} xmp {white-space: normal; word-wrap: break-word; word-break: break-all} </style>");
        printWriter.println("<body>");
        printWriter.println("<script language='JavaScript' type='text/javascript'>");
        printWriter.println("var w;");
        printWriter.println("function openWindow(schema, instance) {");
        printWriter.println("  if (w == null) {");
        printWriter.println("    w = window.open('about:blank', 'xstc');");
        printWriter.println("  }");
        printWriter.println("  if (w.closed) {");
        printWriter.println("    w = window.open('about:blank', 'xstc');");
        printWriter.println("  }");
        printWriter.println("  w.document.open();");
        printWriter.println("  w.document.write(\"<frameset rows=*,*><frame src='\" + schema + \"'><frame src='\" + instance + \"'></frameset>\");");
        printWriter.println("  w.document.close();");
        printWriter.println("  w.focus();");
        printWriter.println(StringSubstitutor.DEFAULT_VAR_END);
        printWriter.println("</script>");
        printWriter.println("<h1>XML Schema Test Collection Results</h1>");
        printWriter.println(new StringBuffer().append("<p>Run on ").append(new XmlCalendar(new Date())).append("</p>").toString());
        printWriter.println("<p>Values in schema or instance valid columns are results from compiling or validating respectively.");
        printWriter.println("Red or orange background mean the test failed.</p>");
        printWriter.println("<table style='border: 1px solid black' cellpadding=0 cellspacing=0>");
        printWriter.println("<tr><td witdh=10%>id</td><td width=70%>Description</td><td width=10%>sch v</td><td width=10%>ins v</td></tr>");
        Iterator it = arrayList.iterator();
        int i3 = 0;
        int i4 = 0;
        while (it.hasNext()) {
            File file2 = (File) it.next();
            System.out.println(new StringBuffer().append("Processing test cases in ").append(file2).toString());
            ArrayList arrayList2 = new ArrayList();
            TestCase[] parseLTGFile = parseLTGFile(file2, arrayList2);
            ArrayList arrayList3 = new ArrayList();
            if (parseLTGFile != null) {
                int i5 = i;
                while (i5 < parseLTGFile.length) {
                    TestCaseResult testCaseResult = new TestCaseResult();
                    Iterator it2 = it;
                    testCaseResult.testCase = parseLTGFile[i5];
                    xMLBeanXSTCHarness.runTestCase(testCaseResult);
                    i4++;
                    if (!testCaseResult.succeeded(z2)) {
                        i3++;
                    } else if (!z) {
                        i5++;
                        it = it2;
                    }
                    arrayList3.add(testCaseResult);
                    i5++;
                    it = it2;
                }
            }
            Iterator it3 = it;
            printWriter.println(new StringBuffer().append("<tr><td colspan=4 bgcolor=skyblue>").append(file2).append("</td></tr>").toString());
            if (!arrayList2.isEmpty()) {
                printWriter.println("<tr><td>Errors within the LTG file:");
                printWriter.println("<xmp>");
                Iterator it4 = arrayList2.iterator();
                while (it4.hasNext()) {
                    printWriter.println(it4.next());
                }
                printWriter.println("</xmp>");
                printWriter.println("</td></tr>");
            } else if (arrayList3.size() == 0) {
                printWriter.println("<tr><td colspan=4 bgcolor=green>Nothing to report</td></tr>");
            }
            Iterator it5 = arrayList3.iterator();
            while (it5.hasNext()) {
                summarizeResultAsHTMLTableRows((TestCaseResult) it5.next(), printWriter, z2);
            }
            it = it3;
            i = 0;
        }
        printWriter.println(new StringBuffer().append("<tr><td colspan=4>Summary: ").append(i3).append(" failures out of ").append(i4).append(" cases run.</td></tr>").toString());
        printWriter.println("</table>");
        printWriter.close();
        System.out.println(new StringBuffer().append("Time run tests: ").append((System.currentTimeMillis() - currentTimeMillis) / 1000.0d).append(" seconds").toString());
        System.out.println(new StringBuffer().append("Results output to ").append(file).toString());
        if (SystemProperties.getProperty("os.name").toLowerCase().indexOf("windows") >= 0) {
            Runtime.getRuntime().exec(new StringBuffer().append("cmd /c start iexplore \"").append(file.getAbsolutePath()).append("\"").toString());
        } else {
            Runtime.getRuntime().exec(new StringBuffer().append("mozilla file://").append(file.getAbsolutePath()).toString());
        }
    }

    public static class TestCase {
        private String description;
        private String errorCode;
        private String id;
        private File instanceFile;
        private boolean ivExpected;
        private File ltgFile;
        private String origin;
        private File resourceFile;
        private boolean rvExpected;
        private File schemaFile;
        private boolean svExpected;

        public File getLtgFile() {
            return this.ltgFile;
        }

        public String getId() {
            return this.id;
        }

        public String getOrigin() {
            return this.origin;
        }

        public String getDescription() {
            return this.description;
        }

        public File getSchemaFile() {
            return this.schemaFile;
        }

        public File getInstanceFile() {
            return this.instanceFile;
        }

        public File getResourceFile() {
            return this.resourceFile;
        }

        public boolean isSvExpected() {
            return this.svExpected;
        }

        public boolean isIvExpected() {
            return this.ivExpected;
        }

        public boolean isRvExpected() {
            return this.rvExpected;
        }

        public String getErrorCode() {
            return this.errorCode;
        }
    }

    public static class TestCaseResult {
        private boolean crash;
        private boolean ivActual;
        private boolean svActual;
        private TestCase testCase;
        private Collection svMessages = new ArrayList();
        private Collection ivMessages = new ArrayList();

        public TestCase getTestCase() {
            return this.testCase;
        }

        public boolean isSvActual() {
            return this.svActual;
        }

        public void setSvActual(boolean z) {
            this.svActual = z;
        }

        public boolean isIvActual() {
            return this.ivActual;
        }

        public void setIvActual(boolean z) {
            this.ivActual = z;
        }

        public Collection getSvMessages() {
            return Collections.unmodifiableCollection(this.svMessages);
        }

        public void addSvMessages(Collection collection) {
            this.svMessages.addAll(collection);
        }

        public Collection getIvMessages() {
            return Collections.unmodifiableCollection(this.ivMessages);
        }

        public void addIvMessages(Collection collection) {
            this.ivMessages.addAll(collection);
        }

        public void setCrash(boolean z) {
            this.crash = z;
        }

        public boolean isCrash() {
            return this.crash;
        }

        public boolean succeeded(boolean z) {
            boolean z2 = true;
            boolean z3 = !this.crash && isIvActual() == this.testCase.isIvExpected() && isSvActual() == this.testCase.isSvExpected();
            if (!z || this.testCase.getErrorCode() == null) {
                return z3;
            }
            if (!XSTCTester.errorReported(this.testCase.getErrorCode(), this.svMessages) && !XSTCTester.errorReported(this.testCase.getErrorCode(), this.ivMessages)) {
                z2 = false;
            }
            return z3 & z2;
        }
    }

    public static String makeHTMLLink(File file, boolean z) {
        if (file == null) {
            return "&nbsp;";
        }
        return new StringBuffer().append("<a href=\"").append(file.getAbsoluteFile().toURI()).append("\" target=_blank>").append(Boolean.toString(z)).append("</a>").toString();
    }

    public static String makeHTMLDescription(TestCase testCase) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<a class=noline href='javascript:openWindow(\"");
        if (testCase.getSchemaFile() == null) {
            stringBuffer.append("about:No schema");
        } else {
            stringBuffer.append(testCase.getSchemaFile().getAbsolutePath().replaceAll("\\\\", "\\\\\\\\"));
        }
        stringBuffer.append("\", \"");
        if (testCase.getInstanceFile() == null) {
            stringBuffer.append("about:No instance");
        } else {
            stringBuffer.append(testCase.getInstanceFile().getAbsolutePath().replaceAll("\\\\", "\\\\\\\\"));
        }
        stringBuffer.append("\")'><xmp>");
        stringBuffer.append(leadingSpace.matcher(testCase.getDescription()).replaceAll(""));
        stringBuffer.append("</xmp></a>");
        return stringBuffer.toString();
    }

    public static void summarizeResultAsHTMLTableRows(TestCaseResult testCaseResult, PrintWriter printWriter, boolean z) {
        String stringBuffer;
        TestCase testCase = testCaseResult.getTestCase();
        boolean z2 = true;
        int i = (!z || testCase.getErrorCode() == null) ? 0 : 1;
        int i2 = (testCaseResult.getIvMessages().isEmpty() && testCaseResult.getSvMessages().isEmpty()) ? 0 : 1;
        boolean z3 = testCase.getSchemaFile() == null || testCase.isSvExpected() == testCaseResult.isSvActual();
        boolean z4 = testCase.getInstanceFile() == null || testCase.isIvExpected() == testCaseResult.isIvActual();
        if (i != 0) {
            z2 = errorReported(testCase.getErrorCode(), testCaseResult.svMessages) || errorReported(testCase.getErrorCode(), testCaseResult.ivMessages);
        }
        printWriter.println(testCaseResult.isCrash() ? "<tr bgcolor=black color=white>" : "<tr>");
        printWriter.println(new StringBuffer().append("<td rowspan=").append(i + 1 + i2).append(" valign=top>").append(testCase.getId()).append("</td>").toString());
        printWriter.println(new StringBuffer().append("<td valign=top>").append(makeHTMLDescription(testCase)).append("</td>").toString());
        if (testCase.getResourceFile() == null) {
            stringBuffer = makeHTMLLink(testCase.getSchemaFile(), testCaseResult.isSvActual());
        } else {
            stringBuffer = new StringBuffer().append(makeHTMLLink(testCase.getSchemaFile(), testCaseResult.isSvActual())).append("<br>").append(makeHTMLLink(testCase.getResourceFile(), testCaseResult.isSvActual())).toString();
        }
        printWriter.println(new StringBuffer().append(z3 ? "<td valign=top>" : testCaseResult.isSvActual() ? "<td bgcolor=orange valign=top>" : "<td bgcolor=red valign=top>").append(stringBuffer).append("</td>").toString());
        printWriter.println(new StringBuffer().append(z4 ? "<td valign=top>" : testCaseResult.isIvActual() ? "<td bgcolor=orange valign=top>" : "<td bgcolor=red valign=top>").append(makeHTMLLink(testCase.getInstanceFile(), testCaseResult.isIvActual())).append("</td>").toString());
        printWriter.println("</tr>");
        if (i != 0) {
            printWriter.println("<tr>");
            printWriter.println(new StringBuffer().append(z2 ? "<td colspan=4 valid=top>" : "<td colspan=4 bgcolor=orange valign=top>").append("expected error: ").append(testCase.getErrorCode()).append("</td>").toString());
            printWriter.println("</tr>");
        }
        if (i2 != 0) {
            if (!testCaseResult.succeeded(z)) {
                printWriter.println("<tr><td colspan=4 bgcolor=yellow><xmp>");
            } else {
                printWriter.println("<tr><td colspan=4><xmp>");
            }
            Iterator it = testCaseResult.getSvMessages().iterator();
            while (it.hasNext()) {
                printWriter.println(it.next());
            }
            Iterator it2 = testCaseResult.getIvMessages().iterator();
            while (it2.hasNext()) {
                printWriter.println(it2.next());
            }
            printWriter.println("</xmp></tr></td>");
        }
    }

    public static TestCase[] parseLTGFile(File file, Collection collection) {
        ArrayList arrayList = new ArrayList();
        try {
            XmlOptions xmlOptions = new XmlOptions();
            xmlOptions.setLoadSubstituteNamespaces(Collections.singletonMap("", "http://www.bea.com/2003/05/xmlbean/ltgfmt"));
            xmlOptions.setErrorListener(arrayList);
            xmlOptions.setLoadLineNumbers();
            TestsDocument parse = TestsDocument.Factory.parse(file, xmlOptions);
            if (!parse.validate(xmlOptions)) {
                throw new Exception(new StringBuffer().append("Document ").append(file).append(" not valid.").toString());
            }
            org.apache.xmlbeans.impl.xb.ltgfmt.TestCase[] testArray = parse.getTests().getTestArray();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < testArray.length; i++) {
                TestCase testCase = new TestCase();
                testCase.ltgFile = file;
                testCase.id = testArray[i].getId();
                testCase.origin = testArray[i].getOrigin();
                testCase.description = testArray[i].getDescription();
                FileDesc[] fileArray = testArray[i].getFiles().getFileArray();
                testArray[i].getOrigin();
                for (int i2 = 0; i2 < fileArray.length; i2++) {
                    File file2 = new File(file.getParentFile(), new StringBuffer().append(fileArray[i2].getFolder()).append(InternalZipConstants.ZIP_FILE_SEPARATOR).append(fileArray[i2].getFileName()).toString());
                    if (file2.exists() && file2.isFile() && file2.canRead()) {
                        int intValue = fileArray[i2].getRole().intValue();
                        if (intValue == 1) {
                            if (testCase.schemaFile != null) {
                                collection.add(XmlError.forObject("More than one schema file speicifed - ignoring all but last", fileArray[i2]).toString());
                            }
                            testCase.schemaFile = file2;
                            testCase.svExpected = fileArray[i2].getValidity();
                        } else if (intValue == 2) {
                            if (testCase.instanceFile != null) {
                                collection.add(XmlError.forObject("More than one instance file speicifed - ignoring all but last", fileArray[i2]).toString());
                            }
                            testCase.instanceFile = file2;
                            testCase.ivExpected = fileArray[i2].getValidity();
                        } else if (intValue == 3) {
                            if (testCase.resourceFile != null) {
                                collection.add(XmlError.forObject("More than one resource file speicifed - ignoring all but last", fileArray[i2]).toString());
                            }
                            testCase.resourceFile = file2;
                            testCase.rvExpected = fileArray[i2].getValidity();
                        } else {
                            throw new XmlException(XmlError.forObject("Unexpected file role", fileArray[i2]));
                        }
                        if (fileArray[i2].getCode() != null) {
                            testCase.errorCode = fileArray[i2].getCode().getID();
                        }
                    }
                    collection.add(XmlError.forObject(new StringBuffer().append("Can't read file ").append(file2).toString(), fileArray[i2]).toString());
                }
                arrayList2.add(testCase);
            }
            return (TestCase[]) arrayList2.toArray(new TestCase[arrayList2.size()]);
        } catch (Exception e) {
            if (arrayList.isEmpty()) {
                collection.add(e.getMessage());
                return null;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                collection.add(it.next().toString());
            }
            return null;
        }
    }

    public static boolean errorReported(String str, Collection collection) {
        if (str != null && collection != null && collection.size() != 0) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (str.equals(((XmlError) it.next()).getErrorCode())) {
                    return true;
                }
            }
        }
        return false;
    }
}
