package Rk.TestNGPackage;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo {

	public static void main(String[] args) throws IOException {
		
		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/Spark/Spark.html");
		extentReports.attachReporter(sparkReporter);

		ExtentTest test1 = extentReports.createTest("Test 1");
		test1.pass("This is passed");
		
		ExtentTest test2 = extentReports.createTest("Test 2");
		test2.log(Status.FAIL, "This is failed");
		
		extentReports.createTest("Test 3").skip("This is skipped");
		
		extentReports.flush();
		Desktop.getDesktop().browse(new File("target/Spark/Spark.html").toURI());
		
	}

}
