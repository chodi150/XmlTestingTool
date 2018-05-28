package business;

import exception.NotValidXmlException;
import exception.XmlValidationException;
import org.custommonkey.xmlunit.XMLUnit;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Piotr on 19.05.2018.
 */
public class XMLValidator {

    private static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    boolean isXmlValidAgainstXsdScheme(File scheme, File xmlFile) throws XmlValidationException {
        try {
            validateAgainstXsdScheme(scheme, xmlFile);
        } catch (NotValidXmlException e) {
            return false;
        }
        return true;
    }
    boolean isXmlFileValidAgainstCorrectFile(File correctFile, File xmlFile) throws XmlValidationException {
        try {
            String file1 = readFile(correctFile.toString(), StandardCharsets.UTF_8);
            String file2 = readFile(xmlFile.toString(), StandardCharsets.UTF_8);
            XMLUnit.setIgnoreWhitespace(true);
            return XMLUnit.compareXML(file1, file2).identical();
        } catch (IOException | SAXException e) {
            throw new XmlValidationException("Problems while comparing files", e );
        }
    }

    boolean isXmlStringValidAgainstCorrectXmlString(String xml1, String xml2) throws XmlValidationException {
        XMLUnit.setIgnoreWhitespace(true);
        try {
            return XMLUnit.compareXML(xml1,xml2).identical();
        } catch (SAXException | IOException e) {
            throw new XmlValidationException("Problems while comparing files", e );
        }
    }


    public boolean hasXmlValidMarkups(File xmlFile) throws XmlValidationException {
        try {
            validateMarkups(xmlFile);
        } catch (NotValidXmlException e) {
            return false;
        }
        return true;
    }

    public void validateAgainstXsdScheme(File scheme, File xmlFile) throws XmlValidationException, NotValidXmlException {
        Validator validator;
        Document document;
        try {
            DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            document = parser.parse(xmlFile);
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Source schemaFile = new StreamSource(scheme);
            Schema schema = factory.newSchema(schemaFile);
            validator = schema.newValidator();
        } catch (Exception e) {
            throw new XmlValidationException("Problems while validating xml file", e);
        }

        try {
            validator.validate(new DOMSource(document));
        } catch (SAXException | IOException e) {
            throw new NotValidXmlException("XML does not match given xsd scheme.", e);
        }
    }

    private void validateMarkups(File xmlFile) throws NotValidXmlException, XmlValidationException {
        DocumentBuilder parser;
        try {
            parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new XmlValidationException("Problems while validating markups", e);
        }
        try {
           parser.parse(xmlFile);
        } catch (SAXException |IOException e) {
            throw new NotValidXmlException("Given xml file is not valid.", e);
        }
    }

    public String getValueOfXpathTag(File file, String path) throws XmlValidationException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            XPath xPath = XPathFactory.newInstance().newXPath();
            Node node =  (Node)xPath.evaluate(path, document, XPathConstants.NODE);
            return node.getTextContent();
        } catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException e) {
            throw new XmlValidationException("Problems with parsing xml", e);
        }
    }

}
