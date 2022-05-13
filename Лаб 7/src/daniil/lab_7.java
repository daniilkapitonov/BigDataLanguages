package daniil;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.SocketHandler;


public class lab_7 {

    public static void main(String[] args) {
        System.out.println("Вариант 1 №9");
        String text = "И мы подымем их на вилы, " +
                "Мы а петлях раскачнем тела, " +
                "Чтоб лопнули на шее жилы, " +
                "Чтоб кровь проклятая текла.";
        String[] words = "б в г д ж з й к л м н п р с т ф х ц ч ш щ".split(" ");
        System.out.println(Arrays.toString(words));
        System.out.print("Введите длинну удаления - ");
        int number;
        Scanner in = new Scanner(System.in);
        number = in.nextInt();
        String[] text_mass = text.split(" ");
        System.out.println(text);
        for (int i =0; i!=text_mass.length; i++){
            String word = String.valueOf(text_mass[i].charAt(0)).toLowerCase(Locale.ROOT);
            if (text_mass[i].length() == number && Arrays.asList(words).contains(word)){
                text = text.replace(text_mass[i], "");
            }
        }
        text = text.replace("   ", " ");
        text = text.replace("  ", " ");
        System.out.println(text);

        System.out.println("Вариант 1 №10");
        String text2 = "И мы подымем их на вилы, " +
                "Мы а( петлях раскачнем тела, " +
                "Чтоб лопнули на шее жилы, " +
                "Чтоб кровь проклятая) текла.";
        StringBuilder str = new StringBuilder(text2);
        System.out.print("Введите символы для удаления через пробел - ");
        String[] in_word;
        Scanner in2 = new Scanner(System.in);
        in_word = in2.nextLine().split(" ");
        System.out.println(Arrays.toString(in_word));
        System.out.println(str);
        int i1 = text2.indexOf(in_word[0]);
        int i2 = text2.indexOf(in_word[1]);
        System.out.println(text2.length());
        System.out.println(i1+" "+i2);
        for (int i =i1; i!=i2+1; i++){
//            text2 = text2.(String.valueOf(text2.charAt(i)), "7"), ;
            str.setCharAt(i, '7');
        }
        text2 = str.toString().replace("7", "");
        System.out.println(text2);

        System.out.println("Вариант 2 №9");
        String text3 = "и миы подыимем их ниа вилы, ";
        System.out.println(text3);

        String[] words3 = text3.split(" ");
        boolean isContain;
        System.out.print("Встречающиеся во всех словах буквы: ");
        for (int i = 0; i < words3[0].length(); i++) {
            isContain = true;
            for (int j = 1; j < words3.length; j++) {
                isContain &= words3[j].contains(String.valueOf(words3[0].charAt(i)));
            }
            if (isContain) System.out.print(words3[0].charAt(i) + " ");
        }

        System.out.println("\nВариант 2 №10");

        String[] alph = "а б в г д е ё ж з и й к л м н о п р с т у ф х ц ч ш щ ъ ы ь э ю".split(" ");
        String text4 = "И мы подымем их на вилы, " +
                "Мы а петлях раскачнем 2345 тела, " +
                "Чтоб лопнули на 523 шее жилы, " +
                "Чтоб кровь проклятая текла.";
        String[] words4 = text4.split(" ");
        String result = "";
        boolean str_res = false;
        for (int i=0; i!= words4.length; i++){
            for (int j=0; j!=words4[i].length(); j++){
                if (!Arrays.asList(alph).contains(String.valueOf(words4[i].charAt(j)).toLowerCase(Locale.ROOT))){
                } else {
                    str_res = false;
                }
            }
            if (str_res && words4[i].length() > result.length()){
                result = words4[i];
            }
            str_res  =true;
        }
        System.out.println(result);

        System.out.println("Вариант 3 №9");
        String[] alph2 = "а б в г д е ё ж з и й к л м н о п р с т у ф х ц ч ш щ ъ ы ь э ю".split(" ");
        String text5 = "И мы подымем их на вилы, " +
                "Мы а петлях раскачнем тела, " +
                "Чтоб лопнули на шее жилы, " +
                "Чтоб кровь проклятая текла.";
        String[] words5 = text5.split(" ");
        boolean checkN = false;

        for (int i=0; i!=alph2.length; i++){
            for (int j=0; j!=words5.length;j++){
//                System.out.println(String.valueOf(words5[j].charAt(0)).toLowerCase(Locale.ROOT).equals("а")+ alph2[i]);
//                System.out.println(String.valueOf(words5[j].charAt(0)).toLowerCase(Locale.ROOT).equals(alph2[i]) + " "+ words5[j]+ " "+ alph2[i]);
                if (String.valueOf(words5[j].charAt(0)).toLowerCase(Locale.ROOT).equals(alph2[i])){
                    System.out.print(words5[j]+ " ");
                    checkN = true;
                }
            }
            if (checkN) System.out.println();
            checkN = false;
        }
        System.out.println("Вариант 3 №10");
        String[] alph6 = "а е ё и о у ы э ю я".split(" ");
        String text6 = "И мы подымем их на вилы, " +
                "Мы а петлях раскачнем тела, " +
                "Чтоб лопнули на шее жилы, " +
                "Чтоб кровь проклятая текла.";
        String[] words6 = text6.split(" ");
        int[] words_mass = new int[words6.length];
        System.out.println(text6);
        for (int i = 0; i!=words6.length; i++){
            int gl_count=0;
            for (int j=0; j!=words6[i].length(); j++){
                if (Arrays.asList(alph6).contains(String.valueOf(words6[i].charAt(j)).toLowerCase(Locale.ROOT))){
                    gl_count+=1;
                }
            }
            words_mass[i] = gl_count;
        }

        for (int i=0; i!=words_mass.length; i++){
            for (int j=0; j!=words_mass.length; j++){
                if (words_mass[i] < words_mass[j]){
                    int cash = words_mass[i];
                    words_mass[i] = words_mass[j];
                    words_mass[j] = cash;

                    String cashS = words6[i];
                    words6[i] = words6[j];
                    words6[j] = cashS;
                }
            }
        }
        System.out.println(Arrays.toString(words6));

        System.out.println("Вариант 4 №9");
        String text7 = "И мы подымем их на вилы, " +
                "Мы а петлях раскачнем тела, " +
                "Чтоб лопнули на шее жилы, " +
                "Чтоб кровь rtgrrgh проклятая текла.";
        String[] words7 = text7.split(" ");
        System.out.println(Arrays.toString(words7));
        for (int i=0; i!=words7.length;i++){
            String w1 = String.valueOf(words7[i].charAt(0));
            words7[i] = w1 + words7[i].replace(w1,"");
        }
        System.out.println(Arrays.toString(words7));

        System.out.println("Вариант 4 №10");
        String text8 = "И мы подымем их на вилы\n" +
                "Мы а петлях раскачнем тела\n" +
                "Чтоб лопнули на шее жилч\n" +
                "Чтоб кровь rtgrrgh проклятая текч";
        String[] words8 = text8.split("\n");
        System.out.println(text8);
        System.out.println();
        int[] str_l = new int[words8.length];
        String cash_str = "";
        for (int i =0 ; i!=words8.length; i++){
            if (String.valueOf(words8[i].charAt(0)).toLowerCase(Locale.ROOT).equals(String.valueOf(words8[i].
                    charAt(words8[i].length()-1)).toLowerCase(Locale.ROOT))){
                if (cash_str.length() < words8[i].length()) cash_str = words8[i];
            }
        }
        System.out.println(text8.replace(cash_str, ""));




    }
}
