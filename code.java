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
        int date_lpn = sumLPN(date);

        int month_lpn = sumLPN(month);
        
        int year_lpn = sumLPN(year);

        int final_lpn = sumLPN(date_lpn + month_lpn + year_lpn);
        return (final_lpn);
    }
    public static int sumLPN(int num){
        int lpn = 0;
        int temp = num;
        
        do{
            lpn=0;
            if(temp==11 || temp==22 || temp==33){
                lpn=temp;
                break;
            }
            while (temp > 0) {
                lpn += temp % 10;
                temp /= 10;
            }
            temp=lpn;
            
        }while (temp / 10 > 0);
        return lpn;
    }

    public static int Month(String mon) {
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
