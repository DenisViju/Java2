import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> numere = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while(scanner.hasNextInt()) {
                numere.add(scanner.nextInt());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul nu a fost gasit");
            e.printStackTrace();
        }

        System.out.println("Numere: " + numere);

        Collections.sort(numere);
        System.out.println("Sortate crescator: " + numere);

        Collections.sort(numere, Collections.reverseOrder());
        System.out.println("Sortate descrescător: " + numere);
    }
}