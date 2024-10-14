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

        float kleingartenLängex = sinfollsterKleinstegemeinsamerTeilerGrundstück;
        float kleingartenLängey = sinfollsterKleinstegemeinsamerTeilerGrundstück;

        System.out.println("grundstückx: " + grundstückx);
        System.out.println("grundstücky: " +grundstücky);
        System.out.println("kleingartenLängex: "+kleingartenLängex);
        System.out.println("kleingartenLängey: "+kleingartenLängey);
        System.out.println("Gärten: "+((grundstückx/kleingartenLängex)*(grundstücky/kleingartenLängey)));
        System.out.println("Interesenten: "+anzahlInteresenten);
        System.out.println("Interesenten_upper: "+anzahlInteresentenUpper);

        while( anzahlInteresentenUpper - ((grundstückx/kleingartenLängex)*(grundstücky/kleingartenLängey)) < 0 || anzahlInteresenten - ((grundstückx/kleingartenLängex)*(grundstücky/kleingartenLängey)) > 0 ){
            if (anzahlInteresenten - ((grundstückx/kleingartenLängex)*(grundstücky/kleingartenLängey)) > 0){
                if ( kleingartenLängex >= kleingartenLängey){
                    kleingartenLängex = kleingartenLängex - (kleingartenLängex/((grundstückx/kleingartenLängex)+1));
                }else if ( kleingartenLängex <= kleingartenLängey) {
                    kleingartenLängey = kleingartenLängey - (kleingartenLängey/((grundstücky/kleingartenLängey)+1));
                }
            }else if (anzahlInteresentenUpper - ((grundstückx/kleingartenLängex)*(grundstücky/kleingartenLängey)) < 0){
                if ( kleingartenLängex <= kleingartenLängey) {
                    kleingartenLängey = kleingartenLängey + (kleingartenLängey/((grundstücky/kleingartenLängey)-1));
                }else if ( kleingartenLängex >= kleingartenLängey){
                    kleingartenLängex = kleingartenLängex + (kleingartenLängex/((grundstückx/kleingartenLängex)-1));
                }
            }
        }

        System.out.println("Jeder Kleingarten hat eine Breite von " + kleingartenLängex +" und eine Länge von " + kleingartenLängey + ".");
        System.out.println("Dies sorgt für eine Abweichung der Kanten vom perfekten Quadrat von:" + (kleingartenLängex - kleingartenLängey));
        System.out.println("Insgesamt gibt es " + (grundstückx/kleingartenLängex)*(grundstücky/kleingartenLängey) + " Kleingärten.");
        System.out.println("Dies sind " + (anzahlInteresenten - (grundstückx/kleingartenLängex)*(grundstücky/kleingartenLängey)) + " mehr als es Intressenten gibt.(" + (((grundstückx/kleingartenLängex)*(grundstücky/kleingartenLängey)/(anzahlInteresenten/100.0f))-100) + " Prozent)");
        

        new KleingartenVisualisierung(grundstückx, grundstücky, kleingartenLängex, kleingartenLängey, anzahlInteresenten);

    }
}
