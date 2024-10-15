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

        System.err.println("---------------------------------------------------Start---------------------------------------------------");

        System.out.println("gewählter gemeinsamer Teiler: " + sinfollsterKleinstegemeinsamerTeilerGrundstück);

        float kleingartenLängex = sinfollsterKleinstegemeinsamerTeilerGrundstück;
        float kleingartenLängey = sinfollsterKleinstegemeinsamerTeilerGrundstück;

        System.out.println("grundstückx: " + grundstückx);
        System.out.println("grundstücky: " +grundstücky);
        System.out.println("kleingartenLängex: "+kleingartenLängex);
        System.out.println("kleingartenLängey: "+kleingartenLängey);
        System.out.println("Gärten: "+((grundstückx/kleingartenLängex)*(grundstücky/kleingartenLängey)));
        System.out.println("Interesenten: "+anzahlInteresenten);
        System.out.println("Interesenten_upper: "+anzahlInteresentenUpper);

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

        System.err.println("-----------------------------------------------------------------------------------------------------------");

        System.out.println("Jeder Kleingarten hat eine Breite von " + kleingartenLängex +" und eine Länge von " + kleingartenLängey + ".");
        System.out.println("Dies sorgt für eine Abweichung der Kanten vom perfekten Quadrat von:" + (kleingartenLängex - kleingartenLängey));
        System.out.println("Insgesamt gibt es " + (grundstückx/kleingartenLängex)*(grundstücky/kleingartenLängey) + " Kleingärten.");
        System.out.println("Dies sind " + (((grundstückx/kleingartenLängex)*(grundstücky/kleingartenLängey))- anzahlInteresenten) + " mehr als es Intressenten gibt.(" + (((grundstückx/kleingartenLängex)*(grundstücky/kleingartenLängey)/(anzahlInteresenten/100.0f))-100) + " Prozent)");
        
        kontröler(grundstückx, grundstücky, kleingartenLängex, kleingartenLängey);

        System.err.println("----------------------------------------------------End----------------------------------------------------");
    }

    private static void kontröler(int grundstückx, int grundstücky, float kleingartenLängex, float kleingartenLängey){ 
        	if ((grundstückx/kleingartenLängex) - (int) (grundstückx/kleingartenLängex) > 0.0009){
                System.err.println("Die Aufteilung der x Achse ist um " + ((grundstückx/kleingartenLängex) - (int) (grundstückx/kleingartenLängex)) + " ungenau.");
            } 
            if ((grundstücky/kleingartenLängey) - (int) (grundstücky/kleingartenLängey) > 0.0009){
                System.err.println("Die Aufteilung der y Achse ist um " + ((grundstücky/kleingartenLängey) - (int) (grundstücky/kleingartenLängey)) + " ungenau.");
            }
    }
}
