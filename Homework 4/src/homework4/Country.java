//ДЗ4:
//Выполнить до 27.03:
//1. Создать энум страны Country:
//1.1. В котором есть 10 элементов
//1.2. У каждого элемента есть два свойства (площадь страны, количество человек)
//1.3. Добавить интерфейс с методами получения площади страны и количеством человек
//1.4. Энум должен реализовывать созданный интерфейс
//1.5. Воспользоваться методом valueOf передав туда название элемента энума
//1.6. Сравнить результат valueOf и элемент энума через оператор ==
//1.7. Передать в valueOf имя несуществующего элемента
//1.8. Изучить что делаем метод compareTo в энумах.
//1.9. Изучить интерфейсы Comparable и Comparator из jdk
//1.9. Создать класс CountryAreaComparator. Данный класс должен реализоватвать интерфейс Comparator
// (implements Comparator<Country> написать вот так, что такое в скобочках мы пока не изучали, если что это тема generics).
// В данном классе необходимо сравнить площадь двух переданных стран.

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

    public int getSquare() {
        return square;
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
