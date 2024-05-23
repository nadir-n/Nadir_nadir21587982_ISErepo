import java.util.*;

class code {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Date: ");
        int date = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Month: ");
        String month = sc.nextLine();
        System.out.println("Enter Year: ");
        int year = sc.nextInt();
        sc.close();
        int mon = Month(month);
        int LPN = LifePathNumber(date, mon, year);
        System.out.println("Life Path Number: " + LPN);

    }

    public static int LifePathNumber(int date, int month, int year) {
        int date_lpn = 0;
        int temp;
        date_lpn = date_lpn + date % 10;
        temp = date / 10;
        date_lpn += temp;
        System.out.println("Date " + date_lpn);

        int month_lpn = 0;
        month_lpn = month_lpn + month % 10;
        temp = month / 10;
        date_lpn += temp;
        System.out.println("Month " + month_lpn);

        int year_lpn = 0;
        year_lpn = year_lpn + year / 1000; 
        temp = year % 1000; 
        year_lpn += temp / 100; 
        temp = temp % 100;
        year_lpn += temp / 10;
        temp = temp % 10; 
        year_lpn += temp;

        System.out.println("Year " + year_lpn);
        return (date_lpn + month_lpn + year_lpn);
    }

    public static int Month(String mon) {
        if (mon.equals("January")) {
            return 1;
        } else if (mon.equals("February")) {
            return 2;
        } else if (mon.equals("March")) {
            return 3;
        } else if (mon.equals("April")) {
            return 4;
        } else if (mon.equals("May")) {
            return 5;
        } else if (mon.equals("June")) {
            return 6;
        } else if (mon.equals("July")) {
            return 7;
        } else if (mon.equals("August")) {
            return 8;
        } else if (mon.equals("September")) {
            return 9;
        } else if (mon.equals("October")) {
            return 10;
        } else if (mon.equals("November")) {
            return 11;
        } else if (mon.equals("December")) {
            return 12;
        }
        return -1;
    }
}