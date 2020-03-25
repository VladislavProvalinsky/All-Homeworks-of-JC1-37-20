package homework3;

public class ArraysSort {

    public void chooseSort (int[]a){
        for (int i = 0; i < a.length; i++) {
            int m = i;
            for (int j = i; j < a.length; j++) {
                if (a[m] > a[j]) { // можно менять условие в зависимости от порядка сортировки
                    m = j;
                }
            }
            int t = a[m];
            a[m] = a[i];
            a[i] = t;
            System.out.print(t + " ");
        }
    }

    public void bubbleSort (int [] a){
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) { // можно менять условие в зависимости от порядка сортировки
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }
    }

    public void shakerSort (int [] a){
        int leftSide = 1; // определяем номер эл-та с левой стороны
        int rightSide = a.length-1; // определяем номер эл-та с правой стороны
        while (leftSide<=rightSide) { // вводим цикл сужения
            for (int i = rightSide; i >= leftSide; i--) { // вводим цикл сортировки справа, ищем мин. значение и сдвигаем его влево
                if (a[i - 1] > a[i]) {
                    int t = a[i];
                    a[i] = a[i-1];
                    a[i-1] = t;
                }
            }
            leftSide++; // уменьшаем количество итераций
            for (int i = leftSide; i <= rightSide; i++) { // вводим цикл сортировки слева, ищем макс значение и сдвигаем его вправо
                if (a[i - 1] > a[i]) {
                    int t = a[i];
                    a[i] = a[i-1];
                    a[i-1] = t;
                }
            }
            rightSide--; // уменьшаем количество итераций
        }
    }

    public void insertSort (int[]a){
        for (int i = 1; i < a.length; i++) {
            int current = a[i];
            int m = i-1;
            while (m>=0 && current<a[m]) {
                a[m+1] = a[m];
                m--;
            }
            a[m+1]=current;
        }
    }

    public void mergeSort(int[]a) {
        if (a.length < 2) {
            return;
        }
        int mid = a.length/2;
        int[]leftArr = new int[mid];
        int[]rightArr = new int[a.length - mid];

        for (int i = 0; i < mid; i++) {
            leftArr[i]= a[i];
        }
        for (int i = mid; i < a.length; i++) {
            rightArr[i - mid]= a[i];
        }
        mergeSort(leftArr);
        mergeSort(rightArr);

        merge(a, leftArr, rightArr, mid, a.length - mid);
    }

    private void merge(int[]a, int[]leftArr, int[]rightArr, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (leftArr[i]<= rightArr[j]) {
                a[k++]= leftArr[i++];
            }
            else {
                a[k++]= rightArr[j++];
            }
        }
        while (i < left) {
            a[k++]= leftArr[i++];
        }
        while (j < right) {
            a[k++]= rightArr[j++];
        }
    }

    public void quickSort (int[] a, int start, int end) {
        int startMarker = start;
        int endMarker = end;
        int pivot = a[end-1]; // определяем опорный элемент
        while (startMarker < endMarker){
            while (a[startMarker] < pivot) { // Двигаем левый маркер слева направо пока элемент меньше, чем pivot
                startMarker++;
            }
            while ((a[endMarker] > pivot) && (endMarker > startMarker)) { // Двигаем правый маркер, пока элемент больше, чем pivot
                endMarker--;
            }
            if (startMarker < endMarker) { // Проверим, не нужно обменять местами элементы, на которые указывают маркеры
                int temp = a[startMarker];
                a[startMarker] = a[endMarker];
                a[endMarker] = temp;
                if (endMarker - startMarker>1){
                startMarker++; // Сдвигаем маркеры, чтобы получить новые границы
                endMarker--;
                } else {
                    break;
                }
            }
        }
        if ((startMarker>start) && (startMarker-start>1)) { // Выполняем рекурсивно для частей
            quickSort(a,start,startMarker);
        }
        if ((end>endMarker) && (end-endMarker>1)) {
            quickSort(a,endMarker,end);
        }
    }

    public int [] deleteDublicat (int [] a){
        boolean flag = false;
        int countIteration=0;
        int count = 0;
        int n = a.length;
        int [] temp = new int [n];
        for (int i = 0; i < a.length ; i++) {
            flag = false;
            countIteration = 0;
            for (int j = i+1; j < a.length; j++) {
                if (a[i]==a[j]){
                    temp [i] = a[i];
                    flag = true;
                    countIteration++;
                }
            }
            temp [i] = a[i];
            if (flag == true){
                i+=countIteration;
                count+=countIteration;
            }
        }
        int [] res = new int [a.length-count];
        for (int i = 0, j=0; j < temp.length; i++,j++) {
                if (temp[j]!=0){
                    res [i]=temp[j];
                } else
                    i--;
            }
        return res;
    }
}
