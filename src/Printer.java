public class Printer {

    public void outArray2String(String[][] matrix){
    
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                if (matrix[i][j].length() < 2){
                    System.out.print(matrix[i][j]+"  ");    
                } else{
                    System.out.print(matrix[i][j]+" ");
                }   
                }
            System.out.println();
        }
    }

    public void outArray2int(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int outArray2Kleidung(int[][] matrix) {
        int anzahl = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][2] != 0){
                System.out.println(" Sorte: " + matrix[i][0] + " Stiel: " + matrix[i][1] + " Anzahl übrig: " + matrix[i][2]);
                anzahl += matrix[i][2];
            }
        }
        System.out.println("Die Anzahl der übriggeblieben Kleidungstücke: " + anzahl);
        return anzahl;
    }
    public int outArray2KleidungforGröße(int[][] matrix) {
        int anzahl = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][2] != 0){
                System.out.println(" Sorte: " + matrix[i][0] + " Stiel: " + matrix[i][1] + " Anzahl übrig: " + matrix[i][2]);
                anzahl += matrix[i][2];
            }
        }
        System.out.println("Die Anzahl der Kleidungstücke in dieser Größe: " + anzahl);
        return anzahl;
    }

    public void outArray2KleidungNurDaten(int[][] matrix) {
        int anzahl = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][2] != 0){
                System.out.println( matrix[i][0] + " " + matrix[i][1] + " " + matrix[i][2] + " " + matrix[i][3]);
                anzahl += matrix[i][2];
            }
        }
        System.out.println("Die Anzahl der Kleidungstücke dieser Sorte: " + anzahl);
    }
    public int outArray2KleidungNurDatenreturn(int[][] matrix) {
        int anzahl = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][2] != 0){
                anzahl += matrix[i][2];
            }
        }
        return anzahl;
    }

    public void outArray1int(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void outArray1String(String[] matrix){

        for (int i = 0; i < matrix.length; i++){
            if (matrix[i].length() < 1){
                System.out.print(i +": "+matrix[i]+" ");    
            } else{
                System.out.print(i +":"+matrix[i]+" ");
            }   
        }
        System.out.println();
    }

    public void outArray1boll(boolean[] matrix){

        for (int i = 0; i < matrix.length; i++){
            if (matrix[i]){
                System.out.print(i+1 +": "+matrix[i]+" ");    
            } else{
                System.out.print(i+1 +":"+matrix[i]+" ");
            }
        }
        System.out.println();
    }

} 