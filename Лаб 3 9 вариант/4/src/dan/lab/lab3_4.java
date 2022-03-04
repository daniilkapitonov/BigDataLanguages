package dan.lab;

import java.io.*;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab3_4 {
    public static class Item implements Serializable{
        private static final long serialVersionUID = 2609875448065146411L;
        private String name;
        private int cost;
        private int count;
        public ArrayList<Item> items_sell;

        public Item() {
            items_sell = new ArrayList<>();

        }

        public Item(String name, int cost, int count) {
            this.name = name;
            this.cost = cost;
            this.count = count;
        }

        public void add_item(String name, int cost, int count){
            Item cash = new Item(name,cost, count);
            this.items_sell.add(cash);
        }
        public void add_count_item(String name, int cost, int count){
            int n = this.search_item(name, cost);
            if (n!=-1){
                items_sell.get(n).count+=count;
            } else{
                System.out.println("Такого товара не найдено");
            }
        }
        public void remove_item(String name, int cost){
            int n = this.search_item(name, cost);
            if (n !=-1) {
                this.items_sell.remove(n);
            }else{
                System.out.println("Такого товара не найдено");
            }
        }
        public int search_item(String name, int cost){
            for (int i=0; i!=items_sell.size();i++)
            {
                if(items_sell.get(i).name.equals(name) && items_sell.get(i).cost == cost){
                    return i;
                }
            }
            return -1;
        }

        public String toString(int n) {
            if (n!=-1) {
                return "item{" +
                        "Название товара='" + this.items_sell.get(n).name + '\'' +
                        ", цена=" + this.items_sell.get(n).cost + '\'' +
                        ", кол-во=" + this.items_sell.get(n).count +
                        '}';
            }else{
                return "Такого товара не найдено";
            }
        }

        @Override
        public String toString() {
            return "item{" +
                    "Название товара='" + name + '\'' +
                    ", цена=" + cost +
                    ", кол-во=" + count +
                    '}';
        }
    }

    public static class Client implements Serializable{
        private String FIO;
        private boolean ban;
        private int balance;
        public ArrayList<Client> clients;

        public Client(String FIO, int balance) {
            this.FIO = FIO;
            this.ban = false;
            this.balance = balance;
        }

        public Client() {
            clients = new ArrayList<>();
        }

        public void add_new_client(String FIO, int balance){
            Client cash = new Client(FIO, balance);
            clients.add(cash);
        }

        public int search_client(String name){
            for(int i=0;i!=this.clients.size();i++){
                if (this.clients.get(i).FIO.equals(name)){
                    return i;
                }
            }
            return -1;
        }

        public void remove_client(String name)
        {
            int n = this.search_client(name);
            if (n !=-1){
                clients.remove(n);
            }else{
                System.out.println("такого пользователя не найдено");
            }
        }

        public void add_money(int n, int money){
            if (n!=-1){
                this.balance+=money;
            }else{
                System.out.println("такого пользователя не найдено");
            }
        }

        public void ban_unban_client(String name, boolean ban){
            int n = this.search_client(name);
            if (n!=-1){
                clients.get(n).ban = ban;
            }else{
                System.out.println("такого пользователя не найдено");
            }
        }


        public String toString(int n) {
            if (n!=-1) {
                return "client{" +
                        "ФИО='" + clients.get(n).FIO + '\'' +
                        ", забанен=" + clients.get(n).ban +
                        ", баланс=" + clients.get(n).balance +
                        '}';
            }else{
                return "Такого пользователя не найдено";
            }
        }

        @Override
        public String toString() {
            return "client{" +
                    "ФИО='" + FIO + '\'' +
                    ", забанен=" + ban +
                    ", баланс=" + balance +
                    '}';
        }
    }



    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Вариант 4 №9");
        System.out.println("Старт систетмы Интернет-магазин");

//        item itemss = new item();
//        itemss.add_item("IPhone", 6000, 5);
//        FileOutputStream items_file_w = new FileOutputStream("itemsobj.txt");
//        ObjectOutputStream itemsobj_w = new ObjectOutputStream(items_file_w);
//        itemsobj_w.writeObject(itemss);
//        itemsobj_w.close();
//
//        client clientss = new client();
//        clientss.add_new_client("Вася", 2000);
//        FileOutputStream clients_file_w = new FileOutputStream("clientsobj.txt");
//        ObjectOutputStream clientsobj_w = new ObjectOutputStream(clients_file_w);
//        clientsobj_w.writeObject(clientss);
//        clientsobj_w.close();


        FileInputStream items_file = new FileInputStream("itemsobj.txt");
        ObjectInputStream itemsobj = new ObjectInputStream(items_file);
        Object cash_i = itemsobj.readObject();
        Item items = (Item) cash_i;
        itemsobj.close();
        System.out.println("Товары загружены");

        FileInputStream clients_file = new FileInputStream("clientsobj.txt");
        ObjectInputStream clientsobj = new ObjectInputStream(clients_file);
        Object cash_c = clientsobj.readObject();
        Client clients_list = (Client) cash_c;
        clientsobj.close();
        System.out.println("Клиенты загружены");
while (true) {
    System.out.println("Вы клиент или администратор? 1- клиент, 2 - администратор, 3 - выйти");
    Scanner in_1 = new Scanner(System.in);
    int who = in_1.nextInt();
    String cl_name = "";
    int cl_id = 0;
    while (who != 3 && who != 55 && who != 66) {
        Scanner in = new Scanner(System.in);
        switch (who) {
            case 1:
                System.out.println("Введите своё имя");
                cl_name = (in.nextLine());
                cl_id = clients_list.search_client(cl_name);
                System.out.println("Информация о клиенте:" + cl_id);
                System.out.println(clients_list.toString(cl_id));
                if (cl_id == -1) {
                    who = -1;
                } else {
                    if (!clients_list.clients.get(cl_id).ban) {
                        who = 55;
                    } else {
                        who = -1;
                        System.out.println("Вы были забанены. Обратитесь к администратору");
                    }

                }
                break;
            case 2:
                System.out.println("Введите пароль");
                String pass = in.nextLine();
                if (pass.equals("123")) {
                    System.out.println("Добро пожаловать!");
                    who = 66;
                } else {
                    System.out.println("Пароль не верный");
                    who = -1;
                }
                break;
            default:
                System.out.println("Такого значения нет, введите снова");
                who = -1;
                break;
        }
        if (who == -1) {
            System.out.println("Вы клиент или администратор? 1- клиент, 2 - администратор, 3 - выйти");
            who = in.nextInt();
        }
    }
    if (who != 3) {
        System.out.println("Добро пожаловать в в систему. Доступные команды:");
        boolean check = true;
        while (check) {
            if (who == 55) {
                System.out.println("Клиент, введите цифры для выполнения действия:\n 1 - Пополнить балланс, 2 - Купить товар, 3 - выйти");
                Scanner in_c = new Scanner(System.in);
                switch (Integer.parseInt(in_c.nextLine())) {
                    case 1:
                        System.out.println("На какую сумму вы хотите пополнить балланс?" + cl_name + cl_id);
                        in_c.reset();
                        int money = in_c.nextInt();
                        clients_list.clients.get(cl_id).add_money(cl_id, money);
                        System.out.println("Успешно");
                        System.out.println(clients_list.clients.get(cl_id).toString());
                        break;
                    case 2:
                        System.out.println("Введите название товара и его цену для покупки");
                        in_c.reset();
                        String it_name = in_c.nextLine();
                        in_c.reset();
                        int it_cost = in_c.nextInt();
                        int it_id = items.search_item(it_name, it_cost);
                        if (it_id != -1) {
                            if (items.items_sell.get(it_id).count > 0) {
                                if (items.items_sell.get(it_id).cost <= clients_list.clients.get(cl_id).balance) {
                                    clients_list.clients.get(cl_id).balance -= items.items_sell.get(it_id).cost;
                                    items.items_sell.get(it_id).count -= 1;
                                    System.out.println("Покупка совершена успешно");
                                } else {
                                    System.out.println("У вас недостаточно средств для покупки");
                                }
                            } else {
                                System.out.println("Товара нет в наличии");
                            }
                        } else{
                            System.out.println("Такого товара нет");
                        }
                        break;
                    case 3:
                        check = false;
                        break;
                    default:
                        System.out.println("Такого значения нет, введите снова");
                        break;

                }
            } else {
                System.out.println("Администратор, введите цифры для выполнения действия:\n 1 - Забанить клиента, 2 - Добавить товар, 3 - Информация о товаре, 4 - Выйти");
                Scanner in_a = new Scanner(System.in);
                switch (Integer.parseInt(in_a.nextLine())) {
                    case 1:
                        System.out.println("Чтоба занести клиента в чёрный список введите его имя и статус");
                        in_a.reset();
                        String name = in_a.nextLine();
                        boolean status = Boolean.parseBoolean(in_a.nextLine());
                        clients_list.ban_unban_client(name, status);
                        System.out.println("Успешно");
                        break;
                    case 2:
                        System.out.println("Чтобы добавить товар введите его название, цену и кол-во");
                        in_a.reset();
                        String iname = in_a.nextLine();
                        int icost = Integer.parseInt(in_a.nextLine());
                        int icount = Integer.parseInt(in_a.nextLine());
                        items.add_item(iname,icost,icount);
                        System.out.println("Успешно");
                        System.out.println(items.toString(items.search_item(iname,icost)));
                        break;
                    case 3:
                        System.out.println("Введите название товара и его цену");
                        in_a.reset();
                        String it_name = in_a.nextLine();
                        in_a.reset();
                        int it_cost = in_a.nextInt();
                        int it_id = items.search_item(it_name, it_cost);
                        if (it_id != -1) {
                            System.out.println(items.items_sell.get(it_id).toString());
                        } else {
                            System.out.println("Такого товара нет");
                        }
                        break;
                    case 4:
                        check = false;
                        break;
                    default:
                        break;


                }

            }
        }

    }


    //items.add_item("IPhone", 6000, 5);
    FileOutputStream items_file_w = new FileOutputStream("itemsobj.txt");
    ObjectOutputStream itemsobj_w = new ObjectOutputStream(items_file_w);
    itemsobj_w.writeObject(items);
    itemsobj_w.close();


    //clients_list.add_new_client("Вася", 2000);
    FileOutputStream clients_file_w = new FileOutputStream("clientsobj.txt");
    ObjectOutputStream clientsobj_w = new ObjectOutputStream(clients_file_w);
    clientsobj_w.writeObject(clients_list);
    clientsobj_w.close();
}










    }
}
