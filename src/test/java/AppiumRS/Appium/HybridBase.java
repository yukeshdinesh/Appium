package AppiumRS.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.w3c.dom.UserDataHandler;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class HybridBase {

	public static AndroidDriver<AndroidElement> driverinitialize(String device, String appString) throws MalformedURLException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		File srcFile = new File("apps");

		File appFile = new File(srcFile, appString);
		System.out.println(appFile.getAbsolutePath());
		// app
		desiredCapabilities.setCapability(MobileCapabilityType.APP,appFile.getAbsolutePath());
		
		// Android autoamtion name
		desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		// device anme
		if (device.equalsIgnoreCase("emulator")) {
			desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_XL_API_28");
		} else {
			desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		}

		desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(url, desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	@Test
	public void path() {
		File srcFile = new File("apps");

		File appFile = new File(srcFile, "*.apk");
		System.out.println(appFile.getAbsolutePath());
		System.out.println(srcFile.getAbsolutePath());
		System.out.println(System.getProperty("user.dir"));
		
		String s1 = "Hello";
		String s2 = "Hello";
		String s3 = new String("Hello");
		
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
	}
}
