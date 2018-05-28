package business;

import exception.XmlValidationException;
import org.assertj.core.api.AbstractAssert;

public class XmlStringAssert extends AbstractAssert<XmlStringAssert, String> {
    private XMLValidator xmlValidator = new XMLValidator();
    public XmlStringAssert(String actual) {
        super(actual, XmlStringAssert.class);
    }

    public static XmlStringAssert assertThat(String xml){
        return new XmlStringAssert(xml);
    }

    public void isStringXmlValidAgainstStringXml(String xml) {
        try {
            if(!xmlValidator.isXmlStringValidAgainstCorrectXmlString(xml, this.actual))
                failWithMessage("\nExpected:\n"+xml+"\nActual:\n"+this.actual);
        } catch (XmlValidationException e) {
            failWithMessage("Exception while executing test!");
        }
    }
}
