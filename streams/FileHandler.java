package streams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileHandler {
    public static void main(String[] args) {
        String filePath = "streams/myFile.txt";
        String content = """
                Hello there 🫶🏼,
                This is a file content.
                I hope you like it.
                """;

        FileHandler.createFile(filePath);
        FileHandler.createDirectory(filePath);
        // FileHandler.readFileContent(filePath);
        FileHandler.writeToFile(filePath, content);
        FileHandler.writeToFile(filePath, "\n\n" + content, true);
        FileHandler.createDirectory("streams/myFolder");
        FileHandler.createDirectories("streams/folders/hiis/myFiles");

        FilenameFilter filter = (File dir, String name) -> {
            return name.contains(".");
        };

        String[] contents = new File("streams").list(filter);
        System.out.println("Contents of current directory:");
        for (String content1 : contents) {
            System.out.println(content1);
        }
    }

    public static Boolean createFile(String filePath) {
        File myFile = new File(filePath);
        System.out.println(myFile.getAbsolutePath());
        System.out.println(myFile.exists());
        System.out.println(myFile.canRead());
        Boolean created = false;
        try {
            created = myFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return created;
    }

    public static void createDirectory(String directoryPath) {
        File myDirectory = new File(directoryPath);
        myDirectory.mkdir();
    }

    public static void createDirectories(String directoryPath) {
        File myDirectory = new File(directoryPath);
        myDirectory.mkdirs();
    }

    public static void readFileContent(String filePath) {
        File file = new File(filePath);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void writeToFile(String filePath, String content) {
        FileHandler.writeToFile(filePath, content, false);
    }

    public static void writeToFile(String filePath, String content, Boolean append) {
        File file = new File(filePath);
        try {
            FileWriter fileWriter = new FileWriter(file, append);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFileOrDirectory(String path) {
        File file = new File(path);
        file.delete();
    }
}
