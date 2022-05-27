package dan.lab_8;

import java.util.Objects;
import java.util.concurrent.Exchanger;

public class Lab_8 {
    public static class Robot{
        public class Leg implements Runnable {
            private final String name;
            private final boolean leg;
            Leg(String name, boolean leg) {
                this.name = name;
                this.leg = leg;
            }
            @Override
            public void run() {
                while(true) {
                    if (leg == currentLeg) {
                        step();
                        currentLeg = !leg;
                        Thread.yield();
                    }
                }
            }
            private void step() {
                System.out.println(name);
            }
        }
        boolean currentLeg = true;
        Leg left = new Leg("LEFT", false);
        Leg right = new Leg("RIGHT", true);
        void run() {
            new Thread(left).start();
            new Thread(right).start();
        }
        public Robot() {
            System.out.println("Robot:");
        }
    }
    public static class Shop  {
        public static class Product implements Runnable {
            private final String operation;
            private final Integer request;
            Product(String operation, Integer request) {
                this.operation = operation;
                this.request = request;
                run();
            }
            @Override
            public void run() {
                if (Objects.equals(operation, "+")) {
                    step();
                    product += this.request;
                }
                else {
                    if (product < this.request){
                        System.out.println("No product");
                    }
                    else {
                        step();
                        product -= this.request;
                    }
                }
            }
            private void step() {
                System.out.println("Product - "+product+". Operation "+operation+". Change on "+request);
            }

        }
        public static Integer product = 0;
        Product people_manuf = new Product("+", (int) (Math.random() * 100));
        Product people_buyer = new Product("-", (int) (Math.random() * 100));
        public Shop() {
            new Thread(people_manuf).start();
            new Thread(people_buyer).start();
        }



    }

    public static void main(String[] args) {
        Robot robot1 = new Robot();
        Shop shop1 = new Shop();
    }
}
