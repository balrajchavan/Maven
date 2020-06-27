package POM_Tests;

import org.testng.annotations.Test;
import Listeners.ListenerTestNG_Demo;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerTestNG_Demo.class)
public class TestNG_Listener_demo{

	
	@Test
	public void test1() {

		System.out.println("Inside test1");
	}

	@Test
	public void test2() {

		System.out.println("Inside test2");
	}

	@Test
	public void test3() {

		System.out.println("Inside test3");
	}



}
