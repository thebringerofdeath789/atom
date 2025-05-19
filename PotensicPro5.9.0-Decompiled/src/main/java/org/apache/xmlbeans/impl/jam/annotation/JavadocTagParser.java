package org.apache.xmlbeans.impl.jam.annotation;

import com.sun.javadoc.SourcePosition;
import com.sun.javadoc.Tag;
import org.apache.xmlbeans.impl.jam.JClass;
import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;
import org.apache.xmlbeans.impl.jam.mutable.MAnnotatedElement;
import org.apache.xmlbeans.impl.jam.mutable.MAnnotation;
import org.apache.xmlbeans.impl.jam.mutable.MSourcePosition;
import org.apache.xmlbeans.impl.jam.provider.JamLogger;
import org.apache.xmlbeans.impl.jam.provider.JamServiceContext;

/* loaded from: classes5.dex */
public abstract class JavadocTagParser {
    private JamServiceContext mContext = null;
    private boolean mAddSingleValueMembers = false;

    public abstract void parse(MAnnotatedElement mAnnotatedElement, Tag tag);

    public void setAddSingleValueMembers(boolean z) {
        this.mAddSingleValueMembers = z;
    }

    public void init(JamServiceContext jamServiceContext) {
        if (jamServiceContext == null) {
            throw new IllegalArgumentException("null logger");
        }
        if (this.mContext != null) {
            throw new IllegalStateException("JavadocTagParser.init() called twice");
        }
        this.mContext = jamServiceContext;
    }

    protected MAnnotation[] createAnnotations(MAnnotatedElement mAnnotatedElement, Tag tag) {
        String substring = tag.name().trim().substring(1);
        MAnnotation mutableAnnotation = mAnnotatedElement.getMutableAnnotation(substring);
        if (mutableAnnotation == null) {
            mutableAnnotation = mAnnotatedElement.findOrCreateAnnotation(substring);
            setPosition(mutableAnnotation, tag);
        }
        MAnnotation addLiteralAnnotation = mAnnotatedElement.addLiteralAnnotation(substring);
        setPosition(addLiteralAnnotation, tag);
        MAnnotation[] mAnnotationArr = {addLiteralAnnotation, mutableAnnotation};
        if (this.mAddSingleValueMembers) {
            setSingleValueText(mAnnotationArr, tag);
        }
        return mAnnotationArr;
    }

    protected void setValue(MAnnotation[] mAnnotationArr, String str, String str2) {
        String trim = str2.trim();
        String trim2 = str.trim();
        for (int i = 0; i < mAnnotationArr.length; i++) {
            if (mAnnotationArr[i].getValue(trim2) == null) {
                mAnnotationArr[i].setSimpleValue(trim2, trim, getStringType());
            }
        }
    }

    protected JamLogger getLogger() {
        return this.mContext.getLogger();
    }

    protected JClass getStringType() {
        return ((ElementContext) this.mContext).getClassLoader().loadClass("java.lang.String");
    }

    protected void setSingleValueText(MAnnotation[] mAnnotationArr, Tag tag) {
        String text = tag.text();
        for (MAnnotation mAnnotation : mAnnotationArr) {
            mAnnotation.setSimpleValue("value", text, getStringType());
        }
    }

    private void setPosition(MAnnotation mAnnotation, Tag tag) {
        SourcePosition position = tag.position();
        if (position != null) {
            MSourcePosition createSourcePosition = mAnnotation.createSourcePosition();
            createSourcePosition.setLine(position.line());
            createSourcePosition.setColumn(position.column());
            if (position.file() != null) {
                createSourcePosition.setSourceURI(position.file().toURI());
            }
        }
    }
}
