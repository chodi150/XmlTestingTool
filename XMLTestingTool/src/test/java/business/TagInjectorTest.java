package business;

import config.XMLConfig;
import org.custommonkey.xmlunit.XMLTestCase;
import org.junit.Test;

import java.io.File;
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
}