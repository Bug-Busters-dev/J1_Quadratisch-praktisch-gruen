
import java.io.*;

public class FileReaderx {
    static int anfangsZeile = 0;

    public int readLine(String file, int zeile) {
        int inhalt = 0;

        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {

                for (int i = 0; i < zeile; i++) {
                    String zinhalt = br.readLine();
                
                    if (zinhalt == null) {
                        break;
                    }

                    try {
                        inhalt = Integer.parseInt(zinhalt.trim()); 
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        System.err.println("Die Datei hat nicht das richtige Format.");
                    }
                
                }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("Datei existiert nicht.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Lesen hat nicht geklappt.");
        }
        return inhalt;
    }
}
