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
        //*** */
        actualLifePathNumber = calculator.LifePathNumber("00-06-1990");
        expectedLifePathNumber = -1;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (00-06-1990) passed");
        } else {
            System.out.println("Test Case (00-06-1990) failed: expected " + expectedLifePathNumber + " but got "+ actualLifePathNumber);
        }

        // Invalid date
        actualLifePathNumber = calculator.LifePathNumber("33-06-1990");
        expectedLifePathNumber = -1;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (33-06-1990) passed");
        } else {
            System.out.println("Test Case (33-06-1990) failed: expected " + expectedLifePathNumber + " but got "+ actualLifePathNumber);
        }

        // Valid month
        actualLifePathNumber = calculator.LifePathNumber("15-06-1990");
        expectedLifePathNumber = 4;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (15-06-1990) passed");
        } else {
            System.out.println("Test Case (15-06-1990) failed: expected " + expectedLifePathNumber + " but got "+ actualLifePathNumber);
        }

        // Invalid month
        //** */
        actualLifePathNumber = calculator.LifePathNumber("15-00-1990");
        expectedLifePathNumber = -1;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (15-00-1990) passed");
        } else {
            System.out.println("Test Case (15-00-1990) failed: expected " + expectedLifePathNumber + " but got "+ actualLifePathNumber);
        }

        // Invalid month
        actualLifePathNumber = calculator.LifePathNumber("15-15-1990");
        expectedLifePathNumber = -1;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (15-15-1990) passed");
        } else {
            System.out.println("Test Case (15-15-1990) failed: expected " + expectedLifePathNumber + " but got "+ actualLifePathNumber);
        }

        // Valid year
        actualLifePathNumber = calculator.LifePathNumber("15-06-1990");
        expectedLifePathNumber = 4;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (15-06-1990) passed");
        } else {
            System.out.println("Test Case (15-06-1990) failed: expected " + expectedLifePathNumber + " but got "+ actualLifePathNumber);
        }

        // Invalid year
        actualLifePathNumber = calculator.LifePathNumber("15-06-1800");
        expectedLifePathNumber = -1;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (15-06-1800) passed");
        } else {
            System.out.println("Test Case (15-06-1800) failed: expected " + expectedLifePathNumber + " but got "+ actualLifePathNumber);
        }

        // Invalid year 
        actualLifePathNumber = calculator.LifePathNumber("15-06-2080");
        expectedLifePathNumber = -1;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (15-06-2080) passed");
        } else {
            System.out.println("Test Case (15-06-2080) failed: expected " + expectedLifePathNumber + " but got "+ actualLifePathNumber);
        }
    }
}
