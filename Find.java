
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Find {

    public void find(String id) {
        boolean find = false;
        String file = "list.txt";
        try (Scanner use = new Scanner(new BufferedReader(new FileReader(file)))) {
            while (use.hasNextLine()) {
                String line = use.nextLine();
                String[] splitList = line.split(",");
                if (splitList[0].equals(id)) {
                    System.out.println(line);
                    find = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (find == false) {
            System.out.println("There is no such an id.");
        }
    }
}
