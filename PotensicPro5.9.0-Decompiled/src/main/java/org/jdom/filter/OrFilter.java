package org.jdom.filter;

/* loaded from: classes5.dex */
final class OrFilter extends AbstractFilter {
    private static final String CVS_ID = "@(#) $RCSfile: OrFilter.java,v $ $Revision: 1.4 $ $Date: 2004/02/06 09:28:31 $";
    private Filter left;
    private Filter right;

    public OrFilter(Filter filter, Filter filter2) {
        if (filter == null || filter2 == null) {
            throw new IllegalArgumentException("null filter not allowed");
        }
        this.left = filter;
        this.right = filter2;
    }

    @Override // org.jdom.filter.AbstractFilter, org.jdom.filter.Filter
    public boolean matches(Object obj) {
        return this.left.matches(obj) || this.right.matches(obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrFilter)) {
            return false;
        }
        OrFilter orFilter = (OrFilter) obj;
        return (this.left.equals(orFilter.left) && this.right.equals(orFilter.right)) || (this.left.equals(orFilter.right) && this.right.equals(orFilter.left));
    }

    public int hashCode() {
        return (this.left.hashCode() * 31) + this.right.hashCode();
    }

    public String toString() {
        return new StringBuffer(64).append("[OrFilter: ").append(this.left.toString()).append(",\n").append("           ").append(this.right.toString()).append("]").toString();
    }
}
