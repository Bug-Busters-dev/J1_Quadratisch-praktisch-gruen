public class QuadratischPraktischGruen {
    public static void main(String[] args) throws Exception {
        
        int anzahlInteresenten;
        int grundstücky;
        int grundstückx;

        String file = "C:\\Users\\Jonathan salomo\\Documents\\Programiren\\Informatik Wettbewerb\\BWINF 2024\\Runde 1\\Quadratisch-praktisch-gruen\\data\\garten0.txt";
        FileReaderx fileReaderx = new FileReaderx;
        

        anzahlInteresenten = fileReaderx.readLine(file; 1);
        grundstückx = fileReaderx.readLine(file; 2);
        grundstücky = fileReaderx.readLine(file; 3);

        System.out.println(anzahlInteresenten);
        System.out.println(grundstückx);
        System.out.println(grundstücky);
        

    }
}
