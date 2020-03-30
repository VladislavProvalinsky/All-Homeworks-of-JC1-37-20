package homework4;

public enum Country implements ICharacteristicsCountry {
    BELARUS(9_413_446	,207_600),
    RUSSIA(146_748_590,17_125_191),
    UKRAIN(41_732_779,603_549),
    GREAT_BRITAIN (66_647_112, 244_820),
    POLAND (38_313_035, 312_685),
    LATVIA (1_908_100, 64_589),
    LITVA (2_790_472,65_200),
    ESTONIA (1_328_360, 45_226),
    GERMANY (83_149_300, 357_021),
    FRANCE (68_859_599, 547_030);

    private int popularity;
    private int square;

    Country(int popularity, int square){
        this.popularity = popularity;
        this.square = square;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public int getPopularity (Country Country){
        return Country.getPopularity();
    }

    public int getSquare (Country Country) {
        return Country.getSquare();
    }

    public static Country valueOfIgnoreCase(String name){
        return valueOf(name.toUpperCase());
    }
}
