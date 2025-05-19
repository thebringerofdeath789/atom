package org.dom4j.tree;

import java.io.IOException;
import java.io.Writer;
import org.dom4j.Comment;
import org.dom4j.Element;
import org.dom4j.Visitor;

/* loaded from: classes5.dex */
public abstract class AbstractComment extends AbstractCharacterData implements Comment {
    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public short getNodeType() {
        return (short) 8;
    }

    @Override // org.dom4j.tree.AbstractCharacterData, org.dom4j.Node
    public String getPath(Element element) {
        Element parent = getParent();
        return (parent == null || parent == element) ? "comment()" : new StringBuffer().append(parent.getPath(element)).append("/comment()").toString();
    }

    @Override // org.dom4j.tree.AbstractCharacterData, org.dom4j.Node
    public String getUniquePath(Element element) {
        Element parent = getParent();
        return (parent == null || parent == element) ? "comment()" : new StringBuffer().append(parent.getUniquePath(element)).append("/comment()").toString();
    }

    public String toString() {
        return new StringBuffer().append(super.toString()).append(" [Comment: \"").append(getText()).append("\"]").toString();
    }

    @Override // org.dom4j.Node
    public String asXML() {
        return new StringBuffer().append("<!--").append(getText()).append("-->").toString();
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public void write(Writer writer) throws IOException {
        writer.write("<!--");
        writer.write(getText());
        writer.write("-->");
    }

    @Override // org.dom4j.Node
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
