package com.example.projektpik;

import business.TagInjector;
import business.XmlAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjektpikApplicationTests {

	File file;
	@Before
	public void setup(){
		file = new File("testFiles/testfile3.xml");
	}


	@Test
	public void checkValidMarkups() {
		file = new File("testFiles/testfile3.xml");
		XmlAssert.assertThat(file).hasValidMarkups();
	}

	@Test
	public void checkAgainsXsdScheme() {
		file = new File("testFiles/testfile3.xml");
		File scheme = new File("testFiles/scheme_testfile3.xsd");
		XmlAssert.assertThat(file).isValidAgainstXsd(scheme);
	}

	@Test
	public void checkIfTwoFilesWithWhitespacesAreEqual() {
		File hej1 = new File("testFiles/testfile1.xml");
		File hej2 = new File("testFiles/testfile2.xml");
		XmlAssert.assertThat(hej1).isValidAgainstInputFile(hej2);
	}

}
