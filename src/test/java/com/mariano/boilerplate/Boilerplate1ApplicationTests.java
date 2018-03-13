package com.mariano.boilerplate;

import static org.junit.Assert.assertEquals;

import org.assertj.core.api.Fail;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Boilerplate1ApplicationTests {

	@Test
	public void contextLoads() {
		//Fail.fail("lalalala");
		assertEquals(4,6);
	}
	@BeforeClass
	public static void contextLrroads() {
		//Fail.fail("lalalala");
		//when
		assertEquals(4,6);
	}
}
