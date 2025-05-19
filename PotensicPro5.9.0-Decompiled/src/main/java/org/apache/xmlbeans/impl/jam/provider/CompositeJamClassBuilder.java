package org.apache.xmlbeans.impl.jam.provider;

import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;
import org.apache.xmlbeans.impl.jam.mutable.MClass;

/* loaded from: classes5.dex */
public class CompositeJamClassBuilder extends JamClassBuilder {
    private JamClassBuilder[] mBuilders;

    public CompositeJamClassBuilder(JamClassBuilder[] jamClassBuilderArr) {
        if (jamClassBuilderArr == null) {
            throw new IllegalArgumentException("null builders");
        }
        this.mBuilders = jamClassBuilderArr;
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamClassBuilder
    public void init(ElementContext elementContext) {
        int i = 0;
        while (true) {
            JamClassBuilder[] jamClassBuilderArr = this.mBuilders;
            if (i >= jamClassBuilderArr.length) {
                return;
            }
            jamClassBuilderArr[i].init(elementContext);
            i++;
        }
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamClassBuilder
    public MClass build(String str, String str2) {
        int i = 0;
        while (true) {
            JamClassBuilder[] jamClassBuilderArr = this.mBuilders;
            if (i >= jamClassBuilderArr.length) {
                return null;
            }
            MClass build = jamClassBuilderArr[i].build(str, str2);
            if (build != null) {
                return build;
            }
            i++;
        }
    }
}
