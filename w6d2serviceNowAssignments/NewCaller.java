package w6d2serviceNowAssignments;

//import java.util.ArrayList;

import java.util.List;
//import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class NewCaller extends BaseClass{
	@BeforeTest
	public void setFile() {
		filename="NewCallerTestData";
	}
	@Test(dataProvider="fetchData")

	public  void newCaller(String fname, String lname,String email,String ph, String phno) throws InterruptedException {
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
		
		shadow.findElementByXPath("//button[text()='New']").click();
		shadow.findElementByXPath("//input[@id='sys_user.first_name']").sendKeys(fname);
		shadow.findElementByXPath("//input[@id='sys_user.last_name']").sendKeys(lname);
		shadow.findElementByXPath("//input[@id='sys_user.title']").sendKeys("creating new caller");
		shadow.findElementByXPath("//input[@id='sys_user.email']").sendKeys(email);
		shadow.findElementByXPath("//input[@id='sys_user.phone']").sendKeys(ph);
		shadow.findElementByXPath("//input[@id='sys_user.mobile_phone']").sendKeys(phno);
		shadow.findElementByXPath("//button[@id='sysverb_insert_bottom']").click();
		WebElement dd = shadow.findElementByXPath("//select[@role='listbox']");
		Select sel = new Select(dd);
		sel.selectByIndex(3);
		shadow.findElementByXPath("//input[@class='form-control']").sendKeys(ph,Keys.ENTER);
		Thread.sleep(3000);
		List<WebElement> list = shadow.findElementsByXPath("//a[@class='linked formlink']");
		boolean found=false;
		for (WebElement webElement : list) {
			if(webElement.getText().contains(ph)) {
				found=true;
				break;
			}
			
		}
		if(found) {
			System.out.println("New caller is created successfully");
		}else {
			System.out.println("New caller is not created");
			
		}
	}
	
	}
	
	


		
		
		


	


