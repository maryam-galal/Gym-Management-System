package PACKK;

import java.io.*;
import java.nio.file.*;

import java.util.*;


public class Admin extends Person {
    public void search_customer() throws IOException {
        String path = "Customer.txt";
        String line = "";
        String name;
        Scanner enter = new Scanner(System.in);
        System.out.println("Enter name: ");
        name = enter.next();
        BufferedReader br = new BufferedReader(new FileReader(path));
        while ((line = br.readLine()) != null){
            String[] values = line.split(",");

            if (values.length > 0 && values[1].equals(name)) {
                System.out.println("Found customer:");
                System.out.println(line);
                break;
            }
        }
        br.close();
    }

    public void search_coach() throws IOException {
        String path = "Coach.txt";
        String line = "";
        String name;
        Scanner enter = new Scanner(System.in);
        System.out.println("Enter name: ");
        name = enter.next();
        BufferedReader br = new BufferedReader(new FileReader(path));
        while ((line = br.readLine()) != null){
            String[] values = line.split(",");

            if (values.length > 0 && values[1].equals(name)) {
                System.out.println("Found Coach:");

                System.out.print(values[0] + " , ");
                System.out.print(values[1]);

                for (int i = 5; i < values.length; i++) {
                    System.out.print(", " + values[i]);
                }
                System.out.println();
                break;
            }
        }
        br.close();
    }

    public void edit_customer() throws IOException {

        String path = "Customer.txt";
        String tempFile = "editCustomer.txt";

        String line = "";
        String name;
        int number;

        Scanner enter = new Scanner(System.in);
        System.out.println("Enter name: ");
        name = enter.next();

        boolean found = false;


        System.out.println("Choose the number you want to edit: ");//0(id),1(name)....
        number = enter.nextInt();

        BufferedReader br = new BufferedReader(new FileReader(path));
        BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));

        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");

            if (values.length > 0 && values[1].equals(name)) {
                found=true;
                System.out.println("Edit customer:");
                switch (number) {
                    case 1:
                        System.out.println("Enter new Name: ");
                        values[1] = enter.next();
                        break;
                    case 2:
                        System.out.println("Enter new Password: ");
                        values[2] = enter.next();
                        break;
                    case 3:
                        System.out.println("Enter new address: ");
                        values[4] = enter.next();
                        break;
                    case 4:
                        System.out.println("Enter new phone number: ");
                        values[5] = enter.next();
                        break;
                    case 5:
                        System.out.println("Enter new email: ");
                        values[6] = enter.next();
                        break;

                }

                // Reconstruct the modified line
                String modifiedLine = String.join(",", values);
                bw.write(modifiedLine);

            }
            else if(!found){
                System.out.println("you entered the wrong name");
                edit_customer();
            }
            else {
                // Write the original line if no modifications were made
                bw.write(line);
            }
            bw.newLine(); // Move to the next line in the file
        }

        br.close();
        bw.close();

        //rename edit

    }
    //make edit coach
    public void customer_delete() throws IOException {
        File file = new File("Customer.txt");
        File tempFile = new File("deleteFile.txt");

        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String line;
        boolean found = false;

        String nameToDelete;
        Scanner enter = new Scanner(System.in);
        System.out.println("Enter name: ");
        nameToDelete = enter.next();

        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");

            if (values.length > 0 && values[1].equals(nameToDelete)) {
                found = true;
                System.out.println("Deleted customer: " + line);
                continue; // Skip writing this line (delete the row)
            }

            writer.write(line + System.getProperty("line.separator")); // Write line to the temp file
        }

        writer.close();
        reader.close();

        //handle if want to delete another customer or the customer you want was already deleted
        if (!found) {
            tempFile.delete(); // Delete the temp file if the row was not found
            System.out.println("Customer not found.");
            customer_delete();
        }
    }
}
