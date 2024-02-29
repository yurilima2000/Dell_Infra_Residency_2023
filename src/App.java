import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {

    private ArrayList<String> names = new ArrayList<>();

    public void execute() {
        readFirstLine();
        System.out.println(names);
    }



    public void readFirstLine() {

        try (Scanner scanner = new Scanner(new File("resources\\DNIT-Distancias.csv"))) {
            scanner.useDelimiter(",");

            if (scanner.hasNextLine()) {
                String firstLine = scanner.nextLine();
                ArrayList<String> names = new ArrayList<>(Arrays.asList(firstLine.split(";")));
                this.names = names;
            } else {
                System.out.println("The file is empty.");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }




    public void readAndPrintCSV() {        





        try (BufferedReader reader = new BufferedReader(new FileReader("DNIT-Distancias.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Use StringTokenizer ou split() para dividir a linha em campos
                String[] fields = line.split(",");
                // Imprima os campos
                for (String field : fields) {
                    System.out.print(field + " ");
                }
                System.out.println(); // Nova linha para a próxima linha do CSV
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
