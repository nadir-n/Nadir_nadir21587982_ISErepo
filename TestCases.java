import java.net.CacheRequest;

public class TestCases {
    public static void main(String args[]) {
        LifePathCalculator calculator = new LifePathCalculator();

        // Test case 1
        int expectedLifePathNumber = 22;
        String expectedLuckyColour = "White";
        boolean expectedMasterNumber = true;
        int date = 13;
        int month = 11;
        int year = 1987;
        int actualLifePathNumber1 = calculator.LifePathNumber(date, month, year);
        assert expectedLifePathNumber == actualLifePathNumber1;
        String actualLuckyColour = calculator.LuckyColour(expectedLifePathNumber);
        boolean actualMasterNumber = calculator.MasterNumber(expectedLifePathNumber);

        if (expectedLifePathNumber == actualLifePathNumber1) {
            System.out.println("Test Case 1(Lucky Number) passed");
        } else {
            System.out.println("Test Case 1(Lucky Number) failed");
        }
        // Lucky Colour
        if (expectedLuckyColour.equals(actualLuckyColour)) {
            System.out.println("Test Case 2(Lucky Colour) passed");
        } else {
            System.out.println("Test Case 2(Lucky Colour) failed");
        }
        // Master Number
        if (expectedMasterNumber == actualMasterNumber) {
            System.out.println("Test Case 3(Check if Master) passed");
        } else {
            System.out.println("Test Case 3(Check if Master) failed");
        }

        ///////////////////// Equivalence Partioning Test Case/////////////////////
        EquivalencePartioningTestCases(calculator);

        ////////////////// Boundary Value Test Case ///////////////////////
        BoundaryValueTestCases(calculator);

        ///////////////////////////// White Box Testing//////////////////////
        WhiteBoxForCheckTwoBirthdays(calculator);
        WhiteBoxForLifePathNumber(calculator);

    }

    private static void BoundaryValueTestCases(LifePathCalculator calculator) {
        // Boundary Value Test Cases
        int expectedLifePathNumber;

        // Date boundary tests
        int actualLifePathNumber = calculator.LifePathNumber("01-01-1901");
        expectedLifePathNumber = 4;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (01-01-1901) passed");
        } else {
            System.out.println("Test Case (01-01-1901) failed: expected " + expectedLifePathNumber + " but got "
                    + actualLifePathNumber);
        }

        actualLifePathNumber = calculator.LifePathNumber("00-01-1901");
        expectedLifePathNumber = -1;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (00-01-1901) passed");
        } else {
            System.out.println("Test Case (00-01-1901) failed: expected " + expectedLifePathNumber + " but got "
                    + actualLifePathNumber);
        }

        actualLifePathNumber = calculator.LifePathNumber("31-12-2024");
        expectedLifePathNumber = 6;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (31-12-2024) passed");
        } else {
            System.out.println("Test Case (31-12-2024) failed: expected " + expectedLifePathNumber + " but got "
                    + actualLifePathNumber);
        }

        actualLifePathNumber = calculator.LifePathNumber("32-12-2024");
        expectedLifePathNumber = -1;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (32-12-2024) passed");
        } else {
            System.out.println("Test Case (32-12-2024) failed: expected " + expectedLifePathNumber + " but got "
                    + actualLifePathNumber);
        }

        // Month boundary tests
        actualLifePathNumber = calculator.LifePathNumber("15-01-2000");
        expectedLifePathNumber = 9;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (15-01-2000) passed");
        } else {
            System.out.println("Test Case (15-01-2000) failed: expected " + expectedLifePathNumber + " but got "
                    + actualLifePathNumber);
        }

        actualLifePathNumber = calculator.LifePathNumber("15-00-2000");
        expectedLifePathNumber = -1;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (15-00-2000) passed");
        } else {
            System.out.println("Test Case (15-00-2000) failed: expected " + expectedLifePathNumber + " but got "
                    + actualLifePathNumber);
        }

        actualLifePathNumber = calculator.LifePathNumber("15-12-2000");
        expectedLifePathNumber = 11;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (15-12-2000) passed");
        } else {
            System.out.println("Test Case (15-12-2000) failed: expected " + expectedLifePathNumber + " but got "
                    + actualLifePathNumber);
        }

        actualLifePathNumber = calculator.LifePathNumber("15-13-2000");
        expectedLifePathNumber = -1;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (15-13-2000) passed");
        } else {
            System.out.println("Test Case (15-13-2000) failed: expected " + expectedLifePathNumber + " but got "
                    + actualLifePathNumber);
        }

        // Year boundary tests
        actualLifePathNumber = calculator.LifePathNumber("15-06-1901");
        expectedLifePathNumber = 5;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (15-06-1901) passed");
        } else {
            System.out.println("Test Case (15-06-1901) failed: expected " + expectedLifePathNumber + " but got "
                    + actualLifePathNumber);
        }

        actualLifePathNumber = calculator.LifePathNumber("15-06-1900");
        expectedLifePathNumber = -1;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (15-06-1900) passed");
        } else {
            System.out.println("Test Case (15-06-1900) failed: expected " + expectedLifePathNumber + " but got "
                    + actualLifePathNumber);
        }

        actualLifePathNumber = calculator.LifePathNumber("15-06-2024");
        expectedLifePathNumber = 2;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (15-06-2024) passed");
        } else {
            System.out.println("Test Case (15-06-2024) failed: expected " + expectedLifePathNumber + " but got "
                    + actualLifePathNumber);
        }

        actualLifePathNumber = calculator.LifePathNumber("15-06-2025");
        expectedLifePathNumber = -1;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (15-06-2025) passed");
        } else {
            System.out.println("Test Case (15-06-2025) failed: expected " + expectedLifePathNumber + " but got "
                    + actualLifePathNumber);
        }
    }

    private static void EquivalencePartioningTestCases(LifePathCalculator calculator) {
        // Equivalence Partioning Test Cases
        // Valid date
        int expectedLifePathNumber;
        int actualLifePathNumber = calculator.LifePathNumber("15-06-1990");
        expectedLifePathNumber = 4;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (15-06-1990) passed");
        } else {
            System.out.println("Test Case (15-06-1990) failed: expected " + expectedLifePathNumber + " but got "
                    + actualLifePathNumber);
        }

        // Invalid date
        // *** */
        actualLifePathNumber = calculator.LifePathNumber("00-06-1990");
        expectedLifePathNumber = -1;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (00-06-1990) passed");
        } else {
            System.out.println("Test Case (00-06-1990) failed: expected " + expectedLifePathNumber + " but got "
                    + actualLifePathNumber);
        }

        // Invalid date
        actualLifePathNumber = calculator.LifePathNumber("33-06-1990");
        expectedLifePathNumber = -1;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (33-06-1990) passed");
        } else {
            System.out.println("Test Case (33-06-1990) failed: expected " + expectedLifePathNumber + " but got "
                    + actualLifePathNumber);
        }

        // Valid month
        actualLifePathNumber = calculator.LifePathNumber("15-06-1990");
        expectedLifePathNumber = 4;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (15-06-1990) passed");
        } else {
            System.out.println("Test Case (15-06-1990) failed: expected " + expectedLifePathNumber + " but got "
                    + actualLifePathNumber);
        }

        // Invalid month
        // ** */
        actualLifePathNumber = calculator.LifePathNumber("15-00-1990");
        expectedLifePathNumber = -1;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (15-00-1990) passed");
        } else {
            System.out.println("Test Case (15-00-1990) failed: expected " + expectedLifePathNumber + " but got "
                    + actualLifePathNumber);
        }

        // Invalid month
        actualLifePathNumber = calculator.LifePathNumber("15-15-1990");
        expectedLifePathNumber = -1;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (15-15-1990) passed");
        } else {
            System.out.println("Test Case (15-15-1990) failed: expected " + expectedLifePathNumber + " but got "
                    + actualLifePathNumber);
        }

        // Valid year
        actualLifePathNumber = calculator.LifePathNumber("15-06-1990");
        expectedLifePathNumber = 4;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (15-06-1990) passed");
        } else {
            System.out.println("Test Case (15-06-1990) failed: expected " + expectedLifePathNumber + " but got "
                    + actualLifePathNumber);
        }

        // Invalid year
        actualLifePathNumber = calculator.LifePathNumber("15-06-1800");
        expectedLifePathNumber = -1;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (15-06-1800) passed");
        } else {
            System.out.println("Test Case (15-06-1800) failed: expected " + expectedLifePathNumber + " but got "
                    + actualLifePathNumber);
        }

        // Invalid year
        actualLifePathNumber = calculator.LifePathNumber("15-06-2080");
        expectedLifePathNumber = -1;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (15-06-2080) passed");
        } else {
            System.out.println("Test Case (15-06-2080) failed: expected " + expectedLifePathNumber + " but got "
                    + actualLifePathNumber);
        }
    }

    private static void WhiteBoxForCheckTwoBirthdays(LifePathCalculator calculator) {
        // Test case 1: Year1 is below the valid range
        if (calculator.CheckTwoBirthdays(1, 1, 1900, 1, 1, 2000) == -1) {
            System.out.println("Test case WB1 passed.");
        } else {
            System.out.println("Test case WB1 failed.");
        }

        // Test case 2: Year2 is above the valid range
        if (calculator.CheckTwoBirthdays(1, 1, 2000, 1, 1, 2025) == -1) {
            System.out.println("Test case WB2 passed.");
        } else {
            System.out.println("Test case WB2 failed.");
        }

        // Test case 3: Both dates result in the same life path number
        if (calculator.CheckTwoBirthdays(1, 2, 2000, 2, 1, 2000) == 1) {
            System.out.println("Test case WB3 passed.");
        } else {
            System.out.println("Test case WB3 failed.");
        }

        // Test case 4: Both dates result in different life path numbers
        if (calculator.CheckTwoBirthdays(1, 1, 2000, 3, 3, 2000) == 0) {
            System.out.println("Test case WB4 passed.");
        } else {
            System.out.println("Test case WB4 failed.");
        }
    }

    private static void WhiteBoxForLifePathNumber(LifePathCalculator calculator) {
        // Test case 1: Year is below the valid range
        if (calculator.LifePathNumber(1, 1, 1900) == -1) {
            System.out.println("Test case WB5 passed.");
        } else {
            System.out.println("Test case WB5 failed.");
        }

        // Test case 2: Year is above the valid range
        if (calculator.LifePathNumber(1, 1, 2025) == -1) {
            System.out.println("Test case WB6 passed.");
        } else {
            System.out.println("Test case WB6 failed.");
        }

        // Test case 3: Date is below the valid range
        if (calculator.LifePathNumber(0, 1, 2000) == -1) {
            System.out.println("Test case WB7 passed.");
        } else {
            System.out.println("Test case WB7 failed.");
        }

        // Test case 4: Date is above the valid range
        if (calculator.LifePathNumber(32, 1, 2000) == -1) {
            System.out.println("Test case WB8 passed.");
        } else {
            System.out.println("Test case WB8 failed.");
        }

        // Test case 5: Month is below the valid range
        if (calculator.LifePathNumber(1, 0, 2000) == -1) {
            System.out.println("Test case WB9 passed.");
        } else {
            System.out.println("Test case WB9 failed.");
        }

        // Test case 6: Month is above the valid range
        if (calculator.LifePathNumber(1, 13, 2000) == -1) {
            System.out.println("Test case WB10 passed.");
        } else {
            System.out.println("Test case WB10 failed.");
        }

        // Test case 7: All inputs are within valid range
        int result = calculator.LifePathNumber(15, 6, 1990);
        if (result != -1) {
            System.out.println("Test case WB11 passed. Life Path Number: " + result);
        } else {
            System.out.println("Test case WB11 failed.");
        }
    }

}
