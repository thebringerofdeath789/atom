package org.apache.poi.poifs.crypt.dsig.facets;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1;
import com.microsoft.schemas.office.x2006.digsig.SignatureInfoV1Document;
import com.opencsv.ICSVParser;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import javax.xml.crypto.XMLStructure;
import javax.xml.crypto.dom.DOMStructure;
import javax.xml.crypto.dsig.Manifest;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureProperty;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLObject;
import javax.xml.crypto.dsig.XMLSignatureException;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.ContentTypes;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.poifs.crypt.dsig.services.RelationshipTransformService;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.openxmlformats.schemas.xpackage.x2006.digitalSignature.CTSignatureTime;
import org.openxmlformats.schemas.xpackage.x2006.digitalSignature.SignatureTimeDocument;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* loaded from: classes5.dex */
public class OOXMLSignatureFacet extends SignatureFacet {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) OOXMLSignatureFacet.class);
    public static final String[] contentTypes = {"application/vnd.openxmlformats-officedocument.wordprocessingml.document.main+xml", "application/vnd.openxmlformats-officedocument.wordprocessingml.fontTable+xml", "application/vnd.openxmlformats-officedocument.wordprocessingml.settings+xml", "application/vnd.openxmlformats-officedocument.wordprocessingml.styles+xml", "application/vnd.openxmlformats-officedocument.theme+xml", "application/vnd.openxmlformats-officedocument.wordprocessingml.webSettings+xml", "application/vnd.openxmlformats-officedocument.wordprocessingml.numbering+xml", "application/vnd.ms-word.stylesWithEffects+xml", "application/vnd.openxmlformats-officedocument.spreadsheetml.sharedStrings+xml", "application/vnd.openxmlformats-officedocument.spreadsheetml.worksheet+xml", "application/vnd.openxmlformats-officedocument.spreadsheetml.styles+xml", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet.main+xml", "application/vnd.openxmlformats-officedocument.presentationml.presentation.main+xml", "application/vnd.openxmlformats-officedocument.presentationml.slideLayout+xml", "application/vnd.openxmlformats-officedocument.presentationml.slideMaster+xml", "application/vnd.openxmlformats-officedocument.presentationml.slide+xml", "application/vnd.openxmlformats-officedocument.presentationml.tableStyles+xml", "application/vnd.openxmlformats-officedocument.presentationml.viewProps+xml", "application/vnd.openxmlformats-officedocument.presentationml.presProps+xml"};
    public static final String[] signed = {"powerPivotData", "activeXControlBinary", "attachedToolbars", "connectorXml", "downRev", "functionPrototypes", "graphicFrameDoc", "groupShapeXml", "ink", "keyMapCustomizations", "legacyDiagramText", "legacyDocTextInfo", "officeDocument", "pictureXml", "shapeXml", "smartTags", "ui/altText", "ui/buttonSize", "ui/controlID", "ui/description", "ui/enabled", "ui/extensibility", "ui/helperText", "ui/imageID", "ui/imageMso", "ui/keyTip", "ui/label", "ui/lcid", "ui/loud", "ui/pressed", "ui/progID", "ui/ribbonID", "ui/showImage", "ui/showLabel", "ui/supertip", "ui/target", "ui/text", "ui/title", "ui/tooltip", "ui/userCustomization", "ui/visible", "userXmlData", "vbaProject", "wordVbaData", "wsSortMap", "xlBinaryIndex", "xlExternalLinkPath/xlAlternateStartup", "xlExternalLinkPath/xlLibrary", "xlExternalLinkPath/xlPathMissing", "xlExternalLinkPath/xlStartup", "xlIntlMacrosheet", "xlMacrosheet", "customData", "diagramDrawing", "hdphoto", "inkXml", "media", "slicer", "slicerCache", "stylesWithEffects", "ui/extensibility", "chartColorStyle", "chartLayout", "chartStyle", "dictionary", "timeline", "timelineCache", "aFChunk", "attachedTemplate", "audio", "calcChain", "chart", "chartsheet", "chartUserShapes", "commentAuthors", "comments", "connections", SessionDescription.ATTR_CONTROL, "customProperty", "customXml", "diagramColors", "diagramData", "diagramLayout", "diagramQuickStyle", "dialogsheet", "drawing", "endnotes", "externalLink", "externalLinkPath", CellUtil.FONT, "fontTable", "footer", "footnotes", "glossaryDocument", "handoutMaster", "header", "hyperlink", "image", "mailMergeHeaderSource", "mailMergeRecipientData", "mailMergeSource", "notesMaster", "notesSlide", "numbering", "officeDocument", "oleObject", "package", "pivotCacheDefinition", "pivotCacheRecords", "pivotTable", "presProps", "printerSettings", "queryTable", "recipientData", "settings", "sharedStrings", "sheetMetadata", "slide", "slideLayout", "slideMaster", "slideUpdateInfo", "slideUpdateUrl", "styles", "table", "tableSingleCells", "tableStyles", "tags", "theme", "themeOverride", "transform", "video", "viewProps", "volatileDependencies", "webSettings", "worksheet", "xmlMaps", "ctrlProp", "customData", "diagram", "diagramColorsHeader", "diagramLayoutHeader", "diagramQuickStyleHeader", "documentParts", "slicer", "slicerCache", "vmlDrawing"};

    @Override // org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet
    public void preSign(Document document, List<Reference> list, List<XMLObject> list2) throws XMLSignatureException {
        LOG.log(1, "pre sign");
        addManifestObject(document, list, list2);
        addSignatureInfo(document, list, list2);
    }

    protected void addManifestObject(Document document, List<Reference> list, List<XMLObject> list2) throws XMLSignatureException {
        ArrayList arrayList = new ArrayList();
        addManifestReferences(arrayList);
        Manifest newManifest = getSignatureFactory().newManifest(arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(newManifest);
        addSignatureTime(document, arrayList2);
        list2.add(getSignatureFactory().newXMLObject(arrayList2, "idPackageObject", (String) null, (String) null));
        list.add(newReference("#idPackageObject", null, "http://www.w3.org/2000/09/xmldsig#Object", null, null));
    }

    protected void addManifestReferences(List<Reference> list) throws XMLSignatureException {
        OPCPackage opcPackage = this.signatureConfig.getOpcPackage();
        ArrayList<PackagePart> partsByContentType = opcPackage.getPartsByContentType(ContentTypes.RELATIONSHIPS_PART);
        HashSet hashSet = new HashSet();
        for (PackagePart packagePart : partsByContentType) {
            String replaceFirst = packagePart.getPartName().getName().replaceFirst("(.*)/_rels/.*", "$1");
            try {
                PackageRelationshipCollection packageRelationshipCollection = new PackageRelationshipCollection(opcPackage);
                packageRelationshipCollection.parseRelationshipsPart(packagePart);
                RelationshipTransformService.RelationshipTransformParameterSpec relationshipTransformParameterSpec = new RelationshipTransformService.RelationshipTransformParameterSpec();
                Iterator<PackageRelationship> it = packageRelationshipCollection.iterator();
                while (it.hasNext()) {
                    PackageRelationship next = it.next();
                    String relationshipType = next.getRelationshipType();
                    if (TargetMode.EXTERNAL != next.getTargetMode() && isSignedRelationship(relationshipType)) {
                        relationshipTransformParameterSpec.addRelationshipReference(next.getId());
                        try {
                            String replace = new URI(replaceFirst + next.getTargetURI().toString()).normalize().getPath().replace(ICSVParser.DEFAULT_ESCAPE_CHARACTER, '/');
                            POILogger pOILogger = LOG;
                            pOILogger.log(1, "part name: " + replace);
                            try {
                                String contentType = opcPackage.getPart(PackagingURIHelper.createPartName(replace)).getContentType();
                                if (relationshipType.endsWith("customXml") && !contentType.equals("inkml+xml") && !contentType.equals(ContentTypes.XML)) {
                                    pOILogger.log(1, "skipping customXml with content type: " + contentType);
                                } else if (!hashSet.contains(replace)) {
                                    list.add(newReference(replace + "?ContentType=" + contentType, null, null, null, null));
                                    hashSet.add(replace);
                                }
                            } catch (InvalidFormatException e) {
                                throw new XMLSignatureException(e);
                            }
                        } catch (URISyntaxException e2) {
                            throw new XMLSignatureException(e2);
                        }
                    }
                }
                if (relationshipTransformParameterSpec.hasSourceIds()) {
                    List<Transform> arrayList = new ArrayList<>();
                    arrayList.add(newTransform(RelationshipTransformService.TRANSFORM_URI, relationshipTransformParameterSpec));
                    arrayList.add(newTransform("http://www.w3.org/TR/2001/REC-xml-c14n-20010315"));
                    list.add(newReference(packagePart.getPartName().getName() + "?ContentType=application/vnd.openxmlformats-package.relationships+xml", arrayList, null, null, null));
                }
            } catch (InvalidFormatException e3) {
                throw new XMLSignatureException("Invalid relationship descriptor: " + packagePart.getPartName().getName(), e3);
            }
        }
    }

    protected void addSignatureTime(Document document, List<XMLStructure> list) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String format = simpleDateFormat.format(this.signatureConfig.getExecutionTime());
        LOG.log(1, "now: " + format);
        CTSignatureTime addNewSignatureTime = SignatureTimeDocument.Factory.newInstance().addNewSignatureTime();
        addNewSignatureTime.setFormat("YYYY-MM-DDThh:mm:ssTZD");
        addNewSignatureTime.setValue(format);
        Element element = (Element) document.importNode(addNewSignatureTime.getDomNode(), true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DOMStructure(element));
        SignatureProperty newSignatureProperty = getSignatureFactory().newSignatureProperty(arrayList, "#" + this.signatureConfig.getPackageSignatureId(), "idSignatureTime");
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(newSignatureProperty);
        list.add(getSignatureFactory().newSignatureProperties(arrayList2, "id-signature-time-" + this.signatureConfig.getExecutionTime()));
    }

    protected void addSignatureInfo(Document document, List<Reference> list, List<XMLObject> list2) throws XMLSignatureException {
        ArrayList arrayList = new ArrayList();
        CTSignatureInfoV1 addNewSignatureInfoV1 = SignatureInfoV1Document.Factory.newInstance().addNewSignatureInfoV1();
        addNewSignatureInfoV1.setManifestHashAlgorithm(this.signatureConfig.getDigestMethodUri());
        Element element = (Element) document.importNode(addNewSignatureInfoV1.getDomNode(), true);
        element.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns", SignatureFacet.MS_DIGSIG_NS);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new DOMStructure(element));
        SignatureProperty newSignatureProperty = getSignatureFactory().newSignatureProperty(arrayList2, "#" + this.signatureConfig.getPackageSignatureId(), "idOfficeV1Details");
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(newSignatureProperty);
        arrayList.add(getSignatureFactory().newSignatureProperties(arrayList3, (String) null));
        list2.add(getSignatureFactory().newXMLObject(arrayList, "idOfficeObject", (String) null, (String) null));
        list.add(newReference("#idOfficeObject", null, "http://www.w3.org/2000/09/xmldsig#Object", null, null));
    }

    protected static String getRelationshipReferenceURI(String str) {
        return InternalZipConstants.ZIP_FILE_SEPARATOR + str + "?ContentType=application/vnd.openxmlformats-package.relationships+xml";
    }

    protected static String getResourceReferenceURI(String str, String str2) {
        return InternalZipConstants.ZIP_FILE_SEPARATOR + str + "?ContentType=" + str2;
    }

    protected static boolean isSignedRelationship(String str) {
        LOG.log(1, "relationship type: " + str);
        for (String str2 : signed) {
            if (str.endsWith(str2)) {
                return true;
            }
        }
        if (!str.endsWith("customXml")) {
            return false;
        }
        LOG.log(1, "customXml relationship type");
        return true;
    }
}
