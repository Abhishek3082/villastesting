package driversetup;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Driver 
	{
	    public static WebDriver driver;
	    public static Properties prop;
	    public static ExtentHtmlReporter exthtml;
		public static ExtentReports report;
		public static ExtentTest exttest;
		
		
	    public void setUp()
	    {
	    	prop=new Properties();
	    	try{prop.load(new FileInputStream("src/main/java/config/config.properties"));}catch(Exception e) {}
	    	if(prop.getProperty("browsername").matches("chrome"))
	    	{
	    		driver=new ChromeDriver();
	    		//driver.get("https://opensource-demo.orangehrmlive.com");
	    	}
	    	exthtml = new ExtentHtmlReporter(prop.getProperty("reportslocation"));
			   report = new ExtentReports();
		 	   report.attachReporter(exthtml);
		 	   report.setSystemInfo("Host Name", "TestSystem");  //name of thesystem
		 	   report.setSystemInfo("Environment", "Test Env");
		 	   report.setSystemInfo("User Name", "ABHI VIJAY");
		 	   
		 	   exthtml.config().setDocumentTitle("Make_My_Trip");
		 	   exthtml.config().setReportName("Villas Module Testing");
		 	   exthtml.config().setTestViewChartLocation(ChartLocation.TOP);
		 	   exthtml.config().setTheme(Theme.STANDARD);
	    }
	  
//	    public void teadDown()
//	    {
//	    	driver.close();
//	    
//	 		try {
//	 		Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");
//	 		//Runtime.getRuntime().exec("taskkill /f /im geckodriver.exe");
//	 		}
//	 		catch(Exception e)
//	 		{
//	 			
//	 		}
//	 		report.flush();
//	    }
}
