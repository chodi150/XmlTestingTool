package business;

import exception.XmlValidationException;
import org.assertj.core.api.AbstractAssert;
import org.custommonkey.xmlunit.DetailedDiff;

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
            DetailedDiff diff = xmlValidator.compareStringValidAgainstCorrectXmlString(xml, this.actual);
            if(!diff.identical())
                failWithMessage(diff.getAllDifferences().toString());
        } catch (XmlValidationException e) {
            failWithMessage("Exception while executing test!");
        }
    }
}
