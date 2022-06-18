package dan.lab1_2;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class lab1_2 {
    public static void main(String[] args){
        System.out.println("ВАРИАНТ 2 № 9");
        System.out.print("Введите кол-во элементов массива - ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] mass = new int[n];
        int[] mass_cash  = new int[n];
        int cash = 0;
        System.out.printf("Введите %d элементов массива \n", n);
        for (int i=0;i!=n;i++)
        {
            int num = in.nextInt();
            mass[i] = num;
            mass_cash[i] = num;

        }

        System.out.println("Массив без сортировки");
        for  (int i=0; i!=n; i++)
        {
            System.out.printf("%d эелмент массива равен числу - %d\n", i, mass[i]);
        }
        for (int i=0; i!=n;i++)
        {
            for (int j=0;j!=n; j++)
            {
                if (mass_cash[i]>mass_cash[j])
                {
                    cash = mass_cash[i];
                    mass_cash[i] = mass_cash[j];
                    mass_cash[j] =  cash;
                }
            }
        }
        Arrays.sort(mass);
        System.out.println("Массив сортировка по возрастанию " + Arrays.toString(mass));
        System.out.println("Массив сортировка по убыванию " + Arrays.toString(mass_cash));
        System.out.println("\nВАРИАНТ 2 № 10");
        int[] mass_count = new int[n];
        for (int i=0; i!=n;i++)
        {
            for (int j=0; j!=n; j++)
            {
                if (mass[i]==mass[j])
                {
                    mass_count[i]++;
                }
            }
        }
        for (int i=0; i!=n;i++)
        {
            for (int j=0; j!=n; j++)
            {
                if (mass_count[i]>mass_count[j])
                {
                    cash = mass_count[i];
                    mass_count[i] = mass_count[j];
                    mass_count[j] = cash;
                    cash = mass[i];
                    mass[i] = mass[j];
                    mass[j] = cash;
                }
            }
        }
        System.out.println("Массив в порядке убывания частоты встречаемости чисел " + Arrays.toString(mass));



    }
}
