package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import herokuappjson_Base.BaseClass;
import herokuappjson_Base.JsonReader;
import pages.Login_Page;

public class TC_001_logintest extends BaseClass {
	String expectedurl = "https://the-internet.herokuapp.com/secure";
	String actualurl;
	@Test
	public void logintestpositive() {
		test = extent.createTest(new Object() {
		}.getClass().getEnclosingMethod().getName());
		try {
			Login_Page login = new Login_Page(driver);
			JsonReader jread = new JsonReader();
			jread.getdata(0);
			login.login(jread.getUsername(), jread.getPassword());
			actualurl = driver.getCurrentUrl();
			Assert.assertEquals(actualurl, expectedurl);
			test.log(Status.PASS, "Login Successfull");
		} catch (Exception e) {
			test.log(Status.FAIL, e.getMessage());
		}

	}

	@Test
	public void logintestnegative1() {
		test = extent.createTest(new Object() {
		}.getClass().getEnclosingMethod().getName());
		try {
			Login_Page login = new Login_Page(driver);
			JsonReader jread = new JsonReader();
			jread.getdata(1);
			login.login(jread.getUsername(), jread.getPassword());
			actualurl = driver.getCurrentUrl();
			Assert.assertNotEquals(actualurl, expectedurl);
			test.log(Status.PASS, "login unsuccessfull");
		} catch (Exception e) {
			test.log(Status.FAIL, e.getMessage());
		}
	}

	@Test
	public void logintestnegative2() {
		test = extent.createTest(new Object() {
		}.getClass().getEnclosingMethod().getName());
		try {
			Login_Page login = new Login_Page(driver);
			JsonReader jread = new JsonReader();
			jread.getdata(2);
			login.login(jread.getUsername(), jread.getPassword());
			actualurl = driver.getCurrentUrl();
			Assert.assertNotEquals(actualurl, expectedurl);
			test.log(Status.PASS, "login unsuccessfull");
		} catch (Exception e) {
			test.log(Status.FAIL, e.getMessage());
		}
	}

}



