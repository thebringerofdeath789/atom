package org.dom4j;

/* loaded from: classes5.dex */
public class IllegalAddException extends IllegalArgumentException {
    public IllegalAddException(String str) {
        super(str);
    }

    public IllegalAddException(Element element, Node node, String str) {
        super(new StringBuffer().append("The node \"").append(node.toString()).append("\" could not be added to the element \"").append(element.getQualifiedName()).append("\" because: ").append(str).toString());
    }

    public IllegalAddException(Branch branch, Node node, String str) {
        super(new StringBuffer().append("The node \"").append(node.toString()).append("\" could not be added to the branch \"").append(branch.getName()).append("\" because: ").append(str).toString());
    }
}
