package org.jdom.filter;

/* loaded from: classes5.dex */
final class AndFilter extends AbstractFilter {
    private static final String CVS_ID = "@(#) $RCSfile: AndFilter.java,v $ $Revision: 1.3 $ $Date: 2004/02/06 09:28:31 $";
    private Filter left;
    private Filter right;

    public AndFilter(Filter filter, Filter filter2) {
        if (filter == null || filter2 == null) {
            throw new IllegalArgumentException("null filter not allowed");
        }
        this.left = filter;
        this.right = filter2;
    }

    @Override // org.jdom.filter.AbstractFilter, org.jdom.filter.Filter
    public boolean matches(Object obj) {
        return this.left.matches(obj) && this.right.matches(obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AndFilter)) {
            return false;
        }
        AndFilter andFilter = (AndFilter) obj;
        return (this.left.equals(andFilter.left) && this.right.equals(andFilter.right)) || (this.left.equals(andFilter.right) && this.right.equals(andFilter.left));
    }

    public int hashCode() {
        return (this.left.hashCode() * 31) + this.right.hashCode();
    }

    public String toString() {
        return new StringBuffer(64).append("[AndFilter: ").append(this.left.toString()).append(",\n").append("            ").append(this.right.toString()).append("]").toString();
    }
}
