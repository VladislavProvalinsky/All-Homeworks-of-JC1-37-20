package homework3;

public class ArraysSort {

    public void chooseSort (int[]a){
        System.out.print("Массив до сортировки: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.print("\nМассив после сортировки методом прямого выбора: ");
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
        System.out.print("Массив до сортировки: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) { // можно менять условие в зависимости от порядка сортировки
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }
        System.out.print("\nМассив после пузырьковой сортировки: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public void shakerSort (int [] a){
        System.out.print("Массив до сортировки: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
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
        System.out.print("\nМассив после шейкерной сортировки: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public void insertSort (int[]a){
        System.out.print("Массив до сортировки: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        for (int i = 1; i < a.length; i++) {
            int current = a[i];
            int m = i-1;
            while (m>=0 && current<a[m]) {
                a[m+1] = a[m];
                m--;
            }
            a[m+1]=current;
        }
        System.out.print("\nМассив после сортировки методом включения: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
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

    public void merge(int[]a, int[]leftArr, int[]rightArr, int left, int right) {
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

    public void quickSort(int[] a) {
        int leftMarker = 1;
        int rightMarker = a.length-1;
        int pivot = a[(leftMarker + rightMarker) / 2]; // определяем опорный элемент
        do {
            while (a[leftMarker] < pivot) { // Двигаем левый маркер слева направо пока элемент меньше, чем pivot
                leftMarker++;
            }
            while (a[rightMarker] > pivot) { // Двигаем правый маркер, пока элемент больше, чем pivot
                rightMarker--;
            }
            if (leftMarker <= rightMarker) { // Проверим, не нужно обменять местами элементы, на которые указывают маркеры
                if (leftMarker < rightMarker) { // Левый маркер будет меньше правого только если мы должны выполнить swap
                    int temp = a[leftMarker];
                    a[leftMarker] = a[rightMarker];
                    a[rightMarker] = temp;
                }
                leftMarker++; // Сдвигаем маркеры, чтобы получить новые границы
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);
        if (leftMarker < a.length-1) { // Выполняем рекурсивно для частей
            quickSort(a);
        }
        if (0 < rightMarker) {
            quickSort(a);
        }
    }
}
