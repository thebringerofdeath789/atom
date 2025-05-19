package org.dom4j.rule;

import org.dom4j.Node;

/* loaded from: classes5.dex */
public class NullAction implements Action {
    public static final NullAction SINGLETON = new NullAction();

    @Override // org.dom4j.rule.Action
    public void run(Node node) throws Exception {
    }
}
