package dan.lab;

public class lab3_1 {
    public static class vektor{
        int x,y;
        public vektor(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
        public void print()
        {
            System.out.println("x - "+this.x+" y - "+this.y);
        }
        public static String vek_summ(vektor v1, vektor v2)
        {
            String result;
            result = "Сумма векторов: x -  "+String.valueOf(v1.x+v2.x) + " y - " + String.valueOf(v1.y+ v2.y);
            return result;
        }
        public static String vek_vich(vektor v1, vektor v2)
        {
            String result;
            result = "Разница векторов: x -  "+String.valueOf(v1.x-v2.x) + " y - " + String.valueOf(v1.y-v2.y);
            return result;
        }
        public void vek_inc()
        {
            this.x++;
            this.y++;
            print();
        }
        public void vek_dec()
        {
            this.x--;
            this.y--;
            print();
        }
        public static int ver_skal_proiz(vektor v1, vektor v2)
        {
            return (v1.x* v2.x+v1.y* v2.y);
        }
        public static double vek_dlin(vektor v)
        {
            return (Math.sqrt(Math.pow(v.x,2) + Math.pow(v.y,2)));
        }
        public static double vek_corner(vektor v1, vektor v2)
        {
            return (vektor.ver_skal_proiz(v1,v2) / ((vektor.vek_dlin(v1)* vektor.vek_dlin(v2))));
        }
    }
    public static void main(String[] args){
        vektor[] mass = new vektor[2];
        for (int i=0;i!=2;i++)
        {
            mass[i] = new vektor(i+1, i+1);
        }
        System.out.println(vektor.vek_summ(mass[0],mass[1]));
        System.out.println(vektor.vek_vich(mass[0],mass[1]));
        mass[0].vek_inc();
        mass[1].vek_dec();
        System.out.println("");
        int m = 10;
        vektor[] mass_m = new vektor[m];
        for (int i=0; i!=m;i++)
        {
            mass_m[i] = new vektor(i+1,i*2+1);
            mass_m[i].print();
        }
        for (int i=0; i!=m;i= i+2)
        {
            System.out.printf("Вектора под номерами: %d, %d\n",i,i+1);
            System.out.println("Скалярное произведение векторов = " + vektor.ver_skal_proiz(mass_m[i],mass_m[i+1]));
            System.out.println("Длина вектора 1 = "+vektor.vek_dlin(mass_m[i]));
            System.out.println("Длина вектора 2 = "+vektor.vek_dlin(mass_m[i+1]));
            System.out.println("Cos угла между векторами "+ (vektor.vek_corner(mass_m[i], mass_m[i+1])));
        }

    }
}
