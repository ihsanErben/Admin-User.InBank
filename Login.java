
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {

    public boolean login() {
        String file = "list.txt";
        Scanner scn = new Scanner(System.in);
        System.out.print("id: ");
        String id = scn.next();
        System.out.print("password: ");
        String password = scn.next();

        try (Scanner use = new Scanner(new BufferedReader(new FileReader(file)))) {
            while (use.hasNextLine()) {
                String line = use.nextLine();
                String[] splitList = line.split(",");
                if (id.equals(splitList[0]) && password.equals(splitList[1])) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
