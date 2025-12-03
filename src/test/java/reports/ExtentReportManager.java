package reports;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	
		
		ExtentSparkReporter sparkReporter; 		//UI of the report
		ExtentReports extent; 					//Populate Common info on the Report
		ExtentTest test; 						//Creating Test Cases Entries in the report and Update the status of the Test Methods
		
		
		@Override
		public void  onStart(ITestContext context) {
			sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/testrunreport.html");
			sparkReporter.config().setDocumentTitle("Automation Report");
			sparkReporter.config().setReportName("Regression Testing");
			sparkReporter.config().setTheme(Theme.DARK);
			
			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
			
			extent.setSystemInfo("Computer Name","local host");
			extent.setSystemInfo("Environment","QA");
			extent.setSystemInfo("Tester Name","Nandhana");
			extent.setSystemInfo("OS","Windows");
			extent.setSystemInfo("Browser","Chrome");
			
			
			
		}
		@Override
		
		public void onTestSuccess(ITestResult result) {
			test = extent.createTest(result.getName());   	//Create a New Entry in the Report
			test.log(Status.PASS,"TestCase Passed : "+result.getName());	//Update the status
			
			
		}
		
		@Override
		
		public void onTestFailure(ITestResult result) {
			test = extent.createTest(result.getName());   	//Create a New Entry in the Report
			test.log(Status.FAIL,"TestCase Failed : "+result.getName());	//Update the status
			
			
		}
		@Override

		public void onTestSkipped(ITestResult result) {
			test = extent.createTest(result.getName());   	//Create a New Entry in the Report
			test.log(Status.SKIP,"TestCase Passed : "+result.getName());	//Update the status
	
	
		}
		public void onFinish(ITestContext context) {
			extent.flush();
		}
		
}