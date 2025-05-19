package org.apache.xmlbeans.impl.piccolo.xml;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.lang3.CharEncoding;

/* loaded from: classes5.dex */
public class XMLDecoderFactory {
    private static HashMap decoders = new HashMap();

    static {
        UTF8XMLDecoder uTF8XMLDecoder = new UTF8XMLDecoder();
        ASCIIXMLDecoder aSCIIXMLDecoder = new ASCIIXMLDecoder();
        ISO8859_1XMLDecoder iSO8859_1XMLDecoder = new ISO8859_1XMLDecoder();
        UnicodeBigXMLDecoder unicodeBigXMLDecoder = new UnicodeBigXMLDecoder();
        UnicodeLittleXMLDecoder unicodeLittleXMLDecoder = new UnicodeLittleXMLDecoder();
        decoders.put("UTF-8", uTF8XMLDecoder);
        decoders.put(InternalZipConstants.CHARSET_UTF8, uTF8XMLDecoder);
        decoders.put("US-ASCII", aSCIIXMLDecoder);
        decoders.put("ASCII", aSCIIXMLDecoder);
        decoders.put("ISO-8859-1", iSO8859_1XMLDecoder);
        decoders.put("ISO8859_1", iSO8859_1XMLDecoder);
        decoders.put("UTF-16LE", unicodeLittleXMLDecoder);
        decoders.put("UNICODELITTLE", unicodeLittleXMLDecoder);
        decoders.put("UNICODELITTLEUNMARKED", unicodeLittleXMLDecoder);
        decoders.put(CharEncoding.UTF_16BE, unicodeBigXMLDecoder);
        decoders.put("UTF-16", unicodeBigXMLDecoder);
        decoders.put("UNICODEBIG", unicodeBigXMLDecoder);
        decoders.put("UNICODEBIGUNMARKED", unicodeBigXMLDecoder);
    }

    public static XMLDecoder createDecoder(String str) throws UnsupportedEncodingException {
        XMLDecoder xMLDecoder = (XMLDecoder) decoders.get(str.toUpperCase());
        if (xMLDecoder != null) {
            return xMLDecoder.newXMLDecoder();
        }
        throw new UnsupportedEncodingException(new StringBuffer().append("Encoding '").append(str).append("' not supported").toString());
    }
}
