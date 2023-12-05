package com.example.mainpage;
import java.io.*;
public class file_Creation {
    public static void main(String[] args) {
        try {
            // Creating a file with a specific path
            File file = new File("C:\\Users\\Mariam\\IdeaProjects\\mainpage\\src\\main\\java\\com\\example\\mainpage\\Gyminfo_class.txt");
            boolean fileCreated = file.createNewFile();
            System.out.println("File created: " + fileCreated);

            // Writing to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Mariam\\IdeaProjects\\mainpage\\src\\main\\java\\com\\example\\mainpage\\Gyminfo_class.txt"));
            writer.write("Fitness Gym \n");
            writer.write("Cairo,Nasr city, Makram Ebeid  \n");
            writer.write("01148272855\n");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
