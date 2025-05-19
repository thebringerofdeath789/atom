package org.xml.sax.helpers;

import java.util.Objects;
import org.xml.sax.Parser;

/* loaded from: classes6.dex */
public class ParserFactory {
    private ParserFactory() {
    }

    public static Parser makeParser() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NullPointerException, ClassCastException {
        String property = System.getProperty("org.xml.sax.parser");
        Objects.requireNonNull(property, "No value for sax.parser property");
        return makeParser(property);
    }

    public static Parser makeParser(String str) throws ClassNotFoundException, IllegalAccessException, InstantiationException, ClassCastException {
        return (Parser) NewInstance.newInstance(NewInstance.getClassLoader(), str);
    }
}
