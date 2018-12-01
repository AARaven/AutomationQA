package MathUtilTests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


//@Listeners(CustomListener.class)
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

    @Test(groups = "integers", dataProvider = "DataForIntegersTests",
            dataProviderClass = Data.class)
    public void testMathMax(int x, int y) {
        int max = (x >= y) ? x : y;
        Assert.assertEquals(Math.max(x, y), max,
                "The result is not right!");
    }

    @Test(groups = "doubles", dataProvider = "DataForDoublesTests",
            dataProviderClass = Data.class)
    public void testMathMax(double x, double y) {
        double max = (x >= y) ? x : y;
        Assert.assertEquals(Math.max(x, y), max,
                "The result is not right!");
    }

    @Test(groups = "integers", dataProvider = "DataForIntegersTests",
            dataProviderClass = Data.class)
    public void testMathMin(int x, int y) {
        int min = (x <= y) ? x : y;
        Assert.assertEquals(Math.min(x, y), min,
                "The result is not right!");
    }

    @Test(groups = "doubles", dataProvider = "DataForDoublesTests",
            dataProviderClass = Data.class)
    public void testMathMin(Double x, Double y) {
        double min = (x <= y) ? x : y;
        Assert.assertEquals(Math.min(x, y), min,
                "The result is not right!");
    }

    @Test(groups = "integers")
    @Parameters("firstValue")
    public void testMathAbs(int firstValue) {

        int result = (firstValue < 0) ? -firstValue : firstValue;

        Assert.assertEquals(Math.abs(firstValue), result,
                "The result is not right!");
        Assert.assertNotEquals(Math.abs(firstValue), -result,
                "The result is not right!");
        Assert.assertTrue(Math.abs(firstValue) != firstValue,
                "The result is not right!");
        Assert.assertFalse(Math.abs(firstValue) < firstValue,
                "The result is not right!");
    }

    @Test(groups = "integers")
    @Parameters("secondValue")
    public void testMathAbs(double secondValue) {

        double result = (secondValue < 0.0) ? -secondValue : secondValue;

        Assert.assertEquals(Math.abs(secondValue), result,
                "The result is not right!");
        Assert.assertNotEquals(Math.abs(secondValue), -result,
                "The result is not right!");
        Assert.assertTrue(Math.abs(secondValue) != -secondValue,
                "The result is not right!");
        Assert.assertFalse(Math.abs(secondValue) < -secondValue,
                "The result is not right!");
    }

    @Test(groups = {"fail", "integers"}, dataProvider = "DataForIntegersTests",
            dataProviderClass = Data.class)
    public void testAssertFail(Integer x, Integer y) {
        Assert.assertTrue(Math.pow(x, y) > (x + y),
                "The result is not right!");
        Assert.fail();
    }

    @Test(groups = "doubles")
    @Parameters("secondValue")
    public void testMathSqrt(double secondValue) {

        double sqrt = StrictMath.sqrt(secondValue);

        Assert.assertEquals(Math.sqrt(secondValue), sqrt,
                "The result is not right!");
    }

    @Test(groups = {"doubles", "fail"})
    @Parameters("secondValue")
    public void testMathSqrtFail(double secondValue) {

        double sqrt = StrictMath.sqrt(secondValue);

        Assert.assertEquals(Math.sqrt(secondValue), sqrt,
                "The result is not right!");

        softAssert.assertTrue(Math.sqrt(secondValue) < (secondValue));
    }

    @Test(groups = {"integers", "context"})
    public void testContextSetUp(ITestContext context) {
        context.setAttribute("newValue", "25");
    }

    @Test(groups = {"integers", "context"})
    @Parameters("firstValue")
    public void testContextSetUp(ITestContext context, int firstValue) {
        String attribute = context.getAttribute("newValue").toString();
        int sum = Integer.parseInt(attribute) + firstValue;
        Assert.assertEquals(sum, firstValue + 25);
    }
}
