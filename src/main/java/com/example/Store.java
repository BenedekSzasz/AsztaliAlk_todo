package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store {
    private static String fileName = "todo.txt";
    public static List<String> readFile() {
        try {
            return tryReadFile();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    private static List<String> tryReadFile() throws FileNotFoundException {
        File file = new File(fileName);
        List<String> todoList = new ArrayList<>();
        try(Scanner sc = new Scanner(file, "UTF-8");){
            while (sc.hasNext()) {
                todoList.add(sc.nextLine());
            }
        }
        return todoList;
    }

    public static void appendTodoToFile(String todo) {
        try {
            tryAppendTodoToFile(todo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void tryAppendTodoToFile(String todo) throws IOException {
        try (FileWriter writer = new FileWriter(
            fileName,
            Charset.forName("UTF-8"),
            true
         );) {
            {
             writer.write(todo);
             writer.write("\n");
            }
        }
    }

    public static void writeAllToFile(List<String> todoList) {
        try(FileWriter writer = new FileWriter(
            fileName, 
            Charset.forName("UTF-8"), 
            false)){ {
                for(String todo : todoList) {
                    writer.write(todo);
                    writer.write("\n");
                }
            }
         } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unused")
    private static void tryWriteAllToFile(List<String> todoList) throws IOException {
        try (FileWriter writer = new FileWriter(
            fileName,
            Charset.forName("UTF-8"),
            false
         );) {
            {
             for(String todo : todoList) {
                 writer.write(todo);
                 writer.write("\n");
                }
            
            }
        }

    }
}
