package com.example.projektpik.facade;

import com.example.projektpik.database.XmlDocumentRepository;
import com.example.projektpik.exception.NoSuchXmlException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Piotr on 29.05.2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED)
public class XmlFacadeTest {

    @Autowired
    XmlDocumentFacade xmlDocumentFacade;

    String xml;

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Before
    public void setup(){
        xml = "<student><name>Leber</name><surname>James</surname></student>";
    }

    @Test(expected = NoSuchXmlException.class)
    public void givenDatabaseWithNoXmlsWhenDeletingThenThrows() throws NoSuchXmlException {
        xmlDocumentFacade.deleteXml(1L);
    }

    @Test
    public void givenXmlWhenSavingToDatabaseThereIsOneInDatabase(){
        xmlDocumentFacade.saveXml(xml);
        Assert.assertEquals(xmlDocumentFacade.getAllXmls().size(), 1);
    }

}
