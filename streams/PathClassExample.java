package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathClassExample {
    public static void main(String[] args) {
        Path path = Paths.get("hello.txt");
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(path.toAbsolutePath());
        System.out.println(path.getParent());
        System.out.println(path.getRoot());
        System.out.println(path.getFileName());

        Path source = Paths.get("hello23.txt");
        Path dest = Paths.get("hi.txt");
        
        try {
            if (Files.exists(dest)) {
                System.out.println("Destination file already exists, deleting it...");
                Files.delete(dest);
            }
            if (!Files.exists(source)) {
                System.out.println("Source file does not exist, creating it...");
                Files.createFile(source);
                return;
            }
            Files.copy(source, dest);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
