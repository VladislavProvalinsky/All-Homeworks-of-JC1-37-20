package Homework9;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    // пишем статический метод для вставок уникальных выборок (в качестве ключей) с колличеством их повторений
    public static void mapAdditor (Map<String, Integer> map, List<String> list) {
        for (String word : list) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
    }

    public static void main(String[] args) {
        String separator = File.separator;
        String path = "C:" + separator + "Users" + separator + "Vlad" + separator + "Desktop" + separator + "Benign_list_big_final.csv";

        List<String> urls = null;
        try {
            urls = Files.lines(Paths.get(path))
                    .map(s -> s.replaceAll(";",""))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Pattern pattern = Pattern.compile("(http|https)://([\\w.]*\\.([\\w]*))/?.*"); // задаем Pattern шаблон для проверок URL адресов

        /*
        Создаем листы для нужных нам выборок из паттерна
         */
        List<String> protocols = new ArrayList<>();
        List<String> domens = new ArrayList<>();
        List<String> upperDomens = new ArrayList<>();

        for (String url : urls) { // пишем цикл проверок соответствия адресов паттерну и выводим нужные выборки по группам (сразу добавляем каждую выборку в свой лист)
            Matcher matcher = pattern.matcher(url);
            boolean matches = matcher.matches();
            if (matches) { // выбираем только "чистые" адреса и только у "чистых" записываем в листы выборки
                protocols.add(matcher.group(1));
                domens.add(matcher.group(2));
                upperDomens.add(matcher.group(3));
            }
        }

        // Заводим для каждого листа выборок свои Мапы для будущей сортировки

        Map<String, Integer> mapOfProtocols = new LinkedHashMap<>();
        Map<String, Integer> mapOfDomens = new LinkedHashMap<>();
        Map<String, Integer> mapOfUpperDomens = new LinkedHashMap<>();

        // добавляем элементы листов выборок в Мапы с помощью нашего статического метода
        mapAdditor(mapOfProtocols, protocols);
        mapAdditor(mapOfDomens, domens);
        mapAdditor(mapOfUpperDomens, upperDomens);

        // заносим отсортированные Map-ы выборок в новые Map сохраняя порядок вставки
        Map<String, Integer> sortedProtocols = SortByValuesMaps.sortByValue(mapOfProtocols);
        Map<String, Integer> sortedDomens = SortByValuesMaps.sortByValue(mapOfDomens);
        Map<String, Integer> sortedUpperDomens = SortByValuesMaps.sortByValue(mapOfUpperDomens);

        // выводим ТОП-10 часто употребляемых протоколов
        List<Map.Entry<String, Integer>> list1 = new ArrayList<>(sortedProtocols.entrySet());
        System.out.println("Топ 2 часто встречающихся протоколов URL адресов:");
        for (int i = 0; i < 2; i++) {
            System.out.println(list1.get(i));
        }

        // выводим ТОП-10 часто употребляемых доменов
        List<Map.Entry<String, Integer>> list2 = new ArrayList<>(sortedDomens.entrySet());
        System.out.println("Топ 10 часто встречающихся доменов URL адресов:");
        for (int i = 0; i < 10; i++) {
            System.out.println(list2.get(i));
        }

        // выводим ТОП-10 часто употребляемых доменов верхнего уровня
        List<Map.Entry<String, Integer>> list3 = new ArrayList<>(sortedUpperDomens.entrySet());
        System.out.println("Топ 10 часто встречающихся доменов верхнего уровня URL адресов:");
        for (int i = 0; i < 10; i++) {
            System.out.println(list3.get(i));
        }
    }
}
