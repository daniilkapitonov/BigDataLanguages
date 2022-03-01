package dan.lab;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class lab3_4_10 {
    public static class passanger implements Serializable{
        private String FIO;
        private int balance;
        public ArrayList<passanger> pas_list;

        public passanger(String FIO, int balance) {
            this.FIO = FIO;
            this.balance = balance;
        }

        public passanger() {
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
            passanger cash = new passanger(FIO, balance);
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

    public static class train implements Serializable{
        private String depin;
        private String depout;
        private int day;
        private int t_out;
        private int t_in;
        private int cost;
        ArrayList<train> train_list;

        public train(String depin, String depout, int day, int t_out, int t_in, int cost) {
            this.depin = depin;
            this.depout = depout;
            this.day = day;
            this.t_out = t_out;
            this.t_in = t_in;
            this.cost = cost;
        }

        public train() {
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
            train cash = new train(depin, depout, day, t_out, t_in, cost);
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


//        passanger c_pass = new passanger();
//        c_pass.add_pas("Вася", 10000);
//        FileOutputStream pass_file_w = new FileOutputStream("passobj.txt");
//        ObjectOutputStream passobj_w = new ObjectOutputStream(pass_file_w);
//        passobj_w.writeObject(c_pass);
//        passobj_w.close();
//
//        train c_train = new train();
//        c_train.add_train("Питер","Москва",4,6,20,1200);
//        FileOutputStream train_file_w = new FileOutputStream("trainobj.txt");
//        ObjectOutputStream trainobj_w = new ObjectOutputStream(train_file_w);
//        trainobj_w.writeObject(c_train);
//        trainobj_w.close();

        FileInputStream pass_file = new FileInputStream("passobj.txt");
        ObjectInputStream passobj = new ObjectInputStream(pass_file);
        Object cash_i = passobj.readObject();
        passanger passangers = (passanger) cash_i;
        passobj.close();
        System.out.println("Пассажиры загружены");

        FileInputStream train_file = new FileInputStream("trainobj.txt");
        ObjectInputStream trainobj = new ObjectInputStream(train_file);
        Object cash_c = trainobj.readObject();
        train trains = (train) cash_c;
        trainobj.close();
        System.out.println("Поезда загружены");
        Scanner in_1 = new Scanner(System.in);
        System.out.println("Вы пассажир или администратор? 1 - пассажир, 2 - администратор, 3 - выйти");
        int who = in_1.nextInt();
        while (who !=3 && who!=55 && who !=66){
            Scanner in = new Scanner(System.in);
            switch (who){
                case 1:
                    System.out.println("Пассажир, введите своё имя");
                    String p_name = in.nextLine();
                    int p_id = passangers.search_pas(p_name);
                    if (p_id!=-1){
                        System.out.println("Добро пожаловать!");
                        who = 55;
                    }else{
                        who=-1;
                    }
                    System.out.println(passangers.toString(p_id));
                    break;
                case 2:
                    System.out.println("Введите пароль");
                    if (in.nextLine().equals("123"))
                    {
                        System.out.println("Успешно");
                        who = 66;
                    }else{
                        System.out.println("Пароль введён не верно");
                        who = -1;
                    }
                    break;
                case 3:
                    who = 3;
                default:
                    System.out.println("Такого пункта меню нет в списке");
                    who=-1;
            }
            if (who ==-1){
                System.out.println("Вы пассажир или администратор? 1 - пассажир, 2 - администратор, 3 - выйти");
                who = in.nextInt();

            }
        }




        //passanger c_pass = new passanger();
        //c_pass.add_pas("Вася", 10000);
        FileOutputStream pass_file_w = new FileOutputStream("passobj.txt");
        ObjectOutputStream passobj_w = new ObjectOutputStream(pass_file_w);
        passobj_w.writeObject(passangers);
        passobj_w.close();

        //train c_train = new train();
        //c_train.add_train("Питер","Москва",4,6,20,1200);
        FileOutputStream train_file_w = new FileOutputStream("trainobj.txt");
        ObjectOutputStream trainobj_w = new ObjectOutputStream(train_file_w);
        trainobj_w.writeObject(trains);
        trainobj_w.close();

    }
}
