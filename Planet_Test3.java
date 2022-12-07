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


}
