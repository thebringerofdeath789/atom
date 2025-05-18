package com.lib.bean;

import java.io.FileOutputStream;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/* loaded from: classes2.dex */
public class XmlWriter {
    private Document document;
    private String path;
    private Element rootElement;
    private XMLOutputter xmlWriter;

    public XmlWriter(String str) throws Exception {
        this.path = str;
        Document build = new SAXBuilder().build(str);
        this.document = build;
        this.rootElement = build.getRootElement();
        Format prettyFormat = Format.getPrettyFormat();
        prettyFormat.setEncoding("utf-8");
        prettyFormat.setIndent("    ");
        this.xmlWriter = new XMLOutputter(prettyFormat);
    }

    public void writeString(String str, String str2) throws Exception {
        Element element = new Element("string");
        element.setAttribute("name", str);
        element.setText(str2);
        this.rootElement.addContent(element);
        this.xmlWriter.output(this.document, new FileOutputStream(this.path));
    }

    public void clean() throws Exception {
        this.rootElement.removeContent();
        this.xmlWriter.output(this.document, new FileOutputStream(this.path));
    }

    public static void createXmlFile(String str) throws Exception {
        new XMLOutputter().output(new Document(new Element("resources")), new FileOutputStream(str));
    }
}