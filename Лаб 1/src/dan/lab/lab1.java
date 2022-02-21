package dan.lab;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class lab1 {
    public static void main(String[] args){
        System.out.println("ВАРИАНТ 1 № 3");
        Scanner in = new Scanner(System.in);
        System.out.print("Введите положительное число - ");
        int n = in.nextInt();
        System.out.printf("Ваше число: %d \n", n);

        String str[] = new String[n];
        String[] rand = {"Один","Два", "Три", "Четыре","Пять","Шесть"};
        int rand_num=0;

        for (int i=0; i !=n; i++)
        {
            rand_num = (int) (Math.random()*6);
            str[i] = rand[rand_num];
        }
        System.out.println("Сгенерированные строки:" + Arrays.toString(str));
        System.out.println("Вывод строк друг за другом, через пробел");
        for (int i=0;i!=n;i++)
        {
            System.out.print(str[i]+" ");
        }
        System.out.println("\nВывод строк через \\n");
        for (int i=0;i!=n;i++)
        {
            System.out.println(str[i]);
        }
        System.out.println("\n\nВАРИАНТ 1 № 4");
        boolean flag = true;
        int tryings = 0;
        while (flag) {
            int pass_num = (int) (Math.random() * 10000);
            String pass = "Qwerty" + pass_num;
            System.out.println("Введите ваш пароль. В конце (без пробела) добавьте проверочный код: " + pass_num);
            System.out.print("Пароль:");
            String vvod = in.next();
            if (pass.equals(vvod)) {
                System.out.println("Пароль введён верно");
                flag = false;
            } else {
                tryings++;

                if (tryings > 5)
                {
                    System.out.println("Вы ввели пароль не верно 5 раз. Страница авторизации закрывается.");
                    flag = false;
                } else
                {
                    System.out.println("Пароль введён не верно. Осталось попыток:"+ (5 - tryings));
                }
            }
        }
        

    }
}
