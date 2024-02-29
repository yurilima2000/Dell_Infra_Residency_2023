import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
  
    public void execute(){
        nomes();
    }



    public void nomes(){

        try (Scanner scanner = new Scanner(new File("C:\\Users\\yuri-oliveira\\Desktop\\InfraResidency\\src\\DNIT-Distancias.csv"))) {
            // Configurar o delimitador para vírgula (CSV padrão)
            scanner.useDelimiter(",");

            // Verificar se há pelo menos uma linha no arquivo
            if (scanner.hasNextLine()) {
                // Ler apenas a primeira linha
                String primeiraLinha = scanner.nextLine();
                System.out.println(primeiraLinha);
            } else {
                System.out.println("O arquivo está vazio.");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }




    public void readAndPrintCSV() {        

        ArrayList<String> nomes = new ArrayList<>();



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
