//import java.util.*;

class code {
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
        //Lucky Colour
        if (expectedLuckyColour.equals(actualLuckyColour)) {
            System.out.println("Test Case 2(Lucky Colour) passed");
        } else {
            System.out.println("Test Case 2(Lucky Colour) failed");
        }
        //Master Number
        if (expectedMasterNumber == actualMasterNumber) {
            System.out.println("Test Case 3(Check if Master) passed");
        } else {
            System.out.println("Test Case 3(Check if Master) failed");
        }
      

    }

}

class LifePathCalculator {
    public boolean CheckTwoBirthdays(int date1, int mon1, int year1, int date2, int mon2, int year2) {
        
        int LPN1 = LifePathNumber(date1, mon1, year1);
        int LPN2 = LifePathNumber(date2, mon2, year2);
        if (LPN1 == LPN2) {
            return true;
        } else {
            return false;
        }
    }

    public String FindGeneration(int year) {
        String gen = " ";
        if (year >= 1901 && year <= 1945) {
            gen = "Silent";
        } else if (year >= 1946 && year <= 1964) {
            gen = "Baby Boomers";
        } else if (year >= 1965 && year <= 1979) {
            gen = "Generation X";
        } else if (year >= 1980 && year <= 1994) {
            gen = "Millenials";
        } else if (year >= 1994 && year <= 2009) {
            gen = "Generation Z";
        } else if (year >= 2010 && year <= 2024) {
            gen = "Generation Alpha";
        }
        return gen;
    }

    public boolean MasterNumber(int lpn) {
        if (lpn == 11 || lpn == 22 || lpn == 33)
            return true;
        else
            return false;
    }

    public String LuckyColour(int lpn) {
        String colour = "";
        if (lpn == 1) {
            colour = "Red";
        } else if (lpn == 2) {
            colour = "Orange";
        } else if (lpn == 3) {
            colour = "Yellow";
        } else if (lpn == 4) {
            colour = "Green";
        } else if (lpn == 5) {
            colour = "Sky Blue";
        } else if (lpn == 6) {
            colour = "Indigo";
        } else if (lpn == 7) {
            colour = "Violet";
        } else if (lpn == 8) {
            colour = "Magenta";
        } else if (lpn == 9) {
            colour = "Gold";
        } else if (lpn == 11) {
            colour = "Silver";
        } else if (lpn == 22) {
            colour = "White";
        } else if (lpn == 33) {
            colour = "Crimson";
        }
        return colour;

    }

    public int LifePathNumber(int date, int month, int year) {
        if(year<1901 || year>2024){
            return -1;
        }
        int date_lpn = sumLPN(date);

        int month_lpn = sumLPN(month);

        int year_lpn = sumLPN(year);

        int final_lpn = sumLPN(date_lpn + month_lpn + year_lpn);
        return (final_lpn);
    }

    public int sumLPN(int num) {
        int lpn = 0;
        int temp = num;

        do {
            lpn = 0;
            if (temp == 11 || temp == 22 || temp == 33) {
                lpn = temp;
                break;
            }
            while (temp > 0) {
                lpn += temp % 10;
                temp /= 10;
            }
            temp = lpn;

        } while (temp / 10 > 0);
        return lpn;
    }

    public int Month(String mon) {
        if (mon.equalsIgnoreCase("January")) {
            return 1;
        } else if (mon.equalsIgnoreCase("February")) {
            return 2;
        } else if (mon.equalsIgnoreCase("March")) {
            return 3;
        } else if (mon.equalsIgnoreCase("April")) {
            return 4;
        } else if (mon.equalsIgnoreCase("May")) {
            return 5;
        } else if (mon.equalsIgnoreCase("June")) {
            return 6;
        } else if (mon.equalsIgnoreCase("July")) {
            return 7;
        } else if (mon.equalsIgnoreCase("August")) {
            return 8;
        } else if (mon.equalsIgnoreCase("September")) {
            return 9;
        } else if (mon.equalsIgnoreCase("October")) {
            return 10;
        } else if (mon.equalsIgnoreCase("November")) {
            return 11;
        } else if (mon.equalsIgnoreCase("December")) {
            return 12;
        }
        return -1;
    }

}