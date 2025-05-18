package com.lib.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/* loaded from: classes2.dex */
public class XmlReader {
    private Document document;
    private String path;
    private Element rootElement;
    private List<XmlCell> xmlCells = new ArrayList();

    public XmlReader(String str) throws Exception {
        this.path = str;
        Document build = new SAXBuilder().build(str);
        this.document = build;
        Element rootElement = build.getRootElement();
        this.rootElement = rootElement;
        List children = rootElement.getChildren("string");
        for (int i = 0; i < children.size(); i++) {
            Element element = (Element) children.get(i);
            this.xmlCells.add(new XmlCell(element.getAttribute("name").getValue(), element.getText()));
        }
    }

    public boolean isContain(String str) {
        Iterator<XmlCell> it = this.xmlCells.iterator();
        while (it.hasNext()) {
            if (it.next().getKey().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public List<XmlCell> getCells() {
        return this.xmlCells;
    }
}