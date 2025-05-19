package org.jdom;

/* loaded from: classes5.dex */
public class IllegalAddException extends IllegalArgumentException {
    private static final String CVS_ID = "@(#) $RCSfile: IllegalAddException.java,v $ $Revision: 1.25 $ $Date: 2004/02/06 09:28:30 $ $Name: jdom_1_0 $";

    IllegalAddException(Element element, Attribute attribute, String str) {
        super(new StringBuffer().append("The attribute \"").append(attribute.getQualifiedName()).append("\" could not be added to the element \"").append(element.getQualifiedName()).append("\": ").append(str).toString());
    }

    IllegalAddException(Element element, Element element2, String str) {
        super(new StringBuffer().append("The element \"").append(element2.getQualifiedName()).append("\" could not be added as a child of \"").append(element.getQualifiedName()).append("\": ").append(str).toString());
    }

    IllegalAddException(Element element, String str) {
        super(new StringBuffer().append("The element \"").append(element.getQualifiedName()).append("\" could not be added as the root of the document: ").append(str).toString());
    }

    IllegalAddException(Element element, ProcessingInstruction processingInstruction, String str) {
        super(new StringBuffer().append("The PI \"").append(processingInstruction.getTarget()).append("\" could not be added as content to \"").append(element.getQualifiedName()).append("\": ").append(str).toString());
    }

    IllegalAddException(ProcessingInstruction processingInstruction, String str) {
        super(new StringBuffer().append("The PI \"").append(processingInstruction.getTarget()).append("\" could not be added to the top level of the document: ").append(str).toString());
    }

    IllegalAddException(Element element, Comment comment, String str) {
        super(new StringBuffer().append("The comment \"").append(comment.getText()).append("\" could not be added as content to \"").append(element.getQualifiedName()).append("\": ").append(str).toString());
    }

    IllegalAddException(Element element, CDATA cdata, String str) {
        super(new StringBuffer().append("The CDATA \"").append(cdata.getText()).append("\" could not be added as content to \"").append(element.getQualifiedName()).append("\": ").append(str).toString());
    }

    IllegalAddException(Element element, Text text, String str) {
        super(new StringBuffer().append("The Text \"").append(text.getText()).append("\" could not be added as content to \"").append(element.getQualifiedName()).append("\": ").append(str).toString());
    }

    IllegalAddException(Comment comment, String str) {
        super(new StringBuffer().append("The comment \"").append(comment.getText()).append("\" could not be added to the top level of the document: ").append(str).toString());
    }

    IllegalAddException(Element element, EntityRef entityRef, String str) {
        super(new StringBuffer().append("The entity reference\"").append(entityRef.getName()).append("\" could not be added as content to \"").append(element.getQualifiedName()).append("\": ").append(str).toString());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    IllegalAddException(org.jdom.Element r5, org.jdom.Namespace r6, java.lang.String r7) {
        /*
            r4 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r1 = "The namespace xmlns"
            java.lang.StringBuffer r0 = r0.append(r1)
            java.lang.String r1 = r6.getPrefix()
            java.lang.String r2 = "="
            if (r1 == 0) goto L37
            java.lang.String r1 = r6.getPrefix()
            java.lang.String r3 = ""
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L20
            goto L37
        L20:
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            java.lang.String r3 = ":"
            r1.<init>(r3)
            java.lang.String r3 = r6.getPrefix()
            java.lang.StringBuffer r1 = r1.append(r3)
            java.lang.StringBuffer r1 = r1.append(r2)
            java.lang.String r2 = r1.toString()
        L37:
            java.lang.StringBuffer r0 = r0.append(r2)
            java.lang.String r1 = "\""
            java.lang.StringBuffer r0 = r0.append(r1)
            java.lang.String r6 = r6.getURI()
            java.lang.StringBuffer r6 = r0.append(r6)
            java.lang.String r0 = "\" could not be added as a namespace to \""
            java.lang.StringBuffer r6 = r6.append(r0)
            java.lang.String r5 = r5.getQualifiedName()
            java.lang.StringBuffer r5 = r6.append(r5)
            java.lang.String r6 = "\": "
            java.lang.StringBuffer r5 = r5.append(r6)
            java.lang.StringBuffer r5 = r5.append(r7)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jdom.IllegalAddException.<init>(org.jdom.Element, org.jdom.Namespace, java.lang.String):void");
    }

    IllegalAddException(DocType docType, String str) {
        super(new StringBuffer().append("The DOCTYPE ").append(docType.toString()).append(" could not be added to the document: ").append(str).toString());
    }

    public IllegalAddException(String str) {
        super(str);
    }
}
