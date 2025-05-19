package org.jdom;

import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.jdom.output.XMLOutputter;

/* loaded from: classes5.dex */
public class Comment extends Content {
    private static final String CVS_ID = "@(#) $RCSfile: Comment.java,v $ $Revision: 1.32 $ $Date: 2004/02/11 21:12:43 $ $Name: jdom_1_0 $";
    protected String text;

    protected Comment() {
    }

    public Comment(String str) {
        setText(str);
    }

    @Override // org.jdom.Content
    public String getValue() {
        return this.text;
    }

    public String getText() {
        return this.text;
    }

    public Comment setText(String str) {
        String checkCommentData = Verifier.checkCommentData(str);
        if (checkCommentData != null) {
            throw new IllegalDataException(str, JamXmlElements.COMMENT, checkCommentData);
        }
        this.text = str;
        return this;
    }

    public String toString() {
        return new StringBuffer().append("[Comment: ").append(new XMLOutputter().outputString(this)).append("]").toString();
    }
}
