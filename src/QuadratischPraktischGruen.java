public class QuadratischPraktischGruen {
    public static void main(String[] args) throws Exception {
        
        int anzahlInteresenten;
        int grundstücky;
        int grundstückx;

        String file = "C:\\Users\\Jonathan salomo\\Documents\\Programiren\\Informatik Wettbewerb\\BWINF 2024\\Runde 1\\Quadratisch-praktisch-gruen\\data\\garten0.txt";
        FileReaderx fileReaderx = new FileReaderx();
        

        anzahlInteresenten = fileReaderx.readLine(file, 1);
        grundstückx = fileReaderx.readLine(file, 2);
        grundstücky = fileReaderx.readLine(file, 3);

        System.out.println(anzahlInteresenten);
        System.out.println(grundstückx);
        System.out.println(grundstücky);

        float anzahlInteresentenUpper = anzahlInteresenten + (anzahlInteresenten/100)*10;

        EuklidischerAlgorithmus euklidischerAlgorithmus = new EuklidischerAlgorithmus();
        int[] kleinstegemeinsameTeilerGrundstück = euklidischerAlgorithmus.gemeinsameTeilerFinden(grundstückx, grundstücky);
        
        int sinfollsterKleinstegemeinsamerTeilerGrundstück = 0;
        
        for(int i = 0; i > kleinstegemeinsameTeilerGrundstück.length-1; i++){

            if (i+1 < kleinstegemeinsameTeilerGrundstück.length-1){
                if (anzahlInteresentenUpper - ((grundstückx/kleinstegemeinsameTeilerGrundstück[i])*(grundstücky/kleinstegemeinsameTeilerGrundstück[i])) < anzahlInteresentenUpper - ((grundstückx/kleinstegemeinsameTeilerGrundstück[i])*(grundstücky/kleinstegemeinsameTeilerGrundstück[i])) || anzahlInteresentenUpper - ((grundstückx/kleinstegemeinsameTeilerGrundstück[i]+1)*(grundstücky/kleinstegemeinsameTeilerGrundstück[i]+1)) < 0){
                    sinfollsterKleinstegemeinsamerTeilerGrundstück = kleinstegemeinsameTeilerGrundstück[i];
                }
            }else {
                sinfollsterKleinstegemeinsamerTeilerGrundstück = kleinstegemeinsameTeilerGrundstück[i];
            }
        }

        float kleingartenLängex = sinfollsterKleinstegemeinsamerTeilerGrundstück;
        float kleingartenLängey = sinfollsterKleinstegemeinsamerTeilerGrundstück;

        while( anzahlInteresentenUpper - ((grundstückx/kleingartenLängex)*(grundstücky/kleingartenLängey)) < 0 || anzahlInteresenten - ((grundstückx/kleingartenLängex)*(grundstücky/kleingartenLängey)) > 0){
            if (anzahlInteresenten - ((grundstückx/kleingartenLängex)*(grundstücky/kleingartenLängey)) > 0){
                if ( kleingartenLängex > kleingartenLängey || grundstückx > grundstücky){
                    kleingartenLängex = kleingartenLängex - kleingartenLängex/(grundstückx/kleingartenLängex);
                }else if ( kleingartenLängex < kleingartenLängey || grundstückx < grundstücky) {
                    kleingartenLängey = kleingartenLängey - kleingartenLängey/(grundstücky/kleingartenLängey);
                }
            }
        }

        System.out.println("Jeder Kleingarten hat eine Breite von " + kleingartenLängex +" und eine Länge von " + kleingartenLängey + ".");
        System.out.println("Dies sorgt für eine Abweichung der Kanten vom perfekten Quadrat von:" + (kleingartenLängex - kleingartenLängey));
        System.out.println("Insgesamt gibt es " + (grundstückx/kleingartenLängex)*(grundstücky/kleingartenLängey) + " Kleingärten.");
        System.out.println("Dies sind " + (anzahlInteresenten - (grundstückx/kleingartenLängex)*(grundstücky/kleingartenLängey)) + " mehr als es Intressenten gibt. ( " + ((grundstückx/kleingartenLängex)*(grundstücky/kleingartenLängey)/(anzahlInteresenten/100)) + " Prozent mehr.)");
    }
}
