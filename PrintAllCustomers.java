
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PrintAllCustomers {

    public void printAll() {
        String file = "list.txt";
        try (Scanner use = new Scanner(new BufferedReader(new FileReader(file)))) {
            while (use.hasNextLine()) {
                String line = use.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
