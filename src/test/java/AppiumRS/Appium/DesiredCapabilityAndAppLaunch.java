package AppiumRS.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class DesiredCapabilityAndAppLaunch {
	
	
	 static File appFile = new File("/Appium/apps/ApiDemos-debug.apk");
		
	@Test
	public void firstTest() throws MalformedURLException {
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		
		//app
		desiredCapabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\Yukesh\\eclipse-workspace\\Appium\\apps\\ApiDemos-debug.apk" );
		//Android autoamtion name
		desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		//device anme
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_XL_API_28");
		desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "400");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(url, desiredCapabilities);
		driver.get(null);

	}

}
