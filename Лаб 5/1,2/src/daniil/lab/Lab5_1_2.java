package daniil.lab;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedMap;

//1.	Создать класс City (город)
//        с внутренним классом, с помощью объектов которого можно хранить информацию о проспектах,
//        улицах, площадях.
public class Lab5_1_2 {
    public static class City{
        String name;
        ArrayList<Street> street_list;

        public City() {
            street_list = new ArrayList<>();
        }

        public City(String name) {
            this.name = name;
            street_list = new ArrayList<>();
        }
        public void new_street(String name, boolean square, boolean prospect, boolean street){
            Street cash = new Street(name, square, prospect, street);
            if (cash.name.equals("error")){
                System.out.println("Новая улица не была добавлена");
            }else{
                street_list.add(cash);
            }
        }
        public String delenie(int n1, int n2){
            try{
                return Float.toString(n1/n2);
            } catch (Exception er){
                return "Воникла ошибка - "+ er.getMessage();
            }
        }
        public static String check_null(City c){
            return "Объект пустой? - "+Boolean.toString(c==null);
        }
        @Override
        public String toString() {
            return "City{" +
                    "name='" + name + '\'' +
                    ", street_list=" + street_list +
                    '}';
        }

        public static class Street{
            String name;
            boolean square;
            boolean prospect;
            boolean street;

            public Street(String name, boolean square, boolean prospect, boolean street) {
                if (!square && !prospect && !street){
                    System.out.println("Ошибка ввода названия улицы. Не выбран ни один её тип.");
                    this.name = "error";
                } else{
                    this.name = name;
                    this.square = square;
                    this.prospect = prospect;
                    this.street = street;
                }
            }

            public Street() {
            }

            @Override
            public String toString() {
                return "Street{" +
                        "name='" + name + '\'' +
                        ", square=" + square +
                        ", prospect=" + prospect +
                        ", street=" + street +
                        '}';
            }
        }
    }
    interface Furniture{
        public String getname();
    }

    public static abstract class Wardrobe implements Furniture{
        String name;
        int cost;
        public String getname(){
            return this.name;
        }

        public Wardrobe() {
        }

        public Wardrobe(String name, int cost) {
            if (name.equals("") || cost == 0){
                System.out.println("Введеные пустые или нулевые значения книги");
            } else {
                this.name = name;
                this.cost = cost;
            }

        }
        public void test(){
            System.out.println("Test");
        }

        @Override
        public String toString() {
            return "Wardrobe{" +
                    "name='" + name + '\'' +
                    ", cost=" + cost +
                    '}';
        }
    }
    public static class Book_war extends Wardrobe{
        @Override
        public void test(){
            System.out.println("Book");
        }

        public Book_war(String name, int cost) {
            super(name, cost);
        }

        public Book_war() {
        }
    }
    public static void main(String[] args) {
        City SPB = new City("Piter");
        SPB.new_street("Войковская", true, false, false);
        SPB.new_street("Чеборская", false, false, false);
        System.out.println(SPB.toString());
        System.out.println(City.check_null(SPB));
        System.out.println(SPB.delenie(1,0));
        System.out.println(SPB.delenie(1,1));

        Book_war ward = new Book_war("Onegin", 12);
        System.out.println(ward.toString());
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название книги и её стоимость");

        try{
            System.out.print("Название - ");
            String name = in.nextLine();
            System.out.print("Цена - ");
            int cost = in.nextInt();
            Book_war t_ward = new Book_war(name, cost);
            System.out.println(t_ward.toString());
        } catch (Exception er){
            System.out.println("Введены не корректные данные - "+er.getMessage());
            Book_war t_ward = new Book_war();
        }




    }
}
