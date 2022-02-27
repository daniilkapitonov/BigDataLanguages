package daniil.lab;

import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.Period;


public class lab3_3 {
    public static class photo
    {
        private String ph_name;
        private String f_pass;
        private photo(String ph_name, String f_pass) {
            this.ph_name = ph_name;
            this.f_pass = f_pass;
        }

        private photo() {

        }
        public boolean equals(photo o2){
            if (this.hashcode(o2)) {
                return this.equals(o2);
            }else{
                return false;
            }
        }
        public boolean hashcode(photo o2){
            return this.hashCode() == o2.hashCode();
        }
        public String toString(){
            return "Название фотогравии - "+ this.ph_name+ ",  директория  - "+ this.f_pass;
        }
        private void ph_print(){
            System.out.println(this.ph_name+this.f_pass);
        }

    }
    public static class photoalbum extends photo
    {
        private String alb_name;
        private ArrayList<photo> album;

        public photoalbum(String alb_name, ArrayList<photo> album) {
            this.alb_name = alb_name;
            this.album = album;
        }
        public photoalbum(String alb_name) {
            this.alb_name = alb_name;
            this.album = new ArrayList<>();

        }
        public boolean equals(photoalbum o2){
            if (this.hashcode(o2)) {
                return this.equals(o2);
            }else{
                return false;
            }
        }
        public boolean hashcode(photoalbum o2){
            return this.hashCode() == o2.hashCode();
        }
        private void add_photo(photo new_p){
            this.album.add(new_p);
        }
        public String toString(){
            String result = "";
            result+="Название альбома - "+ this.alb_name;
            for (photo ph:this.album) {
               result+= "\n" + ph.toString();
            }
            return result;
        }
        private int ph_count(){
            return this.album.size();
        }
    }



    public static void main(String[] args) {
        System.out.println("Вариант 3 №9");
        photoalbum album = new photoalbum("Новый альбом");
        photo ph_1 = new photo("photo1", "newfolder1");
        photo ph_2 = new photo("photo2", "newfolder2");
        album.add_photo(ph_1);
        album.add_photo(ph_2);
        System.out.println(album.ph_count());
        System.out.println(album.toString());

        System.out.println("\nВариант 3 №10");
        year year2022 = new year(2022);
        for (int i=0; i!=1;i++){
            String name;
            int number, count;
            Scanner in = new Scanner(System.in);
            System.out.print("Введите название месяца - ");
            name = in.nextLine();
            System.out.print("Введите номер месяца - ");
            number = in.nextInt();
            System.out.print("Введите кол-во дней в месяце - ");
            count = in.nextInt();
            month new_month = new month(name, number);
            for (int j=1; j<=count;j++){
                day new_day = new day(j);
                new_month.add_day(new_day);
            }
            year2022.add_new_month(new_month);
        }
        System.out.println(year2022.toString());
        System.out.println("");
        System.out.println("Вевести день неделя заданной даты");
        Scanner in = new Scanner(System.in);
        int m_n, d_n;
        Scanner in1 = new Scanner(System.in);
        System.out.print("Введите номер месяца - ");
        m_n = in1.nextInt();
        System.out.print("Число месяца - ");
        d_n = in1.nextInt();
        Calendar show_data = new GregorianCalendar(2022, m_n-1, d_n);
        System.out.println(show_data.getTime());
        Calendar show_data1 = new GregorianCalendar(2022, m_n-1, d_n);
        String begin, end;
        System.out.print("Введите начальную дату формата dd.MM.yyyy - ");

        begin = in.nextLine();
        System.out.print("Введите конечную дату формата dd.MM.yyyy - ");
        end = in.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate startDate = LocalDate.parse(begin, formatter);
        LocalDate endDate = LocalDate.parse(end, formatter);
        Period period = Period.between(startDate, endDate);
        System.out.println("Прошло лет - "+period.getYears());
        System.out.println("Прошло месяцев - "+period.getMonths());
        System.out.println("Прошло дней - "+period.getDays());
    }

    public static class day{
        int day_number;
        String notes;

        public day(int day_number) {
            this.day_number = day_number;
        }

        public day(int day_number, String notes) {
            this.day_number = day_number;
            this.notes = notes;
        }

        public day(){}

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            day day = (day) o;
            return day_number == day.day_number && Objects.equals(notes, day.notes);
        }

        @Override
        public int hashCode() {
            return Objects.hash(day_number, notes);
        }

        @Override
        public String toString() {
            return "day{" +
                    "day_number=" + day_number +
                    ", notes='" + notes + '\'' +
                    '}';
        }
    }
    public static class month extends day{
        String month_name;
        int month_number;
        String notes;
        ArrayList<day> days;

        public month(String month_name, int month_number, String notes, ArrayList<day> days) {
            this.month_name = month_name;
            this.month_number = month_number;
            this.notes = notes;
            this.days = days;
        }

        public month(String month_name, int month_number) {
            this.month_name = month_name;
            this.month_number = month_number;
            this.days = new ArrayList<>();
        }
         public void add_day(day newday){
            this.days.add(newday);
         }


        public month(){}


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            month month = (month) o;
            return Objects.equals(month_name, month.month_name) && Objects.equals(notes, month.notes) && Objects.equals(days, month.days);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), month_name, notes, days);
        }

        @Override
        public String toString() {
            return "\nmonth{" +
                    "month_name='" + month_name + '\'' +
                    ", notes='" + notes + '\'' +
                    ", days=" + days.toString() +
                    '}';
        }
    }
    public static class year extends month{
        int year_number;
        String notes;
        ArrayList<month> monthes;

        public year(int year_number, String notes, ArrayList<month> monthes) {
            this.year_number = year_number;
            this.notes = notes;
            this.monthes = monthes;
        }

        public year(int year_number) {
            this.year_number = year_number;
            this.monthes = new ArrayList<>();
        }

        public void add_new_month(month new_month){
            this.monthes.add(new_month);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            year year = (year) o;
            return year_number == year.year_number && Objects.equals(notes, year.notes);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), year_number, notes);
        }

        @Override
        public String toString() {
            return "year{" +
                    "year_number=" + year_number +
                    ", notes='" + notes + '\'' +
                    ", monthes=" + monthes.toString() +
                    '}';
        }
    }
}
