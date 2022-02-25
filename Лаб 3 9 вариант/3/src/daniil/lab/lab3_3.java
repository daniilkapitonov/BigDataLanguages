package daniil.lab;

public class lab3_3 {
    public static class photo
    {
        private String ph_name;
        private String f_pass;
        private photo(String ph_name, String f_pass) {
            this.ph_name = ph_name;
            this.f_pass = f_pass;
        }
    }
    public static class photoalbum
    {
        private String alb_name;
        private photo[] album;

    }
}
