package Day49_utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Day49_testCases.BaseClass;

public class ExtendReportManager implements ITestListener	 {
	
	public ExtentSparkReporter spartReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	
	public void onStart(ITestContext testContext)
	{
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		repName="Test-Report-" + timeStamp + ".html";
		spartReporter=new ExtentSparkReporter(".\\reports\\"+repName);
		
		spartReporter.config().setDocumentTitle("Opencart automation Report");
		spartReporter.config().setReportName("Opencart Functional Testing");
		spartReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(spartReporter);
		extent.setSystemInfo("Application", "Opencart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Customers");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		
		String os=testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating system", os);
		
		String browser=testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		List<String> includeGroups=testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includeGroups.isEmpty())
		{
			extent.setSystemInfo("Groups", includeGroups.toString());
		}
		
	}
	
	public void onTesstSuccess(ITestResult result)
	{
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName()+"got successfully executed");
	}
	
	public void onTestFailure(ITestResult result)
	{
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.FAIL, result.getName()+"got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		
		String imgPath=new BaseClass().captureScreen(result.getName());
		test.addScreenCaptureFromPath(imgPath);
	}
	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+"got Skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}
	
	public void onFinish(ITestContext testContest)
	{
		extent.flush();
		
		String pathOfExtendReport=System.getProperty("user.dir")+"\\reports\\"+repName;
		File extentReport=new File(pathOfExtendReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		}catch (IOException e){
			e.printStackTrace();
		}
		
		
		
	/*	try {
			URL url=new URL("file://"+System.getProperty("user.dir")+"\\reports\\"+repName);
			
			//Create email message
			ImageHtmlEmail email=new ImageHtmlEmail();
			email.setDataSourceResolver(new DataSourceUrlResolver(url));
			email.setHostName("smtp.googleemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("balajiloging@gmail.com","Password"));
			email.setSSLOnConnect(true);
			email.setFrom("balajiloging@gmail.com");
			email.setSubject("Test Resultes");
			email.setMsg("Please find attached report");
			email.addTo("balajiloging@gmail.com");
			email.attach(url,"extent report","Please check report....");
			email.send();
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		
	}
	

}
