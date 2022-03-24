package daniil.lab;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lab5_3_4 {
    public static void main(String[] args) throws IOException {
        File file = new File("test.txt");
        FileOutputStream fout = new FileOutputStream(file);

        String greetings = "1 2 3 4 5 6\r\n7 8 9 1 2 3\n4 5 6 7 8 9\n";

        fout.write(greetings.getBytes());

        fout.close();

        FileInputStream fileInputStream = new FileInputStream(file);
        String zap = "";

        ArrayList<ArrayList<Integer>> mass = new ArrayList<>();
        ArrayList<ArrayList<String>> mass_str = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = "";
        while ((line = br.readLine())!= null){
            ArrayList<String> mass_str_c = new ArrayList<>();
            mass.add(IntStream.of(Arrays.stream(line.split(" ")).mapToInt(Integer::valueOf).toArray()).boxed().collect(Collectors.toCollection(ArrayList::new)));
            mass_str_c.addAll(Arrays.asList(line.split(" ")));
            mass_str.add(mass_str_c);
        }
        ArrayList<ArrayList<Integer>> mass_t = new ArrayList<>();
        for (int i=0; i!=mass.get(0).size(); i++){
            ArrayList<Integer> mass_1 = new ArrayList<>();
            for (int j=0; j!=mass.size(); j++){
                mass_1.add(mass.get(j).get(i));
            }
            mass_t.add(mass_1);
        }
        System.out.println(mass);
        System.out.println(mass_t);
        System.out.println("Размерность x - "+mass.size()+" y - "+mass.get(0).size());
        ArrayList<ArrayList<Integer>> mass_90 = new ArrayList<>();
        System.out.println("");
        for (int i=0; i!=mass_t.size(); i++){
            ArrayList<Integer> mass_1 = new ArrayList<>();
            for (int j=mass_t.get(0).size()-1;j>=0; j--){
                mass_1.add(mass_t.get(i).get(j));
            }
           mass_90.add(mass_1);
        }
        System.out.println(mass_90);
        String cash = "";
        String new_str_file = "";
        for (int i=0; i!=mass_str.size(); i++){
            cash = mass_str.get(i).get(mass_str.get(i).size()-1);
            mass_str.get(i).set(mass_str.get(i).size()-1,mass_str.get(i).get(0));
            mass_str.get(i).set(0, cash);
            new_str_file+= String.join(" ", mass_str.get(i));
            new_str_file+="\n";
        }
        System.out.println(new_str_file);
        File file_n = new File("new_f.txt");
        FileOutputStream new_f = new FileOutputStream(file_n);

        new_f.write(new_str_file.getBytes());

        new_f.close();

        Scanner in = new Scanner(System.in);
        System.out.println(mass_str);
        System.out.print("Введите m (слов) - ");
        int m = in.nextInt();
        System.out.print("Введите n (строк) - ");
        int n = in.nextInt();
        ArrayList<ArrayList<String>> mass_str_l_nm = new ArrayList<>();
        for (int i=mass_str.size()-n; i!=mass_str.size(); i++){
            ArrayList<String> mass_s = new ArrayList<>();
            for (int j=mass_str.get(i).size()-m; j!=mass_str.get(i).size(); j++){
                mass_s.add(mass_str.get(i).get(j));

            }
            mass_str_l_nm.add(mass_s);
        }
        String str_nm = "";
        for (int i=0; i!=mass_str_l_nm.size();i++){
            str_nm+= String.join(" ", mass_str_l_nm.get(i));
            str_nm+="\n";
        }
        System.out.println(mass_str_l_nm);
        File file_n_nm = new File("new_f_nm.txt");
        FileOutputStream new_f_nm = new FileOutputStream(file_n_nm);

        new_f_nm.write(str_nm.getBytes());

        new_f_nm.close();


    }
}
