package homework4;

public class CountryMain {

    public static void main(String[] args) {
        Country ob = Country.BELARUS;
        System.out.println(String.format("Население страны %s составляет: %s человек",ob,ob.getPopularity(ob)));
        System.out.println(String.format("Площадь страны %s составляет: %s кв.км",ob,ob.getSquare(ob)));

        Country ob1 = Country.valueOf("BELARUS");
        System.out.println(ob1);

        Country ob2 = Country.valueOfIgnoreCase("Russia");
        System.out.println(ob2);

        System.out.println(ob==ob1);

        int litvaIndex = Country.LITVA.ordinal();
        System.out.println(litvaIndex);

        System.out.println(ob2.compareTo(ob1));

        CountryAreaComparator comparator = new CountryAreaComparator();
        System.out.println(comparator.compare(Country.BELARUS,Country.FRANCE));

    }
}
