package Nanoprecise.WebAuto;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Nano_Repository {
	WebDriver driver;
	public void launchApp() {
		System.setProperty("webdriver.chrome.driver","D:\\shubhrajit_workspace\\WebAuto\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://operations.nanoprecisedataservices.com/");
	}
	
	public void loginApp() {
		//Passing UserId & Password and Hitting login button.
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(Nano_Locators.USER_ID).sendKeys(Nano_TestData.UserName);
		driver.findElement(Nano_Locators.PASSWORD).sendKeys(Nano_TestData.PassWord);
	    driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.findElement(Nano_Locators.LOGIN_BTN).click();
	}
	
	public void logout() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(Nano_Locators.LOGOUT_BTN).click();
		
	}
	public void equipment_Table() {
		
		       
        WebElement equip = driver.findElement(By.xpath("(//*[@id='root']//table/tbody/tr/td[1])[2]"));
        String equipName = equip.getText();
        System.out.println("Checking details for "+equipName);
        
        equip.click();
	}
	
	public void health_Summary() throws Exception {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(Nano_Locators.Health_Summery).click();
		
		//Operating the DropDown using System KeyBoard
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		WebElement DD_data = driver.findElement(Nano_Locators.Click_DD);
		DD_data.click();
		Robot robo=new Robot();
		robo.keyPress(KeyEvent.VK_DOWN);
		robo.keyRelease(KeyEvent.VK_DOWN);
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		
		
		//Collecting all the information from the Visible data present in the screen
		String Remaining_Useful_Life = driver.findElement(Nano_Locators.Remaining_Useful_Life_Val).getText();
		System.out.println(Remaining_Useful_Life);
		
		String Recommendation = driver.findElement(Nano_Locators.Recommendation_Val).getText();
		System.out.println(Recommendation);
		
		
		String Fault_Mode = driver.findElement(Nano_Locators.Fault_Mode_Val).getText();
		System.out.println(Fault_Mode);
		
		String Health_Status = driver.findElement(Nano_Locators.Health_Status_Val).getText();
		System.out.println(Health_Status);
		
		
		
		
		
		/*
		 * Actions actdd = new Actions(driver);
		 * DD_data.click(); Thread.sleep(5000);
		 * DD_data.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		 */
		/*
		 * actdd.click(DD_data).build().perform();
		 * actdd.keyDown(Keys.ARROW_DOWN).build().perform();
		 * actdd.keyDown(Keys.ARROW_DOWN).build().perform();
		 * actdd.keyUp(Keys.ARROW_DOWN).build().perform();
		 * actdd.keyDown(Keys.ENTER).build().perform();
		 */
		
	}
	

	public void sound_RMS() throws Exception {	
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(Nano_Locators.Sound).click();
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(Nano_Locators.RMS).click();
		
		//Operating the DropDown using System KeyBoard
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				WebElement DD_data = driver.findElement(Nano_Locators.Click_DD);
				DD_data.click();
				Robot robo=new Robot();
				robo.keyPress(KeyEvent.VK_DOWN);
				robo.keyRelease(KeyEvent.VK_DOWN);
				robo.keyPress(KeyEvent.VK_ENTER);
				robo.keyRelease(KeyEvent.VK_ENTER);
	}	
	//Changing the time period
	public void chooseDate(String selectdate) throws Exception {
		
		Date dt=new Date(selectdate);
		SimpleDateFormat dat=new SimpleDateFormat("MMM/dd/yyyy");
		String date=dat.format(dt);
		String[] split = date.split("/");
		String month = split[0]+" "+split[2];
		System.out.println(month);
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(Nano_Locators.From_Date).click();
		
		while(true) {
			try {
				driver.findElement(By.xpath("//*[contains(text(),'"+month+"')]")).isDisplayed();
				String firstPart = "//*[@class='react-datepicker__day react-datepicker__day--0";
				String secondPart = "']";
				String[] splitDate = selectdate.split("/");
				String finalPart = firstPart+splitDate[1]+secondPart;
				driver.findElement(By.xpath(finalPart)).click();
				break;
			}catch (Exception e) {
				driver.findElement(Nano_Locators.NextMonth).click();
				Thread.sleep(5000);
			}
		}
		
		//JavascriptExecutor js =(JavascriptExecutor)driver;
		//js.executeScript("document.getElementByClassName('c-datepicker').value='2019-12-12'");
	}
}
