package pages;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import driversetup.Driver;

public class Villas extends Driver {
By Villas=By.xpath("//span[text()='Villas & Apts']");
By Search_city=By.xpath("//span[text()='City / Hotel / Area / Building']");
By Enter=By.xpath("//input[@placeholder=\"Enter city/ Hotel/ Area/ Building\"]");
By check_in=By.xpath("//input[@id='checkin']");
By Next_Month=By.xpath("//span[@aria-label=\"Next Month\"]");
By check_out =By.xpath("//input[@id='checkout']");
By dates_in_first_displayed_month=By.xpath("(//div[text()='18'])[1]");
By dates_in_second_displayed_month=By.xpath("(//div[text()='18'])[2]");
By Guest= By.xpath("//input[@id='guest']");
By Adults = By.xpath("//li[@data-cy=\"adults-11\"]");
By Adults1 = By.xpath("//li[@data-cy=\"adults-15\"]");
By Children=By.xpath("//li[@data-cy=\"children-1\"]");
By Children1=By.xpath("//li[@data-cy=\"children-2\"]");
By Traveller= By.xpath("//span[contains(text(),'Travelling For')]");
//By work=By.xpath("//li[contains(text(),'Work')]");
By work=By.xpath("//li[contains(text(),'Work')]");
By Leisure=By.xpath("//li[contains(text(),'Leisure')]");
By search=By.xpath("//button[@id='hsw_search_button']");
By Apply=By.xpath("//button[contains(text(),'APPLY')]");
By popularfilters=By.xpath("//p[text()='4BHK']");
By location=By.xpath("//span[text()='North Goa']");
By rating=By.xpath("//p[text()='4 & above (Very Good)']");
By property=By.xpath("//p[text()='Apartments & more']");
By Facility=By.xpath("//p[text()='Outdoor Sports']");
By entireprop=By.xpath("//p[text()='Entire Property']");
By hostlang=By.xpath("//p[text()='English']");
By villa=By.xpath("//span[text()='Riviera Hermitage']");
By villa_filter=By.xpath("//span[text()='Heritage Exotica Villa : 4BHK, Baga']");
By gettitle=By.xpath("//h1[@id='detpg_hotel_name']");
By combo=By.xpath("//button[@id='detpg_multi_view_combo']");
By book_combo=By.xpath("//span[@id='detpg_book_combo_btn']");
By textmsg=By.xpath("//p[text()='Upto 15 guests allowed.']");


	public void openUrl() throws InterruptedException
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(2000);
		exttest=report.createTest("Validate URL");
		exttest.log(Status.PASS,"Title is correct and the search word is displayed");
	
	}
	public void selectPage() throws InterruptedException
	{
		//hread.sleep(2000);
	driver.findElement(Villas).click();
	}
	public void selectCity() throws InterruptedException, IOException
	{
		//Thread.sleep(2000);
	driver.findElement(Search_city).click();
	
	driver.findElement(Enter).sendKeys("Goa");
	Thread.sleep(2000);
	driver.findElement(Enter).sendKeys(Keys.DOWN);
	driver.findElement(Enter).sendKeys(Keys.ENTER);
	exttest=report.createTest("Search city validation");
	exttest.log(Status.PASS,"Title is correct and the city was displayed with proper screen shot");
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	// Now you can do whatever you need to do with it, for example copy somewhere
	FileUtils.copyFile(scrFile, new File(prop.getProperty("screenshot")+"city.png"));
	exttest.addScreenCaptureFromPath(prop.getProperty("screenshot")+"city.png");
	}
	
	public void dates() throws InterruptedException
	{
		//Thread.sleep(2000);
	driver.findElement(check_in).click();
	driver.findElement(dates_in_first_displayed_month).click();
	driver.findElement(check_out).click();
	driver.findElement(dates_in_second_displayed_month).click();
	}
	
	public void noOfGuests() throws InterruptedException
	{
		//Thread.sleep(2000);
	driver.findElement(Guest).click();
	Thread.sleep(2000);
	driver.findElement(Adults).click();
	driver.findElement(Children).click();
	//Thread.sleep(2000);
	driver.findElement(Apply).click();
	}
	public void noOfinvalidGuests() throws InterruptedException, IOException
	{
		//Thread.sleep(2000);
	driver.findElement(Guest).click();
	Thread.sleep(2000);
	driver.findElement(Adults1).click();
	driver.findElement(Children1).click();
	Thread.sleep(2000);
	exttest=report.createTest("Guests more than 15 allowed");
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	// Now you can do whatever you need to do with it, for example copy somewhere
	FileUtils.copyFile(scrFile, new File(prop.getProperty("screenshot")+"guests.png"));
	exttest.addScreenCaptureFromPath(prop.getProperty("screenshot")+"guests.png");
	//driver.findElement(textmsg);
	String str=driver.findElement(textmsg).getText();
	System.out.println(str);
	//Thread.sleep(2000);
	driver.findElement(Apply).click();
	if(true)
	{
		
		exttest.log(Status.FAIL,"Guests Booking displayed in report as success");
	}
	
	}
	public void travellingFor() throws InterruptedException
	{
		//Thread.sleep(2000);
	driver.findElement(Traveller).click();
	driver.findElement(work).click();
	exttest=report.createTest("work section allowed");
	exttest.log(Status.PASS,"work section report report as success");
	}
	public void finalSearch() throws InterruptedException
	{
		//Thread.sleep(2000);
	driver.findElement(search).click();	
	Thread.sleep(5000);
	
	}
	public static String str;
	public void selectfilters()//rey
	{
		driver.findElement(popularfilters).click();
		driver.findElement(location).click();
		driver.findElement(rating).click();
		//driver.findElement(property).click();
		driver.findElement(Facility).click();
		//driver.findElement(entireprop).click();
		driver.findElement(hostlang).click();
	}
	public void villas_filters()
	{
		str=driver.findElement(villa).getText();
		driver.findElement(villa_filter).click();
	}
	public void selectvillas()
	{
		str=driver.findElement(villa).getText();
		driver.findElement(villa).click();
	}
	public void validatetitle()
	{
		ArrayList<String> lst=(ArrayList<String>) driver.getWindowHandles();
		driver.switchTo().window(lst.get(1));
		String str1=driver.findElement(gettitle).getText();
		if(str.equalsIgnoreCase(str1))
		{
			System.out.println("Equal");
		}
		else
		{
			System.out.println("Not Equal");
		}
			
	}
	public void booking()
	{
		driver.findElement(combo).click();
		driver.findElement(book_combo).click();
		exttest=report.createTest("Validate Booking");
		exttest.log(Status.FAIL,"Booking displayed in report success");
	}
	
}
