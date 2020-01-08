package Nanoprecise.WebAuto;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Nano_Execution extends Nano_Repository {
	
	@BeforeTest
	public void verify_Launch() {
		launchApp();
	}
	@Test(priority = 1)
	public void verify_Login() {
		loginApp();
	}
	@Test(priority = 2)
	public void equipment() {
		equipment_Table();
	}
	@Test(priority = 3)
	public void hltSummery() throws Exception {
		health_Summary();
	}
	
	@Test(priority = 4)
	public void checkRMS() throws Exception {
		 sound_RMS();
	}
	@Test(priority = 5)
	public void checkDateWise() throws Exception {
		chooseDate("12/11/2019");
	}
	
	
	  @AfterTest 
	  public void cLoseApp() throws Exception {
	  Thread.sleep(15000);
		  //driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  logout();
	  driver.close(); }
	 
}
