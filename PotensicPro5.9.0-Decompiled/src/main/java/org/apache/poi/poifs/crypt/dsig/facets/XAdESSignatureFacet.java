package org.apache.poi.poifs.crypt.dsig.facets;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import javax.xml.crypto.dom.DOMStructure;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.XMLObject;
import javax.xml.crypto.dsig.XMLSignatureException;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.poifs.crypt.dsig.SignatureConfig;
import org.apache.poi.poifs.crypt.dsig.services.SignaturePolicyService;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.etsi.uri.x01903.v13.AnyType;
import org.etsi.uri.x01903.v13.CertIDType;
import org.etsi.uri.x01903.v13.DataObjectFormatType;
import org.etsi.uri.x01903.v13.DigestAlgAndValueType;
import org.etsi.uri.x01903.v13.ObjectIdentifierType;
import org.etsi.uri.x01903.v13.QualifyingPropertiesDocument;
import org.etsi.uri.x01903.v13.QualifyingPropertiesType;
import org.etsi.uri.x01903.v13.SignaturePolicyIdType;
import org.etsi.uri.x01903.v13.SignedPropertiesType;
import org.etsi.uri.x01903.v13.SignedSignaturePropertiesType;
import org.etsi.uri.x01903.v13.SignerRoleType;
import org.w3.x2000.x09.xmldsig.X509IssuerSerialType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* loaded from: classes5.dex */
public class XAdESSignatureFacet extends SignatureFacet {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) XAdESSignatureFacet.class);
    private static final String XADES_TYPE = "http://uri.etsi.org/01903#SignedProperties";
    private Map<String, String> dataObjectFormatMimeTypes = new HashMap();

    @Override // org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet
    public void preSign(Document document, List<Reference> list, List<XMLObject> list2) throws XMLSignatureException {
        LOG.log(1, "preSign");
        QualifyingPropertiesType addNewQualifyingProperties = QualifyingPropertiesDocument.Factory.newInstance().addNewQualifyingProperties();
        addNewQualifyingProperties.setTarget("#" + this.signatureConfig.getPackageSignatureId());
        SignedPropertiesType addNewSignedProperties = addNewQualifyingProperties.addNewSignedProperties();
        addNewSignedProperties.setId(this.signatureConfig.getXadesSignatureId());
        SignedSignaturePropertiesType addNewSignedSignatureProperties = addNewSignedProperties.addNewSignedSignatureProperties();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("Z"));
        calendar.setTime(this.signatureConfig.getExecutionTime());
        calendar.clear(14);
        addNewSignedSignatureProperties.setSigningTime(calendar);
        if (this.signatureConfig.getSigningCertificateChain() == null || this.signatureConfig.getSigningCertificateChain().isEmpty()) {
            throw new RuntimeException("no signing certificate chain available");
        }
        setCertID(addNewSignedSignatureProperties.addNewSigningCertificate().addNewCert(), this.signatureConfig, this.signatureConfig.isXadesIssuerNameNoReverseOrder(), this.signatureConfig.getSigningCertificateChain().get(0));
        String xadesRole = this.signatureConfig.getXadesRole();
        if (xadesRole != null && !xadesRole.isEmpty()) {
            SignerRoleType addNewSignerRole = addNewSignedSignatureProperties.addNewSignerRole();
            addNewSignedSignatureProperties.setSignerRole(addNewSignerRole);
            AnyType addNewClaimedRole = addNewSignerRole.addNewClaimedRoles().addNewClaimedRole();
            XmlString newInstance = XmlString.Factory.newInstance();
            newInstance.setStringValue(xadesRole);
            insertXChild(addNewClaimedRole, newInstance);
        }
        SignaturePolicyService signaturePolicyService = this.signatureConfig.getSignaturePolicyService();
        if (signaturePolicyService != null) {
            SignaturePolicyIdType addNewSignaturePolicyId = addNewSignedSignatureProperties.addNewSignaturePolicyIdentifier().addNewSignaturePolicyId();
            ObjectIdentifierType addNewSigPolicyId = addNewSignaturePolicyId.addNewSigPolicyId();
            addNewSigPolicyId.setDescription(signaturePolicyService.getSignaturePolicyDescription());
            addNewSigPolicyId.addNewIdentifier().setStringValue(signaturePolicyService.getSignaturePolicyIdentifier());
            setDigestAlgAndValue(addNewSignaturePolicyId.addNewSigPolicyHash(), signaturePolicyService.getSignaturePolicyDocument(), this.signatureConfig.getDigestAlgo());
            String signaturePolicyDownloadUrl = signaturePolicyService.getSignaturePolicyDownloadUrl();
            if (signaturePolicyDownloadUrl != null) {
                AnyType addNewSigPolicyQualifier = addNewSignaturePolicyId.addNewSigPolicyQualifiers().addNewSigPolicyQualifier();
                XmlString newInstance2 = XmlString.Factory.newInstance();
                newInstance2.setStringValue(signaturePolicyDownloadUrl);
                insertXChild(addNewSigPolicyQualifier, newInstance2);
            }
        } else if (this.signatureConfig.isXadesSignaturePolicyImplied()) {
            addNewSignedSignatureProperties.addNewSignaturePolicyIdentifier().addNewSignaturePolicyImplied();
        }
        if (!this.dataObjectFormatMimeTypes.isEmpty()) {
            List dataObjectFormatList = addNewSignedProperties.addNewSignedDataObjectProperties().getDataObjectFormatList();
            for (Map.Entry<String, String> entry : this.dataObjectFormatMimeTypes.entrySet()) {
                DataObjectFormatType newInstance3 = DataObjectFormatType.Factory.newInstance();
                newInstance3.setObjectReference("#" + entry.getKey());
                newInstance3.setMimeType(entry.getValue());
                dataObjectFormatList.add(newInstance3);
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DOMStructure((Element) document.importNode((Element) addNewQualifyingProperties.getDomNode(), true)));
        list2.add(getSignatureFactory().newXMLObject(arrayList, (String) null, (String) null, (String) null));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(newTransform("http://www.w3.org/TR/2001/REC-xml-c14n-20010315"));
        list.add(newReference("#" + this.signatureConfig.getXadesSignatureId(), arrayList2, XADES_TYPE, null, null));
    }

    protected static void setDigestAlgAndValue(DigestAlgAndValueType digestAlgAndValueType, byte[] bArr, HashAlgorithm hashAlgorithm) {
        digestAlgAndValueType.addNewDigestMethod().setAlgorithm(SignatureConfig.getDigestMethodUri(hashAlgorithm));
        digestAlgAndValueType.setDigestValue(CryptoFunctions.getMessageDigest(hashAlgorithm).digest(bArr));
    }

    protected static void setCertID(CertIDType certIDType, SignatureConfig signatureConfig, boolean z, X509Certificate x509Certificate) {
        String x500Principal;
        X509IssuerSerialType addNewIssuerSerial = certIDType.addNewIssuerSerial();
        if (z) {
            x500Principal = x509Certificate.getIssuerDN().getName().replace(",", ", ");
        } else {
            x500Principal = x509Certificate.getIssuerX500Principal().toString();
        }
        addNewIssuerSerial.setX509IssuerName(x500Principal);
        addNewIssuerSerial.setX509SerialNumber(x509Certificate.getSerialNumber());
        try {
            setDigestAlgAndValue(certIDType.addNewCertDigest(), x509Certificate.getEncoded(), signatureConfig.getXadesDigestAlgo());
        } catch (CertificateEncodingException e) {
            throw new RuntimeException("certificate encoding error: " + e.getMessage(), e);
        }
    }

    public void addMimeType(String str, String str2) {
        this.dataObjectFormatMimeTypes.put(str, str2);
    }

    protected static void insertXChild(XmlObject xmlObject, XmlObject xmlObject2) {
        XmlCursor newCursor = xmlObject.newCursor();
        newCursor.toEndToken();
        XmlCursor newCursor2 = xmlObject2.newCursor();
        newCursor2.toNextToken();
        newCursor2.moveXml(newCursor);
        newCursor2.dispose();
        newCursor.dispose();
    }
}
