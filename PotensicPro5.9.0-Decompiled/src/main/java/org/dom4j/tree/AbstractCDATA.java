package org.dom4j.tree;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import org.dom4j.CDATA;
import org.dom4j.Visitor;

/* loaded from: classes5.dex */
public abstract class AbstractCDATA extends AbstractCharacterData implements CDATA {
    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public short getNodeType() {
        return (short) 4;
    }

    public String toString() {
        return new StringBuffer().append(super.toString()).append(" [CDATA: \"").append(getText()).append("\"]").toString();
    }

    @Override // org.dom4j.Node
    public String asXML() {
        StringWriter stringWriter = new StringWriter();
        try {
            write(stringWriter);
        } catch (IOException unused) {
        }
        return stringWriter.toString();
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public void write(Writer writer) throws IOException {
        writer.write("<![CDATA[");
        if (getText() != null) {
            writer.write(getText());
        }
        writer.write("]]>");
    }

    @Override // org.dom4j.Node
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
