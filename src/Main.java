import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {

        DirectoryStream.Filter<Path> filter =
                new DirectoryStream.Filter<Path>() {
                    public boolean accept(Path path) throws IOException {
                        return Files.isRegularFile(path);
                    }
                };
//        Path directory = FileSystems.getDefault().getPath("FileTree/Dir2/Dir3");
        Path directory = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2" + File.separator + "Dir3");

        try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter)) {
            for (Path file : contents) {
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException e) {
            System.out.println(e.getMessage());
        }

        String separator = File.separator;
        System.out.println(separator);
        separator = FileSystems.getDefault().getSeparator();
        System.out.println(separator);
    }
}
