package org.apache.xmlbeans.impl.schema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public class SchemaDependencies {
    private Map _dependencies = new HashMap();
    private Map _contributions = new HashMap();

    void registerDependency(String str, String str2) {
        Set set = (Set) this._dependencies.get(str2);
        if (set == null) {
            set = new HashSet();
            this._dependencies.put(str2, set);
        }
        set.add(str);
    }

    Set computeTransitiveClosure(List list) {
        ArrayList arrayList = new ArrayList(list);
        HashSet hashSet = new HashSet(list);
        for (int i = 0; i < arrayList.size(); i++) {
            Set<String> set = (Set) this._dependencies.get(arrayList.get(i));
            if (set != null) {
                for (String str : set) {
                    if (!hashSet.contains(str)) {
                        arrayList.add(str);
                        hashSet.add(str);
                    }
                }
            }
        }
        return hashSet;
    }

    SchemaDependencies() {
    }

    SchemaDependencies(SchemaDependencies schemaDependencies, Set set) {
        for (String str : schemaDependencies._dependencies.keySet()) {
            if (!set.contains(str)) {
                HashSet hashSet = new HashSet();
                this._dependencies.put(str, hashSet);
                for (String str2 : (Set) schemaDependencies._dependencies.get(str)) {
                    if (!set.contains(str2)) {
                        hashSet.add(str2);
                    }
                }
            }
        }
        for (String str3 : schemaDependencies._contributions.keySet()) {
            if (!set.contains(str3)) {
                ArrayList arrayList = new ArrayList();
                this._contributions.put(str3, arrayList);
                Iterator it = ((List) schemaDependencies._contributions.get(str3)).iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
            }
        }
    }

    void registerContribution(String str, String str2) {
        List list = (List) this._contributions.get(str);
        if (list == null) {
            list = new ArrayList();
            this._contributions.put(str, list);
        }
        list.add(str2);
    }

    boolean isFileRepresented(String str) {
        Iterator it = this._contributions.values().iterator();
        while (it.hasNext()) {
            if (((List) it.next()).contains(str)) {
                return true;
            }
        }
        return false;
    }

    List getFilesTouched(Set set) {
        ArrayList arrayList = new ArrayList();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            arrayList.addAll((List) this._contributions.get(it.next()));
        }
        return arrayList;
    }

    List getNamespacesTouched(Set set) {
        ArrayList arrayList = new ArrayList();
        for (String str : this._contributions.keySet()) {
            List list = (List) this._contributions.get(str);
            for (int i = 0; i < list.size(); i++) {
                if (set.contains(list.get(i))) {
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }
}
