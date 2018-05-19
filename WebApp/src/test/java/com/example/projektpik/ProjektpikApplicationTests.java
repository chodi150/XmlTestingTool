package com.example.projektpik;

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
		file = new File("hej10-36-24.xml");
	}


	@Test
	public void funnyTest() {
		file = new File("hej10-36-24.xml");
		XmlAssert.assertThat(file).hasValidMarkups();
	}

	@Test
	public void funnierTest() {
		file = new File("hej10-36-24.xml");
		File scheme = new File("scheme.xsd");
		XmlAssert.assertThat(file).isValidAgainstXsd(scheme);
	}

	@Test
	public void theFunniestTest() {
		File hej1 = new File("hej1.xml");
		File hej2 = new File("hej2.xml");
		XmlAssert.assertThat(hej1).isValidAgainstInputFile(hej2);
	}

}
