package daniil.lab;

import java.io.*;

public class Lab5_3_4 {
    public static void main(String[] args) throws IOException {
        File file = new File("test.txt");
        FileOutputStream fout = new FileOutputStream(file);

        String greetings = "1 2 3 4 5\r\n1 2 3 4 5\n";

        fout.write(greetings.getBytes());

        fout.close();

        FileInputStream fileInputStream = new FileInputStream(file);

        int i;
//        int[][] mass  = new  int[][];/
        int x=0,y=0;
        while((i=fileInputStream.read())!= -1){
            String cash = Character.toString((char)i);
            String zap = "";
            System.out.print(cash);
            if (cash.equals("\n")){
                System.out.println("перенос");
            }
            zap = zap.concat(cash);
            x+=1;
            y = zap.split(" ").length;
        }
        System.out.println(x+" "+y);
    }
}
