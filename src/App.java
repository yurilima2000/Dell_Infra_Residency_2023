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
        // readFirstLine();
        // System.out.println(names);
        linha1.add(1);
        linha1.add(2);
        linha1.add(3);
        linha2.add(4);
        linha2.add(5);
        linha2.add(6);
        linha3.add(7);
        linha3.add(8);
        linha3.add(9);
        matriz.add(linha1);
        matriz.add(linha2);
        matriz.add(linha3);

        for (ArrayList<Integer> linha : matriz) {
            for (int elemento : linha) {
                System.out.print(elemento + " ");
            }
            System.out.println(); 
        }       
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




}
