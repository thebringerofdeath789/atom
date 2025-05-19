package jxl.demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import jxl.WorkbookSettings;
import jxl.biff.BaseCompoundFile;
import jxl.read.biff.BiffException;
import jxl.read.biff.CompoundFile;

/* loaded from: classes4.dex */
class PropertySetsReader {
    private CompoundFile compoundFile;
    private BufferedWriter writer;

    public PropertySetsReader(File file, String str, OutputStream outputStream) throws IOException, BiffException {
        this.writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[1048576];
        int read = fileInputStream.read(bArr);
        int i = read;
        while (read != -1) {
            if (i >= bArr.length) {
                byte[] bArr2 = new byte[bArr.length + 1048576];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                bArr = bArr2;
            }
            read = fileInputStream.read(bArr, i, bArr.length - i);
            i += read;
        }
        this.compoundFile = new CompoundFile(bArr, new WorkbookSettings());
        fileInputStream.close();
        if (str == null) {
            displaySets();
        } else {
            displayPropertySet(str, outputStream);
        }
    }

    void displaySets() throws IOException {
        int numberOfPropertySets = this.compoundFile.getNumberOfPropertySets();
        for (int i = 0; i < numberOfPropertySets; i++) {
            BaseCompoundFile.PropertyStorage propertySet = this.compoundFile.getPropertySet(i);
            this.writer.write(Integer.toString(i));
            this.writer.write(") ");
            this.writer.write(propertySet.name);
            this.writer.write("(type ");
            this.writer.write(Integer.toString(propertySet.type));
            this.writer.write(" size ");
            this.writer.write(Integer.toString(propertySet.size));
            this.writer.write(" prev ");
            this.writer.write(Integer.toString(propertySet.previous));
            this.writer.write(" next ");
            this.writer.write(Integer.toString(propertySet.next));
            this.writer.write(" child ");
            this.writer.write(Integer.toString(propertySet.child));
            this.writer.write(" start block ");
            this.writer.write(Integer.toString(propertySet.startBlock));
            this.writer.write(")");
            this.writer.newLine();
        }
        this.writer.flush();
        this.writer.close();
    }

    void displayPropertySet(String str, OutputStream outputStream) throws IOException, BiffException {
        if (str.equalsIgnoreCase("SummaryInformation")) {
            str = "\u0005SummaryInformation";
        } else if (str.equalsIgnoreCase("DocumentSummaryInformation")) {
            str = "\u0005DocumentSummaryInformation";
        } else if (str.equalsIgnoreCase("CompObj")) {
            str = BaseCompoundFile.COMP_OBJ_NAME;
        }
        outputStream.write(this.compoundFile.getStream(str));
    }
}
