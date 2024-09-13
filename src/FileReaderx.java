
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FileReaderx {
    static int anfangsZeile = 0;

    public int[] readLine(String file, int zeile) {
        int[] inhalt = null;

        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {

            for (int i = 0; i < zeile; i++) {
                String zinhalt = br.readLine();
                anfangsZeile = i +1;

                if (zinhalt == null || zinhalt == "") {
                    break;
                }

                try {
                    String[] numbersAsString = zinhalt.split(" ");

                    inhalt = new int[numbersAsString.length];

                    for (int f = 0; f < numbersAsString.length; f++) {
                        inhalt[f] = Integer.parseInt(numbersAsString[f]);
                    }
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
 
    public int[][] redarray(String file, int anzahlStile, int zahlenproZeile){

        ArrayList<Integer[]> kombinationen = new ArrayList<Integer[]>();
        
        //System.out.println("anfangs Zeile:  " + anfangsZeile);

        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {

            for (int q = 0; q < anfangsZeile; q++) {
                br.readLine();
            }
            for (int q = 0; q < Math.pow(anzahlStile, 2) ; q++){
                String zinhalt = br.readLine();
                anfangsZeile = q+2;

                if (zinhalt == null) {
                        break;
                }

                try {
                    String[] numbersAsString = zinhalt.split(" ");

                    if (numbersAsString.length != zahlenproZeile) {
                        break;
                    }

                    Integer[] inhalt = new Integer[numbersAsString.length];

                    for (int f = 0; f < numbersAsString.length; f++) {
                        inhalt[f] = Integer.parseInt(numbersAsString[f]);
                    }
                    kombinationen.add(inhalt);

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

        int[][] kombiarray = new int[kombinationen.size()][zahlenproZeile];
        for (int i = 0; i < kombinationen.size(); i++) {
            kombiarray[i] = Arrays.stream(kombinationen.get(i)).mapToInt(Integer::intValue).toArray();
        }
        return kombiarray;
    }
}
