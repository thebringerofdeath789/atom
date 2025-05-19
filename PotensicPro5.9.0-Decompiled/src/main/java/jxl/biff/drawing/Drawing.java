package jxl.biff.drawing;

import common.Assert;
import common.LengthConverter;
import common.LengthUnit;
import common.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import jxl.Image;
import jxl.Sheet;

/* loaded from: classes4.dex */
public class Drawing implements DrawingGroupObject, Image {
    private static final double DEFAULT_FONT_SIZE = 10.0d;
    static /* synthetic */ Class class$jxl$biff$drawing$Drawing;
    private static Logger logger;
    private int blipId;
    private DrawingData drawingData;
    private DrawingGroup drawingGroup;
    private int drawingNumber;
    private EscherContainer escherData;
    private double height;
    private byte[] imageData;
    private File imageFile;
    private boolean initialized;
    private MsoDrawingRecord msoDrawingRecord;
    private ObjRecord objRecord;
    private int objectId;
    private Origin origin;
    private PNGReader pngReader;
    private EscherContainer readSpContainer;
    private int referenceCount;
    private int shapeId;
    private Sheet sheet;
    private ShapeType type;
    private double width;
    private double x;
    private double y;

    @Override // jxl.biff.drawing.DrawingGroupObject
    public boolean isFormObject() {
        return false;
    }

    @Override // jxl.biff.drawing.DrawingGroupObject
    public void writeTailRecords(jxl.write.biff.File file) throws IOException {
    }

    static {
        Class cls = class$jxl$biff$drawing$Drawing;
        if (cls == null) {
            cls = class$("jxl.biff.drawing.Drawing");
            class$jxl$biff$drawing$Drawing = cls;
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

    public Drawing(MsoDrawingRecord msoDrawingRecord, ObjRecord objRecord, DrawingData drawingData, DrawingGroup drawingGroup, Sheet sheet) {
        boolean z = false;
        this.initialized = false;
        this.drawingGroup = drawingGroup;
        this.msoDrawingRecord = msoDrawingRecord;
        this.drawingData = drawingData;
        this.objRecord = objRecord;
        this.sheet = sheet;
        this.initialized = false;
        this.origin = Origin.READ;
        this.drawingData.addData(this.msoDrawingRecord.getData());
        this.drawingNumber = this.drawingData.getNumDrawings() - 1;
        this.drawingGroup.addDrawing(this);
        if (msoDrawingRecord != null && objRecord != null) {
            z = true;
        }
        Assert.verify(z);
        initialize();
    }

    protected Drawing(DrawingGroupObject drawingGroupObject, DrawingGroup drawingGroup) {
        this.initialized = false;
        Drawing drawing = (Drawing) drawingGroupObject;
        Assert.verify(drawing.origin == Origin.READ);
        this.msoDrawingRecord = drawing.msoDrawingRecord;
        this.objRecord = drawing.objRecord;
        this.initialized = false;
        this.origin = Origin.READ;
        this.drawingData = drawing.drawingData;
        this.drawingGroup = drawingGroup;
        this.drawingNumber = drawing.drawingNumber;
        drawingGroup.addDrawing(this);
    }

    public Drawing(double d, double d2, double d3, double d4, File file) {
        this.initialized = false;
        this.imageFile = file;
        this.initialized = true;
        this.origin = Origin.WRITE;
        this.x = d;
        this.y = d2;
        this.width = d3;
        this.height = d4;
        this.referenceCount = 1;
        this.type = ShapeType.PICTURE_FRAME;
    }

    public Drawing(double d, double d2, double d3, double d4, byte[] bArr) {
        this.initialized = false;
        this.imageData = bArr;
        this.initialized = true;
        this.origin = Origin.WRITE;
        this.x = d;
        this.y = d2;
        this.width = d3;
        this.height = d4;
        this.referenceCount = 1;
        this.type = ShapeType.PICTURE_FRAME;
    }

    private void initialize() {
        EscherContainer spContainer = this.drawingData.getSpContainer(this.drawingNumber);
        this.readSpContainer = spContainer;
        Assert.verify(spContainer != null);
        EscherRecord[] children = this.readSpContainer.getChildren();
        Sp sp = (Sp) this.readSpContainer.getChildren()[0];
        this.shapeId = sp.getShapeId();
        this.objectId = this.objRecord.getObjectId();
        ShapeType type = ShapeType.getType(sp.getShapeType());
        this.type = type;
        if (type == ShapeType.UNKNOWN) {
            logger.warn("Unknown shape type");
        }
        Opt opt = (Opt) this.readSpContainer.getChildren()[1];
        if (opt.getProperty(260) != null) {
            this.blipId = opt.getProperty(260).value;
        }
        if (opt.getProperty(261) != null) {
            this.imageFile = new File(opt.getProperty(261).stringValue);
        } else if (this.type == ShapeType.PICTURE_FRAME) {
            logger.warn("no filename property for drawing");
            this.imageFile = new File(Integer.toString(this.blipId));
        }
        ClientAnchor clientAnchor = null;
        for (int i = 0; i < children.length && clientAnchor == null; i++) {
            if (children[i].getType() == EscherRecordType.CLIENT_ANCHOR) {
                clientAnchor = (ClientAnchor) children[i];
            }
        }
        if (clientAnchor == null) {
            logger.warn("client anchor not found");
        } else {
            this.x = clientAnchor.getX1();
            this.y = clientAnchor.getY1();
            this.width = clientAnchor.getX2() - this.x;
            this.height = clientAnchor.getY2() - this.y;
        }
        if (this.blipId == 0) {
            logger.warn("linked drawings are not supported");
        }
        this.initialized = true;
    }

    @Override // jxl.Image
    public File getImageFile() {
        return this.imageFile;
    }

    @Override // jxl.biff.drawing.DrawingGroupObject
    public String getImageFilePath() {
        File file = this.imageFile;
        if (file == null) {
            int i = this.blipId;
            return i != 0 ? Integer.toString(i) : "__new__image__";
        }
        return file.getPath();
    }

    @Override // jxl.biff.drawing.DrawingGroupObject
    public final void setObjectId(int i, int i2, int i3) {
        this.objectId = i;
        this.blipId = i2;
        this.shapeId = i3;
        if (this.origin == Origin.READ) {
            this.origin = Origin.READ_WRITE;
        }
    }

    @Override // jxl.biff.drawing.DrawingGroupObject
    public final int getObjectId() {
        if (!this.initialized) {
            initialize();
        }
        return this.objectId;
    }

    @Override // jxl.biff.drawing.DrawingGroupObject
    public int getShapeId() {
        if (!this.initialized) {
            initialize();
        }
        return this.shapeId;
    }

    @Override // jxl.biff.drawing.DrawingGroupObject
    public final int getBlipId() {
        if (!this.initialized) {
            initialize();
        }
        return this.blipId;
    }

    @Override // jxl.biff.drawing.DrawingGroupObject
    public MsoDrawingRecord getMsoDrawingRecord() {
        return this.msoDrawingRecord;
    }

    @Override // jxl.biff.drawing.DrawingGroupObject
    public EscherContainer getSpContainer() {
        if (!this.initialized) {
            initialize();
        }
        if (this.origin == Origin.READ) {
            return getReadSpContainer();
        }
        SpContainer spContainer = new SpContainer();
        spContainer.add(new Sp(this.type, this.shapeId, 2560));
        Opt opt = new Opt();
        opt.addProperty(260, true, false, this.blipId);
        if (this.type == ShapeType.PICTURE_FRAME) {
            File file = this.imageFile;
            String path = file != null ? file.getPath() : "";
            opt.addProperty(261, true, true, path.length() * 2, path);
            opt.addProperty(447, false, false, 65536);
            opt.addProperty(959, false, false, 524288);
            spContainer.add(opt);
        }
        double d = this.x;
        double d2 = this.y;
        spContainer.add(new ClientAnchor(d, d2, d + this.width, d2 + this.height));
        spContainer.add(new ClientData());
        return spContainer;
    }

    @Override // jxl.biff.drawing.DrawingGroupObject
    public void setDrawingGroup(DrawingGroup drawingGroup) {
        this.drawingGroup = drawingGroup;
    }

    @Override // jxl.biff.drawing.DrawingGroupObject
    public DrawingGroup getDrawingGroup() {
        return this.drawingGroup;
    }

    @Override // jxl.biff.drawing.DrawingGroupObject
    public Origin getOrigin() {
        return this.origin;
    }

    @Override // jxl.biff.drawing.DrawingGroupObject
    public int getReferenceCount() {
        return this.referenceCount;
    }

    @Override // jxl.biff.drawing.DrawingGroupObject
    public void setReferenceCount(int i) {
        this.referenceCount = i;
    }

    @Override // jxl.biff.drawing.DrawingGroupObject
    public double getX() {
        if (!this.initialized) {
            initialize();
        }
        return this.x;
    }

    @Override // jxl.biff.drawing.DrawingGroupObject
    public void setX(double d) {
        if (this.origin == Origin.READ) {
            if (!this.initialized) {
                initialize();
            }
            this.origin = Origin.READ_WRITE;
        }
        this.x = d;
    }

    @Override // jxl.biff.drawing.DrawingGroupObject
    public double getY() {
        if (!this.initialized) {
            initialize();
        }
        return this.y;
    }

    @Override // jxl.biff.drawing.DrawingGroupObject
    public void setY(double d) {
        if (this.origin == Origin.READ) {
            if (!this.initialized) {
                initialize();
            }
            this.origin = Origin.READ_WRITE;
        }
        this.y = d;
    }

    @Override // jxl.biff.drawing.DrawingGroupObject
    public double getWidth() {
        if (!this.initialized) {
            initialize();
        }
        return this.width;
    }

    @Override // jxl.biff.drawing.DrawingGroupObject
    public void setWidth(double d) {
        if (this.origin == Origin.READ) {
            if (!this.initialized) {
                initialize();
            }
            this.origin = Origin.READ_WRITE;
        }
        this.width = d;
    }

    @Override // jxl.biff.drawing.DrawingGroupObject
    public double getHeight() {
        if (!this.initialized) {
            initialize();
        }
        return this.height;
    }

    @Override // jxl.biff.drawing.DrawingGroupObject
    public void setHeight(double d) {
        if (this.origin == Origin.READ) {
            if (!this.initialized) {
                initialize();
            }
            this.origin = Origin.READ_WRITE;
        }
        this.height = d;
    }

    private EscherContainer getReadSpContainer() {
        if (!this.initialized) {
            initialize();
        }
        return this.readSpContainer;
    }

    @Override // jxl.biff.drawing.DrawingGroupObject
    public byte[] getImageData() {
        Assert.verify(this.origin == Origin.READ || this.origin == Origin.READ_WRITE);
        if (!this.initialized) {
            initialize();
        }
        return this.drawingGroup.getImageData(this.blipId);
    }

    @Override // jxl.biff.drawing.DrawingGroupObject
    public byte[] getImageBytes() throws IOException {
        if (this.origin == Origin.READ || this.origin == Origin.READ_WRITE) {
            return getImageData();
        }
        Assert.verify(this.origin == Origin.WRITE);
        File file = this.imageFile;
        if (file == null) {
            Assert.verify(this.imageData != null);
            return this.imageData;
        }
        int length = (int) file.length();
        byte[] bArr = new byte[length];
        FileInputStream fileInputStream = new FileInputStream(this.imageFile);
        fileInputStream.read(bArr, 0, length);
        fileInputStream.close();
        return bArr;
    }

    @Override // jxl.biff.drawing.DrawingGroupObject
    public ShapeType getType() {
        return this.type;
    }

    @Override // jxl.biff.drawing.DrawingGroupObject
    public void writeAdditionalRecords(jxl.write.biff.File file) throws IOException {
        if (this.origin == Origin.READ) {
            file.write(this.objRecord);
        } else {
            file.write(new ObjRecord(this.objectId, ObjRecord.PICTURE));
        }
    }

    @Override // jxl.Image
    public double getColumn() {
        return getX();
    }

    @Override // jxl.Image
    public double getRow() {
        return getY();
    }

    @Override // jxl.biff.drawing.DrawingGroupObject
    public boolean isFirst() {
        return this.msoDrawingRecord.isFirst();
    }

    public void removeRow(int i) {
        double d = i;
        if (this.y > d) {
            setY(d);
        }
    }

    private double getWidthInPoints() {
        double d;
        if (this.sheet == null) {
            logger.warn("calculating image width:  sheet is null");
            return 0.0d;
        }
        double d2 = this.x;
        int i = (int) d2;
        int ceil = ((int) Math.ceil(d2 + this.width)) - 1;
        double size = ((((1.0d - (this.x - i)) * r5.getSize()) * 0.59d) * (this.sheet.getColumnView(i).getFormat() != null ? r5.getFormat().getFont().getPointSize() : DEFAULT_FONT_SIZE)) / 256.0d;
        if (ceil != i) {
            d = (((((this.x + this.width) - ceil) * r13.getSize()) * 0.59d) * (this.sheet.getColumnView(ceil).getFormat() != null ? r13.getFormat().getFont().getPointSize() : DEFAULT_FONT_SIZE)) / 256.0d;
        } else {
            d = 0.0d;
        }
        double d3 = 0.0d;
        for (int i2 = 0; i2 < (ceil - i) - 1; i2++) {
            d3 += ((r10.getSize() * 0.59d) * (this.sheet.getColumnView((i + 1) + i2).getFormat() != null ? r10.getFormat().getFont().getPointSize() : DEFAULT_FONT_SIZE)) / 256.0d;
        }
        return d3 + size + d;
    }

    private double getHeightInPoints() {
        double d = 0.0d;
        if (this.sheet == null) {
            logger.warn("calculating image height:  sheet is null");
            return 0.0d;
        }
        double d2 = this.y;
        int i = (int) d2;
        int ceil = ((int) Math.ceil(d2 + this.height)) - 1;
        double size = this.sheet.getRowView(i).getSize();
        int size2 = ceil != i ? this.sheet.getRowView(ceil).getSize() : 0;
        for (int i2 = 0; i2 < (ceil - i) - 1; i2++) {
            d += this.sheet.getRowView(i + 1 + i2).getSize();
        }
        return ((d + size) + size2) / 20.0d;
    }

    @Override // jxl.Image
    public double getWidth(LengthUnit lengthUnit) {
        return getWidthInPoints() * LengthConverter.getConversionFactor(LengthUnit.POINTS, lengthUnit);
    }

    @Override // jxl.Image
    public double getHeight(LengthUnit lengthUnit) {
        return getHeightInPoints() * LengthConverter.getConversionFactor(LengthUnit.POINTS, lengthUnit);
    }

    @Override // jxl.Image
    public int getImageWidth() {
        return getPngReader().getWidth();
    }

    @Override // jxl.Image
    public int getImageHeight() {
        return getPngReader().getHeight();
    }

    @Override // jxl.Image
    public double getHorizontalResolution(LengthUnit lengthUnit) {
        return getPngReader().getHorizontalResolution() / LengthConverter.getConversionFactor(LengthUnit.METRES, lengthUnit);
    }

    @Override // jxl.Image
    public double getVerticalResolution(LengthUnit lengthUnit) {
        return getPngReader().getVerticalResolution() / LengthConverter.getConversionFactor(LengthUnit.METRES, lengthUnit);
    }

    private PNGReader getPngReader() {
        byte[] imageData;
        PNGReader pNGReader = this.pngReader;
        if (pNGReader != null) {
            return pNGReader;
        }
        if (this.origin == Origin.READ || this.origin == Origin.READ_WRITE) {
            imageData = getImageData();
        } else {
            try {
                imageData = getImageBytes();
            } catch (IOException unused) {
                logger.warn("Could not read image file");
                imageData = new byte[0];
            }
        }
        PNGReader pNGReader2 = new PNGReader(imageData);
        this.pngReader = pNGReader2;
        pNGReader2.read();
        return this.pngReader;
    }
}
