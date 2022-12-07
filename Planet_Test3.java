import java.awt.*;

public class Planet_Test3 {
    private final String TYPE_SUN = "항성";
    private final String TYPE_SATELLITE = "위성";
    private final String TYPE_PLANET = "행성";
    private final String SHAPE_SUN = "*";
    private final String SHAPE_SATELLITE = "·";
    private final String SHAPE_PLANET = "+";
    private final String BLANK = " ";
    private final String CURRENT_LOCATION_MESSAGE_H = "H";
    private final String CURRENT_LOCATION_MESSAGE_E = "E";
    private final String CURRENT_LOCATION_MESSAGE_R = "R";
    private final String CURRENT_LOCATION_MESSAGE = "!";
    private final String CURRENT_LOCATION_ARROW1 = "|";
    private final String CURRENT_LOCATION_ARROW2 = "V";
    private final int SATELLITE_SIZE = 2;

    private static final int mapSize = 103;
    private static String[][] solarSystem = new String[mapSize][mapSize];

    private String planet;
    private int dates;
    private String type;
    private String name;

    public Planet_Test3(String name, String type, int dates) {
        this.name = name;
        this.type = type;
        this.dates = dates;
        makePlanet();
    }

    private void makePlanet() {
        if (type.equals(TYPE_SUN)) {
            planet = SHAPE_SUN;
        } else if (type.equals(TYPE_SATELLITE)) {
            planet = SHAPE_SATELLITE;
        } else if (type.equals(TYPE_PLANET)) {
            planet = SHAPE_PLANET;
        }
    }

    public int addSolarToSolarSystem() {
        int solarXY = mapSize / 2 + 1;
        solarSystem[solarXY][solarXY] =planet;
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

    private void addPlanetToSolarSystem(int y, int x) {
        if (name.equals(StarEnum.EARTH.getName())) {
            solarSystem[y-3][x-2] = CURRENT_LOCATION_MESSAGE_H;
            solarSystem[y-3][x-1] = CURRENT_LOCATION_MESSAGE_E;
            solarSystem[y-3][x] = CURRENT_LOCATION_MESSAGE_R;
            solarSystem[y-3][x+1] = CURRENT_LOCATION_MESSAGE_E;
            solarSystem[y-3][x+2] = CURRENT_LOCATION_MESSAGE;
            solarSystem[y-2][x] = CURRENT_LOCATION_ARROW1;
            solarSystem[y-1][x] = CURRENT_LOCATION_ARROW2;
        }
        solarSystem[y][x] = planet;
    }


    private Point revolve(int day, int radius, int y, int x) {

        for (int i = 1; i <= day; i++) {
            if (i > 1 && i <= radius + 1) {
                y++;
                x--;
            }
            if (i > radius + 1 && i <= radius * 2 + 1) {
                y--;
                x--;
            }
            if (i > radius * 2 + 1 && i <= radius * 3 + 1) {
                y--;
                x++;
            }
            if (i > radius * 3 + 1 && i <= radius * 4) {
                y++;
                x++;
            }
        }
        addPlanetToSolarSystem(y, x);
        return new Point(x, y);
    }
}
