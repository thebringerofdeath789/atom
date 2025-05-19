package org.apache.poi.dev;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Iterator;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;

/* loaded from: classes4.dex */
public class OOXMLLister {
    private OPCPackage container;
    private PrintStream disp;

    public OOXMLLister(OPCPackage oPCPackage) {
        this(oPCPackage, System.out);
    }

    public OOXMLLister(OPCPackage oPCPackage, PrintStream printStream) {
        this.container = oPCPackage;
        this.disp = printStream;
    }

    public static long getSize(PackagePart packagePart) throws IOException {
        InputStream inputStream = packagePart.getInputStream();
        byte[] bArr = new byte[8192];
        long j = 0;
        int i = 0;
        while (i > -1) {
            i = inputStream.read(bArr);
            if (i > 0) {
                j += i;
            }
        }
        return j;
    }

    public void displayParts() throws Exception {
        Iterator<PackagePart> it = this.container.getParts().iterator();
        while (it.hasNext()) {
            PackagePart next = it.next();
            this.disp.println(next.getPartName());
            this.disp.println("\t" + next.getContentType());
            if (!next.getPartName().toString().equals("/docProps/core.xml")) {
                this.disp.println("\t" + getSize(next) + " bytes");
            }
            if (!next.isRelationshipPart()) {
                this.disp.println("\t" + next.getRelationships().size() + " relations");
                Iterator<PackageRelationship> it2 = next.getRelationships().iterator();
                while (it2.hasNext()) {
                    displayRelation(it2.next(), "\t  ");
                }
            }
        }
    }

    public void displayRelations() throws Exception {
        Iterator<PackageRelationship> it = this.container.getRelationships().iterator();
        while (it.hasNext()) {
            displayRelation(it.next(), "");
        }
    }

    private void displayRelation(PackageRelationship packageRelationship, String str) {
        this.disp.println(str + "Relationship:");
        this.disp.println(str + "\tFrom: " + packageRelationship.getSourceURI());
        this.disp.println(str + "\tTo:   " + packageRelationship.getTargetURI());
        this.disp.println(str + "\tID:   " + packageRelationship.getId());
        this.disp.println(str + "\tMode: " + packageRelationship.getTargetMode());
        this.disp.println(str + "\tType: " + packageRelationship.getRelationshipType());
    }

    public static void main(String[] strArr) throws Exception {
        if (strArr.length == 0) {
            System.err.println("Use:");
            System.err.println("\tjava OOXMLLister <filename>");
            System.exit(1);
        }
        File file = new File(strArr[0]);
        if (!file.exists()) {
            System.err.println("Error, file not found!");
            System.err.println("\t" + file.toString());
            System.exit(2);
        }
        OOXMLLister oOXMLLister = new OOXMLLister(OPCPackage.open(file.toString(), PackageAccess.READ));
        oOXMLLister.disp.println(file.toString() + "\n");
        oOXMLLister.displayParts();
        oOXMLLister.disp.println();
        oOXMLLister.displayRelations();
    }
}
