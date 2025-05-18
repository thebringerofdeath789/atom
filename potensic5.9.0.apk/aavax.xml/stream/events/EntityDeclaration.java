package aavax.xml.stream.events;

/* loaded from: classes.dex */
public interface EntityDeclaration extends XMLEvent {
    String getBaseURI();

    String getName();

    String getNotationName();

    String getPublicId();

    String getReplacementText();

    String getSystemId();
}