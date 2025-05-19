package com.bea.xml.stream;

import aavax.xml.stream.XMLStreamException;

/* loaded from: classes.dex */
public class XMLEventPlayer extends XMLEventReaderBase {
    private XMLStreamPlayer player;

    public XMLEventPlayer(XMLStreamPlayer xMLStreamPlayer) throws XMLStreamException {
        super(xMLStreamPlayer);
        this.player = xMLStreamPlayer;
    }

    @Override // com.bea.xml.stream.XMLEventReaderBase
    protected boolean parseSome() throws XMLStreamException {
        this.allocator.allocate(this.reader, this);
        if (this.reader.hasNext()) {
            this.reader.next();
        }
        if (isOpen() && this.reader.getEventType() == 8) {
            if (this.player.endDocumentIsPresent()) {
                this.allocator.allocate(this.reader, this);
            }
            internal_close();
        }
        return !needsMore();
    }
}
