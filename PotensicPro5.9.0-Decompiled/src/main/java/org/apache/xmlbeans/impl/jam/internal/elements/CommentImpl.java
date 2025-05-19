package org.apache.xmlbeans.impl.jam.internal.elements;

import org.apache.xmlbeans.impl.jam.mutable.MComment;
import org.apache.xmlbeans.impl.jam.visitor.JVisitor;
import org.apache.xmlbeans.impl.jam.visitor.MVisitor;

/* loaded from: classes5.dex */
public final class CommentImpl extends ElementImpl implements MComment {
    private String mText;

    CommentImpl(ElementImpl elementImpl) {
        super(elementImpl);
        this.mText = null;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MComment
    public void setText(String str) {
        this.mText = str;
    }

    @Override // org.apache.xmlbeans.impl.jam.JComment
    public String getText() {
        String str = this.mText;
        return str == null ? "" : str;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MElement
    public void accept(MVisitor mVisitor) {
        mVisitor.visit(this);
    }

    @Override // org.apache.xmlbeans.impl.jam.JElement
    public void accept(JVisitor jVisitor) {
        jVisitor.visit(this);
    }

    @Override // org.apache.xmlbeans.impl.jam.JElement
    public String getQualifiedName() {
        return new StringBuffer().append(getParent().getQualifiedName()).append(".{comment}").toString();
    }
}
