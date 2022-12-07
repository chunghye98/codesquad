public enum StarEnum {

    SOLAR(0, 0, "태양", "항성"),

    MERCURY(6, 88, "수성", "행성"),
    VENUS(12, 225, "금성", "행성"),
    EARTH(18, 365, "지구", "행성"),
    MARS(24, 687, "화성", "행성"),
    JUPITER(30, 9380, "목성", "행성"),
    SATURN(36, 10585, "토성", "행성"),
    URANUS(42, 30660, "천왕성", "행성"),
    NEPTUNE(48, 60225, "해왕성", "행성"),

    MOON(2, 27, "달", "위성"),
    PHOBOS(2, 8 / 24 + 1, "포보스", "위성"),
    EUROPA(2, 85 / 24 + 1, "유로파", "위성"),
    TITAN(2, 16, "타이탄", "위성"),
    MIRANDA(2, 34 / 24 + 1, "미란다", "위성"),
    TRITON(2, 141 / 24 + 1, "트리톤", "위성");

    private final int radius;
    private final double round;
    private final int date;
    private final String name;
    private final String type;

    StarEnum(int radius, int date, String name, String type) {
        this.radius = radius;
        this.date = date;
        this.name = name;
        this.type = type;
        this.round = (double) radius * 4.0;
    }

    public int getRadius() {
        return radius;
    }

    public double getRound() {
        return round;
    }

    public int getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
