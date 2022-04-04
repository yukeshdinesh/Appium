package AppiumRS.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {


	public static  AndroidDriver<AndroidElement> driverinitialize() throws MalformedURLException {
		
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
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;

	}
	
}
