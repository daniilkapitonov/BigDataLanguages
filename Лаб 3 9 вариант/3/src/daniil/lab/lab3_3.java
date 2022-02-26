package daniil.lab;

import java.util.ArrayList;

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
        photo test_1 = new photo("Фото_1", "новая папка_новая папка");
        photo test_2 = new photo("Фото_1", "новая папка_новая папка");
        System.out.println(test_1.hashCode() +" "+test_2.hashCode() );
        System.out.println(test_1.equals(test_2));
    }
}
