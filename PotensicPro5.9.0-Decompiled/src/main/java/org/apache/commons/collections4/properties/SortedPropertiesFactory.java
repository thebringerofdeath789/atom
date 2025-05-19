package org.apache.commons.collections4.properties;

/* loaded from: classes4.dex */
public class SortedPropertiesFactory extends AbstractPropertiesFactory<SortedProperties> {
    public static final SortedPropertiesFactory INSTANCE = new SortedPropertiesFactory();

    private SortedPropertiesFactory() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.properties.AbstractPropertiesFactory
    public SortedProperties createProperties() {
        return new SortedProperties();
    }
}
