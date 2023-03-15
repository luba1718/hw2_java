// 1. Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
// результат после каждой итерации запишите в лог-файл.

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;
public class task1 {
    public static void main(String[] args) throws IOException {
        int [] array = {-3, 0, 25, 3, -10, 2};
        System.out.println(Arrays.toString(array));
        int[] newArr = listSort(array);
        System.out.println("\n Отсортированный массив: " + Arrays.toString(newArr) + " \n");
    }

    public static int[] listSort(int [] arr) throws IOException{
        Logger logger = Logger.getLogger(task1.class.getName());
        FileHandler fh = new FileHandler("logTask1.xml");
        logger.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);
        for(int k = 0; k < arr.length-1; k++) {
            for (int i = 0; i < arr.length - k-1; i++){
                if (arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            logger.info("\n Итерация номер " + k + " результат: " + Arrays.toString(arr));
        }
        return arr;
    }
    
}