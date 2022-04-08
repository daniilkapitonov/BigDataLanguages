package dan.lab;
//
//9.	Дана матрица из целых чисел. Найти в ней прямоугольную подматрицу,
//        состоящую из максимального количества одинаковых элементов. Использовать класс Stack.
//
//        10.	На прямой гоночной трассе стоит N автомобилей, для каждого из которых
//        известны начальное положение и скорость. Определить, сколько произойдет обгонов.
//

import com.sun.org.apache.xalan.internal.xsltc.trax.SmartTransformerFactoryImpl;

import java.util.*;

public class Lab9_10_2 {

    public static void main(String[] args) {
        System.out.println("Вариант 2№9");
        int n = 5;
        HashSet<Integer> num_list = new HashSet<>();
        int[][] mass = new int[n][n];
        Stack<Integer> matr_stack = new Stack<>();
        for (int i = 0; i != n; i++) {
            for (int j = 0; j != n; j++) {
                mass[i][j] = (int) (Math.random() * 3 + 1);
                System.out.print(mass[i][j] + " ");
                matr_stack.push(mass[i][j]);
                num_list.add(mass[i][j]);
            }
            System.out.println("");
        }
        System.out.println("Num_list = " + num_list);
        System.out.println("Matr_stack = " + matr_stack);
        System.out.println(matr_stack.search(3));
        int[] max_p_i_j_c = new int[3];
        max_p_i_j_c[0] = 0;
        max_p_i_j_c[1] = 0;
        max_p_i_j_c[2] = 0;
        for (int num_add_i = 0; num_add_i != n + 1; num_add_i++) {
            for (int num_add_j = 0; num_add_j != n + 1; num_add_j++) {
                int[] mass_numbers_c = new int[3];
                if (num_add_i != n || num_add_j != n) {
                    for (int i = 0; i != num_add_i; i++) {
                        for (int j = 0; j != num_add_j; j++) {
                            switch (mass[i][j]) {
                                case 1:
                                    mass_numbers_c[0]++;
                                    break;
                                case 2:
                                    mass_numbers_c[1]++;
                                    break;
                                case 3:
                                    mass_numbers_c[2]++;
                                    break;
                            }

                            System.out.print(mass[i][j] + " ");
                        }
                        System.out.println("");
                    }
                    System.out.println(num_add_i + " " + num_add_j);
                    System.out.println(Arrays.toString(mass_numbers_c));
                    int max = Math.max(Math.max(mass_numbers_c[0], mass_numbers_c[1]), Math.max(mass_numbers_c[1], mass_numbers_c[2]));
                    if (max > max_p_i_j_c[2]) {
                        max_p_i_j_c[2] = max;
                        max_p_i_j_c[0] = num_add_i;
                        max_p_i_j_c[1] = num_add_j;
                    }
                }
            }

        }
        System.out.println(Arrays.toString(max_p_i_j_c));

        for (int i = 0; i != max_p_i_j_c[0]; i++) {
            for (int j = 0; j != max_p_i_j_c[1]; j++) {
                System.out.print(mass[i][j] + " ");

            }
            System.out.println("");
        }
        System.out.println("Вариант 2№10");
        int road_lenght =  (int)(Math.random()*2000+1000);
        System.out.println("Длинна трассы = "+ road_lenght);
        ArrayList<Car> car_mass = new ArrayList<>();
        for (int i=0; i!=n; i++){
            car_mass.add(new Car((int)(Math.random()*16+100),(int)(Math.random()*2+10),(int)(Math.random()*2+20), road_lenght));
        }
        System.out.println(car_mass);
        int count =0;
        for (int i=0; i!=n; i++){
            for (int j=0; j!=n; j++){
                if (car_mass.get(i).time_for_road > car_mass.get(j).time_for_road){
                    count++;
                }
            }
        }
        System.out.println("Кол-во обгонов = "+ count);



    }

    public static class Car{
        int speed;
        int length;
        int leng_from_start;
        double time_for_road;

        public Car(int speed, int length, int leng_from_start, int road_lenght) {
            this.speed = speed;
            this.length = length;
            this.leng_from_start = length + leng_from_start;
            this.time_for_road = time_count(this.speed, road_lenght);

        }

        public double time_count(int speed, int road_lenght){
            return (double) road_lenght/ (double)speed;
        }


        @Override
        public String toString() {
            return "Car{" +
                    "speed=" + speed +
                    ", length=" + length +
                    ", leng_from_start=" + leng_from_start +
                    ", time_for_road=" + time_for_road +
                    '}';
        }
    }


}
