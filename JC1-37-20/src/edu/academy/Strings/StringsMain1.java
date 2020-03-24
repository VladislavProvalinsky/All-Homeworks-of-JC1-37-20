package edu.academy.Strings;

public class StringsMain1 {
    public static void main(String[] args) {
        /*concat: объединяет строки
        valueOf: преобразует объект в строковый вид
        join: соединяет строки с учетом разделителя
        equals\ equalsIgnoreCase : сравнивает строки с\ без учетом регистра
        trim: удаляет начальные и конечные пробелы
        format: форматирует строку подставляю в неё значение из аргументов*/

        String str = "Илья";

        System.out.println(String.format("Привет %s, как дела", str));

        String spacedString = "    Очень много пробелов         тут и ещё вот тут        ";

        System.out.println(spacedString.trim());
        System.out.println(spacedString);

        System.out.println(spacedString.concat("Алло"));



    }
}
