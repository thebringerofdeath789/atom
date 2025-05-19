package org.apache.commons.collections.set;

import java.util.Set;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.collection.TransformedCollection;

/* loaded from: classes4.dex */
public class TransformedSet extends TransformedCollection implements Set {
    private static final long serialVersionUID = 306127383500410386L;

    public static Set decorate(Set set, Transformer transformer) {
        return new TransformedSet(set, transformer);
    }

    protected TransformedSet(Set set, Transformer transformer) {
        super(set, transformer);
    }
}
