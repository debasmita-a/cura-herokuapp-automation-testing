package reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	
	private ExtentReport() {
	}

	public static ExtentReports extent;
	
	public static void setupReporter() {
		if(Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark/Spark.html");
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("Cura Herokuapp Test Automation Report");
			spark.config().setReportName("Test Automation Report");
		}

	}
	
	public static void flushReporter() throws IOException {
		if(Objects.nonNull(extent)) {
			extent.flush();
		}
		Desktop.getDesktop().browse(new File("target/Spark/Spark.html").toURI());
	}
	
	public static void createTest(String testcasename) {
		ExtentManager.setExtentTest(extent.createTest(testcasename));
	}

}
