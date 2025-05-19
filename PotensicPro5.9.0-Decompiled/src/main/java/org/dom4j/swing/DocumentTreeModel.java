package org.dom4j.swing;

import javax.swing.tree.DefaultTreeModel;
import org.dom4j.Document;

/* loaded from: classes5.dex */
public class DocumentTreeModel extends DefaultTreeModel {
    protected Document document;

    public DocumentTreeModel(Document document) {
        super(new BranchTreeNode(document));
        this.document = document;
    }

    public Document getDocument() {
        return this.document;
    }

    public void setDocument(Document document) {
        this.document = document;
        setRoot(new BranchTreeNode(document));
    }
}
