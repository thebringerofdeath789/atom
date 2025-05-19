package org.apache.xmlbeans.impl.tool;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import javax.xml.transform.OutputKeys;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.Sax2Dom;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;

/* loaded from: classes5.dex */
public class TypeHierarchyPrinter {
    public static void printUsage() {
        System.out.println("Prints the inheritance hierarchy of types defined in a schema.\n");
        System.out.println("Usage: xsdtree [-noanon] [-nopvr] [-noupa] [-partial] [-license] schemafile.xsd*");
        System.out.println("    -noanon - Don't include anonymous types in the tree.");
        System.out.println("    -noupa - do not enforce the unique particle attribution rule");
        System.out.println("    -nopvr - do not enforce the particle valid (restriction) rule");
        System.out.println("    -partial - Print only part of the hierarchy.");
        System.out.println("    -license - prints license information");
        System.out.println("    schemafile.xsd - File containing the schema for which to print a tree.");
        System.out.println();
    }

    public static void main(String[] strArr) throws Exception {
        HashSet hashSet = new HashSet();
        hashSet.add("h");
        hashSet.add("help");
        hashSet.add("usage");
        hashSet.add("license");
        hashSet.add(OutputKeys.VERSION);
        hashSet.add("noanon");
        hashSet.add("noupr");
        hashSet.add("noupa");
        hashSet.add("partial");
        CommandLine commandLine = new CommandLine(strArr, hashSet, Collections.EMPTY_SET);
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
        boolean z = commandLine.getOpt("noanon") != null;
        boolean z2 = commandLine.getOpt("nopvr") != null;
        boolean z3 = commandLine.getOpt("noupa") != null;
        boolean z4 = commandLine.getOpt("partial") != null;
        File[] filesEndingWith = commandLine.filesEndingWith(".xsd");
        File[] filesEndingWith2 = commandLine.filesEndingWith(".jar");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < filesEndingWith.length; i++) {
            try {
                arrayList.add(SchemaDocument.Factory.parse(filesEndingWith[i], new XmlOptions().setLoadLineNumbers()));
            } catch (Exception e) {
                System.err.println(new StringBuffer().append(filesEndingWith[i]).append(" not loadable: ").append(e).toString());
            }
        }
        XmlObject[] xmlObjectArr = (XmlObject[]) arrayList.toArray(new XmlObject[0]);
        ArrayList arrayList2 = new ArrayList();
        XmlOptions xmlOptions = new XmlOptions();
        xmlOptions.setErrorListener(arrayList2);
        xmlOptions.setCompileDownloadUrls();
        if (z2) {
            xmlOptions.setCompileNoPvrRule();
        }
        if (z3) {
            xmlOptions.setCompileNoUpaRule();
        }
        if (z4) {
            xmlOptions.put("COMPILE_PARTIAL_TYPESYSTEM");
        }
        try {
            SchemaTypeSystem compileXsd = XmlBeans.compileXsd(xmlObjectArr, (filesEndingWith2 == null || filesEndingWith2.length <= 0) ? null : XmlBeans.typeLoaderForResource(XmlBeans.resourceLoaderForPath(filesEndingWith2)), xmlOptions);
            if (z4 && !arrayList2.isEmpty()) {
                System.out.println("Schema invalid: partial schema type system recovered");
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    System.out.println(it.next());
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("http://www.w3.org/XML/1998/namespace", "xml");
            hashMap.put("http://www.w3.org/2001/XMLSchema", "xs");
            System.out.println("xmlns:xs=\"http://www.w3.org/2001/XMLSchema\"");
            HashMap hashMap2 = new HashMap();
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(Arrays.asList(compileXsd.documentTypes()));
            arrayList3.addAll(Arrays.asList(compileXsd.attributeTypes()));
            arrayList3.addAll(Arrays.asList(compileXsd.globalTypes()));
            for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                SchemaType schemaType = (SchemaType) arrayList3.get(i2);
                if (!z) {
                    arrayList3.addAll(Arrays.asList(schemaType.getAnonymousTypes()));
                }
                if (!schemaType.isDocumentType() && !schemaType.isAttributeType() && schemaType != XmlObject.type) {
                    noteNamespace(hashMap, schemaType);
                    Collection collection = (Collection) hashMap2.get(schemaType.getBaseType());
                    if (collection == null) {
                        collection = new ArrayList();
                        hashMap2.put(schemaType.getBaseType(), collection);
                        if (schemaType.getBaseType().isBuiltinType()) {
                            arrayList3.add(schemaType.getBaseType());
                        }
                    }
                    collection.add(schemaType);
                }
            }
            ArrayList arrayList4 = new ArrayList();
            arrayList4.add(XmlObject.type);
            StringBuffer stringBuffer = new StringBuffer();
            while (!arrayList4.isEmpty()) {
                SchemaType schemaType2 = (SchemaType) arrayList4.remove(arrayList4.size() - 1);
                if (schemaType2 == null) {
                    stringBuffer.setLength(Math.max(0, stringBuffer.length() - 2));
                } else {
                    System.out.println(new StringBuffer().append((Object) stringBuffer).append("+-").append(QNameHelper.readable(schemaType2, hashMap)).append(notes(schemaType2)).toString());
                    Collection collection2 = (Collection) hashMap2.get(schemaType2);
                    if (collection2 != null && collection2.size() > 0) {
                        stringBuffer.append((arrayList4.size() == 0 || arrayList4.get(arrayList4.size() - 1) == null) ? "  " : "| ");
                        arrayList4.add(null);
                        arrayList4.addAll(collection2);
                    }
                }
            }
        } catch (XmlException e2) {
            System.out.println(new StringBuffer().append("Schema invalid:").append(z4 ? " couldn't recover from errors" : "").toString());
            if (arrayList2.isEmpty()) {
                System.out.println(e2.getMessage());
                return;
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                System.out.println(it2.next());
            }
        }
    }

    private static String notes(SchemaType schemaType) {
        if (schemaType.isBuiltinType()) {
            return " (builtin)";
        }
        if (schemaType.isSimpleType()) {
            int simpleVariety = schemaType.getSimpleVariety();
            return simpleVariety != 2 ? simpleVariety != 3 ? schemaType.getEnumerationValues() != null ? " (enumeration)" : "" : " (list)" : " (union)";
        }
        int contentType = schemaType.getContentType();
        return contentType != 2 ? contentType != 4 ? "" : " (mixed)" : " (complex)";
    }

    private static void noteNamespace(Map map, SchemaType schemaType) {
        String namespace = QNameHelper.namespace(schemaType);
        if (namespace.equals("") || map.containsKey(namespace)) {
            return;
        }
        String suggestPrefix = QNameHelper.suggestPrefix(namespace);
        int i = 0;
        String str = suggestPrefix;
        while (map.containsValue(str)) {
            str = new StringBuffer().append(suggestPrefix).append(i).toString();
            i++;
        }
        map.put(namespace, str);
        System.out.println(new StringBuffer().append(Sax2Dom.XMLNS_STRING).append(str).append("=\"").append(namespace).append("\"").toString());
    }
}
