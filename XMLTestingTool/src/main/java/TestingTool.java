import business.TagInjector;
import business.XMLValidator;
import config.XMLConfig;
import exception.XmlValidationException;
import model.Student;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class TestingTool {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        XMLConfig xmlConfig = new XMLConfig();
        TagInjector thymeleafTagInjector = new TagInjector(xmlConfig.templateEngine(""));
        XMLValidator xmlValidator = new XMLValidator();
        try {
            File file = new File("XMLTestingTool/src/main/resources/example_file.xml");
            System.out.println(xmlValidator.getValueOfXpathTag(file,"/note/heading"));
        } catch (XmlValidationException e) {
            e.printStackTrace();
        }
    }
}
