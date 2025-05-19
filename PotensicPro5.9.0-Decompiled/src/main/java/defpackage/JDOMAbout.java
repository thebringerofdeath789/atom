package defpackage;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import javax.xml.transform.OutputKeys;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/* loaded from: classes.dex */
public class JDOMAbout {
    public static void main(String[] strArr) throws Exception {
        Info info = new JDOMAbout().new Info();
        String str = info.title;
        System.out.println(new StringBuffer(String.valueOf(str)).append(" version ").append(info.version).toString());
        System.out.println(new StringBuffer("Copyright ").append(info.copyright).toString());
        System.out.println();
        System.out.println(info.description);
        System.out.println();
        System.out.println("Authors:");
        for (Author author : info.authors) {
            System.out.print(new StringBuffer("  ").append(author.name).toString());
            if (author.email == null) {
                System.out.println();
            } else {
                System.out.println(new StringBuffer(" <").append(author.email).append(">").toString());
            }
        }
        System.out.println();
        System.out.println(new StringBuffer(String.valueOf(str)).append(" license:").toString());
        System.out.println(info.license);
        System.out.println();
        System.out.println(new StringBuffer(String.valueOf(str)).append(" support:").toString());
        System.out.println(info.support);
        System.out.println();
        System.out.println(new StringBuffer(String.valueOf(str)).append(" web site: ").append(info.website).toString());
        System.out.println();
    }

    private class Info {
        List authors;
        String copyright;
        String description;
        String license;
        String support;
        String title;
        String version;
        String website;

        Info() throws Exception {
            SAXBuilder sAXBuilder = new SAXBuilder();
            StringTokenizer stringTokenizer = new StringTokenizer(System.getProperty("java.class.path"), ";:");
            ZipEntry zipEntry = null;
            JarFile jarFile = null;
            while (stringTokenizer.hasMoreTokens() && zipEntry == null) {
                try {
                    JarFile jarFile2 = new JarFile(stringTokenizer.nextToken());
                    try {
                        zipEntry = jarFile2.getEntry("META-INF/info.xml");
                    } catch (Exception unused) {
                    }
                    jarFile = jarFile2;
                } catch (Exception unused2) {
                }
            }
            if (zipEntry == null) {
                throw new FileNotFoundException("META-INF/info.xml not found; it should be within the JDOM JAR but isn't");
            }
            Element rootElement = sAXBuilder.build(jarFile.getInputStream(zipEntry)).getRootElement();
            this.title = rootElement.getChildTextTrim("title");
            this.version = rootElement.getChildTextTrim(OutputKeys.VERSION);
            this.copyright = rootElement.getChildTextTrim("copyright");
            this.description = rootElement.getChildTextTrim("description");
            this.license = rootElement.getChildTextTrim("license");
            this.support = rootElement.getChildTextTrim("support");
            this.website = rootElement.getChildTextTrim("web-site");
            List<Element> children = rootElement.getChildren("author");
            this.authors = new LinkedList();
            for (Element element : children) {
                JDOMAbout.this.getClass();
                Author author = JDOMAbout.this.new Author();
                author.name = element.getChildTextTrim("name");
                author.email = element.getChildTextTrim("e-mail");
                this.authors.add(author);
            }
        }
    }

    private class Author {
        String email;
        String name;

        Author() {
        }
    }
}
