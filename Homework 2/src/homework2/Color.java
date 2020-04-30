//ДЗ 2
// 1. Создать класс Color. Класс должен содержать:
// 1.0 Все константы должны быть приватными, все методы должны быть публичны, конструктор должен быть публичными. Статических методов быть не должно.
// 1.1 Создать конструктор который будет принимать параметр int. Туда мы будем передавать номер цвета.
// 1.2 Внутри класса создать константы цветов радуги которые будут содержать номера цветов
// (http://cyclowiki.org/wiki/%D0%9A%D0%B0%D0%B6%D0%B4%D1%8B%D0%B9_%D0%BE%D1%85%D0%BE%D1%82%D0%BD%D0%B8%D0%BA_%D0%B6%D0%B5%D0%BB%D0%B0%D0%B5%D1%82_%D0%B7%D0%BD%D0%B0%D1%82%D1%8C,_%D0%B3%D0%B4%D0%B5_%D1%81%D0%B8%D0%B4%D0%B8%D1%82_%D1%84%D0%B0%D0%B7%D0%B0%D0%BD).
// Например RED = 1;
// 1.3 Создать методы getNumber() и getName(). Метод getNumber должен вернуть номер цвета который мы передали в конструктор.
// Метод getName должен возвращать название цвета ввиде строки на русском, если цвет нам не известен возвращать строку "неизвестно" .
// В методе getName должен использоваться switch и константы объявленные при выполнении первого задания. Внимание никакой печати
// в консоль внутри класс Color быть не должно.
// 2. В отдельном классе, создать мэйн метод. Внутри данного метода создать экземпляр Color. В конструктор передать число
// 3. Далее вывести в консоль номер цвета и его названия использую результат выполнения методов getNumber и getName.

package homework2;

public class Color {

    private final int RED = 1;
    private final int ORANGE = 2;
    private final int YELLOW = 3;
    private final int GREEN = 4;
    private final int BLUE = 5;
    private final int SINIY = 6;
    private final int PURPLE = 7;

    private int ColorNumber;

    public Color(int number) {
        this.ColorNumber = number;
    }

    public int getNumber() {
        return ColorNumber;
    }

    public String getName() {
        switch (ColorNumber) {
            case 1:
                return "Красный";
            case 2:
                return "Оранжевый";
            case 3:
                return "Желтый";
            case 4:
                return "Зеленый";
            case 5:
                return "Голубой";
            case 6:
                return "Синий";
            case 7:
                return "Фиолетовый";
            default:
                return "неизвестно";
        }
    }
}
