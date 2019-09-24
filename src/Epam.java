import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Array;
import java.util.*;

public class Epam {
    public static void main(String[] args) {
//        Задание. Ввести с консоли n - размерность матрицы a [n] [n]. Задать значения элементов матрицы в интервале значений от -M до M с помощью генератора случайных чисел (класс Random).
//        1.     Упорядочить строки (столбцы) матрицы в порядке возрастания значений элементов k-го столбца (строки).
//
//        2.     Найти и вывести наибольшее число возрастающих (убывающих) элементов матрицы, идущих подряд.
//
//        3.     Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки
//
//        4.     Найти максимальный элемент в матрице и удалить из матрицы все строки и столбцы, его содержащие
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int n = sc.nextInt();
        int[][] mass = new int[n][n];
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                mass[i][j] = random.nextInt();

            }
        }
 //        1.     Упорядочить строки (столбцы) матрицы в порядке возрастания значений элементов k-го столбца (строки).
//        Arrays.sort(mass, Comparator.comparingInt(arr -> arr[1]));
        int collIncrease=0;
        for (int i = 0; i < n ; i++) {
            int t = mass[i][0];
            for (int j = 0; j < n ; j++) {
                int coll = -1;
                t +=1;
                if (t == mass[i][j]) {
                    coll +=1;
                }else{
                    if(coll>collIncrease){
                        collIncrease = coll;
                    }
                    coll = 0;
                    t = mass[i][j];
                }
            }
        }
        int collDecrease=0;
        for (int i = 0; i < n ; i++) {
            int t = mass[i][0];
            for (int j = 0; j < n ; j++) {
                int coll = -1;
                t -=1;
                if (t == mass[i][j]) {
                    coll +=1;
                }else{
                    if(coll>collDecrease){
                        collDecrease = coll;
                    }
                    coll = 0;
                    t = mass[i][j];
                }
            }
        }
        System.out.println("2.     Найти и вывести наибольшее число возрастающих (убывающих) элементов матрицы, идущих подряд.");
        System.out.println("подряд по увилечению " + collIncrease);
        System.out.println("Подряд по убыванию " + collDecrease);
        //        3.     Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки
        int summ = 0;
        for (int i = 0; i < n ; i++) {
            boolean boo = true;
            while (boo) {
                for (int j = 0; j < n;) {
                    if (mass[i][j] > 0) {
                        for (int l = j + 1; l < n; ) {
                            if (mass[i][l] < 0) {
                                summ += mass[i][l];
                            } else {
                                boo = false;
                            }
                            l +=1;
                            if (l == n) boo = false;
                        }
                    }
                    j +=1;
                    if(j == n)boo = false;
                }
            }
        }
        System.out.println("сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки");
        System.out.println(summ);
        //        4.     Найти максимальный элемент в матрице и удалить из матрицы все строки и столбцы, его содержащие
        int max = mass[0][0];
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                if(max < mass[i][j]){
                    max = mass[i][j];
                }

            }

        }
        TreeSet<Integer> line = new TreeSet<>();
        TreeSet<Integer> column = new TreeSet<>();

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                if(max == mass[i][j]){
                    line.add(i);
                    column.add(j);
                }
            }
        }

        int[][] massMin = new int[n-line.size()][n-column.size()];
        int line2 = 0;
        for (int i = 0; i < n ; i++) {
            int lin = 0;
            for (Integer li: line) {
                if(li == i) {
                    lin +=1;
                }
            }
            if(lin == 0 ){
                int column2 = 0;
                for (int j = 0; j < n ; j++) {

                    int colu = 0;
                    for (Integer col: column){
                        if(col == j){
                            colu +=1;
                        }
                    }
                    if(colu == 0){
                        massMin[line2][column2] = mass[i][j];
                        column2 +=1;
//                        System.out.println("column2 " + column2);

                    }
                }
                line2 +=1;
//                System.out.println("line2 " + line2);
            }
        }
        for (int i=0; i<n-1; i++) {
            for (int j=0; j<n-1; j++) {
                System.out.print(mass[i][j]+" ");
            }
            System.out.println();
        }
        for (int i=0; i<n-1; i++) {
            for (int j=0; j<n-1; j++) {
                System.out.print(massMin[i][j]+" ");
            }
            System.out.println();
        }

    }
}
