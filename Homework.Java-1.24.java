import java.io.*;
import java.util.*;

public class SumIntegersFromFile {
    public static void main(String[] args) {
        String filePath = "input.txt"; 
        int sum = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\s+"); 
                for (String token : tokens) {
                    try {
                        sum += Integer.parseInt(token);
                    } catch (NumberFormatException ignored) {

                    }
                }
            }
            System.out.println("Suma numerelor intregi din fisier: " + sum);
        } catch (FileNotFoundException e) {
            System.err.println("Fisierul nu a fost gasit: " + filePath);
        } catch (IOException e) {
            System.err.println("Eroare la citirea fisierului: " + e.getMessage());
        }
    }
}
