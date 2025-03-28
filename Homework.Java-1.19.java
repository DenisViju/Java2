import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Student {
    private String nume;
    private Double nota;

    Student(String nume, Double nota) {
        this.nume = nume;
        this.nota = nota;
    }
    public String getNume() {
        return nume;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return nume + " (" + nota + ")";
    }
}



public class Main {
    public static void main(String[] args) {

        ArrayList<Student> studenti = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    String nume = parts[0];
                    double nota = Double.parseDouble(parts[1]);
                    studenti.add(new Student(nume, nota));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Fisierul nu a fost gasit!");
            e.printStackTrace();
            return;
        } catch (NumberFormatException e) {
            System.err.println("Formatul notelor este invalid!");
            e.printStackTrace();
            return;
        }

        System.out.println("Studenti:");
        studenti.forEach(System.out::println);


        Collections.sort(studenti, Comparator.comparingDouble(Student::getNota));
        System.out.println("\nSortati crescator dupa nota:");
        studenti.forEach(System.out::println);


        Collections.sort(studenti, Comparator.comparingDouble(Student::getNota).reversed());
        System.out.println("\nSortati descrescator dupa nota:");
        studenti.forEach(System.out::println);
    }
}