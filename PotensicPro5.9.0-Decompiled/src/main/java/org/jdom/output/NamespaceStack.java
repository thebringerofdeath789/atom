package org.jdom.output;

import java.util.Stack;
import org.jdom.Namespace;

/* loaded from: classes5.dex */
class NamespaceStack {
    private static final String CVS_ID = "@(#) $RCSfile: NamespaceStack.java,v $ $Revision: 1.13 $ $Date: 2004/02/06 09:28:32 $ $Name: jdom_1_0 $";
    private Stack prefixes = new Stack();
    private Stack uris = new Stack();

    NamespaceStack() {
    }

    public void push(Namespace namespace) {
        this.prefixes.push(namespace.getPrefix());
        this.uris.push(namespace.getURI());
    }

    public String pop() {
        String str = (String) this.prefixes.pop();
        this.uris.pop();
        return str;
    }

    public int size() {
        return this.prefixes.size();
    }

    public String getURI(String str) {
        int lastIndexOf = this.prefixes.lastIndexOf(str);
        if (lastIndexOf == -1) {
            return null;
        }
        return (String) this.uris.elementAt(lastIndexOf);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String property = System.getProperty("line.separator");
        stringBuffer.append(new StringBuffer("Stack: ").append(this.prefixes.size()).append(property).toString());
        for (int i = 0; i < this.prefixes.size(); i++) {
            stringBuffer.append(new StringBuffer(String.valueOf(String.valueOf(this.prefixes.elementAt(i)))).append("&").append(this.uris.elementAt(i)).append(property).toString());
        }
        return stringBuffer.toString();
    }
}
