//import java.util.*;


public class LifePathCalculator {
    // ------------------------------Check two
    // Birthdays------------------------------//
    // all parameters int
    public int CheckTwoBirthdays(int date1, int mon1, int year1, int date2, int mon2, int year2) {
        if (year1 < 1901 || year1 > 2024) {
            return -1;
        }
        if (year2 < 1901 || year2 > 2024) {
            return -1;
        }

        int LPN1 = LifePathNumber(date1, mon1, year1);
        int LPN2 = LifePathNumber(date2, mon2, year2);
        if (LPN1 == LPN2) {
            return 1;
        } else {
            return 0;
        }
    }

    // Month is string and remaining parameters are int
    public int CheckTwoBirthdays(int date1, String mon1, int year1, int date2, String mon2, int year2) {

        if (year1 < 1901 || year1 > 2024) {
            return -1;
        }
        if (year2 < 1901 || year2 > 2024) {
            return -1;
        }
        int month1 = Month(mon1);
        int month2 = Month(mon2);

        int LPN1 = LifePathNumber(date1, month1, year1);
        int LPN2 = LifePathNumber(date2, month2, year2);
        if (LPN1 == LPN2) {
            return 1;
        } else {
            return 0;
        }
    }

    // string paramater in dd-mm-yyyy format
    public int CheckTwoBirthdays(String birthdate1, String birthdate2) {
        String[] parts = birthdate1.split("-");
        int date1 = Integer.parseInt(parts[0]);
        int month1 = Integer.parseInt(parts[1]);
        int year1 = Integer.parseInt(parts[2]);

        String[] parts1 = birthdate2.split("-");
        int date2 = Integer.parseInt(parts1[0]);
        int month2 = Integer.parseInt(parts1[1]);
        int year2 = Integer.parseInt(parts1[2]);
        if (year1 < 1901 || year1 > 2024) {
            return -1;
        }
        if (year2 < 1901 || year2 > 2024) {
            return -1;
        }

        int LPN1 = LifePathNumber(date1, month1, year1);
        int LPN2 = LifePathNumber(date2, month2, year2);
        if (LPN1 == LPN2) {
            return 1;
        } else {
            return 0;
        }
    }

    public String FindGeneration(String birthdate) {
        String[] parts = birthdate.split("-");
        int date = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);
        String gen = "";

        if (year < 1901 || year > 2024) {
            return gen;
        }
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

        if (lpn < 1 || lpn > 9) {
            if (lpn != 11 && lpn != 22 && lpn != 33) {
                return colour;
            }
        }

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

    // -----------------------------Life Path
    // Number---------------------------------//
    // integer parameters
    public int LifePathNumber(int date, int month, int year) {
        if (year < 1901 || year > 2024) {
            return -1;
        }
        if(date<1 || date>31){
            return -1;
        }
        if(month<1 || month>12){
            return -1;
        }
        int date_lpn = sumLPN(date);

        int month_lpn = sumLPN(month);

        int year_lpn = sumLPN(year);

        int final_lpn = sumLPN(date_lpn + month_lpn + year_lpn);
        return (final_lpn);
    }

    // string paramater in dd-mm-yyyy format
    public int LifePathNumber(String birthdate) {
        String[] parts = birthdate.split("-");
        int date = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        if (year < 1901 || year > 2024) {
            return -1;
        }
        if(date<1 || date>31){
            return -1;
        }
        if(month<1 || month>12){
            return -1;
        }
        int date_lpn = sumLPN(date);

        int month_lpn = sumLPN(month);

        int year_lpn = sumLPN(year);

        int final_lpn = sumLPN(date_lpn + month_lpn + year_lpn);
        return (final_lpn);
    }

    // integer parameters for date and year and string parameter for month
    public int LifePathNumber(int date, String month, int year) {

        if (year < 1901 || year > 2024) {
            return -1;
        }
        if(date<1 || date>31){
            return -1;
        }
        

        int mon = Month(month);
        if(mon<1 || mon>12){
            return -1;
        }

        int date_lpn = sumLPN(date);

        int month_lpn = sumLPN(mon);

        int year_lpn = sumLPN(year);

        int final_lpn = sumLPN(date_lpn + month_lpn + year_lpn);
        return (final_lpn);
    }

    // -----------------------------Private
    // functions---------------------------------//
    private int sumLPN(int num) {
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

    private int Month(String mon) {
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