package AppiumRS.Appium;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Scroll {
	

	@Test
	public void scrollMethod() throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = Base.driverinitialize();
		
		//Using UIAutomator
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		//String scrollElementString = "new UiScrollable(UiSelector().scrollIntoView(text(\"WebView3\")))";
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");
	}


}
