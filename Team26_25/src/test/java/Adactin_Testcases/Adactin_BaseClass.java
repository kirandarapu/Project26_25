package Adactin_Testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import Adactin_Utilities.ReadingData;

public class Adactin_BaseClass {

	//common functionality for every testcase

	ReadingData rd=new ReadingData();

	public String AppURL=rd.getAppURL();
	public String UName=rd.getUsername();
	public String PWord=rd.getPassword();

	public static WebDriver driver;
	public static Logger log;
	@BeforeClass
	public void openApp() {

		driver=new ChromeDriver();

		driver.get(AppURL);
		driver.manage().window().maximize();

		log=Logger.getLogger(driver.getClass());
		PropertyConfigurator.configure("log4j.properties");
	}


	@AfterClass
	public void closeApp() {

		driver.close();
	}

	//create capture screenshot method in baseclass

	public String captureScreen(String name) throws IOException {
		String timeStamp=new SimpleDateFormat("dd.MM.yyyy.hh.mm.ss").format(new Date());

		TakesScreenshot ts=(TakesScreenshot)driver;

		File src=ts.getScreenshotAs(OutputType.FILE);

		//system.getProperty("user.dir")
		String target=(System.getProperty("user.dir")+"\\Screenshots\\"+name+"_"+timeStamp+".png");

		try {
			FileUtils.copyFile(src, new File(target));
		}catch(Exception e) {
			e.printStackTrace();
		}

		log.info("screenshot is taken");
		return target;
	}

}


