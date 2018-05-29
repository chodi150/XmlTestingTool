package business;

import config.XMLConfig;
import model.Student;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class TagInjectorTest{
    XMLConfig xmlConfig = new XMLConfig();
    TagInjector thymeleafTagInjector = new TagInjector(xmlConfig.templateEngine(""));

    @Test
    public void tagInjectionWithObjectsFiles() throws IOException {
        Map<String, Object> map = new TreeMap<>();
        Student x = new Student();
        x.setSurname("Potter");
        x.setName("Harry");
        map.put("x", x);
        File f1 = new File("src/test/testfiles/testfile7_1.xml");
        thymeleafTagInjector.produceXmlWithInjectedTags(map,"testfile7_2","src/test/testfiles/testfile7_3");
        File f2 = new File("src/test/testfiles/testfile7_3.xml");
        XmlAssert.assertThat(f1).isValidAgainstInputFile(f2);
    }

    @Test
    public void tagInjectionWithDollarSignWithoutDotFiles() throws IOException {
        Map<String, Object> map = new TreeMap<>();
        map.put("name", "Ron");
        map.put("surname", "Weasley");
        File f1 = new File("src/test/testfiles/testfile8_1.xml");
        thymeleafTagInjector.produceXmlWithInjectedTags(map,"testfile8_2","src/test/testfiles/testfile8_3");
        File f2 = new File("src/test/testfiles/testfile8_3.xml");
        XmlAssert.assertThat(f1).isValidAgainstInputFile(f2);
    }


    @Test
    public void tagInjectionWithObjectsStrings() {
        Map<String, Object> map = new TreeMap<>();
        Student student = new Student();
        student.setSurname("Portasinski");
        student.setName("Damian");
        map.put("student", student);
        String content = thymeleafTagInjector.produceStringXmlWithInjectedTags(map,"testfile6");
        XmlStringAssert.assertThat(content).isStringXmlValidAgainstStringXml("<Student>\n" +
                "    <name>Damian</name>\n" +
                "    <surname>Portasinski</surname>\n" +
                "</Student>");
    }


    @Test
    public void tagInjectionWithDollarSignWithoutDotStrings() {
        Map<String, Object> map = new TreeMap<>();
        map.put("ad1","Kevin");
        map.put("ad2","Lars");
        String content = thymeleafTagInjector.produceStringXmlWithInjectedTags(map,"testfile1");
        XmlStringAssert.assertThat(content).isStringXmlValidAgainstStringXml("<note>\n" +
                "    <to>Kevin</to>\n" +
                "    <from>Lars</from>\n" +
                "\t<heading>Reminder</heading>\n" +
                "    <body>Don't forget me this weekend!</body>\n" +
                "</note>");
    }

    @Test
    public void tagInjectionWithDollarSignWithDotStrings() {
        Map<String, Object> map = new TreeMap<>();
        map.put("ad1.x","Kevin");
        map.put("ad2","Lars");
        String content = thymeleafTagInjector.produceStringXmlWithInjectedTags(map,"testfile2");
        XmlStringAssert.assertThat(content).isStringXmlValidAgainstStringXml("<note>\n" +
                "    <to>Kevin</to>\n" +
                "    <from>Lars</from>\n" +
                "\t<heading>Reminder</heading>\n" +
                "    <body>Don't forget me this weekend!</body>\n" +
                "</note>");
    }

    @Test(expected = AssertionError.class)
    public void tagInjectionWithDollarSignWithDotStringsShouldFail() {
        Map<String, Object> map = new TreeMap<>();
        map.put("ad1.x","Kevin");
        map.put("ad2","Lars");
        String content = thymeleafTagInjector.produceStringXmlWithInjectedTags(map,"testfile2");
        XmlStringAssert.assertThat(content).isStringXmlValidAgainstStringXml("<note>\n" +
                "    <to>Kevin</to>\n" +
                "    <from>Lars</from>\n" +
                "\t<heading>Reeminder</heading>\n" +
                "    <body>Don't forget me this weekend!</body>\n" +
                "</note>");
    }

    @Test
    public void checkValidMarkups() throws IOException {
        File file = new File("src/test/testfiles/testfile3.xml");
        XmlAssert.assertThat(file).hasValidMarkups();
    }

    @Test(expected = AssertionError.class)
    public void checkNotValidMarkups() throws IOException {
        File file = new File("src/test/testfiles/testfile9.xml");
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

    @Test(expected = AssertionError.class)
    public void checkIfTwoFilesWithWhitespacesAreNotEqual() {
        File hej1 = new File("src/test/testfiles/testfile4.xml");
        File hej2 = new File("src/test/testfiles/testfile9.xml");
        XmlAssert.assertThat(hej1).isValidAgainstInputFile(hej2);
    }

    @Test
    public void checkIfXmlHasCertainValueInTag() {
        File hej1 = new File("src/test/testfiles/testfile5.xml");
        XmlAssert.assertThat(hej1).xPathTagHasGivenValue("/note/heading",  "Reminder");
    }
}