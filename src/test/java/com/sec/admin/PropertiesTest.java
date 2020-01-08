package com.sec.admin;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sec.admin.controller.BoardController;


@SpringBootTest(classes=BoardController.class,properties= {"author.name=kim","author.age=18","author.nation=kor"})
public class PropertiesTest {
	@Autowired
	Environment environment;
	
	@Test
	public void testMethod() {
		System.out.println("name:"+environment.getProperty("author.name"));
		System.out.println("age:"+environment.getProperty("author.age"));
		System.out.println("nation:"+environment.getProperty("author.nation"));
		
	}

}
