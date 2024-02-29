import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
  
    public void execute(){
        readAndPrintCSV();
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
