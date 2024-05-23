import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TestCases {
    public static void main(String args[]) {
        LifePathCalculator calculator = new LifePathCalculator();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println(
                        "\nPress 1 for viewing test cases\nPress 2 for taking input and output on terminal\nPress 3 for importing data from file (-1 to quit program):");

                int choice = scanner.nextInt();
                if (choice == 1) {
                    // Black Box Testing
                    // Equivalence Partioning Test Case
                    EquivalencePartitioning_LifePathNumber(calculator);
                    EquivalencePartitioning_MasterNumber(calculator);
                    EquivalencePartitioning_LuckyColour(calculator);
                    EquivalencePartitioning_Generation(calculator);
                    EquivalencePartitioning_CheckTwoBirthdays(calculator);

                    // Boundary Value Test Case
                    BoundaryValue_LifePathNumber(calculator);
                    BoundaryValue_LuckyColour(calculator);
                    BoundaryValue_Generation(calculator);

                    // White Box Testing
                    WhiteBoxForCheckTwoBirthdays(calculator);
                    WhiteBoxForLifePathNumber(calculator);
                } else if (choice == 2) {
                    System.out.print("Enter date: ");
                    int date = scanner.nextInt();
                    System.out.print("Enter month number : ");
                    int mon = scanner.nextInt();
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    System.out.print("\nLife path number: " + calculator.LifePathNumber(date, mon, year));
                    System.out.print(
                            "\nMaster number: " + calculator.MasterNumber(calculator.LifePathNumber(date, mon, year)));
                    System.out.print(
                            "\nLucky colour: " + calculator.LuckyColour(calculator.LifePathNumber(date, mon, year)));
                    System.out.print("\nGeneration: " + calculator.FindGeneration(date, mon, year));

                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt", true))) {
                        writer.write("Date: " + date + ", Month: " + mon + ", Year: " + year + "\n");
                        writer.write("Life path number: " + calculator.LifePathNumber(date, mon, year) + "\n");
                        writer.write("Master number: "
                                + calculator.MasterNumber(calculator.LifePathNumber(date, mon, year)) + "\n");
                        writer.write("Lucky colour: "
                                + calculator.LuckyColour(calculator.LifePathNumber(date, mon, year)) + "\n");
                        writer.write("Generation: " + calculator.FindGeneration(date, mon, year) + "\n\n");
                        System.out.println("\nStored in output.txt\n");
                    } catch (IOException e) {
                        System.out.println("Error writing to file: " + e.getMessage());
                    }
                }
                else if (choice==3){
                    try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            String[] parts = line.split("-");
                            if (parts.length == 3) {
                                int day = Integer.parseInt(parts[0]);
                                int month = Integer.parseInt(parts[1]);
                                int year = Integer.parseInt(parts[2]);
                                int lifePathNumber = calculator.LifePathNumber(day, month, year);
                                System.out.println("Date: " + day + "-" + month + "-" + year + ", Life Path Number: " + lifePathNumber);
                            } else {
                                System.out.println("Invalid data format: " + line);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                 else if (choice == -1) {
                    System.exit(0);
                } else {
                    System.out.println("\nInvalid Input\n");
                }
            }
        }

    }

    private static void EquivalencePartitioning_LifePathNumber(LifePathCalculator calculator) {

        System.out.println("\nEquivalence Partitioning Test Cases for LifePathNumber");

        // Valid date
        int expectedLifePathNumber;
        int actualLifePathNumber = calculator.LifePathNumber(15, "June", 1990);
        expectedLifePathNumber = 4;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (15-June-1990) passed");
        } else {
            System.out.println("Test Case (15-June-1990) failed: expected " + expectedLifePathNumber + " but got "
                    + actualLifePathNumber);
        }

        // Invalid date
        actualLifePathNumber = calculator.LifePathNumber(0, "June", 1990);
        expectedLifePathNumber = -1;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (00-June-1990) passed");
        } else {
            System.out.println("Test Case (00-June-1990) failed: expected " + expectedLifePathNumber + " but got "
                    + actualLifePathNumber);
        }

        // Invalid date
        actualLifePathNumber = calculator.LifePathNumber(33, "June", 1990);
        expectedLifePathNumber = -1;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (33-June-1990) passed");
        } else {
            System.out.println("Test Case (33-June-1990) failed: expected " + expectedLifePathNumber + " but got "
                    + actualLifePathNumber);
        }

        // Valid month
        actualLifePathNumber = calculator.LifePathNumber(15, "June", 1990);
        expectedLifePathNumber = 4;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (15-June-1990) passed");
        } else {
            System.out.println("Test Case (15-June-1990) failed: expected " + expectedLifePathNumber + " but got "
                    + actualLifePathNumber);
        }

        // Valid year
        actualLifePathNumber = calculator.LifePathNumber(15, "June", 1990);
        expectedLifePathNumber = 4;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (15-June-1990) passed");
        } else {
            System.out.println("Test Case (15-June-1990) failed: expected " + expectedLifePathNumber + " but got "
                    + actualLifePathNumber);
        }

        // Invalid year
        actualLifePathNumber = calculator.LifePathNumber(15, "June", 1800);
        expectedLifePathNumber = -1;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (15-June-1800) passed");
        } else {
            System.out.println("Test Case (15-June-1800) failed: expected " + expectedLifePathNumber + " but got "
                    + actualLifePathNumber);
        }

        // Invalid year
        actualLifePathNumber = calculator.LifePathNumber(15, "June", 2080);
        expectedLifePathNumber = -1;
        assert expectedLifePathNumber == actualLifePathNumber;
        if (expectedLifePathNumber == actualLifePathNumber) {
            System.out.println("Test Case (15-June-2080) passed");
        } else {
            System.out.println("Test Case (15-June-2080) failed: expected " + expectedLifePathNumber + " but got "
                    + actualLifePathNumber);
        }
    }

    private static void EquivalencePartitioning_MasterNumber(LifePathCalculator calculator) {

        System.out.println("\nEquivalence Partitioning for Master Number");
        if (calculator.MasterNumber(11)) {
            System.out.println("Test case EP1 passed.");
        } else {
            System.out.println("Test case EP1 failed.");
        }

        if (!calculator.MasterNumber(1)) {
            System.out.println("Test case EP2 passed.");
        } else {
            System.out.println("Test case EP2 failed.");
        }

        if (!calculator.MasterNumber(0)) {
            System.out.println("Test case EP3 passed.");
        } else {
            System.out.println("Test case EP3 failed.");
        }

        if (!calculator.MasterNumber(34)) {
            System.out.println("Test case EP4 passed.");
        } else {
            System.out.println("Test case EP4 failed.");
        }

    }

    private static void EquivalencePartitioning_LuckyColour(LifePathCalculator calculator) {
        System.out.println("\nEquivalence Partitioning for Lucky Colour");

        if ("Red".equals(calculator.LuckyColour(1))) {
            System.out.println("Test case EP5 passed.");
        } else {
            System.out.println("Test case EP5 failed.");
        }

        if ("Sky Blue".equals(calculator.LuckyColour(5))) {
            System.out.println("Test case EP6 passed.");
        } else {
            System.out.println("Test case EP6 failed.");
        }

        if ("Gold".equals(calculator.LuckyColour(9))) {
            System.out.println("Test case EP7 passed.");
        } else {
            System.out.println("Test case EP7 failed.");
        }

        if ("Silver".equals(calculator.LuckyColour(11))) {
            System.out.println("Test case EP8 passed.");
        } else {
            System.out.println("Test case EP8 failed.");
        }

        if ("White".equals(calculator.LuckyColour(22))) {
            System.out.println("Test case EP9 passed.");
        } else {
            System.out.println("Test case EP9 failed.");
        }

        if ("Crimson".equals(calculator.LuckyColour(33))) {
            System.out.println("Test case EP10 passed.");
        } else {
            System.out.println("Test case EP10 failed.");
        }

        if ("".equals(calculator.LuckyColour(0))) {
            System.out.println("Test case EP11 passed.");
        } else {
            System.out.println("Test case EP11 failed.");
        }

        if ("".equals(calculator.LuckyColour(34))) {
            System.out.println("Test case EP12 passed.");
        } else {
            System.out.println("Test case EP12 failed.");
        }
    }

    private static void EquivalencePartitioning_Generation(LifePathCalculator calculator) {
        System.out.println("\nEquivalence Partitioning For Generation");

        if ("Silent".equals(calculator.FindGeneration("15-01-1945"))) {
            System.out.println("Test case EP13 passed.");
        } else {
            System.out.println("Test case EP13 failed.");
        }

        if ("Baby Boomers".equals(calculator.FindGeneration("15-01-1955"))) {
            System.out.println("Test case EP14 passed.");
        } else {
            System.out.println("Test case EP14 failed.");
        }

        if ("Generation X".equals(calculator.FindGeneration("15-01-1970"))) {
            System.out.println("Test case EP15 passed.");
        } else {
            System.out.println("Test case EP15 failed.");
        }

        if ("Millenials".equals(calculator.FindGeneration("15-01-1990"))) {
            System.out.println("Test case EP16 passed.");
        } else {
            System.out.println("Test case EP16 failed.");
        }

        if ("Generation Z".equals(calculator.FindGeneration("15-01-2005"))) {
            System.out.println("Test case EP17 passed.");
        } else {
            System.out.println("Test case EP17 failed.");
        }

        if ("Generation Alpha".equals(calculator.FindGeneration("15-01-2015"))) {
            System.out.println("Test case EP18 passed.");
        } else {
            System.out.println("Test case EP18 failed.");
        }

        if ("".equals(calculator.FindGeneration("15-01-1800"))) {
            System.out.println("Test case EP19 passed.");
        } else {
            System.out.println("Test case EP19 failed.");
        }

        if ("".equals(calculator.FindGeneration("15-01-2030"))) {
            System.out.println("Test case EP20 passed.");
        } else {
            System.out.println("Test case EP20 failed.");
        }
    }

    private static void EquivalencePartitioning_CheckTwoBirthdays(LifePathCalculator calculator) {
        System.out.println("\nEquivalence Partitioning For Check Two Birthdays:");

        if (1 == calculator.CheckTwoBirthdays("15-01-2000", "15-01-2000")) {
            System.out.println("Test case EP21 passed.");
        } else {
            System.out.println("Test case EP21 failed.");
        }

        if (0 == calculator.CheckTwoBirthdays("15-01-2000", "20-02-1995")) {
            System.out.println("Test case EP22 passed.");
        } else {
            System.out.println("Test case EP22 failed.");
        }

        if (-1 == calculator.CheckTwoBirthdays("15-01-1800", "20-02-1995")) {
            System.out.println("Test case EP23 passed.");
        } else {
            System.out.println("Test case EP23 failed.");
        }

        if (-1 == calculator.CheckTwoBirthdays("15-01-2000", "20-02-2100")) {
            System.out.println("Test case EP24 passed.");
        } else {
            System.out.println("Test case EP24 failed.");
        }
    }

    private static void BoundaryValue_LifePathNumber(LifePathCalculator calculator) {

        System.out.println("\nBoundary Value For LifePathNumber:");
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

    private static void BoundaryValue_LuckyColour(LifePathCalculator calculator) {
        System.out.println("\nBoundary Value for Lucky Colour");
        // LPN = 1 (Minimum valid LPN)
        if ("Red".equals(calculator.LuckyColour(1))) {
            System.out.println("Test case BV1 passed.");
        } else {
            System.out.println("Test case BV1 failed.");
        }

        if ("Sky Blue".equals(calculator.LuckyColour(5))) {
            System.out.println("Test case BV2 passed.");
        } else {
            System.out.println("Test case BV2 failed.");
        }

        if ("Gold".equals(calculator.LuckyColour(9))) {
            System.out.println("Test case BV3 passed.");
        } else {
            System.out.println("Test case BV3 failed.");
        }

        if ("Silver".equals(calculator.LuckyColour(11))) {
            System.out.println("Test case BV4 passed.");
        } else {
            System.out.println("Test case BV4 failed.");
        }

        if ("White".equals(calculator.LuckyColour(22))) {
            System.out.println("Test case BV5 passed.");
        } else {
            System.out.println("Test case BV5 failed.");
        }

        // LPN = 33 (Maximum valid LPN)
        if ("Crimson".equals(calculator.LuckyColour(33))) {
            System.out.println("Test case BV6 passed.");
        } else {
            System.out.println("Test case BV6 failed.");
        }

        // LPN = 0 (Invalid LPN)
        if ("".equals(calculator.LuckyColour(0))) {
            System.out.println("Test case BV7 passed.");
        } else {
            System.out.println("Test case BV7 failed.");
        }

        // LPN = 34 (Invalid LPN)
        if ("".equals(calculator.LuckyColour(34))) {
            System.out.println("Test case BV8 passed.");
        } else {
            System.out.println("Test case BV8 failed.");
        }
    }

    private static void BoundaryValue_Generation(LifePathCalculator calculator) {
        System.out.println("\nBoundary Value for Generation");
        // lowest valid year
        if ("Silent".equals(calculator.FindGeneration("15-01-1901"))) {
            System.out.println("Test case BV9 passed.");
        } else {
            System.out.println("Test case BV9 failed.");
        }
        // highest valid year
        if ("Generation Alpha".equals(calculator.FindGeneration("15-01-2024"))) {
            System.out.println("Test case BV10 passed.");
        } else {
            System.out.println("Test case BV10 failed.");
        }
        // invalid year below range
        if ("".equals(calculator.FindGeneration("15-01-1900"))) {
            System.out.println("Test case BV11 passed.");
        } else {
            System.out.println("Test case BV11 failed.");
        }
        // invalid year above range
        if ("".equals(calculator.FindGeneration("15-01-2025"))) {
            System.out.println("Test case BV12 passed.");
        } else {
            System.out.println("Test case BV12 failed.");
        }
    }

    private static void WhiteBoxForCheckTwoBirthdays(LifePathCalculator calculator) {
        System.out.println("\nWhiteBox for CheckTwoBirthdays");
        // Year1 is below the valid range

        if (calculator.CheckTwoBirthdays(1, 1, 1900, 1, 1, 2000) == -1) {
            System.out.println("Test case WB1 passed.");
        } else {
            System.out.println("Test case WB1 failed.");
        }

        // Year2 is above the valid range
        if (calculator.CheckTwoBirthdays(1, 1, 2000, 1, 1, 2025) == -1) {
            System.out.println("Test case WB2 passed.");
        } else {
            System.out.println("Test case WB2 failed.");
        }

        // Both dates result in the same life path number
        if (calculator.CheckTwoBirthdays(1, 2, 2000, 2, 1, 2000) == 1) {
            System.out.println("Test case WB3 passed.");
        } else {
            System.out.println("Test case WB3 failed.");
        }

        // Both dates result in different life path numbers
        if (calculator.CheckTwoBirthdays(1, 1, 2000, 3, 3, 2000) == 0) {
            System.out.println("Test case WB4 passed.");
        } else {
            System.out.println("Test case WB4 failed.");
        }
    }

    private static void WhiteBoxForLifePathNumber(LifePathCalculator calculator) {
        System.out.println("\nWhiteBox for LifePathNumber");
        // Year is below the valid range
        if (calculator.LifePathNumber(1, 1, 1900) == -1) {
            System.out.println("Test case WB5 passed.");
        } else {
            System.out.println("Test case WB5 failed.");
        }

        // Year is above the valid range
        if (calculator.LifePathNumber(1, 1, 2025) == -1) {
            System.out.println("Test case WB6 passed.");
        } else {
            System.out.println("Test case WB6 failed.");
        }

        // Date is below the valid range
        if (calculator.LifePathNumber(0, 1, 2000) == -1) {
            System.out.println("Test case WB7 passed.");
        } else {
            System.out.println("Test case WB7 failed.");
        }

        // Date is above the valid range
        if (calculator.LifePathNumber(32, 1, 2000) == -1) {
            System.out.println("Test case WB8 passed.");
        } else {
            System.out.println("Test case WB8 failed.");
        }

        // Month is below the valid range
        if (calculator.LifePathNumber(1, 0, 2000) == -1) {
            System.out.println("Test case WB9 passed.");
        } else {
            System.out.println("Test case WB9 failed.");
        }

        // Month is above the valid range
        if (calculator.LifePathNumber(1, 13, 2000) == -1) {
            System.out.println("Test case WB10 passed.");
        } else {
            System.out.println("Test case WB10 failed.");
        }

        // All inputs are within valid range
        int result = calculator.LifePathNumber(15, 6, 1990);
        if (result != -1) {
            System.out.println("Test case WB11 passed.");
        } else {
            System.out.println("Test case WB11 failed.");
        }
    }

}
