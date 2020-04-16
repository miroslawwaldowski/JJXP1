package pl.Java_JSON_XML.JJXP1;

public class PeselCheck {

    private static int[] PESEL = new int[11];
    private static int day;
    private static int month;
    private static int year;

    private static void date() {
        day = (10 * PESEL[4]) + PESEL[5];
        month = (10 * PESEL[2]) + PESEL[3];
        year = (10 * PESEL[0]) + PESEL[1];

        if (month > 80 && month < 93) {
            month -= 80;
            year += 1800;
        } else if (month > 0 && month < 13) {
            year += 1900;
        } else if (month > 20 && month < 33) {
            month -= 20;
            year += 2000;
        } else if (month > 40 && month < 53) {
            month -= 40;
            year += 2100;
        } else if (month > 60 && month < 73) {
            month -= 60;
            year += 2200;
        }
    }

    private static boolean checkDate() {
        if (month > 0 && month < 13) {
            return (((day > 0 && day < 32) && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)) ||
                    ((day > 0 && day < 31) && (month == 4 || month == 6 || month == 9 || month == 11)) ||
                    ((day > 0 && day < 30 && leapYear(year)) || (day > 0 && day < 29 && !leapYear(year))));
        } else {
            return false;
        }
    }

    private static boolean leapYear(int year) {
        return (year % 400 == 0 || year % 4 == 0 && year % 100 != 0);
    }

    private static boolean control() {

        int sum = 9 * PESEL[0] + 7 * PESEL[1] + 3 * PESEL[2] + PESEL[3] +
                9 * PESEL[4] + 7 * PESEL[5] + 3 * PESEL[6] + PESEL[7] +
                9 * PESEL[8] + 7 * PESEL[9];
        sum %= 10;
        return sum == PESEL[10];
    }

    public static boolean check(String pesel) {
        if (pesel.length() == 11) {
            for (int i = 0; i < 11; i++) {
                PESEL[i] = Byte.parseByte(pesel.substring(i, i + 1));
            }
            date();
            return (checkDate() && control());
        } else {
            return false;
        }
    }
}

