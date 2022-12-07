import java.awt.*;
import java.util.Scanner;

public class Calculation_Test2 {

    private final int ZERO = 48;
    private final int NINE = 57;

    private int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private int solarXY;

    private StringBuilder sb;

    private Planet_Test2 solar;
    private Planet_Test2 earth;
    private Planet_Test2 moon;

    public Calculation_Test2() {
        solar = new Planet_Test2(5);
        solarXY = solar.addSolarToSolarSystem();
        earth = new Planet_Test2(3);
        moon = new Planet_Test2(1);
    }

    public void run() {
        System.out.println("Sun, Earth, Moon");
        System.out.println("날짜를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        int month = inputToInteger(sc.next());
        int date = inputToInteger(sc.next());

        int day = calculateNumberOfDays(month, date);

        movePlanet(day);

        solar.showSolarSystem();
    }

    private int inputToInteger(String strInput) {
        char[] temp = strInput.toCharArray();
        sb = new StringBuilder();
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] >= ZERO && temp[i] <= NINE) {
                sb.append(temp[i]);
            }
        }
        return Integer.parseInt(sb.toString());
    }

    private void movePlanet(int day) {
        Point p = earth.moveEarth(day, solarXY);
        moon.moveMoon(day, p);
    }

    private int calculateNumberOfDays(int month, int date) {
        int day = 0;
        for (int i = 0; i < month; i++) {
            day += months[i];
        }
        day = day + date;
        return day;
    }
}
