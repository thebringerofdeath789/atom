package org.dom4j.tree;

import java.util.Map;
import org.dom4j.Element;

/* loaded from: classes5.dex */
public class DefaultProcessingInstruction extends FlyweightProcessingInstruction {
    private Element parent;

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public boolean isReadOnly() {
        return false;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public boolean supportsParent() {
        return true;
    }

    public DefaultProcessingInstruction(String str, Map map) {
        super(str, map);
    }

    public DefaultProcessingInstruction(String str, String str2) {
        super(str, str2);
    }

    public DefaultProcessingInstruction(Element element, String str, String str2) {
        super(str, str2);
        this.parent = element;
    }

    @Override // org.dom4j.tree.FlyweightProcessingInstruction, org.dom4j.ProcessingInstruction
    public void setTarget(String str) {
        this.target = str;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public void setText(String str) {
        this.text = str;
        this.values = parseValues(str);
    }

    @Override // org.dom4j.tree.AbstractProcessingInstruction, org.dom4j.ProcessingInstruction
    public void setValues(Map map) {
        this.values = map;
        this.text = toString(map);
    }

    @Override // org.dom4j.tree.AbstractProcessingInstruction, org.dom4j.ProcessingInstruction
    public void setValue(String str, String str2) {
        this.values.put(str, str2);
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public Element getParent() {
        return this.parent;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public void setParent(Element element) {
        this.parent = element;
    }
}
