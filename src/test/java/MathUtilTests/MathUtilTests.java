package MathUtilTests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

@Listeners(CustomListener.class)
public class MathUtilTests {

    private SoftAssert softAssert = new SoftAssert();


    @BeforeSuite
    public void startSuite() {
        System.out.println("Before suite.");
    }

    @AfterSuite
    public void endSuite() {
        System.out.println("After suite.");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class.");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After class.");
    }

    @BeforeGroups
    public void beforeGroup() {
        System.out.println("Before group.");
    }

    @AfterGroups
    public void afterGroup() {
        System.out.println("After group.");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before test.");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After test.");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Before method. ");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("After method." + "\n");
    }

    @Test(groups = "tester", dataProvider = "DataForIntegersTests",
            dataProviderClass = Data.class)
    public void testMathMax(int x, int y) {
        int max = (x >= y) ? x : y;
        Assert.assertEquals(Math.max(x, y), max,
                "The result is not right!");
    }

    @Test(groups = "tester", dataProvider = "DataForDoublesTests",
            dataProviderClass = Data.class)
    public void testMathMax(double x, double y) {
        double max = (x >= y) ? x : y;
        Assert.assertEquals(Math.max(x, y), max,
                "The result is not right!");
    }

    @Test(groups = "tester", dataProvider = "DataForIntegersTests",
            dataProviderClass = Data.class)
    public void testMathMin(int x, int y) {
        int min = (x <= y) ? x : y;
        Assert.assertEquals(Math.min(x, y), min,
                "The result is not right!");
    }

    @Test(groups = "tester", dataProvider = "DataForDoublesTests",
            dataProviderClass = Data.class)
    public void testMathMin(Double x, Double y) {
        double min = (x <= y) ? x : y;
        Assert.assertEquals(Math.min(x, y), min,
                "The result is not right!");
    }

    @Test(groups = "tester")
    @Parameters("valueForIntegerTests")
    public void testMathAbs(int valueForIntegerTests) {

        int result = (valueForIntegerTests < 0) ? -valueForIntegerTests : valueForIntegerTests;

        Assert.assertEquals(Math.abs(valueForIntegerTests), result,
                "The result is not right!");
        Assert.assertNotEquals(Math.abs(valueForIntegerTests), -result,
                "The result is not right!");
        Assert.assertTrue(Math.abs(valueForIntegerTests) != valueForIntegerTests,
                "The result is not right!");
        Assert.assertFalse(Math.abs(valueForIntegerTests) < valueForIntegerTests,
                "The result is not right!");
    }

    @Test(groups = "tester")
    @Parameters("valueForDoublesTests")
    public void testMathAbs(double valueForDoublesTests) {

        double result = (valueForDoublesTests < 0.0) ? -valueForDoublesTests : valueForDoublesTests;

        Assert.assertEquals(Math.abs(valueForDoublesTests), result,
                "The result is not right!");
        Assert.assertNotEquals(Math.abs(valueForDoublesTests), -result,
                "The result is not right!");
        Assert.assertTrue(Math.abs(valueForDoublesTests) != -valueForDoublesTests,
                "The result is not right!");
        Assert.assertFalse(Math.abs(valueForDoublesTests) < -valueForDoublesTests,
                "The result is not right!");
    }

    @Test(groups = "fail", dataProvider = "DataForIntegersTests",
            dataProviderClass = Data.class)
    public void testAssertFail(Integer x, Integer y) {
        if (x ==0) Assert.fail();
        Assert.assertTrue(Math.pow(x, y) > (x + y),
                "The result is not right!");
    }

    @Test(groups = "dependent", dependsOnGroups = {"fail"})
    @Parameters("valueForDoublesTests")
    public void testMathSqrt(double valueForDoublesTests) {

        double sqrt = StrictMath.sqrt(valueForDoublesTests);

        Assert.assertEquals(Math.sqrt(valueForDoublesTests), sqrt,
                "The result is not right!");
    }

    @Test(groups = "fail")
    @Parameters("valueForFailTest")
    public void testMathSqrtFail(double valueForFailTest) {

        double sqrt = StrictMath.sqrt(valueForFailTest);

        Assert.assertEquals(Math.sqrt(valueForFailTest), sqrt,
                "The result is not right!");

        softAssert.assertTrue(Math.sqrt(valueForFailTest) < valueForFailTest);
    }

    @Test(groups = "context")
    public void testContextSetUp(ITestContext context) {
        context.setAttribute("newValue", "25");
    }

    @Test(groups = "context")
    @Parameters("valueTestingContext")
    public void testContextSetUp(ITestContext context, int valueTestingContext) {
        String attribute = context.getAttribute("newValue").toString();
        int sum = Integer.parseInt(attribute) + valueTestingContext;
        Assert.assertEquals(sum, valueTestingContext + 25);
    }
}
