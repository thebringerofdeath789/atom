package org.apache.xmlbeans.impl.tool;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class Extension {
    private Class className;
    private List params = new ArrayList();

    public Class getClassName() {
        return this.className;
    }

    public void setClassName(Class cls) {
        this.className = cls;
    }

    public List getParams() {
        return this.params;
    }

    public Param createParam() {
        Param param = new Param();
        this.params.add(param);
        return param;
    }

    public class Param {
        private String name;
        private String value;

        public Param() {
        }

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getValue() {
            return this.value;
        }

        public void setValue(String str) {
            this.value = str;
        }
    }
}
