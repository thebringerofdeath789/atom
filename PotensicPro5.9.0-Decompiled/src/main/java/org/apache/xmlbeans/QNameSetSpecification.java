package org.apache.xmlbeans;

import aavax.xml.namespace.QName;
import java.util.Set;

/* loaded from: classes5.dex */
public interface QNameSetSpecification {
    boolean contains(QName qName);

    boolean containsAll(QNameSetSpecification qNameSetSpecification);

    Set excludedQNamesInIncludedURIs();

    Set excludedURIs();

    Set includedQNamesInExcludedURIs();

    Set includedURIs();

    QNameSet intersect(QNameSetSpecification qNameSetSpecification);

    QNameSet inverse();

    boolean isAll();

    boolean isDisjoint(QNameSetSpecification qNameSetSpecification);

    boolean isEmpty();

    QNameSet union(QNameSetSpecification qNameSetSpecification);
}
