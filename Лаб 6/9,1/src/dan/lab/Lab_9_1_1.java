package dan.lab;

//1.	Определить множество на основе множества целых чисел.
//        Создать методы для определения пересечения и объединения множеств.

import java.io.*;
import java.util.*;


public class Lab_9_1_1 {

    public static boolean check_in(ArrayList<Integer> m1, ArrayList<Integer> m2){
        return m1.get(m1.size()-1) >= m2.get(0) || m1.get(0) <= m2.get(m2.size()-1);
    }

    public static ArrayList<Integer> concat(ArrayList<Integer> m1, ArrayList<Integer> m2){
        System.out.println("Вариант 1 №1");
        ArrayList<Integer> ret = new ArrayList<>();
        int max= Math.max(m1.size(), m2.size());
        System.out.println(max);
        for (int i =0; i!= max; i++){
            if (m1.size()  > i && m2.size() > i){
                if (m1.get(i) == m2.get(i)){
                    ret.add(m1.get(i));
                }  else{
                    ret.add(m1.get(i));
                    ret.add(m2.get(i));
                }
            } else{
                if (m1.size()  > i){
                    ret.add(m1.get(i));
                } else {
                    ret.add(m2.get(i));
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<ArrayList<Integer>> mn_vo = new ArrayList<>();


        for (int j = 0; j!=6; j++){
            ArrayList<Integer> cash = new ArrayList<>();
            int i_1 = (int) (Math.random() * 10 + 1);
            for (int i =0; i!=i_1; i++){
                cash.add(3*(i_1 - i));
            }
            Collections.sort(cash);
            mn_vo.add(cash);
        }

        System.out.println(mn_vo);

        System.out.println(check_in(mn_vo.get(1), mn_vo.get(2)));
        System.out.println(concat(mn_vo.get(1), mn_vo.get(2)));

        System.out.println("Вариант 1 №9");

        File file = new File("eng_test.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = "";
        HashSet<String> str = new HashSet<>();
        while ((line = br.readLine())!= null){
            for (String word:line.split(" ")){
                if (!str.contains(word.toLowerCase())){
                    str.add(word.replace(".", "")
                            .replace(",","")
                            .replace(";", "").toLowerCase());
                }
            }
        }
        System.out.println(str);



    }
}
