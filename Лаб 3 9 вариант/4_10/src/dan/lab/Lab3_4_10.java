package dan.lab;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab3_4_10 {
    public static class Passanger implements Serializable{
        private String FIO;
        private int balance;
        public ArrayList<Passanger> pas_list;

        public Passanger(String FIO, int balance) {
            this.FIO = FIO;
            this.balance = balance;
        }

        public Passanger() {
            pas_list = new ArrayList<>();
        }

        @Override
        public String toString() {
            return "passanger{" +
                    "FIO='" + FIO + '\'' +
                    ", balance=" + balance +
                    '}';
        }

        public String toString(int n) {
            if (n!=-1) {
                return "passanger{" +
                        "FIO='" + pas_list.get(n).FIO + '\'' +
                        ", balance=" + pas_list.get(n).balance +
                        '}';
            }else{
                return "Пассажир не найден";
            }
        }

        public void add_pas(String FIO, int balance){
            Passanger cash = new Passanger(FIO, balance);
            this.pas_list.add(cash);
        }

        public int search_pas(String name){
            for (int i=0;i!=this.pas_list.size();i++){
                if (this.pas_list.get(i).FIO.equals(name)){
                    return i;
                }
            }
            return -1;
        }

        public void add_money_pass(int value){
            this.balance+=value;
        }
    }

    public static class Train implements Serializable{
        private String depin;
        private String depout;
        private int day;
        private int t_out;
        private int t_in;
        private int cost;
        ArrayList<Train> train_list;

        public Train(String depin, String depout, int day, int t_out, int t_in, int cost) {
            this.depin = depin;
            this.depout = depout;
            this.day = day;
            this.t_out = t_out;
            this.t_in = t_in;
            this.cost = cost;
        }

        public Train() {
            train_list = new ArrayList<>();
        }

        @Override
        public String toString() {
            return "train{" +
                    "depin='" + depin + '\'' +
                    ", depout='" + depout + '\'' +
                    ", day=" + day +
                    ", t_out=" + t_out +
                    ", t_in=" + t_in +
                    ", cost=" + cost +
                    '}';
        }
        public String toString(int n) {
            if (n!=-1) {
                return "train{" +
                        "depin='" + train_list.get(n).depin + '\'' +
                        ", depout='" + train_list.get(n).depout + '\'' +
                        ", day=" + train_list.get(n).day +
                        ", t_out=" + train_list.get(n).t_out +
                        ", t_in=" + train_list.get(n).t_in +
                        ", cost=" + train_list.get(n).cost +
                        '}';
            }else
            {
                return "Такого поезда нет";
            }
        }

        public void add_train(String depin, String depout, int day, int t_out, int t_in, int cost){
            Train cash = new Train(depin, depout, day, t_out, t_in, cost);
            this.train_list.add(cash);
        }

        public int searchg_train(String depout, int t_out){
            for(int i=0; i!=this.train_list.size();i++){
                if (this.train_list.get(i).depout.equals(depout) && this.train_list.get(i).t_out==t_out){
                    return i;
                }
            }
            return -1;
        }


    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Вариант 4 №10");


        Passanger c_pass = new Passanger();
        c_pass.add_pas("Вася", 10000);
        FileOutputStream pass_file_w = new FileOutputStream("passobj.txt");
        ObjectOutputStream passobj_w = new ObjectOutputStream(pass_file_w);
        passobj_w.writeObject(c_pass);
        passobj_w.close();

        Train c_train = new Train();
        c_train.add_train("Питер","Москва",4,6,20,1200);
        FileOutputStream train_file_w = new FileOutputStream("trainobj.txt");
        ObjectOutputStream trainobj_w = new ObjectOutputStream(train_file_w);
        trainobj_w.writeObject(c_train);
        trainobj_w.close();

        FileInputStream pass_file = new FileInputStream("passobj.txt");
        ObjectInputStream passobj = new ObjectInputStream(pass_file);
        Object cash_i = passobj.readObject();
        Passanger passangers = (Passanger) cash_i;
        passobj.close();
        System.out.println("Пассажиры загружены");

        FileInputStream train_file = new FileInputStream("trainobj.txt");
        ObjectInputStream trainobj = new ObjectInputStream(train_file);
        Object cash_c = trainobj.readObject();
        Train trains = (Train) cash_c;
        trainobj.close();
        System.out.println("Поезда загружены");
        while (true) {
        Scanner in_1 = new Scanner(System.in);
        System.out.println("Вы пассажир или администратор? 1 - пассажир, 2 - администратор, 3 - выйти");
        int who = in_1.nextInt();
        String p_name="";
        int p_id = 0;

            while (who != 3 && who != 55 && who != 66) {
                Scanner in = new Scanner(System.in);
                switch (who) {
                    case 1:
                        System.out.println("Пассажир, введите своё имя");
                        p_name = in.nextLine();
                        p_id = passangers.search_pas(p_name);
                        if (p_id != -1) {
                            System.out.println("Добро пожаловать!");
                            who = 55;
                        } else {
                            who = -1;
                        }
                        System.out.println(passangers.toString(p_id));
                        break;
                    case 2:
                        System.out.println("Введите пароль");
                        if (in.nextLine().equals("123")) {
                            System.out.println("Успешно");
                            who = 66;
                        } else {
                            System.out.println("Пароль введён не верно");
                            who = -1;
                        }
                        break;
                    case 3:
                        who = 3;
                    default:
                        System.out.println("Такого пункта меню нет в списке");
                        who = -1;
                }
                if (who == -1) {
                    System.out.println("Вы пассажир или администратор? 1 - пассажир, 2 - администратор, 3 - выйти");
                    who = in.nextInt();

                }
            }

            if (who != 3) {
                System.out.println("Добро пожаловать в систему покупки билетов");
                boolean check = true;
                while (check) {
                    if (who == 55) {
                        System.out.println("Пассажир, выбери пункт меню для совершения действий\n1 - купить билет, 2 - пополнить балланс, 3 - выйти");
                        Scanner in_p = new Scanner(System.in);
                        switch (Integer.parseInt(in_p.nextLine())) {
                            case 1:
                                System.out.println("Введите город отправления и время отправления");
                                in_p.reset();
                                String city = in_p.nextLine();
                                int t_out = Integer.parseInt(in_p.nextLine());
                                System.out.println("Информация о поезде");
                                int tr_id = trains.searchg_train(city, t_out);
                                System.out.println(trains.toString(tr_id));
                                System.out.println("Купить билет на этот поезд? 1 - да, 2 - нет");
                                switch (in_p.nextLine()) {
                                    case "1":
                                        if (passangers.pas_list.get(p_id).balance >= trains.train_list.get(tr_id).cost) {
                                            passangers.pas_list.get(p_id).balance -= trains.train_list.get(tr_id).cost;
                                            System.out.println("Покупка совершена");
                                        } else {
                                            System.out.println("У вас недостаточно средств");
                                        }
                                        break;
                                    case "2":
                                        System.out.println("Отмена покупки");
                                        break;
                                    default:
                                        System.out.println("Такого пункта меню нет");
                                        break;
                                }
                                break;
                            case 2:
                                System.out.println("Введите сумму поплнения");
                                int value = Integer.parseInt(in_p.nextLine());
                                passangers.pas_list.get(p_id).add_money_pass(value);
                                System.out.println(passangers.pas_list.get(p_id).toString());
                            case 3:
                                check = false;
                                break;
                            default:
                                System.out.println("Такого пункта меню нет");
                                break;
                        }
                    } else {
                        System.out.println("Администратор, выбери пункт меню для совершения действий\n1 - добавить поезд, 2 - посмотрет информацию о поезде, 3 - выйти");
                        Scanner in_a = new Scanner(System.in);
                        switch (in_a.nextLine()) {
                            case "1":
                                System.out.println("Введите:");
                                System.out.print("Место прибытия - ");
                                String d_in = in_a.nextLine();
                                System.out.print("Место отбытия - ");
                                String d_out = in_a.nextLine();
                                System.out.print("День отправки - ");
                                int day = Integer.parseInt(in_a.nextLine());
                                System.out.print("Время отправки - ");
                                int t_out = Integer.parseInt(in_a.nextLine());
                                System.out.print("Время прибытия - ");
                                int t_in = Integer.parseInt(in_a.nextLine());
                                System.out.print("Стоимость - ");
                                int cost = Integer.parseInt(in_a.nextLine());
                                trains.add_train(d_in, d_out, day, t_out, t_in, cost);
                                System.out.println("Новый рейс успешно добавлен");
                                System.out.println(trains.train_list.get(trains.searchg_train(d_out, t_out)).toString());
                                break;
                            case "2":
                                System.out.println("Введите:");
                                System.out.print("Место отбытия - ");
                                d_out = in_a.nextLine();
                                System.out.print("Время отправки - ");
                                t_out = Integer.parseInt(in_a.nextLine());
                                System.out.println(trains.train_list.get(trains.searchg_train(d_out, t_out)).toString());
                                break;
                            case "3":
                                check = false;
                                break;
                            default:
                                System.out.println("Такого пункта меню нет");
                                break;
                        }
                    }
                }
            }


//            //passanger c_pass = new passanger();
//            //c_pass.add_pas("Вася", 10000);
//            FileOutputStream pass_file_w = new FileOutputStream("passobj.txt");
//            ObjectOutputStream passobj_w = new ObjectOutputStream(pass_file_w);
//            passobj_w.writeObject(passangers);
//            passobj_w.close();
//
//            //train c_train = new train();
//            //c_train.add_train("Питер","Москва",4,6,20,1200);
//            FileOutputStream train_file_w = new FileOutputStream("trainobj.txt");
//            ObjectOutputStream trainobj_w = new ObjectOutputStream(train_file_w);
//            trainobj_w.writeObject(trains);
//            trainobj_w.close();
        }

    }
}
