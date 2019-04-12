package com.naukri.util;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import com.naukri.base.Base;

public class WindowSwitchingClose extends Base
{
	private static String parentWindow;
	private static String childWindow;
	
	public WindowSwitchingClose() throws IOException
	{
		super();
	}
	public static void closeWindow()
	{
		parentWindow= driver.getWindowHandle();
		Set<String> windows= driver.getWindowHandles();
		System.out.println(windows.size());
		Iterator<String> window= windows.iterator();
		
		while(window.hasNext())
		{
			childWindow= window.next();
			if(! parentWindow.equals(childWindow))
			{
				driver.switchTo().window(childWindow);
				driver.close();
			}
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.switchTo().window(parentWindow);
	}
}
