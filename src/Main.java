import java.io.*;

public class Main {
    public static void main(String[] args) {
        String sourceFilePath = "source.txt";
        String targetFilePath = "target.txt";
        copyFileReplacingSpaces(sourceFilePath, targetFilePath);
    }
    public static void copyFileReplacingSpaces(String sourceFilePath, String targetFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(targetFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String modifiedLine = line.replace(" ", "-");
                writer.write(modifiedLine);
                writer.newLine();
            }

            System.out.println("Plik został pomyślnie skopiowany z zamianą spacji na myślniki.");
        } catch (IOException e) {
            System.err.println("Wystąpił błąd podczas operacji na plikach: " + e.getMessage());
        }
    }
}