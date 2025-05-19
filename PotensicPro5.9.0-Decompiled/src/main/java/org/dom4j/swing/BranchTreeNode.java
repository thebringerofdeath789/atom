package org.dom4j.swing;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.tree.TreeNode;
import org.dom4j.Branch;
import org.dom4j.CharacterData;
import org.dom4j.Node;

/* loaded from: classes5.dex */
public class BranchTreeNode extends LeafTreeNode {
    protected List children;

    @Override // org.dom4j.swing.LeafTreeNode
    public boolean getAllowsChildren() {
        return true;
    }

    public BranchTreeNode() {
    }

    public BranchTreeNode(Branch branch) {
        super(branch);
    }

    public BranchTreeNode(TreeNode treeNode, Branch branch) {
        super(treeNode, branch);
    }

    @Override // org.dom4j.swing.LeafTreeNode
    public Enumeration children() {
        return new Enumeration() { // from class: org.dom4j.swing.BranchTreeNode.1
            private int index = -1;

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return this.index + 1 < BranchTreeNode.this.getChildCount();
            }

            @Override // java.util.Enumeration
            public Object nextElement() {
                BranchTreeNode branchTreeNode = BranchTreeNode.this;
                int i = this.index + 1;
                this.index = i;
                return branchTreeNode.getChildAt(i);
            }
        };
    }

    @Override // org.dom4j.swing.LeafTreeNode
    public TreeNode getChildAt(int i) {
        return (TreeNode) getChildList().get(i);
    }

    @Override // org.dom4j.swing.LeafTreeNode
    public int getChildCount() {
        return getChildList().size();
    }

    @Override // org.dom4j.swing.LeafTreeNode
    public int getIndex(TreeNode treeNode) {
        return getChildList().indexOf(treeNode);
    }

    @Override // org.dom4j.swing.LeafTreeNode
    public boolean isLeaf() {
        return getXmlBranch().nodeCount() <= 0;
    }

    @Override // org.dom4j.swing.LeafTreeNode
    public String toString() {
        return this.xmlNode.getName();
    }

    protected List getChildList() {
        if (this.children == null) {
            this.children = createChildList();
        }
        return this.children;
    }

    protected List createChildList() {
        String text;
        Branch xmlBranch = getXmlBranch();
        int nodeCount = xmlBranch.nodeCount();
        ArrayList arrayList = new ArrayList(nodeCount);
        for (int i = 0; i < nodeCount; i++) {
            Node node = xmlBranch.node(i);
            if (!(node instanceof CharacterData) || ((text = node.getText()) != null && text.trim().length() > 0)) {
                arrayList.add(createChildTreeNode(node));
            }
        }
        return arrayList;
    }

    protected TreeNode createChildTreeNode(Node node) {
        if (node instanceof Branch) {
            return new BranchTreeNode(this, (Branch) node);
        }
        return new LeafTreeNode(this, node);
    }

    protected Branch getXmlBranch() {
        return (Branch) this.xmlNode;
    }
}
