package org.apache.poi.poifs.crypt.dsig.services;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.Provider;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.xml.crypto.Data;
import javax.xml.crypto.MarshalException;
import javax.xml.crypto.OctetStreamData;
import javax.xml.crypto.XMLCryptoContext;
import javax.xml.crypto.XMLStructure;
import javax.xml.crypto.dom.DOMStructure;
import javax.xml.crypto.dsig.TransformException;
import javax.xml.crypto.dsig.TransformService;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.XmlSort;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTRelationshipReference;
import org.openxmlformats.schemas.xpackage.x2006.digitalSignature.RelationshipReferenceDocument;
import org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationship;
import org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships;
import org.openxmlformats.schemas.xpackage.x2006.relationships.RelationshipsDocument;
import org.openxmlformats.schemas.xpackage.x2006.relationships.STTargetMode;
import org.w3.x2000.x09.xmldsig.TransformDocument;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* loaded from: classes5.dex */
public class RelationshipTransformService extends TransformService {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) RelationshipTransformService.class);
    public static final String TRANSFORM_URI = "http://schemas.openxmlformats.org/package/2006/RelationshipTransform";
    private final List<String> sourceIds;

    public static class RelationshipTransformParameterSpec implements TransformParameterSpec {
        List<String> sourceIds = new ArrayList();

        public void addRelationshipReference(String str) {
            this.sourceIds.add(str);
        }

        public boolean hasSourceIds() {
            return !this.sourceIds.isEmpty();
        }
    }

    public RelationshipTransformService() {
        LOG.log(1, JamXmlElements.CONSTRUCTOR);
        this.sourceIds = new ArrayList();
    }

    public static synchronized void registerDsigProvider() {
        synchronized (RelationshipTransformService.class) {
            if (Security.getProperty("POIXmlDsigProvider") == null) {
                Provider provider = new Provider("POIXmlDsigProvider", 1.0d, "POIXmlDsigProvider") { // from class: org.apache.poi.poifs.crypt.dsig.services.RelationshipTransformService.1
                    static final long serialVersionUID = 1;
                };
                provider.put("TransformService.http://schemas.openxmlformats.org/package/2006/RelationshipTransform", RelationshipTransformService.class.getName());
                provider.put("TransformService.http://schemas.openxmlformats.org/package/2006/RelationshipTransform MechanismType", "DOM");
                Security.addProvider(provider);
            }
        }
    }

    public void init(TransformParameterSpec transformParameterSpec) throws InvalidAlgorithmParameterException {
        LOG.log(1, "init(params)");
        if (!(transformParameterSpec instanceof RelationshipTransformParameterSpec)) {
            throw new InvalidAlgorithmParameterException();
        }
        Iterator<String> it = ((RelationshipTransformParameterSpec) transformParameterSpec).sourceIds.iterator();
        while (it.hasNext()) {
            this.sourceIds.add(it.next());
        }
    }

    public void init(XMLStructure xMLStructure, XMLCryptoContext xMLCryptoContext) throws InvalidAlgorithmParameterException {
        POILogger pOILogger = LOG;
        pOILogger.log(1, "init(parent,context)");
        pOILogger.log(1, "parent java type: " + xMLStructure.getClass().getName());
        try {
            XmlObject[] selectChildren = TransformDocument.Factory.parse(((DOMStructure) xMLStructure).getNode()).getTransform().selectChildren(RelationshipReferenceDocument.type.getDocumentElementName());
            if (selectChildren.length == 0) {
                pOILogger.log(5, "no RelationshipReference/@SourceId parameters present");
            }
            for (XmlObject xmlObject : selectChildren) {
                String sourceId = ((CTRelationshipReference) xmlObject).getSourceId();
                LOG.log(1, "sourceId: ", sourceId);
                this.sourceIds.add(sourceId);
            }
        } catch (XmlException e) {
            throw new InvalidAlgorithmParameterException(e);
        }
    }

    public void marshalParams(XMLStructure xMLStructure, XMLCryptoContext xMLCryptoContext) throws MarshalException {
        LOG.log(1, "marshallParams(parent,context)");
        Element element = (Element) ((DOMStructure) xMLStructure).getNode();
        Document ownerDocument = element.getOwnerDocument();
        for (String str : this.sourceIds) {
            RelationshipReferenceDocument newInstance = RelationshipReferenceDocument.Factory.newInstance();
            newInstance.addNewRelationshipReference().setSourceId(str);
            element.appendChild(ownerDocument.importNode(newInstance.getRelationshipReference().getDomNode(), true));
        }
    }

    public AlgorithmParameterSpec getParameterSpec() {
        LOG.log(1, "getParameterSpec");
        return null;
    }

    public Data transform(Data data, XMLCryptoContext xMLCryptoContext) throws TransformException {
        POILogger pOILogger = LOG;
        pOILogger.log(1, "transform(data,context)");
        pOILogger.log(1, "data java type: " + data.getClass().getName());
        OctetStreamData octetStreamData = (OctetStreamData) data;
        pOILogger.log(1, "URI: " + octetStreamData.getURI());
        try {
            RelationshipsDocument parse = RelationshipsDocument.Factory.parse(octetStreamData.getOctetStream());
            pOILogger.log(1, "relationships document", parse);
            CTRelationships relationships = parse.getRelationships();
            List<CTRelationship> relationshipList = relationships.getRelationshipList();
            Iterator<CTRelationship> it = relationships.getRelationshipList().iterator();
            while (it.hasNext()) {
                CTRelationship next = it.next();
                if (!this.sourceIds.contains(next.getId())) {
                    LOG.log(1, "removing element: " + next.getId());
                    it.remove();
                } else if (!next.isSetTargetMode()) {
                    next.setTargetMode(STTargetMode.INTERNAL);
                }
            }
            LOG.log(1, "# Relationship elements", Integer.valueOf(relationshipList.size()));
            XmlSort.sort(relationships, new Comparator<XmlCursor>() { // from class: org.apache.poi.poifs.crypt.dsig.services.RelationshipTransformService.2
                @Override // java.util.Comparator
                public int compare(XmlCursor xmlCursor, XmlCursor xmlCursor2) {
                    return ((CTRelationship) xmlCursor.getObject()).getId().compareTo(((CTRelationship) xmlCursor2.getObject()).getId());
                }
            });
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                XmlOptions xmlOptions = new XmlOptions();
                xmlOptions.setSaveNoXmlDecl();
                parse.save(byteArrayOutputStream, xmlOptions);
                return new OctetStreamData(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            } catch (IOException e) {
                throw new TransformException(e.getMessage(), e);
            }
        } catch (Exception e2) {
            throw new TransformException(e2.getMessage(), e2);
        }
    }

    public Data transform(Data data, XMLCryptoContext xMLCryptoContext, OutputStream outputStream) throws TransformException {
        LOG.log(1, "transform(data,context,os)");
        return null;
    }

    public boolean isFeatureSupported(String str) {
        LOG.log(1, "isFeatureSupported(feature)");
        return false;
    }
}
