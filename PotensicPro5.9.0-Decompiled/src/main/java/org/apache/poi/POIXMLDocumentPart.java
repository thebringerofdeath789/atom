package org.apache.poi;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.exceptions.PartAlreadyExistsException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.xmlbeans.XmlOptions;

/* loaded from: classes.dex */
public class POIXMLDocumentPart {
    public static final XmlOptions DEFAULT_XML_OPTIONS;
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) POIXMLDocumentPart.class);
    private PackagePart packagePart;
    private PackageRelationship packageRel;
    private POIXMLDocumentPart parent;
    private Map<String, POIXMLDocumentPart> relations = new LinkedHashMap();
    private int relationCounter = 0;

    protected void commit() throws IOException {
    }

    protected void onDocumentCreate() throws IOException {
    }

    protected void onDocumentRead() throws IOException {
    }

    protected void onDocumentRemove() throws IOException {
    }

    static {
        XmlOptions xmlOptions = new XmlOptions();
        DEFAULT_XML_OPTIONS = xmlOptions;
        xmlOptions.setSaveOuter();
        xmlOptions.setUseDefaultNamespace();
        xmlOptions.setSaveAggressiveNamespaces();
        xmlOptions.setCharacterEncoding("UTF-8");
    }

    int incrementRelationCounter() {
        int i = this.relationCounter + 1;
        this.relationCounter = i;
        return i;
    }

    int decrementRelationCounter() {
        int i = this.relationCounter - 1;
        this.relationCounter = i;
        return i;
    }

    int getRelationCounter() {
        return this.relationCounter;
    }

    public POIXMLDocumentPart(OPCPackage oPCPackage) {
        PackageRelationship relationship = oPCPackage.getRelationshipsByType("http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument").getRelationship(0);
        if (relationship == null && (relationship = oPCPackage.getRelationshipsByType(PackageRelationshipTypes.STRICT_CORE_DOCUMENT).getRelationship(0)) != null) {
            throw new POIXMLException("Strict OOXML isn't currently supported, please see bug #57699");
        }
        if (relationship == null) {
            throw new POIXMLException("OOXML file structure broken/invalid - no core document found!");
        }
        this.packagePart = oPCPackage.getPart(relationship);
        this.packageRel = relationship;
    }

    public POIXMLDocumentPart() {
    }

    public POIXMLDocumentPart(PackagePart packagePart, PackageRelationship packageRelationship) {
        this.packagePart = packagePart;
        this.packageRel = packageRelationship;
    }

    public POIXMLDocumentPart(POIXMLDocumentPart pOIXMLDocumentPart, PackagePart packagePart, PackageRelationship packageRelationship) {
        this.packagePart = packagePart;
        this.packageRel = packageRelationship;
        this.parent = pOIXMLDocumentPart;
    }

    protected final void rebase(OPCPackage oPCPackage) throws InvalidFormatException {
        PackageRelationshipCollection relationshipsByType = this.packagePart.getRelationshipsByType("http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument");
        if (relationshipsByType.size() != 1) {
            throw new IllegalStateException("Tried to rebase using http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument but found " + relationshipsByType.size() + " parts of the right type");
        }
        PackageRelationship relationship = relationshipsByType.getRelationship(0);
        this.packageRel = relationship;
        this.packagePart = this.packagePart.getRelatedPart(relationship);
    }

    public final PackagePart getPackagePart() {
        return this.packagePart;
    }

    public final PackageRelationship getPackageRelationship() {
        return this.packageRel;
    }

    public final List<POIXMLDocumentPart> getRelations() {
        return Collections.unmodifiableList(new ArrayList(this.relations.values()));
    }

    public final POIXMLDocumentPart getRelationById(String str) {
        return this.relations.get(str);
    }

    public final String getRelationId(POIXMLDocumentPart pOIXMLDocumentPart) {
        for (Map.Entry<String, POIXMLDocumentPart> entry : this.relations.entrySet()) {
            if (entry.getValue() == pOIXMLDocumentPart) {
                return entry.getKey();
            }
        }
        return null;
    }

    public final void addRelation(String str, POIXMLDocumentPart pOIXMLDocumentPart) {
        this.relations.put(str, pOIXMLDocumentPart);
        pOIXMLDocumentPart.incrementRelationCounter();
    }

    protected final void removeRelation(POIXMLDocumentPart pOIXMLDocumentPart) {
        removeRelation(pOIXMLDocumentPart, true);
    }

    protected final boolean removeRelation(POIXMLDocumentPart pOIXMLDocumentPart, boolean z) {
        String relationId = getRelationId(pOIXMLDocumentPart);
        if (relationId == null) {
            return false;
        }
        pOIXMLDocumentPart.decrementRelationCounter();
        getPackagePart().removeRelationship(relationId);
        this.relations.remove(relationId);
        if (!z || pOIXMLDocumentPart.getRelationCounter() != 0) {
            return true;
        }
        try {
            pOIXMLDocumentPart.onDocumentRemove();
            getPackagePart().getPackage().removePart(pOIXMLDocumentPart.getPackagePart());
            return true;
        } catch (IOException e) {
            throw new POIXMLException(e);
        }
    }

    public final POIXMLDocumentPart getParent() {
        return this.parent;
    }

    public String toString() {
        PackagePart packagePart = this.packagePart;
        return packagePart == null ? "" : packagePart.toString();
    }

    protected final void onSave(Set<PackagePart> set) throws IOException {
        prepareForCommit();
        commit();
        set.add(getPackagePart());
        for (POIXMLDocumentPart pOIXMLDocumentPart : this.relations.values()) {
            if (!set.contains(pOIXMLDocumentPart.getPackagePart())) {
                pOIXMLDocumentPart.onSave(set);
            }
        }
    }

    protected void prepareForCommit() {
        PackagePart packagePart = getPackagePart();
        if (packagePart != null) {
            packagePart.clear();
        }
    }

    public final POIXMLDocumentPart createRelationship(POIXMLRelation pOIXMLRelation, POIXMLFactory pOIXMLFactory) {
        return createRelationship(pOIXMLRelation, pOIXMLFactory, -1, false);
    }

    public final POIXMLDocumentPart createRelationship(POIXMLRelation pOIXMLRelation, POIXMLFactory pOIXMLFactory, int i) {
        return createRelationship(pOIXMLRelation, pOIXMLFactory, i, false);
    }

    protected final POIXMLDocumentPart createRelationship(POIXMLRelation pOIXMLRelation, POIXMLFactory pOIXMLFactory, int i, boolean z) {
        try {
            PackagePartName createPartName = PackagingURIHelper.createPartName(pOIXMLRelation.getFileName(i));
            PackagePart createPart = this.packagePart.getPackage().createPart(createPartName, pOIXMLRelation.getContentType());
            PackageRelationship addRelationship = z ? null : this.packagePart.addRelationship(createPartName, TargetMode.INTERNAL, pOIXMLRelation.getRelation());
            POIXMLDocumentPart newDocumentPart = pOIXMLFactory.newDocumentPart(pOIXMLRelation);
            newDocumentPart.packageRel = addRelationship;
            newDocumentPart.packagePart = createPart;
            newDocumentPart.parent = this;
            if (!z) {
                addRelation(addRelationship.getId(), newDocumentPart);
            }
            return newDocumentPart;
        } catch (PartAlreadyExistsException e) {
            throw e;
        } catch (Exception e2) {
            throw new POIXMLException(e2);
        }
    }

    protected void read(POIXMLFactory pOIXMLFactory, Map<PackagePart, POIXMLDocumentPart> map) throws OpenXML4JException {
        PackagePart packagePart;
        Iterator<PackageRelationship> it = this.packagePart.getRelationships().iterator();
        while (it.hasNext()) {
            PackageRelationship next = it.next();
            if (next.getTargetMode() == TargetMode.INTERNAL) {
                URI targetURI = next.getTargetURI();
                if (targetURI.getRawFragment() != null) {
                    packagePart = null;
                } else {
                    packagePart = this.packagePart.getPackage().getPart(PackagingURIHelper.createPartName(targetURI));
                    if (packagePart == null) {
                        logger.log(7, "Skipped invalid entry " + next.getTargetURI());
                    }
                }
                if (!map.containsKey(packagePart)) {
                    POIXMLDocumentPart createDocumentPart = pOIXMLFactory.createDocumentPart(this, next, packagePart);
                    createDocumentPart.parent = this;
                    addRelation(next.getId(), createDocumentPart);
                    if (packagePart != null) {
                        map.put(packagePart, createDocumentPart);
                        if (packagePart.hasRelationships()) {
                            createDocumentPart.read(pOIXMLFactory, map);
                        }
                    }
                } else {
                    addRelation(next.getId(), map.get(packagePart));
                }
            }
        }
    }

    protected PackagePart getTargetPart(PackageRelationship packageRelationship) throws InvalidFormatException {
        return getPackagePart().getRelatedPart(packageRelationship);
    }
}
