package jxl.biff.drawing;

/* loaded from: classes4.dex */
final class ShapeType {
    private int value;
    private static ShapeType[] types = new ShapeType[0];
    public static final ShapeType MIN = new ShapeType(0);
    public static final ShapeType PICTURE_FRAME = new ShapeType(75);
    public static final ShapeType HOST_CONTROL = new ShapeType(201);
    public static final ShapeType TEXT_BOX = new ShapeType(202);
    public static final ShapeType UNKNOWN = new ShapeType(-1);

    ShapeType(int i) {
        this.value = i;
        ShapeType[] shapeTypeArr = types;
        ShapeType[] shapeTypeArr2 = new ShapeType[shapeTypeArr.length + 1];
        types = shapeTypeArr2;
        System.arraycopy(shapeTypeArr, 0, shapeTypeArr2, 0, shapeTypeArr.length);
        types[shapeTypeArr.length] = this;
    }

    static ShapeType getType(int i) {
        ShapeType shapeType = UNKNOWN;
        int i2 = 0;
        boolean z = false;
        while (true) {
            ShapeType[] shapeTypeArr = types;
            if (i2 >= shapeTypeArr.length || z) {
                break;
            }
            if (shapeTypeArr[i2].value == i) {
                shapeType = shapeTypeArr[i2];
                z = true;
            }
            i2++;
        }
        return shapeType;
    }

    public int getValue() {
        return this.value;
    }
}
