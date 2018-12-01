package MathUtilTests;

import org.testng.annotations.DataProvider;

public class Data {

    @DataProvider(name = "DataForIntegersTests")
    public static Object[][] integerDataProvider() {
        return new Object[][]
                {{39, 41}, {51, 29}, {23, 16},
                        {38, 12}, {24, 82}};
    }

    @DataProvider(name = "DataForDoublesTests")
    public static Object[][] doubleDataProvider() {
        return new Object[][]
                {{1.52, 1.12}, {13.45, 22.10}, {24.08, 39.01},
                        {2.7, 22.31}, {14.89, 27.62}};
    }
}
