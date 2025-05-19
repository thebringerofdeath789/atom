package org.apache.commons.beanutils;

import java.beans.IntrospectionException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;

/* loaded from: classes4.dex */
public class SuppressPropertiesBeanIntrospector implements BeanIntrospector {
    public static final SuppressPropertiesBeanIntrospector SUPPRESS_CLASS = new SuppressPropertiesBeanIntrospector(Collections.singleton(JamXmlElements.CLASS));
    private final Set<String> propertyNames;

    public SuppressPropertiesBeanIntrospector(Collection<String> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Property names must not be null!");
        }
        this.propertyNames = Collections.unmodifiableSet(new HashSet(collection));
    }

    public Set<String> getSuppressedProperties() {
        return this.propertyNames;
    }

    @Override // org.apache.commons.beanutils.BeanIntrospector
    public void introspect(IntrospectionContext introspectionContext) throws IntrospectionException {
        Iterator<String> it = getSuppressedProperties().iterator();
        while (it.hasNext()) {
            introspectionContext.removePropertyDescriptor(it.next());
        }
    }
}
