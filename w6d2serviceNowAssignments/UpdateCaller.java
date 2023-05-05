package w6d2serviceNowAssignments;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class UpdateCaller extends BaseClass {

	@BeforeTest
	public void setFile() {
		filename="UpdateCallerTestData";
	}
	@Test(dataProvider="fetchData")

	public  void newCaller(String search, String update) throws InterruptedException {
		Thread.sleep(6000);
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(20);
		shadow.findElementByXPath("//div[text()='All']").click();
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("caller");
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//mark[text()='Caller']").click();
		WebElement frame = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame);
		WebElement dd = shadow.findElementByXPath("//select[@role='listbox']");
		Select sel = new Select(dd);
		sel.selectByIndex(2);
		shadow.findElementByXPath("//input[@class='form-control']").sendKeys(search,Keys.ENTER);
		shadow.findElementByXPath("//a[@class='linked formlink']").click();
		shadow.findElementByXPath("//input[@id='sys_user.phone']").clear();
		shadow.findElementByXPath("//input[@id='sys_user.phone']").sendKeys(update);
		shadow.findElementByXPath("//button[@id='sysverb_update_bottom']").click();
		shadow.findElementByXPath("//input[@class='form-control']").sendKeys(search,Keys.ENTER);
		shadow.findElementByXPath("//a[@class='linked formlink']").click();
	//	WebElement Bphone = shadow.findElementByXPath("//input[@id='sys_user.phone']");
		String value = shadow.findElementByXPath("//input[@id='sys_user.phone']").getAttribute("value");
	  Thread.sleep(3000);
		if(value.contains(update)) {
	    	System.out.println("caller updated successfully");
	    }else {
	    	System.out.println("caller not updated");
	    }
	}

}
