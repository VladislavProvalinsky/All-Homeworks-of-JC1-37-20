package homework4;

import java.util.Comparator;

public class CountryAreaComparator implements Comparator<Country>{
    @Override
    public int compare(Country o1, Country o2) {
        if (o1.getSquare() == o2.getSquare()) {
            return 0;
        }
        else if (o1.getSquare() > o2.getSquare()) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
