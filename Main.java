
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("--------------------------------------------------------------------------");
        String file = "list.txt";
        Find find = new Find();
        PrintAllCustomers pac = new PrintAllCustomers();
        Scanner scn = new Scanner(System.in);
        int a = 1;
        while (a == 1) {
            System.out.println("1- admin");
            System.out.println("2- user");
            System.out.print("option: ");
            int option = scn.nextInt();
            if (option == 1) {
                int b = 1;

                System.out.print("admin id: ");
                String adminID = scn.next();
                System.out.print("admin password: ");
                String adminPassword = scn.next();
                if (!(adminID.equals("1808") && adminPassword.equals("1808"))) {
                    b = 0;
                    System.out.println("Admin id or password is wrong.");
                } else {
                    System.out.println("Admin panel was actived.");
                    System.out.println("--------------------------------------------------------------------------");
                }
                while (b == 1) {

                    System.out.println("1- Add customer");
                    System.out.println("2- Print all customers");
                    System.out.println("3- Update customer balance");
                    System.out.println("4- Find a customer");
                    System.out.print("option: ");
                    int opt = scn.nextInt();

                    if (opt == 1) {
                        try (BufferedWriter write = new BufferedWriter(new FileWriter(file, true))) {

                            System.out.print("New customer id: ");
                            String nci = scn.next();
                            System.out.print("New customer password: ");
                            String ncp = scn.next();
                            System.out.print("New customer balance: ");
                            int ncb = scn.nextInt();

                            write.newLine();
                            write.write(nci + "," + ncp + "," + ncb);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    } else if (opt == 2) {
                        pac.printAll();
                    } else if (opt == 3) {

                        System.out.print("Customer id: ");
                        String cID = scn.next();

                        boolean finded = false;
                        try (Scanner use = new Scanner(new BufferedReader(new FileReader(file))); BufferedWriter write = new BufferedWriter(new FileWriter(file, true))) {

                            while (use.hasNextLine()) {
                                String line = use.nextLine();
                                String[] splitList = line.split(",");
                                if (splitList[0].equals(cID)) {
                                    System.out.print("The customer's new balance: ");
                                    String NewBalance = scn.next();
                                    write.write(splitList[0] + "," + splitList[1] + "," + NewBalance);
                                    System.out.println("The customer balance was updated.");
                                    finded = true;
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        if (finded == false) {
                            System.out.println("There is no such an id.");
                        }

                    } else if (opt == 4) {
                        System.out.print("Customer id: ");
                        String cID = scn.next();
                        find.find(cID);
                    } else if (opt == 0) {
                        b = 0;
                        break;
                    }
                    System.out.println("-----------------------------");
                }

            } else if (option == 2) {
                int c = 1;
                boolean go = false;
                int balance = 5;
                System.out.print("user id: ");
                String userID = scn.next();
                System.out.print("user password: ");
                String userPassword = scn.next();

                try (Scanner sc = new Scanner(new BufferedReader(new FileReader(file)))) {
                    while (sc.hasNextLine()) {
                        String line = sc.nextLine();
                        String[] listArray = line.split(",");

                        if (userID.equals(listArray[0]) && userPassword.equals(listArray[1])) {
                            balance = Integer.valueOf(listArray[2]);
                            go = true;
                        }

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("--------------------------------------------------------------------------");

                if (go == true) {
                    while (c == 1) {
                        System.out.println("1- Display my balance");
                        System.out.print("option: ");
                        int op = scn.nextInt();
                        if (op == 1) {
                            System.out.println("balance: " + balance);
                        }else if(op == 0){
                            c = 0;
                            go = false;
                        }
                        System.out.println("-----------------------------");
                    }
                } else {
                    System.out.println("User id or password is wrong.");
                }

            } else if (option == 0) {
                return;
            }
            System.out.println("--------------------------------------------------------------------------");
        }
    }
}
