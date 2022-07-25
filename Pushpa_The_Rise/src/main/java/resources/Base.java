package resources;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;  

public class Base {
	
	public  WebDriver driver;
	public  Properties prop;
	
	public Properties extractData() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		return prop;
		 
	}
	
	public WebDriver initializeDriver() throws IOException {
        
		 prop = extractData();
		String browserName=prop.getProperty("browser");
		//ChromeBrowser
		if(browserName.equals("chrome"))
		{    
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\driver\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().window().maximize();
		}
		//FirefoxBrowser
		else if(browserName.equals("firefox"))
		{
	         
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\driver\\geckodriver.exe");   

			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}	
		   return driver ;	   
	}

}
