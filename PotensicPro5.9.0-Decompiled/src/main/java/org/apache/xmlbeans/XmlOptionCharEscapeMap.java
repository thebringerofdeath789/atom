package org.apache.xmlbeans;

import java.util.HashMap;
import kotlin.text.Typography;

/* loaded from: classes5.dex */
public class XmlOptionCharEscapeMap {
    public static final int DECIMAL = 1;
    public static final int HEXADECIMAL = 2;
    public static final int PREDEF_ENTITY = 0;
    private static final HashMap _predefEntities;
    private HashMap _charMap = new HashMap();

    static {
        HashMap hashMap = new HashMap();
        _predefEntities = hashMap;
        hashMap.put(new Character(Typography.less), "&lt;");
        hashMap.put(new Character(Typography.greater), "&gt;");
        hashMap.put(new Character(Typography.amp), "&amp;");
        hashMap.put(new Character('\''), "&apos;");
        hashMap.put(new Character('\"'), "&quot;");
    }

    public boolean containsChar(char c) {
        return this._charMap.containsKey(new Character(c));
    }

    public void addMapping(char c, int i) throws XmlException {
        Character ch = new Character(c);
        if (i == 0) {
            String str = (String) _predefEntities.get(ch);
            if (str == null) {
                throw new XmlException("XmlOptionCharEscapeMap.addMapping(): the PREDEF_ENTITY mode can only be used for the following characters: <, >, &, \" and '");
            }
            this._charMap.put(ch, str);
            return;
        }
        if (i == 1) {
            this._charMap.put(ch, new StringBuffer().append("&#").append((int) c).append(";").toString());
        } else {
            if (i == 2) {
                this._charMap.put(ch, new StringBuffer().append("&#x").append(Integer.toHexString(c)).append(";").toString());
                return;
            }
            throw new XmlException("XmlOptionCharEscapeMap.addMapping(): mode must be PREDEF_ENTITY, DECIMAL or HEXADECIMAL");
        }
    }

    public void addMappings(char c, char c2, int i) throws XmlException {
        if (c > c2) {
            throw new XmlException("XmlOptionCharEscapeMap.addMappings(): ch1 must be <= ch2");
        }
        while (c <= c2) {
            addMapping(c, i);
            c = (char) (c + 1);
        }
    }

    public String getEscapedString(char c) {
        return (String) this._charMap.get(new Character(c));
    }
}
