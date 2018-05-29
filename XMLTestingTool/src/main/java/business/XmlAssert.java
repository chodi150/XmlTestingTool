package business;

import exception.XmlValidationException;
import org.assertj.core.api.AbstractAssert;

import java.io.File;

/**
 * Created by Piotr on 19.05.2018.
 */
public class XmlAssert extends AbstractAssert<XmlAssert, File>{
    private XMLValidator xmlValidator = new XMLValidator();
    public XmlAssert(File actual) {
        super(actual, XmlAssert.class);
    }

    public static XmlAssert assertThat(File file){
        return new XmlAssert(file);
    }

    public void hasValidMarkups() {
        try {
            if(!xmlValidator.hasXmlValidMarkups(this.actual))
                failWithMessage("Given xml is not valid!");
        } catch (XmlValidationException e) {
            failWithMessage("Exception while executing test!");
        }
    }

    public void isValidAgainstXsd(File xsdScheme) {
        try {
            if(!xmlValidator.isXmlValidAgainstXsdScheme(xsdScheme, this.actual))
                failWithMessage("Given xml is not valid against xsd scheme!");
        } catch (XmlValidationException e) {
            failWithMessage("Exception while executing test!");
        }
    }

    public void isValidAgainstInputFile(File inputFile) {
        try {
            if(!xmlValidator.isXmlFileValidAgainstCorrectFile(inputFile, this.actual))
                failWithMessage("\nExpected:\n"+xmlValidator.fileToString(inputFile)+"\nActual:\n"+xmlValidator.fileToString(this.actual));
        } catch (XmlValidationException e) {
            failWithMessage("Exception while executing test!");
        }
    }

    public void xPathTagHasGivenValue(String xpath, String value) {
        try{
            if(!value.equals(xmlValidator.getValueOfXpathTag(this.actual, xpath))){
                failWithMessage("\nExpected:\n"+value+"\nActual:\n"+xmlValidator.getValueOfXpathTag(this.actual, xpath));
            }
        } catch (XmlValidationException e) {
            failWithMessage("Exception while executing test!");
        }
    }

}
