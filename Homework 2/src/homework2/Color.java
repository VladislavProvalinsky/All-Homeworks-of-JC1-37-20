package homework2;

public class Color {
    private int Red;
    private int Orange;
    private int Yellow;
    private int Green;
    private int Blue;
    private int Siniy;
    private int Purple;
    private int UnknownColor;
    private int ColorNumber;
    private String ColorName;

    public Color(int ColorNumber) {
        this.ColorNumber = ColorNumber;
    }

    public int getNumber() {
        return ColorNumber;
    }

    public String getName() {
        switch (ColorNumber) {
            case 1:
                Red = ColorNumber;
                ColorName = "Красный";
                break;
            case 2:
                Orange = ColorNumber;
                ColorName = "Оранжевый";
                break;
            case 3:
                Yellow = ColorNumber;
                ColorName = "Желтый";
                break;
            case 4:
                Green = ColorNumber;
                ColorName = "Зеленый";
                break;
            case 5:
                Blue = ColorNumber;
                ColorName = "Голубой";
                break;
            case 6:
                Siniy = ColorNumber;
                ColorName = "Синий";
                break;
            case 7:
                Purple = ColorNumber;
                ColorName = "Фиолетовый";
                break;
            default:
                UnknownColor = ColorNumber;
                ColorName = "неизвестно";
        }
        return ColorName;
    }
}
