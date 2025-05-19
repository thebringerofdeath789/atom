package org.apache.poi.poifs.crypt.dsig.facets;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.security.cert.CRLException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import javax.xml.crypto.MarshalException;
import org.apache.poi.poifs.crypt.dsig.services.RevocationData;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.xml.security.c14n.Canonicalizer;
import org.apache.xmlbeans.XmlException;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.cert.ocsp.BasicOCSPResp;
import org.bouncycastle.cert.ocsp.OCSPResp;
import org.etsi.uri.x01903.v13.CRLIdentifierType;
import org.etsi.uri.x01903.v13.CRLRefType;
import org.etsi.uri.x01903.v13.CRLRefsType;
import org.etsi.uri.x01903.v13.CRLValuesType;
import org.etsi.uri.x01903.v13.CertIDListType;
import org.etsi.uri.x01903.v13.CertificateValuesType;
import org.etsi.uri.x01903.v13.CompleteCertificateRefsType;
import org.etsi.uri.x01903.v13.CompleteRevocationRefsType;
import org.etsi.uri.x01903.v13.EncapsulatedPKIDataType;
import org.etsi.uri.x01903.v13.OCSPIdentifierType;
import org.etsi.uri.x01903.v13.OCSPRefType;
import org.etsi.uri.x01903.v13.OCSPRefsType;
import org.etsi.uri.x01903.v13.OCSPValuesType;
import org.etsi.uri.x01903.v13.QualifyingPropertiesDocument;
import org.etsi.uri.x01903.v13.QualifyingPropertiesType;
import org.etsi.uri.x01903.v13.ResponderIDType;
import org.etsi.uri.x01903.v13.RevocationValuesType;
import org.etsi.uri.x01903.v13.UnsignedPropertiesType;
import org.etsi.uri.x01903.v13.UnsignedSignaturePropertiesType;
import org.etsi.uri.x01903.v13.XAdESTimeStampType;
import org.etsi.uri.x01903.v14.ValidationDataType;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* loaded from: classes5.dex */
public class XAdESXLSignatureFacet extends SignatureFacet {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) XAdESXLSignatureFacet.class);
    private final CertificateFactory certificateFactory;

    public XAdESXLSignatureFacet() {
        try {
            this.certificateFactory = CertificateFactory.getInstance("X.509");
        } catch (CertificateException e) {
            throw new RuntimeException("X509 JCA error: " + e.getMessage(), e);
        }
    }

    @Override // org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet
    public void postSign(Document document) throws MarshalException {
        POILogger pOILogger = LOG;
        pOILogger.log(1, "XAdES-X-L post sign phase");
        NodeList elementsByTagNameNS = document.getElementsByTagNameNS(SignatureFacet.XADES_132_NS, "QualifyingProperties");
        if (elementsByTagNameNS.getLength() == 1) {
            try {
                QualifyingPropertiesType qualifyingProperties = QualifyingPropertiesDocument.Factory.parse(elementsByTagNameNS.item(0)).getQualifyingProperties();
                UnsignedPropertiesType unsignedProperties = qualifyingProperties.getUnsignedProperties();
                if (unsignedProperties == null) {
                    unsignedProperties = qualifyingProperties.addNewUnsignedProperties();
                }
                UnsignedSignaturePropertiesType unsignedSignatureProperties = unsignedProperties.getUnsignedSignatureProperties();
                if (unsignedSignatureProperties == null) {
                    unsignedSignatureProperties = unsignedProperties.addNewUnsignedSignatureProperties();
                }
                NodeList elementsByTagNameNS2 = document.getElementsByTagNameNS(SignatureFacet.XML_DIGSIG_NS, "SignatureValue");
                if (elementsByTagNameNS2.getLength() != 1) {
                    throw new IllegalArgumentException("SignatureValue is not set.");
                }
                RevocationData revocationData = new RevocationData();
                pOILogger.log(1, "creating XAdES-T time-stamp");
                XAdESTimeStampType createXAdESTimeStamp = createXAdESTimeStamp(Collections.singletonList(elementsByTagNameNS2.item(0)), revocationData);
                unsignedSignatureProperties.addNewSignatureTimeStamp().set(createXAdESTimeStamp);
                if (revocationData.hasRevocationDataEntries()) {
                    XAdESSignatureFacet.insertXChild(unsignedSignatureProperties, createValidationData(revocationData));
                }
                if (this.signatureConfig.getRevocationDataService() == null) {
                    return;
                }
                CompleteCertificateRefsType addNewCompleteCertificateRefs = unsignedSignatureProperties.addNewCompleteCertificateRefs();
                CertIDListType addNewCertRefs = addNewCompleteCertificateRefs.addNewCertRefs();
                List<X509Certificate> signingCertificateChain = this.signatureConfig.getSigningCertificateChain();
                int size = signingCertificateChain.size();
                if (size > 1) {
                    Iterator<X509Certificate> it = signingCertificateChain.subList(1, size).iterator();
                    while (it.hasNext()) {
                        XAdESSignatureFacet.setCertID(addNewCertRefs.addNewCert(), this.signatureConfig, false, it.next());
                    }
                }
                CompleteRevocationRefsType addNewCompleteRevocationRefs = unsignedSignatureProperties.addNewCompleteRevocationRefs();
                RevocationData revocationData2 = this.signatureConfig.getRevocationDataService().getRevocationData(signingCertificateChain);
                if (revocationData2.hasCRLs()) {
                    CRLRefsType addNewCRLRefs = addNewCompleteRevocationRefs.addNewCRLRefs();
                    addNewCompleteRevocationRefs.setCRLRefs(addNewCRLRefs);
                    Iterator<byte[]> it2 = revocationData2.getCRLs().iterator();
                    while (it2.hasNext()) {
                        byte[] next = it2.next();
                        CRLRefType addNewCRLRef = addNewCRLRefs.addNewCRLRef();
                        try {
                            X509CRL x509crl = (X509CRL) this.certificateFactory.generateCRL(new ByteArrayInputStream(next));
                            CRLIdentifierType addNewCRLIdentifier = addNewCRLRef.addNewCRLIdentifier();
                            NodeList nodeList = elementsByTagNameNS;
                            addNewCRLIdentifier.setIssuer(x509crl.getIssuerDN().getName().replace(",", ", "));
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(x509crl.getThisUpdate());
                            addNewCRLIdentifier.setIssueTime(calendar);
                            addNewCRLIdentifier.setNumber(getCrlNumber(x509crl));
                            XAdESSignatureFacet.setDigestAlgAndValue(addNewCRLRef.addNewDigestAlgAndValue(), next, this.signatureConfig.getDigestAlgo());
                            it2 = it2;
                            addNewCRLRefs = addNewCRLRefs;
                            elementsByTagNameNS = nodeList;
                        } catch (CRLException e) {
                            throw new RuntimeException("CRL parse error: " + e.getMessage(), e);
                        }
                    }
                }
                NodeList nodeList2 = elementsByTagNameNS;
                if (revocationData2.hasOCSPs()) {
                    OCSPRefsType addNewOCSPRefs = addNewCompleteRevocationRefs.addNewOCSPRefs();
                    for (byte[] bArr : revocationData2.getOCSPs()) {
                        try {
                            OCSPRefType addNewOCSPRef = addNewOCSPRefs.addNewOCSPRef();
                            XAdESSignatureFacet.setDigestAlgAndValue(addNewOCSPRef.addNewDigestAlgAndValue(), bArr, this.signatureConfig.getDigestAlgo());
                            OCSPIdentifierType addNewOCSPIdentifier = addNewOCSPRef.addNewOCSPIdentifier();
                            BasicOCSPResp basicOCSPResp = (BasicOCSPResp) new OCSPResp(bArr).getResponseObject();
                            Calendar calendar2 = Calendar.getInstance();
                            calendar2.setTime(basicOCSPResp.getProducedAt());
                            addNewOCSPIdentifier.setProducedAt(calendar2);
                            ResponderIDType addNewResponderID = addNewOCSPIdentifier.addNewResponderID();
                            DERTaggedObject aSN1Primitive = basicOCSPResp.getResponderId().toASN1Object().toASN1Primitive();
                            if (2 == aSN1Primitive.getTagNo()) {
                                addNewResponderID.setByKey(aSN1Primitive.getObject().getOctets());
                            } else {
                                addNewResponderID.setByName(X500Name.getInstance(aSN1Primitive.getObject()).toString());
                            }
                        } catch (Exception e2) {
                            throw new RuntimeException("OCSP decoding error: " + e2.getMessage(), e2);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(elementsByTagNameNS2.item(0));
                arrayList.add(createXAdESTimeStamp.getDomNode());
                arrayList.add(addNewCompleteCertificateRefs.getDomNode());
                arrayList.add(addNewCompleteRevocationRefs.getDomNode());
                RevocationData revocationData3 = new RevocationData();
                LOG.log(1, "creating XAdES-X time-stamp");
                XAdESTimeStampType createXAdESTimeStamp2 = createXAdESTimeStamp(arrayList, revocationData3);
                if (revocationData3.hasRevocationDataEntries()) {
                    XAdESSignatureFacet.insertXChild(unsignedSignatureProperties, createValidationData(revocationData3));
                }
                unsignedSignatureProperties.addNewSigAndRefsTimeStamp().set(createXAdESTimeStamp2);
                CertificateValuesType addNewCertificateValues = unsignedSignatureProperties.addNewCertificateValues();
                Iterator<X509Certificate> it3 = signingCertificateChain.iterator();
                while (it3.hasNext()) {
                    try {
                        addNewCertificateValues.addNewEncapsulatedX509Certificate().setByteArrayValue(it3.next().getEncoded());
                    } catch (CertificateEncodingException e3) {
                        throw new RuntimeException("certificate encoding error: " + e3.getMessage(), e3);
                    }
                }
                createRevocationValues(unsignedSignatureProperties.addNewRevocationValues(), revocationData2);
                nodeList2.item(0).getParentNode().replaceChild(document.importNode(qualifyingProperties.getDomNode(), true), nodeList2.item(0));
                return;
            } catch (XmlException e4) {
                throw new MarshalException(e4);
            }
        }
        throw new MarshalException("no XAdES-BES extension present");
    }

    public static byte[] getC14nValue(List<Node> list, String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            Iterator<Node> it = list.iterator();
            while (it.hasNext()) {
                byteArrayOutputStream.write(Canonicalizer.getInstance(str).canonicalizeSubtree(it.next()));
            }
            return byteArrayOutputStream.toByteArray();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new RuntimeException("c14n error: " + e2.getMessage(), e2);
        }
    }

    private BigInteger getCrlNumber(X509CRL x509crl) {
        try {
            byte[] extensionValue = x509crl.getExtensionValue(Extension.cRLNumber.getId());
            if (extensionValue == null) {
                return null;
            }
            return new ASN1InputStream(new ASN1InputStream(extensionValue).readObject().getOctets()).readObject().getPositiveValue();
        } catch (Exception e) {
            throw new RuntimeException("I/O error: " + e.getMessage(), e);
        }
    }

    private XAdESTimeStampType createXAdESTimeStamp(List<Node> list, RevocationData revocationData) {
        return createXAdESTimeStamp(getC14nValue(list, this.signatureConfig.getXadesCanonicalizationMethod()), revocationData);
    }

    private XAdESTimeStampType createXAdESTimeStamp(byte[] bArr, RevocationData revocationData) {
        try {
            byte[] timeStamp = this.signatureConfig.getTspService().timeStamp(bArr, revocationData);
            XAdESTimeStampType newInstance = XAdESTimeStampType.Factory.newInstance();
            newInstance.setId("time-stamp-" + UUID.randomUUID().toString());
            newInstance.addNewCanonicalizationMethod().setAlgorithm(this.signatureConfig.getXadesCanonicalizationMethod());
            EncapsulatedPKIDataType addNewEncapsulatedTimeStamp = newInstance.addNewEncapsulatedTimeStamp();
            addNewEncapsulatedTimeStamp.setByteArrayValue(timeStamp);
            addNewEncapsulatedTimeStamp.setId("time-stamp-token-" + UUID.randomUUID().toString());
            return newInstance;
        } catch (Exception e) {
            throw new RuntimeException("error while creating a time-stamp: " + e.getMessage(), e);
        }
    }

    private ValidationDataType createValidationData(RevocationData revocationData) {
        ValidationDataType newInstance = ValidationDataType.Factory.newInstance();
        createRevocationValues(newInstance.addNewRevocationValues(), revocationData);
        return newInstance;
    }

    private void createRevocationValues(RevocationValuesType revocationValuesType, RevocationData revocationData) {
        if (revocationData.hasCRLs()) {
            CRLValuesType addNewCRLValues = revocationValuesType.addNewCRLValues();
            Iterator<byte[]> it = revocationData.getCRLs().iterator();
            while (it.hasNext()) {
                addNewCRLValues.addNewEncapsulatedCRLValue().setByteArrayValue(it.next());
            }
        }
        if (revocationData.hasOCSPs()) {
            OCSPValuesType addNewOCSPValues = revocationValuesType.addNewOCSPValues();
            Iterator<byte[]> it2 = revocationData.getOCSPs().iterator();
            while (it2.hasNext()) {
                addNewOCSPValues.addNewEncapsulatedOCSPValue().setByteArrayValue(it2.next());
            }
        }
    }
}
