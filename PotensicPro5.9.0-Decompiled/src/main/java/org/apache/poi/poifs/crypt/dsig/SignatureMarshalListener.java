package org.apache.poi.poifs.crypt.dsig;

import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.poifs.crypt.dsig.SignatureConfig;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MutationEvent;

/* loaded from: classes5.dex */
public class SignatureMarshalListener implements EventListener, SignatureConfig.SignatureConfigurable {
    SignatureConfig signatureConfig;
    ThreadLocal<EventTarget> target = new ThreadLocal<>();

    public void setEventTarget(EventTarget eventTarget) {
        this.target.set(eventTarget);
    }

    @Override // org.w3c.dom.events.EventListener
    public void handleEvent(Event event) {
        if (event instanceof MutationEvent) {
            EventTarget target = ((MutationEvent) event).getTarget();
            if (target instanceof Element) {
                handleElement((Element) target);
            }
        }
    }

    public void handleElement(Element element) {
        EventTarget eventTarget = this.target.get();
        String packageSignatureId = this.signatureConfig.getPackageSignatureId();
        if (element.hasAttribute(PackageRelationship.ID_ATTRIBUTE_NAME)) {
            element.setIdAttribute(PackageRelationship.ID_ATTRIBUTE_NAME, true);
        }
        setListener(eventTarget, this, false);
        if (packageSignatureId.equals(element.getAttribute(PackageRelationship.ID_ATTRIBUTE_NAME))) {
            element.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:mdssi", "http://schemas.openxmlformats.org/package/2006/digital-signature");
        }
        setPrefix(element);
        setListener(eventTarget, this, true);
    }

    public static void setListener(EventTarget eventTarget, EventListener eventListener, boolean z) {
        if (z) {
            eventTarget.addEventListener("DOMSubtreeModified", eventListener, false);
        } else {
            eventTarget.removeEventListener("DOMSubtreeModified", eventListener, false);
        }
    }

    protected void setPrefix(Node node) {
        String str = this.signatureConfig.getNamespacePrefixes().get(node.getNamespaceURI());
        if (str != null && node.getPrefix() == null) {
            node.setPrefix(str);
        }
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            setPrefix(childNodes.item(i));
        }
    }

    @Override // org.apache.poi.poifs.crypt.dsig.SignatureConfig.SignatureConfigurable
    public void setSignatureConfig(SignatureConfig signatureConfig) {
        this.signatureConfig = signatureConfig;
    }
}
