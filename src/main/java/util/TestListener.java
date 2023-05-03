package util;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static page.BasePage.getDriver;

public class TestListener implements ITestListener {

//    final boolean USE_FULL_PAGE_SCREENSHOT = true;

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log("Test '" + iTestResult.getName() + "' PASSED");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log("Test '" + iTestResult.getName() + "' FAILED");
        saveScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log("Test '" + iTestResult.getName() + "' SKIPPED");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        log("Test Started....");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        log("Test finished");
    }

    private void saveScreenshot() {
//        if(false) {
        Shutterbug.shootPage(getDriver(), Capture.VIEWPORT).save();
        Shutterbug.shootPage(getDriver(), Capture.FULL_SCROLL).save();
//        } else
//        {
//            File screenCapture = ((TakesScreenshot) getDriver())
//                    .getScreenshotAs(OutputType.FILE);
//            try {
//                FileUtils.copyFile(screenCapture, new File(
//                        ".//target/view_port_screenshots/"
//                                + getCurrentTimeAsString() +
//                                ".png"));
//            } catch (IOException e) {
//                log("Failed to save screenshot: " + e.getLocalizedMessage());
//            }
//        }
    }

    private void log(String methodName) {
        System.out.println(methodName);
    }

}
