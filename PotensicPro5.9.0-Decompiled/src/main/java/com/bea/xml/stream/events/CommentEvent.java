package com.bea.xml.stream.events;

import aavax.xml.stream.events.Comment;
import java.io.IOException;
import java.io.Writer;

/* loaded from: classes.dex */
public class CommentEvent extends CharactersEvent implements Comment {
    public CommentEvent() {
        init();
    }

    public CommentEvent(String str) {
        init();
        setData(str);
    }

    @Override // com.bea.xml.stream.events.CharactersEvent
    protected void init() {
        setEventType(5);
    }

    @Override // aavax.xml.stream.events.Comment
    public String getText() {
        return getData();
    }

    @Override // com.bea.xml.stream.events.CharactersEvent, com.bea.xml.stream.events.BaseEvent
    protected void doWriteAsEncodedUnicode(Writer writer) throws IOException {
        writer.write("<!--");
        String text = getText();
        if (text.length() > 0) {
            writer.write(text);
        }
        writer.write("-->");
    }
}
