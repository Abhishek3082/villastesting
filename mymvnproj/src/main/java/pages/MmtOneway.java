package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import driversetup.Driver;


public class MmtOneway extends Driver {
	By flight=By.xpath("//*[@id='SW']/div[1]/div[2]/div/div/nav/ul/li[1]/a");
	By oneway=By.xpath("//*[text()='OneWay']");
    By from=By.xpath("//span[text()='From']");
  By enter=By.xpath("//input[@placeholder=\"From\"]");
    By hyd=By.xpath("//*[text()='HYD']");
    By to=By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[1]/div/div/div/input");
    By mumbai=By.xpath("//*[@id=\"react-autowhatever-1-section-0-item-0\"]/div");
    By departure=By.xpath("//*[@id='departure']");
    By date1=By.xpath("//div[@aria-label='Wed Jun 16 2021']");
    By Return=By.xpath("//span[text()='RETURN']");
    By date2 = By.xpath("(//p[text()='21'])[1]");//mada kudvu
    By multi=By.xpath("//*[text()='Multi City']");
    By mfrom1=By.xpath("(//span[text()='From'])[1]");
    By menter1=By.xpath("//input[@placeholder=\"From\"]");
    By mto1=By.xpath("(//span[text()='To'])[1]");
    By mtoenter1=By.xpath("//input[@placeholder='To']");
    By mdep1=By.xpath("//input[@id='anotherDeparture 0']");
    By mdate1=By.xpath("//div[@aria-label='Wed Jun 23 2021']");
    By mfrom2=By.xpath("(//span[text()='From'])[1]");
    By menter2=By.xpath("//input[@placeholder=\"From\"]");
    By mto2=By.xpath("//input[@value=\"Select City\"]");
    By mtoenter2=By.xpath("//input[@aria-autocomplete=\"list\"]");
    By mdep2=By.xpath("//input[@id='anotherDeparture 1']");
    By mdate2=By.xpath("//div[@aria-label='Tue Jul 13 2021']");
    By search=By.xpath("//a[text()='Search']");
    By error=By.xpath("//span[@class=\"redText errorMsgText\"]");
    By trending=By.xpath("(//a[@class='darkGreyText'])[3]");
  
    public void openurl() {
    	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
	}


  // @Test(priority=1)
public void oneway() throws InterruptedException {
	
	Thread.sleep(5000);
	driver.findElement(from).click();
	driver.findElement(enter).sendKeys("Hyderabad");
	Thread.sleep(2000);
	driver.findElement(enter).sendKeys(Keys.DOWN);
    driver.findElement(enter).sendKeys(Keys.ENTER);
	driver.findElement(to).sendKeys("mumbai");
	driver.findElement(to).sendKeys(Keys.DOWN);
	driver.findElement(to).sendKeys(Keys.ENTER);
    Thread.sleep(2000);
	//driver.findElement(departure).click();
    Thread.sleep(2000);
	driver.findElement(date1).click();
	//driver.findElement(date1).click();
	Thread.sleep(2000);
	driver.findElement(search).click();
	driver.quit();
}
  // @Test(priority=2)
public void roundtrip() throws InterruptedException {
	Thread.sleep(5000);
	driver.findElement(from).click();
	driver.findElement(enter).sendKeys("Hyderabad");
	Thread.sleep(2000);
	driver.findElement(enter).sendKeys(Keys.DOWN);
	Thread.sleep(2000);
    driver.findElement(enter).sendKeys(Keys.ENTER);
	driver.findElement(to).sendKeys("mumbai");
	driver.findElement(to).sendKeys(Keys.DOWN);
    driver.findElement(to).sendKeys(Keys.ENTER);
    Thread.sleep(2000);
    Thread.sleep(2000);
	driver.findElement(date1).click();
	Thread.sleep(2000);
	driver.findElement(Return).click();
	Thread.sleep(2000);
	driver.findElement(date2).click();
	driver.findElement(search).click();
	driver.quit();
}
  // @Test(priority=3)
public void multicity() throws InterruptedException{
	driver.findElement(multi).click();
	Thread.sleep(2000);
	driver.findElement(mfrom1).click();
	driver.findElement(menter1).sendKeys("Hyderabad");
	Thread.sleep(2000);
	driver.findElement(menter1).sendKeys(Keys.DOWN);
	driver.findElement(menter1).sendKeys(Keys.ENTER);
	driver.findElement(mto1).click();
	driver.findElement(mtoenter1).sendKeys("banglore");
	Thread.sleep(2000);
	driver.findElement(mtoenter1).sendKeys(Keys.DOWN);
	driver.findElement(mtoenter1).sendKeys(Keys.ENTER);
	//driver.findElement(mdep1).click();
	Thread.sleep(2000);
	driver.findElement(mdate1).click();
	Thread.sleep(2000);
	driver.findElement(mto2).click();

	driver.findElement(mtoenter2).sendKeys("tirupathi");
	Thread.sleep(2000);
	driver.findElement(mtoenter2).sendKeys(Keys.DOWN);
	driver.findElement(mtoenter2).sendKeys(Keys.ENTER);
	//driver.findElement(mdep2).click();
	driver.findElement(mdate2).click();
	driver.findElement(search).click();
	driver.quit();
}
// @Test(priority=4)
public void Trending() throws InterruptedException {
	Thread.sleep(2000);
	
	String s=driver.findElement(trending).getText();
	System.out.println(s);
	driver.findElement(trending).click();
	System.out.println("Success");
	
}
//INVALID TESTCASES
	public void invalidft() throws InterruptedException {
		driver.findElement(from).click();
		driver.findElement(enter).sendKeys("Hyderabad");
		Thread.sleep(2000);
		driver.findElement(enter).sendKeys(Keys.DOWN);
	    driver.findElement(enter).sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
		driver.findElement(to).sendKeys("Hyderabad");
		Thread.sleep(2000);
		driver.findElement(to).sendKeys(Keys.DOWN);
		driver.findElement(to).sendKeys(Keys.ENTER);
		
		String error1=driver.findElement(error).getText();
		System.out.println(error1);
	    Thread.sleep(2000);
		
	}
	public void multione() throws InterruptedException {
		driver.findElement(multi).click();
		Thread.sleep(2000);
		driver.findElement(mfrom1).click();
		driver.findElement(menter1).sendKeys("Hyderabad");
		Thread.sleep(2000);
		driver.findElement(menter1).sendKeys(Keys.DOWN);
		driver.findElement(menter1).sendKeys(Keys.ENTER);
		driver.findElement(mto1).click();
		driver.findElement(mtoenter1).sendKeys("banglore");
		Thread.sleep(2000);
		driver.findElement(mtoenter1).sendKeys(Keys.DOWN);
		driver.findElement(mtoenter1).sendKeys(Keys.ENTER);
		//driver.findElement(mdep1).click();
		Thread.sleep(2000);
		driver.findElement(mdate1).click();
		Thread.sleep(2000);
		driver.findElement(search).click();
		System.out.println("returns to oneway");
		
	}
	
}
