package javax.xml.transform;

import java.util.Properties;

/* loaded from: classes4.dex */
public abstract class Transformer {
    protected Transformer() {
    }

    public abstract void clearParameters();

    public abstract ErrorListener getErrorListener();

    public abstract Properties getOutputProperties();

    public abstract String getOutputProperty(String str) throws IllegalArgumentException;

    public abstract Object getParameter(String str);

    public abstract URIResolver getURIResolver();

    public abstract void setErrorListener(ErrorListener errorListener) throws IllegalArgumentException;

    public abstract void setOutputProperties(Properties properties) throws IllegalArgumentException;

    public abstract void setOutputProperty(String str, String str2) throws IllegalArgumentException;

    public abstract void setParameter(String str, Object obj);

    public abstract void setURIResolver(URIResolver uRIResolver);

    public abstract void transform(Source source, Result result) throws TransformerException;
}
