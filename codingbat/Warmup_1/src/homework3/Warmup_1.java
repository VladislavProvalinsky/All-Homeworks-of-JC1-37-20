package homework3;

public class Warmup_1 {

    // Параметр weekday имеет значение true, если это будний день, а параметр holiday
// - true, если мы находимся в отпуске. Мы спим, если не будний день или мы в отпуске.
// Верните истину, если мы будем спать
    public boolean sleepIn(boolean weekday, boolean vacation) {
        if (weekday == false || vacation == true){
            return true;
        }
        return false;
    }

    // У нас есть две обезьяны, a и b, а параметры aSmile и bSmile указывают,
// улыбается ли каждая. У нас проблемы, если они оба улыбаются или если ни
// один из них не улыбается. Верните истину, если у нас проблемы.
    public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        if ((aSmile == true && bSmile == true)||(aSmile == false && bSmile == false)){
            return true;
        }
        return false;
    }

    // Если даны два значения типа int, вернуть их сумму. Если два значения не совпадают,
// верните двойную их сумму.
    public int sumDouble(int a, int b) {
        if (a!=b){
            return a+b;
        }
        return (a+b)*2;
    }

    // Если задано значение int n, вернуть абсолютную разницу между n и 21,
// за исключением возврата двойной абсолютной разницы, если n больше 21.
    public int diff21(int n) {
        if (n>=21){
            return Math.abs(n-21)*2;
        }
        return Math.abs(n-21);
    }

    // У нас есть громко говорящий попугай. Параметр hour является текущим часовым
// временем в диапазоне 0..23. Мы попадаем в беду, если попугай разговаривает,
// а час до 7 или после 20. Если у нас неприятности, верните истину.
    public boolean parrotTrouble(boolean talking, int hour) {
        if (talking == true && (hour < 7 || hour > 20)){
            return true;
        }
        return false;
    }

    // Если заданы 2 числа, a и b, вернуть true, если один, если их 10 или их сумма равна 10.
    public boolean makes10(int a, int b) {
        if (a ==1 || a==10 || b==1 || b == 10 || a+b==10){
            return true;
        }
        return false;
    }

    // Если задано int n, вернуть true, если оно находится в пределах 10 из 100 или 200.
// Примечание. Math.abs (num) вычисляет абсолютное значение числа.
    public boolean nearHundred(int n) {
        if (n<90 || (n>110 && n <190) || n>210){
            return false;
        }
        return true;
    }

    // Если задано 2 значения типа int, вернуть true, если одно отрицательно, а другое
// положительно. За исключением случаев, когда параметр «отрицательный» имеет значение
// «истина», возвращает значение «истина», только если оба значения являются отрицательными
    public boolean posNeg(int a, int b, boolean negative) {
        if (negative) {
            return (a < 0 && b < 0);
        }
        return ((a < 0 && b > 0) || (a > 0 && b < 0));
    }

    // Если указана строка, верните новую строку, где на переднем плане добавлено "не".
// Однако если строка уже начинается с "not", верните строку без изменений.
// Примечание: используйте .equals () для сравнения 2 строк.
    public String notString(String str) {
        String not = "not ";
        String x = not+str;
        if (x.equals(str)==true || str.startsWith("not")==true){
            return str;
        }
        return not+str;
    }

    // При наличии непустой строки и int n возвращает новую строку, где char с индексом n удален.
// Значение n будет допустимым индексом символа в исходной строке (т.е. n будет находиться
// в диапазоне 0.. str.length () -1 включительно).
    public String missingChar(String str, int n) {
        return str.substring(0, n) + str.substring(n + 1);
    }

    // Если указана строка, верните новую строку, где были обменены первый и последний символы.
    public String frontBack(String str) {
        if (str.length()==0){
            return str;
        }
        else {
            char string [] = str.toCharArray();
            int len = string.length - 1;
            char temp = string[0];
            string[0] = string[len];
            string[len] = temp;
            str = new String(string);
            return str;
        }
    }

    // Учитывая строку, мы скажем, что передний - это первые 3 символа строки.
// Если длина строки меньше 3, то спереди все, что там есть. Возвращает новую строку,
// которая представляет собой 3 копии передней части.
    public String front3(String str) {
        if (str.length()<3){
            return str+str+str;
        }
        else {
            String sub = str.substring(0,3);
            return sub+sub+sub;
        }
    }

    // Учитывая строку, возьмите последний знак и верните новую строку с последним знаком,
// добавленным спереди и сзади, так что "кот" дает "tcatt". Исходная строка будет иметь
// длину 1 или более.
    public String backAround(String str) {
        String sub = str.substring(str.length()-1);
        return sub+str+sub;
    }

    // Возвращает значение true, если данное неотрицательное число кратно 3 или кратно 5.
// Использовать оператор% "mod" -- см. Введение в Mod
    public boolean or35(int n) {
        if (n%3==0 || n%5==0){
            return true;
        }
        return false;
    }

    // Учитывая строку, возьмите первые 2 чара и верните строку с 2 чарами, добавленными
// как спереди, так и сзади, поэтому "котенок" дает "кикиттенки". Если длина строки
// меньше 2, используйте любые символы.
    public String front22(String str) {
        if(str.length()<2){
            return str+str+str;
        } else {
            String sub = str.substring(0,2);
            return sub+str+sub;
        }
    }

    // Если указана строка, верните значение true, если строка начинается с "hi" и false
// в противном случае.
    public boolean startHi(String str) {
        if (str.startsWith("hi")==true){
            return true;
        }
        return false;
    }

    // При двух температурах возвращается значение true, если одна из них меньше 0,
// а другая больше 100.
    public boolean icyHot(int temp1, int temp2) {
        if (temp1<0 && temp2>100 || temp1>100 && temp2<0){
            return true;
        }
        return false;
    }

    // Учитывая 2 значения int, верните значение true, если любое из них находится в
// диапазоне 10.. 20 включительно.
    public boolean in1020(int a, int b) {
        if (a>=10 && a<=20 || b>=10 && b<=20){
            return true;
        }
        return false;
    }

    // Скажем, что число "подростковое", если оно находится в диапазоне 13.. 19 включительно.
// Если задано 3 значения int, возвращайте значение true, если 1 или более из них являются
// подростковыми.
    public boolean hasTeen(int a, int b, int c) {
        if (a>=13 && a<=19 || b>=13 && b<=19 || c>=13 && c<=19){
            return true;
        }
        return false;
    }

    // Скажем, что число "подростковое", если оно находится в диапазоне 13.. 19 включительно.
// Если задано 2 значения int, верните значение true, если один или другой является подростком,
// но не оба.
    public boolean loneTeen(int a, int b) {
        if ((a>=13 && a<=19 && b>=13 && b<=19) || a==b){
            return false;
        }
        return true;
    }

    // Если строка "del" начинается с индекса 1, возвращает строку, в которой это "del"
// было удалено. В противном случае верните строку без изменений.
    public String delDel(String str) {
        if (str.startsWith("del",1)==true && str.length()>=4){
            String str1 = str.substring(0,1);
            String str2 = str.substring(4);
            return str1+str2;
        }
        return str;
    }

    // Возвращает значение true, если данная строка начинается с "mix", кроме "m" может быть
// что угодно, поэтому "pix", "9ix".. все количество.
    public boolean mixStart(String str) {
        if (str.startsWith("ix",1)){
            return true;
        }
        return false;
    }

    // Если указана строка, верните строку, составленную из первых 2 символов (если она присутствует),
// но включите первый символ, только если это 'o', и включите второй, только если это 'z', поэтому
// "ozymandias" дает "oz".
    public String startOz(String str) {
        if (str.startsWith("oz")==true){
            return str.substring(0,2);
        }
        else if (str.startsWith("z",1)==true){
            return str.substring(1,2);
        }
        else if (str.startsWith("o",0)==true){
            return str.substring(0,1);
        }
        return "";
    }

    // С учетом трех значений int, a b c, возвращает наибольшее.
    public int intMax(int a, int b, int c) {
        int mus [] = {a,b,c};
        int m = mus [0];
        for (int i=0; i<mus.length; i++){
            if (m<mus[i]){
                m = mus[i];
            }
        }
        return m;
    }

    // Если задано 2 значения int, верните любое из значений, ближайших к значению 10,
// или верните 0 в случае привязки. Обратите внимание, что Math.abs (n) возвращает
// абсолютное значение числа.
    public int close10(int a, int b) {
        int num1 = Math.abs(a-10);
        int num2 = Math.abs(b-10);
        if (num1<num2){
            return a;
        }
        else if (num2<num1){
            return b;
        }
        return 0;
    }

    // Учитывая 2 значения int, возвращайте значение true, если они оба находятся в диапазоне
// 30.. 40 включительно, или они оба находятся в диапазоне 40.. 50 включительно.
    public boolean in3050(int a, int b) {
        if (a>=30 && b>=30 && a<=40 && b<=40){
            return true;
        }
        else if (a>=40 && b>=40 && a<=50 && b<=50){
            return true;
        }
        return false;
    }

    // При 2 положительных значений int возвращает большее значение, которое находится в
// диапазоне 10.. 20 включительно, или возвращает 0, если ни одно из них не находится
// в этом диапазоне.
    public int max1020(int a, int b) {
        if (b>a){
            int temp = a;
            a = b;
            b = temp;
        }
        if (a>=10 && a<=20){
            return a;
        }
        else if (b>=10 && b<=20){
            return b;
        }
        return 0;
    }

    // Возвращает значение true, если данная строка содержит от 1 до 3 символов "e".
    public boolean stringE(String str) {
        char a [] = str.toCharArray();
        int sum = 0;
        for (int i=0; i<a.length; i++){
            if (a[i]=='e'){
                sum +=1;
            }
        }
        if (sum>=1 && sum <=3){
            return true;
        }
        return false;
    }

    // Учитывая два неотрицательных значения int, верните значение true, если они имеют
// одну и ту же последнюю цифру, например, с 27 и 57. Обратите внимание, что оператор
// % "mod" вычисляет остатки, так что 17% 10 равно 7.
    public boolean lastDigit(int a, int b) {
        int lastnum_a = a%10;
        int lastnum_b = b%10;
        if (lastnum_a == lastnum_b){
            return true;
        }
        return false;
    }

    // Если указана строка, верните новую строку, где последние 3 символа находятся в
// верхнем регистре. Если строка содержит менее 3 символов, в верхнем регистре все,
// что там есть. Обратите внимание, что str.toUpperCase () возвращает версию строки
// в верхнем регистре.
    public String endUp(String str) {
        if (str.length()<3){
            return str.toUpperCase ();
        }
        else {
            String str1 = str.substring(0,str.length()-3);
            String strUp = str.substring(str.length()-3);
            return str1+strUp.toUpperCase ();
        }
    }

    // При наличии непустой строки и int N возвращает строку, начинающуюся с символа 0,
// а затем каждый N-й символ строки. Если N равно 3, используйте символ 0, 3, 6,...
// и так далее. N равно 1 или более.
    public String everyNth(String str, int n) {
        String str1 ="";
        for (int i=0; i<str.length(); i+=n){
            str1+=str.charAt(i);
        }
        return str1;
    }
}
