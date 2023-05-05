package w6d2serviceNowAssignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class DeleteCaller extends BaseClass{
	@BeforeTest
	public void setFile() {
		filename="DeleteCallerTestData";
	}
	@Test(dataProvider="fetchData")

	public  void newCaller(String search) throws InterruptedException {
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
		shadow.findElementByXPath("//button[@id='sysverb_delete_bottom']").click();
		driver.findElement(By.xpath("//button[@id='ok_button']")).click();
		shadow.findElementByXPath("//input[@class='form-control']").sendKeys(search,Keys.ENTER);
		List<WebElement> list = shadow.findElementsByXPath("//a[@class='linked formlink']");
		Thread.sleep(3000);
		boolean found=false;
		for (WebElement webElement : list) {
			if(webElement.getText().contains(search)) {
				found=true;
				break;
			}
			
		}
		if(found) {
			System.out.println("caller is not deleted");
		}else {
			System.out.println("caller is deleted successfully");
		}
	}
}
