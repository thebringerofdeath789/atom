package jxl.biff.drawing;

import common.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import jxl.WorkbookSettings;
import jxl.biff.IntegerHelper;
import jxl.write.biff.File;

/* loaded from: classes4.dex */
public class SheetDrawingWriter {
    static /* synthetic */ Class class$jxl$biff$drawing$SheetDrawingWriter;
    private static Logger logger;
    private Chart[] charts = new Chart[0];
    private ArrayList drawings;
    private boolean drawingsModified;
    private WorkbookSettings workbookSettings;

    static {
        Class cls = class$jxl$biff$drawing$SheetDrawingWriter;
        if (cls == null) {
            cls = class$("jxl.biff.drawing.SheetDrawingWriter");
            class$jxl$biff$drawing$SheetDrawingWriter = cls;
        }
        logger = Logger.getLogger(cls);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public SheetDrawingWriter(WorkbookSettings workbookSettings) {
    }

    public void setDrawings(ArrayList arrayList, boolean z) {
        this.drawings = arrayList;
        this.drawingsModified = z;
    }

    public void write(File file) throws IOException {
        int i;
        if (this.drawings.size() == 0 && this.charts.length == 0) {
            return;
        }
        boolean z = this.drawingsModified;
        int size = this.drawings.size();
        Iterator it = this.drawings.iterator();
        while (true) {
            if (!it.hasNext() || z) {
                break;
            } else if (((DrawingGroupObject) it.next()).getOrigin() != Origin.READ) {
                z = true;
            }
        }
        if (size > 0 && !z && !((DrawingGroupObject) this.drawings.get(0)).isFirst()) {
            z = true;
        }
        if (size == 0) {
            Chart[] chartArr = this.charts;
            if (chartArr.length == 1 && chartArr[0].getMsoDrawingRecord() == null) {
                z = false;
            }
        }
        if (!z) {
            writeUnmodified(file);
            return;
        }
        int length = this.charts.length + size;
        Object[] objArr = new Object[length];
        EscherContainer escherContainer = null;
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            EscherContainer spContainer = ((DrawingGroupObject) this.drawings.get(i3)).getSpContainer();
            if (spContainer != null) {
                byte[] data = spContainer.getData();
                objArr[i3] = data;
                if (i3 == 0) {
                    escherContainer = spContainer;
                } else {
                    i2 += data.length;
                }
            }
        }
        int i4 = 0;
        while (true) {
            Chart[] chartArr2 = this.charts;
            if (i4 >= chartArr2.length) {
                break;
            }
            EscherContainer spContainer2 = chartArr2[i4].getSpContainer();
            byte[] headerData = spContainer2.setHeaderData(spContainer2.getBytes());
            objArr[i4 + size] = headerData;
            if (i4 == 0 && size == 0) {
                escherContainer = spContainer2;
            } else {
                i2 += headerData.length;
            }
            i4++;
        }
        DgContainer dgContainer = new DgContainer();
        dgContainer.add(new Dg(this.charts.length + size));
        SpgrContainer spgrContainer = new SpgrContainer();
        SpContainer spContainer3 = new SpContainer();
        spContainer3.add(new Spgr());
        spContainer3.add(new Sp(ShapeType.MIN, 1024, 5));
        spgrContainer.add(spContainer3);
        spgrContainer.add(escherContainer);
        dgContainer.add(spgrContainer);
        byte[] data2 = dgContainer.getData();
        IntegerHelper.getFourBytes(IntegerHelper.getInt(data2[4], data2[5], data2[6], data2[7]) + i2, data2, 4);
        IntegerHelper.getFourBytes(IntegerHelper.getInt(data2[28], data2[29], data2[30], data2[31]) + i2, data2, 28);
        if (size > 0 && ((DrawingGroupObject) this.drawings.get(0)).isFormObject()) {
            int length2 = data2.length - 8;
            byte[] bArr = new byte[length2];
            System.arraycopy(data2, 0, bArr, 0, length2);
            data2 = bArr;
        }
        file.write(new MsoDrawingRecord(data2));
        if (size > 0) {
            ((DrawingGroupObject) this.drawings.get(0)).writeAdditionalRecords(file);
        } else {
            Chart chart = this.charts[0];
            file.write(chart.getObjRecord());
            file.write(chart);
        }
        for (i = 1; i < length; i++) {
            byte[] bArr2 = (byte[]) objArr[i];
            if (i < size && ((DrawingGroupObject) this.drawings.get(i)).isFormObject()) {
                int length3 = bArr2.length - 8;
                byte[] bArr3 = new byte[length3];
                System.arraycopy(bArr2, 0, bArr3, 0, length3);
                bArr2 = bArr3;
            }
            file.write(new MsoDrawingRecord(bArr2));
            if (i < size) {
                ((DrawingGroupObject) this.drawings.get(i)).writeAdditionalRecords(file);
            } else {
                Chart chart2 = this.charts[i - size];
                file.write(chart2.getObjRecord());
                file.write(chart2);
            }
        }
        Iterator it2 = this.drawings.iterator();
        while (it2.hasNext()) {
            ((DrawingGroupObject) it2.next()).writeTailRecords(file);
        }
    }

    private void writeUnmodified(File file) throws IOException {
        if (this.charts.length == 0 && this.drawings.size() == 0) {
            return;
        }
        if (this.charts.length == 0 && this.drawings.size() != 0) {
            Iterator it = this.drawings.iterator();
            while (it.hasNext()) {
                DrawingGroupObject drawingGroupObject = (DrawingGroupObject) it.next();
                file.write(drawingGroupObject.getMsoDrawingRecord());
                drawingGroupObject.writeAdditionalRecords(file);
            }
            Iterator it2 = this.drawings.iterator();
            while (it2.hasNext()) {
                ((DrawingGroupObject) it2.next()).writeTailRecords(file);
            }
            return;
        }
        int i = 0;
        if (this.drawings.size() != 0 || this.charts.length == 0) {
            int size = this.drawings.size();
            Chart[] chartArr = this.charts;
            int length = chartArr.length + size;
            EscherContainer[] escherContainerArr = new EscherContainer[length];
            boolean[] zArr = new boolean[chartArr.length + size];
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                DrawingGroupObject drawingGroupObject2 = (DrawingGroupObject) this.drawings.get(i3);
                escherContainerArr[i3] = drawingGroupObject2.getSpContainer();
                if (i3 > 0) {
                    i2 += escherContainerArr[i3].getLength();
                }
                if (drawingGroupObject2.isFormObject()) {
                    zArr[i3] = true;
                }
            }
            int i4 = 0;
            while (true) {
                Chart[] chartArr2 = this.charts;
                if (i4 >= chartArr2.length) {
                    break;
                }
                int i5 = i4 + size;
                escherContainerArr[i5] = chartArr2[i4].getSpContainer();
                i2 += escherContainerArr[i5].getLength();
                i4++;
            }
            DgContainer dgContainer = new DgContainer();
            dgContainer.add(new Dg(this.charts.length + size));
            SpgrContainer spgrContainer = new SpgrContainer();
            SpContainer spContainer = new SpContainer();
            spContainer.add(new Spgr());
            spContainer.add(new Sp(ShapeType.MIN, 1024, 5));
            spgrContainer.add(spContainer);
            spgrContainer.add(escherContainerArr[0]);
            dgContainer.add(spgrContainer);
            byte[] data = dgContainer.getData();
            IntegerHelper.getFourBytes(IntegerHelper.getInt(data[4], data[5], data[6], data[7]) + i2, data, 4);
            IntegerHelper.getFourBytes(IntegerHelper.getInt(data[28], data[29], data[30], data[31]) + i2, data, 28);
            if (zArr[0]) {
                int length2 = data.length - 8;
                byte[] bArr = new byte[length2];
                System.arraycopy(data, 0, bArr, 0, length2);
                data = bArr;
            }
            file.write(new MsoDrawingRecord(data));
            ((DrawingGroupObject) this.drawings.get(0)).writeAdditionalRecords(file);
            for (int i6 = 1; i6 < length; i6++) {
                byte[] headerData = escherContainerArr[i6].setHeaderData(escherContainerArr[i6].getBytes());
                if (zArr[i6]) {
                    int length3 = headerData.length - 8;
                    byte[] bArr2 = new byte[length3];
                    System.arraycopy(headerData, 0, bArr2, 0, length3);
                    headerData = bArr2;
                }
                file.write(new MsoDrawingRecord(headerData));
                if (i6 < size) {
                    ((DrawingGroupObject) this.drawings.get(i6)).writeAdditionalRecords(file);
                } else {
                    Chart chart = this.charts[i6 - size];
                    file.write(chart.getObjRecord());
                    file.write(chart);
                }
            }
            Iterator it3 = this.drawings.iterator();
            while (it3.hasNext()) {
                ((DrawingGroupObject) it3.next()).writeTailRecords(file);
            }
            return;
        }
        while (true) {
            Chart[] chartArr3 = this.charts;
            if (i >= chartArr3.length) {
                return;
            }
            Chart chart2 = chartArr3[i];
            if (chart2.getMsoDrawingRecord() != null) {
                file.write(chart2.getMsoDrawingRecord());
            }
            if (chart2.getObjRecord() != null) {
                file.write(chart2.getObjRecord());
            }
            file.write(chart2);
            i++;
        }
    }

    public void setCharts(Chart[] chartArr) {
        this.charts = chartArr;
    }

    public Chart[] getCharts() {
        return this.charts;
    }
}
