package AppiumRS.Appium;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class DragAndDrop {
	

	@Test
	public void scrollMethod() throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = Base.driverinitialize();
		
		//Using UIAutomator
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		driver.findElementByAndroidUIAutomator("text(\"Drag and Drop\")").click();	
		
		AndroidElement sourceElement = driver.findElementById("io.appium.android.apis:id/drag_dot_1");
		AndroidElement destinationElement = driver.findElementById("io.appium.android.apis:id/drag_dot_2");
		
		TouchAction touchAction = new TouchAction(driver);
		touchAction
		.longPress(LongPressOptions.longPressOptions()
		.withElement(ElementOption.element(sourceElement)))
		.moveTo(ElementOption.element(destinationElement))
		.release()
		.perform();
	
	}


}
