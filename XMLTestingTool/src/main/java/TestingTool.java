import business.TagInjector;
import config.XMLConfig;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class TestingTool {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        XMLConfig xmlConfig = new XMLConfig();
        TagInjector thymeleafTagInjector = new TagInjector(xmlConfig.templateEngine(""));
        Map<String, Object> map = new TreeMap<>();
        map.put("name","damian");
        map.put("surname","portasinski");
        try {
            thymeleafTagInjector.produceXmlWithInjectedTags(map, "hej", "XMLTestingTool/");
        } catch (IOException e) {
            System.err.println("Houston mamy problem");
        }
    }
}