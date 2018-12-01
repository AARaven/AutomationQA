package MathUtilTests;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener {
    public void onTestStart(ITestResult result) {
        System.out.println("\n" + "OnTestStart# Checking...");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("\n" + " ________________________________________");
        System.out.println("|***** The test SUCCESSFULLY PASSED.*****|");
        System.out.println("|                                        |");
        System.out.println("|____________________QA_Team_____________|" + "\n");

    }

    public void onTestFailure(ITestResult result) {
        System.out.println("\n" + " _______________________________________");
        System.out.println("|    !!!!!The test is DOWN.!!!!!        |");
        System.out.println("|                                       |");
        System.out.println("|____________________QA_Team____________|" + "\n");
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("\n" + " _______________________________________");
        System.out.println("|                                       |");
        System.out.println("|      ~~~~~The test is SKIPPED.~~~~~   |");
        System.out.println("|____________________QA_Team____________|" + "\n");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {
        System.out.println("OnStart# Suite is started." + "\n");
    }

    public void onFinish(ITestContext context) {
        System.out.println("\n" + "OnFinish# Checking complete." + "\n");
    }
}
