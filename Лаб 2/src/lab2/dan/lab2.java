package lab2.dan;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class lab2 {
    public static void print(int k, String interval, boolean check)
    {
        if (check)
        {
            System.out.printf("Число %d принадлежит интервалу %s", k, interval);
        } else
        {
            System.out.printf("Число %d не принадлежит интервалу %s", k, interval);
        }
        System.out.println();
    }
    public static void print_mass(int mass[][], int n)
    {
        for (int i=0; i!=n;i++)
        {
            for (int j=0; j!=n; j++)
            {
                System.out.printf("%3d\t", mass[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        System.out.println("Вариант 1 №9, 10");
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число k - ");
        int k = in.nextInt();
        System.out.println("Вводите интервалы для проверки. Для завершения проверки введите stop.");
        boolean check = true;
        while (check)
        {
            String str = in.nextLine();
            switch (str)
            {
                case "(-10k, 0]":
                    if (k > -10000 && k<=0)
                    {
                        print(k,"(-10k, 0]", true);
                    } else
                    {
                        print(k,"(-10k, 0]", false);
                    }
                    break;
                case "(0, 5]":
                    if (k > 0 && k<=5)
                    {
                        print(k,"(0, 5]", true);
                    } else
                    {
                        print(k,"(0, 5]", false);
                    }
                    break;
                case "(5, 10]":
                    if (k > 5 && k<=10)
                    {
                        print(k,"(5, 10]", true);
                    } else
                    {
                        print(k,"(5, 10]", false);
                    }
                    break;
                case "(10, 10k]":
                    if (k > 10 && k<=10000)
                    {
                        print(k,"(10, 10k]", true);
                    } else
                    {
                        print(k,"(10, 10k]", false);
                    }
                    break;
                case "(-10k, 5]":
                    if (k > -10000 && k<=5)
                    {
                        print(k,"(-10k, 5]", true);
                    } else
                    {
                        print(k,"(-10k, 5]", false);
                    }
                    break;
                case "[0, 10]":
                    if (k >= 0 && k<=10)
                    {
                        print(k,"[0, 10]", true);
                    } else
                    {
                        print(k,"[0, 10]", false);
                    }
                    break;
                case "[5, 15]":
                    if (k >= 5 && k<=15)
                    {
                        print(k,"[5, 15]", true);
                    } else
                    {
                        print(k,"[5, 15]", false);
                    }
                    break;
                case "[10, 10k]":
                    if (k >= 10 && k<=10000)
                    {
                        print(k,"[10, 10k]", true);
                    } else
                    {
                        print(k,"[10, 10k]", false);
                    }
                    break;
                case "stop":
                    check = false;
                    break;


            }
        }
        System.out.println("\nВариант 2 №9");
        System.out.print("Введите размерность матрицы - ");
        int n = in.nextInt();
        int[][] a = new int[n][n];
        Random r = new Random();
        for (int i=0; i!=n;i++)
        {
            for (int j=0; j!=n; j++)
            {
                a[i][j] = (r.nextInt(n*2) - n);
            }
        }
        print_mass(a,n);
        double sr_ar = 0.0;
        for (int i=0; i!=n; i++)
        {
            for (int x=0;x!=n;x++)
            {
                sr_ar += a[i][x];
            }
            sr_ar/=n;
            for (int j=0; j!=n; j++)
            {
               a[i][j] -= sr_ar;
            }
        }
        System.out.println("Новая матрица");
        print_mass(a,n);
        System.out.println("\nВариант 2 №10");
        int[] max_x = new int[n*n];
        int[] max_y = new int[n*n];
        int max = 0;
        int max_i=0;
        for (int i=0; i!=n; i++)
        {
            for (int j=0;j!=n;j++)
            {
                if (a[i][j] >= max)
                {
                    max = a[i][j];
                    max_x[max_i] = i;
                    max_y[max_i] = j;
                    if (a[i][j] == max && max_x[max_i]!=i)
                    {
                        max_i++;
                        max_x[max_i] = i;
                        max_y[max_i] = j;
                    }
                }
            }
        }
        max_i++;
        for (int i=0;i!=n*n;i++)
        {
            if (max_x[i] == 0)
            {
                max_x[i] += n*n;
                max_y[i] += n*n;
            }
        }
        System.out.println(max_i+Arrays.toString(max_x)+" "+Arrays.toString(max_y));
        int[][] new_a = new int[n-max_i][n-max_i];
        int new_i=0, new_j=0;

        for (int i=0;i!=n;i++)
        {
            if (Arrays.binarySearch(max_x, i) < 0)
            {
                for (int j = 0; j != n; j++) {
                    //System.out.printf("x = %d, y = %d\n", Arrays.binarySearch(max_x, i), (Arrays.binarySearch(max_y, j)));
                    if (Arrays.binarySearch(max_y, j) < 0 && (Arrays.binarySearch(max_x, i) < 0)) {
                        //System.out.printf("В массив добавлен элемент %d, x = %d, y= %d\n", a[i][j], new_i, new_j);
                        new_a[new_i][new_j] = a[i][j];
                        new_j++;
                    }
                }
                new_j = 0;
                new_i++;
            }
        }
        System.out.println("Новый массив");
        print_mass(new_a, n-max_i);
    }

}
