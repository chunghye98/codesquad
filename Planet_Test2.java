import java.awt.*;

public class Planet_Test2 {
    private final String STAR = "*";
    private final String BLANK = " ";
    private final int SOLAR_RANGE = 2;
    private final int EARTH_RANGE = 1;
    private final int MOON_XY = 0;
    private final int EARTH_MOVE_RANGE_1 = 1;
    private final int EARTH_MOVE_RANGE_2 = 91;
    private final int EARTH_MOVE_RANGE_3 = 182;
    private final int EARTH_MOVE_RANGE_4 = 273;
    private final int EARTH_MOVE_RANGE_5 = 365;
    private final int MOON_MOVE_RANGE_1 = 1;
    private final int MOON_MOVE_RANGE_2 = 8;
    private final int MOON_MOVE_RANGE_3 = 15;
    private final int MOON_MOVE_RANGE_4 = 22;
    private final int MOON_MOVE_RANGE_5 = 28;
    private static final int EARTH_MOVE_DIAMETER = 365 / 2 + 1;
    private static final int MOON_MOVE_DIAMETER = 28 / 2;

    private static String[][] solarSystem = new String[EARTH_MOVE_DIAMETER + MOON_MOVE_DIAMETER + 1][EARTH_MOVE_DIAMETER + MOON_MOVE_DIAMETER + 1];

    private String[][] planet;
    private int size;
    private int solarSystemRange;

    public Planet_Test2(int size) {
        this.size = size;
        this.planet = new String[size][size];
        this.solarSystemRange = EARTH_MOVE_DIAMETER + MOON_MOVE_DIAMETER;
        makePlanet();
    }

    private void makePlanet() {
        int radius = size / 2;
        // 2사분면
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                if (j > radius - i - 1) {
                    planet[i][j] = STAR;
                } else {
                    planet[i][j] = BLANK;
                }
            }
        }

        // 1사분면
        for (int i = 0; i < radius; i++) {
            for (int j = radius; j < size; j++) {
                if (j <= radius + i) {
                    planet[i][j] = STAR;
                } else {
                    planet[i][j] = BLANK;
                }
            }
        }

        // 3사분면
        for (int i = radius; i < size; i++) {
            for (int j = 0; j < radius; j++) {
                if (j >= i - radius) {
                    planet[i][j] = STAR;
                } else {
                    planet[i][j] = BLANK;
                }
            }
        }

        // 4사분면
        for (int i = radius; i < size; i++) {
            for (int j = radius; j < size; j++) {
                if (j <= size - 1 + (radius - i)) {
                    planet[i][j] = STAR;
                } else {
                    planet[i][j] = BLANK;
                }
            }
        }
    }

    // 태양계에 태양 넣기
    public int addSolarToSolarSystem() {
        int solarXY = solarSystemRange / 2 + 1;
        for (int i = solarXY - SOLAR_RANGE; i <= solarXY + SOLAR_RANGE; i++) {
            for (int j = solarXY - SOLAR_RANGE; j <= solarXY + SOLAR_RANGE; j++) {
                solarSystem[i][j] = planet[i - (solarXY - SOLAR_RANGE)][j - (solarXY - SOLAR_RANGE)];
            }
        }
        return solarXY;
    }

    // 태양계 보여주기
    public void showSolarSystem() {
        for (int i = 0; i < solarSystem.length; i++) {
            for (int j = 0; j < solarSystem[i].length; j++) {
                if (solarSystem[i][j] == null) {
                    solarSystem[i][j] = BLANK;
                }
            }
        }

        for (String[] arr : solarSystem) {
            for (String s : arr) {
                System.out.print(s);
            }
            System.out.println();
        }
    }

    // 태양계에 지구 넣기
    public void addEarthToSolarSystem(int y, int x) {
        for (int i = y - EARTH_RANGE; i <= y + EARTH_RANGE; i++) {
            for (int j = x - EARTH_RANGE; j <= x + EARTH_RANGE; j++) {
                solarSystem[i][j] = planet[i - (y - EARTH_RANGE)][j - (x - EARTH_RANGE)];
            }
        }
    }

    // 태양계에 달 넣기
    public void addMoonToSolarSystem(int y, int x) {
        solarSystem[y][x] = planet[MOON_XY][MOON_XY];
    }

    // 지구가 공전한 후 위치 찾기
    public Point moveEarth(int day, int solarXY) {
        int y = solarXY;
        int x = EARTH_MOVE_DIAMETER + MOON_MOVE_DIAMETER / 2;
        for (int i = 0; i < day; i++) {
            if (i > EARTH_MOVE_RANGE_1 && i <= EARTH_MOVE_RANGE_2) {
                y++;
                x--;
            }
            if (i > EARTH_MOVE_RANGE_2 && i <= EARTH_MOVE_RANGE_3) {
                y--;
                x--;
            }
            if (i > EARTH_MOVE_RANGE_3 && i <= EARTH_MOVE_RANGE_4) {
                y--;
                x++;
            }
            if (i > EARTH_MOVE_RANGE_4 && i <= EARTH_MOVE_RANGE_5) {
                y++;
                x++;
            }
        }
        addEarthToSolarSystem(y, x);
        return new Point(x, y);
    }

    // 달이 공전한 후 위치 찾기
    public void moveMoon(int day, Point p) {
        int y = p.y;
        int x = p.x + MOON_MOVE_DIAMETER / 2;
        day = day % (MOON_MOVE_DIAMETER * 2);
        for (int i = 0; i < day; i++) {
            if (i > MOON_MOVE_RANGE_1 && i <= MOON_MOVE_RANGE_2) {
                y++;
                x--;
            }
            if (i > MOON_MOVE_RANGE_2 && i <= MOON_MOVE_RANGE_3) {
                y--;
                x--;
            }
            if (i > MOON_MOVE_RANGE_3 && i <= MOON_MOVE_RANGE_4) {
                y--;
                x++;
            }
            if (i > MOON_MOVE_RANGE_4 && i <= MOON_MOVE_RANGE_5) {
                x++;
                y++;
            }
        }
        addMoonToSolarSystem(y, x);
    }
}
