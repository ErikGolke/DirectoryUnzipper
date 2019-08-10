import java.io.File;
import java.io.IOException;

public class ShowFiles {

    // A utility class that iterates over all the files in an array of files, checking for zipped files.
    // If a zipped file is encountered, uses the Unzipper class to unzip the contents to a folder of the same
    // name

    public static void showFiles(File[] files) throws IOException {
        Unzipper unzip = new Unzipper();
        try {
            for (File file : files) {
                // checks to see if file is a directory
                if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                    // if the file is a directory, run next iteration
                    showFiles(file.listFiles());
                } else {
                    // if file is not a directory, checks if the file is a .zip file and extracts contents
                    if (file.getName().contains(".zip")) {
                        System.out.println("Unzipping " + file.getName());
                        unzip.unzip(file.getAbsolutePath(), file.getAbsolutePath());
                        System.out.println("Unzipped " + file.getName());
                    }

                }
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }
}
