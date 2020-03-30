package homework4;

public class CountryAreaComparator implements Comparator<Country>{
    public int compare(Country country1, Country country2) {
        if (country1.getSquare() == country2.getSquare()) {
            return 0;
        }
        if (country1.getSquare() > country2.getSquare()) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
