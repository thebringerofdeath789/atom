package org.apache.xmlbeans;

/* loaded from: classes5.dex */
public interface SchemaLocalElement extends SchemaField, SchemaAnnotated {
    boolean blockExtension();

    boolean blockRestriction();

    boolean blockSubstitution();

    SchemaIdentityConstraint[] getIdentityConstraints();

    boolean isAbstract();
}
