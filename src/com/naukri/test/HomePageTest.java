package com.naukri.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.naukri.base.Base;
import com.naukri.util.WindowSwitchingClose;

public class HomePageTest extends Base
{

	public HomePageTest() throws IOException {
		super();
		System.out.println("Hello");
	}
	
	@Test
	public void homePage() throws InterruptedException
	{
		initialize();
		Thread.sleep(10);
		WindowSwitchingClose.closeWindow();
	}
	
}
