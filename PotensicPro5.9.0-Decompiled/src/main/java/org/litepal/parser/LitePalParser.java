package org.litepal.parser;

import android.content.res.AssetManager;
import android.content.res.Resources;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.litepal.LitePalApplication;
import org.litepal.exceptions.ParseConfigurationFileException;
import org.litepal.util.Const;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes5.dex */
public class LitePalParser {
    static final String ATTR_CLASS = "class";
    static final String ATTR_VALUE = "value";
    static final String NODE_CASES = "cases";
    static final String NODE_DB_NAME = "dbname";
    static final String NODE_LIST = "list";
    static final String NODE_MAPPING = "mapping";
    static final String NODE_STORAGE = "storage";
    static final String NODE_VERSION = "version";
    private static LitePalParser parser;

    public static LitePalConfig parseLitePalConfiguration() {
        if (parser == null) {
            parser = new LitePalParser();
        }
        return parser.usePullParse();
    }

    private void useSAXParser() {
        try {
            XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            xMLReader.setContentHandler(new LitePalContentHandler());
            xMLReader.parse(new InputSource(getConfigInputStream()));
        } catch (Resources.NotFoundException unused) {
            throw new ParseConfigurationFileException(ParseConfigurationFileException.CAN_NOT_FIND_LITEPAL_FILE);
        } catch (IOException unused2) {
            throw new ParseConfigurationFileException(ParseConfigurationFileException.IO_EXCEPTION);
        } catch (ParserConfigurationException unused3) {
            throw new ParseConfigurationFileException(ParseConfigurationFileException.PARSE_CONFIG_FAILED);
        } catch (SAXException unused4) {
            throw new ParseConfigurationFileException(ParseConfigurationFileException.FILE_FORMAT_IS_NOT_CORRECT);
        }
    }

    private LitePalConfig usePullParse() {
        try {
            LitePalConfig litePalConfig = new LitePalConfig();
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            newPullParser.setInput(getConfigInputStream(), "UTF-8");
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                String name = newPullParser.getName();
                if (eventType == 2) {
                    if (NODE_DB_NAME.equals(name)) {
                        litePalConfig.setDbName(newPullParser.getAttributeValue("", "value"));
                    } else if ("version".equals(name)) {
                        litePalConfig.setVersion(Integer.parseInt(newPullParser.getAttributeValue("", "value")));
                    } else if (NODE_MAPPING.equals(name)) {
                        litePalConfig.addClassName(newPullParser.getAttributeValue("", "class"));
                    } else if (NODE_CASES.equals(name)) {
                        litePalConfig.setCases(newPullParser.getAttributeValue("", "value"));
                    } else if (NODE_STORAGE.equals(name)) {
                        litePalConfig.setStorage(newPullParser.getAttributeValue("", "value"));
                    }
                }
            }
            return litePalConfig;
        } catch (IOException unused) {
            throw new ParseConfigurationFileException(ParseConfigurationFileException.IO_EXCEPTION);
        } catch (XmlPullParserException unused2) {
            throw new ParseConfigurationFileException(ParseConfigurationFileException.FILE_FORMAT_IS_NOT_CORRECT);
        }
    }

    private InputStream getConfigInputStream() throws IOException {
        AssetManager assets = LitePalApplication.getContext().getAssets();
        String[] list = assets.list("");
        if (list != null && list.length > 0) {
            for (String str : list) {
                if (Const.Config.CONFIGURATION_FILE_NAME.equalsIgnoreCase(str)) {
                    return assets.open(str, 3);
                }
            }
        }
        throw new ParseConfigurationFileException(ParseConfigurationFileException.CAN_NOT_FIND_LITEPAL_FILE);
    }
}
