//2. К ДЗ война и мир написать новую реализацию ISearchEngine. Данная реализация должна подсчитывать количество
//   совпадений по переданному шаблону. Нужно использовать matcher.find()

package Homework5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EasySearchRegex {

    public static int searchWithPattern(Pattern pattern, String text) {
        int count = 0;
        Matcher m = pattern.matcher(text);
        while (!m.hitEnd()) {
            if (m.find()) {
                count++;
            }
        }
        return count;
    }
}
