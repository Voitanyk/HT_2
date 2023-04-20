import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileReader;
import java.util.List;


public class PomXmlVersionChecker {
    private static final Logger LOGGER = LoggerFactory.getLogger(PomXmlVersionChecker.class);
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    public void printLibrariesAndVersions() {
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            org.w3c.dom.Document document = builder.parse("pom.xml");
            document.getDocumentElement().normalize();
            NodeList dependencies = document.getElementsByTagName("dependency");
            for (int i = 0; i < dependencies.getLength(); i++) {
                Node node = dependencies.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String groupId = element.getElementsByTagName("groupId").item(0).getTextContent();
                    String artifactId = element.getElementsByTagName("artifactId").item(0).getTextContent();
                    String version = element.getElementsByTagName("version").item(0).getTextContent();
                    LOGGER.info("{}:{}:{}", groupId, artifactId, version);
                }
            }
        } catch (Exception e) {
            LOGGER.error("Failed to get versions from pom.xml", e);
        }
    }

    public String getLibraryVersion(String libraryName) throws Exception {
        MavenXpp3Reader reader = new MavenXpp3Reader();
        Model model = reader.read(new FileReader("pom.xml"));
        List<Dependency> dependencies = model.getDependencies();
        for (Dependency dep : dependencies) {
            if (libraryName.equals(dep.getArtifactId())) {
                return dep.getVersion();
            }
        }
        return "null";
    }
}
