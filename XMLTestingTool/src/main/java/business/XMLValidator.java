package business;

import exception.NotValidXmlException;
import exception.XmlValidationException;
import org.w3c.dom.Document;
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
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
/**
 * Created by Piotr on 19.05.2018.
 */
public class XMLValidator {

    boolean isXmlValidAgainstXsdScheme(File scheme, File xmlFile) throws XmlValidationException {
        try {
            validateAgainstXsdScheme(scheme, xmlFile);
        } catch (NotValidXmlException e) {
            return false;
        }
        return true;
    }
    boolean isXmlValidAgainstCorrectFile(File correctFile, File xmlFile) throws XmlValidationException {
        try {
            return FileUtils.contentEquals(correctFile, xmlFile);
        } catch (IOException e) {
            throw new XmlValidationException("Provlems while comparing files", e );
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

    private void validateAgainstXsdScheme(File scheme, File xmlFile) throws XmlValidationException, NotValidXmlException {
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





}
