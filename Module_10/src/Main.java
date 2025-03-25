import java.io.*;
import java.util.Scanner;

public class Main {


    private static final String FILE_PATH = "./Module_10/src/input.txt";
    private static final String EMPTY = "./Module_10/src/empty.txt";
    /*D:\Java\2025\java_Program\Module_10\src\input.txt*/
    private static final String INCORRECT_FILE_PATH = "./input1.txt";

    private static void readFile(String path) {
        File file = new File(path);
        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                Scanner scanner = new Scanner(fileInputStream);
        ) {
            String fileLine = scanner.nextLine();
            System.out.printf("'%s' read from file '%s'%n", fileLine, path);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("FileNotFound exception '" + path + "'");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("I/O exception for '" + path + "'");
        } finally {
            System.out.println("finally method for '" + path + "'");
        }
    }

    public static void myReadFile(String path) throws EmptyFileException {
        File file = new File(path);
        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                Scanner scanner = new Scanner(fileInputStream);
        ) {
            if (scanner.hasNextLine()) {
                String fileLine = scanner.nextLine();
                System.out.printf("'%s' read from file '%s'%n", fileLine, path);
            } else {
                throw new EmptyFileException("File is empty", path);
            }
        } catch (IOException ex) {
            throw new EmptyFileException("I/O exception occurred", ex, path);
        } finally {
            System.out.println("finally method for '" + path + "'");
        }
    }

    public static void main(String[] args) throws EmptyFileException {
        System.out.println("Текущая дериктория: " + System.getProperty("user.dir"));
        System.out.println("Корректный путь");
        try {
            myReadFile(FILE_PATH);
        } catch (EmptyFileException e) {
            System.out.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("НеКорректный путь");
        try {
            myReadFile(INCORRECT_FILE_PATH);
        } catch (EmptyFileException e) {
            System.out.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Пустой");
        try {
            myReadFile(EMPTY);
        } catch (EmptyFileException e) {
            System.out.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }

    }
}

