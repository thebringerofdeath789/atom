package org.apache.commons.collections4.properties;

import java.util.Properties;

/* loaded from: classes4.dex */
public class PropertiesFactory extends AbstractPropertiesFactory<Properties> {
    public static final PropertiesFactory INSTANCE = new PropertiesFactory();

    private PropertiesFactory() {
    }

    @Override // org.apache.commons.collections4.properties.AbstractPropertiesFactory
    protected Properties createProperties() {
        return new Properties();
    }
}
