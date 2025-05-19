package org.dom4j.tree;

import java.util.Collections;
import java.util.Map;
import org.dom4j.Element;
import org.dom4j.Node;

/* loaded from: classes5.dex */
public class FlyweightProcessingInstruction extends AbstractProcessingInstruction {
    protected String target;
    protected String text;
    protected Map values;

    public FlyweightProcessingInstruction() {
    }

    public FlyweightProcessingInstruction(String str, Map map) {
        this.target = str;
        this.values = map;
        this.text = toString(map);
    }

    public FlyweightProcessingInstruction(String str, String str2) {
        this.target = str;
        this.text = str2;
        this.values = parseValues(str2);
    }

    @Override // org.dom4j.ProcessingInstruction
    public String getTarget() {
        return this.target;
    }

    public void setTarget(String str) {
        throw new UnsupportedOperationException("This PI is read-only and cannot be modified");
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public String getText() {
        return this.text;
    }

    @Override // org.dom4j.ProcessingInstruction
    public String getValue(String str) {
        String str2 = (String) this.values.get(str);
        return str2 == null ? "" : str2;
    }

    @Override // org.dom4j.ProcessingInstruction
    public Map getValues() {
        return Collections.unmodifiableMap(this.values);
    }

    @Override // org.dom4j.tree.AbstractNode
    protected Node createXPathResult(Element element) {
        return new DefaultProcessingInstruction(element, getTarget(), getText());
    }
}
