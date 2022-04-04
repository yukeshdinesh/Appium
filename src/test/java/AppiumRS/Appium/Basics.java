package AppiumRS.Appium;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Basics {

	@Test
	public void test1() throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = Base.driverinitialize();

		//Using Xpath
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		boolean enabled = driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").isEnabled();
		System.out.println(enabled);
		
		//Using ID
		driver.findElementById("android:id/checkbox").click();
		WebElement wifiSettingElement = driver.findElementByXPath("(//android.widget.RelativeLayout)[2]");
		boolean enabled2 = wifiSettingElement.isEnabled();
		System.out.println(enabled2);
		wifiSettingElement.click();
		
		//Using ClassName
		driver.findElementByClassName("android.widget.EditText").sendKeys("Yukesh");
		
		//Using multiple elements and selecting needed one
		List<AndroidElement> buttonElements = driver.findElementsByClassName("android.widget.Button");
		for (AndroidElement button : buttonElements) {
			String text = button.getText();
			System.out.println(text);
			if (text.equalsIgnoreCase("OK")) {
				button.click();

			}
		}
		
		//Using Uiautomator
		driver.findElementByAndroidUIAutomator("text(\"WiFi settings\")").click();

	}
	
	@Test
	public void test2() throws MalformedURLException { 

		AndroidDriver<AndroidElement> driver = Base.driverinitialize();

		//Using UIAutomator
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		
		//Using Ui selector get the properties value and select
		List<AndroidElement> findElementsByAndroidUIAutomator = driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)");
		System.out.println(findElementsByAndroidUIAutomator.size());
		for (AndroidElement object : findElementsByAndroidUIAutomator) {
			System.out.println(object.getText());
		}

	}

}
