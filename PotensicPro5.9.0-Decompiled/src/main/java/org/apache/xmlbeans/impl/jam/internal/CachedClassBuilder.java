package org.apache.xmlbeans.impl.jam.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.xmlbeans.impl.jam.mutable.MClass;
import org.apache.xmlbeans.impl.jam.provider.JamClassBuilder;

/* loaded from: classes5.dex */
public class CachedClassBuilder extends JamClassBuilder {
    private Map mQcname2jclass = null;
    private List mClassNames = new ArrayList();

    @Override // org.apache.xmlbeans.impl.jam.provider.JamClassBuilder
    public MClass build(String str, String str2) {
        if (this.mQcname2jclass == null) {
            return null;
        }
        if (str.trim().length() > 0) {
            str2 = new StringBuffer().append(str).append('.').append(str2).toString();
        }
        return (MClass) this.mQcname2jclass.get(str2);
    }

    @Override // org.apache.xmlbeans.impl.jam.provider.JamClassBuilder
    public MClass createClassToBuild(String str, String str2, String[] strArr) {
        String stringBuffer = str.trim().length() > 0 ? new StringBuffer().append(str).append('.').append(str2).toString() : str2;
        Map map = this.mQcname2jclass;
        if (map != null) {
            MClass mClass = (MClass) map.get(stringBuffer);
            if (mClass != null) {
                return mClass;
            }
        } else {
            this.mQcname2jclass = new HashMap();
        }
        MClass createClassToBuild = super.createClassToBuild(str, str2, strArr);
        this.mQcname2jclass.put(stringBuffer, createClassToBuild);
        this.mClassNames.add(stringBuffer);
        return createClassToBuild;
    }

    public String[] getClassNames() {
        String[] strArr = new String[this.mClassNames.size()];
        this.mClassNames.toArray(strArr);
        return strArr;
    }
}
