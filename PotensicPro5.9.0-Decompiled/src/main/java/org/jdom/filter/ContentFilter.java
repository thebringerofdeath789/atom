package org.jdom.filter;

import org.jdom.CDATA;
import org.jdom.Comment;
import org.jdom.DocType;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.EntityRef;
import org.jdom.ProcessingInstruction;
import org.jdom.Text;

/* loaded from: classes5.dex */
public class ContentFilter extends AbstractFilter {
    public static final int CDATA = 2;
    public static final int COMMENT = 8;
    private static final String CVS_ID = "@(#) $RCSfile: ContentFilter.java,v $ $Revision: 1.14 $ $Date: 2004/08/31 04:56:07 $ $Name: jdom_1_0 $";
    public static final int DOCTYPE = 128;
    public static final int DOCUMENT = 64;
    public static final int ELEMENT = 1;
    public static final int ENTITYREF = 32;
    public static final int PI = 16;
    public static final int TEXT = 4;
    private int filterMask;

    public ContentFilter() {
        setDefaultMask();
    }

    public ContentFilter(boolean z) {
        if (z) {
            setDefaultMask();
        } else {
            int i = this.filterMask;
            this.filterMask = i & (~i);
        }
    }

    public ContentFilter(int i) {
        setFilterMask(i);
    }

    public int getFilterMask() {
        return this.filterMask;
    }

    public void setFilterMask(int i) {
        setDefaultMask();
        this.filterMask = i & this.filterMask;
    }

    public void setDefaultMask() {
        this.filterMask = 255;
    }

    public void setDocumentContent() {
        this.filterMask = 153;
    }

    public void setElementContent() {
        this.filterMask = 63;
    }

    public void setElementVisible(boolean z) {
        if (z) {
            this.filterMask |= 1;
        } else {
            this.filterMask &= -2;
        }
    }

    public void setCDATAVisible(boolean z) {
        if (z) {
            this.filterMask |= 2;
        } else {
            this.filterMask &= -3;
        }
    }

    public void setTextVisible(boolean z) {
        if (z) {
            this.filterMask |= 4;
        } else {
            this.filterMask &= -5;
        }
    }

    public void setCommentVisible(boolean z) {
        if (z) {
            this.filterMask |= 8;
        } else {
            this.filterMask &= -9;
        }
    }

    public void setPIVisible(boolean z) {
        if (z) {
            this.filterMask |= 16;
        } else {
            this.filterMask &= -17;
        }
    }

    public void setEntityRefVisible(boolean z) {
        if (z) {
            this.filterMask |= 32;
        } else {
            this.filterMask &= -33;
        }
    }

    public void setDocTypeVisible(boolean z) {
        if (z) {
            this.filterMask |= 128;
        } else {
            this.filterMask &= -129;
        }
    }

    @Override // org.jdom.filter.AbstractFilter, org.jdom.filter.Filter
    public boolean matches(Object obj) {
        return obj instanceof Element ? (this.filterMask & 1) != 0 : obj instanceof CDATA ? (this.filterMask & 2) != 0 : obj instanceof Text ? (this.filterMask & 4) != 0 : obj instanceof Comment ? (this.filterMask & 8) != 0 : obj instanceof ProcessingInstruction ? (this.filterMask & 16) != 0 : obj instanceof EntityRef ? (this.filterMask & 32) != 0 : obj instanceof Document ? (this.filterMask & 64) != 0 : (obj instanceof DocType) && (this.filterMask & 128) != 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ContentFilter) && this.filterMask == ((ContentFilter) obj).filterMask;
    }

    public int hashCode() {
        return this.filterMask;
    }
}
