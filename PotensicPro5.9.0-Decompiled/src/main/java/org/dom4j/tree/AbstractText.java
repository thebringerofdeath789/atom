package org.dom4j.tree;

import java.io.IOException;
import java.io.Writer;
import org.dom4j.Text;
import org.dom4j.Visitor;

/* loaded from: classes5.dex */
public abstract class AbstractText extends AbstractCharacterData implements Text {
    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public short getNodeType() {
        return (short) 3;
    }

    public String toString() {
        return new StringBuffer().append(super.toString()).append(" [Text: \"").append(getText()).append("\"]").toString();
    }

    @Override // org.dom4j.Node
    public String asXML() {
        return getText();
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public void write(Writer writer) throws IOException {
        writer.write(getText());
    }

    @Override // org.dom4j.Node
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
