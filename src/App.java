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
    private ArrayList<ArrayList<Integer>> matriz = new ArrayList<>();
    private ArrayList<Integer> linha1 = new ArrayList<>();
    private ArrayList<Integer> linha2 = new ArrayList<>();
    private ArrayList<Integer> linha3 = new ArrayList<>();

    //automatizar processo,  para cada linha -> criar um arraaylist com as distancias e adicionar na matriz 

    public void execute() {
        
        readFirstLine();
        numeroDasCidades();
        System.out.println("DIGITE O NUMERO DA PRIMEIRA CIDADE :");

        

    }

    public void readFirstLine() {
        try (Scanner scanner = new Scanner(new File("resources/DNIT-Distancias.csv"))) {
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

    public void numeroDasCidades(){
        System.out.println("=========================================================================");
        System.out.println("NÚMEROS DAS CIDADES");
        System.out.println("=========================================================================");
        int cont = 1;
        for(int i = 0; i < names.size(); i++){
            System.out.println(cont + " - " + names.get(i) );
            cont++;
        }
        System.out.println("=========================================================================");
    }


}
