import java.awt.*;
import java.util.Scanner;

public class Calculation_Test3 {
    private final int ZERO = 48;
    private final int NINE = 57;
    private final String INPUT_MESSAGE = "날짜를 입력하세요.";

    private int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private int solarXY;

    private StringBuilder sb;

    private Planet_Test3 solar;   // 태양
    private Planet_Test3 mercury; // 수성
    private Planet_Test3 venus;   // 금성
    private Planet_Test3 earth;   // 지구
    private Planet_Test3 mars;    // 화성
    private Planet_Test3 jupiter; // 목성
    private Planet_Test3 saturn;  // 토성
    private Planet_Test3 uranus;  // 천왕성
    private Planet_Test3 neptune; // 해왕성
    private Planet_Test3 moon; // 지구의 위성(달)
    private Planet_Test3 phobos; // 화성의 위성(포보스)
    private Planet_Test3 europa; // 목성의 위성(유로파)
    private Planet_Test3 titan; // 토성의 위성(타이탄)
    private Planet_Test3 miranda; // 천왕성의 위성(미란다)
    private Planet_Test3 triton; // 해왕성의 위성(트리톤)

    public Calculation_Test3() {
        solar = new Planet_Test3(StarEnum.SOLAR.getName(), StarEnum.SOLAR.getType(), StarEnum.SOLAR.getDate());

        mercury = new Planet_Test3(StarEnum.MERCURY.getName(), StarEnum.MERCURY.getType(), StarEnum.MERCURY.getDate());
        venus = new Planet_Test3(StarEnum.VENUS.getName(), StarEnum.VENUS.getType(), StarEnum.VENUS.getDate());
        earth = new Planet_Test3(StarEnum.EARTH.getName(), StarEnum.EARTH.getType(), StarEnum.EARTH.getDate());
        mars = new Planet_Test3(StarEnum.MARS.getName(), StarEnum.MARS.getType(), StarEnum.MARS.getDate());
        jupiter = new Planet_Test3(StarEnum.JUPITER.getName(), StarEnum.JUPITER.getType(), StarEnum.JUPITER.getDate());
        saturn = new Planet_Test3(StarEnum.SATURN.getName(), StarEnum.SATURN.getType(), StarEnum.SATURN.getDate());
        uranus = new Planet_Test3(StarEnum.URANUS.getName(), StarEnum.URANUS.getType(), StarEnum.URANUS.getDate());
        neptune = new Planet_Test3(StarEnum.NEPTUNE.getName(), StarEnum.NEPTUNE.getType(), StarEnum.NEPTUNE.getDate());

        moon = new Planet_Test3(StarEnum.MOON.getName(), StarEnum.MOON.getType(), StarEnum.MOON.getDate());
        phobos = new Planet_Test3(StarEnum.PHOBOS.getName(), StarEnum.PHOBOS.getType(), StarEnum.PHOBOS.getDate());
        europa = new Planet_Test3(StarEnum.EUROPA.getName(), StarEnum.EUROPA.getType(), StarEnum.EUROPA.getDate());
        titan = new Planet_Test3(StarEnum.TITAN.getName(), StarEnum.TITAN.getType(), StarEnum.TITAN.getDate());
        miranda = new Planet_Test3(StarEnum.MIRANDA.getName(), StarEnum.MIRANDA.getType(), StarEnum.MIRANDA.getDate());
        triton = new Planet_Test3(StarEnum.TRITON.getName(), StarEnum.TRITON.getType(), StarEnum.TRITON.getDate());

        solarXY = solar.addSolarToSolarSystem();
    }

    public void run() {

    }


}
