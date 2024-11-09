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
        
        for(int i = 0; i < kleinstegemeinsameTeilerGrundstück.length; i++){
            try {
                if (anzahlInteresentenUpper - ((grundstückx/kleinstegemeinsameTeilerGrundstück[i])*(grundstücky/kleinstegemeinsameTeilerGrundstück[i])) < (anzahlInteresenten / 100.0f) * 10 || anzahlInteresentenUpper - ((grundstückx/kleinstegemeinsameTeilerGrundstück[i]+1)*(grundstücky/kleinstegemeinsameTeilerGrundstück[i]+1)) < 0){
                    sinfollsterKleinstegemeinsamerTeilerGrundstück = kleinstegemeinsameTeilerGrundstück[i];
                }
            } catch (Exception e) {
                sinfollsterKleinstegemeinsamerTeilerGrundstück = kleinstegemeinsameTeilerGrundstück[i];
            }
        }

        double kleingartenLängex = sinfollsterKleinstegemeinsamerTeilerGrundstück;
        double kleingartenLängey = sinfollsterKleinstegemeinsamerTeilerGrundstück;

        System.out.println("--------------------------------------------------------------------------------------------------------------------");

        System.out.println("grundstückx: " + grundstückx +"m");
        System.out.println("grundstücky: " +grundstücky +"m");
        System.out.println("kleingartenLängex (vor der weiteren Anpassung): "+kleingartenLängex +"m");
        System.out.println("kleingartenLängey (vor der weiteren Anpassung): "+kleingartenLängey +"m");
        System.out.println("Gärten (basierend auf den Längen vor der weiteren Anpassung): "+((grundstückx/kleingartenLängex)*(grundstücky/kleingartenLängey)));
        System.out.println("Interesenten: "+anzahlInteresenten);
        System.out.println("Interesenten_upper: "+anzahlInteresentenUpper);

        System.out.println("--------------------------------------------------------------------------------------------------------------------");

        int lastStep = 0;
        int xStep = 0;
        int yStep = 0;

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
        }

        System.out.println("Jeder Kleingarten hat eine Breite von " + kleingartenLängex +"m und eine Länge von " + kleingartenLängey + "m.");
        System.out.println("Dies sorgt für eine Abweichung der Kanten vom perfekten Quadrat von: " + (kleingartenLängex - kleingartenLängey) + "m (" + abweichung(kleingartenLängex, kleingartenLängey) + " Prozent)");
        System.out.println("Insgesamt gibt es " + Math.floor((grundstückx/kleingartenLängex)*(grundstücky/kleingartenLängey)) + " Kleingärten.");
        System.out.println("Dies sind " + Math.floor((((grundstückx/kleingartenLängex)*(grundstücky/kleingartenLängey))- anzahlInteresenten)) + " mehr als es Intressenten gibt.(" + String.format("%.5f", ((grundstückx/kleingartenLängex)*(grundstücky/kleingartenLängey)/(anzahlInteresenten/100.0f))-100) + " Prozent)");
        
        System.out.println("--------------------------------------------------------------------------------------------------------------------");

        kontröler(grundstückx, grundstücky, kleingartenLängex, kleingartenLängey);
    }

    private static double abweichung(double kleingartenLängex, double kleingartenLängey){
        double proAbweichung = 0;

        proAbweichung = ((kleingartenLängex - kleingartenLängey) / Math.max(kleingartenLängey, kleingartenLängex)) * 100;

        return proAbweichung;
    }

    private static void kontröler(int grundstückx, int grundstücky, double kleingartenLängex, double kleingartenLängey){ 
        	if ((grundstückx/kleingartenLängex) - (int) (grundstückx/kleingartenLängex) > 0){
                System.err.println("Die Aufteilung der x Achse ist um " + String.format("%.20f", (((grundstückx / kleingartenLängex) - (int) (grundstückx / kleingartenLängex))*kleingartenLängex)) + "m ungenau.");
                System.err.println("Es bleiben auf der X Achse also am Nach der Aufteilung der Kleingährten " + String.format("%.20f", (((grundstückx / kleingartenLängex) - (int) (grundstückx / kleingartenLängex))*kleingartenLängex)) + "m an Land übrig.");
                System.err.println("Dies ist auf die Kleingärten runtergerechnet eine Messungenauigkeit von : " + 
                String.format("%.20f", 
                ((((grundstückx / kleingartenLängex) - (int) (grundstückx / kleingartenLängex)) * kleingartenLängex) / 
                (grundstückx / kleingartenLängex)) * 100) + "cm");
            } 
            if ((grundstücky/kleingartenLängey) - (int) (grundstücky/kleingartenLängey) > 0){
                System.err.println("Die Aufteilung der y Achse ist um " + String.format("%.20f", (((grundstücky / kleingartenLängey) - (int) (grundstücky / kleingartenLängey))*kleingartenLängey)) + "m ungenau.");
                System.err.println("Es bleiben auf der Y Achse also am Nach der Aufteilung der Kleingährten " + String.format("%.20f", (((grundstücky / kleingartenLängey) - (int) (grundstücky / kleingartenLängey))*kleingartenLängex)) + "m an Land übrig.");
                System.err.println("Dies ist auf die Kleingärten runtergerechnet eine Messungenauigkeit von : " + 
                String.format("%.20f", 
                ((((grundstücky / kleingartenLängey) - (int) (grundstücky / kleingartenLängey)) * kleingartenLängey) / 
                (grundstücky / kleingartenLängey)) * 100) + "cm");
            }
            if ((grundstücky/kleingartenLängey) - (int) (grundstücky/kleingartenLängey) > 0 || (grundstückx/kleingartenLängex) - (int) (grundstückx/kleingartenLängex) > 0){
                System.out.println("--------------------------------------------------------------------------------------------------------------------");
            }
    }
}
