package daniil.lab;

import java.io.*;

public class Lab5_3_4 {
    public static void main(String[] args) throws IOException {
        File file = new File("test.txt");
        FileOutputStream fout = new FileOutputStream(file, true);

        String greetings = "1 2 3 4 5\r\n";

        fout.write(greetings.getBytes());

        fout.close();

        FileInputStream fileInputStream = new FileInputStream(file);

        int i;

        while((i=fileInputStream.read())!= -1){
            if ()
            System.out.print((char) i);
        }
    }
}
