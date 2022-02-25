package daniil.lab;
import java.util.Scanner;
import java.util.Random;

public class lab3_2 {

    public static class Product {
        //Наименование, UPC, Производитель, Цена, Срок хранения, Количество
        String name, creator;
        boolean upc;
        double cost;
        int safe_day, count;

        public Product(String name, String creator, boolean upc, double cost, int safe_day, int count) {
            this.name = name;
            this.creator = creator;
            this.upc = upc;
            this.cost = cost;
            this.safe_day = safe_day;
            this.count = count;
        }

        public Product() {
            System.out.println("Добавление нового продукта в базу");
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            System.out.print("Наименование - ");
            this.name = in.nextLine();
            System.out.print("Производитель - ");
            this.creator = in.nextLine();
            System.out.print("UPS (T|F) - ");
            this.upc = in.nextBoolean();
            System.out.print("Цена - ");
            this.cost = in.nextInt();
            System.out.print("Срок хранения (суток) - ");
            this.safe_day = in.nextInt();
            System.out.print("Количество - ");
            this.count = in.nextInt();
        }

        public void Product_print() {
            System.out.println("Информация о продукте:");
            System.out.printf("Наименование - %s\nПроизоводитель - %s\nUPS - %b\nЦена - %f\nСрок хранения - %d\n" +
                    "Количество - %d\n", this.name, this.creator, this.upc, this.cost, this.safe_day, this.count);
            System.out.println("");
        }

        public static Product[] Pr_mass_create(int n) {
            Product[] mass = new Product[n];
            Random r = new Random();
            String[] rand_creator = {"KIA", "HYUNDAI", "AUDI", "BMW", "NISSAN"};
            String[] rand_name = {"K5", "SOLARIS", "RS6", "X7", "X-TRAIL"};
            for (int i = 0; i != n; i++) {
                mass[i] = new Product(rand_name[r.nextInt(4)], rand_creator[r.nextInt(4)], false, r.nextDouble() * 100, i * i + 1, i + 10);
            }
            return mass;
        }

        public static void select(Product[] mass, int n, String name, int cost, int safe_day) {
            for (int i = 0; i != n; i++) {
                if (!name.equals("") && cost == 0) {
                    if (mass[i].name.equals(name)) {
                        mass[i].Product_print();
                    }
                }
                if (!name.equals("") && cost > 0) {
                    if (mass[i].name.equals(name) && mass[i].cost <= cost) {
                        mass[i].Product_print();
                    }
                }
                if (name.equals("") && cost == 0 && safe_day > 0) {
                    if (mass[i].safe_day > safe_day) {
                        mass[i].Product_print();
                    }
                }
            }
        }

    }

    public static class Train {
        //Пункт назначения, Номер поезда, Время отправления, Число мест (общих, купе, плацкарт, люкс)
        String arrival;
        int train_no;
        int time_out;
        int total_place, kupe_place, pla_place, luxe_place;

        public Train() {
            String[] arriaval_places = {"Омкс", "Рязань", "Москва", "Питер", "Надым", "Тула", "Колыма"};
            Random r = new Random();
            this.arrival = arriaval_places[r.nextInt(6)];
            this.train_no = r.nextInt(10000) + 1;
            this.time_out = r.nextInt(23) + 1;
            this.kupe_place = r.nextInt(40);
            this.pla_place = r.nextInt(100) + 1;
            this.luxe_place = r.nextInt(25);
            this.total_place = this.kupe_place + this.pla_place + this.luxe_place;

        }

        public void Tr_print() {
            System.out.println("Инфрмация о поезде:");
            System.out.printf("Пункт названчения - %s\nНомер поезда - %d\nЧас отправления - %d\nОбщее число мест - %d\nМеста купе - %d\n" +
                    "Места плацкарт - %d\nМеста люкс - %d\n\n", this.arrival, this.train_no, this.time_out, this.total_place, this.kupe_place, this.pla_place, this.luxe_place);

        }

        public static Train[] create_mass(int n) {
            Train[] mass = new Train[n];
            for (int i = 0; i != n; i++) {
                mass[i] = new Train();
            }
            return mass;
        }
        public static void select(Train[] mass, int n, String arrival, int time_out, int total_place)
        {
            for (int i=0; i!=n; i++)
            {
                if (time_out == 0 && total_place == 0)
                {
                    if (mass[i].arrival.equals(arrival))
                    {
                        mass[i].Tr_print();
                    }
                }else if (time_out > 0 && total_place == 0)
                {
                    if (mass[i].time_out > time_out && mass[i].arrival.equals(arrival))
                    {
                        mass[i].Tr_print();
                    }
                } else
                {
                    if (mass[i].total_place > total_place && mass[i].arrival.equals(arrival))
                    {
                        mass[i].Tr_print();
                    }

                }
            }
        }

    }
    public static void main(String[] args) {
        int n=8;
        System.out.println("Вариант 2 №9");
        Product[] mass;
        mass = Product.Pr_mass_create(n);
        for (int i=0; i!=n;i++)
        {

            mass[i].Product_print();
        }
        System.out.println("Запрос поиска (а) Поиск K5");
        Product.select(mass, n, "K5",0,0);
        System.out.println("Запрос поиска (б) Поиск K5 стоимостью меньше 50");
        Product.select(mass, n, "K5",50,0);
        System.out.println("Запрос поиска (с) срок хранения больше 10");
        Product.select(mass, n, "",0,10);
        System.out.println("\nВариант 2 №10");
        Train[] masstr;
        masstr = Train.create_mass(n);
        for (int i=0; i!=n;i++)
        {
            masstr[i].Tr_print();
        }
        System.out.println("Запрос (а) список поездов, следующих до заданного пункта назначения");
        Train.select(masstr,n,"Москва",0,0);
        System.out.println("Запрос (б) список поездов, следующих до заданного пункта назначения и отправляющихся после заданного часа");
        Train.select(masstr,n,"Питер",10,0);
        System.out.println("Запрос (с) список поездов, отправляющихся до заданного пункта назначения и имеющих общие места");
        Train.select(masstr,n,"Надым",0,100);




    }
}
