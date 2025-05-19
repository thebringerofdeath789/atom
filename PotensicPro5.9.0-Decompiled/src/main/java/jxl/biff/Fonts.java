package jxl.biff;

import common.Assert;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import jxl.write.biff.File;

/* loaded from: classes4.dex */
public class Fonts {
    private static final int numDefaultFonts = 4;
    private ArrayList fonts = new ArrayList();

    public void addFont(FontRecord fontRecord) {
        if (fontRecord.isInitialized()) {
            return;
        }
        int size = this.fonts.size();
        if (size >= 4) {
            size++;
        }
        fontRecord.initialize(size);
        this.fonts.add(fontRecord);
    }

    public FontRecord getFont(int i) {
        if (i > 4) {
            i--;
        }
        return (FontRecord) this.fonts.get(i);
    }

    public void write(File file) throws IOException {
        Iterator it = this.fonts.iterator();
        while (it.hasNext()) {
            file.write((FontRecord) it.next());
        }
    }

    IndexMapping rationalize() {
        IndexMapping indexMapping = new IndexMapping(this.fonts.size() + 1);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 4; i++) {
            FontRecord fontRecord = (FontRecord) this.fonts.get(i);
            arrayList.add(fontRecord);
            indexMapping.setMapping(fontRecord.getFontIndex(), fontRecord.getFontIndex());
        }
        int i2 = 0;
        for (int i3 = 4; i3 < this.fonts.size(); i3++) {
            FontRecord fontRecord2 = (FontRecord) this.fonts.get(i3);
            Iterator it = arrayList.iterator();
            boolean z = false;
            while (it.hasNext() && !z) {
                FontRecord fontRecord3 = (FontRecord) it.next();
                if (fontRecord2.equals(fontRecord3)) {
                    indexMapping.setMapping(fontRecord2.getFontIndex(), indexMapping.getNewIndex(fontRecord3.getFontIndex()));
                    i2++;
                    z = true;
                }
            }
            if (!z) {
                arrayList.add(fontRecord2);
                int fontIndex = fontRecord2.getFontIndex() - i2;
                Assert.verify(fontIndex > 4);
                indexMapping.setMapping(fontRecord2.getFontIndex(), fontIndex);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            FontRecord fontRecord4 = (FontRecord) it2.next();
            fontRecord4.initialize(indexMapping.getNewIndex(fontRecord4.getFontIndex()));
        }
        this.fonts = arrayList;
        return indexMapping;
    }
}
