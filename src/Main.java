import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        // A tool which iterates over all the contents of an input directory, extracting all .zip files into
        // folders of the same name, along with all the contents therein

        Scanner input = new Scanner(System.in);
        System.out.println("Input complete filepath of the folder you wish to extract contents of.");
        String folderToBeExtracted = input.nextLine();

        File[] files = new File(folderToBeExtracted).listFiles();
        ShowFiles.showFiles(files);
}
}
