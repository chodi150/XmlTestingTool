package business;

import config.XMLConfig;
import org.custommonkey.xmlunit.XMLTestCase;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class TagInjectorTest{
    XMLConfig xmlConfig = new XMLConfig();
    TagInjector thymeleafTagInjector = new TagInjector(xmlConfig.templateEngine(""));
    @Test
    public void tagInjectionWithDollarSignWithoutDot() {
        Map<String, Object> map = new TreeMap<>();
        map.put("name","damian");
        map.put("surname","portasinski");
        String content = thymeleafTagInjector.produceStringXmlWithInjectedTags(map,"testfile1");
        XmlStringAssert.assertThat(content).isStringXmlValidAgainstStringXml("<note>\n" +
                "    <to>damian</to>\n" +
                "    <from>portasinski</from>\n" +
                "\t<heading>Reminder</heading>\n" +
                "    <body>Don't forget me this weekend!</body>\n" +
                "</note>");
    }

    @Test
    public void tagInjectionWithDollarSignWithDot() {
        Map<String, Object> map = new TreeMap<>();
        map.put("name.x","damian");
        map.put("surname","portasinski");
        String content = thymeleafTagInjector.produceStringXmlWithInjectedTags(map,"testfile2");
        XmlStringAssert.assertThat(content).isStringXmlValidAgainstStringXml("<note>\n" +
                "    <to>damian</to>\n" +
                "    <from>portasinski</from>\n" +
                "\t<heading>Reminder</heading>\n" +
                "    <body>Don't forget me this weekend!</body>\n" +
                "</note>");
    }

    @Test
    public void checkValidMarkups() throws IOException {

        File file = new File("src/test/testfiles/testfile3.xml");
        XmlAssert.assertThat(file).hasValidMarkups();
    }

    @Test
    public void checkAgainsXsdScheme() {
        File file = new File("src/test/testfiles/testfile3.xml");
        File scheme = new File("src/test/testfiles/scheme_testfile3.xsd");
        XmlAssert.assertThat(file).isValidAgainstXsd(scheme);
    }

    @Test
    public void checkIfTwoFilesWithWhitespacesAreEqual() {
        File hej1 = new File("src/test/testfiles/testfile4.xml");
        File hej2 = new File("src/test/testfiles/testfile5.xml");
        XmlAssert.assertThat(hej1).isValidAgainstInputFile(hej2);
    }
}