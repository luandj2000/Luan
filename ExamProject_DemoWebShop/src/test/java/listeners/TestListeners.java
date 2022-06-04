package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import frameWork.BasePage;
import frameWork.Utilities;

public class TestListeners extends BasePage implements ITestListener {

	Utilities util = new Utilities();

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		// when this method is triggered take a screen shot
		try {
			util.takeSnapShot("On test Success" + util.timereturn() + ".png");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// when this method is triggered take a screen shot
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		try {
			util.takeSnapShot("On test Failure" + util.timereturn() + ".png");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		cleanUp();
	}
}
