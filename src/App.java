import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {

    private ArrayList<String> names;
    private String[][] matrix;

    public void execute() {
        createNames();
        createMatrix();
        calculateDistance();

    }

    public void calculateDistance() {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < names.size(); i++) {
            System.out.print(i + "-" + names.get(i) + "| ");
        }
        System.out.println();

        System.out.println("Digite o numero correspondente a primeira cidade: ");
        int x = in.nextInt();
        System.out.println("Agora digite o numero da segunda cidade: ");
        int y = in.nextInt();

        System.out.println("Calculando distancia entre " + names.get(x).toUpperCase() + "e "
                + names.get(y).toUpperCase());

        for(int i = 0; i < 4; i++){
            System.out.println(".");
            try {
                Thread.sleep(1000); // 1000 milissegundos = 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String valor = matrix[x][y].trim();

        int distancia = Integer.parseInt(valor);
        System.out.println("DISTANCIA: " + distancia);
        in.close();
    }

    public void createNames() {
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

    public void createMatrix() {

        try (BufferedReader reader = new BufferedReader(new FileReader("resources\\DNIT-Distancias.csv"))) {
            // Pular a primeira linha (cabeçalho)
            reader.readLine();

            // Inicializar uma lista para armazenar as linhas restantes
            List<String[]> linhas = new ArrayList<>();

            // Ler as linhas do arquivo e adicionar à lista
            String linha;
            while ((linha = reader.readLine()) != null) {
                // Dividir a linha usando a vírgula como delimitador
                String[] dados = linha.split(";");
                linhas.add(dados);
            }

            // Converte a lista para uma matriz
            String[][] matrix = linhas.toArray(new String[0][]);
            this.matrix = matrix;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
