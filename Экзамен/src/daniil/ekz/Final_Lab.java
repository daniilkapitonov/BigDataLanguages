package daniil.ekz;

import java.awt.*;
import java.util.Optional;
import java.util.Scanner;

public class Final_Lab {
    static Point check_dot(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4){
        if (x1 == x2) {
            return null;
        }

        double x = ((x1*y2-x2*y1)*(x4-x3)-(x3*y4-x4*y3)*(x2-x1))/((y1-y2)*(x4-x3)-(y3-y4)*(x2-x1));
        double y = ((y3-y4)*x-(x3*y4-x4*y3))/(x4-x3);
        if (((x1<=x)& (x2>=x)& (x3<=x)& (x4 >=x))|| ((y1<=y)& (y2>=y)& (y3<=y) & (y4>=y))){
            Point point = new Point();
            point.setLocation(x, y);
            return point;
        } else {
            return null;
        }

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите значение N - ");
        int N = in.nextInt();
        Point[] d1 = new Point[N];
        Point[] d2 = new Point[N];

        int max = 20;
        int min = -20;
        double min_x = max;
        for (int i=0; i!=N; i++){
            d1[i] = new Point();
            d2[i] = new Point();
            d1[i].setLocation ((double) (Math.random()*((max-min)+1))+min, (double)(Math.random()*((max-min)+1))+min);
            d2[i].setLocation ((double)(Math.random()*((max-min)+1))+min, (double)(Math.random()*((max-min)+1))+min);
            System.out.println("D1 - "+ d1[i]+ " ,D2 - " + d2[i]);
        }
        for (int i=0; i!=N; i++){
            for (int j=0; j!=N; j++) {
                if (i!=j) {
                    System.out.println("Точка перечесения отрезкой:");
                    System.out.println("D1 - " + d1[i] + " ,D2 - " + d2[j]);
                    double cash;
                    if (check_dot(d1[i].getX(), d1[i].getY(), d2[i].getX(), d2[i].getY(),
                            d1[j].getX(), d1[j].getY(), d2[j].getX(), d2[j].getY()) != null) {
                        cash = check_dot(d1[i].getX(), d1[i].getY(), d2[i].getX(), d2[i].getY(),
                                d1[j].getX(), d1[j].getY(), d2[j].getX(), d2[j].getY()).getX();
                        if (Math.abs(cash) < min_x) {
                            min_x = cash;
                        }
                        System.out.println(check_dot(d1[i].getX(), d1[i].getY(), d2[i].getX(), d2[i].getY(),
                                d1[j].getX(), d1[j].getY(), d2[j].getX(), d2[j].getY()));
                    }else {
                        System.out.println("null");
                    }
                }
            }
        }
        System.out.println("Минимальная абсцисса - " + min_x);
    }
}
