package org.w3c.dom;

/* loaded from: classes6.dex */
public interface ProcessingInstruction extends Node {
    String getData();

    String getTarget();

    void setData(String str) throws DOMException;
}
