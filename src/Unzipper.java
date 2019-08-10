import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

// Iterates over a zipped file, extracting all contents into a folder of the same name
public class Unzipper {
    // Set buffer size for read/write
    private static final int BUFFER_SIZE = 4096;

    public void unzip(String input, String output) throws IOException {
        // Creates folder for output, removing .zip extension
        File outDir = new File(output.replace(".zip", ""));
        // Check if folder already exists, if it doesn't, creates it
        if (!outDir.exists()) {
            outDir.mkdir();
        }
        // Get stream from zip file to be extracted
        ZipInputStream zipInput = new ZipInputStream(new FileInputStream(input));
        ZipEntry entry = zipInput.getNextEntry();
        // While there is still information to be read

        while(entry != null) {
            String filePath = outDir + File.separator + entry.getName();
            // if entry is a file, extract it
            if (!entry.isDirectory()) {
               extractFile(zipInput, filePath);
            // if it is a directory, create it
            } else {
                File dir = new File(filePath);
                dir.mkdir();
            }
            // close relevant entry, move to next one
            zipInput.closeEntry();
            entry = zipInput.getNextEntry();
        }
        zipInput.close();
    }

    private void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        // Iterate over zipped file, copying contents to unzipped file in the correct directory

        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn = new byte[BUFFER_SIZE];
        int read = 0;
        while ((read = zipIn.read(bytesIn)) != -1) {
            outputStream.write(bytesIn, 0, read);
        }
        outputStream.close();

    }
}
