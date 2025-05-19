package org.dom4j.tree;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Element;
import org.dom4j.ProcessingInstruction;
import org.dom4j.Visitor;

/* loaded from: classes5.dex */
public abstract class AbstractProcessingInstruction extends AbstractNode implements ProcessingInstruction {
    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public short getNodeType() {
        return (short) 7;
    }

    @Override // org.dom4j.ProcessingInstruction
    public boolean removeValue(String str) {
        return false;
    }

    @Override // org.dom4j.Node
    public String getPath(Element element) {
        Element parent = getParent();
        return (parent == null || parent == element) ? "processing-instruction()" : new StringBuffer().append(parent.getPath(element)).append("/processing-instruction()").toString();
    }

    @Override // org.dom4j.Node
    public String getUniquePath(Element element) {
        Element parent = getParent();
        return (parent == null || parent == element) ? "processing-instruction()" : new StringBuffer().append(parent.getUniquePath(element)).append("/processing-instruction()").toString();
    }

    public String toString() {
        return new StringBuffer().append(super.toString()).append(" [ProcessingInstruction: &").append(getName()).append(";]").toString();
    }

    @Override // org.dom4j.Node
    public String asXML() {
        return new StringBuffer().append("<?").append(getName()).append(StringUtils.SPACE).append(getText()).append("?>").toString();
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public void write(Writer writer) throws IOException {
        writer.write("<?");
        writer.write(getName());
        writer.write(StringUtils.SPACE);
        writer.write(getText());
        writer.write("?>");
    }

    @Override // org.dom4j.Node
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override // org.dom4j.ProcessingInstruction
    public void setValue(String str, String str2) {
        throw new UnsupportedOperationException("This PI is read-only and cannot be modified");
    }

    @Override // org.dom4j.ProcessingInstruction
    public void setValues(Map map) {
        throw new UnsupportedOperationException("This PI is read-only and cannot be modified");
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public String getName() {
        return getTarget();
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public void setName(String str) {
        setTarget(str);
    }

    protected String toString(Map map) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            stringBuffer.append(str);
            stringBuffer.append("=\"");
            stringBuffer.append(str2);
            stringBuffer.append("\" ");
        }
        stringBuffer.setLength(stringBuffer.length() - 1);
        return stringBuffer.toString();
    }

    protected Map parseValues(String str) {
        HashMap hashMap = new HashMap();
        StringTokenizer stringTokenizer = new StringTokenizer(str, " ='\"", true);
        while (stringTokenizer.hasMoreTokens()) {
            String name = getName(stringTokenizer);
            if (stringTokenizer.hasMoreTokens()) {
                hashMap.put(name, getValue(stringTokenizer));
            }
        }
        return hashMap;
    }

    private String getName(StringTokenizer stringTokenizer) {
        StringBuffer stringBuffer = new StringBuffer(stringTokenizer.nextToken());
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (nextToken.equals("=")) {
                break;
            }
            stringBuffer.append(nextToken);
        }
        return stringBuffer.toString().trim();
    }

    private String getValue(StringTokenizer stringTokenizer) {
        String nextToken = stringTokenizer.nextToken();
        StringBuffer stringBuffer = new StringBuffer();
        while (stringTokenizer.hasMoreTokens() && !nextToken.equals("'") && !nextToken.equals("\"")) {
            nextToken = stringTokenizer.nextToken();
        }
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken2 = stringTokenizer.nextToken();
            if (nextToken.equals(nextToken2)) {
                break;
            }
            stringBuffer.append(nextToken2);
        }
        return stringBuffer.toString();
    }
}
