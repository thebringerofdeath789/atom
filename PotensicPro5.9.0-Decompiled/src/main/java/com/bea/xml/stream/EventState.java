package com.bea.xml.stream;

import aavax.xml.namespace.QName;
import com.bea.xml.stream.util.ElementTypeNames;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
public class EventState {
    private List attributes;
    private String data;
    private String extraData;
    private List namespaces;
    private QName qname;
    private int type;

    public EventState() {
    }

    public EventState(int i) {
        this.type = i;
        this.attributes = new ArrayList();
        this.namespaces = new ArrayList();
    }

    public void clear() {
        this.qname = null;
        this.attributes = new ArrayList();
        this.namespaces = new ArrayList();
        this.data = null;
        this.extraData = null;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }

    public QName getName() {
        return this.qname;
    }

    public String getLocalName() {
        return this.qname.getLocalPart();
    }

    public String getPrefix() {
        return this.qname.getPrefix();
    }

    public String getNamespaceURI() {
        return this.qname.getNamespaceURI();
    }

    public void setName(QName qName) {
        this.qname = qName;
    }

    public void setAttributes(List list) {
        this.attributes = list;
    }

    public void addAttribute(Object obj) {
        this.attributes.add(obj);
    }

    public void addNamespace(Object obj) {
        this.namespaces.add(obj);
    }

    public List getAttributes() {
        return this.attributes;
    }

    public void setNamespaces(List list) {
        this.namespaces = list;
    }

    public List getNamespaces() {
        return this.namespaces;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String str) {
        this.data = str;
    }

    public String getExtraData() {
        return this.extraData;
    }

    public void setExtraData(String str) {
        this.extraData = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new StringBuffer().append("[").append(ElementTypeNames.getEventTypeString(this.type)).append("]").toString());
        if (this.qname != null) {
            stringBuffer.append(new StringBuffer().append("[name='").append(this.qname).append("']").toString());
        }
        Iterator it = this.namespaces.iterator();
        while (it.hasNext()) {
            stringBuffer.append(new StringBuffer().append(it.next()).append(StringUtils.SPACE).toString());
        }
        Iterator it2 = this.attributes.iterator();
        while (it2.hasNext()) {
            stringBuffer.append(new StringBuffer().append(it2.next()).append(StringUtils.SPACE).toString());
        }
        if (this.data != null) {
            stringBuffer.append(new StringBuffer().append(",data=[").append(this.data).append("]").toString());
        }
        if (this.extraData != null) {
            stringBuffer.append(new StringBuffer().append(",extradata=[").append(this.extraData).append("]").toString());
        }
        return stringBuffer.toString();
    }
}
