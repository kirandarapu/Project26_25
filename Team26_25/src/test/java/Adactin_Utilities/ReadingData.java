package Adactin_Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadingData {//utilities class
	
	//excel sheet ==> reading mode ==> FileInputStream
	Properties pro;
	public  ReadingData() {
		
		File f=new File("D:\\SeleniumPracticeWork\\Team26_25\\Configuration\\data.properties");
	
		try {
			//it is converted into reading mode
			FileInputStream fis=new FileInputStream(f);
			pro=new Properties();
			pro.load(fis);//load the file input stream
		}catch(Exception e) {
			e.printStackTrace();//it is provide the proper information about exception,which line of code getting error 
		}
	
		
	
	}
	
	public String getAppURL() { //get the application url
		
		String url=pro.getProperty("appURL");
		return url;
	}
	
	public String getUsername() {//get the username
		
		String uname=pro.getProperty("username");
		return uname;
	}
	
	public String getPassword() {
		
		String pword=pro.getProperty("password");
		return pword;
				
	}
	

}
