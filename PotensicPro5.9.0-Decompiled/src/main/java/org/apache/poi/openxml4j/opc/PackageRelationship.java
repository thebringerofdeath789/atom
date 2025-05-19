package org.apache.poi.openxml4j.opc;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.net.URI;
import java.net.URISyntaxException;
import net.lingala.zip4j.util.InternalZipConstants;

/* loaded from: classes5.dex */
public final class PackageRelationship {
    public static final String ID_ATTRIBUTE_NAME = "Id";
    public static final String RELATIONSHIPS_TAG_NAME = "Relationships";
    public static final String RELATIONSHIP_TAG_NAME = "Relationship";
    public static final String TARGET_ATTRIBUTE_NAME = "Target";
    public static final String TARGET_MODE_ATTRIBUTE_NAME = "TargetMode";
    public static final String TYPE_ATTRIBUTE_NAME = "Type";
    private static URI containerRelationshipPart;
    private OPCPackage container;
    private String id;
    private String relationshipType;
    private PackagePart source;
    private TargetMode targetMode;
    private URI targetUri;

    static {
        try {
            containerRelationshipPart = new URI("/_rels/.rels");
        } catch (URISyntaxException unused) {
        }
    }

    public PackageRelationship(OPCPackage oPCPackage, PackagePart packagePart, URI uri, TargetMode targetMode, String str, String str2) {
        if (oPCPackage == null) {
            throw new IllegalArgumentException("pkg");
        }
        if (uri == null) {
            throw new IllegalArgumentException("targetUri");
        }
        if (str == null) {
            throw new IllegalArgumentException("relationshipType");
        }
        if (str2 == null) {
            throw new IllegalArgumentException(TtmlNode.ATTR_ID);
        }
        this.container = oPCPackage;
        this.source = packagePart;
        this.targetUri = uri;
        this.targetMode = targetMode;
        this.relationshipType = str;
        this.id = str2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PackageRelationship)) {
            return false;
        }
        PackageRelationship packageRelationship = (PackageRelationship) obj;
        if (!this.id.equals(packageRelationship.id) || !this.relationshipType.equals(packageRelationship.relationshipType)) {
            return false;
        }
        PackagePart packagePart = packageRelationship.source;
        return (packagePart == null || packagePart.equals(this.source)) && this.targetMode == packageRelationship.targetMode && this.targetUri.equals(packageRelationship.targetUri);
    }

    public int hashCode() {
        int hashCode = this.id.hashCode() + this.relationshipType.hashCode();
        PackagePart packagePart = this.source;
        return hashCode + (packagePart == null ? 0 : packagePart.hashCode()) + this.targetMode.hashCode() + this.targetUri.hashCode();
    }

    public static URI getContainerPartRelationship() {
        return containerRelationshipPart;
    }

    public OPCPackage getPackage() {
        return this.container;
    }

    public String getId() {
        return this.id;
    }

    public String getRelationshipType() {
        return this.relationshipType;
    }

    public PackagePart getSource() {
        return this.source;
    }

    public URI getSourceURI() {
        PackagePart packagePart = this.source;
        if (packagePart == null) {
            return PackagingURIHelper.PACKAGE_ROOT_URI;
        }
        return packagePart._partName.getURI();
    }

    public TargetMode getTargetMode() {
        return this.targetMode;
    }

    public URI getTargetURI() {
        if (this.targetMode == TargetMode.EXTERNAL) {
            return this.targetUri;
        }
        if (!this.targetUri.toASCIIString().startsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            return PackagingURIHelper.resolvePartUri(getSourceURI(), this.targetUri);
        }
        return this.targetUri;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.id == null ? "id=null" : "id=" + this.id);
        sb.append(this.container == null ? " - container=null" : " - container=" + this.container.toString());
        sb.append(this.relationshipType == null ? " - relationshipType=null" : " - relationshipType=" + this.relationshipType);
        sb.append(this.source == null ? " - source=null" : " - source=" + getSourceURI().toASCIIString());
        sb.append(this.targetUri == null ? " - target=null" : " - target=" + getTargetURI().toASCIIString());
        sb.append(this.targetMode == null ? ",targetMode=null" : ",targetMode=" + this.targetMode.toString());
        return sb.toString();
    }
}
