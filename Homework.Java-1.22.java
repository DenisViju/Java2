import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Introdu primul numar: ");
            Integer numar1 = citesteNumar(scanner);

            System.out.print("Introdu al doilea numar: ");
            Integer numar2 = citesteNumar(scanner);

            if (numar1 == null || numar2 == null) {
                System.out.println("Eroare: Cel putin un numar este invalid (null).");
                return;
            }

            int suma = numar1 + numar2;
            System.out.println("Suma: " + suma);

        } catch (InputMismatchException e) {
            System.out.println("Eroare: Introdu doar numere intregi!");
        } finally {
            scanner.close();
        }
    }

    private static Integer citesteNumar(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.next();
            return null;
        }
    }
}