package org.apache.poi.openxml4j.opc;

import java.util.ArrayList;
import java.util.TreeMap;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;

/* loaded from: classes5.dex */
public final class PackagePartCollection extends TreeMap<PackagePartName, PackagePart> {
    private static final long serialVersionUID = 2515031135957635515L;
    private ArrayList<String> registerPartNameStr = new ArrayList<>();

    @Override // java.util.TreeMap, java.util.AbstractMap
    public Object clone() {
        return super.clone();
    }

    @Override // java.util.TreeMap, java.util.AbstractMap, java.util.Map
    public PackagePart put(PackagePartName packagePartName, PackagePart packagePart) {
        String[] split = packagePartName.getURI().toASCIIString().split(PackagingURIHelper.FORWARD_SLASH_STRING);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : split) {
            if (!str.equals("")) {
                stringBuffer.append(PackagingURIHelper.FORWARD_SLASH_CHAR);
            }
            stringBuffer.append(str);
            if (this.registerPartNameStr.contains(stringBuffer.toString())) {
                throw new InvalidOperationException("You can't add a part with a part name derived from another part ! [M1.11]");
            }
        }
        this.registerPartNameStr.add(packagePartName.getName());
        return (PackagePart) super.put((PackagePartCollection) packagePartName, (PackagePartName) packagePart);
    }

    @Override // java.util.TreeMap, java.util.AbstractMap, java.util.Map
    public PackagePart remove(Object obj) {
        if (obj instanceof PackagePartName) {
            this.registerPartNameStr.remove(((PackagePartName) obj).getName());
        }
        return (PackagePart) super.remove(obj);
    }
}
