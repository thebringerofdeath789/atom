package org.apache.poi.openxml4j.opc;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.util.DocumentHelper;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* loaded from: classes5.dex */
public final class PackageRelationshipCollection implements Iterable<PackageRelationship> {
    private static POILogger logger = POILogFactory.getLogger((Class<?>) PackageRelationshipCollection.class);
    private OPCPackage container;
    private int nextRelationshipId;
    private PackagePartName partName;
    private PackagePart relationshipPart;
    private TreeMap<String, PackageRelationship> relationshipsByID;
    private TreeMap<String, PackageRelationship> relationshipsByType;
    private PackagePart sourcePart;

    PackageRelationshipCollection() {
        this.nextRelationshipId = -1;
        this.relationshipsByID = new TreeMap<>();
        this.relationshipsByType = new TreeMap<>();
    }

    public PackageRelationshipCollection(PackageRelationshipCollection packageRelationshipCollection, String str) {
        this();
        for (PackageRelationship packageRelationship : packageRelationshipCollection.relationshipsByID.values()) {
            if (str == null || packageRelationship.getRelationshipType().equals(str)) {
                addRelationship(packageRelationship);
            }
        }
    }

    public PackageRelationshipCollection(OPCPackage oPCPackage) throws InvalidFormatException {
        this(oPCPackage, (PackagePart) null);
    }

    public PackageRelationshipCollection(PackagePart packagePart) throws InvalidFormatException {
        this(packagePart._container, packagePart);
    }

    public PackageRelationshipCollection(OPCPackage oPCPackage, PackagePart packagePart) throws InvalidFormatException {
        this();
        if (oPCPackage == null) {
            throw new IllegalArgumentException(TtmlNode.RUBY_CONTAINER);
        }
        if (packagePart != null && packagePart.isRelationshipPart()) {
            throw new IllegalArgumentException("part");
        }
        this.container = oPCPackage;
        this.sourcePart = packagePart;
        this.partName = getRelationshipPartName(packagePart);
        if (oPCPackage.getPackageAccess() == PackageAccess.WRITE || !oPCPackage.containPart(this.partName)) {
            return;
        }
        PackagePart part = oPCPackage.getPart(this.partName);
        this.relationshipPart = part;
        parseRelationshipsPart(part);
    }

    private static PackagePartName getRelationshipPartName(PackagePart packagePart) throws InvalidOperationException {
        PackagePartName partName;
        if (packagePart == null) {
            partName = PackagingURIHelper.PACKAGE_ROOT_PART_NAME;
        } else {
            partName = packagePart.getPartName();
        }
        return PackagingURIHelper.getRelationshipPartName(partName);
    }

    public void addRelationship(PackageRelationship packageRelationship) {
        this.relationshipsByID.put(packageRelationship.getId(), packageRelationship);
        this.relationshipsByType.put(packageRelationship.getRelationshipType(), packageRelationship);
    }

    public PackageRelationship addRelationship(URI uri, TargetMode targetMode, String str, String str2) {
        if (str2 == null) {
            if (this.nextRelationshipId == -1) {
                this.nextRelationshipId = size() + 1;
            }
            do {
                StringBuilder append = new StringBuilder().append("rId");
                int i = this.nextRelationshipId;
                this.nextRelationshipId = i + 1;
                str2 = append.append(i).toString();
            } while (this.relationshipsByID.get(str2) != null);
        }
        PackageRelationship packageRelationship = new PackageRelationship(this.container, this.sourcePart, uri, targetMode, str, str2);
        this.relationshipsByID.put(packageRelationship.getId(), packageRelationship);
        this.relationshipsByType.put(packageRelationship.getRelationshipType(), packageRelationship);
        return packageRelationship;
    }

    public void removeRelationship(String str) {
        PackageRelationship packageRelationship;
        TreeMap<String, PackageRelationship> treeMap = this.relationshipsByID;
        if (treeMap == null || this.relationshipsByType == null || (packageRelationship = treeMap.get(str)) == null) {
            return;
        }
        this.relationshipsByID.remove(packageRelationship.getId());
        this.relationshipsByType.values().remove(packageRelationship);
    }

    public void removeRelationship(PackageRelationship packageRelationship) {
        if (packageRelationship == null) {
            throw new IllegalArgumentException("rel");
        }
        this.relationshipsByID.values().remove(packageRelationship);
        this.relationshipsByType.values().remove(packageRelationship);
    }

    public PackageRelationship getRelationship(int i) {
        if (i < 0 || i > this.relationshipsByID.values().size()) {
            throw new IllegalArgumentException("index");
        }
        int i2 = 0;
        for (PackageRelationship packageRelationship : this.relationshipsByID.values()) {
            int i3 = i2 + 1;
            if (i == i2) {
                return packageRelationship;
            }
            i2 = i3;
        }
        return null;
    }

    public PackageRelationship getRelationshipByID(String str) {
        return this.relationshipsByID.get(str);
    }

    public int size() {
        return this.relationshipsByID.values().size();
    }

    public void parseRelationshipsPart(PackagePart packagePart) throws InvalidFormatException {
        try {
            logger.log(1, "Parsing relationship: " + packagePart.getPartName());
            NodeList elementsByTagName = DocumentHelper.readDocument(packagePart.getInputStream()).getDocumentElement().getElementsByTagName(PackageRelationship.RELATIONSHIP_TAG_NAME);
            int length = elementsByTagName.getLength();
            boolean z = false;
            for (int i = 0; i < length; i++) {
                Element element = (Element) elementsByTagName.item(i);
                String attribute = element.getAttribute(PackageRelationship.ID_ATTRIBUTE_NAME);
                String attribute2 = element.getAttribute(PackageRelationship.TYPE_ATTRIBUTE_NAME);
                if (attribute2.equals(PackageRelationshipTypes.CORE_PROPERTIES)) {
                    if (z) {
                        throw new InvalidFormatException("OPC Compliance error [M4.1]: there is more than one core properties relationship in the package !");
                    }
                    z = true;
                }
                Attr attributeNode = element.getAttributeNode(PackageRelationship.TARGET_MODE_ATTRIBUTE_NAME);
                TargetMode targetMode = TargetMode.INTERNAL;
                if (attributeNode != null) {
                    targetMode = attributeNode.getValue().toLowerCase().equals("internal") ? TargetMode.INTERNAL : TargetMode.EXTERNAL;
                }
                URI uri = PackagingURIHelper.toURI("http://invalid.uri");
                String attribute3 = element.getAttribute(PackageRelationship.TARGET_ATTRIBUTE_NAME);
                try {
                    uri = PackagingURIHelper.toURI(attribute3);
                } catch (URISyntaxException e) {
                    logger.log(7, (Object) ("Cannot convert " + attribute3 + " in a valid relationship URI-> dummy-URI used"), (Throwable) e);
                }
                addRelationship(uri, targetMode, attribute2, attribute);
            }
        } catch (Exception e2) {
            logger.log(7, (Throwable) e2);
            throw new InvalidFormatException(e2.getMessage());
        }
    }

    public PackageRelationshipCollection getRelationships(String str) {
        return new PackageRelationshipCollection(this, str);
    }

    @Override // java.lang.Iterable
    public Iterator<PackageRelationship> iterator() {
        return this.relationshipsByID.values().iterator();
    }

    public Iterator<PackageRelationship> iterator(String str) {
        ArrayList arrayList = new ArrayList();
        for (PackageRelationship packageRelationship : this.relationshipsByID.values()) {
            if (packageRelationship.getRelationshipType().equals(str)) {
                arrayList.add(packageRelationship);
            }
        }
        return arrayList.iterator();
    }

    public void clear() {
        this.relationshipsByID.clear();
        this.relationshipsByType.clear();
    }

    public String toString() {
        String str;
        String str2;
        String str3;
        String str4 = this.relationshipsByID == null ? "relationshipsByID=null" : this.relationshipsByID.size() + " relationship(s) = [";
        PackagePart packagePart = this.relationshipPart;
        if (packagePart != null && packagePart._partName != null) {
            str = str4 + "," + this.relationshipPart._partName;
        } else {
            str = str4 + ",relationshipPart=null";
        }
        PackagePart packagePart2 = this.sourcePart;
        if (packagePart2 != null && packagePart2._partName != null) {
            str2 = str + "," + this.sourcePart._partName;
        } else {
            str2 = str + ",sourcePart=null";
        }
        if (this.partName != null) {
            str3 = str2 + "," + this.partName;
        } else {
            str3 = str2 + ",uri=null)";
        }
        return str3 + "]";
    }
}
