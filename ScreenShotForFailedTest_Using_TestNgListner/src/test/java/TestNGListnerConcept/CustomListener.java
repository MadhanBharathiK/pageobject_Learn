package TestNGListnerConcept;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener extends baseClass implements ITestListener {
	
	
	@Override
	public void onTestStart(ITestResult reuslt) {
		
	}
	
	@Override
	public void onTestSuccess(ITestResult reuslt) {
		
	}

	
	@Override
	public void onTestFailure(ITestResult result) {
		
		System.out.println("FAILED Test");
		failed(result.getMethod().getMethodName());
		
		
	}
	
	@Override
	public void onTestSkipped(ITestResult reuslt) {
		
	}
	
	
}
