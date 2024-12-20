
import javax.swing.*;
public class QuadratischPraktischGruen {
    public static void main(String[] args) throws Exception {
        
        int anzahlInteresenten;
        int grundstücky;
        int grundstückx;

        String file = "data\\garten5.txt";
        FileReaderx fileReaderx = new FileReaderx();
        

        anzahlInteresenten = fileReaderx.readLine(file, 1);
        grundstückx = fileReaderx.readLine(file, 2);
        grundstücky = fileReaderx.readLine(file, 3);

        float anzahlInteresentenUpper = anzahlInteresenten + (anzahlInteresenten / 100.0f) * 10;

        EuklidischerAlgorithmus euklidischerAlgorithmus = new EuklidischerAlgorithmus();
        int[] kleinstegemeinsameTeilerGrundstück = euklidischerAlgorithmus.gemeinsameTeilerFinden(grundstückx, grundstücky);
        
        int sinfollsterKleinstegemeinsamerTeilerGrundstück = 0;

        Printer printer = new Printer();
        printer.outArray1int(kleinstegemeinsameTeilerGrundstück);
        
        for(int i = 0; i < kleinstegemeinsameTeilerGrundstück.length; i++){
            try {
                if (anzahlInteresentenUpper - ((grundstückx/kleinstegemeinsameTeilerGrundstück[i])*(grundstücky/kleinstegemeinsameTeilerGrundstück[i])) < (anzahlInteresenten / 100.0f) * 10 || anzahlInteresentenUpper - ((grundstückx/kleinstegemeinsameTeilerGrundstück[i]+1)*(grundstücky/kleinstegemeinsameTeilerGrundstück[i]+1)) < 0){
                    sinfollsterKleinstegemeinsamerTeilerGrundstück = kleinstegemeinsameTeilerGrundstück[i];
                }
            } catch (Exception e) {
                sinfollsterKleinstegemeinsamerTeilerGrundstück = kleinstegemeinsameTeilerGrundstück[i];
            }
        }

        System.out.println(sinfollsterKleinstegemeinsamerTeilerGrundstück);

        double kleingartenLängex = sinfollsterKleinstegemeinsamerTeilerGrundstück;
        double kleingartenLängey = sinfollsterKleinstegemeinsamerTeilerGrundstück;

        System.out.println("--------------------------------------------------------------------------------------------------------------------");

        System.out.println("grundstückx: " + grundstückx +"m");
        System.out.println("grundstücky: " +grundstücky +"m");
        System.out.println("kleingartenLängex: "+kleingartenLängex +"m");
        System.out.println("kleingartenLängey: "+kleingartenLängey +"m");
        System.out.println("Gärten: "+((grundstückx/kleingartenLängex)*(grundstücky/kleingartenLängey)));
        System.out.println("Interesenten: "+anzahlInteresenten);
        System.out.println("Interesenten_upper: "+anzahlInteresentenUpper);

        System.out.println("--------------------------------------------------------------------------------------------------------------------");

        int lastStep = 0;
        int xStep = 0;
        int yStep = 0;
        double kleingährten = (grundstückx/kleingartenLängex)*(grundstücky/kleingartenLängey);

        while((anzahlInteresentenUpper - ((grundstückx/kleingartenLängex)*(grundstücky/kleingartenLängey)) < 0 || anzahlInteresenten - ((grundstückx/kleingartenLängex)*(grundstücky/kleingartenLängey)) > 0)) {
            

            if (anzahlInteresenten - ((grundstückx/kleingartenLängex)*(grundstücky/kleingartenLängey)) > 0) {
                if (kleingartenLängex >= kleingartenLängey && lastStep != 4 && xStep != 1|| lastStep == 3) {
                    kleingartenLängex = kleingartenLängex - (kleingartenLängex/((grundstückx/kleingartenLängex)+1));
                    lastStep = 1;
                    xStep = -1;
                } else if (kleingartenLängex <= kleingartenLängey && lastStep != 3 && yStep != 1|| lastStep == 4) {
                    kleingartenLängey = kleingartenLängey - (kleingartenLängey/((grundstücky/kleingartenLängey)+1));
                    lastStep = 2;
                    yStep = -1;
                } else if (grundstückx/kleingartenLängex > grundstücky/kleingartenLängey){
                    kleingartenLängex = kleingartenLängex - (kleingartenLängex/((grundstückx/kleingartenLängex)+1));
                    lastStep = 1;
                    xStep = -1;
                } else if (grundstückx/kleingartenLängex < grundstücky/kleingartenLängey){
                    kleingartenLängey = kleingartenLängey - (kleingartenLängey/((grundstücky/kleingartenLängey)+1));
                    lastStep = 2;
                    yStep = -1;
                }
            } else if (anzahlInteresentenUpper - ((grundstückx/kleingartenLängex)*(grundstücky/kleingartenLängey)) < 0) {
                if (kleingartenLängex >= kleingartenLängey && lastStep != 2 && yStep != -1|| lastStep == 1) {
                    kleingartenLängey = kleingartenLängey + (kleingartenLängey/((grundstücky/kleingartenLängey)-1));
                    lastStep = 3;
                    yStep = 1;
                } else if (kleingartenLängex <= kleingartenLängey && lastStep != 1 && xStep != -1|| lastStep == 2) {
                    kleingartenLängex = kleingartenLängex + (kleingartenLängex/((grundstückx/kleingartenLängex)-1));
                    lastStep = 4;
                    xStep = 1;
                } else if (grundstückx/kleingartenLängex > grundstücky/kleingartenLängey){
                    kleingartenLängex = kleingartenLängex + (kleingartenLängex/((grundstückx/kleingartenLängex)-1));
                    lastStep = 4;
                    xStep = 1;
                } else if (grundstückx/kleingartenLängex < grundstücky/kleingartenLängey){
                    kleingartenLängey = kleingartenLängey + (kleingartenLängey/((grundstücky/kleingartenLängey)-1));
                    lastStep = 3;
                    yStep = 1;
                }
            }
            kleingährten = (grundstückx/kleingartenLängex)*(grundstücky/kleingartenLängey);
        }

        System.out.println("Jeder Kleingarten hat eine Breite von " + kleingartenLängex +"m und eine Länge von " + kleingartenLängey + "m.");
        System.out.println("Dies sorgt für eine Abweichung der Kanten vom perfekten Quadrat von: " + (kleingartenLängex - kleingartenLängey) + "m (" + abweichung(kleingartenLängex, kleingartenLängey) + " Prozent)");
        System.out.println("Insgesamt gibt es " + Math.floor((grundstückx/kleingartenLängex)*(grundstücky/kleingartenLängey)) + " Kleingärten.");
        System.out.println("Dies sind " + Math.floor((((grundstückx/kleingartenLängex)*(grundstücky/kleingartenLängey))- anzahlInteresenten)) + " mehr als es Intressenten gibt.(" + String.format("%.5f", ((grundstückx/kleingartenLängex)*(grundstücky/kleingartenLängey)/(anzahlInteresenten/100.0f))-100) + " Prozent)");
        
        System.out.println("--------------------------------------------------------------------------------------------------------------------");

        kontröler(grundstückx, grundstücky, kleingartenLängex, kleingartenLängey);

        vis(grundstückx, grundstücky, kleingartenLängex, kleingartenLängey, anzahlInteresenten);

    }

    private static double abweichung(double kleingartenLängex, double kleingartenLängey){
        double proAbweichung = 0;

        proAbweichung = ((kleingartenLängex - kleingartenLängey) / Math.max(kleingartenLängey, kleingartenLängex)) * 100;

        return proAbweichung;
    }

    private static void kontröler(int grundstückx, int grundstücky, double kleingartenLängex, double kleingartenLängey){ 
        	if ((grundstückx/kleingartenLängex) - (int) (grundstückx/kleingartenLängex) > 0){
                System.err.println("Die Aufteilung der x Achse ist um " + String.format("%.20f", 1.0 - ((grundstückx / kleingartenLängex) - (int) (grundstückx / kleingartenLängex))) + "m ungenau.");
                System.err.println("Es bleiben auf der X Achse also am Nach der Aufteilung der Kleingährten " + String.format("%.20f", 1.0 - ((grundstückx / kleingartenLängex) - (int) (grundstückx / kleingartenLängex))) + "m an Land übrig.");
            } 
            if ((grundstücky/kleingartenLängey) - (int) (grundstücky/kleingartenLängey) > 0){
                System.err.println("Die Aufteilung der y Achse ist um " + String.format("%.20f", 1.0 - ((grundstücky / kleingartenLängey) - (int) (grundstücky / kleingartenLängey))) + "m ungenau.");
                System.err.println("Es bleiben auf der Y Achse also am Nach der Aufteilung der Kleingährten " + String.format("%.20f", 1.0 - ((grundstückx / kleingartenLängex) - (int) (grundstückx / kleingartenLängex))) + "m an Land übrig.");
            }
            if ((grundstücky/kleingartenLängey) - (int) (grundstücky/kleingartenLängey) > 0 || (grundstückx/kleingartenLängex) - (int) (grundstückx/kleingartenLängex) > 0){
                System.out.println("--------------------------------------------------------------------------------------------------------------------");
            }
    }

    private static void vis(int grundstueckX, int grundstueckY, double kleingartenLängeX, double kleingartenLängeY, int anzahlInteressenten){

        JFrame frame = new JFrame("Kleingarten Visualisierung");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Erstelle die Visualisierungskomponente
        KleingartenVisualisierung visualisierung = new KleingartenVisualisierung(grundstueckX,  grundstueckY,  kleingartenLängeX,  kleingartenLängeY,  anzahlInteressenten);

        // ScrollPane hinzufügen
        JScrollPane scrollPane = new JScrollPane(visualisierung);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // ScrollPane dem Frame hinzufügen
        frame.add(scrollPane);

        // Größe des Frames festlegen und sichtbar machen
        frame.setSize(800, 600);  // Frame-Größe anpassen
        frame.setVisible(true);
    }
}
