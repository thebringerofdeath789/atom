package org.apache.poi.xssf.usermodel.helpers;

import aavax.xml.namespace.QName;
import com.google.android.exoplayer2.audio.AacUtil;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.xml.bind.DatatypeConverter;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;

/* loaded from: classes5.dex */
public class XSSFPaswordHelper {
    public static void setPassword(XmlObject xmlObject, String str, HashAlgorithm hashAlgorithm, String str2) {
        XmlCursor newCursor = xmlObject.newCursor();
        if (str == null) {
            newCursor.removeAttribute(getAttrName(str2, "password"));
            newCursor.removeAttribute(getAttrName(str2, "algorithmName"));
            newCursor.removeAttribute(getAttrName(str2, "hashValue"));
            newCursor.removeAttribute(getAttrName(str2, "saltValue"));
            newCursor.removeAttribute(getAttrName(str2, "spinCount"));
            return;
        }
        newCursor.toFirstContentToken();
        if (hashAlgorithm == null) {
            newCursor.insertAttributeWithValue(getAttrName(str2, "password"), Integer.toHexString(CryptoFunctions.createXorVerifier1(str)).toUpperCase());
        } else {
            byte[] generateSeed = new SecureRandom().generateSeed(16);
            byte[] hashPassword = CryptoFunctions.hashPassword(str, hashAlgorithm, generateSeed, AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND, false);
            newCursor.insertAttributeWithValue(getAttrName(str2, "algorithmName"), hashAlgorithm.jceId);
            newCursor.insertAttributeWithValue(getAttrName(str2, "hashValue"), DatatypeConverter.printBase64Binary(hashPassword));
            newCursor.insertAttributeWithValue(getAttrName(str2, "saltValue"), DatatypeConverter.printBase64Binary(generateSeed));
            newCursor.insertAttributeWithValue(getAttrName(str2, "spinCount"), "" + AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND);
        }
        newCursor.dispose();
    }

    public static boolean validatePassword(XmlObject xmlObject, String str, String str2) {
        if (str == null) {
            return false;
        }
        XmlCursor newCursor = xmlObject.newCursor();
        String attributeText = newCursor.getAttributeText(getAttrName(str2, "password"));
        String attributeText2 = newCursor.getAttributeText(getAttrName(str2, "algorithmName"));
        String attributeText3 = newCursor.getAttributeText(getAttrName(str2, "hashValue"));
        String attributeText4 = newCursor.getAttributeText(getAttrName(str2, "saltValue"));
        String attributeText5 = newCursor.getAttributeText(getAttrName(str2, "spinCount"));
        newCursor.dispose();
        if (attributeText != null) {
            return Integer.parseInt(attributeText, 16) == CryptoFunctions.createXorVerifier1(str);
        }
        if (attributeText3 == null || attributeText2 == null || attributeText4 == null || attributeText5 == null) {
            return false;
        }
        return Arrays.equals(DatatypeConverter.parseBase64Binary(attributeText3), CryptoFunctions.hashPassword(str, HashAlgorithm.fromString(attributeText2), DatatypeConverter.parseBase64Binary(attributeText4), Integer.parseInt(attributeText5), false));
    }

    private static QName getAttrName(String str, String str2) {
        if (str == null || "".equals(str)) {
            return new QName(str2);
        }
        return new QName(str + Character.toUpperCase(str2.charAt(0)) + str2.substring(1));
    }
}
