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
import io.appium.java_client.touch.offset.PointOption;

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
	
	@Test
	public void swipeMethod() throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = Base.driverinitialize();
		
		//Using UIAutomator
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")").click();
		
		driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
		
		driver.findElementByXPath("//*[@content-desc='9']").click();
		
		//Swipe  Longpress the source element then move to destination element
		
		TouchAction touchAction = new TouchAction(driver);
		
		AndroidElement fromElement = driver.findElementByXPath("//*[@content-desc='15']");
		AndroidElement toElement = driver.findElementByXPath("//*[@content-desc='45']");
		
		touchAction
		.longPress(LongPressOptions.longPressOptions()
		.withElement(ElementOption.element(fromElement))
		.withDuration(Duration.ofSeconds(2)))
		.moveTo(ElementOption.element(toElement))
		.release()
		.perform();
		

	}

	@Test
	public void scrollMethod() throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = Base.driverinitialize();
		
		//Using UIAutomator
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		//String scrollElementString = "new UiScrollable(UiSelector().scrollIntoView(text(\"WebView3\")))";
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");
	}

	
}
