package herokuappjson_Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static String configfile = "./src/test/resources/config.properties";
	public static Properties prop = null;
	public static String extendreportpath = "./Reports";
	public static String testdatafile = "./src/test/resources/TestData.json";
	public static ExtentReports extent = null;
	public static ExtentTest test = null;
	public static String screenshotspath = System.getProperty("user.dir") + "/Screenshots";

	@BeforeSuite
	public void loadPropertyFile() {
		FileInputStream file = null;
		extent = ExtentReportFile.extentReportconfig(extendreportpath);

		try {
			file = new FileInputStream(configfile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	@BeforeMethod
	public void launchDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void teardown() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
		extent.flush();

	}
}
