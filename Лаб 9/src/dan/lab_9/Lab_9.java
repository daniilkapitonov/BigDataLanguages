package dan.lab_9;

import java.util.Arrays;
import java.util.Collection;

public class Lab_9 {
    public static class Student {
        String name;
        int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }

    public static void main(String[] args) {
        Collection<Student> students = Arrays.asList(
                new Student("Ivan", 40),
                new Student("Petr", 60),
                new Student("Olga", 70)
        );
        students.stream().filter(x->x.score >= 40 && x.score <=60).forEach(x-> System.out.println(x.toString()));

        Collection<String> str = Arrays.asList(
                "hello", "hell", "hel", "bro", "hel"
        );
        System.out.println(str.stream().filter(x->x.equals("hel")).count());

    }
}
