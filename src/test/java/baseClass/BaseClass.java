package baseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {
	
		protected static WebDriver driver;
		static String baseUrl = "https://demoblaze.com/";
		
		@BeforeMethod
		@Parameters({"browers"})
		public  void setUp(@Optional("chrome") String br) {

				switch (br.toLowerCase()) {
				case "chrome" :driver = new ChromeDriver(); break;
				case "edge" :driver = new EdgeDriver(); break;
				case "firefox" :driver = new FirefoxDriver(); break;
				default: System.out.println("Invalid Browser"); return;
				
				}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get(baseUrl);
			System.out.println("Launched Browser : "+baseUrl);
			
		}

		@AfterMethod
		public void tearDown() {
			driver.quit();
			System.out.println("Browser Closed!!");
		}
	}



