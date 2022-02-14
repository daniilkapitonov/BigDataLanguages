package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Program {

    public int t;

    public static void main(String[] args) {

        // garbage collector - сборщик мусора
        
        Program h = new Program();
        h.toDo();

        Program.main(new String[]{"ffff","sdsd"});

        int a = 10;
        var b = 200;
        boolean flag = true;

        /*
        char ch = 'A';
        long l = 2228;
        a = (int)l;
        */

        float f = 4.56f;
        double d = 983.122; // по умолчанию всегда double


        System.out.println("Hello");
        //System.out.println("123"*2);

        String str = "Hello"; // immutable
        System.out.println(str.hashCode());
        str+= "dsfdsf";
        System.out.println(str.hashCode());

        //mutable String

        StringBuilder stringBuilder = new StringBuilder("SDfsdfs");
        System.out.println(stringBuilder.hashCode());
        stringBuilder.append("sdfsdf");
        System.out.println(stringBuilder.hashCode());

        String str2 = stringBuilder.toString();
        System.out.println(str2);

        // / - целочисл. деление
        // % - остаток от деления

        double x = Math.pow(2.0,2.0);

        int[] v = new int[2]; // 0 0
        int p[] = new int[5]; // 0 0 0 0 0

        int[] q;  // null

        q = new int[7];

        int[] t = {5,3,0,10};

        Arrays.sort(t);


        ArrayList arrayList = new ArrayList(); // 10
        arrayList.add(1);
        arrayList.add(2);
        //Collections.



    }

    public void toDo() {
        int v = this.t;
    }

}

// Java code style - (.pdf ~1994)
