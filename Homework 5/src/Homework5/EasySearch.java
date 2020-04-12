//2.2. Написать класс EasySearch реализующий интерфейс ISearchEngine. Реализовать поиск по строкам при помощи метода indexOf.

package Homework5;

public class EasySearch implements ISearchEngine {
    @Override
    public int search(String str, String word) {
        int count = 0;
        int symbols = 0;
            while (count !=-1){
                count = str.toLowerCase().indexOf(word.toLowerCase(),count);
                if (count !=-1){
                    count++;
                    symbols++;
                }
            }
        return symbols;
    }
}
