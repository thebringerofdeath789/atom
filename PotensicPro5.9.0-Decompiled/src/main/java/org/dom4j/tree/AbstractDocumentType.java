package org.dom4j.tree;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import org.dom4j.DocumentType;
import org.dom4j.Element;
import org.dom4j.Visitor;

/* loaded from: classes5.dex */
public abstract class AbstractDocumentType extends AbstractNode implements DocumentType {
    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public short getNodeType() {
        return (short) 10;
    }

    @Override // org.dom4j.Node
    public String getPath(Element element) {
        return "";
    }

    @Override // org.dom4j.Node
    public String getUniquePath(Element element) {
        return "";
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public String getName() {
        return getElementName();
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public void setName(String str) {
        setElementName(str);
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public String getText() {
        List internalDeclarations = getInternalDeclarations();
        if (internalDeclarations == null || internalDeclarations.size() <= 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = internalDeclarations.iterator();
        if (it.hasNext()) {
            stringBuffer.append(it.next().toString());
            while (it.hasNext()) {
                Object next = it.next();
                stringBuffer.append("\n");
                stringBuffer.append(next.toString());
            }
        }
        return stringBuffer.toString();
    }

    public String toString() {
        return new StringBuffer().append(super.toString()).append(" [DocumentType: ").append(asXML()).append("]").toString();
    }

    @Override // org.dom4j.Node
    public String asXML() {
        boolean z;
        StringBuffer stringBuffer = new StringBuffer("<!DOCTYPE ");
        stringBuffer.append(getElementName());
        String publicID = getPublicID();
        if (publicID == null || publicID.length() <= 0) {
            z = false;
        } else {
            stringBuffer.append(" PUBLIC \"");
            stringBuffer.append(publicID);
            stringBuffer.append("\"");
            z = true;
        }
        String systemID = getSystemID();
        if (systemID != null && systemID.length() > 0) {
            if (!z) {
                stringBuffer.append(" SYSTEM");
            }
            stringBuffer.append(" \"");
            stringBuffer.append(systemID);
            stringBuffer.append("\"");
        }
        stringBuffer.append(">");
        return stringBuffer.toString();
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public void write(Writer writer) throws IOException {
        boolean z;
        writer.write("<!DOCTYPE ");
        writer.write(getElementName());
        String publicID = getPublicID();
        if (publicID == null || publicID.length() <= 0) {
            z = false;
        } else {
            writer.write(" PUBLIC \"");
            writer.write(publicID);
            writer.write("\"");
            z = true;
        }
        String systemID = getSystemID();
        if (systemID != null && systemID.length() > 0) {
            if (!z) {
                writer.write(" SYSTEM");
            }
            writer.write(" \"");
            writer.write(systemID);
            writer.write("\"");
        }
        List internalDeclarations = getInternalDeclarations();
        if (internalDeclarations != null && internalDeclarations.size() > 0) {
            writer.write(" [");
            for (Object obj : internalDeclarations) {
                writer.write("\n  ");
                writer.write(obj.toString());
            }
            writer.write("\n]");
        }
        writer.write(">");
    }

    @Override // org.dom4j.Node
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
