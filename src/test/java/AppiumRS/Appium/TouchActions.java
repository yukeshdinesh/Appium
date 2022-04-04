package AppiumRS.Appium;

import java.net.MalformedURLException;
import java.time.Duration;

import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class TouchActions {
	
	@Test
	public void tapTest() throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = Base.driverinitialize();
		
		//Using UIAutomator
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		AndroidElement expandablElement = driver.findElementByXPath("//*[@text='Expandable Lists']");
		
		//Touch actions
		TouchAction touchAction = new TouchAction(driver);

		//Tap
		touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(expandablElement))).perform();
		
		driver.findElementByXPath("//*[@text='1. Custom Adapter']").click();
		AndroidElement peoplElement = driver.findElementByXPath("//*[@text='People Names']");
		
		//Long press
		touchAction
		.longPress(LongPressOptions.longPressOptions()
				.withElement(ElementOption.element(peoplElement))
				.withDuration(Duration.ofSeconds(2))).release().perform();
		
		
		System.out.println(driver.findElementByXPath("//*[@text='Sample menu']").isDisplayed());
		
		
		
		
		
		
	}

}
