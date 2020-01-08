package Nanoprecise.WebAuto;

import org.openqa.selenium.By;

public class Nano_Locators {
	public static By USER_ID = By.xpath("//*[@class = 'jss556']");//By.xpath("//*[@class='jss532 jss535']");//By.xpath("//*[text()='Username']");
	public static By PASSWORD = By.xpath("//*[@type = 'password']");
	
	public static By LOGIN_BTN = By.xpath("//*[@type = 'button']");
	public static By LOGOUT_BTN = By.xpath("//*[text()='Logout']");
    //Health Summery
	public static By Health_Summery = By.xpath("//*[text()='Health Summary']");
	public static By  Click_DD = By.xpath("//*[@class='css-1hwfws3']");
	
	public static By Remaining_Useful_Life = By.xpath("//*[contains(text(),'Remaining Useful')]");
    public static By Remaining_Useful_Life_Val = By.xpath("//*[contains(text(),'Remaining Useful')]/following::*[2]");
    public static By Recommendation = By.xpath("//*[contains(text(),'Recommendation:')]");
    public static By Recommendation_Val = By.xpath("//*[contains(text(),'Recommendation:')]/following::*[2]");
    public static By Fault_Mode = By.xpath("//*[contains(text(),'Fault Mode')]");
    public static By Fault_Mode_Val = By.xpath("//*[contains(text(),'Fault Mode')]/following::*[2]");
    public static By Health_Status = By.xpath("//*[contains(text(),'Health Status')]");
    public static By Health_Status_Val = By.xpath("//*[contains(text(),'Health Status')]/following::*[2]");
    
    
    //Sound
    public static By  Sound = By.xpath("//*[text()='Sound']");
    public static By  RMS = By.xpath("//*[text()='RMS']");
    public static By  DatePicker = By.xpath("//*[@class='c-datepicker']");
    public static By  From_Date = By.xpath("(//input[@class='c-datepicker'])[1]");
    public static By  To_Date = By.xpath("(//input[@class='c-datepicker'])[2]");
    public static By  PreviousMonth = By.xpath("//*[text()='Previous Month']");
    public static By  NextMonth = By.xpath("//*[text()='Next Month']");
    //public static By XXXXX= By.xpath("");
}
