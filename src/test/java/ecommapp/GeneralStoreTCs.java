package ecommapp;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import AppiumRS.Appium.HybridBase;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class GeneralStoreTCs {

	@Test(description = "Positive scenario - ")
	public void ecommerce_TC1() throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = HybridBase.driverinitialize("emulator", "General-Store.apk");

		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("kumar");

		driver.hideKeyboard();

		driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();

		driver.findElementById("android:id/text1").click();

		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));");

		driver.findElementByAndroidUIAutomator("text(\"Australia\")").click();

		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

	}

	@Test(description = "Negative scenario - No name ")
	public void ecommerce_TC2() throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = HybridBase.driverinitialize("emulator", "General-Store.apk");

		// driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("kumar");

		// driver.hideKeyboard();

		driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();

		driver.findElementById("android:id/text1").click();

//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));

//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));   

		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));");

		driver.findElementByAndroidUIAutomator("text(\"Australia\")").click();

		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

		String toastMessage = driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");

		System.out.println(toastMessage);

		Assert.assertEquals("Please enter your name", toastMessage);
	}

	@Test(description = "Scroll and add to cart the expected item ")
	public void ecommerce_TC3() throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = HybridBase.driverinitialize("emulator", "General-Store.apk");

		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("kumar");

		driver.hideKeyboard();

		driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();

		driver.findElementById("android:id/text1").click();

//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));

//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));   

		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));");

		driver.findElementByAndroidUIAutomator("text(\"Australia\")").click();

		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
		//Home page
		//Scroll to the element
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));

		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		System.out.println(count);

		for (int i = 0; i < count; i++)

		{

			String text = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();

			if (text.equalsIgnoreCase("Jordan 6 Rings"))

			{

				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();

				break;

			}

		}

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		String lastpageText = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();

		Assert.assertEquals("Jordan 6 Rings", lastpageText);

	}

}
