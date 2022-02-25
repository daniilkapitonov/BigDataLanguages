package dan.lab;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Arrays;
import java.util.Random;

public class lab3_1 {
    public static class kv_yr
    {
        int a,b,c;
        double x1,x2;
        public kv_yr(int a, int b, int c)
        {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        public kv_yr(int x)
        {
            Random r = new Random();
            this.a =  r.nextInt(12);
            this.b =  r.nextInt(12);
            this.c =  r.nextInt(12);
            this.x1 = x;
        }

        public void kv_print()
        {
            System.out.printf("Уравнение имеет вид: %d*x^2+%d*x+%d=0\n",this.a, this.b,this.c);
        }
        public String kv_korni()
        {
            double d,x1,x2;
            String result;
            d = Math.pow(this.b,2) - 4*this.a*this.c;
            if (d<0)
            {
                result = "У уравнения отсутствуют корни";
                this.x1 = 666;
                this.x2 = 666;
            } else if (d == 0)
            {
                x1 = (-b+Math.sqrt(d))/(2*this.a);
                result = "Корень уравнения = " + x1;
                this.x1 = x1;
                this.x2 = this.x1;
            } else
            {
                this.x1 = (-b+Math.sqrt(d))/(2*this.a);
                this.x2 = (-b-Math.sqrt(d))/(2*this.a);
                result = "Корни уравнения: " + this.x1+" "+this.x2;


            }

            return result;
        }
        public String kv_voz_yb()
        {
            String result;

            result = "Экстремум функции находится в точке - " + -this.b/this.a+"\n";
            result += "Функция возрастает на промежутки от минус бесконечности до "+ -this.b/this.a+ " и убывает начиная с " + -this.b/this.a + " до + бесконечнгсти";
            return result;
        }
    }
    public static class BoolMatrix {
        int n;
        int m;
        int true_count;
        boolean[][] matrix;

        public BoolMatrix(int n, int m) {
            Random r = new Random();
            this.n = n;
            this.m = m;
            this.matrix = new boolean[n][m];
            for (int i = 0; i != n; i++) {
                for (int j = 0; j != m; j++) {
                    this.matrix[i][j] = r.nextBoolean();
                    if (this.matrix[i][j] == true)
                    {
                        this.true_count++;
                    }
                }
            }
        }
        public BoolMatrix() {
            Random r = new Random();
            this.n = r.nextInt(10)+1;
            this.m = r.nextInt(10)+1;
            this.matrix = new boolean[n][m];
            for (int i = 0; i != n; i++) {
                for (int j = 0; j != m; j++) {
                    this.matrix[i][j] = r.nextBoolean();
                    if (this.matrix[i][j] == true)
                    {
                        this.true_count++;
                    }
                }
            }
        }
        public void m_print()
        {
            System.out.printf("\nМатрица размерностью %d на %d\n", this.n, this.m);
            for (int i=0; i!=this.n; i++)
            {
                for (int j=0;j!=this.m;j++)
                {
                    System.out.printf("%2b\t", this.matrix[i][j]);
                }
                System.out.println("");
            }
            System.out.printf("В матрицы содержиться %d элемента(ов) равных 1\n", this.true_count);
        }
        public static void m_summ(BoolMatrix m1, BoolMatrix m2)
        {
            System.out.println("\nЛогическое сложение матриц");
            for (int i=0;i!=m1.n;i++)
            {
                for (int j=0; j!=m1.m; j++)
                {
                    System.out.printf("%1b\t", m1.matrix[i][j] | m2.matrix[i][j]);
                }
                System.out.println("");
            }
        }
        public static void m_umn(BoolMatrix m1, BoolMatrix m2)
        {
            System.out.println("\nЛогическое умножение матриц");
            for (int i=0;i!=m1.n;i++)
            {
                for (int j=0; j!=m1.m; j++)
                {
                    System.out.printf("%1b\t", m1.matrix[i][j] & m2.matrix[i][j]);
                }
                System.out.println("");
            }
        }
        public void m_invers()
        {
            System.out.println("\nИнверсия матрицы\nБыло:");
            this.m_print();
            for (int i=0; i!=this.n; i++)
            {
                for (int j=0; j!=this.m; j++)
                {
                    this.matrix[i][j] = !this.matrix[i][j];
                }
            }

            System.out.println("Стало:");
            this.tr_count();
            this.m_print();

        }
        public void tr_count()
        {
            this.true_count =0;
            for (int i = 0; i != n; i++) {
                for (int j = 0; j != m; j++) {
                    if (this.matrix[i][j])
                    {
                        this.true_count++;
                    }
                }
            }
        }
        public void b_sort()
        {
            System.out.println("\nСортировка матрицы в лексикографическом порядке\nБыло:");
            this.m_print();
            boolean[] cash = new boolean[this.m];
            int count_1=0, count_2=0;
            for (int ii=0;ii!=this.n;ii++) {
                for (int i = 0; i != this.n - 1; i++) {
                    for (int j = 0; j != this.m; j++) {
                        if (this.matrix[i][j]) {
                            count_1 += (int) Math.pow(this.m - j, 2);
                        }
                        if (this.matrix[i + 1][j]) {
                            count_2 += (int) Math.pow(this.m - j, 2);
                        }
                    }
                    if (count_1 < count_2) {
                        for (int n = 0; n != this.m; n++) {
                            cash[n] = this.matrix[i][n];
                        }
                        for (int n = 0; n != this.m; n++) {
                            this.matrix[i][n] = this.matrix[i + 1][n];
                        }
                        for (int n = 0; n != this.m; n++) {
                            this.matrix[i + 1][n] = cash[n];
                        }
                    }
                    count_1 = 0;
                    count_2 = 0;
                }
            }
            System.out.println("Стало:");
            this.m_print();
        }
    }

    public static void main(String[] args) {
        System.out.println("Вариант 1 №9");
        kv_yr n = new kv_yr(1,3,-4);
        n.kv_print();
        System.out.println(n.kv_korni());
        System.out.println(n.kv_voz_yb());
        int m=2;
        kv_yr[] mass = new kv_yr[m];
        Random r = new Random();
        double max=0, min=9999999;
        for (int i=0; i!=m; i++)
        {
            mass[i] = new kv_yr(r.nextInt(20)+1,r.nextInt(20)+1,r.nextInt(20)-21);
            //mass[i].kv_print();
            System.out.println(mass[i].kv_korni());
            if (mass[i].x1>max && mass[i].x1!=666)
            {
                max = mass[i].x1;
            }
            if (mass[i].x1<min && mass[i].x1!=666)
            {
                min = mass[i].x1;
            }

        }
        System.out.println("Максимальный корень x1 = "+max+". Минимальный корень x1 = "+min);

        System.out.println("\nВариант 1 №10");
        BoolMatrix m_1 = new BoolMatrix(6,6);
        m_1.m_print();
        BoolMatrix m_2 = new BoolMatrix(6,6);
        m_2.m_print();
        BoolMatrix.m_summ(m_1,m_2);
        BoolMatrix.m_umn(m_1,m_2);
        m_1.m_invers();
        m_1.b_sort();






    }
}
