package org.dom4j.tree;

import org.dom4j.CharacterData;
import org.dom4j.Element;

/* loaded from: classes5.dex */
public abstract class AbstractCharacterData extends AbstractNode implements CharacterData {
    @Override // org.dom4j.Node
    public String getPath(Element element) {
        Element parent = getParent();
        return (parent == null || parent == element) ? "text()" : new StringBuffer().append(parent.getPath(element)).append("/text()").toString();
    }

    @Override // org.dom4j.Node
    public String getUniquePath(Element element) {
        Element parent = getParent();
        return (parent == null || parent == element) ? "text()" : new StringBuffer().append(parent.getUniquePath(element)).append("/text()").toString();
    }

    @Override // org.dom4j.CharacterData
    public void appendText(String str) {
        setText(new StringBuffer().append(getText()).append(str).toString());
    }
}
