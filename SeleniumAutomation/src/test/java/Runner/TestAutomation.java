package Runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import com.cucumber.listener.Reporter;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(
		retryCount =2,
		detailedReport = true,
		detailedAggregatedReport =true,
		usageReport = true,
		toPDF= true,
		outputFolder = "target"
		
		
		
		)
@CucumberOptions(
		features= "src//test//resources//Features/",
		glue={"StepDefinition"},
		dryRun=false,
				plugin={//"pretty"
						"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"
		
		}  // to generate default report in cucumber console
				
		)
public class TestAutomation { 
	
@AfterClass

public static void writeExtentReports(){
	
	Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"//src//test//resources//Features//ExtentConfig.xml"));
	Reporter.setSystemInfo("User Name",System.getProperty("user.name"));
	Reporter.setSystemInfo("Time Zone",System.getProperty("user.timezone"));
	Reporter.setSystemInfo("Application Name","Test App");
	Reporter.setSystemInfo("os name",System.getProperty("os.name").toString());
	Reporter.setSystemInfo("Environment","Testing Server");
	

	
}


}
