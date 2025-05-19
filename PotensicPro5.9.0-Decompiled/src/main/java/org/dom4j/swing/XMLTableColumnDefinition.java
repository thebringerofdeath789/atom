package org.dom4j.swing;

import java.io.Serializable;
import org.dom4j.DocumentHelper;
import org.dom4j.XPath;

/* loaded from: classes5.dex */
public class XMLTableColumnDefinition implements Serializable {
    public static final int NODE_TYPE = 3;
    public static final int NUMBER_TYPE = 2;
    public static final int OBJECT_TYPE = 0;
    public static final int STRING_TYPE = 1;
    static /* synthetic */ Class class$java$lang$Number;
    static /* synthetic */ Class class$java$lang$Object;
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$org$dom4j$Node;
    private XPath columnNameXPath;
    private String name;
    private int type;
    private XPath xpath;

    public XMLTableColumnDefinition() {
    }

    public XMLTableColumnDefinition(String str, String str2, int i) {
        this.name = str;
        this.type = i;
        this.xpath = createXPath(str2);
    }

    public XMLTableColumnDefinition(String str, XPath xPath, int i) {
        this.name = str;
        this.xpath = xPath;
        this.type = i;
    }

    public XMLTableColumnDefinition(XPath xPath, XPath xPath2, int i) {
        this.xpath = xPath2;
        this.columnNameXPath = xPath;
        this.type = i;
    }

    public static int parseType(String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        if (str.equals("string")) {
            return 1;
        }
        if (str.equals("number")) {
            return 2;
        }
        return str.equals("node") ? 3 : 0;
    }

    public Class getColumnClass() {
        int i = this.type;
        if (i == 1) {
            Class cls = class$java$lang$String;
            if (cls != null) {
                return cls;
            }
            Class class$ = class$("java.lang.String");
            class$java$lang$String = class$;
            return class$;
        }
        if (i == 2) {
            Class cls2 = class$java$lang$Number;
            if (cls2 != null) {
                return cls2;
            }
            Class class$2 = class$("java.lang.Number");
            class$java$lang$Number = class$2;
            return class$2;
        }
        if (i == 3) {
            Class cls3 = class$org$dom4j$Node;
            if (cls3 != null) {
                return cls3;
            }
            Class class$3 = class$("org.dom4j.Node");
            class$org$dom4j$Node = class$3;
            return class$3;
        }
        Class cls4 = class$java$lang$Object;
        if (cls4 != null) {
            return cls4;
        }
        Class class$4 = class$("java.lang.Object");
        class$java$lang$Object = class$4;
        return class$4;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public Object getValue(Object obj) {
        int i = this.type;
        if (i == 1) {
            return this.xpath.valueOf(obj);
        }
        if (i == 2) {
            return this.xpath.numberValueOf(obj);
        }
        if (i == 3) {
            return this.xpath.selectSingleNode(obj);
        }
        return this.xpath.evaluate(obj);
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public XPath getXPath() {
        return this.xpath;
    }

    public void setXPath(XPath xPath) {
        this.xpath = xPath;
    }

    public XPath getColumnNameXPath() {
        return this.columnNameXPath;
    }

    public void setColumnNameXPath(XPath xPath) {
        this.columnNameXPath = xPath;
    }

    protected XPath createXPath(String str) {
        return DocumentHelper.createXPath(str);
    }

    protected void handleException(Exception exc) {
        System.out.println(new StringBuffer().append("Caught: ").append(exc).toString());
    }
}
