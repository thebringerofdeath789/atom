package org.jdom.filter;

/* loaded from: classes5.dex */
public abstract class AbstractFilter implements Filter {
    private static final String CVS_ID = "@(#) $RCSfile: AbstractFilter.java,v $ $Revision: 1.5 $ $Date: 2004/02/27 11:32:58 $";

    @Override // org.jdom.filter.Filter
    public abstract boolean matches(Object obj);

    public Filter negate() {
        return new NegateFilter(this);
    }

    public Filter or(Filter filter) {
        return new OrFilter(this, filter);
    }

    public Filter and(Filter filter) {
        return new AndFilter(this, filter);
    }
}
