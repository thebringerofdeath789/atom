package com.lib.bean;

import com.lib.LanguageType;
import java.io.File;

/* loaded from: classes2.dex */
public class LanguageWriter {
    private int column;
    private String content;
    private LanguageType type;
    private XmlReader xmlReader;
    private XmlWriter xmlWriter;

    public LanguageWriter(LanguageType languageType) {
        this.type = languageType;
    }

    public int getColumn() {
        return this.column;
    }

    public void setColumn(int i) {
        this.column = i;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void init(String str) throws Exception {
        File file = new File(str + File.separator + this.type.xmlName);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file.getAbsolutePath() + File.separator + "strings.xml");
        if (file2.exists()) {
            file2.delete();
        }
        if (!file2.exists()) {
            XmlWriter.createXmlFile(file2.getAbsolutePath());
        }
        this.xmlWriter = new XmlWriter(file2.getAbsolutePath());
        this.xmlReader = new XmlReader(file2.getAbsolutePath());
    }

    public void write(String str, String str2) throws Exception {
        if (this.xmlReader.isContain(str) || str2 == null || str2.length() <= 0) {
            return;
        }
        this.xmlWriter.writeString(str, str2);
    }

    public String getExcelHead() {
        return this.type.excelHead;
    }

    public LanguageType getType() {
        return this.type;
    }
}
