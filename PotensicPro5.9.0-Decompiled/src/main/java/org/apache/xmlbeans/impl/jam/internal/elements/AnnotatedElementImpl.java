package org.apache.xmlbeans.impl.jam.internal.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.xmlbeans.impl.jam.JAnnotation;
import org.apache.xmlbeans.impl.jam.JAnnotationValue;
import org.apache.xmlbeans.impl.jam.JComment;
import org.apache.xmlbeans.impl.jam.annotation.AnnotationProxy;
import org.apache.xmlbeans.impl.jam.mutable.MAnnotatedElement;
import org.apache.xmlbeans.impl.jam.mutable.MAnnotation;
import org.apache.xmlbeans.impl.jam.mutable.MComment;

/* loaded from: classes5.dex */
public abstract class AnnotatedElementImpl extends ElementImpl implements MAnnotatedElement {
    private List mAllAnnotations;
    private MComment mComment;
    private Map mName2Annotation;

    protected AnnotatedElementImpl(ElementContext elementContext) {
        super(elementContext);
        this.mName2Annotation = null;
        this.mComment = null;
        this.mAllAnnotations = null;
    }

    protected AnnotatedElementImpl(ElementImpl elementImpl) {
        super(elementImpl);
        this.mName2Annotation = null;
        this.mComment = null;
        this.mAllAnnotations = null;
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotatedElement
    public JAnnotation[] getAnnotations() {
        return getMutableAnnotations();
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotatedElement
    public JAnnotation getAnnotation(Class cls) {
        return getMutableAnnotation(cls.getName());
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotatedElement
    public JAnnotation getAnnotation(String str) {
        return getMutableAnnotation(str);
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotatedElement
    public JAnnotationValue getAnnotationValue(String str) {
        if (this.mName2Annotation == null) {
            return null;
        }
        String trim = str.trim();
        int indexOf = trim.indexOf(64);
        if (indexOf == -1 || indexOf == trim.length() - 1) {
            JAnnotation annotation = getAnnotation(trim);
            if (annotation == null) {
                return null;
            }
            return annotation.getValue("value");
        }
        JAnnotation annotation2 = getAnnotation(trim.substring(0, indexOf));
        if (annotation2 == null) {
            return null;
        }
        return annotation2.getValue(trim.substring(indexOf + 1));
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotatedElement
    public Object getAnnotationProxy(Class cls) {
        return getEditableProxy(cls);
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotatedElement
    public JComment getComment() {
        return getMutableComment();
    }

    @Override // org.apache.xmlbeans.impl.jam.JAnnotatedElement
    public JAnnotation[] getAllJavadocTags() {
        List list = this.mAllAnnotations;
        if (list == null) {
            return NO_ANNOTATION;
        }
        JAnnotation[] jAnnotationArr = new JAnnotation[list.size()];
        this.mAllAnnotations.toArray(jAnnotationArr);
        return jAnnotationArr;
    }

    public AnnotationProxy getEditableProxy(Class cls) {
        MAnnotation mutableAnnotation;
        if (this.mName2Annotation == null || (mutableAnnotation = getMutableAnnotation(cls.getName())) == null) {
            return null;
        }
        return (AnnotationProxy) mutableAnnotation.getProxy();
    }

    public void removeAnnotation(MAnnotation mAnnotation) {
        Map map = this.mName2Annotation;
        if (map != null) {
            map.values().remove(mAnnotation);
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MAnnotatedElement
    public MAnnotation[] getMutableAnnotations() {
        Map map = this.mName2Annotation;
        if (map == null) {
            return new MAnnotation[0];
        }
        MAnnotation[] mAnnotationArr = new MAnnotation[map.values().size()];
        this.mName2Annotation.values().toArray(mAnnotationArr);
        return mAnnotationArr;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MAnnotatedElement
    public MAnnotation getMutableAnnotation(String str) {
        if (this.mName2Annotation == null) {
            return null;
        }
        return (MAnnotation) this.mName2Annotation.get(str.trim());
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MAnnotatedElement
    public MAnnotation findOrCreateAnnotation(String str) {
        MAnnotation mutableAnnotation = getMutableAnnotation(str);
        if (mutableAnnotation != null) {
            return mutableAnnotation;
        }
        AnnotationImpl annotationImpl = new AnnotationImpl(getContext(), getContext().createAnnotationProxy(str), str);
        if (this.mName2Annotation == null) {
            this.mName2Annotation = new HashMap();
        }
        this.mName2Annotation.put(annotationImpl.getQualifiedName(), annotationImpl);
        return annotationImpl;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MAnnotatedElement
    public MAnnotation addLiteralAnnotation(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null tagname");
        }
        String trim = str.trim();
        AnnotationImpl annotationImpl = new AnnotationImpl(getContext(), getContext().createAnnotationProxy(trim), trim);
        if (this.mAllAnnotations == null) {
            this.mAllAnnotations = new ArrayList();
        }
        this.mAllAnnotations.add(annotationImpl);
        if (getMutableAnnotation(trim) == null) {
            if (this.mName2Annotation == null) {
                this.mName2Annotation = new HashMap();
            }
            this.mName2Annotation.put(trim, annotationImpl);
        }
        return annotationImpl;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MAnnotatedElement
    public MComment getMutableComment() {
        return this.mComment;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MAnnotatedElement
    public MComment createComment() {
        CommentImpl commentImpl = new CommentImpl(this);
        this.mComment = commentImpl;
        return commentImpl;
    }

    @Override // org.apache.xmlbeans.impl.jam.mutable.MAnnotatedElement
    public void removeComment() {
        this.mComment = null;
    }

    protected void addAnnotation(JAnnotation jAnnotation) {
        Map map = this.mName2Annotation;
        if (map == null) {
            HashMap hashMap = new HashMap();
            this.mName2Annotation = hashMap;
            hashMap.put(jAnnotation.getQualifiedName(), jAnnotation);
        } else if (map.get(jAnnotation.getQualifiedName()) == null) {
            this.mName2Annotation.put(jAnnotation.getQualifiedName(), jAnnotation);
        }
        if (this.mAllAnnotations == null) {
            this.mAllAnnotations = new ArrayList();
        }
        this.mAllAnnotations.add(jAnnotation);
    }

    public MAnnotation addAnnotationForProxy(Class cls, AnnotationProxy annotationProxy) {
        String name = cls.getName();
        MAnnotation mutableAnnotation = getMutableAnnotation(name);
        if (mutableAnnotation != null) {
            return mutableAnnotation;
        }
        AnnotationImpl annotationImpl = new AnnotationImpl(getContext(), annotationProxy, name);
        if (this.mName2Annotation == null) {
            this.mName2Annotation = new HashMap();
        }
        this.mName2Annotation.put(annotationImpl.getQualifiedName(), annotationImpl);
        return annotationImpl;
    }
}
