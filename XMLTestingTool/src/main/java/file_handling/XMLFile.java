package file_handling;

import exception.NotValidXmlException;
import lombok.Data;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by Piotr on 19.05.2018.
 */
@Data
public class XMLFile {
    File xmlFile;

    public XMLFile(String filename) throws NotValidXmlException, ParserConfigurationException, IOException, SAXException {
        DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        this.xmlFile = new File(filename);
        Document document = parser.parse(this.xmlFile);
    }
}
