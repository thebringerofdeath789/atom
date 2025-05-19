package org.apache.xmlbeans.impl.regex;

import java.util.HashMap;
import java.util.Map;
import org.apache.xmlbeans.impl.common.XMLChar;

/* loaded from: classes5.dex */
public class SchemaRegularExpression extends RegularExpression {
    static final Map knownPatterns = buildKnownPatternMap();

    private SchemaRegularExpression(String str) {
        super(str, "X");
    }

    public static RegularExpression forPattern(String str) {
        SchemaRegularExpression schemaRegularExpression = (SchemaRegularExpression) knownPatterns.get(str);
        return schemaRegularExpression != null ? schemaRegularExpression : new RegularExpression(str, "X");
    }

    private static Map buildKnownPatternMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("\\c+", new SchemaRegularExpression("\\c+") { // from class: org.apache.xmlbeans.impl.regex.SchemaRegularExpression.1
            @Override // org.apache.xmlbeans.impl.regex.RegularExpression
            public boolean matches(String str) {
                return XMLChar.isValidNmtoken(str);
            }
        });
        hashMap.put("\\i\\c*", new SchemaRegularExpression("\\i\\c*") { // from class: org.apache.xmlbeans.impl.regex.SchemaRegularExpression.2
            @Override // org.apache.xmlbeans.impl.regex.RegularExpression
            public boolean matches(String str) {
                return XMLChar.isValidName(str);
            }
        });
        hashMap.put("[\\i-[:]][\\c-[:]]*", new SchemaRegularExpression("[\\i-[:]][\\c-[:]]*") { // from class: org.apache.xmlbeans.impl.regex.SchemaRegularExpression.3
            @Override // org.apache.xmlbeans.impl.regex.RegularExpression
            public boolean matches(String str) {
                return XMLChar.isValidNCName(str);
            }
        });
        return hashMap;
    }
}
