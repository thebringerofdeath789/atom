package org.apache.poi.xslf.usermodel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle;
import org.openxmlformats.schemas.presentationml.x2006.main.CTBackground;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterTextStyles;
import org.openxmlformats.schemas.presentationml.x2006.main.SldMasterDocument;

/* loaded from: classes5.dex */
public class XSLFSlideMaster extends XSLFSheet {
    private Map<String, XSLFSlideLayout> _layouts;
    private CTSlideMaster _slide;
    private XSLFTheme _theme;

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public XSLFSheet getMasterSheet() {
        return null;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    protected String getRootElementName() {
        return "sldMaster";
    }

    XSLFSlideMaster() {
        this._slide = CTSlideMaster.Factory.newInstance();
    }

    protected XSLFSlideMaster(PackagePart packagePart, PackageRelationship packageRelationship) throws IOException, XmlException {
        super(packagePart, packageRelationship);
        CTSlideMaster sldMaster = SldMasterDocument.Factory.parse(getPackagePart().getInputStream()).getSldMaster();
        this._slide = sldMaster;
        setCommonSlideData(sldMaster.getCSld());
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public CTSlideMaster getXmlObject() {
        return this._slide;
    }

    private Map<String, XSLFSlideLayout> getLayouts() {
        if (this._layouts == null) {
            this._layouts = new HashMap();
            for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
                if (pOIXMLDocumentPart instanceof XSLFSlideLayout) {
                    XSLFSlideLayout xSLFSlideLayout = (XSLFSlideLayout) pOIXMLDocumentPart;
                    this._layouts.put(xSLFSlideLayout.getName().toLowerCase(), xSLFSlideLayout);
                }
            }
        }
        return this._layouts;
    }

    public XSLFSlideLayout[] getSlideLayouts() {
        return (XSLFSlideLayout[]) getLayouts().values().toArray(new XSLFSlideLayout[this._layouts.size()]);
    }

    public XSLFSlideLayout getLayout(SlideLayout slideLayout) {
        for (XSLFSlideLayout xSLFSlideLayout : getLayouts().values()) {
            if (xSLFSlideLayout.getType() == slideLayout) {
                return xSLFSlideLayout;
            }
        }
        return null;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public XSLFTheme getTheme() {
        if (this._theme == null) {
            Iterator<POIXMLDocumentPart> it = getRelations().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                POIXMLDocumentPart next = it.next();
                if (next instanceof XSLFTheme) {
                    this._theme = (XSLFTheme) next;
                    CTColorMapping clrMap = this._slide.getClrMap();
                    if (clrMap != null) {
                        this._theme.initColorMap(clrMap);
                    }
                }
            }
        }
        return this._theme;
    }

    /* renamed from: org.apache.poi.xslf.usermodel.XSLFSlideMaster$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xslf$usermodel$Placeholder;

        static {
            int[] iArr = new int[Placeholder.values().length];
            $SwitchMap$org$apache$poi$xslf$usermodel$Placeholder = iArr;
            try {
                iArr[Placeholder.TITLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$xslf$usermodel$Placeholder[Placeholder.CENTERED_TITLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$xslf$usermodel$Placeholder[Placeholder.SUBTITLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$xslf$usermodel$Placeholder[Placeholder.BODY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    protected CTTextListStyle getTextProperties(Placeholder placeholder) {
        CTSlideMasterTextStyles txStyles = getXmlObject().getTxStyles();
        int i = AnonymousClass1.$SwitchMap$org$apache$poi$xslf$usermodel$Placeholder[placeholder.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return txStyles.getTitleStyle();
        }
        if (i == 4) {
            return txStyles.getBodyStyle();
        }
        return txStyles.getOtherStyle();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    protected boolean canDraw(XSLFShape xSLFShape) {
        return !(xSLFShape instanceof XSLFSimpleShape) || ((XSLFSimpleShape) xSLFShape).getCTPlaceholder() == null;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public XSLFBackground getBackground() {
        CTBackground bg = this._slide.getCSld().getBg();
        if (bg != null) {
            return new XSLFBackground(bg, this);
        }
        return null;
    }
}
