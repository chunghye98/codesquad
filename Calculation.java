import java.awt.*;
import java.util.Scanner;

public class Calculation {

    private final int ZERO = 48;
    private final int NINE = 57;

    private int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private int solarXY;

    private StringBuilder sb;

    private Planet solar;
    private Planet earth;
    private Planet moon;

    public Calculation() {
        solar = new Planet(5);
        solarXY = solar.addSolarToSolarSystem();
        earth = new Planet(3);
        moon = new Planet(1);
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
