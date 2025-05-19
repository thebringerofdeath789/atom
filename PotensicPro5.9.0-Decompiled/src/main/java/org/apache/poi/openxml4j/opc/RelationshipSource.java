package org.apache.poi.openxml4j.opc;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;

/* loaded from: classes5.dex */
public interface RelationshipSource {
    PackageRelationship addExternalRelationship(String str, String str2);

    PackageRelationship addExternalRelationship(String str, String str2, String str3);

    PackageRelationship addRelationship(PackagePartName packagePartName, TargetMode targetMode, String str);

    PackageRelationship addRelationship(PackagePartName packagePartName, TargetMode targetMode, String str, String str2);

    void clearRelationships();

    PackageRelationship getRelationship(String str);

    PackageRelationshipCollection getRelationships() throws InvalidFormatException, OpenXML4JException;

    PackageRelationshipCollection getRelationshipsByType(String str) throws InvalidFormatException, IllegalArgumentException, OpenXML4JException;

    boolean hasRelationships();

    boolean isRelationshipExists(PackageRelationship packageRelationship);

    void removeRelationship(String str);
}
