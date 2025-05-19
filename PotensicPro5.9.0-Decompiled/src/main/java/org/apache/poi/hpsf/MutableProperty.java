package org.apache.poi.hpsf;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public class MutableProperty extends Property {
    public MutableProperty() {
    }

    public MutableProperty(Property property) {
        setID(property.getID());
        setType(property.getType());
        setValue(property.getValue());
    }

    public void setID(long j) {
        this.id = j;
    }

    public void setType(long j) {
        this.type = j;
    }

    public void setValue(Object obj) {
        this.value = obj;
    }

    public int write(OutputStream outputStream, int i) throws IOException, WritingNotSupportedException {
        long type = getType();
        if (i == 1200 && type == 30) {
            type = 31;
        }
        return 0 + TypeWriter.writeUIntToStream(outputStream, type) + VariantSupport.write(outputStream, type, getValue(), i);
    }
}
