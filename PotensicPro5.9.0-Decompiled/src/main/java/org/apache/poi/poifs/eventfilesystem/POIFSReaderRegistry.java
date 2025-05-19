package org.apache.poi.poifs.eventfilesystem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.poi.poifs.filesystem.DocumentDescriptor;
import org.apache.poi.poifs.filesystem.POIFSDocumentPath;

/* loaded from: classes5.dex */
class POIFSReaderRegistry {
    private Set omnivorousListeners = new HashSet();
    private Map selectiveListeners = new HashMap();
    private Map chosenDocumentDescriptors = new HashMap();

    POIFSReaderRegistry() {
    }

    void registerListener(POIFSReaderListener pOIFSReaderListener, POIFSDocumentPath pOIFSDocumentPath, String str) {
        if (this.omnivorousListeners.contains(pOIFSReaderListener)) {
            return;
        }
        Set set = (Set) this.selectiveListeners.get(pOIFSReaderListener);
        if (set == null) {
            set = new HashSet();
            this.selectiveListeners.put(pOIFSReaderListener, set);
        }
        DocumentDescriptor documentDescriptor = new DocumentDescriptor(pOIFSDocumentPath, str);
        if (set.add(documentDescriptor)) {
            Set set2 = (Set) this.chosenDocumentDescriptors.get(documentDescriptor);
            if (set2 == null) {
                set2 = new HashSet();
                this.chosenDocumentDescriptors.put(documentDescriptor, set2);
            }
            set2.add(pOIFSReaderListener);
        }
    }

    void registerListener(POIFSReaderListener pOIFSReaderListener) {
        if (this.omnivorousListeners.contains(pOIFSReaderListener)) {
            return;
        }
        removeSelectiveListener(pOIFSReaderListener);
        this.omnivorousListeners.add(pOIFSReaderListener);
    }

    Iterator getListeners(POIFSDocumentPath pOIFSDocumentPath, String str) {
        HashSet hashSet = new HashSet(this.omnivorousListeners);
        Set set = (Set) this.chosenDocumentDescriptors.get(new DocumentDescriptor(pOIFSDocumentPath, str));
        if (set != null) {
            hashSet.addAll(set);
        }
        return hashSet.iterator();
    }

    private void removeSelectiveListener(POIFSReaderListener pOIFSReaderListener) {
        Set set = (Set) this.selectiveListeners.remove(pOIFSReaderListener);
        if (set != null) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                dropDocument(pOIFSReaderListener, (DocumentDescriptor) it.next());
            }
        }
    }

    private void dropDocument(POIFSReaderListener pOIFSReaderListener, DocumentDescriptor documentDescriptor) {
        Set set = (Set) this.chosenDocumentDescriptors.get(documentDescriptor);
        set.remove(pOIFSReaderListener);
        if (set.size() == 0) {
            this.chosenDocumentDescriptors.remove(documentDescriptor);
        }
    }
}
