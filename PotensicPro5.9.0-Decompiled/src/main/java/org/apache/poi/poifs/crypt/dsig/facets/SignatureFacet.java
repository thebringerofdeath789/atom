package org.apache.poi.poifs.crypt.dsig.facets;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.util.List;
import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLObject;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.spec.DigestMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import org.apache.jcp.xml.dsig.internal.dom.DOMDigestMethod;
import org.apache.jcp.xml.dsig.internal.dom.DOMReference;
import org.apache.poi.poifs.crypt.dsig.SignatureConfig;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.w3c.dom.Document;

/* loaded from: classes5.dex */
public abstract class SignatureFacet implements SignatureConfig.SignatureConfigurable {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) SignatureFacet.class);
    public static final String MS_DIGSIG_NS = "http://schemas.microsoft.com/office/2006/digsig";
    public static final String OO_DIGSIG_NS = "http://schemas.openxmlformats.org/package/2006/digital-signature";
    public static final String XADES_132_NS = "http://uri.etsi.org/01903/v1.3.2#";
    public static final String XADES_141_NS = "http://uri.etsi.org/01903/v1.4.1#";
    public static final String XML_DIGSIG_NS = "http://www.w3.org/2000/09/xmldsig#";
    public static final String XML_NS = "http://www.w3.org/2000/xmlns/";
    protected SignatureConfig signatureConfig;

    public void postSign(Document document) throws MarshalException {
    }

    public void preSign(Document document, List<Reference> list, List<XMLObject> list2) throws XMLSignatureException {
    }

    @Override // org.apache.poi.poifs.crypt.dsig.SignatureConfig.SignatureConfigurable
    public void setSignatureConfig(SignatureConfig signatureConfig) {
        this.signatureConfig = signatureConfig;
    }

    protected XMLSignatureFactory getSignatureFactory() {
        return this.signatureConfig.getSignatureFactory();
    }

    protected Transform newTransform(String str) throws XMLSignatureException {
        return newTransform(str, null);
    }

    protected Transform newTransform(String str, TransformParameterSpec transformParameterSpec) throws XMLSignatureException {
        try {
            return getSignatureFactory().newTransform(str, transformParameterSpec);
        } catch (GeneralSecurityException e) {
            throw new XMLSignatureException("unknown canonicalization method: " + str, e);
        }
    }

    protected Reference newReference(String str, List<Transform> list, String str2, String str3, byte[] bArr) throws XMLSignatureException {
        return newReference(str, list, str2, str3, bArr, this.signatureConfig);
    }

    public static Reference newReference(String str, List<Transform> list, String str2, String str3, byte[] bArr, SignatureConfig signatureConfig) throws XMLSignatureException {
        Reference newReference;
        String digestMethodUri = signatureConfig.getDigestMethodUri();
        XMLSignatureFactory signatureFactory = signatureConfig.getSignatureFactory();
        try {
            DigestMethod newDigestMethod = signatureFactory.newDigestMethod(digestMethodUri, (DigestMethodParameterSpec) null);
            if (bArr == null) {
                newReference = signatureFactory.newReference(str, newDigestMethod, list, str2, str3);
            } else {
                newReference = signatureFactory.newReference(str, newDigestMethod, list, str2, str3, bArr);
            }
            brokenJvmWorkaround(newReference);
            return newReference;
        } catch (GeneralSecurityException e) {
            throw new XMLSignatureException("unknown digest method uri: " + digestMethodUri, e);
        }
    }

    public static void brokenJvmWorkaround(Reference reference) {
        DigestMethod digestMethod = reference.getDigestMethod();
        String algorithm = digestMethod.getAlgorithm();
        Provider provider = Security.getProvider("BC");
        if (provider == null || "http://www.w3.org/2000/09/xmldsig#sha1".equals(algorithm)) {
            return;
        }
        try {
            Method declaredMethod = DOMDigestMethod.class.getDeclaredMethod("getMessageDigestAlgorithm", new Class[0]);
            declaredMethod.setAccessible(true);
            MessageDigest messageDigest = MessageDigest.getInstance((String) declaredMethod.invoke(digestMethod, new Object[0]), provider);
            Field declaredField = DOMReference.class.getDeclaredField("md");
            declaredField.setAccessible(true);
            declaredField.set(reference, messageDigest);
        } catch (Exception e) {
            LOG.log(5, (Object) "Can't overwrite message digest (workaround for https://bugzilla.redhat.com/show_bug.cgi?id=1155012)", (Throwable) e);
        }
    }
}
